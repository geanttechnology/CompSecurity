.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;
.super Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;
.source "VirtuosoFolderCollection.java"

# interfaces
.implements Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field iAssetId:Ljava/lang/String;

.field iAssetURL:Ljava/lang/String;

.field iCompleted:I

.field iCurrentSize:D

.field iExpectedSize:D

.field iMetaData:Ljava/lang/String;

.field iSize:I

.field isAdded:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-class v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->LOG_TAG:Ljava/lang/String;

    .line 28
    return-void
.end method

.method constructor <init>()V
    .locals 4

    .prologue
    const/4 v1, 0x2

    const-wide/16 v2, 0x0

    const/4 v0, 0x0

    .line 44
    invoke-direct {p0, v1, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;-><init>(II)V

    .line 37
    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCompleted:I

    .line 38
    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iSize:I

    .line 39
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->isAdded:Z

    .line 40
    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCurrentSize:D

    .line 41
    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iExpectedSize:D

    .line 45
    return-void
.end method

.method constructor <init>(I)V
    .locals 4
    .param p1, "aType"    # I

    .prologue
    const-wide/16 v2, 0x0

    const/4 v0, 0x0

    .line 48
    invoke-direct {p0, p1, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;-><init>(II)V

    .line 37
    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCompleted:I

    .line 38
    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iSize:I

    .line 39
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->isAdded:Z

    .line 40
    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCurrentSize:D

    .line 41
    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iExpectedSize:D

    .line 49
    return-void
.end method

.method constructor <init>(Landroid/database/Cursor;)V
    .locals 0
    .param p1, "c"    # Landroid/database/Cursor;

    .prologue
    .line 225
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;-><init>()V

    .line 227
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->refresh(Landroid/database/Cursor;)V

    .line 228
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 4
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const-wide/16 v2, 0x0

    const/4 v0, 0x0

    .line 64
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;-><init>()V

    .line 37
    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCompleted:I

    .line 38
    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iSize:I

    .line 39
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->isAdded:Z

    .line 40
    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCurrentSize:D

    .line 41
    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iExpectedSize:D

    .line 66
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->readFromParcel(Landroid/os/Parcel;)V

    .line 67
    return-void
.end method


# virtual methods
.method public assetId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iAssetId:Ljava/lang/String;

    return-object v0
.end method

.method public assetURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iAssetURL:Ljava/lang/String;

    return-object v0
.end method

.method public currentSize()D
    .locals 2

    .prologue
    .line 184
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCurrentSize:D

    return-wide v0
.end method

.method public expectedSize()D
    .locals 2

    .prologue
    .line 194
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iExpectedSize:D

    return-wide v0
.end method

.method public fractionComplete()D
    .locals 4

    .prologue
    const-wide/16 v0, 0x0

    .line 204
    iget-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iExpectedSize:D

    cmpg-double v2, v2, v0

    if-gtz v2, :cond_0

    .line 206
    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCurrentSize:D

    iget-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iExpectedSize:D

    div-double/2addr v0, v2

    goto :goto_0
.end method

.method public isAdded()Z
    .locals 1

    .prologue
    .line 164
    iget-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->isAdded:Z

    return v0
.end method

.method public metadata()Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iMetaData:Ljava/lang/String;

    return-object v0
.end method

.method protected readFromParcel(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v0, 0x1

    .line 75
    invoke-super {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->readFromParcel(Landroid/os/Parcel;)V

    .line 76
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iAssetURL:Ljava/lang/String;

    .line 77
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iAssetId:Ljava/lang/String;

    .line 78
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iMetaData:Ljava/lang/String;

    .line 80
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCompleted:I

    .line 81
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->isAdded:Z

    .line 82
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iSize:I

    .line 83
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCurrentSize:D

    .line 84
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iExpectedSize:D

    .line 85
    return-void

    .line 81
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method refresh(Landroid/database/Cursor;)V
    .locals 4
    .param p1, "c"    # Landroid/database/Cursor;

    .prologue
    const/4 v0, 0x1

    .line 210
    const-string v1, "assetUrl"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setAssetUrl(Ljava/lang/String;)V

    .line 211
    const-string v1, "assetId"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setAssetId(Ljava/lang/String;)V

    .line 212
    const-string v1, "description"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setMetadata(Ljava/lang/String;)V

    .line 213
    const-string v1, "uuid"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setUuid(Ljava/lang/String;)V

    .line 214
    const-string v1, "parentUuid"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setParentUuid(Ljava/lang/String;)V

    .line 215
    const-string v1, "contentType"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setType(I)V

    .line 216
    const-string v1, "addedToQueue"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setAdded(Z)V

    .line 217
    const-string v0, "_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setId(I)V

    .line 218
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->values()[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    const-string v1, "errorType"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-int v1, v2

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 219
    const-string v0, "currentSize"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    long-to-double v0, v0

    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setCurrentSize(D)V

    .line 220
    const-string v0, "expectedSize"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    long-to-double v0, v0

    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setExpectedSize(D)V

    .line 221
    const-string v0, "clientAuthority"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->setClientProviderAuth(Ljava/lang/String;)V

    .line 222
    return-void

    .line 216
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setAdded(Z)V
    .locals 0
    .param p1, "aIsAdded"    # Z

    .prologue
    .line 169
    iput-boolean p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->isAdded:Z

    .line 170
    return-void
.end method

.method public setAssetId(Ljava/lang/String;)V
    .locals 0
    .param p1, "aAssetId"    # Ljava/lang/String;

    .prologue
    .line 149
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iAssetId:Ljava/lang/String;

    .line 150
    return-void
.end method

.method public setAssetUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "aAssetUrl"    # Ljava/lang/String;

    .prologue
    .line 144
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iAssetURL:Ljava/lang/String;

    .line 145
    return-void
.end method

.method public setCurrentSize(D)V
    .locals 1
    .param p1, "size"    # D

    .prologue
    .line 189
    iput-wide p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCurrentSize:D

    .line 190
    return-void
.end method

.method public setExpectedSize(D)V
    .locals 1
    .param p1, "size"    # D

    .prologue
    .line 199
    iput-wide p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iExpectedSize:D

    .line 200
    return-void
.end method

.method public setMetadata(Ljava/lang/String;)V
    .locals 0
    .param p1, "aMetaData"    # Ljava/lang/String;

    .prologue
    .line 154
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iMetaData:Ljava/lang/String;

    .line 155
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flag"    # I

    .prologue
    .line 90
    invoke-super {p0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->writeToParcel(Landroid/os/Parcel;I)V

    .line 91
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iAssetURL:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 92
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iAssetId:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 93
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iMetaData:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 95
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCompleted:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 96
    iget-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->isAdded:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 97
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iSize:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 98
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iCurrentSize:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 99
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;->iExpectedSize:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 100
    return-void

    .line 96
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
