package mage.client.dialog;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.*;
import mage.cards.decks.Deck;
import mage.cards.decks.DeckFileFilter;
import mage.cards.decks.importer.DeckImporter;
import mage.cards.repository.ExpansionInfo;
import mage.cards.repository.ExpansionRepository;
import mage.client.MageFrame;
import mage.client.SessionHandler;
import mage.client.table.TournamentPlayerPanel;
import mage.client.util.IgnoreList;
import mage.client.util.gui.FastSearchUtil;
import mage.constants.MatchTimeLimit;
import mage.constants.MultiplayerAttackOption;
import mage.constants.RangeOfInfluence;
import mage.constants.SkillLevel;
import mage.game.GameException;
import mage.game.draft.DraftOptions;
import mage.game.draft.DraftOptions.TimingOption;
import mage.game.mulligan.MulliganType;
import mage.game.tournament.LimitedOptions;
import mage.game.tournament.TournamentOptions;
import mage.players.PlayerType;
import mage.view.GameTypeView;
import mage.view.TableView;
import mage.view.TournamentTypeView;
import org.apache.log4j.Logger;

/**
 * App GUI: create new TOURNEY
 *
 * @author BetaSteward_at_googlemail.com, JayDi85
 */
public class NewTournamentDialog extends MageDialog {

    private static final Logger logger = Logger.getLogger(NewTournamentDialog.class);

    private TableView table;
    // private UUID playerId;
    private UUID roomId;
    private String lastSessionId;
    private RandomPacksSelectorDialog randomPackSelector;
    private JTextArea txtRandomPacks;
    private final java.util.List<TournamentPlayerPanel> players = new ArrayList<>();
    private final java.util.List<JPanel> packPanels = new ArrayList<>();
    private static final int CONSTRUCTION_TIME_MIN = 6;
    private static final int CONSTRUCTION_TIME_MAX = 30;
    private boolean isRandom = false;
    private boolean isRichMan = false;
    private boolean isRemixed = false;
    private String cubeFromDeckFilename = "";
    private String jumpstartPacksFilename = "";
    private boolean automaticChange = false;

    public NewTournamentDialog() {
        initComponents();
        lastSessionId = "";
        txtName.setText("Tournament");
        this.spnNumWins.setModel(new SpinnerNumberModel(2, 1, 5, 1));
        this.spnFreeMulligans.setModel(new SpinnerNumberModel(0, 0, 5, 1));
        this.cbMulligan.setModel(new DefaultComboBoxModel(MulliganType.values()));
        this.spnConstructTime.setModel(new SpinnerNumberModel(10, CONSTRUCTION_TIME_MIN, CONSTRUCTION_TIME_MAX, 2));
        this.spnNumRounds.setModel(new SpinnerNumberModel(2, 2, 10, 1));
        this.spnQuitRatio.setModel(new SpinnerNumberModel(100, 0, 100, 5));
        this.spnMinimumRating.setModel(new SpinnerNumberModel(0, 0, 3000, 10));
        fcSelectEmblemCardsPerPlayer = new JFileChooser();
        fcSelectEmblemCardsPerPlayer.setAcceptAllFileFilterUsed(false);
        fcSelectEmblemCardsPerPlayer.addChoosableFileFilter(new DeckFileFilter("dck", "XMage's deck files (*.dck)"));
        fcSelectEmblemCardsStartingPlayer = new JFileChooser();
        fcSelectEmblemCardsStartingPlayer.setAcceptAllFileFilterUsed(false);
        fcSelectEmblemCardsStartingPlayer.addChoosableFileFilter(new DeckFileFilter("dck", "XMage's deck files (*.dck)"));
    }

