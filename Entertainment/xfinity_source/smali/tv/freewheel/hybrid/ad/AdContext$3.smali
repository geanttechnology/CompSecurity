.class Ltv/freewheel/hybrid/ad/AdContext$3;
.super Ljava/lang/Thread;
.source "AdContext.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/ad/AdContext;->submitRequest(DD)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/ad/AdContext;

.field final synthetic val$delayMs:J


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;J)V
    .locals 0

    .prologue
    .line 587
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdContext$3;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    iput-wide p2, p0, Ltv/freewheel/hybrid/ad/AdContext$3;->val$delayMs:J

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 591
    :try_start_0
    iget-wide v4, p0, Ltv/freewheel/hybrid/ad/AdContext$3;->val$delayMs:J

    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-lez v3, :cond_0

    .line 592
    iget-wide v4, p0, Ltv/freewheel/hybrid/ad/AdContext$3;->val$delayMs:J

    invoke-static {v4, v5}, Ljava/lang/Thread;->sleep(J)V

    .line 594
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    .line 596
    .local v0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_1
    new-instance v2, Ljava/io/FileInputStream;

    new-instance v3, Ljava/io/File;

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext$3;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdContext;->serverUrl:Ljava/lang/String;

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-direct {v2, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 597
    .local v2, "fis":Ljava/io/FileInputStream;
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext$3;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v3, v3, Ltv/freewheel/hybrid/ad/AdContext;->adResponse:Ltv/freewheel/hybrid/ad/AdResponse;

    invoke-virtual {v3, v2}, Ltv/freewheel/hybrid/ad/AdResponse;->parse(Ljava/io/InputStream;)V

    .line 598
    const-string v3, "message"

    const-string v4, "request succeeded"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 599
    const-string v3, "success"

    const-string v4, "true"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 600
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext$3;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    new-instance v4, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v5, "requestComplete"

    invoke-direct {v4, v5, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    .line 614
    .end local v0    # "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v2    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-void

    .line 601
    .restart local v0    # "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :catch_0
    move-exception v1

    .line 602
    .local v1, "e":Ljava/io/FileNotFoundException;
    :try_start_2
    const-string v3, "message"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "request failed: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/io/FileNotFoundException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 603
    const-string v3, "success"

    const-string v4, "false"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 604
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext$3;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    new-instance v4, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v5, "requestComplete"

    invoke-direct {v4, v5, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 610
    .end local v0    # "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v1    # "e":Ljava/io/FileNotFoundException;
    :catch_1
    move-exception v1

    .line 612
    .local v1, "e":Ljava/lang/Throwable;
    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_0

    .line 605
    .end local v1    # "e":Ljava/lang/Throwable;
    .restart local v0    # "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :catch_2
    move-exception v1

    .line 606
    .local v1, "e":Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
    :try_start_3
    const-string v3, "message"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "request failed: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 607
    const-string v3, "success"

    const-string v4, "false"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 608
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdContext$3;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    new-instance v4, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v5, "requestComplete"

    invoke-direct {v4, v5, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0
.end method
