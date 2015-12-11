.class public Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;
.super Ljava/lang/Object;
.source "AdAsset.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "creative"
    strict = false
.end annotation


# instance fields
.field private affiliate:Z
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private analytics:Lcom/disney/datg/videoplatforms/sdk/models/api/Analytics;
    .annotation runtime Lorg/simpleframework/xml/Element;
        name = "analytics"
        required = false
    .end annotation
.end field

.field private asset:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private duration:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private end:F
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private format:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private info:Lcom/disney/datg/videoplatforms/sdk/models/api/Info;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private playthrough:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        name = "onPlayEndAutoContinue"
        required = false
    .end annotation
.end field

.field private start:F
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private type:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->asset:Ljava/lang/String;

    .line 24
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->format:Ljava/lang/String;

    .line 27
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->duration:Ljava/lang/String;

    .line 30
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->type:Ljava/lang/String;

    .line 39
    const-string v0, "true"

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->playthrough:Ljava/lang/String;

    .line 51
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->analytics:Lcom/disney/datg/videoplatforms/sdk/models/api/Analytics;

    .line 54
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->info:Lcom/disney/datg/videoplatforms/sdk/models/api/Info;

    .line 57
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->affiliate:Z

    return-void
.end method


# virtual methods
.method public getDuration()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->duration:Ljava/lang/String;

    return-object v0
.end method

.method public getEnd()F
    .locals 1

    .prologue
    .line 176
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->end:F

    return v0
.end method

.method public getStart()F
    .locals 1

    .prologue
    .line 168
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->start:F

    return v0
.end method
