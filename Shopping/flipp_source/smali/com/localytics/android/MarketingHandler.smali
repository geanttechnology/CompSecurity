.class Lcom/localytics/android/MarketingHandler;
.super Lcom/localytics/android/BaseHandler;
.source "SourceFile"

# interfaces
.implements Lcom/localytics/android/AnalyticsListener;


# static fields
.field private static final AB_ATTRIBUTE:Ljava/lang/String; = "ab"

.field private static final ACTION_ATTRIBUTE:Ljava/lang/String; = "Action"

.field private static final APP_CONTEXT_ATTRIBUTE:Ljava/lang/String; = "App Context"

.field private static final AUGMENTED_BLACKOUT_TIMES_RULE:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final AUGMENTED_BLACKOUT_WEEKDAYS_RULE:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static final CAMPAIGN_ID_ATTRIBUTE:Ljava/lang/String; = "Campaign ID"

.field private static final CREATIVE_DISPLAYED_ATTRIBUTE:Ljava/lang/String; = "Creative Displayed"

.field private static final CREATIVE_ID_ATTRIBUTE:Ljava/lang/String; = "Creative ID"

.field private static final CREATIVE_TYPE_ATTRIBUTE:Ljava/lang/String; = "Creative Type"

.field private static final DATE_SDF:Ljava/text/SimpleDateFormat;

.field private static final DEFAULT_FREQUENCY_CAPPING_RULE:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static final GLOBAL_FREQUENCY_CAPPING_RULE_CAMPAIGN_ID:I = -0x1

