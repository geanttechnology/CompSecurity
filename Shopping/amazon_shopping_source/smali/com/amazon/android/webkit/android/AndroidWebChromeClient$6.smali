.class Lcom/amazon/android/webkit/android/AndroidWebChromeClient$6;
.super Lcom/amazon/android/webkit/AmazonJsResult;
.source "AndroidWebChromeClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->convertJsResult(Landroid/webkit/JsResult;)Lcom/amazon/android/webkit/AmazonJsResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/android/webkit/android/AndroidWebChromeClient;

.field final synthetic val$jsResult:Landroid/webkit/JsResult;


# direct methods
.method constructor <init>(Lcom/amazon/android/webkit/android/AndroidWebChromeClient;Landroid/webkit/JsResult;)V
    .locals 0

    .prologue
    .line 199
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$6;->this$0:Lcom/amazon/android/webkit/android/AndroidWebChromeClient;

    iput-object p2, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$6;->val$jsResult:Landroid/webkit/JsResult;

    invoke-direct {p0}, Lcom/amazon/android/webkit/AmazonJsResult;-><init>()V

    return-void
.end method
