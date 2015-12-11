.class Lcom/amazon/mShop/about/MShopAboutView$2$1$1;
.super Ljava/lang/Object;
.source "MShopAboutView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/about/MShopAboutView$2$1;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/amazon/mShop/about/MShopAboutView$2$1;

.field final synthetic val$e:Ljava/lang/Exception;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/about/MShopAboutView$2$1;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/amazon/mShop/about/MShopAboutView$2$1$1;->this$2:Lcom/amazon/mShop/about/MShopAboutView$2$1;

    iput-object p2, p0, Lcom/amazon/mShop/about/MShopAboutView$2$1$1;->val$e:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 129
    iget-object v0, p0, Lcom/amazon/mShop/about/MShopAboutView$2$1$1;->this$2:Lcom/amazon/mShop/about/MShopAboutView$2$1;

    iget-object v0, v0, Lcom/amazon/mShop/about/MShopAboutView$2$1;->this$1:Lcom/amazon/mShop/about/MShopAboutView$2;

    iget-object v0, v0, Lcom/amazon/mShop/about/MShopAboutView$2;->val$c:Landroid/content/Context;

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/mShop/about/MShopAboutView$2$1$1;->this$2:Lcom/amazon/mShop/about/MShopAboutView$2$1;

    iget-object v2, v2, Lcom/amazon/mShop/about/MShopAboutView$2$1;->this$1:Lcom/amazon/mShop/about/MShopAboutView$2;

    iget-object v2, v2, Lcom/amazon/mShop/about/MShopAboutView$2;->this$0:Lcom/amazon/mShop/about/MShopAboutView;

    iget-object v3, p0, Lcom/amazon/mShop/about/MShopAboutView$2$1$1;->val$e:Ljava/lang/Exception;

    iget-object v4, p0, Lcom/amazon/mShop/about/MShopAboutView$2$1$1;->this$2:Lcom/amazon/mShop/about/MShopAboutView$2$1;

    iget-object v4, v4, Lcom/amazon/mShop/about/MShopAboutView$2$1;->this$1:Lcom/amazon/mShop/about/MShopAboutView$2;

    iget-object v4, v4, Lcom/amazon/mShop/about/MShopAboutView$2;->val$c:Landroid/content/Context;

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->ok:I

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;Ljava/lang/String;)V

    .line 134
    return-void
.end method
