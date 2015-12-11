.class Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$1;
.super Ljava/lang/Object;
.source "DRMManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->OperationError(Lcom/adobe/ave/drm/DRMError;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;


# direct methods
.method constructor <init>(Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;)V
    .locals 0
    .param p1, "this$1"    # Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 68
    iget-object v1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    iget-object v1, v1, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->cb:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    instance-of v1, v1, Lcom/adobe/ave/drm/DRMOperationErrorWithErrorObjectCallback;

    if-eqz v1, :cond_0

    .line 70
    iget-object v1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    iget-object v0, v1, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->cb:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    check-cast v0, Lcom/adobe/ave/drm/DRMOperationErrorWithErrorObjectCallback;

    .line 71
    .local v0, "cbWithErrorObject":Lcom/adobe/ave/drm/DRMOperationErrorWithErrorObjectCallback;
    iget-object v1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    iget-object v1, v1, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->drmError:Lcom/adobe/ave/drm/DRMError;

    invoke-interface {v0, v1}, Lcom/adobe/ave/drm/DRMOperationErrorWithErrorObjectCallback;->OperationError(Lcom/adobe/ave/drm/DRMError;)V

    .line 74
    .end local v0    # "cbWithErrorObject":Lcom/adobe/ave/drm/DRMOperationErrorWithErrorObjectCallback;
    :goto_0
    return-void

    .line 73
    :cond_0
    iget-object v1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    iget-object v1, v1, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->cb:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    iget-object v2, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    iget-object v2, v2, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->drmError:Lcom/adobe/ave/drm/DRMError;

    invoke-virtual {v2}, Lcom/adobe/ave/drm/DRMError;->getMajorError()J

    move-result-wide v2

    iget-object v4, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    iget-object v4, v4, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->drmError:Lcom/adobe/ave/drm/DRMError;

    invoke-virtual {v4}, Lcom/adobe/ave/drm/DRMError;->getMinorError()J

    move-result-wide v4

    const/4 v6, 0x0

    invoke-interface/range {v1 .. v6}, Lcom/adobe/ave/drm/DRMOperationErrorCallback;->OperationError(JJLjava/lang/Exception;)V

    goto :goto_0
.end method
