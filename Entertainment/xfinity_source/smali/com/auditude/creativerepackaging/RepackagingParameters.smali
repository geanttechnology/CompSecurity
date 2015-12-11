.class public Lcom/auditude/creativerepackaging/RepackagingParameters;
.super Ljava/lang/Object;
.source "RepackagingParameters.java"


# instance fields
.field private final HLS_FORMAT:Ljava/lang/String;

.field private final HLS_MIMETYPE:Ljava/lang/String;

.field private creativeURL:Ljava/lang/String;

.field private requiredFormat:Ljava/lang/String;

.field private videoHeight:I

.field private videoWidth:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const-string v0, "application/x-mpegURL"

    iput-object v0, p0, Lcom/auditude/creativerepackaging/RepackagingParameters;->HLS_MIMETYPE:Ljava/lang/String;

    .line 15
    const-string v0, "m3u8"

    iput-object v0, p0, Lcom/auditude/creativerepackaging/RepackagingParameters;->HLS_FORMAT:Ljava/lang/String;

    .line 7
    return-void
.end method


# virtual methods
.method public getCreativeURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/auditude/creativerepackaging/RepackagingParameters;->creativeURL:Ljava/lang/String;

    return-object v0
.end method

.method public getRequiredFormat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/auditude/creativerepackaging/RepackagingParameters;->requiredFormat:Ljava/lang/String;

    return-object v0
.end method

.method public getVideoHeight()I
    .locals 1

    .prologue
    .line 80
    iget v0, p0, Lcom/auditude/creativerepackaging/RepackagingParameters;->videoHeight:I

    return v0
.end method

.method public getVideoWidth()I
    .locals 1

    .prologue
    .line 62
    iget v0, p0, Lcom/auditude/creativerepackaging/RepackagingParameters;->videoWidth:I

    return v0
.end method

.method public setCreativeURL(Ljava/lang/String;)V
    .locals 0
    .param p1, "creativeURL"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/auditude/creativerepackaging/RepackagingParameters;->creativeURL:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setRequiredFormat(Ljava/lang/String;)V
    .locals 1
    .param p1, "requiredFormat"    # Ljava/lang/String;

    .prologue
    .line 51
    const-string v0, "application/x-mpegURL"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 52
    const-string v0, "m3u8"

    iput-object v0, p0, Lcom/auditude/creativerepackaging/RepackagingParameters;->requiredFormat:Ljava/lang/String;

    .line 55
    :goto_0
    return-void

    .line 54
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/creativerepackaging/RepackagingParameters;->requiredFormat:Ljava/lang/String;

    goto :goto_0
.end method

.method public setVideoHeight(I)V
    .locals 0
    .param p1, "videoHeight"    # I

    .prologue
    .line 90
    iput p1, p0, Lcom/auditude/creativerepackaging/RepackagingParameters;->videoHeight:I

    .line 91
    return-void
.end method

.method public setVideoWidth(I)V
    .locals 0
    .param p1, "videoWidth"    # I

    .prologue
    .line 72
    iput p1, p0, Lcom/auditude/creativerepackaging/RepackagingParameters;->videoWidth:I

    .line 73
    return-void
.end method
