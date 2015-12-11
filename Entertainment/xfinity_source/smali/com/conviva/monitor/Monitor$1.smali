.class Lcom/conviva/monitor/Monitor$1;
.super Ljava/util/TimerTask;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/conviva/monitor/Monitor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/conviva/monitor/Monitor;


# direct methods
.method constructor <init>(Lcom/conviva/monitor/Monitor;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/monitor/Monitor$1;->this$0:Lcom/conviva/monitor/Monitor;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    iget-object v0, p0, Lcom/conviva/monitor/Monitor$1;->this$0:Lcom/conviva/monitor/Monitor;

    # invokes: Lcom/conviva/monitor/Monitor;->pollStreamer()V
    invoke-static {v0}, Lcom/conviva/monitor/Monitor;->access$000(Lcom/conviva/monitor/Monitor;)V

    return-void
.end method
