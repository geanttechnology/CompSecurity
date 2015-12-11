.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;
.super Ljava/lang/Object;
.source "Assets.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "assets"
    strict = false
.end annotation


# instance fields
.field private asset:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;",
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
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAsset()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;",
            ">;"
        }
    .end annotation

    .prologue
    .line 19
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->asset:Ljava/util/ArrayList;

    return-object v0
.end method
