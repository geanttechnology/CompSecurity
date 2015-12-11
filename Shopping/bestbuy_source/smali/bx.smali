.class public Lbx;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

.field private b:I

.field private c:I

.field private d:I

.field private e:Z

.field private f:Z

.field private g:I

.field private h:I

.field private i:I

.field private j:Landroid/view/View;

.field private k:Landroid/view/View;

.field private l:Landroid/view/animation/AlphaAnimation;

.field private m:Z

.field private n:Z


# direct methods
.method private constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)V
    .locals 4

    .prologue
    const/4 v0, -0x1

    const/4 v3, 0x0

    .line 89
    iput-object p1, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 91
    iput v0, p0, Lbx;->b:I

    .line 92
    iput v3, p0, Lbx;->c:I

    .line 93
    iput v3, p0, Lbx;->d:I

    .line 94
    iput-boolean v3, p0, Lbx;->e:Z

    .line 95
    iput-boolean v3, p0, Lbx;->f:Z

    .line 96
    iput v0, p0, Lbx;->g:I

    .line 101
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/high16 v1, 0x3f800000    # 1.0f

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    iput-object v0, p0, Lbx;->l:Landroid/view/animation/AlphaAnimation;

    .line 102
    iput-boolean v3, p0, Lbx;->m:Z

    .line 103
    iput-boolean v3, p0, Lbx;->n:Z

    return-void
.end method

.method public synthetic constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$1;)V
    .locals 0

    .prologue
    .line 89
    invoke-direct {p0, p1}, Lbx;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)V

    return-void
.end method

.method private a()V
    .locals 1

    .prologue
    .line 191
    const/4 v0, 0x1

    iput-boolean v0, p0, Lbx;->e:Z

    .line 192
    const/4 v0, 0x0

    iput-boolean v0, p0, Lbx;->f:Z

    .line 193
    const/4 v0, -0x1

    iput v0, p0, Lbx;->g:I

    .line 194
    return-void
.end method

.method private a(I)V
    .locals 1

    .prologue
    .line 197
    const/4 v0, 0x0

    iput-boolean v0, p0, Lbx;->e:Z

    .line 198
    invoke-direct {p0, p1}, Lbx;->b(I)V

    .line 199
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->requestLayout()V

    .line 200
    iput p1, p0, Lbx;->g:I

    .line 201
    return-void
.end method

.method private a(II)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 205
    iget v0, p0, Lbx;->c:I

    if-lez v0, :cond_0

    .line 206
    if-lt p1, p2, :cond_4

    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    sub-int v2, p1, p2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    :goto_0
    iput v0, p0, Lbx;->h:I

    .line 209
    :cond_0
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lbx;->j:Landroid/view/View;

    .line 210
    iget-object v0, p0, Lbx;->j:Landroid/view/View;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lbx;->j:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    :goto_1
    iput v0, p0, Lbx;->i:I

    .line 212
    iget v0, p0, Lbx;->c:I

    if-gez v0, :cond_2

    .line 213
    iget v0, p0, Lbx;->g:I

    iget v2, p0, Lbx;->d:I

    add-int/lit8 v2, v2, -0x1

    if-eq v0, v2, :cond_1

    .line 214
    iget v0, p0, Lbx;->d:I

    add-int/lit8 v0, v0, -0x1

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    invoke-direct {p0, v0}, Lbx;->b(I)V

    .line 215
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lbx;->k:Landroid/view/View;

    .line 217
    :cond_1
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getChildCount()I

    move-result v0

    if-lez v0, :cond_6

    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    :goto_2
    iput v0, p0, Lbx;->h:I

    .line 218
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget v2, p0, Lbx;->i:I

    invoke-virtual {v0, v1, v2}, Landroid/widget/RelativeLayout;->scrollTo(II)V

    .line 220
    :cond_2
    iget-object v0, p0, Lbx;->j:Landroid/view/View;

    if-eqz v0, :cond_3

    iget v0, p0, Lbx;->i:I

    if-lez v0, :cond_3

    iget v0, p0, Lbx;->h:I

    if-lez v0, :cond_3

    const/4 v1, 0x1

    :cond_3
    iput-boolean v1, p0, Lbx;->f:Z

    .line 221
    return-void

    :cond_4
    move v0, v1

    .line 206
    goto :goto_0

    .line 210
    :cond_5
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getHeight()I

    move-result v0

    goto :goto_1

    :cond_6
    move v0, v1

    .line 217
    goto :goto_2
.end method

