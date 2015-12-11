.class public Lcom/wjj/utils/StickyLayout;
.super Landroid/widget/LinearLayout;
.source "StickyLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wjj/utils/StickyLayout$OnGiveUpTouchEventListener;
    }
.end annotation


# static fields
.field private static final DEBUG:Z = true

.field public static final STATUS_COLLAPSED:I = 0x2

.field public static final STATUS_EXPANDED:I = 0x1

.field private static final TAG:Ljava/lang/String; = "StickyLayout"

.field private static final TAN:I = 0x2


# instance fields
.field private mContent:Landroid/view/View;

.field private mDisallowInterceptTouchEventOnHeader:Z

.field private mGiveUpTouchEventListener:Lcom/wjj/utils/StickyLayout$OnGiveUpTouchEventListener;

.field private mHeader:Landroid/view/View;

.field private mHeaderHeight:I

.field private mInitDataSucceed:Z

.field private mIsSticky:Z

.field private mLastX:I

.field private mLastXIntercept:I

.field private mLastY:I

.field private mLastYIntercept:I

.field private mOriginalHeaderHeight:I

.field private mStatus:I

.field private mTouchSlop:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 80
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 58
    iput v1, p0, Lcom/wjj/utils/StickyLayout;->mStatus:I

    .line 65
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastX:I

    .line 66
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastY:I

    .line 69
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastXIntercept:I

    .line 70
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastYIntercept:I

    .line 75
    iput-boolean v1, p0, Lcom/wjj/utils/StickyLayout;->mIsSticky:Z

    .line 76
    iput-boolean v0, p0, Lcom/wjj/utils/StickyLayout;->mInitDataSucceed:Z

    .line 77
    iput-boolean v1, p0, Lcom/wjj/utils/StickyLayout;->mDisallowInterceptTouchEventOnHeader:Z

    .line 81
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 84
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 58
    iput v1, p0, Lcom/wjj/utils/StickyLayout;->mStatus:I

    .line 65
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastX:I

    .line 66
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastY:I

    .line 69
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastXIntercept:I

    .line 70
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastYIntercept:I

    .line 75
    iput-boolean v1, p0, Lcom/wjj/utils/StickyLayout;->mIsSticky:Z

    .line 76
    iput-boolean v0, p0, Lcom/wjj/utils/StickyLayout;->mInitDataSucceed:Z

    .line 77
    iput-boolean v1, p0, Lcom/wjj/utils/StickyLayout;->mDisallowInterceptTouchEventOnHeader:Z

    .line 85
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 89
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 58
    iput v1, p0, Lcom/wjj/utils/StickyLayout;->mStatus:I

    .line 65
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastX:I

    .line 66
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastY:I

    .line 69
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastXIntercept:I

    .line 70
    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mLastYIntercept:I

    .line 75
    iput-boolean v1, p0, Lcom/wjj/utils/StickyLayout;->mIsSticky:Z

    .line 76
    iput-boolean v0, p0, Lcom/wjj/utils/StickyLayout;->mInitDataSucceed:Z

    .line 77
    iput-boolean v1, p0, Lcom/wjj/utils/StickyLayout;->mDisallowInterceptTouchEventOnHeader:Z

    .line 90
    return-void
.end method

