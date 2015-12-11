.class public Lcom/auditude/ads/model/tracking/Submissions;
.super Lcom/auditude/ads/model/BaseElement;
.source "Submissions.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 9
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/auditude/ads/model/BaseElement;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 10
    return-void
.end method


# virtual methods
.method public getSubmissionById(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/Submission;
    .locals 5
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 14
    const/4 v0, 0x0

    .line 15
    .local v0, "submission":Lcom/auditude/ads/model/tracking/Submission;
    invoke-virtual {p0, p1}, Lcom/auditude/ads/model/tracking/Submissions;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v2

    .line 16
    .local v2, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 18
    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 19
    .local v1, "tempVar":Lcom/auditude/ads/model/tracking/TrackingUrl;
    instance-of v3, v1, Lcom/auditude/ads/model/tracking/Submission;

    if-eqz v3, :cond_1

    move-object v0, v1

    .end local v0    # "submission":Lcom/auditude/ads/model/tracking/Submission;
    :goto_0
    check-cast v0, Lcom/auditude/ads/model/tracking/Submission;

    .line 22
    .end local v1    # "tempVar":Lcom/auditude/ads/model/tracking/TrackingUrl;
    .restart local v0    # "submission":Lcom/auditude/ads/model/tracking/Submission;
    :cond_0
    return-object v0

    .line 19
    .restart local v1    # "tempVar":Lcom/auditude/ads/model/tracking/TrackingUrl;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
