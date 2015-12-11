.class Lcom/amazon/mShop/platform/AndroidPlatform$2;
.super Ljava/lang/Object;
.source "AndroidPlatform.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/platform/AndroidPlatform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/platform/AndroidPlatform;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/platform/AndroidPlatform;)V
    .locals 0

    .prologue
    .line 362
    iput-object p1, p0, Lcom/amazon/mShop/platform/AndroidPlatform$2;->this$0:Lcom/amazon/mShop/platform/AndroidPlatform;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic getServerConnection()Lcom/amazon/rio/j2me/client/trans/IServiceConnection;
    .locals 1

    .prologue
    .line 362
    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform$2;->getServerConnection()Lcom/amazon/rio/j2me/client/trans/ServerConnection;

    move-result-object v0

    return-object v0
.end method

.method public getServerConnection()Lcom/amazon/rio/j2me/client/trans/ServerConnection;
    .locals 2

    .prologue
    .line 366
    new-instance v0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;

    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform$2;->this$0:Lcom/amazon/mShop/platform/AndroidPlatform;

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getSecureServiceUrl()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;-><init>(Ljava/lang/String;)V

    return-object v0
.end method
