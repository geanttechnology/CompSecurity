.class Lcom/conviva/session/Session$4;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/conviva/utils/CallableWithParameters$With1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/conviva/session/Session;->postHeartbeat(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/conviva/utils/CallableWithParameters$With1",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/conviva/session/Session;


# direct methods
.method constructor <init>(Lcom/conviva/session/Session;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/session/Session$4;->this$0:Lcom/conviva/session/Session;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic exec(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/conviva/session/Session$4;->exec(Ljava/lang/String;)V

    return-void
.end method

.method public exec(Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/conviva/session/Session$4;->this$0:Lcom/conviva/session/Session;

    # invokes: Lcom/conviva/session/Session;->onHeartbeatResponse(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/conviva/session/Session;->access$300(Lcom/conviva/session/Session;Ljava/lang/String;)V

    return-void
.end method
