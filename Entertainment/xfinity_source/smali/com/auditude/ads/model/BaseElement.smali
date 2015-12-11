.class public Lcom/auditude/ads/model/BaseElement;
.super Ljava/lang/Object;
.source "BaseElement.java"


# instance fields
.field public errorUrl:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private parent:Lcom/auditude/ads/model/BaseElement;

.field private state:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private trackingEvents:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/tracking/TrackingEvent;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/auditude/ads/model/BaseElement;)V
    .locals 1
    .param p1, "parent"    # Lcom/auditude/ads/model/BaseElement;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/model/BaseElement;->trackingEvents:Ljava/util/ArrayList;

    .line 19
    iput-object p1, p0, Lcom/auditude/ads/model/BaseElement;->parent:Lcom/auditude/ads/model/BaseElement;

    .line 20
    return-void
.end method


# virtual methods
.method public final addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Lcom/auditude/ads/model/tracking/TrackingUrl;
    .param p2, "type"    # Ljava/lang/String;

    .prologue
    .line 69
    const/4 v3, 0x1

    invoke-virtual {p0, p2, v3}, Lcom/auditude/ads/model/BaseElement;->getTrackingEventByType(Ljava/lang/String;Z)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v2

    .line 70
    .local v2, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    if-eqz v2, :cond_0

    .line 72
    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v3

    if-nez v3, :cond_1

    .line 74
    invoke-virtual {v2, p1}, Lcom/auditude/ads/model/tracking/TrackingEvent;->addTrackingUrl(Lcom/auditude/ads/model/tracking/TrackingUrl;)V

    .line 90
    :cond_0
    :goto_0
    return-void

    .line 78
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lt v0, v3, :cond_2

    .line 87
    invoke-virtual {v2, p1}, Lcom/auditude/ads/model/tracking/TrackingEvent;->addTrackingUrl(Lcom/auditude/ads/model/tracking/TrackingUrl;)V

    goto :goto_0

    .line 80
    :cond_2
    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 81
    .local v1, "tracking":Lcom/auditude/ads/model/tracking/TrackingUrl;
    if-eqz v1, :cond_3

    invoke-virtual {v1}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_3

    invoke-virtual {v1}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 78
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public final copyTrackingEventsTo(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "toElement"    # Lcom/auditude/ads/model/BaseElement;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "externalSubmissionUrl"    # Ljava/lang/String;

    .prologue
    .line 123
    invoke-virtual {p0, p2}, Lcom/auditude/ads/model/BaseElement;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v2

    .line 124
    .local v2, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 126
    const/4 v4, 0x1

    invoke-virtual {p1, p2, v4}, Lcom/auditude/ads/model/BaseElement;->getTrackingEventByType(Ljava/lang/String;Z)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v1

    .line 127
    .local v1, "targetTrackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_1

    .line 138
    .end local v1    # "targetTrackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    :cond_0
    return-void

    .line 127
    .restart local v1    # "targetTrackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    :cond_1
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 129
    .local v3, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    invoke-virtual {v3}, Lcom/auditude/ads/model/tracking/TrackingUrl;->duplicate()Lcom/auditude/ads/model/tracking/TrackingUrl;

    move-result-object v0

    .line 130
    .local v0, "newTrackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    instance-of v4, v0, Lcom/auditude/ads/model/tracking/Submission;

    if-eqz v4, :cond_2

    move-object v4, v0

    .line 132
    check-cast v4, Lcom/auditude/ads/model/tracking/Submission;

    iput-object p3, v4, Lcom/auditude/ads/model/tracking/Submission;->externalUrl:Ljava/lang/String;

    .line 135
    :cond_2
    invoke-virtual {v1, v0}, Lcom/auditude/ads/model/tracking/TrackingEvent;->addTrackingUrl(Lcom/auditude/ads/model/tracking/TrackingUrl;)V

    goto :goto_0
.end method

.method public final getID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/auditude/ads/model/BaseElement;->id:Ljava/lang/String;

    return-object v0
.end method

.method public final getParent()Lcom/auditude/ads/model/BaseElement;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/auditude/ads/model/BaseElement;->parent:Lcom/auditude/ads/model/BaseElement;

    return-object v0
.end method

.method public final getState()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 38
    iget-object v0, p0, Lcom/auditude/ads/model/BaseElement;->state:Ljava/util/HashMap;

    return-object v0
.end method

.method public final getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/TrackingEvent;
    .locals 1
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 94
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/auditude/ads/model/BaseElement;->getTrackingEventByType(Ljava/lang/String;Z)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v0

    return-object v0
.end method

.method public final getTrackingEventByType(Ljava/lang/String;Z)Lcom/auditude/ads/model/tracking/TrackingEvent;
    .locals 4
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "create"    # Z

    .prologue
    .line 99
    iget-object v2, p0, Lcom/auditude/ads/model/BaseElement;->trackingEvents:Ljava/util/ArrayList;

    if-eqz v2, :cond_0

    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 101
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/auditude/ads/model/BaseElement;->trackingEvents:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lt v0, v2, :cond_1

    .line 110
    .end local v0    # "i":I
    :cond_0
    if-eqz p2, :cond_3

    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 112
    new-instance v1, Lcom/auditude/ads/model/tracking/TrackingEvent;

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;-><init>(Ljava/lang/String;)V

    .line 113
    .local v1, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    iget-object v2, p0, Lcom/auditude/ads/model/BaseElement;->trackingEvents:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move-object v2, v1

    .line 118
    .end local v1    # "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    :goto_1
    return-object v2

    .line 103
    .restart local v0    # "i":I
    :cond_1
    iget-object v2, p0, Lcom/auditude/ads/model/BaseElement;->trackingEvents:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/auditude/ads/model/tracking/TrackingEvent;

    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 105
    iget-object v2, p0, Lcom/auditude/ads/model/BaseElement;->trackingEvents:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/auditude/ads/model/tracking/TrackingEvent;

    goto :goto_1

    .line 101
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 118
    .end local v0    # "i":I
    :cond_3
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public final getTrackingEvents()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/tracking/TrackingEvent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 47
    iget-object v0, p0, Lcom/auditude/ads/model/BaseElement;->trackingEvents:Ljava/util/ArrayList;

    return-object v0
.end method

.method public final resetTrackingEvents()V
    .locals 3

    .prologue
    .line 56
    iget-object v1, p0, Lcom/auditude/ads/model/BaseElement;->trackingEvents:Ljava/util/ArrayList;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/auditude/ads/model/BaseElement;->trackingEvents:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 65
    :cond_0
    return-void

    .line 61
    :cond_1
    iget-object v1, p0, Lcom/auditude/ads/model/BaseElement;->trackingEvents:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/tracking/TrackingEvent;

    .line 63
    .local v0, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    invoke-virtual {v0}, Lcom/auditude/ads/model/tracking/TrackingEvent;->reset()V

    goto :goto_0
.end method

.method public final setID(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/auditude/ads/model/BaseElement;->id:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public final setState(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p1, "value":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/auditude/ads/model/BaseElement;->state:Ljava/util/HashMap;

    .line 43
    return-void
.end method

.method public final setTrackingEvents(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/tracking/TrackingEvent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 51
    .local p1, "value":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/tracking/TrackingEvent;>;"
    iput-object p1, p0, Lcom/auditude/ads/model/BaseElement;->trackingEvents:Ljava/util/ArrayList;

    .line 52
    return-void
.end method
