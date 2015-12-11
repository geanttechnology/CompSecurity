.class public Lcom/aio/downloader/views/PagerSlidingTabStrip;
.super Landroid/widget/HorizontalScrollView;
.source "PagerSlidingTabStrip.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/PagerSlidingTabStrip$CustomTabProvider;,
        Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;,
        Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;,
        Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;,
        Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;
    }
.end annotation


# static fields
.field private static final ANDROID_ATTRS:[I

.field public static final DEF_VALUE_TAB_TEXT_ALPHA:I = 0x96

.field private static final PADDING_INDEX:I = 0x1

.field private static final PADDING_LEFT_INDEX:I = 0x2

.field private static final PADDING_RIGHT_INDEX:I = 0x3

.field private static final TEXT_COLOR_PRIMARY:I


# instance fields
.field private firstTabGlobalLayoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

.field private isCustomTabs:Z

.field private isExpandTabs:Z

.field private isPaddingMiddle:Z

.field private isTabTextAllCaps:Z

.field private final mAdapterObserver:Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;

.field private mCurrentPosition:I

.field private mCurrentPositionOffset:F

.field public mDelegatePageListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

.field private mDividerColor:I

.field private mDividerPadding:I

.field private mDividerPaint:Landroid/graphics/Paint;

.field private mDividerWidth:I

.field private mIndicatorColor:I

.field private mIndicatorHeight:I

.field private mLastScrollX:I

.field private mPaddingLeft:I

.field private mPaddingRight:I

.field private final mPageListener:Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;

.field private mPager:Landroid/support/v4/view/ViewPager;

.field private mRectPaint:Landroid/graphics/Paint;

.field private mScrollOffset:I

.field private mTabBackgroundResId:I

.field private mTabCount:I

.field private mTabLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

.field private mTabPadding:I

.field private mTabReselectedListener:Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;

.field private mTabTextColor:Landroid/content/res/ColorStateList;

.field private mTabTextSize:I

.field private mTabTextTypeface:Landroid/graphics/Typeface;

.field private mTabTextTypefaceStyle:I

.field private mTabsContainer:Landroid/widget/LinearLayout;

.field private mUnderlineColor:I

.field private mUnderlineHeight:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    const/4 v0, 0x4

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->ANDROID_ATTRS:[I

    .line 59
    return-void

    .line 51
    nop

    :array_0
    .array-data 4
        0x1010036
        0x10100d5
        0x10100d6
        0x10100d8
    .end array-data
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 109
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 110
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 113
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 114
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 11
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 118
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 64
    new-instance v7, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;

    const/4 v8, 0x0

    invoke-direct {v7, p0, v8}, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;-><init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;)V

    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mAdapterObserver:Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;

    .line 65
    new-instance v7, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;

    const/4 v8, 0x0

    invoke-direct {v7, p0, v8}, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;-><init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;)V

    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPageListener:Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;

    .line 66
    const/4 v7, 0x0

    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabReselectedListener:Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;

    .line 72
    const/4 v7, 0x0

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I

    .line 73
    const/4 v7, 0x0

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPositionOffset:F

    .line 79
    const/4 v7, 0x2

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorHeight:I

    .line 81
    const/4 v7, 0x0

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineHeight:I

    .line 84
    const/4 v7, 0x0

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerWidth:I

    .line 85
    const/4 v7, 0x0

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPadding:I

    .line 88
    const/16 v7, 0xc

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabPadding:I

    .line 89
    const/16 v7, 0xe

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextSize:I

    .line 90
    const/4 v7, 0x0

    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextColor:Landroid/content/res/ColorStateList;

    .line 92
    const/4 v7, 0x0

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingLeft:I

    .line 93
    const/4 v7, 0x0

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingRight:I

    .line 95
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isExpandTabs:Z

    .line 97
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isPaddingMiddle:Z

    .line 98
    const/4 v7, 0x1

    iput-boolean v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isTabTextAllCaps:Z

    .line 100
    const/4 v7, 0x0

    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextTypeface:Landroid/graphics/Typeface;

    .line 101
    const/4 v7, 0x1

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextTypefaceStyle:I

    .line 104
    const/4 v7, 0x0

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mLastScrollX:I

    .line 106
    const v7, 0x7f020166

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabBackgroundResId:I

    .line 427
    new-instance v7, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;

    invoke-direct {v7, p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;-><init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;)V

    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->firstTabGlobalLayoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    .line 119
    const/4 v7, 0x1

    invoke-virtual {p0, v7}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setFillViewport(Z)V

    .line 120
    const/4 v7, 0x0

    invoke-virtual {p0, v7}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setWillNotDraw(Z)V

    .line 121
    new-instance v7, Landroid/widget/LinearLayout;

    invoke-direct {v7, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    .line 122
    iget-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 123
    iget-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {p0, v7}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->addView(Landroid/view/View;)V

    .line 125
    new-instance v7, Landroid/graphics/Paint;

    invoke-direct {v7}, Landroid/graphics/Paint;-><init>()V

    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mRectPaint:Landroid/graphics/Paint;

    .line 126
    iget-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mRectPaint:Landroid/graphics/Paint;

    const/4 v8, 0x1

    invoke-virtual {v7, v8}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 127
    iget-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mRectPaint:Landroid/graphics/Paint;

    sget-object v8, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v7, v8}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 129
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    .line 131
    .local v1, "dm":Landroid/util/DisplayMetrics;
    const/4 v7, 0x1

    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mScrollOffset:I

    int-to-float v8, v8

    .line 130
    invoke-static {v7, v8, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v7

    float-to-int v7, v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mScrollOffset:I

    .line 133
    const/4 v7, 0x1

    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorHeight:I

    int-to-float v8, v8

    .line 132
    invoke-static {v7, v8, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v7

    float-to-int v7, v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorHeight:I

    .line 135
    const/4 v7, 0x1

    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineHeight:I

    int-to-float v8, v8

    .line 134
    invoke-static {v7, v8, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v7

    float-to-int v7, v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineHeight:I

    .line 137
    const/4 v7, 0x1

    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPadding:I

    int-to-float v8, v8

    .line 136
    invoke-static {v7, v8, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v7

    float-to-int v7, v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPadding:I

    .line 139
    const/4 v7, 0x1

    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabPadding:I

    int-to-float v8, v8

    .line 138
    invoke-static {v7, v8, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v7

    float-to-int v7, v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabPadding:I

    .line 141
    const/4 v7, 0x1

    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerWidth:I

    int-to-float v8, v8

    .line 140
    invoke-static {v7, v8, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v7

    float-to-int v7, v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerWidth:I

    .line 143
    const/4 v7, 0x2

    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextSize:I

    int-to-float v8, v8

    .line 142
    invoke-static {v7, v8, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v7

    float-to-int v7, v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextSize:I

    .line 145
    new-instance v7, Landroid/graphics/Paint;

    invoke-direct {v7}, Landroid/graphics/Paint;-><init>()V

    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPaint:Landroid/graphics/Paint;

    .line 146
    iget-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPaint:Landroid/graphics/Paint;

    const/4 v8, 0x1

    invoke-virtual {v7, v8}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 147
    iget-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPaint:Landroid/graphics/Paint;

    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerWidth:I

    int-to-float v8, v8

    invoke-virtual {v7, v8}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 150
    sget-object v7, Lcom/aio/downloader/views/PagerSlidingTabStrip;->ANDROID_ATTRS:[I

    invoke-virtual {p1, p2, v7}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 151
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f08002e

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    .line 152
    .local v6, "textPrimaryColor":I
    iput v6, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineColor:I

    .line 153
    iput v6, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerColor:I

    .line 154
    iput v6, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorColor:I

    .line 155
    const/4 v7, 0x1

    const/4 v8, 0x0

    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v3

    .line 156
    .local v3, "padding":I
    if-lez v3, :cond_2

    move v7, v3

    :goto_0
    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingLeft:I

    .line 158
    if-lez v3, :cond_3

    .end local v3    # "padding":I
    :goto_1
    iput v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingRight:I

    .line 160
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 162
    const-string v5, "sans-serif"

    .line 171
    .local v5, "tabTextTypefaceName":Ljava/lang/String;
    sget-object v7, Lcom/aio/downloader/R$styleable;->PagerSlidingTabStrip:[I

    .line 170
    invoke-virtual {p1, p2, v7}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 173
    const/4 v7, 0x0

    .line 174
    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorColor:I

    .line 172
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorColor:I

    .line 176
    const/4 v7, 0x1

    .line 177
    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorHeight:I

    .line 175
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorHeight:I

    .line 179
    const/4 v7, 0x2

    .line 180
    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineColor:I

    .line 178
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineColor:I

    .line 182
    const/4 v7, 0x3

    .line 183
    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineHeight:I

    .line 181
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineHeight:I

    .line 185
    const/4 v7, 0x4

    .line 186
    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerColor:I

    .line 184
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerColor:I

    .line 188
    const/4 v7, 0x5

    .line 189
    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerWidth:I

    .line 187
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerWidth:I

    .line 191
    const/4 v7, 0x6

    .line 192
    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPadding:I

    .line 190
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPadding:I

    .line 194
    const/16 v7, 0x8

    .line 195
    iget-boolean v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isExpandTabs:Z

    .line 194
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v7

    .line 193
    iput-boolean v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isExpandTabs:Z

    .line 197
    const/4 v7, 0x7

    .line 198
    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mScrollOffset:I

    .line 196
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mScrollOffset:I

    .line 200
    const/16 v7, 0x9

    .line 201
    iget-boolean v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isPaddingMiddle:Z

    .line 199
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v7

    iput-boolean v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isPaddingMiddle:Z

    .line 203
    const/16 v7, 0xa

    .line 204
    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabPadding:I

    .line 202
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabPadding:I

    .line 206
    const/16 v7, 0xb

    .line 207
    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabBackgroundResId:I

    .line 205
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabBackgroundResId:I

    .line 209
    const/16 v7, 0xc

    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextSize:I

    .line 208
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextSize:I

    .line 211
    const/16 v7, 0xd

    invoke-virtual {v0, v7}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 212
    const/16 v7, 0xd

    invoke-virtual {v0, v7}, Landroid/content/res/TypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v7

    .line 210
    :goto_2
    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextColor:Landroid/content/res/ColorStateList;

    .line 215
    const/16 v7, 0xe

    .line 216
    iget v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextTypefaceStyle:I

    .line 214
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v7

    iput v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextTypefaceStyle:I

    .line 218
    const/16 v7, 0xf

    .line 219
    iget-boolean v8, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isTabTextAllCaps:Z

    .line 217
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v7

    iput-boolean v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isTabTextAllCaps:Z

    .line 221
    const/16 v7, 0x10

    .line 222
    const/16 v8, 0x96

    .line 220
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v4

    .line 224
    .local v4, "tabTextAlpha":I
    const/16 v7, 0x11

    invoke-virtual {v0, v7}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 225
    .local v2, "fontFamily":Ljava/lang/String;
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 228
    iget-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextColor:Landroid/content/res/ColorStateList;

    if-nez v7, :cond_0

    .line 232
    invoke-static {v6}, Landroid/graphics/Color;->red(I)I

    move-result v7

    .line 233
    invoke-static {v6}, Landroid/graphics/Color;->green(I)I

    move-result v8

    .line 234
    invoke-static {v6}, Landroid/graphics/Color;->blue(I)I

    move-result v9

    .line 232
    invoke-static {v4, v7, v8, v9}, Landroid/graphics/Color;->argb(IIII)I

    move-result v7

    .line 229
    invoke-direct {p0, v6, v6, v7}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->createColorStateList(III)Landroid/content/res/ColorStateList;

    move-result-object v7

    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextColor:Landroid/content/res/ColorStateList;

    .line 238
    :cond_0
    if-eqz v2, :cond_1

    .line 239
    move-object v5, v2

    .line 242
    :cond_1
    iget v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextTypefaceStyle:I

    .line 241
    invoke-static {v5, v7}, Landroid/graphics/Typeface;->create(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v7

    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextTypeface:Landroid/graphics/Typeface;

    .line 246
    invoke-direct {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setTabsContainerParentViewPaddings()V

    .line 250
    iget-boolean v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isExpandTabs:Z

    if-eqz v7, :cond_5

    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v8, 0x0

    .line 251
    const/4 v9, -0x1

    const/high16 v10, 0x3f800000    # 1.0f

    invoke-direct {v7, v8, v9, v10}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    .line 250
    :goto_3
    iput-object v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    .line 254
    return-void

    .line 157
    .end local v2    # "fontFamily":Ljava/lang/String;
    .end local v4    # "tabTextAlpha":I
    .end local v5    # "tabTextTypefaceName":Ljava/lang/String;
    .restart local v3    # "padding":I
    :cond_2
    const/4 v7, 0x2

    const/4 v8, 0x0

    .line 156
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v7

    goto/16 :goto_0

    .line 159
    :cond_3
    const/4 v7, 0x3

    const/4 v8, 0x0

    .line 158
    invoke-virtual {v0, v7, v8}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v3

    goto/16 :goto_1

    .line 213
    .end local v3    # "padding":I
    .restart local v5    # "tabTextTypefaceName":Ljava/lang/String;
    :cond_4
    const/4 v7, 0x0

    goto :goto_2

    .line 252
    .restart local v2    # "fontFamily":Ljava/lang/String;
    .restart local v4    # "tabTextAlpha":I
    :cond_5
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v8, -0x2

    .line 253
    const/4 v9, -0x1

    .line 252
    invoke-direct {v7, v8, v9}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    goto :goto_3
.end method

.method static synthetic access$0(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Z
    .locals 1

    .prologue
    .line 97
    iget-boolean v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isPaddingMiddle:Z

    return v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/views/PagerSlidingTabStrip;F)V
    .locals 0

    .prologue
    .line 73
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPositionOffset:F

    return-void
.end method

.method static synthetic access$11(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I
    .locals 1

    .prologue
    .line 72
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I

    return v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/views/PagerSlidingTabStrip;II)V
    .locals 0

    .prologue
    .line 355
    invoke-direct {p0, p1, p2}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->scrollToChild(II)V

    return-void
.end method

.method static synthetic access$13(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V
    .locals 0

    .prologue
    .line 566
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->updateSelection(I)V

    return-void
.end method

.method static synthetic access$14(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I
    .locals 1

    .prologue
    .line 70
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabCount:I

    return v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/views/PagerSlidingTabStrip;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 590
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->select(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$16(Lcom/aio/downloader/views/PagerSlidingTabStrip;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 578
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->unSelect(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$17(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabReselectedListener:Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V
    .locals 0

    .prologue
    .line 93
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingRight:I

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V
    .locals 0

    .prologue
    .line 92
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingLeft:I

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I
    .locals 1

    .prologue
    .line 92
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingLeft:I

    return v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I
    .locals 1

    .prologue
    .line 93
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingRight:I

    return v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I
    .locals 1

    .prologue
    .line 103
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mScrollOffset:I

    return v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V
    .locals 0

    .prologue
    .line 103
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mScrollOffset:I

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V
    .locals 0

    .prologue
    .line 72
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I

    return-void
.end method

.method private addTab(ILjava/lang/CharSequence;Landroid/view/View;)V
    .locals 3
    .param p1, "position"    # I
    .param p2, "title"    # Ljava/lang/CharSequence;
    .param p3, "tabView"    # Landroid/view/View;

    .prologue
    .line 299
    .line 300
    const v1, 0x7f07037e

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 299
    check-cast v0, Landroid/widget/TextView;

    .line 301
    .local v0, "textView":Landroid/widget/TextView;
    if-eqz v0, :cond_0

    .line 302
    if-eqz p2, :cond_0

    .line 303
    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 306
    :cond_0
    const/4 v1, 0x1

    invoke-virtual {p3, v1}, Landroid/view/View;->setFocusable(Z)V

    .line 307
    new-instance v1, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;

    invoke-direct {v1, p0, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;-><init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V

    invoke-virtual {p3, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 321
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabLayoutParams:Landroid/widget/LinearLayout$LayoutParams;

    invoke-virtual {v1, p3, p1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 322
    return-void
.end method

.method private createColorStateList(I)Landroid/content/res/ColorStateList;
    .locals 5
    .param p1, "color_state_default"    # I

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 838
    new-instance v0, Landroid/content/res/ColorStateList;

    new-array v1, v4, [[I

    new-array v2, v3, [I

    aput-object v2, v1, v3

    .line 839
    new-array v2, v4, [I

    aput p1, v2, v3

    .line 838
    invoke-direct {v0, v1, v2}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    return-object v0
.end method

.method private createColorStateList(III)Landroid/content/res/ColorStateList;
    .locals 8
    .param p1, "color_state_pressed"    # I
    .param p2, "color_state_selected"    # I
    .param p3, "color_state_default"    # I

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 845
    new-instance v0, Landroid/content/res/ColorStateList;

    new-array v1, v7, [[I

    .line 846
    new-array v2, v5, [I

    const v3, 0x10100a7

    aput v3, v2, v4

    aput-object v2, v1, v4

    .line 847
    new-array v2, v5, [I

    const v3, 0x10100a1

    aput v3, v2, v4

    aput-object v2, v1, v5

    .line 848
    new-array v2, v4, [I

    aput-object v2, v1, v6

    .line 849
    new-array v2, v7, [I

    aput p1, v2, v4

    aput p2, v2, v5

    .line 850
    aput p3, v2, v6

    .line 845
    invoke-direct {v0, v1, v2}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    return-object v0
.end method

.method private getIndicatorCoordinates()Landroid/util/Pair;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Float;",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation

    .prologue
    const/high16 v8, 0x3f800000    # 1.0f

    .line 381
    iget-object v6, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    iget v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I

    invoke-virtual {v6, v7}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 382
    .local v0, "currentTab":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v6

    int-to-float v1, v6

    .line 383
    .local v1, "lineLeft":F
    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v6

    int-to-float v2, v6

    .line 386
    .local v2, "lineRight":F
    iget v6, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPositionOffset:F

    const/4 v7, 0x0

    cmpl-float v6, v6, v7

    if-lez v6, :cond_0

    iget v6, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I

    iget v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabCount:I

    add-int/lit8 v7, v7, -0x1

    if-ge v6, v7, :cond_0

    .line 387
    iget-object v6, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    iget v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I

    add-int/lit8 v7, v7, 0x1

    invoke-virtual {v6, v7}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 388
    .local v3, "nextTab":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v6

    int-to-float v4, v6

    .line 389
    .local v4, "nextTabLeft":F
    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v6

    int-to-float v5, v6

    .line 390
    .local v5, "nextTabRight":F
    iget v6, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPositionOffset:F

    mul-float/2addr v6, v4

    iget v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPositionOffset:F

    sub-float v7, v8, v7

    .line 391
    mul-float/2addr v7, v1

    .line 390
    add-float v1, v6, v7

    .line 392
    iget v6, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPositionOffset:F

    mul-float/2addr v6, v5

    iget v7, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPositionOffset:F

    sub-float v7, v8, v7

    .line 393
    mul-float/2addr v7, v2

    .line 392
    add-float v2, v6, v7

    .line 396
    .end local v3    # "nextTab":Landroid/view/View;
    .end local v4    # "nextTabLeft":F
    .end local v5    # "nextTabRight":F
    :cond_0
    new-instance v6, Landroid/util/Pair;

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v8

    invoke-direct {v6, v7, v8}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v6
.end method

.method private scrollToChild(II)V
    .locals 5
    .param p1, "position"    # I
    .param p2, "offset"    # I

    .prologue
    .line 356
    iget v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabCount:I

    if-nez v2, :cond_1

    .line 377
    :cond_0
    :goto_0
    return-void

    .line 360
    :cond_1
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v2, p1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getLeft()I

    move-result v2

    add-int v1, v2, p2

    .line 361
    .local v1, "newScrollX":I
    if-gtz p1, :cond_2

    if-lez p2, :cond_3

    .line 368
    :cond_2
    iget v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mScrollOffset:I

    sub-int/2addr v1, v2

    .line 369
    invoke-direct {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getIndicatorCoordinates()Landroid/util/Pair;

    move-result-object v0

    .line 370
    .local v0, "lines":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Float;Ljava/lang/Float;>;"
    int-to-float v3, v1

    iget-object v2, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v4

    iget-object v2, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    sub-float v2, v4, v2

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v2, v4

    add-float/2addr v2, v3

    float-to-int v1, v2

    .line 373
    .end local v0    # "lines":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Float;Ljava/lang/Float;>;"
    :cond_3
    iget v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mLastScrollX:I

    if-eq v1, v2, :cond_0

    .line 374
    iput v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mLastScrollX:I

    .line 375
    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->scrollTo(II)V

    goto :goto_0
.end method

.method private select(Landroid/view/View;)V
    .locals 2
    .param p1, "tab"    # Landroid/view/View;

    .prologue
    .line 591
    if-eqz p1, :cond_1

    .line 593
    const v1, 0x7f07037e

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 592
    check-cast v0, Landroid/widget/TextView;

    .line 594
    .local v0, "tab_title":Landroid/widget/TextView;
    if-eqz v0, :cond_0

    .line 595
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setSelected(Z)V

    .line 597
    :cond_0
    iget-boolean v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isCustomTabs:Z

    if-eqz v1, :cond_1

    .line 598
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/PagerSlidingTabStrip$CustomTabProvider;

    invoke-interface {v1, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip$CustomTabProvider;->tabSelected(Landroid/view/View;)V

    .line 600
    .end local v0    # "tab_title":Landroid/widget/TextView;
    :cond_1
    return-void
.end method

.method private setTabsContainerParentViewPaddings()V
    .locals 4

    .prologue
    .line 257
    iget v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorHeight:I

    iget v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineHeight:I

    if-lt v1, v2, :cond_0

    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorHeight:I

    .line 259
    .local v0, "bottomMargin":I
    :goto_0
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getPaddingLeft()I

    move-result v1

    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getPaddingTop()I

    move-result v2

    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getPaddingRight()I

    move-result v3

    invoke-virtual {p0, v1, v2, v3, v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setPadding(IIII)V

    .line 262
    return-void

    .line 258
    .end local v0    # "bottomMargin":I
    :cond_0
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineHeight:I

    goto :goto_0
.end method

.method private unSelect(Landroid/view/View;)V
    .locals 2
    .param p1, "tab"    # Landroid/view/View;

    .prologue
    .line 579
    if-eqz p1, :cond_1

    .line 581
    const v1, 0x7f07037e

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 580
    check-cast v0, Landroid/widget/TextView;

    .line 582
    .local v0, "tab_title":Landroid/widget/TextView;
    if-eqz v0, :cond_0

    .line 583
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setSelected(Z)V

    .line 585
    :cond_0
    iget-boolean v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isCustomTabs:Z

    if-eqz v1, :cond_1

    .line 586
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/PagerSlidingTabStrip$CustomTabProvider;

    invoke-interface {v1, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip$CustomTabProvider;->tabUnselected(Landroid/view/View;)V

    .line 588
    .end local v0    # "tab_title":Landroid/widget/TextView;
    :cond_1
    return-void
.end method

.method private updateSelection(I)V
    .locals 4
    .param p1, "position"    # I

    .prologue
    .line 567
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabCount:I

    if-lt v0, v3, :cond_0

    .line 576
    return-void

    .line 568
    :cond_0
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 569
    .local v2, "tv":Landroid/view/View;
    if-ne v0, p1, :cond_1

    const/4 v1, 0x1

    .line 570
    .local v1, "selected":Z
    :goto_1
    if-eqz v1, :cond_2

    .line 571
    invoke-direct {p0, v2}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->select(Landroid/view/View;)V

    .line 567
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 569
    .end local v1    # "selected":Z
    :cond_1
    const/4 v1, 0x0

    goto :goto_1

    .line 573
    .restart local v1    # "selected":Z
    :cond_2
    invoke-direct {p0, v2}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->unSelect(Landroid/view/View;)V

    goto :goto_2
.end method

.method private updateTabStyles()V
    .locals 7

    .prologue
    .line 325
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabCount:I

    if-lt v0, v3, :cond_0

    .line 353
    return-void

    .line 326
    :cond_0
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 327
    .local v2, "v":Landroid/view/View;
    iget v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabBackgroundResId:I

    invoke-virtual {v2, v3}, Landroid/view/View;->setBackgroundResource(I)V

    .line 328
    iget v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabPadding:I

    invoke-virtual {v2}, Landroid/view/View;->getPaddingTop()I

    move-result v4

    iget v5, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabPadding:I

    .line 329
    invoke-virtual {v2}, Landroid/view/View;->getPaddingBottom()I

    move-result v6

    .line 328
    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/view/View;->setPadding(IIII)V

    .line 330
    const v3, 0x7f07037e

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 331
    .local v1, "tab_title":Landroid/widget/TextView;
    if-eqz v1, :cond_1

    .line 332
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextColor:Landroid/content/res/ColorStateList;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 333
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextTypeface:Landroid/graphics/Typeface;

    iget v4, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextTypefaceStyle:I

    invoke-virtual {v1, v3, v4}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 334
    const/4 v3, 0x0

    iget v4, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextSize:I

    int-to-float v4, v4

    invoke-virtual {v1, v3, v4}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 338
    iget-boolean v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isTabTextAllCaps:Z

    if-eqz v3, :cond_1

    .line 339
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xe

    if-lt v3, v4, :cond_2

    .line 340
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setAllCaps(Z)V

    .line 325
    :cond_1
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 344
    :cond_2
    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    .line 345
    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    .line 347
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 348
    invoke-virtual {v4}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v4

    iget-object v4, v4, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    .line 346
    invoke-virtual {v3, v4}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v3

    .line 343
    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1
.end method


# virtual methods
.method public getDividerColor()I
    .locals 1

    .prologue
    .line 706
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerColor:I

    return v0
.end method

.method public getDividerPadding()I
    .locals 1

    .prologue
    .line 718
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPadding:I

    return v0
.end method

.method public getDividerWidth()I
    .locals 1

    .prologue
    .line 710
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerWidth:I

    return v0
.end method

.method public getIndicatorColor()I
    .locals 1

    .prologue
    .line 694
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorColor:I

    return v0
.end method

.method public getIndicatorHeight()I
    .locals 1

    .prologue
    .line 698
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorHeight:I

    return v0
.end method

.method public getScrollOffset()I
    .locals 1

    .prologue
    .line 722
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mScrollOffset:I

    return v0
.end method

.method public getShouldExpand()Z
    .locals 1

    .prologue
    .line 726
    iget-boolean v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isExpandTabs:Z

    return v0
.end method

.method public getTabBackground()I
    .locals 1

    .prologue
    .line 742
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabBackgroundResId:I

    return v0
.end method

.method public getTabPaddingLeftRight()I
    .locals 1

    .prologue
    .line 746
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabPadding:I

    return v0
.end method

.method public getTextColor()Landroid/content/res/ColorStateList;
    .locals 1

    .prologue
    .line 738
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextColor:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method public getTextSize()I
    .locals 1

    .prologue
    .line 730
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextSize:I

    return v0
.end method

.method public getUnderlineColor()I
    .locals 1

    .prologue
    .line 702
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineColor:I

    return v0
.end method

.method public getUnderlineHeight()I
    .locals 1

    .prologue
    .line 714
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineHeight:I

    return v0
.end method

.method public isTextAllCaps()Z
    .locals 1

    .prologue
    .line 734
    iget-boolean v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isTabTextAllCaps:Z

    return v0
.end method

.method public notifyDataSetChanged()V
    .locals 6

    .prologue
    .line 279
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 280
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v3}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/view/PagerAdapter;->getCount()I

    move-result v3

    iput v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabCount:I

    .line 282
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabCount:I

    if-lt v0, v3, :cond_0

    .line 295
    invoke-direct {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->updateTabStyles()V

    .line 296
    return-void

    .line 283
    :cond_0
    iget-boolean v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isCustomTabs:Z

    if-eqz v3, :cond_1

    .line 284
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v3}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/views/PagerSlidingTabStrip$CustomTabProvider;

    .line 285
    invoke-interface {v3, p0, v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip$CustomTabProvider;->getCustomTabView(Landroid/view/ViewGroup;I)Landroid/view/View;

    move-result-object v1

    .line 291
    .local v1, "tabView":Landroid/view/View;
    :goto_1
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v3}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/support/v4/view/PagerAdapter;->getPageTitle(I)Ljava/lang/CharSequence;

    move-result-object v2

    .line 292
    .local v2, "title":Ljava/lang/CharSequence;
    invoke-direct {p0, v0, v2, v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->addTab(ILjava/lang/CharSequence;Landroid/view/View;)V

    .line 282
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 287
    .end local v1    # "tabView":Landroid/view/View;
    .end local v2    # "title":Ljava/lang/CharSequence;
    :cond_1
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 288
    const v4, 0x7f0300a2

    const/4 v5, 0x0

    .line 287
    invoke-virtual {v3, v4, p0, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .restart local v1    # "tabView":Landroid/view/View;
    goto :goto_1
.end method

.method protected onAttachedToWindow()V
    .locals 2

    .prologue
    .line 622
    invoke-super {p0}, Landroid/widget/HorizontalScrollView;->onAttachedToWindow()V

    .line 623
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    if-eqz v0, :cond_0

    .line 624
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mAdapterObserver:Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;

    invoke-virtual {v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;->isAttached()Z

    move-result v0

    if-nez v0, :cond_0

    .line 625
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mAdapterObserver:Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/PagerAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 626
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mAdapterObserver:Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;->setAttached(Z)V

    .line 629
    :cond_0
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 633
    invoke-super {p0}, Landroid/widget/HorizontalScrollView;->onDetachedFromWindow()V

    .line 634
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    if-eqz v0, :cond_0

    .line 635
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mAdapterObserver:Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;

    invoke-virtual {v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;->isAttached()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 636
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mAdapterObserver:Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/PagerAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 637
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mAdapterObserver:Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;->setAttached(Z)V

    .line 640
    :cond_0
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 10
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 467
    invoke-super {p0, p1}, Landroid/widget/HorizontalScrollView;->onDraw(Landroid/graphics/Canvas;)V

    .line 468
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isInEditMode()Z

    move-result v0

    if-nez v0, :cond_0

    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabCount:I

    if-nez v0, :cond_1

    .line 500
    :cond_0
    :goto_0
    return-void

    .line 472
    :cond_1
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getHeight()I

    move-result v6

    .line 474
    .local v6, "height":I
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerWidth:I

    if-lez v0, :cond_2

    .line 475
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerWidth:I

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 476
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerColor:I

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 477
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_1
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabCount:I

    add-int/lit8 v0, v0, -0x1

    if-lt v7, v0, :cond_4

    .line 485
    .end local v7    # "i":I
    :cond_2
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineHeight:I

    if-lez v0, :cond_3

    .line 486
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mRectPaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineColor:I

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 487
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingLeft:I

    int-to-float v1, v0

    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineHeight:I

    sub-int v0, v6, v0

    int-to-float v2, v0

    .line 488
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getWidth()I

    move-result v0

    iget v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingRight:I

    add-int/2addr v0, v3

    int-to-float v3, v0

    int-to-float v4, v6

    .line 489
    iget-object v5, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mRectPaint:Landroid/graphics/Paint;

    move-object v0, p1

    .line 487
    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 493
    :cond_3
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorHeight:I

    if-lez v0, :cond_0

    .line 494
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mRectPaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorColor:I

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 495
    invoke-direct {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getIndicatorCoordinates()Landroid/util/Pair;

    move-result-object v8

    .line 496
    .local v8, "lines":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Float;Ljava/lang/Float;>;"
    iget-object v0, v8, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    iget v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingLeft:I

    int-to-float v1, v1

    add-float/2addr v1, v0

    .line 497
    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorHeight:I

    sub-int v0, v6, v0

    int-to-float v2, v0

    iget-object v0, v8, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    iget v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingLeft:I

    int-to-float v3, v3

    add-float/2addr v3, v0

    int-to-float v4, v6

    .line 498
    iget-object v5, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mRectPaint:Landroid/graphics/Paint;

    move-object v0, p1

    .line 496
    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    goto :goto_0

    .line 478
    .end local v8    # "lines":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Float;Ljava/lang/Float;>;"
    .restart local v7    # "i":I
    :cond_4
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    .line 479
    .local v9, "tab":Landroid/view/View;
    invoke-virtual {v9}, Landroid/view/View;->getRight()I

    move-result v0

    int-to-float v1, v0

    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPadding:I

    int-to-float v2, v0

    .line 480
    invoke-virtual {v9}, Landroid/view/View;->getRight()I

    move-result v0

    int-to-float v3, v0

    iget v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPadding:I

    sub-int v0, v6, v0

    int-to-float v4, v0

    iget-object v5, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPaint:Landroid/graphics/Paint;

    move-object v0, p1

    .line 479
    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 477
    add-int/lit8 v7, v7, 0x1

    goto :goto_1
.end method

.method protected onLayout(ZIIII)V
    .locals 4
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    const/4 v3, 0x0

    .line 401
    iget-boolean v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isPaddingMiddle:Z

    if-nez v1, :cond_0

    iget v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingLeft:I

    if-gtz v1, :cond_0

    iget v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingRight:I

    if-lez v1, :cond_1

    .line 403
    :cond_0
    iget-boolean v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isPaddingMiddle:Z

    if-eqz v1, :cond_3

    .line 404
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getWidth()I

    move-result v0

    .line 413
    .local v0, "width":I
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setMinimumWidth(I)V

    .line 416
    invoke-virtual {p0, v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setClipToPadding(Z)V

    .line 419
    .end local v0    # "width":I
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v1

    if-lez v1, :cond_2

    .line 420
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v1

    .line 421
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->firstTabGlobalLayoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    invoke-virtual {v1, v2}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 424
    :cond_2
    invoke-super/range {p0 .. p5}, Landroid/widget/HorizontalScrollView;->onLayout(ZIIII)V

    .line 425
    return-void

    .line 408
    :cond_3
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getWidth()I

    move-result v1

    iget v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingLeft:I

    sub-int/2addr v1, v2

    iget v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingRight:I

    sub-int v0, v1, v2

    .restart local v0    # "width":I
    goto :goto_0
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 3
    .param p1, "state"    # Landroid/os/Parcelable;

    .prologue
    .line 644
    move-object v0, p1

    check-cast v0, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;

    .line 645
    .local v0, "savedState":Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;
    invoke-virtual {v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Landroid/widget/HorizontalScrollView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 646
    iget v1, v0, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;->currentPosition:I

    iput v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I

    .line 647
    iget v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v1

    if-lez v1, :cond_0

    .line 648
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->unSelect(Landroid/view/View;)V

    .line 649
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;

    iget v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->select(Landroid/view/View;)V

    .line 651
    :cond_0
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->requestLayout()V

    .line 652
    return-void
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .locals 3

    .prologue
    .line 656
    invoke-super {p0}, Landroid/widget/HorizontalScrollView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    .line 657
    .local v1, "superState":Landroid/os/Parcelable;
    new-instance v0, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;

    invoke-direct {v0, v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;-><init>(Landroid/os/Parcelable;)V

    .line 658
    .local v0, "savedState":Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;
    iget v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I

    iput v2, v0, Lcom/aio/downloader/views/PagerSlidingTabStrip$SavedState;->currentPosition:I

    .line 659
    return-object v0
.end method

.method public setAllCaps(Z)V
    .locals 0
    .param p1, "textAllCaps"    # Z

    .prologue
    .line 812
    iput-boolean p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isTabTextAllCaps:Z

    .line 813
    return-void
.end method

.method public setDividerColor(I)V
    .locals 0
    .param p1, "dividerColor"    # I

    .prologue
    .line 775
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerColor:I

    .line 776
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 777
    return-void
.end method

.method public setDividerColorResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 780
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerColor:I

    .line 781
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 782
    return-void
.end method

.method public setDividerPadding(I)V
    .locals 0
    .param p1, "dividerPaddingPx"    # I

    .prologue
    .line 795
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerPadding:I

    .line 796
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 797
    return-void
.end method

.method public setDividerWidth(I)V
    .locals 0
    .param p1, "dividerWidthPx"    # I

    .prologue
    .line 785
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDividerWidth:I

    .line 786
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 787
    return-void
.end method

.method public setIndicatorColor(I)V
    .locals 0
    .param p1, "indicatorColor"    # I

    .prologue
    .line 750
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorColor:I

    .line 751
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 752
    return-void
.end method

.method public setIndicatorColorResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 755
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorColor:I

    .line 756
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 757
    return-void
.end method

.method public setIndicatorHeight(I)V
    .locals 0
    .param p1, "indicatorLineHeightPx"    # I

    .prologue
    .line 760
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mIndicatorHeight:I

    .line 761
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 762
    return-void
.end method

.method public setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    .prologue
    .line 508
    iput-object p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDelegatePageListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    .line 509
    return-void
.end method

.method public setOnTabReselectedListener(Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;)V
    .locals 0
    .param p1, "tabReselectedListener"    # Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;

    .prologue
    .line 504
    iput-object p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabReselectedListener:Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;

    .line 505
    return-void
.end method

.method public setScrollOffset(I)V
    .locals 0
    .param p1, "scrollOffsetPx"    # I

    .prologue
    .line 800
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mScrollOffset:I

    .line 801
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 802
    return-void
.end method

.method public setShouldExpand(Z)V
    .locals 1
    .param p1, "shouldExpand"    # Z

    .prologue
    .line 805
    iput-boolean p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isExpandTabs:Z

    .line 806
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    if-eqz v0, :cond_0

    .line 807
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->requestLayout()V

    .line 809
    :cond_0
    return-void
.end method

.method public setTabBackground(I)V
    .locals 0
    .param p1, "resId"    # I

    .prologue
    .line 860
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabBackgroundResId:I

    .line 861
    return-void
.end method

.method public setTabPaddingLeftRight(I)V
    .locals 0
    .param p1, "paddingPx"    # I

    .prologue
    .line 864
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabPadding:I

    .line 865
    invoke-direct {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->updateTabStyles()V

    .line 866
    return-void
.end method

.method public setTextColor(I)V
    .locals 1
    .param p1, "textColor"    # I

    .prologue
    .line 825
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->createColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 826
    return-void
.end method

.method public setTextColor(Landroid/content/res/ColorStateList;)V
    .locals 0
    .param p1, "colorStateList"    # Landroid/content/res/ColorStateList;

    .prologue
    .line 833
    iput-object p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextColor:Landroid/content/res/ColorStateList;

    .line 834
    invoke-direct {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->updateTabStyles()V

    .line 835
    return-void
.end method

.method public setTextColorResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 821
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setTextColor(I)V

    .line 822
    return-void
.end method

.method public setTextColorStateListResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 829
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 830
    return-void
.end method

.method public setTextSize(I)V
    .locals 0
    .param p1, "textSizePx"    # I

    .prologue
    .line 816
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextSize:I

    .line 817
    invoke-direct {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->updateTabStyles()V

    .line 818
    return-void
.end method

.method public setTypeface(Landroid/graphics/Typeface;I)V
    .locals 0
    .param p1, "typeface"    # Landroid/graphics/Typeface;
    .param p2, "style"    # I

    .prologue
    .line 854
    iput-object p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextTypeface:Landroid/graphics/Typeface;

    .line 855
    iput p2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabTextTypefaceStyle:I

    .line 856
    invoke-direct {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->updateTabStyles()V

    .line 857
    return-void
.end method

.method public setUnderlineColor(I)V
    .locals 0
    .param p1, "underlineColor"    # I

    .prologue
    .line 765
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineColor:I

    .line 766
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 767
    return-void
.end method

.method public setUnderlineColorResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 770
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineColor:I

    .line 771
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 772
    return-void
.end method

.method public setUnderlineHeight(I)V
    .locals 0
    .param p1, "underlineHeightPx"    # I

    .prologue
    .line 790
    iput p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mUnderlineHeight:I

    .line 791
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 792
    return-void
.end method

.method public setViewPager(Landroid/support/v4/view/ViewPager;)V
    .locals 2
    .param p1, "pager"    # Landroid/support/v4/view/ViewPager;

    .prologue
    .line 265
    iput-object p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;

    .line 266
    invoke-virtual {p1}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v0

    if-nez v0, :cond_0

    .line 267
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 268
    const-string v1, "ViewPager does not have adapter instance."

    .line 267
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 271
    :cond_0
    invoke-virtual {p1}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v0

    instance-of v0, v0, Lcom/aio/downloader/views/PagerSlidingTabStrip$CustomTabProvider;

    iput-boolean v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->isCustomTabs:Z

    .line 272
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPageListener:Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;

    invoke-virtual {p1, v0}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 273
    invoke-virtual {p1}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mAdapterObserver:Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/PagerAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 274
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mAdapterObserver:Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip$PagerAdapterObserver;->setAttached(Z)V

    .line 275
    invoke-virtual {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->notifyDataSetChanged()V

    .line 276
    return-void
.end method
