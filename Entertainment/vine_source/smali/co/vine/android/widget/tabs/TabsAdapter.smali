.class public Lco/vine/android/widget/tabs/TabsAdapter;
.super Landroid/support/v4/app/FragmentPagerAdapter;
.source "TabsAdapter.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# instance fields
.field private final mActivity:Lco/vine/android/BaseControllerActionBarActivity;

.field private final mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

.field private mSetActionBarColorOnPageSelectedEnabled:Z

.field private final mTabFactory:Lco/vine/android/widget/tabs/DummyTabFactory;

.field private final mTabHost:Landroid/widget/TabHost;

.field private final mTabs:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/widget/tabs/TabInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final mViewPager:Landroid/support/v4/view/ViewPager;

.field public previousTab:I


# direct methods
.method public constructor <init>(Lco/vine/android/BaseControllerActionBarActivity;Landroid/widget/TabHost;Landroid/support/v4/view/ViewPager;Lco/vine/android/widget/tabs/ViewPagerScrollBar;)V
    .locals 2
    .param p1, "activity"    # Lco/vine/android/BaseControllerActionBarActivity;
    .param p2, "tabHost"    # Landroid/widget/TabHost;
    .param p3, "pager"    # Landroid/support/v4/view/ViewPager;
    .param p4, "scrollBar"    # Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    .prologue
    .line 56
    invoke-virtual {p1}, Lco/vine/android/BaseControllerActionBarActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/support/v4/app/FragmentPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;)V

    .line 37
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    .line 40
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mSetActionBarColorOnPageSelectedEnabled:Z

    .line 57
    iput-object p1, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    .line 58
    iput-object p2, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabHost:Landroid/widget/TabHost;

    .line 59
    iput-object p3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mViewPager:Landroid/support/v4/view/ViewPager;

    .line 60
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 61
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, p0}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 62
    iput-object p4, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    .line 63
    new-instance v0, Lco/vine/android/widget/tabs/DummyTabFactory;

    iget-object v1, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-direct {v0, v1}, Lco/vine/android/widget/tabs/DummyTabFactory;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabFactory:Lco/vine/android/widget/tabs/DummyTabFactory;

    .line 64
    return-void
.end method


