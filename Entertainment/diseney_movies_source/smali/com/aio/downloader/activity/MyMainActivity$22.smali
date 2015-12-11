.class Lcom/aio/downloader/activity/MyMainActivity$22;
.super Ljava/util/TimerTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->onCreate(Landroid/os/Bundle;)V
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
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$22;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 1880
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1884
    new-instance v0, Landroid/content/Intent;

    const-string v1, "\u53d1\u9001\u5e7f\u64ad"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1886
    .local v0, "mIntent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$22;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/MyMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 1887
    return-void
.end method
