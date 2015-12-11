.class Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$1;
.super Ljava/lang/Object;
.source "MAPWebViewHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->continueLoadingURL()V
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
    .line 223
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 227
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$200(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$100(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    move-result-object v1

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->returnToURL:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/android/webkit/AmazonWebView;->loadUrl(Ljava/lang/String;)V

    .line 228
    return-void
.end method
