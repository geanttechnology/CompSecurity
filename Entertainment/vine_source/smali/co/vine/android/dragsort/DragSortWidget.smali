.class public Lco/vine/android/dragsort/DragSortWidget;
.super Landroid/widget/RelativeLayout;
.source "DragSortWidget.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;
.implements Landroid/widget/AdapterView$OnItemClickListener;
.implements Lco/vine/android/views/HorizontalListView$OnScrollListener;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/dragsort/DragSortWidget$CurrentlyPlayingProvider;,
        Lco/vine/android/dragsort/DragSortWidget$CheckForLongPress;,
        Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;,
        Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;,
        Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;,
        Lco/vine/android/dragsort/DragSortWidget$DragListener;,
        Lco/vine/android/dragsort/DragSortWidget$RemoveListener;,
        Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;,
        Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;,
        Lco/vine/android/dragsort/DragSortWidget$ContentViewPickUpAnimator;,
        Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;,
        Lco/vine/android/dragsort/DragSortWidget$DropAnimator;,
        Lco/vine/android/dragsort/DragSortWidget$DragScroller;
    }
.end annotation


# static fields
.field private static final DROP_DURATION:I = 0x96

.field private static final FOCUSED_ALPHA:F = 1.0f

.field public static final INVALID_POSITION:I = -0x1

.field private static final MAX_SCROLL_SPEED_DENSITY_MULTIPLIER:F = 0.1f

.field private static final PICK_UP_CONTENT_DURATION:I = 0x82

.field private static final PICK_UP_DURATION:I

.field private static final REMOVE_DURATION:I = 0x64

.field private static final SCROLL_THRESHOLD:F = 0.33f

.field private static final SMOOTHNESS:F = 0.05f

.field private static final SWAP_DURATION:I = 0x64

.field private static final UNFOCUSED_ALPHA:F = 0.3f


# instance fields
.field private isFromContentView:Z

.field private mActivatedDrawable:Landroid/graphics/drawable/Drawable;

.field private mActivePointerId:I

.field private mAdapterWrapper:Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;

.field private mCheckForLongPress:Lco/vine/android/dragsort/DragSortWidget$CheckForLongPress;

.field private mContentView:Landroid/view/View;

.field private mContentViewBounds:Landroid/graphics/Rect;

.field private mContentViewPickUpAnimator:Lco/vine/android/dragsort/DragSortWidget$ContentViewPickUpAnimator;

.field private mCurrentlyPlayingProvider:Lco/vine/android/dragsort/DragSortWidget$CurrentlyPlayingProvider;

.field private mDownPosition:I

.field private mDragListener:Lco/vine/android/dragsort/DragSortWidget$DragListener;

.field private mDragScroller:Lco/vine/android/dragsort/DragSortWidget$DragScroller;

.field private mDropAnimator:Lco/vine/android/dragsort/DragSortWidget$DropAnimator;

.field mDropping:Z

.field private mFloatBitmap:Landroid/graphics/Bitmap;

.field private mFloatView:Landroid/widget/ImageView;

.field private mFloatViewActivatedDrawable:Landroid/graphics/drawable/Drawable;

.field private mFloatViewAlpha:F

.field private mFloatViewDefaultSize:I

.field private mFloatViewDestroyAnimator:Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;

.field private mFloatViewHeight:I

.field private mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

.field private mFloatViewListPosition:I

.field private mFloatViewWidth:I

.field private mFloatViewX:I

.field private mFloatViewY:I

.field private mFocusedPosition:I

.field private mListView:Lco/vine/android/views/HorizontalListView;

.field private mMaxScrollSpeed:F

.field private mPickingUpContent:Z

.field private mRemoveAnimator:Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;

.field private mRemoveListener:Lco/vine/android/dragsort/DragSortWidget$RemoveListener;

.field private mRemovePosition:I

.field mRemoving:Z

.field private mSelectionChangedListener:Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;

.field private mSelectionPosition:I

.field private mTouchDownX:I

.field private mTouchDownY:I

.field private mTouchListPosition:I

.field private final mTouchSlop:I

.field private mTouchX:I

.field private mTouchY:I

.field private mXOffsetFromTouch:I

