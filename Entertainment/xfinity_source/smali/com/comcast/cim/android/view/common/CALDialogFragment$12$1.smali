.class Lcom/comcast/cim/android/view/common/CALDialogFragment$12$1;
.super Ljava/lang/Object;
.source "CALDialogFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/CALDialogFragment$12;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/android/view/common/CALDialogFragment$12;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/CALDialogFragment$12;)V
    .locals 0
    .param p1, "this$1"    # Lcom/comcast/cim/android/view/common/CALDialogFragment$12;

    .prologue
    .line 297
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$12$1;->this$1:Lcom/comcast/cim/android/view/common/CALDialogFragment$12;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 300
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$12$1;->this$1:Lcom/comcast/cim/android/view/common/CALDialogFragment$12;

    iget-object v0, v0, Lcom/comcast/cim/android/view/common/CALDialogFragment$12;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$12$1;->this$1:Lcom/comcast/cim/android/view/common/CALDialogFragment$12;

    iget-object v2, v2, Lcom/comcast/cim/android/view/common/CALDialogFragment$12;->val$stackTrace:Landroid/widget/TextView;

    # invokes: Lcom/comcast/cim/android/view/common/CALDialogFragment;->copyViewText(Landroid/content/Context;Landroid/widget/TextView;)V
    invoke-static {v0, v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->access$400(Lcom/comcast/cim/android/view/common/CALDialogFragment;Landroid/content/Context;Landroid/widget/TextView;)V

    .line 301
    return-void
.end method
