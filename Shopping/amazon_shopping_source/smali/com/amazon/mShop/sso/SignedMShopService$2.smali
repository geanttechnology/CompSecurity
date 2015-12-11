.class Lcom/amazon/mShop/sso/SignedMShopService$2;
.super Ljava/lang/Object;
.source "SignedMShopService.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/SignedMShopService;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getServerConnection()Lcom/amazon/rio/j2me/client/trans/IServiceConnection;
    .locals 2

    .prologue
    .line 33
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getSecureServiceUrl()Ljava/lang/String;

    move-result-object v0

    .line 34
    .local v0, "url":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/sso/SignedHttpServerConnection;

    invoke-direct {v1, v0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;-><init>(Ljava/lang/String;)V

    return-object v1
.end method
