/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.abilities.effects.common;

import java.util.UUID;
import mage.Constants.Outcome;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.Card;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.common.TargetCardInLibrary;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class SearchLibraryPutInPlayEffect extends OneShotEffect {

	private TargetCardInLibrary target;
	private boolean tapped;

	public SearchLibraryPutInPlayEffect(TargetCardInLibrary target) {
		this(target, false, Outcome.PutCardInPlay);
	}
	
	public SearchLibraryPutInPlayEffect(TargetCardInLibrary target, boolean tapped) {
		this(target, tapped, Outcome.PutCardInPlay);
	}

	public SearchLibraryPutInPlayEffect(TargetCardInLibrary target, boolean tapped, Outcome outcome) {
		super(outcome);
		this.target = target;
		this.tapped = tapped;
	}

	@Override
	public boolean apply(Game game) {
		Player player = game.getPlayer(this.source.getControllerId());
		player.searchLibrary(target, game);
		if (target.getTargets().size() > 0) {
			for (UUID cardId: target.getTargets()) {
				Card card = player.getLibrary().remove(cardId);
				if (card != null) {
					if (player.putOntoBattlefield(card, game)) {
						if (tapped) {
							Permanent permanent = game.getPermanent(card.getId());
							if (permanent != null)
								permanent.setTapped(true);
						}
					}
				}
			}
			player.shuffleLibrary(game);
		}
		return true;
	}

	@Override
	public String getText() {
		StringBuilder sb = new StringBuilder();
		sb.append("Search your library for ");
		if (target.getNumberOfTargets() == 0 && target.getMaxNumberOfTargets() > 0) {
			sb.append("up to ");
			sb.append(target.getMaxNumberOfTargets());
			sb.append(" ");
			sb.append(target.getTargetName());
			sb.append(", and put them onto the battlefield");
		}
		else {
			sb.append("a ");
			sb.append(target.getTargetName());
			sb.append(", and put it onto the battlefield");
		}
		sb.append(". Then shuffle your library");
		return sb.toString();
	}

	@Override
	public void setSource(Ability ability) {
		super.setSource(ability);
		target.setAbility(ability);
	}

}
