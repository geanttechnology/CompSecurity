.class public Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;
.source "SettingsFragmentActivity.java"


# instance fields
.field userManager:Lcom/comcast/cim/model/user/UserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/UserManager",
            "<+",
            "Lcom/comcast/cim/model/user/User;",
            "+",
            "Lcom/comcast/cim/model/user/service/UserSettings;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;-><init>()V

    .line 22
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getUserManager()Lcom/comcast/cim/model/user/UserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->userManager:Lcom/comcast/cim/model/user/UserManager;

    return-void
.end method

.method private getHeaderPairForResource(Ljava/lang/String;)Landroid/util/Pair;
    .locals 7
    .param p1, "resource"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Landroid/preference/PreferenceActivity$Header;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->getListAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 45
    .local v0, "adapter":Landroid/widget/ListAdapter;
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    .line 46
    .local v1, "count":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-le v1, v3, :cond_1

    .line 47
    invoke-interface {v0, v3}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/preference/PreferenceActivity$Header;

    .line 49
    .local v2, "header":Landroid/preference/PreferenceActivity$Header;
    iget-object v5, v2, Landroid/preference/PreferenceActivity$Header;->fragmentArguments:Landroid/os/Bundle;

    if-eqz v5, :cond_0

    .line 50
    iget-object v5, v2, Landroid/preference/PreferenceActivity$Header;->fragmentArguments:Landroid/os/Bundle;

    const-string v6, "resource"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 51
    .local v4, "resourceArg":Ljava/lang/String;
    if-eqz v4, :cond_0

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 52
    new-instance v5, Landroid/util/Pair;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-direct {v5, v2, v6}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 56
    .end local v2    # "header":Landroid/preference/PreferenceActivity$Header;
    .end local v4    # "resourceArg":Ljava/lang/String;
    :goto_1
    return-object v5

    .line 46
    .restart local v2    # "header":Landroid/preference/PreferenceActivity$Header;
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 56
    .end local v2    # "header":Landroid/preference/PreferenceActivity$Header;
    :cond_1
    const/4 v5, 0x0

    goto :goto_1
.end method


# virtual methods
.method public getUserManager()Lcom/comcast/cim/model/user/UserManager;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/user/UserManager",
            "<+",
            "Lcom/comcast/cim/model/user/User;",
            "+",
            "Lcom/comcast/cim/model/user/service/UserSettings;",
            ">;"
        }
    .end annotation

    .prologue
    .line 66
    iget-object v0, p0, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->userManager:Lcom/comcast/cim/model/user/UserManager;

    return-object v0
.end method

.method public onBuildHeaders(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/preference/PreferenceActivity$Header;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 61
    .local p1, "target":Ljava/util/List;, "Ljava/util/List<Landroid/preference/PreferenceActivity$Header;>;"
    sget v0, Lcom/comcast/cim/android/R$xml;->preference_headers:I

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->loadHeadersFromResource(ILjava/util/List;)V

    .line 62
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 27
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->onCreate(Landroid/os/Bundle;)V

    .line 32
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 33
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "resource"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 34
    .local v2, "resource":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 35
    invoke-direct {p0, v2}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->getHeaderPairForResource(Ljava/lang/String;)Landroid/util/Pair;

    move-result-object v0

    .line 37
    .local v0, "initialHeaderPair":Landroid/util/Pair;, "Landroid/util/Pair<Landroid/preference/PreferenceActivity$Header;Ljava/lang/Integer;>;"
    if-eqz v0, :cond_0

    .line 38
    iget-object v3, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v3, Landroid/preference/PreferenceActivity$Header;

    iget-object v4, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {p0, v3, v4}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->onHeaderClick(Landroid/preference/PreferenceActivity$Header;I)V

    .line 41
    .end local v0    # "initialHeaderPair":Landroid/util/Pair;, "Landroid/util/Pair<Landroid/preference/PreferenceActivity$Header;Ljava/lang/Integer;>;"
    :cond_0
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 71
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 76
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingPreferenceActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 73
    :pswitch_0
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->finish()V

    .line 74
    const/4 v0, 0x1

    goto :goto_0

    .line 71
    nop

    :pswitch_data_0
    .packed-switch 0x102002c
        :pswitch_0
    .end packed-switch
.end method
