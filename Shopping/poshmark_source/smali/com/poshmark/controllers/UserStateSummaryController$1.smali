.class Lcom/poshmark/controllers/UserStateSummaryController$1;
.super Ljava/lang/Object;
.source "UserStateSummaryController.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/controllers/UserStateSummaryController;->refreshModels()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Lcom/poshmark/data_model/models/UserStateSummary;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/controllers/UserStateSummaryController;


# direct methods
.method constructor <init>(Lcom/poshmark/controllers/UserStateSummaryController;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/UserStateSummary;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 74
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/UserStateSummary;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v4

    if-nez v4, :cond_7

    .line 75
    iget-object v5, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    iget-object v4, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v4, Lcom/poshmark/data_model/models/UserStateSummary;

    # setter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v5, v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$002(Lcom/poshmark/controllers/UserStateSummaryController;Lcom/poshmark/data_model/models/UserStateSummary;)Lcom/poshmark/data_model/models/UserStateSummary;

    .line 78
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v5}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->getAbSegment()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/poshmark/analytics/Analytics;->setUserSegment(Ljava/lang/String;)V

    .line 79
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v5}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->getAbSegment()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/poshmark/application/PMApplicationSession;->setUserABSegment(Ljava/lang/String;)V

    .line 81
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->event_invites:Lcom/poshmark/data_model/models/UserStateSummary$EventInvites;

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$EventInvites;->updated_at:Ljava/lang/String;

    if-eqz v4, :cond_0

    .line 82
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->event_invites:Lcom/poshmark/data_model/models/UserStateSummary$EventInvites;

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$EventInvites;->updated_at:Ljava/lang/String;

    invoke-static {v4}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    .line 83
    .local v2, "partyUpdateTimeFromServer":Ljava/util/Date;
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v4

    invoke-virtual {v4, v2}, Lcom/poshmark/controllers/GlobalPartiesController;->lastUpdatedBefore(Ljava/util/Date;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 84
    const-string v4, "com.poshmark.intents.NEW_EVENTS_ON_SERVER"

    invoke-static {v4}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 88
    .end local v2    # "partyUpdateTimeFromServer":Ljava/util/Date;
    :cond_0
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->collections:Lcom/poshmark/data_model/models/UserStateSummary$Collections;

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$Collections;->posts:Lcom/poshmark/data_model/models/UserStateSummary$Posts;

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$Posts;->updated_at:Ljava/lang/String;

    if-eqz v4, :cond_1

    .line 89
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->collections:Lcom/poshmark/data_model/models/UserStateSummary$Collections;

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$Collections;->posts:Lcom/poshmark/data_model/models/UserStateSummary$Posts;

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$Posts;->updated_at:Ljava/lang/String;

    invoke-static {v4}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    .line 90
    .local v3, "showroomsUpdateTimeFromServer":Ljava/util/Date;
    invoke-static {}, Lcom/poshmark/controllers/ShowroomsController;->getGlobalShowroomsController()Lcom/poshmark/controllers/ShowroomsController;

    move-result-object v4

    invoke-virtual {v4, v3}, Lcom/poshmark/controllers/ShowroomsController;->lastUpdatedBefore(Ljava/util/Date;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 91
    const-string v4, "com.poshmark.intents.NEW_SHOWROOMS_ON_SERVER"

    invoke-static {v4}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 95
    .end local v3    # "showroomsUpdateTimeFromServer":Ljava/util/Date;
    :cond_1
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->feature_settings:Lcom/poshmark/data_model/models/UserStateSummary$FeatureSettings;

    if-eqz v4, :cond_2

    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->feature_settings:Lcom/poshmark/data_model/models/UserStateSummary$FeatureSettings;

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$FeatureSettings;->updated_at:Ljava/lang/String;

    if-eqz v4, :cond_2

    .line 96
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->feature_settings:Lcom/poshmark/data_model/models/UserStateSummary$FeatureSettings;

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$FeatureSettings;->updated_at:Ljava/lang/String;

    invoke-static {v4}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 97
    .local v1, "featuresUpdateTimeFromServer":Ljava/util/Date;
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v4

    invoke-virtual {v4, v1}, Lcom/poshmark/utils/FeatureManager;->lastUpdatedBefore(Ljava/util/Date;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 98
    const-string v4, "com.poshmark.intents.NEW_FEATURES_ON_SERVER"

    invoke-static {v4}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 102
    .end local v1    # "featuresUpdateTimeFromServer":Ljava/util/Date;
    :cond_2
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->brands:Lcom/poshmark/data_model/models/UserStateSummary$Brands;

    if-eqz v4, :cond_5

    .line 103
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 104
    .local v0, "b":Landroid/os/Bundle;
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->brands:Lcom/poshmark/data_model/models/UserStateSummary$Brands;

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$Brands;->all:Lcom/poshmark/data_model/models/UserStateSummary$UpdatedAt;

    if-eqz v4, :cond_3

    .line 105
    const-string v4, "ALL_BRANDS_UPDATE_DTM"

    iget-object v5, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v5}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/data_model/models/UserStateSummary;->brands:Lcom/poshmark/data_model/models/UserStateSummary$Brands;

    iget-object v5, v5, Lcom/poshmark/data_model/models/UserStateSummary$Brands;->all:Lcom/poshmark/data_model/models/UserStateSummary$UpdatedAt;

    iget-object v5, v5, Lcom/poshmark/data_model/models/UserStateSummary$UpdatedAt;->updated_at:Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    :cond_3
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->brands:Lcom/poshmark/data_model/models/UserStateSummary$Brands;

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$Brands;->following:Lcom/poshmark/data_model/models/UserStateSummary$UpdatedAt;

    if-eqz v4, :cond_4

    .line 108
    const-string v4, "FOLLOWING_BRANDS_UPDATE_DTM"

    iget-object v5, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v5}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/data_model/models/UserStateSummary;->brands:Lcom/poshmark/data_model/models/UserStateSummary$Brands;

    iget-object v5, v5, Lcom/poshmark/data_model/models/UserStateSummary$Brands;->following:Lcom/poshmark/data_model/models/UserStateSummary$UpdatedAt;

    iget-object v5, v5, Lcom/poshmark/data_model/models/UserStateSummary$UpdatedAt;->updated_at:Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    :cond_4
    const-string v4, "com.poshmark.intents.NEW_BRANDS_ON_SERVER"

    invoke-static {v4, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 113
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_5
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->catalog:Lcom/poshmark/data_model/models/UserStateSummary$Catalog;

    if-eqz v4, :cond_6

    .line 114
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 115
    .restart local v0    # "b":Landroid/os/Bundle;
    const-string v4, "CATALOG_UPDATE_DTM"

    iget-object v5, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v5}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/data_model/models/UserStateSummary;->catalog:Lcom/poshmark/data_model/models/UserStateSummary$Catalog;

    iget-object v5, v5, Lcom/poshmark/data_model/models/UserStateSummary$Catalog;->updated_at:Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    const-string v4, "com.poshmark.intents.NEW_CATALOG_ON_SERVER"

    invoke-static {v4, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 119
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_6
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->notifications:Lcom/poshmark/data_model/models/UserStateSummary$NotificationsObject;

    iget v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$NotificationsObject;->total:I

    invoke-static {v4}, Lcom/poshmark/data_model/models/BadgeCount;->setCountValue(I)V

    .line 120
    iget-object v4, p0, Lcom/poshmark/controllers/UserStateSummaryController$1;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # getter for: Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;
    invoke-static {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/UserStateSummary;->notifications:Lcom/poshmark/data_model/models/UserStateSummary$NotificationsObject;

    iget v4, v4, Lcom/poshmark/data_model/models/UserStateSummary$NotificationsObject;->total:I

    if-lez v4, :cond_8

    .line 121
    const-string v4, "com.poshmark.intents.NEW_BADGE_COUNT"

    invoke-static {v4}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 126
    :cond_7
    :goto_0
    return-void

    .line 123
    :cond_8
    invoke-static {}, Lcom/poshmark/data_model/models/BadgeCount;->resetCount()V

    goto :goto_0
.end method
