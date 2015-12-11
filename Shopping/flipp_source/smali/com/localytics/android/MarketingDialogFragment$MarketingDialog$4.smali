.class Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$4;
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
    .line 844
    iput-object p1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$4;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 4

    .prologue
    .line 854
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$4;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mCallbacks:Landroid/util/SparseArray;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$500(Lcom/localytics/android/MarketingDialogFragment;)Landroid/util/SparseArray;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 856
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$4;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mCallbacks:Landroid/util/SparseArray;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$500(Lcom/localytics/android/MarketingDialogFragment;)Landroid/util/SparseArray;

    move-result-object v0

    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingCallable;

    .line 857
    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v1

    if-nez v1, :cond_0

    if-eqz v0, :cond_0

    .line 859
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$4;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    iget-object v3, v3, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;
    invoke-static {v3}, Lcom/localytics/android/MarketingDialogFragment;->access$200(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingMessage;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingCallable;->call([Ljava/lang/Object;)Ljava/lang/Object;

    .line 862
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 868
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 849
    return-void
.end method
