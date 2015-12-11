.class Lcom/bestbuy/android/activities/mybby/CIALoginFragment$2;
.super Landroid/webkit/WebChromeClient;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/mybby/CIALoginFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$2;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onCloseWindow(Landroid/webkit/WebView;)V
    .locals 0

    .prologue
    .line 141
    invoke-super {p0, p1}, Landroid/webkit/WebChromeClient;->onCloseWindow(Landroid/webkit/WebView;)V

    .line 142
    invoke-virtual {p1}, Landroid/webkit/WebView;->goBack()V

    .line 143
    return-void
.end method

.method public onJsAlert(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z
    .locals 1

    .prologue
    .line 127
    const/4 v0, 0x1

    return v0
.end method

.method public onProgressChanged(Landroid/webkit/WebView;I)V
    .locals 0

    .prologue
    .line 137
    invoke-super {p0, p1, p2}, Landroid/webkit/WebChromeClient;->onProgressChanged(Landroid/webkit/WebView;I)V

    .line 138
    return-void
.end method

.method public onReceivedTitle(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 132
    invoke-super {p0, p1, p2}, Landroid/webkit/WebChromeClient;->onReceivedTitle(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 133
    return-void
.end method
