.class Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8$1;
.super Ljava/lang/Object;
.source "AppRecommendKeywordsActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8$1;->this$1:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;

    .line 441
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 444
    const-string v1, "http://android.downloadatoz.com/_201409/market/hits.php?type=search&id=app&title="

    .line 446
    .local v1, "keyword_app_url":Ljava/lang/String;
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8$1;->this$1:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;->access$0(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;)Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    .line 447
    invoke-interface {v2}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v2

    .line 446
    invoke-static {v2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 448
    .local v0, "appkeywords":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 449
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 448
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 451
    return-void
.end method
