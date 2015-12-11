.class public abstract Lcom/poshmark/utils/FragmentPagerAdapter;
.super Landroid/support/v4/view/PagerAdapter;
.source "FragmentPagerAdapter.java"


# static fields
.field private static final DEBUG:Z = false

.field private static final TAG:Ljava/lang/String; = "FragmentPagerAdapter"


# instance fields
.field private mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

.field private mCurrentPrimaryItem:Lcom/poshmark/ui/fragments/PMFragment;

.field private final mFragmentManager:Landroid/support/v4/app/FragmentManager;


# direct methods
.method public constructor <init>(Landroid/support/v4/app/FragmentManager;)V
    .locals 1
    .param p1, "fm"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    const/4 v0, 0x0

    .line 74
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 71
    iput-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

    .line 72
    iput-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurrentPrimaryItem:Lcom/poshmark/ui/fragments/PMFragment;

    .line 75
    iput-object p1, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    .line 76
    return-void
.end method

.method private static makeFragmentName(II)Ljava/lang/String;
    .locals 2
    .param p0, "viewId"    # I
    .param p1, "index"    # I

    .prologue
    .line 162
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "android:switcher:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 1
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 110
    iget-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

    if-nez v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

    .line 115
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

    check-cast p3, Landroid/support/v4/app/Fragment;

    .end local p3    # "object":Ljava/lang/Object;
    invoke-virtual {v0, p3}, Landroid/support/v4/app/FragmentTransaction;->detach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 116
    return-void
.end method

.method public finishUpdate(Landroid/view/ViewGroup;)V
    .locals 1
    .param p1, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 135
    iget-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

    if-eqz v0, :cond_0

    .line 136
    iget-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 137
    iget-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->executePendingTransactions()Z

    .line 138
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

    .line 140
    :cond_0
    return-void
.end method

.method public getCurrentVisibleFragment()Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurrentPrimaryItem:Lcom/poshmark/ui/fragments/PMFragment;

    return-object v0
.end method

.method public abstract getItem(I)Landroid/support/v4/app/Fragment;
.end method

.method public instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 5
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I

    .prologue
    .line 89
    iget-object v2, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

    if-nez v2, :cond_0

    .line 90
    iget-object v2, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

    .line 94
    :cond_0
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getId()I

    move-result v2

    invoke-static {v2, p2}, Lcom/poshmark/utils/FragmentPagerAdapter;->makeFragmentName(II)Ljava/lang/String;

    move-result-object v1

    .line 95
    .local v1, "name":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v2, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFragment;

    .line 96
    .local v0, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v0, :cond_1

    .line 98
    iget-object v2, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

    invoke-virtual {v2, v0}, Landroid/support/v4/app/FragmentTransaction;->attach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 105
    :goto_0
    return-object v0

    .line 100
    :cond_1
    invoke-virtual {p0, p2}, Lcom/poshmark/utils/FragmentPagerAdapter;->getItem(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .end local v0    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    check-cast v0, Lcom/poshmark/ui/fragments/PMFragment;

    .line 102
    .restart local v0    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    iget-object v2, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurTransaction:Landroid/support/v4/app/FragmentTransaction;

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getId()I

    move-result v3

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getId()I

    move-result v4

    invoke-static {v4, p2}, Lcom/poshmark/utils/FragmentPagerAdapter;->makeFragmentName(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v0, v4}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    goto :goto_0
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "object"    # Ljava/lang/Object;

    .prologue
    .line 144
    check-cast p2, Landroid/support/v4/app/Fragment;

    .end local p2    # "object":Ljava/lang/Object;
    invoke-virtual {p2}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v0

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public restoreState(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V
    .locals 0
    .param p1, "state"    # Landroid/os/Parcelable;
    .param p2, "loader"    # Ljava/lang/ClassLoader;

    .prologue
    .line 154
    return-void
.end method

.method public saveState()Landroid/os/Parcelable;
    .locals 1

    .prologue
    .line 149
    const/4 v0, 0x0

    return-object v0
.end method

.method public setPrimaryItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 3
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 120
    move-object v0, p3

    check-cast v0, Lcom/poshmark/ui/fragments/PMFragment;

    .line 121
    .local v0, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    iget-object v1, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurrentPrimaryItem:Lcom/poshmark/ui/fragments/PMFragment;

    if-eq v0, v1, :cond_2

    .line 122
    iget-object v1, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurrentPrimaryItem:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v1, :cond_0

    .line 123
    iget-object v1, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurrentPrimaryItem:Lcom/poshmark/ui/fragments/PMFragment;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 125
    :cond_0
    if-eqz v0, :cond_1

    .line 126
    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->getUserVisibleHint()Z

    move-result v1

    if-nez v1, :cond_1

    .line 127
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 129
    :cond_1
    iput-object v0, p0, Lcom/poshmark/utils/FragmentPagerAdapter;->mCurrentPrimaryItem:Lcom/poshmark/ui/fragments/PMFragment;

    .line 131
    :cond_2
    return-void
.end method

.method public startUpdate(Landroid/view/ViewGroup;)V
    .locals 0
    .param p1, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 85
    return-void
.end method
