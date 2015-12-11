.class public Lcom/comcast/cim/cmasl/android/util/view/widget/EmbeddableGridView;
.super Landroid/widget/GridView;
.source "EmbeddableGridView.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xb
.end annotation


# static fields
.field public static final MAX_CELL_HEIGHT_MEASURE_SPEC:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 20
    const v0, 0xffffff

    const/high16 v1, -0x80000000

    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    sput v0, Lcom/comcast/cim/cmasl/android/util/view/widget/EmbeddableGridView;->MAX_CELL_HEIGHT_MEASURE_SPEC:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 32
    invoke-direct {p0, p1}, Landroid/widget/GridView;-><init>(Landroid/content/Context;)V

    .line 33
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Landroid/widget/GridView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 24
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/GridView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 25
    return-void
.end method


# virtual methods
.method protected onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 37
    sget v0, Lcom/comcast/cim/cmasl/android/util/view/widget/EmbeddableGridView;->MAX_CELL_HEIGHT_MEASURE_SPEC:I

    invoke-super {p0, p1, v0}, Landroid/widget/GridView;->onMeasure(II)V

    .line 39
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EmbeddableGridView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EmbeddableGridView;->getMeasuredHeight()I

    move-result v1

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 40
    return-void
.end method
