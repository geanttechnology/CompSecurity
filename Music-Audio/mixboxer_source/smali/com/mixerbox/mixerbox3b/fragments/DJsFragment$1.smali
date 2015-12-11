.class Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 59
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->NoNetworkAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 61
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 66
    :goto_0
    return-void

    .line 64
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    invoke-virtual {v0, p3}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/MyItem;

    .line 65
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-interface {v0}, Lcom/mixerbox/mixerbox3b/classes/MyItem;->getMyJSONObject()Lorg/json/JSONObject;

    move-result-object v0

    invoke-static {v1, v0, v2, v2, v2}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle;->onClick(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Landroid/view/View;)V

    goto :goto_0
.end method
