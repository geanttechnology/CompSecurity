.class public Lcom/amazon/mShop/details/AmazonKindleProxy;
.super Lcom/amazon/mShop/details/FriendAppProxy;
.source "AmazonKindleProxy.java"


# static fields
.field private static final instance:Lcom/amazon/mShop/details/AmazonKindleProxy;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    new-instance v0, Lcom/amazon/mShop/details/AmazonKindleProxy;

    invoke-direct {v0}, Lcom/amazon/mShop/details/AmazonKindleProxy;-><init>()V

    sput-object v0, Lcom/amazon/mShop/details/AmazonKindleProxy;->instance:Lcom/amazon/mShop/details/AmazonKindleProxy;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/details/FriendAppProxy;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/details/AmazonKindleProxy;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/amazon/mShop/details/AmazonKindleProxy;->instance:Lcom/amazon/mShop/details/AmazonKindleProxy;

    return-object v0
.end method


# virtual methods
.method public getButtonLabel(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 74
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/AmazonKindleProxy;->isFriendAppInstalled(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 75
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/AmazonKindleProxy;->needFriendAppUpdate(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 76
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->buy_box_update_amazon_kindle_to_buy:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 81
    :goto_0
    return-object v0

    .line 78
    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->buy_box_buy_now_from_amazon_kindle:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 81
    :cond_1
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->buy_box_install_amazon_kindle_to_buy:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected getIntentForInstall(Landroid/content/Context;)Landroid/content/Intent;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 160
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "zh_CN"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 161
    invoke-super {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->getIntentForInstall(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v1

    .line 164
    :goto_0
    return-object v1

    .line 163
    :cond_0
    const-string/jumbo v0, "https://www.amazon.cn/gp/aw/feature/id=cn_app_download"

    .line 164
    .local v0, "uriString":Ljava/lang/String;
    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    const-string/jumbo v3, "https://www.amazon.cn/gp/aw/feature/id=cn_app_download"

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    goto :goto_0
.end method

.method protected getIntentForStart(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)Landroid/content/Intent;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "product"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 42
    invoke-virtual {p2}, Lcom/amazon/mShop/control/item/ProductController;->getGroupId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/mShop/details/AmazonKindleProxy;->getIntentForStart(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method protected getIntentForStart(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 48
    const/4 v0, 0x0

    return-object v0
.end method

.method public getIntentForStart(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "groupId"    # Ljava/lang/String;
    .param p3, "asin"    # Ljava/lang/String;

    .prologue
    .line 53
    const-string/jumbo v2, "ebooks_display_on_website"

    invoke-virtual {v2, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string/jumbo v1, "kindle://store/openstore/asin/?asin=%s"

    .line 54
    .local v1, "url":Ljava/lang/String;
    :goto_0
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p3, v3, v4

    invoke-static {v1, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 55
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/details/AmazonKindleProxy;->addRefTag(Landroid/content/Context;Landroid/content/Intent;)V

    .line 56
    return-object v0

    .line 53
    .end local v0    # "intent":Landroid/content/Intent;
    .end local v1    # "url":Ljava/lang/String;
    :cond_0
    const-string/jumbo v1, "kindle://store/openstore/?asin=%s&storefront-context=periodicals"

    goto :goto_0
.end method

.method protected getPackageName(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 37
    const-string/jumbo v0, "com.amazon.kindle"

    return-object v0
.end method

.method protected getRefTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    const-string/jumbo v0, "kindle"

    return-object v0
.end method

.method protected needFriendAppUpdate(Landroid/content/Context;)Z
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 62
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 64
    .local v0, "manager":Landroid/content/pm/PackageManager;
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/AmazonKindleProxy;->getPackageName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v0, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 65
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget v4, v1, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    if-ge v4, v2, :cond_0

    .line 69
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_0
    return v2

    .restart local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    move v2, v3

    .line 65
    goto :goto_0

    .line 66
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v3

    goto :goto_0
.end method
