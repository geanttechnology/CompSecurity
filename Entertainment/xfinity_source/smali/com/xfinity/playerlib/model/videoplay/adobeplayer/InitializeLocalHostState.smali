.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;
.source "InitializeLocalHostState.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 0
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 18
    return-void
.end method

.method private startLocalHostServer(Ljava/lang/String;)V
    .locals 7
    .param p1, "baseDirectory"    # Ljava/lang/String;

    .prologue
    .line 41
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLocalHostServer()Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 42
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLocalHostServer()Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->stop()V

    .line 43
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setLocalHostServer(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;)V

    .line 52
    :cond_0
    const/4 v4, 0x0

    .line 53
    .local v4, "tries":I
    const/4 v3, 0x0

    .line 55
    .local v3, "lastException":Ljava/lang/Throwable;
    :goto_0
    const/16 v5, 0xf

    if-ge v4, v5, :cond_1

    .line 57
    :try_start_0
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 58
    .local v0, "directoryFile":Ljava/io/File;
    new-instance v2, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getHttpPort()I

    move-result v5

    invoke-direct {v2, v5, v0}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;-><init>(ILjava/io/File;)V

    .line 59
    .local v2, "httpd":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setLocalHostServer(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;)V

    .line 60
    new-instance v5, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;

    iget-object v6, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v5, v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {p0, v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 69
    .end local v0    # "directoryFile":Ljava/io/File;
    .end local v2    # "httpd":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;
    :cond_1
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLocalHostServer()Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    move-result-object v5

    if-nez v5, :cond_2

    .line 70
    new-instance v5, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    iget-object v6, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v5, v6, v3, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/Throwable;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    invoke-virtual {p0, v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 73
    :cond_2
    return-void

    .line 62
    :catch_0
    move-exception v1

    .line 63
    .local v1, "e":Ljava/io/IOException;
    add-int/lit8 v4, v4, 0x1

    .line 64
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->incrementHttpPort()V

    .line 65
    move-object v3, v1

    .line 66
    goto :goto_0
.end method


# virtual methods
.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    const-string v0, "InitializeLocalHostState"

    return-object v0
.end method

.method public run()V
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getDownloadedFile()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getFileDirectory()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->startLocalHostServer(Ljava/lang/String;)V

    .line 37
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "newState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 22
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/PlayerPreparingState;

    if-eqz v0, :cond_0

    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/InitializeLocalHostState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 27
    :goto_0
    return-void

    .line 25
    :cond_0
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
