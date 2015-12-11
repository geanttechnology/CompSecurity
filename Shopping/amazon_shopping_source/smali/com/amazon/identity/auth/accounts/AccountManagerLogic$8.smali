.class Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;
.super Ljava/lang/Object;
.source "AccountManagerLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->renameDevice(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$newDeviceName:Ljava/lang/String;

.field final synthetic val$options:Landroid/os/Bundle;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 0

    .prologue
    .line 1483
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;->val$directedId:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;->val$newDeviceName:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;->val$options:Landroid/os/Bundle;

    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 6
    .param p1, "innerCallback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 1488
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRenameDevice:Lcom/amazon/identity/auth/accounts/RenameDevice;
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$1400(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/RenameDevice;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;->val$directedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;->val$newDeviceName:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;->val$options:Landroid/os/Bundle;

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    move-object v4, p1

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/RenameDevice;->renameDevice(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 1489
    const/4 v0, 0x0

    return-object v0
.end method
