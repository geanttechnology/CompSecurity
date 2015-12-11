.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Show;
.super Ljava/lang/Object;
.source "Show.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "show"
    strict = false
.end annotation


# instance fields
.field private thumbnails:Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private trackcode:Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->thumbnails:Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    return-object v0
.end method

.method public getTrackcode()Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Show;->trackcode:Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;

    return-object v0
.end method
