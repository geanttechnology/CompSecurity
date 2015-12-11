.class Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;
.super Ljava/lang/Object;
.source "DRMManager.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/ave/drm/DRMManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "UIThreadLicenseReturnCompleteCB"
.end annotation


# instance fields
.field cb:Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;

.field final synthetic this$0:Lcom/adobe/ave/drm/DRMManager;


# direct methods
.method public constructor <init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;)V
    .locals 0
    .param p1, "this$0"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "cb"    # Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;->this$0:Lcom/adobe/ave/drm/DRMManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 110
    iput-object p2, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;->cb:Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;

    .line 111
    return-void
.end method


# virtual methods
.method public OperationComplete(J)V
    .locals 3
    .param p1, "numReturned"    # J

    .prologue
    .line 114
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;->this$0:Lcom/adobe/ave/drm/DRMManager;

    # getter for: Lcom/adobe/ave/drm/DRMManager;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/adobe/ave/drm/DRMManager;->access$000(Lcom/adobe/ave/drm/DRMManager;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB$1;-><init>(Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;J)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 119
    return-void
.end method
