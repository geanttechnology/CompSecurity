.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Video;
.super Ljava/lang/Object;
.source "Video.java"

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/lang/Cloneable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "video"
    strict = false
.end annotation


# instance fields
.field private accesslevel:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field

.field private adtarget:Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private airdates:Lcom/disney/datg/videoplatforms/sdk/models/api/Airdates;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private assets:Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private availdate:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private description:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private duration:Lcom/disney/datg/videoplatforms/sdk/models/api/Duration;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private expiredate:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private id:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field

.field private inSubWindon:Z
    .annotation runtime Lorg/simpleframework/xml/Transient;
    .end annotation
.end field

.field private number:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private season:Lcom/disney/datg/videoplatforms/sdk/models/api/Season;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private show:Lcom/disney/datg/videoplatforms/sdk/models/api/Show;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private thumbnails:Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private title:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private tvrating:Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private workflowid:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 119
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->inSubWindon:Z

    return-void
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 311
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getAccesslevel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 367
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->accesslevel:Ljava/lang/String;

    return-object v0
.end method

.method public getAdtarget()Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;
    .locals 1

    .prologue
    .line 286
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->adtarget:Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;

    return-object v0
.end method

.method public getAirdates()Lcom/disney/datg/videoplatforms/sdk/models/api/Airdates;
    .locals 1

    .prologue
    .line 237
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->airdates:Lcom/disney/datg/videoplatforms/sdk/models/api/Airdates;

    return-object v0
.end method

.method public getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;
    .locals 1

    .prologue
    .line 280
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->assets:Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    return-object v0
.end method

.method public getAvaildate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 243
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->availdate:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getDuration()Lcom/disney/datg/videoplatforms/sdk/models/api/Duration;
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->duration:Lcom/disney/datg/videoplatforms/sdk/models/api/Duration;

    return-object v0
.end method

.method public getExpiredate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 249
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->expiredate:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->number:Ljava/lang/String;

    return-object v0
.end method

.method public getSeason()Lcom/disney/datg/videoplatforms/sdk/models/api/Season;
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->season:Lcom/disney/datg/videoplatforms/sdk/models/api/Season;

    return-object v0
.end method

.method public getShow()Lcom/disney/datg/videoplatforms/sdk/models/api/Show;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->show:Lcom/disney/datg/videoplatforms/sdk/models/api/Show;

    return-object v0
.end method

.method public getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;
    .locals 1

    .prologue
    .line 305
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->thumbnails:Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getTvrating()Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->tvrating:Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;

    return-object v0
.end method

.method public getWorkflowid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 355
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->workflowid:Ljava/lang/String;

    return-object v0
.end method
