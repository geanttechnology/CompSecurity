.class public Lcom/amazon/mShop/feature/Features;
.super Ljava/lang/Object;
.source "Features.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;
    }
.end annotation


# static fields
.field private static final DEBUG:Z

.field private static sInstance:Lcom/amazon/mShop/feature/Features;


# instance fields
.field private final mFeatureMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/rio/j2me/client/services/mShop/Feature;",
            ">;"
        }
    .end annotation
.end field

.field private mFeatureNames:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mFeatureStateSubscribers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/feature/FeatureStateSubscriber;",
            ">;"
        }
    .end annotation
.end field

.field private mLastUpdateTime:J

.field private final mResponseListener:Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponseListener;

.field private mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field private mTimer:Ljava/util/Timer;

.field private final mUserListener:Lcom/amazon/mShop/model/auth/UserListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 41
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/feature/Features;->DEBUG:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    .line 178
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/amazon/mShop/feature/Features;->mLastUpdateTime:J

    .line 74
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureMap:Ljava/util/Map;

    .line 79
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    .line 81
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureStateSubscribers:Ljava/util/List;

    .line 449
    new-instance v0, Lcom/amazon/mShop/feature/Features$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/feature/Features$1;-><init>(Lcom/amazon/mShop/feature/Features;)V

    iput-object v0, p0, Lcom/amazon/mShop/feature/Features;->mResponseListener:Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponseListener;

    .line 677
    new-instance v0, Lcom/amazon/mShop/feature/Features$3;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/feature/Features$3;-><init>(Lcom/amazon/mShop/feature/Features;)V

    iput-object v0, p0, Lcom/amazon/mShop/feature/Features;->mUserListener:Lcom/amazon/mShop/model/auth/UserListener;

    .line 182
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_ShopAppOneClickSetting"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 183
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_ShopAppSigninPrompt"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 185
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_ShopAppAIV"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 187
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "SX_mShop_Android_Fast_Browse"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 189
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_SocialConnectOOBE"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 191
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_ShopAppFlow"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 192
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_CN_Amazon_Ten_Years_Logo"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 194
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_ShopAppHTMLGateway"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 196
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_ShopAppSpinnerHardwareAcc"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 197
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_HTMLNotificationsPage"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 199
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_DexLoading"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 200
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_Enable_Sns_CA"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 202
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_UnknownSourcesGuide"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 204
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_ShopAppHTMLRecommendations"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 206
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_ShopAppHtmlGatewayHA"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 208
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_UpgradeThruAppstore"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 210
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_DataMatrix"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 213
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "SX_mShop_Android_Assets_Loading_Scheme"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 215
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "SX_mShop_Android_Dynamic_Display_Settings"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 218
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "SX_Shop_Android_Gallery_Messaging"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 220
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_AmazonSmile"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 222
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_Deals"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 225
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "SX_Shop_Android_Web_Client_GTE_5.1"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 228
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "SX_mShop_Android_Voice_Search_Nav"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 229
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "SX_mShop_Android_Voice_Search_Result_Nav"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 230
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "SX_mShop_Android_Voice_Search_Access"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 231
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "SX_mShop_Android_Voice_Search_Scan_Flow"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 232
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "SX_mShop_Android_Voice_Search_Barcode"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 233
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "SX_mShop_Android_Voice_Search_Shop_By_Department"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 236
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "Android_Wear_OneClick_Buy"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 237
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "WearableDevicesDisabled"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 240
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    const-string/jumbo v1, "AIVGROVERINTEGRATION_42456"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 243
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mUserListener:Lcom/amazon/mShop/model/auth/UserListener;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 244
    return-void
.end method

