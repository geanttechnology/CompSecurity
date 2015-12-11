.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;
.super Ljava/lang/Object;
.source "Ads.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "adgroup"
    strict = false
.end annotation


# instance fields
.field private ad:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        name = "creative"
        required = false
    .end annotation
.end field

.field private label:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field

.field private type:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
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

    .line 19
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;->ad:Ljava/util/ArrayList;

    .line 22
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;->type:Ljava/lang/String;

    .line 25
    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;->label:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getAd()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;->ad:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;->type:Ljava/lang/String;

    return-object v0
.end method
