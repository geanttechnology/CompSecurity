.class public Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;
.super Ljava/lang/Object;
.source "TrackCode.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "trackcode"
    strict = false
.end annotation


# instance fields
.field private generic:Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getGeneric()Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/TrackCode;->generic:Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;

    return-object v0
.end method
