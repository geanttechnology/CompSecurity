.class Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$1;
.super Landroid/webkit/WebViewClient;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;)V
    .locals 0

    .prologue
    .line 102
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$1;->this$0:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 105
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V

    .line 106
    return-void
.end method
