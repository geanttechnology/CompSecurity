.class Lcom/comcast/playerplatform/util/android/Clock$1;
.super Ljava/util/TimerTask;
.source "Clock.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/util/android/Clock;->start()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/util/android/Clock;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/util/android/Clock;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/comcast/playerplatform/util/android/Clock$1;->this$0:Lcom/comcast/playerplatform/util/android/Clock;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/Clock$1;->this$0:Lcom/comcast/playerplatform/util/android/Clock;

    # invokes: Lcom/comcast/playerplatform/util/android/Clock;->dispatchClockEvent()V
    invoke-static {v0}, Lcom/comcast/playerplatform/util/android/Clock;->access$000(Lcom/comcast/playerplatform/util/android/Clock;)V

    .line 49
    return-void
.end method
