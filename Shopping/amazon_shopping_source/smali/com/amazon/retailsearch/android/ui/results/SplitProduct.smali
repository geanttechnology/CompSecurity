.class public Lcom/amazon/retailsearch/android/ui/results/SplitProduct;
.super Lcom/amazon/retailsearch/android/ui/results/ProductView;
.source "SplitProduct.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/SplitProduct$1;,
        Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;,
        Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;
    }
.end annotation


# instance fields
.field private asin:Ljava/lang/String;

.field private byLine:Landroid/widget/TextView;

.field private mArrowGenerator:Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;

.field private mContext:Landroid/content/Context;

.field private mOrientation:I

.field private onTouchListener:Landroid/view/View$OnTouchListener;

.field private ratingsLine:Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;

.field private resultItemSelectionListener:Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

.field private selectionIndicator:Landroid/widget/ImageView;

.field protected splitGestureDetector:Landroid/view/GestureDetector;

.field private splitGestureListener:Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 64
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/ProductView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 65
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->SplitView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 66
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mContext:Landroid/content/Context;

    .line 67
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->asin:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/SplitProduct;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 29
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->updateIndicator(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->selectionIndicator:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    .prologue
    .line 29
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mOrientation:I

    return v0
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mArrowGenerator:Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;

    return-object v0
.end method

.method private updateIndicator(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "selectedAsin"    # Ljava/lang/String;

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->selectionIndicator:Landroid/widget/ImageView;

    if-nez v0, :cond_0

    .line 157
    :goto_0
    return-void

    .line 149
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 151
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->selectionIndicator:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mArrowGenerator:Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mOrientation:I

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->getArrow(I)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 155
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->selectionIndicator:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method


# virtual methods
.method protected buildView()V
    .locals 5

    .prologue
    .line 104
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->buildView()V

    .line 105
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Product;->getByLine()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 107
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->byLine:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 116
    :goto_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->ratingsLine:Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;

    if-eqz v2, :cond_0

    .line 118
    new-instance v2, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel$Builder;

    invoke-direct {v2}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel$Builder;-><init>()V

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Ratings;Landroid/content/res/Resources;)Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;

    move-result-object v0

    .line 119
    .local v0, "ratingsLineModel":Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->ratingsLine:Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v2, v0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 122
    .end local v0    # "ratingsLineModel":Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAsin()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->asin:Ljava/lang/String;

    .line 123
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v2}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->getSelectedAsin()Ljava/lang/String;

    move-result-object v1

    .line 124
    .local v1, "selectedAsin":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->asin:Ljava/lang/String;

    invoke-direct {p0, v2, v1}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->updateIndicator(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->resultItemSelectionListener:Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    if-eqz v2, :cond_1

    .line 127
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->resultItemSelectionListener:Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;

    invoke-interface {v2, v3}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V

    .line 131
    :cond_1
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->asin:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->asin:Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 133
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    new-instance v3, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->asin:Ljava/lang/String;

    invoke-direct {v3, p0, v4}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->addListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V

    .line 135
    :cond_2
    return-void

    .line 111
    .end local v1    # "selectedAsin":Ljava/lang/String;
    :cond_3
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->byLine:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Product;->getByLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 112
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->byLine:Landroid/widget/TextView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 168
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->onTouchListener:Landroid/view/View$OnTouchListener;

    if-eqz v0, :cond_0

    .line 170
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->onTouchListener:Landroid/view/View$OnTouchListener;

    invoke-interface {v0, p0, p1}, Landroid/view/View$OnTouchListener;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z

    .line 172
    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 173
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    .line 174
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->splitGestureDetector:Landroid/view/GestureDetector;

    if-eqz v0, :cond_1

    .line 176
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->splitGestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 178
    :cond_1
    const/4 v0, 0x1

    return v0
.end method

.method protected init(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 72
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->init(Landroid/content/Context;)V

    .line 73
    sget v0, Lcom/amazon/retailsearch/R$layout;->split_product_items:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 74
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;Lcom/amazon/retailsearch/android/ui/results/SplitProduct$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->splitGestureListener:Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;

    .line 75
    new-instance v0, Landroid/view/GestureDetector;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->splitGestureListener:Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitProductGestureListener;

    invoke-direct {v0, v1, v2}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->splitGestureDetector:Landroid/view/GestureDetector;

    .line 76
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;

    invoke-direct {v0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mArrowGenerator:Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;

    .line 77
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->initProductElements()V

    .line 78
    return-void
.end method

.method protected initProductElements()V
    .locals 3

    .prologue
    const/4 v2, 0x2

    const/4 v1, 0x1

    .line 83
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->initProductElements()V

    .line 84
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_item_byline:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->byLine:Landroid/widget/TextView;

    .line 85
    sget v0, Lcom/amazon/retailsearch/R$id;->arrow_selection_indicator_icon:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->selectionIndicator:Landroid/widget/ImageView;

    .line 86
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    if-ne v0, v2, :cond_1

    .line 88
    iput v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mOrientation:I

    .line 89
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_ratings:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->ratingsLine:Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;

    .line 96
    :cond_0
    :goto_0
    return-void

    .line 91
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    if-ne v0, v1, :cond_0

    .line 93
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mOrientation:I

    .line 94
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->selectionIndicator:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mArrowGenerator:Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->mOrientation:I

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/views/ArrowView;->getArrow(I)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v1

    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicHeight()I

    move-result v1

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 184
    const/4 v0, 0x0

    return v0
.end method

.method public setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    .locals 0
    .param p1, "l"    # Landroid/view/View$OnTouchListener;

    .prologue
    .line 162
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->onTouchListener:Landroid/view/View$OnTouchListener;

    .line 163
    return-void
.end method
