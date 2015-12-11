.class public Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;
.super Lcom/amazon/mShop/gno/GNOMenuItemProvider;
.source "GNOMenuItemProviderDefault.java"


# instance fields
.field context:Landroid/content/Context;

.field private mMenuItems:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 112
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNOMenuItemProvider;-><init>()V

    .line 110
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->context:Landroid/content/Context;

    .line 113
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->buildDefaultMenuItems(Landroid/content/Context;)V

    .line 114
    return-void
.end method

.method private getAIVItem(Landroid/content/Context;)Lcom/amazon/mShop/gno/GNODrawerItem;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 337
    const-string/jumbo v0, "mshop:aiv"

    invoke-static {p1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_gateway:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v1}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    new-instance v1, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$9;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$9;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    const-string/jumbo v1, "mshop:aiv/vh"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_videos_home:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/wl"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_wl:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_wl_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/yvl"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_yvl:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_yvl_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v1

    const-string/jumbo v0, "mshop:aiv/prime_tv"

    invoke-static {p1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_prime_tv:I

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/prime_tv_top"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_prime_tv_top:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_prime_tv_top_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/prime_tv_kids"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_prime_kids_tv:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_prime_kids_tv_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v1

    const-string/jumbo v0, "mshop:aiv/hbo_on_prime"

    invoke-static {p1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_hbo_prime:I

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_hbo_prime_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    new-instance v2, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$8;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$8;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;)V

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/prime_tv_genres"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_prime_genres:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_prime_genres_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v1

    const-string/jumbo v0, "mshop:aiv/prime_mov"

    invoke-static {p1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_prime_mov:I

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/prime_mov_top"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_prime_mov_top:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_prime_mov_top_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/prime_mov_kids"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_prime_kids_mov:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_prime_kids_mov_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/prime_movie_genres"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_movie_prime_genres:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_movie_prime_genres_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v1

    const-string/jumbo v0, "mshop:aiv/tv"

    invoke-static {p1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv:I

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/tv_latest"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_latest:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_latest_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/tv_pop"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_pop:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_pop_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/tv_kids"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_kids:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_kids_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/tv_genres"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_genres:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_tv_genres_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v1

    const-string/jumbo v0, "mshop:aiv/mov"

    invoke-static {p1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_mov:I

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/mov_new"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_mov_new:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_mov_new_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/mov_pop"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_mov_pop:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_mov_pop_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/mov_kids"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_mov_kids:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_mov_kids_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/movie_genres"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_movie_genres:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_movie_genres_url:I

    invoke-direct {p0, p1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v1

    const-string/jumbo v0, "mshop:aiv/more"

    invoke-static {p1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_more:I

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/more_settings"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_more_settings:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_settings:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv/more_help"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_more_help:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    move-result-object v0

    return-object v0
.end method

.method private getAppstoreItem(Landroid/content/Context;)Lcom/amazon/mShop/gno/GNODrawerItem;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 476
    const-string/jumbo v0, "mshop:appstore"

    invoke-static {p1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_gateway:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v1}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    new-instance v1, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$11;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$11;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/recommended"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_recommended:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_recommended:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/new_releases"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_new_releases:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_new_releases:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/best_sellers"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_best_sellers:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_best_sellers:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/coins"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_coins:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_coins:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    new-instance v2, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$10;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$10;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;)V

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/categories"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_categories:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/games"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_games:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_games:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/entertainment"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_entertainment:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_entertainment:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/all_categories"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_all_categories:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_all_categories:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/library"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_library:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/your_applications"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_your_applications:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_your_apps:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/subscriptions"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_manage_subscriptions:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_subscriptions:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/more"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_more:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/settings"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_settings:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_settings:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    const-string/jumbo v1, "mshop:appstore/help"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_appstore_help:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/navigation/AppNavigator$Target;->mas_help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;

    move-result-object v0

    return-object v0
.end method

.method private navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    .locals 1
    .param p1, "target"    # Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .prologue
    .line 563
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v0

    return-object v0
.end method

.method private navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    .locals 1
    .param p1, "target"    # Lcom/amazon/mShop/navigation/AppNavigator$Target;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/navigation/AppNavigator$Target;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;)",
            "Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;"
        }
    .end annotation

    .prologue
    .line 614
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    new-instance v0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$14;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$14;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    return-object v0
.end method

.method private navigateToAIVUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "stringId"    # I

    .prologue
    .line 590
    new-instance v0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$13;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$13;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;Landroid/content/Context;I)V

    return-object v0
.end method

.method private navigateToUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "stringId"    # I

    .prologue
    .line 567
    new-instance v0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$12;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$12;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;Landroid/content/Context;I)V

    return-object v0
.end method


# virtual methods
.method public buildDefaultMenuItems(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 117
    new-instance v1, Ljava/util/LinkedHashMap;

    invoke-direct {v1}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    .line 120
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:home"

    const-string/jumbo v3, "mshop:home"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->home:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-string/jumbo v4, "gno_hm"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->home:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 128
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:your_recently_viewed_items_post_5_0"

    const-string/jumbo v3, "mshop:your_recently_viewed_items_post_5_0"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->history_title:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-string/jumbo v4, "gno_rvi"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_recently_viewed_items:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 136
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v3, "mshop:shop_by_department"

    const-string/jumbo v1, "mshop:shop_by_department"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSBD;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;

    move-result-object v1

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->shop_by_department_text:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;

    const-string/jumbo v4, "gno_br"

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->shop_by_department:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSBD;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 144
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:aiv"

    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->getAIVItem(Landroid/content/Context;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 147
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:appstore"

    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->getAppstoreItem(Landroid/content/Context;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 150
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v3, "mshop:deals"

    const-string/jumbo v1, "mshop:deals"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->goldbox:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    const-string/jumbo v4, "gno_deal"

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->deals:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    new-instance v4, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$1;

    invoke-direct {v4, p0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$1;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;Landroid/content/Context;)V

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 164
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v3, "mshop:gift_cards"

    const-string/jumbo v1, "mshop:gift_cards"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->more_email_gift_card:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    const-string/jumbo v4, "gno_gc"

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->gift_cards:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    new-instance v4, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$2;

    invoke-direct {v4, p0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$2;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;Landroid/content/Context;)V

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 180
    new-instance v0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$3;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$3;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;)V

    .line 187
    .local v0, "smileFeatureCallable":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<Ljava/lang/Boolean;>;"
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v3, "mshop:your_charity_header"

    const-string/jumbo v1, "mshop:your_charity_header"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;

    move-result-object v1

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->your_charity:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 194
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:your_charity"

    new-instance v3, Lcom/amazon/mShop/gno/GNODrawerItemCharity;

    const-string/jumbo v4, "mshop:your_charity"

    invoke-direct {v3, p1, v4, v0}, Lcom/amazon/mShop/gno/GNODrawerItemCharity;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/concurrent/Callable;)V

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 200
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v3, "mshop:your_account_sub_header"

    const-string/jumbo v1, "mshop:your_account_sub_header"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v1

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->youraccount:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 206
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:your_wish_list"

    const-string/jumbo v3, "mshop:your_wish_list"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->wishlist_default_title:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-string/jumbo v4, "gno_wl"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_wish_list:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 214
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:your_orders"

    const-string/jumbo v3, "mshop:your_orders"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->youraccount_your_orders:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-string/jumbo v4, "gno_yo"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_orders:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:your_account"

    const-string/jumbo v3, "mshop:your_account"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->youraccount:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-string/jumbo v4, "gno_ta"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_account:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 229
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:your_recommendations"

    const-string/jumbo v3, "mshop:your_recommendations"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->recommendations_title:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-string/jumbo v4, "gno_recs"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_recommendations:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 236
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v3, "mshop:your_subscribe_and_save"

    const-string/jumbo v1, "mshop:your_subscribe_and_save"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->menu_more_mys_description:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    const-string/jumbo v4, "gno_sns"

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->your_subscribe_and_save:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    new-instance v4, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$4;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$4;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;)V

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 250
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v3, "mshop:cloud_drive"

    const-string/jumbo v1, "mshop:cloud_drive"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->ya_backup_your_photos:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    const-string/jumbo v4, "gno_cd"

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->back_up_your_photos:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    new-instance v4, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$5;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$5;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;)V

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 264
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v3, "mshop:more_sub_header"

    const-string/jumbo v1, "mshop:more_sub_header"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v1

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->more:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 270
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:change_country"

    const-string/jumbo v3, "mshop:change_country"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->amazon_store:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-string/jumbo v4, "gno_cc"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_flag:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withSubView(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->change_country:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 279
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v3, "mshop:notifications"

    const-string/jumbo v1, "mshop:notifications"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->notification_setting:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    const-string/jumbo v4, "gno_notify"

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->notifications:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    new-instance v4, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$6;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$6;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;)V

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 293
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:contact_us"

    const-string/jumbo v3, "mshop:contact_us"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->contact_us_title:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-string/jumbo v4, "gno_cu"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->contact_us:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 303
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:legal_with_aiv"

    const-string/jumbo v3, "mshop:legal_with_aiv"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->legal_info_text:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-string/jumbo v4, "gno_legal"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->legal_info_url_android_with_aiv:I

    invoke-direct {p0, p1, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateToUrlOnClick(Landroid/content/Context;I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 311
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:help"

    const-string/jumbo v3, "mshop:help"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->help_and_about_title:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-string/jumbo v4, "gno_help"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->help:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 319
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "mshop:authentication"

    new-instance v3, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;

    invoke-direct {v3, p1}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;-><init>(Landroid/content/Context;)V

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 322
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v3, "mshop:exit"

    const-string/jumbo v1, "mshop:exit"

    invoke-static {p1, v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->exit:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    const-string/jumbo v4, "gno_exit"

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    sget-object v4, Lcom/amazon/mShop/navigation/AppNavigator$Target;->exit:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    new-instance v4, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$7;

    invoke-direct {v4, p0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$7;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;Landroid/content/Context;)V

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withIsHiddenCallable(Ljava/util/concurrent/Callable;)Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 334
    return-void
.end method

.method public getItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 624
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItem;

    return-object v0
.end method

.method public getItems()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 629
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->mMenuItems:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method
