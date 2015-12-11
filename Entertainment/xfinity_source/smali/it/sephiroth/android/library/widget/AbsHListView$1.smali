.class Lit/sephiroth/android/library/widget/AbsHListView$1;
.super Ljava/lang/Object;
.source "AbsHListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lit/sephiroth/android/library/widget/AbsHListView;->onTouchEvent(Landroid/view/MotionEvent;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lit/sephiroth/android/library/widget/AbsHListView;

.field final synthetic val$child:Landroid/view/View;

.field final synthetic val$performClick:Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;


# direct methods
.method constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;)V
    .locals 0

    .prologue
    .line 3192
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$1;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iput-object p2, p0, Lit/sephiroth/android/library/widget/AbsHListView$1;->val$child:Landroid/view/View;

    iput-object p3, p0, Lit/sephiroth/android/library/widget/AbsHListView$1;->val$performClick:Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 3196
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$1;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v1, -0x1

    iput v1, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3197
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$1;->val$child:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setPressed(Z)V

    .line 3198
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$1;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->setPressed(Z)V

    .line 3199
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$1;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    if-nez v0, :cond_0

    .line 3200
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$1;->val$performClick:Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->run()V

    .line 3202
    :cond_0
    return-void
.end method
