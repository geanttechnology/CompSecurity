.class Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "SplitProduct.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/SplitProduct;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SplitProductGestureListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)V
    .locals 0

    .prologue
    .line 221
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;Lcom/amazon/retailsearch/android/ui/results/SplitProduct$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/SplitProduct;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/SplitProduct$1;

    .prologue
    .line 221
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)V

    return-void
.end method


# virtual methods
.method public onSingleTapConfirmed(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 226
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->selectionIndicator:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->access$300(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)Landroid/widget/ImageView;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 228
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->selectionIndicator:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->access$300(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)Landroid/widget/ImageView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mArrowGenerator:Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->access$500(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mOrientation:I
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->access$400(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->getArrow(I)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 231
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->asin:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->access$100(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V

    .line 232
    invoke-super {p0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onSingleTapUp(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method
