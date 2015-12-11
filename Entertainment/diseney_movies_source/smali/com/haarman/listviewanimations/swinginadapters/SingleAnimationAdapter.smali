.class public abstract Lcom/haarman/listviewanimations/swinginadapters/SingleAnimationAdapter;
.super Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;
.source "SingleAnimationAdapter.java"


# direct methods
.method public constructor <init>(Landroid/widget/BaseAdapter;)V
    .locals 0
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;

    .prologue
    .line 31
    invoke-direct {p0, p1}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 32
    return-void
.end method


# virtual methods
.method protected abstract getAnimator(Landroid/view/ViewGroup;Landroid/view/View;)Lcom/nineoldandroids/animation/Animator;
.end method

.method public getAnimators(Landroid/view/ViewGroup;Landroid/view/View;)[Lcom/nineoldandroids/animation/Animator;
    .locals 3
    .param p1, "parent"    # Landroid/view/ViewGroup;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 36
    invoke-virtual {p0, p1, p2}, Lcom/haarman/listviewanimations/swinginadapters/SingleAnimationAdapter;->getAnimator(Landroid/view/ViewGroup;Landroid/view/View;)Lcom/nineoldandroids/animation/Animator;

    move-result-object v0

    .line 37
    .local v0, "animator":Lcom/nineoldandroids/animation/Animator;
    const/4 v1, 0x1

    new-array v1, v1, [Lcom/nineoldandroids/animation/Animator;

    const/4 v2, 0x0

    aput-object v0, v1, v2

    return-object v1
.end method
