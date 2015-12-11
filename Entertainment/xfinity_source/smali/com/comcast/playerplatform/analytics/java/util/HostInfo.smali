.class public Lcom/comcast/playerplatform/analytics/java/util/HostInfo;
.super Ljava/lang/Object;
.source "HostInfo.java"


# instance fields
.field private accountId:Ljava/lang/String;

.field private final applicationName:Ljava/lang/String;

.field private final applicationVersion:Ljava/lang/String;

.field private final deviceId:Ljava/lang/String;

.field private final deviceName:Ljava/lang/String;

.field private final deviceVersion:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "applicationName"    # Ljava/lang/String;
    .param p2, "applicationVersion"    # Ljava/lang/String;
    .param p3, "deviceId"    # Ljava/lang/String;
    .param p4, "deviceName"    # Ljava/lang/String;
    .param p5, "deviceVersion"    # Ljava/lang/String;

    .prologue
    .line 29
    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v6}, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "applicationName"    # Ljava/lang/String;
    .param p2, "applicationVersion"    # Ljava/lang/String;
    .param p3, "deviceId"    # Ljava/lang/String;
    .param p4, "deviceName"    # Ljava/lang/String;
    .param p5, "deviceVersion"    # Ljava/lang/String;
    .param p6, "accountId"    # Ljava/lang/String;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->applicationName:Ljava/lang/String;

    .line 34
    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->applicationVersion:Ljava/lang/String;

    .line 35
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->deviceId:Ljava/lang/String;

    .line 36
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->deviceName:Ljava/lang/String;

    .line 37
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->deviceVersion:Ljava/lang/String;

    .line 38
    iput-object p6, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->accountId:Ljava/lang/String;

    .line 39
    return-void
.end method


# virtual methods
.method public getAccountId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->accountId:Ljava/lang/String;

    return-object v0
.end method

.method public getApplicationName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->applicationName:Ljava/lang/String;

    return-object v0
.end method

.method public getApplicationVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->applicationVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->deviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->deviceName:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->deviceVersion:Ljava/lang/String;

    return-object v0
.end method

.method public setAccountId(Ljava/lang/String;)V
    .locals 0
    .param p1, "accountId"    # Ljava/lang/String;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->accountId:Ljava/lang/String;

    .line 67
    return-void
.end method
