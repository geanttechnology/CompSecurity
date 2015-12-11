.class Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;
.super Ljava/lang/Object;
.source "FilterableProgramCollectionFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$OnScrollChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "QuickReturnOnScrollChangedListener"
.end annotation


# instance fields
.field private final quickReturnView:Landroid/view/View;

.field private quickReturnViewHeight:I

.field private referenceQuickReturnViewRect:Landroid/graphics/Rect;

.field final synthetic this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;Landroid/view/View;)V
    .locals 2
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;
    .param p2, "quickReturnView"    # Landroid/view/View;

    .prologue
    .line 233
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>.QuickReturnOnScrollChangedListener;"
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 229
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;

    .line 234
    iput-object p2, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnView:Landroid/view/View;

    .line 236
    invoke-virtual {p2}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    new-instance v1, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;-><init>(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 250
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;)Landroid/graphics/Rect;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    .prologue
    .line 226
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;)I
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    .prologue
    .line 226
    iget v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnViewHeight:I

    return v0
.end method

.method static synthetic access$102(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;I)I
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;
    .param p1, "x1"    # I

    .prologue
    .line 226
    iput p1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnViewHeight:I

    return p1
.end method


# virtual methods
.method public adjustReferenceRectVerticals(I)V
    .locals 2
    .param p1, "adjustment"    # I

    .prologue
    .line 275
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>.QuickReturnOnScrollChangedListener;"
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setTranslationY(F)V

    .line 277
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;

    iget v1, v0, Landroid/graphics/Rect;->top:I

    add-int/2addr v1, p1

    iput v1, v0, Landroid/graphics/Rect;->top:I

    .line 278
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;

    iget v1, v0, Landroid/graphics/Rect;->bottom:I

    add-int/2addr v1, p1

    iput v1, v0, Landroid/graphics/Rect;->bottom:I

    .line 279
    return-void
.end method

.method public onScrollChanged(FF)V
    .locals 7
    .param p1, "deltaX"    # F
    .param p2, "deltaY"    # F

    .prologue
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>.QuickReturnOnScrollChangedListener;"
    const/4 v6, 0x0

    .line 254
    const v2, 0x3a83126f    # 0.001f

    .line 255
    .local v2, "zeroThreshold":F
    cmpl-float v3, p2, v2

    if-gtz v3, :cond_0

    const/high16 v3, -0x40800000    # -1.0f

    mul-float/2addr v3, v2

    cmpg-float v3, p2, v3

    if-gez v3, :cond_3

    .line 256
    :cond_0
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 257
    .local v0, "currentRect":Landroid/graphics/Rect;
    iget-object v3, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnView:Landroid/view/View;

    invoke-virtual {v3, v0}, Landroid/view/View;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    .line 258
    cmpl-float v3, p2, v6

    if-lez v3, :cond_1

    iget v3, v0, Landroid/graphics/Rect;->bottom:I

    iget-object v4, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->top:I

    if-le v3, v4, :cond_1

    iget v3, v0, Landroid/graphics/Rect;->top:I

    iget-object v4, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->top:I

    iget v5, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnViewHeight:I

    sub-int/2addr v4, v5

    if-gt v3, v4, :cond_2

    :cond_1
    cmpg-float v3, p2, v6

    if-gez v3, :cond_5

    iget v3, v0, Landroid/graphics/Rect;->bottom:I

    iget-object v4, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->bottom:I

    if-ge v3, v4, :cond_5

    .line 262
    :cond_2
    cmpg-float v3, p2, v6

    if-gez v3, :cond_4

    iget v3, v0, Landroid/graphics/Rect;->bottom:I

    int-to-float v3, v3

    sub-float/2addr v3, p2

    iget-object v4, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->bottom:I

    int-to-float v4, v4

    cmpl-float v3, v3, v4

    if-lez v3, :cond_4

    .line 263
    iget-object v3, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnView:Landroid/view/View;

    invoke-virtual {v3, v6}, Landroid/view/View;->setTranslationY(F)V

    .line 272
    .end local v0    # "currentRect":Landroid/graphics/Rect;
    :cond_3
    :goto_0
    return-void

    .line 265
    .restart local v0    # "currentRect":Landroid/graphics/Rect;
    :cond_4
    iget-object v3, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getTranslationY()F

    move-result v3

    sub-float v1, v3, p2

    .line 266
    .local v1, "translation":F
    iget-object v3, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnView:Landroid/view/View;

    invoke-virtual {v3, v1}, Landroid/view/View;->setTranslationY(F)V

    goto :goto_0

    .line 268
    .end local v1    # "translation":F
    :cond_5
    iget v3, v0, Landroid/graphics/Rect;->bottom:I

    iget-object v4, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->bottom:I

    if-le v3, v4, :cond_3

    .line 269
    iget-object v3, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnView:Landroid/view/View;

    invoke-virtual {v3, v6}, Landroid/view/View;->setTranslationY(F)V

    goto :goto_0
.end method
