.class public abstract Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;
.super Lcom/haarman/listviewanimations/BaseAdapterDecorator;
.source "AnimationAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;
    }
.end annotation


# static fields
.field protected static final DEFAULTANIMATIONDELAYMILLIS:J = 0x64L

.field protected static final DEFAULTANIMATIONDURATIONMILLIS:J = 0x12cL

.field private static final INITIALDELAYMILLIS:J = 0x96L


# instance fields
.field private mAnimationStartMillis:J

.field private mAnimators:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mHasParentAnimationAdapter:Z

.field private mLastAnimatedPosition:I


# direct methods
.method public constructor <init>(Landroid/widget/BaseAdapter;)V
    .locals 2
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;

    .prologue
    .line 48
    invoke-direct {p0, p1}, Lcom/haarman/listviewanimations/BaseAdapterDecorator;-><init>(Landroid/widget/BaseAdapter;)V

    .line 49
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mAnimators:Landroid/util/SparseArray;

    .line 51
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mAnimationStartMillis:J

    .line 52
    const/4 v0, -0x1

    iput v0, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mLastAnimatedPosition:I

    .line 54
    instance-of v0, p1, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;

    if-eqz v0, :cond_0

    .line 55
    check-cast p1, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;

    .end local p1    # "baseAdapter":Landroid/widget/BaseAdapter;
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->setHasParentAnimationAdapter(Z)V

    .line 57
    :cond_0
    return-void
.end method

