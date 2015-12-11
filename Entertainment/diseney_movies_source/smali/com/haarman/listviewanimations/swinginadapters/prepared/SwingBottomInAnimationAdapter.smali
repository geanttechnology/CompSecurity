.class public Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
.super Lcom/haarman/listviewanimations/swinginadapters/SingleAnimationAdapter;
.source "SwingBottomInAnimationAdapter.java"


# instance fields
.field private final mAnimationDelayMillis:J

.field private final mAnimationDurationMillis:J


# direct methods
.method public constructor <init>(Landroid/widget/BaseAdapter;)V
    .locals 6
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;

    .prologue
    .line 36
    const-wide/16 v2, 0x64

    const-wide/16 v4, 0x12c

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;JJ)V

    .line 37
    return-void
.end method

.method public constructor <init>(Landroid/widget/BaseAdapter;J)V
    .locals 6
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;
    .param p2, "animationDelayMillis"    # J

    .prologue
    .line 40
    const-wide/16 v4, 0x12c

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;JJ)V

    .line 41
    return-void
.end method

.method public constructor <init>(Landroid/widget/BaseAdapter;JJ)V
    .locals 0
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;
    .param p2, "animationDelayMillis"    # J
    .param p4, "animationDurationMillis"    # J

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/haarman/listviewanimations/swinginadapters/SingleAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 45
    iput-wide p2, p0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->mAnimationDelayMillis:J

    .line 46
    iput-wide p4, p0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->mAnimationDurationMillis:J

    .line 47
    return-void
.end method


# virtual methods
.method protected getAnimationDelayMillis()J
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->mAnimationDelayMillis:J

    return-wide v0
.end method

.method protected getAnimationDurationMillis()J
    .locals 2

    .prologue
    .line 56
    iget-wide v0, p0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->mAnimationDurationMillis:J

    return-wide v0
.end method

.method protected getAnimator(Landroid/view/ViewGroup;Landroid/view/View;)Lcom/nineoldandroids/animation/Animator;
    .locals 2
    .param p1, "parent"    # Landroid/view/ViewGroup;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 61
    const-string v0, "translationY"

    const/4 v1, 0x2

    new-array v1, v1, [F

    fill-array-data v1, :array_0

    invoke-static {p2, v0, v1}, Lcom/nineoldandroids/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Lcom/nineoldandroids/animation/ObjectAnimator;

    move-result-object v0

    return-object v0

    nop

    :array_0
    .array-data 4
        0x43fa0000    # 500.0f
        0x0
    .end array-data
.end method
