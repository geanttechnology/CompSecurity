.class Lcom/localytics/android/MarketingDialogFragment$1;
.super Lcom/localytics/android/MarketingCallable;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/localytics/android/MarketingDialogFragment;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingDialogFragment;)V
    .locals 0

    .prologue
    .line 370
    iput-object p1, p0, Lcom/localytics/android/MarketingDialogFragment$1;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    invoke-direct {p0}, Lcom/localytics/android/MarketingCallable;-><init>()V

    return-void
.end method


# virtual methods
.method call([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4

    .prologue
    .line 374
    const/4 v0, 0x0

    aget-object v0, p1, v0

    check-cast v0, Ljava/lang/String;

    .line 375
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$1;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mMarketingDialog:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;
    invoke-static {v1}, Lcom/localytics/android/MarketingDialogFragment;->access$000(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    move-result-object v1

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWebView:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;
    invoke-static {v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$100(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    move-result-object v1

    .line 376
    iget-object v2, p0, Lcom/localytics/android/MarketingDialogFragment$1;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    iget-object v3, p0, Lcom/localytics/android/MarketingDialogFragment$1;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    invoke-virtual {v3}, Lcom/localytics/android/MarketingDialogFragment;->getActivity()Landroid/support/v4/app/ac;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Lcom/localytics/android/MarketingDialogFragment;->handleUrl(Ljava/lang/String;Landroid/app/Activity;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 378
    new-instance v2, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v3, Lcom/localytics/android/MarketingDialogFragment$1$1;

    invoke-direct {v3, p0, v1, v0}, Lcom/localytics/android/MarketingDialogFragment$1$1;-><init>(Lcom/localytics/android/MarketingDialogFragment$1;Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 386
    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method
