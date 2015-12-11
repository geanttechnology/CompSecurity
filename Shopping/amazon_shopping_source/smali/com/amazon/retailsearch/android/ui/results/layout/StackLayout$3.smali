.class Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;
.super Lcom/amazon/ansel/fetch/AbstractResourceListener;
.source "StackLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loadAtfImage(Lcom/amazon/searchapp/retailsearch/model/Image;)V
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
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)V
    .locals 0

    .prologue
    .line 749
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-direct {p0}, Lcom/amazon/ansel/fetch/AbstractResourceListener;-><init>()V

    return-void
.end method


# virtual methods
.method public result(Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "image"    # Landroid/graphics/Bitmap;

    .prologue
    .line 753
    if-eqz p1, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$500(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->atfImageListeners:Ljava/util/List;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$600(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 765
    :cond_0
    :goto_0
    return-void

    .line 758
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$500(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getAtfImagesLoadedCount()I

    move-result v1

    add-int/lit8 v0, v1, 0x1

    .line 759
    .local v0, "atfImagesLoadedCount":I
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$500(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setAtfImagesLoadedCount(I)V

    .line 760
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->atfProductCount:I
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$700(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I

    move-result v1

    if-lt v0, v1, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$800(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 763
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$800(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->searchATFReached()V

    goto :goto_0
.end method

.method public bridge synthetic result(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 749
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;->result(Landroid/graphics/Bitmap;)V

    return-void
.end method
