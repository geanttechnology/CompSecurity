.class Lcom/amazon/mShop/search/viewit/CameraPreview$1;
.super Landroid/os/Handler;
.source "CameraPreview.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/viewit/CameraPreview;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/CameraPreview;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/CameraPreview;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/CameraPreview;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 57
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 63
    :goto_0
    return-void

    .line 59
    :pswitch_0
    const-string/jumbo v0, "CameraPreview"

    const-string/jumbo v1, "Run scheduled restart"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/CameraPreview;

    # invokes: Lcom/amazon/mShop/search/viewit/CameraPreview;->restart()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/CameraPreview;->access$000(Lcom/amazon/mShop/search/viewit/CameraPreview;)V

    goto :goto_0

    .line 57
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
