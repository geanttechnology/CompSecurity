.class Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$1;
.super Ljava/lang/Object;
.source "DefaultLoadingViewDelegate.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->setup()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;)V
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 117
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    iget-object v0, v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingProgressBar:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 118
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    iget-object v0, v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingInfoText:Landroid/widget/TextView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 119
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    iget-object v0, v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingRetryButton:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 120
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->startLoading()V

    .line 121
    return-void
.end method
