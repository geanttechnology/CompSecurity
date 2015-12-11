.class Lcom/amazon/identity/auth/accounts/AccountManagerLogic$6;
.super Ljava/lang/Object;
.source "AccountManagerLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->scheduleDeregister(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 0

    .prologue
    .line 1248
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$6;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$6;->val$directedId:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$6;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 3
    .param p1, "innerCallback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 1253
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$6;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$6;->val$directedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$6;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-static {v0, v1, p1, v2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$1200(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method
