.class public Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"

# interfaces
.implements Lahx;
.implements Lcom/inc247/ChatSDKEventsListener;
.implements Lqo;
.implements Lqp;


# static fields
.field public static a:Z

.field private static h:Lcom/inc247/ChatSDK;

.field private static i:Lorg/json/JSONObject;

.field private static j:Lorg/json/JSONObject;

.field private static k:I


# instance fields
.field private A:Landroid/view/View$OnClickListener;

.field private B:Landroid/view/View$OnClickListener;

.field private C:Landroid/view/View$OnClickListener;

.field private b:Ljava/lang/String;

.field private c:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

.field private d:Lbp;

.field private e:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private f:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private g:Landroid/widget/ImageView;

.field private l:Z

.field private m:[Ljava/lang/String;

.field private n:[Ljava/lang/String;

.field private o:Landroid/view/View;

.field private p:Landroid/widget/Switch;

.field private q:Z

.field private r:Z

.field private s:Lqm;

.field private t:Landroid/view/View;

.field private u:Landroid/widget/ProgressBar;

.field private v:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field

.field private w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private x:Ljava/lang/String;

.field private y:Z

.field private z:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 81
    const/4 v0, 0x0

    sput-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->j:Lorg/json/JSONObject;

    .line 84
    sput v1, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->k:I

    .line 85
    sput-boolean v1, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 69
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 73
    const-class v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->b:Ljava/lang/String;

    .line 76
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->e:Ljava/util/ArrayList;

    .line 77
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->f:Ljava/util/ArrayList;

    .line 86
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->l:Z

    .line 90
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->q:Z

    .line 91
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->r:Z

    .line 95
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->v:Ljava/util/ArrayList;

    .line 97
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->x:Ljava/lang/String;

    .line 98
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->y:Z

    .line 99
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->z:Z

    .line 101
    new-instance v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;-><init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->A:Landroid/view/View$OnClickListener;

    .line 134
    new-instance v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$2;-><init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->B:Landroid/view/View$OnClickListener;

    .line 157
    new-instance v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$3;-><init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->C:Landroid/view/View$OnClickListener;

    .line 509
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->b(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)Z
    .locals 1

    .prologue
    .line 69
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->l:Z

    return v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;Z)Z
    .locals 0

    .prologue
    .line 69
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->y:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->u:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method private b(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 414
    invoke-static {p0}, Lcom/inc247/ApplicationStatusModel/Utils;->isOnline(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 416
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    sput-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->j:Lorg/json/JSONObject;

    .line 418
    :try_start_0
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->j:Lorg/json/JSONObject;

    const-string v1, "queueId"

    invoke-virtual {v0, v1, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 426
    :goto_0
    const/4 v0, 0x1

    invoke-static {v0}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->setChatRunning(Z)V

    .line 436
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->h:Lcom/inc247/ChatSDK;

    sget-object v1, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->i:Lorg/json/JSONObject;

    sget-object v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->j:Lorg/json/JSONObject;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, p0, v2, v3}, Lcom/inc247/ChatSDK;->startChat(Lorg/json/JSONObject;Landroid/app/Activity;Lorg/json/JSONObject;Z)V

    .line 446
    :goto_1
    return-void

    .line 419
    :catch_0
    move-exception v0

    .line 420
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 442
    :cond_0
    invoke-static {p0}, Lcom/inc247/constants/CheckInternetConnection;->ShowInternetConnectionLossAlert(Landroid/content/Context;)V

    goto :goto_1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;Z)Z
    .locals 0

    .prologue
    .line 69
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->z:Z

    return p1
.end method

.method static synthetic c()Lcom/inc247/ChatSDK;
    .locals 1

    .prologue
    .line 69
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->h:Lcom/inc247/ChatSDK;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->x:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d()I
    .locals 1

    .prologue
    .line 69
    sget v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->k:I

    return v0
.end method

.method static synthetic e()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 69
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->i:Lorg/json/JSONObject;

    return-object v0
.end method

.method static synthetic f()Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
    .locals 1

    .prologue
    .line 69
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->baseFragmentActivity:Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    return-object v0
.end method

.method static synthetic g()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 69
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->j:Lorg/json/JSONObject;

    return-object v0
.end method

.method private h()V
    .locals 3

    .prologue
    .line 383
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    sput-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->j:Lorg/json/JSONObject;

    .line 385
    :try_start_0
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->j:Lorg/json/JSONObject;

    const-string v1, "queueId"

    const-string v2, "bestbuy-App-Sales"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 390
    :goto_0
    invoke-static {p0}, Lcom/inc247/ChatSDK;->initializeChat(Landroid/app/Activity;)Lcom/inc247/ChatSDK;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->h:Lcom/inc247/ChatSDK;

    .line 391
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->h:Lcom/inc247/ChatSDK;

    iput-object p0, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 392
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->h:Lcom/inc247/ChatSDK;

    invoke-virtual {v0, p0}, Lcom/inc247/ChatSDK;->setChatEventsListener(Lcom/inc247/ChatSDKEventsListener;)V

    .line 393
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->h:Lcom/inc247/ChatSDK;

    sget-object v1, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->j:Lorg/json/JSONObject;

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDK;->getQueueId(Lorg/json/JSONObject;)V

    .line 399
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->h:Lcom/inc247/ChatSDK;

    invoke-virtual {v0}, Lcom/inc247/ChatSDK;->getQueueIdParameters()V

    .line 401
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    sput-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->i:Lorg/json/JSONObject;

    .line 404
    :try_start_1
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->i:Lorg/json/JSONObject;

    const-string v1, "username"

    const-string v2, "Test Account"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 405
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->i:Lorg/json/JSONObject;

    const-string v1, "email"

    const-string v2, "Testing"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 406
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->i:Lorg/json/JSONObject;

    const-string v1, "accountnumber"

    const-string v2, "Sample Testing"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 411
    :goto_1
    return-void

    .line 386
    :catch_0
    move-exception v0

    .line 387
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 408
    :catch_1
    move-exception v0

    .line 409
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method private i()Z
    .locals 2

    .prologue
    .line 504
    const-string v0, "location"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 505
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public a()Landroid/view/View$OnClickListener;
    .locals 1

    .prologue
    .line 449
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->A:Landroid/view/View$OnClickListener;

    return-object v0
.end method

.method public a(Ljava/lang/String;)Landroid/view/View$OnClickListener;
    .locals 1

    .prologue
    .line 457
    iput-object p1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->x:Ljava/lang/String;

    .line 458
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->B:Landroid/view/View$OnClickListener;

    return-object v0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;)V
    .locals 7

    .prologue
    .line 631
    if-eqz p1, :cond_1

    .line 632
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->isChat()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->r:Z

    .line 633
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->isBookABlueShirt()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->q:Z

    .line 634
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->isChat()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->r:Z

    .line 635
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->r:Z

    if-eqz v0, :cond_0

    .line 637
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    if-nez v0, :cond_0

    .line 638
    invoke-direct {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->h()V

    .line 641
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->q:Z

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->getBookABlueShirtStores()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 642
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->v:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->getBookABlueShirtStores()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 644
    :try_start_0
    const-string v0, "blueassist_storelist"

    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->v:Ljava/util/ArrayList;

    invoke-static {p0, v0, v1}, Lnj;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 650
    :cond_1
    :goto_0
    new-instance v0, Lbp;

    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget-object v3, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->e:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->f:Ljava/util/ArrayList;

    iget-boolean v5, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->r:Z

    iget-boolean v6, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->q:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v6}, Lbp;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;ZZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->d:Lbp;

    .line 651
    new-instance v0, Lfd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->d:Lbp;

    invoke-direct {v0, v1}, Lfd;-><init>(Landroid/widget/ExpandableListAdapter;)V

    .line 652
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->o:Landroid/view/View;

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->addFooterView(Landroid/view/View;)V

    .line 653
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->setAdapter(Lfd;)V

    .line 654
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->expandGroup(I)Z

    .line 655
    return-void

    .line 645
    :catch_0
    move-exception v0

    .line 646
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public b()Landroid/view/View$OnClickListener;
    .locals 1

    .prologue
    .line 453
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->C:Landroid/view/View$OnClickListener;

    return-object v0
.end method

.method public onAgentMessage(Lorg/json/JSONObject;)V
    .locals 1

    .prologue
    .line 323
    sget-boolean v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a:Z

    if-eqz v0, :cond_0

    .line 325
    sget v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->k:I

    .line 326
    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->c()V

    .line 328
    :cond_0
    return-void
.end method

.method public onChatAgentAvailability(Z)V
    .locals 0

    .prologue
    .line 318
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->l:Z

    .line 319
    return-void
.end method

.method public onChatEnded(Lorg/json/JSONObject;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 293
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->y:Z

    .line 294
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->z:Z

    .line 295
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "shake_your_device"

    const-string v2, "Off"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 297
    const-string v1, "On"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 299
    invoke-static {}, Lcom/bestbuy/android/base/BBYApplication;->getInstance()Lcom/bestbuy/android/base/BBYApplication;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYApplication;->registerSensor()V

    .line 302
    :cond_0
    sput-boolean v3, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a:Z

    .line 303
    sput v3, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->k:I

    .line 305
    invoke-static {p0}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    new-instance v1, Landroid/content/Intent;

    const-string v2, "chatstatus"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    .line 307
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->stopService(Landroid/content/Intent;)Z

    .line 308
    sget-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->baseFragmentActivity:Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->reEnablePullDown()V

    .line 310
    const/4 v0, 0x0

    sput-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->h:Lcom/inc247/ChatSDK;

    .line 311
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->finish()V

    .line 312
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->overridePendingTransition(II)V

    .line 313
    return-void
.end method

.method public onChatError(Lcom/inc247/errors/ChatSDKError;)V
    .locals 3

    .prologue
    .line 369
    const-string v0, "OnChatError:"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Inside function onChatError "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/inc247/errors/ChatSDKError;->getErrorMsg()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 370
    return-void
.end method

.method public onChatMaximized(Lorg/json/JSONObject;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 348
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->u:Landroid/widget/ProgressBar;

    invoke-virtual {v0}, Landroid/widget/ProgressBar;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 349
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->u:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 351
    :cond_0
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "shake_your_device"

    const-string v2, "Off"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 353
    const-string v1, "On"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 355
    invoke-static {}, Lcom/bestbuy/android/base/BBYApplication;->getInstance()Lcom/bestbuy/android/base/BBYApplication;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYApplication;->registerSensor()V

    .line 358
    :cond_1
    sput-boolean v3, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a:Z

    .line 359
    sput v3, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->k:I

    .line 360
    return-void
.end method

.method public onChatMinimized(Lorg/json/JSONObject;)V
    .locals 3

    .prologue
    .line 332
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "shake_your_device"

    const-string v2, "Off"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 334
    const-string v1, "On"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 336
    invoke-static {}, Lcom/bestbuy/android/base/BBYApplication;->getInstance()Lcom/bestbuy/android/base/BBYApplication;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYApplication;->unRegisterSensor()V

    .line 339
    :cond_0
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a:Z

    .line 340
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 342
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->finish()V

    .line 343
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->overridePendingTransition(II)V

    .line 344
    return-void
.end method

.method public onChatStarted(Lorg/json/JSONObject;)V
    .locals 4

    .prologue
    .line 278
    invoke-static {p0}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    new-instance v1, Landroid/content/Intent;

    const-string v2, "chatstatus"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    .line 280
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 281
    const-string v1, "bb.liveChat"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 282
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->y:Z

    if-eqz v1, :cond_1

    .line 283
    const-string v1, "bb.prevPageLink"

    sget-object v2, Llu;->aV:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 284
    sget-object v1, Llu;->aX:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 289
    :cond_0
    :goto_0
    return-void

    .line 285
    :cond_1
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->z:Z

    if-eqz v1, :cond_0

    .line 286
    const-string v1, "bb.prevPageLink"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Llu;->aZ:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ": All Other Categories"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 287
    sget-object v1, Llu;->ba:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 495
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->s:Lqm;

    sget-object v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->REQUEST:Lcom/google/android/gms/location/LocationRequest;

    invoke-interface {v0, v1, v2, p0}, Lahr;->a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;

    .line 496
    return-void
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 7

    .prologue
    .line 476
    invoke-virtual {p1}, Lpp;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 478
    const/16 v0, 0x2328

    :try_start_0
    invoke-virtual {p1, p0, v0}, Lpp;->a(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 485
    :goto_0
    new-instance v0, Lbp;

    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget-object v3, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->e:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->f:Ljava/util/ArrayList;

    iget-boolean v5, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->r:Z

    iget-boolean v6, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->q:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v6}, Lbp;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;ZZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->d:Lbp;

    .line 486
    new-instance v0, Lfd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->d:Lbp;

    invoke-direct {v0, v1}, Lfd;-><init>(Landroid/widget/ExpandableListAdapter;)V

    .line 487
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->o:Landroid/view/View;

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->addFooterView(Landroid/view/View;)V

    .line 488
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->setAdapter(Lfd;)V

    .line 489
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->expandGroup(I)Z

    .line 490
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->t:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 491
    return-void

    .line 479
    :catch_0
    move-exception v0

    .line 480
    invoke-virtual {v0}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    goto :goto_0

    .line 483
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->b:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services connection failed with code "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lpp;->c()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onConnectionSuspended(I)V
    .locals 3

    .prologue
    .line 500
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->b:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services suspended cause:  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 501
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 8

    .prologue
    const/4 v1, 0x1

    const/4 v7, 0x0

    const/4 v2, 0x0

    .line 192
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 193
    const v0, 0x7f030045

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->setContentView(I)V

    .line 194
    const v0, 0x7f0c0111

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->u:Landroid/widget/ProgressBar;

    .line 195
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->appData:Lnb;

    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->appData:Lnb;

    invoke-virtual {v0, v1}, Lnb;->i(Z)V

    .line 197
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 198
    const v0, 0x7f0c0064

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->t:Landroid/view/View;

    .line 199
    const v0, 0x7f0c0110

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    .line 200
    const v0, 0x7f0c0067

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->g:Landroid/widget/ImageView;

    .line 201
    const v0, 0x7f0c010e

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 202
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080389

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 205
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f0a0002

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->n:[Ljava/lang/String;

    .line 206
    new-instance v0, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->n:[Ljava/lang/String;

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->e:Ljava/util/ArrayList;

    .line 207
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f0a0001

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->m:[Ljava/lang/String;

    .line 208
    new-instance v0, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->m:[Ljava/lang/String;

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->f:Ljava/util/ArrayList;

    .line 210
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v3, 0x7f0300ee

    invoke-virtual {v0, v3, v2, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->o:Landroid/view/View;

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->o:Landroid/view/View;

    const v3, 0x7f0c03b1

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Switch;

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->p:Landroid/widget/Switch;

    .line 214
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v3, "shake_your_device"

    const-string v4, "Off"

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 215
    const-string v3, "On"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    move v0, v1

    .line 216
    :goto_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->p:Landroid/widget/Switch;

    invoke-virtual {v1, v0}, Landroid/widget/Switch;->setChecked(Z)V

    .line 218
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lnb;->k:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 219
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lnb;->k:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 220
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    sget-object v3, Lnb;->l:Ljava/lang/String;

    invoke-virtual {v1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    .line 221
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 223
    sget-object v3, Lnb;->m:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 224
    const-string v0, "bb.prevPageLink"

    const-string v3, "More: Blue Assist"

    invoke-virtual {v1, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 225
    sget-object v0, Llu;->bo:Ljava/lang/String;

    const-string v3, "browse,service"

    invoke-virtual {v1, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 226
    sget-object v0, Llu;->bp:Ljava/lang/String;

    const-string v3, "BLUEA"

    invoke-virtual {v1, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 230
    :cond_0
    :goto_1
    sget-object v0, Llu;->aT:Ljava/lang/String;

    invoke-static {v0, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 233
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->p:Landroid/widget/Switch;

    new-instance v1, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$4;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$4;-><init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 243
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->g:Landroid/widget/ImageView;

    new-instance v1, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$5;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$5;-><init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 253
    invoke-direct {p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->i()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 254
    new-instance v0, Lqn;

    invoke-direct {v0, p0}, Lqn;-><init>(Landroid/content/Context;)V

    sget-object v1, Lahy;->a:Lpx;

    invoke-virtual {v0, v1}, Lqn;->a(Lpx;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqo;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqp;)Lqn;

    move-result-object v0

    invoke-virtual {v0}, Lqn;->b()Lqm;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->s:Lqm;

    .line 259
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->s:Lqm;

    invoke-interface {v0}, Lqm;->b()V

    .line 260
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->t:Landroid/view/View;

    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    .line 265
    :goto_2
    return-void

    :cond_2
    move v0, v7

    .line 215
    goto/16 :goto_0

    .line 227
    :cond_3
    sget-object v3, Lnb;->n:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 228
    const-string v0, "bb.prevPageLink"

    const-string v3, "Shake: Blue Assist"

    invoke-virtual {v1, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 262
    :cond_4
    new-instance v0, Lhx;

    iget-object v3, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->t:Landroid/view/View;

    move-object v1, p0

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    invoke-direct/range {v0 .. v6}, Lhx;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhx;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_2
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 269
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onDestroy()V

    .line 270
    sget-boolean v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a:Z

    if-nez v0, :cond_0

    .line 271
    const/4 v0, 0x0

    sput-object v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->h:Lcom/inc247/ChatSDK;

    .line 273
    :cond_0
    return-void
.end method

.method public onLocationChanged(Landroid/location/Location;)V
    .locals 8

    .prologue
    const/4 v2, 0x0

    .line 463
    if-eqz p1, :cond_1

    .line 465
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->appData:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Lnb;->a(D)V

    .line 466
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->appData:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Lnb;->b(D)V

    .line 467
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->s:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 468
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->s:Lqm;

    invoke-interface {v0, v1, p0}, Lahr;->a(Lqm;Lahx;)Lqq;

    .line 470
    :cond_0
    new-instance v0, Lhx;

    iget-object v3, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->t:Landroid/view/View;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v6

    invoke-virtual {v1, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object v1, p0

    move-object v6, v2

    invoke-direct/range {v0 .. v6}, Lhx;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhx;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 472
    :cond_1
    return-void
.end method

.method public onNavigationRequest(Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 364
    const-string v0, "onNavigationRequest:"

    const-string v1, "Inside function onNavigationRequest "

    invoke-static {v0, v1}, Lkf;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 365
    return-void
.end method

.method public onQueueIdParamRetrievalFinished()V
    .locals 0

    .prologue
    .line 380
    return-void
.end method

.method public onQueueIdParamRetrievalStarted()V
    .locals 0

    .prologue
    .line 375
    return-void
.end method
