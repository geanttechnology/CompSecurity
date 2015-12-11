.class public Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
.super Ljava/lang/Object;
.source "PlayManifest.java"


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "playmanifest"
    strict = false
.end annotation


# instance fields
.field private adlist:Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;
    .annotation runtime Lorg/simpleframework/xml/Element;
        name = "adlist"
        required = false
    .end annotation
.end field

.field private channel:Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;
    .annotation runtime Lorg/simpleframework/xml/Element;
        name = "channel"
        required = false
    .end annotation
.end field

.field private entitlmentResponse:Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;
    .annotation runtime Lorg/simpleframework/xml/Element;
        name = "entitlement"
        required = false
    .end annotation
.end field

.field private video:Lcom/disney/datg/videoplatforms/sdk/models/api/Video;
    .annotation runtime Lorg/simpleframework/xml/Element;
        name = "video"
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->entitlmentResponse:Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;

    .line 12
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->adlist:Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;

    .line 15
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->video:Lcom/disney/datg/videoplatforms/sdk/models/api/Video;

    .line 18
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->channel:Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;

    return-void
.end method


# virtual methods
.method public getAdCollection()Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->adlist:Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;

    return-object v0
.end method

.method public getChannel()Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->channel:Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;

    return-object v0
.end method

.method public getEntitlmentResponse()Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->entitlmentResponse:Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;

    return-object v0
.end method

.method public getVideo()Lcom/disney/datg/videoplatforms/sdk/models/api/Video;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->video:Lcom/disney/datg/videoplatforms/sdk/models/api/Video;

    return-object v0
.end method
