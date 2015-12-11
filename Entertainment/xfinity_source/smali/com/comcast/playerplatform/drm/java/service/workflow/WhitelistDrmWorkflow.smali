.class public Lcom/comcast/playerplatform/drm/java/service/workflow/WhitelistDrmWorkflow;
.super Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;
.source "WhitelistDrmWorkflow.java"


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 1
    .param p1, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .param p2, "authenticationDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p5, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 17
    invoke-direct/range {p0 .. p5}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 18
    sget-object v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->ALLOW_SERVER:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/WhitelistDrmWorkflow;->licenseSettings:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    .line 19
    return-void
.end method


# virtual methods
.method public validate()V
    .locals 1

    .prologue
    .line 21
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/DrmUtil;->generateWhiteListString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/drm/java/service/workflow/WhitelistDrmWorkflow;->acquireVoucher(Ljava/lang/String;)V

    .line 22
    return-void
.end method
