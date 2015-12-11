.class Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;
.super Ljava/lang/Object;
.source "DRMManager.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMOperationErrorWithErrorObjectCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/ave/drm/DRMManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "UIThreadErrorCB"
.end annotation


# instance fields
.field cb:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

.field drmError:Lcom/adobe/ave/drm/DRMError;

.field final synthetic this$0:Lcom/adobe/ave/drm/DRMManager;


# direct methods
.method public constructor <init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationErrorCallback;)V
    .locals 0
    .param p1, "this$0"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "cb"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->this$0:Lcom/adobe/ave/drm/DRMManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput-object p2, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->cb:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    .line 60
    return-void
.end method


# virtual methods
.method public OperationError(JJLjava/lang/Exception;)V
    .locals 9
    .param p1, "majorCode"    # J
    .param p3, "minorCode"    # J
    .param p5, "e"    # Ljava/lang/Exception;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->this$0:Lcom/adobe/ave/drm/DRMManager;

    # getter for: Lcom/adobe/ave/drm/DRMManager;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/adobe/ave/drm/DRMManager;->access$000(Lcom/adobe/ave/drm/DRMManager;)Landroid/os/Handler;

    move-result-object v7

    new-instance v0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$2;

    move-object v1, p0

    move-wide v2, p1

    move-wide v4, p3

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$2;-><init>(Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;JJLjava/lang/Exception;)V

    invoke-virtual {v7, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 85
    return-void
.end method

.method public OperationError(Lcom/adobe/ave/drm/DRMError;)V
    .locals 2
    .param p1, "error"    # Lcom/adobe/ave/drm/DRMError;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->drmError:Lcom/adobe/ave/drm/DRMError;

    .line 65
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->this$0:Lcom/adobe/ave/drm/DRMManager;

    # getter for: Lcom/adobe/ave/drm/DRMManager;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/adobe/ave/drm/DRMManager;->access$000(Lcom/adobe/ave/drm/DRMManager;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$1;

    invoke-direct {v1, p0}, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$1;-><init>(Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 76
    return-void
.end method
