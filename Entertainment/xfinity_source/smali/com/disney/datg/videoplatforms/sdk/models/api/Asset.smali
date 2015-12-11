.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;
.super Ljava/lang/Object;
.source "Asset.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "asset"
    strict = false
.end annotation


# instance fields
.field private accesslevel:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field

.field private format:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field

.field private lang:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field

.field private storageid:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field

.field private value:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Text;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    const-string v0, "en-us"

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->lang:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getAccesslevel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->accesslevel:Ljava/lang/String;

    return-object v0
.end method

.method public getFormat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->format:Ljava/lang/String;

    return-object v0
.end method

.method public getStorageid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->storageid:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->value:Ljava/lang/String;

    return-object v0
.end method
