.class public Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
.super Ljava/lang/Object;
.source "AdBreak.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "adbreak"
    strict = false
.end annotation


# instance fields
.field private adEventStarted:Z

.field private adgroup:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        name = "adgroup"
        required = false
    .end annotation
.end field

.field private analytics:Lcom/disney/datg/videoplatforms/sdk/models/api/Analytics;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private end:F
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private num:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
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

.field private watched:Z


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->type:Ljava/lang/String;

    .line 24
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->num:Ljava/lang/String;

    .line 27
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->analytics:Lcom/disney/datg/videoplatforms/sdk/models/api/Analytics;

    .line 31
    iput v1, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->start:F

    .line 34
    iput v1, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->end:F

    .line 37
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->adgroup:Ljava/util/ArrayList;

    .line 40
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->watched:Z

    .line 42
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->adEventStarted:Z

    return-void
.end method


# virtual methods
.method public getAdgroup()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;",
            ">;"
        }
    .end annotation

    .prologue
    .line 59
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->adgroup:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getEnd()F
    .locals 1

    .prologue
    .line 78
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->end:F

    return v0
.end method

.method public getNum()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->num:Ljava/lang/String;

    return-object v0
.end method

.method public getStart()F
    .locals 1

    .prologue
    .line 72
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->start:F

    return v0
.end method

.method public isAdEventStarted()Z
    .locals 1

    .prologue
    .line 90
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->adEventStarted:Z

    return v0
.end method

.method public isWatched()Z
    .locals 1

    .prologue
    .line 84
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->watched:Z

    return v0
.end method

.method public setAdEventStarted(Z)V
    .locals 0
    .param p1, "adEventStarted"    # Z

    .prologue
    .line 93
    iput-boolean p1, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->adEventStarted:Z

    .line 94
    return-void
.end method

.method public setWatched(Z)V
    .locals 0
    .param p1, "watched"    # Z

    .prologue
    .line 87
    iput-boolean p1, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->watched:Z

    .line 88
    return-void
.end method
