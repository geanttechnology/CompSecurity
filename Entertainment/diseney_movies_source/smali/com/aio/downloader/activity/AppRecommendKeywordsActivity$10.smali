.class Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;
.super Ljava/lang/Object;
.source "AppRecommendKeywordsActivity.java"

# interfaces
.implements Landroid/text/TextWatcher;


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
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    .line 510
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 4
    .param p1, "arg0"    # Landroid/text/Editable;

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 538
    const-string v0, "changetv"

    const-string v1, "333"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 540
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 541
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->serchgridview:Landroid/widget/GridView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$9(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/GridView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/GridView;->setVisibility(I)V

    .line 542
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->ll_serch_refresh:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$12(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 543
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pomitlv:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$4(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/ListView;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/ListView;->setVisibility(I)V

    .line 544
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pulltoresult:Lcom/aio/downloader/refresh/PullToRefreshLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$13(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/refresh/PullToRefreshLayout;

    move-result-object v0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->setVisibility(I)V

    .line 547
    :cond_0
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "arg0"    # Ljava/lang/CharSequence;
    .param p2, "arg1"    # I
    .param p3, "arg2"    # I
    .param p4, "arg3"    # I

    .prologue
    .line 514
    const-string v0, "changetv"

    const-string v1, "111"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 516
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 4
    .param p1, "arg0"    # Ljava/lang/CharSequence;
    .param p2, "arg1"    # I
    .param p3, "arg2"    # I
    .param p4, "arg3"    # I

    .prologue
    const/4 v3, 0x0

    const/16 v2, 0x8

    .line 521
    const-string v0, "changetv"

    const-string v1, "222"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 523
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->serchgridview:Landroid/widget/GridView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$9(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/GridView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/GridView;->setVisibility(I)V

    .line 524
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->ll_serch_refresh:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$12(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 525
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pulltoresult:Lcom/aio/downloader/refresh/PullToRefreshLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$13(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/refresh/PullToRefreshLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->setVisibility(I)V

    .line 532
    new-instance v0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    new-array v1, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 533
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pomitlv:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$4(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/ListView;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/ListView;->setVisibility(I)V

    .line 534
    return-void
.end method
