.class Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$2;
.super Ljava/lang/Object;
.source "RegisterAccountHelper.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->ensureCredentialsPopulated(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;

.field final synthetic val$callback:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;Landroid/content/Context;Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$2;->this$0:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$2;->val$context:Landroid/content/Context;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$2;->val$callback:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$2;->val$callback:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;->failure()V

    .line 116
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 102
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$2;->this$0:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$2;->val$context:Landroid/content/Context;

    # invokes: Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->haveAnyCredentials(Landroid/content/Context;)Z
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->access$200(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$2;->val$callback:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;->success()V

    .line 110
    :goto_0
    return-void

    .line 108
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$2;->val$callback:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;->failure()V

    goto :goto_0
.end method
