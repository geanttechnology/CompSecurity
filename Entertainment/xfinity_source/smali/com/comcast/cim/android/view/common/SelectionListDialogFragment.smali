.class public abstract Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;
.super Landroid/app/DialogFragment;
.source "SelectionListDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;,
        Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$OnSelectionChangedListener;
    }
.end annotation


# instance fields
.field private anchorView:Landroid/view/View;

.field protected cancelOnSelectionChanged:Z

.field private heightAdjustmentInPixels:I

.field private inflater:Landroid/view/LayoutInflater;

.field protected isToggleable:Z

.field onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

.field private onKeyListener:Landroid/content/DialogInterface$OnKeyListener;

.field onSelectionChangedListener:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$OnSelectionChangedListener;

.field private selectedItemIndex:I

.field protected selectionItems:[Ljava/lang/String;

.field private selectionList:Landroid/widget/ListView;


# direct methods
.method public constructor <init>(ILandroid/view/View;Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$OnSelectionChangedListener;Landroid/content/DialogInterface$OnCancelListener;Landroid/content/DialogInterface$OnKeyListener;I)V
    .locals 1
    .param p1, "selectedItemIndex"    # I
    .param p2, "anchorView"    # Landroid/view/View;
    .param p3, "onSelectionChangeListener"    # Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$OnSelectionChangedListener;
    .param p4, "onCancelListener"    # Landroid/content/DialogInterface$OnCancelListener;
    .param p5, "onKeyListener"    # Landroid/content/DialogInterface$OnKeyListener;
    .param p6, "heightAdjustmentInPixels"    # I

    .prologue
    const/4 v0, 0x1

    .line 43
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    .line 31
    iput-boolean v0, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->isToggleable:Z

    .line 32
    iput-boolean v0, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->cancelOnSelectionChanged:Z

    .line 33
    const/4 v0, 0x0

    iput v0, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->heightAdjustmentInPixels:I

    .line 44
    iput-object p2, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->anchorView:Landroid/view/View;

    .line 45
    iput p1, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectedItemIndex:I

    .line 46
    iput-object p3, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->onSelectionChangedListener:Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$OnSelectionChangedListener;

    .line 47
    iput-object p4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    .line 48
    iput-object p5, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->onKeyListener:Landroid/content/DialogInterface$OnKeyListener;

    .line 49
    iput p6, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->heightAdjustmentInPixels:I

    .line 50
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    .prologue
    .line 24
    iget v0, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->heightAdjustmentInPixels:I

    return v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)Landroid/view/LayoutInflater;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->inflater:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method static synthetic access$200(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    .prologue
    .line 24
    iget v0, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectedItemIndex:I

    return v0
.end method

.method static synthetic access$202(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;
    .param p1, "x1"    # I

    .prologue
    .line 24
    iput p1, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectedItemIndex:I

    return p1
.end method

.method static synthetic access$300(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)Landroid/widget/ListView;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectionList:Landroid/widget/ListView;

    return-object v0
.end method


# virtual methods
.method dpToPx(I)I
    .locals 3
    .param p1, "dp"    # I

    .prologue
    .line 148
    const/4 v0, 0x1

    int-to-float v1, p1

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v0, v1, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v0, v0

    return v0
.end method

.method protected getDisplayText(Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 152
    return-object p1
.end method

.method protected abstract getHeaderSummaryTextId()I
.end method

.method protected abstract getHeaderTitleTextId()I
.end method

.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 229
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    invoke-interface {v0, p1}, Landroid/content/DialogInterface$OnCancelListener;->onCancel(Landroid/content/DialogInterface;)V

    .line 230
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 56
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onCreate(Landroid/os/Bundle;)V

    .line 57
    const/4 v0, 0x1

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getTheme()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->setStyle(II)V

    .line 58
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 63
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v1

    .line 64
    .local v1, "dialog":Landroid/app/Dialog;
    invoke-virtual {v1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v6

    const/4 v7, 0x2

    invoke-virtual {v6, v7}, Landroid/view/Window;->clearFlags(I)V

    .line 65
    const/4 v6, 0x1

    invoke-virtual {v1, v6}, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V

    .line 66
    iget-object v6, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->onKeyListener:Landroid/content/DialogInterface$OnKeyListener;

    invoke-virtual {v1, v6}, Landroid/app/Dialog;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)V

    .line 68
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 69
    .local v0, "args":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 70
    const-string v6, "data"

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectionItems:[Ljava/lang/String;

    .line 73
    :cond_0
    sget v6, Lcom/comcast/cim/android/R$layout;->selection_list_dialog:I

    const/4 v7, 0x0

    invoke-virtual {p1, v6, p2, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v5

    .line 75
    .local v5, "layout":Landroid/view/View;
    sget v6, Lcom/comcast/cim/android/R$id;->selection_list:I

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ListView;

    iput-object v6, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectionList:Landroid/widget/ListView;

    .line 76
    iget-object v6, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectionList:Landroid/widget/ListView;

    new-instance v7, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;

    invoke-direct {v7, p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$SelectionListAdapter;-><init>(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)V

    invoke-virtual {v6, v7}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 77
    iget-object v6, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectionList:Landroid/widget/ListView;

    iget v7, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->selectedItemIndex:I

    invoke-virtual {v6, v7}, Landroid/widget/ListView;->setSelection(I)V

    .line 79
    sget v6, Lcom/comcast/cim/android/R$id;->title:I

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 80
    .local v3, "headerTitle":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getHeaderTitleTextId()I

    move-result v6

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setText(I)V

    .line 82
    sget v6, Lcom/comcast/cim/android/R$id;->summary:I

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 83
    .local v2, "headerSummary":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getHeaderSummaryTextId()I

    move-result v6

    invoke-virtual {v2, v6}, Landroid/widget/TextView;->setText(I)V

    .line 85
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->inflater:Landroid/view/LayoutInflater;

    .line 88
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->setPosition()V

    .line 91
    sget v6, Lcom/comcast/cim/android/R$id;->inner_layout:I

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    .line 92
    .local v4, "innerLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v6

    new-instance v7, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$1;

    invoke-direct {v7, p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$1;-><init>(Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 113
    return-object v5
.end method

.method protected setPosition()V
    .locals 6

    .prologue
    .line 124
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v3

    .line 126
    .local v3, "params":Landroid/view/WindowManager$LayoutParams;
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/comcast/cim/android/R$dimen;->selection_list_dialog_width:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 128
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    .line 129
    .local v2, "anchorViewRect":Landroid/graphics/Rect;
    iget-object v4, p0, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->anchorView:Landroid/view/View;

    invoke-virtual {v4, v2}, Landroid/view/View;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    .line 131
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v4

    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/Display;->getWidth()I

    move-result v1

    .line 132
    .local v1, "activityWindowWidth":I
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v4

    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/Display;->getHeight()I

    move-result v0

    .line 135
    .local v0, "activityWindowHeight":I
    iget v4, v2, Landroid/graphics/Rect;->top:I

    iget v5, v2, Landroid/graphics/Rect;->bottom:I

    sub-int v5, v0, v5

    if-le v4, v5, :cond_0

    .line 136
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v4

    const/16 v5, 0x55

    invoke-virtual {v4, v5}, Landroid/view/Window;->setGravity(I)V

    .line 137
    iget v4, v2, Landroid/graphics/Rect;->top:I

    sub-int v4, v0, v4

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 142
    :goto_0
    iget v4, v2, Landroid/graphics/Rect;->right:I

    sub-int v4, v1, v4

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 144
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v4

    invoke-virtual {v4, v3}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 145
    return-void

    .line 139
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v4

    const/16 v5, 0x35

    invoke-virtual {v4, v5}, Landroid/view/Window;->setGravity(I)V

    .line 140
    iget v4, v2, Landroid/graphics/Rect;->bottom:I

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->y:I

    goto :goto_0
.end method
