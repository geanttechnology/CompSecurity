.class Lcom/aio/downloader/service/PhoneStateReceiver$2;
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
    iput-object p1, p0, Lcom/aio/downloader/service/PhoneStateReceiver$2;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    .line 179
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/aio/downloader/service/PhoneStateReceiver$2;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    # getter for: Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog:Lcom/aio/downloader/dialog/CallerOutDialog;
    invoke-static {v0}, Lcom/aio/downloader/service/PhoneStateReceiver;->access$0(Lcom/aio/downloader/service/PhoneStateReceiver;)Lcom/aio/downloader/dialog/CallerOutDialog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/CallerOutDialog;->show()V

    .line 204
    return-void
.end method
