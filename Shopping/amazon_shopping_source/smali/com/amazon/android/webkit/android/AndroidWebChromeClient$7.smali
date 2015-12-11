.class Lcom/amazon/android/webkit/android/AndroidWebChromeClient$7;
.super Lcom/amazon/android/webkit/AmazonJsPromptResult;
.source "AndroidWebChromeClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->convertJsPromptResult(Landroid/webkit/JsPromptResult;)Lcom/amazon/android/webkit/AmazonJsPromptResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/android/webkit/android/AndroidWebChromeClient;

.field final synthetic val$jsPromptResult:Landroid/webkit/JsPromptResult;


# direct methods
.method constructor <init>(Lcom/amazon/android/webkit/android/AndroidWebChromeClient;Landroid/webkit/JsPromptResult;)V
    .locals 0

    .prologue
    .line 213
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$7;->this$0:Lcom/amazon/android/webkit/android/AndroidWebChromeClient;

    iput-object p2, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$7;->val$jsPromptResult:Landroid/webkit/JsPromptResult;

    invoke-direct {p0}, Lcom/amazon/android/webkit/AmazonJsPromptResult;-><init>()V

    return-void
.end method
