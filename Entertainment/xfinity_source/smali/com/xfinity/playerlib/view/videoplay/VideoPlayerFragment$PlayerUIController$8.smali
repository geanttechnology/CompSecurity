.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$8;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showPinPadFragment()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    .prologue
    .line 1610
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$8;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public validatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
    .locals 3
    .param p1, "pinInput"    # Ljava/lang/String;
    .param p2, "validationListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .prologue
    .line 1613
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$400()Lorg/slf4j/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "User input pin: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    .line 1614
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$8;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onValidatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V

    .line 1615
    return-void
.end method
