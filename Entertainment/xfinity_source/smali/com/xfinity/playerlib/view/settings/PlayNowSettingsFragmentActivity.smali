.class public Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;
.super Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;
.source "PlayNowSettingsFragmentActivity.java"


# instance fields
.field private final androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

.field private final configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

.field private mHeaders:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/preference/PreferenceActivity$Header;",
            ">;"
        }
    .end annotation
.end field

.field private final sideMenuBuilder:Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

.field private final sideRibbonDelegateBuilder:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;-><init>()V

    .line 25
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSideRibbonDelegateBuilder()Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->sideRibbonDelegateBuilder:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    .line 26
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSideMenuBuilder()Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->sideMenuBuilder:Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

    .line 27
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    .line 28
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 29
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    return-void
.end method


# virtual methods
.method protected getSideMenuBuilder()Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->sideMenuBuilder:Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

    return-object v0
.end method

.method protected getSideRibbonDelegateBuilder()Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->sideRibbonDelegateBuilder:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    return-object v0
.end method

.method protected isValidFragment(Ljava/lang/String;)Z
    .locals 1
    .param p1, "fragmentName"    # Ljava/lang/String;

    .prologue
    .line 130
    const-class v0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 131
    const/4 v0, 0x1

    .line 134
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onBuildHeaders(Ljava/util/List;)V
    .locals 9
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
    .line 83
    .local p1, "target":Ljava/util/List;, "Ljava/util/List<Landroid/preference/PreferenceActivity$Header;>;"
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->onBuildHeaders(Ljava/util/List;)V

    .line 85
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->mHeaders:Ljava/util/List;

    .line 87
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 88
    .local v3, "resources":Landroid/content/res/Resources;
    sget v7, Lcom/xfinity/playerlib/R$string;->settings_signout_title:I

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 90
    .local v4, "signoutTitle":Ljava/lang/String;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_0
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/preference/PreferenceActivity$Header;

    .line 91
    .local v1, "header":Landroid/preference/PreferenceActivity$Header;
    invoke-virtual {v1, v3}, Landroid/preference/PreferenceActivity$Header;->getTitle(Landroid/content/res/Resources;)Ljava/lang/CharSequence;

    move-result-object v7

    if-eqz v7, :cond_0

    .line 92
    invoke-virtual {v1, v3}, Landroid/preference/PreferenceActivity$Header;->getTitle(Landroid/content/res/Resources;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-interface {v7}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v5

    .line 93
    .local v5, "tempTitle":Ljava/lang/String;
    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 94
    iget-object v7, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v7

    check-cast v7, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v1, Landroid/preference/PreferenceActivity$Header;->summary:Ljava/lang/CharSequence;

    goto :goto_0

    .line 100
    .end local v1    # "header":Landroid/preference/PreferenceActivity$Header;
    .end local v5    # "tempTitle":Ljava/lang/String;
    :cond_1
    iget-object v7, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    invoke-virtual {v7}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->hasCellularCapability()Z

    move-result v7

    if-nez v7, :cond_3

    .line 101
    sget v7, Lcom/xfinity/playerlib/R$string;->settings_use_cellular_title:I

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 103
    .local v6, "videoPlaybackTitle":Ljava/lang/String;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 104
    .local v2, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/preference/PreferenceActivity$Header;>;"
    :cond_2
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3

    .line 105
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/preference/PreferenceActivity$Header;

    .line 106
    .restart local v1    # "header":Landroid/preference/PreferenceActivity$Header;
    invoke-virtual {v1, v3}, Landroid/preference/PreferenceActivity$Header;->getTitle(Landroid/content/res/Resources;)Ljava/lang/CharSequence;

    move-result-object v7

    if-eqz v7, :cond_2

    invoke-virtual {v1, v3}, Landroid/preference/PreferenceActivity$Header;->getTitle(Landroid/content/res/Resources;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-interface {v7}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 107
    invoke-interface {v2}, Ljava/util/Iterator;->remove()V

    goto :goto_1

    .line 112
    .end local v1    # "header":Landroid/preference/PreferenceActivity$Header;
    .end local v2    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/preference/PreferenceActivity$Header;>;"
    .end local v6    # "videoPlaybackTitle":Ljava/lang/String;
    :cond_3
    iget-object v7, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->isDeveloperModeAllowed()Z

    move-result v7

    if-nez v7, :cond_5

    .line 113
    sget v7, Lcom/xfinity/playerlib/R$string;->settings_title_developer_options:I

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 114
    .local v0, "developerOptionsTitle":Ljava/lang/String;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 115
    .restart local v2    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/preference/PreferenceActivity$Header;>;"
    :cond_4
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 116
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/preference/PreferenceActivity$Header;

    .line 117
    .restart local v1    # "header":Landroid/preference/PreferenceActivity$Header;
    invoke-virtual {v1, v3}, Landroid/preference/PreferenceActivity$Header;->getTitle(Landroid/content/res/Resources;)Ljava/lang/CharSequence;

    move-result-object v7

    if-eqz v7, :cond_4

    invoke-virtual {v1, v3}, Landroid/preference/PreferenceActivity$Header;->getTitle(Landroid/content/res/Resources;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-interface {v7}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 118
    invoke-interface {v2}, Ljava/util/Iterator;->remove()V

    goto :goto_2

    .line 122
    .end local v0    # "developerOptionsTitle":Ljava/lang/String;
    .end local v1    # "header":Landroid/preference/PreferenceActivity$Header;
    .end local v2    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/preference/PreferenceActivity$Header;>;"
    :cond_5
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 35
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->isKindle()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 38
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x400

    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 40
    :cond_0
    return-void
.end method

.method public setListAdapter(Landroid/widget/ListAdapter;)V
    .locals 5
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 65
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->mHeaders:Ljava/util/List;

    if-nez v2, :cond_0

    .line 66
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->mHeaders:Ljava/util/List;

    .line 71
    invoke-interface {p1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    .line 72
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 73
    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->mHeaders:Ljava/util/List;

    invoke-interface {p1, v1}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/preference/PreferenceActivity$Header;

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 72
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 76
    .end local v0    # "count":I
    .end local v1    # "i":I
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->getListView()Landroid/widget/ListView;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 77
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->getListView()Landroid/widget/ListView;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 78
    new-instance v2, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->mHeaders:Ljava/util/List;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    invoke-direct {v2, p0, v3, v4}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;-><init>(Landroid/content/Context;Ljava/util/List;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;)V

    invoke-super {p0, v2}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->setListAdapter(Landroid/widget/ListAdapter;)V

    .line 79
    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->isKindle()Z

    move-result v0

    if-nez v0, :cond_0

    .line 48
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 50
    :cond_0
    return-void
.end method
