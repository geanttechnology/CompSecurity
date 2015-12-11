.class Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;
.super Ljava/lang/Object;
.source "AdapterView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/AdapterView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SelectionNotifier"
.end annotation


# instance fields
.field final synthetic this$0:Lit/sephiroth/android/library/widget/AdapterView;


# direct methods
.method private constructor <init>(Lit/sephiroth/android/library/widget/AdapterView;)V
    .locals 0

    .prologue
    .line 878
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>.SelectionNotifier;"
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lit/sephiroth/android/library/widget/AdapterView;Lit/sephiroth/android/library/widget/AdapterView$1;)V
    .locals 0
    .param p1, "x0"    # Lit/sephiroth/android/library/widget/AdapterView;
    .param p2, "x1"    # Lit/sephiroth/android/library/widget/AdapterView$1;

    .prologue
    .line 878
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>.SelectionNotifier;"
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;-><init>(Lit/sephiroth/android/library/widget/AdapterView;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 882
    .local p0, "this":Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;, "Lit/sephiroth/android/library/widget/AdapterView<TT;>.SelectionNotifier;"
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    iget-boolean v0, v0, Lit/sephiroth/android/library/widget/AdapterView;->mDataChanged:Z

    if-eqz v0, :cond_1

    .line 886
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 887
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    invoke-virtual {v0, p0}, Lit/sephiroth/android/library/widget/AdapterView;->post(Ljava/lang/Runnable;)Z

    .line 893
    :cond_0
    :goto_0
    return-void

    .line 890
    :cond_1
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    # invokes: Lit/sephiroth/android/library/widget/AdapterView;->fireOnSelected()V
    invoke-static {v0}, Lit/sephiroth/android/library/widget/AdapterView;->access$200(Lit/sephiroth/android/library/widget/AdapterView;)V

    .line 891
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AdapterView$SelectionNotifier;->this$0:Lit/sephiroth/android/library/widget/AdapterView;

    # invokes: Lit/sephiroth/android/library/widget/AdapterView;->performAccessibilityActionsOnSelected()V
    invoke-static {v0}, Lit/sephiroth/android/library/widget/AdapterView;->access$300(Lit/sephiroth/android/library/widget/AdapterView;)V

    goto :goto_0
.end method
