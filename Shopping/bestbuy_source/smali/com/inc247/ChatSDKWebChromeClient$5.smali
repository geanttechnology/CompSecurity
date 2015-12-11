.class Lcom/inc247/ChatSDKWebChromeClient$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


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
    iput-object p1, p0, Lcom/inc247/ChatSDKWebChromeClient$5;->this$0:Lcom/inc247/ChatSDKWebChromeClient;

    iput-object p2, p0, Lcom/inc247/ChatSDKWebChromeClient$5;->val$result:Landroid/webkit/JsResult;

    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/inc247/ChatSDKWebChromeClient$5;->val$result:Landroid/webkit/JsResult;

    invoke-virtual {v0}, Landroid/webkit/JsResult;->cancel()V

    .line 94
    return-void
.end method
