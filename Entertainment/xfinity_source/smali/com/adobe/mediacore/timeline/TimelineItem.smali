.class public abstract Lcom/adobe/mediacore/timeline/TimelineItem;
.super Ljava/lang/Object;


# instance fields
.field protected final _duration:J

.field private final _resource:Lcom/adobe/mediacore/MediaResource;


# direct methods
.method protected constructor <init>(Lcom/adobe/mediacore/MediaResource;J)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Resource parameter of TimelineItem constructor must be not nul"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const-wide/16 v0, 0x0

    cmp-long v0, p2, v0

    if-gtz v0, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Duration parameter of TimelineItem constructor must be greater than 0."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iput-object p1, p0, Lcom/adobe/mediacore/timeline/TimelineItem;->_resource:Lcom/adobe/mediacore/MediaResource;

    iput-wide p2, p0, Lcom/adobe/mediacore/timeline/TimelineItem;->_duration:J

    return-void
.end method


# virtual methods
.method public equals(Lcom/adobe/mediacore/timeline/TimelineItem;)Z
    .locals 2

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/TimelineItem;->_resource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/TimelineItem;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaResource;->equals(Lcom/adobe/mediacore/MediaResource;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/TimelineItem;->_duration:J

    return-wide v0
.end method

.method public final getMediaResource()Lcom/adobe/mediacore/MediaResource;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/TimelineItem;->_resource:Lcom/adobe/mediacore/MediaResource;

    return-object v0
.end method
