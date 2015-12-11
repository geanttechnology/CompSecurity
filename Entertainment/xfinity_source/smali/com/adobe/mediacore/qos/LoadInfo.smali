.class public final Lcom/adobe/mediacore/qos/LoadInfo;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/qos/LoadInfo$Type;
    }
.end annotation


# instance fields
.field private final _downloadDuration:J

.field private final _mediaDuration:J

.field private final _periodIndex:I

.field private final _resourceSize:J

.field private final _trackIndex:I

.field private final _trackName:Ljava/lang/String;

.field private final _trackType:Ljava/lang/String;

.field private final _type:Lcom/adobe/mediacore/qos/LoadInfo$Type;

.field private final _url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/qos/LoadInfo$Type;Ljava/lang/String;IJJJLjava/lang/String;Ljava/lang/String;I)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_type:Lcom/adobe/mediacore/qos/LoadInfo$Type;

    iput-object p2, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_url:Ljava/lang/String;

    iput p3, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_periodIndex:I

    iput-wide p4, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_resourceSize:J

    iput-wide p6, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_mediaDuration:J

    iput-wide p8, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_downloadDuration:J

    iput-object p10, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_trackName:Ljava/lang/String;

    iput-object p11, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_trackType:Ljava/lang/String;

    iput p12, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_trackIndex:I

    return-void
.end method

.method public static createFragmentLoadInformation(Ljava/lang/String;IJJJ)Lcom/adobe/mediacore/qos/LoadInfo;
    .locals 14

    new-instance v0, Lcom/adobe/mediacore/qos/LoadInfo;

    sget-object v1, Lcom/adobe/mediacore/qos/LoadInfo$Type;->FRAGMENT:Lcom/adobe/mediacore/qos/LoadInfo$Type;

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, -0x1

    move-object v2, p0

    move v3, p1

    move-wide/from16 v4, p2

    move-wide/from16 v6, p4

    move-wide/from16 v8, p6

    invoke-direct/range {v0 .. v12}, Lcom/adobe/mediacore/qos/LoadInfo;-><init>(Lcom/adobe/mediacore/qos/LoadInfo$Type;Ljava/lang/String;IJJJLjava/lang/String;Ljava/lang/String;I)V

    return-object v0
.end method

.method public static createManifestLoadInformation(Ljava/lang/String;)Lcom/adobe/mediacore/qos/LoadInfo;
    .locals 13

    const/4 v10, 0x0

    const/4 v3, -0x1

    const-wide/16 v4, 0x0

    new-instance v0, Lcom/adobe/mediacore/qos/LoadInfo;

    sget-object v1, Lcom/adobe/mediacore/qos/LoadInfo$Type;->MANIFEST:Lcom/adobe/mediacore/qos/LoadInfo$Type;

    move-object v2, p0

    move-wide v6, v4

    move-wide v8, v4

    move-object v11, v10

    move v12, v3

    invoke-direct/range {v0 .. v12}, Lcom/adobe/mediacore/qos/LoadInfo;-><init>(Lcom/adobe/mediacore/qos/LoadInfo$Type;Ljava/lang/String;IJJJLjava/lang/String;Ljava/lang/String;I)V

    return-object v0
.end method

.method public static createTrackLoadInformation(Ljava/lang/String;IJJJLjava/lang/String;Ljava/lang/String;I)Lcom/adobe/mediacore/qos/LoadInfo;
    .locals 14

    new-instance v0, Lcom/adobe/mediacore/qos/LoadInfo;

    sget-object v1, Lcom/adobe/mediacore/qos/LoadInfo$Type;->TRACK:Lcom/adobe/mediacore/qos/LoadInfo$Type;

    move-object v2, p0

    move v3, p1

    move-wide/from16 v4, p2

    move-wide/from16 v6, p4

    move-wide/from16 v8, p6

    move-object/from16 v10, p8

    move-object/from16 v11, p9

    move/from16 v12, p10

    invoke-direct/range {v0 .. v12}, Lcom/adobe/mediacore/qos/LoadInfo;-><init>(Lcom/adobe/mediacore/qos/LoadInfo$Type;Ljava/lang/String;IJJJLjava/lang/String;Ljava/lang/String;I)V

    return-object v0
.end method


# virtual methods
.method public getDownloadDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_downloadDuration:J

    return-wide v0
.end method

.method public getFragmentSize()J
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/LoadInfo;->getSize()J

    move-result-wide v0

    return-wide v0
.end method

.method public getFragmentUrl()Ljava/lang/String;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/LoadInfo;->getUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMediaDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_mediaDuration:J

    return-wide v0
.end method

.method public getPeriodIndex()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_periodIndex:I

    return v0
.end method

.method public getSize()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_resourceSize:J

    return-wide v0
.end method

.method public getTrackIndex()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_trackIndex:I

    return v0
.end method

.method public getTrackName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_trackName:Ljava/lang/String;

    return-object v0
.end method

.method public getTrackType()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_trackType:Ljava/lang/String;

    return-object v0
.end method

.method public final getType()Lcom/adobe/mediacore/qos/LoadInfo$Type;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_type:Lcom/adobe/mediacore/qos/LoadInfo$Type;

    return-object v0
.end method

.method public final getUrl()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/LoadInfo;->_url:Ljava/lang/String;

    return-object v0
.end method
