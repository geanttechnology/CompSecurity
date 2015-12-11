.class Lcom/amazon/android/webkit/android/AndroidWebViewClient$1;
.super Lcom/amazon/android/webkit/AmazonHttpAuthHandler;
.source "AndroidWebViewClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/android/webkit/android/AndroidWebViewClient;->onReceivedHttpAuthRequest(Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/android/webkit/android/AndroidWebViewClient;

.field final synthetic val$handler:Landroid/webkit/HttpAuthHandler;


# direct methods
.method constructor <init>(Lcom/amazon/android/webkit/android/AndroidWebViewClient;Landroid/webkit/HttpAuthHandler;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient$1;->this$0:Lcom/amazon/android/webkit/android/AndroidWebViewClient;

    iput-object p2, p0, Lcom/amazon/android/webkit/android/AndroidWebViewClient$1;->val$handler:Landroid/webkit/HttpAuthHandler;

    invoke-direct {p0}, Lcom/amazon/android/webkit/AmazonHttpAuthHandler;-><init>()V

    return-void
.end method
