.class Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$1;
.super Ljava/lang/Object;
.source "Home_app_Listview_Adapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

.field private final synthetic val$list:Ljava/util/ArrayList;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$1;->val$list:Ljava/util/ArrayList;

    .line 210
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x0

    .line 213
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/aio/downloader/activity/AppSearchResultActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 214
    .local v0, "ti":Landroid/content/Intent;
    const-string v2, "searchkeywords"

    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$1;->val$list:Ljava/util/ArrayList;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSearch_keyword()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 215
    const-string v2, "bbb"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v1, "search="

    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$1;->val$list:Ljava/util/ArrayList;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSearch_keyword()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 216
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 218
    return-void
.end method
