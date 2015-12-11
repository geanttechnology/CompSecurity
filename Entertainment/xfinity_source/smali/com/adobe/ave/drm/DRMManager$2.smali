.class Lcom/adobe/ave/drm/DRMManager$2;
.super Ljava/lang/Object;
.source "DRMManager.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/ave/drm/DRMManager;->initialize(Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/ave/drm/DRMManager;

.field final synthetic val$complete:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;


# direct methods
.method constructor <init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
    .locals 0
    .param p1, "this$0"    # Lcom/adobe/ave/drm/DRMManager;

    .prologue
    .line 257
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMManager$2;->this$0:Lcom/adobe/ave/drm/DRMManager;

    iput-object p2, p0, Lcom/adobe/ave/drm/DRMManager$2;->val$complete:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public LicenseAcquired(Lcom/adobe/ave/drm/DRMLicense;)V
    .locals 1
    .param p1, "license"    # Lcom/adobe/ave/drm/DRMLicense;

    .prologue
    .line 259
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMManager$2;->val$complete:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    invoke-interface {v0}, Lcom/adobe/ave/drm/DRMOperationCompleteCallback;->OperationComplete()V

    .line 260
    return-void
.end method
