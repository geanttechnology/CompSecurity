.class public Lcom/disney/datg/videoplatforms/sdk/models/api/PartnerVideo;
.super Ljava/lang/Object;
.source "PartnerVideo.java"

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/lang/Cloneable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "video"
    strict = false
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

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
    .line 145
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
