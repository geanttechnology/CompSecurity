.class Lcom/poshmark/utils/FeedItemLinearLayout$2;
.super Ljava/lang/Object;
.source "FeedItemLinearLayout.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/FeedItemLinearLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/FeedItemLinearLayout;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/FeedItemLinearLayout;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/poshmark/utils/FeedItemLinearLayout$2;->this$0:Lcom/poshmark/utils/FeedItemLinearLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v9, 0x0

    .line 84
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 85
    .local v0, "feedItem":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getListingLikeStatus()Z

    move-result v6

    if-nez v6, :cond_0

    move v2, v5

    .line 87
    .local v2, "newLikeState":Z
    :goto_0
    if-eqz v2, :cond_1

    .line 88
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v4

    check-cast v4, Landroid/app/Activity;

    const-string v6, "lk"

    invoke-static {v4, v6}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 89
    .local v3, "trackingJSON":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    const-string v6, "listings_feed_screen"

    const-string v7, "listing"

    const-string v8, "like"

    invoke-virtual {v4, v6, v7, v8, v9}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    invoke-static {v0}, Lcom/poshmark/utils/FBDPAHelper;->trackListingLike(Lcom/poshmark/data_model/models/ListingSummary;)V

    .line 91
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v3, v9}, Lcom/poshmark/http/api/PMApi;->like(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 92
    invoke-virtual {v0, v5}, Lcom/poshmark/data_model/models/ListingSocial;->setListingLikeStatus(Z)V

    .line 94
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/facebook/appevents/AppEventsLogger;->newLogger(Landroid/content/Context;)Lcom/facebook/appevents/AppEventsLogger;

    move-result-object v1

    .line 95
    .local v1, "logger":Lcom/facebook/appevents/AppEventsLogger;
    const-string v4, "like"

    invoke-virtual {v1, v4}, Lcom/facebook/appevents/AppEventsLogger;->logEvent(Ljava/lang/String;)V

    .line 102
    .end local v1    # "logger":Lcom/facebook/appevents/AppEventsLogger;
    .end local v3    # "trackingJSON":Ljava/lang/String;
    :goto_1
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v4

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v2}, Lcom/poshmark/notifications/ListingNotificationManager;->fireListingLikedMessage(Ljava/lang/String;Z)V

    .line 103
    return-void

    .end local v2    # "newLikeState":Z
    :cond_0
    move v2, v4

    .line 85
    goto :goto_0

    .line 97
    .restart local v2    # "newLikeState":Z
    :cond_1
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v5

    const-string v6, "listings_feed_screen"

    const-string v7, "listing"

    const-string v8, "unlike"

    invoke-virtual {v5, v6, v7, v8, v9}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v9}, Lcom/poshmark/http/api/PMApi;->unLike(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 99
    invoke-virtual {v0, v4}, Lcom/poshmark/data_model/models/ListingSocial;->setListingLikeStatus(Z)V

    goto :goto_1
.end method
