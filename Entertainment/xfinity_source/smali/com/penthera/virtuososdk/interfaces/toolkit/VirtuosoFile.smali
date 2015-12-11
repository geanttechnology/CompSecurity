.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;
.super Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;
.source "VirtuosoFile.java"

# interfaces
.implements Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoFile;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field iAssetId:Ljava/lang/String;

.field iAssetURL:Ljava/lang/String;

.field iCurrentSize:D

.field iDescription:Ljava/lang/String;

.field iErrorCount:J

.field iExpectedSize:D

.field iFileHash:Ljava/lang/String;

.field iFilePath:Ljava/lang/String;

.field iIsPending:Z

.field iLastUpdateTime:J

.field iMD5State:Lcom/penthera/virtuososdk/download/MD5State;

.field iMimeType:Ljava/lang/String;

.field iName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 79
    new-instance v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile$1;

    invoke-direct {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile$1;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 26
    return-void
.end method

.method constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 44
    invoke-direct {p0, v2, v2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;-><init>(II)V

    .line 32
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iExpectedSize:D

    .line 34
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iCurrentSize:D

    .line 39
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iIsPending:Z

    .line 41
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iLastUpdateTime:J

    .line 45
    return-void
.end method

.method constructor <init>(Landroid/database/Cursor;)V
    .locals 0
    .param p1, "c"    # Landroid/database/Cursor;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;-><init>()V

    .line 98
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->refresh(Landroid/database/Cursor;)V

    .line 99
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 91
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;-><init>()V

    .line 32
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iExpectedSize:D

    .line 34
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iCurrentSize:D

    .line 39
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iIsPending:Z

    .line 41
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iLastUpdateTime:J

    .line 93
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->readFromParcel(Landroid/os/Parcel;)V

    .line 94
    return-void
.end method


# virtual methods
.method public assetId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iAssetId:Ljava/lang/String;

    return-object v0
.end method

.method public assetURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iAssetURL:Ljava/lang/String;

    return-object v0
.end method

.method public currentSize()D
    .locals 2

    .prologue
    .line 207
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iCurrentSize:D

    return-wide v0
.end method

.method public errorCount()J
    .locals 2

    .prologue
    .line 202
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iErrorCount:J

    return-wide v0
.end method

.method public expectedSize()D
    .locals 2

    .prologue
    .line 197
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iExpectedSize:D

    return-wide v0
.end method

.method public fileMD5()Ljava/lang/String;
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iFileHash:Ljava/lang/String;

    return-object v0
.end method

.method public filePath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iFilePath:Ljava/lang/String;

    return-object v0
.end method

.method public fractionComplete()D
    .locals 4

    .prologue
    const-wide/16 v0, 0x0

    .line 212
    iget-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iExpectedSize:D

    cmpg-double v2, v2, v0

    if-gtz v2, :cond_0

    .line 213
    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iCurrentSize:D

    iget-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iExpectedSize:D

    div-double/2addr v0, v2

    goto :goto_0
.end method

.method public isPending()Z
    .locals 1

    .prologue
    .line 291
    iget-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iIsPending:Z

    return v0
.end method

.method public md5State()Lcom/penthera/virtuososdk/download/MD5State;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iMD5State:Lcom/penthera/virtuososdk/download/MD5State;

    return-object v0
.end method

.method public md5StateAsByteArray()[B
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iMD5State:Lcom/penthera/virtuososdk/download/MD5State;

    invoke-static {v0}, Lcom/penthera/virtuososdk/utility/Serialization;->serializeObject(Ljava/lang/Object;)[B

    move-result-object v0

    return-object v0
.end method

.method public metadata()Ljava/lang/String;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iDescription:Ljava/lang/String;

    return-object v0
.end method

.method public mimeType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 280
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iMimeType:Ljava/lang/String;

    return-object v0
.end method

.method protected readFromParcel(Landroid/os/Parcel;)V
    .locals 4
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v0, 0x1

    .line 129
    invoke-super {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->readFromParcel(Landroid/os/Parcel;)V

    .line 131
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iAssetURL:Ljava/lang/String;

    .line 132
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iAssetId:Ljava/lang/String;

    .line 133
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iDescription:Ljava/lang/String;

    .line 134
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v2

    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iExpectedSize:D

    .line 135
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v2

    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iCurrentSize:D

    .line 136
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iFilePath:Ljava/lang/String;

    .line 137
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iFileHash:Ljava/lang/String;

    .line 138
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iMimeType:Ljava/lang/String;

    .line 139
    invoke-virtual {p1}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setMd5State([B)V

    .line 140
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iIsPending:Z

    .line 141
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iName:Ljava/lang/String;

    .line 143
    return-void

    .line 140
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method refresh(Landroid/database/Cursor;)V
    .locals 4
    .param p1, "c"    # Landroid/database/Cursor;

    .prologue
    const/4 v1, 0x1

    .line 102
    const-string v0, "assetUrl"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setAssetUrl(Ljava/lang/String;)V

    .line 103
    const-string v0, "assetId"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setAssetId(Ljava/lang/String;)V

    .line 104
    const-string v0, "description"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setMetadata(Ljava/lang/String;)V

    .line 105
    const-string v0, "fileHash"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setFileMD5(Ljava/lang/String;)V

    .line 106
    const-string v0, "mimeType"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setMimeType(Ljava/lang/String;)V

    .line 107
    const-string v0, "currentSize"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-double v2, v2

    invoke-virtual {p0, v2, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setCurrentSize(D)V

    .line 108
    const-string v0, "expectedSize"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-double v2, v2

    invoke-virtual {p0, v2, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setExpectedSize(D)V

    .line 109
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->values()[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    const-string v2, "errorType"

    invoke-interface {p1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p1, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-int v2, v2

    aget-object v0, v0, v2

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 110
    const-string v0, "filePath"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setFilePath(Ljava/lang/String;)V

    .line 111
    const-string v0, "uuid"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setUuid(Ljava/lang/String;)V

    .line 112
    const-string v0, "errorCount"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-virtual {p0, v2, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setErrorCount(J)V

    .line 113
    const-string v0, "hashState"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setMd5State([B)V

    .line 114
    const-string v0, "pending"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getShort(I)S

    move-result v0

    if-ne v0, v1, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setPending(Z)V

    .line 115
    const-string v0, "parentUuid"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setParentUuid(Ljava/lang/String;)V

    .line 116
    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setType(I)V

    .line 117
    const-string v0, "_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setId(I)V

    .line 118
    const-string v0, "completeTime"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setCompletionTime(J)V

    .line 119
    const-string v0, "clientAuthority"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setClientProviderAuth(Ljava/lang/String;)V

    .line 120
    const-string v0, "contentState"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setContentState(I)V

    .line 121
    return-void

    .line 114
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public regenerateFilePath(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/Context;)V
    .locals 1
    .param p1, "cr"    # Landroid/content/ContentResolver;
    .param p2, "client"    # Ljava/lang/String;
    .param p3, "cx"    # Landroid/content/Context;

    .prologue
    .line 302
    invoke-static {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->generateFilePath(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setFilePath(Ljava/lang/String;)V

    .line 303
    return-void
.end method

.method public setAssetId(Ljava/lang/String;)V
    .locals 2
    .param p1, "aAssetId"    # Ljava/lang/String;

    .prologue
    .line 229
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "aAssetId must be provided"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 230
    :cond_0
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iAssetId:Ljava/lang/String;

    .line 231
    return-void
.end method

.method public setAssetUrl(Ljava/lang/String;)V
    .locals 3
    .param p1, "aAssetUrl"    # Ljava/lang/String;

    .prologue
    .line 236
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "aAssetUrl must be provided"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 238
    :cond_0
    :try_start_0
    new-instance v1, Ljava/net/URL;

    invoke-direct {v1, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 242
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iAssetURL:Ljava/lang/String;

    .line 243
    return-void

    .line 239
    :catch_0
    move-exception v0

    .line 240
    .local v0, "e":Ljava/net/MalformedURLException;
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "aAssetUrl must be a valid URL"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public setCurrentSize(D)V
    .locals 1
    .param p1, "aCurrentSize"    # D

    .prologue
    .line 264
    iput-wide p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iCurrentSize:D

    .line 265
    return-void
.end method

.method public setErrorCount(J)V
    .locals 3
    .param p1, "aErrorCount"    # J

    .prologue
    .line 259
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "aErrorCount must be greater than or equal 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 260
    :cond_0
    iput-wide p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iErrorCount:J

    .line 261
    return-void
.end method

.method public setExpectedSize(D)V
    .locals 3
    .param p1, "aExpectedSize"    # D

    .prologue
    .line 254
    const-wide/16 v0, 0x0

    cmpg-double v0, p1, v0

    if-gez v0, :cond_0

    const-wide/high16 p1, -0x4010000000000000L    # -1.0

    .end local p1    # "aExpectedSize":D
    :cond_0
    iput-wide p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iExpectedSize:D

    .line 255
    return-void
.end method

.method public setFileMD5(Ljava/lang/String;)V
    .locals 0
    .param p1, "aHash"    # Ljava/lang/String;

    .prologue
    .line 270
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iFileHash:Ljava/lang/String;

    .line 271
    return-void
.end method

.method public setFilePath(Ljava/lang/String;)V
    .locals 0
    .param p1, "aPath"    # Ljava/lang/String;

    .prologue
    .line 275
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iFilePath:Ljava/lang/String;

    .line 276
    return-void
.end method

.method public setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V
    .locals 1
    .param p1, "aNewState"    # Lcom/penthera/virtuososdk/download/MD5State;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iMD5State:Lcom/penthera/virtuososdk/download/MD5State;

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/MD5State;->copy(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 167
    return-void
.end method

.method public setMd5State([B)V
    .locals 1
    .param p1, "aNewState"    # [B

    .prologue
    .line 172
    if-nez p1, :cond_0

    .line 174
    :goto_0
    return-void

    .line 173
    :cond_0
    invoke-static {p1}, Lcom/penthera/virtuososdk/utility/Serialization;->deserializeObject([B)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/download/MD5State;

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iMD5State:Lcom/penthera/virtuososdk/download/MD5State;

    goto :goto_0
.end method

.method public setMetadata(Ljava/lang/String;)V
    .locals 0
    .param p1, "aMetaData"    # Ljava/lang/String;

    .prologue
    .line 247
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iDescription:Ljava/lang/String;

    .line 249
    return-void
.end method

.method public setMimeType(Ljava/lang/String;)V
    .locals 0
    .param p1, "aMimeType"    # Ljava/lang/String;

    .prologue
    .line 285
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iMimeType:Ljava/lang/String;

    .line 286
    return-void
.end method

.method public setPending(Z)V
    .locals 0
    .param p1, "aPending"    # Z

    .prologue
    .line 297
    iput-boolean p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iIsPending:Z

    .line 298
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flag"    # I

    .prologue
    .line 148
    invoke-super {p0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->writeToParcel(Landroid/os/Parcel;I)V

    .line 149
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iAssetURL:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 150
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iAssetId:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 151
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iDescription:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 152
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iExpectedSize:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 153
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iCurrentSize:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 154
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iFilePath:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 155
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iFileHash:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 156
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iMimeType:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 157
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->md5StateAsByteArray()[B

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByteArray([B)V

    .line 158
    iget-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iIsPending:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 159
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->iName:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 160
    return-void

    .line 158
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
