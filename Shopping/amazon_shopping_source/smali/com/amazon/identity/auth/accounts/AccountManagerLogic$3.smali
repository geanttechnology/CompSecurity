.class Lcom/amazon/identity/auth/accounts/AccountManagerLogic$3;
.super Ljava/lang/Object;
.source "AccountManagerLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

.field final synthetic val$regData:Landroid/os/Bundle;

.field final synthetic val$regType:Lcom/amazon/identity/auth/device/api/RegistrationType;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 0

    .prologue
    .line 746
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$3;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$3;->val$regType:Lcom/amazon/identity/auth/device/api/RegistrationType;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$3;->val$regData:Landroid/os/Bundle;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$3;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 4
    .param p1, "innerCallback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 751
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$3;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$3;->val$regType:Lcom/amazon/identity/auth/device/api/RegistrationType;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$3;->val$regData:Landroid/os/Bundle;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$3;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-static {v0, v1, v2, p1, v3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$400(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method
