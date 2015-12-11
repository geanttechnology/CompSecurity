.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;
.super Ljava/lang/Object;
.source "VirtuosoIdentifier.java"

# interfaces
.implements Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;


# instance fields
.field iClientProvider:Ljava/lang/String;

.field iCompletionTime:J

.field iContentState:I

.field iContentType:I

.field iDownloadErrorType:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field iId:I

.field iParentUuid:Ljava/lang/String;

.field iType:I

.field iUuid:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 32
    invoke-direct {p0, v0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;-><init>(II)V

    .line 33
    return-void
.end method

.method constructor <init>(II)V
    .locals 1
    .param p1, "aType"    # I
    .param p2, "aContentType"    # I

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    const/4 v0, -0x1

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iId:I

    .line 20
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Not_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iDownloadErrorType:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 23
    const/4 v0, 0x0

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iContentState:I

    .line 36
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iUuid:Ljava/lang/String;

    .line 37
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iParentUuid:Ljava/lang/String;

    .line 38
    iput p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iType:I

    .line 39
    iput p2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iContentType:I

    .line 40
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    const/4 v0, -0x1

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iId:I

    .line 20
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Not_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iDownloadErrorType:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 23
    const/4 v0, 0x0

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iContentState:I

    .line 44
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->readFromParcel(Landroid/os/Parcel;)V

    .line 45
    return-void
.end method


# virtual methods
.method public clientProviderAuth()Ljava/lang/String;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iClientProvider:Ljava/lang/String;

    return-object v0
.end method

.method public completionTime()J
    .locals 2

    .prologue
    .line 165
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iCompletionTime:J

    return-wide v0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x0

    return v0
.end method

.method public downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iDownloadErrorType:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    return-object v0
.end method

.method public getContentState()I
    .locals 1

    .prologue
    .line 185
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iContentState:I

    return v0
.end method

.method public id()I
    .locals 1

    .prologue
    .line 127
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iId:I

    return v0
.end method

.method public parentUuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iParentUuid:Ljava/lang/String;

    return-object v0
.end method

.method protected readFromParcel(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 53
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iType:I

    .line 54
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iContentType:I

    .line 55
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iUuid:Ljava/lang/String;

    .line 56
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iParentUuid:Ljava/lang/String;

    .line 57
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iId:I

    .line 58
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->values()[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iDownloadErrorType:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 59
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iCompletionTime:J

    .line 60
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iClientProvider:Ljava/lang/String;

    .line 61
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iContentState:I

    .line 62
    return-void
.end method

.method public readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 85
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 86
    .local v0, "temp":Ljava/lang/String;
    const-string v1, "null"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 87
    const/4 v0, 0x0

    .line 89
    :cond_0
    return-object v0
.end method

.method public setClientProviderAuth(Ljava/lang/String;)V
    .locals 0
    .param p1, "aAuth"    # Ljava/lang/String;

    .prologue
    .line 173
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iClientProvider:Ljava/lang/String;

    .line 174
    return-void
.end method

.method public setCompletionTime(J)V
    .locals 1
    .param p1, "time"    # J

    .prologue
    .line 160
    iput-wide p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iCompletionTime:J

    .line 161
    return-void
.end method

.method public setContentState(I)V
    .locals 0
    .param p1, "state"    # I

    .prologue
    .line 179
    iput p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iContentState:I

    .line 180
    return-void
.end method

.method public setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V
    .locals 0
    .param p1, "aError"    # Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .prologue
    .line 142
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iDownloadErrorType:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 143
    return-void
.end method

.method public setId(I)V
    .locals 0
    .param p1, "aId"    # I

    .prologue
    .line 132
    iput p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iId:I

    .line 133
    return-void
.end method

.method public setParentUuid(Ljava/lang/String;)V
    .locals 0
    .param p1, "asString"    # Ljava/lang/String;

    .prologue
    .line 122
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iParentUuid:Ljava/lang/String;

    .line 123
    return-void
.end method

.method public setType(I)V
    .locals 0
    .param p1, "aType"    # I

    .prologue
    .line 110
    iput p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iType:I

    .line 111
    return-void
.end method

.method public setUuid(Ljava/lang/String;)V
    .locals 0
    .param p1, "aUuid"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iUuid:Ljava/lang/String;

    .line 101
    return-void
.end method

.method public type()I
    .locals 1

    .prologue
    .line 105
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iType:I

    return v0
.end method

.method public uuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iUuid:Ljava/lang/String;

    return-object v0
.end method

.method public writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V
    .locals 0
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "aProperty"    # Ljava/lang/String;

    .prologue
    .line 79
    if-nez p2, :cond_0

    .line 80
    const-string p2, "null"

    .line 81
    :cond_0
    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 82
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flag"    # I

    .prologue
    .line 67
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 68
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iContentType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 69
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iUuid:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 70
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iParentUuid:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 71
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 72
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iDownloadErrorType:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 73
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iCompletionTime:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 74
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iClientProvider:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 75
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->iContentState:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 76
    return-void
.end method
