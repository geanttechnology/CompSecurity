.class Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1$1;
.super Ljava/lang/Object;
.source "RegisterAccountHelper.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->startAsyncOperation()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1$1;->this$1:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public failure()V
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1$1;->this$1:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;

    iget-object v0, v0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->val$callback:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;->failure()V

    .line 70
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1$1;->this$1:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;

    # invokes: Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->asyncOperationComplete()V
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->access$100(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;)V

    .line 71
    return-void
.end method

.method public success()V
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1$1;->this$1:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;

    iget-object v0, v0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->val$callback:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;->success()V

    .line 62
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1$1;->this$1:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;

    # invokes: Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->asyncOperationComplete()V
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->access$000(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;)V

    .line 63
    return-void
.end method
