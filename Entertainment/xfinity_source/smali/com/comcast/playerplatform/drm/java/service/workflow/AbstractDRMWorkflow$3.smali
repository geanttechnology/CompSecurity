.class Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$3;
.super Ljava/lang/Object;
.source "AbstractDRMWorkflow.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->loadVoucherNoToken()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;)V
    .locals 0

    .prologue
    .line 225
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$3;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 228
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$3;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v0, v0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmManager:Lcom/adobe/ave/drm/DRMManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$3;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v1, v1, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$3;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v2, v2, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->licenseSettings:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$3;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v3, v3, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmOperationErrorCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$3;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    iget-object v4, v4, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->drmLicenseAcquiredCallback:Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/adobe/ave/drm/DRMManager;->acquireLicense(Lcom/adobe/ave/drm/DRMMetadata;Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V

    .line 232
    return-void
.end method
