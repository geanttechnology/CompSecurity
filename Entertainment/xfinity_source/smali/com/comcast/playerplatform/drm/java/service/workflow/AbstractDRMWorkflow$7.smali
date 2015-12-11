.class Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$7;
.super Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
.source "AbstractDRMWorkflow.java"


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
    .line 320
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$7;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public responseReceived(Ljava/lang/String;)V
    .locals 1
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 323
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$7;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    # invokes: Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->getMetadata(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->access$000(Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;Ljava/lang/String;)V

    .line 324
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow$7;->this$0:Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow;->validate()V

    .line 325
    return-void
.end method
