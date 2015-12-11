.class public Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;
.super Ljava/lang/Object;
.source "AlertZipCodeManager.java"


# instance fields
.field private fipsCode:Ljava/lang/String;

.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

.field private retryAttempt:I

.field private retryInterval:I

.field private zipResponseReceived:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

.field private zipsToFipsUri:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const/16 v0, 0x3e8

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->retryInterval:I

    .line 22
    const/4 v0, 0x1

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->retryAttempt:I

    .line 25
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$1;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->zipResponseReceived:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    .line 53
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->fipsCode:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$002(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->fipsCode:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    return-object v0
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->zipsToFipsUri:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->retryFips()V

    return-void
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->getFipsCode()V

    return-void
.end method

.method static synthetic access$508(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)I
    .locals 2
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    .prologue
    .line 20
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->retryAttempt:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->retryAttempt:I

    return v0
.end method

.method private getFipsCode()V
    .locals 9

    .prologue
    const/4 v4, 0x0

    .line 64
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v8

    new-instance v0, Lcom/comcast/playerplatform/util/android/XrestHelper;

    const-string v1, ""

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->zipsToFipsUri:Ljava/lang/String;

    const-string v3, "GET"

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->zipResponseReceived:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-object v7, v4

    invoke-direct/range {v0 .. v7}, Lcom/comcast/playerplatform/util/android/XrestHelper;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    invoke-virtual {v8, v0}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    .line 65
    return-void
.end method

.method private retryFips()V
    .locals 8

    .prologue
    .line 75
    iget v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->retryInterval:I

    int-to-double v2, v1

    const-wide/high16 v4, 0x4000000000000000L    # 2.0

    iget v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->retryAttempt:I

    int-to-double v6, v1

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v4

    mul-double/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    .line 77
    .local v0, "interval":Ljava/lang/Double;
    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    new-instance v2, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$2;

    invoke-direct {v2, p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$2;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)V

    invoke-virtual {v0}, Ljava/lang/Double;->intValue()I

    move-result v3

    int-to-long v4, v3

    invoke-virtual {v1, v2, v4, v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 85
    return-void
.end method


# virtual methods
.method public setAlertListener(Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    .line 89
    return-void
.end method
