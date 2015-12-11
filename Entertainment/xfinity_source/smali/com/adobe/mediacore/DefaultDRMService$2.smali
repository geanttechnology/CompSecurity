.class Lcom/adobe/mediacore/DefaultDRMService$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/ave/drm/DRMOperationCompleteCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/DefaultDRMService;->initialize()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/DefaultDRMService;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/DefaultDRMService;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultDRMService$2;->this$0:Lcom/adobe/mediacore/DefaultDRMService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public OperationComplete()V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultDRMService$2;->this$0:Lcom/adobe/mediacore/DefaultDRMService;

    const/4 v1, 0x1

    # setter for: Lcom/adobe/mediacore/DefaultDRMService;->_drmInitialized:Z
    invoke-static {v0, v1}, Lcom/adobe/mediacore/DefaultDRMService;->access$102(Lcom/adobe/mediacore/DefaultDRMService;Z)Z

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultDRMService$2;->this$0:Lcom/adobe/mediacore/DefaultDRMService;

    # getter for: Lcom/adobe/mediacore/DefaultDRMService;->_listener:Lcom/adobe/mediacore/DRMService$DRMEventListener;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultDRMService;->access$000(Lcom/adobe/mediacore/DefaultDRMService;)Lcom/adobe/mediacore/DRMService$DRMEventListener;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultDRMService$2;->this$0:Lcom/adobe/mediacore/DefaultDRMService;

    # getter for: Lcom/adobe/mediacore/DefaultDRMService;->_listener:Lcom/adobe/mediacore/DRMService$DRMEventListener;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultDRMService;->access$000(Lcom/adobe/mediacore/DefaultDRMService;)Lcom/adobe/mediacore/DRMService$DRMEventListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/DRMService$DRMEventListener;->onInitialized()V

    :cond_0
    return-void
.end method
