.class public abstract Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
.super Ljava/lang/Object;
.source "VPMedia.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;
    }
.end annotation


# static fields
.field public static LIVE:Ljava/lang/String;

.field private static TAG:Ljava/lang/String;

.field public static VOD:Ljava/lang/String;


# instance fields
.field protected accessWindow:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

.field protected affiliateId:Ljava/lang/String;

.field protected assetUrl:Ljava/lang/String;

.field protected authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

.field protected brandId:Ljava/lang/String;

.field protected ccEnabled:Z

.field private configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

.field protected contentUrl:Ljava/lang/String;

.field protected currentMetadata:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

.field protected currentRequest:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected currentToken:Ljava/lang/String;

.field protected mediaDesc:Ljava/lang/String;

.field protected mediaId:Ljava/lang/String;

.field protected mediaRating:Ljava/lang/String;

.field protected mediaTitle:Ljava/lang/String;

.field private onAuthZListener:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

.field protected playManifest:Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

.field protected signal:Ljava/util/concurrent/CountDownLatch;

.field protected thumbnails:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;",
            "Ljava/util/List",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;",
            ">;>;"
        }
    .end annotation
.end field

.field protected tokenToAuthorize:Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;

.field protected utcOffset:Ljava/lang/String;

.field protected workflowId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    const-string v0, "VPMedia"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->TAG:Ljava/lang/String;

    .line 38
    const-string v0, "LIVE"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->LIVE:Ljava/lang/String;

    .line 39
    const-string v0, "VOD"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->VOD:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->mediaId:Ljava/lang/String;

    .line 77
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->brandId:Ljava/lang/String;

    .line 79
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->contentUrl:Ljava/lang/String;

    .line 80
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->currentToken:Ljava/lang/String;

    .line 81
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->assetUrl:Ljava/lang/String;

    .line 82
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->UNDEFINED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->accessWindow:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    .line 83
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->mediaTitle:Ljava/lang/String;

    .line 84
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->mediaDesc:Ljava/lang/String;

    .line 85
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->mediaRating:Ljava/lang/String;

    .line 86
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->affiliateId:Ljava/lang/String;

    .line 87
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->utcOffset:Ljava/lang/String;

    .line 88
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->playManifest:Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

    .line 91
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->ccEnabled:Z

    .line 96
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->thumbnails:Ljava/util/Map;

    .line 98
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    .line 104
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    invoke-direct {v0, p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->currentMetadata:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    .line 105
    return-void
.end method

.method static synthetic access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->setAssetUrl(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$300(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;)V
    .locals 0
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .param p1, "x1"    # Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

    .prologue
    .line 34
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->setPlayManifest(Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;)V

    return-void
.end method

.method private setAssetUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "assetUrl"    # Ljava/lang/String;

    .prologue
    .line 162
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->assetUrl:Ljava/lang/String;

    .line 163
    return-void
.end method

.method private setPlayManifest(Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;)V
    .locals 0
    .param p1, "playManifest"    # Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

    .prologue
    .line 170
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->playManifest:Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

    .line 171
    return-void
.end method


# virtual methods
.method public addThumbnail(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;Ljava/util/List;)V
    .locals 1
    .param p1, "type"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;",
            "Ljava/util/List",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 239
    .local p2, "thumbnails":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->thumbnails:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 240
    return-void
.end method

.method public authorizeMediaWithAuthToken(Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;)V
    .locals 1
    .param p1, "token"    # Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;

    .prologue
    .line 251
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->tokenToAuthorize:Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;

    .line 252
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->RECEIVED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    .line 253
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->signal:Ljava/util/concurrent/CountDownLatch;

    if-eqz v0, :cond_0

    .line 254
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->signal:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 256
    :cond_0
    return-void
.end method

.method protected finalize()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 546
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 547
    return-void
.end method

.method public getAccessWindow()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->accessWindow:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    return-object v0
.end method

.method public getAssetUrl()Ljava/lang/String;
    .locals 5

    .prologue
    .line 259
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->assetUrl:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 260
    const-string v1, "%s?%s"

    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getContentUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    if-ne v0, v4, :cond_1

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getContentUrl()Ljava/lang/String;

    move-result-object v0

    :goto_0
    aput-object v0, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentToken()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    if-ne v0, v4, :cond_2

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentToken()Ljava/lang/String;

    move-result-object v0

    :goto_1
    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->assetUrl:Ljava/lang/String;

    .line 264
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->assetUrl:Ljava/lang/String;

    return-object v0

    .line 260
    :cond_1
    const-string v0, ""

    goto :goto_0

    :cond_2
    const-string v0, ""

    goto :goto_1
.end method

.method public getContentUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->contentUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;
    .locals 1

    .prologue
    .line 509
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->currentMetadata:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    return-object v0
.end method

.method public getCurrentToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->currentToken:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaDesc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->mediaDesc:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->mediaId:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->mediaTitle:Ljava/lang/String;

    return-object v0
.end method

.method public abstract getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;
.end method

.method public getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;
    .locals 1

    .prologue
    .line 243
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->onAuthZListener:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    return-object v0
.end method

.method public getPlayManifest()Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->playManifest:Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

    return-object v0
.end method

.method public getPlayableAssetUrl(Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 277
    .local p1, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;, "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler<Ljava/lang/String;>;"
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->getManager()Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;

    invoke-direct {v1, p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)V

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->execute(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->currentRequest:Ljava/util/concurrent/Future;

    .line 503
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->currentRequest:Ljava/util/concurrent/Future;

    return-object v0
.end method

.method public setAccessWindow(I)V
    .locals 1
    .param p1, "accessLevel"    # I

    .prologue
    .line 182
    packed-switch p1, :pswitch_data_0

    .line 196
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->UNDEFINED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->accessWindow:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    .line 197
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    .line 199
    :goto_0
    return-void

    .line 184
    :pswitch_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->FREE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->accessWindow:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    .line 185
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    goto :goto_0

    .line 188
    :pswitch_1
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->SUBSCRIPTION:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->accessWindow:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    .line 189
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    goto :goto_0

    .line 192
    :pswitch_2
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->MARKET:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->accessWindow:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    .line 193
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    goto :goto_0

    .line 182
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public setAffiliateId(Ljava/lang/String;)V
    .locals 0
    .param p1, "affiliateId"    # Ljava/lang/String;

    .prologue
    .line 230
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->affiliateId:Ljava/lang/String;

    .line 231
    return-void
.end method

.method protected setConfiguration(Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    .locals 1
    .param p1, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .prologue
    .line 521
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .line 522
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    if-eqz v0, :cond_0

    .line 523
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentNetwork()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->brandId:Ljava/lang/String;

    .line 525
    :cond_0
    return-void
.end method

.method public setContentUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "contentUrl"    # Ljava/lang/String;

    .prologue
    .line 150
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->contentUrl:Ljava/lang/String;

    .line 151
    return-void
.end method

.method public setMediaDesc(Ljava/lang/String;)V
    .locals 0
    .param p1, "mediaDesc"    # Ljava/lang/String;

    .prologue
    .line 214
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->mediaDesc:Ljava/lang/String;

    .line 215
    return-void
.end method

.method public setMediaId(Ljava/lang/String;)V
    .locals 0
    .param p1, "mediaId"    # Ljava/lang/String;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->mediaId:Ljava/lang/String;

    .line 116
    return-void
.end method

.method public setMediaRating(Ljava/lang/String;)V
    .locals 0
    .param p1, "mediaRating"    # Ljava/lang/String;

    .prologue
    .line 222
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->mediaRating:Ljava/lang/String;

    .line 223
    return-void
.end method

.method public setMediaTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "mediaTitle"    # Ljava/lang/String;

    .prologue
    .line 206
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->mediaTitle:Ljava/lang/String;

    .line 207
    return-void
.end method

.method public setOnAuthorizationListener(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;)V
    .locals 0
    .param p1, "onAuthZListener"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    .prologue
    .line 247
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->onAuthZListener:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    .line 248
    return-void
.end method

.method public setWorkflowId(Ljava/lang/String;)V
    .locals 0
    .param p1, "workflowId"    # Ljava/lang/String;

    .prologue
    .line 142
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->workflowId:Ljava/lang/String;

    .line 143
    return-void
.end method
