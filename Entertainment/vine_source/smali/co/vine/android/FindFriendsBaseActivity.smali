.class public Lco/vine/android/FindFriendsBaseActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "FindFriendsBaseActivity.java"

# interfaces
.implements Landroid/widget/TabHost$OnTabChangeListener;
.implements Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;


# static fields
.field public static final EXTRA_IS_TWITTER_REG:Ljava/lang/String; = "is_twitter_reg"

.field private static final STATE_CURRENT_TAB:Ljava/lang/String; = "currentTab"

.field public static final TAG_ADDRESS_BOOK:Ljava/lang/String; = "address"

.field public static final TAG_SEARCH:Ljava/lang/String; = "search"

.field public static final TAG_TWITTER:Ljava/lang/String; = "twitter"


# instance fields
.field protected mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

.field protected mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

.field protected mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

.field protected mViewPager:Landroid/support/v4/view/ViewPager;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method

.method private setupTabs()V
    .locals 2

    .prologue
    .line 77
    const v0, 0x1020012

    invoke-virtual {p0, v0}, Lco/vine/android/FindFriendsBaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/tabs/IconTabHost;

    iput-object v0, p0, Lco/vine/android/FindFriendsBaseActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    .line 78
    iget-object v0, p0, Lco/vine/android/FindFriendsBaseActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    if-nez v0, :cond_0

    .line 79
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Your content must have a TabHost whose id attribute is \'android.R.id.tabhost\'"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 83
    :cond_0
    iget-object v0, p0, Lco/vine/android/FindFriendsBaseActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v0}, Lco/vine/android/widget/tabs/IconTabHost;->setup()V

    .line 84
    const v0, 0x7f0a00da

    invoke-virtual {p0, v0}, Lco/vine/android/FindFriendsBaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lco/vine/android/FindFriendsBaseActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    .line 85
    return-void
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 123
    packed-switch p1, :pswitch_data_0

    .line 133
    :cond_0
    :goto_0
    return-void

    .line 126
    :pswitch_0
    iget-object v1, p0, Lco/vine/android/FindFriendsBaseActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lco/vine/android/widget/tabs/TabsAdapter;->getTab(I)Lco/vine/android/widget/tabs/TabInfo;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/TabInfo;->fragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 127
    .local v0, "frag":Landroid/support/v4/app/Fragment;
    if-eqz v0, :cond_0

    .line 128
    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0

    .line 123
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 39
    const v1, 0x7f030053

    const/4 v2, 0x1

    invoke-super {p0, p1, v1, v2}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 40
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 41
    invoke-direct {p0}, Lco/vine/android/FindFriendsBaseActivity;->setupTabs()V

    .line 44
    :cond_0
    const v1, 0x7f0a011c

    invoke-virtual {p0, v1}, Lco/vine/android/FindFriendsBaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    iput-object v1, p0, Lco/vine/android/FindFriendsBaseActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    .line 45
    invoke-virtual {p0}, Lco/vine/android/FindFriendsBaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 46
    .local v0, "intent":Landroid/content/Intent;
    if-eqz v0, :cond_1

    .line 47
    const-string v1, "is_twitter_reg"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 48
    iget-object v1, p0, Lco/vine/android/FindFriendsBaseActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    const v2, 0x7f070001

    invoke-virtual {v1, v2}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setColorIds(I)V

    .line 52
    :cond_1
    const v1, 0x7f0a00da

    invoke-virtual {p0, v1}, Lco/vine/android/FindFriendsBaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/support/v4/view/ViewPager;

    iput-object v1, p0, Lco/vine/android/FindFriendsBaseActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    .line 53
    iget-object v1, p0, Lco/vine/android/FindFriendsBaseActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {p0}, Lco/vine/android/FindFriendsBaseActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0b0054

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/support/v4/view/ViewPager;->setPageMargin(I)V

    .line 54
    iget-object v1, p0, Lco/vine/android/FindFriendsBaseActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    const v2, 0x7f09000e

    invoke-virtual {v1, v2}, Landroid/support/v4/view/ViewPager;->setPageMarginDrawable(I)V

    .line 55
    return-void
.end method

.method public onCurrentTabClicked()V
    .locals 0

    .prologue
    .line 97
    return-void
.end method

.method protected onDestroy()V
    .locals 3

    .prologue
    .line 113
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onDestroy()V

    .line 114
    iget-object v2, p0, Lco/vine/android/FindFriendsBaseActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v2}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v0

    .line 115
    .local v0, "currentIndex":I
    iget-object v2, p0, Lco/vine/android/FindFriendsBaseActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v2}, Lco/vine/android/widget/tabs/TabsAdapter;->getTabs()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/widget/tabs/TabInfo;

    invoke-virtual {v2}, Lco/vine/android/widget/tabs/TabInfo;->fragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 116
    .local v1, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v2, v1, Lco/vine/android/widget/OnTabChangedListener;

    if-eqz v2, :cond_0

    .line 117
    check-cast v1, Lco/vine/android/widget/OnTabChangedListener;

    .end local v1    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-interface {v1, v0}, Lco/vine/android/widget/OnTabChangedListener;->onMoveAway(I)V

    .line 119
    :cond_0
    return-void
.end method

.method protected onRestoreInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "state"    # Landroid/os/Bundle;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 59
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onRestoreInstanceState(Landroid/os/Bundle;)V

    .line 60
    const-string v1, "currentTab"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 61
    .local v0, "cur":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 62
    invoke-virtual {p0, v0}, Lco/vine/android/FindFriendsBaseActivity;->setCurrentTabByTag(Ljava/lang/String;)V

    .line 64
    :cond_0
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 69
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 70
    iget-object v1, p0, Lco/vine/android/FindFriendsBaseActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v0

    .line 71
    .local v0, "cur":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 72
    const-string v1, "currentTab"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    :cond_0
    return-void
.end method

.method public onSupportContentChanged()V
    .locals 1

    .prologue
    .line 89
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onSupportContentChanged()V

    .line 90
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v0

    if-nez v0, :cond_0

    .line 91
    invoke-direct {p0}, Lco/vine/android/FindFriendsBaseActivity;->setupTabs()V

    .line 93
    :cond_0
    return-void
.end method

.method public onTabChanged(Ljava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 108
    iget-object v0, p0, Lco/vine/android/FindFriendsBaseActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lco/vine/android/FindFriendsBaseActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 109
    return-void
.end method

.method setCurrentTabByTag(Ljava/lang/String;)V
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 100
    iget-object v0, p0, Lco/vine/android/FindFriendsBaseActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    .line 101
    .local v0, "tabHost":Landroid/widget/TabHost;
    invoke-virtual {v0}, Landroid/widget/TabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 102
    invoke-virtual {v0, p1}, Landroid/widget/TabHost;->setCurrentTabByTag(Ljava/lang/String;)V

    .line 104
    :cond_0
    iget-object v1, p0, Lco/vine/android/FindFriendsBaseActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    iget-object v2, p0, Lco/vine/android/FindFriendsBaseActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v2

    invoke-virtual {v1, v2}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setPosition(I)V

    .line 105
    return-void
.end method
