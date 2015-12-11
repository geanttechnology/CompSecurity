.class public Lcom/comcast/cim/android/view/common/SAPSelectionListDialogFragment;
.super Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;
.source "SAPSelectionListDialogFragment.java"


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
    .line 20
    invoke-direct/range {p0 .. p6}, Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;-><init>(ILandroid/view/View;Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$OnSelectionChangedListener;Landroid/content/DialogInterface$OnCancelListener;Landroid/content/DialogInterface$OnKeyListener;I)V

    .line 21
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/common/SAPSelectionListDialogFragment;->isToggleable:Z

    .line 22
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/common/SAPSelectionListDialogFragment;->cancelOnSelectionChanged:Z

    .line 23
    return-void
.end method


# virtual methods
.method protected getDisplayText(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-static {p1}, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->getDisplayNameForLanguageCode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 38
    .local v0, "displayName":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 41
    .end local v0    # "displayName":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "displayName":Ljava/lang/String;
    :cond_0
    move-object v0, p1

    goto :goto_0
.end method

.method protected getHeaderSummaryTextId()I
    .locals 1

    .prologue
    .line 32
    sget v0, Lcom/comcast/cim/android/R$string;->sap_dialog_summary:I

    return v0
.end method

.method protected getHeaderTitleTextId()I
    .locals 1

    .prologue
    .line 27
    sget v0, Lcom/comcast/cim/android/R$string;->sap_dialog_title:I

    return v0
.end method
