.class public Lcom/amazon/mShop/mash/MShopMASHApplication;
.super Ljava/lang/Object;
.source "MShopMASHApplication.java"

# interfaces
.implements Lcom/amazon/mobile/mash/MASHApplication;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppCustomUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getUserAgent()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isDebugEnabled()Z
    .locals 1

    .prologue
    .line 22
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    return v0
.end method

.method public shouldInterceptUrls()Z
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x1

    return v0
.end method
