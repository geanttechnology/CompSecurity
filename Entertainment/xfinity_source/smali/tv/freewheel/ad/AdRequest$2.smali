.class Ltv/freewheel/ad/AdRequest$2;
.super Ljava/lang/Thread;
.source "AdRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/ad/AdRequest;->requestVideoView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/ad/AdRequest;


# direct methods
.method constructor <init>(Ltv/freewheel/ad/AdRequest;)V
    .locals 0

    .prologue
    .line 473
    iput-object p1, p0, Ltv/freewheel/ad/AdRequest$2;->this$0:Ltv/freewheel/ad/AdRequest;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 477
    :try_start_0
    new-instance v1, Ljava/io/FileInputStream;

    new-instance v4, Ljava/io/File;

    iget-object v5, p0, Ltv/freewheel/ad/AdRequest$2;->this$0:Ltv/freewheel/ad/AdRequest;

    iget-object v5, v5, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v5, v5, Ltv/freewheel/ad/AdContext;->serverUrl:Ljava/lang/String;

    invoke-direct {v4, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-direct {v1, v4}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 478
    .local v1, "fis":Ljava/io/FileInputStream;
    new-instance v3, Ltv/freewheel/ad/AdResponse;

    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$2;->this$0:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    invoke-direct {v3, v4}, Ltv/freewheel/ad/AdResponse;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 479
    .local v3, "response":Ltv/freewheel/ad/AdResponse;
    invoke-virtual {v3, v1}, Ltv/freewheel/ad/AdResponse;->parse(Ljava/io/InputStream;)V

    .line 480
    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$2;->this$0:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    iget-object v5, v3, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    iget-object v5, v5, Ltv/freewheel/ad/VideoAsset;->callbackHandler:Ltv/freewheel/ad/handler/VideoViewCallbackHandler;

    iput-object v5, v4, Ltv/freewheel/ad/VideoAsset;->callbackHandler:Ltv/freewheel/ad/handler/VideoViewCallbackHandler;

    .line 482
    iget-object v4, v3, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    const/4 v5, 0x0

    iput-object v5, v4, Ltv/freewheel/ad/VideoAsset;->callbackHandler:Ltv/freewheel/ad/handler/VideoViewCallbackHandler;

    .line 483
    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$2;->this$0:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v4, v4, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    invoke-virtual {v4}, Ltv/freewheel/ad/VideoAsset;->play()V

    .line 485
    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$2;->this$0:Ltv/freewheel/ad/AdRequest;

    # getter for: Ltv/freewheel/ad/AdRequest;->videoViewTestListener:Ltv/freewheel/ad/interfaces/IEventListener;
    invoke-static {v4}, Ltv/freewheel/ad/AdRequest;->access$000(Ltv/freewheel/ad/AdRequest;)Ltv/freewheel/ad/interfaces/IEventListener;

    move-result-object v2

    .line 486
    .local v2, "l":Ltv/freewheel/ad/interfaces/IEventListener;
    if-eqz v2, :cond_0

    .line 487
    const/4 v4, 0x0

    invoke-interface {v2, v4}, Ltv/freewheel/ad/interfaces/IEventListener;->run(Ltv/freewheel/ad/interfaces/IEvent;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ltv/freewheel/ad/AdResponse$IllegalAdResponseException; {:try_start_0 .. :try_end_0} :catch_1

    .line 494
    .end local v1    # "fis":Ljava/io/FileInputStream;
    .end local v2    # "l":Ltv/freewheel/ad/interfaces/IEventListener;
    .end local v3    # "response":Ltv/freewheel/ad/AdResponse;
    :cond_0
    :goto_0
    return-void

    .line 489
    :catch_0
    move-exception v0

    .line 490
    .local v0, "e":Ljava/io/FileNotFoundException;
    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$2;->this$0:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->logger:Ltv/freewheel/utils/Logger;

    const-string v5, "file not found"

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0

    .line 491
    .end local v0    # "e":Ljava/io/FileNotFoundException;
    :catch_1
    move-exception v0

    .line 492
    .local v0, "e":Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;
    iget-object v4, p0, Ltv/freewheel/ad/AdRequest$2;->this$0:Ltv/freewheel/ad/AdRequest;

    iget-object v4, v4, Ltv/freewheel/ad/AdRequest;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "file not well formatted "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method
