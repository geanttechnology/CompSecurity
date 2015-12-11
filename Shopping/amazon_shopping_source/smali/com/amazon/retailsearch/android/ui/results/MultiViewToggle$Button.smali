.class Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;
.super Ljava/lang/Object;
.source "MultiViewToggle.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Button"
.end annotation


# instance fields
.field private image:Landroid/widget/ImageView;

.field private imageId:I

.field private selectedImageId:I

.field private viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewType;III)V
    .locals 4
    .param p1, "selector"    # Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .param p3, "imageId"    # I
    .param p4, "selectedImageId"    # I
    .param p5, "contentDescriptionId"    # I

    .prologue
    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    new-instance v1, Landroid/widget/ImageView;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->image:Landroid/widget/ImageView;

    .line 128
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$dimen;->padding_b:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 129
    .local v0, "padding":I
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->image:Landroid/widget/ImageView;

    invoke-virtual {v1, v0, v0, v0, v0}, Landroid/widget/ImageView;->setPadding(IIII)V

    .line 131
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->image:Landroid/widget/ImageView;

    new-instance v2, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;

    const/4 v3, 0x0

    invoke-direct {v2, p1, p2, v3}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewType;Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$1;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 132
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->image:Landroid/widget/ImageView;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, p5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 134
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 135
    iput p3, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->imageId:I

    .line 136
    iput p4, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->selectedImageId:I

    .line 137
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewType;IIILcom/amazon/retailsearch/android/ui/results/MultiViewToggle$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .param p3, "x2"    # I
    .param p4, "x3"    # I
    .param p5, "x4"    # I
    .param p6, "x5"    # Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$1;

    .prologue
    .line 117
    invoke-direct/range {p0 .. p5}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;-><init>(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewType;III)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;

    .prologue
    .line 117
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->image:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;)Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;

    .prologue
    .line 117
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;

    .prologue
    .line 117
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->selectedImageId:I

    return v0
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;

    .prologue
    .line 117
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$Button;->imageId:I

    return v0
.end method
