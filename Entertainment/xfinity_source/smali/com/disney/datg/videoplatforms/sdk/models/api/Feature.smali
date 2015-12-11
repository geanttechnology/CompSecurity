.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;
.super Ljava/lang/Object;
.source "Feature.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "feature"
    strict = false
.end annotation


# instance fields
.field private id:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        name = "id"
        required = true
    .end annotation
.end field

.field private param:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Param;",
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
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getParam()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Param;",
            ">;"
        }
    .end annotation

    .prologue
    .line 27
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;->param:Ljava/util/ArrayList;

    return-object v0
.end method
