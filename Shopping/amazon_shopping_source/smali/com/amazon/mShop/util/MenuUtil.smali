.class public Lcom/amazon/mShop/util/MenuUtil;
.super Ljava/lang/Object;
.source "MenuUtil.java"


# static fields
.field private static final sRefMarkerMappings:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 45
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    .line 47
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_item_home:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "hm"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_item_search:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "sr"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_item_cart:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "crt_html"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_item_wishlist:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "wl_html"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_item_youraccount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "ya"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_item_more:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_deals:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_deal"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_email_gift_card:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_em_gc"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_recently_viewed_items:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_rvi"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_recommendations:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_recs"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_mys:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_sns"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_notification_setting:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_notify"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_change_country:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "cc"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 60
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_legal:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_legal"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_remembers:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_rem"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_get_amazon_android_apps:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_get_aaa"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_contact_us:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_cs"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_help:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_help"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    sget-object v0, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->menu_more_about:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "mr_about"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;
    .locals 6
    .param p0, "itemId"    # I
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "titleResourceId"    # I
    .param p3, "iconResourceId"    # I
    .param p4, "intent"    # Landroid/content/Intent;
    .param p5, "alphabeticShortcut"    # Ljava/lang/Character;
    .param p6, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 82
    invoke-virtual {p6}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    move v0, p0

    move-object v1, p1

    move v2, p2

    move-object v4, p4

    move-object v5, p5

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;ILandroid/graphics/drawable/Drawable;Landroid/content/Intent;Ljava/lang/Character;)Landroid/view/MenuItem;

    move-result-object v0

    return-object v0
.end method

.method private static addMenuItem(ILandroid/view/Menu;ILandroid/graphics/drawable/Drawable;Landroid/content/Intent;Ljava/lang/Character;)Landroid/view/MenuItem;
    .locals 2
    .param p0, "itemId"    # I
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "titleResourceId"    # I
    .param p3, "iconDrawable"    # Landroid/graphics/drawable/Drawable;
    .param p4, "intent"    # Landroid/content/Intent;
    .param p5, "alphabeticShortcut"    # Ljava/lang/Character;

    .prologue
    const/4 v1, 0x0

    .line 102
    invoke-interface {p1, v1, p0, v1, p2}, Landroid/view/Menu;->add(IIII)Landroid/view/MenuItem;

    move-result-object v0

    .line 103
    .local v0, "menuItem":Landroid/view/MenuItem;
    if-eqz p3, :cond_0

    .line 104
    invoke-interface {v0, p3}, Landroid/view/MenuItem;->setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;

    .line 107
    :cond_0
    if-eqz p4, :cond_1

    .line 108
    invoke-interface {v0, p4}, Landroid/view/MenuItem;->setIntent(Landroid/content/Intent;)Landroid/view/MenuItem;

    .line 111
    :cond_1
    if-eqz p5, :cond_2

    .line 112
    invoke-virtual {p5}, Ljava/lang/Character;->charValue()C

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setAlphabeticShortcut(C)Landroid/view/MenuItem;

    .line 115
    :cond_2
    instance-of v1, p1, Landroid/view/SubMenu;

    if-nez v1, :cond_3

    .line 116
    invoke-static {p2}, Lcom/amazon/mShop/util/MenuUtil;->getMenuItemTitle(I)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 119
    :cond_3
    return-object v0
.end method

