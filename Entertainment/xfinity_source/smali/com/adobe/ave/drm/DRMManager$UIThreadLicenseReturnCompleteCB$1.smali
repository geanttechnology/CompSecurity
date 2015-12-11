.class Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB$1;
.super Ljava/lang/Object;
.source "DRMManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;->OperationComplete(J)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;

.field final synthetic val$numReturned:J


# direct methods
.method constructor <init>(Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;J)V
    .locals 0
    .param p1, "this$1"    # Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;

    .prologue
    .line 114
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;

    iput-wide p2, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB$1;->val$numReturned:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 116
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;

    iget-object v0, v0, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;->cb:Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;

    iget-wide v2, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB$1;->val$numReturned:J

    invoke-interface {v0, v2, v3}, Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;->OperationComplete(J)V

    .line 117
    return-void
.end method
