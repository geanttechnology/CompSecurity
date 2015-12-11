.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Features;
.super Ljava/lang/Object;
.source "Features.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "features"
    strict = false
.end annotation


# instance fields
.field private feature:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;",
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
.method public getFeatures()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Feature;",
            ">;"
        }
    .end annotation

    .prologue
    .line 20
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Features;->feature:Ljava/util/ArrayList;

    return-object v0
.end method
