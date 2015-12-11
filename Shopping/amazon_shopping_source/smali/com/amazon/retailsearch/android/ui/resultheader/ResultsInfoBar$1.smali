.class Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;
.super Ljava/lang/Object;
.source "ResultsInfoBar.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildRefinements(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 128
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    # getter for: Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filterView:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->access$100(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)Landroid/widget/TextView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v2

    instance-of v2, v2, Landroid/support/v4/app/FragmentActivity;

    if-eqz v2, :cond_2

    .line 131
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    # getter for: Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filterView:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->access$100(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)Landroid/widget/TextView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    .line 132
    .local v0, "context":Landroid/support/v4/app/FragmentActivity;
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 133
    .local v1, "fragmentManager":Landroid/support/v4/app/FragmentManager;
    if-eqz v1, :cond_1

    const-string/jumbo v2, "popup_dialog_fragment"

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 150
    .end local v0    # "context":Landroid/support/v4/app/FragmentActivity;
    .end local v1    # "fragmentManager":Landroid/support/v4/app/FragmentManager;
    :cond_0
    :goto_0
    return-void

    .line 136
    .restart local v0    # "context":Landroid/support/v4/app/FragmentActivity;
    .restart local v1    # "fragmentManager":Landroid/support/v4/app/FragmentManager;
    :cond_1
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    new-instance v3, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    invoke-direct {v3}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;-><init>()V

    # invokes: Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->showRefinementDialog(Landroid/support/v4/app/FragmentActivity;Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)V
    invoke-static {v2, v0, v3}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->access$200(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;Landroid/support/v4/app/FragmentActivity;Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)V

    goto :goto_0

    .line 141
    .end local v0    # "context":Landroid/support/v4/app/FragmentActivity;
    .end local v1    # "fragmentManager":Landroid/support/v4/app/FragmentManager;
    :cond_2
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    # getter for: Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filterView:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->access$100(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)Landroid/widget/TextView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    .line 142
    .local v0, "context":Landroid/app/Activity;
    invoke-virtual {v0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 143
    .local v1, "fragmentManager":Landroid/app/FragmentManager;
    if-eqz v1, :cond_3

    const-string/jumbo v2, "popup_dialog_fragment"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v2

    if-nez v2, :cond_0

    .line 146
    :cond_3
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    new-instance v3, Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    invoke-direct {v3}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;-><init>()V

    # invokes: Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->showRefinementDialog(Landroid/app/Activity;Lcom/amazon/retailsearch/popup/PopupDialogFragment;)V
    invoke-static {v2, v0, v3}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->access$300(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;Landroid/app/Activity;Lcom/amazon/retailsearch/popup/PopupDialogFragment;)V

    goto :goto_0
.end method
