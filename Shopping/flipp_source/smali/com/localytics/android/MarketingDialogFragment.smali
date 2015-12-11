.class public final Lcom/localytics/android/MarketingDialogFragment;
.super Landroid/support/v4/app/y;
.source "SourceFile"


# static fields
.field private static final AMP_DESCRIPTION:Ljava/lang/String; = "amp_view"

.field private static final CLOSE_BUTTON_DESCRIPTION:Ljava/lang/String; = "close_button"

.field private static final CLOSE_BUTTON_ID:I = 0x1

.field static final DIALOG_TAG:Ljava/lang/String; = "marketing_dialog"

.field private static final OPENING_EXTERNAL:I = 0x2

.field private static final OPENING_INTERNAL:I = 0x1

.field private static final PROTOCOL_UNMATCHED:I = -0x1

.field private static final PROTOCOL_UNRECOGNIZED:I = -0x2

.field private static final WEB_VIEW_ID:I = 0x2

.field private static dismissButtonLocation:Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;

.field private static sDismissButtonImage:Landroid/graphics/Bitmap;


# instance fields
.field private mCallbacks:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/localytics/android/MarketingCallable;",
            ">;"
        }
    .end annotation
.end field

.field private final mEnterAnimatable:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final mExitAnimatable:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private mJavaScriptClient:Lcom/localytics/android/JavaScriptClient;

.field private mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

.field private mMarketingMessage:Lcom/localytics/android/MarketingMessage;

.field private final mUploadedViewEvent:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 100
    const/4 v0, 0x0

    sput-object v0, Lcom/localytics/android/MarketingDialogFragment;->sDismissButtonImage:Landroid/graphics/Bitmap;

    .line 101
    sget-object v0, Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;->LEFT:Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;

    sput-object v0, Lcom/localytics/android/MarketingDialogFragment;->dismissButtonLocation:Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 130
    invoke-direct {p0}, Landroid/support/v4/app/y;-><init>()V

    .line 131
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mEnterAnimatable:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 132
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mExitAnimatable:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 133
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mUploadedViewEvent:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 134
    return-void
.end method

.method static synthetic access$000(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/JavaScriptClient;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mJavaScriptClient:Lcom/localytics/android/JavaScriptClient;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/localytics/android/MarketingDialogFragment;)Ljava/util/concurrent/atomic/AtomicBoolean;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mEnterAnimatable:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-object v0
.end method

