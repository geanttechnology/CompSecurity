.class public Lcom/comcast/cim/cmasl/android/util/view/widget/EmbeddableListView;
.super Landroid/widget/ListView;
.source "EmbeddableListView.java"


# static fields
.field public static final MAX_CELL_HEIGHT_MEASURE_SPEC:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 16
    const/high16 v0, 0x800000

    const/high16 v1, -0x80000000

    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    sput v0, Lcom/comcast/cim/cmasl/android/util/view/widget/EmbeddableListView;->MAX_CELL_HEIGHT_MEASURE_SPEC:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 28
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 19
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 20
    return-void
.end method


# virtual methods
.method protected onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 32
    sget v0, Lcom/comcast/cim/cmasl/android/util/view/widget/EmbeddableListView;->MAX_CELL_HEIGHT_MEASURE_SPEC:I

    invoke-super {p0, p1, v0}, Landroid/widget/ListView;->onMeasure(II)V

    .line 34
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EmbeddableListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EmbeddableListView;->getMeasuredHeight()I

    move-result v1

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 35
    return-void
.end method
