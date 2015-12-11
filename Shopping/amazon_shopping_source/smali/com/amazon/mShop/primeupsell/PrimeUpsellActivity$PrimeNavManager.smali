.class Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeNavManager;
.super Lcom/amazon/mShop/mash/nav/AmazonNavManager;
.source "PrimeUpsellActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PrimeNavManager"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeNavManager;->this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;

    invoke-direct {p0}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;
    .param p2, "x1"    # Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$1;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeNavManager;-><init>(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;)V

    return-void
.end method


# virtual methods
.method protected handleDismissAll(Landroid/webkit/WebView;Landroid/net/Uri;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "uri"    # Landroid/net/Uri;

    .prologue
    .line 60
    const-string/jumbo v1, "result"

    invoke-virtual {p2, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 61
    .local v0, "signupResult":Ljava/lang/String;
    const-string/jumbo v1, "successPrime"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 62
    iget-object v1, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeNavManager;->this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;

    sget-object v2, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_SIGNUP_SUCCESS:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    # setter for: Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->mPrimeUpsellResult:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;
    invoke-static {v1, v2}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->access$002(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;)Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    .line 70
    :cond_0
    :goto_0
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;->handleDismissAll(Landroid/webkit/WebView;Landroid/net/Uri;)V

    .line 71
    return-void

    .line 63
    :cond_1
    const-string/jumbo v1, "successNoThanks"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 64
    iget-object v1, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeNavManager;->this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;

    sget-object v2, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_USER_CANCELLED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    # setter for: Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->mPrimeUpsellResult:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;
    invoke-static {v1, v2}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->access$002(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;)Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    goto :goto_0

    .line 65
    :cond_2
    const-string/jumbo v1, "failurePrime"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 66
    iget-object v1, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeNavManager;->this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;

    sget-object v2, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_SIGNUP_FAILURE:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    # setter for: Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->mPrimeUpsellResult:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;
    invoke-static {v1, v2}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->access$002(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;)Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    goto :goto_0

    .line 67
    :cond_3
    const-string/jumbo v1, "failureOfferNotDisplayed"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 68
    iget-object v1, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeNavManager;->this$0:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;

    sget-object v2, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_OFFER_PAGE_NOT_DISPLAYED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    # setter for: Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->mPrimeUpsellResult:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;
    invoke-static {v1, v2}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->access$002(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;)Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    goto :goto_0
.end method
