.class Lcom/amazon/identity/auth/device/AuthPortalUIActivity$5;
.super Ljava/lang/Object;
.source "AuthPortalUIActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

.field final synthetic val$errorBundle:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 1533
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$5;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$5;->val$errorBundle:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1538
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$5;->val$errorBundle:Landroid/os/Bundle;

    if-nez v1, :cond_0

    .line 1540
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$5;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finish()V

    .line 1550
    :goto_0
    return-void

    .line 1544
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$5;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2500(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;

    move-result-object v0

    .line 1545
    .local v0, "response":Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;
    if-eqz v0, :cond_1

    .line 1547
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$5;->val$errorBundle:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->onError(Landroid/os/Bundle;)V

    .line 1549
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$5;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # invokes: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->closeActivity()V
    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2600(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V

    goto :goto_0
.end method
