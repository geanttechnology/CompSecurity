.class Lcom/aio/downloader/activity/MinigameRecommendActivity$3;
.super Ljava/lang/Object;
.source "MinigameRecommendActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MinigameRecommendActivity;->buildListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MinigameRecommendActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 106
    iget-object v2, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$7(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 107
    iget-object v2, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    iget-object v3, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v3}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$7(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-interface {v3}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$8(Lcom/aio/downloader/activity/MinigameRecommendActivity;Ljava/lang/String;)V

    .line 108
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    .line 109
    const-class v3, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    .line 108
    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 110
    .local v0, "ti":Landroid/content/Intent;
    const-string v2, "searchkeywords"

    iget-object v3, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->gamekeywords:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$9(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 111
    iget-object v2, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    invoke-virtual {v2, v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->startActivity(Landroid/content/Intent;)V

    .line 118
    .end local v0    # "ti":Landroid/content/Intent;
    :goto_0
    return-void

    .line 113
    :cond_0
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    .line 114
    const-class v3, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    .line 113
    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 115
    .local v1, "ti2":Landroid/content/Intent;
    const-string v3, "searchkeywords"

    iget-object v2, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$2(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Ljava/util/List;

    move-result-object v2

    const/4 v4, 0x0

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/SearchkeywordModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/SearchkeywordModel;->getKeyword()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 116
    iget-object v2, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method