.method private initData()V
    .locals 6

    .prologue
    .line 101
    invoke-virtual {p0}, Lcom/wjj/utils/StickyLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const-string v3, "sticky_header"

    const-string v4, "id"

    invoke-virtual {p0}, Lcom/wjj/utils/StickyLayout;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v3, v4, v5}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 102
    .local v1, "headerId":I
    invoke-virtual {p0}, Lcom/wjj/utils/StickyLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const-string v3, "sticky_content"

    const-string v4, "id"

    invoke-virtual {p0}, Lcom/wjj/utils/StickyLayout;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v3, v4, v5}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 103
    .local v0, "contentId":I
    if-eqz v1, :cond_1

    if-eqz v0, :cond_1

    .line 104
    invoke-virtual {p0, v1}, Lcom/wjj/utils/StickyLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/wjj/utils/StickyLayout;->mHeader:Landroid/view/View;

    .line 105
    invoke-virtual {p0, v0}, Lcom/wjj/utils/StickyLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/wjj/utils/StickyLayout;->mContent:Landroid/view/View;

    .line 106
    iget-object v2, p0, Lcom/wjj/utils/StickyLayout;->mHeader:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    iput v2, p0, Lcom/wjj/utils/StickyLayout;->mOriginalHeaderHeight:I

    .line 107
    iget v2, p0, Lcom/wjj/utils/StickyLayout;->mOriginalHeaderHeight:I

    iput v2, p0, Lcom/wjj/utils/StickyLayout;->mHeaderHeight:I

    .line 108
    invoke-virtual {p0}, Lcom/wjj/utils/StickyLayout;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v2

    iput v2, p0, Lcom/wjj/utils/StickyLayout;->mTouchSlop:I

    .line 109
    iget v2, p0, Lcom/wjj/utils/StickyLayout;->mHeaderHeight:I

    if-lez v2, :cond_0

    .line 110
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/wjj/utils/StickyLayout;->mInitDataSucceed:Z

    .line 113
    :cond_0
    const-string v2, "StickyLayout"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "mTouchSlop = "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v4, p0, Lcom/wjj/utils/StickyLayout;->mTouchSlop:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "mHeaderHeight = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, p0, Lcom/wjj/utils/StickyLayout;->mHeaderHeight:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 118
    return-void

    .line 116
    :cond_1
    new-instance v2, Ljava/util/NoSuchElementException;

    const-string v3, "Did your view with id \"sticky_header\" or \"sticky_content\" exists?"

    invoke-direct {v2, v3}, Ljava/util/NoSuchElementException;-><init>(Ljava/lang/String;)V

    throw v2
.end method


