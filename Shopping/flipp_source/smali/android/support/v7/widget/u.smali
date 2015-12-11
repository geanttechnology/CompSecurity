.class public final Landroid/support/v7/widget/u;
.super Landroid/support/v7/widget/av;
.source "SourceFile"


# instance fields
.field a:I

.field b:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, -0x2

    .line 773
    invoke-direct {p0, v0, v0}, Landroid/support/v7/widget/av;-><init>(II)V

    .line 764
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/widget/u;->a:I

    .line 766
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/widget/u;->b:I

    .line 774
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 769
    invoke-direct {p0, p1, p2}, Landroid/support/v7/widget/av;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 764
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/widget/u;->a:I

    .line 766
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/widget/u;->b:I

    .line 770
    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1

    .prologue
    .line 781
    invoke-direct {p0, p1}, Landroid/support/v7/widget/av;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    .line 764
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/widget/u;->a:I

    .line 766
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/widget/u;->b:I

    .line 782
    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup$MarginLayoutParams;)V
    .locals 1

    .prologue
    .line 777
    invoke-direct {p0, p1}, Landroid/support/v7/widget/av;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    .line 764
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/widget/u;->a:I

    .line 766
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/widget/u;->b:I

    .line 778
    return-void
.end method

.method static synthetic a(Landroid/support/v7/widget/u;)I
    .locals 1

    .prologue
    .line 757
    iget v0, p0, Landroid/support/v7/widget/u;->a:I

    return v0
.end method

.method static synthetic a(Landroid/support/v7/widget/u;I)I
    .locals 0

    .prologue
    .line 757
    iput p1, p0, Landroid/support/v7/widget/u;->b:I

    return p1
.end method

.method static synthetic b(Landroid/support/v7/widget/u;)I
    .locals 1

    .prologue
    .line 757
    iget v0, p0, Landroid/support/v7/widget/u;->b:I

    return v0
.end method

.method static synthetic b(Landroid/support/v7/widget/u;I)I
    .locals 0

    .prologue
    .line 757
    iput p1, p0, Landroid/support/v7/widget/u;->a:I

    return p1
.end method
