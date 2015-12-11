.class public Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# instance fields
.field private a:Luk/co/senab/actionbarpulltorefresh/library/j;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 50
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 51
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 54
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 55
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 59
    return-void
.end method

.method protected static a(Landroid/app/Activity;Luk/co/senab/actionbarpulltorefresh/library/h;)Luk/co/senab/actionbarpulltorefresh/library/j;
    .locals 1

    .prologue
    .line 223
    new-instance v0, Luk/co/senab/actionbarpulltorefresh/library/j;

    if-eqz p1, :cond_0

    :goto_0
    invoke-direct {v0, p0, p1}, Luk/co/senab/actionbarpulltorefresh/library/j;-><init>(Landroid/app/Activity;Luk/co/senab/actionbarpulltorefresh/library/h;)V

    return-object v0

    :cond_0
    new-instance p1, Luk/co/senab/actionbarpulltorefresh/library/h;

    invoke-direct {p1}, Luk/co/senab/actionbarpulltorefresh/library/h;-><init>()V

    goto :goto_0
.end method


# virtual methods
.method final a()V
    .locals 2

    .prologue
    .line 227
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    if-nez v0, :cond_0

    .line 228
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "You need to setup the PullToRefreshLayout before using it"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 230
    :cond_0
    return-void
.end method

