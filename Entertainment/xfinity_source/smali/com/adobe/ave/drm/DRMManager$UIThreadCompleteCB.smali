.class Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;
.super Ljava/lang/Object;
.source "DRMManager.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMOperationCompleteCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/ave/drm/DRMManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "UIThreadCompleteCB"
.end annotation


# instance fields
.field cb:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

.field final synthetic this$0:Lcom/adobe/ave/drm/DRMManager;


# direct methods
.method public constructor <init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
    .locals 0
    .param p1, "this$0"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "cb"    # Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;->this$0:Lcom/adobe/ave/drm/DRMManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 93
    iput-object p2, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;->cb:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    .line 94
    return-void
.end method


# virtual methods
.method public OperationComplete()V
    .locals 2

    .prologue
    .line 97
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;->this$0:Lcom/adobe/ave/drm/DRMManager;

    # getter for: Lcom/adobe/ave/drm/DRMManager;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/adobe/ave/drm/DRMManager;->access$000(Lcom/adobe/ave/drm/DRMManager;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB$1;

    invoke-direct {v1, p0}, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB$1;-><init>(Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 102
    return-void
.end method
