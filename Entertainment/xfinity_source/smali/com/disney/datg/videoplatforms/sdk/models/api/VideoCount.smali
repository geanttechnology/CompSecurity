.class public Lcom/disney/datg/videoplatforms/sdk/models/api/VideoCount;
.super Ljava/lang/Object;
.source "VideoCount.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
.end annotation


# instance fields
.field private total:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    const-string v0, "0"

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/VideoCount;->total:Ljava/lang/String;

    return-void
.end method