.method final a(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 197
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    if-eqz v0, :cond_1

    .line 198
    iget-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    if-eqz p1, :cond_3

    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    instance-of v0, v0, Luk/co/senab/actionbarpulltorefresh/library/n;

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Luk/co/senab/actionbarpulltorefresh/library/n;

    iget-object v0, v0, Luk/co/senab/actionbarpulltorefresh/library/n;->a:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    const/16 v2, 0x2e

    invoke-virtual {v0, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    const/4 v3, -0x1

    if-ne v2, v3, :cond_2

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v0}, Luk/co/senab/actionbarpulltorefresh/library/g;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Luk/co/senab/actionbarpulltorefresh/library/b/c;

    :goto_1
    invoke-virtual {v1}, Luk/co/senab/actionbarpulltorefresh/library/j;->d()Z

    move-result v2

    if-nez v2, :cond_1

    if-nez p1, :cond_4

    const-string v0, "PullToRefreshAttacher"

    const-string v1, "Refreshable View is null."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 200
    :cond_1
    :goto_2
    return-void

    .line 198
    :cond_2
    if-nez v2, :cond_0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_3
    const/4 v0, 0x0

    goto :goto_1

    :cond_4
    if-nez v0, :cond_5

    invoke-static {p1}, Luk/co/senab/actionbarpulltorefresh/library/g;->a(Landroid/view/View;)Luk/co/senab/actionbarpulltorefresh/library/b/c;

    move-result-object v0

    :cond_5
    iget-object v1, v1, Luk/co/senab/actionbarpulltorefresh/library/j;->m:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2
.end method

.method public bridge synthetic generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    .prologue
    .line 42
    invoke-virtual {p0, p1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->generateLayoutParams(Landroid/util/AttributeSet;)Landroid/widget/FrameLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroid/widget/FrameLayout$LayoutParams;
    .locals 2

    .prologue
    .line 145
    new-instance v0, Luk/co/senab/actionbarpulltorefresh/library/n;

    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Luk/co/senab/actionbarpulltorefresh/library/n;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method public getHeaderTransformer()Luk/co/senab/actionbarpulltorefresh/library/f;
    .locals 1

    .prologue
    .line 116
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a()V

    .line 117
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    iget-object v0, v0, Luk/co/senab/actionbarpulltorefresh/library/j;->a:Luk/co/senab/actionbarpulltorefresh/library/f;

    return-object v0
.end method

.method public final getHeaderView()Landroid/view/View;
    .locals 1

    .prologue
    .line 108
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a()V

    .line 109
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    iget-object v0, v0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    return-object v0
.end method

.method protected onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2

    .prologue
    .line 159
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    if-eqz v0, :cond_0

    .line 160
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    iget-object v1, v0, Luk/co/senab/actionbarpulltorefresh/library/j;->a:Luk/co/senab/actionbarpulltorefresh/library/f;

    iget-object v0, v0, Luk/co/senab/actionbarpulltorefresh/library/j;->c:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Luk/co/senab/actionbarpulltorefresh/library/f;->a(Landroid/app/Activity;)V

    .line 162
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 163
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    if-eqz v0, :cond_0

    .line 152
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    invoke-virtual {v0}, Luk/co/senab/actionbarpulltorefresh/library/j;->a()V

    .line 154
    :cond_0
    invoke-super {p0}, Landroid/widget/FrameLayout;->onDetachedFromWindow()V

    .line 155
    return-void
.end method

.method public final onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 126
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->getChildCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 127
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    invoke-virtual {v0, p1}, Luk/co/senab/actionbarpulltorefresh/library/j;->a(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 129
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 7

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 137
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_9

    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    if-eqz v2, :cond_9

    .line 138
    iget-object v2, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    if-nez v3, :cond_0

    iput-boolean v1, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->k:Z

    :cond_0
    iget-boolean v3, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->k:Z

    if-eqz v3, :cond_3

    iget-boolean v3, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->i:Z

    if-nez v3, :cond_3

    invoke-virtual {v2, p1}, Luk/co/senab/actionbarpulltorefresh/library/j;->a(Landroid/view/MotionEvent;)Z

    :cond_1
    :goto_0
    move v0, v1

    .line 140
    :cond_2
    :goto_1
    return v0

    .line 138
    :cond_3
    iget-object v3, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->l:Landroid/view/View;

    if-eqz v3, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    goto :goto_0

    :pswitch_0
    iget-object v0, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->l:Landroid/view/View;

    iget-boolean v3, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->i:Z

    if-eqz v3, :cond_4

    iget-boolean v3, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->n:Z

    if-eqz v3, :cond_4

    if-eqz v0, :cond_4

    iget v3, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->g:F

    iget v4, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->h:F

    sub-float/2addr v3, v4

    invoke-virtual {v2, v0}, Luk/co/senab/actionbarpulltorefresh/library/j;->a(Landroid/view/View;)F

    move-result v0

    cmpl-float v0, v3, v0

    if-ltz v0, :cond_4

    invoke-virtual {v2, v1, v1}, Luk/co/senab/actionbarpulltorefresh/library/j;->a(ZZ)V

    :cond_4
    iget-boolean v0, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->i:Z

    if-eqz v0, :cond_5

    invoke-virtual {v2}, Luk/co/senab/actionbarpulltorefresh/library/j;->c()V

    :cond_5
    invoke-virtual {v2}, Luk/co/senab/actionbarpulltorefresh/library/j;->b()V

    goto :goto_0

    :pswitch_1
    iget-boolean v3, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->j:Z

    if-nez v3, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iget-boolean v3, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->i:Z

    if-eqz v3, :cond_1

    iget v3, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->g:F

    cmpl-float v3, v0, v3

    if-eqz v3, :cond_1

    iget v3, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->g:F

    sub-float v3, v0, v3

    iget v4, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->f:I

    neg-int v4, v4

    int-to-float v4, v4

    cmpl-float v4, v3, v4

    if-ltz v4, :cond_8

    iget-object v4, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->l:Landroid/view/View;

    invoke-virtual {v2, v4}, Luk/co/senab/actionbarpulltorefresh/library/j;->a(Landroid/view/View;)F

    move-result v4

    iget v5, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->h:F

    sub-float v5, v0, v5

    cmpg-float v6, v5, v4

    if-gez v6, :cond_6

    iget-object v6, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->a:Luk/co/senab/actionbarpulltorefresh/library/f;

    div-float v4, v5, v4

    invoke-virtual {v6, v4}, Luk/co/senab/actionbarpulltorefresh/library/f;->a(F)V

    :goto_2
    const/4 v4, 0x0

    cmpl-float v3, v3, v4

    if-lez v3, :cond_1

    iput v0, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->g:F

    goto :goto_0

    :cond_6
    iget-boolean v4, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->n:Z

    if-eqz v4, :cond_7

    iget-object v4, v2, Luk/co/senab/actionbarpulltorefresh/library/j;->a:Luk/co/senab/actionbarpulltorefresh/library/f;

    invoke-virtual {v4}, Luk/co/senab/actionbarpulltorefresh/library/f;->c()V

    goto :goto_2

    :cond_7
    invoke-virtual {v2, v1, v1}, Luk/co/senab/actionbarpulltorefresh/library/j;->a(ZZ)V

    goto :goto_2

    :cond_8
    invoke-virtual {v2}, Luk/co/senab/actionbarpulltorefresh/library/j;->c()V

    invoke-virtual {v2}, Luk/co/senab/actionbarpulltorefresh/library/j;->b()V

    goto/16 :goto_0

    .line 140
    :cond_9
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto/16 :goto_1

    .line 138
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final setHeaderViewListener(Luk/co/senab/actionbarpulltorefresh/library/a/a;)V
    .locals 1

    .prologue
    .line 99
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a()V

    .line 100
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    iput-object p1, v0, Luk/co/senab/actionbarpulltorefresh/library/j;->e:Luk/co/senab/actionbarpulltorefresh/library/a/a;

    .line 101
    return-void
.end method

.method setPullToRefreshAttacher(Luk/co/senab/actionbarpulltorefresh/library/j;)V
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    if-eqz v0, :cond_0

    .line 167
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    invoke-virtual {v0}, Luk/co/senab/actionbarpulltorefresh/library/j;->a()V

    .line 169
    :cond_0
    iput-object p1, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    .line 170
    return-void
.end method

.method public final setRefreshing(Z)V
    .locals 2

    .prologue
    .line 69
    invoke-virtual {p0}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a()V

    .line 70
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Luk/co/senab/actionbarpulltorefresh/library/j;->a(ZZ)V

    .line 71
    return-void
.end method
