.class Lcom/amazon/mShop/sso/SignedMShopService$1;
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
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getServerConnection()Lcom/amazon/rio/j2me/client/trans/IServiceConnection;
    .locals 2

    .prologue
    .line 28
    new-instance v0, Ljava/lang/RuntimeException;

    const-string/jumbo v1, "signed requests must always go over SSL"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
