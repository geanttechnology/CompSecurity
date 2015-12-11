.class Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;
.super Ljava/lang/Object;
.source "AppRecommendKeywordsActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->buildListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    .line 362
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "arg1"    # Landroid/view/View;
    .param p3, "pos"    # I
    .param p4, "arg3"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 368
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listresult:Ljava/util/ArrayList;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$20(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 374
    :goto_0
    :try_start_1
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    .line 375
    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 376
    const-string v3, "input_method"

    .line 375
    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 374
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 378
    .local v0, "inputManager":Landroid/view/inputmethod/InputMethodManager;
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    const/4 v3, 0x0

    .line 377
    invoke-virtual {v0, v2, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 379
    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list2:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$2(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/SearcherPromitModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/SearcherPromitModel;->getS()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$15(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Ljava/lang/String;)V

    .line 380
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->appkeywords:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$14(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/DeletableEditText;->setText(Ljava/lang/CharSequence;)V

    .line 381
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$18(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/refresh/PullableListView_load;

    move-result-object v2

    .line 382
    const v3, 0x7f0701db

    invoke-virtual {v2, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 381
    check-cast v1, Landroid/widget/RelativeLayout;

    .line 383
    .local v1, "re":Landroid/widget/RelativeLayout;
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 385
    new-instance v2, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;

    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {v2, v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 391
    .end local v0    # "inputManager":Landroid/view/inputmethod/InputMethodManager;
    .end local v1    # "re":Landroid/widget/RelativeLayout;
    :goto_1
    return-void

    .line 387
    :catch_0
    move-exception v2

    goto :goto_1

    .line 370
    :catch_1
    move-exception v2

    goto :goto_0
.end method
