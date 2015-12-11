.class Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;
.super Ljava/lang/Object;
.source "AbsHListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/AbsHListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "WindowRunnnable"
.end annotation


# instance fields
.field private mOriginalAttachCount:I

.field final synthetic this$0:Lit/sephiroth/android/library/widget/AbsHListView;


# direct methods
.method private constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;)V
    .locals 0

    .prologue
    .line 2479
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;Lit/sephiroth/android/library/widget/AbsHListView$1;)V
    .locals 0
    .param p1, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p2, "x1"    # Lit/sephiroth/android/library/widget/AbsHListView$1;

    .prologue
    .line 2479
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    return-void
.end method


# virtual methods
.method public rememberWindowAttachCount()V
    .locals 1

    .prologue
    .line 2484
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->getWindowAttachCount()I
    invoke-static {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->access$200(Lit/sephiroth/android/library/widget/AbsHListView;)I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;->mOriginalAttachCount:I

    .line 2485
    return-void
.end method

.method public sameWindow()Z
    .locals 2

    .prologue
    .line 2488
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->hasWindowFocus()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->getWindowAttachCount()I
    invoke-static {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->access$300(Lit/sephiroth/android/library/widget/AbsHListView;)I

    move-result v0

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;->mOriginalAttachCount:I

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
