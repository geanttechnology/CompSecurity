.class public final Lcom/wishabi/flipp/app/eq;
.super Landroid/preference/PreferenceFragment;
.source "SourceFile"


# instance fields
.field a:Landroid/preference/Preference$OnPreferenceClickListener;

.field b:Landroid/preference/Preference$OnPreferenceChangeListener;

.field private c:Landroid/widget/Toast;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 60
    invoke-direct {p0}, Landroid/preference/PreferenceFragment;-><init>()V

    .line 63
    new-instance v0, Lcom/wishabi/flipp/app/er;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/er;-><init>(Lcom/wishabi/flipp/app/eq;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/eq;->a:Landroid/preference/Preference$OnPreferenceClickListener;

    .line 73
    new-instance v0, Lcom/wishabi/flipp/app/es;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/es;-><init>(Lcom/wishabi/flipp/app/eq;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/eq;->b:Landroid/preference/Preference$OnPreferenceChangeListener;

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/eq;Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 60
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/eq;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/wishabi/flipp/app/eq;->c:Landroid/widget/Toast;

    if-nez v1, :cond_0

    new-instance v1, Landroid/widget/Toast;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/eq;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/Toast;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/wishabi/flipp/app/eq;->c:Landroid/widget/Toast;

    iget-object v1, p0, Lcom/wishabi/flipp/app/eq;->c:Landroid/widget/Toast;

    const/16 v2, 0x50

    const/4 v3, 0x1

    const/high16 v4, 0x425c0000    # 55.0f

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    invoke-static {v3, v4, v5}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v3

    float-to-int v3, v3

    invoke-virtual {v1, v2, v6, v3}, Landroid/widget/Toast;->setGravity(III)V

    invoke-virtual {v0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f030031

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/wishabi/flipp/app/eq;->c:Landroid/widget/Toast;

    invoke-virtual {v1, v0}, Landroid/widget/Toast;->setView(Landroid/view/View;)V

    :cond_0
    if-nez p1, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/eq;->c:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->cancel()V

    :cond_1
    :goto_0
    return-void

    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/eq;->c:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0b00c2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/eq;->c:Landroid/widget/Toast;

    invoke-virtual {v0, v6}, Landroid/widget/Toast;->setDuration(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/eq;->c:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method


# virtual methods
.method public final onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 92
    invoke-super {p0, p1}, Landroid/preference/PreferenceFragment;->onCreate(Landroid/os/Bundle;)V

    .line 94
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/eq;->getPreferenceManager()Landroid/preference/PreferenceManager;

    move-result-object v0

    const-string v1, "com.wishabi.flipp.preferences"

    invoke-virtual {v0, v1}, Landroid/preference/PreferenceManager;->setSharedPreferencesName(Ljava/lang/String;)V

    .line 96
    const/high16 v0, 0x7f060000

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/eq;->addPreferencesFromResource(I)V

    .line 98
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/eq;->getPreferenceManager()Landroid/preference/PreferenceManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/preference/PreferenceManager;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 99
    const-string v1, "keep_search_history"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 101
    const-string v1, "keep_search_history"

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/eq;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v1

    .line 102
    iget-object v2, p0, Lcom/wishabi/flipp/app/eq;->b:Landroid/preference/Preference$OnPreferenceChangeListener;

    invoke-virtual {v1, v2}, Landroid/preference/Preference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 105
    const-string v1, "clear_search_history"

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/eq;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v1

    .line 106
    iget-object v2, p0, Lcom/wishabi/flipp/app/eq;->a:Landroid/preference/Preference$OnPreferenceClickListener;

    invoke-virtual {v1, v2}, Landroid/preference/Preference;->setOnPreferenceClickListener(Landroid/preference/Preference$OnPreferenceClickListener;)V

    .line 107
    invoke-virtual {v1, v0}, Landroid/preference/Preference;->setEnabled(Z)V

    .line 108
    return-void
.end method
