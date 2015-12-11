.class public Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;
.super Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
.source "VPVideo.java"


# static fields
.field private static MEDIA_TYPE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;


# instance fields
.field private airDate:Ljava/lang/String;

.field private availableDate:Ljava/lang/String;

.field private cGenre:Ljava/lang/String;

.field private cShowName:Ljava/lang/String;

.field private cVideo:Ljava/lang/String;

.field private dayPart:Ljava/lang/String;

.field private duration:J

.field private episodeNumber:Ljava/lang/String;

.field private expireDate:Ljava/lang/String;

.field private seasonNumber:Ljava/lang/String;

.field private storageId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->VOD:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->MEDIA_TYPE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;-><init>()V

    return-void
.end method


# virtual methods
.method public getAirDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->airDate:Ljava/lang/String;

    return-object v0
.end method

.method public getAvailableDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->availableDate:Ljava/lang/String;

    return-object v0
.end method

.method public getCGenre()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->cGenre:Ljava/lang/String;

    return-object v0
.end method

.method public getCShowName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->cShowName:Ljava/lang/String;

    return-object v0
.end method

.method public getCVideo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->cVideo:Ljava/lang/String;

    return-object v0
.end method

.method public getContentUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 21
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->contentUrl:Ljava/lang/String;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->contentUrl:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x4

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->contentUrl:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    const-string v1, "json"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 22
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->contentUrl:Ljava/lang/String;

    const-string v1, "json"

    const-string v2, "m3u8"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->contentUrl:Ljava/lang/String;

    .line 24
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->contentUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getDayPart()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->dayPart:Ljava/lang/String;

    return-object v0
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 41
    iget-wide v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->duration:J

    return-wide v0
.end method

.method public getEpisodeNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->episodeNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getExpireDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->expireDate:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->MEDIA_TYPE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    return-object v0
.end method

.method public getSeasonNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->seasonNumber:Ljava/lang/String;

    return-object v0
.end method

.method public setAirDate(Ljava/lang/String;)V
    .locals 0
    .param p1, "airDate"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->airDate:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public setAvailableDate(Ljava/lang/String;)V
    .locals 0
    .param p1, "availableDate"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->availableDate:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setCGenre(Ljava/lang/String;)V
    .locals 0
    .param p1, "genre"    # Ljava/lang/String;

    .prologue
    .line 101
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->cGenre:Ljava/lang/String;

    .line 102
    return-void
.end method

.method public setCShowName(Ljava/lang/String;)V
    .locals 0
    .param p1, "cShowName"    # Ljava/lang/String;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->cShowName:Ljava/lang/String;

    .line 110
    return-void
.end method

.method public setCVideo(Ljava/lang/String;)V
    .locals 0
    .param p1, "cVideo"    # Ljava/lang/String;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->cVideo:Ljava/lang/String;

    .line 118
    return-void
.end method

.method public setDayPart(Ljava/lang/String;)V
    .locals 0
    .param p1, "dayPart"    # Ljava/lang/String;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->dayPart:Ljava/lang/String;

    .line 94
    return-void
.end method

.method public setDuration(J)V
    .locals 1
    .param p1, "duration"    # J

    .prologue
    .line 45
    iput-wide p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->duration:J

    .line 46
    return-void
.end method

.method public setEpisodeNumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "episodeNumber"    # Ljava/lang/String;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->episodeNumber:Ljava/lang/String;

    .line 70
    return-void
.end method

.method public setExpireDate(Ljava/lang/String;)V
    .locals 0
    .param p1, "expireDate"    # Ljava/lang/String;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->expireDate:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public setSeasonNumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "seasonNumber"    # Ljava/lang/String;

    .prologue
    .line 85
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->seasonNumber:Ljava/lang/String;

    .line 86
    return-void
.end method

.method public setStorageId(Ljava/lang/String;)V
    .locals 0
    .param p1, "storageId"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPVideo;->storageId:Ljava/lang/String;

    .line 38
    return-void
.end method
