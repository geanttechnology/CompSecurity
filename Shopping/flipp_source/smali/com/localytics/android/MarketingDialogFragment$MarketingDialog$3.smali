.class Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# instance fields
.field final synthetic this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)V
    .locals 0

    .prologue
    .line 809
    iput-object p1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$3;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 3

    .prologue
    .line 826
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$3;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment;->dismiss()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 832
    :goto_0
    return-void

    .line 828
    :catch_0
    move-exception v0

    .line 830
    const-class v1, Ljava/lang/RuntimeException;

    const-string v2, "Localytics library threw an uncaught exception"

    invoke-static {v1, v2, v0}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Exception;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 836
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 2

    .prologue
    .line 812
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$3;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mCallbacks:Landroid/util/SparseArray;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$500(Lcom/localytics/android/MarketingDialogFragment;)Landroid/util/SparseArray;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 814
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$3;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mCallbacks:Landroid/util/SparseArray;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$500(Lcom/localytics/android/MarketingDialogFragment;)Landroid/util/SparseArray;

    move-result-object v0

    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingCallable;

    .line 815
    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v1

    if-nez v1, :cond_0

    if-eqz v0, :cond_0

    .line 817
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingCallable;->call([Ljava/lang/Object;)Ljava/lang/Object;

    .line 820
    :cond_0
    return-void
.end method
