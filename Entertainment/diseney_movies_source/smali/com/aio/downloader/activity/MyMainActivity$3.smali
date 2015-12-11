.class Lcom/aio/downloader/activity/MyMainActivity$3;
.super Landroid/content/BroadcastReceiver;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$3;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 333
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    .line 338
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$Mya_rush;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$3;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$Mya_rush;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$Mya_rush;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 339
    return-void
.end method