.method private b(II)I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 270
    if-nez p2, :cond_0

    .line 271
    const/4 v0, -0x1

    .line 278
    :goto_0
    return v0

    .line 273
    :cond_0
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v0

    .line 274
    :goto_1
    if-ge v1, p2, :cond_1

    iget-object v2, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/RelativeLayout;->getHeight()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 275
    iget-object v2, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getHeight()I

    move-result v2

    add-int/2addr v0, v2

    .line 274
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 277
    :cond_1
    add-int v0, p1, v1

    add-int/lit8 v0, v0, -0x1

    invoke-static {p1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    goto :goto_0
.end method

.method private b()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v1, 0x0

    .line 224
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/FrameLayout;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 225
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->computeVerticalScrollOffset()I

    move-result v3

    .line 226
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->computeVerticalScrollRange()I

    move-result v4

    .line 227
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->computeVerticalScrollExtent()I

    move-result v5

    .line 228
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/FrameLayout;

    move-result-object v2

    if-lt v5, v4, :cond_1

    const/4 v0, 0x4

    :goto_0
    invoke-virtual {v2, v0}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 229
    if-lt v5, v4, :cond_2

    .line 243
    :cond_0
    :goto_1
    return-void

    :cond_1
    move v0, v1

    .line 228
    goto :goto_0

    .line 232
    :cond_2
    if-nez v4, :cond_3

    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getHeight()I

    move-result v0

    move v2, v0

    .line 233
    :goto_2
    if-nez v4, :cond_4

    move v0, v1

    .line 234
    :goto_3
    iget-object v3, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/FrameLayout;

    move-result-object v3

    invoke-virtual {v3, v1, v2, v1, v0}, Landroid/widget/FrameLayout;->setPadding(IIII)V

    .line 235
    iget-object v0, p0, Lbx;->l:Landroid/view/animation/AlphaAnimation;

    invoke-virtual {v0}, Landroid/view/animation/AlphaAnimation;->reset()V

    .line 236
    iget-object v0, p0, Lbx;->l:Landroid/view/animation/AlphaAnimation;

    invoke-virtual {v0, v7}, Landroid/view/animation/AlphaAnimation;->setFillBefore(Z)V

    .line 237
    iget-object v0, p0, Lbx;->l:Landroid/view/animation/AlphaAnimation;

    invoke-virtual {v0, v7}, Landroid/view/animation/AlphaAnimation;->setFillAfter(Z)V

    .line 238
    iget-object v0, p0, Lbx;->l:Landroid/view/animation/AlphaAnimation;

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/AlphaAnimation;->setStartOffset(J)V

    .line 239
    iget-object v0, p0, Lbx;->l:Landroid/view/animation/AlphaAnimation;

    const-wide/16 v2, 0x7d0

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/AlphaAnimation;->setDuration(J)V

    .line 240
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/FrameLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->clearAnimation()V

    .line 241
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/FrameLayout;

    move-result-object v0

    iget-object v1, p0, Lbx;->l:Landroid/view/animation/AlphaAnimation;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_1

    .line 232
    :cond_3
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getHeight()I

    move-result v0

    mul-int/2addr v0, v3

    div-int/2addr v0, v4

    move v2, v0

    goto :goto_2

    .line 233
    :cond_4
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getHeight()I

    move-result v0

    iget-object v6, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getHeight()I

    move-result v6

    add-int/2addr v3, v5

    mul-int/2addr v3, v6

    div-int/2addr v3, v4

    sub-int/2addr v0, v3

    goto :goto_3
.end method

.method private b(I)V
    .locals 5

    .prologue
    const/4 v1, 0x0

    const/4 v4, 0x0

    .line 246
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 247
    if-eqz v0, :cond_0

    .line 248
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->removeViewAt(I)V

    .line 251
    :cond_0
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v0

    invoke-virtual {v0, p1}, Lby;->b(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 252
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v0

    invoke-virtual {v0, p1, v1, v1}, Lby;->a(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 253
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v2, -0x1

    const/4 v3, -0x2

    invoke-direct {v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 255
    iget-object v1, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getWidth()I

    move-result v1

    const/high16 v2, 0x40000000    # 2.0f

    invoke-static {v1, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    invoke-static {v4, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/view/View;->measure(II)V

    .line 257
    iget-object v1, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 258
    invoke-virtual {v0, v4, v4}, Landroid/view/View;->scrollTo(II)V

    .line 259
    iget-object v1, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v1

    invoke-virtual {v1, v4, v4}, Landroid/widget/RelativeLayout;->scrollTo(II)V

    .line 260
    iget-object v1, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v1

    invoke-virtual {v1, v0, v4}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;I)V

    .line 266
    :goto_0
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/FrameLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->bringToFront()V

    .line 267
    return-void

    .line 262
    :cond_1
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput v4, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 263
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v4, v4}, Landroid/widget/RelativeLayout;->scrollTo(II)V

    goto :goto_0
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 11

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 113
    iget-boolean v0, p0, Lbx;->n:Z

    if-nez v0, :cond_1

    .line 188
    :cond_0
    :goto_0
    return-void

    .line 117
    :cond_1
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getHeaderViewsCount()I

    move-result v0

    sub-int v5, p2, v0

    .line 118
    if-gez v5, :cond_2

    .line 119
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->removeAllViews()V

    goto :goto_0

    .line 123
    :cond_2
    invoke-direct {p0}, Lbx;->b()V

    .line 124
    if-lez p3, :cond_3

    if-nez v5, :cond_3

    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_3

    .line 125
    invoke-direct {p0, v2}, Lbx;->b(I)V

    .line 126
    iput v2, p0, Lbx;->g:I

    .line 129
    :cond_3
    invoke-direct {p0, v5, p3}, Lbx;->b(II)I

    move-result v6

    .line 130
    if-lez p4, :cond_5

    iget v0, p0, Lbx;->b:I

    if-eq v0, v6, :cond_5

    .line 131
    iget v0, p0, Lbx;->b:I

    sub-int v0, v6, v0

    iput v0, p0, Lbx;->c:I

    .line 133
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v0

    invoke-virtual {v0, v6}, Lby;->e(I)I

    move-result v0

    iput v0, p0, Lbx;->d:I

    .line 135
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v0

    invoke-virtual {v0, v6}, Lby;->g(I)Z

    move-result v7

    .line 136
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v0

    iget v3, p0, Lbx;->d:I

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v0, v3}, Lby;->b(I)Z

    move-result v8

    .line 137
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v0

    iget v3, p0, Lbx;->d:I

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v0, v3}, Lby;->b(I)Z

    move-result v9

    .line 138
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v0

    iget v3, p0, Lbx;->d:I

    invoke-virtual {v0, v3}, Lby;->b(I)Z

    move-result v10

    .line 139
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v0

    invoke-virtual {v0, v6}, Lby;->f(I)I

    move-result v0

    iget-object v3, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v3

    iget v4, p0, Lbx;->d:I

    invoke-virtual {v3, v4}, Lby;->a(I)I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-ne v0, v3, :cond_9

    move v0, v1

    .line 140
    :goto_1
    iget-object v3, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v3

    iget v4, p0, Lbx;->d:I

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v3, v4}, Lby;->a(I)I

    move-result v3

    if-lez v3, :cond_a

    move v3, v1

    .line 141
    :goto_2
    iget-object v4, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v4

    invoke-virtual {v4, v6}, Lby;->f(I)I

    move-result v4

    if-nez v4, :cond_b

    move v4, v1

    .line 143
    :goto_3
    if-eqz v4, :cond_c

    if-nez v10, :cond_c

    if-eqz v8, :cond_c

    if-eq v6, v5, :cond_c

    move v4, v1

    .line 144
    :goto_4
    if-eqz v0, :cond_d

    if-eqz v10, :cond_d

    if-nez v9, :cond_d

    if-ne v6, v5, :cond_d

    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v0

    iget-object v9, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v9}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v9

    invoke-virtual {v9, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    invoke-virtual {v9}, Landroid/view/View;->getHeight()I

    move-result v9

    div-int/lit8 v9, v9, 0x2

    if-lt v0, v9, :cond_d

    move v0, v1

    .line 146
    :goto_5
    iput-boolean v2, p0, Lbx;->m:Z

    .line 147
    if-eqz v7, :cond_f

    if-nez v8, :cond_f

    if-ltz v5, :cond_f

    .line 148
    iget v0, p0, Lbx;->c:I

    if-gez v0, :cond_e

    iget v0, p0, Lbx;->d:I

    add-int/lit8 v0, v0, -0x1

    :goto_6
    invoke-direct {p0, v0}, Lbx;->a(I)V

    .line 160
    :cond_4
    :goto_7
    iput v6, p0, Lbx;->b:I

    .line 163
    :cond_5
    iget-boolean v0, p0, Lbx;->e:Z

    if-eqz v0, :cond_7

    .line 164
    if-lt v6, v5, :cond_15

    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v0

    sub-int v1, v6, v5

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v0

    .line 166
    :goto_8
    iget-boolean v1, p0, Lbx;->f:Z

    if-nez v1, :cond_6

    .line 167
    invoke-direct {p0, v6, v5}, Lbx;->a(II)V

    .line 170
    :cond_6
    iget-boolean v1, p0, Lbx;->f:Z

    if-eqz v1, :cond_18

    iget v1, p0, Lbx;->i:I

    iget v3, p0, Lbx;->h:I

    sub-int/2addr v1, v3

    iget v3, p0, Lbx;->c:I

    mul-int/2addr v1, v3

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v3

    mul-int/2addr v3, v1

    iget v1, p0, Lbx;->c:I

    if-gez v1, :cond_16

    iget v1, p0, Lbx;->h:I

    :goto_9
    div-int/2addr v3, v1

    iget v1, p0, Lbx;->c:I

    if-lez v1, :cond_17

    iget v1, p0, Lbx;->h:I

    :goto_a
    add-int/2addr v1, v3

    .line 172
    :goto_b
    iget-object v3, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v3

    sub-int/2addr v0, v1

    invoke-static {v2, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    neg-int v0, v0

    invoke-virtual {v3, v2, v0}, Landroid/widget/RelativeLayout;->scrollTo(II)V

    .line 173
    iget-boolean v0, p0, Lbx;->f:Z

    if-eqz v0, :cond_7

    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iget v0, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-eq v1, v0, :cond_7

    .line 174
    iget v0, p0, Lbx;->c:I

    if-gez v0, :cond_19

    iget-object v0, p0, Lbx;->k:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    :goto_c
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 175
    iget v3, v0, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    sub-int v3, v1, v3

    iput v3, v0, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 176
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 177
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->requestLayout()V

    .line 181
    :cond_7
    iget-boolean v0, p0, Lbx;->m:Z

    if-eqz v0, :cond_0

    .line 182
    iget v0, p0, Lbx;->g:I

    iget v1, p0, Lbx;->d:I

    if-eq v0, v1, :cond_8

    .line 183
    iget v0, p0, Lbx;->d:I

    invoke-direct {p0, v0}, Lbx;->b(I)V

    .line 184
    iget v0, p0, Lbx;->d:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lbx;->g:I

    .line 186
    :cond_8
    iget-object v0, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iget v1, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    iget-object v3, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getHeight()I

    move-result v3

    iget-object v4, p0, Lbx;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    move-result-object v4

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getTop()I

    move-result v4

    add-int/2addr v3, v4

    sub-int/2addr v1, v3

    invoke-virtual {v0, v2, v1}, Landroid/widget/RelativeLayout;->scrollTo(II)V

    goto/16 :goto_0

    :cond_9
    move v0, v2

    .line 139
    goto/16 :goto_1

    :cond_a
    move v3, v2

    .line 140
    goto/16 :goto_2

    :cond_b
    move v4, v2

    .line 141
    goto/16 :goto_3

    :cond_c
    move v4, v2

    .line 143
    goto/16 :goto_4

    :cond_d
    move v0, v2

    .line 144
    goto/16 :goto_5

    .line 148
    :cond_e
    iget v0, p0, Lbx;->d:I

    goto/16 :goto_6

    .line 149
    :cond_f
    if-eqz v7, :cond_10

    if-gtz v5, :cond_11

    :cond_10
    if-eqz v4, :cond_13

    .line 150
    :cond_11
    if-nez v3, :cond_12

    .line 151
    iget v0, p0, Lbx;->d:I

    add-int/lit8 v0, v0, -0x1

    invoke-direct {p0, v0}, Lbx;->a(I)V

    .line 153
    :cond_12
    invoke-direct {p0}, Lbx;->a()V

    goto/16 :goto_7

    .line 154
    :cond_13
    if-eqz v0, :cond_14

    .line 155
    iput-boolean v1, p0, Lbx;->m:Z

    goto/16 :goto_7

    .line 156
    :cond_14
    iget v0, p0, Lbx;->g:I

    iget v1, p0, Lbx;->d:I

    if-eq v0, v1, :cond_4

    .line 157
    iget v0, p0, Lbx;->d:I

    invoke-direct {p0, v0}, Lbx;->a(I)V

    goto/16 :goto_7

    :cond_15
    move v0, v2

    .line 164
    goto/16 :goto_8

    .line 170
    :cond_16
    iget v1, p0, Lbx;->i:I

    goto/16 :goto_9

    :cond_17
    iget v1, p0, Lbx;->i:I

    goto/16 :goto_a

    :cond_18
    move v1, v2

    goto/16 :goto_b

    .line 174
    :cond_19
    iget-object v0, p0, Lbx;->j:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    goto/16 :goto_c
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 1

    .prologue
    .line 107
    const/4 v0, 0x1

    iput-boolean v0, p0, Lbx;->n:Z

    .line 108
    return-void
.end method
