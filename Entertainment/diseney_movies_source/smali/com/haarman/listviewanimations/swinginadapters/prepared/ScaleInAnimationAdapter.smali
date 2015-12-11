.class public Lcom/haarman/listviewanimations/swinginadapters/prepared/ScaleInAnimationAdapter;
.super Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;
.source "ScaleInAnimationAdapter.java"


# static fields
.field private static final DEFAULTSCALEFROM:F = 0.8f


# instance fields
.field private mAnimationDelayMillis:J

.field private mAnimationDurationMillis:J

.field private mScaleFrom:F


# direct methods
.method public constructor <init>(Landroid/widget/BaseAdapter;)V
    .locals 1
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;

    .prologue
    .line 35
    const v0, 0x3f4ccccd    # 0.8f

    invoke-direct {p0, p1, v0}, Lcom/haarman/listviewanimations/swinginadapters/prepared/ScaleInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;F)V

    .line 36
    return-void
.end method

.method public constructor <init>(Landroid/widget/BaseAdapter;F)V
    .locals 7
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;
    .param p2, "scaleFrom"    # F

    .prologue
    .line 39
    const-wide/16 v3, 0x64

    const-wide/16 v5, 0x12c

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    invoke-direct/range {v0 .. v6}, Lcom/haarman/listviewanimations/swinginadapters/prepared/ScaleInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;FJJ)V

    .line 40
    return-void
.end method

.method public constructor <init>(Landroid/widget/BaseAdapter;FJJ)V
    .locals 0
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;
    .param p2, "scaleFrom"    # F
    .param p3, "animationDelayMillis"    # J
    .param p5, "animationDurationMillis"    # J

    .prologue
    .line 43
    invoke-direct {p0, p1}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 44
    iput p2, p0, Lcom/haarman/listviewanimations/swinginadapters/prepared/ScaleInAnimationAdapter;->mScaleFrom:F

    .line 45
    iput-wide p3, p0, Lcom/haarman/listviewanimations/swinginadapters/prepared/ScaleInAnimationAdapter;->mAnimationDelayMillis:J

    .line 46
    iput-wide p5, p0, Lcom/haarman/listviewanimations/swinginadapters/prepared/ScaleInAnimationAdapter;->mAnimationDurationMillis:J

    .line 47
    return-void
.end method


# virtual methods
.method protected getAnimationDelayMillis()J
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/haarman/listviewanimations/swinginadapters/prepared/ScaleInAnimationAdapter;->mAnimationDelayMillis:J

    return-wide v0
.end method

.method protected getAnimationDurationMillis()J
    .locals 2

    .prologue
    .line 56
    iget-wide v0, p0, Lcom/haarman/listviewanimations/swinginadapters/prepared/ScaleInAnimationAdapter;->mAnimationDurationMillis:J

    return-wide v0
.end method

.method public getAnimators(Landroid/view/ViewGroup;Landroid/view/View;)[Lcom/nineoldandroids/animation/Animator;
    .locals 9
    .param p1, "parent"    # Landroid/view/ViewGroup;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    const/high16 v8, 0x3f800000    # 1.0f

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 61
    const-string v2, "scaleX"

    new-array v3, v7, [F

    iget v4, p0, Lcom/haarman/listviewanimations/swinginadapters/prepared/ScaleInAnimationAdapter;->mScaleFrom:F

    aput v4, v3, v5

    aput v8, v3, v6

    invoke-static {p2, v2, v3}, Lcom/nineoldandroids/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Lcom/nineoldandroids/animation/ObjectAnimator;

    move-result-object v0

    .line 62
    .local v0, "scaleX":Lcom/nineoldandroids/animation/ObjectAnimator;
    const-string v2, "scaleY"

    new-array v3, v7, [F

    iget v4, p0, Lcom/haarman/listviewanimations/swinginadapters/prepared/ScaleInAnimationAdapter;->mScaleFrom:F

    aput v4, v3, v5

    aput v8, v3, v6

    invoke-static {p2, v2, v3}, Lcom/nineoldandroids/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Lcom/nineoldandroids/animation/ObjectAnimator;

    move-result-object v1

    .line 63
    .local v1, "scaleY":Lcom/nineoldandroids/animation/ObjectAnimator;
    new-array v2, v7, [Lcom/nineoldandroids/animation/ObjectAnimator;

    aput-object v0, v2, v5

    aput-object v1, v2, v6

    return-object v2
.end method
