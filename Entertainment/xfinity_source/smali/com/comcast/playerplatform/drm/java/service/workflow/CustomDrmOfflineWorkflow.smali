.class public Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmOfflineWorkflow;
.super Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;
.source "CustomDrmOfflineWorkflow.java"


# instance fields
.field private isAms:Z

.field public token:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Ljava/lang/String;ZLcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 6
    .param p1, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .param p2, "authenticationDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p5, "token"    # Ljava/lang/String;
    .param p6, "isAms"    # Z
    .param p7, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 24
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p7

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractOfflineDrmWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 25
    iput-object p5, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmOfflineWorkflow;->token:Ljava/lang/String;

    .line 26
    sget-object v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->FORCE_REFRESH:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmOfflineWorkflow;->licenseSettings:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    .line 27
    iput-boolean p6, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmOfflineWorkflow;->isAms:Z

    .line 29
    return-void
.end method


# virtual methods
.method public validate()V
    .locals 5

    .prologue
    const/4 v1, 0x1

    .line 33
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmOfflineWorkflow;->requestLicenseAnonymously:Ljava/lang/Boolean;

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmOfflineWorkflow;->token:Ljava/lang/String;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmOfflineWorkflow;->messageId:Ljava/lang/String;

    iget-boolean v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmOfflineWorkflow;->isAms:Z

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v2, v3, v4, v0, v1}, Lcom/comcast/playerplatform/drm/java/util/DrmUtil;->generateDrmKeyString(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/drm/java/service/workflow/CustomDrmOfflineWorkflow;->acquireVoucher(Ljava/lang/String;)V

    .line 34
    return-void

    .line 33
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
