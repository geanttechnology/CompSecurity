.class public Lit/sephiroth/android/library/widget/HListView;
.super Lit/sephiroth/android/library/widget/AbsHListView;
.source "HListView.java"


# annotations
.annotation runtime Landroid/widget/RemoteViews$RemoteView;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lit/sephiroth/android/library/widget/HListView$1;,
        Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;,
        Lit/sephiroth/android/library/widget/HListView$FocusSelector;,
        Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;
    }
.end annotation


# instance fields
.field private mAreAllItemsSelectable:Z

.field private final mArrowScrollFocusResult:Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;

.field mDivider:Landroid/graphics/drawable/Drawable;

.field private mDividerIsOpaque:Z

.field private mDividerPaint:Landroid/graphics/Paint;

.field mDividerWidth:I

.field private mFocusSelector:Lit/sephiroth/android/library/widget/HListView$FocusSelector;

.field private mFooterDividersEnabled:Z

.field private mFooterViewInfos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mHeaderDividersEnabled:Z

.field private mHeaderViewInfos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mIsCacheColorOpaque:Z

.field private mItemsCanFocus:Z

.field mMeasureWithChild:I

.field mOverScrollFooter:Landroid/graphics/drawable/Drawable;

.field mOverScrollHeader:Landroid/graphics/drawable/Drawable;

