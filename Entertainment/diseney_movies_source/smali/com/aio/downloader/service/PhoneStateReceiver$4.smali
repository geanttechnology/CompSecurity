.class Lcom/aio/downloader/service/PhoneStateReceiver$4;
.super Ljava/lang/Object;
.source "PhoneStateReceiver.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/PhoneStateReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/PhoneStateReceiver;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/PhoneStateReceiver;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/PhoneStateReceiver$4;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    .line 434
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 439
    iget-object v0, p0, Lcom/aio/downloader/service/PhoneStateReceiver$4;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    # getter for: Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;
    invoke-static {v0}, Lcom/aio/downloader/service/PhoneStateReceiver;->access$3(Lcom/aio/downloader/service/PhoneStateReceiver;)Lcom/aio/downloader/dialog/CallerOutDialog1;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/CallerOutDialog1;->show()V

    .line 440
    return-void
.end method
