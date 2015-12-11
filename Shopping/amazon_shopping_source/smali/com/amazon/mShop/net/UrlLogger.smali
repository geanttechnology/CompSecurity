.class public Lcom/amazon/mShop/net/UrlLogger;
.super Ljava/lang/Object;
.source "UrlLogger.java"


# static fields
.field private static sPrefix:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getBaseUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 14
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->config_mobile_serviceURL:I

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "/tag"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getRefTagPrefix()Ljava/lang/String;
    .locals 2

    .prologue
    .line 30
    sget-object v0, Lcom/amazon/mShop/net/UrlLogger;->sPrefix:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 31
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_refTagPrefix:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForApp(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/net/UrlLogger;->sPrefix:Ljava/lang/String;

    .line 34
    :cond_0
    sget-object v0, Lcom/amazon/mShop/net/UrlLogger;->sPrefix:Ljava/lang/String;

    return-object v0
.end method

.method public static logRefTag(Ljava/lang/String;)V
    .locals 3
    .param p0, "refTag"    # Ljava/lang/String;

    .prologue
    .line 48
    invoke-static {}, Lcom/amazon/mShop/net/UrlLogger;->getRefTagPrefix()Ljava/lang/String;

    move-result-object v0

    .line 49
    .local v0, "prefix":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 54
    :goto_0
    return-void

    .line 53
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "/ref="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/net/UrlLogger;->logURL(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static logURL(Ljava/lang/String;)V
    .locals 2
    .param p0, "argument"    # Ljava/lang/String;

    .prologue
    .line 66
    invoke-static {}, Lcom/amazon/mShop/net/UrlLogger;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    .line 67
    .local v0, "baseUrl":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 71
    :goto_0
    return-void

    .line 70
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/net/HttpFetcher;->fetch(Ljava/lang/String;)V

    goto :goto_0
.end method
