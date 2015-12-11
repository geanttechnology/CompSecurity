.class Ltv/freewheel/utils/URLLoader$1;
.super Ljava/lang/Thread;
.source "URLLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/utils/URLLoader;->load(Ltv/freewheel/utils/URLRequest;D)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/utils/URLLoader;

.field final synthetic val$request:Ltv/freewheel/utils/URLRequest;

.field final synthetic val$timeOutSeconds:D


# direct methods
.method constructor <init>(Ltv/freewheel/utils/URLLoader;Ltv/freewheel/utils/URLRequest;D)V
    .locals 1

    .prologue
    .line 222
    iput-object p1, p0, Ltv/freewheel/utils/URLLoader$1;->this$0:Ltv/freewheel/utils/URLLoader;

    iput-object p2, p0, Ltv/freewheel/utils/URLLoader$1;->val$request:Ltv/freewheel/utils/URLRequest;

    iput-wide p3, p0, Ltv/freewheel/utils/URLLoader$1;->val$timeOutSeconds:D

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 226
    :try_start_0
    iget-object v2, p0, Ltv/freewheel/utils/URLLoader$1;->val$request:Ltv/freewheel/utils/URLRequest;

    iget-wide v2, v2, Ltv/freewheel/utils/URLRequest;->delayMs:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    .line 227
    iget-object v2, p0, Ltv/freewheel/utils/URLLoader$1;->val$request:Ltv/freewheel/utils/URLRequest;

    iget-wide v2, v2, Ltv/freewheel/utils/URLRequest;->delayMs:J

    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V

    .line 229
    :cond_0
    iget-wide v2, p0, Ltv/freewheel/utils/URLLoader$1;->val$timeOutSeconds:D

    const-wide v4, 0x408f400000000000L    # 1000.0

    mul-double/2addr v2, v4

    double-to-int v1, v2

    .line 230
    .local v1, "timeOutMilliSeconds":I
    iget-object v2, p0, Ltv/freewheel/utils/URLLoader$1;->this$0:Ltv/freewheel/utils/URLLoader;

    iget-object v3, p0, Ltv/freewheel/utils/URLLoader$1;->this$0:Ltv/freewheel/utils/URLLoader;

    iget-object v4, p0, Ltv/freewheel/utils/URLLoader$1;->val$request:Ltv/freewheel/utils/URLRequest;

    invoke-virtual {v3, v4, v1}, Ltv/freewheel/utils/URLLoader;->initHttpClient(Ltv/freewheel/utils/URLRequest;I)Ltv/freewheel/utils/http/ISimpleHttpClient;

    move-result-object v3

    # setter for: Ltv/freewheel/utils/URLLoader;->client:Ltv/freewheel/utils/http/ISimpleHttpClient;
    invoke-static {v2, v3}, Ltv/freewheel/utils/URLLoader;->access$002(Ltv/freewheel/utils/URLLoader;Ltv/freewheel/utils/http/ISimpleHttpClient;)Ltv/freewheel/utils/http/ISimpleHttpClient;

    .line 231
    iget-object v2, p0, Ltv/freewheel/utils/URLLoader$1;->this$0:Ltv/freewheel/utils/URLLoader;

    # getter for: Ltv/freewheel/utils/URLLoader;->clientAlive:Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-static {v2}, Ltv/freewheel/utils/URLLoader;->access$100(Ltv/freewheel/utils/URLLoader;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 232
    iget-object v2, p0, Ltv/freewheel/utils/URLLoader$1;->this$0:Ltv/freewheel/utils/URLLoader;

    iget-object v3, p0, Ltv/freewheel/utils/URLLoader$1;->this$0:Ltv/freewheel/utils/URLLoader;

    # getter for: Ltv/freewheel/utils/URLLoader;->client:Ltv/freewheel/utils/http/ISimpleHttpClient;
    invoke-static {v3}, Ltv/freewheel/utils/URLLoader;->access$000(Ltv/freewheel/utils/URLLoader;)Ltv/freewheel/utils/http/ISimpleHttpClient;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/utils/URLLoader$1;->val$request:Ltv/freewheel/utils/URLRequest;

    invoke-virtual {v2, v3, v4}, Ltv/freewheel/utils/URLLoader;->issueHttpRequest(Ltv/freewheel/utils/http/ISimpleHttpClient;Ltv/freewheel/utils/URLRequest;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 238
    .end local v1    # "timeOutMilliSeconds":I
    :goto_0
    return-void

    .line 233
    :catch_0
    move-exception v0

    .line 234
    .local v0, "e":Ljava/lang/Throwable;
    iget-object v2, p0, Ltv/freewheel/utils/URLLoader$1;->this$0:Ltv/freewheel/utils/URLLoader;

    new-instance v3, Ltv/freewheel/utils/events/Event;

    const-string v4, "URLLoader.Load.Error"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "RuntimeError: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Ltv/freewheel/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/URLLoader;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 235
    iget-object v2, p0, Ltv/freewheel/utils/URLLoader$1;->this$0:Ltv/freewheel/utils/URLLoader;

    # getter for: Ltv/freewheel/utils/URLLoader;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/utils/URLLoader;->access$200(Ltv/freewheel/utils/URLLoader;)Ltv/freewheel/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "load failed on url: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/utils/URLLoader$1;->val$request:Ltv/freewheel/utils/URLRequest;

    iget-object v4, v4, Ltv/freewheel/utils/URLRequest;->url:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 236
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_0
.end method