# virtual methods
.method public getHeaderHeight()I
    .locals 1

    .prologue
    .line 294
    iget v0, p0, Lcom/wjj/utils/StickyLayout;->mHeaderHeight:I

    return v0
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 10
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 126
    const/4 v2, 0x0

    .line 127
    .local v2, "intercepted":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v7

    float-to-int v3, v7

    .line 128
    .local v3, "x":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v7

    float-to-int v4, v7

    .line 130
    .local v4, "y":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v7

    packed-switch v7, :pswitch_data_0

    .line 165
    :cond_0
    :goto_0
    const-string v7, "StickyLayout"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "intercepted="

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 167
    if-eqz v2, :cond_4

    iget-boolean v7, p0, Lcom/wjj/utils/StickyLayout;->mIsSticky:Z

    if-eqz v7, :cond_4

    :goto_1
    return v5

    .line 132
    :pswitch_0
    iput v3, p0, Lcom/wjj/utils/StickyLayout;->mLastXIntercept:I

    .line 133
    iput v4, p0, Lcom/wjj/utils/StickyLayout;->mLastYIntercept:I

    .line 134
    iput v3, p0, Lcom/wjj/utils/StickyLayout;->mLastX:I

    .line 135
    iput v4, p0, Lcom/wjj/utils/StickyLayout;->mLastY:I

    .line 136
    const/4 v2, 0x0

    .line 137
    goto :goto_0

    .line 140
    :pswitch_1
    iget v7, p0, Lcom/wjj/utils/StickyLayout;->mLastXIntercept:I

    sub-int v0, v3, v7

    .line 141
    .local v0, "deltaX":I
    iget v7, p0, Lcom/wjj/utils/StickyLayout;->mLastYIntercept:I

    sub-int v1, v4, v7

    .line 142
    .local v1, "deltaY":I
    iget-boolean v7, p0, Lcom/wjj/utils/StickyLayout;->mDisallowInterceptTouchEventOnHeader:Z

    if-eqz v7, :cond_1

    invoke-virtual {p0}, Lcom/wjj/utils/StickyLayout;->getHeaderHeight()I

    move-result v7

    if-gt v4, v7, :cond_1

    .line 143
    const/4 v2, 0x0

    .line 144
    goto :goto_0

    :cond_1
    invoke-static {v1}, Ljava/lang/Math;->abs(I)I

    move-result v7

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v8

    if-gt v7, v8, :cond_2

    .line 145
    const/4 v2, 0x0

    .line 146
    goto :goto_0

    :cond_2
    iget v7, p0, Lcom/wjj/utils/StickyLayout;->mStatus:I

    if-ne v7, v5, :cond_3

    iget v7, p0, Lcom/wjj/utils/StickyLayout;->mTouchSlop:I

    neg-int v7, v7

    if-gt v1, v7, :cond_3

    .line 147
    const/4 v2, 0x1

    .line 148
    goto :goto_0

    :cond_3
    iget-object v7, p0, Lcom/wjj/utils/StickyLayout;->mGiveUpTouchEventListener:Lcom/wjj/utils/StickyLayout$OnGiveUpTouchEventListener;

    if-eqz v7, :cond_0

    .line 149
    iget-object v7, p0, Lcom/wjj/utils/StickyLayout;->mGiveUpTouchEventListener:Lcom/wjj/utils/StickyLayout$OnGiveUpTouchEventListener;

    invoke-interface {v7, p1}, Lcom/wjj/utils/StickyLayout$OnGiveUpTouchEventListener;->giveUpTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v7

    if-eqz v7, :cond_0

    iget v7, p0, Lcom/wjj/utils/StickyLayout;->mTouchSlop:I

    if-lt v1, v7, :cond_0

    .line 150
    const/4 v2, 0x1

    .line 153
    goto :goto_0

    .line 156
    .end local v0    # "deltaX":I
    .end local v1    # "deltaY":I
    :pswitch_2
    const/4 v2, 0x0

    .line 157
    iput v6, p0, Lcom/wjj/utils/StickyLayout;->mLastYIntercept:I

    iput v6, p0, Lcom/wjj/utils/StickyLayout;->mLastXIntercept:I

    goto :goto_0

    :cond_4
    move v5, v6

    .line 167
    goto :goto_1

    .line 130
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 12
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v11, 0x1

    .line 172
    iget-boolean v5, p0, Lcom/wjj/utils/StickyLayout;->mIsSticky:Z

    if-nez v5, :cond_0

    .line 210
    :goto_0
    return v11

    .line 175
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    float-to-int v3, v5

    .line 176
    .local v3, "x":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v5

    float-to-int v4, v5

    .line 177
    .local v4, "y":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v5

    packed-switch v5, :pswitch_data_0

    .line 208
    :goto_1
    :pswitch_0
    iput v3, p0, Lcom/wjj/utils/StickyLayout;->mLastX:I

    .line 209
    iput v4, p0, Lcom/wjj/utils/StickyLayout;->mLastY:I

    goto :goto_0

    .line 182
    :pswitch_1
    iget v5, p0, Lcom/wjj/utils/StickyLayout;->mLastX:I

    sub-int v0, v3, v5

    .line 183
    .local v0, "deltaX":I
    iget v5, p0, Lcom/wjj/utils/StickyLayout;->mLastY:I

    sub-int v1, v4, v5

    .line 185
    .local v1, "deltaY":I
    const-string v5, "StickyLayout"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "mHeaderHeight="

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v7, p0, Lcom/wjj/utils/StickyLayout;->mHeaderHeight:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "  deltaY="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "  mlastY="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget v7, p0, Lcom/wjj/utils/StickyLayout;->mLastY:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 187
    iget v5, p0, Lcom/wjj/utils/StickyLayout;->mHeaderHeight:I

    add-int/2addr v5, v1

    iput v5, p0, Lcom/wjj/utils/StickyLayout;->mHeaderHeight:I

    .line 188
    iget v5, p0, Lcom/wjj/utils/StickyLayout;->mHeaderHeight:I

    invoke-virtual {p0, v5}, Lcom/wjj/utils/StickyLayout;->setHeaderHeight(I)V

    goto :goto_1

    .line 193
    .end local v0    # "deltaX":I
    .end local v1    # "deltaY":I
    :pswitch_2
    const/4 v2, 0x0

    .line 194
    .local v2, "destHeight":I
    iget v5, p0, Lcom/wjj/utils/StickyLayout;->mHeaderHeight:I

    int-to-double v5, v5

    iget v7, p0, Lcom/wjj/utils/StickyLayout;->mOriginalHeaderHeight:I

    int-to-double v7, v7

    const-wide/high16 v9, 0x3fe0000000000000L    # 0.5

    mul-double/2addr v7, v9

    cmpg-double v5, v5, v7

    if-gtz v5, :cond_1

    .line 195
    const/4 v2, 0x0

    .line 196
    const/4 v5, 0x2

    iput v5, p0, Lcom/wjj/utils/StickyLayout;->mStatus:I

    .line 202
    :goto_2
    iget v5, p0, Lcom/wjj/utils/StickyLayout;->mHeaderHeight:I

    const-wide/16 v6, 0x1f4

    invoke-virtual {p0, v5, v2, v6, v7}, Lcom/wjj/utils/StickyLayout;->smoothSetHeaderHeight(IIJ)V

    goto :goto_1

    .line 198
    :cond_1
    iget v2, p0, Lcom/wjj/utils/StickyLayout;->mOriginalHeaderHeight:I

    .line 199
    iput v11, p0, Lcom/wjj/utils/StickyLayout;->mStatus:I

    goto :goto_2

    .line 177
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public onWindowFocusChanged(Z)V
    .locals 1
    .param p1, "hasWindowFocus"    # Z

    .prologue
    .line 94
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onWindowFocusChanged(Z)V

    .line 95
    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/wjj/utils/StickyLayout;->mHeader:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wjj/utils/StickyLayout;->mContent:Landroid/view/View;

    if-nez v0, :cond_1

    .line 96
    :cond_0
    invoke-direct {p0}, Lcom/wjj/utils/StickyLayout;->initData()V

    .line 98
    :cond_1
    return-void
