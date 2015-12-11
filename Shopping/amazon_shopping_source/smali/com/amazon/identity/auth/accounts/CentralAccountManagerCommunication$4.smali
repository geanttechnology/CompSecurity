.class Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$4;
.super Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter;
.source "CentralAccountManagerCommunication.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter",
        "<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 909
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$4;->this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/framework/AccountManagerCallbackAdapter;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    return-void
.end method


# virtual methods
.method protected onResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "result"    # Ljava/lang/Boolean;

    .prologue
    .line 913
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    .line 915
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$4;->this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->access$100(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 921
    :goto_0
    return-void

    .line 919
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$4;->this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->access$200(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method protected bridge synthetic onResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 909
    check-cast p2, Ljava/lang/Boolean;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$4;->onResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/Boolean;)V

    return-void
.end method
