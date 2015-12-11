.class Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller$1;
.super Ljava/lang/Object;
.source "AbsHListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->start(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

.field final synthetic val$position:I


# direct methods
.method constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;I)V
    .locals 0

    .prologue
    .line 3936
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller$1;->this$1:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    iput p2, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller$1;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 3940
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller$1;->this$1:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller$1;->val$position:I

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->start(I)V

    .line 3941
    return-void
.end method
