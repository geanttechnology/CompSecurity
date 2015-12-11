.class Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$4;
.super Ljava/lang/Object;
.source "StackLayout.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createProductImageFactory()Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)V
    .locals 0

    .prologue
    .line 1005
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$4;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public fromUrl(Ljava/lang/String;)Lcom/amazon/ansel/fetch/ImageRequest;
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 1008
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1009
    const/4 v1, 0x0

    .line 1014
    :goto_0
    return-object v1

    .line 1012
    :cond_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$4;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageSize:Landroid/graphics/Point;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$900(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Landroid/graphics/Point;

    move-result-object v1

    iget v1, v1, Landroid/graphics/Point;->x:I

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$4;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageSize:Landroid/graphics/Point;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$900(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Landroid/graphics/Point;

    move-result-object v2

    iget v2, v2, Landroid/graphics/Point;->y:I

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 1013
    .local v0, "size":I
    invoke-static {p1, v0}, Lcom/amazon/searchapp/retailsearch/client/MsaUtil;->setImageRes(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object p1

    .line 1014
    new-instance v1, Lcom/amazon/ansel/fetch/ImageRequest;

    new-instance v2, Lcom/amazon/ansel/fetch/UriRequest;

    invoke-direct {v2, p1}, Lcom/amazon/ansel/fetch/UriRequest;-><init>(Ljava/lang/String;)V

    const/16 v3, 0xa0

    invoke-direct {v1, v2, v3}, Lcom/amazon/ansel/fetch/ImageRequest;-><init>(Lcom/amazon/ansel/fetch/UriRequest;I)V

    goto :goto_0
.end method
