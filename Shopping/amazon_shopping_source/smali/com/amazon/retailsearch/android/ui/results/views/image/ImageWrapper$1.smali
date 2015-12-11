.class Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;
.super Lcom/amazon/ansel/fetch/AbstractResourceListener;
.source "ImageWrapper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->loadAndShowImage(Lcom/amazon/ansel/fetch/ImageRequest;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/ansel/fetch/AbstractResourceListener",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

.field final synthetic val$imageRequest:Lcom/amazon/ansel/fetch/ImageRequest;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;Lcom/amazon/ansel/fetch/ImageRequest;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;->val$imageRequest:Lcom/amazon/ansel/fetch/ImageRequest;

    invoke-direct {p0}, Lcom/amazon/ansel/fetch/AbstractResourceListener;-><init>()V

    return-void
.end method


# virtual methods
.method public result(Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "image"    # Landroid/graphics/Bitmap;

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->imageListener:Lcom/amazon/ansel/fetch/ResourceListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;)Lcom/amazon/ansel/fetch/ResourceListener;

    move-result-object v0

    if-ne v0, p0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;->val$imageRequest:Lcom/amazon/ansel/fetch/ImageRequest;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->activeImageRequest:Lcom/amazon/ansel/fetch/ImageRequest;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;)Lcom/amazon/ansel/fetch/ImageRequest;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/retailsearch/util/Utils;->isEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 157
    :cond_0
    :goto_0
    return-void

    .line 149
    :cond_1
    if-nez p1, :cond_2

    .line 151
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->hideImage()V

    goto :goto_0

    .line 155
    :cond_2
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->activeImageRequest:Lcom/amazon/ansel/fetch/ImageRequest;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;)Lcom/amazon/ansel/fetch/ImageRequest;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->showImage(Lcom/amazon/ansel/fetch/ImageRequest;Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method

.method public bridge synthetic result(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 140
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;->result(Landroid/graphics/Bitmap;)V

    return-void
.end method
