.class Lcom/amazon/identity/auth/accounts/DeregisterAccount$2;
.super Ljava/lang/Object;
.source "DeregisterAccount.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DeregisterAccount;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount;

.field final synthetic val$response:Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/DeregisterAccount;Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;)V
    .locals 0

    .prologue
    .line 144
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$2;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$2;->val$response:Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onRequestComplete(Z)V
    .locals 2
    .param p1, "success"    # Z

    .prologue
    .line 148
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 149
    .local v0, "responseBundle":Landroid/os/Bundle;
    const-string/jumbo v1, "booleanResult"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 150
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$2;->val$response:Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;

    invoke-interface {v1, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;->onResult(Landroid/os/Bundle;)V

    .line 151
    return-void
.end method
