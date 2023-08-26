package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 * @author TheElk801
 */
public final class WildsOfEldraine extends ExpansionSet {

    private static final WildsOfEldraine instance = new WildsOfEldraine();

    public static WildsOfEldraine getInstance() {
        return instance;
    }

    private WildsOfEldraine() {
        super("Wilds of Eldraine", "WOE", ExpansionSet.buildDate(2023, 9, 8), SetType.EXPANSION);
        this.blockName = "Wilds of Eldraine";
        this.hasBoosters = false; // temporary

        cards.add(new SetCardInfo("A Tale for the Ages", 34, Rarity.RARE, mage.cards.a.ATaleForTheAges.class));
        cards.add(new SetCardInfo("Agatha of the Vile Cauldron", 199, Rarity.MYTHIC, mage.cards.a.AgathaOfTheVileCauldron.class));
        cards.add(new SetCardInfo("Agatha's Champion", 160, Rarity.UNCOMMON, mage.cards.a.AgathasChampion.class));
        cards.add(new SetCardInfo("Agatha's Soul Cauldron", 242, Rarity.MYTHIC, mage.cards.a.AgathasSoulCauldron.class));
        cards.add(new SetCardInfo("Archive Dragon", 41, Rarity.UNCOMMON, mage.cards.a.ArchiveDragon.class));
        cards.add(new SetCardInfo("Archon of the Wild Rose", 1, Rarity.RARE, mage.cards.a.ArchonOfTheWildRose.class));
        cards.add(new SetCardInfo("Archon's Glory", 2, Rarity.COMMON, mage.cards.a.ArchonsGlory.class));
        cards.add(new SetCardInfo("Armory Mice", 3, Rarity.COMMON, mage.cards.a.ArmoryMice.class));
        cards.add(new SetCardInfo("Ash, Party Crasher", 201, Rarity.UNCOMMON, mage.cards.a.AshPartyCrasher.class));
        cards.add(new SetCardInfo("Ashiok's Reaper", 79, Rarity.UNCOMMON, mage.cards.a.AshioksReaper.class));
        cards.add(new SetCardInfo("Asinine Antics", 42, Rarity.MYTHIC, mage.cards.a.AsinineAntics.class));
        cards.add(new SetCardInfo("Back for Seconds", 80, Rarity.UNCOMMON, mage.cards.b.BackForSeconds.class));
        cards.add(new SetCardInfo("Barrow Naughty", 81, Rarity.COMMON, mage.cards.b.BarrowNaughty.class));
        cards.add(new SetCardInfo("Beanstalk Wurm", 161, Rarity.COMMON, mage.cards.b.BeanstalkWurm.class));
        cards.add(new SetCardInfo("Become Brutes", 317, Rarity.UNCOMMON, mage.cards.b.BecomeBrutes.class));
        cards.add(new SetCardInfo("Belligerent of the Ball", 120, Rarity.UNCOMMON, mage.cards.b.BelligerentOfTheBall.class));
        cards.add(new SetCardInfo("Bellowing Bruiser", 121, Rarity.COMMON, mage.cards.b.BellowingBruiser.class));
        cards.add(new SetCardInfo("Beluna Grandsquall", 220, Rarity.MYTHIC, mage.cards.b.BelunaGrandsquall.class));
        cards.add(new SetCardInfo("Beluna's Gatekeeper", 43, Rarity.COMMON, mage.cards.b.BelunasGatekeeper.class));
        cards.add(new SetCardInfo("Beseech the Mirror", 82, Rarity.MYTHIC, mage.cards.b.BeseechTheMirror.class));
        cards.add(new SetCardInfo("Besotted Knight", 4, Rarity.COMMON, mage.cards.b.BesottedKnight.class));
        cards.add(new SetCardInfo("Bespoke Battlegarb", 122, Rarity.COMMON, mage.cards.b.BespokeBattlegarb.class));
        cards.add(new SetCardInfo("Bestial Bloodline", 162, Rarity.COMMON, mage.cards.b.BestialBloodline.class));
        cards.add(new SetCardInfo("Bitter Chill", 44, Rarity.UNCOMMON, mage.cards.b.BitterChill.class));
        cards.add(new SetCardInfo("Blossoming Tortoise", 163, Rarity.MYTHIC, mage.cards.b.BlossomingTortoise.class));
        cards.add(new SetCardInfo("Boundary Lands Ranger", 123, Rarity.UNCOMMON, mage.cards.b.BoundaryLandsRanger.class));
        cards.add(new SetCardInfo("Bramble Familiar", 164, Rarity.RARE, mage.cards.b.BrambleFamiliar.class));
        cards.add(new SetCardInfo("Brave the Wilds", 165, Rarity.COMMON, mage.cards.b.BraveTheWilds.class));
        cards.add(new SetCardInfo("Break the Spell", 5, Rarity.COMMON, mage.cards.b.BreakTheSpell.class));
        cards.add(new SetCardInfo("Callous Sell-Sword", 221, Rarity.UNCOMMON, mage.cards.c.CallousSellSword.class));
        cards.add(new SetCardInfo("Candy Grapple", 83, Rarity.COMMON, mage.cards.c.CandyGrapple.class));
        cards.add(new SetCardInfo("Candy Trail", 243, Rarity.COMMON, mage.cards.c.CandyTrail.class));
        cards.add(new SetCardInfo("Chancellor of Tales", 45, Rarity.UNCOMMON, mage.cards.c.ChancellorOfTales.class));
        cards.add(new SetCardInfo("Charging Hooligan", 318, Rarity.UNCOMMON, mage.cards.c.ChargingHooligan.class));
        cards.add(new SetCardInfo("Charmed Clothier", 6, Rarity.COMMON, mage.cards.c.CharmedClothier.class));
        cards.add(new SetCardInfo("Charming Scoundrel", 124, Rarity.RARE, mage.cards.c.CharmingScoundrel.class));
        cards.add(new SetCardInfo("Cheeky House-Mouse", 7, Rarity.UNCOMMON, mage.cards.c.CheekyHouseMouse.class));
        cards.add(new SetCardInfo("Collector's Vault", 244, Rarity.UNCOMMON, mage.cards.c.CollectorsVault.class));
        cards.add(new SetCardInfo("Commune with Nature", 166, Rarity.COMMON, mage.cards.c.CommuneWithNature.class));
        cards.add(new SetCardInfo("Conceited Witch", 84, Rarity.COMMON, mage.cards.c.ConceitedWitch.class));
        cards.add(new SetCardInfo("Cooped Up", 8, Rarity.COMMON, mage.cards.c.CoopedUp.class));
        cards.add(new SetCardInfo("Cruel Somnophage", 222, Rarity.RARE, mage.cards.c.CruelSomnophage.class));
        cards.add(new SetCardInfo("Crystal Grotto", 254, Rarity.COMMON, mage.cards.c.CrystalGrotto.class));
        cards.add(new SetCardInfo("Cursed Courtier", 9, Rarity.UNCOMMON, mage.cards.c.CursedCourtier.class));
        cards.add(new SetCardInfo("Cut In", 125, Rarity.COMMON, mage.cards.c.CutIn.class));
        cards.add(new SetCardInfo("Decadent Dragon", 223, Rarity.RARE, mage.cards.d.DecadentDragon.class));
        cards.add(new SetCardInfo("Devouring Sugarmaw", 224, Rarity.RARE, mage.cards.d.DevouringSugarmaw.class));
        cards.add(new SetCardInfo("Diminisher Witch", 46, Rarity.COMMON, mage.cards.d.DiminisherWitch.class));
        cards.add(new SetCardInfo("Discerning Financier", 10, Rarity.UNCOMMON, mage.cards.d.DiscerningFinancier.class));
        cards.add(new SetCardInfo("Disdainful Stroke", 47, Rarity.UNCOMMON, mage.cards.d.DisdainfulStroke.class));
        cards.add(new SetCardInfo("Dream Spoilers", 85, Rarity.UNCOMMON, mage.cards.d.DreamSpoilers.class));
        cards.add(new SetCardInfo("Dutiful Griffin", 11, Rarity.UNCOMMON, mage.cards.d.DutifulGriffin.class));
        cards.add(new SetCardInfo("Edgewall Inn", 255, Rarity.UNCOMMON, mage.cards.e.EdgewallInn.class));
        cards.add(new SetCardInfo("Edgewall Pack", 126, Rarity.COMMON, mage.cards.e.EdgewallPack.class));
        cards.add(new SetCardInfo("Eerie Interference", 12, Rarity.UNCOMMON, mage.cards.e.EerieInterference.class));
        cards.add(new SetCardInfo("Ego Drain", 86, Rarity.UNCOMMON, mage.cards.e.EgoDrain.class));
        cards.add(new SetCardInfo("Elvish Archivist", 168, Rarity.RARE, mage.cards.e.ElvishArchivist.class));
        cards.add(new SetCardInfo("Embereth Veteran", 127, Rarity.UNCOMMON, mage.cards.e.EmberethVeteran.class));
        cards.add(new SetCardInfo("Eriette of the Charmed Apple", 202, Rarity.MYTHIC, mage.cards.e.ErietteOfTheCharmedApple.class));
        cards.add(new SetCardInfo("Eriette's Tempting Apple", 245, Rarity.UNCOMMON, mage.cards.e.EriettesTemptingApple.class));
        cards.add(new SetCardInfo("Eriette's Whisper", 88, Rarity.COMMON, mage.cards.e.EriettesWhisper.class));
        cards.add(new SetCardInfo("Evolving Wilds", 256, Rarity.COMMON, mage.cards.e.EvolvingWilds.class));
        cards.add(new SetCardInfo("Expel the Interlopers", 13, Rarity.RARE, mage.cards.e.ExpelTheInterlopers.class));
        cards.add(new SetCardInfo("Experimental Confectioner", 314, Rarity.UNCOMMON, mage.cards.e.ExperimentalConfectioner.class));
        cards.add(new SetCardInfo("Faerie Dreamthief", 89, Rarity.UNCOMMON, mage.cards.f.FaerieDreamthief.class));
        cards.add(new SetCardInfo("Faerie Fencing", 90, Rarity.UNCOMMON, mage.cards.f.FaerieFencing.class));
        cards.add(new SetCardInfo("Farsight Ritual", 49, Rarity.RARE, mage.cards.f.FarsightRitual.class));
        cards.add(new SetCardInfo("Faunsbane Troll", 203, Rarity.RARE, mage.cards.f.FaunsbaneTroll.class));
        cards.add(new SetCardInfo("Feed the Cauldron", 91, Rarity.COMMON, mage.cards.f.FeedTheCauldron.class));
        cards.add(new SetCardInfo("Fell Horseman", 92, Rarity.COMMON, mage.cards.f.FellHorseman.class));
        cards.add(new SetCardInfo("Ferocious Werefox", 170, Rarity.COMMON, mage.cards.f.FerociousWerefox.class));
        cards.add(new SetCardInfo("Flick a Coin", 128, Rarity.COMMON, mage.cards.f.FlickACoin.class));
        cards.add(new SetCardInfo("Food Coma", 308, Rarity.UNCOMMON, mage.cards.f.FoodComa.class));
        cards.add(new SetCardInfo("Food Fight", 346, Rarity.RARE, mage.cards.f.FoodFight.class));
        cards.add(new SetCardInfo("Forest", 266, Rarity.LAND, mage.cards.basiclands.Forest.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Frantic Firebolt", 130, Rarity.COMMON, mage.cards.f.FranticFirebolt.class));
        cards.add(new SetCardInfo("Freeze in Place", 50, Rarity.COMMON, mage.cards.f.FreezeInPlace.class));
        cards.add(new SetCardInfo("Frolicking Familiar", 226, Rarity.UNCOMMON, mage.cards.f.FrolickingFamiliar.class));
        cards.add(new SetCardInfo("Frostbridge Guard", 14, Rarity.COMMON, mage.cards.f.FrostbridgeGuard.class));
        cards.add(new SetCardInfo("Gadwick's First Duel", 51, Rarity.UNCOMMON, mage.cards.g.GadwicksFirstDuel.class));
        cards.add(new SetCardInfo("Gallant Pie-Wielder", 15, Rarity.UNCOMMON, mage.cards.g.GallantPieWielder.class));
        cards.add(new SetCardInfo("Galvanic Giant", 52, Rarity.UNCOMMON, mage.cards.g.GalvanicGiant.class));
        cards.add(new SetCardInfo("Gingerbread Hunter", 227, Rarity.UNCOMMON, mage.cards.g.GingerbreadHunter.class));
        cards.add(new SetCardInfo("Gingerbrute", 246, Rarity.COMMON, mage.cards.g.Gingerbrute.class));
        cards.add(new SetCardInfo("Glass Casket", 16, Rarity.UNCOMMON, mage.cards.g.GlassCasket.class));
        cards.add(new SetCardInfo("Gnawing Crescendo", 131, Rarity.COMMON, mage.cards.g.GnawingCrescendo.class));
        cards.add(new SetCardInfo("Goddric, Cloaked Reveler", 132, Rarity.RARE, mage.cards.g.GoddricCloakedReveler.class));
        cards.add(new SetCardInfo("Grabby Giant", 133, Rarity.COMMON, mage.cards.g.GrabbyGiant.class));
        cards.add(new SetCardInfo("Graceful Takedown", 171, Rarity.UNCOMMON, mage.cards.g.GracefulTakedown.class));
        cards.add(new SetCardInfo("Grand Ball Guest", 134, Rarity.COMMON, mage.cards.g.GrandBallGuest.class));
        cards.add(new SetCardInfo("Greta, Sweettooth Scourge", 205, Rarity.UNCOMMON, mage.cards.g.GretaSweettoothScourge.class));
        cards.add(new SetCardInfo("Gruff Triplets", 172, Rarity.RARE, mage.cards.g.GruffTriplets.class));
        cards.add(new SetCardInfo("Gumdrop Poisoner", 93, Rarity.RARE, mage.cards.g.GumdropPoisoner.class));
        cards.add(new SetCardInfo("Hamlet Glutton", 173, Rarity.COMMON, mage.cards.h.HamletGlutton.class));
        cards.add(new SetCardInfo("Harried Spearguard", 135, Rarity.COMMON, mage.cards.h.HarriedSpearguard.class));
        cards.add(new SetCardInfo("Heartflame Duelist", 228, Rarity.RARE, mage.cards.h.HeartflameDuelist.class));
        cards.add(new SetCardInfo("Hearth Elemental", 136, Rarity.UNCOMMON, mage.cards.h.HearthElemental.class));
        cards.add(new SetCardInfo("High Fae Negotiator", 94, Rarity.UNCOMMON, mage.cards.h.HighFaeNegotiator.class));
        cards.add(new SetCardInfo("Hollow Scavenger", 174, Rarity.COMMON, mage.cards.h.HollowScavenger.class));
        cards.add(new SetCardInfo("Hopeful Vigil", 17, Rarity.COMMON, mage.cards.h.HopefulVigil.class));
        cards.add(new SetCardInfo("Hopeless Nightmare", 95, Rarity.COMMON, mage.cards.h.HopelessNightmare.class));
        cards.add(new SetCardInfo("Horned Loch-Whale", 53, Rarity.RARE, mage.cards.h.HornedLochWhale.class));
        cards.add(new SetCardInfo("Howling Galefang", 175, Rarity.UNCOMMON, mage.cards.h.HowlingGalefang.class));
        cards.add(new SetCardInfo("Hylda of the Icy Crown", 206, Rarity.MYTHIC, mage.cards.h.HyldaOfTheIcyCrown.class));
        cards.add(new SetCardInfo("Hylda's Crown of Winter", 247, Rarity.RARE, mage.cards.h.HyldasCrownOfWinter.class));
        cards.add(new SetCardInfo("Ice Out", 54, Rarity.COMMON, mage.cards.i.IceOut.class));
        cards.add(new SetCardInfo("Icewrought Sentry", 55, Rarity.UNCOMMON, mage.cards.i.IcewroughtSentry.class));
        cards.add(new SetCardInfo("Imodane's Recruiter", 229, Rarity.UNCOMMON, mage.cards.i.ImodanesRecruiter.class));
        cards.add(new SetCardInfo("Imodane, the Pyrohammer", 137, Rarity.RARE, mage.cards.i.ImodaneThePyrohammer.class));
        cards.add(new SetCardInfo("Ingenious Prodigy", 56, Rarity.RARE, mage.cards.i.IngeniousProdigy.class));
        cards.add(new SetCardInfo("Into the Fae Court", 57, Rarity.COMMON, mage.cards.i.IntoTheFaeCourt.class));
        cards.add(new SetCardInfo("Intrepid Trufflesnout", 320, Rarity.UNCOMMON, mage.cards.i.IntrepidTrufflesnout.class));
        cards.add(new SetCardInfo("Island", 263, Rarity.LAND, mage.cards.basiclands.Island.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Johann's Stopgap", 58, Rarity.COMMON, mage.cards.j.JohannsStopgap.class));
        cards.add(new SetCardInfo("Johann, Apprentice Sorcerer", 207, Rarity.UNCOMMON, mage.cards.j.JohannApprenticeSorcerer.class));
        cards.add(new SetCardInfo("Kellan's Lightblades", 18, Rarity.COMMON, mage.cards.k.KellansLightblades.class));
        cards.add(new SetCardInfo("Kellan, the Fae-Blooded", 230, Rarity.MYTHIC, mage.cards.k.KellanTheFaeBlooded.class));
        cards.add(new SetCardInfo("Kindled Heroism", 138, Rarity.COMMON, mage.cards.k.KindledHeroism.class));
        cards.add(new SetCardInfo("Knight of Doves", 19, Rarity.UNCOMMON, mage.cards.k.KnightOfDoves.class));
        cards.add(new SetCardInfo("Korvold and the Noble Thief", 139, Rarity.UNCOMMON, mage.cards.k.KorvoldAndTheNobleThief.class));
        cards.add(new SetCardInfo("Lady of Laughter", 309, Rarity.RARE, mage.cards.l.LadyOfLaughter.class));
        cards.add(new SetCardInfo("Leaping Ambush", 177, Rarity.COMMON, mage.cards.l.LeapingAmbush.class));
        cards.add(new SetCardInfo("Lich-Knights' Conquest", 96, Rarity.RARE, mage.cards.l.LichKnightsConquest.class));
        cards.add(new SetCardInfo("Likeness Looter", 208, Rarity.RARE, mage.cards.l.LikenessLooter.class));
        cards.add(new SetCardInfo("Living Lectern", 59, Rarity.COMMON, mage.cards.l.LivingLectern.class));
        cards.add(new SetCardInfo("Lord Skitter's Blessing", 98, Rarity.RARE, mage.cards.l.LordSkittersBlessing.class));
        cards.add(new SetCardInfo("Lord Skitter's Butcher", 99, Rarity.UNCOMMON, mage.cards.l.LordSkittersButcher.class));
        cards.add(new SetCardInfo("Lord Skitter, Sewer King", 97, Rarity.RARE, mage.cards.l.LordSkitterSewerKing.class));
        cards.add(new SetCardInfo("Malevolent Witchkite", 315, Rarity.RARE, mage.cards.m.MalevolentWitchkite.class));
        cards.add(new SetCardInfo("Merfolk Coralsmith", 60, Rarity.COMMON, mage.cards.m.MerfolkCoralsmith.class));
        cards.add(new SetCardInfo("Merry Bards", 140, Rarity.COMMON, mage.cards.m.MerryBards.class));
        cards.add(new SetCardInfo("Minecart Daredevil", 141, Rarity.COMMON, mage.cards.m.MinecartDaredevil.class));
        cards.add(new SetCardInfo("Mintstrosity", 100, Rarity.COMMON, mage.cards.m.Mintstrosity.class));
        cards.add(new SetCardInfo("Misleading Motes", 61, Rarity.COMMON, mage.cards.m.MisleadingMotes.class));
        cards.add(new SetCardInfo("Mocking Sprite", 62, Rarity.COMMON, mage.cards.m.MockingSprite.class));
        cards.add(new SetCardInfo("Moment of Valor", 20, Rarity.COMMON, mage.cards.m.MomentOfValor.class));
        cards.add(new SetCardInfo("Monstrous Rage", 142, Rarity.UNCOMMON, mage.cards.m.MonstrousRage.class));
        cards.add(new SetCardInfo("Moonshaker Cavalry", 21, Rarity.MYTHIC, mage.cards.m.MoonshakerCavalry.class));
        cards.add(new SetCardInfo("Mountain", 265, Rarity.LAND, mage.cards.basiclands.Mountain.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Neva, Stalked by Nightmares", 209, Rarity.UNCOMMON, mage.cards.n.NevaStalkedByNightmares.class));
        cards.add(new SetCardInfo("Night of the Sweets' Revenge", 178, Rarity.UNCOMMON, mage.cards.n.NightOfTheSweetsRevenge.class));
        cards.add(new SetCardInfo("Not Dead After All", 101, Rarity.COMMON, mage.cards.n.NotDeadAfterAll.class));
        cards.add(new SetCardInfo("Obyra's Attendants", 63, Rarity.COMMON, mage.cards.o.ObyrasAttendants.class));
        cards.add(new SetCardInfo("Obyra, Dreaming Duelist", 210, Rarity.UNCOMMON, mage.cards.o.ObyraDreamingDuelist.class));
        cards.add(new SetCardInfo("Ogre Chitterlord", 319, Rarity.RARE, mage.cards.o.OgreChitterlord.class));
        cards.add(new SetCardInfo("Old Flitterfang", 316, Rarity.UNCOMMON, mage.cards.o.OldFlitterfang.class));
        cards.add(new SetCardInfo("Pests of Honor", 310, Rarity.UNCOMMON, mage.cards.p.PestsOfHonor.class));
        cards.add(new SetCardInfo("Picklock Prankster", 64, Rarity.UNCOMMON, mage.cards.p.PicklockPrankster.class));
        cards.add(new SetCardInfo("Picnic Ruiner", 232, Rarity.UNCOMMON, mage.cards.p.PicnicRuiner.class));
        cards.add(new SetCardInfo("Plains", 262, Rarity.LAND, mage.cards.basiclands.Plains.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Plunge into Winter", 22, Rarity.COMMON, mage.cards.p.PlungeIntoWinter.class));
        cards.add(new SetCardInfo("Pollen-Shield Hare", 233, Rarity.RARE, mage.cards.p.PollenShieldHare.class));
        cards.add(new SetCardInfo("Prophetic Prism", 249, Rarity.COMMON, mage.cards.p.PropheticPrism.class));
        cards.add(new SetCardInfo("Protective Parents", 24, Rarity.COMMON, mage.cards.p.ProtectiveParents.class));
        cards.add(new SetCardInfo("Provisions Merchant", 321, Rarity.UNCOMMON, mage.cards.p.ProvisionsMerchant.class));
        cards.add(new SetCardInfo("Questing Druid", 234, Rarity.RARE, mage.cards.q.QuestingDruid.class));
        cards.add(new SetCardInfo("Quick Study", 65, Rarity.COMMON, mage.cards.q.QuickStudy.class));
        cards.add(new SetCardInfo("Raging Battle Mouse", 143, Rarity.RARE, mage.cards.r.RagingBattleMouse.class));
        cards.add(new SetCardInfo("Rankle's Prank", 102, Rarity.RARE, mage.cards.r.RanklesPrank.class));
        cards.add(new SetCardInfo("Rat Out", 103, Rarity.COMMON, mage.cards.r.RatOut.class));
        cards.add(new SetCardInfo("Ratcatcher Trainee", 144, Rarity.COMMON, mage.cards.r.RatcatcherTrainee.class));
        cards.add(new SetCardInfo("Realm-Scorcher Hellkite", 145, Rarity.MYTHIC, mage.cards.r.RealmScorcherHellkite.class));
        cards.add(new SetCardInfo("Redcap Gutter-Dweller", 146, Rarity.RARE, mage.cards.r.RedcapGutterDweller.class));
        cards.add(new SetCardInfo("Redcap Thief", 147, Rarity.COMMON, mage.cards.r.RedcapThief.class));
        cards.add(new SetCardInfo("Redtooth Genealogist", 179, Rarity.COMMON, mage.cards.r.RedtoothGenealogist.class));
        cards.add(new SetCardInfo("Redtooth Vanguard", 180, Rarity.UNCOMMON, mage.cards.r.RedtoothVanguard.class));
        cards.add(new SetCardInfo("Regal Bunnicorn", 25, Rarity.RARE, mage.cards.r.RegalBunnicorn.class));
        cards.add(new SetCardInfo("Restless Bivouac", 257, Rarity.RARE, mage.cards.r.RestlessBivouac.class));
        cards.add(new SetCardInfo("Restless Cottage", 258, Rarity.RARE, mage.cards.r.RestlessCottage.class));
        cards.add(new SetCardInfo("Restless Fortress", 259, Rarity.RARE, mage.cards.r.RestlessFortress.class));
        cards.add(new SetCardInfo("Restless Spire", 260, Rarity.RARE, mage.cards.r.RestlessSpire.class));
        cards.add(new SetCardInfo("Restless Vinestalk", 261, Rarity.RARE, mage.cards.r.RestlessVinestalk.class));
        cards.add(new SetCardInfo("Return Triumphant", 26, Rarity.COMMON, mage.cards.r.ReturnTriumphant.class));
        cards.add(new SetCardInfo("Return from the Wilds", 181, Rarity.COMMON, mage.cards.r.ReturnFromTheWilds.class));
        cards.add(new SetCardInfo("Rimefur Reindeer", 27, Rarity.COMMON, mage.cards.r.RimefurReindeer.class));
        cards.add(new SetCardInfo("Rootrider Faun", 182, Rarity.COMMON, mage.cards.r.RootriderFaun.class));
        cards.add(new SetCardInfo("Rotisserie Elemental", 148, Rarity.RARE, mage.cards.r.RotisserieElemental.class));
        cards.add(new SetCardInfo("Rowan's Grim Search", 104, Rarity.COMMON, mage.cards.r.RowansGrimSearch.class));
        cards.add(new SetCardInfo("Rowan, Scion of War", 211, Rarity.MYTHIC, mage.cards.r.RowanScionOfWar.class));
        cards.add(new SetCardInfo("Rowdy Research", 312, Rarity.UNCOMMON, mage.cards.r.RowdyResearch.class));
        cards.add(new SetCardInfo("Royal Treatment", 183, Rarity.UNCOMMON, mage.cards.r.RoyalTreatment.class));
        cards.add(new SetCardInfo("Ruby, Daring Tracker", 212, Rarity.UNCOMMON, mage.cards.r.RubyDaringTracker.class));
        cards.add(new SetCardInfo("Savior of the Sleeping", 28, Rarity.COMMON, mage.cards.s.SaviorOfTheSleeping.class));
        cards.add(new SetCardInfo("Scalding Viper", 235, Rarity.RARE, mage.cards.s.ScaldingViper.class));
        cards.add(new SetCardInfo("Scarecrow Guide", 250, Rarity.COMMON, mage.cards.s.ScarecrowGuide.class));
        cards.add(new SetCardInfo("Scream Puff", 105, Rarity.COMMON, mage.cards.s.ScreamPuff.class));
        cards.add(new SetCardInfo("Sentinel of Lost Lore", 184, Rarity.RARE, mage.cards.s.SentinelOfLostLore.class));
        cards.add(new SetCardInfo("Sharae of Numbing Depths", 213, Rarity.UNCOMMON, mage.cards.s.SharaeOfNumbingDepths.class));
        cards.add(new SetCardInfo("Shatter the Oath", 106, Rarity.COMMON, mage.cards.s.ShatterTheOath.class));
        cards.add(new SetCardInfo("Shrouded Shepherd", 236, Rarity.UNCOMMON, mage.cards.s.ShroudedShepherd.class));
        cards.add(new SetCardInfo("Skewer Slinger", 149, Rarity.COMMON, mage.cards.s.SkewerSlinger.class));
        cards.add(new SetCardInfo("Skybeast Tracker", 185, Rarity.COMMON, mage.cards.s.SkybeastTracker.class));
        cards.add(new SetCardInfo("Sleep-Cursed Faerie", 66, Rarity.RARE, mage.cards.s.SleepCursedFaerie.class));
        cards.add(new SetCardInfo("Sleight of Hand", 67, Rarity.COMMON, mage.cards.s.SleightOfHand.class));
        cards.add(new SetCardInfo("Slumbering Keepguard", 29, Rarity.COMMON, mage.cards.s.SlumberingKeepguard.class));
        cards.add(new SetCardInfo("Snaremaster Sprite", 68, Rarity.COMMON, mage.cards.s.SnaremasterSprite.class));
        cards.add(new SetCardInfo("Solitary Sanctuary", 30, Rarity.UNCOMMON, mage.cards.s.SolitarySanctuary.class));
        cards.add(new SetCardInfo("Song of Totentanz", 150, Rarity.RARE, mage.cards.s.SongOfTotentanz.class));
        cards.add(new SetCardInfo("Soul-Guide Lantern", 251, Rarity.UNCOMMON, mage.cards.s.SoulGuideLantern.class));
        cards.add(new SetCardInfo("Specter of Mortality", 107, Rarity.RARE, mage.cards.s.SpecterOfMortality.class));
        cards.add(new SetCardInfo("Spell Stutter", 69, Rarity.COMMON, mage.cards.s.SpellStutter.class));
        cards.add(new SetCardInfo("Spellbook Vendor", 31, Rarity.RARE, mage.cards.s.SpellbookVendor.class));
        cards.add(new SetCardInfo("Spellscorn Coven", 237, Rarity.UNCOMMON, mage.cards.s.SpellscornCoven.class));
        cards.add(new SetCardInfo("Spider Food", 186, Rarity.COMMON, mage.cards.s.SpiderFood.class));
        cards.add(new SetCardInfo("Spiteful Hexmage", 108, Rarity.RARE, mage.cards.s.SpitefulHexmage.class));
        cards.add(new SetCardInfo("Splashy Spellcaster", 70, Rarity.UNCOMMON, mage.cards.s.SplashySpellcaster.class));
        cards.add(new SetCardInfo("Stingblade Assassin", 109, Rarity.COMMON, mage.cards.s.StingbladeAssassin.class));
        cards.add(new SetCardInfo("Stockpiling Celebrant", 32, Rarity.COMMON, mage.cards.s.StockpilingCelebrant.class));
        cards.add(new SetCardInfo("Stonesplitter Bolt", 151, Rarity.UNCOMMON, mage.cards.s.StonesplitterBolt.class));
        cards.add(new SetCardInfo("Stormkeld Prowler", 71, Rarity.COMMON, mage.cards.s.StormkeldProwler.class));
        cards.add(new SetCardInfo("Stormkeld Vanguard", 187, Rarity.UNCOMMON, mage.cards.s.StormkeldVanguard.class));
        cards.add(new SetCardInfo("Storyteller Pixie", 313, Rarity.UNCOMMON, mage.cards.s.StorytellerPixie.class));
        cards.add(new SetCardInfo("Stroke of Midnight", 33, Rarity.UNCOMMON, mage.cards.s.StrokeOfMidnight.class));
        cards.add(new SetCardInfo("Succumb to the Cold", 72, Rarity.UNCOMMON, mage.cards.s.SuccumbToTheCold.class));
        cards.add(new SetCardInfo("Sugar Rush", 110, Rarity.COMMON, mage.cards.s.SugarRush.class));
        cards.add(new SetCardInfo("Swamp", 264, Rarity.LAND, mage.cards.basiclands.Swamp.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sweettooth Witch", 111, Rarity.COMMON, mage.cards.s.SweettoothWitch.class));
        cards.add(new SetCardInfo("Syr Armont, the Redeemer", 214, Rarity.UNCOMMON, mage.cards.s.SyrArmontTheRedeemer.class));
        cards.add(new SetCardInfo("Syr Ginger, the Meal Ender", 252, Rarity.RARE, mage.cards.s.SyrGingerTheMealEnder.class));
        cards.add(new SetCardInfo("Taken by Nightmares", 112, Rarity.UNCOMMON, mage.cards.t.TakenByNightmares.class));
        cards.add(new SetCardInfo("Talion's Messenger", 73, Rarity.RARE, mage.cards.t.TalionsMessenger.class));
        cards.add(new SetCardInfo("Talion, the Kindly Lord", 215, Rarity.MYTHIC, mage.cards.t.TalionTheKindlyLord.class));
        cards.add(new SetCardInfo("Tangled Colony", 113, Rarity.RARE, mage.cards.t.TangledColony.class));
        cards.add(new SetCardInfo("Tanglespan Lookout", 188, Rarity.UNCOMMON, mage.cards.t.TanglespanLookout.class));
        cards.add(new SetCardInfo("Tattered Ratter", 152, Rarity.UNCOMMON, mage.cards.t.TatteredRatter.class));
        cards.add(new SetCardInfo("Tempest Hart", 238, Rarity.UNCOMMON, mage.cards.t.TempestHart.class));
        cards.add(new SetCardInfo("Tenacious Tomeseeker", 74, Rarity.UNCOMMON, mage.cards.t.TenaciousTomeseeker.class));
        cards.add(new SetCardInfo("The Apprentice's Folly", 200, Rarity.RARE, mage.cards.t.TheApprenticesFolly.class));
        cards.add(new SetCardInfo("The End", 87, Rarity.RARE, mage.cards.t.TheEnd.class));
        cards.add(new SetCardInfo("The Goose Mother", 204, Rarity.RARE, mage.cards.t.TheGooseMother.class));
        cards.add(new SetCardInfo("The Huntsman's Redemption", 176, Rarity.RARE, mage.cards.t.TheHuntsmansRedemption.class));
        cards.add(new SetCardInfo("The Irencrag", 248, Rarity.RARE, mage.cards.t.TheIrencrag.class));
        cards.add(new SetCardInfo("The Princess Takes Flight", 23, Rarity.UNCOMMON, mage.cards.t.ThePrincessTakesFlight.class));
        cards.add(new SetCardInfo("The Witch's Vanity", 119, Rarity.UNCOMMON, mage.cards.t.TheWitchsVanity.class));
        cards.add(new SetCardInfo("Threadbind Clique", 239, Rarity.UNCOMMON, mage.cards.t.ThreadbindClique.class));
        cards.add(new SetCardInfo("Three Blind Mice", 35, Rarity.RARE, mage.cards.t.ThreeBlindMice.class));
        cards.add(new SetCardInfo("Three Bowls of Porridge", 253, Rarity.UNCOMMON, mage.cards.t.ThreeBowlsOfPorridge.class));
        cards.add(new SetCardInfo("Thunderous Debut", 190, Rarity.RARE, mage.cards.t.ThunderousDebut.class));
        cards.add(new SetCardInfo("Titanic Growth", 191, Rarity.COMMON, mage.cards.t.TitanicGrowth.class));
        cards.add(new SetCardInfo("Toadstool Admirer", 192, Rarity.COMMON, mage.cards.t.ToadstoolAdmirer.class));
        cards.add(new SetCardInfo("Torch the Tower", 153, Rarity.COMMON, mage.cards.t.TorchTheTower.class));
        cards.add(new SetCardInfo("Totentanz, Swarm Piper", 216, Rarity.UNCOMMON, mage.cards.t.TotentanzSwarmPiper.class));
        cards.add(new SetCardInfo("Tough Cookie", 193, Rarity.UNCOMMON, mage.cards.t.ToughCookie.class));
        cards.add(new SetCardInfo("Troublemaker Ouphe", 194, Rarity.COMMON, mage.cards.t.TroublemakerOuphe.class));
        cards.add(new SetCardInfo("Troyan, Gutsy Explorer", 217, Rarity.UNCOMMON, mage.cards.t.TroyanGutsyExplorer.class));
        cards.add(new SetCardInfo("Twining Twins", 240, Rarity.RARE, mage.cards.t.TwiningTwins.class));
        cards.add(new SetCardInfo("Tuinvale Guide", 36, Rarity.COMMON, mage.cards.t.TuinvaleGuide.class));
        cards.add(new SetCardInfo("Twisted Fealty", 154, Rarity.UNCOMMON, mage.cards.t.TwistedFealty.class));
        cards.add(new SetCardInfo("Twisted Sewer-Witch", 114, Rarity.UNCOMMON, mage.cards.t.TwistedSewerWitch.class));
        cards.add(new SetCardInfo("Two-Headed Hunter", 155, Rarity.UNCOMMON, mage.cards.t.TwoHeadedHunter.class));
        cards.add(new SetCardInfo("Unassuming Sage", 37, Rarity.COMMON, mage.cards.u.UnassumingSage.class));
        cards.add(new SetCardInfo("Unruly Catapult", 156, Rarity.COMMON, mage.cards.u.UnrulyCatapult.class));
        cards.add(new SetCardInfo("Up the Beanstalk", 195, Rarity.UNCOMMON, mage.cards.u.UpTheBeanstalk.class));
        cards.add(new SetCardInfo("Vantress Transmuter", 75, Rarity.COMMON, mage.cards.v.VantressTransmuter.class));
        cards.add(new SetCardInfo("Verdant Outrider", 196, Rarity.COMMON, mage.cards.v.VerdantOutrider.class));
        cards.add(new SetCardInfo("Virtue of Knowledge", 76, Rarity.MYTHIC, mage.cards.v.VirtueOfKnowledge.class));
        cards.add(new SetCardInfo("Virtue of Loyalty", 38, Rarity.MYTHIC, mage.cards.v.VirtueOfLoyalty.class));
        cards.add(new SetCardInfo("Virtue of Persistence", 115, Rarity.MYTHIC, mage.cards.v.VirtueOfPersistence.class));
        cards.add(new SetCardInfo("Voracious Vermin", 116, Rarity.COMMON, mage.cards.v.VoraciousVermin.class));
        cards.add(new SetCardInfo("Warehouse Tabby", 117, Rarity.COMMON, mage.cards.w.WarehouseTabby.class));
        cards.add(new SetCardInfo("Water Wings", 77, Rarity.COMMON, mage.cards.w.WaterWings.class));
        cards.add(new SetCardInfo("Welcome to Sweettooth", 198, Rarity.UNCOMMON, mage.cards.w.WelcomeToSweettooth.class));
        cards.add(new SetCardInfo("Werefox Bodyguard", 39, Rarity.RARE, mage.cards.w.WerefoxBodyguard.class));
        cards.add(new SetCardInfo("Wicked Visitor", 118, Rarity.COMMON, mage.cards.w.WickedVisitor.class));
        cards.add(new SetCardInfo("Wildwood Mentor", 322, Rarity.RARE, mage.cards.w.WildwoodMentor.class));
        cards.add(new SetCardInfo("Will, Scion of Peace", 218, Rarity.MYTHIC, mage.cards.w.WillScionOfPeace.class));
        cards.add(new SetCardInfo("Witch's Mark", 158, Rarity.COMMON, mage.cards.w.WitchsMark.class));
        cards.add(new SetCardInfo("Witchstalker Frenzy", 159, Rarity.UNCOMMON, mage.cards.w.WitchstalkerFrenzy.class));
        cards.add(new SetCardInfo("Woodland Acolyte", 241, Rarity.UNCOMMON, mage.cards.w.WoodlandAcolyte.class));
    }

//    @Override
//    public BoosterCollator createCollator() {
//        return new WildsOfEldraineCollator();
//    }
}
