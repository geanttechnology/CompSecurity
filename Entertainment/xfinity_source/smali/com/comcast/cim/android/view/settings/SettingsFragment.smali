.class public Lcom/comcast/cim/android/view/settings/SettingsFragment;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;
.source "SettingsFragment.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 17
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;->onCreate(Landroid/os/Bundle;)V

    .line 19
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "resource"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "xml"

    .line 21
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v4

    .line 19
    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 23
    .local v0, "res":I
    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/view/settings/SettingsFragment;->addPreferencesFromResource(I)V

    .line 25
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 29
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v2

    .line 32
    .local v2, "returnView":Landroid/view/View;
    const v3, 0x102000a

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    .line 33
    .local v0, "listView":Landroid/widget/ListView;
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 34
    .local v1, "resources":Landroid/content/res/Resources;
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$string;->no_visible_footer_extra:I

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 35
    sget v3, Lcom/comcast/cim/android/R$color;->transparent:I

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/ListView;->setOverscrollFooter(Landroid/graphics/drawable/Drawable;)V

    .line 38
    :cond_0
    return-object v2
.end method
