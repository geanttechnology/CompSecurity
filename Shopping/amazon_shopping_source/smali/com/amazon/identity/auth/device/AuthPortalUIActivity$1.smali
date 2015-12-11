.class Lcom/amazon/identity/auth/device/AuthPortalUIActivity$1;
.super Lcom/amazon/android/webkit/AmazonWebChromeClient;
.source "AuthPortalUIActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->setupWebChromeClient(Lcom/amazon/android/webkit/AmazonWebView;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V
    .locals 0

    .prologue
    .line 829
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$1;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-direct {p0}, Lcom/amazon/android/webkit/AmazonWebChromeClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressChanged(Lcom/amazon/android/webkit/AmazonWebView;I)V
    .locals 1
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "progress"    # I

    .prologue
    .line 833
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$1;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-static {v0, p1, p2}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$400(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Lcom/amazon/android/webkit/AmazonWebView;I)V

    .line 834
    return-void
.end method
