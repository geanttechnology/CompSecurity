.class public Lcom/amazon/mShop/gno/GNODrawer;
.super Ljava/lang/Object;
.source "GNODrawer.java"

# interfaces
.implements Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;
.implements Lcom/amazon/mobile/appdrawer/AppDrawerShowHideCallback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNODrawer$SimpleGNODrawerListener;,
        Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;,
        Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;
    }
.end annotation


# static fields
.field private static sDrawerItemAdapter:Lcom/amazon/mShop/gno/GNOItemAdapter;


# instance fields
.field private mAppDrawerFragment:Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;

.field private mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

.field private mListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;",
            ">;"
        }
    .end annotation
.end field

.field private mMenuList:Landroid/widget/ListView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    new-instance v0, Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-direct {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;-><init>()V

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawer;->sDrawerItemAdapter:Lcom/amazon/mShop/gno/GNOItemAdapter;

    return-void
.end method

.method private constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 4
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    const/4 v3, 0x0

    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer:I

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    .line 50
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->gno_drawer_shadow:I

    const/4 v2, 0x3

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->setDrawerShadow(II)V

    .line 51
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    new-instance v1, Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;

    invoke-direct {v1, p0, v3}, Lcom/amazon/mShop/gno/GNODrawer$DrawerListener;-><init>(Lcom/amazon/mShop/gno/GNODrawer;Lcom/amazon/mShop/gno/GNODrawer$1;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->setDrawerListener(Landroid/support/v4/widget/DrawerLayout$DrawerListener;)V

    .line 53
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mListeners:Ljava/util/Set;

    .line 56
    invoke-static {p0}, Lcom/amazon/mShop/util/LocaleUtils;->addLocaleSwitchListener(Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;)V

    .line 58
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->gno_drawer_list:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawer;->buildMenu()V

    .line 62
    invoke-virtual {p1}, Lcom/amazon/mShop/AmazonActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->amazon_app_drawer_fragment:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mAppDrawerFragment:Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;

    .line 64
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_is_app_drawer_enabled:I

    invoke-static {p1, v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 65
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawer$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/gno/GNODrawer$1;-><init>(Lcom/amazon/mShop/gno/GNODrawer;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/gno/GNODrawer;->addListener(Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;)V

    .line 83
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mAppDrawerFragment:Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;

    invoke-virtual {v0, p0}, Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;->setShowHideCallback(Lcom/amazon/mobile/appdrawer/AppDrawerShowHideCallback;)V

    .line 88
    :goto_0
    return-void

    .line 85
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/mShop/AmazonActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawer;->mAppDrawerFragment:Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->remove(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 86
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawer;->hideAppDrawer()V

    goto :goto_0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/gno/GNODrawer;)Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mAppDrawerFragment:Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/gno/GNODrawer;)Landroid/widget/ListView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/gno/GNODrawer;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawer;->getListenersCopy()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method private buildMenu()V
    .locals 2

    .prologue
    .line 369
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    new-instance v1, Lcom/amazon/mShop/gno/GNODrawer$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/gno/GNODrawer$3;-><init>(Lcom/amazon/mShop/gno/GNODrawer;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 380
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setDescendantFocusability(I)V

    .line 381
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 382
    return-void
.end method

.method public static getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;
    .locals 1

    .prologue
    .line 40
    sget-object v0, Lcom/amazon/mShop/gno/GNODrawer;->sDrawerItemAdapter:Lcom/amazon/mShop/gno/GNOItemAdapter;

    return-object v0
.end method

.method public static getInstance(Lcom/amazon/mShop/AmazonActivity;)Lcom/amazon/mShop/gno/GNODrawer;
    .locals 1
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 45
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawer;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/gno/GNODrawer;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    return-object v0
.end method

.method private getListenersCopy()Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;",
            ">;"
        }
    .end annotation

    .prologue
    .line 449
    new-instance v0, Ljava/util/HashSet;

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawer;->mListeners:Ljava/util/Set;

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method

.method public static reset()V
    .locals 1

    .prologue
    .line 390
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->clearItems()V

    .line 391
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->notifyDataSetChanged()V

    .line 392
    invoke-static {}, Lcom/amazon/mShop/gno/GNOMenuItemController;->getInstance()Lcom/amazon/mShop/gno/GNOMenuItemController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNOMenuItemController;->resetUpdate()V

    .line 394
    invoke-static {}, Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;->reset()V

    .line 395
    return-void
.end method


# virtual methods
.method public addListener(Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;

    .prologue
    .line 457
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 458
    return-void
.end method

.method public applyGNODrawer(Landroid/view/View;)Landroid/view/View;
    .locals 4
    .param p1, "contentView"    # Landroid/view/View;

    .prologue
    .line 357
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    sget v3, Lcom/amazon/mShop/android/lib/R$id;->content_frame:I

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 358
    .local v1, "oldContent":Landroid/view/View;
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    invoke-virtual {v2, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->indexOfChild(Landroid/view/View;)I

    move-result v0

    .line 359
    .local v0, "index":I
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    invoke-virtual {v2, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->removeView(Landroid/view/View;)V

    .line 360
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    invoke-virtual {v2, p1, v0}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->addView(Landroid/view/View;I)V

    .line 362
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    return-object v2
.end method

.method public close()V
    .locals 2

    .prologue
    .line 127
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawer;->isUnlocked()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 128
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->closeDrawer(I)V

    .line 130
    :cond_0
    return-void
.end method

.method public closeAppDrawer()V
    .locals 2

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mAppDrawerFragment:Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;->closeAppDrawer(Z)V

    .line 121
    return-void
.end method

.method public destroy()V
    .locals 2

    .prologue
    .line 341
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 344
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mListeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 347
    invoke-static {p0}, Lcom/amazon/mShop/util/LocaleUtils;->removeLocaleSwitchListener(Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;)V

    .line 348
    return-void
.end method

.method public focusOn(Ljava/lang/String;)Z
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 275
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/gno/GNODrawer;->focusOn(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public focusOn(Ljava/lang/String;Z)Z
    .locals 3
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "pinToTop"    # Z

    .prologue
    .line 284
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v0

    .line 286
    .local v0, "item":Lcom/amazon/mShop/gno/GNODrawerItem;
    if-eqz v0, :cond_0

    .line 287
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/gno/GNODrawer$2;

    invoke-direct {v2, p0, v0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawer$2;-><init>(Lcom/amazon/mShop/gno/GNODrawer;Lcom/amazon/mShop/gno/GNODrawerItem;Ljava/lang/String;Z)V

    invoke-interface {v1, v2}, Lcom/amazon/mShop/platform/Platform;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 305
    const/4 v1, 0x1

    .line 307
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getListView()Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    return-object v0
.end method

.method public hideAppDrawer()V
    .locals 2

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->app_drawer_frame_layout:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->more_amazon_apps_placeholder:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 98
    return-void
.end method

.method public isAppDrawerOpen()Z
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mAppDrawerFragment:Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;

    invoke-virtual {v0}, Lcom/amazon/mobile/appdrawer/LeftNavAppDrawerFragment;->isAppDrawerOpen()Z

    move-result v0

    return v0
.end method

.method public isClosed()Z
    .locals 1

    .prologue
    .line 191
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawer;->isOpen()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isItemDisplayed(Ljava/lang/String;)Z
    .locals 4
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 256
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v3

    invoke-virtual {v3, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getVisibleItemPosition(Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getListViewPosition(I)I

    move-result v2

    .line 257
    .local v2, "pos":I
    iget-object v3, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    invoke-virtual {v3}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v1

    .line 258
    .local v1, "min":I
    iget-object v3, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    invoke-virtual {v3}, Landroid/widget/ListView;->getLastVisiblePosition()I

    move-result v0

    .line 259
    .local v0, "max":I
    if-lt v2, v1, :cond_0

    if-gt v2, v0, :cond_0

    const/4 v3, 0x1

    :goto_0
    return v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public isLastVisibleItem(Ljava/lang/String;)Z
    .locals 2
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 214
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getVisibleItemPosition(Ljava/lang/String;)I

    move-result v0

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    invoke-virtual {v1}, Landroid/widget/ListView;->getLastVisiblePosition()I

    move-result v1

    invoke-static {v1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getAdapterPosition(I)I

    move-result v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isOpen()Z
    .locals 2

    .prologue
    .line 184
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->isDrawerOpen(I)Z

    move-result v0

    return v0
.end method

.method public isUnlocked()Z
    .locals 2

    .prologue
    .line 205
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->getDrawerLockMode(I)I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isVisible()Z
    .locals 2

    .prologue
    .line 198
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->isDrawerVisible(I)Z

    move-result v0

    return v0
.end method

.method public lock()V
    .locals 2

    .prologue
    .line 170
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->isDrawerOpen(I)Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/gno/GNODrawer;->lock(Z)V

    .line 171
    return-void
.end method

.method public lock(Z)V
    .locals 3
    .param p1, "opened"    # Z

    .prologue
    const/4 v2, 0x3

    .line 159
    if-eqz p1, :cond_0

    .line 160
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    const/4 v1, 0x2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->setDrawerLockMode(II)V

    .line 164
    :goto_0
    return-void

    .line 162
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    const/4 v1, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->setDrawerLockMode(II)V

    goto :goto_0
.end method

.method public onLocaleSwitch(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "fromLocale"    # Ljava/lang/String;
    .param p2, "toLocale"    # Ljava/lang/String;

    .prologue
    .line 399
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->reset()V

    .line 400
    return-void
.end method

.method public refresh()V
    .locals 1

    .prologue
    .line 324
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->notifyDataSetChanged()V

    .line 325
    return-void
.end method

.method public removeListener(Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;

    .prologue
    .line 465
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 466
    return-void
.end method

.method public resetPosition()V
    .locals 2

    .prologue
    .line 315
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->collapseExpandedGroup()V

    .line 316
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelection(I)V

    .line 317
    return-void
.end method

.method public scrollItemToTop(Ljava/lang/String;)V
    .locals 3
    .param p1, "id"    # Ljava/lang/String;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 240
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getVisibleItemPosition(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getListViewPosition(I)I

    move-result v0

    .line 241
    .local v0, "pos":I
    if-ltz v0, :cond_0

    .line 242
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xa

    if-le v1, v2, :cond_1

    .line 243
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/widget/ListView;->smoothScrollToPositionFromTop(II)V

    .line 248
    :cond_0
    :goto_0
    return-void

    .line 245
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setSelection(I)V

    goto :goto_0
.end method

.method public showAppDrawer()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->app_drawer_frame_layout:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 105
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->more_amazon_apps_placeholder:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 106
    return-void
.end method

.method public toggle()V
    .locals 2

    .prologue
    const/4 v1, 0x3

    .line 136
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawer;->isUnlocked()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 137
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->isDrawerOpen(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 138
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->closeDrawer(I)V

    .line 143
    :cond_0
    :goto_0
    return-void

    .line 140
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->openDrawer(I)V

    goto :goto_0
.end method

.method public unlock()V
    .locals 3

    .prologue
    .line 177
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawer;->mDrawer:Lcom/amazon/mShop/gno/AmazonDrawerLayout;

    const/4 v1, 0x0

    const/4 v2, 0x3

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/gno/AmazonDrawerLayout;->setDrawerLockMode(II)V

    .line 178
    return-void
.end method

.method public updateMenuItems(Z)V
    .locals 2
    .param p1, "needFetchFromServer"    # Z

    .prologue
    .line 333
    invoke-static {}, Lcom/amazon/mShop/gno/GNOMenuItemController;->getInstance()Lcom/amazon/mShop/gno/GNOMenuItemController;

    move-result-object v0

    sget-object v1, Lcom/amazon/mShop/gno/GNODrawer;->sDrawerItemAdapter:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-virtual {v0, v1, p1}, Lcom/amazon/mShop/gno/GNOMenuItemController;->updateMenuItems(Lcom/amazon/mShop/gno/GNOItemAdapter;Z)V

    .line 334
    return-void
.end method
