.class public Lcom/xfinity/playerlib/view/videoplay/CCSelectionListDialogFragment;
.super Lcom/comcast/cim/android/view/common/SelectionListDialogFragment;
.source "CCSelectionListDialogFragment.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "ValidFragment"
    }
.end annotation


# virtual methods
.method protected getHeaderSummaryTextId()I
    .locals 1

    .prologue
    .line 28
    sget v0, Lcom/xfinity/playerlib/R$string;->cc_dialog_summary:I

    return v0
.end method

.method protected getHeaderTitleTextId()I
    .locals 1

    .prologue
    .line 23
    sget v0, Lcom/xfinity/playerlib/R$string;->cc_dialog_title:I

    return v0
.end method
