.class Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$3;
.super Lcom/amazon/identity/auth/device/framework/AccountManagerFutureAdapter;
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
        "Lcom/amazon/identity/auth/device/framework/AccountManagerFutureAdapter",
        "<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;Landroid/accounts/AccountManagerFuture;)V
    .locals 0

    .prologue
    .line 884
    .local p2, "x0":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Ljava/lang/Boolean;>;"
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$3;->this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/framework/AccountManagerFutureAdapter;-><init>(Landroid/accounts/AccountManagerFuture;)V

    return-void
.end method


# virtual methods
.method protected getResultBundle(Ljava/lang/Boolean;)Landroid/os/Bundle;
    .locals 2
    .param p1, "result"    # Ljava/lang/Boolean;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
        }
    .end annotation

    .prologue
    .line 889
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    .line 891
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$3;->this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->access$100(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;)Landroid/os/Bundle;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;-><init>(Landroid/os/Bundle;)V

    throw v0

    .line 894
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$3;->this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->access$200(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic getResultBundle(Ljava/lang/Object;)Landroid/os/Bundle;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
        }
    .end annotation

    .prologue
    .line 884
    check-cast p1, Ljava/lang/Boolean;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$3;->getResultBundle(Ljava/lang/Boolean;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method
