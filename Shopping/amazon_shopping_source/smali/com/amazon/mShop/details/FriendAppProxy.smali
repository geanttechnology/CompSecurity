.class public abstract Lcom/amazon/mShop/details/FriendAppProxy;
.super Ljava/lang/Object;
.source "FriendAppProxy.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/details/FriendAppProxy$Factory;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    return-void
.end method

.method protected static isAmazonAppstoreDownloadUrl(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 363
    const-string/jumbo v1, "/gp/mas/get-appstore/android"

    .line 364
    .local v1, "oldAppstoreUriPath":Ljava/lang/String;
    const-string/jumbo v0, "/gp/mas/get/android"

    .line 365
    .local v0, "newAppstoreUriPath":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 366
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 367
    .local v2, "urlPath":Ljava/lang/String;
    if-eqz v2, :cond_1

    invoke-virtual {v2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {v2, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 370
    :cond_0
    const/4 v3, 0x1

    .line 374
    .end local v2    # "urlPath":Ljava/lang/String;
    :goto_0
    return v3

    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method

.method protected static isAmazonMp3DownloadUrl(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 343
    const-string/jumbo v0, "/gp/dmusic/device/android/buy.html"

    .line 344
    .local v0, "mp3UrlPath":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 345
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    .line 346
    .local v1, "urlPath":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-virtual {v1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 348
    const/4 v2, 0x1

    .line 351
    .end local v1    # "urlPath":Ljava/lang/String;
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected addRefTag(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 233
    const-string/jumbo v0, "ref"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "mShopAndroidApp"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p1}, Lcom/amazon/mShop/util/BuildUtils;->getVersionName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 234
    return-void
.end method

.method public abstract getButtonLabel(Landroid/content/Context;)Ljava/lang/String;
.end method

.method protected getIntentForFriendApp(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)Landroid/content/Intent;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "product"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 121
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->isAbleToStartFriendApp(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 123
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/details/FriendAppProxy;->getIntentForStart(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)Landroid/content/Intent;

    move-result-object v0

    .line 133
    .local v0, "intent":Landroid/content/Intent;
    :goto_0
    if-eqz v0, :cond_0

    .line 134
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 135
    :cond_0
    return-object v0

    .line 126
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->getIntentForInstall(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .restart local v0    # "intent":Landroid/content/Intent;
    goto :goto_0
.end method

.method public getIntentForFriendApp(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 176
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->isAbleToStartFriendApp(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 178
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/details/FriendAppProxy;->getIntentForStart(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 188
    .local v0, "intent":Landroid/content/Intent;
    :goto_0
    if-eqz v0, :cond_0

    .line 189
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 190
    :cond_0
    return-object v0

    .line 181
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->getIntentForInstall(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .restart local v0    # "intent":Landroid/content/Intent;
    goto :goto_0
.end method

.method protected getIntentForInstall(Landroid/content/Context;)Landroid/content/Intent;
    .locals 12
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 288
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->amazon_appstore_package_name:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 289
    .local v1, "appStoreName":Ljava/lang/String;
    invoke-virtual {p0, p1, v1}, Lcom/amazon/mShop/details/FriendAppProxy;->isAppInstalled(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 290
    const-string/jumbo v8, "amzn://apps/android?p=%s"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->getPackageName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 291
    .local v2, "appUrl":Ljava/lang/String;
    new-instance v3, Landroid/content/Intent;

    const-string/jumbo v8, "android.intent.action.VIEW"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v9

    invoke-direct {v3, v8, v9}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 292
    .local v3, "intent":Landroid/content/Intent;
    invoke-virtual {v3, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 294
    invoke-virtual {p0, p1, v3}, Lcom/amazon/mShop/details/FriendAppProxy;->addRefTag(Landroid/content/Context;Landroid/content/Intent;)V

    .end local v2    # "appUrl":Ljava/lang/String;
    :goto_0
    move-object v4, v3

    .line 311
    .end local v3    # "intent":Landroid/content/Intent;
    .local v4, "intent":Ljava/lang/Object;
    :goto_1
    return-object v4

    .line 296
    .end local v4    # "intent":Ljava/lang/Object;
    :cond_0
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "market://search?q=pname:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->getPackageName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 297
    .local v7, "uriString":Ljava/lang/String;
    new-instance v3, Landroid/content/Intent;

    const-string/jumbo v8, "android.intent.action.VIEW"

    invoke-static {v7}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v9

    invoke-direct {v3, v8, v9}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 298
    .restart local v3    # "intent":Landroid/content/Intent;
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 299
    .local v6, "manager":Landroid/content/pm/PackageManager;
    const/high16 v8, 0x10000

    invoke-virtual {v6, v3, v8}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 300
    .local v0, "activities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v8

    if-lez v8, :cond_1

    move-object v4, v3

    .line 303
    .restart local v4    # "intent":Ljava/lang/Object;
    goto :goto_1

    .line 307
    .end local v4    # "intent":Ljava/lang/Object;
    :cond_1
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->amazon_appstore_landing_page_url:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 308
    .local v5, "landingPage":Ljava/lang/String;
    new-instance v3, Landroid/content/Intent;

    .end local v3    # "intent":Landroid/content/Intent;
    const-string/jumbo v8, "android.intent.action.VIEW"

    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v9

    invoke-direct {v3, v8, v9}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .restart local v3    # "intent":Landroid/content/Intent;
    goto :goto_0
.end method

.method protected abstract getIntentForStart(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)Landroid/content/Intent;
.end method

.method protected abstract getIntentForStart(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
.end method

.method protected abstract getPackageName(Landroid/content/Context;)Ljava/lang/String;
.end method

.method protected abstract getRefTag()Ljava/lang/String;
.end method

.method public getRefTagForFriendApp(Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 196
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->isAbleToStartFriendApp(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 198
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "b_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/details/FriendAppProxy;->getRefTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 204
    .local v0, "refTag":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 201
    .end local v0    # "refTag":Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "i_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/details/FriendAppProxy;->getRefTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "refTag":Ljava/lang/String;
    goto :goto_0
.end method

.method public isAbleToStartFriendApp(Landroid/content/Context;)Z
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 215
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->isFriendAppInstalled(Landroid/content/Context;)Z

    move-result v2

    if-eq v2, v1, :cond_1

    .line 223
    :cond_0
    :goto_0
    return v0

    .line 218
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->needFriendAppUpdate(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_0

    move v0, v1

    .line 223
    goto :goto_0
.end method

.method protected isAppInstalled(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "packageName"    # Ljava/lang/String;

    .prologue
    .line 106
    invoke-static {p1, p2}, Lcom/amazon/mShop/util/AppUtils;->isAppInstalled(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method protected isFriendAppInstalled(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 97
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->getPackageName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/amazon/mShop/util/AppUtils;->isAppInstalled(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method protected abstract needFriendAppUpdate(Landroid/content/Context;)Z
.end method
