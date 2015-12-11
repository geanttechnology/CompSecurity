.class Lcom/igexin/sdk/SdkService$MsgLooperThread;
.super Ljava/lang/Thread;
.source "SdkService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/igexin/sdk/SdkService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MsgLooperThread"
.end annotation


# instance fields
.field private intent:Landroid/content/Intent;


# direct methods
.method public constructor <init>(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 633
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 634
    iput-object p1, p0, Lcom/igexin/sdk/SdkService$MsgLooperThread;->intent:Landroid/content/Intent;

    .line 635
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 640
    invoke-static {}, Landroid/os/Looper;->prepare()V

    .line 642
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v1

    # invokes: Lcom/igexin/sdk/SdkService;->init()V
    invoke-static {v1}, Lcom/igexin/sdk/SdkService;->access$300(Lcom/igexin/sdk/SdkService;)V

    .line 644
    sget-object v1, Lcom/igexin/sdk/Consts;->VPUSH_APPID:Ljava/lang/String;

    if-eqz v1, :cond_0

    sget-object v1, Lcom/igexin/sdk/Consts;->VPUSH_APPKEY:Ljava/lang/String;

    if-eqz v1, :cond_0

    sget-object v1, Lcom/igexin/sdk/Consts;->VPUSH_APPSECRET:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 646
    new-instance v1, Lcom/igexin/sdk/SdkService$MyHandler;

    invoke-direct {v1}, Lcom/igexin/sdk/SdkService$MyHandler;-><init>()V

    sput-object v1, Lcom/igexin/sdk/SdkService;->msgLooperHandler:Landroid/os/Handler;

    .line 647
    const/4 v1, 0x1

    # setter for: Lcom/igexin/sdk/SdkService;->isThreadInit:B
    invoke-static {v1}, Lcom/igexin/sdk/SdkService;->access$402(B)B

    .line 649
    iget-object v1, p0, Lcom/igexin/sdk/SdkService$MsgLooperThread;->intent:Landroid/content/Intent;

    if-eqz v1, :cond_0

    .line 650
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 651
    .local v0, "msg":Landroid/os/Message;
    const/16 v1, 0x2af8

    iput v1, v0, Landroid/os/Message;->what:I

    .line 652
    iget-object v1, p0, Lcom/igexin/sdk/SdkService$MsgLooperThread;->intent:Landroid/content/Intent;

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 653
    invoke-static {v0}, Lcom/igexin/sdk/SdkService;->sendMessage(Landroid/os/Message;)V

    .line 657
    .end local v0    # "msg":Landroid/os/Message;
    :cond_0
    invoke-static {}, Landroid/os/Looper;->loop()V

    .line 658
    return-void
.end method
