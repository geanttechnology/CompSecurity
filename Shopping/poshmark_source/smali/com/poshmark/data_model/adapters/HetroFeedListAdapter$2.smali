.class Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$2;
.super Ljava/lang/Object;
.source "HetroFeedListAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$2;->this$0:Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    const/4 v8, 0x0

    .line 74
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 75
    .local v0, "feedItem":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getListingLikeStatus()Z

    move-result v5

    if-nez v5, :cond_0

    move v1, v4

    .line 77
    .local v1, "newLikeState":Z
    :goto_0
    if-eqz v1, :cond_1

    .line 78
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    check-cast v3, Landroid/app/Activity;

    const-string v5, "lk"

    invoke-static {v3, v5}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 79
    .local v2, "trackingJSON":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v5, "listings_feed_screen"

    const-string v6, "listing"

    const-string v7, "like"

    invoke-virtual {v3, v5, v6, v7, v8}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    invoke-static {v0}, Lcom/poshmark/utils/FBDPAHelper;->trackListingLike(Lcom/poshmark/data_model/models/ListingSummary;)V

    .line 81
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v2, v8}, Lcom/poshmark/http/api/PMApi;->like(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 82
    invoke-virtual {v0, v4}, Lcom/poshmark/data_model/models/ListingSocial;->setListingLikeStatus(Z)V

    .line 93
    .end local v2    # "trackingJSON":Ljava/lang/String;
    :goto_1
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v3

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v1}, Lcom/poshmark/notifications/ListingNotificationManager;->fireListingLikedMessage(Ljava/lang/String;Z)V

    .line 94
    return-void

    .end local v1    # "newLikeState":Z
    :cond_0
    move v1, v3

    .line 75
    goto :goto_0

    .line 88
    .restart local v1    # "newLikeState":Z
    :cond_1
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    const-string v5, "listings_feed_screen"

    const-string v6, "listing"

    const-string v7, "unlike"

    invoke-virtual {v4, v5, v6, v7, v8}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v8}, Lcom/poshmark/http/api/PMApi;->unLike(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 90
    invoke-virtual {v0, v3}, Lcom/poshmark/data_model/models/ListingSocial;->setListingLikeStatus(Z)V

    goto :goto_1
.end method
