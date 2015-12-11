.class Lcom/amazon/mShop/AmazonBrandedWebView$DialogDismisser;
.super Ljava/lang/Object;
.source "AmazonBrandedWebView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonBrandedWebView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DialogDismisser"
.end annotation


# instance fields
.field private final myPageStartCount:I

.field final synthetic this$0:Lcom/amazon/mShop/AmazonBrandedWebView;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/AmazonBrandedWebView;)V
    .locals 1

    .prologue
    .line 312
    iput-object p1, p0, Lcom/amazon/mShop/AmazonBrandedWebView$DialogDismisser;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 313
    # getter for: Lcom/amazon/mShop/AmazonBrandedWebView;->mPageStartCount:I
    invoke-static {p1}, Lcom/amazon/mShop/AmazonBrandedWebView;->access$200(Lcom/amazon/mShop/AmazonBrandedWebView;)I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView$DialogDismisser;->myPageStartCount:I

    .line 314
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/AmazonBrandedWebView;Lcom/amazon/mShop/AmazonBrandedWebView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/AmazonBrandedWebView;
    .param p2, "x1"    # Lcom/amazon/mShop/AmazonBrandedWebView$1;

    .prologue
    .line 309
    invoke-direct {p0, p1}, Lcom/amazon/mShop/AmazonBrandedWebView$DialogDismisser;-><init>(Lcom/amazon/mShop/AmazonBrandedWebView;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 318
    iget v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView$DialogDismisser;->myPageStartCount:I

    iget-object v1, p0, Lcom/amazon/mShop/AmazonBrandedWebView$DialogDismisser;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    # getter for: Lcom/amazon/mShop/AmazonBrandedWebView;->mPageStartCount:I
    invoke-static {v1}, Lcom/amazon/mShop/AmazonBrandedWebView;->access$200(Lcom/amazon/mShop/AmazonBrandedWebView;)I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 319
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView$DialogDismisser;->this$0:Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonBrandedWebView;->dismissDialogIfShowing()V

    .line 321
    :cond_0
    return-void
.end method
