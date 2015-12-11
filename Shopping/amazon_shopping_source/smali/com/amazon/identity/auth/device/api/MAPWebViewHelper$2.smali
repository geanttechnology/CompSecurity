.class Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$2;
.super Ljava/lang/Object;
.source "MAPWebViewHelper.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)V
    .locals 0

    .prologue
    .line 426
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$2;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 437
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$2;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mClientEventCallback:Lcom/amazon/identity/auth/device/api/Callback;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$400(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->setError(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 438
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 431
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$2;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$300(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)V

    .line 432
    return-void
.end method
