.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;
.super Ljava/lang/Object;
.source "Channel.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    strict = false
.end annotation


# instance fields
.field private accesslevel:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field

.field private assets:Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private description:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private id:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
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
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAccesslevel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->accesslevel:Ljava/lang/String;

    return-object v0
.end method

.method public getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->assets:Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getThumbnails()Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->thumbnails:Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getTvrating()Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;
    .locals 1

    .prologue
    .line 181
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->tvrating:Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;

    return-object v0
.end method

.method public getWorkflowid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->workflowid:Ljava/lang/String;

    return-object v0
.end method
