.class Lcom/amazon/identity/auth/accounts/AccountManagerLogic$2;
.super Ljava/lang/Object;
.source "AccountManagerLogic.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

.field final synthetic val$authData:Landroid/os/Bundle;

.field final synthetic val$callback:Lcom/amazon/identity/auth/device/api/Callback;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 0

    .prologue
    .line 686
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$2;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$2;->val$authData:Landroid/os/Bundle;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$2;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 691
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$2;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAuthenticator:Lcom/amazon/identity/auth/accounts/AccountAuthenticator;
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$300(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$2;->val$authData:Landroid/os/Bundle;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$2;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 692
    return-void
.end method
