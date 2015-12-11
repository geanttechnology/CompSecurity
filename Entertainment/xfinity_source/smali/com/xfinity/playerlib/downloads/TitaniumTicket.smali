.class public Lcom/xfinity/playerlib/downloads/TitaniumTicket;
.super Ljava/lang/Object;
.source "TitaniumTicket.java"


# instance fields
.field private assetExpirationDate:Ljava/util/Date;

.field private key:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "xsct"
    .end annotation
.end field

.field private licenseExpirationDate:Ljava/util/Date;

.field private persistent:Z

.field private releasePid:Ljava/lang/String;

.field private signature:Ljava/lang/String;

.field private signatureKey:Ljava/lang/String;

.field private signedFields:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private timestamp:Ljava/util/Date;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAssetExpirationDate()Ljava/util/Date;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonDeserialize;
        using = Lcom/comcast/cim/utils/TimestampInSecondsDeserializer;
    .end annotation

    .annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonSerialize;
        using = Lcom/comcast/cim/utils/TimestampInSecondsSerializer;
    .end annotation

    .prologue
    .line 29
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicket;->assetExpirationDate:Ljava/util/Date;

    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "xsct"
    .end annotation

    .prologue
    .line 34
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicket;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getLicenseExpirationDate()Ljava/util/Date;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonDeserialize;
        using = Lcom/comcast/cim/utils/TimestampInSecondsDeserializer;
    .end annotation

    .annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonSerialize;
        using = Lcom/comcast/cim/utils/TimestampInSecondsSerializer;
    .end annotation

    .prologue
    .line 40
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicket;->licenseExpirationDate:Ljava/util/Date;

    return-object v0
.end method

.method public getReleasePid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicket;->releasePid:Ljava/lang/String;

    return-object v0
.end method

.method public getSignature()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicket;->signature:Ljava/lang/String;

    return-object v0
.end method

.method public getSignatureKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicket;->signatureKey:Ljava/lang/String;

    return-object v0
.end method

.method public getSignedFields()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 60
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicket;->signedFields:Ljava/util/List;

    return-object v0
.end method

.method public getTimestamp()Ljava/util/Date;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonDeserialize;
        using = Lcom/comcast/cim/utils/TimestampInSecondsDeserializer;
    .end annotation

    .annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonSerialize;
        using = Lcom/comcast/cim/utils/TimestampInSecondsSerializer;
    .end annotation

    .prologue
    .line 66
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicket;->timestamp:Ljava/util/Date;

    return-object v0
.end method

.method public isPersistent()Z
    .locals 1

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicket;->persistent:Z

    return v0
.end method
