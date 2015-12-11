.class public Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;
.super Ljava/lang/Object;
.source "AdCollection.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "adlist"
    strict = false
.end annotation


# instance fields
.field private adbreak:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        name = "adbreak"
        required = false
    .end annotation
.end field

.field private build:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field

.field private error:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;->adbreak:Ljava/util/ArrayList;

    .line 25
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;->error:Ljava/lang/String;

    .line 28
    const-string v0, "1"

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;->build:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getAdbreak()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;->adbreak:Ljava/util/ArrayList;

    return-object v0
.end method
