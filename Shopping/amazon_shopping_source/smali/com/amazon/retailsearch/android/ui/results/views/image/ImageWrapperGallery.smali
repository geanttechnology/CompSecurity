.class public Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperGallery;
.super Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;
.source "ImageWrapperGallery.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 28
    return-void
.end method


# virtual methods
.method protected postInflate()V
    .locals 1

    .prologue
    .line 36
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_image:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperGallery;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperGallery;->imageView:Landroid/widget/ImageView;

    .line 39
    return-void
.end method
