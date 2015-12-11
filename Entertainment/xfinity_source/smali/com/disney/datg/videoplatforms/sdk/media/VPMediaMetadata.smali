.class public Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;
.super Ljava/lang/Object;
.source "VPMediaMetadata.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;
    }
.end annotation


# static fields
.field public static ADINFO_AD_DURATION:Ljava/lang/String;

.field public static ADINFO_AD_INDEX:Ljava/lang/String;

.field public static ADINFO_AD_TYPE:Ljava/lang/String;

.field public static ADINFO_TOTAL_ADS:Ljava/lang/String;

.field public static ASSET_CURRENT_AFFILIATE:Ljava/lang/String;

.field public static ASSET_DESCRIPTION:Ljava/lang/String;

.field public static ASSET_DURATION:Ljava/lang/String;

.field public static ASSET_ID:Ljava/lang/String;

.field public static ASSET_RATING:Ljava/lang/String;

.field public static ASSET_SUPPORTED_AFFILIATES:Ljava/lang/String;

.field public static ASSET_TITLE:Ljava/lang/String;

.field protected static BOUNDARY_EVENT:Ljava/lang/String;

.field protected static BOUNDARY_EVENT_AD_BREAK_END:Ljava/lang/String;

.field protected static BOUNDARY_EVENT_AD_BREAK_START:Ljava/lang/String;

.field protected static BOUNDARY_EVENT_AD_END:Ljava/lang/String;

.field protected static BOUNDARY_EVENT_AD_START:Ljava/lang/String;

.field protected static BOUNDARY_EVENT_PROGRAM_END:Ljava/lang/String;

.field protected static BOUNDARY_EVENT_PROGRAM_START:Ljava/lang/String;

.field public static METADATA_ASSET:Ljava/lang/String;

.field protected static METADATA_EVENT:Ljava/lang/String;

.field public static METADATA_EVENT_DESC:Ljava/lang/String;

.field public static METADATA_EVENT_NAME:Ljava/lang/String;

.field public static METADATA_RATE:Ljava/lang/String;


# instance fields
.field private currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

.field private uplynkMetadata:Lcom/uplynk/media/MediaPlayer$UplynkMetadata;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-string v0, "METADATA"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->METADATA_EVENT:Ljava/lang/String;

    .line 17
    const-string v0, "BOUNDARY"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT:Ljava/lang/String;

    .line 18
    const-string v0, "AD_START"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_AD_START:Ljava/lang/String;

    .line 19
    const-string v0, "AD_END"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_AD_END:Ljava/lang/String;

    .line 20
    const-string v0, "AD_BREAK_START"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_AD_BREAK_START:Ljava/lang/String;

    .line 21
    const-string v0, "AD_BREAK_END"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_AD_BREAK_END:Ljava/lang/String;

    .line 22
    const-string v0, "PROGRAM_START"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_PROGRAM_START:Ljava/lang/String;

    .line 23
    const-string v0, "PROGRAM_END"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_PROGRAM_END:Ljava/lang/String;

    .line 26
    const-string v0, "metadata_event_name"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->METADATA_EVENT_NAME:Ljava/lang/String;

    .line 27
    const-string v0, "metadata_event_desc"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->METADATA_EVENT_DESC:Ljava/lang/String;

    .line 28
    const-string v0, "metadata_asset_id"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_ID:Ljava/lang/String;

    .line 29
    const-string v0, "metadata_rate"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->METADATA_RATE:Ljava/lang/String;

    .line 30
    const-string v0, "metadata_asset"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->METADATA_ASSET:Ljava/lang/String;

    .line 31
    const-string v0, "asset_rating"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_RATING:Ljava/lang/String;

    .line 32
    const-string v0, "asset_duration"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_DURATION:Ljava/lang/String;

    .line 33
    const-string v0, "asset_description"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_DESCRIPTION:Ljava/lang/String;

    .line 34
    const-string v0, "asset_title"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_TITLE:Ljava/lang/String;

    .line 35
    const-string v0, "current_affiliate"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_CURRENT_AFFILIATE:Ljava/lang/String;

    .line 36
    const-string v0, "supported_affiliates"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_SUPPORTED_AFFILIATES:Ljava/lang/String;

    .line 37
    const-string v0, "ad_type"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_AD_TYPE:Ljava/lang/String;

    .line 38
    const-string v0, "total_ads"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_TOTAL_ADS:Ljava/lang/String;

    .line 39
    const-string v0, "ad_index"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_AD_INDEX:Ljava/lang/String;

    .line 40
    const-string v0, "ad_duration"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_AD_DURATION:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    .locals 0
    .param p1, "media"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 48
    return-void
