.class Lcom/livemixtapes/MediaObserver$1;
.super Ljava/lang/Object;
.source "MediaObserver.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/MediaObserver;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/MediaObserver;


# direct methods
.method constructor <init>(Lcom/livemixtapes/MediaObserver;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/MediaObserver$1;->this$0:Lcom/livemixtapes/MediaObserver;

    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 50
    const/4 v0, 0x1

    :try_start_0
    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    .line 52
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "PROGRESS: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v3}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 54
    iget-object v0, p0, Lcom/livemixtapes/MediaObserver$1;->this$0:Lcom/livemixtapes/MediaObserver;

    # getter for: Lcom/livemixtapes/MediaObserver;->stop:Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-static {v0}, Lcom/livemixtapes/MediaObserver;->access$0(Lcom/livemixtapes/MediaObserver;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_0

    .line 56
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->updatePosition()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 65
    :cond_0
    :goto_0
    return-void

    .line 60
    :catch_0
    move-exception v0

    goto :goto_0
.end method