.method static synthetic access$1600()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 63
    sget-object v0, Lcom/localytics/android/MarketingDialogFragment;->sDismissButtonImage:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method static synthetic access$200(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingMessage;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;

    return-object v0
.end method

.method static synthetic access$300(Lcom/localytics/android/MarketingDialogFragment;)Ljava/util/concurrent/atomic/AtomicBoolean;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mExitAnimatable:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-object v0
.end method

.method static synthetic access$400()Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;
    .locals 1

    .prologue
    .line 63
    sget-object v0, Lcom/localytics/android/MarketingDialogFragment;->dismissButtonLocation:Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;

    return-object v0
.end method

.method static synthetic access$500(Lcom/localytics/android/MarketingDialogFragment;)Landroid/util/SparseArray;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mCallbacks:Landroid/util/SparseArray;

    return-object v0
.end method

.method static getInAppDismissButtonLocation()Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;
    .locals 1

    .prologue
    .line 157
    sget-object v0, Lcom/localytics/android/MarketingDialogFragment;->dismissButtonLocation:Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;

    return-object v0
.end method

.method private getValueByQueryKey(Ljava/lang/String;Ljava/net/URI;)Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v2, 0x0

    const/4 v0, 0x0

    .line 558
    invoke-virtual {p2}, Ljava/net/URI;->getQuery()Ljava/lang/String;

    move-result-object v1

    .line 560
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 585
    :cond_0
    :goto_0
    return-object v0

    .line 565
    :cond_1
    invoke-virtual {p2}, Ljava/net/URI;->getQuery()Ljava/lang/String;

    move-result-object v1

    const-string v3, "[&]"

    invoke-virtual {v1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 566
    array-length v4, v3

    move v1, v2

    :goto_1
    if-ge v1, v4, :cond_0

    aget-object v5, v3, v1

    .line 568
    const-string v6, "[=]"

    invoke-virtual {v5, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 569
    aget-object v6, v5, v2

    invoke-virtual {v6, p1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v6

    if-nez v6, :cond_2

    .line 571
    const/4 v6, 0x2

    array-length v7, v5

    if-ne v6, v7, :cond_2

    .line 575
    const/4 v1, 0x1

    :try_start_0
    aget-object v1, v5, v1

    const-string v2, "UTF-8"

    invoke-static {v1, v2}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 566
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 579
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private getValueByQueryKey(Ljava/lang/String;Ljava/net/URL;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 592
    :try_start_0
    invoke-virtual {p2}, Ljava/net/URL;->toURI()Ljava/net/URI;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/localytics/android/MarketingDialogFragment;->getValueByQueryKey(Ljava/lang/String;Ljava/net/URI;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 596
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method private handleCustomProtocolRequest(Ljava/lang/String;Landroid/app/Activity;)I
    .locals 3

    .prologue
    .line 543
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 544
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    .line 545
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 547
    const-string v1, "[In-app Nav Handler]: An app on this device is registered to handle this protocol scheme. Opening..."

    invoke-static {v1}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 548
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 549
    invoke-virtual {p2, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 550
    const/4 v0, 0x2

    .line 553
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x2

    goto :goto_0
.end method

.method private handleCustomProtocolRequest(Ljava/net/URL;Landroid/app/Activity;)I
    .locals 1

    .prologue
    .line 538
    invoke-virtual {p1}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lcom/localytics/android/MarketingDialogFragment;->handleCustomProtocolRequest(Ljava/lang/String;Landroid/app/Activity;)I

    move-result v0

    return v0
.end method

.method private handleFileProtocolRequest(Ljava/net/URL;)I
    .locals 2

    .prologue
    .line 495
    invoke-virtual {p1}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v0

    const-string v1, "file"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 497
    const/4 v0, -0x1

    .line 502
    :goto_0
    return v0

    .line 500
    :cond_0
    const-string v0, "[In-app Nav Handler]: Displaying content from your local creatives."

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 502
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private handleHttpProtocolRequest(Ljava/net/URL;Landroid/app/Activity;)I
    .locals 5

    .prologue
    const/4 v0, 0x1

    const/4 v4, 0x0

    .line 507
    invoke-virtual {p1}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v1

    .line 508
    const-string v2, "http"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v2, "https"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 510
    const/4 v0, -0x1

    .line 533
    :goto_0
    return v0

    .line 513
    :cond_0
    const-string v1, "[In-app Nav Handler]: Handling a request for an external HTTP address."

    invoke-static {v1}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 516
    const-string v1, "ampExternalOpen"

    invoke-direct {p0, v1, p1}, Lcom/localytics/android/MarketingDialogFragment;->getValueByQueryKey(Ljava/lang/String;Ljava/net/URL;)Ljava/lang/String;

    move-result-object v1

    .line 517
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "true"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 519
    const-string v1, "[In-app Nav Handler]: Query string hook [%s] set to true. Opening the URL in chrome"

    new-array v2, v0, [Ljava/lang/Object;

    const-string v3, "ampExternalOpen"

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 521
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-virtual {p1}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 522
    iget-object v2, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v2}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {v2, v1, v4}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v2

    .line 523
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 525
    invoke-virtual {p2, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 526
    const/4 v0, 0x2

    goto :goto_0

    .line 531
    :cond_1
    const-string v1, "[In-app Nav Handler]: Loading HTTP request inside the current in-app view"

    invoke-static {v1}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    goto :goto_0
.end method

.method static newInstance()Lcom/localytics/android/MarketingDialogFragment;
    .locals 2

    .prologue
    .line 141
    new-instance v0, Lcom/localytics/android/MarketingDialogFragment;

    invoke-direct {v0}, Lcom/localytics/android/MarketingDialogFragment;-><init>()V

    .line 142
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingDialogFragment;->setRetainInstance(Z)V

    .line 143
    return-object v0
.end method

.method static setDismissButtonImage(Landroid/graphics/Bitmap;)V
    .locals 1

    .prologue
    .line 148
    sget-object v0, Lcom/localytics/android/MarketingDialogFragment;->sDismissButtonImage:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 150
    sget-object v0, Lcom/localytics/android/MarketingDialogFragment;->sDismissButtonImage:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 152
    :cond_0
    sput-object p0, Lcom/localytics/android/MarketingDialogFragment;->sDismissButtonImage:Landroid/graphics/Bitmap;

    .line 153
    return-void
.end method

.method static setInAppDismissButtonLocation(Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;)V
    .locals 0

    .prologue
    .line 162
    sput-object p0, Lcom/localytics/android/MarketingDialogFragment;->dismissButtonLocation:Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;

    .line 163
    return-void
.end method

.method private tagMarketingActionEventWithAction(Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v4, 0x2

    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 264
    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 313
    :cond_0
    :goto_0
    return-void

    .line 269
    :cond_1
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mUploadedViewEvent:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, v5}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 271
    const-string v0, "The in-app action for this message has already been set. Ignoring in-app Action: [%s]"

    new-array v1, v5, [Ljava/lang/Object;

    aput-object p1, v1, v6

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    goto :goto_0

    .line 276
    :cond_2
    new-instance v1, Ljava/util/TreeMap;

    invoke-direct {v1}, Ljava/util/TreeMap;-><init>()V

    .line 277
    const-string v0, "ampAction"

    invoke-virtual {v1, v0, p1}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 278
    const-string v0, "type"

    const-string v2, "In-App"

    invoke-virtual {v1, v0, v2}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 279
    const-string v0, "ampCampaignId"

    iget-object v2, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;

    const-string v3, "campaign_id"

    invoke-virtual {v2, v3}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    const-string v0, "ampCampaign"

    iget-object v2, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;

    const-string v3, "rule_name_non_unique"

    invoke-virtual {v2, v3}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 281
    const-string v0, "Schema Version - Client"

    const-string v2, "3"

    invoke-virtual {v1, v0, v2}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 282
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;

    const-string v2, "schema_version"

    invoke-virtual {v0, v2}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 283
    if-eqz v0, :cond_3

    .line 285
    const-string v2, "Schema Version - Server"

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 288
    :cond_3
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;

    const-string v2, "ab_test"

    invoke-virtual {v0, v2}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 289
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 291
    const-string v2, "ampAB"

    invoke-virtual {v1, v2, v0}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 295
    :cond_4
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mCallbacks:Landroid/util/SparseArray;

    if-eqz v0, :cond_0

    .line 297
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mCallbacks:Landroid/util/SparseArray;

    invoke-virtual {v0, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingCallable;

    .line 298
    if-eqz v0, :cond_5

    .line 300
    new-array v2, v4, [Ljava/lang/Object;

    const-string v3, "ampView"

    aput-object v3, v2, v6

    aput-object v1, v2, v5

    invoke-virtual {v0, v2}, Lcom/localytics/android/MarketingCallable;->call([Ljava/lang/Object;)Ljava/lang/Object;

    .line 303
    :cond_5
    sget-boolean v0, Lcom/localytics/android/Constants;->IS_LOGGING_ENABLED:Z

    if-eqz v0, :cond_0

    .line 305
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 306
    invoke-virtual {v1}, Ljava/util/TreeMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 308
    const-string v1, "Key = "

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, ", Value = "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 310
    :cond_6
    const-string v0, "In-app event tagged successfully.\n   Attributes Dictionary = \n%s"

    new-array v1, v5, [Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v6

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    goto/16 :goto_0
.end method

.method private tagMarketingActionForURL(Ljava/net/URI;)V
    .locals 4

    .prologue
    .line 475
    const-string v0, "ampAction"

    invoke-direct {p0, v0, p1}, Lcom/localytics/android/MarketingDialogFragment;->getValueByQueryKey(Ljava/lang/String;Ljava/net/URI;)Ljava/lang/String;

    move-result-object v0

    .line 476
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 478
    const-string v1, "Attempting to tag event with custom in-app action. [Action: %s]"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 479
    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingDialogFragment;->tagMarketingActionEventWithAction(Ljava/lang/String;)V

    .line 491
    :cond_0
    :goto_0
    return-void

    .line 485
    :cond_1
    invoke-virtual {p1}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    .line 486
    const-string v1, "file"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "http"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "https"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 488
    const-string v0, "click"

    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingDialogFragment;->tagMarketingActionEventWithAction(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method final dismissCampaign()V
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    if-eqz v0, :cond_1

    .line 169
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;

    if-eqz v0, :cond_0

    .line 171
    const-string v0, "X"

    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingDialogFragment;->tagMarketingActionEventWithAction(Ljava/lang/String;)V

    .line 173
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->dismiss()V

    .line 175
    :cond_1
    return-void
.end method

.method final handleUrl(Ljava/lang/String;Landroid/app/Activity;)Z
    .locals 9

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    const/4 v8, 0x2

    .line 407
    .line 409
    const-string v2, "[In-app Nav Handler]: Evaluating in-app URL:\n\tURL:%s"

    new-array v3, v0, [Ljava/lang/Object;

    aput-object p1, v3, v1

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 414
    :try_start_0
    const-string v2, "://"

    invoke-virtual {p1, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 416
    const/4 v2, 0x0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {p1, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    .line 420
    :goto_0
    :try_start_1
    new-instance v2, Ljava/net/URI;

    invoke-direct {v2, v3}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v2}, Lcom/localytics/android/MarketingDialogFragment;->tagMarketingActionForURL(Ljava/net/URI;)V

    .line 426
    new-instance v4, Ljava/net/URL;

    invoke-direct {v4, v3}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 429
    invoke-direct {p0, v4}, Lcom/localytics/android/MarketingDialogFragment;->handleFileProtocolRequest(Ljava/net/URL;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v2

    if-lez v2, :cond_2

    .line 431
    if-ne v2, v8, :cond_1

    .line 462
    :goto_1
    if-ne v2, v8, :cond_0

    .line 464
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->dismissWithAnimation()V

    .line 469
    :cond_0
    :goto_2
    return v0

    :cond_1
    move v0, v1

    .line 431
    goto :goto_1

    .line 435
    :cond_2
    :try_start_2
    invoke-direct {p0, v4, p2}, Lcom/localytics/android/MarketingDialogFragment;->handleHttpProtocolRequest(Ljava/net/URL;Landroid/app/Activity;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result v2

    if-lez v2, :cond_4

    .line 437
    if-ne v2, v8, :cond_3

    .line 462
    :goto_3
    if-ne v2, v8, :cond_0

    .line 464
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->dismissWithAnimation()V

    goto :goto_2

    :cond_3
    move v0, v1

    .line 437
    goto :goto_3

    .line 441
    :cond_4
    :try_start_3
    invoke-direct {p0, v4, p2}, Lcom/localytics/android/MarketingDialogFragment;->handleCustomProtocolRequest(Ljava/net/URL;Landroid/app/Activity;)I
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result v2

    if-lez v2, :cond_6

    .line 443
    if-ne v2, v8, :cond_5

    .line 462
    :goto_4
    if-ne v2, v8, :cond_0

    .line 464
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->dismissWithAnimation()V

    goto :goto_2

    :cond_5
    move v0, v1

    .line 443
    goto :goto_4

    .line 446
    :cond_6
    :try_start_4
    const-string v5, "[In-app Nav Handler]: Protocol handler scheme not recognized. Attempting to load the URL... [Scheme: %s]"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v4}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 462
    if-ne v2, v8, :cond_7

    .line 464
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->dismissWithAnimation()V

    :cond_7
    :goto_5
    move v0, v1

    .line 469
    goto :goto_2

    .line 451
    :catch_0
    move-exception v2

    move v2, v1

    move-object v3, p1

    :goto_6
    :try_start_5
    invoke-direct {p0, v3, p2}, Lcom/localytics/android/MarketingDialogFragment;->handleCustomProtocolRequest(Ljava/lang/String;Landroid/app/Activity;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    move-result v2

    if-lez v2, :cond_9

    .line 453
    if-ne v2, v8, :cond_8

    .line 462
    :goto_7
    if-ne v2, v8, :cond_0

    .line 464
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->dismissWithAnimation()V

    goto :goto_2

    :cond_8
    move v0, v1

    .line 453
    goto :goto_7

    .line 456
    :cond_9
    :try_start_6
    const-string v0, "[In-app Nav Handler]: Invalid url %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 457
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->dismissWithAnimation()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 462
    if-ne v2, v8, :cond_7

    .line 464
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->dismissWithAnimation()V

    goto :goto_5

    .line 462
    :catchall_0
    move-exception v0

    :goto_8
    if-ne v1, v8, :cond_a

    .line 464
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->dismissWithAnimation()V

    :cond_a
    throw v0

    .line 462
    :catchall_1
    move-exception v0

    move v1, v2

    goto :goto_8

    .line 451
    :catch_1
    move-exception v2

    move v2, v1

    goto :goto_6

    :catch_2
    move-exception v4

    goto :goto_6

    :cond_b
    move-object v3, p1

    goto/16 :goto_0
.end method

.method public final onActivityCreated(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 226
    const-string v0, "[InAppDialogFragment]: onActivityCreated"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 227
    invoke-super {p0, p1}, Landroid/support/v4/app/y;->onActivityCreated(Landroid/os/Bundle;)V

    .line 228
    return-void
.end method

.method public final onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 180
    const-string v0, "[InAppDialogFragment]: onAttach"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 181
    invoke-super {p0, p1}, Landroid/support/v4/app/y;->onAttach(Landroid/app/Activity;)V

    .line 182
    return-void
.end method

.method public final onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 194
    const-string v0, "[InAppDialogFragment]: onCreate"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 195
    invoke-super {p0, p1}, Landroid/support/v4/app/y;->onCreate(Landroid/os/Bundle;)V

    .line 196
    return-void
.end method

.method public final onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 3

    .prologue
    .line 201
    const-string v0, "[InAppDialogFragment]: onCreateDialog"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 202
    new-instance v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {p0}, Lcom/localytics/android/MarketingDialogFragment;->getActivity()Landroid/support/v4/app/ac;

    move-result-object v1

    const v2, 0x103000b

    invoke-direct {v0, p0, v1, v2}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;-><init>(Lcom/localytics/android/MarketingDialogFragment;Landroid/content/Context;I)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    return-object v0
.end method

.method public final onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1

    .prologue
    .line 318
    const-string v0, "[InAppDialogFragment]: onCreateView"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 319
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/app/y;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public final onDestroy()V
    .locals 4

    .prologue
    const/4 v2, 0x1

    .line 346
    const-string v0, "[InAppDialogFragment]: onDestroy"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 347
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mCallbacks:Landroid/util/SparseArray;

    if-eqz v0, :cond_0

    .line 349
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mCallbacks:Landroid/util/SparseArray;

    invoke-virtual {v0, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingCallable;

    .line 350
    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v1

    if-nez v1, :cond_0

    if-eqz v0, :cond_0

    .line 352
    new-array v1, v2, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingCallable;->call([Ljava/lang/Object;)Ljava/lang/Object;

    .line 355
    :cond_0
    invoke-super {p0}, Landroid/support/v4/app/y;->onDestroy()V

    .line 356
    return-void
.end method

.method public final onDestroyView()V
    .locals 2

    .prologue
    .line 254
    const-string v0, "[InAppDialogFragment]: onDestroyView"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 255
    invoke-virtual {p0}, Lcom/localytics/android/MarketingDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/localytics/android/MarketingDialogFragment;->getRetainInstance()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 257
    invoke-virtual {p0}, Lcom/localytics/android/MarketingDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 259
    :cond_0
    invoke-super {p0}, Landroid/support/v4/app/y;->onDestroyView()V

    .line 260
    return-void
.end method

.method public final onDetach()V
    .locals 1

    .prologue
    .line 187
    const-string v0, "[InAppDialogFragment]: onDetach"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 188
    invoke-super {p0}, Landroid/support/v4/app/y;->onDetach()V

    .line 189
    return-void
.end method

.method public final onDismiss(Landroid/content/DialogInterface;)V
    .locals 2

    .prologue
    .line 208
    const-string v0, "[InAppDialogFragment]: onDismiss"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 211
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;

    if-eqz v0, :cond_0

    .line 213
    const-string v0, "X"

    invoke-direct {p0, v0}, Lcom/localytics/android/MarketingDialogFragment;->tagMarketingActionEventWithAction(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 220
    :cond_0
    :goto_0
    invoke-super {p0, p1}, Landroid/support/v4/app/y;->onDismiss(Landroid/content/DialogInterface;)V

    .line 221
    return-void

    .line 216
    :catch_0
    move-exception v0

    .line 218
    const-string v1, "MarketingDialogFragment onDismiss"

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics$Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public final onPause()V
    .locals 1

    .prologue
    .line 339
    const-string v0, "[InAppDialogFragment]: onPause"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 340
    invoke-super {p0}, Landroid/support/v4/app/y;->onPause()V

    .line 341
    return-void
.end method

.method public final onResume()V
    .locals 1

    .prologue
    .line 332
    const-string v0, "[InAppDialogFragment]: onResume"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 333
    invoke-super {p0}, Landroid/support/v4/app/y;->onResume()V

    .line 334
    return-void
.end method

.method public final onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 240
    const-string v0, "[InAppDialogFragment]: onSaveInstanceState"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 241
    invoke-super {p0, p1}, Landroid/support/v4/app/y;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 242
    return-void
.end method

.method public final onStart()V
    .locals 1

    .prologue
    .line 233
    const-string v0, "[InAppDialogFragment]: onStart"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 234
    invoke-super {p0}, Landroid/support/v4/app/y;->onStart()V

    .line 235
    return-void
.end method

.method public final onStop()V
    .locals 1

    .prologue
    .line 247
    const-string v0, "[InAppDialogFragment]: onStop"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 248
    invoke-super {p0}, Landroid/support/v4/app/y;->onStop()V

    .line 249
    return-void
.end method

.method public final onViewStateRestored(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 325
    const-string v0, "[InAppDialogFragment]: onViewStateRestored"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 326
    invoke-super {p0, p1}, Landroid/support/v4/app/y;->onViewStateRestored(Landroid/os/Bundle;)V

    .line 327
    return-void
.end method

.method public final setCallbacks(Landroid/util/SparseArray;)Lcom/localytics/android/MarketingDialogFragment;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/SparseArray",
            "<",
            "Lcom/localytics/android/MarketingCallable;",
            ">;)",
            "Lcom/localytics/android/MarketingDialogFragment;"
        }
    .end annotation

    .prologue
    .line 602
    iput-object p1, p0, Lcom/localytics/android/MarketingDialogFragment;->mCallbacks:Landroid/util/SparseArray;

    .line 603
    return-object p0
.end method

.method final setData(Lcom/localytics/android/MarketingMessage;)Lcom/localytics/android/MarketingDialogFragment;
    .locals 0

    .prologue
    .line 360
    iput-object p1, p0, Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;

    .line 361
    return-object p0
.end method

.method final setJavaScriptClient(Lcom/localytics/android/JavaScriptClient;)Lcom/localytics/android/MarketingDialogFragment;
    .locals 3

    .prologue
    .line 366
    iput-object p1, p0, Lcom/localytics/android/MarketingDialogFragment;->mJavaScriptClient:Lcom/localytics/android/JavaScriptClient;

    .line 367
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment;->mJavaScriptClient:Lcom/localytics/android/JavaScriptClient;

    invoke-virtual {v0}, Lcom/localytics/android/JavaScriptClient;->getCallbacks()Landroid/util/SparseArray;

    move-result-object v0

    .line 369
    const/16 v1, 0xf

    new-instance v2, Lcom/localytics/android/MarketingDialogFragment$1;

    invoke-direct {v2, p0}, Lcom/localytics/android/MarketingDialogFragment$1;-><init>(Lcom/localytics/android/MarketingDialogFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 391
    const/4 v1, 0x4

    new-instance v2, Lcom/localytics/android/MarketingDialogFragment$2;

    invoke-direct {v2, p0}, Lcom/localytics/android/MarketingDialogFragment$2;-><init>(Lcom/localytics/android/MarketingDialogFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 402
    return-object p0
.end method
