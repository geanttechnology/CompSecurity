.class public Lcom/poshmark/ui/fragments/NewFeedFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "NewFeedFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/ListingNotificationHandler;
.implements Lcom/poshmark/notifications/SynchronousBroadcastListener;


# instance fields
.field adapter:Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;

.field cacheHelper:Lcom/poshmark/utils/FeedCacheHelper;

.field feedData:Lcom/poshmark/data_model/models/Feed;

.field feedListView:Lcom/poshmark/ui/customviews/PMListView;

.field isFragmentBeingPoppedOfStack:Z

.field isFragmentBeingResurrected:Z

.field newItemsBubble:Lcom/poshmark/ui/customviews/PMButton;

.field pagesScrolled:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 50
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 55
    iput v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->pagesScrolled:I

    .line 56
    new-instance v0, Lcom/poshmark/utils/FeedCacheHelper;

    invoke-direct {v0}, Lcom/poshmark/utils/FeedCacheHelper;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->cacheHelper:Lcom/poshmark/utils/FeedCacheHelper;

    .line 57
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->isFragmentBeingResurrected:Z

    .line 58
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->isFragmentBeingPoppedOfStack:Z

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/NewFeedFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/NewFeedFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 50
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getFeed(Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/NewFeedFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/NewFeedFragment;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->showFindPeopleFragment()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/NewFeedFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/NewFeedFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 50
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/NewFeedFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method private checkForTrigger()V
    .locals 2

    .prologue
    .line 178
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->bUpdateOnShow:Z

    if-eqz v1, :cond_0

    .line 181
    invoke-static {}, Lcom/poshmark/triggers/PMTriggerManager;->getGlobalTriggerManager()Lcom/poshmark/triggers/PMTriggerManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/triggers/PMTriggerManager;->getRateAppTrigger()Lcom/poshmark/triggers/RateAppTrigger;

    move-result-object v0

    .line 182
    .local v0, "trigger":Lcom/poshmark/triggers/RateAppTrigger;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/triggers/RateAppTrigger;->isValid()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 183
    invoke-virtual {v0}, Lcom/poshmark/triggers/RateAppTrigger;->incrementViewCount()V

    .line 184
    invoke-virtual {v0}, Lcom/poshmark/triggers/RateAppTrigger;->shouldFireTrigger()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 185
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->executeAppRateFlow(Lcom/poshmark/triggers/RateAppTrigger;)V

    .line 189
    .end local v0    # "trigger":Lcom/poshmark/triggers/RateAppTrigger;
    :cond_0
    return-void
.end method

.method private executeAppRateFlow(Lcom/poshmark/triggers/RateAppTrigger;)V
    .locals 6
    .param p1, "trigger"    # Lcom/poshmark/triggers/RateAppTrigger;

    .prologue
    .line 192
    new-instance v0, Lcom/poshmark/utils/PMLoveDialog;

    invoke-direct {v0, p1}, Lcom/poshmark/utils/PMLoveDialog;-><init>(Lcom/poshmark/triggers/PMTrigger;)V

    .line 193
    .local v0, "loveDlg":Lcom/poshmark/utils/PMLoveDialog;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "pmLoveDlg"

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/PMLoveDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 194
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "app"

    const-string v4, "app_love_alert_displayed"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 195
    return-void
.end method

.method private generateModel(Ljava/lang/String;)Lcom/poshmark/data_model/models/Feed;
    .locals 5
    .param p1, "responseString"    # Ljava/lang/String;

    .prologue
    .line 336
    new-instance v2, Lcom/google/gson/GsonBuilder;

    invoke-direct {v2}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-class v3, Lcom/poshmark/data_model/models/Feed;

    new-instance v4, Lcom/poshmark/utils/FeedDeserializer;

    invoke-direct {v4}, Lcom/poshmark/utils/FeedDeserializer;-><init>()V

    invoke-virtual {v2, v3, v4}, Lcom/google/gson/GsonBuilder;->registerTypeAdapter(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v0

    .line 340
    .local v0, "gson":Lcom/google/gson/Gson;
    const-class v2, Lcom/poshmark/data_model/models/Feed;

    instance-of v3, v0, Lcom/google/gson/Gson;

    if-nez v3, :cond_0

    invoke-virtual {v0, p1, v2}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    .end local v0    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v1, Lcom/poshmark/data_model/models/Feed;

    .line 341
    .local v1, "model":Lcom/poshmark/data_model/models/Feed;
    return-object v1

    .line 340
    .end local v1    # "model":Lcom/poshmark/data_model/models/Feed;
    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, p1, v2}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method private getFeed(Z)V
    .locals 8
    .param p1, "isPagination"    # Z

    .prologue
    const/4 v5, 0x0

    .line 280
    if-nez p1, :cond_2

    .line 281
    iget v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->pagesScrolled:I

    if-lez v0, :cond_0

    .line 282
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "listing"

    const-string v4, "pages_scrolled_by_user"

    iget v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->pagesScrolled:I

    int-to-long v6, v0

    invoke-virtual/range {v1 .. v7}, Lcom/poshmark/analytics/Analytics;->trackEventWithValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V

    .line 283
    const/4 v0, 0x0

    iput v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->pagesScrolled:I

    .line 285
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 286
    new-instance v0, Lcom/poshmark/ui/fragments/NewFeedFragment$6;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/NewFeedFragment$6;-><init>(Lcom/poshmark/ui/fragments/NewFeedFragment;)V

    invoke-static {v5, v0}, Lcom/poshmark/http/api/PMApi;->getHetroFeed(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 307
    :cond_1
    :goto_0
    return-void

    .line 295
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Feed;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 296
    iget v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->pagesScrolled:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->pagesScrolled:I

    .line 297
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Feed;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/NewFeedFragment$7;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/NewFeedFragment$7;-><init>(Lcom/poshmark/ui/fragments/NewFeedFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getHetroFeed(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 6
    .param p2, "isPagination"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 310
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->hideProgressDialog()V

    .line 311
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_2

    .line 312
    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->responseString:Ljava/lang/String;

    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/NewFeedFragment;->generateModel(Ljava/lang/String;)Lcom/poshmark/data_model/models/Feed;

    move-result-object v0

    .line 313
    .local v0, "model":Lcom/poshmark/data_model/models/Feed;
    if-nez p2, :cond_1

    .line 314
    iput-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    .line 316
    iget-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/Feed;->createHashAndRemoveDups()V

    .line 317
    iget-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 318
    iget-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 319
    iget-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 320
    iget-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->cacheHelper:Lcom/poshmark/utils/FeedCacheHelper;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->responseString:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/FeedCacheHelper;->saveFeed(Ljava/lang/String;)V

    .line 333
    .end local v0    # "model":Lcom/poshmark/data_model/models/Feed;
    :cond_0
    :goto_0
    return-void

    .line 322
    .restart local v0    # "model":Lcom/poshmark/data_model/models/Feed;
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/Feed;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 323
    iget-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 327
    .end local v0    # "model":Lcom/poshmark/data_model/models/Feed;
    :cond_2
    if-nez p2, :cond_0

    .line 328
    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_MY_FEED:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    const v5, 0x7f0600e7

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/NewFeedFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private setupFeedList()V
    .locals 15

    .prologue
    const/4 v14, 0x0

    const/4 v13, 0x0

    .line 208
    const/4 v5, 0x0

    .line 209
    .local v5, "forceReload":Z
    const/4 v8, 0x0

    .line 210
    .local v8, "showBubble":Z
    const/4 v3, 0x0

    .line 212
    .local v3, "bubbleString":Ljava/lang/String;
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->cacheHelper:Lcom/poshmark/utils/FeedCacheHelper;

    invoke-virtual {v9}, Lcom/poshmark/utils/FeedCacheHelper;->isCachedFeedAvailable()Z

    move-result v9

    if-eqz v9, :cond_1

    .line 213
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->cacheHelper:Lcom/poshmark/utils/FeedCacheHelper;

    invoke-virtual {v9}, Lcom/poshmark/utils/FeedCacheHelper;->getLastCachedDate()Ljava/util/Date;

    move-result-object v6

    .line 215
    .local v6, "lastCachedDate":Ljava/util/Date;
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v9

    invoke-virtual {v9}, Lcom/poshmark/utils/FeatureManager;->getFeedAutoRefreshFeature()Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;

    move-result-object v0

    .line 216
    .local v0, "autoRefreshFeature":Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;->isEnabled()Z

    move-result v9

    if-eqz v9, :cond_0

    .line 217
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;->geAutoRefreshIntervalInSeconds()I

    move-result v1

    .line 218
    .local v1, "autoRefreshIntervalInSeconds":I
    int-to-long v10, v1

    sget-object v9, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->SECONDS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    invoke-static {v6, v10, v11, v9}, Lcom/poshmark/utils/DateUtils;->isDateWithinPastWindow(Ljava/util/Date;JLcom/poshmark/utils/DateUtils$TIME_UNIT;)Z

    move-result v9

    if-nez v9, :cond_0

    .line 219
    const/4 v5, 0x1

    .line 223
    .end local v1    # "autoRefreshIntervalInSeconds":I
    :cond_0
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v9

    invoke-virtual {v9}, Lcom/poshmark/utils/FeatureManager;->getFeedLazyLoadFeature()Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;

    move-result-object v7

    .line 224
    .local v7, "lazyLoadFeature":Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;
    if-eqz v7, :cond_1

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;->isEnabled()Z

    move-result v9

    if-eqz v9, :cond_1

    .line 225
    invoke-virtual {v7}, Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;->getTitle()Ljava/lang/String;

    move-result-object v3

    .line 226
    invoke-virtual {v7}, Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;->geBubbleDisplayIntervalInSeconds()I

    move-result v2

    .line 227
    .local v2, "bubbleDisplaytIntervalInSeconds":I
    int-to-long v10, v2

    sget-object v9, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->SECONDS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    invoke-static {v6, v10, v11, v9}, Lcom/poshmark/utils/DateUtils;->isDateWithinPastWindow(Ljava/util/Date;JLcom/poshmark/utils/DateUtils$TIME_UNIT;)Z

    move-result v9

    if-nez v9, :cond_1

    .line 228
    const/4 v8, 0x1

    .line 233
    .end local v0    # "autoRefreshFeature":Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;
    .end local v2    # "bubbleDisplaytIntervalInSeconds":I
    .end local v6    # "lastCachedDate":Ljava/util/Date;
    .end local v7    # "lazyLoadFeature":Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;
    :cond_1
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    if-eqz v9, :cond_5

    .line 234
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v10, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 235
    iget-boolean v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->bUpdateOnShow:Z

    if-eqz v9, :cond_2

    .line 236
    sget-object v9, Lcom/poshmark/utils/NewRelicCustomInteractions;->USER_TRIGGERED_FEED_REFRESH:Ljava/lang/String;

    invoke-static {v9}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 260
    :cond_2
    :goto_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v9

    invoke-virtual {v9}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v9

    if-eqz v9, :cond_4

    .line 261
    if-nez v5, :cond_3

    iget-boolean v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->bUpdateOnShow:Z

    if-eqz v9, :cond_8

    .line 262
    :cond_3
    iput-boolean v13, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->bUpdateOnShow:Z

    .line 263
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->newItemsBubble:Lcom/poshmark/ui/customviews/PMButton;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMButton;->setVisibility(I)V

    .line 264
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const v10, 0x7f060190

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/NewFeedFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 265
    invoke-direct {p0, v13}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getFeed(Z)V

    .line 276
    :cond_4
    :goto_1
    return-void

    .line 238
    :cond_5
    iget-boolean v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->isFragmentBeingResurrected:Z

    if-eqz v9, :cond_7

    .line 240
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v9

    iget-object v10, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v11, "app"

    const-string v12, "feed_resurrected"

    invoke-virtual {v9, v10, v11, v12, v14}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 242
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->cacheHelper:Lcom/poshmark/utils/FeedCacheHelper;

    invoke-virtual {v9}, Lcom/poshmark/utils/FeedCacheHelper;->isCachedFeedAvailable()Z

    move-result v9

    if-eqz v9, :cond_6

    .line 244
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v9

    iget-object v10, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v11, "app"

    const-string v12, "cached_items_displayed"

    invoke-virtual {v9, v10, v11, v12, v14}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 245
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->cacheHelper:Lcom/poshmark/utils/FeedCacheHelper;

    invoke-virtual {v9}, Lcom/poshmark/utils/FeedCacheHelper;->getCachedFeed()Ljava/lang/String;

    move-result-object v4

    .line 246
    .local v4, "cachedFeedJson":Ljava/lang/String;
    invoke-direct {p0, v4}, Lcom/poshmark/ui/fragments/NewFeedFragment;->generateModel(Ljava/lang/String;)Lcom/poshmark/data_model/models/Feed;

    move-result-object v9

    iput-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    .line 247
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v10, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 248
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v9}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 249
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v9, v13}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    goto :goto_0

    .line 251
    .end local v4    # "cachedFeedJson":Ljava/lang/String;
    :cond_6
    const/4 v5, 0x1

    .line 252
    sget-object v9, Lcom/poshmark/utils/NewRelicCustomInteractions;->APP_FOREGROUND_FEED_REFRESH:Ljava/lang/String;

    invoke-static {v9}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    goto :goto_0

    .line 255
    :cond_7
    sget-object v9, Lcom/poshmark/utils/NewRelicCustomInteractions;->APP_LAUNCH_FEED_REFRESH:Ljava/lang/String;

    invoke-static {v9}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 256
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v9

    iget-object v10, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v11, "app"

    const-string v12, "feed_cold_start"

    invoke-virtual {v9, v10, v11, v12, v14}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 257
    const/4 v5, 0x1

    goto/16 :goto_0

    .line 266
    :cond_8
    if-eqz v8, :cond_4

    .line 267
    if-eqz v3, :cond_9

    .line 268
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->newItemsBubble:Lcom/poshmark/ui/customviews/PMButton;

    invoke-virtual {v9, v3}, Lcom/poshmark/ui/customviews/PMButton;->setText(Ljava/lang/CharSequence;)V

    .line 270
    :cond_9
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->newItemsBubble:Lcom/poshmark/ui/customviews/PMButton;

    const v10, 0x7f02010d

    invoke-virtual {v9, v10, v13, v13, v13}, Lcom/poshmark/ui/customviews/PMButton;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 271
    iget-object v9, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->newItemsBubble:Lcom/poshmark/ui/customviews/PMButton;

    invoke-virtual {v9, v13}, Lcom/poshmark/ui/customviews/PMButton;->setVisibility(I)V

    .line 272
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v9

    iget-object v10, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v11, "app"

    const-string v12, "new_items_bubble_displayed"

    invoke-virtual {v9, v10, v11, v12, v14}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method private showFindPeopleFragment()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 202
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 203
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v1, Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v0, v2, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 204
    return-void
.end method


# virtual methods
.method public addCommentToListing(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 382
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    if-eqz v0, :cond_0

    .line 384
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 386
    :cond_0
    return-void
.end method

.method public deleteListing(Ljava/lang/String;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 398
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    if-eqz v0, :cond_0

    .line 400
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 402
    :cond_0
    return-void
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 174
    const-string v0, "fd2"

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x0

    .line 347
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 348
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    .line 349
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->cacheHelper:Lcom/poshmark/utils/FeedCacheHelper;

    invoke-virtual {v0}, Lcom/poshmark/utils/FeedCacheHelper;->clearCachedFeed()V

    .line 352
    :cond_0
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 353
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 354
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 355
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 356
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getFeed(Z)V

    .line 364
    :cond_1
    :goto_0
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.UPDATE_FEED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 365
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 366
    invoke-direct {p0, v2}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getFeed(Z)V

    .line 369
    :cond_2
    return-void

    .line 359
    :cond_3
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->bUpdateOnShow:Z

    goto :goto_0
.end method

.method public handleSynchronousBroadcastMsg(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "intent"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/Object;

    .prologue
    .line 130
    const-string v0, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 133
    :cond_0
    return-void
.end method

.method public likeListing(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "likeStatus"    # Z

    .prologue
    .line 390
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    if-eqz v0, :cond_0

    .line 392
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 394
    :cond_0
    return-void
.end method

.method public newListingCreated()V
    .locals 1

    .prologue
    .line 406
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->bUpdateOnShow:Z

    .line 407
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 103
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 104
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 63
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 64
    new-instance v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    const/high16 v3, -0x80000000

    invoke-direct {v0, v1, p0, v2, v3}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->adapter:Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;

    .line 65
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 66
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 67
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.UPDATE_FEED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 68
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.APP_UPGRADED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 69
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/ListingNotificationManager;->registerListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V

    .line 71
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "RESURRECTION"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->isFragmentBeingResurrected:Z

    .line 72
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "FRAGMENT_BEING_POPPED_OFF_STACK"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->isFragmentBeingPoppedOfStack:Z

    .line 73
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 77
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 79
    const v1, 0x7f03003e

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 80
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c010d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 81
    iget-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->adapter:Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;

    new-instance v3, Lcom/poshmark/ui/fragments/NewFeedFragment$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/NewFeedFragment$1;-><init>(Lcom/poshmark/ui/fragments/NewFeedFragment;)V

    invoke-virtual {v1, v2, v4, v4, v3}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 87
    const v1, 0x7f0c010e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMButton;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->newItemsBubble:Lcom/poshmark/ui/customviews/PMButton;

    .line 88
    iget-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->newItemsBubble:Lcom/poshmark/ui/customviews/PMButton;

    new-instance v2, Lcom/poshmark/ui/fragments/NewFeedFragment$2;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/NewFeedFragment$2;-><init>(Lcom/poshmark/ui/fragments/NewFeedFragment;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 98
    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 115
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 116
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 120
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 121
    invoke-static {}, Lcom/poshmark/notifications/SynchronousBroadcastManager;->getSyncronousBroadcastManager()Lcom/poshmark/notifications/SynchronousBroadcastManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/SynchronousBroadcastManager;->registerSynchronousBroadcastListener(Ljava/lang/String;Lcom/poshmark/notifications/SynchronousBroadcastListener;)V

    .line 122
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 123
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->checkForTrigger()V

    .line 124
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->setupFeedList()V

    .line 126
    :cond_0
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 108
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onStop()V

    .line 109
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->adapter:Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->clearImageList()V

    .line 110
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 198
    const-string v0, "listings_feed_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 199
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 138
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 139
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->showLogoAsTitle()V

    .line 140
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/NewFeedFragment;->showRefreshButton(Z)V

    .line 141
    new-instance v0, Lcom/poshmark/ui/fragments/NewFeedFragment$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/NewFeedFragment$3;-><init>(Lcom/poshmark/ui/fragments/NewFeedFragment;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->setRefreshActionButtonListener(Landroid/view/View$OnClickListener;)V

    .line 152
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/NewFeedFragment;->showFindPeopleButton(Z)V

    .line 153
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/NewFeedFragment;->showSearchButton(Z)V

    .line 154
    new-instance v0, Lcom/poshmark/ui/fragments/NewFeedFragment$4;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/NewFeedFragment$4;-><init>(Lcom/poshmark/ui/fragments/NewFeedFragment;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->setSearchActionButtonListener(Landroid/view/View$OnClickListener;)V

    .line 164
    new-instance v0, Lcom/poshmark/ui/fragments/NewFeedFragment$5;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/NewFeedFragment$5;-><init>(Lcom/poshmark/ui/fragments/NewFeedFragment;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->setFindPeopleActionButtonListener(Landroid/view/View$OnClickListener;)V

    .line 170
    return-void
.end method

.method public updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 1
    .param p1, "listing"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 374
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedData:Lcom/poshmark/data_model/models/Feed;

    if-eqz v0, :cond_0

    .line 376
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment;->feedListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 378
    :cond_0
    return-void
.end method
