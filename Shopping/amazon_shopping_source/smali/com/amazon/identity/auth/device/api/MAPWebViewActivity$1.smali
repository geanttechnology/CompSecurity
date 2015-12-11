.class Lcom/amazon/identity/auth/device/api/MAPWebViewActivity$1;
.super Ljava/lang/Object;
.source "MAPWebViewActivity.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->getAuthActivityCallback()Lcom/amazon/identity/auth/device/api/Callback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->access$100(Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;Landroid/os/Bundle;)V

    .line 52
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;->access$000(Lcom/amazon/identity/auth/device/api/MAPWebViewActivity;Landroid/os/Bundle;)V

    .line 46
    return-void
.end method
