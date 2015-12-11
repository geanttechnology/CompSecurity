.class public Lcom/adobe/mediacore/MediaPlayerItemLoader;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private _context:Landroid/content/Context;

.field private _isProtected:Z

.field private _listener:Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private _mediaResource:Lcom/adobe/mediacore/MediaResource;

.field private _videoEngine:Lcom/adobe/ave/VideoEngine;

.field private _videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

.field private _videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

.field private _videoEngineListener:Lcom/adobe/ave/VideoEngineListener;

.field private final contentId:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/MediaPlayerItemLoader;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;)V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_logger:Lcom/adobe/mediacore/logging/Logger;

    const/4 v0, 0x0

    iput v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->contentId:I

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Video engine context parameter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    if-nez p2, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Video engine dispatcher parameter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_context:Landroid/content/Context;

    iput-object p2, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_listener:Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;

    new-instance v0, Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-direct {v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    :try_start_0
    new-instance v0, Lcom/adobe/ave/VideoEngine;

    invoke-direct {v0}, Lcom/adobe/ave/VideoEngine;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    sget-object v0, Lcom/adobe/ave/ListenerType;->ERROR:Lcom/adobe/ave/ListenerType;

    sget-object v1, Lcom/adobe/ave/ListenerType;->DRM_METADATA:Lcom/adobe/ave/ListenerType;

    sget-object v2, Lcom/adobe/ave/ListenerType;->TIMELINE:Lcom/adobe/ave/ListenerType;

    invoke-static {v0, v1, v2}, Ljava/util/EnumSet;->of(Ljava/lang/Enum;Ljava/lang/Enum;Ljava/lang/Enum;)Ljava/util/EnumSet;

    move-result-object v0

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->createEngineListener()Lcom/adobe/ave/VideoEngineListener;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngineListener:Lcom/adobe/ave/VideoEngineListener;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngineListener:Lcom/adobe/ave/VideoEngineListener;

    invoke-virtual {v1, v0, v2}, Lcom/adobe/ave/VideoEngine;->addListener(Ljava/util/Set;Lcom/adobe/ave/VideoEngineListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v1, v0}, Lcom/adobe/ave/VideoEngine;->setLocalStoragePath(Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_listener:Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v2

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;->onError(Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/ave/VideoEngine;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-object v0
.end method

.method static synthetic access$300(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_isProtected:Z

    return v0
.end method

.method static synthetic access$302(Lcom/adobe/mediacore/MediaPlayerItemLoader;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_isProtected:Z

    return p1
.end method

.method static synthetic access$400(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/VideoEngineItem;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    return-object v0
.end method

.method static synthetic access$402(Lcom/adobe/mediacore/MediaPlayerItemLoader;Lcom/adobe/mediacore/VideoEngineItem;)Lcom/adobe/mediacore/VideoEngineItem;
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;

    return-object p1
.end method

.method static synthetic access$500(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/VideoEngineDispatcher;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    return-object v0
.end method

.method static synthetic access$600(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/MediaResource;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    return-object v0
.end method

.method static synthetic access$700(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_listener:Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;

    return-object v0
.end method

.method private convertType(Lcom/adobe/mediacore/MediaResource$Type;)Lcom/adobe/ave/ContainerType;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaResource$Type;->HDS:Lcom/adobe/mediacore/MediaResource$Type;

    if-ne p1, v0, :cond_0

    sget-object v0, Lcom/adobe/ave/ContainerType;->F4M:Lcom/adobe/ave/ContainerType;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/MediaResource$Type;->HLS:Lcom/adobe/mediacore/MediaResource$Type;

    if-ne p1, v0, :cond_1

    sget-object v0, Lcom/adobe/ave/ContainerType;->HLS:Lcom/adobe/ave/ContainerType;

    goto :goto_0

    :cond_1
    sget-object v0, Lcom/adobe/ave/ContainerType;->UNDEFINED:Lcom/adobe/ave/ContainerType;

    goto :goto_0
.end method

.method private createEngineListener()Lcom/adobe/ave/VideoEngineListener;
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;-><init>(Lcom/adobe/mediacore/MediaPlayerItemLoader;)V

    return-object v0
.end method


# virtual methods
.method public load(Lcom/adobe/mediacore/MediaResource;)V
    .locals 4

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaResource;->getType()Lcom/adobe/mediacore/MediaResource$Type;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->convertType(Lcom/adobe/mediacore/MediaResource$Type;)Lcom/adobe/ave/ContainerType;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngine:Lcom/adobe/ave/VideoEngine;

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v1, v3}, Lcom/adobe/ave/VideoEngine;->load(Ljava/lang/String;Lcom/adobe/ave/ContainerType;I)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader;->_listener:Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v2

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;->onError(Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V

    goto :goto_0
.end method
