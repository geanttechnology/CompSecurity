.class public Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;
.super Ljava/lang/Object;
.source "RetailSearchInitSettings.java"


# instance fields
.field private appVersion:Ljava/lang/String;

.field private debugMode:Z

.field private deviceId:Ljava/lang/String;

.field private featureConfiguration:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

.field private userAgent:Ljava/lang/String;

.field private weblabClient:Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->appVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->deviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getFeatureConfiguration()Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->featureConfiguration:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    return-object v0
.end method

.method public getUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method public getWeblabClient()Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->weblabClient:Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;

    return-object v0
.end method

.method public isDebugMode()Z
    .locals 1

    .prologue
    .line 20
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->debugMode:Z

    return v0
.end method

.method public setAppVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "appVersion"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->appVersion:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public setDebugMode(Z)V
    .locals 0
    .param p1, "debugMode"    # Z

    .prologue
    .line 25
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->debugMode:Z

    .line 26
    return-void
.end method

.method public setDeviceId(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceId"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->deviceId:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setFeatureConfiguration(Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;)V
    .locals 0
    .param p1, "featureConfiguration"    # Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->featureConfiguration:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    .line 46
    return-void
.end method

.method public setUserAgent(Ljava/lang/String;)V
    .locals 0
    .param p1, "userAgent"    # Ljava/lang/String;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->userAgent:Ljava/lang/String;

    .line 66
    return-void
.end method

.method public setWeblabClient(Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;)V
    .locals 0
    .param p1, "weblabClient"    # Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->weblabClient:Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;

    .line 56
    return-void
.end method