    public void showDialog(UUID roomId) {
        this.roomId = roomId;
        if (!lastSessionId.equals(SessionHandler.getSessionId())) {
            lastSessionId = SessionHandler.getSessionId();
            this.player1Panel.setPlayerName(SessionHandler.getUserName());
            this.player1Panel.showLevel(false); // no computer
            cbTournamentType.setModel(new DefaultComboBoxModel(SessionHandler.getTournamentTypes().toArray()));

            cbGameType.setModel(new DefaultComboBoxModel(SessionHandler.getTournamentGameTypes().toArray()));
            cbDeckType.setModel(new DefaultComboBoxModel(SessionHandler.getDeckTypes()));

            cbTimeLimit.setModel(new DefaultComboBoxModel(MatchTimeLimit.values()));
            cbSkillLevel.setModel(new DefaultComboBoxModel(SkillLevel.values()));
            cbDraftCube.setModel(new DefaultComboBoxModel(SessionHandler.getDraftCubes()));
            cbDraftTiming.setModel(new DefaultComboBoxModel(Arrays.stream(TimingOption.values())
                    .filter(o -> !o.equals(TimingOption.NONE))
                    .toArray())
            );
            // update player types
            int i = 2;
            for (TournamentPlayerPanel tournamentPlayerPanel : players) {
                tournamentPlayerPanel.init(i++);
            }
            cbAllowSpectators.setSelected(true);
            cbPlaneChase.setSelected(false);
            this.setModal(true);
            this.setLocation(150, 100);
        }

        onLoadSettings(0);

        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        popupSaveSettings = new javax.swing.JPopupMenu();
        menuSaveSettings1 = new javax.swing.JMenuItem();
        menuSaveSettings2 = new javax.swing.JMenuItem();
        popupLoadSettings = new javax.swing.JPopupMenu();
        menuLoadSettingsLast = new javax.swing.JMenuItem();
        separator1 = new javax.swing.JPopupMenu.Separator();
        menuLoadSettings1 = new javax.swing.JMenuItem();
        menuLoadSettings2 = new javax.swing.JMenuItem();
        separator2 = new javax.swing.JPopupMenu.Separator();
        menuLoadSettingsDefault = new javax.swing.JMenuItem();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lbTimeLimit = new javax.swing.JLabel();
        cbTimeLimit = new javax.swing.JComboBox();
        lbSkillLevel = new javax.swing.JLabel();
        cbSkillLevel = new javax.swing.JComboBox();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblTournamentType = new javax.swing.JLabel();
        cbTournamentType = new javax.swing.JComboBox();
        lbDeckType = new javax.swing.JLabel();
        cbDeckType = new javax.swing.JComboBox();
        lblGameType = new javax.swing.JLabel();
        cbGameType = new javax.swing.JComboBox();
        lblFreeMulligans = new javax.swing.JLabel();
        spnFreeMulligans = new javax.swing.JSpinner();
        lblNumWins = new javax.swing.JLabel();
        spnNumWins = new javax.swing.JSpinner();
        lblDraftCube = new javax.swing.JLabel();
        cbDraftCube = new javax.swing.JComboBox();
        lblNumRounds = new javax.swing.JLabel();
        spnNumRounds = new javax.swing.JSpinner();
        lblPacks = new javax.swing.JLabel();
        pnlPacks = new javax.swing.JPanel();
        lblNbrPlayers = new javax.swing.JLabel();
        lblNbrSeats = new javax.swing.JLabel();
        spnNumPlayers = new javax.swing.JSpinner();
        spnNumSeats = new javax.swing.JSpinner();
        pnlDraftOptions = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbDraftTiming = new javax.swing.JComboBox();
        cbAllowSpectators = new javax.swing.JCheckBox();
        cbPlaneChase = new javax.swing.JCheckBox();
        chkEmblemCards = new javax.swing.JCheckBox();
        lblEmblemCardsStartingPlayer = new javax.swing.JLabel();
        txtEmblemCardsStartingPlayer = new javax.swing.JTextField();
        btnEmblemCardsStartingPlayer = new javax.swing.JButton();
        lblEmblemCardsPerPlayer = new javax.swing.JLabel();
        txtEmblemCardsPerPlayer = new javax.swing.JTextField();
        btnEmblemCardsPerPlayer = new javax.swing.JButton();
        lblPlayer1 = new javax.swing.JLabel();
        lblConstructionTime = new javax.swing.JLabel();
        chkRollbackTurnsAllowed = new javax.swing.JCheckBox();
        spnConstructTime = new javax.swing.JSpinner();
        player1Panel = new mage.client.table.NewPlayerPanel();
        pnlPlayers = new javax.swing.JPanel();
        pnlOtherPlayers = new javax.swing.JPanel();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pnlRandomPacks = new javax.swing.JPanel();
        lblQuitRatio = new javax.swing.JLabel();
        spnQuitRatio = new javax.swing.JSpinner();
        lblMinimumRating = new javax.swing.JLabel();
        spnMinimumRating = new javax.swing.JSpinner();
        chkRated = new javax.swing.JCheckBox();
        lblMullgian = new javax.swing.JLabel();
        cbMulligan = new javax.swing.JComboBox<>();
        btnSettingsSave = new javax.swing.JButton();
        btnSettingsLoad = new javax.swing.JButton();
        lblSettings = new javax.swing.JLabel();

        menuSaveSettings1.setText("Save to config 1");
        menuSaveSettings1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveSettings1ActionPerformed(evt);
            }
        });
        popupSaveSettings.add(menuSaveSettings1);

        menuSaveSettings2.setText("Save to config 2");
        menuSaveSettings2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveSettings2ActionPerformed(evt);
            }
        });
        popupSaveSettings.add(menuSaveSettings2);

        menuLoadSettingsLast.setText("Load from last time");
        menuLoadSettingsLast.setToolTipText("");
        menuLoadSettingsLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadSettingsLastActionPerformed(evt);
            }
        });
        popupLoadSettings.add(menuLoadSettingsLast);
        popupLoadSettings.add(separator1);

        menuLoadSettings1.setText("Load from config 1");
        menuLoadSettings1.setToolTipText("");
        menuLoadSettings1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadSettings1ActionPerformed(evt);
            }
        });
        popupLoadSettings.add(menuLoadSettings1);

        menuLoadSettings2.setText("Load from config 2");
        menuLoadSettings2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadSettings2ActionPerformed(evt);
            }
        });
        popupLoadSettings.add(menuLoadSettings2);
        popupLoadSettings.add(separator2);

        menuLoadSettingsDefault.setText("Load default settings");
        menuLoadSettingsDefault.setToolTipText("");
        menuLoadSettingsDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadSettingsDefaultActionPerformed(evt);
            }
        });
        popupLoadSettings.add(menuLoadSettingsDefault);

        setTitle("New Tournament");

        lblName.setText("Name:");

        lbTimeLimit.setText("Time Limit:");
        lbTimeLimit.setToolTipText("The time a player has for the whole match. If a player runs out of time during a game, they lose the complete match. ");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cbTimeLimit, org.jdesktop.beansbinding.ObjectProperty.create(), lbTimeLimit, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        cbTimeLimit.setToolTipText("The time a player has for the whole match. If a player runs out of time during a game, they lose the complete match. ");

        lbSkillLevel.setText("Skill Level:");
        lbSkillLevel.setToolTipText("The time a player has for the whole match. If a player runs out of time during a game, they lose the complete match. ");

        cbSkillLevel.setToolTipText("<HTML>This option can be used to make it easier to find matches<br>\nwith opponents of the appropriate skill level.");

        lblPassword.setText("Password:");
        lblPassword.setToolTipText("Players have to enter the password to be able to join this table.");

        txtPassword.setToolTipText("Players have to enter the password to be able to join this table.");

        lblTournamentType.setText("Tournament Type:");

        cbTournamentType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTournamentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTournamentTypeActionPerformed(evt);
            }
        });

        lbDeckType.setText("Deck Type:");
        lbDeckType.setFocusable(false);

        lblGameType.setText("Game Type:");
        lblGameType.setFocusable(false);

        cbGameType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGameTypeActionPerformed(evt);
            }
        });

        lblFreeMulligans.setLabelFor(spnFreeMulligans);
        lblFreeMulligans.setText("Free Mulligans:");

        spnFreeMulligans.setToolTipText("Players can take this number of free mulligans (their hand size will not be reduced).");

        lblNumWins.setText("Wins:");

        spnNumWins.setToolTipText("To win a match a player has to win this number of games.");
        spnNumWins.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnNumWinsnumPlayersChanged(evt);
            }
        });

        lblDraftCube.setText("Draft Cube:");

        cbDraftCube.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDraftCube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDraftCubeActionPerformed(evt);
            }
        });

        lblNumRounds.setText("Number of Swiss Rounds:");
        lblNumRounds.setToolTipText("<html>The number of rounds the swiss tournament has in total.<br>\nThe tournaments ends after that number of rounds or<br> \nif there are less than two players left in the tournament.");

        spnNumRounds.setToolTipText("<html>The number of rounds the swiss tournament has in total.<br>\nThe tournaments ends after that number of rounds or<br> \nif there are less than two players left in the tournament.");
        spnNumRounds.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnNumRoundsnumPlayersChanged(evt);
            }
        });

        lblPacks.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPacks.setText("Packs");

        pnlPacks.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlPacks.setLayout(new java.awt.GridLayout(0, 1, 2, 0));

        lblNbrPlayers.setText("Players:");

        lblNbrSeats.setText("Seats:");

        spnNumPlayers.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnNumPlayersStateChanged(evt);
            }
        });

        spnNumSeats.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnNumSeatsStateChanged(evt);
            }
        });

        jLabel6.setText("Timing:");

        cbDraftTiming.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDraftTiming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDraftTimingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDraftOptionsLayout = new javax.swing.GroupLayout(pnlDraftOptions);
        pnlDraftOptions.setLayout(pnlDraftOptionsLayout);
        pnlDraftOptionsLayout.setHorizontalGroup(
            pnlDraftOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDraftOptionsLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDraftTiming, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlDraftOptionsLayout.setVerticalGroup(
            pnlDraftOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDraftOptionsLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(pnlDraftOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDraftTiming, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        cbAllowSpectators.setText("Allow spectators");
        cbAllowSpectators.setToolTipText("Allow other players to watch the games of this table.");

        cbPlaneChase.setText("PlaneChase");
        cbPlaneChase.setToolTipText("Use Plane Chase for the tournament.");

        chkEmblemCards.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chkEmblemCards.setText("Emblem Cards - ");
        chkEmblemCards.setToolTipText("If enabled, select cards to give players emblem copies of");
        chkEmblemCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEmblemCardsActionPerformed(evt);
            }
        });

        lblEmblemCardsStartingPlayer.setText("Starting Player File");
        lblEmblemCardsStartingPlayer.setToolTipText("An emblem of every card in this file is given to the starting player (useful for symmetric effects)");

        txtEmblemCardsStartingPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmblemCardsStartingPlayerActionPerformed(evt);
            }
        });

        btnEmblemCardsStartingPlayer.setText("...");
        btnEmblemCardsStartingPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmblemCardsStartingPlayerActionPerformed(evt);
            }
        });

        lblEmblemCardsPerPlayer.setText("Per-Player File");
        lblEmblemCardsPerPlayer.setToolTipText("An emblem of each card in this file is given to each player");

        txtEmblemCardsPerPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmblemCardsPerPlayerActionPerformed(evt);
            }
        });

        btnEmblemCardsPerPlayer.setText("...");
        btnEmblemCardsPerPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmblemCardsPerPlayerActionPerformed(evt);
            }
        });

        lblPlayer1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPlayer1.setText("Player 1 (You)");

        lblConstructionTime.setText("Construction Time (Minutes):");

        chkRollbackTurnsAllowed.setText("Rollbacks");
        chkRollbackTurnsAllowed.setToolTipText("<HTML>Allow to rollback to the start of previous turns<br> if all players agree. ");

        spnConstructTime.setToolTipText("The time players have to build their deck.");

        player1Panel.setPreferredSize(new java.awt.Dimension(400, 44));

        pnlOtherPlayers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlOtherPlayers.setLayout(new java.awt.GridLayout(0, 1, 2, 0));

        javax.swing.GroupLayout pnlPlayersLayout = new javax.swing.GroupLayout(pnlPlayers);
        pnlPlayers.setLayout(pnlPlayersLayout);
        pnlPlayersLayout.setHorizontalGroup(
            pnlPlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlOtherPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPlayersLayout.setVerticalGroup(
            pnlPlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlOtherPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnOk.setText("Create");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        pnlRandomPacks.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlRandomPacks.setToolTipText("");
        pnlRandomPacks.setLayout(new javax.swing.BoxLayout(pnlRandomPacks, javax.swing.BoxLayout.Y_AXIS));

        lblQuitRatio.setText("Allowed quit %");

        spnQuitRatio.setToolTipText("");

        lblMinimumRating.setText("Minimum rating:");
        lblMinimumRating.setToolTipText("Players with rating less than this value can't join this table");

        spnMinimumRating.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnMinimumRatingnumPlayersChanged(evt);
            }
        });

        chkRated.setText("Rated game");
        chkRated.setToolTipText("Indicates if matches will be rated");

        lblMullgian.setText("Mulligan type:");
        lblMullgian.setToolTipText("What style of mulligan?");

        cbMulligan.setToolTipText("Selections the type of mulligan for games.");

        btnSettingsSave.setText("Save...");
        btnSettingsSave.setToolTipText("Save settings");
        btnSettingsSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSettingsSaveMouseClicked(evt);
            }
        });

        btnSettingsLoad.setText("Load...");
        btnSettingsLoad.setToolTipText("Load settings");
        btnSettingsLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSettingsLoadMouseClicked(evt);
            }
        });

        lblSettings.setText("Settings");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPacks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNbrPlayers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnNumPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNbrSeats)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnNumSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblPacks)
                            .addComponent(lblPlayer1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(pnlDraftOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNumRounds))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblConstructionTime)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spnConstructTime, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkRollbackTurnsAllowed))
                            .addComponent(spnNumRounds, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSettings)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSettingsLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSettingsSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDraftCube)
                                    .addComponent(lblTournamentType)
                                    .addComponent(lbDeckType)
                                    .addComponent(lblGameType))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbDraftCube, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbDeckType, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbGameType, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTournamentType, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(chkRated)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMinimumRating)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnMinimumRating, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNumWins)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnNumWins, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMullgian)
                                    .addComponent(cbMulligan, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblFreeMulligans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spnFreeMulligans))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbPlaneChase))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblQuitRatio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spnQuitRatio))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lbSkillLevel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbSkillLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTimeLimit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTimeLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAllowSpectators)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(player1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRandomPacks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkEmblemCards)
                        .addGap(0, 0, 0)
                        .addComponent(lblEmblemCardsPerPlayer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmblemCardsPerPlayer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEmblemCardsPerPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmblemCardsStartingPlayer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmblemCardsStartingPlayer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEmblemCardsStartingPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName)
                    .addComponent(lbTimeLimit)
                    .addComponent(cbTimeLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAllowSpectators, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblQuitRatio)
                        .addComponent(spnQuitRatio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNumWins)
                        .addComponent(spnNumWins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkRated)
                        .addComponent(lblMinimumRating)
                        .addComponent(spnMinimumRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTournamentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTournamentType)
                    .addComponent(lbSkillLevel)
                    .addComponent(cbSkillLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDraftCube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDraftCube))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDeckType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDeckType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGameType)
                            .addComponent(cbGameType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMullgian)
                            .addComponent(lblFreeMulligans))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbMulligan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnFreeMulligans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPlaneChase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmblemCardsStartingPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmblemCardsStartingPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmblemCardsStartingPlayer)
                    .addComponent(txtEmblemCardsPerPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmblemCardsPerPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmblemCardsPerPlayer)
                    .addComponent(chkEmblemCards))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPacks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPacks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlRandomPacks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spnNumRounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNumRounds))
                            .addComponent(lblNbrPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnNumPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(pnlDraftOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblNbrSeats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnNumSeats))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnConstructTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblConstructionTime)
                        .addComponent(chkRollbackTurnsAllowed)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSettingsLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSettingsSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSettings))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTournamentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTournamentTypeActionPerformed
        prepareTourneyView((Integer) this.spnNumPlayers.getValue());

        jumpstartPacksFilename = "";
        if (cbTournamentType.getSelectedItem().toString().matches(".*Jumpstart.*Custom.*")) {
            jumpstartPacksFilename = playerLoadJumpstartPacks();
        }

    }//GEN-LAST:event_cbTournamentTypeActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        // get settings
        TournamentOptions tOptions = getTournamentOptions();

        // CHECKS
        TournamentTypeView tournamentType = (TournamentTypeView) cbTournamentType.getSelectedItem();
        if (tournamentType.isRandom() || tournamentType.isRichMan() || tournamentType.isRemixed()) {
            if (tOptions.getLimitedOptions().getSetCodes().size() < 1) {
                JOptionPane.showMessageDialog(
                        MageFrame.getDesktop(),
                        "Warning, you must select at least one set for the pool",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
        }
        if (tournamentType.isDraft() && tOptions.getLimitedOptions() instanceof DraftOptions) {
            DraftOptions draftOptions = (DraftOptions) tOptions.getLimitedOptions();
            if (draftOptions.getTiming() == TimingOption.NONE) {
                JOptionPane.showMessageDialog(MageFrame.getDesktop(), "Warning, you must select draft timing option", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // save last settings
        onSaveSettings(0, tOptions);

        // run
        table = SessionHandler.createTournamentTable(roomId, tOptions);
        if (table == null) {
            // message must be send by server!
            return;
        }

        // join AI
        for (TournamentPlayerPanel player : players) {
            if (player.getPlayerType().getSelectedItem() != PlayerType.HUMAN) {
                if (!player.joinTournamentTable(roomId, table.getTableId(), DeckImporter.importDeckFromFile(this.player1Panel.getDeckFile(), true))) {
                    // error message must be send by sever
                    SessionHandler.removeTable(roomId, table.getTableId());
                    table = null;
                    return;
                }
            }
        }

        // join itself
        if (SessionHandler.joinTournamentTable(
                roomId,
                table.getTableId(),
                this.player1Panel.getPlayerName(),
                PlayerType.HUMAN, 1,
                DeckImporter.importDeckFromFile(this.player1Panel.getDeckFile(), true),
                tOptions.getPassword())) {
            // all fine, can close create dialog (join dialog will be opened after feedback from server)
            this.hideDialog();
            return;
        }

        JOptionPane.showMessageDialog(MageFrame.getDesktop(), "Error joining tournament.", "Error", JOptionPane.ERROR_MESSAGE);
        SessionHandler.removeTable(roomId, table.getTableId());
        table = null;
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.table = null;
        // this.playerId = null;
        this.hideDialog();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void updateNumSeats() {
        // int numPlayers = (Integer) this.spnNumPlayers.getValue();
        int numSeats = (Integer) this.spnNumSeats.getValue();

        if (numSeats > 2) {
            TournamentTypeView tournamentType = (TournamentTypeView) cbTournamentType.getSelectedItem();
            if (numSeats >= tournamentType.getMinPlayers()) {
                createPlayers(numSeats - 1);
                spnNumPlayers.setValue(numSeats);
            } else {
                numSeats = tournamentType.getMinPlayers();
                createPlayers(numSeats - 1);
                spnNumPlayers.setValue(numSeats);
                spnNumSeats.setValue(numSeats);
            }
            spnNumWins.setValue(1);
        }
    }

    private void spnNumPlayersStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnNumPlayersStateChanged
        int numPlayers = (Integer) this.spnNumPlayers.getValue();
        createPlayers(numPlayers - 1);
        int numSeats = (Integer) this.spnNumSeats.getValue();
        if (numSeats > 2 && numPlayers != numSeats) {
            updateNumSeats();
        }
    }//GEN-LAST:event_spnNumPlayersStateChanged

    private void spnNumSeatsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnNumSeatsStateChanged
        int numSeats = (Integer) this.spnNumSeats.getValue();
        this.spnNumPlayers.setEnabled(numSeats <= 2);
        updateNumSeats();
    }//GEN-LAST:event_spnNumSeatsStateChanged

    private void spnNumWinsnumPlayersChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnNumWinsnumPlayersChanged
        int numSeats = (Integer) this.spnNumSeats.getValue();
        int numWins = (Integer) this.spnNumSeats.getValue();
        if (numSeats > 2) {
            spnNumWins.setValue(1);
        }
    }//GEN-LAST:event_spnNumWinsnumPlayersChanged

    private JFileChooser fcSelectDeck = null;

    protected String playerLoadDeck() {
        if (fcSelectDeck == null) {
            fcSelectDeck = new JFileChooser();
            fcSelectDeck.setAcceptAllFileFilterUsed(false);
            fcSelectDeck.addChoosableFileFilter(new DeckFileFilter("dck", "XMage's deck files (*.dck)"));
        }
        String lastFolder = MageFrame.getPreferences().get("lastDeckFolder", "");
        if (!lastFolder.isEmpty()) {
            fcSelectDeck.setCurrentDirectory(new File(lastFolder));
        }
        int ret = fcSelectDeck.showDialog(this, "Select Deck");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fcSelectDeck.getSelectedFile();
            return (file.getPath());
        }
        return "";
    }

    private JFileChooser fcJumpstartSelectDeck = null;

    protected String playerLoadJumpstartPacks() {
        if (fcJumpstartSelectDeck == null) {
            fcJumpstartSelectDeck = new JFileChooser();
            fcJumpstartSelectDeck.setAcceptAllFileFilterUsed(false);
            fcJumpstartSelectDeck.addChoosableFileFilter(new DeckFileFilter("txt", "Jumpstart Packs (*.txt)"));
        }
        String lastFolder = MageFrame.getPreferences().get("lastDeckFolder", "");
        if (!lastFolder.isEmpty()) {
            fcJumpstartSelectDeck.setCurrentDirectory(new File(lastFolder));
        }
        int ret = fcJumpstartSelectDeck.showDialog(this, "Select Jumpstart Packs file");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fcJumpstartSelectDeck.getSelectedFile();
            return (file.getPath());
        }
        return "";
    }

    private void cbDraftCubeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDraftCubeActionPerformed
        cubeFromDeckFilename = "";
        if (cbDraftCube.getSelectedItem().toString().equals("Cube From Deck")) {
            cubeFromDeckFilename = playerLoadDeck();
        }
    }//GEN-LAST:event_cbDraftCubeActionPerformed

    private void cbDraftTimingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDraftTimingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDraftTimingActionPerformed

    private void spnNumRoundsnumPlayersChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnNumRoundsnumPlayersChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_spnNumRoundsnumPlayersChanged

    private void cbGameTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGameTypeActionPerformed
        setGameOptions();
    }//GEN-LAST:event_cbGameTypeActionPerformed

    private void spnMinimumRatingnumPlayersChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnMinimumRatingnumPlayersChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_spnMinimumRatingnumPlayersChanged

    private void menuSaveSettings1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveSettings1ActionPerformed
        onSaveSettings(1);
    }//GEN-LAST:event_menuSaveSettings1ActionPerformed

    private void menuSaveSettings2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveSettings2ActionPerformed
        onSaveSettings(2);
    }//GEN-LAST:event_menuSaveSettings2ActionPerformed

    private void menuLoadSettingsLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoadSettingsLastActionPerformed
        onLoadSettings(0);
    }//GEN-LAST:event_menuLoadSettingsLastActionPerformed

    private void menuLoadSettings1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoadSettings1ActionPerformed
        onLoadSettings(1);
    }//GEN-LAST:event_menuLoadSettings1ActionPerformed

    private void menuLoadSettings2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoadSettings2ActionPerformed
        onLoadSettings(2);
    }//GEN-LAST:event_menuLoadSettings2ActionPerformed

    private void menuLoadSettingsDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoadSettingsDefaultActionPerformed
        onLoadSettings(-1);
    }//GEN-LAST:event_menuLoadSettingsDefaultActionPerformed

    private void btnSettingsSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSettingsSaveMouseClicked
        popupSaveSettings.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_btnSettingsSaveMouseClicked

    private void btnSettingsLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSettingsLoadMouseClicked
        popupLoadSettings.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_btnSettingsLoadMouseClicked

    private void chkEmblemCardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEmblemCardsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEmblemCardsActionPerformed
    private void txtEmblemCardsStartingPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmblemCardsPerPlayerActionPerformed
    }//GEN-LAST:event_txtEmblemCardsPerPlayerActionPerformed

    private void txtEmblemCardsPerPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmblemCardsStartingPlayerActionPerformed
    }//GEN-LAST:event_txtEmblemCardsStartingPlayerActionPerformed
    private void btnEmblemCardsStartingPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmblemCardsStartingPlayerActionPerformed
        loadEmblemCardFile(true);
    }//GEN-LAST:event_btnEmblemCardsStartingPlayerActionPerformed

    private void btnEmblemCardsPerPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmblemCardsPerPlayerActionPerformed
        loadEmblemCardFile(false);
    }//GEN-LAST:event_btnEmblemCardsPerPlayerActionPerformed

    private final JFileChooser fcSelectEmblemCardsPerPlayer;
    private final JFileChooser fcSelectEmblemCardsStartingPlayer;
    private void loadEmblemCardFile(boolean isStartingPlayer) {
        JFileChooser fileChooser = isStartingPlayer ? fcSelectEmblemCardsStartingPlayer : fcSelectEmblemCardsPerPlayer;
        JTextField textField = isStartingPlayer ? txtEmblemCardsStartingPlayer : txtEmblemCardsPerPlayer;
        String prefKey = isStartingPlayer ? "lastStartingPlayerEmblemCardsFolder" : "lastPerPlayerEmblemCardsFolder";

        String lastFolder = MageFrame.getPreferences().get(prefKey, "");
        if (!lastFolder.isEmpty()) {
            fileChooser.setCurrentDirectory(new File(lastFolder));
        }
        int ret = fileChooser.showDialog(this, "Select Emblem Cards");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            textField.setText(file.getPath());
            try {
                MageFrame.getPreferences().put(prefKey, file.getCanonicalPath());
            } catch (IOException ex) {
            }
        }
        fileChooser.setSelectedFile(null);
    }

    private void setGameOptions() {
        GameTypeView gameType = (GameTypeView) cbGameType.getSelectedItem();
//        int oldValue = (Integer) this.spnNumPlayers.getValue();
//        this.spnNumPlayers.setModel(new SpinnerNumberModel(gameType.getMinPlayers(), gameType.getMinPlayers(), gameType.getMaxPlayers(), 1));
//        this.spnNumPlayers.setEnabled(gameType.getMinPlayers() != gameType.getMaxPlayers());
//        if (oldValue >= gameType.getMinPlayers() && oldValue <= gameType.getMaxPlayers()){
//            this.spnNumPlayers.setBoostedValue(oldValue);
//        }
        // this.cbAttackOption.setEnabled(gameType.isUseAttackOption());
        // this.cbRange.setEnabled(gameType.isUseRange());
        createPlayers((Integer) spnNumPlayers.getValue() - 1);
    }

    private void prepareTourneyView(int numPlayers) {
        TournamentTypeView tournamentType = (TournamentTypeView) cbTournamentType.getSelectedItem();
        activatePanelElements(tournamentType);

        // players
        if (numPlayers < tournamentType.getMinPlayers() || numPlayers > tournamentType.getMaxPlayers()) {
            numPlayers = tournamentType.getMinPlayers();
            createPlayers(numPlayers - 1); // ?
        }
        this.spnNumPlayers.setModel(new SpinnerNumberModel(numPlayers, tournamentType.getMinPlayers(), tournamentType.getMaxPlayers(), 1));
        this.spnNumPlayers.setEnabled(tournamentType.getMinPlayers() != tournamentType.getMaxPlayers());
        createPlayers((Integer) spnNumPlayers.getValue() - 1);
        this.spnNumSeats.setModel(new SpinnerNumberModel(2, 2, tournamentType.getMaxPlayers(), 1));

        // packs
        preparePacksView(tournamentType);
    }

    private void preparePacksView(TournamentTypeView tournamentType) {
        if (tournamentType.isLimited()) {
            this.isRandom = tournamentType.isRandom();
            this.isRichMan = tournamentType.isRichMan();
            this.isRemixed = tournamentType.isRemixed();
            if (this.isRandom || this.isRichMan || this.isRemixed) {
                createRandomPacks();
            } else {
                createPacks(tournamentType.getNumBoosters());
            }
        }
    }

    private void setNumberOfSwissRoundsMin(int numPlayers) {
        // set the number of minimum swiss rounds related to the number of players
        int minRounds = (int) Math.ceil(Math.log(numPlayers + 1) / Math.log(2));
        int newValue = Math.max((Integer) spnNumRounds.getValue(), minRounds);
        this.spnNumRounds.setModel(new SpinnerNumberModel(newValue, 2, 10, 1));
        this.pack();
        this.revalidate();
        this.repaint();
    }

    /**
     * Sets elements of the panel to visible or not visible
     *
     * @param tournamentType
     */
    private void activatePanelElements(TournamentTypeView tournamentType) {
        this.pnlDraftOptions.setVisible(tournamentType.isDraft());
        this.lblNumRounds.setVisible(!tournamentType.isElimination());
        this.spnNumRounds.setVisible(!tournamentType.isElimination());

        this.lblConstructionTime.setVisible(tournamentType.isLimited());
        this.spnConstructTime.setVisible(tournamentType.isLimited());

        this.lbDeckType.setVisible(!tournamentType.isLimited());
        this.cbDeckType.setVisible(!tournamentType.isLimited());
        this.lblGameType.setVisible(!tournamentType.isLimited());
        this.cbGameType.setVisible(!tournamentType.isLimited());
        this.player1Panel.showDeckElements(!tournamentType.isLimited());

        if (tournamentType.isLimited()) {
            if (tournamentType.isCubeBooster()) {
                this.lblDraftCube.setVisible(true);
                this.cbDraftCube.setVisible(true);
                this.lblPacks.setVisible(false);
                this.pnlPacks.setVisible(false);
                this.pnlRandomPacks.setVisible(false);
            } else if (tournamentType.isRandom() || tournamentType.isRichMan() || tournamentType.isRemixed()) {
                this.lblDraftCube.setVisible(false);
                this.cbDraftCube.setVisible(false);
                this.lblPacks.setVisible(true);
                this.pnlRandomPacks.setVisible(true);
                this.pnlPacks.setVisible(false);
            } else {
                this.lblDraftCube.setVisible(false);
                this.cbDraftCube.setVisible(false);
                this.lblPacks.setVisible(true);
                this.pnlPacks.setVisible(true);
                this.pnlRandomPacks.setVisible(false);
            }
        } else {
            // construced
            this.lblDraftCube.setVisible(false);
            this.cbDraftCube.setVisible(false);
            this.pnlPacks.setVisible(false);
            this.pnlPacks.setVisible(false);
            this.pnlRandomPacks.setVisible(false);
        }
    }

    private String prepareVersionStr(int version, boolean saveMode) {
        // version: 0, 1, 2... to save/load
        // version: -1 to reset (load from empty record)
        switch (version) {
            case -1:
                return saveMode ? "" : "-1"; // can't save to -1 version
            case 1:
                return "1";
            case 2:
                return "2";
            default:
                return "";
        }
    }

    private void loadRandomPacks(int version) {
        String versionStr = prepareVersionStr(version, false);
        java.util.List<String> packList;
        String packNames;
        String randomPrefs = PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PACKS_RANDOM_DRAFT + versionStr, "");
        if (!randomPrefs.isEmpty()) {
            packList = new ArrayList<>(Arrays.asList(randomPrefs.split(";")));
            packNames = randomPrefs;
        } else {
            ExpansionInfo[] allExpansions = ExpansionRepository.instance.getWithBoostersSortedByReleaseDate();
            packList = Arrays.stream(allExpansions).map(ExpansionInfo::getCode).collect(Collectors.toCollection(ArrayList::new));
            packNames = Arrays.stream(allExpansions).map(ExpansionInfo::getCode).collect(Collectors.joining(";"));
        }
        randomPackSelector.setSelectedPacks(packList);
        txtRandomPacks.setText(packNames);
    }

    private void createRandomPacks() {
        if (pnlRandomPacks.getComponentCount() == 0) {
            if (randomPackSelector == null) {
                randomPackSelector = new RandomPacksSelectorDialog();
                randomPackSelector.setLocationRelativeTo(this);
            }
            txtRandomPacks = new JTextArea();
            txtRandomPacks.setEnabled(false);
            txtRandomPacks.setLineWrap(true);

            loadRandomPacks(-1); // load default packs

            txtRandomPacks.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlRandomPacks.add(txtRandomPacks);
            JButton btnSelectRandomPacks = new JButton();
            btnSelectRandomPacks.setAlignmentX(Component.LEFT_ALIGNMENT);
            btnSelectRandomPacks.setText("Select sets to be included in the pool");
            btnSelectRandomPacks.setToolTipText(RandomPacksSelectorDialog.randomDraftDescription);
            btnSelectRandomPacks.addActionListener(evt -> showRandomPackSelectorDialog());
            pnlRandomPacks.add(btnSelectRandomPacks);
            this.pnlRandomPacks.setMinimumSize(new Dimension(784, 150));
        }
        txtRandomPacks.setText(txtRandomPacks.getText()); // workaround to apply field's auto-size
        this.pack();
        this.revalidate();
        this.repaint();
    }

    private void showRandomPackSelectorDialog() {
        randomPackSelector.showDialog(isRandom, isRichMan, isRemixed);
        this.txtRandomPacks.setText(String.join(";", randomPackSelector.getSelectedPacks()));
        this.pack();
        this.revalidate();
        this.repaint();
    }

    private void createPacks(int numPacks) {
        while (packPanels.size() > numPacks) {
            pnlPacks.remove(packPanels.get(packPanels.size() - 1));
            packPanels.remove(packPanels.size() - 1);
        }
        while (packPanels.size() < numPacks) {
            // SELECT PACK
            // panel
            JPanel setPanel = new JPanel();
            setPanel.setLayout(new javax.swing.BoxLayout(setPanel, javax.swing.BoxLayout.LINE_AXIS));
            setPanel.setOpaque(false);
            //setPanel.setPreferredSize(new Dimension(200, 25));
            //setPanel.setMaximumSize(new Dimension(200, 25));
            pnlPacks.add(setPanel);
            packPanels.add(setPanel); // for later access
            // combo set
            JComboBox pack = new JComboBox();
            pack.setModel(new DefaultComboBoxModel(ExpansionRepository.instance.getWithBoostersSortedByReleaseDate()));
            pack.addActionListener(evt -> packActionPerformed(evt));
            pack.setAlignmentX(0.0F);
            pack.setMinimumSize(new Dimension(50, 25));
            pack.setPreferredSize(new Dimension(50, 25));
            pack.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
            setPanel.add(pack);
            // search button
            JButton searchButton = new JButton();
            searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/search_24.png")));
            searchButton.setToolTipText("Search and select from list");
            searchButton.setAlignmentX(1.0F);
            searchButton.setMinimumSize(new java.awt.Dimension(24, 24));
            searchButton.setPreferredSize(new java.awt.Dimension(32, 32));
            searchButton.setMaximumSize(new java.awt.Dimension(32, 32));
            searchButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                    // search combo box near button (must be only one combo in panel)
                    JButton button = (JButton) evt.getSource();
                    JComboBox combo = findComboInComponent(button.getParent());

                    if (combo != null) {
                        FastSearchUtil.showFastSearchForStringComboBox(combo, "Select value");
                    }
                }
            });
            setPanel.add(searchButton);
        }
        this.pack();
        this.revalidate();
        this.repaint();
    }

    private JComboBox findComboInComponent(Container panel) {
        // search combo box near button (must be only one combo in panel)
        JComboBox combo = null;
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JComboBox) {
                combo = (JComboBox) comp;
                break;
            }
        }
        return combo;
    }

    private void packActionPerformed(java.awt.event.ActionEvent evt) {
        // fill all bottom combobox with same value
        JComboBox curentCombo = (JComboBox) evt.getSource();
        int newValue = curentCombo.getSelectedIndex();

        // search start index
        int startIndex = 0;
        for (int i = 0; i < packPanels.size(); i++) {
            JComboBox pack = findComboInComponent(packPanels.get(i));
            if (pack != null && pack.equals(curentCombo)) {
                startIndex = i + 1;
                break;
            }
        }

        // change all from start index
        for (int i = startIndex; i < packPanels.size(); i++) {
            JComboBox pack = findComboInComponent(packPanels.get(i));
            if (pack != null) {
                pack.setSelectedIndex(newValue);
            }
        }
    }

    private void createPlayers(int numPlayers) {
        // add/remove player panels
        if (numPlayers > players.size()) {
            while (players.size() != numPlayers) {
                TournamentPlayerPanel playerPanel = new TournamentPlayerPanel();
                playerPanel.init(players.size() + 2);

                players.add(playerPanel);
            }
        } else if (numPlayers < players.size()) {
            while (players.size() != numPlayers) {
                players.remove(players.size() - 1);
            }
        }
        drawPlayers();

        setNumberOfSwissRoundsMin(numPlayers);

    }

    private void drawPlayers() {
        this.pnlOtherPlayers.removeAll();
        for (TournamentPlayerPanel panel : players) {
            this.pnlOtherPlayers.add(panel);
            panel.getPlayerType().addActionListener(evt -> {
                if (!automaticChange) {
                    playerActionPerformed(evt);
                }
            });
        }
        this.pack();
        this.revalidate();
        this.repaint();
    }

    private void playerActionPerformed(java.awt.event.ActionEvent evt) {
        boolean start = false;
        int selectedIndex = 0;
        automaticChange = true;
        for (TournamentPlayerPanel player : players) {
            if (!start) {
                if (evt.getSource().equals(player.getPlayerType())) {
                    start = true;
                    selectedIndex = player.getPlayerType().getSelectedIndex();
                }
            } else {
                player.getPlayerType().setSelectedIndex(selectedIndex);
            }
        }
        automaticChange = false;
    }

    private void loadBoosterPacks(String packString) {
        if (!packString.isEmpty()) {
            String[] packsArray = packString.substring(1, packString.length() - 1).split(",");
            int packNumber = 0;
            for (String pack : packsArray) {
                packNumber++;
                if (!packPanels.isEmpty() && this.packPanels.size() >= packNumber - 1) {
                    JPanel panel = packPanels.get(packNumber - 1);
                    JComboBox comboBox = findComboInComponent(panel);

                    if (comboBox != null) {
                        ComboBoxModel model = comboBox.getModel();
                        int size = model.getSize();
                        for (int i = 0; i < size; i++) {
                            ExpansionInfo element = (ExpansionInfo) model.getElementAt(i);
                            if (element.getCode().equals(pack.trim())) {
                                comboBox.setSelectedIndex(i);
                                break;
                            }
                        }
                    } else {
                        logger.error("Can't find combo component in " + panel.toString());
                    }
                }

            }
        }
    }

    private TournamentOptions getTournamentOptions() {
        TournamentTypeView tournamentType = (TournamentTypeView) cbTournamentType.getSelectedItem();
        int numSeats = (Integer) this.spnNumSeats.getValue();
        TournamentOptions tOptions = new TournamentOptions(this.txtName.getText(), "", numSeats);
        tOptions.setTournamentType(tournamentType.getName());
        tOptions.setPassword(txtPassword.getText());
        tOptions.getPlayerTypes().add(PlayerType.HUMAN);
        tOptions.setWatchingAllowed(cbAllowSpectators.isSelected());
        tOptions.setPlaneChase(cbPlaneChase.isSelected());
        tOptions.setQuitRatio((Integer) spnQuitRatio.getValue());
        tOptions.setMinimumRating((Integer) spnMinimumRating.getValue());
        for (TournamentPlayerPanel player : players) {
            tOptions.getPlayerTypes().add((PlayerType) player.getPlayerType().getSelectedItem());
        }
        if (!tournamentType.isElimination()) {
            tOptions.setNumberRounds((Integer) spnNumRounds.getValue());
        }
        if (tournamentType.isDraft()) {
            DraftOptions options = new DraftOptions();
            options.setTiming((TimingOption) this.cbDraftTiming.getSelectedItem());
            tOptions.setLimitedOptions(options);
        }
        if (tOptions.getLimitedOptions() == null) {
            tOptions.setLimitedOptions(new LimitedOptions());
        }
        if (tournamentType.isLimited()) {
            tOptions.getLimitedOptions().setConstructionTime((Integer) this.spnConstructTime.getValue() * 60);
            tOptions.getLimitedOptions().setIsRandom(tournamentType.isRandom());
            tOptions.getLimitedOptions().setIsRemixed(tournamentType.isRemixed());
            tOptions.getLimitedOptions().setIsRichMan(tournamentType.isRichMan());
            tOptions.getLimitedOptions().setIsJumpstart(tournamentType.isJumpstart());

            if (tournamentType.isJumpstart()) {
                if (!(jumpstartPacksFilename.isEmpty())) {
                    String jumpstartPacksData = "";
                    try {
                        jumpstartPacksData = new String(Files.readAllBytes(Paths.get(jumpstartPacksFilename)));
                        if (jumpstartPacksData.length() > 300000) {
                            JOptionPane.showMessageDialog(MageFrame.getDesktop(), "Chosen file too big", "Jumpstart Packs data is too long.  Please trim or choose another file.", JOptionPane.ERROR_MESSAGE);
                            jumpstartPacksData = "";
                        }
                    } catch (IOException e2) {
                        JOptionPane.showMessageDialog(MageFrame.getDesktop(), e2.getMessage(), "Error loading Jumpstart Packs data", JOptionPane.ERROR_MESSAGE);
                    }
                    tOptions.getLimitedOptions().setJumpstartPacks(jumpstartPacksData);
                }
            }
            if (tournamentType.isCubeBooster()) {
                tOptions.getLimitedOptions().setDraftCubeName(this.cbDraftCube.getSelectedItem().toString());
                if (!(cubeFromDeckFilename.isEmpty())) {
                    Deck cubeFromDeck = new Deck();
                    try {
                        cubeFromDeck = Deck.load(DeckImporter.importDeckFromFile(cubeFromDeckFilename, true), true, true);
                    } catch (GameException e1) {
                        JOptionPane.showMessageDialog(MageFrame.getDesktop(), e1.getMessage(), "Error loading deck", JOptionPane.ERROR_MESSAGE);
                    }
                    if (cubeFromDeck != null) {
                        cubeFromDeck.clearLayouts();
                        tOptions.getLimitedOptions().setCubeFromDeck(cubeFromDeck);
                    }
                }
            } else if (tournamentType.isRandom() || tournamentType.isRichMan()) {
                this.isRandom = tournamentType.isRandom();
                this.isRichMan = tournamentType.isRichMan();
                this.isRemixed = tournamentType.isRemixed();
                tOptions.getLimitedOptions().getSetCodes().clear();
                java.util.List<String> selected = randomPackSelector.getSelectedPacks();
                Collections.shuffle(selected);
                int maxPacks = 3 * (players.size() + 1);
                if (tournamentType.isRichMan()) {
                    maxPacks = 36;
                }
                if (selected.size() > maxPacks) {
                    StringBuilder infoString = new StringBuilder("More sets were selected than needed. ");
                    infoString.append(maxPacks);
                    infoString.append(" sets will be randomly chosen.");
                    JOptionPane.showMessageDialog(MageFrame.getDesktop(), infoString, "Information", JOptionPane.INFORMATION_MESSAGE);
                    tOptions.getLimitedOptions().getSetCodes().addAll(selected.subList(0, maxPacks));
                } else {
                    tOptions.getLimitedOptions().getSetCodes().addAll(selected);
                }
            } else if (tournamentType.isRemixed()) {
                this.isRandom = tournamentType.isRandom();
                this.isRichMan = tournamentType.isRichMan();
                this.isRemixed = tournamentType.isRemixed();
                tOptions.getLimitedOptions().getSetCodes().clear();
                tOptions.getLimitedOptions().getSetCodes().addAll(randomPackSelector.getSelectedPacks());
            } else {
                for (JPanel panel : packPanels) {
                    JComboBox combo = findComboInComponent(panel);
                    if (combo != null) {
                        tOptions.getLimitedOptions().getSetCodes().add(((ExpansionInfo) combo.getSelectedItem()).getCode());
                    } else {
                        logger.error("Can't find combo component in " + panel.toString());
                    }
                }
            }
            tOptions.getMatchOptions().setDeckType("Limited");
            tOptions.getMatchOptions().setGameType("Two Player Duel");
            tOptions.getMatchOptions().setLimited(true);
        } else {
            tOptions.getLimitedOptions().setConstructionTime(0);
            tOptions.getLimitedOptions().setNumberBoosters(0);
            tOptions.getLimitedOptions().setDraftCube(null);
            tOptions.getLimitedOptions().setDraftCubeName("");
            tOptions.getMatchOptions().setDeckType((String) this.cbDeckType.getSelectedItem());
            tOptions.getMatchOptions().setGameType(((GameTypeView) this.cbGameType.getSelectedItem()).getName());
            tOptions.getMatchOptions().setLimited(tOptions.getMatchOptions().getDeckType().startsWith("Limited"));
            if (tOptions.getMatchOptions().getDeckType().startsWith("Variant Magic - Freeform Unlimited Commander")) {
                tOptions.getMatchOptions().setLimited(true); // limited-style sideboarding with unlimited basics enabled for Freeform Unlimited Commander
            }
        }

        String serverAddress = SessionHandler.getSession().getServerHostname().orElse("");
        tOptions.getMatchOptions().setBannedUsers(IgnoreList.getIgnoredUsers(serverAddress));

        tOptions.getMatchOptions().setMatchTimeLimit((MatchTimeLimit) this.cbTimeLimit.getSelectedItem());
        tOptions.getMatchOptions().setSkillLevel((SkillLevel) this.cbSkillLevel.getSelectedItem());
        tOptions.getMatchOptions().setWinsNeeded((Integer) this.spnNumWins.getValue());
        tOptions.getMatchOptions().setFreeMulligans((Integer) this.spnFreeMulligans.getValue());
        tOptions.getMatchOptions().setMullgianType((MulliganType) this.cbMulligan.getSelectedItem());
        tOptions.getMatchOptions().setAttackOption(MultiplayerAttackOption.LEFT);
        tOptions.getMatchOptions().setRange(RangeOfInfluence.ALL);
        tOptions.getMatchOptions().setRollbackTurnsAllowed(this.chkRollbackTurnsAllowed.isSelected());
        tOptions.getMatchOptions().setRated(this.chkRated.isSelected());
        if (chkEmblemCards.isSelected()) {
            if (!txtEmblemCardsPerPlayer.getText().isEmpty()) {
                Deck perPlayerEmblemDeck = null;
                try {
                    perPlayerEmblemDeck = Deck.load(DeckImporter.importDeckFromFile(txtEmblemCardsPerPlayer.getText(), true), true, true);
                } catch (GameException e1) {
                    JOptionPane.showMessageDialog(MageFrame.getDesktop(), e1.getMessage(), "Error loading deck", JOptionPane.ERROR_MESSAGE);
                }
                if (perPlayerEmblemDeck != null) {
                    perPlayerEmblemDeck.clearLayouts();
                    // copy the cards set so deck can be garbage collected
                    tOptions.getMatchOptions().setPerPlayerEmblemCards(new HashSet<>(perPlayerEmblemDeck.getCards()));
                }
            }
            if (!txtEmblemCardsStartingPlayer.getText().isEmpty()) {
                Deck startingPlayerEmblemDeck = null;
                try {
                    startingPlayerEmblemDeck = Deck.load(DeckImporter.importDeckFromFile(txtEmblemCardsStartingPlayer.getText(), true), true, true);
                } catch (GameException e1) {
                    JOptionPane.showMessageDialog(MageFrame.getDesktop(), e1.getMessage(), "Error loading deck", JOptionPane.ERROR_MESSAGE);
                }
                if (startingPlayerEmblemDeck != null) {
                    startingPlayerEmblemDeck.clearLayouts();
                    // copy the cards set so deck can be garbage collected
                    tOptions.getMatchOptions().setGlobalEmblemCards(new HashSet<>(startingPlayerEmblemDeck.getCards()));
                }
            }
        }
        else {
            tOptions.getMatchOptions().setPerPlayerEmblemCards(Collections.emptySet());
            tOptions.getMatchOptions().setGlobalEmblemCards(Collections.emptySet());
        }

        return tOptions;
    }

    private void onLoadSettings(int version) {
        String versionStr = prepareVersionStr(version, false);
        int numPlayers;
        txtName.setText(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_NAME + versionStr, "Tournament"));
        txtPassword.setText(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PASSWORD + versionStr, ""));
        int timeLimit = Integer.parseInt(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_TIME_LIMIT + versionStr, "1500"));
        for (MatchTimeLimit mtl : MatchTimeLimit.values()) {
            if (mtl.getTimeLimit() == timeLimit) {
                this.cbTimeLimit.setSelectedItem(mtl);
                break;
            }
        }
        String skillLevelDefault = PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TABLE_SKILL_LEVEL + versionStr, "Casual");
        for (SkillLevel skillLevel : SkillLevel.values()) {
            if (skillLevel.toString().equals(skillLevelDefault)) {
                this.cbSkillLevel.setSelectedItem(skillLevel);
                break;
            }
        }
        int constructionTime = Integer.parseInt(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_CONSTR_TIME + versionStr, "600")) / 60;
        if (constructionTime < CONSTRUCTION_TIME_MIN || constructionTime > CONSTRUCTION_TIME_MAX) {
            constructionTime = CONSTRUCTION_TIME_MIN;
        }
        this.spnConstructTime.setValue(constructionTime);
        String tournamentTypeName = PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_TYPE + versionStr, "Sealed Elimination");
        for (TournamentTypeView tournamentTypeView : SessionHandler.getTournamentTypes()) {
            if (tournamentTypeView.getName().equals(tournamentTypeName)) {
                cbTournamentType.setSelectedItem(tournamentTypeView);
                break;
            }
        }
        this.spnFreeMulligans.setValue(Integer.parseInt(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_NUMBER_OF_FREE_MULLIGANS + versionStr, "0")));
        this.cbMulligan.setSelectedItem(MulliganType.valueByName(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_MULLIGUN_TYPE + versionStr, MulliganType.GAME_DEFAULT.toString())));
        this.spnNumWins.setValue(Integer.parseInt(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_NUMBER_OF_WINS + versionStr, "2")));
        this.spnQuitRatio.setValue(Integer.parseInt(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_QUIT_RATIO + versionStr, "100")));
        this.spnMinimumRating.setValue(Integer.parseInt(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_MINIMUM_RATING + versionStr, "0")));

        TournamentTypeView tournamentType = (TournamentTypeView) cbTournamentType.getSelectedItem();
        activatePanelElements(tournamentType);

        if (tournamentType.isLimited()) {
            if (tournamentType.isDraft()) {
                numPlayers = Integer.parseInt(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PLAYERS_DRAFT + versionStr, "4"));
                prepareTourneyView(numPlayers);

                if (tournamentType.isRandom() || tournamentType.isRichMan() || tournamentType.isRemixed()) {
                    loadRandomPacks(version);
                } else {
                    loadBoosterPacks(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PACKS_DRAFT + versionStr, ""));
                }

                String draftTiming = PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_DRAFT_TIMING + versionStr, "REGULAR");
                for (TimingOption timingOption : DraftOptions.TimingOption.values()) {
                    if (timingOption.toString().equals(draftTiming)) {
                        cbDraftTiming.setSelectedItem(draftTiming);
                        break;
                    }
                }
            } else {
                numPlayers = Integer.parseInt(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PLAYERS_SEALED + versionStr, "2"));
                prepareTourneyView(numPlayers);
                loadBoosterPacks(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PACKS_SEALED + versionStr, ""));
            }
        }
        this.cbAllowSpectators.setSelected(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_ALLOW_SPECTATORS + versionStr, "Yes").equals("Yes"));
        this.cbPlaneChase.setSelected(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PLANE_CHASE + versionStr, "No").equals("Yes"));
        this.chkRollbackTurnsAllowed.setSelected(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_ALLOW_ROLLBACKS + versionStr, "Yes").equals("Yes"));
        this.chkRated.setSelected(PreferencesDialog.getCachedValue(PreferencesDialog.KEY_NEW_TOURNAMENT_RATED + versionStr, "No").equals("Yes"));
    }

    private void onSaveSettings(int version) {
        TournamentOptions tOptions = getTournamentOptions();
        onSaveSettings(version, tOptions);
    }

    private void onSaveSettings(int version, TournamentOptions tOptions) {
        String versionStr = prepareVersionStr(version, true);
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_NAME + versionStr, tOptions.getName());
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PASSWORD + versionStr, tOptions.getPassword());
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_TIME_LIMIT + versionStr, Integer.toString(tOptions.getMatchOptions().getPriorityTime()));
        if (this.spnConstructTime.isVisible()) {
            PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_CONSTR_TIME + versionStr, Integer.toString(tOptions.getLimitedOptions().getConstructionTime()));
        }
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_TYPE + versionStr, tOptions.getTournamentType());
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_NUMBER_OF_FREE_MULLIGANS + versionStr, Integer.toString(tOptions.getMatchOptions().getFreeMulligans()));
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_MULLIGUN_TYPE + versionStr, tOptions.getMatchOptions().getMulliganType().toString());
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_NUMBER_OF_WINS + versionStr, Integer.toString(tOptions.getMatchOptions().getWinsNeeded()));
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_QUIT_RATIO + versionStr, Integer.toString(tOptions.getQuitRatio()));
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_MINIMUM_RATING + versionStr, Integer.toString(tOptions.getMinimumRating()));

        if (tOptions.getTournamentType().startsWith("Sealed")) {
            PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PACKS_SEALED + versionStr, tOptions.getLimitedOptions().getSetCodes().toString());
            PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PLAYERS_SEALED + versionStr, Integer.toString(tOptions.getPlayerTypes().size()));
        }

        if (tOptions.getTournamentType().startsWith("Booster")) {
            DraftOptions draftOptions = (DraftOptions) tOptions.getLimitedOptions();
            if (draftOptions != null) {
                PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PACKS_DRAFT + versionStr, draftOptions.getSetCodes().toString());
                PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PLAYERS_DRAFT + versionStr, Integer.toString(tOptions.getPlayerTypes().size()));
                PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_DRAFT_TIMING + versionStr, draftOptions.getTiming().name());
            }
            String deckFile = this.player1Panel.getDeckFile();
            if (deckFile != null && !deckFile.isEmpty()) {
                PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TABLE_DECK_FILE + versionStr, deckFile);
            }
            if (tOptions.getLimitedOptions().getIsRandom() || tOptions.getLimitedOptions().getIsRichMan() || tOptions.getLimitedOptions().getIsRemixed()) {
                PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PACKS_RANDOM_DRAFT + versionStr, String.join(";", this.randomPackSelector.getSelectedPacks()));
            }
        }
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_ALLOW_SPECTATORS + versionStr, (tOptions.isWatchingAllowed() ? "Yes" : "No"));
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_PLANE_CHASE + versionStr, (tOptions.isPlaneChase() ? "Yes" : "No"));
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_ALLOW_ROLLBACKS + versionStr, (tOptions.getMatchOptions().isRollbackTurnsAllowed() ? "Yes" : "No"));
        PreferencesDialog.saveValue(PreferencesDialog.KEY_NEW_TOURNAMENT_RATED + versionStr, (tOptions.getMatchOptions().isRated() ? "Yes" : "No"));
    }

    public TableView getTable() {
        return table;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEmblemCardsPerPlayer;
    private javax.swing.JButton btnEmblemCardsStartingPlayer;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSettingsLoad;
    private javax.swing.JButton btnSettingsSave;
    private javax.swing.JCheckBox cbAllowSpectators;
    private javax.swing.JComboBox cbDeckType;
    private javax.swing.JComboBox cbDraftCube;
    private javax.swing.JComboBox cbDraftTiming;
    private javax.swing.JComboBox cbGameType;
    private javax.swing.JComboBox<String> cbMulligan;
    private javax.swing.JCheckBox cbPlaneChase;
    private javax.swing.JComboBox cbSkillLevel;
    private javax.swing.JComboBox cbTimeLimit;
    private javax.swing.JComboBox cbTournamentType;
    private javax.swing.JCheckBox chkEmblemCards;
    private javax.swing.JCheckBox chkRated;
    private javax.swing.JCheckBox chkRollbackTurnsAllowed;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbDeckType;
    private javax.swing.JLabel lbSkillLevel;
    private javax.swing.JLabel lbTimeLimit;
    private javax.swing.JLabel lblConstructionTime;
    private javax.swing.JLabel lblDraftCube;
    private javax.swing.JLabel lblEmblemCardsPerPlayer;
    private javax.swing.JLabel lblEmblemCardsStartingPlayer;
    private javax.swing.JLabel lblFreeMulligans;
    private javax.swing.JLabel lblGameType;
    private javax.swing.JLabel lblMinimumRating;
    private javax.swing.JLabel lblMullgian;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNbrPlayers;
    private javax.swing.JLabel lblNbrSeats;
    private javax.swing.JLabel lblNumRounds;
    private javax.swing.JLabel lblNumWins;
    private javax.swing.JLabel lblPacks;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblQuitRatio;
    private javax.swing.JLabel lblSettings;
    private javax.swing.JLabel lblTournamentType;
    private javax.swing.JMenuItem menuLoadSettings1;
    private javax.swing.JMenuItem menuLoadSettings2;
    private javax.swing.JMenuItem menuLoadSettingsDefault;
    private javax.swing.JMenuItem menuLoadSettingsLast;
    private javax.swing.JMenuItem menuSaveSettings1;
    private javax.swing.JMenuItem menuSaveSettings2;
    private mage.client.table.NewPlayerPanel player1Panel;
    private javax.swing.JPanel pnlDraftOptions;
    private javax.swing.JPanel pnlOtherPlayers;
    private javax.swing.JPanel pnlPacks;
    private javax.swing.JPanel pnlPlayers;
    private javax.swing.JPanel pnlRandomPacks;
    private javax.swing.JPopupMenu popupLoadSettings;
    private javax.swing.JPopupMenu popupSaveSettings;
    private javax.swing.JPopupMenu.Separator separator1;
    private javax.swing.JPopupMenu.Separator separator2;
    private javax.swing.JSpinner spnConstructTime;
    private javax.swing.JSpinner spnFreeMulligans;
    private javax.swing.JSpinner spnMinimumRating;
    private javax.swing.JSpinner spnNumPlayers;
    private javax.swing.JSpinner spnNumRounds;
    private javax.swing.JSpinner spnNumSeats;
    private javax.swing.JSpinner spnNumWins;
    private javax.swing.JSpinner spnQuitRatio;
    private javax.swing.JTextField txtEmblemCardsPerPlayer;
    private javax.swing.JTextField txtEmblemCardsStartingPlayer;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
