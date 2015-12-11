.class Lcom/amazon/identity/auth/device/AuthPortalUIActivity$6;
.super Ljava/lang/Object;
.source "AuthPortalUIActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->returnSuccess(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

.field final synthetic val$result:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 1564
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$6;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$6;->val$result:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1569
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$6;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2500(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;

    move-result-object v0

    .line 1570
    .local v0, "response":Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;
    if-eqz v0, :cond_0

    .line 1572
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$6;->val$result:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;->onSuccess(Landroid/os/Bundle;)V

    .line 1574
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$6;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finish()V

    .line 1575
    return-void
.end method
