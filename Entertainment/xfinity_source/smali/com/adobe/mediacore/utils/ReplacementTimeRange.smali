.class public Lcom/adobe/mediacore/utils/ReplacementTimeRange;
.super Lcom/adobe/mediacore/utils/TimeRange;


# instance fields
.field private _replacementDuration:J


# direct methods
.method public constructor <init>(JJJ)V
    .locals 3

    invoke-direct {p0, p1, p2, p3, p4}, Lcom/adobe/mediacore/utils/TimeRange;-><init>(JJ)V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->_replacementDuration:J

    iput-wide p5, p0, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->_replacementDuration:J

    return-void
.end method

.method public static createRange(JJJ)Lcom/adobe/mediacore/utils/ReplacementTimeRange;
    .locals 8

    new-instance v1, Lcom/adobe/mediacore/utils/ReplacementTimeRange;

    add-long v4, p0, p2

    move-wide v2, p0

    move-wide v6, p4

    invoke-direct/range {v1 .. v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;-><init>(JJJ)V

    return-object v1
.end method


# virtual methods
.method public getReplacementDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->_replacementDuration:J

    return-wide v0
.end method
