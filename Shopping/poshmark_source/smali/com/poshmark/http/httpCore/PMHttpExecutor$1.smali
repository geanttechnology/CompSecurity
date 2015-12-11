.class Lcom/poshmark/http/httpCore/PMHttpExecutor$1;
.super Landroid/os/Handler;
.source "PMHttpExecutor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/http/httpCore/PMHttpExecutor;->setupHandlerForCallingThread()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/http/httpCore/PMHttpExecutor;


# direct methods
.method constructor <init>(Lcom/poshmark/http/httpCore/PMHttpExecutor;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor$1;->this$0:Lcom/poshmark/http/httpCore/PMHttpExecutor;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 1
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 161
    iget-object v0, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor$1;->this$0:Lcom/poshmark/http/httpCore/PMHttpExecutor;

    # invokes: Lcom/poshmark/http/httpCore/PMHttpExecutor;->handleMessage(Landroid/os/Message;)V
    invoke-static {v0, p1}, Lcom/poshmark/http/httpCore/PMHttpExecutor;->access$200(Lcom/poshmark/http/httpCore/PMHttpExecutor;Landroid/os/Message;)V

    .line 162
    return-void
.end method
