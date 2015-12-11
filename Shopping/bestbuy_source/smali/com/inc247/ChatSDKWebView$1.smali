.class Lcom/inc247/ChatSDKWebView$1;
.super Lcom/inc247/ChatSDKWebChromeClient;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDKWebView;->loadChatSDKWebView(Landroid/content/Context;)V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDKWebView;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDKWebView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDKWebView$1;->this$0:Lcom/inc247/ChatSDKWebView;

    .line 146
    invoke-direct {p0}, Lcom/inc247/ChatSDKWebChromeClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onShowFileChooser(Landroid/webkit/WebView;Landroid/webkit/ValueCallback;Landroid/webkit/WebChromeClient$FileChooserParams;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/webkit/WebView;",
            "Landroid/webkit/ValueCallback",
            "<[",
            "Landroid/net/Uri;",
            ">;",
            "Landroid/webkit/WebChromeClient$FileChooserParams;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 175
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView$1;->this$0:Lcom/inc247/ChatSDKWebView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p2}, Lcom/inc247/ChatSDKWebView;->openFileInput(Landroid/webkit/ValueCallback;Landroid/webkit/ValueCallback;)V

    .line 176
    const/4 v0, 0x1

    return v0
.end method

.method public openFileChooser(Landroid/webkit/ValueCallback;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/webkit/ValueCallback",
            "<",
            "Landroid/net/Uri;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 151
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/inc247/ChatSDKWebView$1;->openFileChooser(Landroid/webkit/ValueCallback;Ljava/lang/String;)V

    .line 152
    return-void
.end method

.method public openFileChooser(Landroid/webkit/ValueCallback;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/webkit/ValueCallback",
            "<",
            "Landroid/net/Uri;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 158
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/inc247/ChatSDKWebView$1;->openFileChooser(Landroid/webkit/ValueCallback;Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    return-void
.end method

.method public openFileChooser(Landroid/webkit/ValueCallback;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/webkit/ValueCallback",
            "<",
            "Landroid/net/Uri;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 166
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView$1;->this$0:Lcom/inc247/ChatSDKWebView;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lcom/inc247/ChatSDKWebView;->openFileInput(Landroid/webkit/ValueCallback;Landroid/webkit/ValueCallback;)V

    .line 167
    return-void
.end method