.field private mYOffsetFromTouch:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    invoke-static {}, Landroid/view/ViewConfiguration;->getTapTimeout()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    sput v0, Lco/vine/android/dragsort/DragSortWidget;->PICK_UP_DURATION:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 110
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/dragsort/DragSortWidget;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 111
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 114
    sget v0, Lco/vine/android/shared/R$attr;->dragSortWidgetStyle:I

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/dragsort/DragSortWidget;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 115
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/16 v6, 0x64

    const/4 v5, -0x1

    const v4, 0x3d4ccccd    # 0.05f

    const/4 v3, 0x0

    .line 118
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 56
    new-instance v1, Lco/vine/android/dragsort/DragSortWidget$DragScroller;

    invoke-direct {v1, p0}, Lco/vine/android/dragsort/DragSortWidget$DragScroller;-><init>(Lco/vine/android/dragsort/DragSortWidget;)V

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mDragScroller:Lco/vine/android/dragsort/DragSortWidget$DragScroller;

    .line 57
    new-instance v1, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;

    const/16 v2, 0x96

    invoke-direct {v1, p0, v4, v2}, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;-><init>(Lco/vine/android/dragsort/DragSortWidget;FI)V

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mDropAnimator:Lco/vine/android/dragsort/DragSortWidget$DropAnimator;

    .line 58
    new-instance v1, Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;

    invoke-direct {v1, p0, v4, v6}, Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;-><init>(Lco/vine/android/dragsort/DragSortWidget;FI)V

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemoveAnimator:Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;

    .line 59
    new-instance v1, Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;

    invoke-direct {v1, p0, v4, v6}, Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;-><init>(Lco/vine/android/dragsort/DragSortWidget;FI)V

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewDestroyAnimator:Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;

    .line 61
    new-instance v1, Lco/vine/android/dragsort/DragSortWidget$ContentViewPickUpAnimator;

    const/16 v2, 0x82

    invoke-direct {v1, p0, v4, v2}, Lco/vine/android/dragsort/DragSortWidget$ContentViewPickUpAnimator;-><init>(Lco/vine/android/dragsort/DragSortWidget;FI)V

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentViewPickUpAnimator:Lco/vine/android/dragsort/DragSortWidget$ContentViewPickUpAnimator;

    .line 66
    const/4 v1, 0x0

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    .line 90
    iput v5, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    .line 91
    iput v5, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    .line 98
    const/high16 v1, 0x437f0000    # 255.0f

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewAlpha:F

    .line 100
    iput-boolean v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mDropping:Z

    .line 101
    iput-boolean v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemoving:Z

    .line 105
    iput-boolean v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mPickingUpContent:Z

    .line 106
    iput-boolean v3, p0, Lco/vine/android/dragsort/DragSortWidget;->isFromContentView:Z

    .line 119
    sget-object v1, Lco/vine/android/shared/R$styleable;->DragSortWidget:[I

    invoke-virtual {p1, p2, v1, p3, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 120
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mActivatedDrawable:Landroid/graphics/drawable/Drawable;

    .line 121
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewActivatedDrawable:Landroid/graphics/drawable/Drawable;

    .line 122
    const/4 v1, 0x2

    invoke-virtual {v0, v1, v3}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v1

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewDefaultSize:I

    .line 123
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v1

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchSlop:I

    .line 124
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 125
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/views/HorizontalListView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    return v0
.end method

.method static synthetic access$1000(Lco/vine/android/dragsort/DragSortWidget;)F
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewAlpha:F

    return v0
.end method

.method static synthetic access$1002(Lco/vine/android/dragsort/DragSortWidget;F)F
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # F

    .prologue
    .line 36
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewAlpha:F

    return p1
.end method

.method static synthetic access$102(Lco/vine/android/dragsort/DragSortWidget;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # I

    .prologue
    .line 36
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    return p1
.end method

.method static synthetic access$1100(Lco/vine/android/dragsort/DragSortWidget;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->destroyFloatView()V

    return-void
.end method

.method static synthetic access$1200(Lco/vine/android/dragsort/DragSortWidget;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->adjustItems()V

    return-void
.end method

.method static synthetic access$1300(Lco/vine/android/dragsort/DragSortWidget;)Landroid/graphics/Rect;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentViewBounds:Landroid/graphics/Rect;

    return-object v0
.end method

.method static synthetic access$1400(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewWidth:I

    return v0
.end method

.method static synthetic access$1402(Lco/vine/android/dragsort/DragSortWidget;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # I

    .prologue
    .line 36
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewWidth:I

    return p1
.end method

.method static synthetic access$1500(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewHeight:I

    return v0
.end method

.method static synthetic access$1502(Lco/vine/android/dragsort/DragSortWidget;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # I

    .prologue
    .line 36
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewHeight:I

    return p1
.end method

.method static synthetic access$1600(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mXOffsetFromTouch:I

    return v0
.end method

.method static synthetic access$1602(Lco/vine/android/dragsort/DragSortWidget;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # I

    .prologue
    .line 36
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mXOffsetFromTouch:I

    return p1
.end method

.method static synthetic access$1700(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mYOffsetFromTouch:I

    return v0
.end method

.method static synthetic access$1702(Lco/vine/android/dragsort/DragSortWidget;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # I

    .prologue
    .line 36
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mYOffsetFromTouch:I

    return p1
.end method

.method static synthetic access$1800(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    return v0
.end method

.method static synthetic access$1900(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewDefaultSize:I

    return v0
.end method

.method static synthetic access$200(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    return v0
.end method

.method static synthetic access$2002(Lco/vine/android/dragsort/DragSortWidget;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # Z

    .prologue
    .line 36
    iput-boolean p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mPickingUpContent:Z

    return p1
.end method

.method static synthetic access$2100(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemovePosition:I

    return v0
.end method

.method static synthetic access$2102(Lco/vine/android/dragsort/DragSortWidget;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # I

    .prologue
    .line 36
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemovePosition:I

    return p1
.end method

.method static synthetic access$2200(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    return v0
.end method

.method static synthetic access$2300(Lco/vine/android/dragsort/DragSortWidget;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->finishRemoveSelection()V

    return-void
.end method

.method static synthetic access$2400(Lco/vine/android/dragsort/DragSortWidget;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mActivatedDrawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$2500(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFocusedPosition:I

    return v0
.end method

.method static synthetic access$2600(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemoveAnimator:Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;

    return-object v0
.end method

.method static synthetic access$2800(Lco/vine/android/dragsort/DragSortWidget;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$2900(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchListPosition:I

    return v0
.end method

.method static synthetic access$300(Lco/vine/android/dragsort/DragSortWidget;)F
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mMaxScrollSpeed:F

    return v0
.end method

.method static synthetic access$3000(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mDownPosition:I

    return v0
.end method

.method static synthetic access$3100(Lco/vine/android/dragsort/DragSortWidget;IZ)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # I
    .param p2, "x2"    # Z

    .prologue
    .line 36
    invoke-direct {p0, p1, p2}, Lco/vine/android/dragsort/DragSortWidget;->handleClick(IZ)Z

    move-result v0

    return v0
.end method

.method static synthetic access$3200(Lco/vine/android/dragsort/DragSortWidget;I)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # I

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lco/vine/android/dragsort/DragSortWidget;->pickUpView(I)Z

    move-result v0

    return v0
.end method

.method static synthetic access$400(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->getClosestItemPosition()I

    move-result v0

    return v0
.end method

.method static synthetic access$500(Lco/vine/android/dragsort/DragSortWidget;II)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # I
    .param p2, "x2"    # I

    .prologue
    .line 36
    invoke-direct {p0, p1, p2}, Lco/vine/android/dragsort/DragSortWidget;->dragFloatView(II)V

    return-void
.end method

.method static synthetic access$600(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewDestroyAnimator:Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    return v0
.end method

.method static synthetic access$702(Lco/vine/android/dragsort/DragSortWidget;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # I

    .prologue
    .line 36
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    return p1
.end method

.method static synthetic access$800(Lco/vine/android/dragsort/DragSortWidget;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    return v0
.end method

.method static synthetic access$802(Lco/vine/android/dragsort/DragSortWidget;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;
    .param p1, "x1"    # I

    .prologue
    .line 36
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    return p1
.end method

.method static synthetic access$900(Lco/vine/android/dragsort/DragSortWidget;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/dragsort/DragSortWidget;

    .prologue
    .line 36
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->finishDrop()V

    return-void
.end method

.method private adjustItem(I)V
    .locals 5
    .param p1, "position"    # I

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 433
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v2

    sub-int v2, p1, v2

    invoke-virtual {v1, v2}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 434
    .local v0, "childView":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 435
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-eqz v1, :cond_1

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    if-ne p1, v1, :cond_1

    .line 436
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 437
    invoke-virtual {v0, v4}, Landroid/view/View;->setActivated(Z)V

    .line 445
    :goto_0
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFocusedPosition:I

    if-ne p1, v1, :cond_3

    const/high16 v1, 0x3f800000    # 1.0f

    :goto_1
    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 446
    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 448
    :cond_0
    return-void

    .line 438
    :cond_1
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    if-ne p1, v1, :cond_2

    .line 439
    invoke-virtual {v0, v4}, Landroid/view/View;->setActivated(Z)V

    .line 440
    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 442
    :cond_2
    invoke-virtual {v0, v3}, Landroid/view/View;->setActivated(Z)V

    .line 443
    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 445
    :cond_3
    const v1, 0x3e99999a    # 0.3f

    goto :goto_1
.end method

.method private adjustItems()V
    .locals 2

    .prologue
    .line 427
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 428
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v1

    add-int/2addr v1, v0

    invoke-direct {p0, v1}, Lco/vine/android/dragsort/DragSortWidget;->adjustItem(I)V

    .line 427
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 430
    :cond_0
    return-void
.end method

.method private createFloatView(I)V
    .locals 5
    .param p1, "position"    # I

    .prologue
    .line 509
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v2

    sub-int v2, p1, v2

    invoke-virtual {v1, v2}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 511
    .local v0, "v":Landroid/view/View;
    if-nez v0, :cond_1

    .line 545
    :cond_0
    :goto_0
    return-void

    .line 516
    :cond_1
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownX:I

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v2

    if-lt v1, v2, :cond_0

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownY:I

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getTop()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v2

    if-lt v1, v2, :cond_0

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownX:I

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v2

    if-gt v1, v2, :cond_0

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownY:I

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getTop()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {v0}, Landroid/view/View;->getBottom()I

    move-result v2

    if-gt v1, v2, :cond_0

    .line 523
    const/high16 v1, 0x100000

    invoke-virtual {v0, v1}, Landroid/view/View;->setDrawingCacheQuality(I)V

    .line 524
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setDrawingCacheEnabled(Z)V

    .line 525
    invoke-virtual {v0}, Landroid/view/View;->getDrawingCache()Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-static {v1}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatBitmap:Landroid/graphics/Bitmap;

    .line 526
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setDrawingCacheEnabled(Z)V

    .line 528
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-nez v1, :cond_2

    .line 529
    new-instance v1, Landroid/widget/ImageView;

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    .line 531
    :cond_2
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 532
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v3

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v4

    invoke-direct {v2, v3, v4}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 533
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownX:I

    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v2

    iget-object v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v3}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v3

    add-int/2addr v2, v3

    sub-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mXOffsetFromTouch:I

    .line 534
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownY:I

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v2

    iget-object v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v3}, Lco/vine/android/views/HorizontalListView;->getTop()I

    move-result v3

    add-int/2addr v2, v3

    sub-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mYOffsetFromTouch:I

    .line 536
    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v1

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewWidth:I

    .line 537
    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v1

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewHeight:I

    .line 539
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mXOffsetFromTouch:I

    sub-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    .line 540
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mYOffsetFromTouch:I

    sub-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    .line 542
    const/high16 v1, 0x437f0000    # 255.0f

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewAlpha:F

    .line 544
    invoke-direct {p0, p1}, Lco/vine/android/dragsort/DragSortWidget;->adjustItem(I)V

    goto/16 :goto_0
.end method

.method private createFloatViewFromContentView()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 548
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    .line 549
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    iget-object v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v3}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual {v1, v2}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 550
    .local v0, "v":Landroid/view/View;
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentViewPickUpAnimator:Lco/vine/android/dragsort/DragSortWidget$ContentViewPickUpAnimator;

    invoke-virtual {v1}, Lco/vine/android/dragsort/DragSortWidget$ContentViewPickUpAnimator;->start()V

    .line 552
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentViewBounds:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->left:I

    sub-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mXOffsetFromTouch:I

    .line 553
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentViewBounds:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->top:I

    sub-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mYOffsetFromTouch:I

    .line 555
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mXOffsetFromTouch:I

    sub-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    .line 556
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mYOffsetFromTouch:I

    sub-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    .line 558
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentViewBounds:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v1

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewWidth:I

    .line 559
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentViewBounds:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v1

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewHeight:I

    .line 561
    const/high16 v1, 0x437f0000    # 255.0f

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewAlpha:F

    .line 562
    if-nez v0, :cond_0

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    if-ltz v1, :cond_0

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v2

    invoke-interface {v2}, Landroid/widget/ListAdapter;->getCount()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 563
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v1

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    invoke-interface {v1, v2, v4, v4}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 565
    :cond_0
    check-cast v0, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;

    .end local v0    # "v":Landroid/view/View;
    invoke-virtual {v0}, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatBitmap:Landroid/graphics/Bitmap;

    .line 567
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-nez v1, :cond_1

    .line 568
    new-instance v1, Landroid/widget/ImageView;

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    .line 571
    :cond_1
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 572
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    iget v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewWidth:I

    iget v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewHeight:I

    invoke-direct {v2, v3, v4}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 574
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    invoke-direct {p0, v1}, Lco/vine/android/dragsort/DragSortWidget;->adjustItem(I)V

    .line 575
    return-void
.end method

.method private destroyFloatView()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 578
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 579
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 580
    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatBitmap:Landroid/graphics/Bitmap;

    .line 581
    iput-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    .line 583
    :cond_0
    return-void
.end method

.method private dragFloatView(II)V
    .locals 4
    .param p1, "oldFloatViewPosition"    # I
    .param p2, "newFloatViewPosition"    # I

    .prologue
    const/4 v1, -0x1

    .line 318
    if-le p1, v1, :cond_1

    if-le p2, v1, :cond_1

    if-eq p1, p2, :cond_1

    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->floatViewIntersectsList()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 320
    iput p2, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    .line 321
    invoke-direct {p0, p1, p2}, Lco/vine/android/dragsort/DragSortWidget;->finishSwap(II)V

    .line 332
    :cond_0
    :goto_0
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->handleDragScroll()V

    .line 333
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    .line 334
    return-void

    .line 322
    :cond_1
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->floatViewIntersectsList()Z

    move-result v1

    if-eqz v1, :cond_2

    if-ne p1, p2, :cond_2

    .line 323
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getLastVisiblePosition()I

    move-result v2

    iget-object v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v3}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual {v1, v2}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 325
    .local v0, "last":Landroid/view/View;
    if-eqz v0, :cond_0

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v2

    if-le v1, v2, :cond_0

    .line 326
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getLastVisiblePosition()I

    move-result v1

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    .line 327
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    invoke-direct {p0, p1, v1}, Lco/vine/android/dragsort/DragSortWidget;->finishSwap(II)V

    goto :goto_0

    .line 330
    .end local v0    # "last":Landroid/view/View;
    :cond_2
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    goto :goto_0
.end method

.method private finishDrop()V
    .locals 2

    .prologue
    .line 372
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mDropping:Z

    .line 373
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    if-eqz v0, :cond_0

    .line 374
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    invoke-interface {v0, v1}, Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;->floatViewLanded(I)V

    .line 376
    :cond_0
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->destroyFloatView()V

    .line 377
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->adjustItems()V

    .line 378
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    .line 379
    return-void
.end method

.method private finishRemoveSelection()V
    .locals 3

    .prologue
    const/4 v2, -0x1

    .line 382
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemovePosition:I

    if-eq v0, v2, :cond_1

    .line 383
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemoveListener:Lco/vine/android/dragsort/DragSortWidget$RemoveListener;

    if-eqz v0, :cond_0

    .line 384
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemoveListener:Lco/vine/android/dragsort/DragSortWidget$RemoveListener;

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemovePosition:I

    invoke-interface {v0, v1}, Lco/vine/android/dragsort/DragSortWidget$RemoveListener;->remove(I)V

    .line 386
    :cond_0
    iput v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemovePosition:I

    .line 387
    iput v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    .line 388
    iput v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mFocusedPosition:I

    .line 389
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionChangedListener:Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;

    if-eqz v0, :cond_1

    .line 390
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionChangedListener:Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;->onSelectionChanged(IZ)V

    .line 393
    :cond_1
    return-void
.end method

.method private finishSwap(II)V
    .locals 3
    .param p1, "oldFloatViewPosition"    # I
    .param p2, "newFloatViewPosition"    # I

    .prologue
    .line 400
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mDragListener:Lco/vine/android/dragsort/DragSortWidget$DragListener;

    if-eqz v1, :cond_3

    .line 401
    if-ge p1, p2, :cond_1

    .line 403
    move v0, p1

    .local v0, "i":I
    :goto_0
    if-ge v0, p2, :cond_3

    .line 404
    if-ltz v0, :cond_0

    .line 405
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mDragListener:Lco/vine/android/dragsort/DragSortWidget$DragListener;

    add-int/lit8 v2, v0, 0x1

    invoke-interface {v1, v0, v2}, Lco/vine/android/dragsort/DragSortWidget$DragListener;->drag(II)V

    .line 406
    add-int/lit8 v1, v0, 0x1

    invoke-direct {p0, v0, v1}, Lco/vine/android/dragsort/DragSortWidget;->triggerSwapAnimation(II)V

    .line 403
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 411
    .end local v0    # "i":I
    :cond_1
    move v0, p1

    .restart local v0    # "i":I
    :goto_1
    if-le v0, p2, :cond_3

    .line 412
    const/4 v1, 0x1

    if-lt v0, v1, :cond_2

    .line 413
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mDragListener:Lco/vine/android/dragsort/DragSortWidget$DragListener;

    add-int/lit8 v2, v0, -0x1

    invoke-interface {v1, v0, v2}, Lco/vine/android/dragsort/DragSortWidget$DragListener;->drag(II)V

    .line 414
    add-int/lit8 v1, v0, -0x1

    invoke-direct {p0, v0, v1}, Lco/vine/android/dragsort/DragSortWidget;->triggerSwapAnimation(II)V

    .line 411
    :cond_2
    add-int/lit8 v0, v0, -0x1

    goto :goto_1

    .line 419
    .end local v0    # "i":I
    :cond_3
    const/4 v1, -0x1

    if-eq p2, v1, :cond_4

    .line 420
    iput p2, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    .line 421
    iput p2, p0, Lco/vine/android/dragsort/DragSortWidget;->mFocusedPosition:I

    .line 423
    :cond_4
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->adjustItems()V

    .line 424
    return-void
.end method

.method private floatViewIntersectsList()Z
    .locals 2

    .prologue
    .line 313
    iget-boolean v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mPickingUpContent:Z

    if-nez v0, :cond_0

    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getRight()I

    move-result v1

    if-gt v0, v1, :cond_0

    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getBottom()I

    move-result v1

    if-gt v0, v1, :cond_0

    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewWidth:I

    add-int/2addr v0, v1

    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v1

    if-lt v0, v1, :cond_0

    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewHeight:I

    add-int/2addr v0, v1

    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getTop()I

    move-result v1

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getClosestItemPosition()I
    .locals 3

    .prologue
    .line 455
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 456
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v2

    sub-int/2addr v1, v2

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2, v0}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getRight()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 457
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v1

    add-int/2addr v1, v0

    .line 460
    :goto_1
    return v1

    .line 455
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 460
    :cond_1
    const/4 v1, -0x1

    goto :goto_1
.end method

.method private handleClick(IZ)Z
    .locals 7
    .param p1, "position"    # I
    .param p2, "listViewClick"    # Z

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v6, -0x1

    .line 623
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    iget-object v5, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v5}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v5

    sub-int v5, p1, v5

    invoke-virtual {v4, v5}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 624
    .local v1, "view":Landroid/view/View;
    if-eqz v1, :cond_3

    .line 625
    iget v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    if-ne v4, p1, :cond_1

    .line 627
    invoke-virtual {v1, v3}, Landroid/view/View;->setActivated(Z)V

    .line 628
    iput v6, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    .line 629
    iput v6, p0, Lco/vine/android/dragsort/DragSortWidget;->mFocusedPosition:I

    .line 645
    :goto_0
    iget-object v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionChangedListener:Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;

    if-eqz v3, :cond_0

    .line 646
    iget-object v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionChangedListener:Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;

    iget v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    invoke-interface {v3, v4, p2}, Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;->onSelectionChanged(IZ)V

    .line 648
    :cond_0
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->adjustItems()V

    .line 649
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    .line 652
    :goto_1
    return v2

    .line 632
    :cond_1
    invoke-virtual {v1, v2}, Landroid/view/View;->setActivated(Z)V

    .line 635
    iget v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    if-eq v4, v6, :cond_2

    .line 636
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    iget v5, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    iget-object v6, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v6}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v6

    sub-int/2addr v5, v6

    invoke-virtual {v4, v5}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 638
    .local v0, "oldChild":Landroid/view/View;
    if-eqz v0, :cond_2

    .line 639
    invoke-virtual {v0, v3}, Landroid/view/View;->setActivated(Z)V

    .line 642
    .end local v0    # "oldChild":Landroid/view/View;
    :cond_2
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    .line 643
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFocusedPosition:I

    goto :goto_0

    :cond_3
    move v2, v3

    .line 652
    goto :goto_1
.end method

.method private handleContentViewTouch(Landroid/view/MotionEvent;)Z
    .locals 11
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v10, -0x1

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 237
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v8

    and-int/lit16 v0, v8, 0xff

    .line 238
    .local v0, "action":I
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->getClosestItemPosition()I

    move-result v8

    iput v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchListPosition:I

    .line 240
    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    move v6, v7

    .line 291
    :goto_1
    return v6

    .line 242
    :pswitch_0
    iget v6, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iput v6, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownX:I

    .line 243
    iget v6, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iput v6, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownY:I

    .line 244
    invoke-virtual {p1, v7}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v6

    iput v6, p0, Lco/vine/android/dragsort/DragSortWidget;->mActivePointerId:I

    .line 245
    iget v6, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    iput v6, p0, Lco/vine/android/dragsort/DragSortWidget;->mDownPosition:I

    goto :goto_0

    .line 248
    :pswitch_1
    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownX:I

    sub-int/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Math;->abs(I)I

    move-result v3

    .line 249
    .local v3, "deltaX":I
    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownY:I

    sub-int/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Math;->abs(I)I

    move-result v4

    .line 250
    .local v4, "deltaY":I
    iget v5, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    .line 251
    .local v5, "oldHoverPosition":I
    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchListPosition:I

    if-eq v8, v10, :cond_1

    .line 252
    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchListPosition:I

    iput v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    .line 254
    :cond_1
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    if-eqz v8, :cond_3

    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    invoke-interface {v8}, Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;->canPickUpFloatView()Z

    move-result v8

    if-eqz v8, :cond_3

    move v2, v6

    .line 256
    .local v2, "canPickupFloatView":Z
    :goto_2
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    if-eqz v8, :cond_4

    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v8}, Lco/vine/android/views/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v1

    .line 257
    .local v1, "adapter":Landroid/widget/ListAdapter;
    :goto_3
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentView:Landroid/view/View;

    if-eqz v8, :cond_5

    if-eqz v1, :cond_5

    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v8

    if-lez v8, :cond_5

    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchSlop:I

    if-ge v4, v8, :cond_2

    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchSlop:I

    if-lt v3, v8, :cond_5

    :cond_2
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-nez v8, :cond_5

    if-eqz v2, :cond_5

    .line 259
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->pickUpContentView()Z

    goto :goto_1

    .end local v1    # "adapter":Landroid/widget/ListAdapter;
    .end local v2    # "canPickupFloatView":Z
    :cond_3
    move v2, v7

    .line 254
    goto :goto_2

    .line 256
    .restart local v2    # "canPickupFloatView":Z
    :cond_4
    const/4 v1, 0x0

    goto :goto_3

    .line 261
    .restart local v1    # "adapter":Landroid/widget/ListAdapter;
    :cond_5
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-eqz v8, :cond_7

    iget-boolean v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mDropping:Z

    if-nez v8, :cond_7

    .line 262
    iget v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mXOffsetFromTouch:I

    sub-int/2addr v7, v8

    iput v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    .line 263
    iget v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mYOffsetFromTouch:I

    sub-int/2addr v7, v8

    iput v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    .line 264
    iget-object v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    if-eqz v7, :cond_6

    .line 265
    iget-object v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    invoke-interface {v7}, Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;->floatViewMoved()V

    .line 267
    :cond_6
    iget v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    invoke-direct {p0, v5, v7}, Lco/vine/android/dragsort/DragSortWidget;->dragFloatView(II)V

    goto/16 :goto_1

    .line 270
    :cond_7
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    goto/16 :goto_0

    .line 273
    .end local v1    # "adapter":Landroid/widget/ListAdapter;
    .end local v2    # "canPickupFloatView":Z
    .end local v3    # "deltaX":I
    .end local v4    # "deltaY":I
    .end local v5    # "oldHoverPosition":I
    :pswitch_2
    iput v10, p0, Lco/vine/android/dragsort/DragSortWidget;->mDownPosition:I

    .line 274
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mCheckForLongPress:Lco/vine/android/dragsort/DragSortWidget$CheckForLongPress;

    invoke-virtual {p0, v8}, Lco/vine/android/dragsort/DragSortWidget;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 275
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-eqz v8, :cond_0

    iget-boolean v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mDropping:Z

    if-nez v8, :cond_0

    .line 276
    iget-object v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    if-eqz v7, :cond_8

    iget-object v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    invoke-interface {v7, v8}, Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;->floatViewDropped(I)Z

    move-result v7

    if-eqz v7, :cond_8

    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->canDelete()Z

    move-result v7

    if-eqz v7, :cond_8

    .line 280
    iget-object v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewDestroyAnimator:Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;

    invoke-virtual {v7}, Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;->start()V

    .line 281
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->removeSelection()V

    .line 285
    :goto_4
    iget-object v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mDragScroller:Lco/vine/android/dragsort/DragSortWidget$DragScroller;

    invoke-virtual {v7, v6}, Lco/vine/android/dragsort/DragSortWidget$DragScroller;->stopScrolling(Z)V

    .line 286
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    goto/16 :goto_1

    .line 283
    :cond_8
    iget-object v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mDropAnimator:Lco/vine/android/dragsort/DragSortWidget$DropAnimator;

    invoke-virtual {v7}, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->start()V

    goto :goto_4

    .line 240
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private handleDragScroll()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const v3, 0x3ea8f5c3    # 0.33f

    .line 464
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->floatViewIntersectsList()Z

    move-result v0

    .line 465
    .local v0, "intersectsList":Z
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v2

    sub-int/2addr v1, v2

    int-to-float v1, v1

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getWidth()I

    move-result v2

    mul-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-lez v1, :cond_0

    if-eqz v0, :cond_0

    .line 467
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mDragScroller:Lco/vine/android/dragsort/DragSortWidget$DragScroller;

    invoke-virtual {v1, v4}, Lco/vine/android/dragsort/DragSortWidget$DragScroller;->startScrolling(I)V

    .line 474
    :goto_0
    return-void

    .line 468
    :cond_0
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v2

    sub-int/2addr v1, v2

    int-to-float v1, v1

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getWidth()I

    move-result v2

    int-to-float v2, v2

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gez v1, :cond_1

    if-eqz v0, :cond_1

    .line 470
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mDragScroller:Lco/vine/android/dragsort/DragSortWidget$DragScroller;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lco/vine/android/dragsort/DragSortWidget$DragScroller;->startScrolling(I)V

    goto :goto_0

    .line 472
    :cond_1
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mDragScroller:Lco/vine/android/dragsort/DragSortWidget$DragScroller;

    invoke-virtual {v1, v4}, Lco/vine/android/dragsort/DragSortWidget$DragScroller;->stopScrolling(Z)V

    goto :goto_0
.end method

.method private handleListViewTouch(Landroid/view/MotionEvent;)Z
    .locals 12
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v11, -0x1

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 161
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v9

    and-int/lit16 v0, v9, 0xff

    .line 162
    .local v0, "action":I
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->getClosestItemPosition()I

    move-result v9

    iput v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchListPosition:I

    .line 164
    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    :pswitch_0
    move v7, v8

    .line 229
    :goto_1
    return v7

    .line 166
    :pswitch_1
    iget v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iput v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownX:I

    .line 167
    iget v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iput v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownY:I

    .line 168
    invoke-virtual {p1, v8}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v7

    iput v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mActivePointerId:I

    .line 169
    iget v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchListPosition:I

    iput v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mDownPosition:I

    .line 170
    iget-object v7, p0, Lco/vine/android/dragsort/DragSortWidget;->mCheckForLongPress:Lco/vine/android/dragsort/DragSortWidget$CheckForLongPress;

    sget v9, Lco/vine/android/dragsort/DragSortWidget;->PICK_UP_DURATION:I

    int-to-long v9, v9

    invoke-virtual {p0, v7, v9, v10}, Lco/vine/android/dragsort/DragSortWidget;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 173
    :pswitch_2
    iget v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    .line 174
    .local v4, "oldHoverPosition":I
    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchListPosition:I

    if-eq v9, v11, :cond_1

    .line 175
    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchListPosition:I

    iput v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    .line 177
    :cond_1
    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iget v10, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownY:I

    sub-int/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Math;->abs(I)I

    move-result v3

    .line 178
    .local v3, "deltaY":I
    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget v10, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownX:I

    sub-int/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Math;->abs(I)I

    move-result v2

    .line 179
    .local v2, "deltaX":I
    iget-object v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    if-eqz v9, :cond_4

    iget-object v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    invoke-interface {v9}, Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;->canPickUpFloatView()Z

    move-result v9

    if-eqz v9, :cond_4

    move v1, v7

    .line 181
    .local v1, "canPickupFloatView":Z
    :goto_2
    iget-object v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-nez v9, :cond_2

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchSlop:I

    if-ge v2, v9, :cond_2

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchSlop:I

    if-lt v3, v9, :cond_2

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iget v10, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchDownY:I

    sub-int/2addr v9, v10

    if-gez v9, :cond_2

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    iget v10, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchListPosition:I

    if-eq v9, v10, :cond_2

    if-eqz v1, :cond_2

    .line 184
    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchListPosition:I

    invoke-direct {p0, v9, v8}, Lco/vine/android/dragsort/DragSortWidget;->handleClick(IZ)Z

    .line 186
    :cond_2
    iget-object v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-nez v9, :cond_5

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchSlop:I

    if-ge v2, v9, :cond_3

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchSlop:I

    if-lt v3, v9, :cond_5

    .line 188
    :cond_3
    iget-object v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mCheckForLongPress:Lco/vine/android/dragsort/DragSortWidget$CheckForLongPress;

    invoke-virtual {p0, v9}, Lco/vine/android/dragsort/DragSortWidget;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 189
    if-eqz v1, :cond_0

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    invoke-direct {p0, v9}, Lco/vine/android/dragsort/DragSortWidget;->pickUpView(I)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 190
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    goto/16 :goto_1

    .end local v1    # "canPickupFloatView":Z
    :cond_4
    move v1, v8

    .line 179
    goto :goto_2

    .line 193
    .restart local v1    # "canPickupFloatView":Z
    :cond_5
    iget-object v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-eqz v9, :cond_0

    iget-boolean v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mDropping:Z

    if-nez v9, :cond_0

    .line 194
    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mXOffsetFromTouch:I

    sub-int/2addr v8, v9

    iput v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    .line 195
    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mYOffsetFromTouch:I

    sub-int/2addr v8, v9

    iput v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    .line 196
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    if-eqz v8, :cond_6

    .line 197
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    invoke-interface {v8}, Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;->floatViewMoved()V

    .line 199
    :cond_6
    iget v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    invoke-direct {p0, v4, v8}, Lco/vine/android/dragsort/DragSortWidget;->dragFloatView(II)V

    goto/16 :goto_1

    .line 204
    .end local v1    # "canPickupFloatView":Z
    .end local v2    # "deltaX":I
    .end local v3    # "deltaY":I
    .end local v4    # "oldHoverPosition":I
    :pswitch_3
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v9

    const v10, 0xff00

    and-int/2addr v9, v10

    shr-int/lit8 v6, v9, 0x8

    .line 206
    .local v6, "pointerIndex":I
    invoke-virtual {p1, v6}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v5

    .line 207
    .local v5, "pointerId":I
    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mActivePointerId:I

    if-ne v5, v9, :cond_0

    .line 211
    .end local v5    # "pointerId":I
    .end local v6    # "pointerIndex":I
    :pswitch_4
    iput v11, p0, Lco/vine/android/dragsort/DragSortWidget;->mDownPosition:I

    .line 212
    iget-object v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mCheckForLongPress:Lco/vine/android/dragsort/DragSortWidget$CheckForLongPress;

    invoke-virtual {p0, v9}, Lco/vine/android/dragsort/DragSortWidget;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 213
    iget-object v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-eqz v9, :cond_0

    iget-boolean v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mDropping:Z

    if-nez v9, :cond_0

    .line 214
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    if-eqz v8, :cond_7

    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    iget v9, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    invoke-interface {v8, v9}, Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;->floatViewDropped(I)Z

    move-result v8

    if-eqz v8, :cond_7

    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->canDelete()Z

    move-result v8

    if-eqz v8, :cond_7

    .line 218
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewDestroyAnimator:Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;

    invoke-virtual {v8}, Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;->start()V

    .line 219
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->removeSelection()V

    .line 223
    :goto_3
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mDragScroller:Lco/vine/android/dragsort/DragSortWidget$DragScroller;

    invoke-virtual {v8, v7}, Lco/vine/android/dragsort/DragSortWidget$DragScroller;->stopScrolling(Z)V

    .line 224
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    goto/16 :goto_1

    .line 221
    :cond_7
    iget-object v8, p0, Lco/vine/android/dragsort/DragSortWidget;->mDropAnimator:Lco/vine/android/dragsort/DragSortWidget$DropAnimator;

    invoke-virtual {v8}, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->start()V

    goto :goto_3

    .line 164
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_4
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method private pickUpContentView()Z
    .locals 3

    .prologue
    .line 598
    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 599
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mCurrentlyPlayingProvider:Lco/vine/android/dragsort/DragSortWidget$CurrentlyPlayingProvider;

    invoke-interface {v1}, Lco/vine/android/dragsort/DragSortWidget$CurrentlyPlayingProvider;->getCurrentlyPlayingPosition()I

    move-result v0

    .line 600
    .local v0, "position":I
    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lco/vine/android/dragsort/DragSortWidget;->handleClick(IZ)Z

    .line 601
    iput v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    .line 602
    iput v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    .line 604
    .end local v0    # "position":I
    :cond_0
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->createFloatViewFromContentView()V

    .line 605
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    if-eqz v1, :cond_1

    .line 606
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    invoke-interface {v1, v2}, Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;->floatViewPickedUp(I)V

    .line 608
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    .line 609
    const/4 v1, 0x1

    return v1
.end method

.method private pickUpView(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 586
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    if-ne p1, v0, :cond_1

    const/4 v0, -0x1

    if-eq p1, v0, :cond_1

    .line 587
    invoke-direct {p0, p1}, Lco/vine/android/dragsort/DragSortWidget;->createFloatView(I)V

    .line 588
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    if-eqz v0, :cond_0

    .line 589
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    invoke-interface {v0, p1}, Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;->floatViewPickedUp(I)V

    .line 591
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    .line 592
    const/4 v0, 0x1

    .line 594
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private triggerSwapAnimation(II)V
    .locals 5
    .param p1, "to"    # I
    .param p2, "from"    # I

    .prologue
    .line 337
    iget-object v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v4}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v4

    sub-int v4, p2, v4

    invoke-virtual {v3, v4}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 339
    .local v1, "oldSwapView":Landroid/view/View;
    if-nez v1, :cond_0

    const/4 v2, 0x0

    .line 341
    .local v2, "swapViewStartLeft":I
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 342
    .local v0, "observer":Landroid/view/ViewTreeObserver;
    new-instance v3, Lco/vine/android/dragsort/DragSortWidget$1;

    invoke-direct {v3, p0, v0, p1, v2}, Lco/vine/android/dragsort/DragSortWidget$1;-><init>(Lco/vine/android/dragsort/DragSortWidget;Landroid/view/ViewTreeObserver;II)V

    invoke-virtual {v0, v3}, Landroid/view/ViewTreeObserver;->addOnPreDrawListener(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V

    .line 369
    return-void

    .line 339
    .end local v0    # "observer":Landroid/view/ViewTreeObserver;
    .end local v2    # "swapViewStartLeft":I
    :cond_0
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v2

    goto :goto_0
.end method


# virtual methods
.method public canDelete()Z
    .locals 1

    .prologue
    .line 233
    iget-boolean v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mPickingUpContent:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public cleanUp()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, -0x1

    .line 1224
    iput v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    .line 1225
    iput v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFocusedPosition:I

    .line 1226
    iput v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemovePosition:I

    .line 1227
    iput-boolean v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mDropping:Z

    .line 1228
    iput-boolean v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemoving:Z

    .line 1229
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->destroyFloatView()V

    .line 1230
    return-void
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 9
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v1, 0x0

    const/4 v8, 0x0

    .line 478
    invoke-super {p0, p1}, Landroid/widget/RelativeLayout;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 480
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-eqz v0, :cond_1

    .line 481
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 482
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    int-to-float v0, v0

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    int-to-float v2, v2

    invoke-virtual {p1, v0, v2}, Landroid/graphics/Canvas;->translate(FF)V

    .line 483
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewWidth:I

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewHeight:I

    invoke-virtual {p1, v8, v8, v0, v2}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    .line 484
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewWidth:I

    int-to-float v3, v0

    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewHeight:I

    int-to-float v4, v0

    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewAlpha:F

    float-to-int v5, v0

    const/16 v6, 0x1f

    move-object v0, p1

    move v2, v1

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Canvas;->saveLayerAlpha(FFFFII)I

    .line 486
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewWidth:I

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewHeight:I

    invoke-virtual {v0, v8, v8, v1, v2}, Landroid/widget/ImageView;->layout(IIII)V

    .line 487
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->draw(Landroid/graphics/Canvas;)V

    .line 488
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 489
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 490
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewActivatedDrawable:Landroid/graphics/drawable/Drawable;

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    iget v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    iget v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewWidth:I

    add-int/2addr v3, v4

    iget v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    iget v5, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewHeight:I

    add-int/2addr v4, v5

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 492
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewActivatedDrawable:Landroid/graphics/drawable/Drawable;

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewAlpha:F

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 493
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewActivatedDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 506
    :cond_0
    :goto_0
    return-void

    .line 495
    :cond_1
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 496
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {v0, v1}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    .line 497
    .local v7, "selection":Landroid/view/View;
    if-eqz v7, :cond_0

    iget-boolean v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemoving:Z

    if-nez v0, :cond_0

    .line 498
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mActivatedDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v7}, Landroid/view/View;->getLeft()I

    move-result v1

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v2

    add-int/2addr v1, v2

    invoke-virtual {v7}, Landroid/view/View;->getTop()I

    move-result v2

    iget-object v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v3}, Lco/vine/android/views/HorizontalListView;->getTop()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {v7}, Landroid/view/View;->getRight()I

    move-result v3

    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v4}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v4

    add-int/2addr v3, v4

    invoke-virtual {v7}, Landroid/view/View;->getBottom()I

    move-result v4

    iget-object v5, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v5}, Lco/vine/android/views/HorizontalListView;->getTop()I

    move-result v5

    add-int/2addr v4, v5

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 502
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mActivatedDrawable:Landroid/graphics/drawable/Drawable;

    const/16 v1, 0xff

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 503
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mActivatedDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_0
.end method

.method public floatViewIsFromContentView()Z
    .locals 1

    .prologue
    .line 1233
    iget-boolean v0, p0, Lco/vine/android/dragsort/DragSortWidget;->isFromContentView:Z

    return v0
.end method

.method public getFloatViewBounds()Landroid/graphics/Rect;
    .locals 6

    .prologue
    .line 670
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 671
    new-instance v0, Landroid/graphics/Rect;

    iget v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    iget v3, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I

    iget v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewWidth:I

    add-int/2addr v3, v4

    iget v4, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I

    iget v5, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewHeight:I

    add-int/2addr v4, v5

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 674
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasFloatView()Z
    .locals 1

    .prologue
    .line 656
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onFinishInflate()V
    .locals 2

    .prologue
    .line 129
    const v0, 0x102000a

    invoke-virtual {p0, v0}, Lco/vine/android/dragsort/DragSortWidget;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/views/HorizontalListView;

    iput-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    .line 130
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v0, p0}, Lco/vine/android/views/HorizontalListView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 131
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v0, p0}, Lco/vine/android/views/HorizontalListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 132
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/views/HorizontalListView;->setFingerScrollEnabled(Z)V

    .line 133
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v0, p0}, Lco/vine/android/views/HorizontalListView;->setOnScrollListener(Lco/vine/android/dragsort/DragSortWidget;)V

    .line 134
    new-instance v0, Lco/vine/android/dragsort/DragSortWidget$CheckForLongPress;

    invoke-direct {v0, p0}, Lco/vine/android/dragsort/DragSortWidget$CheckForLongPress;-><init>(Lco/vine/android/dragsort/DragSortWidget;)V

    iput-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mCheckForLongPress:Lco/vine/android/dragsort/DragSortWidget$CheckForLongPress;

    .line 135
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->xdpi:F

    const v1, 0x3dcccccd    # 0.1f

    mul-float/2addr v0, v1

    iput v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mMaxScrollSpeed:F

    .line 136
    return-void
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 663
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v1

    sub-int/2addr v0, v1

    if-ltz v0, :cond_0

    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v1

    sub-int/2addr v0, v1

    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getWidth()I

    move-result v1

    if-ge v0, v1, :cond_0

    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getTop()I

    move-result v1

    sub-int/2addr v0, v1

    if-ltz v0, :cond_0

    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getTop()I

    move-result v1

    sub-int/2addr v0, v1

    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1}, Lco/vine/android/views/HorizontalListView;->getHeight()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 665
    const/4 v0, 0x1

    invoke-direct {p0, p3, v0}, Lco/vine/android/dragsort/DragSortWidget;->handleClick(IZ)Z

    .line 667
    :cond_0
    return-void
.end method

.method public onScroll()V
    .locals 1

    .prologue
    .line 679
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    .line 680
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mCheckForLongPress:Lco/vine/android/dragsort/DragSortWidget$CheckForLongPress;

    invoke-virtual {p0, v0}, Lco/vine/android/dragsort/DragSortWidget;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 681
    return-void
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v0, 0x0

    .line 309
    invoke-virtual {p0, p1, p2, v0, v0}, Lco/vine/android/dragsort/DragSortWidget;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;II)Z

    move-result v0

    return v0
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;II)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;
    .param p3, "xOffset"    # I
    .param p4, "yOffset"    # I

    .prologue
    const/4 v0, 0x0

    .line 295
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {p1}, Landroid/view/View;->getLeft()I

    move-result v2

    add-int/2addr v1, v2

    add-int/2addr v1, p3

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchX:I

    .line 296
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {p1}, Landroid/view/View;->getTop()I

    move-result v2

    add-int/2addr v1, v2

    add-int/2addr v1, p4

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mTouchY:I

    .line 297
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    if-ne p1, v1, :cond_1

    .line 298
    iput-boolean v0, p0, Lco/vine/android/dragsort/DragSortWidget;->isFromContentView:Z

    .line 299
    invoke-direct {p0, p2}, Lco/vine/android/dragsort/DragSortWidget;->handleListViewTouch(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 304
    :cond_0
    :goto_0
    return v0

    .line 300
    :cond_1
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentView:Landroid/view/View;

    if-ne p1, v1, :cond_0

    .line 301
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/dragsort/DragSortWidget;->isFromContentView:Z

    .line 302
    invoke-direct {p0, p2}, Lco/vine/android/dragsort/DragSortWidget;->handleContentViewTouch(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public releaseReferences()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 617
    invoke-virtual {p0, v0}, Lco/vine/android/dragsort/DragSortWidget;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 618
    iput-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mCurrentlyPlayingProvider:Lco/vine/android/dragsort/DragSortWidget$CurrentlyPlayingProvider;

    .line 619
    iput-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentView:Landroid/view/View;

    .line 620
    return-void
.end method

.method public removeSelection()V
    .locals 1

    .prologue
    .line 396
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemoveAnimator:Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;

    invoke-virtual {v0}, Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;->start()V

    .line 397
    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 2
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    const/4 v1, 0x0

    .line 984
    if-eqz p1, :cond_6

    .line 985
    instance-of v0, p1, Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 986
    check-cast v0, Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    invoke-virtual {p0, v0}, Lco/vine/android/dragsort/DragSortWidget;->setFloatViewInteractionListener(Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;)V

    .line 988
    :cond_0
    instance-of v0, p1, Lco/vine/android/dragsort/DragSortWidget$DragListener;

    if-eqz v0, :cond_1

    move-object v0, p1

    .line 989
    check-cast v0, Lco/vine/android/dragsort/DragSortWidget$DragListener;

    invoke-virtual {p0, v0}, Lco/vine/android/dragsort/DragSortWidget;->setDragListener(Lco/vine/android/dragsort/DragSortWidget$DragListener;)V

    .line 991
    :cond_1
    instance-of v0, p1, Lco/vine/android/dragsort/DragSortWidget$RemoveListener;

    if-eqz v0, :cond_2

    move-object v0, p1

    .line 992
    check-cast v0, Lco/vine/android/dragsort/DragSortWidget$RemoveListener;

    invoke-virtual {p0, v0}, Lco/vine/android/dragsort/DragSortWidget;->setRemoveListener(Lco/vine/android/dragsort/DragSortWidget$RemoveListener;)V

    .line 994
    :cond_2
    instance-of v0, p1, Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;

    if-eqz v0, :cond_3

    move-object v0, p1

    .line 995
    check-cast v0, Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;

    invoke-virtual {p0, v0}, Lco/vine/android/dragsort/DragSortWidget;->setSelectionChangedListener(Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;)V

    .line 997
    :cond_3
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mAdapterWrapper:Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;

    if-nez v0, :cond_4

    .line 998
    new-instance v0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;

    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;-><init>(Lco/vine/android/dragsort/DragSortWidget;Landroid/content/Context;)V

    iput-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mAdapterWrapper:Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;

    .line 1000
    :cond_4
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mAdapterWrapper:Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;

    invoke-virtual {v0, p1}, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 1001
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget;->mAdapterWrapper:Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;

    invoke-virtual {v0, v1}, Lco/vine/android/views/HorizontalListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 1012
    :cond_5
    :goto_0
    return-void

    .line 1003
    :cond_6
    invoke-virtual {p0, v1}, Lco/vine/android/dragsort/DragSortWidget;->setFloatViewInteractionListener(Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;)V

    .line 1004
    invoke-virtual {p0, v1}, Lco/vine/android/dragsort/DragSortWidget;->setDragListener(Lco/vine/android/dragsort/DragSortWidget$DragListener;)V

    .line 1005
    invoke-virtual {p0, v1}, Lco/vine/android/dragsort/DragSortWidget;->setRemoveListener(Lco/vine/android/dragsort/DragSortWidget$RemoveListener;)V

    .line 1006
    invoke-virtual {p0, v1}, Lco/vine/android/dragsort/DragSortWidget;->setSelectionChangedListener(Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;)V

    .line 1007
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v0, v1}, Lco/vine/android/views/HorizontalListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 1008
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mAdapterWrapper:Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;

    if-eqz v0, :cond_5

    .line 1009
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mAdapterWrapper:Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;

    invoke-virtual {v0, v1}, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->setAdapter(Landroid/widget/ListAdapter;)V

    goto :goto_0
.end method

.method public setContentView(Landroid/view/View;Landroid/graphics/Rect;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "bounds"    # Landroid/graphics/Rect;

    .prologue
    .line 1218
    iput-object p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentView:Landroid/view/View;

    .line 1219
    iput-object p2, p0, Lco/vine/android/dragsort/DragSortWidget;->mContentViewBounds:Landroid/graphics/Rect;

    .line 1220
    invoke-virtual {p1, p0}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1221
    return-void
.end method

.method public setCurrentlyPlayingProvider(Lco/vine/android/dragsort/DragSortWidget$CurrentlyPlayingProvider;)V
    .locals 0
    .param p1, "cpp"    # Lco/vine/android/dragsort/DragSortWidget$CurrentlyPlayingProvider;

    .prologue
    .line 613
    iput-object p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mCurrentlyPlayingProvider:Lco/vine/android/dragsort/DragSortWidget$CurrentlyPlayingProvider;

    .line 614
    return-void
.end method

.method public setDragListener(Lco/vine/android/dragsort/DragSortWidget$DragListener;)V
    .locals 0
    .param p1, "l"    # Lco/vine/android/dragsort/DragSortWidget$DragListener;

    .prologue
    .line 1051
    iput-object p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mDragListener:Lco/vine/android/dragsort/DragSortWidget$DragListener;

    .line 1052
    return-void
.end method

.method public setFirstItem(I)V
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 139
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v0, p1}, Lco/vine/android/views/HorizontalListView;->setSelection(I)V

    .line 140
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mDropping:Z

    if-nez v0, :cond_0

    .line 141
    iget v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I

    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->getClosestItemPosition()I

    move-result v1

    invoke-direct {p0, v0, v1}, Lco/vine/android/dragsort/DragSortWidget;->dragFloatView(II)V

    .line 143
    :cond_0
    return-void
.end method

.method public setFloatViewInteractionListener(Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;)V
    .locals 0
    .param p1, "l"    # Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    .prologue
    .line 1043
    iput-object p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFloatViewInteractionListener:Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;

    .line 1044
    return-void
.end method

.method public setFocused(I)V
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 155
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFocusedPosition:I

    .line 156
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->adjustItems()V

    .line 157
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v0}, Lco/vine/android/views/HorizontalListView;->invalidate()V

    .line 158
    return-void
.end method

.method public setRemoveListener(Lco/vine/android/dragsort/DragSortWidget$RemoveListener;)V
    .locals 0
    .param p1, "l"    # Lco/vine/android/dragsort/DragSortWidget$RemoveListener;

    .prologue
    .line 1047
    iput-object p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mRemoveListener:Lco/vine/android/dragsort/DragSortWidget$RemoveListener;

    .line 1048
    return-void
.end method

.method public setSelection(I)V
    .locals 1
    .param p1, "selection"    # I

    .prologue
    .line 146
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I

    .line 147
    const/4 v0, -0x1

    if-eq p1, v0, :cond_0

    .line 148
    iput p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mFocusedPosition:I

    .line 150
    :cond_0
    invoke-direct {p0}, Lco/vine/android/dragsort/DragSortWidget;->adjustItems()V

    .line 151
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    .line 152
    return-void
.end method

.method public setSelectionChangedListener(Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;)V
    .locals 0
    .param p1, "l"    # Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;

    .prologue
    .line 1055
    iput-object p1, p0, Lco/vine/android/dragsort/DragSortWidget;->mSelectionChangedListener:Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;

    .line 1056
    return-void
.end method
