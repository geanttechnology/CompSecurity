.class Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$4;
.super Ljava/lang/Object;
.source "AppRecommendKeywordsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->init()V
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
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$4;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    .line 224
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 229
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$4;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->biaoshi:I
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$21(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)I

    move-result v0

    const/4 v1, 0x5

    if-ne v0, v1, :cond_0

    .line 230
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$4;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-static {v0, v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$22(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;I)V

    .line 232
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$4;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->biaoshi:I
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$21(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)I

    move-result v0

    mul-int/lit8 v0, v0, 0xa

    sput v0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search1:I

    .line 233
    new-instance v0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$4;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 234
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$4;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->biaoshi:I
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$21(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$22(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;I)V

    .line 236
    return-void
.end method
