.class Lcom/aio/downloader/activity/MinigameRecommendActivity$1;
.super Ljava/lang/Object;
.source "MinigameRecommendActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MinigameRecommendActivity;->buildListener()V
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
.field final synthetic this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MinigameRecommendActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$1;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .param p2, "arg1"    # Landroid/view/View;
    .param p3, "position"    # I
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
    .line 69
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$1;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    .line 70
    const-class v2, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    .line 69
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 71
    .local v0, "ti":Landroid/content/Intent;
    const-string v2, "searchkeywords"

    iget-object v1, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$1;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$2(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/SearchkeywordModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/SearchkeywordModel;->getKeyword()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 72
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$1;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->startActivity(Landroid/content/Intent;)V

    .line 73
    return-void
.end method
