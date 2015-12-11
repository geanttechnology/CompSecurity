.class public Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;
.super Lcom/amazon/mShop/gno/GNOMenuItemProvider;
.source "GNOMenuItemProviderDebug.java"


# instance fields
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
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNOMenuItemProvider;-><init>()V

    .line 29
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->buildItems(Landroid/content/Context;)V

    .line 30
    return-void
.end method

.method private buildItems(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 59
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->mMenuItems:Ljava/util/Map;

    .line 61
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 63
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->mMenuItems:Ljava/util/Map;

    const-string/jumbo v2, "android:debug"

    const-string/jumbo v0, "android:debug"

    invoke-static {p1, v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->debug_title:I

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    const-class v3, Lcom/amazon/mShop/debug/DebugSettingsActivity;

    invoke-static {v3}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->startActivity(Ljava/lang/Class;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    const-string/jumbo v3, "android:debug/ads_debug"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_mobile_ads_title:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-class v4, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;

    invoke-static {v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->startActivity(Ljava/lang/Class;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v3, "android:debug/amazon_web_debug"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->menu_more_html_debug_settings:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-class v4, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    invoke-static {v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->startActivity(Ljava/lang/Class;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v3, "android:debug/weblab_overrides"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->menu_more_set_weblab:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$3;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$3;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;)V

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v3, "android:debug/gno_debug"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_gno_settings:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-class v4, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;

    invoke-static {v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->startActivity(Ljava/lang/Class;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v3, "android:debug/sso_debug"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->sso_debug_settings_title:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-class v4, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;

    invoke-static {v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->startActivity(Ljava/lang/Class;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v3, "android:debug/appstore_debug"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-string/jumbo v4, "MAS Debug"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$2;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$2;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;)V

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v3, "android:debug/search_debug"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->search_debug_menu_title:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-class v4, Lcom/amazon/mShop/search/SearchDebugSettingsActivity;

    invoke-static {v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->startActivity(Ljava/lang/Class;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    const-string/jumbo v3, "android:debug/kiang_debug"

    invoke-static {p1, v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_kiang_settings:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    const-class v4, Lcom/amazon/mShop/kiang/KiangDebugSettingsActivity;

    invoke-static {v4}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->startActivity(Ljava/lang/Class;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 120
    :cond_0
    return-void
.end method

.method private static startActivity(Ljava/lang/Class;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;"
        }
    .end annotation

    .prologue
    .line 49
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$1;-><init>(Ljava/lang/Class;)V

    return-object v0
.end method


# virtual methods
.method public getItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->mMenuItems:Ljava/util/Map;

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
    .line 39
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->mMenuItems:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method
