.class public Lcom/amazon/mShop/search/viewit/ViewItActivity;
.super Lcom/amazon/mShop/search/viewit/FSECameraActivity;
.source "ViewItActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/search/viewit/ViewItActivity$10;
    }
.end annotation


# instance fields
.field private mBarcodes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mDataMatrixCodes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mGraphicsMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/amazon/mShop/search/viewit/FSEGraphic;",
            ">;"
        }
    .end annotation
.end field

.field private mImageAsins:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mIsDrawingDisabled:Z

.field private mIsFreshStart:Z

.field private mIsLoadingDisabled:Z

.field private mLastScannedOutput:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mLastScannedTimeMillis:J

.field private mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

.field private mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

.field private privateAuthCodeScanned:Z

.field private publicAuthCodeScanned:Z


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 67
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;-><init>()V

    .line 113
    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsLoadingDisabled:Z

    .line 122
    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    .line 127
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsFreshStart:Z

    .line 132
    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;

    .line 137
    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;

    .line 142
    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    .line 150
    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->publicAuthCodeScanned:Z

    .line 151
    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->privateAuthCodeScanned:Z

    .line 156
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;

    .line 171
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mLastScannedTimeMillis:J

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .prologue
    .line 67
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->updateCameraScreen()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/ViewItActivity;Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .param p1, "x1"    # Ljava/util/List;
    .param p2, "x2"    # Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    .prologue
    .line 67
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->showLoadingWindow(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$502(Lcom/amazon/mShop/search/viewit/ViewItActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 67
    iput-boolean p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->publicAuthCodeScanned:Z

    return p1
.end method

.method static synthetic access$600(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .prologue
    .line 67
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->showPublicDataMatrixCodeInfoDialog()V

    return-void
.end method

.method static synthetic access$702(Lcom/amazon/mShop/search/viewit/ViewItActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 67
    iput-boolean p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->privateAuthCodeScanned:Z

    return p1
.end method

.method static synthetic access$802(Lcom/amazon/mShop/search/viewit/ViewItActivity;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$900(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;

    return-object v0
.end method

.method private clearLastScanned()V
    .locals 2

    .prologue
    .line 188
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mLastScannedOutput:Ljava/util/List;

    .line 189
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mLastScannedTimeMillis:J

    .line 190
    return-void
.end method

.method private clearSceenAndData()V
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 547
    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;

    .line 548
    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;

    .line 549
    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    .line 550
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    if-eqz v0, :cond_0

    .line 551
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 552
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItActivity$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 559
    :cond_0
    return-void
.end method

.method private handleDataMatrixCode(Ljava/lang/String;)V
    .locals 3
    .param p1, "dataMatrixCode"    # Ljava/lang/String;

    .prologue
    .line 907
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeRequest;-><init>()V

    .line 908
    .local v0, "authRequest":Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeRequest;
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeRequest;->setCode(Ljava/lang/String;)V

    .line 910
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V

    invoke-interface {v1, v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->recognizeAuthenticityCode(Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeRequest;Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 959
    return-void
.end method

.method private isDataMatrixCodeEnabled()Z
    .locals 7

    .prologue
    const/4 v4, 0x0

    .line 468
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v0

    .line 469
    .local v0, "currentLocaleName":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$array;->config_datamatrixSupportedLocaleIds:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v3

    .line 470
    .local v3, "supportedLocales":[Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 482
    :cond_0
    :goto_0
    return v4

    .line 474
    :cond_1
    const/4 v2, 0x0

    .line 475
    .local v2, "supportedInLocale":Z
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    array-length v5, v3

    if-ge v1, v5, :cond_2

    .line 476
    aget-object v5, v3, v1

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 477
    const/4 v2, 0x1

    .line 482
    :cond_2
    if-eqz v2, :cond_0

    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v5

    const-string/jumbo v6, "Android_DataMatrix"

    invoke-virtual {v5, v6}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    const/4 v4, 0x1

    goto :goto_0

    .line 475
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method private reportAuthScanMetrics()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 223
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->publicAuthCodeScanned:Z

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->privateAuthCodeScanned:Z

    if-eqz v0, :cond_1

    .line 224
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    const-string/jumbo v1, "SessionsWithPublicPrivateCodes"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    .line 232
    :cond_0
    :goto_0
    iput-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->publicAuthCodeScanned:Z

    .line 233
    iput-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->privateAuthCodeScanned:Z

    .line 234
    return-void

    .line 225
    :cond_1
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->publicAuthCodeScanned:Z

    if-eqz v0, :cond_2

    .line 226
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    const-string/jumbo v1, "SessionsWithPublicOnlyCodes"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    goto :goto_0

    .line 227
    :cond_2
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->privateAuthCodeScanned:Z

    if-eqz v0, :cond_0

    .line 228
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    const-string/jumbo v1, "SessionsWithPrivateOnlyCodes"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private showLoadingWindow(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V
    .locals 3
    .param p2, "outPutType"    # Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "scannedOutput":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v2, 0x0

    .line 565
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItDialogHelper()Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->clearErrorWindow()V

    .line 566
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->showLoadingWindow(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V

    .line 567
    const-wide/16 v0, 0x64

    invoke-static {p0, v0, v1}, Lcom/amazon/mShop/util/UIUtils;->vibrate(Landroid/content/Context;J)V

    .line 570
    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;

    .line 571
    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;

    .line 572
    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    .line 573
    return-void
.end method

.method private showNoObjectFoundErrorDialog()V
    .locals 2

    .prologue
    .line 576
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsBarcodeScanOnly:Z

    if-nez v0, :cond_0

    .line 577
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItActivity$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity$2;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 584
    :cond_0
    return-void
.end method

.method private showPublicDataMatrixCodeInfoDialog()V
    .locals 2

    .prologue
    .line 587
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsBarcodeScanOnly:Z

    if-nez v0, :cond_0

    .line 588
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItActivity$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity$3;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 595
    :cond_0
    return-void
.end method

.method private upateCheckBoxGraphic(Landroid/graphics/PointF;)V
    .locals 5
    .param p1, "centroid"    # Landroid/graphics/PointF;

    .prologue
    const/4 v3, 0x1

    .line 969
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 970
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/viewit/FSEGraphic;

    .line 971
    .local v0, "graphic":Lcom/amazon/mShop/search/viewit/FSEGraphic;
    invoke-virtual {v0, p1}, Lcom/amazon/mShop/search/viewit/FSEGraphic;->setCenterPoint(Landroid/graphics/PointF;)V

    .line 988
    .end local v0    # "graphic":Lcom/amazon/mShop/search/viewit/FSEGraphic;
    :cond_0
    :goto_0
    return-void

    .line 973
    :cond_1
    iget-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsLoadingDisabled:Z

    if-nez v1, :cond_0

    .line 975
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/search/viewit/BoxGraphic;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v4, p1}, Lcom/amazon/mShop/search/viewit/BoxGraphic;-><init>(Landroid/content/Context;Ljava/util/List;Landroid/graphics/PointF;)V

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 979
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/search/viewit/ViewItActivity$7;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity$7;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V

    const-wide/16 v3, 0x2bc

    invoke-interface {v1, v2, v3, v4}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    goto :goto_0
.end method

.method private updateCameraScreen()V
    .locals 4

    .prologue
    .line 536
    const/4 v1, 0x0

    .line 537
    .local v1, "graphicList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/FSEGraphic;>;"
    new-instance v1, Ljava/util/ArrayList;

    .end local v1    # "graphicList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/FSEGraphic;>;"
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 538
    .restart local v1    # "graphicList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/FSEGraphic;>;"
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/viewit/FSEGraphic;

    .line 539
    .local v0, "g":Lcom/amazon/mShop/search/viewit/FSEGraphic;
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 541
    .end local v0    # "g":Lcom/amazon/mShop/search/viewit/FSEGraphic;
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->drawScanningGraphic(Ljava/util/List;)V

    .line 542
    return-void
.end method

.method private updateLoadingStatus(Ljava/util/List;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 603
    .local p1, "newScannedOutput":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 604
    .local v0, "currentTimeMillis":J
    iget-wide v3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mLastScannedTimeMillis:J

    sub-long v3, v0, v3

    const-wide/16 v5, 0x1f40

    cmp-long v3, v3, v5

    if-lez v3, :cond_2

    const/4 v2, 0x1

    .line 605
    .local v2, "isIntervalElapsed":Z
    :goto_0
    if-nez v2, :cond_0

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mLastScannedOutput:Ljava/util/List;

    invoke-static {v3, p1}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->isSimilarObject(Ljava/util/List;Ljava/util/List;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 606
    :cond_0
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mLastScannedOutput:Ljava/util/List;

    .line 607
    iput-wide v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mLastScannedTimeMillis:J

    .line 608
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->enableLoading()V

    .line 610
    :cond_1
    return-void

    .line 604
    .end local v2    # "isIntervalElapsed":Z
    :cond_2
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public didDecodeTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V
    .locals 0
    .param p1, "flowTextCanvasInfo"    # Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;

    .prologue
    .line 842
    return-void
.end method

.method public didProcessFrame(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;II)V
    .locals 0
    .param p1, "objectType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "frameID"    # I
    .param p3, "info"    # I

    .prologue
    .line 769
    return-void
.end method

.method public didReceieveBadTextCanvasDecode()V
    .locals 0

    .prologue
    .line 832
    return-void
.end method

.method public didReceieveScannerBoring()V
    .locals 1

    .prologue
    .line 1049
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    if-eqz v0, :cond_0

    .line 1054
    :goto_0
    return-void

    .line 1053
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->showNoObjectFoundErrorDialog()V

    goto :goto_0
.end method

.method public didReceiveBarcodeDecodeSuccess(Lcom/flow/android/engine/library/objectinfo/FlowBarcodeObjectInfo;)V
    .locals 4
    .param p1, "flowObjectInfo"    # Lcom/flow/android/engine/library/objectinfo/FlowBarcodeObjectInfo;

    .prologue
    const/4 v2, 0x0

    .line 644
    iget-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    if-eqz v3, :cond_1

    .line 645
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->clearSceenAndData()V

    .line 674
    :cond_0
    :goto_0
    return-void

    .line 649
    :cond_1
    if-nez p1, :cond_2

    move-object v0, v2

    .line 650
    .local v0, "barcode":Ljava/lang/String;
    :goto_1
    if-nez p1, :cond_3

    move-object v1, v2

    .line 652
    .local v1, "barcodeFormat":Ljava/lang/String;
    :goto_2
    iget-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsBarcodeScanOnly:Z

    if-eqz v3, :cond_4

    .line 653
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;

    invoke-direct {v3, p0, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 649
    .end local v0    # "barcode":Ljava/lang/String;
    .end local v1    # "barcodeFormat":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Lcom/flow/android/engine/library/objectinfo/FlowBarcodeObjectInfo;->getBarcode()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 650
    .restart local v0    # "barcode":Ljava/lang/String;
    :cond_3
    invoke-virtual {p1}, Lcom/flow/android/engine/library/objectinfo/FlowBarcodeObjectInfo;->getBarcodeType()Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    .line 668
    .restart local v1    # "barcodeFormat":Ljava/lang/String;
    :cond_4
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 669
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;

    .line 670
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 671
    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;

    .line 672
    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    goto :goto_0
.end method

.method public didReceiveDataMatrixDecodeSuccess(Lcom/flow/android/engine/library/objectinfo/FlowDataMatrixObjectInfo;)V
    .locals 3
    .param p1, "flowObjectInfo"    # Lcom/flow/android/engine/library/objectinfo/FlowDataMatrixObjectInfo;

    .prologue
    const/4 v1, 0x0

    .line 683
    iget-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    if-eqz v2, :cond_1

    .line 684
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->clearSceenAndData()V

    .line 695
    :cond_0
    :goto_0
    return-void

    .line 688
    :cond_1
    if-nez p1, :cond_2

    move-object v0, v1

    .line 689
    .local v0, "code":Ljava/lang/String;
    :goto_1
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 690
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    .line 691
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 692
    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;

    .line 693
    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;

    goto :goto_0

    .line 688
    .end local v0    # "code":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Lcom/flow/android/engine/library/objectinfo/FlowDataMatrixObjectInfo;->getDataMatrixCode()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public didReceiveFreeText(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;)V
    .locals 0
    .param p3, "layout"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 737
    .local p1, "noundsBrandsModelNum":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .local p2, "words":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    return-void
.end method

.method public didReceiveImageMatchSuccess(Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;)V
    .locals 3
    .param p1, "flowObjectInfo"    # Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;

    .prologue
    const/4 v1, 0x0

    .line 704
    iget-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    if-eqz v2, :cond_1

    .line 705
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->clearSceenAndData()V

    .line 715
    :cond_0
    :goto_0
    return-void

    .line 709
    :cond_1
    if-nez p1, :cond_2

    move-object v0, v1

    .line 710
    .local v0, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_1
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 711
    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;

    .line 712
    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;

    .line 713
    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    goto :goto_0

    .line 709
    .end local v0    # "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_2
    invoke-virtual {p1}, Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;->getAsins()Ljava/util/List;

    move-result-object v0

    goto :goto_1
.end method

.method public didReceiveInterestPoints(Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/graphics/PointF;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1015
    .local p1, "points":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/graphics/PointF;>;"
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    if-eqz v0, :cond_1

    .line 1016
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->clearSceenAndData()V

    .line 1029
    :cond_0
    :goto_0
    return-void

    .line 1020
    :cond_1
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsBarcodeScanOnly:Z

    if-nez v0, :cond_0

    .line 1021
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItActivity$8;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItActivity$8;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;Ljava/util/ArrayList;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public didReceiveLogoResponse(Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;)V
    .locals 0
    .param p1, "flowLogoMatchObjectInfo"    # Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;

    .prologue
    .line 747
    return-void
.end method

.method public didReceiveQRCodeDecodeSuccess(Lcom/flow/android/engine/library/objectinfo/FlowQrCodeObjectInfo;)V
    .locals 0
    .param p1, "flowObjectInfo"    # Lcom/flow/android/engine/library/objectinfo/FlowQrCodeObjectInfo;

    .prologue
    .line 635
    return-void
.end method

.method public didReceiveScannerStuck()V
    .locals 1

    .prologue
    .line 1036
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    if-eqz v0, :cond_0

    .line 1041
    :goto_0
    return-void

    .line 1040
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->showNoObjectFoundErrorDialog()V

    goto :goto_0
.end method

.method public didReceiveServerFailure(Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;)V
    .locals 4
    .param p1, "reason"    # Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    .prologue
    .line 1063
    iget-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    if-eqz v2, :cond_1

    .line 1064
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->clearSceenAndData()V

    .line 1104
    :cond_0
    :goto_0
    return-void

    .line 1074
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    if-eqz v2, :cond_0

    iget-boolean v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsBarcodeScanOnly:Z

    if-nez v2, :cond_0

    .line 1077
    sget-object v2, Lcom/amazon/mShop/search/viewit/ViewItActivity$10;->$SwitchMap$com$flow$android$engine$library$FlowStateEngineInterface$CallbackServerFailure:[I

    invoke-virtual {p1}, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 1092
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_unknown:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 1093
    .local v1, "errorMsg":Ljava/lang/String;
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_UNKNOWN:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 1097
    .local v0, "errorDialogType":Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
    :goto_1
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/search/viewit/ViewItActivity$9;

    invoke-direct {v3, p0, v1, v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity$9;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V

    invoke-interface {v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 1079
    .end local v0    # "errorDialogType":Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
    .end local v1    # "errorMsg":Ljava/lang/String;
    :pswitch_0
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_network_error:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 1080
    .restart local v1    # "errorMsg":Ljava/lang/String;
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_NETWORK:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 1081
    .restart local v0    # "errorDialogType":Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
    goto :goto_1

    .line 1083
    .end local v0    # "errorDialogType":Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
    .end local v1    # "errorMsg":Ljava/lang/String;
    :pswitch_1
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_authorize_fail:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 1084
    .restart local v1    # "errorMsg":Ljava/lang/String;
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_UNAUTHORIZED:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 1085
    .restart local v0    # "errorDialogType":Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
    goto :goto_1

    .line 1087
    .end local v0    # "errorDialogType":Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
    .end local v1    # "errorMsg":Ljava/lang/String;
    :pswitch_2
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_server_return_error:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 1088
    .restart local v1    # "errorMsg":Ljava/lang/String;
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_FLOW_SERVER:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 1089
    .restart local v0    # "errorDialogType":Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
    goto :goto_1

    .line 1077
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public didReceiveTextSuccess(Lcom/flow/android/engine/library/objectinfo/FlowTextObjectInfo;)V
    .locals 0
    .param p1, "flowObjectInfo"    # Lcom/flow/android/engine/library/objectinfo/FlowTextObjectInfo;

    .prologue
    .line 725
    return-void
.end method

.method public didReceiveTrack(ILjava/util/ArrayList;Landroid/graphics/PointF;)V
    .locals 3
    .param p1, "id"    # I
    .param p3, "centroid"    # Landroid/graphics/PointF;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/graphics/PointF;",
            ">;",
            "Landroid/graphics/PointF;",
            ")V"
        }
    .end annotation

    .prologue
    .line 854
    .local p2, "points":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/graphics/PointF;>;"
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->finishFlowTimeToSuccessObserver()V

    .line 856
    iget-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    if-eqz v1, :cond_1

    .line 857
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->clearSceenAndData()V

    .line 893
    :cond_0
    :goto_0
    return-void

    .line 861
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 862
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;

    invoke-direct {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->updateLoadingStatus(Ljava/util/List;)V

    .line 869
    :cond_2
    :goto_1
    iget-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsLoadingDisabled:Z

    if-nez v1, :cond_0

    .line 870
    invoke-direct {p0, p3}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->upateCheckBoxGraphic(Landroid/graphics/PointF;)V

    .line 871
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->disableLoading()V

    .line 873
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_5

    iget-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsBarcodeScanOnly:Z

    if-nez v1, :cond_5

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    if-eqz v1, :cond_5

    .line 874
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 875
    .local v0, "dataMatrixCode":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->handleDataMatrixCode(Ljava/lang/String;)V

    goto :goto_0

    .line 863
    .end local v0    # "dataMatrixCode":Ljava/lang/String;
    :cond_3
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 864
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;

    invoke-direct {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->updateLoadingStatus(Ljava/util/List;)V

    goto :goto_1

    .line 865
    :cond_4
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 866
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;

    invoke-direct {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->updateLoadingStatus(Ljava/util/List;)V

    goto :goto_1

    .line 876
    :cond_5
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-eqz v1, :cond_6

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_0

    :cond_6
    iget-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsBarcodeScanOnly:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    if-eqz v1, :cond_0

    .line 878
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/search/viewit/ViewItActivity$5;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity$5;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V

    invoke-interface {v1, v2}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public didReceiveTrackFail(I)V
    .locals 2
    .param p1, "id"    # I

    .prologue
    .line 998
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->startFlowTimeToSuccessObserver()V

    .line 1000
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    if-eqz v0, :cond_0

    .line 1001
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->clearSceenAndData()V

    .line 1005
    :goto_0
    return-void

    .line 1003
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public didStopTrackingTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V
    .locals 0
    .param p1, "flowTextCanvasInfo"    # Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;

    .prologue
    .line 806
    return-void
.end method

.method public didTrackTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V
    .locals 0
    .param p1, "flowTextCanvasInfo"    # Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;

    .prologue
    .line 824
    return-void
.end method

.method public didUpdateTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V
    .locals 0
    .param p1, "flowTextCanvasInfo"    # Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;

    .prologue
    .line 816
    return-void
.end method

.method public disableDrawing()V
    .locals 1

    .prologue
    .line 455
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    .line 456
    return-void
.end method

.method public disableLoading()V
    .locals 1

    .prologue
    .line 442
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsLoadingDisabled:Z

    .line 443
    return-void
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x1

    .line 409
    const/16 v2, 0x1b

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    if-eq v2, v3, :cond_0

    const/16 v2, 0x50

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    if-ne v2, v3, :cond_1

    .line 427
    :cond_0
    :goto_0
    return v1

    .line 412
    :cond_1
    const/16 v2, 0x54

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    if-eq v2, v3, :cond_2

    const/16 v2, 0x52

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    if-ne v2, v3, :cond_4

    .line 413
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 427
    :cond_3
    invoke-super {p0, p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0

    .line 417
    :cond_4
    const/4 v2, 0x4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    if-ne v2, v3, :cond_3

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_3

    .line 418
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 419
    .local v0, "currentview":Landroid/view/View;
    instance-of v2, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/gno/GNODrawer;->isVisible()Z

    move-result v2

    if-nez v2, :cond_3

    .line 422
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->animateClose()V

    goto :goto_0
.end method

.method public enableDrawing()V
    .locals 1

    .prologue
    .line 461
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsDrawingDisabled:Z

    .line 462
    return-void
.end method

.method public enableLoading()V
    .locals 1

    .prologue
    .line 448
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsLoadingDisabled:Z

    .line 449
    return-void
.end method

.method protected getCameraFrameLayout()Landroid/widget/FrameLayout;
    .locals 1

    .prologue
    .line 506
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    if-eqz v0, :cond_0

    .line 507
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getCameraFrameLayout()Landroid/widget/FrameLayout;

    move-result-object v0

    .line 509
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected getCredentials()Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;
    .locals 4

    .prologue
    .line 501
    new-instance v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;

    const-string/jumbo v1, "amzn-mbl-cscan-us"

    const-string/jumbo v2, "5b6874d3a20417591bd5464a25a37bc6"

    const-string/jumbo v3, "amzn-mbl-cscan-us"

    invoke-direct {v0, p0, v1, v2, v3}, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;-><init>(Lcom/amazon/mShop/search/viewit/FSECameraActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method protected getModuleSet()Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;",
            ">;"
        }
    .end annotation

    .prologue
    .line 487
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 488
    .local v0, "modules":Ljava/util/Set;, "Ljava/util/Set<Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;>;"
    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->BARCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 489
    iget-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsBarcodeScanOnly:Z

    if-nez v1, :cond_0

    .line 490
    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->IMAGEMATCH:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 492
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->isDataMatrixCodeEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 493
    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->QRCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 496
    :cond_0
    return-object v0
.end method

.method public getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    return-object v0
.end method

.method public getViewItMetricHelper()Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    return-object v0
.end method

.method protected handleCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V
    .locals 5
    .param p1, "a_reason"    # Lcom/a9/cameralibrary/CameraErrorReason;
    .param p2, "a_extraInfo"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 525
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->search_error_message_cannot_open_camera:I

    invoke-static {p0, v1, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    .line 526
    .local v0, "toast":Landroid/widget/Toast;
    const/16 v1, 0x11

    invoke-virtual {v0, v1, v3, v3}, Landroid/widget/Toast;->setGravity(III)V

    .line 527
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 529
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    const-string/jumbo v2, "CANNOT_OPEN_CAMERA"

    invoke-virtual {v1, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p0, v3, v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->setResult(ILandroid/content/Intent;)V

    .line 530
    return-void
.end method

.method protected handleEngineError()V
    .locals 2

    .prologue
    .line 519
    sget-object v0, Lcom/a9/cameralibrary/CameraErrorReason;->UNKNOWN_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

    const-string/jumbo v1, ""

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->handleCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V

    .line 520
    return-void
.end method

.method protected initLayout()V
    .locals 3

    .prologue
    .line 280
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->view_it_photo_capture_view:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    .line 281
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->setRootView(Landroid/view/View;ZZ)V

    .line 282
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->setActionBarAndSeparatorDecoratorVisibility(I)V

    .line 283
    return-void
.end method

.method public lockGNODrawer()V
    .locals 1

    .prologue
    .line 350
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    .line 351
    .local v0, "gnoDrawer":Lcom/amazon/mShop/gno/GNODrawer;
    if-eqz v0, :cond_0

    .line 352
    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->lock()V

    .line 354
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 181
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    .line 182
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsFreshStart:Z

    .line 184
    invoke-super {p0, p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->onCreate(Landroid/os/Bundle;)V

    .line 185
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 267
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->onDestroy()V

    .line 268
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBrowser()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->clear()V

    .line 269
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 273
    invoke-super {p0, p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 274
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsFreshStart:Z

    .line 275
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBrowser()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->clear()V

    .line 276
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 238
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->onPause()V

    .line 243
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->stopScanning()V

    .line 246
    invoke-static {}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->sendEngineMetrics()V

    .line 247
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    .line 194
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->onResume()V

    .line 198
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->clearLastScanned()V

    .line 200
    iget-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsBarcodeScanOnly:Z

    if-eqz v1, :cond_1

    .line 201
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->startScanning()V

    .line 202
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getWindowOverCamera()Landroid/view/View;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 220
    :cond_0
    :goto_0
    return-void

    .line 204
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 205
    .local v0, "currentView":Landroid/view/View;
    if-eqz v0, :cond_0

    instance-of v1, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    if-eqz v1, :cond_0

    .line 206
    iget-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsFreshStart:Z

    if-eqz v1, :cond_3

    .line 207
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->startScanning()V

    .line 209
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 210
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->close()V

    .line 213
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->refresh()V

    .line 214
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsFreshStart:Z

    goto :goto_0

    .line 215
    :cond_3
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v1

    if-nez v1, :cond_0

    .line 216
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->startScanning()V

    goto :goto_0
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 435
    const/4 v0, 0x0

    return v0
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 251
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->onStop()V

    .line 254
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->isEngineStopped()Z

    move-result v0

    if-nez v0, :cond_0

    .line 255
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->stopScanning()V

    .line 258
    invoke-static {}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->sendEngineMetrics()V

    .line 261
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->reportAuthScanMetrics()V

    .line 262
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->postCountMetricsPerSession()V

    .line 263
    return-void
.end method

.method public pauseEngine()V
    .locals 1

    .prologue
    .line 320
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->pauseEngine()V

    .line 323
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->unLockGNODrawer()V

    .line 325
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItDialogHelper()Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->clearErrorWindow()V

    .line 336
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItDialogHelper()Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->sendStopScanningMessageDelayed()V

    .line 337
    return-void
.end method

.method public popView(Z)Z
    .locals 7
    .param p1, "finishIfActivityIsEmpty"    # Z

    .prologue
    .line 378
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getCurrentView()Landroid/view/View;

    move-result-object v2

    .line 379
    .local v2, "popedView":Landroid/view/View;
    invoke-super {p0, p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->popView(Z)Z

    move-result v3

    .line 380
    .local v3, "result":Z
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getCurrentView()Landroid/view/View;

    move-result-object v1

    .line 381
    .local v1, "currentview":Landroid/view/View;
    if-eqz v2, :cond_1

    if-eqz v1, :cond_1

    .line 382
    instance-of v5, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    if-eqz v5, :cond_1

    .line 385
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v5}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v4

    .line 386
    .local v4, "slidingDrawer":Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v5}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerBrowser()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v0

    .line 387
    .local v0, "brower":Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->deleteUndoObject()V

    .line 388
    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getObjectsCount()I

    move-result v5

    if-nez v5, :cond_0

    .line 389
    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateBottomToolBar()V

    .line 390
    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->setListViewHeaderVisibility(I)V

    .line 391
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_vertical_bottom_empty_offset:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateBottomOffset(I)V

    .line 394
    :cond_0
    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v5

    if-nez v5, :cond_1

    .line 395
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->isEngineStopped()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 396
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->startScanning()V

    .line 404
    .end local v0    # "brower":Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    .end local v4    # "slidingDrawer":Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    :cond_1
    :goto_0
    return v3

    .line 397
    .restart local v0    # "brower":Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    .restart local v4    # "slidingDrawer":Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->isEnginePaused()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 398
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->unpauseEngine()V

    goto :goto_0
.end method

.method public pushView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 365
    invoke-super {p0, p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->pushView(Landroid/view/View;)V

    .line 366
    instance-of v0, p1, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->isEnginePaused()Z

    move-result v0

    if-nez v0, :cond_0

    .line 367
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->pauseEngine()V

    .line 369
    :cond_0
    return-void
.end method

.method public showMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 758
    return-void
.end method

.method public startScanning()V
    .locals 1

    .prologue
    .line 286
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->start()V

    .line 287
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->enableLoading()V

    .line 288
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->enableDrawing()V

    .line 290
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 294
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->lockGNODrawer()V

    .line 296
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mIsBarcodeScanOnly:Z

    if-nez v0, :cond_0

    .line 297
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->startFlowSessionDurationObserver()V

    .line 298
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->startFlowTimeToSuccessObserver()V

    .line 299
    const-string/jumbo v0, "fl_session"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 301
    :cond_0
    return-void
.end method

.method public stopScanning()V
    .locals 1

    .prologue
    .line 304
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->stop()V

    .line 305
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->disableLoading()V

    .line 306
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->disableDrawing()V

    .line 307
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mGraphicsMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 311
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->unLockGNODrawer()V

    .line 313
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItDialogHelper()Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->clearErrorWindow()V

    .line 314
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->finishFlowSessionDurationObserver()V

    .line 315
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowTimeToSuccessObserver()V

    .line 316
    return-void
.end method

.method public unLockGNODrawer()V
    .locals 1

    .prologue
    .line 357
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    .line 358
    .local v0, "gnoDrawer":Lcom/amazon/mShop/gno/GNODrawer;
    if-eqz v0, :cond_0

    .line 359
    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->unlock()V

    .line 361
    :cond_0
    return-void
.end method

.method public unpauseEngine()V
    .locals 1

    .prologue
    .line 341
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->unpauseEngine()V

    .line 344
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->lockGNODrawer()V

    .line 346
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItDialogHelper()Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->canclePendingStopScanningMessage()V

    .line 347
    return-void
.end method