# virtual methods
.method public addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "tabSpec"    # Landroid/widget/TabHost$TabSpec;
    .param p3, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/TabHost$TabSpec;",
            "Ljava/lang/Class",
            "<*>;",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .prologue
    .line 67
    .local p2, "clss":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Lco/vine/android/widget/tabs/TabInfo;

    invoke-virtual {p1}, Landroid/widget/TabHost$TabSpec;->getTag()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p2, p3, v1}, Lco/vine/android/widget/tabs/TabInfo;-><init>(Ljava/lang/Class;Landroid/os/Bundle;Ljava/lang/String;)V

    .line 68
    .local v0, "info":Lco/vine/android/widget/tabs/TabInfo;
    iget-object v1, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabFactory:Lco/vine/android/widget/tabs/DummyTabFactory;

    invoke-virtual {p1, v1}, Landroid/widget/TabHost$TabSpec;->setContent(Landroid/widget/TabHost$TabContentFactory;)Landroid/widget/TabHost$TabSpec;

    .line 69
    iget-object v1, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 70
    iget-object v1, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v1, p1}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 71
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/TabsAdapter;->notifyDataSetChanged()V

    .line 72
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getCurrentFragment()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 96
    iget-object v1, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v1}, Landroid/widget/TabHost;->getCurrentTab()I

    move-result v1

    invoke-virtual {p0, v1}, Lco/vine/android/widget/tabs/TabsAdapter;->getTab(I)Lco/vine/android/widget/tabs/TabInfo;

    move-result-object v0

    .line 97
    .local v0, "tab":Lco/vine/android/widget/tabs/TabInfo;
    if-eqz v0, :cond_0

    .line 98
    invoke-virtual {v0}, Lco/vine/android/widget/tabs/TabInfo;->fragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 100
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getIndicator(I)Lco/vine/android/widget/tabs/TabIndicator;
    .locals 2
    .param p1, "tabIndex"    # I

    .prologue
    .line 189
    iget-object v1, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v1}, Landroid/widget/TabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v0

    .line 190
    .local v0, "widget":Landroid/widget/TabWidget;
    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Landroid/widget/TabWidget;->getChildTabViewAt(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/tabs/TabIndicator;

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getItem(I)Landroid/support/v4/app/Fragment;
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 129
    iget-object v1, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/tabs/TabInfo;

    iget-object v0, v0, Lco/vine/android/widget/tabs/TabInfo;->clss:Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/tabs/TabInfo;

    iget-object v0, v0, Lco/vine/android/widget/tabs/TabInfo;->bundle:Landroid/os/Bundle;

    invoke-static {v1, v2, v0}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    return-object v0
.end method

.method public getItemPosition(Ljava/lang/Object;)I
    .locals 4
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    .line 81
    const/4 v0, 0x0

    .line 82
    .local v0, "found":Z
    iget-object v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/widget/tabs/TabInfo;

    .line 83
    .local v2, "info":Lco/vine/android/widget/tabs/TabInfo;
    invoke-virtual {v2}, Lco/vine/android/widget/tabs/TabInfo;->fragment()Landroid/support/v4/app/Fragment;

    move-result-object v3

    if-ne v3, p1, :cond_0

    .line 84
    const/4 v0, 0x1

    .line 88
    .end local v2    # "info":Lco/vine/android/widget/tabs/TabInfo;
    :cond_1
    if-eqz v0, :cond_2

    .line 89
    const/4 v3, -0x1

    .line 91
    :goto_0
    return v3

    :cond_2
    const/4 v3, -0x2

    goto :goto_0
.end method

.method public getNewIndicatorForTab(I)Landroid/widget/ImageView;
    .locals 2
    .param p1, "tabIndex"    # I

    .prologue
    .line 201
    invoke-virtual {p0, p1}, Lco/vine/android/widget/tabs/TabsAdapter;->getIndicator(I)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v0

    .line 202
    .local v0, "indicator":Lco/vine/android/widget/tabs/TabIndicator;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lco/vine/android/widget/tabs/TabIndicator;->getNewIndicator()Landroid/widget/ImageView;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getTab(I)Lco/vine/android/widget/tabs/TabInfo;
    .locals 1
    .param p1, "pos"    # I

    .prologue
    .line 51
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/tabs/TabInfo;

    return-object v0
.end method

.method public getTabs()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/widget/tabs/TabInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 43
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    return-object v0
.end method

.method public instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 4
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I

    .prologue
    .line 135
    invoke-super {p0, p1, p2}, Landroid/support/v4/app/FragmentPagerAdapter;->instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 137
    .local v0, "blf":Landroid/support/v4/app/Fragment;
    iget-object v1, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v1, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/tabs/TabInfo;

    invoke-virtual {v1, v0}, Lco/vine/android/widget/tabs/TabInfo;->setFragment(Landroid/support/v4/app/Fragment;)V

    .line 139
    instance-of v1, v0, Lco/vine/android/BaseArrayListFragment;

    if-eqz v1, :cond_0

    move-object v1, v0

    .line 140
    check-cast v1, Lco/vine/android/BaseArrayListFragment;

    new-instance v2, Lco/vine/android/widget/tabs/TabScrollListener;

    iget-object v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-direct {v2, v3, p2}, Lco/vine/android/widget/tabs/TabScrollListener;-><init>(Lco/vine/android/BaseControllerActionBarActivity;I)V

    invoke-virtual {v1, v2}, Lco/vine/android/BaseArrayListFragment;->setScrollListener(Lco/vine/android/widget/tabs/TabScrollListener;)V

    .line 144
    :cond_0
    return-object v0
.end method

.method public onPageScrollStateChanged(I)V
    .locals 0
    .param p1, "state"    # I

    .prologue
    .line 186
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F
    .param p3, "positionOffsetPixels"    # I

    .prologue
    .line 148
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    if-ge v0, p1, :cond_1

    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    if-eqz v0, :cond_1

    .line 149
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    neg-int v1, p3

    invoke-virtual {v0, p1, v1}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->scroll(II)V

    .line 153
    :cond_0
    :goto_0
    return-void

    .line 150
    :cond_1
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    if-eqz v0, :cond_0

    .line 151
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    invoke-virtual {v0, p1, p3}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->scroll(II)V

    goto :goto_0
.end method

.method public onPageSelected(I)V
    .locals 5
    .param p1, "position"    # I

    .prologue
    .line 160
    iget-object v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v3}, Landroid/widget/TabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v2

    .line 161
    .local v2, "widget":Landroid/widget/TabWidget;
    invoke-virtual {v2}, Landroid/widget/TabWidget;->getDescendantFocusability()I

    move-result v0

    .line 162
    .local v0, "descendantFocusability":I
    const/high16 v3, 0x60000

    invoke-virtual {v2, v3}, Landroid/widget/TabWidget;->setDescendantFocusability(I)V

    .line 163
    iget v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->previousTab:I

    if-eq p1, v3, :cond_2

    .line 164
    iget-object v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabHost:Landroid/widget/TabHost;

    check-cast v3, Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v3, p1}, Lco/vine/android/widget/tabs/IconTabHost;->setTabExplicit(I)V

    .line 165
    iget-object v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    iget v4, p0, Lco/vine/android/widget/tabs/TabsAdapter;->previousTab:I

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/widget/tabs/TabInfo;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/TabInfo;->fragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 166
    .local v1, "fragment":Landroid/support/v4/app/Fragment;
    if-eqz v1, :cond_0

    instance-of v3, v1, Lco/vine/android/widget/OnTabChangedListener;

    if-eqz v3, :cond_0

    .line 167
    check-cast v1, Lco/vine/android/widget/OnTabChangedListener;

    .end local v1    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-interface {v1, p1}, Lco/vine/android/widget/OnTabChangedListener;->onMoveAway(I)V

    .line 169
    :cond_0
    iget-object v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/widget/tabs/TabInfo;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/TabInfo;->fragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 170
    .restart local v1    # "fragment":Landroid/support/v4/app/Fragment;
    if-eqz v1, :cond_1

    instance-of v3, v1, Lco/vine/android/widget/OnTabChangedListener;

    if-eqz v3, :cond_1

    move-object v3, v1

    .line 171
    check-cast v3, Lco/vine/android/widget/OnTabChangedListener;

    iget v4, p0, Lco/vine/android/widget/tabs/TabsAdapter;->previousTab:I

    invoke-interface {v3, v4}, Lco/vine/android/widget/OnTabChangedListener;->onMoveTo(I)V

    .line 174
    :cond_1
    if-eqz v1, :cond_2

    iget-boolean v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mSetActionBarColorOnPageSelectedEnabled:Z

    if-eqz v3, :cond_2

    .line 175
    check-cast v1, Lco/vine/android/BaseFragment;

    .end local v1    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v1}, Lco/vine/android/BaseFragment;->setActionBarColor()V

    .line 178
    :cond_2
    iget-object v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v3}, Landroid/widget/TabHost;->getCurrentTab()I

    move-result v3

    iput v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->previousTab:I

    .line 179
    iget-object v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    if-eqz v3, :cond_3

    .line 180
    iget-object v3, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    invoke-virtual {v3, p1}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setPageColor(I)V

    .line 182
    :cond_3
    invoke-virtual {v2, v0}, Landroid/widget/TabWidget;->setDescendantFocusability(I)V

    .line 183
    return-void
