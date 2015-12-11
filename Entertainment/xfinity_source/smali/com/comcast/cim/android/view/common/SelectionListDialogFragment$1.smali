.class Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$1;
.super Ljava/lang/Object;
.source "SelectionListDialogFragment.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$1;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 10

    .prologue
    .line 95
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$1;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    invoke-virtual {v7}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v7

    invoke-virtual {v7}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v7

    invoke-virtual {v7}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v5

    .line 96
    .local v5, "params":Landroid/view/WindowManager$LayoutParams;
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$1;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    invoke-virtual {v7}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v7

    invoke-virtual {v7}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v7

    invoke-virtual {v7}, Landroid/view/Window;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v7

    invoke-interface {v7}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v7

    invoke-virtual {v7}, Landroid/view/Display;->getHeight()I

    move-result v6

    .line 97
    .local v6, "windowHeight":I
    iget v7, v5, Landroid/view/WindowManager$LayoutParams;->y:I

    sub-int v7, v6, v7

    iget-object v8, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$1;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    iget-object v9, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$1;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    # getter for: Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->heightAdjustmentInPixels:I
    invoke-static {v9}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->access$000(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->dpToPx(I)I

    move-result v8

    sub-int v3, v7, v8

    .line 99
    .local v3, "maxHeight":I
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$1;->this$0:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    invoke-virtual {v7}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getView()Landroid/view/View;

    move-result-object v7

    sget v8, Lcom/comcast/cim/android/R$id;->inner_layout:I

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 100
    .local v0, "innerLayout":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v1

    .line 102
    .local v1, "layoutHeight":I
    if-le v1, v3, :cond_0

    .line 103
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 104
    .local v2, "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    iput v3, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 105
    invoke-virtual {v0, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 108
    .end local v2    # "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    :cond_0
    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v4

    .line 109
    .local v4, "obs":Landroid/view/ViewTreeObserver;
    invoke-virtual {v4, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 110
    return-void
.end method