.end method

.method public requestDisallowInterceptTouchEventOnHeader(Z)V
    .locals 0
    .param p1, "disallowIntercept"    # Z

    .prologue
    .line 302
    iput-boolean p1, p0, Lcom/wjj/utils/StickyLayout;->mDisallowInterceptTouchEventOnHeader:Z

    .line 303
    return-void
.end method

.method public setHeaderHeight(I)V
    .locals 3
    .param p1, "height"    # I

    .prologue
    .line 263
    iget-boolean v0, p0, Lcom/wjj/utils/StickyLayout;->mInitDataSucceed:Z

    if-nez v0, :cond_0

    .line 264
    invoke-direct {p0}, Lcom/wjj/utils/StickyLayout;->initData()V

    .line 268
    :cond_0
    const-string v0, "StickyLayout"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "setHeaderHeight height="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 270
    if-gtz p1, :cond_2

    .line 271
    const/4 p1, 0x0

    .line 276
    :cond_1
    :goto_0
    if-nez p1, :cond_3

    .line 277
    const/4 v0, 0x2

    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mStatus:I

    .line 282
    :goto_1
    iget-object v0, p0, Lcom/wjj/utils/StickyLayout;->mHeader:Landroid/view/View;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/wjj/utils/StickyLayout;->mHeader:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 283
    iget-object v0, p0, Lcom/wjj/utils/StickyLayout;->mHeader:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 284
    iget-object v0, p0, Lcom/wjj/utils/StickyLayout;->mHeader:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->requestLayout()V

    .line 285
    iput p1, p0, Lcom/wjj/utils/StickyLayout;->mHeaderHeight:I

    .line 291
    :goto_2
    return-void

    .line 272
    :cond_2
    iget v0, p0, Lcom/wjj/utils/StickyLayout;->mOriginalHeaderHeight:I

    if-le p1, v0, :cond_1

    .line 273
    iget p1, p0, Lcom/wjj/utils/StickyLayout;->mOriginalHeaderHeight:I

    goto :goto_0

    .line 279
    :cond_3
    const/4 v0, 0x1

    iput v0, p0, Lcom/wjj/utils/StickyLayout;->mStatus:I

    goto :goto_1

    .line 288
    :cond_4
    const-string v0, "StickyLayout"

    const-string v1, "null LayoutParams when setHeaderHeight"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2