.end method

.method public restoreState(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V
    .locals 7
    .param p1, "state"    # Landroid/os/Parcelable;
    .param p2, "loader"    # Ljava/lang/ClassLoader;

    .prologue
    .line 111
    move-object v2, p1

    check-cast v2, Lco/vine/android/widget/tabs/TabSavedState;

    .line 112
    .local v2, "savedState":Lco/vine/android/widget/tabs/TabSavedState;
    iget-object v4, v2, Lco/vine/android/widget/tabs/TabSavedState;->tags:[Ljava/lang/String;

    .line 113
    .local v4, "tags":[Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v5, v4

    if-ge v1, v5, :cond_1

    .line 114
    aget-object v3, v4, v1

    .line 115
    .local v3, "tag":Ljava/lang/String;
    iget-object v5, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-virtual {v5}, Lco/vine/android/BaseControllerActionBarActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v5

    invoke-virtual {v5, v3}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 117
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    if-eqz v0, :cond_0

    .line 118
    iget-object v5, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lco/vine/android/widget/tabs/TabInfo;

    invoke-virtual {v5, v0}, Lco/vine/android/widget/tabs/TabInfo;->setFragment(Landroid/support/v4/app/Fragment;)V

    .line 119
    instance-of v5, v0, Lco/vine/android/BaseArrayListFragment;

    if-eqz v5, :cond_0

    .line 120
    check-cast v0, Lco/vine/android/BaseArrayListFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    new-instance v5, Lco/vine/android/widget/tabs/TabScrollListener;

    iget-object v6, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    invoke-direct {v5, v6, v1}, Lco/vine/android/widget/tabs/TabScrollListener;-><init>(Lco/vine/android/BaseControllerActionBarActivity;I)V

    invoke-virtual {v0, v5}, Lco/vine/android/BaseArrayListFragment;->setScrollListener(Lco/vine/android/widget/tabs/TabScrollListener;)V

    .line 113
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 125
    .end local v3    # "tag":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method public saveState()Landroid/os/Parcelable;
    .locals 2

    .prologue
    .line 106
    new-instance v0, Lco/vine/android/widget/tabs/TabSavedState;

    iget-object v1, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Lco/vine/android/widget/tabs/TabSavedState;-><init>(Ljava/util/ArrayList;)V

    return-object v0
.end method

.method public setNew(IZ)V
    .locals 1
    .param p1, "tabIndex"    # I
    .param p2, "isNew"    # Z

    .prologue
    .line 194
    invoke-virtual {p0, p1}, Lco/vine/android/widget/tabs/TabsAdapter;->getIndicator(I)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v0

    .line 195
    .local v0, "indicator":Lco/vine/android/widget/tabs/TabIndicator;
    if-eqz v0, :cond_0

    .line 196
    invoke-virtual {v0, p2}, Lco/vine/android/widget/tabs/TabIndicator;->setNew(Z)V

    .line 198
    :cond_0
    return-void
.end method

.method public setSetActionBarColorOnPageSelectedEnabled(Z)V
    .locals 0
    .param p1, "setActionBarColorOnPageSelectedEnabled"    # Z

    .prologue
    .line 206
    iput-boolean p1, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mSetActionBarColorOnPageSelectedEnabled:Z

    .line 207
    return-void
.end method

.method public tabs()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/widget/tabs/TabInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 47
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabsAdapter;->mTabs:Ljava/util/ArrayList;

    return-object v0
.end method
