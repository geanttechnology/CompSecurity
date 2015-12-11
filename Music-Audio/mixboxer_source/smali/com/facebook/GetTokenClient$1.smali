.class Lcom/facebook/GetTokenClient$1;
.super Landroid/os/Handler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/facebook/GetTokenClient;


# direct methods
.method constructor <init>(Lcom/facebook/GetTokenClient;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/facebook/GetTokenClient$1;->this$0:Lcom/facebook/GetTokenClient;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/facebook/GetTokenClient$1;->this$0:Lcom/facebook/GetTokenClient;

    # invokes: Lcom/facebook/GetTokenClient;->handleMessage(Landroid/os/Message;)V
    invoke-static {v0, p1}, Lcom/facebook/GetTokenClient;->access$000(Lcom/facebook/GetTokenClient;Landroid/os/Message;)V

    .line 44
    return-void
.end method
