.class Lit/sephiroth/android/library/widget/AbsHListView$2;
.super Ljava/lang/Object;
.source "AbsHListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lit/sephiroth/android/library/widget/AbsHListView;->clearScrollingCache()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lit/sephiroth/android/library/widget/AbsHListView;


# direct methods
.method constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;)V
    .locals 0

    .prologue
    .line 4525
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$2;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 4529
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$2;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCachingStarted:Z

    if-eqz v0, :cond_1

    .line 4530
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$2;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$2;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iput-boolean v2, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mCachingActive:Z

    iput-boolean v2, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mCachingStarted:Z

    .line 4531
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$2;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->setChildrenDrawnWithCacheEnabled(Z)V
    invoke-static {v0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->access$2000(Lit/sephiroth/android/library/widget/AbsHListView;Z)V

    .line 4532
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$2;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->getPersistentDrawingCache()I

    move-result v0

    and-int/lit8 v0, v0, 0x2

    if-nez v0, :cond_0

    .line 4533
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$2;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->setChildrenDrawingCacheEnabled(Z)V
    invoke-static {v0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->access$2100(Lit/sephiroth/android/library/widget/AbsHListView;Z)V

    .line 4535
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$2;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->isAlwaysDrawnWithCacheEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 4536
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$2;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 4539
    :cond_1
    return-void
.end method
