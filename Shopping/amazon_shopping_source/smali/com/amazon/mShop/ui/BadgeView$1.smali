.class Lcom/amazon/mShop/ui/BadgeView$1;
.super Ljava/lang/Object;
.source "BadgeView.java"

# interfaces
.implements Lcom/amazon/mShop/net/HttpFetcher$Subscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/ui/BadgeView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/ui/BadgeView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/ui/BadgeView;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/amazon/mShop/ui/BadgeView$1;->this$0:Lcom/amazon/mShop/ui/BadgeView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onHttpRequestFailed(Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 115
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    return-void
.end method

.method public onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 2
    .param p1, "response"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/Bitmap;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 102
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    iget-object v0, p0, Lcom/amazon/mShop/ui/BadgeView$1;->this$0:Lcom/amazon/mShop/ui/BadgeView;

    # getter for: Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;
    invoke-static {v0}, Lcom/amazon/mShop/ui/BadgeView;->access$000(Lcom/amazon/mShop/ui/BadgeView;)Lcom/amazon/mShop/net/BitmapFetcher;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/ui/BadgeView$1;->this$0:Lcom/amazon/mShop/ui/BadgeView;

    # getter for: Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;
    invoke-static {v0}, Lcom/amazon/mShop/ui/BadgeView;->access$000(Lcom/amazon/mShop/ui/BadgeView;)Lcom/amazon/mShop/net/BitmapFetcher;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 103
    if-eqz p1, :cond_0

    .line 105
    check-cast p2, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    .end local p2    # "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    invoke-virtual {p2}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/amazon/mShop/util/BadgeUtils;->addBadgeBitampToCache(Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 106
    iget-object v0, p0, Lcom/amazon/mShop/ui/BadgeView$1;->this$0:Lcom/amazon/mShop/ui/BadgeView;

    iget-object v1, p0, Lcom/amazon/mShop/ui/BadgeView$1;->this$0:Lcom/amazon/mShop/ui/BadgeView;

    # getter for: Lcom/amazon/mShop/ui/BadgeView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/ui/BadgeView;->access$100(Lcom/amazon/mShop/ui/BadgeView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    # invokes: Lcom/amazon/mShop/ui/BadgeView;->updateBadgeItem(Landroid/graphics/Bitmap;Lcom/amazon/mShop/AmazonActivity;)V
    invoke-static {v0, p1, v1}, Lcom/amazon/mShop/ui/BadgeView;->access$200(Lcom/amazon/mShop/ui/BadgeView;Landroid/graphics/Bitmap;Lcom/amazon/mShop/AmazonActivity;)V

    .line 108
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/ui/BadgeView$1;->this$0:Lcom/amazon/mShop/ui/BadgeView;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;
    invoke-static {v0, v1}, Lcom/amazon/mShop/ui/BadgeView;->access$002(Lcom/amazon/mShop/ui/BadgeView;Lcom/amazon/mShop/net/BitmapFetcher;)Lcom/amazon/mShop/net/BitmapFetcher;

    .line 110
    :cond_1
    return-void
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 99
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/ui/BadgeView$1;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method
