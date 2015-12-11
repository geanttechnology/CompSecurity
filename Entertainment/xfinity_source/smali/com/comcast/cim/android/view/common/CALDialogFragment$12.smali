.class Lcom/comcast/cim/android/view/common/CALDialogFragment$12;
.super Ljava/lang/Object;
.source "CALDialogFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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

.field final synthetic val$stackTrace:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;Landroid/widget/TextView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .prologue
    .line 292
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$12;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    iput-object p2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$12;->val$stackTrace:Landroid/widget/TextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 295
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$12;->val$stackTrace:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    move-object v0, p1

    .line 296
    check-cast v0, Landroid/widget/Button;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$12;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$string;->dlg_btn_copy_info:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 297
    new-instance v0, Lcom/comcast/cim/android/view/common/CALDialogFragment$12$1;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$12$1;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment$12;)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 303
    return-void
.end method