.method private static final StringToFeature(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    .locals 6
    .param p0, "featureStr"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    const/4 v5, 0x3

    .line 613
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 614
    const-string/jumbo v3, ";"

    invoke-virtual {p0, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 617
    .local v1, "vals":[Ljava/lang/String;
    array-length v3, v1

    if-lt v3, v5, :cond_1

    .line 618
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;-><init>()V

    .line 619
    .local v0, "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    const/4 v3, 0x0

    aget-object v3, v1, v3

    invoke-virtual {v0, v3}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->setFeatureName(Ljava/lang/String;)V

    .line 620
    const/4 v3, 0x1

    aget-object v3, v1, v3

    invoke-virtual {v0, v3}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->setClientTreatmentPath(Ljava/lang/String;)V

    .line 621
    const/4 v3, 0x2

    aget-object v3, v1, v3

    invoke-static {v3}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->setSendTrigger(Ljava/lang/Boolean;)V

    .line 623
    array-length v3, v1

    const/4 v4, 0x4

    if-ne v3, v4, :cond_0

    aget-object v2, v1, v5

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    :cond_0
    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->setCacheStamp(Ljava/lang/Integer;)V

    .line 627
    .end local v0    # "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    .end local v1    # "vals":[Ljava/lang/String;
    :goto_0
    return-object v0

    :cond_1
    move-object v0, v2

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/amazon/mShop/feature/Features;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/feature/Features;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/feature/Features;Ljava/util/List;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/feature/Features;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Lcom/amazon/mShop/feature/Features;->notifyFeatureStateReceived(Ljava/util/List;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/feature/Features;Ljava/lang/Exception;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/feature/Features;
    .param p1, "x1"    # Ljava/lang/Exception;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Lcom/amazon/mShop/feature/Features;->notifyError(Ljava/lang/Exception;)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/feature/Features;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/feature/Features;

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/amazon/mShop/feature/Features;->notifyCancel()V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/feature/Features;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/feature/Features;

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/amazon/mShop/feature/Features;->sendFeatureStateRequest()V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/feature/Features;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/feature/Features;

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/amazon/mShop/feature/Features;->clearTimer()V

    return-void
.end method

.method private buildFeature(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    .locals 4
    .param p1, "featureName"    # Ljava/lang/String;

    .prologue
    .line 577
    iget-object v2, p0, Lcom/amazon/mShop/feature/Features;->mFeatureMap:Ljava/util/Map;

    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    .line 578
    .local v0, "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    if-nez v0, :cond_0

    .line 580
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    invoke-interface {v2, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 581
    .local v1, "string":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/feature/Features;->StringToFeature(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    move-result-object v0

    .line 582
    if-eqz v0, :cond_0

    .line 583
    iget-object v2, p0, Lcom/amazon/mShop/feature/Features;->mFeatureMap:Ljava/util/Map;

    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 586
    .end local v1    # "string":Ljava/lang/String;
    :cond_0
    return-object v0
.end method

.method private clearTimer()V
    .locals 1

    .prologue
    .line 665
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mTimer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 666
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 667
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 668
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/feature/Features;->mTimer:Ljava/util/Timer;

    .line 670
    :cond_0
    return-void
.end method

.method public static final featureToString(Lcom/amazon/rio/j2me/client/services/mShop/Feature;)Ljava/lang/String;
    .locals 2
    .param p0, "feature"    # Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    .prologue
    .line 598
    if-eqz p0, :cond_1

    .line 600
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getFeatureName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ";"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getClientTreatmentPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ";"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getSendTrigger()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ";"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getCacheStamp()Ljava/lang/Integer;

    move-result-object v0

    if-nez v0, :cond_0

    const-string/jumbo v0, ""

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 603
    :goto_1
    return-object v0

    .line 600
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getCacheStamp()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 603
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/feature/Features;
    .locals 2

    .prologue
    .line 102
    const-class v1, Lcom/amazon/mShop/feature/Features;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/feature/Features;->sInstance:Lcom/amazon/mShop/feature/Features;

    if-nez v0, :cond_0

    .line 103
    new-instance v0, Lcom/amazon/mShop/feature/Features;

    invoke-direct {v0}, Lcom/amazon/mShop/feature/Features;-><init>()V

    sput-object v0, Lcom/amazon/mShop/feature/Features;->sInstance:Lcom/amazon/mShop/feature/Features;

    .line 105
    :cond_0
    sget-object v0, Lcom/amazon/mShop/feature/Features;->sInstance:Lcom/amazon/mShop/feature/Features;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 102
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private notifyCancel()V
    .locals 4

    .prologue
    .line 542
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/amazon/mShop/feature/Features;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 543
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/feature/Features;->mFeatureStateSubscribers:Ljava/util/List;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 544
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/feature/FeatureStateSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/feature/FeatureStateSubscriber;

    .line 545
    .local v1, "subscriber":Lcom/amazon/mShop/feature/FeatureStateSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/feature/FeatureStateSubscriber;->onCancel()V

    goto :goto_0

    .line 547
    .end local v1    # "subscriber":Lcom/amazon/mShop/feature/FeatureStateSubscriber;
    :cond_0
    return-void
.end method

.method private notifyError(Ljava/lang/Exception;)V
    .locals 8
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 531
    const/4 v5, 0x0

    iput-object v5, p0, Lcom/amazon/mShop/feature/Features;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 532
    new-instance v4, Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/amazon/mShop/feature/Features;->mFeatureStateSubscribers:Ljava/util/List;

    invoke-direct {v4, v5}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 533
    .local v4, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/feature/FeatureStateSubscriber;>;"
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/feature/FeatureStateSubscriber;

    .line 534
    .local v3, "subscriber":Lcom/amazon/mShop/feature/FeatureStateSubscriber;
    invoke-interface {v3, p1}, Lcom/amazon/mShop/feature/FeatureStateSubscriber;->onError(Ljava/lang/Exception;)V

    goto :goto_0

    .line 536
    .end local v3    # "subscriber":Lcom/amazon/mShop/feature/FeatureStateSubscriber;
    :cond_0
    new-instance v2, Lcom/amazon/mShop/net/ServiceCallIdentifier;

    const-string/jumbo v5, "mshop_android_features"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "Error_"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v2, v5, v6}, Lcom/amazon/mShop/net/ServiceCallIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 537
    .local v2, "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    invoke-static {v2}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v0

    .line 538
    .local v0, "callObserver":Lcom/amazon/mShop/net/CallObserver;
    invoke-virtual {v0}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V

    .line 539
    return-void
.end method

.method private notifyFeatureStateReceived(Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Feature;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 507
    .local p1, "features":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Feature;>;"
    sget-boolean v6, Lcom/amazon/mShop/feature/Features;->DEBUG:Z

    if-eqz v6, :cond_0

    .line 508
    const-string/jumbo v6, "Feature"

    const-string/jumbo v7, "FeatureState Service Call completed"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 510
    :cond_0
    const/4 v6, 0x0

    iput-object v6, p0, Lcom/amazon/mShop/feature/Features;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 512
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v6

    iput-wide v6, p0, Lcom/amazon/mShop/feature/Features;->mLastUpdateTime:J

    .line 513
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 515
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    .line 516
    .local v1, "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getFeatureName()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v6, v1}, Lcom/amazon/mShop/feature/Features;->saveFeature(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/Feature;)V

    goto :goto_0

    .line 520
    .end local v1    # "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_1
    new-instance v5, Ljava/util/ArrayList;

    iget-object v6, p0, Lcom/amazon/mShop/feature/Features;->mFeatureStateSubscribers:Ljava/util/List;

    invoke-direct {v5, v6}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 521
    .local v5, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/feature/FeatureStateSubscriber;>;"
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .restart local v2    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/mShop/feature/FeatureStateSubscriber;

    .line 522
    .local v4, "subscriber":Lcom/amazon/mShop/feature/FeatureStateSubscriber;
    invoke-interface {v4, p1}, Lcom/amazon/mShop/feature/FeatureStateSubscriber;->onFeatureStateReceived(Ljava/util/List;)V

    goto :goto_1

    .line 525
    .end local v4    # "subscriber":Lcom/amazon/mShop/feature/FeatureStateSubscriber;
    :cond_2
    new-instance v3, Lcom/amazon/mShop/net/ServiceCallIdentifier;

    const-string/jumbo v6, "mshop_android_features"

    const-string/jumbo v7, "success"

    invoke-direct {v3, v6, v7}, Lcom/amazon/mShop/net/ServiceCallIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 526
    .local v3, "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    invoke-static {v3}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v0

    .line 527
    .local v0, "callObserver":Lcom/amazon/mShop/net/CallObserver;
    invoke-virtual {v0}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V

    .line 528
    return-void
.end method

.method private saveFeature(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/Feature;)V
    .locals 4
    .param p1, "featureName"    # Ljava/lang/String;
    .param p2, "feature"    # Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    .prologue
    .line 556
    if-nez p2, :cond_1

    .line 568
    :cond_0
    :goto_0
    return-void

    .line 560
    :cond_1
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 561
    .local v0, "localizedFeatureName":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/feature/Features;->mFeatureMap:Ljava/util/Map;

    invoke-interface {v1, v0, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 564
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    invoke-static {p2}, Lcom/amazon/mShop/feature/Features;->featureToString(Lcom/amazon/rio/j2me/client/services/mShop/Feature;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 566
    sget-boolean v1, Lcom/amazon/mShop/feature/Features;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 567
    const-string/jumbo v1, "Feature"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "put: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Lcom/amazon/mShop/feature/Features;->featureToString(Lcom/amazon/rio/j2me/client/services/mShop/Feature;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private scheduleFeatureStateCall(J)V
    .locals 2
    .param p1, "delay"    # J

    .prologue
    .line 643
    invoke-direct {p0}, Lcom/amazon/mShop/feature/Features;->clearTimer()V

    .line 645
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/feature/Features;->mTimer:Ljava/util/Timer;

    .line 646
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mTimer:Ljava/util/Timer;

    new-instance v1, Lcom/amazon/mShop/feature/Features$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/feature/Features$2;-><init>(Lcom/amazon/mShop/feature/Features;)V

    invoke-virtual {v0, v1, p1, p2}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 659
    return-void
.end method

.method private scheduleSecondFeatureStateCall(J)V
    .locals 0
    .param p1, "delay"    # J

    .prologue
    .line 638
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/feature/Features;->scheduleFeatureStateCall(J)V

    .line 639
    return-void
.end method

.method private sendFeatureStateRequest()V
    .locals 6

    .prologue
    .line 431
    iget-object v3, p0, Lcom/amazon/mShop/feature/Features;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v3, :cond_0

    .line 433
    iget-object v3, p0, Lcom/amazon/mShop/feature/Features;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v3}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    .line 436
    :cond_0
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateRequest;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateRequest;-><init>()V

    .line 437
    .local v2, "request":Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateRequest;
    new-instance v3, Ljava/util/Vector;

    iget-object v4, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    invoke-direct {v3, v4}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v2, v3}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateRequest;->setCheckFeatures(Ljava/util/List;)V

    .line 439
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/feature/Features;->mResponseListener:Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponseListener;

    invoke-interface {v3, v2, v4}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->featureState(Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateRequest;Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/feature/Features;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 441
    sget-boolean v3, Lcom/amazon/mShop/feature/Features;->DEBUG:Z

    if-eqz v3, :cond_1

    .line 442
    const-string/jumbo v3, "Feature"

    const-string/jumbo v4, "send service call: featureState"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 443
    iget-object v3, p0, Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 444
    .local v1, "name":Ljava/lang/String;
    const-string/jumbo v3, "Feature"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "FeatureStateRequest: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 447
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "name":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private shouldDelayFeatureStateCall()Z
    .locals 1

    .prologue
    .line 352
    invoke-static {}, Lcom/amazon/mShop/net/CookieBridge;->getCurrentSessionId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private shouldSendFeatureStateRequest()Z
    .locals 5

    .prologue
    const/4 v0, 0x1

    .line 423
    iget-wide v1, p0, Lcom/amazon/mShop/feature/Features;->mLastUpdateTime:J

    const-wide/16 v3, -0x1

    cmp-long v1, v1, v3

    if-nez v1, :cond_1

    .line 427
    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v1

    iget-wide v3, p0, Lcom/amazon/mShop/feature/Features;->mLastUpdateTime:J

    sub-long/2addr v1, v3

    const-wide/32 v3, 0x927c0

    cmp-long v1, v1, v3

    if-gtz v1, :cond_0

    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public addFeatureStateSubscriber(Lcom/amazon/mShop/feature/FeatureStateSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/feature/FeatureStateSubscriber;

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureStateSubscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 91
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureStateSubscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 93
    :cond_0
    return-void
.end method

.method public varargs areFeaturesCached([Ljava/lang/String;)Z
    .locals 5
    .param p1, "featureNames"    # [Ljava/lang/String;

    .prologue
    .line 413
    move-object v0, p1

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v1, v0, v2

    .line 414
    .local v1, "featureName":Ljava/lang/String;
    invoke-direct {p0, v1}, Lcom/amazon/mShop/feature/Features;->buildFeature(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    move-result-object v4

    if-nez v4, :cond_0

    .line 415
    const/4 v4, 0x0

    .line 419
    .end local v1    # "featureName":Ljava/lang/String;
    :goto_1
    return v4

    .line 413
    .restart local v1    # "featureName":Ljava/lang/String;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 419
    .end local v1    # "featureName":Ljava/lang/String;
    :cond_1
    const/4 v4, 0x1

    goto :goto_1
.end method

.method public fetchFeatureStates()V
    .locals 1

    .prologue
    .line 359
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/feature/Features;->fetchFeatureStates(Z)V

    .line 360
    return-void
.end method

.method public fetchFeatureStates(Z)V
    .locals 6
    .param p1, "useForce"    # Z

    .prologue
    const-wide/32 v4, 0xea60

    .line 363
    if-eqz p1, :cond_1

    .line 364
    invoke-direct {p0}, Lcom/amazon/mShop/feature/Features;->sendFeatureStateRequest()V

    .line 390
    :cond_0
    :goto_0
    return-void

    .line 367
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mTimer:Ljava/util/Timer;

    if-nez v0, :cond_0

    .line 371
    invoke-direct {p0}, Lcom/amazon/mShop/feature/Features;->shouldSendFeatureStateRequest()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 373
    invoke-direct {p0}, Lcom/amazon/mShop/feature/Features;->shouldDelayFeatureStateCall()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 374
    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/feature/Features;->scheduleFeatureStateCall(J)V

    .line 376
    sget-boolean v0, Lcom/amazon/mShop/feature/Features;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 377
    const-string/jumbo v0, "Feature"

    const-string/jumbo v1, "** Delay Feature State Call because session id is empty"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 382
    :cond_2
    invoke-direct {p0}, Lcom/amazon/mShop/feature/Features;->sendFeatureStateRequest()V

    .line 386
    iget-wide v0, p0, Lcom/amazon/mShop/feature/Features;->mLastUpdateTime:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 387
    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/feature/Features;->scheduleSecondFeatureStateCall(J)V

    goto :goto_0
.end method

.method public getFeature(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    .locals 1
    .param p1, "featureName"    # Ljava/lang/String;

    .prologue
    .line 257
    invoke-direct {p0, p1}, Lcom/amazon/mShop/feature/Features;->buildFeature(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    move-result-object v0

    .line 259
    .local v0, "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    if-eqz v0, :cond_0

    .line 268
    .end local v0    # "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    :goto_0
    return-object v0

    .restart local v0    # "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFeatureCacheStamp(Ljava/lang/String;)Ljava/lang/Integer;
    .locals 2
    .param p1, "featureName"    # Ljava/lang/String;

    .prologue
    .line 301
    invoke-direct {p0, p1}, Lcom/amazon/mShop/feature/Features;->buildFeature(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    move-result-object v0

    .line 302
    .local v0, "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    if-eqz v0, :cond_0

    .line 307
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getCacheStamp()Ljava/lang/Integer;

    move-result-object v1

    .line 309
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getFeatureState(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "featureName"    # Ljava/lang/String;

    .prologue
    .line 279
    invoke-direct {p0, p1}, Lcom/amazon/mShop/feature/Features;->buildFeature(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    move-result-object v0

    .line 281
    .local v0, "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    if-eqz v0, :cond_0

    .line 286
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getClientTreatmentPath()Ljava/lang/String;

    move-result-object v1

    .line 289
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getFeaturesMap()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/rio/j2me/client/services/mShop/Feature;",
            ">;"
        }
    .end annotation

    .prologue
    .line 247
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureMap:Ljava/util/Map;

    return-object v0
.end method

.method public isAllowClientTrigger(Ljava/lang/String;)Z
    .locals 2
    .param p1, "featureName"    # Ljava/lang/String;

    .prologue
    .line 330
    invoke-direct {p0, p1}, Lcom/amazon/mShop/feature/Features;->buildFeature(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    move-result-object v0

    .line 331
    .local v0, "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    if-eqz v0, :cond_0

    .line 332
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getSendTrigger()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    .line 334
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isFeatureActivated(Ljava/lang/String;)Z
    .locals 2
    .param p1, "featureName"    # Ljava/lang/String;

    .prologue
    .line 320
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/feature/Features;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 321
    .local v0, "state":Ljava/lang/String;
    const-string/jumbo v1, "T1"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "T2"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 323
    :cond_0
    const/4 v1, 0x1

    .line 326
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public removeFeatureStateSubscriber(Lcom/amazon/mShop/feature/FeatureStateSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/feature/FeatureStateSubscriber;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mFeatureStateSubscribers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 97
    return-void
.end method

.method public resetStatus()V
    .locals 2

    .prologue
    .line 393
    sget-boolean v0, Lcom/amazon/mShop/feature/Features;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 394
    const-string/jumbo v0, "Feature"

    const-string/jumbo v1, "resetStatus"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 397
    :cond_0
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/amazon/mShop/feature/Features;->mLastUpdateTime:J

    .line 399
    invoke-direct {p0}, Lcom/amazon/mShop/feature/Features;->clearTimer()V

    .line 401
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_1

    .line 402
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    .line 403
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/feature/Features;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 406
    :cond_1
    return-void
.end method
