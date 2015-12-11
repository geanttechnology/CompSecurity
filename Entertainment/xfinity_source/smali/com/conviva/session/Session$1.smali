.class Lcom/conviva/session/Session$1;
.super Ljava/util/TimerTask;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/conviva/session/Session;->createHBTimer(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/conviva/session/Session;


# direct methods
.method constructor <init>(Lcom/conviva/session/Session;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/session/Session$1;->this$0:Lcom/conviva/session/Session;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    iget-object v0, p0, Lcom/conviva/session/Session$1;->this$0:Lcom/conviva/session/Session;

    # invokes: Lcom/conviva/session/Session;->sendHeartbeat()V
    invoke-static {v0}, Lcom/conviva/session/Session;->access$000(Lcom/conviva/session/Session;)V

    return-void
.end method
