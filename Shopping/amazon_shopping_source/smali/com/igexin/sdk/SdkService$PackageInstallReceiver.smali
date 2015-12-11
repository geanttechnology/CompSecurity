.class Lcom/igexin/sdk/SdkService$PackageInstallReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SdkService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/igexin/sdk/SdkService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PackageInstallReceiver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/igexin/sdk/SdkService;


# direct methods
.method constructor <init>(Lcom/igexin/sdk/SdkService;)V
    .locals 0

    .prologue
    .line 769
    iput-object p1, p0, Lcom/igexin/sdk/SdkService$PackageInstallReceiver;->this$0:Lcom/igexin/sdk/SdkService;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 773
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 774
    .local v0, "msg":Landroid/os/Message;
    sget v1, Lcom/igexin/sdk/Consts;->MESSAGE_RECEIVER_INTERNAL:I

    iput v1, v0, Landroid/os/Message;->what:I

    .line 775
    iput-object p2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 776
    invoke-static {v0}, Lcom/igexin/sdk/SdkService;->sendMessage(Landroid/os/Message;)V

    .line 777
    return-void
.end method
