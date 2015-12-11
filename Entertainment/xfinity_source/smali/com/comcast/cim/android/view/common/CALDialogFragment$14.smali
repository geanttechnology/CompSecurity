.class Lcom/comcast/cim/android/view/common/CALDialogFragment$14;
.super Ljava/lang/Object;
.source "CALDialogFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;ILcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;)Landroid/widget/Button;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

.field final synthetic val$button:Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

.field final synthetic val$buttonNum:I


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;I)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .prologue
    .line 375
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$14;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    iput-object p2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$14;->val$button:Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    iput p3, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$14;->val$buttonNum:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 378
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$14;->val$button:Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    iget-object v0, v0, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;->onClickListener:Landroid/content/DialogInterface$OnClickListener;

    if-eqz v0, :cond_0

    .line 379
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$14;->val$button:Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    iget-object v0, v0, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;->onClickListener:Landroid/content/DialogInterface$OnClickListener;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$14;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v1

    iget v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$14;->val$buttonNum:I

    invoke-interface {v0, v1, v2}, Landroid/content/DialogInterface$OnClickListener;->onClick(Landroid/content/DialogInterface;I)V

    .line 381
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$14;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->dismiss()V

    .line 382
    return-void
.end method