.end method

.method public setHeaderHeight(IZ)V
    .locals 0
    .param p1, "height"    # I
    .param p2, "modifyOriginalHeaderHeight"    # Z

    .prologue
    .line 256
    if-eqz p2, :cond_0

    .line 257
    invoke-virtual {p0, p1}, Lcom/wjj/utils/StickyLayout;->setOriginalHeaderHeight(I)V

    .line 259
    :cond_0
    invoke-virtual {p0, p1}, Lcom/wjj/utils/StickyLayout;->setHeaderHeight(I)V

    .line 260
    return-void
.end method

.method public setOnGiveUpTouchEventListener(Lcom/wjj/utils/StickyLayout$OnGiveUpTouchEventListener;)V
    .locals 0
    .param p1, "l"    # Lcom/wjj/utils/StickyLayout$OnGiveUpTouchEventListener;

    .prologue
    .line 121
    iput-object p1, p0, Lcom/wjj/utils/StickyLayout;->mGiveUpTouchEventListener:Lcom/wjj/utils/StickyLayout$OnGiveUpTouchEventListener;

    .line 122
    return-void
.end method

.method public setOriginalHeaderHeight(I)V
    .locals 0
    .param p1, "originalHeaderHeight"    # I

    .prologue
    .line 252
    iput p1, p0, Lcom/wjj/utils/StickyLayout;->mOriginalHeaderHeight:I

    .line 253
    return-void
.end method

.method public setSticky(Z)V
    .locals 0
    .param p1, "isSticky"    # Z

    .prologue
    .line 298
    iput-boolean p1, p0, Lcom/wjj/utils/StickyLayout;->mIsSticky:Z

    .line 299
    return-void
.end method

.method public smoothSetHeaderHeight(IIJ)V
    .locals 6
    .param p1, "from"    # I
    .param p2, "to"    # I
    .param p3, "duration"    # J

    .prologue
    .line 214
    const/4 v5, 0x0

    move-object v0, p0

    move v1, p1

    move v2, p2

    move-wide v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/wjj/utils/StickyLayout;->smoothSetHeaderHeight(IIJZ)V

    .line 215
    return-void
.end method

.method public smoothSetHeaderHeight(IIJZ)V
    .locals 8
    .param p1, "from"    # I
    .param p2, "to"    # I
    .param p3, "duration"    # J
    .param p5, "modifyOriginalHeaderHeight"    # Z

    .prologue
    .line 218
    long-to-float v0, p3

    const/high16 v1, 0x447a0000    # 1000.0f

    div-float/2addr v0, v1

    const/high16 v1, 0x41f00000    # 30.0f

    mul-float/2addr v0, v1

    float-to-int v0, v0

    add-int/lit8 v3, v0, 0x1

    .line 219
    .local v3, "frameCount":I
    sub-int v0, p2, p1

    int-to-float v0, v0

    int-to-float v1, v3

    div-float v6, v0, v1

    .line 220
    .local v6, "partation":F
    new-instance v0, Lcom/wjj/utils/StickyLayout$1;

    const-string v2, "Thread#smoothSetHeaderHeight"

    move-object v1, p0

    move v4, p2

    move v5, p1

    move v7, p5

    invoke-direct/range {v0 .. v7}, Lcom/wjj/utils/StickyLayout$1;-><init>(Lcom/wjj/utils/StickyLayout;Ljava/lang/String;IIIFZ)V

    .line 248
    invoke-virtual {v0}, Lcom/wjj/utils/StickyLayout$1;->start()V

    .line 249
    return-void
.end method