.end method


# virtual methods
.method protected createBoundaryEvent(Ljava/lang/String;)Landroid/os/Bundle;
    .locals 8
    .param p1, "eventType"    # Ljava/lang/String;

    .prologue
    .line 52
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 53
    .local v1, "bundle":Landroid/os/Bundle;
    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->METADATA_EVENT:Ljava/lang/String;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT:Ljava/lang/String;

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->METADATA_EVENT_NAME:Ljava/lang/String;

    invoke-virtual {v1, v4, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    :try_start_0
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->uplynkMetadata:Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    invoke-virtual {v4}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->getAssetInfo()Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    move-result-object v0

    .line 58
    .local v0, "assetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    if-eqz v4, :cond_5

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->uplynkMetadata:Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    if-eqz v4, :cond_5

    .line 60
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 61
    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_ID:Ljava/lang/String;

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    :cond_0
    if-eqz v0, :cond_2

    .line 64
    const-string v3, "N/A"

    .line 65
    .local v3, "rating":Ljava/lang/String;
    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getMovieRating()I

    move-result v4

    if-eqz v4, :cond_6

    .line 66
    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getMovieRating()I

    move-result v4

    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/utils/UplynkUtils;->translateMovieRating(I)Ljava/lang/String;

    move-result-object v3

    .line 70
    :cond_1
    :goto_0
    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_RATING:Ljava/lang/String;

    invoke-virtual {v1, v4, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    .end local v3    # "rating":Ljava/lang/String;
    :cond_2
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaTitle()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_7

    .line 74
    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_TITLE:Ljava/lang/String;

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    :cond_3
    :goto_1
    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getDescription()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_8

    .line 81
    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_DESCRIPTION:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getDescription()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 88
    :cond_4
    :goto_2
    :try_start_1
    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_DURATION:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getDuration()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 98
    .end local v0    # "assetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    :cond_5
    :goto_3
    return-object v1

    .line 67
    .restart local v0    # "assetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    .restart local v3    # "rating":Ljava/lang/String;
    :cond_6
    :try_start_2
    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getTvRating()I

    move-result v4

    if-eqz v4, :cond_1

    .line 68
    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getTvRating()I

    move-result v4

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getRatingFlags()I

    move-result v5

    invoke-static {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/utils/UplynkUtils;->translateTVRating(II)Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 76
    .end local v3    # "rating":Ljava/lang/String;
    :cond_7
    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getDescription()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 77
    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_TITLE:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getDescription()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_1

    .line 93
    .end local v0    # "assetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    :catch_0
    move-exception v2

    .line 95
    .local v2, "e":Ljava/lang/Exception;
    const-string v4, "VPMediaMetadata"

    const-string v5, "Problem with UplynkAssetInfo"

    invoke-static {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 83
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v0    # "assetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    :cond_8
    :try_start_3
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaDesc()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 84
    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_DESCRIPTION:Ljava/lang/String;

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaDesc()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_2

    .line 89
    :catch_1
    move-exception v4

    goto :goto_3
.end method

.method protected getUplynkMetadata()Lcom/uplynk/media/MediaPlayer$UplynkMetadata;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->uplynkMetadata:Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    return-object v0
.end method

.method protected setUplynkMetadata(Lcom/uplynk/media/MediaPlayer$UplynkMetadata;)V
    .locals 0
    .param p1, "uplynkMetadata"    # Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    .prologue
    .line 114
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->uplynkMetadata:Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    .line 115
    return-void
.end method
