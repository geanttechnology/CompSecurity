.class Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;
.super Ljava/lang/Object;
.source "AppRecommendKeywordsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->buildListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    .line 463
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 467
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listresult:Ljava/util/ArrayList;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$20(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 473
    :goto_0
    :try_start_1
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    .line 474
    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 475
    const-string v3, "input_method"

    .line 474
    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 473
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 477
    .local v0, "inputManager":Landroid/view/inputmethod/InputMethodManager;
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    const/4 v3, 0x0

    .line 476
    invoke-virtual {v0, v2, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 485
    .end local v0    # "inputManager":Landroid/view/inputmethod/InputMethodManager;
    :goto_1
    :try_start_2
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 486
    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$7(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;

    move-result-object v2

    const/4 v4, 0x0

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/SearchkeywordModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/SearchkeywordModel;->getKeyword()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$15(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Ljava/lang/String;)V

    .line 491
    :goto_2
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$18(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/refresh/PullableListView_load;

    move-result-object v2

    .line 492
    const v3, 0x7f0701db

    invoke-virtual {v2, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 491
    check-cast v1, Landroid/widget/RelativeLayout;

    .line 493
    .local v1, "re":Landroid/widget/RelativeLayout;
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 494
    new-instance v2, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;

    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {v2, v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 507
    .end local v1    # "re":Landroid/widget/RelativeLayout;
    :goto_3
    return-void

    .line 488
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-interface {v3}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$15(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_2

    .line 503
    :catch_0
    move-exception v2

    goto :goto_3

    .line 479
    :catch_1
    move-exception v2

    goto :goto_1

    .line 469
    :catch_2
    move-exception v2

    goto/16 :goto_0
.end method
