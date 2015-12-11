.class public Lcom/comcast/playerplatform/drm/java/service/LicenseService;
.super Ljava/lang/Object;
.source "LicenseService.java"


# instance fields
.field private authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

.field private clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

.field private context:Landroid/content/Context;

.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 1
    .param p1, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    .line 40
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;-><init>(Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 41
    return-void
.end method

.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 1
    .param p1, "authDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    .line 53
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2, p3}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;-><init>(Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 54
    return-void
.end method

.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 1
    .param p1, "authDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;
    .param p2, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    if-nez p2, :cond_0

    .line 67
    new-instance v0, Lcom/comcast/playerplatform/drm/java/client/ClientState;

    invoke-direct {v0}, Lcom/comcast/playerplatform/drm/java/client/ClientState;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    .line 70
    :cond_0
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    .line 72
    iput-object p3, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->context:Landroid/content/Context;

    .line 73
    iput-object p4, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 74
    return-void
.end method


# virtual methods
.method public acquireLicenseForOfflinePlayback(Ljava/lang/String;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;)V
    .locals 6
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "eventListener"    # Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .prologue
    .line 83
    const-string v2, ""

    const/4 v3, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v4, p2

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->acquireLicenseForOfflinePlayback(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 84
    return-void
.end method

.method public acquireLicenseForOfflinePlayback(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;)V
    .locals 6
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "drmKey"    # Ljava/lang/String;
    .param p3, "isAMS"    # Z
    .param p4, "eventListener"    # Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .prologue
    .line 104
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->acquireLicenseForOfflinePlayback(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 105
    return-void
.end method

.method public acquireLicenseForOfflinePlayback(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 8
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "drmKey"    # Ljava/lang/String;
    .param p3, "isAMS"    # Z
    .param p4, "eventListener"    # Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    .param p5, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 114
    const/4 v0, 0x0

    .line 115
    .local v0, "drmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
    invoke-static {p2}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 116
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmOfflineWorkflow;

    .end local v0    # "drmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->context:Landroid/content/Context;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    const/4 v6, 0x1

    move-object v5, p2

    move-object v7, p5

    invoke-direct/range {v0 .. v7}, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmOfflineWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Ljava/lang/String;ZLcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 120
    .restart local v0    # "drmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
    :goto_0
    invoke-virtual {v0, p4}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->addEventListener(Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;)V

    .line 121
    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->attachAsset(Ljava/lang/String;)V

    .line 122
    return-void

    .line 118
    :cond_0
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;

    .end local v0    # "drmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->context:Landroid/content/Context;

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Landroid/content/Context;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .restart local v0    # "drmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
    goto :goto_0
.end method

.method public acquireLicenseForStreaming(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;Lcom/adobe/ave/drm/DRMMetadata;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 8
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "drmKey"    # Ljava/lang/String;
    .param p3, "isAMS"    # Z
    .param p4, "eventListener"    # Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    .param p5, "metadata"    # Lcom/adobe/ave/drm/DRMMetadata;
    .param p6, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 230
    const/4 v0, 0x0

    .line 231
    .local v0, "drmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
    invoke-static {p2}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 232
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmStreamingWorkflow;

    .end local v0    # "drmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->context:Landroid/content/Context;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    move-object v5, p2

    move-object v7, p6

    invoke-direct/range {v0 .. v7}, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmStreamingWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Ljava/lang/String;Ljava/lang/Boolean;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 237
    .restart local v0    # "drmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
    :goto_0
    invoke-virtual {v0, p4}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->addEventListener(Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;)V

    .line 238
    invoke-virtual {v0, p1, p5}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->attachAsset(Ljava/lang/String;Lcom/adobe/ave/drm/DRMMetadata;)V

    .line 239
    return-void

    .line 234
    :cond_0
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/StreamingDrmWorkflow;

    .end local v0    # "drmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->context:Landroid/content/Context;

    move-object v5, p6

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/drm/java/service/workflow/StreamingDrmWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Landroid/content/Context;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .restart local v0    # "drmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
    goto :goto_0
.end method

.method public acquireLicenseForWhitelist(Ljava/lang/String;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 1
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "eventListener"    # Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    .param p3, "metadata"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 172
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->acquireLicenseForWhitelist(Ljava/lang/String;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;Lcom/adobe/ave/drm/DRMMetadata;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 173
    return-void
.end method

.method public acquireLicenseForWhitelist(Ljava/lang/String;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;Lcom/adobe/ave/drm/DRMMetadata;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 6
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "eventListener"    # Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
    .param p3, "metadata"    # Lcom/adobe/ave/drm/DRMMetadata;
    .param p4, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 181
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/WhitelistDrmWorkflow;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->context:Landroid/content/Context;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/drm/java/service/workflow/WhitelistDrmWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 182
    .local v0, "whitelistDrmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/WhitelistDrmWorkflow;
    invoke-virtual {v0, p2}, Lcom/comcast/playerplatform/drm/java/service/workflow/WhitelistDrmWorkflow;->addEventListener(Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;)V

    .line 183
    invoke-virtual {v0, p1, p3}, Lcom/comcast/playerplatform/drm/java/service/workflow/WhitelistDrmWorkflow;->attachAsset(Ljava/lang/String;Lcom/adobe/ave/drm/DRMMetadata;)V

    .line 184
    return-void
.end method

.method public acquireLocalLicense(Ljava/lang/String;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;)V
    .locals 5
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "eventListener"    # Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .prologue
    .line 247
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/workflow/LocalDrmWorkflow;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->context:Landroid/content/Context;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/comcast/playerplatform/drm/java/service/workflow/LocalDrmWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Landroid/content/Context;)V

    .line 248
    .local v0, "localDrmWorkflow":Lcom/comcast/playerplatform/drm/java/service/workflow/LocalDrmWorkflow;
    invoke-virtual {v0, p2}, Lcom/comcast/playerplatform/drm/java/service/workflow/LocalDrmWorkflow;->addEventListener(Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;)V

    .line 249
    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/drm/java/service/workflow/LocalDrmWorkflow;->attachAsset(Ljava/lang/String;)V

    .line 250
    return-void
.end method
