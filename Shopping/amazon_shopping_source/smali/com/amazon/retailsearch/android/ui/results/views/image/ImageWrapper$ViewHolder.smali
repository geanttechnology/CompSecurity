.class Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;
.super Ljava/lang/Object;
.source "ImageWrapper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ViewHolder"
.end annotation


# instance fields
.field public displayedImage:Lcom/amazon/ansel/fetch/ImageRequest;

.field public imageView:Landroid/widget/ImageView;

.field public thumbSwitcher:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 227
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;

    .prologue
    .line 227
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;-><init>()V

    return-void
.end method
