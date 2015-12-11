.class Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)V
    .locals 0

    .prologue
    .line 954
    iput-object p1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 958
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$200(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingMessage;

    move-result-object v0

    const-string v1, "location"

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 961
    const-string v1, "center"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 963
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$700(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimCenterOut:Landroid/view/animation/TranslateAnimation;
    invoke-static {v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$600(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/view/animation/TranslateAnimation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 980
    :cond_0
    :goto_0
    return-void

    .line 966
    :cond_1
    const-string v1, "full"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 968
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$700(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimFullOut:Landroid/view/animation/TranslateAnimation;
    invoke-static {v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$800(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/view/animation/TranslateAnimation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 971
    :cond_2
    const-string v1, "top"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 973
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$700(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimTopOut:Landroid/view/animation/TranslateAnimation;
    invoke-static {v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$900(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/view/animation/TranslateAnimation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 976
    :cond_3
    const-string v1, "bottom"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 978
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$700(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimBottomOut:Landroid/view/animation/TranslateAnimation;
    invoke-static {v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1000(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/view/animation/TranslateAnimation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0
.end method