.method private static getMenuItemTitle(I)Ljava/lang/CharSequence;
    .locals 7
    .param p0, "titleResourceId"    # I

    .prologue
    const/4 v6, 0x0

    .line 130
    if-lez p0, :cond_0

    .line 131
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 132
    .local v0, "res":Landroid/content/res/Resources;
    invoke-virtual {v0, p0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 133
    .local v2, "title":Ljava/lang/String;
    new-instance v1, Landroid/text/SpannableString;

    invoke-direct {v1, v2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 134
    .local v1, "ss":Landroid/text/SpannableString;
    new-instance v3, Landroid/text/style/AbsoluteSizeSpan;

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->menu_title_size:I

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    invoke-direct {v3, v4, v6}, Landroid/text/style/AbsoluteSizeSpan;-><init>(IZ)V

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    const/16 v5, 0x21

    invoke-virtual {v1, v3, v6, v4, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 138
    .end local v0    # "res":Landroid/content/res/Resources;
    .end local v1    # "ss":Landroid/text/SpannableString;
    .end local v2    # "title":Ljava/lang/String;
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static gotoEmailGiftCardPage(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 393
    const-string/jumbo v1, "amznapp://shopping"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 394
    .local v0, "uriBuilder":Landroid/net/Uri$Builder;
    const-string/jumbo v1, "app-action"

    const-string/jumbo v2, "webview"

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 395
    const-string/jumbo v1, "url"

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more_email_gift_card_url:I

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 396
    const-string/jumbo v1, "app-title"

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more_email_gift_card:I

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 397
    new-instance v1, Lcom/amazon/mShop/mash/nav/AmazonNavManager;

    invoke-direct {v1}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;-><init>()V

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, p0}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;->navigate(Ljava/lang/String;Landroid/content/Context;)Z

    .line 398
    return-void
.end method

.method public static gotoGetAmazonAnroidAppsPage(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 386
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->more_get_amazon_android_apps_url:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 387
    .local v1, "url":Ljava/lang/String;
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 388
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v2, 0x10000000

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 389
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 390
    return-void
.end method

.method public static gotoLegalInfoPage(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 5
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 378
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->legal_info_url_android_with_aiv:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 379
    .local v1, "url":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->legal_info_text:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 380
    .local v0, "title":Ljava/lang/String;
    new-instance v2, Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-direct {v2, p0, v1, v0}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 381
    .local v2, "view":Lcom/amazon/mShop/AmazonBrandedWebView;
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 382
    return-void
.end method

.method public static onCreateOptionsMenu(Landroid/view/Menu;Lcom/amazon/mShop/AmazonActivity;)Z
    .locals 13
    .param p0, "menu"    # Landroid/view/Menu;
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    const/4 v9, 0x0

    const/4 v12, -0x1

    const v8, 0x1080040

    const v7, 0x108003b

    const/4 v4, 0x0

    .line 144
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_item_home:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->home:I

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_home:I

    move-object v1, p0

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 147
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_item_search:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->search_menu_item:I

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_search:I

    const/16 v5, 0x73

    invoke-static {v5}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v5

    move-object v1, p0

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 150
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_item_cart:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->cart:I

    sget-object v3, Lcom/amazon/mShop/util/UIUtils;->CART_ICON_RES_ID_FOR_COUNT:[I

    sget v5, Lcom/amazon/mShop/util/UIUtils;->CART_ICON_RES_ID_FOR_COUNT_PLUS:I

    invoke-static {}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->getCurrentQuantity()I

    move-result v6

    invoke-static {p1, v3, v5, v6}, Lcom/amazon/mShop/util/UIUtils;->badgedIconForCount(Landroid/content/Context;[III)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    move-object v1, p0

    move-object v5, v4

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;ILandroid/graphics/drawable/Drawable;Landroid/content/Intent;Ljava/lang/Character;)Landroid/view/MenuItem;

    .line 154
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_item_wishlist:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more_wishlist_button:I

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_wish_list:I

    move-object v1, p0

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 157
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_item_youraccount:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more_your_account_button:I

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_your_account:I

    move-object v1, p0

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 164
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_item_more:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more:I

    invoke-static {v2}, Lcom/amazon/mShop/util/MenuUtil;->getMenuItemTitle(I)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {p0, v9, v0, v9, v2}, Landroid/view/Menu;->addSubMenu(IIILjava/lang/CharSequence;)Landroid/view/SubMenu;

    move-result-object v1

    .line 165
    .local v1, "submenu":Landroid/view/SubMenu;
    sget v0, Lcom/amazon/mShop/android/lib/R$drawable;->android_menu_more:I

    invoke-interface {v1, v0}, Landroid/view/SubMenu;->setIcon(I)Landroid/view/SubMenu;

    .line 168
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasGoldbox:I

    invoke-static {p1, v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_0

    .line 169
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_deals:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->goldbox:I

    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->goldbox_icon:I

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 173
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/smile/SmileHelper;->isSmile()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 174
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_your_charity:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->your_charity:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 175
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_charity_name:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->your_charity:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 179
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more_email_gift_card:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    invoke-virtual {p1}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more_email_gift_card_url:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 181
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_email_gift_card:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more_email_gift_card:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 185
    :cond_2
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_recently_viewed_items:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->history_title:I

    const v3, 0x1080045

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 188
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 189
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_notification_setting:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->notification_setting:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 193
    :cond_3
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_recommendations:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more_recommendations_button:I

    const v3, 0x1080045

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 196
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isHTMLSnSEnabled()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 197
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_mys:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->menu_more_mys_description:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 201
    :cond_4
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_change_country:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->amazon_store:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 204
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_legal:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->legal_info_text:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 207
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasMoreAmazonAppsMenu:I

    invoke-static {p1, v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 208
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_get_amazon_android_apps:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more_get_amazon_android_apps:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 212
    :cond_5
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_help:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more_help_button:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 215
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_contact_us:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->help_contact_us_title:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 218
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_about:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->more_about_button:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 221
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasExitApp:I

    invoke-static {p1, v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 222
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_exit_app:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->exit:I

    move v3, v7

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 225
    :cond_6
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 227
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_mash_api_test:I

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->mash_api_test:I

    const-class v0, Lcom/amazon/mShop/mash/AmazonMASHTestActivity;

    invoke-static {p1, v0, v12}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v9

    move-object v6, v1

    move-object v10, v4

    move-object v11, p1

    invoke-static/range {v5 .. v11}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 234
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_debug:I

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->debug_title:I

    const-class v0, Lcom/amazon/mShop/debug/DebugSettingsActivity;

    invoke-static {p1, v0, v12}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v9

    move-object v6, v1

    move-object v10, v4

    move-object v11, p1

    invoke-static/range {v5 .. v11}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 237
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_debug_mobile_ads:I

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->debug_mobile_ads_title:I

    const-class v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;

    invoke-static {p1, v0, v12}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v9

    move-object v6, v1

    move-object v10, v4

    move-object v11, p1

    invoke-static/range {v5 .. v11}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 240
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_html_debug_settings:I

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->menu_more_html_debug_settings:I

    const-class v0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    invoke-static {p1, v0, v12}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v9

    move-object v6, v1

    move-object v10, v4

    move-object v11, p1

    invoke-static/range {v5 .. v11}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 243
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->menu_more_set_weblab:I

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->menu_more_set_weblab:I

    move v3, v8

    move-object v5, v4

    move-object v6, p1

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 245
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_gno_debug_settings:I

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->debug_gno_settings:I

    const-class v0, Lcom/amazon/mShop/gno/GNODebugSettingsActivity;

    invoke-static {p1, v0, v12}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v9

    move-object v6, v1

    move-object v10, v4

    move-object v11, p1

    invoke-static/range {v5 .. v11}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 248
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_sso_debug_settings:I

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->sso_debug_settings_title:I

    const-class v0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;

    invoke-static {p1, v0, v12}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v9

    move-object v6, v1

    move-object v10, v4

    move-object v11, p1

    invoke-static/range {v5 .. v11}, Lcom/amazon/mShop/util/MenuUtil;->addMenuItem(ILandroid/view/Menu;IILandroid/content/Intent;Ljava/lang/Character;Lcom/amazon/mShop/AmazonActivity;)Landroid/view/MenuItem;

    .line 252
    :cond_7
    const/4 v0, 0x1

    return v0
.end method

.method public static onOptionsItemSelected(Landroid/view/MenuItem;Lcom/amazon/mShop/AmazonActivity;)Z
    .locals 8
    .param p0, "item"    # Landroid/view/MenuItem;
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    const/4 v4, 0x0

    const/4 v7, 0x0

    const/4 v3, 0x1

    .line 273
    invoke-interface {p0}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 275
    .local v0, "itemId":I
    sget-object v5, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 276
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_item_cart:I

    if-ne v5, v0, :cond_1

    .line 277
    const-string/jumbo v5, "crt_html"

    invoke-static {v5}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 285
    :cond_0
    :goto_0
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_item_home:I

    if-ne v0, v5, :cond_2

    .line 286
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    move-result v3

    .line 372
    :goto_1
    return v3

    .line 279
    :cond_1
    sget-object v5, Lcom/amazon/mShop/util/MenuUtil;->sRefMarkerMappings:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 280
    .local v1, "refMarker":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0

    .line 288
    .end local v1    # "refMarker":Ljava/lang/String;
    :cond_2
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_item_search:I

    if-ne v0, v5, :cond_3

    .line 289
    new-instance v4, Lcom/amazon/mShop/search/SearchIntentBuilder;

    invoke-direct {v4, p1}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v4, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->showSearchEntryView(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->selectInitialQuery(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/search/SearchIntentBuilder;->clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v2

    .line 294
    .local v2, "searchIntent":Landroid/content/Intent;
    invoke-static {p1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z

    move-result v3

    goto :goto_1

    .line 296
    .end local v2    # "searchIntent":Landroid/content/Intent;
    :cond_3
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_item_cart:I

    if-ne v0, v5, :cond_4

    .line 297
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->startCartActivity(Landroid/content/Context;)Z

    move-result v3

    goto :goto_1

    .line 300
    :cond_4
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_item_wishlist:I

    if-ne v0, v5, :cond_5

    .line 301
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->startWishListActivity(Landroid/content/Context;)Z

    move-result v3

    goto :goto_1

    .line 304
    :cond_5
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_item_youraccount:I

    if-ne v0, v5, :cond_6

    .line 305
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->startYourAccountActivity(Landroid/content/Context;)Z

    move-result v3

    goto :goto_1

    .line 309
    :cond_6
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_deals:I

    if-ne v0, v5, :cond_7

    .line 310
    invoke-static {p1, v7, v7}, Lcom/amazon/mShop/util/ActivityUtils;->startDealsActivity(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;)Z

    move-result v3

    goto :goto_1

    .line 313
    :cond_7
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_email_gift_card:I

    if-ne v0, v5, :cond_8

    .line 314
    invoke-static {p1}, Lcom/amazon/mShop/util/MenuUtil;->gotoEmailGiftCardPage(Landroid/content/Context;)V

    goto :goto_1

    .line 318
    :cond_8
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_recently_viewed_items:I

    if-ne v0, v5, :cond_9

    .line 319
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->startRecentlyViewedItemsActivity(Landroid/content/Context;)Z

    move-result v3

    goto :goto_1

    .line 322
    :cond_9
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_notification_setting:I

    if-ne v0, v5, :cond_a

    .line 323
    invoke-static {p1, v7}, Lcom/amazon/mShop/util/ActivityUtils;->startNotificationSettingActivity(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v3

    goto :goto_1

    .line 326
    :cond_a
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_recommendations:I

    if-ne v0, v5, :cond_b

    .line 327
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->startRecommendationsActivity(Landroid/content/Context;)Z

    move-result v3

    goto :goto_1

    .line 330
    :cond_b
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_mys:I

    if-ne v0, v5, :cond_c

    .line 331
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->startSnsManageYourSubscribesActivity(Landroid/content/Context;)Z

    move-result v3

    goto/16 :goto_1

    .line 334
    :cond_c
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_change_country:I

    if-ne v0, v5, :cond_d

    .line 335
    new-array v3, v4, [I

    invoke-static {p1, v3}, Lcom/amazon/mShop/util/ActivityUtils;->startLocaleSwitchActivity(Landroid/content/Context;[I)Z

    move-result v3

    goto/16 :goto_1

    .line 338
    :cond_d
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_legal:I

    if-ne v0, v5, :cond_e

    .line 339
    invoke-static {p1}, Lcom/amazon/mShop/util/MenuUtil;->gotoLegalInfoPage(Lcom/amazon/mShop/AmazonActivity;)V

    goto/16 :goto_1

    .line 343
    :cond_e
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_get_amazon_android_apps:I

    if-ne v0, v5, :cond_f

    .line 344
    invoke-static {p1}, Lcom/amazon/mShop/util/MenuUtil;->gotoGetAmazonAnroidAppsPage(Landroid/content/Context;)V

    goto/16 :goto_1

    .line 348
    :cond_f
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_help:I

    if-ne v0, v5, :cond_10

    .line 349
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->startHelpActivity(Landroid/content/Context;)Z

    move-result v3

    goto/16 :goto_1

    .line 352
    :cond_10
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_contact_us:I

    if-ne v0, v5, :cond_11

    .line 353
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->startContactUsActivity(Landroid/content/Context;)Z

    move-result v3

    goto/16 :goto_1

    .line 356
    :cond_11
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_about:I

    if-ne v0, v5, :cond_12

    .line 357
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->startAboutActivity(Landroid/content/Context;)Z

    move-result v3

    goto/16 :goto_1

    .line 360
    :cond_12
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_set_weblab:I

    if-ne v0, v5, :cond_13

    .line 361
    invoke-static {p1}, Lcom/amazon/mShop/util/DebugUtil;->overrideWeblabAssignment(Landroid/content/Context;)V

    goto/16 :goto_1

    .line 365
    :cond_13
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->menu_more_exit_app:I

    if-ne v0, v5, :cond_14

    .line 366
    const-string/jumbo v4, "mr_exit_ok"

    const-string/jumbo v5, "mr_exit_cancel"

    invoke-static {p1, v4, v5}, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper;->create(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    goto/16 :goto_1

    :cond_14
    move v3, v4

    .line 372
    goto/16 :goto_1
.end method

.method public static provideFeedBack(Landroid/content/Context;)V
    .locals 10
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 403
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/mShop/platform/AppLocale;->getDefaultLocale()Ljava/lang/String;

    move-result-object v2

    .line 404
    .local v2, "defaultLocale":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->provide_feedback_to_address_android:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 406
    .local v3, "feedBackTo":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->getVersionName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    .line 407
    .local v6, "versionNumber":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->about_version:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 408
    .local v0, "aboutVersionFormat":Ljava/lang/String;
    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v6, v7, v8

    invoke-static {v0, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 410
    .local v1, "aboutVersionString":Ljava/lang/String;
    sget v7, Lcom/amazon/mShop/android/lib/R$string;->config_marketplace_id:I

    invoke-static {p0, v7, v2}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 411
    .local v4, "marketPlaceId":Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->provide_feedback_subject_android:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, "("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, " - "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 412
    .local v5, "subject":Ljava/lang/String;
    const/4 v7, 0x0

    invoke-static {p0, v3, v5, v7}, Lcom/amazon/mShop/util/EmailUtils;->composeEmail(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 413
    return-void
.end method
