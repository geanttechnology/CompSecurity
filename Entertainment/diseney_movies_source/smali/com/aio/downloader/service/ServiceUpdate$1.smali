.class Lcom/aio/downloader/service/ServiceUpdate$1;
.super Landroid/os/Handler;
.source "ServiceUpdate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/service/ServiceUpdate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private showup:I

.field final synthetic this$0:Lcom/aio/downloader/service/ServiceUpdate;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceUpdate;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$1;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    .line 178
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceUpdate$1;)I
    .locals 1

    .prologue
    .line 180
    iget v0, p0, Lcom/aio/downloader/service/ServiceUpdate$1;->showup:I

    return v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/ServiceUpdate$1;)Lcom/aio/downloader/service/ServiceUpdate;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$1;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 186
    iget v2, p1, Landroid/os/Message;->what:I

    packed-switch v2, :pswitch_data_0

    .line 225
    :cond_0
    :goto_0
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 226
    return-void

    .line 188
    :pswitch_0
    const-string v2, "qaz"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "10001"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 192
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$1;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v2, v2, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/aio/downloader/utils/Myutils;->parseupdata(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 193
    sget v2, Lcom/aio/downloader/utils/Myutils;->status:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    .line 196
    :try_start_0
    const-string v2, "qaz"

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/service/ServiceUpdate$1;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 197
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v2

    iget-object v4, p0, Lcom/aio/downloader/service/ServiceUpdate$1;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    int-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/service/ServiceUpdate$1;->showup:I

    .line 198
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 199
    .local v0, "timer":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/service/ServiceUpdate$1$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/service/ServiceUpdate$1$1;-><init>(Lcom/aio/downloader/service/ServiceUpdate$1;)V

    .line 215
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0x3e8

    const-wide/16 v4, 0x7530

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 217
    .end local v0    # "timer":Ljava/util/Timer;
    .end local v1    # "task":Ljava/util/TimerTask;
    :catch_0
    move-exception v2

    goto :goto_0

    .line 186
    :pswitch_data_0
    .packed-switch 0x3e9
        :pswitch_0
    .end packed-switch
.end method
