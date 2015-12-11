.class public Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private chatType:Ljava/lang/String;

.field private contractCondition:Ljava/lang/String;

.field private fileSize:Ljava/lang/String;

.field private format:Ljava/lang/String;

.field private freeShippingCode:Ljava/lang/String;

.field private mediaType:Ljava/lang/String;

.field private primaryArtist:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PrimaryArtist;",
            ">;"
        }
    .end annotation
.end field

.field private topHat:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getChatType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->chatType:Ljava/lang/String;

    return-object v0
.end method

.method public getContractCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->contractCondition:Ljava/lang/String;

    return-object v0
.end method

.method public getFileSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->fileSize:Ljava/lang/String;

    return-object v0
.end method

.method public getFormat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->format:Ljava/lang/String;

    return-object v0
.end method

.method public getFreeShippingCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->freeShippingCode:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->mediaType:Ljava/lang/String;

    return-object v0
.end method

.method public getPrimaryArtist()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PrimaryArtist;",
            ">;"
        }
    .end annotation

    .prologue
    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->primaryArtist:Ljava/util/List;

    return-object v0
.end method

.method public getTopHat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->topHat:Ljava/lang/String;

    return-object v0
.end method

.method public setChatType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->chatType:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setContractCondition(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->contractCondition:Ljava/lang/String;

    .line 72
    return-void
.end method

.method public setFileSize(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->fileSize:Ljava/lang/String;

    .line 97
    return-void
.end method

.method public setFormat(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->format:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setFreeShippingCode(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->freeShippingCode:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public setMediaType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->mediaType:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public setPrimaryArtist(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PrimaryArtist;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 88
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->primaryArtist:Ljava/util/List;

    .line 89
    return-void
.end method

.method public setTopHat(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 104
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->topHat:Ljava/lang/String;

    .line 105
    return-void
.end method
