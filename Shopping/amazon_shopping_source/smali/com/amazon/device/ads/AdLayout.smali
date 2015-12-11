.class public Lcom/amazon/device/ads/AdLayout;
.super Landroid/widget/FrameLayout;
.source "AdLayout.java"

# interfaces
.implements Lcom/amazon/device/ads/Ad;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil;
    }
.end annotation


# static fields
.field public static final DEFAULT_TIMEOUT:I = 0x4e20

.field private static final LOG_TAG:Ljava/lang/String; = "AdLayout"

.field private static threadPool:Ljava/util/concurrent/ScheduledThreadPoolExecutor;


# instance fields
.field private activityRootView:Landroid/view/View;

.field private adSize:Lcom/amazon/device/ads/AdSize;

.field private attached:Z

.field private context:Landroid/content/Context;

.field private controller:Lcom/amazon/device/ads/IAdController;

.field private hasPassedActivityValidationCheck:Z

.field private hasRegisterBroadcastReciever:Z

.field private isInForeground:Z

.field private isParentViewMissingAtLoadTime:Z

.field private lastVisibility:I

.field private listenerOnLayout:Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

.field private loadAdStartTime:J

.field private needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private screenStateReceiver:Landroid/content/BroadcastReceiver;

.field private shouldDisableWebViewHardwareAcceleration:Z


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    .line 93
    const/4 v2, 0x1

    .line 94
    .local v2, "numberThreads":I
    const-wide/16 v0, 0x3c

    .line 96
    .local v0, "keepAliveTimeSeconds":J
    new-instance v3, Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const/4 v4, 0x1

    invoke-direct {v3, v4}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;-><init>(I)V

    sput-object v3, Lcom/amazon/device/ads/AdLayout;->threadPool:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    .line 97
    sget-object v3, Lcom/amazon/device/ads/AdLayout;->threadPool:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const-wide/16 v4, 0x3c

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v3, v4, v5, v6}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->setKeepAliveTime(JLjava/util/concurrent/TimeUnit;)V

    .line 98
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 107
    sget-object v0, Lcom/amazon/device/ads/AdSize;->SIZE_AUTO:Lcom/amazon/device/ads/AdSize;

    invoke-direct {p0, p1, v0}, Lcom/amazon/device/ads/AdLayout;-><init>(Landroid/app/Activity;Lcom/amazon/device/ads/AdSize;)V

    .line 108
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/amazon/device/ads/AdSize;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "adSize"    # Lcom/amazon/device/ads/AdSize;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 117
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 67
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->hasRegisterBroadcastReciever:Z

    .line 68
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->attached:Z

    .line 69
    const/16 v0, 0x8

    iput v0, p0, Lcom/amazon/device/ads/AdLayout;->lastVisibility:I

    .line 70
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 71
    iput-object v2, p0, Lcom/amazon/device/ads/AdLayout;->listenerOnLayout:Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .line 73
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->isParentViewMissingAtLoadTime:Z

    .line 74
    iput-object v2, p0, Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;

    .line 76
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->hasPassedActivityValidationCheck:Z

    .line 77
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/device/ads/AdLayout;->loadAdStartTime:J

    .line 119
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/AdLayout;->initialize(Landroid/content/Context;Lcom/amazon/device/ads/AdSize;)V

    .line 120
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 137
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 67
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->hasRegisterBroadcastReciever:Z

    .line 68
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->attached:Z

    .line 69
    const/16 v0, 0x8

    iput v0, p0, Lcom/amazon/device/ads/AdLayout;->lastVisibility:I

    .line 70
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 71
    iput-object v2, p0, Lcom/amazon/device/ads/AdLayout;->listenerOnLayout:Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .line 73
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->isParentViewMissingAtLoadTime:Z

    .line 74
    iput-object v2, p0, Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;

    .line 76
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->hasPassedActivityValidationCheck:Z

    .line 77
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/device/ads/AdLayout;->loadAdStartTime:J

    .line 139
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/AdLayout;->initialize(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 140
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 151
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 67
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->hasRegisterBroadcastReciever:Z

    .line 68
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->attached:Z

    .line 69
    const/16 v0, 0x8

    iput v0, p0, Lcom/amazon/device/ads/AdLayout;->lastVisibility:I

    .line 70
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 71
    iput-object v2, p0, Lcom/amazon/device/ads/AdLayout;->listenerOnLayout:Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .line 73
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->isParentViewMissingAtLoadTime:Z

    .line 74
    iput-object v2, p0, Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;

    .line 76
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->hasPassedActivityValidationCheck:Z

    .line 77
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/device/ads/AdLayout;->loadAdStartTime:J

    .line 153
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/AdLayout;->initialize(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 154
    return-void
.end method

.method constructor <init>(Lcom/amazon/device/ads/IAdController;)V
    .locals 5
    .param p1, "adController"    # Lcom/amazon/device/ads/IAdController;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 162
    invoke-direct {p0, v4}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 67
    iput-boolean v3, p0, Lcom/amazon/device/ads/AdLayout;->hasRegisterBroadcastReciever:Z

    .line 68
    iput-boolean v3, p0, Lcom/amazon/device/ads/AdLayout;->attached:Z

    .line 69
    const/16 v2, 0x8

    iput v2, p0, Lcom/amazon/device/ads/AdLayout;->lastVisibility:I

    .line 70
    new-instance v2, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v2, v3}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v2, p0, Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 71
    iput-object v4, p0, Lcom/amazon/device/ads/AdLayout;->listenerOnLayout:Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .line 73
    iput-boolean v3, p0, Lcom/amazon/device/ads/AdLayout;->isParentViewMissingAtLoadTime:Z

    .line 74
    iput-object v4, p0, Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;

    .line 76
    iput-boolean v3, p0, Lcom/amazon/device/ads/AdLayout;->hasPassedActivityValidationCheck:Z

    .line 77
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/amazon/device/ads/AdLayout;->loadAdStartTime:J

    .line 164
    iput-object p1, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    .line 165
    const/4 v1, 0x0

    .line 166
    .local v1, "context":Landroid/content/Context;
    const/4 v0, 0x0

    .line 167
    .local v0, "adSize":Lcom/amazon/device/ads/AdSize;
    invoke-direct {p0, v1, v0}, Lcom/amazon/device/ads/AdLayout;->initialize(Landroid/content/Context;Lcom/amazon/device/ads/AdSize;)V

    .line 168
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/AdLayout;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdLayout;

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdLayout;->isInForeground:Z

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/device/ads/AdLayout;)Lcom/amazon/device/ads/IAdController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdLayout;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/device/ads/AdLayout;)Ljava/util/concurrent/atomic/AtomicBoolean;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdLayout;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/device/ads/AdLayout;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AdLayout;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;

    return-object v0
