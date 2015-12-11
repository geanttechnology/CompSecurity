.class Lcom/amazon/mShop/control/search/image/ImageSearchController$1;
.super Ljava/lang/Object;
.source "ImageSearchController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/search/image/ImageSearchController;->completed(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/search/image/ImageSearchController;

.field final synthetic val$value:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/search/image/ImageSearchController;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController$1;->this$0:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    iput-object p2, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController$1;->val$value:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 45
    iget-object v2, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController$1;->this$0:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    # invokes: Lcom/amazon/mShop/control/search/image/ImageSearchController;->serviceCallCompleted()V
    invoke-static {v2}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->access$000(Lcom/amazon/mShop/control/search/image/ImageSearchController;)V

    .line 46
    const/4 v0, 0x0

    .local v0, "i":I
    iget-object v2, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController$1;->val$value:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v1

    .local v1, "size":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 48
    iget-object v2, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController$1;->this$0:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    # getter for: Lcom/amazon/mShop/control/search/image/ImageSearchController;->mItems:Ljava/util/List;
    invoke-static {v2}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->access$100(Lcom/amazon/mShop/control/search/image/ImageSearchController;)Ljava/util/List;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController$1;->val$value:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 46
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 51
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/control/search/image/ImageSearchController$1;->this$0:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    # getter for: Lcom/amazon/mShop/control/search/image/ImageSearchController;->mSubscriber:Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;
    invoke-static {v2}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->access$200(Lcom/amazon/mShop/control/search/image/ImageSearchController;)Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;->onCompleted()V

    .line 52
    return-void
.end method
