.class Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB$1;
.super Ljava/lang/Object;
.source "DRMManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;->OperationComplete()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;


# direct methods
.method constructor <init>(Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;)V
    .locals 0
    .param p1, "this$1"    # Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;

    iget-object v0, v0, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;->cb:Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    invoke-interface {v0}, Lcom/adobe/ave/drm/DRMOperationCompleteCallback;->OperationComplete()V

    .line 100
    return-void
.end method