.method private animateView(ILandroid/view/ViewGroup;Landroid/view/View;)V
    .locals 8
    .param p1, "position"    # I
    .param p2, "parent"    # Landroid/view/ViewGroup;
    .param p3, "view"    # Landroid/view/View;

    .prologue
    .line 113
    iget-wide v4, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mAnimationStartMillis:J

    const-wide/16 v6, -0x1

    cmp-long v4, v4, v6

    if-nez v4, :cond_0

    .line 114
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mAnimationStartMillis:J

    .line 117
    :cond_0
    invoke-direct {p0, p3}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->hideView(Landroid/view/View;)V

    .line 120
    iget-object v4, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    instance-of v4, v4, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;

    if-eqz v4, :cond_1

    .line 121
    iget-object v4, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    check-cast v4, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;

    invoke-virtual {v4, p2, p3}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->getAnimators(Landroid/view/ViewGroup;Landroid/view/View;)[Lcom/nineoldandroids/animation/Animator;

    move-result-object v2

    .line 125
    .local v2, "childAnimators":[Lcom/nineoldandroids/animation/Animator;
    :goto_0
    invoke-virtual {p0, p2, p3}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->getAnimators(Landroid/view/ViewGroup;Landroid/view/View;)[Lcom/nineoldandroids/animation/Animator;

    move-result-object v1

    .line 126
    .local v1, "animators":[Lcom/nineoldandroids/animation/Animator;
    const-string v4, "alpha"

    const/4 v5, 0x2

    new-array v5, v5, [F

    fill-array-data v5, :array_0

    invoke-static {p3, v4, v5}, Lcom/nineoldandroids/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Lcom/nineoldandroids/animation/ObjectAnimator;

    move-result-object v0

    .line 128
    .local v0, "alphaAnimator":Lcom/nineoldandroids/animation/Animator;
    new-instance v3, Lcom/nineoldandroids/animation/AnimatorSet;

    invoke-direct {v3}, Lcom/nineoldandroids/animation/AnimatorSet;-><init>()V

    .line 129
    .local v3, "set":Lcom/nineoldandroids/animation/AnimatorSet;
    invoke-direct {p0, v2, v1, v0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->concatAnimators([Lcom/nineoldandroids/animation/Animator;[Lcom/nineoldandroids/animation/Animator;Lcom/nineoldandroids/animation/Animator;)[Lcom/nineoldandroids/animation/Animator;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/nineoldandroids/animation/AnimatorSet;->playTogether([Lcom/nineoldandroids/animation/Animator;)V

    .line 130
    invoke-direct {p0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->calculateAnimationDelay()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Lcom/nineoldandroids/animation/AnimatorSet;->setStartDelay(J)V

    .line 131
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->getAnimationDurationMillis()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Lcom/nineoldandroids/animation/AnimatorSet;->setDuration(J)Lcom/nineoldandroids/animation/AnimatorSet;

    .line 132
    invoke-virtual {v3}, Lcom/nineoldandroids/animation/AnimatorSet;->start()V

    .line 134
    iget-object v4, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mAnimators:Landroid/util/SparseArray;

    invoke-virtual {p3}, Ljava/lang/Object;->hashCode()I

    move-result v5

    new-instance v6, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;

    invoke-direct {v6, p0, p1, v3}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;-><init>(Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;ILcom/nineoldandroids/animation/Animator;)V

    invoke-virtual {v4, v5, v6}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 135
    return-void

    .line 123
    .end local v0    # "alphaAnimator":Lcom/nineoldandroids/animation/Animator;
    .end local v1    # "animators":[Lcom/nineoldandroids/animation/Animator;
    .end local v2    # "childAnimators":[Lcom/nineoldandroids/animation/Animator;
    .end local v3    # "set":Lcom/nineoldandroids/animation/AnimatorSet;
    :cond_1
    const/4 v4, 0x0

    new-array v2, v4, [Lcom/nineoldandroids/animation/Animator;

    .restart local v2    # "childAnimators":[Lcom/nineoldandroids/animation/Animator;
    goto :goto_0

    .line 126
    nop

    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method private animateViewIfNecessary(ILandroid/view/View;Landroid/view/ViewGroup;)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 106
    iget v0, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mLastAnimatedPosition:I

    if-le p1, v0, :cond_0

    iget-boolean v0, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mHasParentAnimationAdapter:Z

    if-nez v0, :cond_0

    .line 107
    invoke-direct {p0, p1, p3, p2}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->animateView(ILandroid/view/ViewGroup;Landroid/view/View;)V

    .line 108
    iput p1, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mLastAnimatedPosition:I

    .line 110
    :cond_0
    return-void
.end method

.method private calculateAnimationDelay()J
    .locals 9

    .prologue
    .line 165
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->getListView()Landroid/widget/ListView;

    move-result-object v5

    invoke-virtual {v5}, Landroid/widget/ListView;->getLastVisiblePosition()I

    move-result v5

    .line 166
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->getListView()Landroid/widget/ListView;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v6

    .line 165
    sub-int v4, v5, v6

    .line 167
    .local v4, "numberOfItems":I
    add-int/lit8 v5, v4, 0x1

    iget v6, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mLastAnimatedPosition:I

    if-ge v5, v6, :cond_0

    .line 168
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->getAnimationDelayMillis()J

    move-result-wide v0

    .line 174
    .local v0, "delay":J
    :goto_0
    const-wide/16 v5, 0x0

    invoke-static {v5, v6, v0, v1}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v5

    return-wide v5

    .line 170
    .end local v0    # "delay":J
    :cond_0
    iget v5, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mLastAnimatedPosition:I

    add-int/lit8 v5, v5, 0x1

    int-to-long v5, v5

    invoke-virtual {p0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->getAnimationDelayMillis()J

    move-result-wide v7

    mul-long v2, v5, v7

    .line 171
    .local v2, "delaySinceStart":J
    iget-wide v5, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mAnimationStartMillis:J

    const-wide/16 v7, 0x96

    add-long/2addr v5, v7

    add-long/2addr v5, v2

    .line 172
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    .line 171
    sub-long v0, v5, v7

    .restart local v0    # "delay":J
    goto :goto_0
.end method

.method private concatAnimators([Lcom/nineoldandroids/animation/Animator;[Lcom/nineoldandroids/animation/Animator;Lcom/nineoldandroids/animation/Animator;)[Lcom/nineoldandroids/animation/Animator;
    .locals 5
    .param p1, "childAnimators"    # [Lcom/nineoldandroids/animation/Animator;
    .param p2, "animators"    # [Lcom/nineoldandroids/animation/Animator;
    .param p3, "alphaAnimator"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 147
    array-length v3, p1

    array-length v4, p2

    add-int/2addr v3, v4

    add-int/lit8 v3, v3, 0x1

    new-array v0, v3, [Lcom/nineoldandroids/animation/Animator;

    .line 150
    .local v0, "allAnimators":[Lcom/nineoldandroids/animation/Animator;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, p2

    if-lt v1, v3, :cond_0

    .line 154
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_1
    array-length v3, p1

    if-lt v2, v3, :cond_1

    .line 159
    array-length v3, v0

    add-int/lit8 v3, v3, -0x1

    aput-object p3, v0, v3

    .line 160
    return-object v0

    .line 151
    .end local v2    # "j":I
    :cond_0
    aget-object v3, p2, v1

    aput-object v3, v0, v1

    .line 150
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 155
    .restart local v2    # "j":I
    :cond_1
    aget-object v3, p1, v2

    aput-object v3, v0, v1

    .line 156
    add-int/lit8 v1, v1, 0x1

    .line 154
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method private hideView(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 138
    const-string v2, "alpha"

    const/4 v3, 0x1

    new-array v3, v3, [F

    const/4 v4, 0x0

    const/4 v5, 0x0

    aput v5, v3, v4

    invoke-static {p1, v2, v3}, Lcom/nineoldandroids/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Lcom/nineoldandroids/animation/ObjectAnimator;

    move-result-object v0

    .line 139
    .local v0, "animator":Lcom/nineoldandroids/animation/ObjectAnimator;
    new-instance v1, Lcom/nineoldandroids/animation/AnimatorSet;

    invoke-direct {v1}, Lcom/nineoldandroids/animation/AnimatorSet;-><init>()V

    .line 140
    .local v1, "set":Lcom/nineoldandroids/animation/AnimatorSet;
    invoke-virtual {v1, v0}, Lcom/nineoldandroids/animation/AnimatorSet;->play(Lcom/nineoldandroids/animation/Animator;)Lcom/nineoldandroids/animation/AnimatorSet$Builder;

    .line 141
    const-wide/16 v2, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/nineoldandroids/animation/AnimatorSet;->setDuration(J)Lcom/nineoldandroids/animation/AnimatorSet;

    .line 142
    invoke-virtual {v1}, Lcom/nineoldandroids/animation/AnimatorSet;->start()V

    .line 143
    return-void
.end method


# virtual methods
.method protected abstract getAnimationDelayMillis()J
.end method

.method protected abstract getAnimationDurationMillis()J
.end method

.method public abstract getAnimators(Landroid/view/ViewGroup;Landroid/view/View;)[Lcom/nineoldandroids/animation/Animator;
.end method

.method public final getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 76
    const/4 v0, 0x0

    .line 78
    .local v0, "alreadyStarted":Z
    iget-boolean v4, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mHasParentAnimationAdapter:Z

    if-nez v4, :cond_0

    .line 80
    const-string v4, "Call setListView() on this AnimationAdapter before setAdapter()!"

    .line 81
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->getListView()Landroid/widget/ListView;

    move-result-object v5

    .line 79
    invoke-static {v4, v5}, Ljunit/framework/Assert;->assertNotNull(Ljava/lang/String;Ljava/lang/Object;)V

    .line 83
    if-eqz p2, :cond_0

    .line 84
    invoke-virtual {p2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    .line 85
    .local v2, "hashCode":I
    iget-object v4, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mAnimators:Landroid/util/SparseArray;

    invoke-virtual {v4, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;

    .line 86
    .local v1, "animationInfo":Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;
    if-eqz v1, :cond_0

    .line 87
    iget v4, v1, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;->position:I

    if-eq v4, p1, :cond_2

    .line 88
    iget-object v4, v1, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;->animator:Lcom/nineoldandroids/animation/Animator;

    invoke-virtual {v4}, Lcom/nineoldandroids/animation/Animator;->end()V

    .line 89
    iget-object v4, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mAnimators:Landroid/util/SparseArray;

    invoke-virtual {v4, v2}, Landroid/util/SparseArray;->remove(I)V

    .line 97
    .end local v1    # "animationInfo":Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;
    .end local v2    # "hashCode":I
    :cond_0
    :goto_0
    invoke-super {p0, p1, p2, p3}, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 99
    .local v3, "itemView":Landroid/view/View;
    iget-boolean v4, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mHasParentAnimationAdapter:Z

    if-nez v4, :cond_1

    if-nez v0, :cond_1

    .line 100
    invoke-direct {p0, p1, v3, p3}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->animateViewIfNecessary(ILandroid/view/View;Landroid/view/ViewGroup;)V

    .line 102
    :cond_1
    return-object v3

    .line 91
    .end local v3    # "itemView":Landroid/view/View;
    .restart local v1    # "animationInfo":Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter$AnimationInfo;
    .restart local v2    # "hashCode":I
    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public reset()V
    .locals 2

    .prologue
    .line 65
    iget-object v0, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mAnimators:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 66
    const/4 v0, -0x1

    iput v0, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mLastAnimatedPosition:I

    .line 67
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mAnimationStartMillis:J

    .line 69
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->getDecoratedBaseAdapter()Landroid/widget/BaseAdapter;

    move-result-object v0

    instance-of v0, v0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;

    if-eqz v0, :cond_0

    .line 70
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->getDecoratedBaseAdapter()Landroid/widget/BaseAdapter;

    move-result-object v0

    check-cast v0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;

    invoke-virtual {v0}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->reset()V

    .line 72
    :cond_0
    return-void
.end method

.method public setHasParentAnimationAdapter(Z)V
    .locals 0
    .param p1, "hasParentAnimationAdapter"    # Z

    .prologue
    .line 184
    iput-boolean p1, p0, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;->mHasParentAnimationAdapter:Z

    .line 185
    return-void
.end method
