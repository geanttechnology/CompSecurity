.class Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;
.super Ljava/lang/Object;
.source "SplitProduct.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/SplitProduct;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SplitItemSelectionListener"
.end annotation


# instance fields
.field private asin:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;Ljava/lang/String;)V
    .locals 0
    .param p2, "asin"    # Ljava/lang/String;

    .prologue
    .line 200
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 201
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;->asin:Ljava/lang/String;

    .line 202
    return-void
.end method


# virtual methods
.method public onResultItemSelected(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)V
    .locals 3
    .param p1, "resultItem"    # Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    .prologue
    .line 207
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;->asin:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;->asin:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->asin:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->access$100(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;->asin:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;->getAsin()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->updateIndicator(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->access$200(Lcom/amazon/retailsearch/android/ui/results/SplitProduct;Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct$SplitItemSelectionListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    invoke-interface {v0, p0}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->removeListener(Lcom/amazon/retailsearch/android/api/display/results/listeners/ResultItemSelectionListener;)V

    .line 212
    return-void
.end method
