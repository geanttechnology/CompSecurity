.class Lcom/amazon/mShop/home/HomeView$6;
.super Ljava/lang/Object;
.source "HomeView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/HomeView;->onHomeCallStarted()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/HomeView;

.field final synthetic val$view:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/HomeView;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 775
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    iput-object p2, p0, Lcom/amazon/mShop/home/HomeView$6;->val$view:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 782
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/home/GatewayActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView$6;->val$view:Landroid/view/View;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/home/GatewayActivity;->getCurrentErrorInfo()Lcom/amazon/mShop/error/AmazonErrorInfo;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/home/GatewayActivity;->getCurrentErrorInfo()Lcom/amazon/mShop/error/AmazonErrorInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/error/AmazonErrorInfo;->getErrorId()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 785
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/home/GatewayActivity;->dismissErrorBox()V

    .line 789
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mNeedInvokeHomeCallStarted:Z
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1200(Lcom/amazon/mShop/home/HomeView;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 805
    :goto_0
    return-void

    .line 792
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # setter for: Lcom/amazon/mShop/home/HomeView;->mNeedInvokeHomeCallStarted:Z
    invoke-static {v0, v2}, Lcom/amazon/mShop/home/HomeView;->access$1202(Lcom/amazon/mShop/home/HomeView;Z)Z

    .line 794
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$300(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/PromoSlotView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/home/PromoSlotView;->clear()V

    .line 795
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$600(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/PromoSlotView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/home/PromoSlotView;->clear()V

    .line 797
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mShovelerEmptyPlaceHolder:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1600(Lcom/amazon/mShop/home/HomeView;)Landroid/widget/ImageView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 798
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mHomeBottomBanner:Landroid/view/View;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1700(Lcom/amazon/mShop/home/HomeView;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 799
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mHomeStrenchFrame:Landroid/view/View;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1800(Lcom/amazon/mShop/home/HomeView;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 800
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1900(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/HomeShovelerView;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/home/HomeShovelerView;->setVisibility(I)V

    .line 801
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$2000(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/HomeShovelerView;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/home/HomeShovelerView;->setVisibility(I)V

    .line 802
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # invokes: Lcom/amazon/mShop/home/HomeView;->loadAds()V
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$2100(Lcom/amazon/mShop/home/HomeView;)V

    .line 803
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1900(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/HomeShovelerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeShovelerView;->clear()V

    .line 804
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$6;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$2000(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/HomeShovelerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeShovelerView;->clear()V

    goto :goto_0
.end method
