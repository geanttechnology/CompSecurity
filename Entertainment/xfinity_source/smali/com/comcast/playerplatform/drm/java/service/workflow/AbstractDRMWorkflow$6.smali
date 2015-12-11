.class Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;
.super Ljava/lang/Object;
.source "AbstractDRMWorkflow.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMOperationCompleteCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;
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
    .line 281
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public OperationComplete()V
    .locals 2

    .prologue
    .line 284
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6$1;-><init>(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$6;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 305
    return-void
.end method