.field private final mTempRect:Landroid/graphics/Rect;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 143
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lit/sephiroth/android/library/widget/HListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 144
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 147
    sget v0, Lit/sephiroth/android/library/R$attr;->hlv_listViewStyle:I

    invoke-direct {p0, p1, p2, v0}, Lit/sephiroth/android/library/widget/HListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 148
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 151
    invoke-direct {p0, p1, p2, p3}, Lit/sephiroth/android/library/widget/AbsHListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 111
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    iput-object v10, p0, Lit/sephiroth/android/library/widget/HListView;->mHeaderViewInfos:Ljava/util/ArrayList;

    .line 112
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    iput-object v10, p0, Lit/sephiroth/android/library/widget/HListView;->mFooterViewInfos:Ljava/util/ArrayList;

    .line 127
    const/4 v10, 0x1

    iput-boolean v10, p0, Lit/sephiroth/android/library/widget/HListView;->mAreAllItemsSelectable:Z

    .line 129
    const/4 v10, 0x0

    iput-boolean v10, p0, Lit/sephiroth/android/library/widget/HListView;->mItemsCanFocus:Z

    .line 132
    new-instance v10, Landroid/graphics/Rect;

    invoke-direct {v10}, Landroid/graphics/Rect;-><init>()V

    iput-object v10, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    .line 137
    new-instance v10, Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;

    const/4 v11, 0x0

    invoke-direct {v10, v11}, Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;-><init>(Lit/sephiroth/android/library/widget/HListView$1;)V

    iput-object v10, p0, Lit/sephiroth/android/library/widget/HListView;->mArrowScrollFocusResult:Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;

    .line 157
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v9

    .line 158
    .local v9, "theme":Landroid/content/res/Resources$Theme;
    sget-object v10, Lit/sephiroth/android/library/R$styleable;->HListView:[I

    const/4 v11, 0x0

    invoke-virtual {v9, p2, v10, p3, v11}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 160
    .local v0, "array":Landroid/content/res/TypedArray;
    const/4 v3, 0x0

    .line 161
    .local v3, "entries":[Ljava/lang/CharSequence;
    const/4 v1, 0x0

    .line 162
    .local v1, "dividerDrawable":Landroid/graphics/drawable/Drawable;
    const/4 v8, 0x0

    .line 163
    .local v8, "overscrollHeader":Landroid/graphics/drawable/Drawable;
    const/4 v7, 0x0

    .line 164
    .local v7, "overscrollFooter":Landroid/graphics/drawable/Drawable;
    const/4 v2, 0x0

    .line 166
    .local v2, "dividerWidth":I
    const/4 v5, 0x1

    .line 167
    .local v5, "headerDividersEnabled":Z
    const/4 v4, 0x1

    .line 168
    .local v4, "footerDividersEnabled":Z
    const/4 v6, -0x1

    .line 170
    .local v6, "measureWithChild":I
    if-eqz v0, :cond_0

    .line 171
    const/4 v10, 0x0

    invoke-virtual {v0, v10}, Landroid/content/res/TypedArray;->getTextArray(I)[Ljava/lang/CharSequence;

    move-result-object v3

    .line 172
    const/4 v10, 0x1

    invoke-virtual {v0, v10}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 173
    const/4 v10, 0x5

    invoke-virtual {v0, v10}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    .line 174
    const/4 v10, 0x6

    invoke-virtual {v0, v10}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    .line 175
    const/4 v10, 0x2

    const/4 v11, 0x0

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    .line 176
    const/4 v10, 0x3

    const/4 v11, 0x1

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v5

    .line 177
    const/4 v10, 0x4

    const/4 v11, 0x1

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v4

    .line 178
    const/4 v10, 0x7

    const/4 v11, -0x1

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v6

    .line 179
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 192
    :cond_0
    if-eqz v3, :cond_1

    .line 193
    new-instance v10, Landroid/widget/ArrayAdapter;

    const v11, 0x1090003

    invoke-direct {v10, p1, v11, v3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    invoke-virtual {p0, v10}, Lit/sephiroth/android/library/widget/HListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 196
    :cond_1
    if-eqz v1, :cond_2

    .line 198
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 201
    :cond_2
    if-eqz v8, :cond_3

    .line 202
    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->setOverscrollHeader(Landroid/graphics/drawable/Drawable;)V

    .line 205
    :cond_3
    if-eqz v7, :cond_4

    .line 206
    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/HListView;->setOverscrollFooter(Landroid/graphics/drawable/Drawable;)V

    .line 210
    :cond_4
    if-eqz v2, :cond_5

    .line 211
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/HListView;->setDividerWidth(I)V

    .line 214
    :cond_5
    iput-boolean v5, p0, Lit/sephiroth/android/library/widget/HListView;->mHeaderDividersEnabled:Z

    .line 215
    iput-boolean v4, p0, Lit/sephiroth/android/library/widget/HListView;->mFooterDividersEnabled:Z

    .line 216
    iput v6, p0, Lit/sephiroth/android/library/widget/HListView;->mMeasureWithChild:I

    .line 218
    return-void
.end method

.method private addViewAfter(Landroid/view/View;I)Landroid/view/View;
    .locals 8
    .param p1, "theView"    # Landroid/view/View;
    .param p2, "position"    # I

    .prologue
    const/4 v6, 0x0

    .line 3092
    add-int/lit8 v2, p2, 0x1

    .line 3093
    .local v2, "belowPosition":I
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mIsScrap:[Z

    invoke-virtual {p0, v2, v0}, Lit/sephiroth/android/library/widget/HListView;->obtainView(I[Z)Landroid/view/View;

    move-result-object v1

    .line 3094
    .local v1, "view":Landroid/view/View;
    invoke-virtual {p1}, Landroid/view/View;->getRight()I

    move-result v0

    iget v4, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    add-int v3, v0, v4

    .line 3095
    .local v3, "edgeOfNewChild":I
    const/4 v4, 0x1

    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v5, v0, Landroid/graphics/Rect;->top:I

    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mIsScrap:[Z

    aget-boolean v7, v0, v6

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lit/sephiroth/android/library/widget/HListView;->setupChild(Landroid/view/View;IIZIZZ)V

    .line 3096
    return-object v1
.end method

.method private addViewBefore(Landroid/view/View;I)Landroid/view/View;
    .locals 8
    .param p1, "theView"    # Landroid/view/View;
    .param p2, "position"    # I

    .prologue
    const/4 v4, 0x0

    .line 3084
    add-int/lit8 v2, p2, -0x1

    .line 3085
    .local v2, "abovePosition":I
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mIsScrap:[Z

    invoke-virtual {p0, v2, v0}, Lit/sephiroth/android/library/widget/HListView;->obtainView(I[Z)Landroid/view/View;

    move-result-object v1

    .line 3086
    .local v1, "view":Landroid/view/View;
    invoke-virtual {p1}, Landroid/view/View;->getLeft()I

    move-result v0

    iget v5, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    sub-int v3, v0, v5

    .line 3087
    .local v3, "edgeOfNewChild":I
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v5, v0, Landroid/graphics/Rect;->top:I

    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mIsScrap:[Z

    aget-boolean v7, v0, v4

    move-object v0, p0

    move v6, v4

    invoke-direct/range {v0 .. v7}, Lit/sephiroth/android/library/widget/HListView;->setupChild(Landroid/view/View;IIZIZZ)V

    .line 3088
    return-object v1
.end method

.method private adjustViewsLeftOrRight()V
    .locals 6

    .prologue
    .line 231
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v1

    .line 234
    .local v1, "childCount":I
    if-lez v1, :cond_2

    .line 237
    iget-boolean v3, p0, Lit/sephiroth/android/library/widget/HListView;->mStackFromRight:Z

    if-nez v3, :cond_3

    .line 240
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 241
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v3

    iget-object v4, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->left:I

    sub-int v2, v3, v4

    .line 242
    .local v2, "delta":I
    iget v3, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    if-eqz v3, :cond_0

    .line 245
    iget v3, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    sub-int/2addr v2, v3

    .line 247
    :cond_0
    if-gez v2, :cond_1

    .line 249
    const/4 v2, 0x0

    .line 267
    :cond_1
    :goto_0
    if-eqz v2, :cond_2

    .line 268
    neg-int v3, v2

    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/HListView;->offsetChildrenLeftAndRight(I)V

    .line 271
    .end local v0    # "child":Landroid/view/View;
    .end local v2    # "delta":I
    :cond_2
    return-void

    .line 253
    :cond_3
    add-int/lit8 v3, v1, -0x1

    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 254
    .restart local v0    # "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v3

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getWidth()I

    move-result v4

    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->right:I

    sub-int/2addr v4, v5

    sub-int v2, v3, v4

    .line 256
    .restart local v2    # "delta":I
    iget v3, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v3, v1

    iget v4, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    if-ge v3, v4, :cond_4

    .line 259
    iget v3, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    add-int/2addr v2, v3

    .line 262
    :cond_4
    if-lez v2, :cond_1

    .line 263
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private amountToScroll(II)I
    .locals 12
    .param p1, "direction"    # I
    .param p2, "nextSelectedPosition"    # I

    .prologue
    .line 2698
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getWidth()I

    move-result v10

    iget-object v11, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v11, v11, Landroid/graphics/Rect;->right:I

    sub-int v5, v10, v11

    .line 2699
    .local v5, "listRight":I
    iget-object v10, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v4, v10, Landroid/graphics/Rect;->left:I

    .line 2701
    .local v4, "listLeft":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v7

    .line 2703
    .local v7, "numChildren":I
    const/16 v10, 0x82

    if-ne p1, v10, :cond_5

    .line 2704
    add-int/lit8 v3, v7, -0x1

    .line 2705
    .local v3, "indexToMakeVisible":I
    const/4 v10, -0x1

    if-eq p2, v10, :cond_0

    .line 2706
    iget v10, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    sub-int v3, p2, v10

    .line 2709
    :cond_0
    iget v10, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int v8, v10, v3

    .line 2710
    .local v8, "positionToMakeVisible":I
    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    .line 2712
    .local v9, "viewToMakeVisible":Landroid/view/View;
    move v2, v5

    .line 2713
    .local v2, "goalRight":I
    iget v10, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v10, v10, -0x1

    if-ge v8, v10, :cond_1

    .line 2714
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->getArrowScrollPreviewLength()I

    move-result v10

    sub-int/2addr v2, v10

    .line 2717
    :cond_1
    invoke-virtual {v9}, Landroid/view/View;->getRight()I

    move-result v10

    if-gt v10, v2, :cond_2

    .line 2719
    const/4 v10, 0x0

    .line 2765
    .end local v2    # "goalRight":I
    :goto_0
    return v10

    .line 2722
    .restart local v2    # "goalRight":I
    :cond_2
    const/4 v10, -0x1

    if-eq p2, v10, :cond_3

    invoke-virtual {v9}, Landroid/view/View;->getLeft()I

    move-result v10

    sub-int v10, v2, v10

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getMaxScrollAmount()I

    move-result v11

    if-lt v10, v11, :cond_3

    .line 2725
    const/4 v10, 0x0

    goto :goto_0

    .line 2728
    :cond_3
    invoke-virtual {v9}, Landroid/view/View;->getRight()I

    move-result v10

    sub-int v0, v10, v2

    .line 2730
    .local v0, "amountToScroll":I
    iget v10, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v10, v7

    iget v11, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    if-ne v10, v11, :cond_4

    .line 2732
    add-int/lit8 v10, v7, -0x1

    invoke-virtual {p0, v10}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v10

    invoke-virtual {v10}, Landroid/view/View;->getRight()I

    move-result v10

    sub-int v6, v10, v5

    .line 2733
    .local v6, "max":I
    invoke-static {v0, v6}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2736
    .end local v6    # "max":I
    :cond_4
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getMaxScrollAmount()I

    move-result v10

    invoke-static {v0, v10}, Ljava/lang/Math;->min(II)I

    move-result v10

    goto :goto_0

    .line 2738
    .end local v0    # "amountToScroll":I
    .end local v2    # "goalRight":I
    .end local v3    # "indexToMakeVisible":I
    .end local v8    # "positionToMakeVisible":I
    .end local v9    # "viewToMakeVisible":Landroid/view/View;
    :cond_5
    const/4 v3, 0x0

    .line 2739
    .restart local v3    # "indexToMakeVisible":I
    const/4 v10, -0x1

    if-eq p2, v10, :cond_6

    .line 2740
    iget v10, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    sub-int v3, p2, v10

    .line 2742
    :cond_6
    iget v10, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int v8, v10, v3

    .line 2743
    .restart local v8    # "positionToMakeVisible":I
    invoke-virtual {p0, v3}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    .line 2744
    .restart local v9    # "viewToMakeVisible":Landroid/view/View;
    move v1, v4

    .line 2745
    .local v1, "goalLeft":I
    if-lez v8, :cond_7

    .line 2746
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->getArrowScrollPreviewLength()I

    move-result v10

    add-int/2addr v1, v10

    .line 2748
    :cond_7
    invoke-virtual {v9}, Landroid/view/View;->getLeft()I

    move-result v10

    if-lt v10, v1, :cond_8

    .line 2750
    const/4 v10, 0x0

    goto :goto_0

    .line 2753
    :cond_8
    const/4 v10, -0x1

    if-eq p2, v10, :cond_9

    invoke-virtual {v9}, Landroid/view/View;->getRight()I

    move-result v10

    sub-int/2addr v10, v1

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getMaxScrollAmount()I

    move-result v11

    if-lt v10, v11, :cond_9

    .line 2756
    const/4 v10, 0x0

    goto :goto_0

    .line 2759
    :cond_9
    invoke-virtual {v9}, Landroid/view/View;->getLeft()I

    move-result v10

    sub-int v0, v1, v10

    .line 2760
    .restart local v0    # "amountToScroll":I
    iget v10, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    if-nez v10, :cond_a

    .line 2762
    const/4 v10, 0x0

    invoke-virtual {p0, v10}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v10

    invoke-virtual {v10}, Landroid/view/View;->getLeft()I

    move-result v10

    sub-int v6, v4, v10

    .line 2763
    .restart local v6    # "max":I
    invoke-static {v0, v6}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2765
    .end local v6    # "max":I
    :cond_a
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getMaxScrollAmount()I

    move-result v10

    invoke-static {v0, v10}, Ljava/lang/Math;->min(II)I

    move-result v10

    goto/16 :goto_0
.end method

.method private amountToScrollToNewFocus(ILandroid/view/View;I)I
    .locals 4
    .param p1, "direction"    # I
    .param p2, "newFocus"    # Landroid/view/View;
    .param p3, "positionOfNewFocus"    # I

    .prologue
    .line 2959
    const/4 v0, 0x0

    .line 2960
    .local v0, "amountToScroll":I
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {p2, v2}, Landroid/view/View;->getDrawingRect(Landroid/graphics/Rect;)V

    .line 2961
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {p0, p2, v2}, Lit/sephiroth/android/library/widget/HListView;->offsetDescendantRectToMyCoords(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 2962
    const/16 v2, 0x21

    if-ne p1, v2, :cond_1

    .line 2963
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->left:I

    iget-object v3, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->left:I

    if-ge v2, v3, :cond_0

    .line 2964
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->left:I

    iget-object v3, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->left:I

    sub-int v0, v2, v3

    .line 2965
    if-lez p3, :cond_0

    .line 2966
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->getArrowScrollPreviewLength()I

    move-result v2

    add-int/2addr v0, v2

    .line 2978
    :cond_0
    :goto_0
    return v0

    .line 2970
    :cond_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getWidth()I

    move-result v2

    iget-object v3, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->right:I

    sub-int v1, v2, v3

    .line 2971
    .local v1, "listRight":I
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->bottom:I

    if-le v2, v1, :cond_0

    .line 2972
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->right:I

    sub-int v0, v2, v1

    .line 2973
    iget v2, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v2, v2, -0x1

    if-ge p3, v2, :cond_0

    .line 2974
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->getArrowScrollPreviewLength()I

    move-result v2

    add-int/2addr v0, v2

    goto :goto_0
.end method

.method private arrowScrollFocused(I)Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;
    .locals 17
    .param p1, "direction"    # I

    .prologue
    .line 2854
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getSelectedView()Landroid/view/View;

    move-result-object v12

    .line 2856
    .local v12, "selectedView":Landroid/view/View;
    if-eqz v12, :cond_2

    invoke-virtual {v12}, Landroid/view/View;->hasFocus()Z

    move-result v14

    if-eqz v14, :cond_2

    .line 2857
    invoke-virtual {v12}, Landroid/view/View;->findFocus()Landroid/view/View;

    move-result-object v8

    .line 2858
    .local v8, "oldFocus":Landroid/view/View;
    invoke-static {}, Landroid/view/FocusFinder;->getInstance()Landroid/view/FocusFinder;

    move-result-object v14

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-virtual {v14, v0, v8, v1}, Landroid/view/FocusFinder;->findNextFocus(Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;

    move-result-object v7

    .line 2883
    .end local v8    # "oldFocus":Landroid/view/View;
    .local v7, "newFocus":Landroid/view/View;
    :goto_0
    if-eqz v7, :cond_c

    .line 2884
    move-object/from16 v0, p0

    invoke-direct {v0, v7}, Lit/sephiroth/android/library/widget/HListView;->positionOfNewFocus(Landroid/view/View;)I

    move-result v9

    .line 2888
    .local v9, "positionOfNewFocus":I
    move-object/from16 v0, p0

    iget v14, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    const/4 v15, -0x1

    if-eq v14, v15, :cond_a

    move-object/from16 v0, p0

    iget v14, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    if-eq v9, v14, :cond_a

    .line 2889
    invoke-direct/range {p0 .. p1}, Lit/sephiroth/android/library/widget/HListView;->lookForSelectablePositionOnScreen(I)I

    move-result v11

    .line 2890
    .local v11, "selectablePosition":I
    const/4 v14, -0x1

    if-eq v11, v14, :cond_a

    const/16 v14, 0x82

    move/from16 v0, p1

    if-ne v0, v14, :cond_0

    if-lt v11, v9, :cond_1

    :cond_0
    const/16 v14, 0x21

    move/from16 v0, p1

    if-ne v0, v14, :cond_a

    if-le v11, v9, :cond_a

    .line 2893
    :cond_1
    const/4 v14, 0x0

    .line 2915
    .end local v9    # "positionOfNewFocus":I
    .end local v11    # "selectablePosition":I
    :goto_1
    return-object v14

    .line 2860
    .end local v7    # "newFocus":Landroid/view/View;
    :cond_2
    const/16 v14, 0x82

    move/from16 v0, p1

    if-ne v0, v14, :cond_6

    .line 2861
    move-object/from16 v0, p0

    iget v14, v0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    if-lez v14, :cond_3

    const/4 v3, 0x1

    .line 2862
    .local v3, "leftFadingEdgeShowing":Z
    :goto_2
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v15, v14, Landroid/graphics/Rect;->left:I

    if-eqz v3, :cond_4

    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getArrowScrollPreviewLength()I

    move-result v14

    :goto_3
    add-int v4, v15, v14

    .line 2864
    .local v4, "listLeft":I
    if-eqz v12, :cond_5

    invoke-virtual {v12}, Landroid/view/View;->getLeft()I

    move-result v14

    if-le v14, v4, :cond_5

    invoke-virtual {v12}, Landroid/view/View;->getLeft()I

    move-result v13

    .line 2868
    .local v13, "xSearchPoint":I
    :goto_4
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    const/4 v15, 0x0

    const/16 v16, 0x0

    move/from16 v0, v16

    invoke-virtual {v14, v13, v15, v13, v0}, Landroid/graphics/Rect;->set(IIII)V

    .line 2880
    .end local v3    # "leftFadingEdgeShowing":Z
    .end local v4    # "listLeft":I
    :goto_5
    invoke-static {}, Landroid/view/FocusFinder;->getInstance()Landroid/view/FocusFinder;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-virtual {v14, v0, v15, v1}, Landroid/view/FocusFinder;->findNextFocusFromRect(Landroid/view/ViewGroup;Landroid/graphics/Rect;I)Landroid/view/View;

    move-result-object v7

    .restart local v7    # "newFocus":Landroid/view/View;
    goto :goto_0

    .line 2861
    .end local v7    # "newFocus":Landroid/view/View;
    .end local v13    # "xSearchPoint":I
    :cond_3
    const/4 v3, 0x0

    goto :goto_2

    .line 2862
    .restart local v3    # "leftFadingEdgeShowing":Z
    :cond_4
    const/4 v14, 0x0

    goto :goto_3

    .restart local v4    # "listLeft":I
    :cond_5
    move v13, v4

    .line 2864
    goto :goto_4

    .line 2870
    .end local v3    # "leftFadingEdgeShowing":Z
    .end local v4    # "listLeft":I
    :cond_6
    move-object/from16 v0, p0

    iget v14, v0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v15

    add-int/2addr v14, v15

    add-int/lit8 v14, v14, -0x1

    move-object/from16 v0, p0

    iget v15, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    if-ge v14, v15, :cond_7

    const/4 v10, 0x1

    .line 2872
    .local v10, "rightFadingEdgeShowing":Z
    :goto_6
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getWidth()I

    move-result v14

    move-object/from16 v0, p0

    iget-object v15, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v15, v15, Landroid/graphics/Rect;->right:I

    sub-int v15, v14, v15

    if-eqz v10, :cond_8

    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getArrowScrollPreviewLength()I

    move-result v14

    :goto_7
    sub-int v5, v15, v14

    .line 2874
    .local v5, "listRight":I
    if-eqz v12, :cond_9

    invoke-virtual {v12}, Landroid/view/View;->getRight()I

    move-result v14

    if-ge v14, v5, :cond_9

    invoke-virtual {v12}, Landroid/view/View;->getRight()I

    move-result v13

    .line 2878
    .restart local v13    # "xSearchPoint":I
    :goto_8
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    const/4 v15, 0x0

    const/16 v16, 0x0

    move/from16 v0, v16

    invoke-virtual {v14, v13, v15, v13, v0}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_5

    .line 2870
    .end local v5    # "listRight":I
    .end local v10    # "rightFadingEdgeShowing":Z
    .end local v13    # "xSearchPoint":I
    :cond_7
    const/4 v10, 0x0

    goto :goto_6

    .line 2872
    .restart local v10    # "rightFadingEdgeShowing":Z
    :cond_8
    const/4 v14, 0x0

    goto :goto_7

    .restart local v5    # "listRight":I
    :cond_9
    move v13, v5

    .line 2874
    goto :goto_8

    .line 2897
    .end local v5    # "listRight":I
    .end local v10    # "rightFadingEdgeShowing":Z
    .restart local v7    # "newFocus":Landroid/view/View;
    .restart local v9    # "positionOfNewFocus":I
    :cond_a
    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v0, v1, v7, v9}, Lit/sephiroth/android/library/widget/HListView;->amountToScrollToNewFocus(ILandroid/view/View;I)I

    move-result v2

    .line 2899
    .local v2, "focusScroll":I
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getMaxScrollAmount()I

    move-result v6

    .line 2900
    .local v6, "maxScrollAmount":I
    if-ge v2, v6, :cond_b

    .line 2902
    move/from16 v0, p1

    invoke-virtual {v7, v0}, Landroid/view/View;->requestFocus(I)Z

    .line 2903
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/HListView;->mArrowScrollFocusResult:Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;

    invoke-virtual {v14, v9, v2}, Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;->populate(II)V

    .line 2904
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/HListView;->mArrowScrollFocusResult:Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;

    goto/16 :goto_1

    .line 2905
    :cond_b
    move-object/from16 v0, p0

    invoke-direct {v0, v7}, Lit/sephiroth/android/library/widget/HListView;->distanceToView(Landroid/view/View;)I

    move-result v14

    if-ge v14, v6, :cond_c

    .line 2910
    move/from16 v0, p1

    invoke-virtual {v7, v0}, Landroid/view/View;->requestFocus(I)Z

    .line 2911
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/HListView;->mArrowScrollFocusResult:Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;

    invoke-virtual {v14, v9, v6}, Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;->populate(II)V

    .line 2912
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/HListView;->mArrowScrollFocusResult:Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;

    goto/16 :goto_1

    .line 2915
    .end local v2    # "focusScroll":I
    .end local v6    # "maxScrollAmount":I
    .end local v9    # "positionOfNewFocus":I
    :cond_c
    const/4 v14, 0x0

    goto/16 :goto_1
.end method

.method private arrowScrollImpl(I)Z
    .locals 11
    .param p1, "direction"    # I

    .prologue
    const/4 v8, 0x1

    const/4 v10, -0x1

    const/4 v9, 0x0

    .line 2476
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v7

    if-gtz v7, :cond_1

    .line 2548
    :cond_0
    :goto_0
    return v9

    .line 2480
    :cond_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getSelectedView()Landroid/view/View;

    move-result-object v6

    .line 2481
    .local v6, "selectedView":Landroid/view/View;
    iget v5, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    .line 2483
    .local v5, "selectedPos":I
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->lookForSelectablePositionOnScreen(I)I

    move-result v4

    .line 2484
    .local v4, "nextSelectedPosition":I
    invoke-direct {p0, p1, v4}, Lit/sephiroth/android/library/widget/HListView;->amountToScroll(II)I

    move-result v0

    .line 2487
    .local v0, "amountToScroll":I
    iget-boolean v7, p0, Lit/sephiroth/android/library/widget/HListView;->mItemsCanFocus:Z

    if-eqz v7, :cond_b

    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->arrowScrollFocused(I)Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;

    move-result-object v1

    .line 2488
    .local v1, "focusResult":Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;
    :goto_1
    if-eqz v1, :cond_2

    .line 2489
    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;->getSelectedPosition()I

    move-result v4

    .line 2490
    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;->getAmountToScroll()I

    move-result v0

    .line 2493
    :cond_2
    if-eqz v1, :cond_c

    move v3, v8

    .line 2494
    .local v3, "needToRedraw":Z
    :goto_2
    if-eq v4, v10, :cond_4

    .line 2495
    if-eqz v1, :cond_d

    move v7, v8

    :goto_3
    invoke-direct {p0, v6, p1, v4, v7}, Lit/sephiroth/android/library/widget/HListView;->handleNewSelectionChange(Landroid/view/View;IIZ)V

    .line 2496
    invoke-virtual {p0, v4}, Lit/sephiroth/android/library/widget/HListView;->setSelectedPositionInt(I)V

    .line 2497
    invoke-virtual {p0, v4}, Lit/sephiroth/android/library/widget/HListView;->setNextSelectedPositionInt(I)V

    .line 2498
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getSelectedView()Landroid/view/View;

    move-result-object v6

    .line 2499
    move v5, v4

    .line 2500
    iget-boolean v7, p0, Lit/sephiroth/android/library/widget/HListView;->mItemsCanFocus:Z

    if-eqz v7, :cond_3

    if-nez v1, :cond_3

    .line 2503
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getFocusedChild()Landroid/view/View;

    move-result-object v2

    .line 2504
    .local v2, "focused":Landroid/view/View;
    if-eqz v2, :cond_3

    .line 2505
    invoke-virtual {v2}, Landroid/view/View;->clearFocus()V

    .line 2508
    .end local v2    # "focused":Landroid/view/View;
    :cond_3
    const/4 v3, 0x1

    .line 2509
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->checkSelectionChanged()V

    .line 2512
    :cond_4
    if-lez v0, :cond_5

    .line 2513
    const/16 v7, 0x21

    if-ne p1, v7, :cond_e

    .end local v0    # "amountToScroll":I
    :goto_4
    invoke-direct {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->scrollListItemsBy(I)V

    .line 2514
    const/4 v3, 0x1

    .line 2519
    :cond_5
    iget-boolean v7, p0, Lit/sephiroth/android/library/widget/HListView;->mItemsCanFocus:Z

    if-eqz v7, :cond_7

    if-nez v1, :cond_7

    if-eqz v6, :cond_7

    invoke-virtual {v6}, Landroid/view/View;->hasFocus()Z

    move-result v7

    if-eqz v7, :cond_7

    .line 2520
    invoke-virtual {v6}, Landroid/view/View;->findFocus()Landroid/view/View;

    move-result-object v2

    .line 2521
    .restart local v2    # "focused":Landroid/view/View;
    invoke-direct {p0, v2, p0}, Lit/sephiroth/android/library/widget/HListView;->isViewAncestorOf(Landroid/view/View;Landroid/view/View;)Z

    move-result v7

    if-eqz v7, :cond_6

    invoke-direct {p0, v2}, Lit/sephiroth/android/library/widget/HListView;->distanceToView(Landroid/view/View;)I

    move-result v7

    if-lez v7, :cond_7

    .line 2522
    :cond_6
    invoke-virtual {v2}, Landroid/view/View;->clearFocus()V

    .line 2527
    .end local v2    # "focused":Landroid/view/View;
    :cond_7
    if-ne v4, v10, :cond_8

    if-eqz v6, :cond_8

    invoke-direct {p0, v6, p0}, Lit/sephiroth/android/library/widget/HListView;->isViewAncestorOf(Landroid/view/View;Landroid/view/View;)Z

    move-result v7

    if-nez v7, :cond_8

    .line 2528
    const/4 v6, 0x0

    .line 2529
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->hideSelector()V

    .line 2533
    iput v10, p0, Lit/sephiroth/android/library/widget/HListView;->mResurrectToPosition:I

    .line 2536
    :cond_8
    if-eqz v3, :cond_0

    .line 2537
    if-eqz v6, :cond_9

    .line 2538
    invoke-virtual {p0, v5, v6}, Lit/sephiroth/android/library/widget/HListView;->positionSelector(ILandroid/view/View;)V

    .line 2539
    invoke-virtual {v6}, Landroid/view/View;->getLeft()I

    move-result v7

    iput v7, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedLeft:I

    .line 2541
    :cond_9
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->awakenScrollBars()Z

    move-result v7

    if-nez v7, :cond_a

    .line 2542
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invalidate()V

    .line 2544
    :cond_a
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invokeOnItemScrollListener()V

    move v9, v8

    .line 2545
    goto/16 :goto_0

    .line 2487
    .end local v1    # "focusResult":Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;
    .end local v3    # "needToRedraw":Z
    .restart local v0    # "amountToScroll":I
    :cond_b
    const/4 v1, 0x0

    goto/16 :goto_1

    .restart local v1    # "focusResult":Lit/sephiroth/android/library/widget/HListView$ArrowScrollFocusResult;
    :cond_c
    move v3, v9

    .line 2493
    goto/16 :goto_2

    .restart local v3    # "needToRedraw":Z
    :cond_d
    move v7, v9

    .line 2495
    goto :goto_3

    .line 2513
    :cond_e
    neg-int v0, v0

    goto :goto_4
.end method

.method private clearRecycledState(Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 531
    .local p1, "infos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;>;"
    if-eqz p1, :cond_1

    .line 532
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 534
    .local v1, "count":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_1

    .line 535
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;

    iget-object v0, v4, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->view:Landroid/view/View;

    .line 536
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .line 537
    .local v3, "p":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    if-eqz v3, :cond_0

    .line 538
    const/4 v4, 0x0

    iput-boolean v4, v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->recycledHeaderFooter:Z

    .line 534
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 542
    .end local v0    # "child":Landroid/view/View;
    .end local v1    # "count":I
    .end local v2    # "i":I
    .end local v3    # "p":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    :cond_1
    return-void
.end method

.method private commonKey(IILandroid/view/KeyEvent;)Z
    .locals 10
    .param p1, "keyCode"    # I
    .param p2, "count"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    const/4 v9, 0x2

    const/16 v8, 0x82

    const/16 v7, 0x21

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 2177
    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v5, :cond_0

    iget-boolean v5, p0, Lit/sephiroth/android/library/widget/HListView;->mIsAttached:Z

    if-nez v5, :cond_1

    .line 2310
    :cond_0
    :goto_0
    return v3

    .line 2181
    :cond_1
    iget-boolean v5, p0, Lit/sephiroth/android/library/widget/HListView;->mDataChanged:Z

    if-eqz v5, :cond_2

    .line 2182
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->layoutChildren()V

    .line 2185
    :cond_2
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0xb

    if-lt v5, v6, :cond_0

    .line 2189
    const/4 v2, 0x0

    .line 2190
    .local v2, "handled":Z
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    .line 2192
    .local v0, "action":I
    if-eq v0, v4, :cond_3

    .line 2193
    sparse-switch p1, :sswitch_data_0

    .line 2295
    :cond_3
    :goto_1
    if-eqz v2, :cond_1e

    move v3, v4

    .line 2296
    goto :goto_0

    .line 2195
    :sswitch_0
    invoke-virtual {p3}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 2196
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v2

    .line 2197
    if-nez v2, :cond_3

    move v1, p2

    .line 2198
    .end local p2    # "count":I
    .local v1, "count":I
    :goto_2
    add-int/lit8 p2, v1, -0x1

    .end local v1    # "count":I
    .restart local p2    # "count":I
    if-lez v1, :cond_3

    .line 2199
    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/HListView;->arrowScroll(I)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2200
    const/4 v2, 0x1

    move v1, p2

    .end local p2    # "count":I
    .restart local v1    # "count":I
    goto :goto_2

    .line 2206
    .end local v1    # "count":I
    .restart local p2    # "count":I
    :cond_4
    invoke-virtual {p3, v9}, Landroid/view/KeyEvent;->hasModifiers(I)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2207
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v5

    if-nez v5, :cond_5

    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/HListView;->fullScroll(I)Z

    move-result v5

    if-eqz v5, :cond_6

    :cond_5
    move v2, v4

    :goto_3
    goto :goto_1

    :cond_6
    move v2, v3

    goto :goto_3

    .line 2212
    :sswitch_1
    invoke-virtual {p3}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v5

    if-eqz v5, :cond_7

    .line 2213
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v2

    .line 2214
    if-nez v2, :cond_3

    move v1, p2

    .line 2215
    .end local p2    # "count":I
    .restart local v1    # "count":I
    :goto_4
    add-int/lit8 p2, v1, -0x1

    .end local v1    # "count":I
    .restart local p2    # "count":I
    if-lez v1, :cond_3

    .line 2216
    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->arrowScroll(I)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2217
    const/4 v2, 0x1

    move v1, p2

    .end local p2    # "count":I
    .restart local v1    # "count":I
    goto :goto_4

    .line 2223
    .end local v1    # "count":I
    .restart local p2    # "count":I
    :cond_7
    invoke-virtual {p3, v9}, Landroid/view/KeyEvent;->hasModifiers(I)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2224
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v5

    if-nez v5, :cond_8

    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->fullScroll(I)Z

    move-result v5

    if-eqz v5, :cond_9

    :cond_8
    move v2, v4

    :goto_5
    goto :goto_1

    :cond_9
    move v2, v3

    goto :goto_5

    .line 2229
    :sswitch_2
    invoke-virtual {p3}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2230
    const/16 v5, 0x11

    invoke-direct {p0, v5}, Lit/sephiroth/android/library/widget/HListView;->handleHorizontalFocusWithinListItem(I)Z

    move-result v2

    goto :goto_1

    .line 2235
    :sswitch_3
    invoke-virtual {p3}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2236
    const/16 v5, 0x42

    invoke-direct {p0, v5}, Lit/sephiroth/android/library/widget/HListView;->handleHorizontalFocusWithinListItem(I)Z

    move-result v2

    goto :goto_1

    .line 2242
    :sswitch_4
    invoke-virtual {p3}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2243
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v2

    .line 2244
    if-nez v2, :cond_3

    invoke-virtual {p3}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v5

    if-nez v5, :cond_3

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v5

    if-lez v5, :cond_3

    .line 2246
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->keyPressed()V

    .line 2247
    const/4 v2, 0x1

    goto/16 :goto_1

    .line 2254
    :sswitch_5
    invoke-virtual {p3}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v5

    if-eqz v5, :cond_d

    .line 2255
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v5

    if-nez v5, :cond_a

    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->pageScroll(I)Z

    move-result v5

    if-eqz v5, :cond_c

    :cond_a
    move v2, v4

    .line 2259
    :cond_b
    :goto_6
    const/4 v2, 0x1

    .line 2260
    goto/16 :goto_1

    :cond_c
    move v2, v3

    .line 2255
    goto :goto_6

    .line 2256
    :cond_d
    invoke-virtual {p3, v4}, Landroid/view/KeyEvent;->hasModifiers(I)Z

    move-result v5

    if-eqz v5, :cond_b

    .line 2257
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v5

    if-nez v5, :cond_e

    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/HListView;->pageScroll(I)Z

    move-result v5

    if-eqz v5, :cond_f

    :cond_e
    move v2, v4

    :goto_7
    goto :goto_6

    :cond_f
    move v2, v3

    goto :goto_7

    .line 2263
    :sswitch_6
    invoke-virtual {p3}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v5

    if-eqz v5, :cond_12

    .line 2264
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v5

    if-nez v5, :cond_10

    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/HListView;->pageScroll(I)Z

    move-result v5

    if-eqz v5, :cond_11

    :cond_10
    move v2, v4

    :goto_8
    goto/16 :goto_1

    :cond_11
    move v2, v3

    goto :goto_8

    .line 2265
    :cond_12
    invoke-virtual {p3, v9}, Landroid/view/KeyEvent;->hasModifiers(I)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2266
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v5

    if-nez v5, :cond_13

    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/HListView;->fullScroll(I)Z

    move-result v5

    if-eqz v5, :cond_14

    :cond_13
    move v2, v4

    :goto_9
    goto/16 :goto_1

    :cond_14
    move v2, v3

    goto :goto_9

    .line 2271
    :sswitch_7
    invoke-virtual {p3}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v5

    if-eqz v5, :cond_17

    .line 2272
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v5

    if-nez v5, :cond_15

    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->pageScroll(I)Z

    move-result v5

    if-eqz v5, :cond_16

    :cond_15
    move v2, v4

    :goto_a
    goto/16 :goto_1

    :cond_16
    move v2, v3

    goto :goto_a

    .line 2273
    :cond_17
    invoke-virtual {p3, v9}, Landroid/view/KeyEvent;->hasModifiers(I)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2274
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v5

    if-nez v5, :cond_18

    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->fullScroll(I)Z

    move-result v5

    if-eqz v5, :cond_19

    :cond_18
    move v2, v4

    :goto_b
    goto/16 :goto_1

    :cond_19
    move v2, v3

    goto :goto_b

    .line 2279
    :sswitch_8
    invoke-virtual {p3}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2280
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v5

    if-nez v5, :cond_1a

    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/HListView;->fullScroll(I)Z

    move-result v5

    if-eqz v5, :cond_1b

    :cond_1a
    move v2, v4

    :goto_c
    goto/16 :goto_1

    :cond_1b
    move v2, v3

    goto :goto_c

    .line 2285
    :sswitch_9
    invoke-virtual {p3}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2286
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resurrectSelectionIfNeeded()Z

    move-result v5

    if-nez v5, :cond_1c

    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->fullScroll(I)Z

    move-result v5

    if-eqz v5, :cond_1d

    :cond_1c
    move v2, v4

    :goto_d
    goto/16 :goto_1

    :cond_1d
    move v2, v3

    goto :goto_d

    .line 2299
    :cond_1e
    packed-switch v0, :pswitch_data_0

    goto/16 :goto_0

    .line 2301
    :pswitch_0
    invoke-super {p0, p1, p3}, Lit/sephiroth/android/library/widget/AbsHListView;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v3

    goto/16 :goto_0

    .line 2304
    :pswitch_1
    invoke-super {p0, p1, p3}, Lit/sephiroth/android/library/widget/AbsHListView;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v3

    goto/16 :goto_0

    .line 2307
    :pswitch_2
    invoke-super {p0, p1, p2, p3}, Lit/sephiroth/android/library/widget/AbsHListView;->onKeyMultiple(IILandroid/view/KeyEvent;)Z

    move-result v3

    goto/16 :goto_0

    .line 2193
    :sswitch_data_0
    .sparse-switch
        0x13 -> :sswitch_0
        0x14 -> :sswitch_1
        0x15 -> :sswitch_2
        0x16 -> :sswitch_3
        0x17 -> :sswitch_4
        0x3e -> :sswitch_5
        0x42 -> :sswitch_4
        0x5c -> :sswitch_6
        0x5d -> :sswitch_7
        0x7a -> :sswitch_8
        0x7b -> :sswitch_9
    .end sparse-switch

    .line 2299
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private correctTooSmall(I)V
    .locals 11
    .param p1, "childCount"    # I

    .prologue
    .line 1484
    iget v8, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    if-nez v8, :cond_2

    if-lez p1, :cond_2

    .line 1487
    const/4 v8, 0x0

    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 1490
    .local v1, "firstChild":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v2

    .line 1493
    .local v2, "firstLeft":I
    iget-object v8, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v8, Landroid/graphics/Rect;->left:I

    .line 1496
    .local v7, "start":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getRight()I

    move-result v8

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getLeft()I

    move-result v9

    sub-int/2addr v8, v9

    iget-object v9, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->right:I

    sub-int v0, v8, v9

    .line 1500
    .local v0, "end":I
    sub-int v6, v2, v7

    .line 1501
    .local v6, "leftOffset":I
    add-int/lit8 v8, p1, -0x1

    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 1502
    .local v3, "lastChild":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v5

    .line 1503
    .local v5, "lastRight":I
    iget v8, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v8, p1

    add-int/lit8 v4, v8, -0x1

    .line 1507
    .local v4, "lastPosition":I
    if-lez v6, :cond_2

    .line 1508
    iget v8, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v8, v8, -0x1

    if-lt v4, v8, :cond_0

    if-le v5, v0, :cond_3

    .line 1509
    :cond_0
    iget v8, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v8, v8, -0x1

    if-ne v4, v8, :cond_1

    .line 1511
    sub-int v8, v5, v0

    invoke-static {v6, v8}, Ljava/lang/Math;->min(II)I

    move-result v6

    .line 1514
    :cond_1
    neg-int v8, v6

    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->offsetChildrenLeftAndRight(I)V

    .line 1515
    iget v8, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v8, v8, -0x1

    if-ge v4, v8, :cond_2

    .line 1518
    add-int/lit8 v8, v4, 0x1

    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v9

    iget v10, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    add-int/2addr v9, v10

    invoke-direct {p0, v8, v9}, Lit/sephiroth/android/library/widget/HListView;->fillRight(II)Landroid/view/View;

    .line 1520
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->adjustViewsLeftOrRight()V

    .line 1527
    .end local v0    # "end":I
    .end local v1    # "firstChild":Landroid/view/View;
    .end local v2    # "firstLeft":I
    .end local v3    # "lastChild":Landroid/view/View;
    .end local v4    # "lastPosition":I
    .end local v5    # "lastRight":I
    .end local v6    # "leftOffset":I
    .end local v7    # "start":I
    :cond_2
    :goto_0
    return-void

    .line 1522
    .restart local v0    # "end":I
    .restart local v1    # "firstChild":Landroid/view/View;
    .restart local v2    # "firstLeft":I
    .restart local v3    # "lastChild":Landroid/view/View;
    .restart local v4    # "lastPosition":I
    .restart local v5    # "lastRight":I
    .restart local v6    # "leftOffset":I
    .restart local v7    # "start":I
    :cond_3
    iget v8, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v8, v8, -0x1

    if-ne v4, v8, :cond_2

    .line 1523
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->adjustViewsLeftOrRight()V

    goto :goto_0
.end method

.method private correctTooWide(I)V
    .locals 10
    .param p1, "childCount"    # I

    .prologue
    .line 1435
    iget v7, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v7, p1

    add-int/lit8 v4, v7, -0x1

    .line 1436
    .local v4, "lastPosition":I
    iget v7, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v7, v7, -0x1

    if-ne v4, v7, :cond_2

    if-lez p1, :cond_2

    .line 1439
    add-int/lit8 v7, p1, -0x1

    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 1442
    .local v3, "lastChild":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v5

    .line 1445
    .local v5, "lastRight":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getRight()I

    move-result v7

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getLeft()I

    move-result v8

    sub-int/2addr v7, v8

    iget-object v8, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v8, v8, Landroid/graphics/Rect;->right:I

    sub-int v0, v7, v8

    .line 1449
    .local v0, "end":I
    sub-int v6, v0, v5

    .line 1450
    .local v6, "rightOffset":I
    const/4 v7, 0x0

    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 1451
    .local v1, "firstChild":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v2

    .line 1455
    .local v2, "firstLeft":I
    if-lez v6, :cond_2

    iget v7, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    if-gtz v7, :cond_0

    iget-object v7, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->top:I

    if-ge v2, v7, :cond_2

    .line 1456
    :cond_0
    iget v7, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    if-nez v7, :cond_1

    .line 1458
    iget-object v7, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->top:I

    sub-int/2addr v7, v2

    invoke-static {v6, v7}, Ljava/lang/Math;->min(II)I

    move-result v6

    .line 1461
    :cond_1
    invoke-virtual {p0, v6}, Lit/sephiroth/android/library/widget/HListView;->offsetChildrenLeftAndRight(I)V

    .line 1462
    iget v7, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    if-lez v7, :cond_2

    .line 1465
    iget v7, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/lit8 v7, v7, -0x1

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v8

    iget v9, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    sub-int/2addr v8, v9

    invoke-direct {p0, v7, v8}, Lit/sephiroth/android/library/widget/HListView;->fillLeft(II)Landroid/view/View;

    .line 1467
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->adjustViewsLeftOrRight()V

    .line 1472
    .end local v0    # "end":I
    .end local v1    # "firstChild":Landroid/view/View;
    .end local v2    # "firstLeft":I
    .end local v3    # "lastChild":Landroid/view/View;
    .end local v5    # "lastRight":I
    .end local v6    # "rightOffset":I
    :cond_2
    return-void
.end method

.method private distanceToView(Landroid/view/View;)I
    .locals 4
    .param p1, "descendant"    # Landroid/view/View;

    .prologue
    .line 2989
    const/4 v0, 0x0

    .line 2990
    .local v0, "distance":I
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {p1, v2}, Landroid/view/View;->getDrawingRect(Landroid/graphics/Rect;)V

    .line 2991
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {p0, p1, v2}, Lit/sephiroth/android/library/widget/HListView;->offsetDescendantRectToMyCoords(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 2992
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getRight()I

    move-result v2

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getLeft()I

    move-result v3

    sub-int/2addr v2, v3

    iget-object v3, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->right:I

    sub-int v1, v2, v3

    .line 2993
    .local v1, "listRight":I
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->right:I

    iget-object v3, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->left:I

    if-ge v2, v3, :cond_1

    .line 2994
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->left:I

    iget-object v3, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->right:I

    sub-int v0, v2, v3

    .line 2998
    :cond_0
    :goto_0
    return v0

    .line 2995
    :cond_1
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->left:I

    if-le v2, v1, :cond_0

    .line 2996
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->left:I

    sub-int v0, v2, v1

    goto :goto_0
.end method

.method private fillBeforeAndAfter(Landroid/view/View;I)V
    .locals 3
    .param p1, "sel"    # Landroid/view/View;
    .param p2, "position"    # I

    .prologue
    .line 800
    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    .line 801
    .local v0, "dividerWidth":I
    iget-boolean v1, p0, Lit/sephiroth/android/library/widget/HListView;->mStackFromRight:Z

    if-nez v1, :cond_0

    .line 802
    add-int/lit8 v1, p2, -0x1

    invoke-virtual {p1}, Landroid/view/View;->getLeft()I

    move-result v2

    sub-int/2addr v2, v0

    invoke-direct {p0, v1, v2}, Lit/sephiroth/android/library/widget/HListView;->fillLeft(II)Landroid/view/View;

    .line 803
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->adjustViewsLeftOrRight()V

    .line 804
    add-int/lit8 v1, p2, 0x1

    invoke-virtual {p1}, Landroid/view/View;->getRight()I

    move-result v2

    add-int/2addr v2, v0

    invoke-direct {p0, v1, v2}, Lit/sephiroth/android/library/widget/HListView;->fillRight(II)Landroid/view/View;

    .line 810
    :goto_0
    return-void

    .line 806
    :cond_0
    add-int/lit8 v1, p2, 0x1

    invoke-virtual {p1}, Landroid/view/View;->getRight()I

    move-result v2

    add-int/2addr v2, v0

    invoke-direct {p0, v1, v2}, Lit/sephiroth/android/library/widget/HListView;->fillRight(II)Landroid/view/View;

    .line 807
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->adjustViewsLeftOrRight()V

    .line 808
    add-int/lit8 v1, p2, -0x1

    invoke-virtual {p1}, Landroid/view/View;->getLeft()I

    move-result v2

    sub-int/2addr v2, v0

    invoke-direct {p0, v1, v2}, Lit/sephiroth/android/library/widget/HListView;->fillLeft(II)Landroid/view/View;

    goto :goto_0
.end method

.method private fillFromLeft(I)Landroid/view/View;
    .locals 2
    .param p1, "nextLeft"    # I

    .prologue
    .line 749
    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    .line 750
    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v1, v1, -0x1

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    .line 751
    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    if-gez v0, :cond_0

    .line 752
    const/4 v0, 0x0

    iput v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    .line 754
    :cond_0
    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    invoke-direct {p0, v0, p1}, Lit/sephiroth/android/library/widget/HListView;->fillRight(II)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private fillFromMiddle(II)Landroid/view/View;
    .locals 9
    .param p1, "childrenLeft"    # I
    .param p2, "childrenRight"    # I

    .prologue
    const/4 v3, 0x1

    .line 768
    sub-int v8, p2, p1

    .line 770
    .local v8, "width":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->reconcileSelectedPosition()I

    move-result v1

    .line 772
    .local v1, "position":I
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v4, v0, Landroid/graphics/Rect;->top:I

    move-object v0, p0

    move v2, p1

    move v5, v3

    invoke-direct/range {v0 .. v5}, Lit/sephiroth/android/library/widget/HListView;->makeAndAddView(IIZIZ)Landroid/view/View;

    move-result-object v6

    .line 773
    .local v6, "sel":Landroid/view/View;
    iput v1, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    .line 775
    invoke-virtual {v6}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    .line 776
    .local v7, "selWidth":I
    if-gt v7, v8, :cond_0

    .line 777
    sub-int v0, v8, v7

    div-int/lit8 v0, v0, 0x2

    invoke-virtual {v6, v0}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 780
    :cond_0
    invoke-direct {p0, v6, v1}, Lit/sephiroth/android/library/widget/HListView;->fillBeforeAndAfter(Landroid/view/View;I)V

    .line 782
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/HListView;->mStackFromRight:Z

    if-nez v0, :cond_1

    .line 783
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v0

    invoke-direct {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->correctTooWide(I)V

    .line 788
    :goto_0
    return-object v6

    .line 785
    :cond_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v0

    invoke-direct {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->correctTooSmall(I)V

    goto :goto_0
.end method

.method private fillFromSelection(III)Landroid/view/View;
    .locals 14
    .param p1, "selectedLeft"    # I
    .param p2, "childrenLeft"    # I
    .param p3, "childrenRight"    # I

    .prologue
    .line 825
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getHorizontalFadingEdgeLength()I

    move-result v7

    .line 826
    .local v7, "fadingEdgeLength":I
    iget v2, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    .line 830
    .local v2, "selectedPosition":I
    move/from16 v0, p2

    invoke-direct {p0, v0, v7, v2}, Lit/sephiroth/android/library/widget/HListView;->getLeftSelectionPixel(III)I

    move-result v8

    .line 831
    .local v8, "leftSelectionPixel":I
    move/from16 v0, p3

    invoke-direct {p0, v0, v7, v2}, Lit/sephiroth/android/library/widget/HListView;->getRightSelectionPixel(III)I

    move-result v10

    .line 833
    .local v10, "rightSelectionPixel":I
    const/4 v4, 0x1

    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v5, v1, Landroid/graphics/Rect;->top:I

    const/4 v6, 0x1

    move-object v1, p0

    move v3, p1

    invoke-direct/range {v1 .. v6}, Lit/sephiroth/android/library/widget/HListView;->makeAndAddView(IIZIZ)Landroid/view/View;

    move-result-object v11

    .line 836
    .local v11, "sel":Landroid/view/View;
    invoke-virtual {v11}, Landroid/view/View;->getRight()I

    move-result v1

    if-le v1, v10, :cond_1

    .line 839
    invoke-virtual {v11}, Landroid/view/View;->getLeft()I

    move-result v1

    sub-int v13, v1, v8

    .line 843
    .local v13, "spaceBefore":I
    invoke-virtual {v11}, Landroid/view/View;->getRight()I

    move-result v1

    sub-int v12, v1, v10

    .line 844
    .local v12, "spaceAfter":I
    invoke-static {v13, v12}, Ljava/lang/Math;->min(II)I

    move-result v9

    .line 847
    .local v9, "offset":I
    neg-int v1, v9

    invoke-virtual {v11, v1}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 863
    .end local v9    # "offset":I
    .end local v12    # "spaceAfter":I
    .end local v13    # "spaceBefore":I
    :cond_0
    :goto_0
    invoke-direct {p0, v11, v2}, Lit/sephiroth/android/library/widget/HListView;->fillBeforeAndAfter(Landroid/view/View;I)V

    .line 865
    iget-boolean v1, p0, Lit/sephiroth/android/library/widget/HListView;->mStackFromRight:Z

    if-nez v1, :cond_2

    .line 866
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v1

    invoke-direct {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->correctTooWide(I)V

    .line 871
    :goto_1
    return-object v11

    .line 848
    :cond_1
    invoke-virtual {v11}, Landroid/view/View;->getLeft()I

    move-result v1

    if-ge v1, v8, :cond_0

    .line 851
    invoke-virtual {v11}, Landroid/view/View;->getLeft()I

    move-result v1

    sub-int v13, v8, v1

    .line 855
    .restart local v13    # "spaceBefore":I
    invoke-virtual {v11}, Landroid/view/View;->getRight()I

    move-result v1

    sub-int v12, v10, v1

    .line 856
    .restart local v12    # "spaceAfter":I
    invoke-static {v13, v12}, Ljava/lang/Math;->min(II)I

    move-result v9

    .line 859
    .restart local v9    # "offset":I
    invoke-virtual {v11, v9}, Landroid/view/View;->offsetLeftAndRight(I)V

    goto :goto_0

    .line 868
    .end local v9    # "offset":I
    .end local v12    # "spaceAfter":I
    .end local v13    # "spaceBefore":I
    :cond_2
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v1

    invoke-direct {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->correctTooSmall(I)V

    goto :goto_1
.end method

.method private fillLeft(II)Landroid/view/View;
    .locals 9
    .param p1, "pos"    # I
    .param p2, "nextRight"    # I

    .prologue
    const/4 v3, 0x0

    .line 717
    const/4 v8, 0x0

    .line 719
    .local v8, "selectedView":Landroid/view/View;
    const/4 v7, 0x0

    .line 724
    .local v7, "end":I
    :goto_0
    if-le p2, v7, :cond_2

    if-ltz p1, :cond_2

    .line 726
    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    if-ne p1, v0, :cond_1

    const/4 v5, 0x1

    .line 727
    .local v5, "selected":Z
    :goto_1
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v4, v0, Landroid/graphics/Rect;->top:I

    move-object v0, p0

    move v1, p1

    move v2, p2

    invoke-direct/range {v0 .. v5}, Lit/sephiroth/android/library/widget/HListView;->makeAndAddView(IIZIZ)Landroid/view/View;

    move-result-object v6

    .line 728
    .local v6, "child":Landroid/view/View;
    invoke-virtual {v6}, Landroid/view/View;->getLeft()I

    move-result v0

    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    sub-int p2, v0, v1

    .line 729
    if-eqz v5, :cond_0

    .line 730
    move-object v8, v6

    .line 732
    :cond_0
    add-int/lit8 p1, p1, -0x1

    .line 733
    goto :goto_0

    .end local v5    # "selected":Z
    .end local v6    # "child":Landroid/view/View;
    :cond_1
    move v5, v3

    .line 726
    goto :goto_1

    .line 735
    :cond_2
    add-int/lit8 v0, p1, 0x1

    iput v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    .line 736
    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v2

    add-int/2addr v1, v2

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p0, v0, v1}, Lit/sephiroth/android/library/widget/HListView;->setVisibleRangeHint(II)V

    .line 737
    return-object v8
.end method

.method private fillRight(II)Landroid/view/View;
    .locals 9
    .param p1, "pos"    # I
    .param p2, "nextLeft"    # I

    .prologue
    const/4 v3, 0x1

    .line 682
    const/4 v8, 0x0

    .line 684
    .local v8, "selectedView":Landroid/view/View;
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getRight()I

    move-result v0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getLeft()I

    move-result v1

    sub-int v7, v0, v1

    .line 689
    .local v7, "end":I
    :goto_0
    if-ge p2, v7, :cond_2

    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    if-ge p1, v0, :cond_2

    .line 691
    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    if-ne p1, v0, :cond_1

    move v5, v3

    .line 692
    .local v5, "selected":Z
    :goto_1
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v4, v0, Landroid/graphics/Rect;->top:I

    move-object v0, p0

    move v1, p1

    move v2, p2

    invoke-direct/range {v0 .. v5}, Lit/sephiroth/android/library/widget/HListView;->makeAndAddView(IIZIZ)Landroid/view/View;

    move-result-object v6

    .line 694
    .local v6, "child":Landroid/view/View;
    invoke-virtual {v6}, Landroid/view/View;->getRight()I

    move-result v0

    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    add-int p2, v0, v1

    .line 695
    if-eqz v5, :cond_0

    .line 696
    move-object v8, v6

    .line 698
    :cond_0
    add-int/lit8 p1, p1, 0x1

    .line 699
    goto :goto_0

    .line 691
    .end local v5    # "selected":Z
    .end local v6    # "child":Landroid/view/View;
    :cond_1
    const/4 v5, 0x0

    goto :goto_1

    .line 701
    :cond_2
    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v2

    add-int/2addr v1, v2

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p0, v0, v1}, Lit/sephiroth/android/library/widget/HListView;->setVisibleRangeHint(II)V

    .line 702
    return-object v8
.end method

.method private fillSpecific(II)Landroid/view/View;
    .locals 11
    .param p1, "position"    # I
    .param p2, "left"    # I

    .prologue
    const/4 v3, 0x1

    .line 1387
    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    if-ne p1, v0, :cond_1

    move v5, v3

    .line 1388
    .local v5, "tempIsSelected":Z
    :goto_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v4, v0, Landroid/graphics/Rect;->top:I

    move-object v0, p0

    move v1, p1

    move v2, p2

    invoke-direct/range {v0 .. v5}, Lit/sephiroth/android/library/widget/HListView;->makeAndAddView(IIZIZ)Landroid/view/View;

    move-result-object v10

    .line 1390
    .local v10, "temp":Landroid/view/View;
    iput p1, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    .line 1395
    iget v9, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    .line 1396
    .local v9, "dividerWidth":I
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/HListView;->mStackFromRight:Z

    if-nez v0, :cond_2

    .line 1397
    add-int/lit8 v0, p1, -0x1

    invoke-virtual {v10}, Landroid/view/View;->getLeft()I

    move-result v1

    sub-int/2addr v1, v9

    invoke-direct {p0, v0, v1}, Lit/sephiroth/android/library/widget/HListView;->fillLeft(II)Landroid/view/View;

    move-result-object v7

    .line 1399
    .local v7, "before":Landroid/view/View;
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->adjustViewsLeftOrRight()V

    .line 1400
    add-int/lit8 v0, p1, 0x1

    invoke-virtual {v10}, Landroid/view/View;->getRight()I

    move-result v1

    add-int/2addr v1, v9

    invoke-direct {p0, v0, v1}, Lit/sephiroth/android/library/widget/HListView;->fillRight(II)Landroid/view/View;

    move-result-object v6

    .line 1401
    .local v6, "after":Landroid/view/View;
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v8

    .line 1402
    .local v8, "childCount":I
    if-lez v8, :cond_0

    .line 1403
    invoke-direct {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->correctTooWide(I)V

    .line 1416
    :cond_0
    :goto_1
    if-eqz v5, :cond_3

    .line 1421
    .end local v10    # "temp":Landroid/view/View;
    :goto_2
    return-object v10

    .line 1387
    .end local v5    # "tempIsSelected":Z
    .end local v6    # "after":Landroid/view/View;
    .end local v7    # "before":Landroid/view/View;
    .end local v8    # "childCount":I
    .end local v9    # "dividerWidth":I
    :cond_1
    const/4 v5, 0x0

    goto :goto_0

    .line 1406
    .restart local v5    # "tempIsSelected":Z
    .restart local v9    # "dividerWidth":I
    .restart local v10    # "temp":Landroid/view/View;
    :cond_2
    add-int/lit8 v0, p1, 0x1

    invoke-virtual {v10}, Landroid/view/View;->getRight()I

    move-result v1

    add-int/2addr v1, v9

    invoke-direct {p0, v0, v1}, Lit/sephiroth/android/library/widget/HListView;->fillRight(II)Landroid/view/View;

    move-result-object v6

    .line 1408
    .restart local v6    # "after":Landroid/view/View;
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->adjustViewsLeftOrRight()V

    .line 1409
    add-int/lit8 v0, p1, -0x1

    invoke-virtual {v10}, Landroid/view/View;->getLeft()I

    move-result v1

    sub-int/2addr v1, v9

    invoke-direct {p0, v0, v1}, Lit/sephiroth/android/library/widget/HListView;->fillLeft(II)Landroid/view/View;

    move-result-object v7

    .line 1410
    .restart local v7    # "before":Landroid/view/View;
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v8

    .line 1411
    .restart local v8    # "childCount":I
    if-lez v8, :cond_0

    .line 1412
    invoke-direct {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->correctTooSmall(I)V

    goto :goto_1

    .line 1418
    :cond_3
    if-eqz v7, :cond_4

    move-object v10, v7

    .line 1419
    goto :goto_2

    :cond_4
    move-object v10, v6

    .line 1421
    goto :goto_2
.end method

.method private getArrowScrollPreviewLength()I
    .locals 2

    .prologue
    .line 2684
    const/4 v0, 0x2

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getHorizontalFadingEdgeLength()I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method private getLeftSelectionPixel(III)I
    .locals 1
    .param p1, "childrenLeft"    # I
    .param p2, "fadingEdgeLength"    # I
    .param p3, "selectedPosition"    # I

    .prologue
    .line 906
    move v0, p1

    .line 907
    .local v0, "leftSelectionPixel":I
    if-lez p3, :cond_0

    .line 908
    add-int/2addr v0, p2

    .line 910
    :cond_0
    return v0
.end method

.method private getRightSelectionPixel(III)I
    .locals 2
    .param p1, "childrenRight"    # I
    .param p2, "fadingEdgeLength"    # I
    .param p3, "selectedPosition"    # I

    .prologue
    .line 886
    move v0, p1

    .line 887
    .local v0, "rightSelectionPixel":I
    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v1, v1, -0x1

    if-eq p3, v1, :cond_0

    .line 888
    sub-int/2addr v0, p2

    .line 890
    :cond_0
    return v0
.end method

.method private handleHorizontalFocusWithinListItem(I)Z
    .locals 7
    .param p1, "direction"    # I

    .prologue
    .line 2409
    const/16 v5, 0x11

    if-eq p1, v5, :cond_0

    const/16 v5, 0x42

    if-eq p1, v5, :cond_0

    .line 2410
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 2414
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v3

    .line 2415
    .local v3, "numChildren":I
    iget-boolean v5, p0, Lit/sephiroth/android/library/widget/HListView;->mItemsCanFocus:Z

    if-eqz v5, :cond_2

    if-lez v3, :cond_2

    iget v5, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    const/4 v6, -0x1

    if-eq v5, v6, :cond_2

    .line 2416
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getSelectedView()Landroid/view/View;

    move-result-object v4

    .line 2417
    .local v4, "selectedView":Landroid/view/View;
    if-eqz v4, :cond_2

    invoke-virtual {v4}, Landroid/view/View;->hasFocus()Z

    move-result v5

    if-eqz v5, :cond_2

    instance-of v5, v4, Landroid/view/ViewGroup;

    if-eqz v5, :cond_2

    .line 2420
    invoke-virtual {v4}, Landroid/view/View;->findFocus()Landroid/view/View;

    move-result-object v0

    .line 2421
    .local v0, "currentFocus":Landroid/view/View;
    invoke-static {}, Landroid/view/FocusFinder;->getInstance()Landroid/view/FocusFinder;

    move-result-object v5

    check-cast v4, Landroid/view/ViewGroup;

    .end local v4    # "selectedView":Landroid/view/View;
    invoke-virtual {v5, v4, v0, p1}, Landroid/view/FocusFinder;->findNextFocus(Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;

    move-result-object v2

    .line 2423
    .local v2, "nextFocus":Landroid/view/View;
    if-eqz v2, :cond_1

    .line 2425
    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {v0, v5}, Landroid/view/View;->getFocusedRect(Landroid/graphics/Rect;)V

    .line 2426
    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {p0, v0, v5}, Lit/sephiroth/android/library/widget/HListView;->offsetDescendantRectToMyCoords(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 2427
    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {p0, v2, v5}, Lit/sephiroth/android/library/widget/HListView;->offsetRectIntoDescendantCoords(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 2428
    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {v2, p1, v5}, Landroid/view/View;->requestFocus(ILandroid/graphics/Rect;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 2429
    const/4 v5, 0x1

    .line 2443
    .end local v0    # "currentFocus":Landroid/view/View;
    .end local v2    # "nextFocus":Landroid/view/View;
    :goto_0
    return v5

    .line 2436
    .restart local v0    # "currentFocus":Landroid/view/View;
    .restart local v2    # "nextFocus":Landroid/view/View;
    :cond_1
    invoke-static {}, Landroid/view/FocusFinder;->getInstance()Landroid/view/FocusFinder;

    move-result-object v6

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getRootView()Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/view/ViewGroup;

    invoke-virtual {v6, v5, v0, p1}, Landroid/view/FocusFinder;->findNextFocus(Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    .line 2438
    .local v1, "globalNextFocus":Landroid/view/View;
    if-eqz v1, :cond_2

    .line 2439
    invoke-direct {p0, v1, p0}, Lit/sephiroth/android/library/widget/HListView;->isViewAncestorOf(Landroid/view/View;Landroid/view/View;)Z

    move-result v5

    goto :goto_0

    .line 2443
    .end local v0    # "currentFocus":Landroid/view/View;
    .end local v1    # "globalNextFocus":Landroid/view/View;
    .end local v2    # "nextFocus":Landroid/view/View;
    :cond_2
    const/4 v5, 0x0

    goto :goto_0
.end method

.method private handleNewSelectionChange(Landroid/view/View;IIZ)V
    .locals 10
    .param p1, "selectedView"    # Landroid/view/View;
    .param p2, "direction"    # I
    .param p3, "newSelectedPosition"    # I
    .param p4, "newFocusAssigned"    # Z

    .prologue
    .line 2568
    const/4 v8, -0x1

    if-ne p3, v8, :cond_0

    .line 2569
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v9, "newSelectedPosition needs to be valid"

    invoke-direct {v8, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 2579
    :cond_0
    const/4 v0, 0x0

    .line 2580
    .local v0, "leftSelected":Z
    iget v8, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    iget v9, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    sub-int v7, v8, v9

    .line 2581
    .local v7, "selectedIndex":I
    iget v8, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    sub-int v3, p3, v8

    .line 2583
    .local v3, "nextSelectedIndex":I
    const/16 v8, 0x21

    if-ne p2, v8, :cond_3

    .line 2584
    move v2, v3

    .line 2585
    .local v2, "leftViewIndex":I
    move v6, v7

    .line 2586
    .local v6, "rightViewIndex":I
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 2587
    .local v1, "leftView":Landroid/view/View;
    move-object v5, p1

    .line 2588
    .local v5, "rightView":Landroid/view/View;
    const/4 v0, 0x1

    .line 2596
    :goto_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v4

    .line 2599
    .local v4, "numChildren":I
    if-eqz v1, :cond_1

    .line 2600
    if-nez p4, :cond_4

    if-eqz v0, :cond_4

    const/4 v8, 0x1

    :goto_1
    invoke-virtual {v1, v8}, Landroid/view/View;->setSelected(Z)V

    .line 2601
    invoke-direct {p0, v1, v2, v4}, Lit/sephiroth/android/library/widget/HListView;->measureAndAdjustRight(Landroid/view/View;II)V

    .line 2605
    :cond_1
    if-eqz v5, :cond_2

    .line 2606
    if-nez p4, :cond_5

    if-nez v0, :cond_5

    const/4 v8, 0x1

    :goto_2
    invoke-virtual {v5, v8}, Landroid/view/View;->setSelected(Z)V

    .line 2607
    invoke-direct {p0, v5, v6, v4}, Lit/sephiroth/android/library/widget/HListView;->measureAndAdjustRight(Landroid/view/View;II)V

    .line 2609
    :cond_2
    return-void

    .line 2590
    .end local v1    # "leftView":Landroid/view/View;
    .end local v2    # "leftViewIndex":I
    .end local v4    # "numChildren":I
    .end local v5    # "rightView":Landroid/view/View;
    .end local v6    # "rightViewIndex":I
    :cond_3
    move v2, v7

    .line 2591
    .restart local v2    # "leftViewIndex":I
    move v6, v3

    .line 2592
    .restart local v6    # "rightViewIndex":I
    move-object v1, p1

    .line 2593
    .restart local v1    # "leftView":Landroid/view/View;
    invoke-virtual {p0, v6}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .restart local v5    # "rightView":Landroid/view/View;
    goto :goto_0

    .line 2600
    .restart local v4    # "numChildren":I
    :cond_4
    const/4 v8, 0x0

    goto :goto_1

    .line 2606
    :cond_5
    const/4 v8, 0x0

    goto :goto_2
.end method

.method private isDirectChildHeaderOrFooter(Landroid/view/View;)Z
    .locals 7
    .param p1, "child"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x1

    .line 1838
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mHeaderViewInfos:Ljava/util/ArrayList;

    .line 1839
    .local v1, "headers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 1840
    .local v4, "numHeaders":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v4, :cond_1

    .line 1841
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;

    iget-object v5, v5, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->view:Landroid/view/View;

    if-ne p1, v5, :cond_0

    move v5, v6

    .line 1852
    :goto_1
    return v5

    .line 1840
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1845
    :cond_1
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFooterViewInfos:Ljava/util/ArrayList;

    .line 1846
    .local v0, "footers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 1847
    .local v3, "numFooters":I
    const/4 v2, 0x0

    :goto_2
    if-ge v2, v3, :cond_3

    .line 1848
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;

    iget-object v5, v5, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->view:Landroid/view/View;

    if-ne p1, v5, :cond_2

    move v5, v6

    .line 1849
    goto :goto_1

    .line 1847
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 1852
    :cond_3
    const/4 v5, 0x0

    goto :goto_1
.end method

.method private isViewAncestorOf(Landroid/view/View;Landroid/view/View;)Z
    .locals 3
    .param p1, "child"    # Landroid/view/View;
    .param p2, "parent"    # Landroid/view/View;

    .prologue
    const/4 v1, 0x1

    .line 2939
    if-ne p1, p2, :cond_1

    .line 2944
    :cond_0
    :goto_0
    return v1

    .line 2943
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 2944
    .local v0, "theParent":Landroid/view/ViewParent;
    instance-of v2, v0, Landroid/view/ViewGroup;

    if-eqz v2, :cond_2

    check-cast v0, Landroid/view/View;

    .end local v0    # "theParent":Landroid/view/ViewParent;
    invoke-direct {p0, v0, p2}, Lit/sephiroth/android/library/widget/HListView;->isViewAncestorOf(Landroid/view/View;Landroid/view/View;)Z

    move-result v2

    if-nez v2, :cond_0

    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private lookForSelectablePositionOnScreen(I)I
    .locals 8
    .param p1, "direction"    # I

    .prologue
    const/4 v6, -0x1

    .line 2802
    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    .line 2803
    .local v1, "firstPosition":I
    const/16 v7, 0x82

    if-ne p1, v7, :cond_5

    .line 2804
    iget v7, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    if-eq v7, v6, :cond_1

    iget v7, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    add-int/lit8 v5, v7, 0x1

    .line 2807
    .local v5, "startPos":I
    :goto_0
    iget-object v7, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v7}, Landroid/widget/ListAdapter;->getCount()I

    move-result v7

    if-lt v5, v7, :cond_2

    move v4, v6

    .line 2842
    :cond_0
    :goto_1
    return v4

    .end local v5    # "startPos":I
    :cond_1
    move v5, v1

    .line 2804
    goto :goto_0

    .line 2810
    .restart local v5    # "startPos":I
    :cond_2
    if-ge v5, v1, :cond_3

    .line 2811
    move v5, v1

    .line 2814
    :cond_3
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getLastVisiblePosition()I

    move-result v3

    .line 2815
    .local v3, "lastVisiblePos":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 2816
    .local v0, "adapter":Landroid/widget/ListAdapter;
    move v4, v5

    .local v4, "pos":I
    :goto_2
    if-gt v4, v3, :cond_b

    .line 2817
    invoke-interface {v0, v4}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v7

    if-eqz v7, :cond_4

    sub-int v7, v4, v1

    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    invoke-virtual {v7}, Landroid/view/View;->getVisibility()I

    move-result v7

    if-eqz v7, :cond_0

    .line 2816
    :cond_4
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 2823
    .end local v0    # "adapter":Landroid/widget/ListAdapter;
    .end local v3    # "lastVisiblePos":I
    .end local v4    # "pos":I
    .end local v5    # "startPos":I
    :cond_5
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v7

    add-int/2addr v7, v1

    add-int/lit8 v2, v7, -0x1

    .line 2824
    .local v2, "last":I
    iget v7, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    if-eq v7, v6, :cond_7

    iget v7, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    add-int/lit8 v5, v7, -0x1

    .line 2827
    .restart local v5    # "startPos":I
    :goto_3
    if-ltz v5, :cond_6

    iget-object v7, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v7}, Landroid/widget/ListAdapter;->getCount()I

    move-result v7

    if-lt v5, v7, :cond_8

    :cond_6
    move v4, v6

    .line 2828
    goto :goto_1

    .line 2824
    .end local v5    # "startPos":I
    :cond_7
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v7

    add-int/2addr v7, v1

    add-int/lit8 v5, v7, -0x1

    goto :goto_3

    .line 2830
    .restart local v5    # "startPos":I
    :cond_8
    if-le v5, v2, :cond_9

    .line 2831
    move v5, v2

    .line 2834
    :cond_9
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 2835
    .restart local v0    # "adapter":Landroid/widget/ListAdapter;
    move v4, v5

    .restart local v4    # "pos":I
    :goto_4
    if-lt v4, v1, :cond_b

    .line 2836
    invoke-interface {v0, v4}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v7

    if-eqz v7, :cond_a

    sub-int v7, v4, v1

    invoke-virtual {p0, v7}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    invoke-virtual {v7}, Landroid/view/View;->getVisibility()I

    move-result v7

    if-eqz v7, :cond_0

    .line 2835
    :cond_a
    add-int/lit8 v4, v4, -0x1

    goto :goto_4

    .end local v2    # "last":I
    :cond_b
    move v4, v6

    .line 2842
    goto :goto_1
.end method

.method private makeAndAddView(IIZIZ)Landroid/view/View;
    .locals 9
    .param p1, "position"    # I
    .param p2, "x"    # I
    .param p3, "flow"    # Z
    .param p4, "childrenTop"    # I
    .param p5, "selected"    # Z

    .prologue
    .line 1874
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/HListView;->mDataChanged:Z

    if-nez v0, :cond_0

    .line 1876
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-virtual {v0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->getActiveView(I)Landroid/view/View;

    move-result-object v1

    .line 1877
    .local v1, "child":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 1880
    const/4 v7, 0x1

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-direct/range {v0 .. v7}, Lit/sephiroth/android/library/widget/HListView;->setupChild(Landroid/view/View;IIZIZZ)V

    move-object v8, v1

    .line 1892
    .end local v1    # "child":Landroid/view/View;
    .local v8, "child":Landroid/view/View;
    :goto_0
    return-object v8

    .line 1887
    .end local v8    # "child":Landroid/view/View;
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mIsScrap:[Z

    invoke-virtual {p0, p1, v0}, Lit/sephiroth/android/library/widget/HListView;->obtainView(I[Z)Landroid/view/View;

    move-result-object v1

    .line 1890
    .restart local v1    # "child":Landroid/view/View;
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mIsScrap:[Z

    const/4 v2, 0x0

    aget-boolean v7, v0, v2

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-direct/range {v0 .. v7}, Lit/sephiroth/android/library/widget/HListView;->setupChild(Landroid/view/View;IIZIZZ)V

    move-object v8, v1

    .line 1892
    .end local v1    # "child":Landroid/view/View;
    .restart local v8    # "child":Landroid/view/View;
    goto :goto_0
.end method

.method private measureAndAdjustRight(Landroid/view/View;II)V
    .locals 4
    .param p1, "child"    # Landroid/view/View;
    .param p2, "childIndex"    # I
    .param p3, "numChildren"    # I

    .prologue
    .line 2622
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v1

    .line 2623
    .local v1, "oldWidth":I
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->measureItem(Landroid/view/View;)V

    .line 2624
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v3

    if-eq v3, v1, :cond_0

    .line 2626
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->relayoutMeasuredItem(Landroid/view/View;)V

    .line 2629
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v3

    sub-int v2, v3, v1

    .line 2630
    .local v2, "widthDelta":I
    add-int/lit8 v0, p2, 0x1

    .local v0, "i":I
    :goto_0
    if-ge v0, p3, :cond_0

    .line 2631
    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 2630
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2634
    .end local v0    # "i":I
    .end local v2    # "widthDelta":I
    :cond_0
    return-void
.end method

.method private measureItem(Landroid/view/View;)V
    .locals 8
    .param p1, "child"    # Landroid/view/View;

    .prologue
    const/4 v7, 0x0

    .line 2643
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    .line 2644
    .local v3, "p":Landroid/view/ViewGroup$LayoutParams;
    if-nez v3, :cond_0

    .line 2645
    new-instance v3, Landroid/view/ViewGroup$LayoutParams;

    .end local v3    # "p":Landroid/view/ViewGroup$LayoutParams;
    const/4 v4, -0x2

    const/4 v5, -0x1

    invoke-direct {v3, v4, v5}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 2650
    .restart local v3    # "p":Landroid/view/ViewGroup$LayoutParams;
    :cond_0
    iget v4, p0, Lit/sephiroth/android/library/widget/HListView;->mHeightMeasureSpec:I

    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->top:I

    iget-object v6, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v6, v6, Landroid/graphics/Rect;->bottom:I

    add-int/2addr v5, v6

    iget v6, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    invoke-static {v4, v5, v6}, Landroid/view/ViewGroup;->getChildMeasureSpec(III)I

    move-result v0

    .line 2651
    .local v0, "childHeightSpec":I
    iget v2, v3, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 2653
    .local v2, "lpWidth":I
    if-lez v2, :cond_1

    .line 2654
    const/high16 v4, 0x40000000    # 2.0f

    invoke-static {v2, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    .line 2658
    .local v1, "childWidthSpec":I
    :goto_0
    invoke-virtual {p1, v1, v0}, Landroid/view/View;->measure(II)V

    .line 2659
    return-void

    .line 2656
    .end local v1    # "childWidthSpec":I
    :cond_1
    invoke-static {v7, v7}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    .restart local v1    # "childWidthSpec":I
    goto :goto_0
.end method

.method private measureScrapChildWidth(Landroid/view/View;II)V
    .locals 7
    .param p1, "child"    # Landroid/view/View;
    .param p2, "position"    # I
    .param p3, "heightMeasureSpec"    # I

    .prologue
    const/4 v6, 0x0

    .line 1183
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .line 1184
    .local v3, "p":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    if-nez v3, :cond_0

    .line 1185
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    .end local v3    # "p":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    check-cast v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .line 1186
    .restart local v3    # "p":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    invoke-virtual {p1, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1188
    :cond_0
    iget-object v4, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v4, p2}, Landroid/widget/ListAdapter;->getItemViewType(I)I

    move-result v4

    iput v4, v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    .line 1189
    const/4 v4, 0x1

    iput-boolean v4, v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->forceAdd:Z

    .line 1191
    iget-object v4, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->top:I

    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->bottom:I

    add-int/2addr v4, v5

    iget v5, v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->height:I

    invoke-static {p3, v4, v5}, Landroid/view/ViewGroup;->getChildMeasureSpec(III)I

    move-result v0

    .line 1192
    .local v0, "childHeightSpec":I
    iget v2, v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->width:I

    .line 1194
    .local v2, "lpWidth":I
    if-lez v2, :cond_1

    .line 1195
    const/high16 v4, 0x40000000    # 2.0f

    invoke-static {v2, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    .line 1199
    .local v1, "childWidthSpec":I
    :goto_0
    invoke-virtual {p1, v1, v0}, Landroid/view/View;->measure(II)V

    .line 1200
    return-void

    .line 1197
    .end local v1    # "childWidthSpec":I
    :cond_1
    invoke-static {v6, v6}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    .restart local v1    # "childWidthSpec":I
    goto :goto_0
.end method

.method private moveSelection(Landroid/view/View;Landroid/view/View;III)Landroid/view/View;
    .locals 20
    .param p1, "oldSel"    # Landroid/view/View;
    .param p2, "newSel"    # Landroid/view/View;
    .param p3, "delta"    # I
    .param p4, "childrenLeft"    # I
    .param p5, "childrenRight"    # I

    .prologue
    .line 954
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getHorizontalFadingEdgeLength()I

    move-result v10

    .line 955
    .local v10, "fadingEdgeLength":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    move/from16 v17, v0

    .line 959
    .local v17, "selectedPosition":I
    move-object/from16 v0, p0

    move/from16 v1, p4

    move/from16 v2, v17

    invoke-direct {v0, v1, v10, v2}, Lit/sephiroth/android/library/widget/HListView;->getLeftSelectionPixel(III)I

    move-result v12

    .line 960
    .local v12, "leftSelectionPixel":I
    move-object/from16 v0, p0

    move/from16 v1, p4

    move/from16 v2, v17

    invoke-direct {v0, v1, v10, v2}, Lit/sephiroth/android/library/widget/HListView;->getRightSelectionPixel(III)I

    move-result v15

    .line 962
    .local v15, "rightSelectionPixel":I
    if-lez p3, :cond_2

    .line 975
    add-int/lit8 v4, v17, -0x1

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLeft()I

    move-result v5

    const/4 v6, 0x1

    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v3, Landroid/graphics/Rect;->top:I

    const/4 v8, 0x0

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v8}, Lit/sephiroth/android/library/widget/HListView;->makeAndAddView(IIZIZ)Landroid/view/View;

    move-result-object p1

    .line 977
    move-object/from16 v0, p0

    iget v9, v0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    .line 980
    .local v9, "dividerWidth":I
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getRight()I

    move-result v3

    add-int v5, v3, v9

    const/4 v6, 0x1

    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v3, Landroid/graphics/Rect;->top:I

    const/4 v8, 0x1

    move-object/from16 v3, p0

    move/from16 v4, v17

    invoke-direct/range {v3 .. v8}, Lit/sephiroth/android/library/widget/HListView;->makeAndAddView(IIZIZ)Landroid/view/View;

    move-result-object v16

    .line 983
    .local v16, "sel":Landroid/view/View;
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getRight()I

    move-result v3

    if-le v3, v15, :cond_0

    .line 986
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getLeft()I

    move-result v3

    sub-int v19, v3, v12

    .line 989
    .local v19, "spaceBefore":I
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getRight()I

    move-result v3

    sub-int v18, v3, v15

    .line 992
    .local v18, "spaceAfter":I
    sub-int v3, p5, p4

    div-int/lit8 v11, v3, 0x2

    .line 993
    .local v11, "halfHorizontalSpace":I
    move/from16 v0, v19

    move/from16 v1, v18

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v14

    .line 994
    .local v14, "offset":I
    invoke-static {v14, v11}, Ljava/lang/Math;->min(II)I

    move-result v14

    .line 997
    neg-int v3, v14

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 999
    neg-int v3, v14

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 1003
    .end local v11    # "halfHorizontalSpace":I
    .end local v14    # "offset":I
    .end local v18    # "spaceAfter":I
    .end local v19    # "spaceBefore":I
    :cond_0
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lit/sephiroth/android/library/widget/HListView;->mStackFromRight:Z

    if-nez v3, :cond_1

    .line 1004
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    add-int/lit8 v3, v3, -0x2

    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getLeft()I

    move-result v4

    sub-int/2addr v4, v9

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4}, Lit/sephiroth/android/library/widget/HListView;->fillLeft(II)Landroid/view/View;

    .line 1005
    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->adjustViewsLeftOrRight()V

    .line 1006
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    add-int/lit8 v3, v3, 0x1

    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getRight()I

    move-result v4

    add-int/2addr v4, v9

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4}, Lit/sephiroth/android/library/widget/HListView;->fillRight(II)Landroid/view/View;

    .line 1076
    .end local v9    # "dividerWidth":I
    :goto_0
    return-object v16

    .line 1008
    .restart local v9    # "dividerWidth":I
    :cond_1
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    add-int/lit8 v3, v3, 0x1

    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getRight()I

    move-result v4

    add-int/2addr v4, v9

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4}, Lit/sephiroth/android/library/widget/HListView;->fillRight(II)Landroid/view/View;

    .line 1009
    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->adjustViewsLeftOrRight()V

    .line 1010
    move-object/from16 v0, p0

    iget v3, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    add-int/lit8 v3, v3, -0x2

    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getLeft()I

    move-result v4

    sub-int/2addr v4, v9

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v4}, Lit/sephiroth/android/library/widget/HListView;->fillLeft(II)Landroid/view/View;

    goto :goto_0

    .line 1012
    .end local v9    # "dividerWidth":I
    .end local v16    # "sel":Landroid/view/View;
    :cond_2
    if-gez p3, :cond_5

    .line 1024
    if-eqz p2, :cond_4

    .line 1026
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getLeft()I

    move-result v5

    const/4 v6, 0x1

    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v3, Landroid/graphics/Rect;->top:I

    const/4 v8, 0x1

    move-object/from16 v3, p0

    move/from16 v4, v17

    invoke-direct/range {v3 .. v8}, Lit/sephiroth/android/library/widget/HListView;->makeAndAddView(IIZIZ)Landroid/view/View;

    move-result-object v16

    .line 1034
    .restart local v16    # "sel":Landroid/view/View;
    :goto_1
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getLeft()I

    move-result v3

    if-ge v3, v12, :cond_3

    .line 1036
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getLeft()I

    move-result v3

    sub-int v19, v12, v3

    .line 1039
    .restart local v19    # "spaceBefore":I
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getRight()I

    move-result v3

    sub-int v18, v15, v3

    .line 1042
    .restart local v18    # "spaceAfter":I
    sub-int v3, p5, p4

    div-int/lit8 v11, v3, 0x2

    .line 1043
    .restart local v11    # "halfHorizontalSpace":I
    move/from16 v0, v19

    move/from16 v1, v18

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v14

    .line 1044
    .restart local v14    # "offset":I
    invoke-static {v14, v11}, Ljava/lang/Math;->min(II)I

    move-result v14

    .line 1047
    move-object/from16 v0, v16

    invoke-virtual {v0, v14}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 1051
    .end local v11    # "halfHorizontalSpace":I
    .end local v14    # "offset":I
    .end local v18    # "spaceAfter":I
    .end local v19    # "spaceBefore":I
    :cond_3
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    move/from16 v2, v17

    invoke-direct {v0, v1, v2}, Lit/sephiroth/android/library/widget/HListView;->fillBeforeAndAfter(Landroid/view/View;I)V

    goto :goto_0

    .line 1030
    .end local v16    # "sel":Landroid/view/View;
    :cond_4
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLeft()I

    move-result v5

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v3, Landroid/graphics/Rect;->top:I

    const/4 v8, 0x1

    move-object/from16 v3, p0

    move/from16 v4, v17

    invoke-direct/range {v3 .. v8}, Lit/sephiroth/android/library/widget/HListView;->makeAndAddView(IIZIZ)Landroid/view/View;

    move-result-object v16

    .restart local v16    # "sel":Landroid/view/View;
    goto :goto_1

    .line 1054
    .end local v16    # "sel":Landroid/view/View;
    :cond_5
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLeft()I

    move-result v5

    .line 1059
    .local v5, "oldLeft":I
    const/4 v6, 0x1

    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v7, v3, Landroid/graphics/Rect;->top:I

    const/4 v8, 0x1

    move-object/from16 v3, p0

    move/from16 v4, v17

    invoke-direct/range {v3 .. v8}, Lit/sephiroth/android/library/widget/HListView;->makeAndAddView(IIZIZ)Landroid/view/View;

    move-result-object v16

    .line 1062
    .restart local v16    # "sel":Landroid/view/View;
    move/from16 v0, p4

    if-ge v5, v0, :cond_6

    .line 1065
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getRight()I

    move-result v13

    .line 1066
    .local v13, "newRight":I
    add-int/lit8 v3, p4, 0x14

    if-ge v13, v3, :cond_6

    .line 1068
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->getLeft()I

    move-result v3

    sub-int v3, p4, v3

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 1073
    .end local v13    # "newRight":I
    :cond_6
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    move/from16 v2, v17

    invoke-direct {v0, v1, v2}, Lit/sephiroth/android/library/widget/HListView;->fillBeforeAndAfter(Landroid/view/View;I)V

    goto/16 :goto_0
.end method

.method private positionOfNewFocus(Landroid/view/View;)I
    .locals 5
    .param p1, "newFocus"    # Landroid/view/View;

    .prologue
    .line 2924
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v2

    .line 2925
    .local v2, "numChildren":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_1

    .line 2926
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 2927
    .local v0, "child":Landroid/view/View;
    invoke-direct {p0, p1, v0}, Lit/sephiroth/android/library/widget/HListView;->isViewAncestorOf(Landroid/view/View;Landroid/view/View;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2928
    iget v3, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v3, v1

    return v3

    .line 2925
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 2931
    .end local v0    # "child":Landroid/view/View;
    :cond_1
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "newFocus is not a child of any of the children of the list!"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method private relayoutMeasuredItem(Landroid/view/View;)V
    .locals 7
    .param p1, "child"    # Landroid/view/View;

    .prologue
    .line 2668
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v5

    .line 2669
    .local v5, "w":I
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    .line 2671
    .local v4, "h":I
    iget-object v6, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v6, Landroid/graphics/Rect;->top:I

    .line 2672
    .local v3, "childTop":I
    add-int v0, v3, v4

    .line 2674
    .local v0, "childBottom":I
    invoke-virtual {p1}, Landroid/view/View;->getLeft()I

    move-result v1

    .line 2675
    .local v1, "childLeft":I
    add-int v2, v1, v5

    .line 2677
    .local v2, "childRight":I
    invoke-virtual {p1, v1, v3, v2, v0}, Landroid/view/View;->layout(IIII)V

    .line 2678
    return-void
.end method

.method private scrollListItemsBy(I)V
    .locals 12
    .param p1, "amount"    # I

    .prologue
    const/4 v11, 0x0

    .line 3008
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->offsetChildrenLeftAndRight(I)V

    .line 3010
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getWidth()I

    move-result v9

    iget-object v10, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->right:I

    sub-int v6, v9, v10

    .line 3011
    .local v6, "listRight":I
    iget-object v9, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v5, v9, Landroid/graphics/Rect;->left:I

    .line 3012
    .local v5, "listLeft":I
    iget-object v8, p0, Lit/sephiroth/android/library/widget/HListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    .line 3014
    .local v8, "recycleBin":Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;
    if-gez p1, :cond_3

    .line 3018
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v7

    .line 3019
    .local v7, "numChildren":I
    add-int/lit8 v9, v7, -0x1

    invoke-virtual {p0, v9}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 3020
    .local v1, "last":Landroid/view/View;
    :goto_0
    invoke-virtual {v1}, Landroid/view/View;->getRight()I

    move-result v9

    if-ge v9, v6, :cond_0

    .line 3021
    iget v9, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v9, v7

    add-int/lit8 v3, v9, -0x1

    .line 3022
    .local v3, "lastVisiblePosition":I
    iget v9, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v9, v9, -0x1

    if-ge v3, v9, :cond_0

    .line 3023
    invoke-direct {p0, v1, v3}, Lit/sephiroth/android/library/widget/HListView;->addViewAfter(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    .line 3024
    add-int/lit8 v7, v7, 0x1

    .line 3028
    goto :goto_0

    .line 3033
    .end local v3    # "lastVisiblePosition":I
    :cond_0
    invoke-virtual {v1}, Landroid/view/View;->getBottom()I

    move-result v9

    if-ge v9, v6, :cond_1

    .line 3034
    invoke-virtual {v1}, Landroid/view/View;->getRight()I

    move-result v9

    sub-int v9, v6, v9

    invoke-virtual {p0, v9}, Lit/sephiroth/android/library/widget/HListView;->offsetChildrenLeftAndRight(I)V

    .line 3038
    :cond_1
    invoke-virtual {p0, v11}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 3039
    .local v0, "first":Landroid/view/View;
    :goto_1
    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v9

    if-ge v9, v5, :cond_7

    .line 3040
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    check-cast v4, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .line 3041
    .local v4, "layoutParams":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    iget v9, v4, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    invoke-virtual {v8, v9}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->shouldRecycleViewType(I)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 3042
    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->detachViewFromParent(Landroid/view/View;)V

    .line 3043
    iget v9, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    invoke-virtual {v8, v0, v9}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->addScrapView(Landroid/view/View;I)V

    .line 3047
    :goto_2
    invoke-virtual {p0, v11}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 3048
    iget v9, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/lit8 v9, v9, 0x1

    iput v9, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    goto :goto_1

    .line 3045
    :cond_2
    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->removeViewInLayout(Landroid/view/View;)V

    goto :goto_2

    .line 3052
    .end local v0    # "first":Landroid/view/View;
    .end local v1    # "last":Landroid/view/View;
    .end local v4    # "layoutParams":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    .end local v7    # "numChildren":I
    :cond_3
    invoke-virtual {p0, v11}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 3055
    .restart local v0    # "first":Landroid/view/View;
    :goto_3
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v9

    if-le v9, v5, :cond_4

    iget v9, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    if-lez v9, :cond_4

    .line 3056
    iget v9, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    invoke-direct {p0, v0, v9}, Lit/sephiroth/android/library/widget/HListView;->addViewBefore(Landroid/view/View;I)Landroid/view/View;

    move-result-object v0

    .line 3057
    iget v9, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/lit8 v9, v9, -0x1

    iput v9, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    goto :goto_3

    .line 3062
    :cond_4
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v9

    if-le v9, v5, :cond_5

    .line 3063
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v9

    sub-int v9, v5, v9

    invoke-virtual {p0, v9}, Lit/sephiroth/android/library/widget/HListView;->offsetChildrenLeftAndRight(I)V

    .line 3066
    :cond_5
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v9

    add-int/lit8 v2, v9, -0x1

    .line 3067
    .local v2, "lastIndex":I
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 3070
    .restart local v1    # "last":Landroid/view/View;
    :goto_4
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v9

    if-le v9, v6, :cond_7

    .line 3071
    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    check-cast v4, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .line 3072
    .restart local v4    # "layoutParams":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    iget v9, v4, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    invoke-virtual {v8, v9}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->shouldRecycleViewType(I)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 3073
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->detachViewFromParent(Landroid/view/View;)V

    .line 3074
    iget v9, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v9, v2

    invoke-virtual {v8, v1, v9}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->addScrapView(Landroid/view/View;I)V

    .line 3078
    :goto_5
    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 3079
    goto :goto_4

    .line 3076
    :cond_6
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->removeViewInLayout(Landroid/view/View;)V

    goto :goto_5

    .line 3081
    .end local v2    # "lastIndex":I
    .end local v4    # "layoutParams":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    :cond_7
    return-void
.end method

.method private setupChild(Landroid/view/View;IIZIZZ)V
    .locals 22
    .param p1, "child"    # Landroid/view/View;
    .param p2, "position"    # I
    .param p3, "x"    # I
    .param p4, "flowDown"    # Z
    .param p5, "childrenTop"    # I
    .param p6, "selected"    # Z
    .param p7, "recycled"    # Z
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 1915
    if-eqz p6, :cond_9

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->shouldShowSelector()Z

    move-result v19

    if-eqz v19, :cond_9

    const/4 v11, 0x1

    .line 1916
    .local v11, "isSelected":Z
    :goto_0
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->isSelected()Z

    move-result v19

    move/from16 v0, v19

    if-eq v11, v0, :cond_a

    const/16 v17, 0x1

    .line 1917
    .local v17, "updateChildSelected":Z
    :goto_1
    move-object/from16 v0, p0

    iget v13, v0, Lit/sephiroth/android/library/widget/HListView;->mTouchMode:I

    .line 1918
    .local v13, "mode":I
    if-lez v13, :cond_b

    const/16 v19, 0x3

    move/from16 v0, v19

    if-ge v13, v0, :cond_b

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mMotionPosition:I

    move/from16 v19, v0

    move/from16 v0, v19

    move/from16 v1, p2

    if-ne v0, v1, :cond_b

    const/4 v10, 0x1

    .line 1919
    .local v10, "isPressed":Z
    :goto_2
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->isPressed()Z

    move-result v19

    move/from16 v0, v19

    if-eq v10, v0, :cond_c

    const/16 v16, 0x1

    .line 1920
    .local v16, "updateChildPressed":Z
    :goto_3
    if-eqz p7, :cond_0

    if-nez v17, :cond_0

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->isLayoutRequested()Z

    move-result v19

    if-eqz v19, :cond_d

    :cond_0
    const/4 v14, 0x1

    .line 1924
    .local v14, "needToMeasure":Z
    :goto_4
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v15

    check-cast v15, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .line 1925
    .local v15, "p":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    if-nez v15, :cond_1

    .line 1926
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v15

    .end local v15    # "p":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    check-cast v15, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .line 1928
    .restart local v15    # "p":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move/from16 v1, p2

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->getItemViewType(I)I

    move-result v19

    move/from16 v0, v19

    iput v0, v15, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    .line 1930
    if-eqz p7, :cond_2

    iget-boolean v0, v15, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->forceAdd:Z

    move/from16 v19, v0

    if-eqz v19, :cond_3

    :cond_2
    iget-boolean v0, v15, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->recycledHeaderFooter:Z

    move/from16 v19, v0

    if-eqz v19, :cond_f

    iget v0, v15, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    move/from16 v19, v0

    const/16 v20, -0x2

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_f

    .line 1931
    :cond_3
    if-eqz p4, :cond_e

    const/16 v19, -0x1

    :goto_5
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v19

    invoke-virtual {v0, v1, v2, v15}, Lit/sephiroth/android/library/widget/HListView;->attachViewToParent(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 1940
    :goto_6
    if-eqz v17, :cond_4

    .line 1941
    move-object/from16 v0, p1

    invoke-virtual {v0, v11}, Landroid/view/View;->setSelected(Z)V

    .line 1944
    :cond_4
    if-eqz v16, :cond_5

    .line 1945
    move-object/from16 v0, p1

    invoke-virtual {v0, v10}, Landroid/view/View;->setPressed(Z)V

    .line 1948
    :cond_5
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mChoiceMode:I

    move/from16 v19, v0

    if-eqz v19, :cond_6

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    move-object/from16 v19, v0

    if-eqz v19, :cond_6

    .line 1949
    move-object/from16 v0, p1

    instance-of v0, v0, Landroid/widget/Checkable;

    move/from16 v19, v0

    if-eqz v19, :cond_12

    move-object/from16 v19, p1

    .line 1950
    check-cast v19, Landroid/widget/Checkable;

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    invoke-static/range {v21 .. v21}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v21

    move-object/from16 v0, v20

    move/from16 v1, p2

    move-object/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/util/SparseArrayCompat;->get(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/Boolean;

    invoke-virtual/range {v20 .. v20}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v20

    invoke-interface/range {v19 .. v20}, Landroid/widget/Checkable;->setChecked(Z)V

    .line 1956
    :cond_6
    :goto_7
    if-eqz v14, :cond_14

    .line 1957
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mHeightMeasureSpec:I

    move/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v21, v0

    add-int v20, v20, v21

    iget v0, v15, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->height:I

    move/from16 v21, v0

    invoke-static/range {v19 .. v21}, Landroid/view/ViewGroup;->getChildMeasureSpec(III)I

    move-result v5

    .line 1958
    .local v5, "childHeightSpec":I
    iget v12, v15, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->width:I

    .line 1960
    .local v12, "lpWidth":I
    if-lez v12, :cond_13

    .line 1961
    const/high16 v19, 0x40000000    # 2.0f

    move/from16 v0, v19

    invoke-static {v12, v0}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v8

    .line 1965
    .local v8, "childWidthSpec":I
    :goto_8
    move-object/from16 v0, p1

    invoke-virtual {v0, v8, v5}, Landroid/view/View;->measure(II)V

    .line 1970
    .end local v5    # "childHeightSpec":I
    .end local v8    # "childWidthSpec":I
    .end local v12    # "lpWidth":I
    :goto_9
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v18

    .line 1971
    .local v18, "w":I
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v9

    .line 1972
    .local v9, "h":I
    if-eqz p4, :cond_15

    move/from16 v6, p3

    .line 1974
    .local v6, "childLeft":I
    :goto_a
    if-eqz v14, :cond_16

    .line 1975
    add-int v4, p5, v9

    .line 1976
    .local v4, "childBottom":I
    add-int v7, v6, v18

    .line 1977
    .local v7, "childRight":I
    move-object/from16 v0, p1

    move/from16 v1, p5

    invoke-virtual {v0, v6, v1, v7, v4}, Landroid/view/View;->layout(IIII)V

    .line 1983
    .end local v4    # "childBottom":I
    .end local v7    # "childRight":I
    :goto_b
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/HListView;->mCachingStarted:Z

    move/from16 v19, v0

    if-eqz v19, :cond_7

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->isDrawingCacheEnabled()Z

    move-result v19

    if-nez v19, :cond_7

    .line 1984
    const/16 v19, 0x1

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->setDrawingCacheEnabled(Z)V

    .line 1987
    :cond_7
    sget v19, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v20, 0xb

    move/from16 v0, v19

    move/from16 v1, v20

    if-lt v0, v1, :cond_8

    .line 1988
    if-eqz p7, :cond_8

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v19

    check-cast v19, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    move-object/from16 v0, v19

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->scrappedFromPosition:I

    move/from16 v19, v0

    move/from16 v0, v19

    move/from16 v1, p2

    if-eq v0, v1, :cond_8

    .line 1989
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->jumpDrawablesToCurrentState()V

    .line 1992
    :cond_8
    return-void

    .line 1915
    .end local v6    # "childLeft":I
    .end local v9    # "h":I
    .end local v10    # "isPressed":Z
    .end local v11    # "isSelected":Z
    .end local v13    # "mode":I
    .end local v14    # "needToMeasure":Z
    .end local v15    # "p":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    .end local v16    # "updateChildPressed":Z
    .end local v17    # "updateChildSelected":Z
    .end local v18    # "w":I
    :cond_9
    const/4 v11, 0x0

    goto/16 :goto_0

    .line 1916
    .restart local v11    # "isSelected":Z
    :cond_a
    const/16 v17, 0x0

    goto/16 :goto_1

    .line 1918
    .restart local v13    # "mode":I
    .restart local v17    # "updateChildSelected":Z
    :cond_b
    const/4 v10, 0x0

    goto/16 :goto_2

    .line 1919
    .restart local v10    # "isPressed":Z
    :cond_c
    const/16 v16, 0x0

    goto/16 :goto_3

    .line 1920
    .restart local v16    # "updateChildPressed":Z
    :cond_d
    const/4 v14, 0x0

    goto/16 :goto_4

    .line 1931
    .restart local v14    # "needToMeasure":Z
    .restart local v15    # "p":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    :cond_e
    const/16 v19, 0x0

    goto/16 :goto_5

    .line 1933
    :cond_f
    const/16 v19, 0x0

    move/from16 v0, v19

    iput-boolean v0, v15, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->forceAdd:Z

    .line 1934
    iget v0, v15, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    move/from16 v19, v0

    const/16 v20, -0x2

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_10

    .line 1935
    const/16 v19, 0x1

    move/from16 v0, v19

    iput-boolean v0, v15, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->recycledHeaderFooter:Z

    .line 1937
    :cond_10
    if-eqz p4, :cond_11

    const/16 v19, -0x1

    :goto_c
    const/16 v20, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v0, v1, v2, v15, v3}, Lit/sephiroth/android/library/widget/HListView;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;Z)Z

    goto/16 :goto_6

    :cond_11
    const/16 v19, 0x0

    goto :goto_c

    .line 1951
    :cond_12
    sget v19, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v20, 0xb

    move/from16 v0, v19

    move/from16 v1, v20

    if-lt v0, v1, :cond_6

    .line 1952
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-static/range {v20 .. v20}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v20

    move-object/from16 v0, v19

    move/from16 v1, p2

    move-object/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/util/SparseArrayCompat;->get(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/Boolean;

    invoke-virtual/range {v19 .. v19}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    goto/16 :goto_7

    .line 1963
    .restart local v5    # "childHeightSpec":I
    .restart local v12    # "lpWidth":I
    :cond_13
    const/16 v19, 0x0

    const/16 v20, 0x0

    invoke-static/range {v19 .. v20}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v8

    .restart local v8    # "childWidthSpec":I
    goto/16 :goto_8

    .line 1967
    .end local v5    # "childHeightSpec":I
    .end local v8    # "childWidthSpec":I
    .end local v12    # "lpWidth":I
    :cond_14
    invoke-virtual/range {p0 .. p1}, Lit/sephiroth/android/library/widget/HListView;->cleanupLayoutState(Landroid/view/View;)V

    goto/16 :goto_9

    .line 1972
    .restart local v9    # "h":I
    .restart local v18    # "w":I
    :cond_15
    sub-int v6, p3, v18

    goto/16 :goto_a

    .line 1979
    .restart local v6    # "childLeft":I
    :cond_16
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLeft()I

    move-result v19

    sub-int v19, v6, v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 1980
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTop()I

    move-result v19

    sub-int v19, p5, v19

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->offsetTopAndBottom(I)V

    goto/16 :goto_b
.end method

.method private showingLeftFadingEdge()Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 548
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getScrollX()I

    move-result v2

    iget-object v3, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->left:I

    add-int v0, v2, v3

    .line 549
    .local v0, "listLeft":I
    iget v2, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    if-gtz v2, :cond_0

    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getLeft()I

    move-result v2

    if-le v2, v0, :cond_1

    :cond_0
    const/4 v1, 0x1

    :cond_1
    return v1
.end method

.method private showingRightFadingEdge()Z
    .locals 6

    .prologue
    .line 556
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v0

    .line 557
    .local v0, "childCount":I
    add-int/lit8 v4, v0, -0x1

    invoke-virtual {p0, v4}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getRight()I

    move-result v3

    .line 558
    .local v3, "rightOfRightChild":I
    iget v4, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v4, v0

    add-int/lit8 v1, v4, -0x1

    .line 560
    .local v1, "lastVisiblePosition":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getScrollX()I

    move-result v4

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getWidth()I

    move-result v5

    add-int/2addr v4, v5

    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->right:I

    sub-int v2, v4, v5

    .line 562
    .local v2, "listRight":I
    iget v4, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v4, v4, -0x1

    if-lt v1, v4, :cond_0

    if-ge v3, v2, :cond_1

    :cond_0
    const/4 v4, 0x1

    :goto_0
    return v4

    :cond_1
    const/4 v4, 0x0

    goto :goto_0
.end method


# virtual methods
.method public addHeaderView(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 318
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-virtual {p0, p1, v0, v1}, Lit/sephiroth/android/library/widget/HListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 319
    return-void
.end method

.method public addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "data"    # Ljava/lang/Object;
    .param p3, "isSelectable"    # Z

    .prologue
    .line 289
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    instance-of v1, v1, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;

    if-nez v1, :cond_0

    .line 290
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Cannot add header view to list -- setAdapter has already been called."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 294
    :cond_0
    new-instance v0, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;

    invoke-direct {v0}, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;-><init>()V

    .line 295
    .local v0, "info":Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;
    iput-object p1, v0, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->view:Landroid/view/View;

    .line 296
    iput-object p2, v0, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->data:Ljava/lang/Object;

    .line 297
    iput-boolean p3, v0, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->isSelectable:Z

    .line 298
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 302
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    if-eqz v1, :cond_1

    .line 303
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;->onChanged()V

    .line 305
    :cond_1
    return-void
.end method

.method arrowScroll(I)Z
    .locals 3
    .param p1, "direction"    # I

    .prologue
    const/4 v2, 0x0

    .line 2456
    const/4 v1, 0x1

    :try_start_0
    iput-boolean v1, p0, Lit/sephiroth/android/library/widget/HListView;->mInLayout:Z

    .line 2457
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->arrowScrollImpl(I)Z

    move-result v0

    .line 2458
    .local v0, "handled":Z
    if-eqz v0, :cond_0

    .line 2459
    invoke-static {p1}, Landroid/view/SoundEffectConstants;->getContantForFocusDirection(I)I

    move-result v1

    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->playSoundEffect(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2463
    :cond_0
    iput-boolean v2, p0, Lit/sephiroth/android/library/widget/HListView;->mInLayout:Z

    return v0

    .end local v0    # "handled":Z
    :catchall_0
    move-exception v1

    iput-boolean v2, p0, Lit/sephiroth/android/library/widget/HListView;->mInLayout:Z

    throw v1
.end method

.method protected canAnimate()Z
    .locals 1

    .prologue
    .line 1996
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->canAnimate()Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 34
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 3187
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/HListView;->mCachingStarted:Z

    move/from16 v32, v0

    if-eqz v32, :cond_0

    .line 3188
    const/16 v32, 0x1

    move/from16 v0, v32

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lit/sephiroth/android/library/widget/HListView;->mCachingActive:Z

    .line 3192
    :cond_0
    move-object/from16 v0, p0

    iget v9, v0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    .line 3193
    .local v9, "dividerWidth":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mOverScrollHeader:Landroid/graphics/drawable/Drawable;

    move-object/from16 v27, v0

    .line 3194
    .local v27, "overscrollHeader":Landroid/graphics/drawable/Drawable;
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mOverScrollFooter:Landroid/graphics/drawable/Drawable;

    move-object/from16 v26, v0

    .line 3195
    .local v26, "overscrollFooter":Landroid/graphics/drawable/Drawable;
    if-eqz v27, :cond_9

    const/4 v12, 0x1

    .line 3196
    .local v12, "drawOverscrollHeader":Z
    :goto_0
    if-eqz v26, :cond_a

    const/4 v11, 0x1

    .line 3197
    .local v11, "drawOverscrollFooter":Z
    :goto_1
    if-lez v9, :cond_b

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mDivider:Landroid/graphics/drawable/Drawable;

    move-object/from16 v32, v0

    if-eqz v32, :cond_b

    const/4 v10, 0x1

    .line 3199
    .local v10, "drawDividers":Z
    :goto_2
    if-nez v10, :cond_1

    if-nez v12, :cond_1

    if-eqz v11, :cond_10

    .line 3201
    :cond_1
    move-object/from16 v0, p0

    iget-object v6, v0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    .line 3202
    .local v6, "bounds":Landroid/graphics/Rect;
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getPaddingTop()I

    move-result v32

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->top:I

    .line 3203
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getBottom()I

    move-result v32

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getTop()I

    move-result v33

    sub-int v32, v32, v33

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getPaddingBottom()I

    move-result v33

    sub-int v32, v32, v33

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->bottom:I

    .line 3205
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v8

    .line 3206
    .local v8, "count":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mHeaderViewInfos:Ljava/util/ArrayList;

    move-object/from16 v32, v0

    invoke-virtual/range {v32 .. v32}, Ljava/util/ArrayList;->size()I

    move-result v19

    .line 3207
    .local v19, "headerCount":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    move/from16 v22, v0

    .line 3208
    .local v22, "itemCount":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mFooterViewInfos:Ljava/util/ArrayList;

    move-object/from16 v32, v0

    invoke-virtual/range {v32 .. v32}, Ljava/util/ArrayList;->size()I

    move-result v32

    sub-int v32, v22, v32

    add-int/lit8 v18, v32, -0x1

    .line 3209
    .local v18, "footerLimit":I
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/HListView;->mHeaderDividersEnabled:Z

    move/from16 v20, v0

    .line 3210
    .local v20, "headerDividers":Z
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/HListView;->mFooterDividersEnabled:Z

    move/from16 v17, v0

    .line 3211
    .local v17, "footerDividers":Z
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    move/from16 v16, v0

    .line 3212
    .local v16, "first":I
    move-object/from16 v0, p0

    iget-boolean v5, v0, Lit/sephiroth/android/library/widget/HListView;->mAreAllItemsSelectable:Z

    .line 3213
    .local v5, "areAllItemsSelectable":Z
    move-object/from16 v0, p0

    iget-object v4, v0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 3218
    .local v4, "adapter":Landroid/widget/ListAdapter;
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->isOpaque()Z

    move-result v32

    if-eqz v32, :cond_c

    invoke-super/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isOpaque()Z

    move-result v32

    if-nez v32, :cond_c

    const/4 v15, 0x1

    .line 3220
    .local v15, "fillForMissingDividers":Z
    :goto_3
    if-eqz v15, :cond_2

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mDividerPaint:Landroid/graphics/Paint;

    move-object/from16 v32, v0

    if-nez v32, :cond_2

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/HListView;->mIsCacheColorOpaque:Z

    move/from16 v32, v0

    if-eqz v32, :cond_2

    .line 3221
    new-instance v32, Landroid/graphics/Paint;

    invoke-direct/range {v32 .. v32}, Landroid/graphics/Paint;-><init>()V

    move-object/from16 v0, v32

    move-object/from16 v1, p0

    iput-object v0, v1, Lit/sephiroth/android/library/widget/HListView;->mDividerPaint:Landroid/graphics/Paint;

    .line 3222
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mDividerPaint:Landroid/graphics/Paint;

    move-object/from16 v32, v0

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getCacheColorHint()I

    move-result v33

    invoke-virtual/range {v32 .. v33}, Landroid/graphics/Paint;->setColor(I)V

    .line 3224
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mDividerPaint:Landroid/graphics/Paint;

    move-object/from16 v28, v0

    .line 3226
    .local v28, "paint":Landroid/graphics/Paint;
    const/4 v13, 0x0

    .line 3227
    .local v13, "effectivePaddingLeft":I
    const/4 v14, 0x0

    .line 3233
    .local v14, "effectivePaddingRight":I
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getRight()I

    move-result v32

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getLeft()I

    move-result v33

    sub-int v32, v32, v33

    sub-int v32, v32, v14

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getScrollX()I

    move-result v33

    add-int v24, v32, v33

    .line 3234
    .local v24, "listRight":I
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/HListView;->mStackFromRight:Z

    move/from16 v32, v0

    if-nez v32, :cond_11

    .line 3235
    const/16 v29, 0x0

    .line 3238
    .local v29, "right":I
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getScrollX()I

    move-result v30

    .line 3239
    .local v30, "scrollX":I
    if-lez v8, :cond_3

    if-gez v30, :cond_3

    .line 3240
    if-eqz v12, :cond_d

    .line 3241
    const/16 v32, 0x0

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->right:I

    .line 3242
    move/from16 v0, v30

    iput v0, v6, Landroid/graphics/Rect;->left:I

    .line 3243
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v27

    invoke-virtual {v0, v1, v2, v6}, Lit/sephiroth/android/library/widget/HListView;->drawOverscrollHeader(Landroid/graphics/Canvas;Landroid/graphics/drawable/Drawable;Landroid/graphics/Rect;)V

    .line 3251
    :cond_3
    :goto_4
    const/16 v21, 0x0

    .local v21, "i":I
    :goto_5
    move/from16 v0, v21

    if-ge v0, v8, :cond_f

    .line 3252
    if-nez v20, :cond_4

    add-int v32, v16, v21

    move/from16 v0, v32

    move/from16 v1, v19

    if-lt v0, v1, :cond_8

    :cond_4
    if-nez v17, :cond_5

    add-int v32, v16, v21

    move/from16 v0, v32

    move/from16 v1, v18

    if-ge v0, v1, :cond_8

    .line 3254
    :cond_5
    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    .line 3255
    .local v7, "child":Landroid/view/View;
    invoke-virtual {v7}, Landroid/view/View;->getRight()I

    move-result v29

    .line 3258
    if-eqz v10, :cond_8

    move/from16 v0, v29

    move/from16 v1, v24

    if-ge v0, v1, :cond_8

    if-eqz v11, :cond_6

    add-int/lit8 v32, v8, -0x1

    move/from16 v0, v21

    move/from16 v1, v32

    if-eq v0, v1, :cond_8

    .line 3260
    :cond_6
    if-nez v5, :cond_7

    add-int v32, v16, v21

    move/from16 v0, v32

    invoke-interface {v4, v0}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v32

    if-eqz v32, :cond_e

    add-int/lit8 v32, v8, -0x1

    move/from16 v0, v21

    move/from16 v1, v32

    if-eq v0, v1, :cond_7

    add-int v32, v16, v21

    add-int/lit8 v32, v32, 0x1

    move/from16 v0, v32

    invoke-interface {v4, v0}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v32

    if-eqz v32, :cond_e

    .line 3262
    :cond_7
    move/from16 v0, v29

    iput v0, v6, Landroid/graphics/Rect;->left:I

    .line 3263
    add-int v32, v29, v9

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->right:I

    .line 3264
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v21

    invoke-virtual {v0, v1, v6, v2}, Lit/sephiroth/android/library/widget/HListView;->drawDivider(Landroid/graphics/Canvas;Landroid/graphics/Rect;I)V

    .line 3251
    .end local v7    # "child":Landroid/view/View;
    :cond_8
    :goto_6
    add-int/lit8 v21, v21, 0x1

    goto :goto_5

    .line 3195
    .end local v4    # "adapter":Landroid/widget/ListAdapter;
    .end local v5    # "areAllItemsSelectable":Z
    .end local v6    # "bounds":Landroid/graphics/Rect;
    .end local v8    # "count":I
    .end local v10    # "drawDividers":Z
    .end local v11    # "drawOverscrollFooter":Z
    .end local v12    # "drawOverscrollHeader":Z
    .end local v13    # "effectivePaddingLeft":I
    .end local v14    # "effectivePaddingRight":I
    .end local v15    # "fillForMissingDividers":Z
    .end local v16    # "first":I
    .end local v17    # "footerDividers":Z
    .end local v18    # "footerLimit":I
    .end local v19    # "headerCount":I
    .end local v20    # "headerDividers":Z
    .end local v21    # "i":I
    .end local v22    # "itemCount":I
    .end local v24    # "listRight":I
    .end local v28    # "paint":Landroid/graphics/Paint;
    .end local v29    # "right":I
    .end local v30    # "scrollX":I
    :cond_9
    const/4 v12, 0x0

    goto/16 :goto_0

    .line 3196
    .restart local v12    # "drawOverscrollHeader":Z
    :cond_a
    const/4 v11, 0x0

    goto/16 :goto_1

    .line 3197
    .restart local v11    # "drawOverscrollFooter":Z
    :cond_b
    const/4 v10, 0x0

    goto/16 :goto_2

    .line 3218
    .restart local v4    # "adapter":Landroid/widget/ListAdapter;
    .restart local v5    # "areAllItemsSelectable":Z
    .restart local v6    # "bounds":Landroid/graphics/Rect;
    .restart local v8    # "count":I
    .restart local v10    # "drawDividers":Z
    .restart local v16    # "first":I
    .restart local v17    # "footerDividers":Z
    .restart local v18    # "footerLimit":I
    .restart local v19    # "headerCount":I
    .restart local v20    # "headerDividers":Z
    .restart local v22    # "itemCount":I
    :cond_c
    const/4 v15, 0x0

    goto/16 :goto_3

    .line 3244
    .restart local v13    # "effectivePaddingLeft":I
    .restart local v14    # "effectivePaddingRight":I
    .restart local v15    # "fillForMissingDividers":Z
    .restart local v24    # "listRight":I
    .restart local v28    # "paint":Landroid/graphics/Paint;
    .restart local v29    # "right":I
    .restart local v30    # "scrollX":I
    :cond_d
    if-eqz v10, :cond_3

    .line 3245
    const/16 v32, 0x0

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->right:I

    .line 3246
    neg-int v0, v9

    move/from16 v32, v0

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->left:I

    .line 3247
    const/16 v32, -0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v32

    invoke-virtual {v0, v1, v6, v2}, Lit/sephiroth/android/library/widget/HListView;->drawDivider(Landroid/graphics/Canvas;Landroid/graphics/Rect;I)V

    goto/16 :goto_4

    .line 3265
    .restart local v7    # "child":Landroid/view/View;
    .restart local v21    # "i":I
    :cond_e
    if-eqz v15, :cond_8

    .line 3266
    move/from16 v0, v29

    iput v0, v6, Landroid/graphics/Rect;->left:I

    .line 3267
    add-int v32, v29, v9

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->right:I

    .line 3268
    move-object/from16 v0, p1

    move-object/from16 v1, v28

    invoke-virtual {v0, v6, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    goto :goto_6

    .line 3274
    .end local v7    # "child":Landroid/view/View;
    :cond_f
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getRight()I

    move-result v32

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getScrollX()I

    move-result v33

    add-int v25, v32, v33

    .line 3275
    .local v25, "overFooterBottom":I
    if-eqz v11, :cond_10

    add-int v32, v16, v8

    move/from16 v0, v32

    move/from16 v1, v22

    if-ne v0, v1, :cond_10

    move/from16 v0, v25

    move/from16 v1, v29

    if-le v0, v1, :cond_10

    .line 3277
    move/from16 v0, v29

    iput v0, v6, Landroid/graphics/Rect;->left:I

    .line 3278
    move/from16 v0, v25

    iput v0, v6, Landroid/graphics/Rect;->right:I

    .line 3279
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v26

    invoke-virtual {v0, v1, v2, v6}, Lit/sephiroth/android/library/widget/HListView;->drawOverscrollFooter(Landroid/graphics/Canvas;Landroid/graphics/drawable/Drawable;Landroid/graphics/Rect;)V

    .line 3334
    .end local v4    # "adapter":Landroid/widget/ListAdapter;
    .end local v5    # "areAllItemsSelectable":Z
    .end local v6    # "bounds":Landroid/graphics/Rect;
    .end local v8    # "count":I
    .end local v13    # "effectivePaddingLeft":I
    .end local v14    # "effectivePaddingRight":I
    .end local v15    # "fillForMissingDividers":Z
    .end local v16    # "first":I
    .end local v17    # "footerDividers":Z
    .end local v18    # "footerLimit":I
    .end local v19    # "headerCount":I
    .end local v20    # "headerDividers":Z
    .end local v21    # "i":I
    .end local v22    # "itemCount":I
    .end local v24    # "listRight":I
    .end local v25    # "overFooterBottom":I
    .end local v28    # "paint":Landroid/graphics/Paint;
    .end local v29    # "right":I
    .end local v30    # "scrollX":I
    :cond_10
    :goto_7
    invoke-super/range {p0 .. p1}, Lit/sephiroth/android/library/widget/AbsHListView;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 3335
    return-void

    .line 3284
    .restart local v4    # "adapter":Landroid/widget/ListAdapter;
    .restart local v5    # "areAllItemsSelectable":Z
    .restart local v6    # "bounds":Landroid/graphics/Rect;
    .restart local v8    # "count":I
    .restart local v13    # "effectivePaddingLeft":I
    .restart local v14    # "effectivePaddingRight":I
    .restart local v15    # "fillForMissingDividers":Z
    .restart local v16    # "first":I
    .restart local v17    # "footerDividers":Z
    .restart local v18    # "footerLimit":I
    .restart local v19    # "headerCount":I
    .restart local v20    # "headerDividers":Z
    .restart local v22    # "itemCount":I
    .restart local v24    # "listRight":I
    .restart local v28    # "paint":Landroid/graphics/Paint;
    :cond_11
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getScrollX()I

    move-result v30

    .line 3286
    .restart local v30    # "scrollX":I
    if-lez v8, :cond_12

    if-eqz v12, :cond_12

    .line 3287
    move/from16 v0, v30

    iput v0, v6, Landroid/graphics/Rect;->left:I

    .line 3288
    const/16 v32, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v32

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Landroid/view/View;->getLeft()I

    move-result v32

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->right:I

    .line 3289
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v27

    invoke-virtual {v0, v1, v2, v6}, Lit/sephiroth/android/library/widget/HListView;->drawOverscrollHeader(Landroid/graphics/Canvas;Landroid/graphics/drawable/Drawable;Landroid/graphics/Rect;)V

    .line 3292
    :cond_12
    if-eqz v12, :cond_17

    const/16 v31, 0x1

    .line 3293
    .local v31, "start":I
    :goto_8
    move/from16 v21, v31

    .restart local v21    # "i":I
    :goto_9
    move/from16 v0, v21

    if-ge v0, v8, :cond_19

    .line 3294
    if-nez v20, :cond_13

    add-int v32, v16, v21

    move/from16 v0, v32

    move/from16 v1, v19

    if-lt v0, v1, :cond_16

    :cond_13
    if-nez v17, :cond_14

    add-int v32, v16, v21

    move/from16 v0, v32

    move/from16 v1, v18

    if-ge v0, v1, :cond_16

    .line 3296
    :cond_14
    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    .line 3297
    .restart local v7    # "child":Landroid/view/View;
    invoke-virtual {v7}, Landroid/view/View;->getLeft()I

    move-result v23

    .line 3299
    .local v23, "left":I
    move/from16 v0, v23

    if-le v0, v13, :cond_16

    .line 3300
    if-nez v5, :cond_15

    add-int v32, v16, v21

    move/from16 v0, v32

    invoke-interface {v4, v0}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v32

    if-eqz v32, :cond_18

    add-int/lit8 v32, v8, -0x1

    move/from16 v0, v21

    move/from16 v1, v32

    if-eq v0, v1, :cond_15

    add-int v32, v16, v21

    add-int/lit8 v32, v32, 0x1

    move/from16 v0, v32

    invoke-interface {v4, v0}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v32

    if-eqz v32, :cond_18

    .line 3302
    :cond_15
    sub-int v32, v23, v9

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->left:I

    .line 3303
    move/from16 v0, v23

    iput v0, v6, Landroid/graphics/Rect;->right:I

    .line 3308
    add-int/lit8 v32, v21, -0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v32

    invoke-virtual {v0, v1, v6, v2}, Lit/sephiroth/android/library/widget/HListView;->drawDivider(Landroid/graphics/Canvas;Landroid/graphics/Rect;I)V

    .line 3293
    .end local v7    # "child":Landroid/view/View;
    .end local v23    # "left":I
    :cond_16
    :goto_a
    add-int/lit8 v21, v21, 0x1

    goto :goto_9

    .line 3292
    .end local v21    # "i":I
    .end local v31    # "start":I
    :cond_17
    const/16 v31, 0x0

    goto :goto_8

    .line 3309
    .restart local v7    # "child":Landroid/view/View;
    .restart local v21    # "i":I
    .restart local v23    # "left":I
    .restart local v31    # "start":I
    :cond_18
    if-eqz v15, :cond_16

    .line 3310
    sub-int v32, v23, v9

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->left:I

    .line 3311
    move/from16 v0, v23

    iput v0, v6, Landroid/graphics/Rect;->right:I

    .line 3312
    move-object/from16 v0, p1

    move-object/from16 v1, v28

    invoke-virtual {v0, v6, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    goto :goto_a

    .line 3318
    .end local v7    # "child":Landroid/view/View;
    .end local v23    # "left":I
    :cond_19
    if-lez v8, :cond_10

    if-lez v30, :cond_10

    .line 3319
    if-eqz v11, :cond_1a

    .line 3320
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getRight()I

    move-result v3

    .line 3321
    .local v3, "absListRight":I
    iput v3, v6, Landroid/graphics/Rect;->left:I

    .line 3322
    add-int v32, v3, v30

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->right:I

    .line 3323
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v26

    invoke-virtual {v0, v1, v2, v6}, Lit/sephiroth/android/library/widget/HListView;->drawOverscrollFooter(Landroid/graphics/Canvas;Landroid/graphics/drawable/Drawable;Landroid/graphics/Rect;)V

    goto/16 :goto_7

    .line 3324
    .end local v3    # "absListRight":I
    :cond_1a
    if-eqz v10, :cond_10

    .line 3325
    move/from16 v0, v24

    iput v0, v6, Landroid/graphics/Rect;->left:I

    .line 3326
    add-int v32, v24, v9

    move/from16 v0, v32

    iput v0, v6, Landroid/graphics/Rect;->right:I

    .line 3327
    const/16 v32, -0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v32

    invoke-virtual {v0, v1, v6, v2}, Lit/sephiroth/android/library/widget/HListView;->drawDivider(Landroid/graphics/Canvas;Landroid/graphics/Rect;I)V

    goto/16 :goto_7
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 2147
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    .line 2148
    .local v1, "handled":Z
    if-nez v1, :cond_0

    .line 2150
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getFocusedChild()Landroid/view/View;

    move-result-object v0

    .line 2151
    .local v0, "focused":Landroid/view/View;
    if-eqz v0, :cond_0

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_0

    .line 2154
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v2

    invoke-virtual {p0, v2, p1}, Lit/sephiroth/android/library/widget/HListView;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v1

    .line 2157
    .end local v0    # "focused":Landroid/view/View;
    :cond_0
    return v1
.end method

.method protected drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "child"    # Landroid/view/View;
    .param p3, "drawingTime"    # J

    .prologue
    .line 3339
    invoke-super {p0, p1, p2, p3, p4}, Lit/sephiroth/android/library/widget/AbsHListView;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    move-result v0

    .line 3340
    .local v0, "more":Z
    iget-boolean v1, p0, Lit/sephiroth/android/library/widget/HListView;->mCachingActive:Z

    if-eqz v1, :cond_0

    .line 3341
    const/4 v1, 0x0

    iput-boolean v1, p0, Lit/sephiroth/android/library/widget/HListView;->mCachingActive:Z

    .line 3343
    :cond_0
    return v0
.end method

.method drawDivider(Landroid/graphics/Canvas;Landroid/graphics/Rect;I)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "bounds"    # Landroid/graphics/Rect;
    .param p3, "childIndex"    # I

    .prologue
    .line 3359
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mDivider:Landroid/graphics/drawable/Drawable;

    .line 3361
    .local v0, "divider":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v0, p2}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 3362
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 3363
    return-void
.end method

.method drawOverscrollFooter(Landroid/graphics/Canvas;Landroid/graphics/drawable/Drawable;Landroid/graphics/Rect;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p3, "bounds"    # Landroid/graphics/Rect;

    .prologue
    .line 3169
    invoke-virtual {p2}, Landroid/graphics/drawable/Drawable;->getMinimumWidth()I

    move-result v1

    .line 3171
    .local v1, "width":I
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 3172
    invoke-virtual {p1, p3}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/Rect;)Z

    .line 3174
    iget v2, p3, Landroid/graphics/Rect;->right:I

    iget v3, p3, Landroid/graphics/Rect;->left:I

    sub-int v0, v2, v3

    .line 3175
    .local v0, "span":I
    if-ge v0, v1, :cond_0

    .line 3176
    iget v2, p3, Landroid/graphics/Rect;->left:I

    add-int/2addr v2, v1

    iput v2, p3, Landroid/graphics/Rect;->right:I

    .line 3179
    :cond_0
    invoke-virtual {p2, p3}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 3180
    invoke-virtual {p2, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 3182
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 3183
    return-void
.end method

.method drawOverscrollHeader(Landroid/graphics/Canvas;Landroid/graphics/drawable/Drawable;Landroid/graphics/Rect;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p3, "bounds"    # Landroid/graphics/Rect;

    .prologue
    .line 3152
    invoke-virtual {p2}, Landroid/graphics/drawable/Drawable;->getMinimumWidth()I

    move-result v1

    .line 3154
    .local v1, "width":I
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 3155
    invoke-virtual {p1, p3}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/Rect;)Z

    .line 3157
    iget v2, p3, Landroid/graphics/Rect;->right:I

    iget v3, p3, Landroid/graphics/Rect;->left:I

    sub-int v0, v2, v3

    .line 3158
    .local v0, "span":I
    if-ge v0, v1, :cond_0

    .line 3159
    iget v2, p3, Landroid/graphics/Rect;->right:I

    sub-int/2addr v2, v1

    iput v2, p3, Landroid/graphics/Rect;->left:I

    .line 3162
    :cond_0
    invoke-virtual {p2, p3}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 3163
    invoke-virtual {p2, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 3165
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 3166
    return-void
.end method

.method protected fillGap(Z)V
    .locals 6
    .param p1, "down"    # Z

    .prologue
    .line 650
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v0

    .line 651
    .local v0, "count":I
    if-eqz p1, :cond_1

    .line 652
    const/4 v1, 0x0

    .line 656
    .local v1, "paddingLeft":I
    if-lez v0, :cond_0

    add-int/lit8 v4, v0, -0x1

    invoke-virtual {p0, v4}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getRight()I

    move-result v4

    iget v5, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    add-int v3, v4, v5

    .line 657
    .local v3, "startOffset":I
    :goto_0
    iget v4, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v4, v0

    invoke-direct {p0, v4, v3}, Lit/sephiroth/android/library/widget/HListView;->fillRight(II)Landroid/view/View;

    .line 658
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v4

    invoke-direct {p0, v4}, Lit/sephiroth/android/library/widget/HListView;->correctTooWide(I)V

    .line 668
    .end local v1    # "paddingLeft":I
    :goto_1
    return-void

    .end local v3    # "startOffset":I
    .restart local v1    # "paddingLeft":I
    :cond_0
    move v3, v1

    .line 656
    goto :goto_0

    .line 660
    .end local v1    # "paddingLeft":I
    :cond_1
    const/4 v2, 0x0

    .line 664
    .local v2, "paddingRight":I
    if-lez v0, :cond_2

    const/4 v4, 0x0

    invoke-virtual {p0, v4}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getLeft()I

    move-result v4

    iget v5, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    sub-int v3, v4, v5

    .line 665
    .restart local v3    # "startOffset":I
    :goto_2
    iget v4, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/lit8 v4, v4, -0x1

    invoke-direct {p0, v4, v3}, Lit/sephiroth/android/library/widget/HListView;->fillLeft(II)Landroid/view/View;

    .line 666
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v4

    invoke-direct {p0, v4}, Lit/sephiroth/android/library/widget/HListView;->correctTooSmall(I)V

    goto :goto_1

    .line 664
    .end local v3    # "startOffset":I
    :cond_2
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getWidth()I

    move-result v4

    sub-int v3, v4, v2

    goto :goto_2
.end method

.method protected findMotionCol(I)I
    .locals 4
    .param p1, "x"    # I

    .prologue
    .line 1355
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v0

    .line 1356
    .local v0, "childCount":I
    if-lez v0, :cond_3

    .line 1357
    iget-boolean v3, p0, Lit/sephiroth/android/library/widget/HListView;->mStackFromRight:Z

    if-nez v3, :cond_1

    .line 1358
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_3

    .line 1359
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 1360
    .local v2, "v":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getRight()I

    move-result v3

    if-gt p1, v3, :cond_0

    .line 1361
    iget v3, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v3, v1

    .line 1373
    .end local v1    # "i":I
    .end local v2    # "v":Landroid/view/View;
    :goto_1
    return v3

    .line 1358
    .restart local v1    # "i":I
    .restart local v2    # "v":Landroid/view/View;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1365
    .end local v1    # "i":I
    .end local v2    # "v":Landroid/view/View;
    :cond_1
    add-int/lit8 v1, v0, -0x1

    .restart local v1    # "i":I
    :goto_2
    if-ltz v1, :cond_3

    .line 1366
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 1367
    .restart local v2    # "v":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getLeft()I

    move-result v3

    if-lt p1, v3, :cond_2

    .line 1368
    iget v3, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v3, v1

    goto :goto_1

    .line 1365
    :cond_2
    add-int/lit8 v1, v1, -0x1

    goto :goto_2

    .line 1373
    .end local v1    # "i":I
    .end local v2    # "v":Landroid/view/View;
    :cond_3
    const/4 v3, -0x1

    goto :goto_1
.end method

.method fullScroll(I)Z
    .locals 5
    .param p1, "direction"    # I

    .prologue
    const/4 v4, 0x1

    .line 2368
    const/4 v0, 0x0

    .line 2369
    .local v0, "moved":Z
    const/16 v2, 0x21

    if-ne p1, v2, :cond_3

    .line 2370
    iget v2, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    if-eqz v2, :cond_1

    .line 2371
    const/4 v2, 0x0

    invoke-virtual {p0, v2, v4}, Lit/sephiroth/android/library/widget/HListView;->lookForSelectablePosition(IZ)I

    move-result v1

    .line 2372
    .local v1, "position":I
    if-ltz v1, :cond_0

    .line 2373
    iput v4, p0, Lit/sephiroth/android/library/widget/HListView;->mLayoutMode:I

    .line 2374
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->setSelectionInt(I)V

    .line 2375
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invokeOnItemScrollListener()V

    .line 2377
    :cond_0
    const/4 v0, 0x1

    .line 2391
    .end local v1    # "position":I
    :cond_1
    :goto_0
    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->awakenScrollBars()Z

    move-result v2

    if-nez v2, :cond_2

    .line 2392
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->awakenScrollBars()Z

    .line 2393
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invalidate()V

    .line 2396
    :cond_2
    return v0

    .line 2379
    :cond_3
    const/16 v2, 0x82

    if-ne p1, v2, :cond_1

    .line 2380
    iget v2, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    iget v3, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v3, v3, -0x1

    if-ge v2, v3, :cond_1

    .line 2381
    iget v2, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p0, v2, v4}, Lit/sephiroth/android/library/widget/HListView;->lookForSelectablePosition(IZ)I

    move-result v1

    .line 2382
    .restart local v1    # "position":I
    if-ltz v1, :cond_4

    .line 2383
    const/4 v2, 0x3

    iput v2, p0, Lit/sephiroth/android/library/widget/HListView;->mLayoutMode:I

    .line 2384
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->setSelectionInt(I)V

    .line 2385
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invokeOnItemScrollListener()V

    .line 2387
    :cond_4
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public bridge synthetic getAdapter()Landroid/widget/Adapter;
    .locals 1

    .prologue
    .line 77
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    return-object v0
.end method

.method public getAdapter()Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 445
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method public getCheckItemIds()[J
    .locals 11
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v10, 0x0

    .line 3588
    iget-object v8, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v8, :cond_1

    iget-object v8, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v8}, Landroid/widget/ListAdapter;->hasStableIds()Z

    move-result v8

    if-eqz v8, :cond_1

    .line 3589
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getCheckedItemIds()[J

    move-result-object v5

    .line 3618
    :cond_0
    :goto_0
    return-object v5

    .line 3594
    :cond_1
    iget v8, p0, Lit/sephiroth/android/library/widget/HListView;->mChoiceMode:I

    if-eqz v8, :cond_3

    iget-object v8, p0, Lit/sephiroth/android/library/widget/HListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    if-eqz v8, :cond_3

    iget-object v8, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v8, :cond_3

    .line 3595
    iget-object v7, p0, Lit/sephiroth/android/library/widget/HListView;->mCheckStates:Landroid/support/v4/util/SparseArrayCompat;

    .line 3596
    .local v7, "states":Landroid/support/v4/util/SparseArrayCompat;, "Landroid/support/v4/util/SparseArrayCompat<Ljava/lang/Boolean;>;"
    invoke-virtual {v7}, Landroid/support/v4/util/SparseArrayCompat;->size()I

    move-result v3

    .line 3597
    .local v3, "count":I
    new-array v5, v3, [J

    .line 3598
    .local v5, "ids":[J
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 3600
    .local v0, "adapter":Landroid/widget/ListAdapter;
    const/4 v1, 0x0

    .line 3601
    .local v1, "checkedCount":I
    const/4 v4, 0x0

    .local v4, "i":I
    move v2, v1

    .end local v1    # "checkedCount":I
    .local v2, "checkedCount":I
    :goto_1
    if-ge v4, v3, :cond_2

    .line 3602
    invoke-virtual {v7, v4}, Landroid/support/v4/util/SparseArrayCompat;->valueAt(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Boolean;

    invoke-virtual {v8}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    if-eqz v8, :cond_4

    .line 3603
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "checkedCount":I
    .restart local v1    # "checkedCount":I
    invoke-virtual {v7, v4}, Landroid/support/v4/util/SparseArrayCompat;->keyAt(I)I

    move-result v8

    invoke-interface {v0, v8}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v8

    aput-wide v8, v5, v2

    .line 3601
    :goto_2
    add-int/lit8 v4, v4, 0x1

    move v2, v1

    .end local v1    # "checkedCount":I
    .restart local v2    # "checkedCount":I
    goto :goto_1

    .line 3609
    :cond_2
    if-eq v2, v3, :cond_0

    .line 3612
    new-array v6, v2, [J

    .line 3613
    .local v6, "result":[J
    invoke-static {v5, v10, v6, v10, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object v5, v6

    .line 3615
    goto :goto_0

    .line 3618
    .end local v0    # "adapter":Landroid/widget/ListAdapter;
    .end local v2    # "checkedCount":I
    .end local v3    # "count":I
    .end local v4    # "i":I
    .end local v5    # "ids":[J
    .end local v6    # "result":[J
    .end local v7    # "states":Landroid/support/v4/util/SparseArrayCompat;, "Landroid/support/v4/util/SparseArrayCompat<Ljava/lang/Boolean;>;"
    :cond_3
    new-array v5, v10, [J

    goto :goto_0

    .restart local v0    # "adapter":Landroid/widget/ListAdapter;
    .restart local v2    # "checkedCount":I
    .restart local v3    # "count":I
    .restart local v4    # "i":I
    .restart local v5    # "ids":[J
    .restart local v7    # "states":Landroid/support/v4/util/SparseArrayCompat;, "Landroid/support/v4/util/SparseArrayCompat<Ljava/lang/Boolean;>;"
    :cond_4
    move v1, v2

    .end local v2    # "checkedCount":I
    .restart local v1    # "checkedCount":I
    goto :goto_2
.end method

.method public getDivider()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 3371
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mDivider:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getDividerWidth()I
    .locals 1

    .prologue
    .line 3401
    iget v0, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    return v0
.end method

.method public getFooterViewsCount()I
    .locals 1

    .prologue
    .line 410
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getHeaderViewsCount()I
    .locals 1

    .prologue
    .line 323
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItemsCanFocus()Z
    .locals 1

    .prologue
    .line 3116
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/HListView;->mItemsCanFocus:Z

    return v0
.end method

.method public getMaxScrollAmount()I
    .locals 3

    .prologue
    .line 224
    const v0, 0x3ea8f5c3    # 0.33f

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getRight()I

    move-result v1

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getLeft()I

    move-result v2

    sub-int/2addr v1, v2

    int-to-float v1, v1

    mul-float/2addr v0, v1

    float-to-int v0, v0

    return v0
.end method

.method public getOverscrollFooter()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 3485
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mOverScrollFooter:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getOverscrollHeader()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 3466
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mOverScrollHeader:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public isOpaque()Z
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 3121
    iget-boolean v5, p0, Lit/sephiroth/android/library/widget/HListView;->mCachingActive:Z

    if-eqz v5, :cond_0

    iget-boolean v5, p0, Lit/sephiroth/android/library/widget/HListView;->mIsCacheColorOpaque:Z

    if-eqz v5, :cond_0

    iget-boolean v5, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerIsOpaque:Z

    if-nez v5, :cond_1

    :cond_0
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->isOpaque()Z

    move-result v5

    if-eqz v5, :cond_4

    :cond_1
    const/4 v4, 0x1

    .line 3122
    .local v4, "retValue":Z
    :goto_0
    if-eqz v4, :cond_3

    .line 3124
    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    if-eqz v5, :cond_5

    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v2, v5, Landroid/graphics/Rect;->left:I

    .line 3125
    .local v2, "listLeft":I
    :goto_1
    invoke-virtual {p0, v6}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 3126
    .local v0, "first":Landroid/view/View;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v5

    if-le v5, v2, :cond_6

    :cond_2
    move v4, v6

    .line 3135
    .end local v0    # "first":Landroid/view/View;
    .end local v2    # "listLeft":I
    .end local v4    # "retValue":Z
    :cond_3
    :goto_2
    return v4

    :cond_4
    move v4, v6

    .line 3121
    goto :goto_0

    .line 3124
    .restart local v4    # "retValue":Z
    :cond_5
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getPaddingLeft()I

    move-result v2

    goto :goto_1

    .line 3129
    .restart local v0    # "first":Landroid/view/View;
    .restart local v2    # "listLeft":I
    :cond_6
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getWidth()I

    move-result v7

    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    if-eqz v5, :cond_8

    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->right:I

    :goto_3
    sub-int v3, v7, v5

    .line 3130
    .local v3, "listRight":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 3131
    .local v1, "last":Landroid/view/View;
    if-eqz v1, :cond_7

    invoke-virtual {v1}, Landroid/view/View;->getRight()I

    move-result v5

    if-ge v5, v3, :cond_3

    :cond_7
    move v4, v6

    .line 3132
    goto :goto_2

    .line 3129
    .end local v1    # "last":Landroid/view/View;
    .end local v3    # "listRight":I
    :cond_8
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getPaddingRight()I

    move-result v5

    goto :goto_3
.end method

.method protected layoutChildren()V
    .locals 26

    .prologue
    .line 1531
    move-object/from16 v0, p0

    iget-boolean v8, v0, Lit/sephiroth/android/library/widget/HListView;->mBlockLayoutRequests:Z

    .line 1532
    .local v8, "blockLayoutRequests":Z
    if-nez v8, :cond_0

    .line 1533
    const/4 v2, 0x1

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lit/sephiroth/android/library/widget/HListView;->mBlockLayoutRequests:Z

    .line 1539
    :try_start_0
    invoke-super/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView;->layoutChildren()V

    .line 1541
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->invalidate()V

    .line 1543
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    if-nez v2, :cond_1

    .line 1544
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->resetList()V

    .line 1545
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->invokeOnItemScrollListener()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1807
    if-nez v8, :cond_0

    .line 1808
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lit/sephiroth/android/library/widget/HListView;->mBlockLayoutRequests:Z

    .line 1811
    :cond_0
    :goto_0
    return-void

    .line 1549
    :cond_1
    :try_start_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v6, v2, Landroid/graphics/Rect;->left:I

    .line 1550
    .local v6, "childrenLeft":I
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getRight()I

    move-result v2

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getLeft()I

    move-result v24

    sub-int v2, v2, v24

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v24, v0

    sub-int v7, v2, v24

    .line 1552
    .local v7, "childrenRight":I
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v10

    .line 1553
    .local v10, "childCount":I
    const/16 v19, 0x0

    .line 1554
    .local v19, "index":I
    const/4 v5, 0x0

    .line 1557
    .local v5, "delta":I
    const/4 v3, 0x0

    .line 1558
    .local v3, "oldSel":Landroid/view/View;
    const/16 v20, 0x0

    .line 1559
    .local v20, "oldFirst":Landroid/view/View;
    const/4 v4, 0x0

    .line 1561
    .local v4, "newSel":Landroid/view/View;
    const/4 v14, 0x0

    .line 1568
    .local v14, "focusLayoutRestoreView":Landroid/view/View;
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mLayoutMode:I

    packed-switch v2, :pswitch_data_0

    .line 1583
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    move/from16 v24, v0

    sub-int v19, v2, v24

    .line 1584
    if-ltz v19, :cond_2

    move/from16 v0, v19

    if-ge v0, v10, :cond_2

    .line 1585
    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 1589
    :cond_2
    const/4 v2, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v20

    .line 1591
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mNextSelectedPosition:I

    if-ltz v2, :cond_3

    .line 1592
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mNextSelectedPosition:I

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    move/from16 v24, v0

    sub-int v5, v2, v24

    .line 1596
    :cond_3
    add-int v2, v19, v5

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 1599
    :cond_4
    :goto_1
    :pswitch_0
    move-object/from16 v0, p0

    iget-boolean v11, v0, Lit/sephiroth/android/library/widget/HListView;->mDataChanged:Z

    .line 1600
    .local v11, "dataChanged":Z
    if-eqz v11, :cond_5

    .line 1601
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->handleDataChanged()V

    .line 1606
    :cond_5
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    if-nez v2, :cond_6

    .line 1607
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->resetList()V

    .line 1608
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->invokeOnItemScrollListener()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1807
    if-nez v8, :cond_0

    .line 1808
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lit/sephiroth/android/library/widget/HListView;->mBlockLayoutRequests:Z

    goto/16 :goto_0

    .line 1570
    .end local v11    # "dataChanged":Z
    :pswitch_1
    :try_start_2
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mNextSelectedPosition:I

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    move/from16 v24, v0

    sub-int v19, v2, v24

    .line 1571
    if-ltz v19, :cond_4

    move/from16 v0, v19

    if-ge v0, v10, :cond_4

    .line 1572
    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    goto :goto_1

    .line 1610
    .restart local v11    # "dataChanged":Z
    :cond_6
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    move-object/from16 v24, v0

    invoke-interface/range {v24 .. v24}, Landroid/widget/ListAdapter;->getCount()I

    move-result v24

    move/from16 v0, v24

    if-eq v2, v0, :cond_8

    .line 1611
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v24, Ljava/lang/StringBuilder;

    invoke-direct/range {v24 .. v24}, Ljava/lang/StringBuilder;-><init>()V

    const-string v25, "The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView("

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getId()I

    move-result v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v24

    const-string v25, ", "

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v24

    const-string v25, ") with Adapter("

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v24

    const-string v25, ")]"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v24

    invoke-direct {v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1807
    .end local v3    # "oldSel":Landroid/view/View;
    .end local v4    # "newSel":Landroid/view/View;
    .end local v5    # "delta":I
    .end local v6    # "childrenLeft":I
    .end local v7    # "childrenRight":I
    .end local v10    # "childCount":I
    .end local v11    # "dataChanged":Z
    .end local v14    # "focusLayoutRestoreView":Landroid/view/View;
    .end local v19    # "index":I
    .end local v20    # "oldFirst":Landroid/view/View;
    :catchall_0
    move-exception v2

    if-nez v8, :cond_7

    .line 1808
    const/16 v24, 0x0

    move/from16 v0, v24

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lit/sephiroth/android/library/widget/HListView;->mBlockLayoutRequests:Z

    :cond_7
    throw v2

    .line 1618
    .restart local v3    # "oldSel":Landroid/view/View;
    .restart local v4    # "newSel":Landroid/view/View;
    .restart local v5    # "delta":I
    .restart local v6    # "childrenLeft":I
    .restart local v7    # "childrenRight":I
    .restart local v10    # "childCount":I
    .restart local v11    # "dataChanged":Z
    .restart local v14    # "focusLayoutRestoreView":Landroid/view/View;
    .restart local v19    # "index":I
    .restart local v20    # "oldFirst":Landroid/view/View;
    :cond_8
    :try_start_3
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mNextSelectedPosition:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lit/sephiroth/android/library/widget/HListView;->setSelectedPositionInt(I)V

    .line 1622
    move-object/from16 v0, p0

    iget v12, v0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    .line 1623
    .local v12, "firstPosition":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    move-object/from16 v22, v0

    .line 1626
    .local v22, "recycleBin":Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;
    const/4 v13, 0x0

    .line 1630
    .local v13, "focusLayoutRestoreDirectChild":Landroid/view/View;
    if-eqz v11, :cond_9

    .line 1631
    const/16 v18, 0x0

    .local v18, "i":I
    :goto_2
    move/from16 v0, v18

    if-ge v0, v10, :cond_a

    .line 1632
    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    add-int v24, v12, v18

    move-object/from16 v0, v22

    move/from16 v1, v24

    invoke-virtual {v0, v2, v1}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->addScrapView(Landroid/view/View;I)V

    .line 1631
    add-int/lit8 v18, v18, 0x1

    goto :goto_2

    .line 1635
    .end local v18    # "i":I
    :cond_9
    move-object/from16 v0, v22

    invoke-virtual {v0, v10, v12}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->fillActiveViews(II)V

    .line 1642
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getFocusedChild()Landroid/view/View;

    move-result-object v17

    .line 1643
    .local v17, "focusedChild":Landroid/view/View;
    if-eqz v17, :cond_d

    .line 1648
    if-eqz v11, :cond_b

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1}, Lit/sephiroth/android/library/widget/HListView;->isDirectChildHeaderOrFooter(Landroid/view/View;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 1649
    :cond_b
    move-object/from16 v13, v17

    .line 1651
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->findFocus()Landroid/view/View;

    move-result-object v14

    .line 1652
    if-eqz v14, :cond_c

    .line 1654
    invoke-virtual {v14}, Landroid/view/View;->onStartTemporaryDetach()V

    .line 1657
    :cond_c
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->requestFocus()Z

    .line 1672
    :cond_d
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->detachAllViewsFromParent()V

    .line 1673
    invoke-virtual/range {v22 .. v22}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->removeSkippedScrap()V

    .line 1675
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mLayoutMode:I

    packed-switch v2, :pswitch_data_1

    .line 1702
    if-nez v10, :cond_17

    .line 1703
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lit/sephiroth/android/library/widget/HListView;->mStackFromRight:Z

    if-nez v2, :cond_16

    .line 1704
    const/4 v2, 0x0

    const/16 v24, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-virtual {v0, v2, v1}, Lit/sephiroth/android/library/widget/HListView;->lookForSelectablePosition(IZ)I

    move-result v21

    .line 1705
    .local v21, "position":I
    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/HListView;->setSelectedPositionInt(I)V

    .line 1706
    move-object/from16 v0, p0

    invoke-direct {v0, v6}, Lit/sephiroth/android/library/widget/HListView;->fillFromLeft(I)Landroid/view/View;

    move-result-object v23

    .line 1725
    .end local v6    # "childrenLeft":I
    .end local v21    # "position":I
    .local v23, "sel":Landroid/view/View;
    :goto_3
    invoke-virtual/range {v22 .. v22}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->scrapActiveViews()V

    .line 1727
    if-eqz v23, :cond_1f

    .line 1730
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lit/sephiroth/android/library/widget/HListView;->mItemsCanFocus:Z

    if-eqz v2, :cond_1e

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->hasFocus()Z

    move-result v2

    if-eqz v2, :cond_1e

    invoke-virtual/range {v23 .. v23}, Landroid/view/View;->hasFocus()Z

    move-result v2

    if-nez v2, :cond_1e

    .line 1731
    move-object/from16 v0, v23

    if-ne v0, v13, :cond_e

    if-eqz v14, :cond_e

    invoke-virtual {v14}, Landroid/view/View;->requestFocus()Z

    move-result v2

    if-nez v2, :cond_f

    :cond_e
    invoke-virtual/range {v23 .. v23}, Landroid/view/View;->requestFocus()Z

    move-result v2

    if-eqz v2, :cond_1c

    :cond_f
    const/4 v15, 0x1

    .line 1734
    .local v15, "focusWasTaken":Z
    :goto_4
    if-nez v15, :cond_1d

    .line 1738
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getFocusedChild()Landroid/view/View;

    move-result-object v16

    .line 1739
    .local v16, "focused":Landroid/view/View;
    if-eqz v16, :cond_10

    .line 1740
    invoke-virtual/range {v16 .. v16}, Landroid/view/View;->clearFocus()V

    .line 1742
    :cond_10
    const/4 v2, -0x1

    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-virtual {v0, v2, v1}, Lit/sephiroth/android/library/widget/HListView;->positionSelector(ILandroid/view/View;)V

    .line 1750
    .end local v15    # "focusWasTaken":Z
    .end local v16    # "focused":Landroid/view/View;
    :goto_5
    invoke-virtual/range {v23 .. v23}, Landroid/view/View;->getLeft()I

    move-result v2

    move-object/from16 v0, p0

    iput v2, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedLeft:I

    .line 1785
    :cond_11
    :goto_6
    if-eqz v14, :cond_12

    invoke-virtual {v14}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    if-eqz v2, :cond_12

    .line 1787
    invoke-virtual {v14}, Landroid/view/View;->onFinishTemporaryDetach()V

    .line 1790
    :cond_12
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput v2, v0, Lit/sephiroth/android/library/widget/HListView;->mLayoutMode:I

    .line 1791
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lit/sephiroth/android/library/widget/HListView;->mDataChanged:Z

    .line 1792
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mPositionScrollAfterLayout:Ljava/lang/Runnable;

    if-eqz v2, :cond_13

    .line 1793
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mPositionScrollAfterLayout:Ljava/lang/Runnable;

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lit/sephiroth/android/library/widget/HListView;->post(Ljava/lang/Runnable;)Z

    .line 1794
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mPositionScrollAfterLayout:Ljava/lang/Runnable;

    .line 1796
    :cond_13
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lit/sephiroth/android/library/widget/HListView;->mNeedSync:Z

    .line 1797
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lit/sephiroth/android/library/widget/HListView;->setNextSelectedPositionInt(I)V

    .line 1799
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->updateScrollIndicators()V

    .line 1801
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    if-lez v2, :cond_14

    .line 1802
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->checkSelectionChanged()V

    .line 1805
    :cond_14
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->invokeOnItemScrollListener()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1807
    if-nez v8, :cond_0

    .line 1808
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lit/sephiroth/android/library/widget/HListView;->mBlockLayoutRequests:Z

    goto/16 :goto_0

    .line 1677
    .end local v23    # "sel":Landroid/view/View;
    .restart local v6    # "childrenLeft":I
    :pswitch_2
    if-eqz v4, :cond_15

    .line 1678
    :try_start_4
    invoke-virtual {v4}, Landroid/view/View;->getLeft()I

    move-result v2

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v6, v7}, Lit/sephiroth/android/library/widget/HListView;->fillFromSelection(III)Landroid/view/View;

    move-result-object v23

    .restart local v23    # "sel":Landroid/view/View;
    goto/16 :goto_3

    .line 1680
    .end local v23    # "sel":Landroid/view/View;
    :cond_15
    move-object/from16 v0, p0

    invoke-direct {v0, v6, v7}, Lit/sephiroth/android/library/widget/HListView;->fillFromMiddle(II)Landroid/view/View;

    move-result-object v23

    .line 1682
    .restart local v23    # "sel":Landroid/view/View;
    goto/16 :goto_3

    .line 1684
    .end local v23    # "sel":Landroid/view/View;
    :pswitch_3
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mSyncPosition:I

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mSpecificLeft:I

    move/from16 v24, v0

    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-direct {v0, v2, v1}, Lit/sephiroth/android/library/widget/HListView;->fillSpecific(II)Landroid/view/View;

    move-result-object v23

    .line 1685
    .restart local v23    # "sel":Landroid/view/View;
    goto/16 :goto_3

    .line 1687
    .end local v23    # "sel":Landroid/view/View;
    :pswitch_4
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v2, v2, -0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v7}, Lit/sephiroth/android/library/widget/HListView;->fillLeft(II)Landroid/view/View;

    move-result-object v23

    .line 1688
    .restart local v23    # "sel":Landroid/view/View;
    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->adjustViewsLeftOrRight()V

    goto/16 :goto_3

    .line 1691
    .end local v23    # "sel":Landroid/view/View;
    :pswitch_5
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput v2, v0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    .line 1692
    move-object/from16 v0, p0

    invoke-direct {v0, v6}, Lit/sephiroth/android/library/widget/HListView;->fillFromLeft(I)Landroid/view/View;

    move-result-object v23

    .line 1693
    .restart local v23    # "sel":Landroid/view/View;
    invoke-direct/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->adjustViewsLeftOrRight()V

    goto/16 :goto_3

    .line 1696
    .end local v23    # "sel":Landroid/view/View;
    :pswitch_6
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->reconcileSelectedPosition()I

    move-result v2

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mSpecificLeft:I

    move/from16 v24, v0

    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-direct {v0, v2, v1}, Lit/sephiroth/android/library/widget/HListView;->fillSpecific(II)Landroid/view/View;

    move-result-object v23

    .line 1697
    .restart local v23    # "sel":Landroid/view/View;
    goto/16 :goto_3

    .end local v23    # "sel":Landroid/view/View;
    :pswitch_7
    move-object/from16 v2, p0

    .line 1699
    invoke-direct/range {v2 .. v7}, Lit/sephiroth/android/library/widget/HListView;->moveSelection(Landroid/view/View;Landroid/view/View;III)Landroid/view/View;

    move-result-object v23

    .line 1700
    .restart local v23    # "sel":Landroid/view/View;
    goto/16 :goto_3

    .line 1708
    .end local v23    # "sel":Landroid/view/View;
    :cond_16
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v2, v2, -0x1

    const/16 v24, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-virtual {v0, v2, v1}, Lit/sephiroth/android/library/widget/HListView;->lookForSelectablePosition(IZ)I

    move-result v21

    .line 1709
    .restart local v21    # "position":I
    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/HListView;->setSelectedPositionInt(I)V

    .line 1710
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v2, v2, -0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v7}, Lit/sephiroth/android/library/widget/HListView;->fillLeft(II)Landroid/view/View;

    move-result-object v23

    .line 1711
    .restart local v23    # "sel":Landroid/view/View;
    goto/16 :goto_3

    .line 1713
    .end local v21    # "position":I
    .end local v23    # "sel":Landroid/view/View;
    :cond_17
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    if-ltz v2, :cond_19

    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    move/from16 v24, v0

    move/from16 v0, v24

    if-ge v2, v0, :cond_19

    .line 1714
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    if-nez v3, :cond_18

    .end local v6    # "childrenLeft":I
    :goto_7
    move-object/from16 v0, p0

    invoke-direct {v0, v2, v6}, Lit/sephiroth/android/library/widget/HListView;->fillSpecific(II)Landroid/view/View;

    move-result-object v23

    .restart local v23    # "sel":Landroid/view/View;
    goto/16 :goto_3

    .end local v23    # "sel":Landroid/view/View;
    .restart local v6    # "childrenLeft":I
    :cond_18
    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v6

    goto :goto_7

    .line 1715
    :cond_19
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    move/from16 v24, v0

    move/from16 v0, v24

    if-ge v2, v0, :cond_1b

    .line 1716
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    if-nez v20, :cond_1a

    .end local v6    # "childrenLeft":I
    :goto_8
    move-object/from16 v0, p0

    invoke-direct {v0, v2, v6}, Lit/sephiroth/android/library/widget/HListView;->fillSpecific(II)Landroid/view/View;

    move-result-object v23

    .restart local v23    # "sel":Landroid/view/View;
    goto/16 :goto_3

    .end local v23    # "sel":Landroid/view/View;
    .restart local v6    # "childrenLeft":I
    :cond_1a
    invoke-virtual/range {v20 .. v20}, Landroid/view/View;->getLeft()I

    move-result v6

    goto :goto_8

    .line 1718
    :cond_1b
    const/4 v2, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v6}, Lit/sephiroth/android/library/widget/HListView;->fillSpecific(II)Landroid/view/View;

    move-result-object v23

    .restart local v23    # "sel":Landroid/view/View;
    goto/16 :goto_3

    .line 1731
    .end local v6    # "childrenLeft":I
    :cond_1c
    const/4 v15, 0x0

    goto/16 :goto_4

    .line 1744
    .restart local v15    # "focusWasTaken":Z
    :cond_1d
    const/4 v2, 0x0

    move-object/from16 v0, v23

    invoke-virtual {v0, v2}, Landroid/view/View;->setSelected(Z)V

    .line 1745
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectorRect:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->setEmpty()V

    goto/16 :goto_5

    .line 1748
    .end local v15    # "focusWasTaken":Z
    :cond_1e
    const/4 v2, -0x1

    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-virtual {v0, v2, v1}, Lit/sephiroth/android/library/widget/HListView;->positionSelector(ILandroid/view/View;)V

    goto/16 :goto_5

    .line 1752
    :cond_1f
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mTouchMode:I

    if-lez v2, :cond_21

    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mTouchMode:I

    const/16 v24, 0x3

    move/from16 v0, v24

    if-ge v2, v0, :cond_21

    .line 1753
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mMotionPosition:I

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    move/from16 v24, v0

    sub-int v2, v2, v24

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    .line 1754
    .local v9, "child":Landroid/view/View;
    if-eqz v9, :cond_20

    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mMotionPosition:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v9}, Lit/sephiroth/android/library/widget/HListView;->positionSelector(ILandroid/view/View;)V

    .line 1762
    .end local v9    # "child":Landroid/view/View;
    :cond_20
    :goto_9
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->hasFocus()Z

    move-result v2

    if-eqz v2, :cond_11

    if-eqz v14, :cond_11

    .line 1763
    invoke-virtual {v14}, Landroid/view/View;->requestFocus()Z

    goto/16 :goto_6

    .line 1756
    :cond_21
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput v2, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectedLeft:I

    .line 1757
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mSelectorRect:Landroid/graphics/Rect;

    invoke-virtual {v2}, Landroid/graphics/Rect;->setEmpty()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_9

    .line 1568
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch

    .line 1675
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_5
        :pswitch_2
        :pswitch_4
        :pswitch_6
        :pswitch_3
        :pswitch_7
    .end packed-switch
.end method

.method protected lookForSelectablePosition(IZ)I
    .locals 4
    .param p1, "position"    # I
    .param p2, "lookDown"    # Z

    .prologue
    const/4 v2, -0x1

    .line 2094
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 2095
    .local v0, "adapter":Landroid/widget/ListAdapter;
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->isInTouchMode()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 2121
    :cond_0
    :goto_0
    return v2

    .line 2099
    :cond_1
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    .line 2100
    .local v1, "count":I
    iget-boolean v3, p0, Lit/sephiroth/android/library/widget/HListView;->mAreAllItemsSelectable:Z

    if-nez v3, :cond_4

    .line 2101
    if-eqz p2, :cond_2

    .line 2102
    const/4 v3, 0x0

    invoke-static {v3, p1}, Ljava/lang/Math;->max(II)I

    move-result p1

    .line 2103
    :goto_1
    if-ge p1, v1, :cond_3

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v3

    if-nez v3, :cond_3

    .line 2104
    add-int/lit8 p1, p1, 0x1

    goto :goto_1

    .line 2107
    :cond_2
    add-int/lit8 v3, v1, -0x1

    invoke-static {p1, v3}, Ljava/lang/Math;->min(II)I

    move-result p1

    .line 2108
    :goto_2
    if-ltz p1, :cond_3

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v3

    if-nez v3, :cond_3

    .line 2109
    add-int/lit8 p1, p1, -0x1

    goto :goto_2

    .line 2113
    :cond_3
    if-ltz p1, :cond_0

    if-ge p1, v1, :cond_0

    move v2, p1

    .line 2116
    goto :goto_0

    .line 2118
    :cond_4
    if-ltz p1, :cond_0

    if-ge p1, v1, :cond_0

    move v2, p1

    .line 2121
    goto :goto_0
.end method

.method final measureWidthOfChildren(IIIII)I
    .locals 12
    .param p1, "heightMeasureSpec"    # I
    .param p2, "startPosition"    # I
    .param p3, "endPosition"    # I
    .param p4, "maxWidth"    # I
    .param p5, "disallowPartialChildPosition"    # I

    .prologue
    .line 1247
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 1248
    .local v1, "adapter":Landroid/widget/ListAdapter;
    if-nez v1, :cond_1

    .line 1249
    iget-object v10, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->left:I

    iget-object v11, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v11, v11, Landroid/graphics/Rect;->right:I

    add-int v6, v10, v11

    .line 1301
    :cond_0
    :goto_0
    return v6

    .line 1253
    :cond_1
    iget-object v10, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->left:I

    iget-object v11, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v11, v11, Landroid/graphics/Rect;->right:I

    add-int v9, v10, v11

    .line 1254
    .local v9, "returnedWidth":I
    iget v10, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    if-lez v10, :cond_6

    iget-object v10, p0, Lit/sephiroth/android/library/widget/HListView;->mDivider:Landroid/graphics/drawable/Drawable;

    if-eqz v10, :cond_6

    iget v3, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    .line 1257
    .local v3, "dividerWidth":I
    :goto_1
    const/4 v6, 0x0

    .line 1262
    .local v6, "prevWidthWithoutPartialChild":I
    const/4 v10, -0x1

    if-ne p3, v10, :cond_2

    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v10

    add-int/lit8 p3, v10, -0x1

    .line 1263
    :cond_2
    iget-object v7, p0, Lit/sephiroth/android/library/widget/HListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    .line 1264
    .local v7, "recycleBin":Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->recycleOnMeasure()Z

    move-result v8

    .line 1265
    .local v8, "recyle":Z
    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mIsScrap:[Z

    .line 1267
    .local v5, "isScrap":[Z
    move v4, p2

    .local v4, "i":I
    :goto_2
    if-gt v4, p3, :cond_9

    .line 1268
    invoke-virtual {p0, v4, v5}, Lit/sephiroth/android/library/widget/HListView;->obtainView(I[Z)Landroid/view/View;

    move-result-object v2

    .line 1270
    .local v2, "child":Landroid/view/View;
    invoke-direct {p0, v2, v4, p1}, Lit/sephiroth/android/library/widget/HListView;->measureScrapChildWidth(Landroid/view/View;II)V

    .line 1272
    if-lez v4, :cond_3

    .line 1274
    add-int/2addr v9, v3

    .line 1278
    :cond_3
    if-eqz v8, :cond_4

    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    check-cast v10, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    iget v10, v10, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    invoke-virtual {v7, v10}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->shouldRecycleViewType(I)Z

    move-result v10

    if-eqz v10, :cond_4

    .line 1279
    const/4 v10, -0x1

    invoke-virtual {v7, v2, v10}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->addScrapView(Landroid/view/View;I)V

    .line 1282
    :cond_4
    invoke-virtual {v2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v10

    add-int/2addr v9, v10

    .line 1284
    move/from16 v0, p4

    if-lt v9, v0, :cond_7

    .line 1287
    if-ltz p5, :cond_5

    move/from16 v0, p5

    if-le v4, v0, :cond_5

    if-lez v6, :cond_5

    move/from16 v0, p4

    if-ne v9, v0, :cond_0

    :cond_5
    move/from16 v6, p4

    goto :goto_0

    .line 1254
    .end local v2    # "child":Landroid/view/View;
    .end local v3    # "dividerWidth":I
    .end local v4    # "i":I
    .end local v5    # "isScrap":[Z
    .end local v6    # "prevWidthWithoutPartialChild":I
    .end local v7    # "recycleBin":Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;
    .end local v8    # "recyle":Z
    :cond_6
    const/4 v3, 0x0

    goto :goto_1

    .line 1294
    .restart local v2    # "child":Landroid/view/View;
    .restart local v3    # "dividerWidth":I
    .restart local v4    # "i":I
    .restart local v5    # "isScrap":[Z
    .restart local v6    # "prevWidthWithoutPartialChild":I
    .restart local v7    # "recycleBin":Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;
    .restart local v8    # "recyle":Z
    :cond_7
    if-ltz p5, :cond_8

    move/from16 v0, p5

    if-lt v4, v0, :cond_8

    .line 1295
    move v6, v9

    .line 1267
    :cond_8
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .end local v2    # "child":Landroid/view/View;
    :cond_9
    move v6, v9

    .line 1301
    goto :goto_0
.end method

.method final measureWithLargeChildren(IIIIII)[I
    .locals 17
    .param p1, "heightMeasureSpec"    # I
    .param p2, "startPosition"    # I
    .param p3, "endPosition"    # I
    .param p4, "maxWidth"    # I
    .param p5, "maxHeight"    # I
    .param p6, "disallowPartialChildPosition"    # I

    .prologue
    .line 1309
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 1310
    .local v2, "adapter":Landroid/widget/ListAdapter;
    if-nez v2, :cond_0

    .line 1311
    const/4 v13, 0x2

    new-array v13, v13, [I

    const/4 v14, 0x0

    move-object/from16 v0, p0

    iget-object v15, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v15, v15, Landroid/graphics/Rect;->left:I

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v16, v0

    add-int v15, v15, v16

    aput v15, v13, v14

    const/4 v14, 0x1

    move-object/from16 v0, p0

    iget-object v15, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v15, v15, Landroid/graphics/Rect;->top:I

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v16, v0

    add-int v15, v15, v16

    aput v15, v13, v14

    .line 1349
    :goto_0
    return-object v13

    .line 1315
    :cond_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v13, v13, Landroid/graphics/Rect;->left:I

    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v14, v14, Landroid/graphics/Rect;->right:I

    add-int v12, v13, v14

    .line 1316
    .local v12, "returnedWidth":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v13, v13, Landroid/graphics/Rect;->top:I

    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v14, v14, Landroid/graphics/Rect;->bottom:I

    add-int v11, v13, v14

    .line 1318
    .local v11, "returnedHeight":I
    move-object/from16 v0, p0

    iget v13, v0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    if-lez v13, :cond_3

    move-object/from16 v0, p0

    iget-object v13, v0, Lit/sephiroth/android/library/widget/HListView;->mDivider:Landroid/graphics/drawable/Drawable;

    if-eqz v13, :cond_3

    move-object/from16 v0, p0

    iget v6, v0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    .line 1320
    .local v6, "dividerWidth":I
    :goto_1
    const/4 v5, 0x0

    .line 1321
    .local v5, "childWidth":I
    const/4 v4, 0x0

    .line 1327
    .local v4, "childHeight":I
    const/4 v13, -0x1

    move/from16 v0, p3

    if-ne v0, v13, :cond_1

    invoke-interface {v2}, Landroid/widget/ListAdapter;->getCount()I

    move-result v13

    add-int/lit8 p3, v13, -0x1

    .line 1328
    :cond_1
    move-object/from16 v0, p0

    iget-object v9, v0, Lit/sephiroth/android/library/widget/HListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    .line 1329
    .local v9, "recycleBin":Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->recycleOnMeasure()Z

    move-result v10

    .line 1330
    .local v10, "recyle":Z
    move-object/from16 v0, p0

    iget-object v8, v0, Lit/sephiroth/android/library/widget/HListView;->mIsScrap:[Z

    .line 1332
    .local v8, "isScrap":[Z
    move/from16 v7, p2

    .local v7, "i":I
    :goto_2
    move/from16 v0, p3

    if-gt v7, v0, :cond_4

    .line 1333
    move-object/from16 v0, p0

    invoke-virtual {v0, v7, v8}, Lit/sephiroth/android/library/widget/HListView;->obtainView(I[Z)Landroid/view/View;

    move-result-object v3

    .line 1335
    .local v3, "child":Landroid/view/View;
    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v0, v3, v7, v1}, Lit/sephiroth/android/library/widget/HListView;->measureScrapChildWidth(Landroid/view/View;II)V

    .line 1338
    if-eqz v10, :cond_2

    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v13

    check-cast v13, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    iget v13, v13, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    invoke-virtual {v9, v13}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->shouldRecycleViewType(I)Z

    move-result v13

    if-eqz v13, :cond_2

    .line 1339
    const/4 v13, -0x1

    invoke-virtual {v9, v3, v13}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->addScrapView(Landroid/view/View;I)V

    .line 1342
    :cond_2
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v13

    add-int/2addr v13, v6

    invoke-static {v5, v13}, Ljava/lang/Math;->max(II)I

    move-result v5

    .line 1343
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v13

    invoke-static {v4, v13}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 1332
    add-int/lit8 v7, v7, 0x1

    goto :goto_2

    .line 1318
    .end local v3    # "child":Landroid/view/View;
    .end local v4    # "childHeight":I
    .end local v5    # "childWidth":I
    .end local v6    # "dividerWidth":I
    .end local v7    # "i":I
    .end local v8    # "isScrap":[Z
    .end local v9    # "recycleBin":Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;
    .end local v10    # "recyle":Z
    :cond_3
    const/4 v6, 0x0

    goto :goto_1

    .line 1346
    .restart local v4    # "childHeight":I
    .restart local v5    # "childWidth":I
    .restart local v6    # "dividerWidth":I
    .restart local v7    # "i":I
    .restart local v8    # "isScrap":[Z
    .restart local v9    # "recycleBin":Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;
    .restart local v10    # "recyle":Z
    :cond_4
    add-int/2addr v12, v5

    .line 1347
    add-int/2addr v11, v4

    .line 1349
    const/4 v13, 0x2

    new-array v13, v13, [I

    const/4 v14, 0x0

    move/from16 v0, p4

    invoke-static {v12, v0}, Ljava/lang/Math;->min(II)I

    move-result v15

    aput v15, v13, v14

    const/4 v14, 0x1

    move/from16 v0, p5

    invoke-static {v11, v0}, Ljava/lang/Math;->min(II)I

    move-result v15

    aput v15, v13, v14

    goto/16 :goto_0
.end method

.method protected onFinishInflate()V
    .locals 3

    .prologue
    .line 3546
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->onFinishInflate()V

    .line 3548
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v0

    .line 3549
    .local v0, "count":I
    if-lez v0, :cond_1

    .line 3550
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 3551
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/HListView;->addHeaderView(Landroid/view/View;)V

    .line 3550
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 3553
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->removeAllViews()V

    .line 3555
    .end local v1    # "i":I
    :cond_1
    return-void
.end method

.method protected onFocusChanged(ZILandroid/graphics/Rect;)V
    .locals 15
    .param p1, "gainFocus"    # Z
    .param p2, "direction"    # I
    .param p3, "previouslyFocusedRect"    # Landroid/graphics/Rect;

    .prologue
    .line 3490
    invoke-super/range {p0 .. p3}, Lit/sephiroth/android/library/widget/AbsHListView;->onFocusChanged(ZILandroid/graphics/Rect;)V

    .line 3492
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 3493
    .local v2, "adapter":Landroid/widget/ListAdapter;
    const/4 v5, -0x1

    .line 3494
    .local v5, "closetChildIndex":I
    const/4 v4, 0x0

    .line 3495
    .local v4, "closestChildLeft":I
    if-eqz v2, :cond_3

    if-eqz p1, :cond_3

    if-eqz p3, :cond_3

    .line 3496
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getScrollX()I

    move-result v12

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getScrollY()I

    move-result v13

    move-object/from16 v0, p3

    invoke-virtual {v0, v12, v13}, Landroid/graphics/Rect;->offset(II)V

    .line 3500
    invoke-interface {v2}, Landroid/widget/ListAdapter;->getCount()I

    move-result v12

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v13

    iget v14, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v13, v14

    if-ge v12, v13, :cond_0

    .line 3501
    const/4 v12, 0x0

    iput v12, p0, Lit/sephiroth/android/library/widget/HListView;->mLayoutMode:I

    .line 3502
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->layoutChildren()V

    .line 3507
    :cond_0
    iget-object v11, p0, Lit/sephiroth/android/library/widget/HListView;->mTempRect:Landroid/graphics/Rect;

    .line 3508
    .local v11, "otherRect":Landroid/graphics/Rect;
    const v9, 0x7fffffff

    .line 3509
    .local v9, "minDistance":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v3

    .line 3510
    .local v3, "childCount":I
    iget v7, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    .line 3512
    .local v7, "firstPosition":I
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    if-ge v8, v3, :cond_3

    .line 3514
    add-int v12, v7, v8

    invoke-interface {v2, v12}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v12

    if-nez v12, :cond_2

    .line 3512
    :cond_1
    :goto_1
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 3518
    :cond_2
    invoke-virtual {p0, v8}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v10

    .line 3519
    .local v10, "other":Landroid/view/View;
    invoke-virtual {v10, v11}, Landroid/view/View;->getDrawingRect(Landroid/graphics/Rect;)V

    .line 3520
    invoke-virtual {p0, v10, v11}, Lit/sephiroth/android/library/widget/HListView;->offsetDescendantRectToMyCoords(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 3521
    move-object/from16 v0, p3

    move/from16 v1, p2

    invoke-static {v0, v11, v1}, Lit/sephiroth/android/library/widget/HListView;->getDistance(Landroid/graphics/Rect;Landroid/graphics/Rect;I)I

    move-result v6

    .line 3523
    .local v6, "distance":I
    if-ge v6, v9, :cond_1

    .line 3524
    move v9, v6

    .line 3525
    move v5, v8

    .line 3526
    invoke-virtual {v10}, Landroid/view/View;->getLeft()I

    move-result v4

    goto :goto_1

    .line 3531
    .end local v3    # "childCount":I
    .end local v6    # "distance":I
    .end local v7    # "firstPosition":I
    .end local v8    # "i":I
    .end local v9    # "minDistance":I
    .end local v10    # "other":Landroid/view/View;
    .end local v11    # "otherRect":Landroid/graphics/Rect;
    :cond_3
    if-ltz v5, :cond_4

    .line 3532
    iget v12, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    add-int/2addr v12, v5

    invoke-virtual {p0, v12, v4}, Lit/sephiroth/android/library/widget/HListView;->setSelectionFromLeft(II)V

    .line 3536
    :goto_2
    return-void

    .line 3534
    :cond_4
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->requestLayout()V

    goto :goto_2
.end method

.method public onGlobalLayout()V
    .locals 0

    .prologue
    .line 3635
    return-void
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .prologue
    .line 3623
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 3624
    const-class v0, Lit/sephiroth/android/library/widget/HListView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 3625
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 1
    .param p1, "info"    # Landroid/view/accessibility/AccessibilityNodeInfo;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 3630
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 3631
    const-class v0, Lit/sephiroth/android/library/widget/HListView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    .line 3632
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 2162
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0, p2}, Lit/sephiroth/android/library/widget/HListView;->commonKey(IILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public onKeyMultiple(IILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "repeatCount"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 2167
    invoke-direct {p0, p1, p2, p3}, Lit/sephiroth/android/library/widget/HListView;->commonKey(IILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 2172
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0, p2}, Lit/sephiroth/android/library/widget/HListView;->commonKey(IILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method protected onMeasure(II)V
    .locals 21
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 1118
    invoke-super/range {p0 .. p2}, Lit/sephiroth/android/library/widget/AbsHListView;->onMeasure(II)V

    .line 1120
    invoke-static/range {p1 .. p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v20

    .line 1121
    .local v20, "widthMode":I
    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v18

    .line 1122
    .local v18, "heightMode":I
    invoke-static/range {p1 .. p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v6

    .line 1123
    .local v6, "widthSize":I
    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v7

    .line 1125
    .local v7, "heightSize":I
    const/16 v17, 0x0

    .line 1126
    .local v17, "childWidth":I
    const/4 v15, 0x0

    .line 1127
    .local v15, "childHeight":I
    const/16 v16, 0x0

    .line 1129
    .local v16, "childState":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    if-nez v2, :cond_6

    const/4 v2, 0x0

    :goto_0
    move-object/from16 v0, p0

    iput v2, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    .line 1131
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    if-lez v2, :cond_2

    if-eqz v20, :cond_0

    if-nez v18, :cond_2

    .line 1136
    :cond_0
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/HListView;->mIsScrap:[Z

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v3}, Lit/sephiroth/android/library/widget/HListView;->obtainView(I[Z)Landroid/view/View;

    move-result-object v14

    .line 1138
    .local v14, "child":Landroid/view/View;
    const/4 v2, 0x0

    move-object/from16 v0, p0

    move/from16 v1, p2

    invoke-direct {v0, v14, v2, v1}, Lit/sephiroth/android/library/widget/HListView;->measureScrapChildWidth(Landroid/view/View;II)V

    .line 1140
    invoke-virtual {v14}, Landroid/view/View;->getMeasuredWidth()I

    move-result v17

    .line 1141
    invoke-virtual {v14}, Landroid/view/View;->getMeasuredHeight()I

    move-result v15

    .line 1143
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xb

    if-lt v2, v3, :cond_1

    .line 1144
    invoke-virtual {v14}, Landroid/view/View;->getMeasuredState()I

    move-result v2

    move/from16 v0, v16

    invoke-static {v0, v2}, Lit/sephiroth/android/library/widget/HListView;->combineMeasuredStates(II)I

    move-result v16

    .line 1147
    :cond_1
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->recycleOnMeasure()Z

    move-result v2

    if-eqz v2, :cond_2

    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/HListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-virtual {v14}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    iget v2, v2, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    invoke-virtual {v3, v2}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->shouldRecycleViewType(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1148
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    const/4 v3, -0x1

    invoke-virtual {v2, v14, v3}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->addScrapView(Landroid/view/View;I)V

    .line 1152
    .end local v14    # "child":Landroid/view/View;
    :cond_2
    if-nez v18, :cond_7

    .line 1153
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->top:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->bottom:I

    add-int/2addr v2, v3

    add-int/2addr v2, v15

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getHorizontalScrollbarHeight()I

    move-result v3

    add-int v7, v2, v3

    .line 1166
    :cond_3
    :goto_1
    if-nez v20, :cond_4

    .line 1167
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->left:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->right:I

    add-int/2addr v2, v3

    add-int v2, v2, v17

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/HListView;->getHorizontalFadingEdgeLength()I

    move-result v3

    mul-int/lit8 v3, v3, 0x2

    add-int v6, v2, v3

    .line 1170
    :cond_4
    const/high16 v2, -0x80000000

    move/from16 v0, v20

    if-ne v0, v2, :cond_5

    .line 1171
    const/4 v10, 0x0

    const/4 v11, -0x1

    const/4 v13, -0x1

    move-object/from16 v8, p0

    move/from16 v9, p2

    move v12, v6

    invoke-virtual/range {v8 .. v13}, Lit/sephiroth/android/library/widget/HListView;->measureWidthOfChildren(IIIII)I

    move-result v6

    .line 1178
    :cond_5
    move-object/from16 v0, p0

    invoke-virtual {v0, v6, v7}, Lit/sephiroth/android/library/widget/HListView;->setMeasuredDimension(II)V

    .line 1179
    move/from16 v0, p2

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/HListView;->mHeightMeasureSpec:I

    .line 1180
    return-void

    .line 1129
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2}, Landroid/widget/ListAdapter;->getCount()I

    move-result v2

    goto/16 :goto_0

    .line 1154
    :cond_7
    const/high16 v2, -0x80000000

    move/from16 v0, v18

    if-ne v0, v2, :cond_8

    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    if-lez v2, :cond_8

    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/HListView;->mMeasureWithChild:I

    const/4 v3, -0x1

    if-le v2, v3, :cond_8

    .line 1157
    move-object/from16 v0, p0

    iget v4, v0, Lit/sephiroth/android/library/widget/HListView;->mMeasureWithChild:I

    move-object/from16 v0, p0

    iget v5, v0, Lit/sephiroth/android/library/widget/HListView;->mMeasureWithChild:I

    const/4 v8, -0x1

    move-object/from16 v2, p0

    move/from16 v3, p2

    invoke-virtual/range {v2 .. v8}, Lit/sephiroth/android/library/widget/HListView;->measureWithLargeChildren(IIIIII)[I

    move-result-object v19

    .line 1158
    .local v19, "result":[I
    const/4 v2, 0x1

    aget v7, v19, v2

    .line 1160
    goto :goto_1

    .line 1161
    .end local v19    # "result":[I
    :cond_8
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xb

    if-lt v2, v3, :cond_3

    .line 1162
    const/high16 v2, -0x1000000

    and-int v2, v2, v16

    or-int/2addr v7, v2

    goto :goto_1
.end method

.method protected onSizeChanged(IIII)V
    .locals 7
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 1098
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v5

    if-lez v5, :cond_1

    .line 1099
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getFocusedChild()Landroid/view/View;

    move-result-object v2

    .line 1100
    .local v2, "focusedChild":Landroid/view/View;
    if-eqz v2, :cond_1

    .line 1101
    iget v5, p0, Lit/sephiroth/android/library/widget/HListView;->mFirstPosition:I

    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/HListView;->indexOfChild(Landroid/view/View;)I

    move-result v6

    add-int v0, v5, v6

    .line 1102
    .local v0, "childPosition":I
    invoke-virtual {v2}, Landroid/view/View;->getRight()I

    move-result v1

    .line 1103
    .local v1, "childRight":I
    const/4 v5, 0x0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getPaddingLeft()I

    move-result v6

    sub-int v6, p1, v6

    sub-int v6, v1, v6

    invoke-static {v5, v6}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 1104
    .local v4, "offset":I
    invoke-virtual {v2}, Landroid/view/View;->getLeft()I

    move-result v5

    sub-int v3, v5, v4

    .line 1105
    .local v3, "left":I
    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mFocusSelector:Lit/sephiroth/android/library/widget/HListView$FocusSelector;

    if-nez v5, :cond_0

    .line 1106
    new-instance v5, Lit/sephiroth/android/library/widget/HListView$FocusSelector;

    const/4 v6, 0x0

    invoke-direct {v5, p0, v6}, Lit/sephiroth/android/library/widget/HListView$FocusSelector;-><init>(Lit/sephiroth/android/library/widget/HListView;Lit/sephiroth/android/library/widget/HListView$1;)V

    iput-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mFocusSelector:Lit/sephiroth/android/library/widget/HListView$FocusSelector;

    .line 1108
    :cond_0
    iget-object v5, p0, Lit/sephiroth/android/library/widget/HListView;->mFocusSelector:Lit/sephiroth/android/library/widget/HListView$FocusSelector;

    invoke-virtual {v5, v0, v3}, Lit/sephiroth/android/library/widget/HListView$FocusSelector;->setup(II)Lit/sephiroth/android/library/widget/HListView$FocusSelector;

    move-result-object v5

    invoke-virtual {p0, v5}, Lit/sephiroth/android/library/widget/HListView;->post(Ljava/lang/Runnable;)Z

    .line 1111
    .end local v0    # "childPosition":I
    .end local v1    # "childRight":I
    .end local v2    # "focusedChild":Landroid/view/View;
    .end local v3    # "left":I
    .end local v4    # "offset":I
    :cond_1
    invoke-super {p0, p1, p2, p3, p4}, Lit/sephiroth/android/library/widget/AbsHListView;->onSizeChanged(IIII)V

    .line 1112
    return-void
.end method

.method pageScroll(I)Z
    .locals 8
    .param p1, "direction"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 2322
    const/4 v1, -0x1

    .line 2323
    .local v1, "nextPage":I
    const/4 v0, 0x0

    .line 2325
    .local v0, "down":Z
    const/16 v5, 0x21

    if-ne p1, v5, :cond_4

    iget v5, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v6

    sub-int/2addr v5, v6

    add-int/lit8 v5, v5, -0x1

    invoke-static {v4, v5}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 2331
    :cond_0
    :goto_0
    if-ltz v1, :cond_5

    .line 2332
    invoke-virtual {p0, v1, v0}, Lit/sephiroth/android/library/widget/HListView;->lookForSelectablePosition(IZ)I

    move-result v2

    .line 2333
    .local v2, "position":I
    if-ltz v2, :cond_5

    .line 2334
    const/4 v4, 0x4

    iput v4, p0, Lit/sephiroth/android/library/widget/HListView;->mLayoutMode:I

    .line 2335
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getPaddingLeft()I

    move-result v4

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getHorizontalFadingEdgeLength()I

    move-result v5

    add-int/2addr v4, v5

    iput v4, p0, Lit/sephiroth/android/library/widget/HListView;->mSpecificLeft:I

    .line 2337
    if-eqz v0, :cond_1

    iget v4, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v5

    sub-int/2addr v4, v5

    if-le v2, v4, :cond_1

    .line 2338
    const/4 v4, 0x3

    iput v4, p0, Lit/sephiroth/android/library/widget/HListView;->mLayoutMode:I

    .line 2341
    :cond_1
    if-nez v0, :cond_2

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v4

    if-ge v2, v4, :cond_2

    .line 2342
    iput v3, p0, Lit/sephiroth/android/library/widget/HListView;->mLayoutMode:I

    .line 2345
    :cond_2
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/HListView;->setSelectionInt(I)V

    .line 2346
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invokeOnItemScrollListener()V

    .line 2347
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->awakenScrollBars()Z

    move-result v4

    if-nez v4, :cond_3

    .line 2348
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invalidate()V

    .line 2355
    .end local v2    # "position":I
    :cond_3
    :goto_1
    return v3

    .line 2326
    :cond_4
    const/16 v5, 0x82

    if-ne p1, v5, :cond_0

    .line 2327
    iget v5, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v5, v5, -0x1

    iget v6, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v7

    add-int/2addr v6, v7

    add-int/lit8 v6, v6, -0x1

    invoke-static {v5, v6}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 2328
    const/4 v0, 0x1

    goto :goto_0

    :cond_5
    move v3, v4

    .line 2355
    goto :goto_1
.end method

.method protected recycleOnMeasure()Z
    .locals 1
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "list"
    .end annotation

    .prologue
    .line 1217
    const/4 v0, 0x1

    return v0
.end method

.method public requestChildRectangleOnScreen(Landroid/view/View;Landroid/graphics/Rect;Z)Z
    .locals 15
    .param p1, "child"    # Landroid/view/View;
    .param p2, "rect"    # Landroid/graphics/Rect;
    .param p3, "immediate"    # Z

    .prologue
    .line 569
    move-object/from16 v0, p2

    iget v8, v0, Landroid/graphics/Rect;->left:I

    .line 572
    .local v8, "rectLeftWithinChild":I
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLeft()I

    move-result v13

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTop()I

    move-result v14

    move-object/from16 v0, p2

    invoke-virtual {v0, v13, v14}, Landroid/graphics/Rect;->offset(II)V

    .line 573
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getScrollX()I

    move-result v13

    neg-int v13, v13

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getScrollY()I

    move-result v14

    neg-int v14, v14

    move-object/from16 v0, p2

    invoke-virtual {v0, v13, v14}, Landroid/graphics/Rect;->offset(II)V

    .line 575
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getWidth()I

    move-result v12

    .line 576
    .local v12, "width":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getScrollX()I

    move-result v6

    .line 577
    .local v6, "listUnfadedLeft":I
    add-int v7, v6, v12

    .line 578
    .local v7, "listUnfadedRight":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getHorizontalFadingEdgeLength()I

    move-result v4

    .line 580
    .local v4, "fadingEdge":I
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->showingLeftFadingEdge()Z

    move-result v13

    if-eqz v13, :cond_1

    .line 582
    iget v13, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    if-gtz v13, :cond_0

    if-le v8, v4, :cond_1

    .line 583
    :cond_0
    add-int/2addr v6, v4

    .line 587
    :cond_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getChildCount()I

    move-result v1

    .line 588
    .local v1, "childCount":I
    add-int/lit8 v13, v1, -0x1

    invoke-virtual {p0, v13}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v13

    invoke-virtual {v13}, Landroid/view/View;->getRight()I

    move-result v9

    .line 590
    .local v9, "rightOfRightChild":I
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/HListView;->showingRightFadingEdge()Z

    move-result v13

    if-eqz v13, :cond_3

    .line 592
    iget v13, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    iget v14, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v14, v14, -0x1

    if-lt v13, v14, :cond_2

    move-object/from16 v0, p2

    iget v13, v0, Landroid/graphics/Rect;->right:I

    sub-int v14, v9, v4

    if-ge v13, v14, :cond_3

    .line 594
    :cond_2
    sub-int/2addr v7, v4

    .line 598
    :cond_3
    const/4 v11, 0x0

    .line 600
    .local v11, "scrollXDelta":I
    move-object/from16 v0, p2

    iget v13, v0, Landroid/graphics/Rect;->right:I

    if-le v13, v7, :cond_7

    move-object/from16 v0, p2

    iget v13, v0, Landroid/graphics/Rect;->left:I

    if-le v13, v6, :cond_7

    .line 605
    invoke-virtual/range {p2 .. p2}, Landroid/graphics/Rect;->width()I

    move-result v13

    if-le v13, v12, :cond_6

    .line 607
    move-object/from16 v0, p2

    iget v13, v0, Landroid/graphics/Rect;->left:I

    sub-int/2addr v13, v6

    add-int/2addr v11, v13

    .line 614
    :goto_0
    sub-int v3, v9, v7

    .line 615
    .local v3, "distanceToRight":I
    invoke-static {v11, v3}, Ljava/lang/Math;->min(II)I

    move-result v11

    .line 635
    .end local v3    # "distanceToRight":I
    :cond_4
    :goto_1
    if-eqz v11, :cond_9

    const/4 v10, 0x1

    .line 636
    .local v10, "scroll":Z
    :goto_2
    if-eqz v10, :cond_5

    .line 637
    neg-int v13, v11

    invoke-direct {p0, v13}, Lit/sephiroth/android/library/widget/HListView;->scrollListItemsBy(I)V

    .line 638
    const/4 v13, -0x1

    move-object/from16 v0, p1

    invoke-virtual {p0, v13, v0}, Lit/sephiroth/android/library/widget/HListView;->positionSelector(ILandroid/view/View;)V

    .line 639
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTop()I

    move-result v13

    iput v13, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedLeft:I

    .line 640
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invalidate()V

    .line 642
    :cond_5
    return v10

    .line 610
    .end local v10    # "scroll":Z
    :cond_6
    move-object/from16 v0, p2

    iget v13, v0, Landroid/graphics/Rect;->right:I

    sub-int/2addr v13, v7

    add-int/2addr v11, v13

    goto :goto_0

    .line 616
    :cond_7
    move-object/from16 v0, p2

    iget v13, v0, Landroid/graphics/Rect;->left:I

    if-ge v13, v6, :cond_4

    move-object/from16 v0, p2

    iget v13, v0, Landroid/graphics/Rect;->right:I

    if-ge v13, v7, :cond_4

    .line 621
    invoke-virtual/range {p2 .. p2}, Landroid/graphics/Rect;->width()I

    move-result v13

    if-le v13, v12, :cond_8

    .line 623
    move-object/from16 v0, p2

    iget v13, v0, Landroid/graphics/Rect;->right:I

    sub-int v13, v7, v13

    sub-int/2addr v11, v13

    .line 630
    :goto_3
    const/4 v13, 0x0

    invoke-virtual {p0, v13}, Lit/sephiroth/android/library/widget/HListView;->getChildAt(I)Landroid/view/View;

    move-result-object v13

    invoke-virtual {v13}, Landroid/view/View;->getLeft()I

    move-result v5

    .line 631
    .local v5, "left":I
    sub-int v2, v5, v6

    .line 632
    .local v2, "deltaToLeft":I
    invoke-static {v11, v2}, Ljava/lang/Math;->max(II)I

    move-result v11

    goto :goto_1

    .line 626
    .end local v2    # "deltaToLeft":I
    .end local v5    # "left":I
    :cond_8
    move-object/from16 v0, p2

    iget v13, v0, Landroid/graphics/Rect;->left:I

    sub-int v13, v6, v13

    sub-int/2addr v11, v13

    goto :goto_3

    .line 635
    :cond_9
    const/4 v10, 0x0

    goto :goto_2
.end method

.method protected resetList()V
    .locals 1

    .prologue
    .line 522
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->clearRecycledState(Ljava/util/ArrayList;)V

    .line 523
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->clearRecycledState(Ljava/util/ArrayList;)V

    .line 525
    invoke-super {p0}, Lit/sephiroth/android/library/widget/AbsHListView;->resetList()V

    .line 527
    const/4 v0, 0x0

    iput v0, p0, Lit/sephiroth/android/library/widget/HListView;->mLayoutMode:I

    .line 528
    return-void
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0
    .param p1, "x0"    # Landroid/widget/Adapter;

    .prologue
    .line 77
    check-cast p1, Landroid/widget/ListAdapter;

    .end local p1    # "x0":Landroid/widget/Adapter;
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 6
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 462
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    if-eqz v1, :cond_0

    .line 463
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    invoke-interface {v1, v2}, Landroid/widget/ListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 466
    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->resetList()V

    .line 467
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->clear()V

    .line 469
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-gtz v1, :cond_1

    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_3

    .line 470
    :cond_1
    new-instance v1, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mHeaderViewInfos:Ljava/util/ArrayList;

    iget-object v3, p0, Lit/sephiroth/android/library/widget/HListView;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-direct {v1, v2, v3, p1}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;-><init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Landroid/widget/ListAdapter;)V

    iput-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 475
    :goto_0
    const/4 v1, -0x1

    iput v1, p0, Lit/sephiroth/android/library/widget/HListView;->mOldSelectedPosition:I

    .line 476
    const-wide/high16 v2, -0x8000000000000000L

    iput-wide v2, p0, Lit/sephiroth/android/library/widget/HListView;->mOldSelectedColId:J

    .line 479
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 481
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v1, :cond_5

    .line 482
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->areAllItemsEnabled()Z

    move-result v1

    iput-boolean v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAreAllItemsSelectable:Z

    .line 483
    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    iput v1, p0, Lit/sephiroth/android/library/widget/HListView;->mOldItemCount:I

    .line 484
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    iput v1, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    .line 485
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->checkFocus()V

    .line 487
    new-instance v1, Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    invoke-direct {v1, p0}, Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    iput-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    .line 488
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mDataSetObserver:Lit/sephiroth/android/library/widget/AbsHListView$AdapterDataSetObserver;

    invoke-interface {v1, v2}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 490
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mRecycler:Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2}, Landroid/widget/ListAdapter;->getViewTypeCount()I

    move-result v2

    invoke-virtual {v1, v2}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->setViewTypeCount(I)V

    .line 493
    iget-boolean v1, p0, Lit/sephiroth/android/library/widget/HListView;->mStackFromRight:Z

    if-eqz v1, :cond_4

    .line 494
    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p0, v1, v4}, Lit/sephiroth/android/library/widget/HListView;->lookForSelectablePosition(IZ)I

    move-result v0

    .line 498
    .local v0, "position":I
    :goto_1
    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->setSelectedPositionInt(I)V

    .line 499
    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->setNextSelectedPositionInt(I)V

    .line 501
    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mItemCount:I

    if-nez v1, :cond_2

    .line 503
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->checkSelectionChanged()V

    .line 512
    .end local v0    # "position":I
    :cond_2
    :goto_2
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->requestLayout()V

    .line 513
    return-void

    .line 472
    :cond_3
    iput-object p1, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    goto :goto_0

    .line 496
    :cond_4
    invoke-virtual {p0, v4, v5}, Lit/sephiroth/android/library/widget/HListView;->lookForSelectablePosition(IZ)I

    move-result v0

    .restart local v0    # "position":I
    goto :goto_1

    .line 506
    .end local v0    # "position":I
    :cond_5
    iput-boolean v5, p0, Lit/sephiroth/android/library/widget/HListView;->mAreAllItemsSelectable:Z

    .line 507
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->checkFocus()V

    .line 509
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->checkSelectionChanged()V

    goto :goto_2
.end method

.method public setCacheColorHint(I)V
    .locals 3
    .param p1, "color"    # I

    .prologue
    .line 3140
    ushr-int/lit8 v1, p1, 0x18

    const/16 v2, 0xff

    if-ne v1, v2, :cond_2

    const/4 v0, 0x1

    .line 3141
    .local v0, "opaque":Z
    :goto_0
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/HListView;->mIsCacheColorOpaque:Z

    .line 3142
    if-eqz v0, :cond_1

    .line 3143
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerPaint:Landroid/graphics/Paint;

    if-nez v1, :cond_0

    .line 3144
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerPaint:Landroid/graphics/Paint;

    .line 3146
    :cond_0
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerPaint:Landroid/graphics/Paint;

    invoke-virtual {v1, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 3148
    :cond_1
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->setCacheColorHint(I)V

    .line 3149
    return-void

    .line 3140
    .end local v0    # "opaque":Z
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setDivider(Landroid/graphics/drawable/Drawable;)V
    .locals 3
    .param p1, "divider"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v0, 0x0

    .line 3386
    if-eqz p1, :cond_2

    .line 3387
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    iput v1, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    .line 3391
    :goto_0
    iput-object p1, p0, Lit/sephiroth/android/library/widget/HListView;->mDivider:Landroid/graphics/drawable/Drawable;

    .line 3392
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_1

    :cond_0
    const/4 v0, 0x1

    :cond_1
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerIsOpaque:Z

    .line 3393
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->requestLayout()V

    .line 3394
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invalidate()V

    .line 3395
    return-void

    .line 3389
    :cond_2
    iput v0, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    goto :goto_0
.end method

.method public setDividerWidth(I)V
    .locals 0
    .param p1, "width"    # I

    .prologue
    .line 3415
    iput p1, p0, Lit/sephiroth/android/library/widget/HListView;->mDividerWidth:I

    .line 3416
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->requestLayout()V

    .line 3417
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invalidate()V

    .line 3418
    return-void
.end method

.method public setFooterDividersEnabled(Z)V
    .locals 0
    .param p1, "footerDividersEnabled"    # Z

    .prologue
    .line 3444
    iput-boolean p1, p0, Lit/sephiroth/android/library/widget/HListView;->mFooterDividersEnabled:Z

    .line 3445
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invalidate()V

    .line 3446
    return-void
.end method

.method public setHeaderDividersEnabled(Z)V
    .locals 0
    .param p1, "headerDividersEnabled"    # Z

    .prologue
    .line 3430
    iput-boolean p1, p0, Lit/sephiroth/android/library/widget/HListView;->mHeaderDividersEnabled:Z

    .line 3431
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invalidate()V

    .line 3432
    return-void
.end method

.method public setItemsCanFocus(Z)V
    .locals 1
    .param p1, "itemsCanFocus"    # Z

    .prologue
    .line 3106
    iput-boolean p1, p0, Lit/sephiroth/android/library/widget/HListView;->mItemsCanFocus:Z

    .line 3107
    if-nez p1, :cond_0

    .line 3108
    const/high16 v0, 0x60000

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->setDescendantFocusability(I)V

    .line 3110
    :cond_0
    return-void
.end method

.method public setOverscrollFooter(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "footer"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 3477
    iput-object p1, p0, Lit/sephiroth/android/library/widget/HListView;->mOverScrollFooter:Landroid/graphics/drawable/Drawable;

    .line 3478
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invalidate()V

    .line 3479
    return-void
.end method

.method public setOverscrollHeader(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "header"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 3456
    iput-object p1, p0, Lit/sephiroth/android/library/widget/HListView;->mOverScrollHeader:Landroid/graphics/drawable/Drawable;

    .line 3457
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->getScrollX()I

    move-result v0

    if-gez v0, :cond_0

    .line 3458
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->invalidate()V

    .line 3460
    :cond_0
    return-void
.end method

.method public setSelection(I)V
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 2008
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lit/sephiroth/android/library/widget/HListView;->setSelectionFromLeft(II)V

    .line 2009
    return-void
.end method

.method public setSelectionFromLeft(II)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "x"    # I

    .prologue
    .line 2021
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    if-nez v0, :cond_1

    .line 2048
    :cond_0
    :goto_0
    return-void

    .line 2025
    :cond_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->isInTouchMode()Z

    move-result v0

    if-nez v0, :cond_5

    .line 2026
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lit/sephiroth/android/library/widget/HListView;->lookForSelectablePosition(IZ)I

    move-result p1

    .line 2027
    if-ltz p1, :cond_2

    .line 2028
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->setNextSelectedPositionInt(I)V

    .line 2034
    :cond_2
    :goto_1
    if-ltz p1, :cond_0

    .line 2035
    const/4 v0, 0x4

    iput v0, p0, Lit/sephiroth/android/library/widget/HListView;->mLayoutMode:I

    .line 2036
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mListPadding:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->left:I

    add-int/2addr v0, p2

    iput v0, p0, Lit/sephiroth/android/library/widget/HListView;->mSpecificLeft:I

    .line 2038
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/HListView;->mNeedSync:Z

    if-eqz v0, :cond_3

    .line 2039
    iput p1, p0, Lit/sephiroth/android/library/widget/HListView;->mSyncPosition:I

    .line 2040
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v0

    iput-wide v0, p0, Lit/sephiroth/android/library/widget/HListView;->mSyncColId:J

    .line 2043
    :cond_3
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    if-eqz v0, :cond_4

    .line 2044
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 2046
    :cond_4
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->requestLayout()V

    goto :goto_0

    .line 2031
    :cond_5
    iput p1, p0, Lit/sephiroth/android/library/widget/HListView;->mResurrectToPosition:I

    goto :goto_1
.end method

.method public setSelectionInt(I)V
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 2058
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->setNextSelectedPositionInt(I)V

    .line 2059
    const/4 v0, 0x0

    .line 2061
    .local v0, "awakeScrollbars":Z
    iget v1, p0, Lit/sephiroth/android/library/widget/HListView;->mSelectedPosition:I

    .line 2063
    .local v1, "selectedPosition":I
    if-ltz v1, :cond_0

    .line 2064
    add-int/lit8 v2, v1, -0x1

    if-ne p1, v2, :cond_3

    .line 2065
    const/4 v0, 0x1

    .line 2071
    :cond_0
    :goto_0
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    if-eqz v2, :cond_1

    .line 2072
    iget-object v2, p0, Lit/sephiroth/android/library/widget/HListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 2075
    :cond_1
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->layoutChildren()V

    .line 2077
    if-eqz v0, :cond_2

    .line 2078
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HListView;->awakenScrollBars()Z

    .line 2080
    :cond_2
    return-void

    .line 2066
    :cond_3
    add-int/lit8 v2, v1, 0x1

    if-ne p1, v2, :cond_0

    .line 2067
    const/4 v0, 0x1

    goto :goto_0
.end method
