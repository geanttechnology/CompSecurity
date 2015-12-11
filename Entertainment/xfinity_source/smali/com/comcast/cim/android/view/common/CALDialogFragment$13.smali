.class Lcom/comcast/cim/android/view/common/CALDialogFragment$13;
.super Ljava/lang/Object;
.source "CALDialogFragment.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/CALDialogFragment;->setMoreInfoButton(Landroid/view/View;Landroid/os/Bundle;)V
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
    .line 306
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$13;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 309
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$13;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast p1, Landroid/widget/TextView;

    .end local p1    # "view":Landroid/view/View;
    # invokes: Lcom/comcast/cim/android/view/common/CALDialogFragment;->copyViewText(Landroid/content/Context;Landroid/widget/TextView;)V
    invoke-static {v0, v1, p1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->access$400(Lcom/comcast/cim/android/view/common/CALDialogFragment;Landroid/content/Context;Landroid/widget/TextView;)V

    .line 310
    const/4 v0, 0x1

    return v0
.end method
