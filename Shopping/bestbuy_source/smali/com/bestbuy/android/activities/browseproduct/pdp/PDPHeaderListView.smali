.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;
.super Landroid/widget/RelativeLayout;
.source "SourceFile"


# instance fields
.field private a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

.field private b:Lby;

.field private c:Landroid/widget/RelativeLayout;

.field private d:Landroid/widget/FrameLayout;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 35
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 36
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 40
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 41
    return-void
.end method

.method private a(F)F
    .locals 2

    .prologue
    .line 291
    const/4 v0, 0x1

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-static {v0, p1, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    return v0
.end method

.method public static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b:Lby;

    return-object v0
.end method

.method private a(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 5

    .prologue
    const/16 v4, 0xa

    const/4 v3, -0x1

    .line 44
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p0, v1, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    .line 45
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 46
    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 47
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    new-instance v1, Lbx;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lbx;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$1;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->setVerticalScrollBarEnabled(Z)V

    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->addView(Landroid/view/View;)V

    .line 60
    new-instance v0, Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c:Landroid/widget/RelativeLayout;

    .line 61
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v1, -0x2

    invoke-direct {v0, v3, v1}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 62
    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 63
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c:Landroid/widget/RelativeLayout;

    const/16 v1, 0x50

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setGravity(I)V

    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->addView(Landroid/view/View;)V

    .line 68
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f020178

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 69
    new-instance v1, Landroid/widget/FrameLayout;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->d:Landroid/widget/FrameLayout;

    .line 70
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    invoke-direct {v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 71
    const/16 v2, 0xb

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 72
    const/high16 v2, 0x40000000    # 2.0f

    invoke-direct {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(F)F

    move-result v2

    float-to-int v2, v2

    iput v2, v1, Landroid/widget/RelativeLayout$LayoutParams;->rightMargin:I

    .line 73
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->d:Landroid/widget/FrameLayout;

    invoke-virtual {v2, v1}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 75
    new-instance v1, Landroid/widget/ImageView;

    invoke-direct {v1, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 76
    new-instance v2, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v2, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 77
    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 78
    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->d:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->d:Landroid/widget/FrameLayout;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->addView(Landroid/view/View;)V

    .line 82
    return-void
.end method

.method public static synthetic b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    return-object v0
.end method

.method public static synthetic c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->c:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method public static synthetic d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Landroid/widget/FrameLayout;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->d:Landroid/widget/FrameLayout;

    return-object v0
.end method


# virtual methods
.method public setAdapter(Lby;)V
    .locals 1

    .prologue
    .line 85
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->b:Lby;

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 87
    return-void
.end method
