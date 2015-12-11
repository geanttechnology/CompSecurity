.class Lcom/poshmark/data_model/adapters/FeedListAdapter$2;
.super Ljava/lang/Object;
.source "FeedListAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/adapters/FeedListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/FeedListAdapter;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/adapters/FeedListAdapter;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter$2;->this$0:Lcom/poshmark/data_model/adapters/FeedListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v7, 0x0

    .line 80
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 81
    .local v0, "feedItem":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getListingLikeStatus()Z

    move-result v3

    if-nez v3, :cond_0

    const/4 v1, 0x1

    .line 83
    .local v1, "newLikeState":Z
    :goto_0
    if-eqz v1, :cond_1

    .line 84
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    check-cast v3, Landroid/app/Activity;

    const-string v4, "lk"

    invoke-static {v3, v4}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 85
    .local v2, "trackingJSON":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "listings_feed_screen"

    const-string v5, "listing"

    const-string v6, "like"

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v2, v7}, Lcom/poshmark/http/api/PMApi;->like(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 96
    .end local v2    # "trackingJSON":Ljava/lang/String;
    :goto_1
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v3

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v1}, Lcom/poshmark/notifications/ListingNotificationManager;->fireListingLikedMessage(Ljava/lang/String;Z)V

    .line 97
    return-void

    .line 81
    .end local v1    # "newLikeState":Z
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 92
    .restart local v1    # "newLikeState":Z
    :cond_1
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "listings_feed_screen"

    const-string v5, "listing"

    const-string v6, "unlike"

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v7}, Lcom/poshmark/http/api/PMApi;->unLike(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_1
.end method
