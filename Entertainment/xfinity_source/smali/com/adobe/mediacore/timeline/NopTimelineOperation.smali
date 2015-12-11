.class public Lcom/adobe/mediacore/timeline/NopTimelineOperation;
.super Lcom/adobe/mediacore/timeline/TimelineOperation;


# direct methods
.method public constructor <init>()V
    .locals 8

    const-wide/16 v4, -0x1

    const/4 v2, 0x0

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-object v3, v2

    move-wide v6, v4

    invoke-direct/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    invoke-direct {p0, v1}, Lcom/adobe/mediacore/timeline/TimelineOperation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    return-void
.end method


# virtual methods
.method public isValid()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method
