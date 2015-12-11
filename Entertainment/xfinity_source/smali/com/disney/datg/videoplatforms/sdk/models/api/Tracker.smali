.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Tracker;
.super Ljava/lang/Object;
.source "Tracker.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "tracker"
    strict = false
.end annotation


# instance fields
.field private click:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/ClickBeacon;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        name = "click"
        required = false
    .end annotation
.end field

.field private end:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/EndBeacon;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        name = "end"
        required = false
    .end annotation
.end field

.field private firstquartile:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/FirstBeacon;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        name = "firstquartile"
        required = false
    .end annotation
.end field

.field private mid:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/MidBeacon;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        name = "mid"
        required = false
    .end annotation
.end field

.field private start:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/StartBeacon;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        name = "start"
        required = false
    .end annotation
.end field

.field private thirdquartile:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/ThirdBeacon;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        name = "thirdquartile"
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Tracker;->start:Ljava/util/ArrayList;

    .line 25
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Tracker;->end:Ljava/util/ArrayList;

    .line 28
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Tracker;->click:Ljava/util/ArrayList;

    .line 31
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Tracker;->firstquartile:Ljava/util/ArrayList;

    .line 34
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Tracker;->mid:Ljava/util/ArrayList;

    .line 37
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Tracker;->thirdquartile:Ljava/util/ArrayList;

    return-void
.end method
