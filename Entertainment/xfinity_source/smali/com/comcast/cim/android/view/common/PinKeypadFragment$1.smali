.class Lcom/comcast/cim/android/view/common/PinKeypadFragment$1;
.super Ljava/lang/Object;
.source "PinKeypadFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/PinKeypadFragment;->onKeyPressed(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/PinKeypadFragment;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    .prologue
    .line 96
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment$1;->this$0:Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 99
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment$1;->this$0:Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    # invokes: Lcom/comcast/cim/android/view/common/PinKeypadFragment;->isDialogActive()Z
    invoke-static {v0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->access$000(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 118
    :goto_0
    return-void

    .line 103
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment$1;->this$0:Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    # invokes: Lcom/comcast/cim/android/view/common/PinKeypadFragment;->showCheckingMessage()V
    invoke-static {v0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->access$100(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)V

    .line 104
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment$1;->this$0:Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    # getter for: Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinValidator:Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;
    invoke-static {v0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->access$600(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment$1;->this$0:Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    # getter for: Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;
    invoke-static {v1}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->access$200(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/comcast/cim/android/view/common/PinKeypadFragment$1$1;

    invoke-direct {v2, p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment$1$1;-><init>(Lcom/comcast/cim/android/view/common/PinKeypadFragment$1;)V

    invoke-interface {v0, v1, v2}, Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;->validatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V

    goto :goto_0
.end method
