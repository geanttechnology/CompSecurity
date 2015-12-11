.class Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB;
.super Ljava/lang/Object;
.source "DRMManager.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/ave/drm/DRMManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "UIThreadLicenseAcquiredCB"
.end annotation


# instance fields
.field cb:Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

.field final synthetic this$0:Lcom/adobe/ave/drm/DRMManager;


# direct methods
.method public constructor <init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V
    .locals 0
    .param p1, "this$0"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "cb"    # Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB;->this$0:Lcom/adobe/ave/drm/DRMManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 127
    iput-object p2, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB;->cb:Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

    .line 128
    return-void
.end method


# virtual methods
.method public LicenseAcquired(Lcom/adobe/ave/drm/DRMLicense;)V
    .locals 2
    .param p1, "license"    # Lcom/adobe/ave/drm/DRMLicense;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB;->this$0:Lcom/adobe/ave/drm/DRMManager;

    # getter for: Lcom/adobe/ave/drm/DRMManager;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/adobe/ave/drm/DRMManager;->access$000(Lcom/adobe/ave/drm/DRMManager;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB$1;

    invoke-direct {v1, p0, p1}, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB$1;-><init>(Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB;Lcom/adobe/ave/drm/DRMLicense;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 136
    return-void
.end method
