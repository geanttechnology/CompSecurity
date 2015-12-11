.class public abstract Lcom/haarman/listviewanimations/swinginadapters/ResourceAnimationAdapter;
.super Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;
.source "ResourceAnimationAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;"
    }
.end annotation


# instance fields
.field private mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/widget/BaseAdapter;Landroid/content/Context;)V
    .locals 0
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 35
    .local p0, "this":Lcom/haarman/listviewanimations/swinginadapters/ResourceAnimationAdapter;, "Lcom/haarman/listviewanimations/swinginadapters/ResourceAnimationAdapter<TT;>;"
    invoke-direct {p0, p1}, Lcom/haarman/listviewanimations/swinginadapters/AnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 36
    iput-object p2, p0, Lcom/haarman/listviewanimations/swinginadapters/ResourceAnimationAdapter;->mContext:Landroid/content/Context;

    .line 37
    return-void
.end method


# virtual methods
.method protected abstract getAnimationResourceId()I
.end method

.method public getAnimators(Landroid/view/ViewGroup;Landroid/view/View;)[Lcom/nineoldandroids/animation/Animator;
    .locals 4
    .param p1, "parent"    # Landroid/view/ViewGroup;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 41
    .local p0, "this":Lcom/haarman/listviewanimations/swinginadapters/ResourceAnimationAdapter;, "Lcom/haarman/listviewanimations/swinginadapters/ResourceAnimationAdapter<TT;>;"
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/nineoldandroids/animation/Animator;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/haarman/listviewanimations/swinginadapters/ResourceAnimationAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/haarman/listviewanimations/swinginadapters/ResourceAnimationAdapter;->getAnimationResourceId()I

    move-result v3

    invoke-static {v2, v3}, Lcom/nineoldandroids/animation/AnimatorInflater;->loadAnimator(Landroid/content/Context;I)Lcom/nineoldandroids/animation/Animator;

    move-result-object v2

    aput-object v2, v0, v1

    return-object v0
.end method
