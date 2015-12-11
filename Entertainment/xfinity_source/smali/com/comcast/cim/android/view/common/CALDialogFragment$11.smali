.class Lcom/comcast/cim/android/view/common/CALDialogFragment$11;
.super Ljava/lang/Object;
.source "CALDialogFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/CALDialogFragment;->createRetryableErrorDialogView(Ljava/lang/String;Landroid/view/View;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .prologue
    .line 273
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$11;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 276
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$11;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/CALDialogFragment;->tryAgainListener:Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;
    invoke-static {v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->access$300(Lcom/comcast/cim/android/view/common/CALDialogFragment;)Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;->tryAgain()V

    .line 277
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$11;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->dismiss()V

    .line 278
    return-void
.end method
