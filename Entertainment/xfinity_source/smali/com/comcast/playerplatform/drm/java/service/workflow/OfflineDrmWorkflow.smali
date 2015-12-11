.class public Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;
.super Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;
.source "OfflineDrmWorkflow.java"


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Landroid/content/Context;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 6
    .param p1, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .param p2, "authenticationDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;
    .param p3, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p4, "context"    # Landroid/content/Context;
    .param p5, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 21
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p4

    move-object v4, p3

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 22
    sget-object v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->FORCE_REFRESH:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->licenseSettings:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    .line 23
    return-void
.end method


# virtual methods
.method public validate()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 28
    invoke-virtual {p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->getXsctToken()Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v1

    .line 30
    .local v1, "securityToken":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->isValid()Z

    move-result v3

    if-nez v3, :cond_1

    :cond_0
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->requestLicenseAnonymously:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 31
    :cond_1
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->requestLicenseAnonymously:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_2

    const/4 v2, 0x0

    .line 32
    .local v2, "securityTokenString":Ljava/lang/String;
    :goto_0
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->requestLicenseAnonymously:Ljava/lang/Boolean;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->messageId:Ljava/lang/String;

    invoke-static {v3, v2, v4, v5, v5}, Lcom/comcast/playerplatform/drm/java/util/DrmUtil;->generateDrmKeyString(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;

    move-result-object v0

    .line 34
    .local v0, "drmKey":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->acquireVoucher(Ljava/lang/String;)V

    .line 41
    .end local v0    # "drmKey":Ljava/lang/String;
    .end local v2    # "securityTokenString":Ljava/lang/String;
    :goto_1
    return-void

    .line 31
    :cond_2
    invoke-virtual {v1}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->getToken()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 35
    :cond_3
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->hasRenewedSession:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_4

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    if-nez v3, :cond_4

    .line 36
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->hasRenewedSession:Ljava/lang/Boolean;

    .line 37
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->sessionService:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->create()V

    goto :goto_1

    .line 39
    :cond_4
    invoke-virtual {p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/OfflineDrmWorkflow;->renewXsctToken()V

    goto :goto_1
.end method
