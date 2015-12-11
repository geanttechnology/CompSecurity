.class Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$2;
.super Ljava/lang/Object;
.source "DRMManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->OperationError(JJLjava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

.field final synthetic val$e:Ljava/lang/Exception;

.field final synthetic val$majorCode:J

.field final synthetic val$minorCode:J


# direct methods
.method constructor <init>(Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;JJLjava/lang/Exception;)V
    .locals 0
    .param p1, "this$1"    # Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$2;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    iput-wide p2, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$2;->val$majorCode:J

    iput-wide p4, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$2;->val$minorCode:J

    iput-object p6, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$2;->val$e:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 82
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$2;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    iget-object v1, v0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;->cb:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    iget-wide v2, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$2;->val$majorCode:J

    iget-wide v4, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$2;->val$minorCode:J

    iget-object v6, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB$2;->val$e:Ljava/lang/Exception;

    invoke-interface/range {v1 .. v6}, Lcom/adobe/ave/drm/DRMOperationErrorCallback;->OperationError(JJLjava/lang/Exception;)V

    .line 83
    return-void
.end method
