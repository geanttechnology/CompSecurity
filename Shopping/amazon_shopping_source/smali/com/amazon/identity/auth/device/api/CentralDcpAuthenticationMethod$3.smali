.class Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$3;
.super Ljava/lang/Object;
.source "CentralDcpAuthenticationMethod.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V
    .locals 0

    .prologue
    .line 466
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$3;->this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$3;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 477
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$3;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onError(Landroid/os/Bundle;)V

    .line 478
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 471
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$3;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onSuccess(Landroid/os/Bundle;)V

    .line 472
    return-void
.end method