.end method

.method private static getAttributeValue(Landroid/util/AttributeSet;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "attrs"    # Landroid/util/AttributeSet;
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 264
    invoke-interface {p0, p1, p2}, Landroid/util/AttributeSet;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private initialize(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v8, 0x1

    .line 172
    const-string/jumbo v1, "adSize"

    .line 173
    .local v1, "adSizeAttributeName":Ljava/lang/String;
    const-string/jumbo v3, "http://schemas.android.com/apk/lib/com.amazon.device.ads"

    .line 175
    .local v3, "adsXmlNamespace":Ljava/lang/String;
    const-string/jumbo v6, "http://schemas.android.com/apk/lib/com.amazon.device.ads"

    const-string/jumbo v7, "adSize"

    invoke-static {p2, v6, v7}, Lcom/amazon/device/ads/AdLayout;->getAttributeValue(Landroid/util/AttributeSet;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 176
    .local v2, "adSizeAttributeValue":Ljava/lang/String;
    if-nez v2, :cond_0

    .line 179
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "http://schemas.android.com/apk/res/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 180
    .local v5, "oldAdsXmlNamespace":Ljava/lang/String;
    const-string/jumbo v6, "adSize"

    invoke-static {p2, v5, v6}, Lcom/amazon/device/ads/AdLayout;->getAttributeValue(Landroid/util/AttributeSet;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 181
    if-eqz v2, :cond_0

    .line 183
    const-string/jumbo v6, "AdLayout"

    const-string/jumbo v7, "DEPRECATED - Please use the XML namespace \"http://schemas.android.com/apk/lib/com.amazon.device.ads\" for specifying AdLayout properties."

    invoke-static {v8, v6, v7}, Lcom/amazon/device/ads/Log;->w(ZLjava/lang/String;Ljava/lang/String;)V

    .line 184
    sget-object v6, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v2, v6}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "custom"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 186
    const-string/jumbo v4, "Using \"custom\" or \"CUSTOM\" for the \"adSize\" property is no longer supported. Please specifiy a size or remove the property to use Auto Ad Size."

    .line 187
    .local v4, "msg":Ljava/lang/String;
    const-string/jumbo v6, "AdLayout"

    invoke-static {v8, v6, v4}, Lcom/amazon/device/ads/Log;->e(ZLjava/lang/String;Ljava/lang/String;)V

    .line 188
    new-instance v6, Ljava/lang/IllegalArgumentException;

    invoke-direct {v6, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 193
    .end local v4    # "msg":Ljava/lang/String;
    .end local v5    # "oldAdsXmlNamespace":Ljava/lang/String;
    :cond_0
    invoke-static {v2}, Lcom/amazon/device/ads/AdLayout;->parseAdSize(Ljava/lang/String;)Lcom/amazon/device/ads/AdSize;

    move-result-object v0

    .line 195
    .local v0, "adSize":Lcom/amazon/device/ads/AdSize;
    invoke-direct {p0, p1, v0}, Lcom/amazon/device/ads/AdLayout;->initialize(Landroid/content/Context;Lcom/amazon/device/ads/AdSize;)V

    .line 196
    return-void
.end method

.method private initialize(Landroid/content/Context;Lcom/amazon/device/ads/AdSize;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "size"    # Lcom/amazon/device/ads/AdSize;

    .prologue
    const/4 v2, 0x1

    const/4 v4, -0x1

    const/4 v3, 0x0

    .line 215
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v1

    invoke-interface {v1, p1}, Lcom/amazon/device/ads/IInternalAdRegistration;->contextReceived(Landroid/content/Context;)V

    .line 217
    if-nez p2, :cond_0

    .line 219
    sget-object p2, Lcom/amazon/device/ads/AdSize;->SIZE_AUTO:Lcom/amazon/device/ads/AdSize;

    .line 221
    :cond_0
    iput-object p2, p0, Lcom/amazon/device/ads/AdLayout;->adSize:Lcom/amazon/device/ads/AdSize;

    .line 222
    iput-object p1, p0, Lcom/amazon/device/ads/AdLayout;->context:Landroid/content/Context;

    .line 228
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->isInEditMode()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 230
    new-instance v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/amazon/device/ads/AdLayout;->context:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 231
    .local v0, "textView":Landroid/widget/TextView;
    const-string/jumbo v1, "AdLayout"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 232
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v1, v4, v4}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 233
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 234
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/AdLayout;->addView(Landroid/view/View;)V

    .line 260
    .end local v0    # "textView":Landroid/widget/TextView;
    :goto_0
    return-void

    .line 238
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->getVisibility()I

    move-result v1

    if-nez v1, :cond_2

    move v1, v2

    :goto_1
    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->isInForeground:Z

    .line 240
    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/AdLayout;->setHorizontalScrollBarEnabled(Z)V

    .line 241
    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/AdLayout;->setVerticalScrollBarEnabled(Z)V

    .line 248
    iget-object v1, p0, Lcom/amazon/device/ads/AdLayout;->context:Landroid/content/Context;

    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/AdLayout;->isWebViewDatabaseNull(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 250
    const-string/jumbo v1, "AdLayout"

    const-string/jumbo v3, "Disabling ads. Local cache file is inaccessible so ads will fail if we try to create a WebView. Details of this Android bug found at: http://code.google.com/p/android/issues/detail?id=10789"

    invoke-static {v2, v1, v3}, Lcom/amazon/device/ads/Log;->e(ZLjava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    move v1, v3

    .line 238
    goto :goto_1

    .line 254
    :cond_3
    iget-object v1, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    if-nez v1, :cond_4

    .line 256
    iget-object v1, p0, Lcom/amazon/device/ads/AdLayout;->adSize:Lcom/amazon/device/ads/AdSize;

    iget-object v2, p0, Lcom/amazon/device/ads/AdLayout;->context:Landroid/content/Context;

    invoke-virtual {p0, v1, v2}, Lcom/amazon/device/ads/AdLayout;->createAdController(Lcom/amazon/device/ads/AdSize;Landroid/content/Context;)Lcom/amazon/device/ads/IAdController;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    .line 259
    :cond_4
    iget-object v1, p0, Lcom/amazon/device/ads/AdLayout;->context:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/device/ads/AdUtils;->checkDefinedActivities(Landroid/content/Context;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->hasPassedActivityValidationCheck:Z

    goto :goto_0
.end method

.method private loadAdWhenParentViewMissing(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V
    .locals 3
    .param p1, "listener"    # Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .prologue
    .line 540
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    if-nez v1, :cond_0

    .line 542
    const-string/jumbo v0, "Can\'t load an ad because layout parameters are blank. Use setLayoutParams() to specify dimensions for this AdLayout."

    .line 543
    .local v0, "msg":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/Metrics;->getInstance()Lcom/amazon/device/ads/Metrics;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/Metrics;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v1

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_FAILED_NULL_LAYOUT_PARAMS:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 544
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/AdLayout;->onRequestError(Ljava/lang/String;)V

    .line 581
    .end local v0    # "msg":Ljava/lang/String;
    :goto_0
    return-void

    .line 551
    :cond_0
    const/16 v1, 0xb

    invoke-static {v1}, Lcom/amazon/device/ads/Utils;->isAtLeastAndroidAPI(I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 553
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->setActivityRootView()V

    .line 554
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->isActivityRootViewNull()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 557
    const-string/jumbo v0, "Ad load failed because root view could not be obtained from the activity."

    .line 558
    .restart local v0    # "msg":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/AdLayout;->onRequestError(Ljava/lang/String;)V

    goto :goto_0

    .line 564
    .end local v0    # "msg":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->isActivityRootViewLayoutRequested()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 566
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdLayout;->deferAdLoadToLayoutEvent(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V

    .line 567
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdLayout;->setOnLayoutChangeListenerForRoot(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V

    goto :goto_0

    .line 571
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->setFloatingWindowDimensions()V

    .line 572
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdLayout;->loadAdFromAdController(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V

    goto :goto_0

    .line 578
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->setFloatingWindowDimensions()V

    .line 579
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdLayout;->loadAdFromAdController(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V

    goto :goto_0
.end method

.method private static parseAdSize(Ljava/lang/String;)Lcom/amazon/device/ads/AdSize;
    .locals 6
    .param p0, "string"    # Ljava/lang/String;

    .prologue
    .line 268
    sget-object v0, Lcom/amazon/device/ads/AdSize;->SIZE_AUTO:Lcom/amazon/device/ads/AdSize;

    .line 269
    .local v0, "adSize":Lcom/amazon/device/ads/AdSize;
    if-eqz p0, :cond_1

    .line 271
    sget-object v4, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p0, v4}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p0

    .line 272
    const-string/jumbo v4, "auto"

    invoke-virtual {p0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 275
    const-string/jumbo v4, "x"

    invoke-virtual {p0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 276
    .local v2, "sizes":[Ljava/lang/String;
    const/4 v3, 0x0

    .line 277
    .local v3, "width":I
    const/4 v1, 0x0

    .line 278
    .local v1, "height":I
    array-length v4, v2

    const/4 v5, 0x2

    if-ne v4, v5, :cond_0

    .line 280
    const/4 v4, 0x0

    aget-object v4, v2, v4

    invoke-static {v4, v3}, Lcom/amazon/device/ads/Utils;->parseInt(Ljava/lang/String;I)I

    move-result v3

    .line 281
    const/4 v4, 0x1

    aget-object v4, v2, v4

    invoke-static {v4, v1}, Lcom/amazon/device/ads/Utils;->parseInt(Ljava/lang/String;I)I

    move-result v1

    .line 284
    :cond_0
    new-instance v0, Lcom/amazon/device/ads/AdSize;

    .end local v0    # "adSize":Lcom/amazon/device/ads/AdSize;
    invoke-direct {v0, v3, v1}, Lcom/amazon/device/ads/AdSize;-><init>(II)V

    .line 287
    .end local v1    # "height":I
    .end local v2    # "sizes":[Ljava/lang/String;
    .end local v3    # "width":I
    .restart local v0    # "adSize":Lcom/amazon/device/ads/AdSize;
    :cond_1
    return-object v0
.end method

.method private registerScreenStateBroadcastReceiver()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 302
    iget-boolean v1, p0, Lcom/amazon/device/ads/AdLayout;->hasRegisterBroadcastReciever:Z

    if-ne v1, v2, :cond_0

    .line 321
    :goto_0
    return-void

    .line 305
    :cond_0
    iput-boolean v2, p0, Lcom/amazon/device/ads/AdLayout;->hasRegisterBroadcastReciever:Z

    .line 306
    new-instance v1, Lcom/amazon/device/ads/AdLayout$1;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/AdLayout$1;-><init>(Lcom/amazon/device/ads/AdLayout;)V

    iput-object v1, p0, Lcom/amazon/device/ads/AdLayout;->screenStateReceiver:Landroid/content/BroadcastReceiver;

    .line 318
    new-instance v0, Landroid/content/IntentFilter;

    const-string/jumbo v1, "android.intent.action.SCREEN_OFF"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 319
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string/jumbo v1, "android.intent.action.USER_PRESENT"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 320
    iget-object v1, p0, Lcom/amazon/device/ads/AdLayout;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/device/ads/AdLayout;->screenStateReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    goto :goto_0
.end method

.method private unregisterScreenStateBroadcastReceiver()V
    .locals 2

    .prologue
    .line 324
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdLayout;->hasRegisterBroadcastReciever:Z

    if-eqz v0, :cond_0

    .line 326
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdLayout;->hasRegisterBroadcastReciever:Z

    .line 327
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/AdLayout;->screenStateReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 329
    :cond_0
    return-void
.end method


# virtual methods
.method public collapseAd()Z
    .locals 3

    .prologue
    .line 870
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    const-string/jumbo v1, "close"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/device/ads/IAdController;->sendCommand(Ljava/lang/String;Ljava/util/HashMap;)Z

    move-result v0

    return v0
.end method

.method createAdController(Lcom/amazon/device/ads/AdSize;Landroid/content/Context;)Lcom/amazon/device/ads/IAdController;
    .locals 1
    .param p1, "size"    # Lcom/amazon/device/ads/AdSize;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 292
    new-instance v0, Lcom/amazon/device/ads/AdController;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/device/ads/AdController;-><init>(Lcom/amazon/device/ads/AdLayout;Lcom/amazon/device/ads/AdSize;Landroid/content/Context;)V

    return-object v0
.end method

.method deferAdLoadToLayoutEvent(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V
    .locals 2
    .param p1, "listener"    # Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .prologue
    .line 716
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 717
    iput-object p1, p0, Lcom/amazon/device/ads/AdLayout;->listenerOnLayout:Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .line 718
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->scheduleTaskForCheckingIfLayoutHasRun()V

    .line 719
    return-void
.end method

.method public destroy()V
    .locals 2

    .prologue
    .line 902
    const-string/jumbo v0, "AdLayout"

    const-string/jumbo v1, "Destroying the AdLayout"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 903
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLayout;->unregisterScreenStateBroadcastReceiver()V

    .line 904
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->destroy()V

    .line 905
    return-void
.end method

.method failLoadIfLayoutHasNotRun()V
    .locals 3

    .prologue
    .line 736
    iget-object v1, p0, Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 738
    const-string/jumbo v0, "Can\'t load an ad because the view size cannot be determined."

    .line 739
    .local v0, "msg":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/Metrics;->getInstance()Lcom/amazon/device/ads/Metrics;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/Metrics;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v1

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_FAILED_LAYOUT_NOT_RUN:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 740
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/AdLayout;->onRequestError(Ljava/lang/String;)V

    .line 742
    .end local v0    # "msg":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method getActivityRootView()Landroid/view/View;
    .locals 1

    .prologue
    .line 813
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;

    return-object v0
.end method

.method getActivityRootViewDimension(Z)I
    .locals 1
    .param p1, "isWidth"    # Z

    .prologue
    .line 848
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v0

    goto :goto_0
.end method

.method getAdController()Lcom/amazon/device/ads/AdController;
    .locals 1

    .prologue
    .line 780
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    check-cast v0, Lcom/amazon/device/ads/AdController;

    return-object v0
.end method

.method public getAdSize()Lcom/amazon/device/ads/AdSize;
    .locals 1

    .prologue
    .line 414
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->adSize:Lcom/amazon/device/ads/AdSize;

    return-object v0
.end method

.method getNeedsToLoadAdOnLayout()Z
    .locals 1

    .prologue
    .line 766
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method getRawScreenDimension(Z)I
    .locals 4
    .param p1, "isWidth"    # Z

    .prologue
    .line 688
    iget-object v2, p0, Lcom/amazon/device/ads/AdLayout;->context:Landroid/content/Context;

    const-string/jumbo v3, "window"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/WindowManager;

    .line 689
    .local v1, "wm":Landroid/view/WindowManager;
    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    .line 690
    .local v0, "metrics":Landroid/util/DisplayMetrics;
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 691
    if-eqz p1, :cond_0

    iget v2, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    :goto_0
    return v2

    :cond_0
    iget v2, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    goto :goto_0
.end method

.method public getTimeout()I
    .locals 1

    .prologue
    .line 390
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->getTimeout()I

    move-result v0

    return v0
.end method

.method isActivityRootViewLayoutRequested()Z
    .locals 1

    .prologue
    .line 829
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->isLayoutRequested()Z

    move-result v0

    return v0
.end method

.method isActivityRootViewNull()Z
    .locals 1

    .prologue
    .line 838
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAdLoading()Z
    .locals 1

    .prologue
    .line 892
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->isLoading()Z

    move-result v0

    return v0
.end method

.method public isLoading()Z
    .locals 1

    .prologue
    .line 880
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->isAdLoading()Z

    move-result v0

    return v0
.end method

.method isParentViewMissingAtLoadTime()Z
    .locals 1

    .prologue
    .line 789
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdLayout;->isParentViewMissingAtLoadTime:Z

    return v0
.end method

.method isWebViewDatabaseNull(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 297
    invoke-static {p1}, Landroid/webkit/WebViewDatabase;->getInstance(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method isWebViewOk(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 696
    invoke-static {p1}, Lcom/amazon/device/ads/WebViewFactory;->isWebViewOk(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public loadAd()Z
    .locals 1

    .prologue
    .line 424
    new-instance v0, Lcom/amazon/device/ads/AdTargetingOptions;

    invoke-direct {v0}, Lcom/amazon/device/ads/AdTargetingOptions;-><init>()V

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/AdLayout;->loadAd(Lcom/amazon/device/ads/AdTargetingOptions;)Z

    move-result v0

    return v0
.end method

.method public loadAd(Lcom/amazon/device/ads/AdTargetingOptions;)Z
    .locals 4
    .param p1, "options"    # Lcom/amazon/device/ads/AdTargetingOptions;

    .prologue
    const/4 v3, 0x0

    .line 435
    if-nez p1, :cond_0

    .line 437
    new-instance p1, Lcom/amazon/device/ads/AdTargetingOptions;

    .end local p1    # "options":Lcom/amazon/device/ads/AdTargetingOptions;
    invoke-direct {p1}, Lcom/amazon/device/ads/AdTargetingOptions;-><init>()V

    .line 439
    .restart local p1    # "options":Lcom/amazon/device/ads/AdTargetingOptions;
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->getTimeout()I

    move-result v0

    const/4 v1, 0x1

    new-array v1, v1, [Lcom/amazon/device/ads/AdSlot;

    new-instance v2, Lcom/amazon/device/ads/AdSlot;

    invoke-direct {v2, p0, p1}, Lcom/amazon/device/ads/AdSlot;-><init>(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdTargetingOptions;)V

    aput-object v2, v1, v3

    invoke-static {v0, p1, v1}, Lcom/amazon/device/ads/AdLoader;->loadAds(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)[Z

    move-result-object v0

    aget-boolean v0, v0, v3

    return v0
.end method

.method loadAdFromAdController(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V
    .locals 3
    .param p1, "listener"    # Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .prologue
    .line 756
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    iget-wide v1, p0, Lcom/amazon/device/ads/AdLayout;->loadAdStartTime:J

    invoke-interface {v0, v1, v2}, Lcom/amazon/device/ads/IAdController;->prepareAd(J)V

    .line 757
    invoke-virtual {p1, p0}, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;->onAdReady(Lcom/amazon/device/ads/Ad;)V

    .line 758
    return-void
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 334
    invoke-super {p0}, Landroid/widget/FrameLayout;->onAttachedToWindow()V

    .line 336
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->isInEditMode()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 340
    :goto_0
    return-void

    .line 338
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdLayout;->attached:Z

    .line 339
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLayout;->registerScreenStateBroadcastReceiver()V

    goto :goto_0
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 344
    invoke-super {p0}, Landroid/widget/FrameLayout;->onDetachedFromWindow()V

    .line 345
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdLayout;->attached:Z

    .line 346
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLayout;->unregisterScreenStateBroadcastReceiver()V

    .line 347
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->prepareToGoAway()V

    .line 348
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 4
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 368
    sub-int v1, p4, p2

    .line 369
    .local v1, "w":I
    sub-int v0, p5, p3

    .line 370
    .local v0, "h":I
    invoke-super/range {p0 .. p5}, Landroid/widget/FrameLayout;->onLayout(ZIIII)V

    .line 372
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->isInEditMode()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 381
    :cond_0
    :goto_0
    return-void

    .line 374
    :cond_1
    iget-object v2, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v2, v1, v0}, Lcom/amazon/device/ads/IAdController;->setWindowDimensions(II)V

    .line 376
    iget-object v2, p0, Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 378
    iget-object v2, p0, Lcom/amazon/device/ads/AdLayout;->listenerOnLayout:Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/AdLayout;->loadAdFromAdController(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V

    .line 379
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/amazon/device/ads/AdLayout;->listenerOnLayout:Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    goto :goto_0
.end method

.method onRequestError(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 746
    const-string/jumbo v0, "AdLayout"

    invoke-static {v0, p1}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 747
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    check-cast v0, Lcom/amazon/device/ads/IAdLoaderCallback;

    new-instance v1, Lcom/amazon/device/ads/AdError;

    sget-object v2, Lcom/amazon/device/ads/AdError$ErrorCode;->REQUEST_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    invoke-direct {v1, v2, p1}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/device/ads/IAdLoaderCallback;->adFailed(Lcom/amazon/device/ads/AdError;)V

    .line 748
    return-void
.end method

.method protected onWindowVisibilityChanged(I)V
    .locals 1
    .param p1, "visibility"    # I

    .prologue
    .line 352
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdLayout;->attached:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/amazon/device/ads/AdLayout;->lastVisibility:I

    if-eq v0, p1, :cond_0

    .line 354
    if-eqz p1, :cond_1

    .line 356
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdLayout;->isInForeground:Z

    .line 357
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLayout;->unregisterScreenStateBroadcastReceiver()V

    .line 364
    :cond_0
    :goto_0
    return-void

    .line 359
    :cond_1
    if-nez p1, :cond_0

    .line 361
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdLayout;->isInForeground:Z

    goto :goto_0
.end method

.method protected passesInternetPermissionCheck(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 706
    invoke-static {}, Lcom/amazon/device/ads/PermissionChecker;->getInstance()Lcom/amazon/device/ads/PermissionChecker;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/device/ads/PermissionChecker;->passesInternetPermissionCheck(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method prepareAd(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)I
    .locals 6
    .param p1, "listener"    # Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .prologue
    const/4 v2, -0x1

    const/4 v3, 0x1

    .line 460
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/amazon/device/ads/AdLayout;->loadAdStartTime:J

    .line 461
    iget-object v4, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v4}, Lcom/amazon/device/ads/IAdController;->isAdLoading()Z

    move-result v4

    if-nez v4, :cond_0

    iget-object v4, p0, Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 463
    :cond_0
    const-string/jumbo v3, "AdLayout"

    const-string/jumbo v4, "Can\'t load an ad because ad loading is already in progress"

    invoke-static {v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 531
    :goto_0
    return v2

    .line 467
    :cond_1
    iget-object v4, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v4}, Lcom/amazon/device/ads/IAdController;->isAdExpanded()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 469
    const-string/jumbo v3, "AdLayout"

    const-string/jumbo v4, "Can\'t load an ad because another ad is currently expanded"

    invoke-static {v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 473
    :cond_2
    iget-boolean v2, p0, Lcom/amazon/device/ads/AdLayout;->hasPassedActivityValidationCheck:Z

    if-nez v2, :cond_3

    .line 475
    const-string/jumbo v1, "Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info."

    .line 478
    .local v1, "msg":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/AdLayout;->onRequestError(Ljava/lang/String;)V

    move v2, v3

    .line 479
    goto :goto_0

    .line 482
    .end local v1    # "msg":Ljava/lang/String;
    :cond_3
    iget-object v2, p0, Lcom/amazon/device/ads/AdLayout;->context:Landroid/content/Context;

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/AdLayout;->passesInternetPermissionCheck(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 484
    const-string/jumbo v1, "Ads cannot load because the INTERNET permission is missing from the app\'s manifest."

    .line 485
    .restart local v1    # "msg":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/AdLayout;->onRequestError(Ljava/lang/String;)V

    move v2, v3

    .line 486
    goto :goto_0

    .line 489
    .end local v1    # "msg":Ljava/lang/String;
    :cond_4
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/RegistrationInfo;->getAppKey()Ljava/lang/String;

    move-result-object v0

    .line 490
    .local v0, "appKey":Ljava/lang/String;
    if-nez v0, :cond_5

    .line 492
    const-string/jumbo v1, "Can\'t load an ad because Application Key has not been set. Did you forget to call AdRegistration.setAppKey( ... )?"

    .line 493
    .restart local v1    # "msg":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/AdLayout;->onRequestError(Ljava/lang/String;)V

    move v2, v3

    .line 494
    goto :goto_0

    .line 497
    .end local v1    # "msg":Ljava/lang/String;
    :cond_5
    iget-object v2, p0, Lcom/amazon/device/ads/AdLayout;->context:Landroid/content/Context;

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/AdLayout;->isWebViewOk(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 499
    const-string/jumbo v1, "We will be unable to create a WebView for rendering an ad due to an unknown issue with the WebView."

    .line 500
    .restart local v1    # "msg":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/Metrics;->getInstance()Lcom/amazon/device/ads/Metrics;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/Metrics;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->AD_FAILED_UNKNOWN_WEBVIEW_ISSUE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v4}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 501
    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/AdLayout;->onRequestError(Ljava/lang/String;)V

    move v2, v3

    .line 502
    goto :goto_0

    .line 505
    .end local v1    # "msg":Ljava/lang/String;
    :cond_6
    iget-object v2, p0, Lcom/amazon/device/ads/AdLayout;->adSize:Lcom/amazon/device/ads/AdSize;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdSize;->isAuto()Z

    move-result v2

    if-eqz v2, :cond_7

    .line 507
    const-string/jumbo v1, "Ad size to be determined automatically."

    .line 508
    .restart local v1    # "msg":Ljava/lang/String;
    const-string/jumbo v2, "AdLayout"

    invoke-static {v2, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 511
    .end local v1    # "msg":Ljava/lang/String;
    :cond_7
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->setIsParentViewMissingAtLoadTime()V

    .line 513
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->isLayoutRequested()Z

    move-result v2

    if-eqz v2, :cond_8

    iget-object v2, p0, Lcom/amazon/device/ads/AdLayout;->adSize:Lcom/amazon/device/ads/AdSize;

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdSize;->isAuto()Z

    move-result v2

    if-eqz v2, :cond_8

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->isParentViewMissingAtLoadTime()Z

    move-result v2

    if-nez v2, :cond_8

    .line 518
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdLayout;->deferAdLoadToLayoutEvent(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V

    .line 531
    :goto_1
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 520
    :cond_8
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->isParentViewMissingAtLoadTime()Z

    move-result v2

    if-eqz v2, :cond_9

    .line 525
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/AdLayout;->loadAdWhenParentViewMissing(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V

    goto :goto_1

    .line 529
    :cond_9
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdLayout;->loadAdFromAdController(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V

    goto :goto_1
.end method

.method resolveLayoutParamForFloatingAd(Z)I
    .locals 2
    .param p1, "isWidth"    # Z

    .prologue
    .line 656
    if-eqz p1, :cond_1

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iget v0, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 658
    .local v0, "value":I
    :goto_0
    const/4 v1, -0x1

    if-ne v0, v1, :cond_3

    .line 660
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->isActivityRootViewNull()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 664
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdLayout;->getRawScreenDimension(Z)I

    move-result v0

    .line 678
    .end local v0    # "value":I
    :cond_0
    :goto_1
    return v0

    .line 656
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iget v0, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_0

    .line 669
    .restart local v0    # "value":I
    :cond_2
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdLayout;->getActivityRootViewDimension(Z)I

    move-result v0

    goto :goto_1

    .line 673
    :cond_3
    const/4 v1, -0x2

    if-ne v0, v1, :cond_0

    .line 675
    const/4 v0, 0x0

    goto :goto_1
.end method

.method scheduleTaskForCheckingIfLayoutHasRun()V
    .locals 5

    .prologue
    .line 723
    new-instance v0, Lcom/amazon/device/ads/AdLayout$2;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/AdLayout$2;-><init>(Lcom/amazon/device/ads/AdLayout;)V

    .line 731
    .local v0, "runnable":Ljava/lang/Runnable;
    sget-object v1, Lcom/amazon/device/ads/AdLayout;->threadPool:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->getTimeout()I

    move-result v2

    int-to-long v2, v2

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v0, v2, v3, v4}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 732
    return-void
.end method

.method setActivityRootView()V
    .locals 2

    .prologue
    .line 820
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->context:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    const v1, 0x1020002

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;

    .line 821
    return-void
.end method

.method setFloatingWindowDimensions()V
    .locals 3

    .prologue
    .line 634
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/AdLayout;->resolveLayoutParamForFloatingAd(Z)I

    move-result v1

    .line 635
    .local v1, "floatingWindowWidth":I
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/AdLayout;->resolveLayoutParamForFloatingAd(Z)I

    move-result v0

    .line 637
    .local v0, "floatingWindowHeight":I
    iget-object v2, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v2, v1, v0}, Lcom/amazon/device/ads/IAdController;->setWindowDimensions(II)V

    .line 638
    return-void
.end method

.method setIsParentViewMissingAtLoadTime()V
    .locals 1

    .prologue
    .line 797
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/device/ads/AdLayout;->isParentViewMissingAtLoadTime:Z

    .line 798
    return-void

    .line 797
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method setIsParentViewMissingAtLoadTime(Z)V
    .locals 0
    .param p1, "parentViewMissingAtLoadTime"    # Z

    .prologue
    .line 804
    iput-boolean p1, p0, Lcom/amazon/device/ads/AdLayout;->isParentViewMissingAtLoadTime:Z

    .line 805
    return-void
.end method

.method public setListener(Lcom/amazon/device/ads/AdListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/ads/AdListener;

    .prologue
    .line 857
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0, p1}, Lcom/amazon/device/ads/IAdController;->setListener(Lcom/amazon/device/ads/AdListener;)V

    .line 858
    return-void
.end method

.method setNeedsToLoadAdOnLayout(Z)V
    .locals 1
    .param p1, "value"    # Z

    .prologue
    .line 775
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 776
    return-void
.end method

.method setOnLayoutChangeListenerForRoot(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .prologue
    .line 589
    invoke-static {p0, p1}, Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil;->setOnLayoutChangeListenerForRoot(Lcom/amazon/device/ads/AdLayout;Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V

    .line 590
    return-void
.end method

.method setShouldDisableWebViewHardwareAcceleration(Z)V
    .locals 0
    .param p1, "shouldDisableWebViewHardwareAcceleration"    # Z

    .prologue
    .line 205
    iput-boolean p1, p0, Lcom/amazon/device/ads/AdLayout;->shouldDisableWebViewHardwareAcceleration:Z

    .line 206
    return-void
.end method

.method public setTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 402
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0, p1}, Lcom/amazon/device/ads/IAdController;->setTimeout(I)V

    .line 403
    return-void
.end method

.method shouldDisableWebViewHardwareAcceleration()Z
    .locals 1

    .prologue
    .line 200
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdLayout;->shouldDisableWebViewHardwareAcceleration:Z

    return v0
.end method
