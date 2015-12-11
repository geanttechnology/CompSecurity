.class public final Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;,
        Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;
    }
.end annotation


# static fields
.field public static final UNKNOWN_DURATION:I = -0x1


# instance fields
.field private final _duration:J

.field private final _mode:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

.field private final _time:J

.field private final _type:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_type:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->INSERT:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_mode:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    iput-wide p2, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_time:J

    iput-wide p4, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_duration:J

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_type:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    iput-object p2, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_mode:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    iput-wide p3, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_time:J

    iput-wide p5, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_duration:J

    return-void
.end method


# virtual methods
.method public getDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_duration:J

    return-wide v0
.end method

.method public getMode()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_mode:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    return-object v0
.end method

.method public getTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_time:J

    return-wide v0
.end method

.method public getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_type:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Object {"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " type="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_type:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, " ,time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_time:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, " ,duration="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->_duration:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
