.class Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB$1;
.super Ljava/lang/Object;
.source "DRMManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB;->AuthenticationComplete([B)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB;

.field final synthetic val$authenticationToken:[B


# direct methods
.method constructor <init>(Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB;[B)V
    .locals 0
    .param p1, "this$1"    # Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB;

    .prologue
    .line 148
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB;

    iput-object p2, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB$1;->val$authenticationToken:[B

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 150
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB$1;->this$1:Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB;

    iget-object v0, v0, Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB;->cb:Lcom/adobe/ave/drm/DRMAuthenticationCompleteCallback;

    iget-object v1, p0, Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB$1;->val$authenticationToken:[B

    invoke-interface {v0, v1}, Lcom/adobe/ave/drm/DRMAuthenticationCompleteCallback;->AuthenticationComplete([B)V

    .line 151
    return-void
.end method
