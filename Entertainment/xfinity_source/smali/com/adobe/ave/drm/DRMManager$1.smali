.class final Lcom/adobe/ave/drm/DRMManager$1;
.super Ljava/lang/Object;
.source "DRMManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/ave/drm/DRMManager;->jobDoneNotify()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 223
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 227
    const-string v0, "DRMManager(j)"

    const-string v1, "DRMManager.needsCycles()"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 228
    # getter for: Lcom/adobe/ave/drm/DRMManager;->sManager:Lcom/adobe/ave/drm/DRMManager;
    invoke-static {}, Lcom/adobe/ave/drm/DRMManager;->access$100()Lcom/adobe/ave/drm/DRMManager;

    move-result-object v0

    # invokes: Lcom/adobe/ave/drm/DRMManager;->needsCycles()V
    invoke-static {v0}, Lcom/adobe/ave/drm/DRMManager;->access$200(Lcom/adobe/ave/drm/DRMManager;)V

    .line 229
    return-void
.end method
