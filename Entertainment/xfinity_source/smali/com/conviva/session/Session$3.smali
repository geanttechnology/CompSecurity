.class Lcom/conviva/session/Session$3;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/conviva/session/Session;->encodeHeartbeat(Ljava/util/Map;Lcom/conviva/utils/CallableWithParameters$With1;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/conviva/session/Session;

.field final synthetic val$encodeCbk:Lcom/conviva/utils/CallableWithParameters$With1;

.field final synthetic val$heartbeat:Ljava/util/Map;


# direct methods
.method constructor <init>(Lcom/conviva/session/Session;Ljava/util/Map;Lcom/conviva/utils/CallableWithParameters$With1;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/session/Session$3;->this$0:Lcom/conviva/session/Session;

    iput-object p2, p0, Lcom/conviva/session/Session$3;->val$heartbeat:Ljava/util/Map;

    iput-object p3, p0, Lcom/conviva/session/Session$3;->val$encodeCbk:Lcom/conviva/utils/CallableWithParameters$With1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/conviva/session/Session$3;->call()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/Void;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    iget-object v0, p0, Lcom/conviva/session/Session$3;->this$0:Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;
    invoke-static {v0}, Lcom/conviva/session/Session;->access$200(Lcom/conviva/session/Session;)Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    iget-object v1, p0, Lcom/conviva/session/Session$3;->val$heartbeat:Ljava/util/Map;

    iget-object v2, p0, Lcom/conviva/session/Session$3;->val$encodeCbk:Lcom/conviva/utils/CallableWithParameters$With1;

    invoke-virtual {v0, v1, v2}, Lcom/conviva/utils/PlatformUtils;->jsonEncode(Ljava/util/Map;Lcom/conviva/utils/CallableWithParameters$With1;)V

    const/4 v0, 0x0

    return-object v0
.end method
