.class Lcom/mixerbox/mixerbox3b/fragments/WebFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

.field final synthetic val$wv:Landroid/webkit/WebView;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/WebFragment;Landroid/webkit/WebView;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$3;->val$wv:Landroid/webkit/WebView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 126
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$3;->val$wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoForward()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$3;->val$wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->goForward()V

    .line 128
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 129
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/WebFragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/actionbarsherlock/app/SherlockFragmentActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->setSupportProgressBarIndeterminateVisibility(Z)V

    .line 131
    :cond_0
    return-void
.end method
