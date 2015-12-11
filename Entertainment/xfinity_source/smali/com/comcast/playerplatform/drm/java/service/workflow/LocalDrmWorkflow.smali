.class public Lcom/comcast/playerplatform/drm/java/service/workflow/LocalDrmWorkflow;
.super Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;
.source "LocalDrmWorkflow.java"


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Landroid/content/Context;)V
    .locals 6
    .param p1, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    .param p2, "authenticationDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;
    .param p3, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p4, "context"    # Landroid/content/Context;

    .prologue
    .line 18
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p4

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractStreamingDrmWorkflow;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 19
    sget-object v0, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->LOCAL_ONLY:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/LocalDrmWorkflow;->licenseSettings:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    .line 20
    return-void
.end method


# virtual methods
.method public validate()V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/drm/java/service/workflow/LocalDrmWorkflow;->acquireVoucher(Ljava/lang/String;)V

    .line 24
    return-void
.end method
