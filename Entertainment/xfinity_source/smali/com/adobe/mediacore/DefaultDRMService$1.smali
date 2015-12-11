.class Lcom/adobe/mediacore/DefaultDRMService$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/ave/drm/DRMOperationErrorCallback;


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

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultDRMService$1;->this$0:Lcom/adobe/mediacore/DefaultDRMService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public OperationError(JJLjava/lang/Exception;)V
    .locals 7

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultDRMService$1;->this$0:Lcom/adobe/mediacore/DefaultDRMService;

    # getter for: Lcom/adobe/mediacore/DefaultDRMService;->_listener:Lcom/adobe/mediacore/DRMService$DRMEventListener;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultDRMService;->access$000(Lcom/adobe/mediacore/DefaultDRMService;)Lcom/adobe/mediacore/DRMService$DRMEventListener;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultDRMService$1;->this$0:Lcom/adobe/mediacore/DefaultDRMService;

    # getter for: Lcom/adobe/mediacore/DefaultDRMService;->_listener:Lcom/adobe/mediacore/DRMService$DRMEventListener;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultDRMService;->access$000(Lcom/adobe/mediacore/DefaultDRMService;)Lcom/adobe/mediacore/DRMService$DRMEventListener;

    move-result-object v1

    move-wide v2, p1

    move-wide v4, p3

    move-object v6, p5

    invoke-interface/range {v1 .. v6}, Lcom/adobe/mediacore/DRMService$DRMEventListener;->onError(JJLjava/lang/Exception;)V

    :cond_0
    return-void
.end method
