.class public Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;
.super Ljava/lang/Object;
.source "CCPreferenceDelegate.java"


# instance fields
.field private final context:Landroid/content/Context;

.field private final prefActivity:Landroid/preference/PreferenceActivity;

.field private final prefFrag:Landroid/preference/PreferenceFragment;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/preference/PreferenceActivity;Landroid/preference/PreferenceFragment;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "prefActivity"    # Landroid/preference/PreferenceActivity;
    .param p3, "preferenceFragment"    # Landroid/preference/PreferenceFragment;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->context:Landroid/content/Context;

    .line 23
    iput-object p2, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->prefActivity:Landroid/preference/PreferenceActivity;

    .line 24
    iput-object p3, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->prefFrag:Landroid/preference/PreferenceFragment;

    .line 26
    return-void
.end method


# virtual methods
.method protected findPreference(I)Landroid/preference/Preference;
    .locals 1
    .param p1, "keyResource"    # I

    .prologue
    .line 168
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->findPreference(Ljava/lang/String;)Landroid/preference/Preference;

    move-result-object v0

    return-object v0
.end method

.method protected findPreference(Ljava/lang/String;)Landroid/preference/Preference;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 175
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->prefActivity:Landroid/preference/PreferenceActivity;

    if-eqz v1, :cond_0

    .line 176
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->prefActivity:Landroid/preference/PreferenceActivity;

    invoke-virtual {v1, p1}, Landroid/preference/PreferenceActivity;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v0

    .line 180
    .local v0, "pref":Landroid/preference/Preference;
    :goto_0
    return-object v0

    .line 178
    .end local v0    # "pref":Landroid/preference/Preference;
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->prefFrag:Landroid/preference/PreferenceFragment;

    invoke-virtual {v1, p1}, Landroid/preference/PreferenceFragment;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v0

    .restart local v0    # "pref":Landroid/preference/Preference;
    goto :goto_0
.end method

