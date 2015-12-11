.class Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$2;
.super Ljava/lang/Object;
.source "CentralAccountManagerCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/token/TokenCache$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V
    .locals 0

    .prologue
    .line 749
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$2;->this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public failure(Ljava/lang/String;ILjava/lang/String;)V
    .locals 2
    .param p1, "tokenType"    # Ljava/lang/String;
    .param p2, "errorCode"    # I
    .param p3, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 766
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const/4 v1, 0x0

    invoke-static {v0, p2, p3, v1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V

    .line 767
    return-void
.end method

.method public failure(Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "tokenType"    # Ljava/lang/String;
    .param p2, "result"    # Landroid/os/Bundle;

    .prologue
    .line 760
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v0, p2}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onError(Landroid/os/Bundle;)V

    .line 761
    return-void
.end method

.method public success()V
    .locals 2

    .prologue
    .line 754
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onSuccess(Landroid/os/Bundle;)V

    .line 755
    return-void
.end method
