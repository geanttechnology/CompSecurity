.class Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration$1;
.super Ljava/lang/Object;
.source "DeregisterAccount.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->startAsyncOperation()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;)V
    .locals 0

    .prologue
    .line 660
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration$1;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 664
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration$1;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;

    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mConnection:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->access$600(Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration$1;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;

    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->mAccount:Landroid/accounts/Account;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->access$500(Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;)Landroid/accounts/Account;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration$1;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->deregister(Landroid/accounts/Account;Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;)V

    .line 665
    return-void
.end method
