.class Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;
.super Ljava/lang/Object;
.source "AppRecommendKeywordsActivity.java"

# interfaces
.implements Landroid/view/View$OnKeyListener;


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
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    .line 394
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;)Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;
    .locals 1

    .prologue
    .line 394
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    return-object v0
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "v"    # Landroid/view/View;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v4, 0x0

    .line 400
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listresult:Ljava/util/ArrayList;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$20(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    .line 406
    :goto_0
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_0

    .line 407
    const/16 v2, 0x42

    if-ne p2, v2, :cond_0

    .line 410
    :try_start_1
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    .line 411
    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 412
    const-string v3, "input_method"

    .line 411
    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 410
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 414
    .local v0, "inputManager":Landroid/view/inputmethod/InputMethodManager;
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    const/4 v3, 0x0

    .line 413
    invoke-virtual {v0, v2, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    .line 422
    .end local v0    # "inputManager":Landroid/view/inputmethod/InputMethodManager;
    :goto_1
    :try_start_2
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-interface {v3}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$15(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Ljava/lang/String;)V

    .line 423
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$18(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/refresh/PullableListView_load;

    move-result-object v2

    .line 424
    const v3, 0x7f0701db

    invoke-virtual {v2, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 423
    check-cast v1, Landroid/widget/RelativeLayout;

    .line 425
    .local v1, "re":Landroid/widget/RelativeLayout;
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 427
    new-instance v2, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;

    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {v2, v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .line 441
    .end local v1    # "re":Landroid/widget/RelativeLayout;
    :goto_2
    :try_start_3
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8$1;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8$1;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 452
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    .line 459
    :cond_0
    :goto_3
    return v4

    .line 453
    :catch_0
    move-exception v2

    goto :goto_3

    .line 436
    :catch_1
    move-exception v2

    goto :goto_2

    .line 416
    :catch_2
    move-exception v2

    goto :goto_1

    .line 402
    :catch_3
    move-exception v2

    goto :goto_0
.end method
