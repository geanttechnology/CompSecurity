.class public Lcom/amazon/mShop/aiv/AIVMShopWebActivity;
.super Lcom/amazon/mShop/web/MShopWebActivity;
.source "AIVMShopWebActivity.java"

# interfaces
.implements Lcom/amazon/mShop/search/ScopedSearch;


# static fields
.field private static final AIV_MSHOP_WEB_ACTIVITY_CLASS:Ljava/lang/String;

.field private static final AIV_SEARCH_ALIAS:Ljava/lang/String; = "instant-video"

.field public static final CALLING_CLASS_NAME:Ljava/lang/String; = "CallingClassName"

.field public static final FORCE_CLEAR_HISTORY:Ljava/lang/String; = "ForceClearHistory"

.field private static final SEARCH_BASE_URL:Ljava/lang/String; = "/s?ref=MshopAivContextSearch&i=instant-video"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/amazon/mShop/aiv/AIVMShopWebActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/aiv/AIVMShopWebActivity;->AIV_MSHOP_WEB_ACTIVITY_CLASS:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public beginForwardTransition(Ljava/lang/String;)V
    .locals 2
    .param p1, "requestUrl"    # Ljava/lang/String;

    .prologue
    .line 60
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVMShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 61
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopWebActivity;->beginForwardTransition(Ljava/lang/String;)V

    .line 62
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVMShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 63
    return-void
.end method

.method public getCategoryMetadata()Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;
    .locals 4

    .prologue
    .line 67
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVMShopWebActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 68
    .local v0, "aivText":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;

    const-string/jumbo v2, "/s?ref=MshopAivContextSearch&i=instant-video"

    const-string/jumbo v3, "instant-video"

    invoke-direct {v1, v0, v2, v3}, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v1
.end method

.method public getCurrentDepartmentDepth()I
    .locals 1

    .prologue
    .line 73
    const/4 v0, 0x1

    return v0
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x0

    .line 32
    const-string/jumbo v3, "ForceClearHistory"

    invoke-virtual {p1, v3, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    .line 33
    .local v1, "forceClearHistory":Z
    const-string/jumbo v3, "CallingClassName"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 39
    .local v0, "callingClass":Ljava/lang/String;
    const-string/jumbo v3, "KeepHistoryStack"

    if-nez v1, :cond_0

    sget-object v4, Lcom/amazon/mShop/aiv/AIVMShopWebActivity;->AIV_MSHOP_WEB_ACTIVITY_CLASS:Ljava/lang/String;

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    const/4 v2, 0x1

    :cond_0
    invoke-virtual {p1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 40
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopWebActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 41
    return-void
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 45
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->onResume()V

    .line 50
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVMShopWebActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawer;->focusOn(Ljava/lang/String;)Z

    .line 51
    return-void
.end method