.field private static final GLOBAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS:[Ljava/lang/String;

.field private static final INDIVIDUAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS:[Ljava/lang/String;

.field private static final JS_STRINGS_THAT_MEAN_NULL:Ljava/util/List;

.field private static final MESSAGE_HANDLE_PUSH_RECEIVED:I = 0xcc

.field private static final MESSAGE_MARKETING_MESSAGE_TRIGGER:I = 0xc9

.field private static final MESSAGE_SET_MARKETING_MESSAGE_AS_NOT_DISPLAYED:I = 0xcd

.field private static final MESSAGE_SHOW_MARKETING_TEST:I = 0xcb

.field private static final PROJECTION_MARKETING_RULE_RECORD:[Ljava/lang/String;

.field private static final PUSH_API_URL_TEMPLATE:Ljava/lang/String; = "http://pushapi.localytics.com/push_test?platform=android&type=prod&campaign=%s&creative=%s&token=%s&install_id=%s&client_ts=%s"

.field private static final PUSH_NOTIFICATIONS_ENABLED_ATTRIBUTE:Ljava/lang/String; = "Push Notifications Enabled"

.field private static final PUSH_OPENED_EVENT:Ljava/lang/String; = "Localytics Push Opened"

.field private static final PUSH_RECEIVED_EVENT:Ljava/lang/String; = "Localytics Push Received"

.field private static final TIME_SDF:Ljava/text/SimpleDateFormat;


# instance fields
.field private lastMarketingMessagesHash:I

.field private mCampaignDisplaying:Z

.field mConfigurations:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private mFragmentManager:Landroid/support/v4/app/ah;

.field private sessionStartMarketingMessageShown:Z

.field private testCampaignsListAdapter:Lcom/localytics/android/MarketingRulesAdapter;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 113
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "version"

    aput-object v1, v0, v4

    sput-object v0, Lcom/localytics/android/MarketingHandler;->PROJECTION_MARKETING_RULE_RECORD:[Ljava/lang/String;

    .line 128
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "undefined"

    aput-object v1, v0, v3

    const-string v1, "null"

    aput-object v1, v0, v4

    const-string v1, "nil"

    aput-object v1, v0, v5

    const-string v1, "\"\""

    aput-object v1, v0, v6

    const-string v1, "\'\'"

    aput-object v1, v0, v7

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/MarketingHandler;->JS_STRINGS_THAT_MEAN_NULL:Ljava/util/List;

    .line 141
    new-array v0, v4, [Ljava/lang/String;

    sget-object v1, Lcom/localytics/android/Constants;->DISPLAY_FREQUENCIES_KEY:Ljava/lang/String;

    aput-object v1, v0, v3

    sput-object v0, Lcom/localytics/android/MarketingHandler;->GLOBAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS:[Ljava/lang/String;

    .line 142
    new-array v0, v5, [Ljava/lang/String;

    sget-object v1, Lcom/localytics/android/Constants;->MAX_DISPLAY_COUNT_KEY:Ljava/lang/String;

    aput-object v1, v0, v3

    sget-object v1, Lcom/localytics/android/Constants;->IGNORE_GLOBAL_KEY:Ljava/lang/String;

    aput-object v1, v0, v4

    sput-object v0, Lcom/localytics/android/MarketingHandler;->INDIVIDUAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS:[Ljava/lang/String;

    .line 146
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "HH:mm"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/localytics/android/MarketingHandler;->TIME_SDF:Ljava/text/SimpleDateFormat;

    .line 147
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/localytics/android/MarketingHandler;->DATE_SDF:Ljava/text/SimpleDateFormat;

    .line 151
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/localytics/android/MarketingHandler;->AUGMENTED_BLACKOUT_TIMES_RULE:Ljava/util/List;

    .line 152
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 153
    const-string v1, "start"

    const-string v2, "00:00"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 154
    const-string v1, "end"

    const-string v2, "23:59"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 155
    sget-object v1, Lcom/localytics/android/MarketingHandler;->AUGMENTED_BLACKOUT_TIMES_RULE:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 157
    const/4 v0, 0x7

    new-array v0, v0, [Ljava/lang/Integer;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v3

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v4

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v5

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v6

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const/4 v2, 0x5

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const/4 v2, 0x6

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/MarketingHandler;->AUGMENTED_BLACKOUT_WEEKDAYS_RULE:Ljava/util/List;

    .line 159
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 160
    sput-object v0, Lcom/localytics/android/MarketingHandler;->DEFAULT_FREQUENCY_CAPPING_RULE:Ljava/util/Map;

    const-string v1, "max_display_count"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 161
    sget-object v0, Lcom/localytics/android/MarketingHandler;->DEFAULT_FREQUENCY_CAPPING_RULE:Ljava/util/Map;

    const-string v1, "ignore_global"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    sget-object v0, Lcom/localytics/android/MarketingHandler;->TIME_SDF:Ljava/text/SimpleDateFormat;

    invoke-virtual {v0, v3}, Ljava/text/SimpleDateFormat;->setLenient(Z)V

    .line 164
    sget-object v0, Lcom/localytics/android/MarketingHandler;->DATE_SDF:Ljava/text/SimpleDateFormat;

    invoke-virtual {v0, v3}, Ljava/text/SimpleDateFormat;->setLenient(Z)V

    .line 165
    return-void
.end method

.method constructor <init>(Lcom/localytics/android/LocalyticsDao;Landroid/os/Looper;Landroid/content/Context;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 176
    invoke-direct {p0, p1, p2}, Lcom/localytics/android/BaseHandler;-><init>(Lcom/localytics/android/LocalyticsDao;Landroid/os/Looper;)V

    .line 124
    iput-boolean v2, p0, Lcom/localytics/android/MarketingHandler;->sessionStartMarketingMessageShown:Z

    .line 125
    iput-object v3, p0, Lcom/localytics/android/MarketingHandler;->testCampaignsListAdapter:Lcom/localytics/android/MarketingRulesAdapter;

    .line 126
    const/4 v0, -0x1

    iput v0, p0, Lcom/localytics/android/MarketingHandler;->lastMarketingMessagesHash:I

    .line 135
    iput-boolean v1, p0, Lcom/localytics/android/MarketingHandler;->mCampaignDisplaying:Z

    .line 177
    const-string v0, "In-app"

    iput-object v0, p0, Lcom/localytics/android/MarketingHandler;->siloName:Ljava/lang/String;

    .line 178
    new-instance v0, Lcom/localytics/android/MarketingHandler$MessagingListenersSet;

    invoke-direct {v0, p0, v3}, Lcom/localytics/android/MarketingHandler$MessagingListenersSet;-><init>(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/MarketingHandler$1;)V

    iput-object v0, p0, Lcom/localytics/android/MarketingHandler;->listeners:Lcom/localytics/android/BaseHandler$ListenersSet;

    .line 179
    iput-boolean v1, p0, Lcom/localytics/android/MarketingHandler;->doesRetry:Z

    .line 182
    invoke-direct {p0, p3}, Lcom/localytics/android/MarketingHandler;->_createLocalyticsDirectory(Landroid/content/Context;)Z

    .line 184
    invoke-virtual {p0, v2}, Lcom/localytics/android/MarketingHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->queueMessage(Landroid/os/Message;)Z

    .line 185
    return-void
.end method

.method private __showMarketingTest()V
    .locals 7

    .prologue
    .line 2218
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;

    if-nez v0, :cond_1

    .line 2431
    :cond_0
    :goto_0
    return-void

    .line 2223
    :cond_1
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;

    const-string v1, "marketing_test_mode_button"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/ah;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;

    const-string v1, "marketing_test_mode_list"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/ah;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-nez v0, :cond_0

    .line 2228
    invoke-static {}, Lcom/localytics/android/TestModeButton;->newInstance()Lcom/localytics/android/TestModeButton;

    move-result-object v0

    .line 2229
    invoke-static {}, Lcom/localytics/android/TestModeListView;->newInstance()Lcom/localytics/android/TestModeListView;

    move-result-object v1

    .line 2230
    iget-object v2, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v2

    .line 2231
    new-instance v3, Lcom/localytics/android/MarketingRulesAdapter;

    invoke-direct {v3, v2, p0}, Lcom/localytics/android/MarketingRulesAdapter;-><init>(Landroid/content/Context;Lcom/localytics/android/MarketingHandler;)V

    .line 2233
    invoke-virtual {v1, v3}, Lcom/localytics/android/TestModeListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 2238
    new-instance v4, Ljava/util/TreeMap;

    invoke-direct {v4}, Ljava/util/TreeMap;-><init>()V

    .line 2240
    const/16 v5, 0x9

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    new-instance v6, Lcom/localytics/android/MarketingHandler$10;

    invoke-direct {v6, p0, v3, v1}, Lcom/localytics/android/MarketingHandler$10;-><init>(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/MarketingRulesAdapter;Lcom/localytics/android/TestModeListView;)V

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2252
    invoke-virtual {v0, v4}, Lcom/localytics/android/TestModeButton;->setCallbacks(Ljava/util/Map;)Lcom/localytics/android/TestModeButton;

    .line 2253
    iget-object v4, p0, Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;

    const-string v5, "marketing_test_mode_button"

    invoke-virtual {v0, v4, v5}, Lcom/localytics/android/TestModeButton;->show(Landroid/support/v4/app/ah;Ljava/lang/String;)V

    .line 2259
    iget-object v4, p0, Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;

    invoke-virtual {v4}, Landroid/support/v4/app/ah;->b()Z

    .line 2264
    new-instance v4, Ljava/util/TreeMap;

    invoke-direct {v4}, Ljava/util/TreeMap;-><init>()V

    .line 2267
    const/16 v5, 0xa

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    new-instance v6, Lcom/localytics/android/MarketingHandler$11;

    invoke-direct {v6, p0, v0}, Lcom/localytics/android/MarketingHandler$11;-><init>(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/TestModeButton;)V

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2279
    const/16 v0, 0xc

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    new-instance v5, Lcom/localytics/android/MarketingHandler$12;

    invoke-direct {v5, p0, v3}, Lcom/localytics/android/MarketingHandler$12;-><init>(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/MarketingRulesAdapter;)V

    invoke-interface {v4, v0, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2292
    const/16 v0, 0xd

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    new-instance v3, Lcom/localytics/android/MarketingHandler$13;

    invoke-direct {v3, p0, v2}, Lcom/localytics/android/MarketingHandler$13;-><init>(Lcom/localytics/android/MarketingHandler;Landroid/content/Context;)V

    invoke-interface {v4, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2336
    const/16 v0, 0xe

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    new-instance v3, Lcom/localytics/android/MarketingHandler$14;

    invoke-direct {v3, p0, v2}, Lcom/localytics/android/MarketingHandler$14;-><init>(Lcom/localytics/android/MarketingHandler;Landroid/content/Context;)V

    invoke-interface {v4, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2367
    const/16 v0, 0xb

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    new-instance v3, Lcom/localytics/android/MarketingHandler$15;

    invoke-direct {v3, p0, v2}, Lcom/localytics/android/MarketingHandler$15;-><init>(Lcom/localytics/android/MarketingHandler;Landroid/content/Context;)V

    invoke-interface {v4, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2430
    invoke-virtual {v1, v4}, Lcom/localytics/android/TestModeListView;->setCallbacks(Ljava/util/Map;)Lcom/localytics/android/TestModeListView;

    goto/16 :goto_0
.end method

.method private _bindRuleToEvents(JLjava/util/List;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1739
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "marketing_ruleevent"

    const-string v2, "%s = ?"

    new-array v3, v6, [Ljava/lang/Object;

    const-string v4, "rule_id_ref"

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {v0, v1, v2, v3}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1742
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1744
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 1745
    const-string v3, "event_name"

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1746
    const-string v0, "rule_id_ref"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1747
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "marketing_ruleevent"

    invoke-virtual {v0, v3, v2}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_0

    .line 1749
    :cond_0
    return-void
.end method

.method private _createLocalyticsDirectory(Landroid/content/Context;)Z
    .locals 2

    .prologue
    .line 195
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 203
    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 205
    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 206
    const-string v1, ".localytics"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 208
    new-instance v1, Ljava/io/File;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 210
    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {v1}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private _decompressZipFile(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 8

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 3121
    const/4 v3, 0x0

    .line 3124
    :try_start_0
    new-instance v2, Ljava/util/zip/ZipInputStream;

    new-instance v4, Ljava/io/FileInputStream;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    invoke-direct {v2, v4}, Ljava/util/zip/ZipInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 3128
    const/16 v3, 0x2000

    :try_start_1
    new-array v3, v3, [B

    .line 3130
    :cond_0
    :goto_0
    invoke-virtual {v2}, Ljava/util/zip/ZipInputStream;->getNextEntry()Ljava/util/zip/ZipEntry;

    move-result-object v4

    if-eqz v4, :cond_5

    .line 3133
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v4}, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 3134
    invoke-virtual {v4}, Ljava/util/zip/ZipEntry;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 3136
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 3137
    invoke-virtual {v4}, Ljava/io/File;->mkdir()Z

    move-result v4

    if-nez v4, :cond_0

    .line 3139
    const-string v4, "Could not create directory %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v5, v6, v7

    invoke-static {v4, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 3157
    :catch_0
    move-exception v0

    .line 3159
    :goto_1
    :try_start_2
    const-string v3, "Caught IOException"

    invoke-static {v3, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 3160
    if-eqz v2, :cond_1

    .line 3168
    :try_start_3
    invoke-virtual {v2}, Ljava/util/zip/ZipInputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    :cond_1
    move v0, v1

    .line 3179
    :goto_2
    return v0

    .line 3144
    :cond_2
    :try_start_4
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    .line 3147
    :goto_3
    const/4 v5, 0x0

    const/16 v6, 0x2000

    invoke-virtual {v2, v3, v5, v6}, Ljava/util/zip/ZipInputStream;->read([BII)I

    move-result v5

    if-lez v5, :cond_4

    .line 3149
    const/4 v6, 0x0

    invoke-virtual {v4, v3, v6, v5}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_3

    .line 3164
    :catchall_0
    move-exception v0

    .line 3166
    :goto_4
    if-eqz v2, :cond_3

    .line 3168
    :try_start_5
    invoke-virtual {v2}, Ljava/util/zip/ZipInputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 3175
    :cond_3
    throw v0

    .line 3152
    :cond_4
    :try_start_6
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V

    .line 3153
    invoke-virtual {v2}, Ljava/util/zip/ZipInputStream;->closeEntry()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_0

    .line 3166
    :cond_5
    :try_start_7
    invoke-virtual {v2}, Ljava/util/zip/ZipInputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1

    goto :goto_2

    .line 3172
    :catch_1
    move-exception v0

    .line 3174
    const-string v2, "Caught IOException"

    invoke-static {v2, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    move v0, v1

    .line 3175
    goto :goto_2

    .line 3172
    :catch_2
    move-exception v0

    .line 3174
    const-string v2, "Caught IOException"

    invoke-static {v2, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    move v0, v1

    .line 3175
    goto :goto_2

    .line 3172
    :catch_3
    move-exception v0

    .line 3174
    const-string v2, "Caught IOException"

    invoke-static {v2, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    move v0, v1

    .line 3175
    goto :goto_2

    .line 3164
    :catchall_1
    move-exception v0

    move-object v2, v3

    goto :goto_4

    .line 3157
    :catch_4
    move-exception v0

    move-object v2, v3

    goto :goto_1
.end method

.method private _destroyLocalMarketingMessage(Lcom/localytics/android/MarketingMessage;)V
    .locals 13

    .prologue
    const/4 v1, 0x0

    .line 1574
    :try_start_0
    const-string v0, "campaign_id"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 1575
    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingHandler;->_getRuleIdFromCampaignId(I)I

    move-result v2

    .line 1580
    int-to-long v4, v2

    invoke-direct {p0, v4, v5}, Lcom/localytics/android/MarketingHandler;->_getConditionIdFromRuleId(J)[J

    move-result-object v3

    .line 1581
    array-length v4, v3

    move v0, v1

    :goto_0
    if-ge v0, v4, :cond_0

    aget-wide v6, v3, v0

    .line 1583
    iget-object v5, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v8, "marketing_condition_values"

    const-string v9, "%s = ?"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string v12, "condition_id_ref"

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v10, v11

    invoke-virtual {v5, v8, v9, v10}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1581
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1585
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "marketing_conditions"

    const-string v4, "%s = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "rule_id_ref"

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v0, v3, v4, v5}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1588
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "marketing_ruleevent"

    const-string v4, "%s = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "rule_id_ref"

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v0, v3, v4, v5}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1591
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "marketing_rules"

    const-string v4, "%s = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "_id"

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v5, v6

    invoke-virtual {v0, v3, v4, v5}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1594
    const-string v0, "base_path"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1595
    if-eqz v0, :cond_3

    .line 1597
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1598
    invoke-virtual {v2}, Ljava/io/File;->isDirectory()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1600
    invoke-virtual {v2}, Ljava/io/File;->list()[Ljava/lang/String;

    move-result-object v3

    array-length v4, v3

    :goto_1
    if-ge v1, v4, :cond_1

    aget-object v5, v3, v1

    .line 1602
    new-instance v6, Ljava/io/File;

    invoke-direct {v6, v2, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/io/File;->delete()Z

    .line 1600
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 1606
    :cond_1
    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    move-result v1

    if-nez v1, :cond_2

    .line 1608
    const-string v1, "Delete %s failed."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 1611
    :cond_2
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".zip"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1612
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v1

    if-nez v1, :cond_3

    .line 1614
    const-string v1, "Delete %s failed."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ".zip"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1622
    :cond_3
    :goto_2
    return-void

    .line 1618
    :catch_0
    move-exception v0

    .line 1620
    const-class v1, Ljava/lang/RuntimeException;

    const-string v2, "Localytics library threw an uncaught exception"

    invoke-static {v1, v2, v0}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Exception;)Ljava/lang/Object;

    goto :goto_2
.end method

.method private _doesCreativeExist(IZ)Z
    .locals 6

    .prologue
    .line 3098
    if-eqz p2, :cond_0

    .line 3100
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Lcom/localytics/android/MarketingHandler;->_getZipFileDirPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "amp_rule_%d.zip"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 3107
    :goto_0
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    return v0

    .line 3104
    :cond_0
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0, p1}, Lcom/localytics/android/MarketingHandler;->_getUnzipFileDirPath(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "index.html"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private _getCampaignIdsFromFrequencyCappingQuery(Ljava/lang/String;)Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1392
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/localytics/android/MarketingHandler;->_getCampaignIdsFromFrequencyCappingQuery(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method private _getCampaignIdsFromFrequencyCappingQuery(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/Set;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1398
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 1399
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 1401
    const/4 v1, 0x0

    .line 1404
    :try_start_0
    iget-object v2, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    iget-object v2, v2, Lcom/localytics/android/BaseProvider;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2, p1, p2}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 1406
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1408
    const-string v2, "campaign_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1413
    :catchall_0
    move-exception v0

    if-eqz v1, :cond_0

    .line 1415
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_0
    throw v0

    .line 1413
    :cond_1
    if-eqz v1, :cond_2

    .line 1415
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1420
    :cond_2
    return-object v0
.end method

.method private _getConditionIdFromRuleId(J)[J
    .locals 9

    .prologue
    const/4 v6, 0x0

    const/4 v7, 0x0

    .line 1919
    .line 1924
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "marketing_conditions"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const-string v3, "%s = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v8, "rule_id_ref"

    aput-object v8, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1925
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    new-array v3, v0, [J

    move v0, v7

    .line 1928
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1930
    add-int/lit8 v2, v0, 0x1

    const-string v4, "_id"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    int-to-long v4, v4

    aput-wide v4, v3, v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move v0, v2

    goto :goto_0

    .line 1935
    :cond_0
    if-eqz v1, :cond_1

    .line 1937
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1941
    :cond_1
    return-object v3

    .line 1935
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_1
    if-eqz v1, :cond_2

    .line 1937
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1938
    :cond_2
    throw v0

    .line 1935
    :catchall_1
    move-exception v0

    goto :goto_1
.end method

.method private _getJavaScriptClientCallbacks(Ljava/util/Map;)Landroid/util/SparseArray;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Landroid/util/SparseArray",
            "<",
            "Lcom/localytics/android/MarketingCallable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2604
    new-instance v1, Landroid/util/SparseArray;

    invoke-direct {v1}, Landroid/util/SparseArray;-><init>()V

    .line 2610
    const/4 v0, 0x3

    new-instance v2, Lcom/localytics/android/MarketingHandler$20;

    invoke-direct {v2, p0}, Lcom/localytics/android/MarketingHandler$20;-><init>(Lcom/localytics/android/MarketingHandler;)V

    invoke-virtual {v1, v0, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 2708
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getIdentifiers()Ljava/util/Map;

    move-result-object v0

    .line 2709
    const/4 v2, 0x5

    new-instance v3, Lcom/localytics/android/MarketingHandler$21;

    invoke-direct {v3, p0, v0}, Lcom/localytics/android/MarketingHandler$21;-><init>(Lcom/localytics/android/MarketingHandler;Ljava/util/Map;)V

    invoke-virtual {v1, v2, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 2736
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 2737
    const/4 v0, 0x0

    :goto_0
    const/16 v3, 0xa

    if-ge v0, v3, :cond_0

    .line 2741
    :try_start_0
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "c"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4, v0}, Lcom/localytics/android/LocalyticsDao;->getCustomDimension(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 2737
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2745
    :catch_0
    move-exception v3

    const-string v3, "[JavaScriptClient]: Failed to get custom dimension"

    invoke-static {v3}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    goto :goto_1

    .line 2748
    :cond_0
    const/4 v0, 0x6

    new-instance v3, Lcom/localytics/android/MarketingHandler$22;

    invoke-direct {v3, p0, v2}, Lcom/localytics/android/MarketingHandler$22;-><init>(Lcom/localytics/android/MarketingHandler;Lorg/json/JSONObject;)V

    invoke-virtual {v1, v0, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 2758
    const/4 v0, 0x7

    new-instance v2, Lcom/localytics/android/MarketingHandler$23;

    invoke-direct {v2, p0, p1}, Lcom/localytics/android/MarketingHandler$23;-><init>(Lcom/localytics/android/MarketingHandler;Ljava/util/Map;)V

    invoke-virtual {v1, v0, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 2794
    const/16 v0, 0x8

    new-instance v2, Lcom/localytics/android/MarketingHandler$24;

    invoke-direct {v2, p0}, Lcom/localytics/android/MarketingHandler$24;-><init>(Lcom/localytics/android/MarketingHandler;)V

    invoke-virtual {v1, v0, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 2807
    return-object v1
.end method

.method private _getMarketingConditionValues(I)Ljava/util/Vector;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/Vector",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 3190
    .line 3195
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "marketing_condition_values"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "value"

    aput-object v4, v2, v3

    const-string v3, "%s = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v7, "condition_id_ref"

    aput-object v7, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 3196
    :goto_0
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 3198
    const-string v0, "value"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 3200
    if-nez v6, :cond_0

    .line 3202
    new-instance v6, Ljava/util/Vector;

    invoke-direct {v6}, Ljava/util/Vector;-><init>()V

    .line 3205
    :cond_0
    invoke-virtual {v6, v0}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 3210
    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v1, :cond_1

    .line 3212
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 3213
    :cond_1
    throw v0

    .line 3210
    :cond_2
    if-eqz v1, :cond_3

    .line 3212
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 3217
    :cond_3
    return-object v6

    .line 3210
    :catchall_1
    move-exception v0

    move-object v1, v6

    goto :goto_1
.end method

.method private _getMarketingConditions(I)Ljava/util/Vector;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/Vector",
            "<",
            "Lcom/localytics/android/MarketingCondition;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 2956
    .line 2962
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "marketing_conditions"

    const/4 v2, 0x0

    const-string v3, "%s = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v7, "rule_id_ref"

    aput-object v7, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 2963
    :goto_0
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2965
    const-string v0, "_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 2966
    const-string v2, "attribute_name"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 2967
    const-string v3, "operator"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 2968
    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingHandler;->_getMarketingConditionValues(I)Ljava/util/Vector;

    move-result-object v0

    .line 2970
    if-nez v6, :cond_0

    .line 2972
    new-instance v6, Ljava/util/Vector;

    invoke-direct {v6}, Ljava/util/Vector;-><init>()V

    .line 2975
    :cond_0
    new-instance v4, Lcom/localytics/android/MarketingCondition;

    invoke-direct {v4, v2, v3, v0}, Lcom/localytics/android/MarketingCondition;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Vector;)V

    .line 2976
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/localytics/android/MarketingCondition;->setPackageName(Ljava/lang/String;)V

    .line 2977
    invoke-virtual {v6, v4}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 2982
    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v1, :cond_1

    .line 2984
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2985
    :cond_1
    throw v0

    .line 2982
    :cond_2
    if-eqz v1, :cond_3

    .line 2984
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2989
    :cond_3
    return-object v6

    .line 2982
    :catchall_1
    move-exception v0

    move-object v1, v6

    goto :goto_1
.end method

.method private _getMarketingMessageMaps(Ljava/lang/String;)Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/localytics/android/MarketingMessage;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 2441
    new-instance v2, Ljava/util/LinkedList;

    invoke-direct {v2}, Ljava/util/LinkedList;-><init>()V

    .line 2443
    const/4 v1, 0x0

    .line 2446
    :try_start_0
    iget-object v3, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3}, Lcom/localytics/android/LocalyticsDao;->getCurrentTimeMillis()J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    .line 2447
    const-string v4, "SELECT * FROM %s AS r LEFT OUTER JOIN %s AS re ON r.%s=re.%s WHERE %s > ? AND %s = ? GROUP BY r.%s;"

    const/4 v5, 0x7

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "marketing_rules"

    aput-object v7, v5, v6

    const/4 v6, 0x1

    const-string v7, "marketing_ruleevent"

    aput-object v7, v5, v6

    const/4 v6, 0x2

    const-string v7, "_id"

    aput-object v7, v5, v6

    const/4 v6, 0x3

    const-string v7, "rule_id_ref"

    aput-object v7, v5, v6

    const/4 v6, 0x4

    const-string v7, "expiration"

    aput-object v7, v5, v6

    const/4 v6, 0x5

    const-string v7, "event_name"

    aput-object v7, v5, v6

    const/4 v6, 0x6

    const-string v7, "_id"

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 2458
    iget-object v5, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    iget-object v5, v5, Lcom/localytics/android/BaseProvider;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v3, v6, v7

    const/4 v3, 0x1

    aput-object p1, v6, v3

    invoke-virtual {v5, v4, v6}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 2460
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 2462
    invoke-interface {v1, v0}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 2464
    new-instance v3, Lcom/localytics/android/MarketingMessage;

    invoke-direct {v3}, Lcom/localytics/android/MarketingMessage;-><init>()V

    .line 2466
    const-string v4, "_id"

    const-string v5, "_id"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2467
    const-string v4, "campaign_id"

    const-string v5, "campaign_id"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2468
    const-string v4, "expiration"

    const-string v5, "expiration"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2469
    const-string v4, "display_seconds"

    const-string v5, "display_seconds"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2470
    const-string v4, "display_session"

    const-string v5, "display_session"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2471
    const-string v4, "version"

    const-string v5, "version"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2472
    const-string v4, "phone_location"

    const-string v5, "phone_location"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2473
    const-string v4, "phone_size_width"

    const-string v5, "phone_size_width"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2474
    const-string v4, "phone_size_height"

    const-string v5, "phone_size_height"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2475
    const-string v4, "tablet_location"

    const-string v5, "tablet_location"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2476
    const-string v4, "tablet_size_width"

    const-string v5, "tablet_size_width"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2477
    const-string v4, "tablet_size_height"

    const-string v5, "tablet_size_height"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2478
    const-string v4, "time_to_display"

    const-string v5, "time_to_display"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2479
    const-string v4, "internet_required"

    const-string v5, "internet_required"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2480
    const-string v4, "ab_test"

    const-string v5, "ab_test"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2481
    const-string v4, "rule_name_non_unique"

    const-string v5, "rule_name_non_unique"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2482
    const-string v4, "location"

    const-string v5, "location"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2483
    const-string v4, "devices"

    const-string v5, "devices"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2484
    const-string v4, "control_group"

    const-string v5, "control_group"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2485
    const-string v4, "schema_version"

    const-string v5, "schema_version"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2487
    invoke-virtual {v2, v3}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2460
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 2492
    :cond_0
    if-eqz v1, :cond_1

    .line 2494
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 2498
    :cond_1
    return-object v2

    .line 2492
    :catchall_0
    move-exception v0

    if-eqz v1, :cond_2

    .line 2494
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0
.end method

.method private _getRemoteFileURL(Lcom/localytics/android/MarketingMessage;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 3069
    const-string v0, "devices"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 3071
    const-string v1, "tablet"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_0

    .line 3073
    const-string v0, "tablet_location"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 3084
    :goto_0
    return-object v0

    .line 3075
    :cond_0
    const-string v1, "both"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    .line 3077
    const-string v0, "phone_location"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method private _getRuleIdFromCampaignId(I)I
    .locals 9

    .prologue
    const/4 v6, 0x0

    const/4 v7, 0x0

    .line 1890
    .line 1894
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "marketing_rules"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const-string v3, "%s = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v8, "campaign_id"

    aput-object v8, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1895
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1897
    const-string v0, "_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    .line 1902
    :goto_0
    if-eqz v1, :cond_0

    .line 1904
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1908
    :cond_0
    return v0

    .line 1902
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_1
    if-eqz v1, :cond_1

    .line 1904
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1905
    :cond_1
    throw v0

    .line 1902
    :catchall_1
    move-exception v0

    goto :goto_1

    :cond_2
    move v0, v7

    goto :goto_0
.end method

.method private _getUnzipFileDirPath(I)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 3025
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 3033
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3035
    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3036
    const-string v1, ".localytics"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3037
    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3038
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3039
    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3040
    const-string v1, "marketing_rule_%d"

    new-array v2, v5, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3042
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 3044
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 3047
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Ljava/io/File;->isDirectory()Z

    move-result v2

    if-nez v2, :cond_1

    .line 3049
    :cond_0
    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    move-result v2

    if-nez v2, :cond_1

    .line 3051
    const-string v0, "Could not create the directory %s for saving the decompressed file."

    new-array v2, v5, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v2, v4

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 3052
    const/4 v0, 0x0

    .line 3056
    :cond_1
    return-object v0
.end method

.method private _getZipFileDirPath()Ljava/lang/String;
    .locals 2

    .prologue
    .line 2999
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 3007
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3009
    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3010
    const-string v1, ".localytics"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3011
    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3012
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3014
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private _handlePushReceived(Landroid/content/Intent;)V
    .locals 14

    .prologue
    .line 226
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ll"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 227
    if-nez v0, :cond_1

    .line 229
    const-string v0, "Ignoring message that aren\'t from Localytics."

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 358
    :cond_0
    :goto_0
    return-void

    .line 235
    :cond_1
    :try_start_0
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 239
    const-string v0, "ca"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v6

    .line 247
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "message"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 248
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->isPushDisabled()Z

    move-result v8

    .line 249
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_4

    const/4 v0, 0x1

    move v4, v0

    .line 250
    :goto_1
    if-nez v8, :cond_5

    if-eqz v4, :cond_5

    const/4 v0, 0x1

    .line 253
    :goto_2
    :try_start_1
    const-string v1, "cr"

    invoke-virtual {v5, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 254
    const-string v1, "v"

    const-string v2, "1"

    invoke-virtual {v5, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 255
    const-string v1, "t"

    const/4 v2, 0x0

    invoke-virtual {v5, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 256
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 258
    if-eqz v4, :cond_6

    .line 260
    const-string v1, "Alert"

    move-object v3, v1

    .line 268
    :goto_3
    const-string v1, "Not Available"

    .line 269
    iget-object v2, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->isAutoIntegrate()Z

    move-result v2

    if-eqz v2, :cond_c

    .line 271
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1}, Lcom/localytics/android/LocalyticsDao;->isAppInForeground()Z

    move-result v1

    if-eqz v1, :cond_7

    .line 273
    const-string v1, "Foreground"

    move-object v2, v1

    .line 282
    :goto_4
    if-eqz v4, :cond_9

    .line 284
    if-eqz v8, :cond_8

    const-string v1, "No"

    .line 291
    :goto_5
    new-instance v11, Ljava/util/HashMap;

    invoke-direct {v11}, Ljava/util/HashMap;-><init>()V

    .line 292
    const-string v12, "Campaign ID"

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v11, v12, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 293
    const-string v12, "Creative ID"

    invoke-virtual {v11, v12, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 294
    const-string v9, "Creative Type"

    invoke-virtual {v11, v9, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 295
    const-string v3, "Creative Displayed"

    invoke-virtual {v11, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 296
    const-string v3, "Push Notifications Enabled"

    if-eqz v8, :cond_a

    const-string v1, "No"

    :goto_6
    invoke-virtual {v11, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 297
    const-string v1, "App Context"

    invoke-virtual {v11, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 298
    const-string v1, "Schema Version - Client"

    const-string v2, "3"

    invoke-virtual {v11, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 299
    const-string v1, "Schema Version - Server"

    invoke-virtual {v11, v1, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 302
    const-string v1, "x"

    const/4 v2, 0x0

    invoke-virtual {v5, v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v1

    if-nez v1, :cond_2

    .line 304
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    const-string v2, "Localytics Push Received"

    invoke-interface {v1, v2, v11}, Lcom/localytics/android/LocalyticsDao;->tagEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 305
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1}, Lcom/localytics/android/LocalyticsDao;->upload()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 313
    :cond_2
    :goto_7
    if-nez v0, :cond_b

    .line 315
    if-eqz v8, :cond_3

    .line 317
    const-string v0, "Got push notification while push is disabled."

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 320
    :cond_3
    if-nez v4, :cond_0

    .line 322
    const-string v0, "Got push notification without a message."

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    goto/16 :goto_0

    .line 243
    :catch_0
    move-exception v0

    const-string v0, "Failed to get campaign id from payload, ignoring message"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    goto/16 :goto_0

    .line 249
    :cond_4
    const/4 v0, 0x0

    move v4, v0

    goto/16 :goto_1

    .line 250
    :cond_5
    const/4 v0, 0x0

    goto/16 :goto_2

    .line 264
    :cond_6
    :try_start_2
    const-string v1, "Silent"

    move-object v3, v1

    goto/16 :goto_3

    .line 277
    :cond_7
    const-string v1, "Background"

    move-object v2, v1

    goto :goto_4

    .line 284
    :cond_8
    const-string v1, "Yes"

    goto :goto_5

    .line 288
    :cond_9
    const-string v1, "Not Applicable"

    goto :goto_5

    .line 296
    :cond_a
    const-string v1, "Yes"
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_6

    .line 310
    :catch_1
    move-exception v1

    const-string v1, "Failed to get campaign id or creative id from payload"

    invoke-static {v1}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    goto :goto_7

    .line 328
    :cond_b
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v1

    .line 329
    const-string v0, ""

    .line 330
    invoke-static {v1}, Lcom/localytics/android/DatapointHelper;->getLocalyticsNotificationIcon(Landroid/content/Context;)I

    move-result v2

    .line 333
    :try_start_3
    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v3

    .line 334
    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    invoke-virtual {v4, v3}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    :try_end_3
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_3 .. :try_end_3} :catch_2

    move-result-object v0

    .line 342
    :goto_8
    new-instance v3, Landroid/content/Intent;

    const-class v4, Lcom/localytics/android/PushTrackingActivity;

    invoke-direct {v3, v1, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 343
    invoke-virtual {v3, p1}, Landroid/content/Intent;->putExtras(Landroid/content/Intent;)Landroid/content/Intent;

    .line 344
    const/4 v4, 0x0

    const/high16 v5, 0x8000000

    invoke-static {v1, v4, v3, v5}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v3

    .line 346
    new-instance v4, Landroid/support/v4/app/bq;

    invoke-direct {v4, v1}, Landroid/support/v4/app/bq;-><init>(Landroid/content/Context;)V

    invoke-virtual {v4, v2}, Landroid/support/v4/app/bq;->a(I)Landroid/support/v4/app/bq;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/support/v4/app/bq;->a(Ljava/lang/CharSequence;)Landroid/support/v4/app/bq;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/support/v4/app/bq;->b(Ljava/lang/CharSequence;)Landroid/support/v4/app/bq;

    move-result-object v0

    iput-object v3, v0, Landroid/support/v4/app/bq;->d:Landroid/app/PendingIntent;

    iget-object v2, v0, Landroid/support/v4/app/bq;->B:Landroid/app/Notification;

    const/4 v3, -0x1

    iput v3, v2, Landroid/app/Notification;->defaults:I

    iget-object v2, v0, Landroid/support/v4/app/bq;->B:Landroid/app/Notification;

    iget v3, v2, Landroid/app/Notification;->flags:I

    or-int/lit8 v3, v3, 0x1

    iput v3, v2, Landroid/app/Notification;->flags:I

    new-instance v2, Landroid/support/v4/app/bp;

    invoke-direct {v2}, Landroid/support/v4/app/bp;-><init>()V

    invoke-virtual {v2, v7}, Landroid/support/v4/app/bp;->a(Ljava/lang/CharSequence;)Landroid/support/v4/app/bp;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/v4/app/bq;->a(Landroid/support/v4/app/cb;)Landroid/support/v4/app/bq;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/bq;->a()Landroid/support/v4/app/bq;

    move-result-object v2

    .line 356
    const-string v0, "notification"

    invoke-virtual {v1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 357
    invoke-static {}, Landroid/support/v4/app/bl;->a()Landroid/support/v4/app/bs;

    move-result-object v1

    invoke-interface {v1, v2}, Landroid/support/v4/app/bs;->a(Landroid/support/v4/app/bq;)Landroid/app/Notification;

    move-result-object v1

    invoke-virtual {v0, v6, v1}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    goto/16 :goto_0

    .line 338
    :catch_2
    move-exception v3

    const-string v3, "Failed to get application name, icon, or launch intent"

    invoke-static {v3}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    goto :goto_8

    :cond_c
    move-object v2, v1

    goto/16 :goto_4

    :cond_d
    move-object v3, v1

    goto/16 :goto_3
.end method

.method private _isConnectingToInternet()Z
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 2817
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v0

    const-string v2, "connectivity"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 2818
    if-eqz v0, :cond_1

    .line 2820
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getAllNetworkInfo()[Landroid/net/NetworkInfo;

    move-result-object v2

    .line 2821
    if-eqz v2, :cond_1

    .line 2823
    array-length v3, v2

    move v0, v1

    :goto_0
    if-ge v0, v3, :cond_1

    aget-object v4, v2, v0

    .line 2825
    invoke-virtual {v4}, Landroid/net/NetworkInfo;->getState()Landroid/net/NetworkInfo$State;

    move-result-object v4

    sget-object v5, Landroid/net/NetworkInfo$State;->CONNECTED:Landroid/net/NetworkInfo$State;

    if-ne v4, v5, :cond_0

    .line 2827
    const/4 v0, 0x1

    .line 2832
    :goto_1
    return v0

    .line 2823
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    move v0, v1

    .line 2832
    goto :goto_1
.end method

.method private _isMarketingMessageSatisfiedConditions(Lcom/localytics/android/MarketingMessage;Ljava/util/Map;)Z
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/localytics/android/MarketingMessage;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 2844
    const/4 v1, 0x1

    .line 2847
    const-string v0, "campaign_id"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 2848
    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingHandler;->_getRuleIdFromCampaignId(I)I

    move-result v0

    .line 2851
    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingHandler;->_getMarketingConditions(I)Ljava/util/Vector;

    move-result-object v0

    .line 2854
    if-eqz v0, :cond_1

    .line 2856
    invoke-virtual {v0}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingCondition;

    .line 2858
    invoke-virtual {v0, p2}, Lcom/localytics/android/MarketingCondition;->isSatisfiedByAttributes(Ljava/util/Map;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2860
    const/4 v0, 0x0

    .line 2866
    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method private _parseMarketingMessage(Lcom/localytics/android/MarketingMessage;)Landroid/content/ContentValues;
    .locals 5

    .prologue
    const/4 v0, 0x1

    .line 1652
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 1654
    const-string v2, "campaign_id"

    const-string v3, "campaign_id"

    invoke-static {p1, v3}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1655
    const-string v2, "expiration"

    const-string v3, "expiration"

    invoke-static {p1, v3}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1656
    const-string v2, "display_seconds"

    const-string v3, "display_seconds"

    invoke-static {p1, v3}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1657
    const-string v2, "display_session"

    const-string v3, "display_session"

    invoke-static {p1, v3}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1658
    const-string v2, "version"

    const-string v3, "version"

    invoke-static {p1, v3}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1659
    const-string v2, "phone_location"

    const-string v3, "phone_location"

    invoke-static {p1, v3}, Lcom/localytics/android/JsonHelper;->getSafeStringFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1660
    const-string v2, "phone_size"

    invoke-static {p1, v2}, Lcom/localytics/android/JsonHelper;->getSafeMapFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v2

    .line 1661
    const-string v3, "phone_size_width"

    const-string v4, "width"

    invoke-static {v2, v4}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1662
    const-string v3, "phone_size_height"

    const-string v4, "height"

    invoke-static {v2, v4}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1663
    const-string v2, "tablet_size"

    invoke-static {p1, v2}, Lcom/localytics/android/JsonHelper;->getSafeMapFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v2

    .line 1664
    const-string v3, "tablet_location"

    const-string v4, "tablet_location"

    invoke-static {p1, v4}, Lcom/localytics/android/JsonHelper;->getSafeStringFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1665
    const-string v3, "tablet_size_width"

    const-string v4, "width"

    invoke-static {v2, v4}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1666
    const-string v3, "tablet_size_height"

    const-string v4, "height"

    invoke-static {v2, v4}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1667
    const-string v2, "time_to_display"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1668
    const-string v2, "internet_required"

    const-string v3, "internet_required"

    invoke-static {p1, v3}, Lcom/localytics/android/JsonHelper;->getSafeBooleanFromMap(Ljava/util/Map;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    :goto_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1669
    const-string v0, "ab_test"

    const-string v2, "ab"

    invoke-static {p1, v2}, Lcom/localytics/android/JsonHelper;->getSafeStringFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1670
    const-string v0, "rule_name"

    invoke-static {p1, v0}, Lcom/localytics/android/JsonHelper;->getSafeStringFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1671
    const-string v2, "rule_name_non_unique"

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1672
    const-string v0, "rule_name"

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1673
    const-string v0, "location"

    const-string v2, "location"

    invoke-static {p1, v2}, Lcom/localytics/android/JsonHelper;->getSafeStringFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1674
    const-string v0, "devices"

    const-string v2, "devices"

    invoke-static {p1, v2}, Lcom/localytics/android/JsonHelper;->getSafeStringFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1675
    const-string v0, "control_group"

    const-string v2, "control_group"

    invoke-static {p1, v2}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1676
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mConfigurations:Ljava/util/Map;

    if-eqz v0, :cond_0

    .line 1678
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mConfigurations:Ljava/util/Map;

    const-string v2, "schema_version"

    invoke-static {v0, v2}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v0

    .line 1679
    if-lez v0, :cond_0

    .line 1681
    const-string v2, "schema_version"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1685
    :cond_0
    return-object v1

    .line 1668
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private _retrieveDisplayingCandidate(Ljava/util/List;Ljava/util/Map;)Lcom/localytics/android/MarketingMessage;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/localytics/android/MarketingMessage;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/localytics/android/MarketingMessage;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x1

    .line 2512
    .line 2514
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    move-object v2, v3

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingMessage;

    .line 2517
    const-string v1, "internet_required"

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-ne v1, v4, :cond_2

    move v1, v4

    .line 2518
    :goto_1
    if-eqz v1, :cond_1

    invoke-direct {p0}, Lcom/localytics/android/MarketingHandler;->_isConnectingToInternet()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2520
    :cond_1
    invoke-direct {p0, v0, p2}, Lcom/localytics/android/MarketingHandler;->_isMarketingMessageSatisfiedConditions(Lcom/localytics/android/MarketingMessage;Ljava/util/Map;)Z

    move-result v1

    if-eqz v1, :cond_0

    move-object v2, v0

    .line 2530
    goto :goto_0

    .line 2517
    :cond_2
    const/4 v1, 0x0

    goto :goto_1

    .line 2532
    :cond_3
    if-eqz v2, :cond_4

    invoke-direct {p0, v2}, Lcom/localytics/android/MarketingHandler;->_updateDisplayingCandidate(Lcom/localytics/android/MarketingMessage;)Z

    move-result v0

    if-nez v0, :cond_5

    :cond_4
    move-object v2, v3

    .line 2537
    :cond_5
    return-object v2
.end method

.method private _saveMarketingConditions(JLjava/util/List;)V
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v11, 0x1

    const/4 v2, 0x0

    .line 1690
    if-nez p3, :cond_1

    .line 1726
    :cond_0
    return-void

    .line 1696
    :cond_1
    invoke-direct {p0, p1, p2}, Lcom/localytics/android/MarketingHandler;->_getConditionIdFromRuleId(J)[J

    move-result-object v1

    .line 1697
    array-length v3, v1

    move v0, v2

    :goto_0
    if-ge v0, v3, :cond_2

    aget-wide v4, v1, v0

    .line 1699
    iget-object v6, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v7, "marketing_condition_values"

    const-string v8, "%s = ?"

    new-array v9, v11, [Ljava/lang/Object;

    const-string v10, "condition_id_ref"

    aput-object v10, v9, v2

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    new-array v9, v11, [Ljava/lang/String;

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v9, v2

    invoke-virtual {v6, v7, v8, v9}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1697
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1701
    :cond_2
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "marketing_conditions"

    const-string v3, "%s = ?"

    new-array v4, v11, [Ljava/lang/Object;

    const-string v5, "rule_id_ref"

    aput-object v5, v4, v2

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    new-array v4, v11, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v2

    invoke-virtual {v0, v1, v3, v4}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1703
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    .line 1706
    check-cast v0, Ljava/util/List;

    .line 1710
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 1711
    const-string v5, "attribute_name"

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v4, v5, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1712
    const-string v5, "operator"

    invoke-interface {v0, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v4, v5, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1713
    const-string v1, "rule_id_ref"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v4, v1, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1714
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v5, "marketing_conditions"

    invoke-virtual {v1, v5, v4}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v4

    .line 1718
    const/4 v1, 0x2

    :goto_1
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v6

    if-ge v1, v6, :cond_3

    .line 1720
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6}, Landroid/content/ContentValues;-><init>()V

    .line 1721
    const-string v7, "value"

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    invoke-static {v8}, Lcom/localytics/android/JsonHelper;->getSafeStringFromValue(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1722
    const-string v7, "condition_id_ref"

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1723
    iget-object v7, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v8, "marketing_condition_values"

    invoke-virtual {v7, v8, v6}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 1718
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method private _tagAmpActionEventForControlGroup(Lcom/localytics/android/MarketingMessage;)V
    .locals 6

    .prologue
    .line 2122
    new-instance v1, Ljava/util/TreeMap;

    invoke-direct {v1}, Ljava/util/TreeMap;-><init>()V

    .line 2124
    const-string v0, "campaign_id"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 2125
    const-string v0, "rule_name_non_unique"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 2126
    const-string v0, "schema_version"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 2127
    const-string v0, "ab_test"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 2128
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 2130
    const-string v5, "ampAB"

    invoke-virtual {v1, v5, v0}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2133
    :cond_0
    const-string v0, "ampAction"

    const-string v5, "control"

    invoke-virtual {v1, v0, v5}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2134
    const-string v0, "type"

    const-string v5, "Control"

    invoke-virtual {v1, v0, v5}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2135
    const-string v0, "ampCampaignId"

    invoke-virtual {v1, v0, v2}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2136
    const-string v0, "ampCampaign"

    invoke-virtual {v1, v0, v3}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2137
    const-string v0, "Schema Version - Client"

    const-string v2, "3"

    invoke-virtual {v1, v0, v2}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2138
    const-string v0, "Schema Version - Server"

    invoke-virtual {v1, v0, v4}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2139
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    const-string v2, "ampView"

    invoke-interface {v0, v2, v1}, Lcom/localytics/android/LocalyticsDao;->tagEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 2140
    return-void
.end method

.method private _timeStringToSeconds(Ljava/lang/String;)I
    .locals 3

    .prologue
    .line 1226
    :try_start_0
    const-string v0, ":"

    invoke-virtual {p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 1227
    const/4 v1, 0x0

    aget-object v1, v0, v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    mul-int/lit16 v1, v1, 0xe10

    const/4 v2, 0x1

    aget-object v0, v0, v2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    mul-int/lit8 v0, v0, 0x3c

    add-int/2addr v0, v1

    .line 1231
    :goto_0
    return v0

    :catch_0
    move-exception v0

    const/4 v0, -0x1

    goto :goto_0
.end method

.method private _updateDisplayingCandidate(Lcom/localytics/android/MarketingMessage;)Z
    .locals 12

    .prologue
    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 2874
    const/4 v1, 0x0

    .line 2875
    const-string v0, "_id"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 2876
    invoke-direct {p0}, Lcom/localytics/android/MarketingHandler;->_getZipFileDirPath()Ljava/lang/String;

    move-result-object v4

    .line 2877
    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingHandler;->_getUnzipFileDirPath(I)Ljava/lang/String;

    move-result-object v5

    .line 2878
    invoke-direct {p0, p1}, Lcom/localytics/android/MarketingHandler;->_getRemoteFileURL(Lcom/localytics/android/MarketingMessage;)Ljava/lang/String;

    move-result-object v6

    const-string v7, ".zip"

    invoke-virtual {v6, v7}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v6

    .line 2881
    invoke-direct {p0, v0, v6}, Lcom/localytics/android/MarketingHandler;->_doesCreativeExist(IZ)Z

    move-result v7

    if-nez v7, :cond_0

    .line 2884
    invoke-static {p1}, Lcom/localytics/android/MarketingDownloader;->getRemoteFileURL(Lcom/localytics/android/MarketingMessage;)Ljava/lang/String;

    move-result-object v7

    .line 2885
    int-to-long v8, v0

    iget-object v10, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v10}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v10

    iget-object v11, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v11}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v11

    invoke-static {v8, v9, v6, v10, v11}, Lcom/localytics/android/MarketingDownloader;->getLocalFileURL(JZLandroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 2888
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_0

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_0

    .line 2890
    iget-object v9, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v9}, Lcom/localytics/android/LocalyticsDao;->getProxy()Ljava/net/Proxy;

    move-result-object v9

    invoke-static {v7, v8, v3, v9}, Lcom/localytics/android/MarketingDownloader;->downloadFile(Ljava/lang/String;Ljava/lang/String;ZLjava/net/Proxy;)Ljava/lang/String;

    .line 2895
    :cond_0
    if-eqz v6, :cond_2

    .line 2898
    const-string v6, "amp_rule_%d.zip"

    new-array v7, v3, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v7, v2

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v4, v5, v0}, Lcom/localytics/android/MarketingHandler;->_decompressZipFile(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2901
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "file://"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "index.html"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 2909
    :cond_1
    :goto_0
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    move v0, v2

    .line 2945
    :goto_1
    return v0

    .line 2906
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "file://"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "index.html"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto :goto_0

    .line 2919
    :cond_3
    const-string v0, "devices"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 2921
    const-string v2, "tablet"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 2923
    const-string v0, "tablet_size_width"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 2924
    const-string v0, "tablet_size_height"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 2940
    :goto_2
    const-string v4, "html_url"

    invoke-virtual {p1, v4, v1}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2941
    const-string v1, "base_path"

    invoke-virtual {p1, v1, v5}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2942
    const-string v1, "display_width"

    int-to-float v2, v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2943
    const-string v1, "display_height"

    int-to-float v0, v0

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    invoke-virtual {p1, v1, v0}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move v0, v3

    .line 2945
    goto :goto_1

    .line 2926
    :cond_4
    const-string v2, "both"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 2928
    const-string v0, "phone_size_width"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 2934
    const-string v0, "phone_size_height"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    goto :goto_2
.end method

.method static synthetic access$100(Lcom/localytics/android/MarketingHandler;)V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0}, Lcom/localytics/android/MarketingHandler;->__showMarketingTest()V

    return-void
.end method

.method static synthetic access$1000(Lcom/localytics/android/MarketingHandler;Ljava/util/Map;)Landroid/util/SparseArray;
    .locals 1

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/localytics/android/MarketingHandler;->_getJavaScriptClientCallbacks(Ljava/util/Map;)Landroid/util/SparseArray;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1100()Ljava/util/List;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/localytics/android/MarketingHandler;->JS_STRINGS_THAT_MEAN_NULL:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$200(Lcom/localytics/android/MarketingHandler;Landroid/content/Intent;)V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/localytics/android/MarketingHandler;->_handlePushReceived(Landroid/content/Intent;)V

    return-void
.end method

.method static synthetic access$300(Lcom/localytics/android/MarketingHandler;)Landroid/support/v4/app/ah;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;

    return-object v0
.end method

.method static synthetic access$400(Lcom/localytics/android/MarketingHandler;)Z
    .locals 1

    .prologue
    .line 76
    iget-boolean v0, p0, Lcom/localytics/android/MarketingHandler;->mCampaignDisplaying:Z

    return v0
.end method

.method static synthetic access$402(Lcom/localytics/android/MarketingHandler;Z)Z
    .locals 0

    .prologue
    .line 76
    iput-boolean p1, p0, Lcom/localytics/android/MarketingHandler;->mCampaignDisplaying:Z

    return p1
.end method

.method static synthetic access$500(Lcom/localytics/android/MarketingHandler;I)V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/localytics/android/MarketingHandler;->setMarketingMessageAsNotDisplayed(I)V

    return-void
.end method

.method static synthetic access$602(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/MarketingRulesAdapter;)Lcom/localytics/android/MarketingRulesAdapter;
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/localytics/android/MarketingHandler;->testCampaignsListAdapter:Lcom/localytics/android/MarketingRulesAdapter;

    return-object p1
.end method

.method static synthetic access$700(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/MarketingMessage;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/localytics/android/MarketingHandler;->_getRemoteFileURL(Lcom/localytics/android/MarketingMessage;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$800(Lcom/localytics/android/MarketingHandler;IZ)Z
    .locals 1

    .prologue
    .line 76
    invoke-direct {p0, p1, p2}, Lcom/localytics/android/MarketingHandler;->_doesCreativeExist(IZ)Z

    move-result v0

    return v0
.end method

.method static synthetic access$900(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/MarketingMessage;)Z
    .locals 1

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/localytics/android/MarketingHandler;->_updateDisplayingCandidate(Lcom/localytics/android/MarketingMessage;)Z

    move-result v0

    return v0
.end method

.method private setMarketingMessageAsNotDisplayed(I)V
    .locals 2

    .prologue
    .line 535
    const/16 v0, 0xcd

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/localytics/android/MarketingHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->queueMessage(Landroid/os/Message;)Z

    .line 536
    return-void
.end method


# virtual methods
.method _additionalFCDatesAndTimesRulesValidation(Ljava/util/List;Ljava/text/SimpleDateFormat;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/text/SimpleDateFormat;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 960
    if-eqz p1, :cond_1

    .line 962
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 966
    :try_start_0
    sget-object v1, Lcom/localytics/android/Constants;->START_KEY:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {p2, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 967
    sget-object v3, Lcom/localytics/android/Constants;->END_KEY:Ljava/lang/String;

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 968
    invoke-virtual {v1, v0}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 970
    new-instance v0, Ljava/lang/Exception;

    invoke-direct {v0}, Ljava/lang/Exception;-><init>()V

    throw v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 975
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    .line 977
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method _additionalFCDisplayFrequencyRulesValidation(Ljava/util/List;)Z
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;>;)Z"
        }
    .end annotation

    .prologue
    .line 944
    if-eqz p1, :cond_2

    .line 946
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 948
    sget-object v1, Lcom/localytics/android/Constants;->DAYS_KEY:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-lez v1, :cond_1

    sget-object v1, Lcom/localytics/android/Constants;->COUNT_KEY:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-gtz v0, :cond_0

    .line 950
    :cond_1
    const/4 v0, 0x0

    .line 955
    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method _additionalFCWeekdaysRulesValidation(Ljava/util/List;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)Z"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 985
    if-eqz p1, :cond_3

    .line 987
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    const/4 v2, 0x7

    if-le v0, v2, :cond_0

    move v0, v1

    .line 1003
    :goto_0
    return v0

    .line 993
    :cond_0
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 995
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-ltz v3, :cond_2

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v3, 0x6

    if-le v0, v3, :cond_1

    :cond_2
    move v0, v1

    .line 997
    goto :goto_0

    .line 1003
    :cond_3
    const/4 v0, 0x1

    goto :goto_0
.end method

.method _augmentBlackoutRule(Ljava/util/Map;)Ljava/util/Map;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1129
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0, p1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 1130
    sget-object v1, Lcom/localytics/android/Constants;->DATES_KEY:Ljava/lang/String;

    invoke-interface {p1, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    .line 1131
    sget-object v2, Lcom/localytics/android/Constants;->WEEKDAYS_KEY:Ljava/lang/String;

    invoke-interface {p1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    .line 1132
    sget-object v3, Lcom/localytics/android/Constants;->TIMES_KEY:Ljava/lang/String;

    invoke-interface {p1, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    .line 1134
    if-nez v1, :cond_0

    if-eqz v2, :cond_2

    :cond_0
    if-nez v3, :cond_2

    .line 1136
    sget-object v1, Lcom/localytics/android/Constants;->TIMES_KEY:Ljava/lang/String;

    new-instance v2, Ljava/util/ArrayList;

    sget-object v3, Lcom/localytics/android/MarketingHandler;->AUGMENTED_BLACKOUT_TIMES_RULE:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1143
    :cond_1
    :goto_0
    return-object v0

    .line 1138
    :cond_2
    if-eqz v3, :cond_1

    if-nez v1, :cond_1

    if-nez v2, :cond_1

    .line 1140
    sget-object v1, Lcom/localytics/android/Constants;->WEEKDAYS_KEY:Ljava/lang/String;

    new-instance v2, Ljava/util/ArrayList;

    sget-object v3, Lcom/localytics/android/MarketingHandler;->AUGMENTED_BLACKOUT_WEEKDAYS_RULE:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method _checkFrequencyCappingRuleArray(Ljava/util/List;[Ljava/lang/String;)Z
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<*>;[",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 914
    if-eqz p1, :cond_3

    .line 916
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-gtz v0, :cond_0

    move v0, v1

    .line 939
    :goto_0
    return v0

    .line 922
    :cond_0
    array-length v0, p2

    if-lez v0, :cond_3

    .line 924
    array-length v3, p2

    move v2, v1

    :goto_1
    if-ge v2, v3, :cond_3

    aget-object v4, p2, v2

    .line 927
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 929
    invoke-interface {v0, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v1

    .line 931
    goto :goto_0

    .line 925
    :cond_2
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    .line 939
    :cond_3
    const/4 v0, 0x1

    goto :goto_0
.end method

.method _deleteFrequencyCappingRule(Ljava/lang/Integer;)Z
    .locals 8

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 1046
    :try_start_0
    iget-object v2, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "frequency_capping_rules"

    const-string v4, "%s = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "campaign_id"

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v2, v3, v4, v5}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1051
    :goto_0
    return v0

    :catch_0
    move-exception v0

    move v0, v1

    goto :goto_0
.end method

.method protected _deleteUploadedData(I)V
    .locals 0

    .prologue
    .line 571
    return-void
.end method

.method _filterMarketingMessagesDisqualifiedByFrequencyCappingRules(Ljava/util/List;)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/localytics/android/MarketingMessage;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/localytics/android/MarketingMessage;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1238
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 1239
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingMessage;

    .line 1241
    const-string v3, "campaign_id"

    invoke-virtual {v0, v3}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-interface {v2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1244
    :cond_0
    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 1246
    sget-object v0, Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;->MAX_COUNT:Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;

    invoke-virtual {p0, v0, v2}, Lcom/localytics/android/MarketingHandler;->_getDisqualifiedCampaigns(Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 1248
    :cond_1
    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 1250
    sget-object v0, Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;->FREQUENCY:Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;

    invoke-virtual {p0, v0, v2}, Lcom/localytics/android/MarketingHandler;->_getDisqualifiedCampaigns(Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 1252
    :cond_2
    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_3

    .line 1254
    sget-object v0, Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;->BLACKOUT:Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;

    invoke-virtual {p0, v0, v2}, Lcom/localytics/android/MarketingHandler;->_getDisqualifiedCampaigns(Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 1256
    :cond_3
    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_4

    .line 1258
    sget-object v0, Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;->FREQUENCY:Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;

    invoke-virtual {p0, v0, v2}, Lcom/localytics/android/MarketingHandler;->_getGloballyDisqualifiedCampaigns(Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 1260
    :cond_4
    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_5

    .line 1262
    sget-object v0, Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;->BLACKOUT:Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;

    invoke-virtual {p0, v0, v2}, Lcom/localytics/android/MarketingHandler;->_getGloballyDisqualifiedCampaigns(Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 1265
    :cond_5
    new-instance v3, Ljava/util/LinkedList;

    invoke-direct {v3}, Ljava/util/LinkedList;-><init>()V

    .line 1267
    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_7

    .line 1269
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_6
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Lcom/localytics/android/MarketingMessage;

    .line 1271
    const-string v0, "campaign_id"

    invoke-virtual {v1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 1272
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 1274
    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1279
    :cond_7
    return-object v3
.end method

.method protected _getDataToUpload()Ljava/util/TreeMap;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1953
    new-instance v0, Ljava/util/TreeMap;

    invoke-direct {v0}, Ljava/util/TreeMap;-><init>()V

    .line 1954
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1955
    return-object v0
.end method

.method _getDisqualifiedCampaigns(Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;Ljava/util/Set;)Ljava/util/Set;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x3

    const/4 v10, 0x7

    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 1298
    sget-object v0, Lcom/localytics/android/MarketingHandler$25;->$SwitchMap$com$localytics$android$MarketingHandler$FrequencyCappingFilter:[I

    invoke-virtual {p1}, Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1386
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    :goto_0
    return-object v0

    .line 1301
    :pswitch_0
    const-string v0, "SELECT fc.%s FROM %s AS fc JOIN %s AS cd ON fc.%s=cd.%s WHERE cd.%s in (%s) GROUP BY fc.%s HAVING count(*) >= fc.%s;"

    const/16 v1, 0x9

    new-array v1, v1, [Ljava/lang/Object;

    const-string v2, "campaign_id"

    aput-object v2, v1, v7

    const-string v2, "frequency_capping_rules"

    aput-object v2, v1, v8

    const-string v2, "campaigns_displayed"

    aput-object v2, v1, v9

    const-string v2, "campaign_id"

    aput-object v2, v1, v6

    const/4 v2, 0x4

    const-string v3, "campaign_id"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "campaign_id"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, ","

    invoke-static {v3, p2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const-string v2, "campaign_id"

    aput-object v2, v1, v10

    const/16 v2, 0x8

    const-string v3, "max_display_count"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingHandler;->_getCampaignIdsFromFrequencyCappingQuery(Ljava/lang/String;)Ljava/util/Set;

    move-result-object v0

    goto :goto_0

    .line 1318
    :pswitch_1
    const-string v0, "SELECT DISTINCT fc.%s FROM %s AS fc JOIN %s AS df ON fc.%s=df.%s JOIN %s AS cd ON fc.%s=cd.%s WHERE (cd.%s BETWEEN datetime(\'%s\',\'-\'||df.%s||\' days\') AND datetime(\'%s\')) AND fc.%s in (%s) GROUP BY df.%s HAVING count(cd.%s) >= df.%s;"

    const/16 v1, 0x11

    new-array v1, v1, [Ljava/lang/Object;

    const-string v2, "campaign_id"

    aput-object v2, v1, v7

    const-string v2, "frequency_capping_rules"

    aput-object v2, v1, v8

    const-string v2, "frequency_capping_display_frequencies"

    aput-object v2, v1, v9

    const-string v2, "_id"

    aput-object v2, v1, v6

    const/4 v2, 0x4

    const-string v3, "frequency_id"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "campaigns_displayed"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "campaign_id"

    aput-object v3, v1, v2

    const-string v2, "campaign_id"

    aput-object v2, v1, v10

    const/16 v2, 0x8

    const-string v3, "date"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    iget-object v3, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3}, Lcom/localytics/android/LocalyticsDao;->getTimeStringForSQLite()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/16 v2, 0xa

    const-string v3, "days"

    aput-object v3, v1, v2

    const/16 v2, 0xb

    iget-object v3, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3}, Lcom/localytics/android/LocalyticsDao;->getTimeStringForSQLite()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/16 v2, 0xc

    const-string v3, "campaign_id"

    aput-object v3, v1, v2

    const/16 v2, 0xd

    const-string v3, ","

    invoke-static {v3, p2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/16 v2, 0xe

    const-string v3, "_id"

    aput-object v3, v1, v2

    const/16 v2, 0xf

    const-string v3, "date"

    aput-object v3, v1, v2

    const/16 v2, 0x10

    const-string v3, "count"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingHandler;->_getCampaignIdsFromFrequencyCappingQuery(Ljava/lang/String;)Ljava/util/Set;

    move-result-object v0

    goto/16 :goto_0

    .line 1341
    :pswitch_2
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getCalendar()Ljava/util/Calendar;

    move-result-object v0

    .line 1342
    invoke-virtual {v0, v10}, Ljava/util/Calendar;->get(I)I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    .line 1343
    const/16 v2, 0xb

    invoke-virtual {v0, v2}, Ljava/util/Calendar;->get(I)I

    move-result v2

    mul-int/lit8 v2, v2, 0x3c

    const/16 v3, 0xc

    invoke-virtual {v0, v3}, Ljava/util/Calendar;->get(I)I

    move-result v3

    add-int/2addr v2, v3

    mul-int/lit8 v2, v2, 0x3c

    const/16 v3, 0xd

    invoke-virtual {v0, v3}, Ljava/util/Calendar;->get(I)I

    move-result v0

    add-int/2addr v2, v0

    .line 1345
    const-string v0, "SELECT fc.%s FROM %s AS fc, %s AS d, %s AS t WHERE ((fc.%s=t.%s) AND (fc.%s=d.%s)) AND (d.%s=t.%s) AND (datetime(\'%s\',\'localtime\') BETWEEN d.%s and d.%s) AND (? BETWEEN t.%s AND t.%s) AND fc.%s IN (%s);"

    const/16 v3, 0x11

    new-array v3, v3, [Ljava/lang/Object;

    const-string v4, "campaign_id"

    aput-object v4, v3, v7

    const-string v4, "frequency_capping_rules"

    aput-object v4, v3, v8

    const-string v4, "frequency_capping_blackout_dates"

    aput-object v4, v3, v9

    const-string v4, "frequency_capping_blackout_times"

    aput-object v4, v3, v6

    const/4 v4, 0x4

    const-string v5, "_id"

    aput-object v5, v3, v4

    const/4 v4, 0x5

    const-string v5, "frequency_id"

    aput-object v5, v3, v4

    const/4 v4, 0x6

    const-string v5, "_id"

    aput-object v5, v3, v4

    const-string v4, "frequency_id"

    aput-object v4, v3, v10

    const/16 v4, 0x8

    const-string v5, "rule_group_id"

    aput-object v5, v3, v4

    const/16 v4, 0x9

    const-string v5, "rule_group_id"

    aput-object v5, v3, v4

    const/16 v4, 0xa

    iget-object v5, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v5}, Lcom/localytics/android/LocalyticsDao;->getTimeStringForSQLite()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/16 v4, 0xb

    const-string v5, "start"

    aput-object v5, v3, v4

    const/16 v4, 0xc

    const-string v5, "end"

    aput-object v5, v3, v4

    const/16 v4, 0xd

    const-string v5, "start"

    aput-object v5, v3, v4

    const/16 v4, 0xe

    const-string v5, "end"

    aput-object v5, v3, v4

    const/16 v4, 0xf

    const-string v5, "campaign_id"

    aput-object v5, v3, v4

    const/16 v4, 0x10

    const-string v5, ","

    invoke-static {v5, p2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    new-array v3, v8, [Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-direct {p0, v0, v3}, Lcom/localytics/android/MarketingHandler;->_getCampaignIdsFromFrequencyCappingQuery(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/Set;

    move-result-object v0

    .line 1364
    const-string v3, "SELECT fc.%s FROM %s AS fc, %s AS w, %s AS t WHERE ((fc.%s=t.%s) AND (fc.%s=w.%s)) AND (w.%s=t.%s) AND (w.%s=?)  AND (? BETWEEN t.%s AND t.%s) AND fc.%s IN (%s);"

    const/16 v4, 0xf

    new-array v4, v4, [Ljava/lang/Object;

    const-string v5, "campaign_id"

    aput-object v5, v4, v7

    const-string v5, "frequency_capping_rules"

    aput-object v5, v4, v8

    const-string v5, "frequency_capping_blackout_weekdays"

    aput-object v5, v4, v9

    const-string v5, "frequency_capping_blackout_times"

    aput-object v5, v4, v6

    const/4 v5, 0x4

    const-string v6, "_id"

    aput-object v6, v4, v5

    const/4 v5, 0x5

    const-string v6, "frequency_id"

    aput-object v6, v4, v5

    const/4 v5, 0x6

    const-string v6, "_id"

    aput-object v6, v4, v5

    const-string v5, "frequency_id"

    aput-object v5, v4, v10

    const/16 v5, 0x8

    const-string v6, "rule_group_id"

    aput-object v6, v4, v5

    const/16 v5, 0x9

    const-string v6, "rule_group_id"

    aput-object v6, v4, v5

    const/16 v5, 0xa

    const-string v6, "day"

    aput-object v6, v4, v5

    const/16 v5, 0xb

    const-string v6, "start"

    aput-object v6, v4, v5

    const/16 v5, 0xc

    const-string v6, "end"

    aput-object v6, v4, v5

    const/16 v5, 0xd

    const-string v6, "campaign_id"

    aput-object v6, v4, v5

    const/16 v5, 0xe

    const-string v6, ","

    invoke-static {v6, p2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    new-array v4, v9, [Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v7

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v8

    invoke-direct {p0, v3, v4}, Lcom/localytics/android/MarketingHandler;->_getCampaignIdsFromFrequencyCappingQuery(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/Set;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    goto/16 :goto_0

    .line 1298
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method _getGloballyDisqualifiedCampaigns(Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;Ljava/util/Set;)Ljava/util/Set;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1426
    const/4 v7, -0x1

    .line 1427
    const/4 v6, 0x0

    .line 1430
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "frequency_capping_rules"

    const/4 v2, 0x0

    const-string v3, "campaign_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v8, "-1"

    aput-object v8, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1431
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 1433
    const-string v0, "_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    move-result v0

    .line 1438
    :goto_0
    if-eqz v1, :cond_0

    .line 1440
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1444
    :cond_0
    const/4 v2, -0x1

    if-eq v0, v2, :cond_2

    .line 1448
    :try_start_2
    sget-object v2, Lcom/localytics/android/MarketingHandler$25;->$SwitchMap$com$localytics$android$MarketingHandler$FrequencyCappingFilter:[I

    invoke-virtual {p1}, Lcom/localytics/android/MarketingHandler$FrequencyCappingFilter;->ordinal()I

    move-result v3

    aget v2, v2, v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    packed-switch v2, :pswitch_data_0

    .line 1526
    :cond_1
    if-eqz v1, :cond_2

    .line 1528
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1533
    :cond_2
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    :cond_3
    :goto_1
    return-object v0

    .line 1438
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_2
    if-eqz v1, :cond_4

    .line 1440
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0

    .line 1451
    :pswitch_0
    :try_start_3
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    iget-object v0, v0, Lcom/localytics/android/BaseProvider;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "SELECT df.%s FROM %s AS fc JOIN %s AS df ON fc.%s = df.%s JOIN %s AS cd WHERE cd.%s = 0 AND fc.%s = ? AND (cd.%s BETWEEN datetime(\'%s\',\'-\'||df.%s||\' days\') AND datetime(\'%s\')) GROUP BY df.%s HAVING count(cd.%s) >= df.%s;"

    const/16 v3, 0xf

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "_id"

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string v5, "frequency_capping_rules"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string v5, "frequency_capping_display_frequencies"

    aput-object v5, v3, v4

    const/4 v4, 0x3

    const-string v5, "_id"

    aput-object v5, v3, v4

    const/4 v4, 0x4

    const-string v5, "frequency_id"

    aput-object v5, v3, v4

    const/4 v4, 0x5

    const-string v5, "campaigns_displayed"

    aput-object v5, v3, v4

    const/4 v4, 0x6

    const-string v5, "ignore_global"

    aput-object v5, v3, v4

    const/4 v4, 0x7

    const-string v5, "campaign_id"

    aput-object v5, v3, v4

    const/16 v4, 0x8

    const-string v5, "date"

    aput-object v5, v3, v4

    const/16 v4, 0x9

    iget-object v5, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v5}, Lcom/localytics/android/LocalyticsDao;->getTimeStringForSQLite()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/16 v4, 0xa

    const-string v5, "days"

    aput-object v5, v3, v4

    const/16 v4, 0xb

    iget-object v5, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v5}, Lcom/localytics/android/LocalyticsDao;->getTimeStringForSQLite()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/16 v4, 0xc

    const-string v5, "_id"

    aput-object v5, v3, v4

    const/16 v4, 0xd

    const-string v5, "date"

    aput-object v5, v3, v4

    const/16 v4, 0xe

    const-string v5, "count"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "-1"

    aput-object v5, v3, v4

    invoke-virtual {v0, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 1472
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_1

    .line 1474
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p2}, Lcom/localytics/android/MarketingHandler;->_getIgnoresGlobalCampaigns(ZLjava/util/Set;)Ljava/util/Set;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result-object v0

    .line 1526
    if-eqz v1, :cond_3

    .line 1528
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto/16 :goto_1

    .line 1479
    :pswitch_1
    :try_start_4
    iget-object v2, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getCalendar()Ljava/util/Calendar;

    move-result-object v2

    .line 1480
    const/4 v3, 0x7

    invoke-virtual {v2, v3}, Ljava/util/Calendar;->get(I)I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    .line 1481
    const/16 v4, 0xb

    invoke-virtual {v2, v4}, Ljava/util/Calendar;->get(I)I

    move-result v4

    mul-int/lit8 v4, v4, 0x3c

    const/16 v5, 0xc

    invoke-virtual {v2, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    add-int/2addr v4, v5

    mul-int/lit8 v4, v4, 0x3c

    const/16 v5, 0xd

    invoke-virtual {v2, v5}, Ljava/util/Calendar;->get(I)I

    move-result v2

    add-int/2addr v2, v4

    .line 1483
    iget-object v4, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    iget-object v4, v4, Lcom/localytics/android/BaseProvider;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "SELECT * FROM %s AS d, %s AS t WHERE ((d.%s=?) AND (t.%s=?)) AND (d.%s=t.%s) AND (datetime(\'%s\',\'localtime\') BETWEEN d.%s and d.%s) AND (? BETWEEN t.%s AND t.%s);"

    const/16 v6, 0xb

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string v8, "frequency_capping_blackout_dates"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-string v8, "frequency_capping_blackout_times"

    aput-object v8, v6, v7

    const/4 v7, 0x2

    const-string v8, "frequency_id"

    aput-object v8, v6, v7

    const/4 v7, 0x3

    const-string v8, "frequency_id"

    aput-object v8, v6, v7

    const/4 v7, 0x4

    const-string v8, "rule_group_id"

    aput-object v8, v6, v7

    const/4 v7, 0x5

    const-string v8, "rule_group_id"

    aput-object v8, v6, v7

    const/4 v7, 0x6

    iget-object v8, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v8}, Lcom/localytics/android/LocalyticsDao;->getTimeStringForSQLite()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x7

    const-string v8, "start"

    aput-object v8, v6, v7

    const/16 v7, 0x8

    const-string v8, "end"

    aput-object v8, v6, v7

    const/16 v7, 0x9

    const-string v8, "start"

    aput-object v8, v6, v7

    const/16 v7, 0xa

    const-string v8, "end"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x2

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 1497
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v4

    .line 1498
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1500
    iget-object v5, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    iget-object v5, v5, Lcom/localytics/android/BaseProvider;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v6, "SELECT * FROM %s AS w, %s AS t WHERE ((w.%s=?) AND (t.%s=?)) AND (w.%s=t.%s) AND (w.%s=?) AND (? BETWEEN t.%s AND t.%s);"

    const/16 v7, 0x9

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string v9, "frequency_capping_blackout_weekdays"

    aput-object v9, v7, v8

    const/4 v8, 0x1

    const-string v9, "frequency_capping_blackout_times"

    aput-object v9, v7, v8

    const/4 v8, 0x2

    const-string v9, "frequency_id"

    aput-object v9, v7, v8

    const/4 v8, 0x3

    const-string v9, "frequency_id"

    aput-object v9, v7, v8

    const/4 v8, 0x4

    const-string v9, "rule_group_id"

    aput-object v9, v7, v8

    const/4 v8, 0x5

    const-string v9, "rule_group_id"

    aput-object v9, v7, v8

    const/4 v8, 0x6

    const-string v9, "day"

    aput-object v9, v7, v8

    const/4 v8, 0x7

    const-string v9, "start"

    aput-object v9, v7, v8

    const/16 v8, 0x8

    const-string v9, "end"

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v7, v8

    const/4 v0, 0x2

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v7, v0

    const/4 v0, 0x3

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v7, v0

    invoke-virtual {v5, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 1514
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    add-int/2addr v0, v4

    .line 1516
    if-lez v0, :cond_1

    .line 1518
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p2}, Lcom/localytics/android/MarketingHandler;->_getIgnoresGlobalCampaigns(ZLjava/util/Set;)Ljava/util/Set;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result-object v0

    .line 1526
    if-eqz v1, :cond_3

    .line 1528
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto/16 :goto_1

    .line 1526
    :catchall_1
    move-exception v0

    if-eqz v1, :cond_5

    .line 1528
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v0

    .line 1438
    :catchall_2
    move-exception v0

    goto/16 :goto_2

    :cond_6
    move v0, v7

    goto/16 :goto_0

    .line 1448
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method _getIgnoresGlobalCampaigns(ZLjava/util/Set;)Ljava/util/Set;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 1285
    const-string v2, "SELECT %s FROM %s WHERE %s = %s AND %s in (%s);"

    const/4 v3, 0x6

    new-array v3, v3, [Ljava/lang/Object;

    const-string v4, "campaign_id"

    aput-object v4, v3, v1

    const-string v4, "frequency_capping_rules"

    aput-object v4, v3, v0

    const/4 v4, 0x2

    const-string v5, "ignore_global"

    aput-object v5, v3, v4

    const/4 v4, 0x3

    if-eqz p1, :cond_0

    :goto_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v4

    const/4 v0, 0x4

    const-string v1, "campaign_id"

    aput-object v1, v3, v0

    const/4 v0, 0x5

    const-string v1, ","

    invoke-static {v1, p2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v0

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingHandler;->_getCampaignIdsFromFrequencyCappingQuery(Ljava/lang/String;)Ljava/util/Set;

    move-result-object v0

    return-object v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method protected _getMaxRowToUpload()I
    .locals 1

    .prologue
    .line 1947
    const/4 v0, 0x1

    return v0
.end method

.method _getQualifiedMarketingMessageForTrigger(Ljava/lang/String;Ljava/util/Map;)Lcom/localytics/android/MarketingMessage;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/localytics/android/MarketingMessage;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 2002
    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2040
    :cond_0
    :goto_0
    return-object v0

    .line 2008
    :cond_1
    const-string v1, "open"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 2010
    iget-boolean v1, p0, Lcom/localytics/android/MarketingHandler;->sessionStartMarketingMessageShown:Z

    if-nez v1, :cond_0

    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v1

    if-nez v1, :cond_0

    .line 2012
    const-string p1, "AMP Loaded"

    .line 2013
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/localytics/android/MarketingHandler;->sessionStartMarketingMessageShown:Z

    .line 2022
    :cond_2
    invoke-direct {p0, p1}, Lcom/localytics/android/MarketingHandler;->_getMarketingMessageMaps(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 2027
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_3

    .line 2029
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v1

    .line 2030
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 2032
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 2033
    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingHandler;->_getMarketingMessageMaps(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 2037
    :cond_3
    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->_filterMarketingMessagesDisqualifiedByFrequencyCappingRules(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 2040
    invoke-direct {p0, v0, p2}, Lcom/localytics/android/MarketingHandler;->_retrieveDisplayingCandidate(Ljava/util/List;Ljava/util/Map;)Lcom/localytics/android/MarketingMessage;

    move-result-object v0

    goto :goto_0
.end method

.method protected _init()V
    .locals 3

    .prologue
    .line 1966
    new-instance v0, Lcom/localytics/android/MarketingProvider;

    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->siloName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-direct {v0, v1, v2}, Lcom/localytics/android/MarketingProvider;-><init>(Ljava/lang/String;Lcom/localytics/android/LocalyticsDao;)V

    iput-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    .line 1967
    return-void
.end method

.method _marketingTrigger(Ljava/lang/String;Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1981
    invoke-virtual {p0, p1, p2}, Lcom/localytics/android/MarketingHandler;->_getQualifiedMarketingMessageForTrigger(Ljava/lang/String;Ljava/util/Map;)Lcom/localytics/android/MarketingMessage;

    move-result-object v2

    .line 1983
    if-eqz v2, :cond_0

    .line 1985
    const-string v0, "campaign_id"

    invoke-virtual {v2, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 1986
    const-string v1, "control_group"

    invoke-virtual {v2, v1}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    .line 1987
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/4 v3, 0x1

    if-ne v1, v3, :cond_1

    .line 1989
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->_setMarketingMessageAsDisplayed(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1991
    invoke-direct {p0, v2}, Lcom/localytics/android/MarketingHandler;->_tagAmpActionEventForControlGroup(Lcom/localytics/android/MarketingMessage;)V

    .line 1997
    :cond_0
    :goto_0
    return-void

    .line 1995
    :cond_1
    invoke-virtual {p0, v2, p2}, Lcom/localytics/android/MarketingHandler;->_tryDisplayingInAppCampaign(Lcom/localytics/android/MarketingMessage;Ljava/util/Map;)V

    goto :goto_0
.end method

.method protected _onUploadCompleted(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 576
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 577
    :goto_0
    iget v1, p0, Lcom/localytics/android/MarketingHandler;->lastMarketingMessagesHash:I

    if-eq v0, v1, :cond_0

    .line 582
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Lcom/localytics/android/JsonHelper;->toMap(Lorg/json/JSONObject;)Ljava/util/Map;

    move-result-object v1

    .line 584
    invoke-virtual {p0, v1}, Lcom/localytics/android/MarketingHandler;->_processConfigObject(Ljava/util/Map;)V

    .line 585
    invoke-virtual {p0, v1}, Lcom/localytics/android/MarketingHandler;->_processMarketingObject(Ljava/util/Map;)V

    .line 587
    iput v0, p0, Lcom/localytics/android/MarketingHandler;->lastMarketingMessagesHash:I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 595
    :cond_0
    :goto_1
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->testCampaignsListAdapter:Lcom/localytics/android/MarketingRulesAdapter;

    if-eqz v0, :cond_2

    .line 597
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->testCampaignsListAdapter:Lcom/localytics/android/MarketingRulesAdapter;

    .line 598
    new-instance v1, Lcom/localytics/android/MarketingHandler$6;

    invoke-direct {v1, p0, v0}, Lcom/localytics/android/MarketingHandler$6;-><init>(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/MarketingRulesAdapter;)V

    invoke-virtual {v1}, Lcom/localytics/android/MarketingHandler$6;->start()V

    .line 613
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/localytics/android/MarketingHandler;->testCampaignsListAdapter:Lcom/localytics/android/MarketingRulesAdapter;

    .line 619
    :goto_2
    return-void

    .line 576
    :cond_1
    iget v0, p0, Lcom/localytics/android/MarketingHandler;->lastMarketingMessagesHash:I

    goto :goto_0

    .line 589
    :catch_0
    move-exception v0

    .line 591
    const-string v1, "JSONException"

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 617
    :cond_2
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    const-string v1, "open"

    invoke-interface {v0, v1}, Lcom/localytics/android/LocalyticsDao;->triggerInAppMessage(Ljava/lang/String;)V

    goto :goto_2
.end method

.method _processConfigObject(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 623
    const-string v0, "config"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    iput-object v0, p0, Lcom/localytics/android/MarketingHandler;->mConfigurations:Ljava/util/Map;

    .line 624
    return-void
.end method

.method _processMarketingObject(Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 628
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 630
    const-string v0, "amp"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 631
    if-eqz v0, :cond_0

    .line 634
    invoke-static {v0}, Lcom/localytics/android/JsonHelper;->toJSON(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONArray;

    invoke-static {v0}, Lcom/localytics/android/JsonHelper;->toList(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v0

    .line 635
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 637
    new-instance v3, Lcom/localytics/android/MarketingMessage;

    invoke-direct {v3, v0}, Lcom/localytics/android/MarketingMessage;-><init>(Ljava/util/Map;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 642
    :cond_0
    invoke-virtual {p0, v1}, Lcom/localytics/android/MarketingHandler;->_removeDeactivatedMarketingMessages(Ljava/util/List;)V

    .line 644
    const/4 v0, -0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/localytics/android/MarketingHandler;->_validateAndStoreFrequencyCappingRule(Ljava/util/Map;Ljava/lang/Integer;)Z

    .line 647
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingMessage;

    .line 649
    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->_saveMarketingMessage(Lcom/localytics/android/MarketingMessage;)I

    .line 650
    sget-object v1, Lcom/localytics/android/Constants;->CAMPAIGN_ID_KEY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {p0, v0, v1}, Lcom/localytics/android/MarketingHandler;->_validateAndStoreFrequencyCappingRule(Ljava/util/Map;Ljava/lang/Integer;)Z

    goto :goto_1

    .line 652
    :cond_1
    return-void
.end method

.method _removeDeactivatedMarketingMessages(Ljava/util/List;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/localytics/android/MarketingMessage;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 663
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 666
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingMessage;

    .line 668
    const-string v2, "campaign_id"

    invoke-static {v0, v2}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 671
    :cond_0
    const/4 v0, -0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->_deleteFrequencyCappingRule(Ljava/lang/Integer;)Z

    .line 674
    new-instance v8, Ljava/util/Vector;

    invoke-direct {v8}, Ljava/util/Vector;-><init>()V

    .line 678
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "marketing_rules"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 680
    const/4 v0, 0x0

    :goto_1
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-ge v0, v2, :cond_2

    .line 682
    invoke-interface {v1, v0}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 686
    const-string v2, "campaign_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    .line 687
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v7, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 689
    new-instance v2, Lcom/localytics/android/MarketingMessage;

    invoke-direct {v2}, Lcom/localytics/android/MarketingMessage;-><init>()V

    .line 694
    const-string v3, "_id"

    const-string v4, "_id"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 695
    const-string v3, "campaign_id"

    const-string v4, "campaign_id"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 696
    const-string v3, "expiration"

    const-string v4, "expiration"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 697
    const-string v3, "display_seconds"

    const-string v4, "display_seconds"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 698
    const-string v3, "display_session"

    const-string v4, "display_session"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 699
    const-string v3, "version"

    const-string v4, "version"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 700
    const-string v3, "phone_location"

    const-string v4, "phone_location"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 701
    const-string v3, "phone_size_width"

    const-string v4, "phone_size_width"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 702
    const-string v3, "phone_size_height"

    const-string v4, "phone_size_height"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 703
    const-string v3, "tablet_location"

    const-string v4, "tablet_location"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 704
    const-string v3, "tablet_size_width"

    const-string v4, "tablet_size_width"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 705
    const-string v3, "tablet_size_height"

    const-string v4, "tablet_size_height"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 706
    const-string v3, "time_to_display"

    const-string v4, "time_to_display"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 707
    const-string v3, "internet_required"

    const-string v4, "internet_required"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 708
    const-string v3, "ab_test"

    const-string v4, "ab_test"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 709
    const-string v3, "rule_name_non_unique"

    const-string v4, "rule_name_non_unique"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 710
    const-string v3, "location"

    const-string v4, "location"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 711
    const-string v3, "devices"

    const-string v4, "devices"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/localytics/android/MarketingMessage;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 713
    invoke-virtual {v8, v2}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 680
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    .line 718
    :cond_2
    if-eqz v1, :cond_3

    .line 720
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 726
    :cond_3
    invoke-virtual {v8}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingMessage;

    .line 728
    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingHandler;->_destroyLocalMarketingMessage(Lcom/localytics/android/MarketingMessage;)V

    .line 729
    const-string v2, "campaign_id"

    invoke-virtual {v0, v2}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->_deleteFrequencyCappingRule(Ljava/lang/Integer;)Z

    goto :goto_2

    .line 718
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_3
    if-eqz v1, :cond_4

    .line 720
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 721
    :cond_4
    throw v0

    .line 732
    :cond_5
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    invoke-virtual {v0}, Lcom/localytics/android/BaseProvider;->vacuumIfNecessary()V

    .line 733
    return-void

    .line 718
    :catchall_1
    move-exception v0

    goto :goto_3
.end method

.method _saveFrequencyCappingRule(Ljava/util/Map;Ljava/lang/Integer;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/Integer;",
            ")Z"
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 1023
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    iget-object v0, v0, Lcom/localytics/android/BaseProvider;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 1025
    invoke-virtual {p0, p1, p2}, Lcom/localytics/android/MarketingHandler;->_saveFrequencyCappingRuleBase(Ljava/util/Map;Ljava/lang/Integer;)J

    move-result-wide v0

    long-to-int v4, v0

    .line 1027
    sget-object v0, Lcom/localytics/android/Constants;->DISPLAY_FREQUENCIES_KEY:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 1028
    if-lez v4, :cond_1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/localytics/android/MarketingHandler;->_saveFrequencyCappingRuleDisplayFrequency(Ljava/util/List;Ljava/lang/Integer;)Z

    move-result v0

    if-eqz v0, :cond_1

    move v1, v2

    .line 1030
    :goto_0
    sget-object v0, Lcom/localytics/android/Constants;->BLACKOUT_RULES_KEY:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 1031
    if-eqz v1, :cond_2

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/localytics/android/MarketingHandler;->_saveFrequencyCappingRuleBlackout(Ljava/util/List;Ljava/lang/Integer;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1033
    :goto_1
    if-eqz v2, :cond_0

    .line 1035
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    iget-object v0, v0, Lcom/localytics/android/BaseProvider;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 1037
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    iget-object v0, v0, Lcom/localytics/android/BaseProvider;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1039
    return v2

    :cond_1
    move v1, v3

    .line 1028
    goto :goto_0

    :cond_2
    move v2, v3

    .line 1031
    goto :goto_1
.end method

.method _saveFrequencyCappingRuleBase(Ljava/util/Map;Ljava/lang/Integer;)J
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;",
            "Ljava/lang/Integer;",
            ")J"
        }
    .end annotation

    .prologue
    .line 1057
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 1058
    const-string v0, "campaign_id"

    invoke-virtual {v1, v0, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1059
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    .line 1061
    const-string v2, "max_display_count"

    sget-object v0, Lcom/localytics/android/Constants;->MAX_DISPLAY_COUNT_KEY:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1062
    const-string v2, "ignore_global"

    sget-object v0, Lcom/localytics/android/Constants;->IGNORE_GLOBAL_KEY:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1070
    :goto_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    iget-object v0, v0, Lcom/localytics/android/BaseProvider;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "frequency_capping_rules"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3, v1}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    return-wide v0

    .line 1066
    :cond_0
    const-string v0, "max_display_count"

    invoke-virtual {v1, v0}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    .line 1067
    const-string v0, "ignore_global"

    invoke-virtual {v1, v0}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    goto :goto_0
.end method

.method _saveFrequencyCappingRuleBlackout(Ljava/util/List;Ljava/lang/Integer;)Z
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;",
            "Ljava/lang/Integer;",
            ")Z"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 1095
    if-eqz p1, :cond_2

    .line 1098
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v1, v2

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 1100
    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->_augmentBlackoutRule(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v4

    .line 1101
    sget-object v0, Lcom/localytics/android/Constants;->DATES_KEY:Ljava/lang/String;

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 1102
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {p0, v0, p2, v5}, Lcom/localytics/android/MarketingHandler;->_saveFrequencyCappingRuleBlackoutDates(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1123
    :cond_0
    :goto_1
    return v2

    .line 1107
    :cond_1
    sget-object v0, Lcom/localytics/android/Constants;->WEEKDAYS_KEY:Ljava/lang/String;

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 1108
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {p0, v0, p2, v5}, Lcom/localytics/android/MarketingHandler;->_saveFrequencyCappingRuleBlackoutWeekdays(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1113
    sget-object v0, Lcom/localytics/android/Constants;->TIMES_KEY:Ljava/lang/String;

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 1114
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {p0, v0, p2, v4}, Lcom/localytics/android/MarketingHandler;->_saveFrequencyCappingRuleBlackoutTimes(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1119
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    .line 1120
    goto :goto_0

    .line 1123
    :cond_2
    const/4 v2, 0x1

    goto :goto_1
.end method

.method _saveFrequencyCappingRuleBlackoutDates(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Z
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ")Z"
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 1148
    if-eqz p1, :cond_0

    .line 1150
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 1154
    :try_start_0
    iget-object v4, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    iget-object v4, v4, Lcom/localytics/android/BaseProvider;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "INSERT INTO %s VALUES (?, ?, datetime(?,\'start of day\'), datetime(?,\'start of day\',\'1 day\',\'-1 second\'));"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string v8, "frequency_capping_blackout_dates"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p2, v6, v7

    const/4 v7, 0x1

    aput-object p3, v6, v7

    const/4 v7, 0x2

    sget-object v8, Lcom/localytics/android/Constants;->START_KEY:Ljava/lang/String;

    invoke-interface {v0, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x3

    sget-object v8, Lcom/localytics/android/Constants;->END_KEY:Ljava/lang/String;

    invoke-interface {v0, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    aput-object v0, v6, v7

    invoke-virtual {v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1164
    :catch_0
    move-exception v0

    move v0, v1

    .line 1166
    :goto_1
    return v0

    :cond_0
    move v0, v2

    goto :goto_1
.end method

.method _saveFrequencyCappingRuleBlackoutTimes(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Z
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ")Z"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v6, -0x1

    .line 1194
    if-eqz p1, :cond_3

    .line 1196
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 1198
    sget-object v1, Lcom/localytics/android/Constants;->START_KEY:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-direct {p0, v1}, Lcom/localytics/android/MarketingHandler;->_timeStringToSeconds(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 1199
    sget-object v4, Lcom/localytics/android/Constants;->END_KEY:Ljava/lang/String;

    invoke-interface {v0, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingHandler;->_timeStringToSeconds(Ljava/lang/String;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 1201
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-eq v4, v6, :cond_1

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-ne v4, v6, :cond_2

    :cond_1
    move v0, v2

    .line 1218
    :goto_0
    return v0

    .line 1206
    :cond_2
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 1207
    const-string v5, "frequency_id"

    invoke-virtual {v4, v5, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1208
    const-string v5, "rule_group_id"

    invoke-virtual {v4, v5, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1209
    const-string v5, "start"

    invoke-virtual {v4, v5, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1210
    const-string v1, "end"

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    add-int/lit8 v0, v0, 0x3b

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v4, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1211
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "frequency_capping_blackout_times"

    invoke-virtual {v0, v1, v4}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    const-wide/16 v4, 0x0

    cmp-long v0, v0, v4

    if-gtz v0, :cond_0

    move v0, v2

    .line 1213
    goto :goto_0

    .line 1218
    :cond_3
    const/4 v0, 0x1

    goto :goto_0
.end method

.method _saveFrequencyCappingRuleBlackoutWeekdays(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Z
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 1174
    if-eqz p1, :cond_1

    .line 1176
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 1178
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 1179
    const-string v3, "frequency_id"

    invoke-virtual {v2, v3, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1180
    const-string v3, "rule_group_id"

    invoke-virtual {v2, v3, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1181
    const-string v3, "day"

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1182
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "frequency_capping_blackout_weekdays"

    invoke-virtual {v0, v3, v2}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v0, v2, v4

    if-gtz v0, :cond_0

    .line 1184
    const/4 v0, 0x0

    .line 1189
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method _saveFrequencyCappingRuleDisplayFrequency(Ljava/util/List;Ljava/lang/Integer;)Z
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;>;",
            "Ljava/lang/Integer;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 1075
    if-eqz p1, :cond_1

    .line 1077
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 1079
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 1080
    const-string v1, "frequency_id"

    invoke-virtual {v3, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1081
    const-string v4, "count"

    sget-object v1, Lcom/localytics/android/Constants;->COUNT_KEY:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v3, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1082
    const-string v1, "days"

    sget-object v4, Lcom/localytics/android/Constants;->DAYS_KEY:Ljava/lang/String;

    invoke-interface {v0, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v3, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1083
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "frequency_capping_display_frequencies"

    invoke-virtual {v0, v1, v3}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    const-wide/16 v4, 0x0

    cmp-long v0, v0, v4

    if-gtz v0, :cond_0

    .line 1085
    const/4 v0, 0x0

    .line 1090
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method _saveMarketingMessage(Lcom/localytics/android/MarketingMessage;)I
    .locals 12

    .prologue
    const/4 v11, 0x2

    const/4 v7, 0x0

    const/4 v10, 0x1

    const/4 v6, 0x0

    .line 745
    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingHandler;->_validateMarketingMessage(Lcom/localytics/android/MarketingMessage;)Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v6

    .line 833
    :goto_0
    return v0

    .line 751
    :cond_0
    const-string v0, "campaign_id"

    invoke-static {p1, v0}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v8

    .line 760
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "marketing_rules"

    sget-object v2, Lcom/localytics/android/MarketingHandler;->PROJECTION_MARKETING_RULE_RECORD:[Ljava/lang/String;

    const-string v3, "%s = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v9, "campaign_id"

    aput-object v9, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 761
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 763
    const-string v0, "_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    .line 764
    const-string v0, "version"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    .line 769
    :goto_1
    if-eqz v1, :cond_1

    .line 771
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 776
    :cond_1
    if-lez v2, :cond_6

    .line 778
    const-string v1, "Existing in-app rule already exists for this campaign\n\t campaignID = %d\n\t ruleID = %d"

    new-array v3, v11, [Ljava/lang/Object;

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v3, v10

    invoke-static {v1, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 780
    const-string v1, "version"

    invoke-static {p1, v1}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v1

    .line 781
    if-lt v0, v1, :cond_3

    .line 783
    const-string v1, "No update needed. Campaign version has not been updated\n\t version: %d"

    new-array v2, v10, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v2, v6

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    move v0, v6

    .line 784
    goto :goto_0

    .line 769
    :catchall_0
    move-exception v0

    move-object v1, v7

    :goto_2
    if-eqz v1, :cond_2

    .line 771
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0

    .line 788
    :cond_3
    invoke-direct {p0, p1}, Lcom/localytics/android/MarketingHandler;->_destroyLocalMarketingMessage(Lcom/localytics/android/MarketingMessage;)V

    .line 796
    :goto_3
    invoke-direct {p0, p1}, Lcom/localytics/android/MarketingHandler;->_parseMarketingMessage(Lcom/localytics/android/MarketingMessage;)Landroid/content/ContentValues;

    move-result-object v0

    .line 797
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "marketing_rules"

    invoke-virtual {v1, v2, v0}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    long-to-int v1, v0

    .line 799
    if-lez v1, :cond_4

    .line 802
    int-to-long v2, v1

    const-string v0, "conditions"

    invoke-static {p1, v0}, Lcom/localytics/android/JsonHelper;->getSafeListFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v2, v3, v0}, Lcom/localytics/android/MarketingHandler;->_saveMarketingConditions(JLjava/util/List;)V

    .line 808
    :try_start_2
    const-string v0, "display_events"

    invoke-virtual {p1, v0}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/JsonHelper;->toJSON(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONArray;

    invoke-static {v0}, Lcom/localytics/android/JsonHelper;->toList(Lorg/json/JSONArray;)Ljava/util/List;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    move-result-object v7

    .line 813
    :goto_4
    if-eqz v7, :cond_4

    .line 815
    int-to-long v2, v1

    invoke-direct {p0, v2, v3, v7}, Lcom/localytics/android/MarketingHandler;->_bindRuleToEvents(JLjava/util/List;)V

    .line 819
    :cond_4
    if-lez v1, :cond_5

    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v0

    if-nez v0, :cond_5

    .line 822
    invoke-static {p1}, Lcom/localytics/android/MarketingDownloader;->getRemoteFileURL(Lcom/localytics/android/MarketingMessage;)Ljava/lang/String;

    move-result-object v2

    .line 823
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_7

    int-to-long v4, v1

    const-string v0, ".zip"

    invoke-virtual {v2, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    iget-object v3, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v3

    iget-object v7, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v7}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v7

    invoke-static {v4, v5, v0, v3, v7}, Lcom/localytics/android/MarketingDownloader;->getLocalFileURL(JZLandroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 826
    :goto_5
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_5

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 828
    const-string v3, "Saving in-app message with remoteURL = %s and localUrl = %s"

    new-array v4, v11, [Ljava/lang/Object;

    aput-object v2, v4, v6

    aput-object v0, v4, v10

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 829
    iget-object v3, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3}, Lcom/localytics/android/LocalyticsDao;->getProxy()Ljava/net/Proxy;

    move-result-object v3

    invoke-static {v2, v0, v10, v3}, Lcom/localytics/android/MarketingDownloader;->downloadFile(Ljava/lang/String;Ljava/lang/String;ZLjava/net/Proxy;)Ljava/lang/String;

    :cond_5
    move v0, v1

    .line 833
    goto/16 :goto_0

    .line 793
    :cond_6
    const-string v0, "In-app campaign not found. Creating a new one."

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    goto/16 :goto_3

    .line 823
    :cond_7
    const-string v0, ""

    goto :goto_5

    :catch_0
    move-exception v0

    goto :goto_4

    .line 769
    :catchall_1
    move-exception v0

    goto/16 :goto_2

    :cond_8
    move v0, v6

    move v2, v6

    goto/16 :goto_1
.end method

.method _setMarketingMessageAsDisplayed(I)Z
    .locals 10

    .prologue
    const/4 v8, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 504
    .line 507
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "frequency_capping_rules"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "ignore_global"

    aput-object v4, v2, v3

    const-string v3, "%s = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v9, "campaign_id"

    aput-object v9, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 508
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 510
    const-string v0, "ignore_global"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 512
    iget-object v2, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    iget-object v2, v2, Lcom/localytics/android/BaseProvider;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "INSERT INTO %s VALUES (?, datetime(\'%s\'), ?);"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v7, "campaigns_displayed"

    aput-object v7, v4, v5

    const/4 v5, 0x1

    iget-object v7, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v7}, Lcom/localytics/android/LocalyticsDao;->getTimeStringForSQLite()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Integer;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v4, v5

    const/4 v5, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 519
    if-eqz v1, :cond_0

    .line 526
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_0
    move v0, v6

    .line 530
    :goto_0
    return v0

    .line 524
    :cond_1
    if-eqz v1, :cond_2

    .line 526
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    move v0, v7

    .line 530
    goto :goto_0

    .line 524
    :catchall_0
    move-exception v0

    move-object v1, v8

    :goto_1
    if-eqz v1, :cond_3

    .line 526
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v0

    .line 524
    :catchall_1
    move-exception v0

    goto :goto_1
.end method

.method _setMarketingMessageAsNotDisplayed(I)Z
    .locals 13

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 540
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    .line 541
    const/4 v8, 0x0

    .line 544
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "campaigns_displayed"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "date"

    aput-object v4, v2, v3

    const-string v3, "%s = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v10, "campaign_id"

    aput-object v10, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object v9, v4, v5

    const-string v5, "%s DESC"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string v12, "date"

    aput-object v12, v10, v11

    invoke-static {v5, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 549
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 551
    const-string v0, "date"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 552
    iget-object v2, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "campaigns_displayed"

    const-string v4, "%s = ? AND %s = ?"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string v10, "campaign_id"

    aput-object v10, v5, v8

    const/4 v8, 0x1

    const-string v10, "date"

    aput-object v10, v5, v8

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v8, 0x0

    aput-object v9, v5, v8

    const/4 v8, 0x1

    aput-object v0, v5, v8

    invoke-virtual {v2, v3, v4, v5}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    if-lez v0, :cond_1

    move v0, v6

    .line 559
    :goto_0
    if-eqz v1, :cond_0

    .line 561
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 565
    :cond_0
    :goto_1
    return v0

    :cond_1
    move v0, v7

    .line 552
    goto :goto_0

    .line 559
    :cond_2
    if-eqz v1, :cond_3

    .line 561
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_3
    move v0, v7

    .line 565
    goto :goto_1

    .line 559
    :catchall_0
    move-exception v0

    move-object v1, v8

    :goto_2
    if-eqz v1, :cond_4

    .line 561
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0

    .line 559
    :catchall_1
    move-exception v0

    goto :goto_2
.end method

.method _tryDisplayingInAppCampaign(Lcom/localytics/android/MarketingMessage;Ljava/util/Map;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/localytics/android/MarketingMessage;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2046
    invoke-direct {p0, p2}, Lcom/localytics/android/MarketingHandler;->_getJavaScriptClientCallbacks(Ljava/util/Map;)Landroid/util/SparseArray;

    move-result-object v0

    .line 2047
    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v2, Lcom/localytics/android/MarketingHandler$8;

    invoke-direct {v2, p0, p1, v0}, Lcom/localytics/android/MarketingHandler$8;-><init>(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/MarketingMessage;Landroid/util/SparseArray;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 2118
    return-void
.end method

.method _validateAndStoreFrequencyCappingRule(Ljava/util/Map;Ljava/lang/Integer;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/Integer;",
            ")Z"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v3, -0x1

    .line 1008
    .line 1009
    sget-object v0, Lcom/localytics/android/Constants;->FREQUENCY_CAPPING_KEY:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 1010
    if-eqz v0, :cond_2

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-ne v1, v3, :cond_1

    const/4 v1, 0x1

    :goto_0
    invoke-virtual {p0, v0, v1}, Lcom/localytics/android/MarketingHandler;->_validateFrequencyCappingRule(Ljava/util/Map;Z)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1012
    invoke-virtual {p0, v0, p2}, Lcom/localytics/android/MarketingHandler;->_saveFrequencyCappingRule(Ljava/util/Map;Ljava/lang/Integer;)Z

    move-result v2

    .line 1018
    :cond_0
    :goto_1
    return v2

    :cond_1
    move v1, v2

    .line 1010
    goto :goto_0

    .line 1014
    :cond_2
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-eq v0, v3, :cond_0

    .line 1016
    new-instance v0, Ljava/util/HashMap;

    sget-object v1, Lcom/localytics/android/MarketingHandler;->DEFAULT_FREQUENCY_CAPPING_RULE:Ljava/util/Map;

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    invoke-virtual {p0, v0, p2}, Lcom/localytics/android/MarketingHandler;->_saveFrequencyCappingRule(Ljava/util/Map;Ljava/lang/Integer;)Z

    move-result v2

    goto :goto_1
.end method

.method _validateFrequencyCappingRule(Ljava/util/Map;Z)Z
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;Z)Z"
        }
    .end annotation

    .prologue
    const/4 v7, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 838
    if-eqz p2, :cond_0

    sget-object v0, Lcom/localytics/android/MarketingHandler;->GLOBAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS:[Ljava/lang/String;

    :goto_0
    array-length v4, v0

    move v1, v2

    :goto_1
    if-ge v1, v4, :cond_2

    aget-object v5, v0, v1

    .line 840
    invoke-interface {p1, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    move v0, v2

    .line 909
    :goto_2
    return v0

    .line 838
    :cond_0
    sget-object v0, Lcom/localytics/android/MarketingHandler;->INDIVIDUAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS:[Ljava/lang/String;

    goto :goto_0

    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 846
    :cond_2
    sget-object v0, Lcom/localytics/android/Constants;->DISPLAY_FREQUENCIES_KEY:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 847
    new-array v1, v7, [Ljava/lang/String;

    sget-object v4, Lcom/localytics/android/Constants;->DAYS_KEY:Ljava/lang/String;

    aput-object v4, v1, v2

    sget-object v4, Lcom/localytics/android/Constants;->COUNT_KEY:Ljava/lang/String;

    aput-object v4, v1, v3

    invoke-virtual {p0, v0, v1}, Lcom/localytics/android/MarketingHandler;->_checkFrequencyCappingRuleArray(Ljava/util/List;[Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    move v0, v2

    .line 849
    goto :goto_2

    .line 851
    :cond_3
    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->_additionalFCDisplayFrequencyRulesValidation(Ljava/util/List;)Z

    move-result v0

    if-nez v0, :cond_4

    move v0, v2

    .line 853
    goto :goto_2

    .line 856
    :cond_4
    sget-object v0, Lcom/localytics/android/Constants;->BLACKOUT_RULES_KEY:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 857
    if-eqz v0, :cond_e

    .line 859
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-gtz v1, :cond_5

    move v0, v2

    .line 861
    goto :goto_2

    .line 865
    :cond_5
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_6
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_e

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Ljava/util/Map;

    .line 867
    sget-object v0, Lcom/localytics/android/Constants;->TIMES_KEY:Ljava/lang/String;

    invoke-interface {v1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    sget-object v0, Lcom/localytics/android/Constants;->DATES_KEY:Ljava/lang/String;

    invoke-interface {v1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    sget-object v0, Lcom/localytics/android/Constants;->WEEKDAYS_KEY:Ljava/lang/String;

    invoke-interface {v1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    move v0, v2

    .line 871
    goto :goto_2

    .line 875
    :cond_7
    sget-object v0, Lcom/localytics/android/Constants;->TIMES_KEY:Ljava/lang/String;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 876
    new-array v5, v7, [Ljava/lang/String;

    sget-object v6, Lcom/localytics/android/Constants;->START_KEY:Ljava/lang/String;

    aput-object v6, v5, v2

    sget-object v6, Lcom/localytics/android/Constants;->END_KEY:Ljava/lang/String;

    aput-object v6, v5, v3

    invoke-virtual {p0, v0, v5}, Lcom/localytics/android/MarketingHandler;->_checkFrequencyCappingRuleArray(Ljava/util/List;[Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_8

    move v0, v2

    .line 878
    goto :goto_2

    .line 880
    :cond_8
    sget-object v5, Lcom/localytics/android/MarketingHandler;->TIME_SDF:Ljava/text/SimpleDateFormat;

    invoke-virtual {p0, v0, v5}, Lcom/localytics/android/MarketingHandler;->_additionalFCDatesAndTimesRulesValidation(Ljava/util/List;Ljava/text/SimpleDateFormat;)Z

    move-result v0

    if-nez v0, :cond_9

    move v0, v2

    .line 882
    goto/16 :goto_2

    .line 885
    :cond_9
    sget-object v0, Lcom/localytics/android/Constants;->DATES_KEY:Ljava/lang/String;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 886
    new-array v5, v7, [Ljava/lang/String;

    sget-object v6, Lcom/localytics/android/Constants;->START_KEY:Ljava/lang/String;

    aput-object v6, v5, v2

    sget-object v6, Lcom/localytics/android/Constants;->END_KEY:Ljava/lang/String;

    aput-object v6, v5, v3

    invoke-virtual {p0, v0, v5}, Lcom/localytics/android/MarketingHandler;->_checkFrequencyCappingRuleArray(Ljava/util/List;[Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_a

    move v0, v2

    .line 888
    goto/16 :goto_2

    .line 890
    :cond_a
    sget-object v5, Lcom/localytics/android/MarketingHandler;->DATE_SDF:Ljava/text/SimpleDateFormat;

    invoke-virtual {p0, v0, v5}, Lcom/localytics/android/MarketingHandler;->_additionalFCDatesAndTimesRulesValidation(Ljava/util/List;Ljava/text/SimpleDateFormat;)Z

    move-result v0

    if-nez v0, :cond_b

    move v0, v2

    .line 892
    goto/16 :goto_2

    .line 895
    :cond_b
    sget-object v0, Lcom/localytics/android/Constants;->WEEKDAYS_KEY:Ljava/lang/String;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 896
    if-eqz v0, :cond_d

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_c

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    const/4 v5, 0x7

    if-le v1, v5, :cond_d

    :cond_c
    move v0, v2

    .line 898
    goto/16 :goto_2

    .line 900
    :cond_d
    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->_additionalFCWeekdaysRulesValidation(Ljava/util/List;)Z

    move-result v0

    if-nez v0, :cond_6

    move v0, v2

    .line 902
    goto/16 :goto_2

    :cond_e
    move v0, v3

    .line 909
    goto/16 :goto_2
.end method

.method protected _validateMarketingMessage(Lcom/localytics/android/MarketingMessage;)Z
    .locals 10

    .prologue
    .line 1632
    const-string v0, "campaign_id"

    invoke-static {p1, v0}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v0

    .line 1633
    const-string v1, "rule_name"

    invoke-static {p1, v1}, Lcom/localytics/android/JsonHelper;->getSafeStringFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1634
    const-string v2, "display_events"

    invoke-static {p1, v2}, Lcom/localytics/android/JsonHelper;->getSafeListFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 1635
    const-string v3, "expiration"

    invoke-static {p1, v3}, Lcom/localytics/android/JsonHelper;->getSafeIntegerFromMap(Ljava/util/Map;Ljava/lang/String;)I

    move-result v3

    .line 1636
    const-string v4, "location"

    invoke-static {p1, v4}, Lcom/localytics/android/JsonHelper;->getSafeStringFromMap(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 1638
    iget-object v5, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v5}, Lcom/localytics/android/LocalyticsDao;->getCurrentTimeMillis()J

    move-result-wide v6

    const-wide/16 v8, 0x3e8

    div-long/2addr v6, v8

    .line 1641
    if-eqz v0, :cond_1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    if-eqz v2, :cond_1

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    int-to-long v0, v3

    cmp-long v0, v0, v6

    if-gtz v0, :cond_0

    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method dismissCurrentInAppMessage()V
    .locals 3

    .prologue
    .line 1550
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;

    if-nez v0, :cond_1

    .line 1567
    :cond_0
    :goto_0
    return-void

    .line 1556
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;

    const-string v1, "marketing_dialog"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/ah;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 1557
    instance-of v1, v0, Lcom/localytics/android/MarketingDialogFragment;

    if-eqz v1, :cond_0

    .line 1559
    check-cast v0, Lcom/localytics/android/MarketingDialogFragment;

    .line 1560
    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment;->dismissCampaign()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1563
    :catch_0
    move-exception v0

    .line 1565
    const-class v1, Ljava/lang/RuntimeException;

    const-string v2, "Localytics library threw an uncaught exception"

    invoke-static {v1, v2, v0}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Exception;)Ljava/lang/Object;

    goto :goto_0
.end method

.method displayMarketingMessage(Ljava/lang/String;Ljava/util/Map;Z)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    const/16 v4, 0xc9

    const/4 v3, 0x2

    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 1538
    const-string v2, "open"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1540
    new-array v2, v3, [Ljava/lang/Object;

    aput-object p1, v2, v1

    const/4 v3, 0x0

    aput-object v3, v2, v0

    invoke-virtual {p0, v4, v2}, Lcom/localytics/android/MarketingHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v2

    const-wide/16 v4, 0x2710

    if-eqz p3, :cond_0

    :goto_0
    int-to-long v0, v0

    mul-long/2addr v0, v4

    invoke-virtual {p0, v2, v0, v1}, Lcom/localytics/android/MarketingHandler;->queueMessageDelayed(Landroid/os/Message;J)Z

    .line 1546
    :goto_1
    return-void

    :cond_0
    move v0, v1

    .line 1540
    goto :goto_0

    .line 1544
    :cond_1
    new-array v2, v3, [Ljava/lang/Object;

    aput-object p1, v2, v1

    aput-object p2, v2, v0

    invoke-virtual {p0, v4, v2}, Lcom/localytics/android/MarketingHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->queueMessage(Landroid/os/Message;)Z

    goto :goto_1
.end method

.method getDialogCallbacks()Landroid/util/SparseArray;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/util/SparseArray",
            "<",
            "Lcom/localytics/android/MarketingCallable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2547
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    .line 2550
    const/4 v1, 0x1

    new-instance v2, Lcom/localytics/android/MarketingHandler$16;

    invoke-direct {v2, p0}, Lcom/localytics/android/MarketingHandler$16;-><init>(Lcom/localytics/android/MarketingHandler;)V

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 2564
    const/4 v1, 0x2

    new-instance v2, Lcom/localytics/android/MarketingHandler$17;

    invoke-direct {v2, p0}, Lcom/localytics/android/MarketingHandler$17;-><init>(Lcom/localytics/android/MarketingHandler;)V

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 2578
    const/16 v1, 0x10

    new-instance v2, Lcom/localytics/android/MarketingHandler$18;

    invoke-direct {v2, p0}, Lcom/localytics/android/MarketingHandler$18;-><init>(Lcom/localytics/android/MarketingHandler;)V

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 2589
    const/16 v1, 0x11

    new-instance v2, Lcom/localytics/android/MarketingHandler$19;

    invoke-direct {v2, p0}, Lcom/localytics/android/MarketingHandler$19;-><init>(Lcom/localytics/android/MarketingHandler;)V

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 2599
    return-object v0
.end method

.method getInAppDismissButtonLocation()Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;
    .locals 1

    .prologue
    .line 2144
    invoke-static {}, Lcom/localytics/android/MarketingDialogFragment;->getInAppDismissButtonLocation()Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;

    move-result-object v0

    return-object v0
.end method

.method getMarketingMessages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/localytics/android/MarketingMessage;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2154
    new-instance v0, Lcom/localytics/android/MarketingHandler$9;

    invoke-direct {v0, p0}, Lcom/localytics/android/MarketingHandler$9;-><init>(Lcom/localytics/android/MarketingHandler;)V

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->getList(Ljava/util/concurrent/Callable;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method protected getUploadThread(Ljava/util/TreeMap;Ljava/lang/String;)Lcom/localytics/android/BaseUploadThread;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Lcom/localytics/android/BaseUploadThread;"
        }
    .end annotation

    .prologue
    .line 1961
    new-instance v0, Lcom/localytics/android/MarketingDownloader;

    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/localytics/android/MarketingDownloader;-><init>(Lcom/localytics/android/BaseHandler;Ljava/util/TreeMap;Ljava/lang/String;Lcom/localytics/android/LocalyticsDao;)V

    return-object v0
.end method

.method protected handleMessageExtended(Landroid/os/Message;)V
    .locals 4

    .prologue
    const/4 v2, 0x1

    .line 409
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 484
    :pswitch_0
    invoke-super {p0, p1}, Lcom/localytics/android/BaseHandler;->handleMessageExtended(Landroid/os/Message;)V

    .line 488
    :goto_0
    return-void

    .line 413
    :pswitch_1
    const-string v0, "In-app handler received MESSAGE_INAPP_TRIGGER"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 415
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, [Ljava/lang/Object;

    check-cast v0, [Ljava/lang/Object;

    .line 417
    const/4 v1, 0x0

    aget-object v1, v0, v1

    check-cast v1, Ljava/lang/String;

    .line 419
    aget-object v0, v0, v2

    check-cast v0, Ljava/util/Map;

    .line 421
    iget-object v2, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v3, Lcom/localytics/android/MarketingHandler$1;

    invoke-direct {v3, p0, v1, v0}, Lcom/localytics/android/MarketingHandler$1;-><init>(Lcom/localytics/android/MarketingHandler;Ljava/lang/String;Ljava/util/Map;)V

    invoke-virtual {v2, v3}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 433
    :pswitch_2
    const-string v0, "In-app handler received MESSAGE_SHOW_INAPP_TEST"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 439
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0, v2, v0}, Lcom/localytics/android/MarketingHandler;->_upload(ZLjava/lang/String;)V

    .line 440
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v1, Lcom/localytics/android/MarketingHandler$2;

    invoke-direct {v1, p0}, Lcom/localytics/android/MarketingHandler$2;-><init>(Lcom/localytics/android/MarketingHandler;)V

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 452
    :pswitch_3
    const-string v0, "In-app handler received MESSAGE_HANDLE_PUSH_RECEIVED"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 454
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/content/Intent;

    .line 456
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v2, Lcom/localytics/android/MarketingHandler$3;

    invoke-direct {v2, p0, v0}, Lcom/localytics/android/MarketingHandler$3;-><init>(Lcom/localytics/android/MarketingHandler;Landroid/content/Intent;)V

    invoke-virtual {v1, v2}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 468
    :pswitch_4
    const-string v0, "Marketing handler received MESSAGE_SET_MARKETING_MESSAGE_AS_NOT_DISPLAYED"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 470
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 472
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v2, Lcom/localytics/android/MarketingHandler$4;

    invoke-direct {v2, p0, v0}, Lcom/localytics/android/MarketingHandler$4;-><init>(Lcom/localytics/android/MarketingHandler;I)V

    invoke-virtual {v1, v2}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 409
    nop

    :pswitch_data_0
    .packed-switch 0xc9
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method handleNotificationReceived(Landroid/content/Intent;)V
    .locals 1

    .prologue
    .line 1753
    const/16 v0, 0xcc

    invoke-virtual {p0, v0, p1}, Lcom/localytics/android/MarketingHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->queueMessage(Landroid/os/Message;)Z

    .line 1754
    return-void
.end method

.method handlePushNotificationOpened(Landroid/content/Intent;)V
    .locals 6

    .prologue
    .line 362
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-nez v0, :cond_1

    .line 404
    :cond_0
    :goto_0
    return-void

    .line 368
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ll"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 369
    if-eqz v0, :cond_0

    .line 373
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 374
    const-string v0, "ca"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 375
    const-string v0, "cr"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 376
    const-string v0, "v"

    const-string v4, "1"

    invoke-virtual {v1, v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 378
    const-string v0, "t"

    const/4 v5, 0x0

    invoke-virtual {v1, v0, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 379
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 381
    const-string v0, "Alert"

    .line 384
    :cond_2
    if-eqz v2, :cond_3

    if-eqz v3, :cond_3

    .line 386
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 387
    const-string v5, "Campaign ID"

    invoke-virtual {v1, v5, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 388
    const-string v2, "Creative ID"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 389
    const-string v2, "Creative Type"

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 390
    const-string v0, "Action"

    const-string v2, "Click"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 391
    const-string v0, "Schema Version - Client"

    const-string v2, "3"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 392
    const-string v0, "Schema Version - Server"

    invoke-virtual {v1, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 393
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    const-string v2, "Localytics Push Opened"

    invoke-interface {v0, v2, v1}, Lcom/localytics/android/LocalyticsDao;->tagEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 397
    :cond_3
    const-string v0, "ll"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->removeExtra(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 401
    :catch_0
    move-exception v0

    const-string v0, "Failed to get campaign id or creative id from payload"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    goto :goto_0
.end method

.method handleTestModeIntent(Landroid/content/Intent;)V
    .locals 7

    .prologue
    const/4 v4, 0x1

    const/4 v6, 0x0

    .line 1758
    if-nez p1, :cond_0

    .line 1760
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "intent cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1763
    :cond_0
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    .line 1765
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "amp"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 1880
    :cond_1
    :goto_0
    return-void

    .line 1770
    :cond_2
    invoke-virtual {v0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 1771
    invoke-virtual {v0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v0

    .line 1772
    const-string v2, "[/]"

    invoke-virtual {v1, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 1774
    if-eqz v1, :cond_1

    array-length v2, v1

    if-eqz v2, :cond_1

    .line 1779
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    const-string v2, "testMode"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1781
    aget-object v0, v1, v6

    const-string v2, "enabled"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1783
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0, v4}, Lcom/localytics/android/LocalyticsDao;->setTestModeEnabled(Z)V

    goto :goto_0

    .line 1785
    :cond_3
    aget-object v0, v1, v6

    const-string v2, "launch"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    aget-object v0, v1, v4

    const-string v2, "push"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1787
    const/4 v0, 0x2

    aget-object v3, v1, v0

    .line 1788
    const/4 v0, 0x3

    aget-object v4, v1, v0

    .line 1789
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getCustomerIdInMemory()Ljava/lang/String;

    move-result-object v5

    .line 1790
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v2

    .line 1792
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1794
    new-instance v0, Lcom/localytics/android/MarketingHandler$7;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/localytics/android/MarketingHandler$7;-><init>(Lcom/localytics/android/MarketingHandler;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-array v1, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingHandler$7;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public localyticsDidTagEvent(Ljava/lang/String;Ljava/util/Map;J)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;J)V"
        }
    .end annotation

    .prologue
    .line 3271
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0, p1, p2}, Lcom/localytics/android/LocalyticsDao;->triggerInAppMessage(Ljava/lang/String;Ljava/util/Map;)V

    .line 3272
    return-void
.end method

.method public localyticsSessionDidOpen(ZZZ)V
    .locals 4

    .prologue
    .line 3239
    if-nez p3, :cond_0

    .line 3241
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getCustomerIdInMemory()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->upload(Ljava/lang/String;)V

    .line 3244
    :cond_0
    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v0

    if-nez v0, :cond_3

    .line 3246
    if-eqz p1, :cond_1

    .line 3248
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    const-string v1, "AMP First Run"

    invoke-interface {v0, v1}, Lcom/localytics/android/LocalyticsDao;->triggerInAppMessage(Ljava/lang/String;)V

    .line 3250
    :cond_1
    if-eqz p2, :cond_2

    .line 3252
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    const-string v1, "AMP upgrade"

    invoke-interface {v0, v1}, Lcom/localytics/android/LocalyticsDao;->triggerInAppMessage(Ljava/lang/String;)V

    .line 3254
    :cond_2
    if-nez p3, :cond_3

    .line 3256
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/localytics/android/MarketingHandler;->sessionStartMarketingMessageShown:Z

    .line 3257
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    const-string v1, "open"

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-interface {v0, v1, v2, v3}, Lcom/localytics/android/LocalyticsDao;->triggerInAppMessage(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 3260
    :cond_3
    return-void
.end method

.method public localyticsSessionWillClose()V
    .locals 0

    .prologue
    .line 3266
    return-void
.end method

.method public localyticsSessionWillOpen(ZZZ)V
    .locals 0

    .prologue
    .line 3234
    return-void
.end method

.method setDismissButtonImage(Landroid/graphics/Bitmap;)V
    .locals 0

    .prologue
    .line 3227
    invoke-static {p1}, Lcom/localytics/android/MarketingDialogFragment;->setDismissButtonImage(Landroid/graphics/Bitmap;)V

    .line 3228
    return-void
.end method

.method setFragmentManager(Landroid/support/v4/app/ah;)V
    .locals 0

    .prologue
    .line 220
    iput-object p1, p0, Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;

    .line 221
    return-void
.end method

.method setInAppDismissButtonLocation(Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;)V
    .locals 0

    .prologue
    .line 2149
    invoke-static {p1}, Lcom/localytics/android/MarketingDialogFragment;->setInAppDismissButtonLocation(Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;)V

    .line 2150
    return-void
.end method

.method setMarketingMessageAsDisplayed(I)Z
    .locals 1

    .prologue
    .line 492
    new-instance v0, Lcom/localytics/android/MarketingHandler$5;

    invoke-direct {v0, p0, p1}, Lcom/localytics/android/MarketingHandler$5;-><init>(Lcom/localytics/android/MarketingHandler;I)V

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->getBool(Ljava/util/concurrent/Callable;)Z

    move-result v0

    return v0
.end method

.method showMarketingTest()V
    .locals 2

    .prologue
    .line 3222
    const/16 v0, 0xcb

    iget-object v1, p0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1}, Lcom/localytics/android/LocalyticsDao;->getCustomerIdInMemory()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/localytics/android/MarketingHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingHandler;->queueMessage(Landroid/os/Message;)Z

    .line 3223
    return-void
.end method
