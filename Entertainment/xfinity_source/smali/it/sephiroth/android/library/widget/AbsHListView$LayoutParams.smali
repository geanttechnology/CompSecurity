.class public Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
.super Landroid/view/ViewGroup$LayoutParams;
.source "AbsHListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/AbsHListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LayoutParams"
.end annotation


# instance fields
.field public forceAdd:Z

.field public itemId:J

.field public recycledHeaderFooter:Z

.field public scrappedFromPosition:I

.field public viewType:I


# direct methods
.method public constructor <init>(III)V
    .locals 2
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "viewType"    # I

    .prologue
    .line 5421
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 5410
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->itemId:J

    .line 5422
    iput p3, p0, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    .line 5423
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 5413
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 5410
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->itemId:J

    .line 5414
    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup$LayoutParams;)V
    .locals 2
    .param p1, "source"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 5426
    invoke-direct {p0, p1}, Landroid/view/ViewGroup$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    .line 5410
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->itemId:J

    .line 5427
    return-void
.end method