.method public setupPreferences(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;Landroid/preference/PreferenceScreen;)V
    .locals 12
    .param p1, "ccPrefStore"    # Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;
    .param p2, "prefScreen"    # Landroid/preference/PreferenceScreen;

    .prologue
    .line 30
    sget v10, Lcom/comcast/cim/cmasl/android708compatlib/R$string;->settings_key_cc_preview:I

    invoke-virtual {p0, v10}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v6

    check-cast v6, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;

    .line 31
    .local v6, "preview":Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;
    invoke-virtual {v6, p1}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->setCcPrefStore(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;)V

    .line 33
    sget v10, Lcom/comcast/cim/cmasl/android708compatlib/R$string;->settings_key_cc_text_size:I

    invoke-virtual {p0, v10}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v8

    check-cast v8, Landroid/preference/ListPreference;

    .line 34
    .local v8, "textSizeListPreference":Landroid/preference/ListPreference;
    if-eqz v8, :cond_0

    .line 35
    invoke-interface {p1}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCTextSize()I

    move-result v10

    invoke-virtual {v8, v10}, Landroid/preference/ListPreference;->setValueIndex(I)V

    .line 36
    invoke-virtual {v8}, Landroid/preference/ListPreference;->getEntry()Ljava/lang/CharSequence;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/preference/ListPreference;->setSummary(Ljava/lang/CharSequence;)V

    .line 37
    new-instance v10, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$1;

    invoke-direct {v10, p0, p1, v6}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$1;-><init>(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;)V

    invoke-virtual {v8, v10}, Landroid/preference/ListPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 50
    :cond_0
    sget v10, Lcom/comcast/cim/cmasl/android708compatlib/R$string;->settings_key_cc_typeface:I

    invoke-virtual {p0, v10}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v9

    check-cast v9, Landroid/preference/ListPreference;

    .line 51
    .local v9, "typefaceListPreference":Landroid/preference/ListPreference;
    if-eqz v9, :cond_1

    .line 55
    invoke-interface {p1}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCFontFamily()I

    move-result v10

    invoke-static {v10}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/preference/ListPreference;->setValue(Ljava/lang/String;)V

    .line 56
    invoke-virtual {v9}, Landroid/preference/ListPreference;->getEntry()Ljava/lang/CharSequence;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/preference/ListPreference;->setSummary(Ljava/lang/CharSequence;)V

    .line 57
    new-instance v10, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$2;

    invoke-direct {v10, p0, p1, v6}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$2;-><init>(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;)V

    invoke-virtual {v9, v10}, Landroid/preference/ListPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 70
    :cond_1
    sget v10, Lcom/comcast/cim/cmasl/android708compatlib/R$string;->settings_key_cc_text_color:I

    invoke-virtual {p0, v10}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v7

    check-cast v7, Landroid/preference/ListPreference;

    .line 71
    .local v7, "textColorListPreference":Landroid/preference/ListPreference;
    if-eqz v7, :cond_2

    .line 72
    invoke-interface {p1}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCTextColor()I

    move-result v10

    invoke-virtual {v7, v10}, Landroid/preference/ListPreference;->setValueIndex(I)V

    .line 73
    invoke-virtual {v7}, Landroid/preference/ListPreference;->getEntry()Ljava/lang/CharSequence;

    move-result-object v10

    invoke-virtual {v7, v10}, Landroid/preference/ListPreference;->setSummary(Ljava/lang/CharSequence;)V

    .line 74
    new-instance v10, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$3;

    invoke-direct {v10, p0, p1, v6}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$3;-><init>(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;)V

    invoke-virtual {v7, v10}, Landroid/preference/ListPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 87
    :cond_2
    sget v10, Lcom/comcast/cim/cmasl/android708compatlib/R$string;->settings_key_cc_edge_type:I

    invoke-virtual {p0, v10}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v4

    check-cast v4, Landroid/preference/ListPreference;

    .line 88
    .local v4, "edgeTypeListPreference":Landroid/preference/ListPreference;
    if-eqz v4, :cond_3

    .line 89
    invoke-interface {p1}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCEdgeType()I

    move-result v10

    invoke-static {v10}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Landroid/preference/ListPreference;->setValue(Ljava/lang/String;)V

    .line 90
    invoke-virtual {v4}, Landroid/preference/ListPreference;->getEntry()Ljava/lang/CharSequence;

    move-result-object v10

    invoke-virtual {v4, v10}, Landroid/preference/ListPreference;->setSummary(Ljava/lang/CharSequence;)V

    .line 91
    new-instance v10, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$4;

    invoke-direct {v10, p0, p1, v6}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$4;-><init>(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;)V

    invoke-virtual {v4, v10}, Landroid/preference/ListPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 105
    :cond_3
    sget v10, Lcom/comcast/cim/cmasl/android708compatlib/R$string;->settings_key_cc_edge_color:I

    invoke-virtual {p0, v10}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v3

    check-cast v3, Landroid/preference/ListPreference;

    .line 106
    .local v3, "edgeColorListPreference":Landroid/preference/ListPreference;
    if-eqz v3, :cond_4

    .line 107
    invoke-interface {p1}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCEdgeColor()I

    move-result v10

    invoke-virtual {v3, v10}, Landroid/preference/ListPreference;->setValueIndex(I)V

    .line 108
    invoke-virtual {v3}, Landroid/preference/ListPreference;->getEntry()Ljava/lang/CharSequence;

    move-result-object v10

    invoke-virtual {v3, v10}, Landroid/preference/ListPreference;->setSummary(Ljava/lang/CharSequence;)V

    .line 109
    new-instance v10, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$5;

    invoke-direct {v10, p0, p1, v6}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$5;-><init>(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;)V

    invoke-virtual {v3, v10}, Landroid/preference/ListPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 122
    :cond_4
    sget v10, Lcom/comcast/cim/cmasl/android708compatlib/R$string;->settings_key_cc_background_color:I

    invoke-virtual {p0, v10}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v0

    check-cast v0, Landroid/preference/ListPreference;

    .line 123
    .local v0, "backgroundColorListPreference":Landroid/preference/ListPreference;
    if-eqz v0, :cond_5

    .line 124
    invoke-interface {p1}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCBackgroundColor()I

    move-result v10

    invoke-virtual {v0, v10}, Landroid/preference/ListPreference;->setValueIndex(I)V

    .line 125
    invoke-virtual {v0}, Landroid/preference/ListPreference;->getEntry()Ljava/lang/CharSequence;

    move-result-object v10

    invoke-virtual {v0, v10}, Landroid/preference/ListPreference;->setSummary(Ljava/lang/CharSequence;)V

    .line 126
    new-instance v10, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$6;

    invoke-direct {v10, p0, p1, v6}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$6;-><init>(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;)V

    invoke-virtual {v0, v10}, Landroid/preference/ListPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 139
    :cond_5
    sget v10, Lcom/comcast/cim/cmasl/android708compatlib/R$string;->settings_key_cc_background_opacity:I

    invoke-virtual {p0, v10}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v1

    check-cast v1, Landroid/preference/ListPreference;

    .line 140
    .local v1, "backgroundOpacityListPreference":Landroid/preference/ListPreference;
    if-eqz v1, :cond_6

    .line 141
    invoke-interface {p1}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCBackgroundOpacity()I

    move-result v10

    invoke-static {v10}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10}, Landroid/preference/ListPreference;->setValue(Ljava/lang/String;)V

    .line 145
    const-string v5, "%"

    .line 146
    .local v5, "percentSign":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Landroid/preference/ListPreference;->getEntry()Ljava/lang/CharSequence;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "%"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10}, Landroid/preference/ListPreference;->setSummary(Ljava/lang/CharSequence;)V

    .line 147
    new-instance v10, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$7;

    invoke-direct {v10, p0, p1, v6}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate$7;-><init>(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;)V

    invoke-virtual {v1, v10}, Landroid/preference/ListPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 161
    .end local v5    # "percentSign":Ljava/lang/String;
    :cond_6
    sget v10, Lcom/comcast/cim/cmasl/android708compatlib/R$string;->settings_key_cc_shortcut:I

    invoke-virtual {p0, v10}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v2

    .line 162
    .local v2, "ccShortcut":Landroid/preference/Preference;
    if-eqz v2, :cond_7

    sget v10, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v11, 0x13

    if-ge v10, v11, :cond_7

    .line 163
    invoke-virtual {p2, v2}, Landroid/preference/PreferenceScreen;->removePreference(Landroid/preference/Preference;)Z

    .line 165
    :cond_7
    return-void
.end method
