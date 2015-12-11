.class Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;
.super Ljava/lang/Object;
.source "FilterableProgramCollectionFragment.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;-><init>(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

.field final synthetic val$quickReturnView:Landroid/view/View;

.field final synthetic val$this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;Landroid/view/View;)V
    .locals 0
    .param p1, "this$1"    # Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    .prologue
    .line 236
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;"
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;->this$1:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    iput-object p2, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;->val$this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;

    iput-object p3, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;->val$quickReturnView:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 3

    .prologue
    .line 239
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;"
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;->val$quickReturnView:Landroid/view/View;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;->this$1:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    # getter for: Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;
    invoke-static {v1}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->access$000(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;)Landroid/graphics/Rect;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    .line 240
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;->this$1:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;->this$1:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    # getter for: Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;
    invoke-static {v1}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->access$000(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;)Landroid/graphics/Rect;

    move-result-object v1

    iget v1, v1, Landroid/graphics/Rect;->bottom:I

    iget-object v2, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;->this$1:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    # getter for: Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->referenceQuickReturnViewRect:Landroid/graphics/Rect;
    invoke-static {v2}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->access$000(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;)Landroid/graphics/Rect;

    move-result-object v2

    iget v2, v2, Landroid/graphics/Rect;->top:I

    sub-int/2addr v1, v2

    # setter for: Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnViewHeight:I
    invoke-static {v0, v1}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->access$102(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;I)I

    .line 241
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;->this$1:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    # getter for: Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->quickReturnViewHeight:I
    invoke-static {v0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->access$100(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;)I

    move-result v0

    if-lez v0, :cond_0

    .line 242
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_1

    .line 243
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;->val$quickReturnView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 248
    :cond_0
    :goto_0
    return-void

    .line 245
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1;->val$quickReturnView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    goto :goto_0
.end method
