.class Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;
.super Ljava/lang/Object;
.source "VODMediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PingUplynk"
.end annotation


# instance fields
.field host:Ljava/lang/String;

.field session:Ljava/lang/String;

.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;


# direct methods
.method public constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2, "host"    # Ljava/lang/String;
    .param p3, "session"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->host:Ljava/lang/String;

    .line 79
    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->session:Ljava/lang/String;

    .line 80
    return-void
.end method


# virtual methods
.method public ping(ILjava/lang/String;)Ljava/util/concurrent/Future;
    .locals 2
    .param p1, "playerTime"    # I
    .param p2, "event"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 85
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->getManager()Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;ILjava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->execute(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
