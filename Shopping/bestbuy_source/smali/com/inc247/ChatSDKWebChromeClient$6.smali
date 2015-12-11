.class Lcom/inc247/ChatSDKWebChromeClient$6;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDKWebChromeClient;->onJsConfirm(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDKWebChromeClient;

.field private final synthetic val$result:Landroid/webkit/JsResult;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDKWebChromeClient;Landroid/webkit/JsResult;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDKWebChromeClient$6;->this$0:Lcom/inc247/ChatSDKWebChromeClient;

    iput-object p2, p0, Lcom/inc247/ChatSDKWebChromeClient$6;->val$result:Landroid/webkit/JsResult;

    .line 96
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/content/DialogInterface;ILandroid/view/KeyEvent;)Z
    .locals 1

    .prologue
    .line 99
    const/4 v0, 0x4

    if-ne p2, v0, :cond_0

    .line 102
    iget-object v0, p0, Lcom/inc247/ChatSDKWebChromeClient$6;->val$result:Landroid/webkit/JsResult;

    invoke-virtual {v0}, Landroid/webkit/JsResult;->cancel()V

    .line 103
    const/4 v0, 0x0

    .line 106
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method
