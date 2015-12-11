.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;
.super Ljava/lang/Object;
.source "Thumbnails.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "thumbnails"
    strict = false
.end annotation


# instance fields
.field private thumbnail:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
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
.method public getThumbnail()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnail;",
            ">;"
        }
    .end annotation

    .prologue
    .line 28
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Thumbnails;->thumbnail:Ljava/util/ArrayList;

    return-object v0
.end method
