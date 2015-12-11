.class Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1$1;
.super Ljava/lang/Object;
.source "CentralAccountManagerCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;)V
    .locals 0

    .prologue
    .line 719
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1$1;->this$1:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 730
    # getter for: Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Failed to deregister the device after detecting child device type change."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 732
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 724
    # getter for: Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Device was deregistered due to the child device type change."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 725
    return-void
.end method
