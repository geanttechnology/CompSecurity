.class Lcom/mixerbox/mixerbox3b/MainPage$45;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 3631
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$45;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 3634
    const/4 v0, 0x3

    if-ne p2, v0, :cond_0

    .line 3636
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$45;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 3637
    invoke-virtual {p1}, Landroid/widget/TextView;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v6}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 3639
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$45;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 3640
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$45;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->NoNetworkAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 3641
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 3655
    :cond_0
    :goto_0
    return v6

    .line 3645
    :cond_1
    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 3646
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 3647
    const-string v2, "query"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3648
    const-string v2, "action:search"

    invoke-static {v2, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 3650
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$45;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v2, 0x1

    new-array v2, v2, [Z

    aput-boolean v6, v2, v6

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setDiscover([Z)V

    .line 3651
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$45;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const-string v2, "VECTORIDSEARCH"

    const-string v3, "vector"

    const/4 v4, 0x2

    const-string v5, ""

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/mixerbox/mixerbox3b/MainPage;->setVector(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    move-result-object v1

    .line 3653
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$45;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v2, v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->setSearch(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;)V

    goto :goto_0
.end method
