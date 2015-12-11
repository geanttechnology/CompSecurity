.class public Lcom/amazon/mShop/details/AmazonVideoProxy;
.super Lcom/amazon/mShop/details/FriendAppProxy;
.source "AmazonVideoProxy.java"


# static fields
.field private static final instance:Lcom/amazon/mShop/details/AmazonVideoProxy;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    new-instance v0, Lcom/amazon/mShop/details/AmazonVideoProxy;

    invoke-direct {v0}, Lcom/amazon/mShop/details/AmazonVideoProxy;-><init>()V

    sput-object v0, Lcom/amazon/mShop/details/AmazonVideoProxy;->instance:Lcom/amazon/mShop/details/AmazonVideoProxy;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/amazon/mShop/details/FriendAppProxy;-><init>()V

    .line 16
    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/details/AmazonVideoProxy;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/amazon/mShop/details/AmazonVideoProxy;->instance:Lcom/amazon/mShop/details/AmazonVideoProxy;

    return-object v0
.end method


# virtual methods
.method public getButtonLabel(Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 57
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/AmazonVideoProxy;->isFriendAppInstalled(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 58
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/AmazonVideoProxy;->needFriendAppUpdate(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 59
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->buy_box_update_amazon_video_to_buy:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 66
    .local v0, "text":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 61
    .end local v0    # "text":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->buy_box_buy_now_from_amazon_video:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "text":Ljava/lang/String;
    goto :goto_0

    .line 64
    .end local v0    # "text":Ljava/lang/String;
    :cond_1
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->buy_box_install_amazon_video_to_buy:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "text":Ljava/lang/String;
    goto :goto_0
.end method

.method protected getIntentForStart(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)Landroid/content/Intent;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "product"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 29
    const/4 v0, 0x0

    invoke-virtual {p2}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/mShop/details/AmazonVideoProxy;->getIntentForStart(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method protected getIntentForStart(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 35
    const/4 v0, 0x0

    return-object v0
.end method

.method public getIntentForStart(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "groupId"    # Ljava/lang/String;
    .param p3, "asin"    # Ljava/lang/String;

    .prologue
    .line 40
    const-string/jumbo v2, "content://com.amazon.avod.detail"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 41
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 42
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v2, "asin"

    invoke-virtual {v0, v2, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 43
    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/details/AmazonVideoProxy;->addRefTag(Landroid/content/Context;Landroid/content/Intent;)V

    .line 45
    return-object v0
.end method

.method protected getPackageName(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    const-string/jumbo v0, "com.amazon.avod"

    return-object v0
.end method

.method protected getRefTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    const-string/jumbo v0, "aiv"

    return-object v0
.end method

.method protected needFriendAppUpdate(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 51
    const/4 v0, 0x0

    return v0
.end method
