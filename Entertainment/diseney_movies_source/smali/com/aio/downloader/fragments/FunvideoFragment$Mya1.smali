.class Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;
.super Landroid/os/AsyncTask;
.source "FunvideoFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/FunvideoFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Mya1"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field private funlistviewadapter:Lcom/aio/downloader/adapter/FunAllAdapter;

.field final synthetic this$0:Lcom/aio/downloader/fragments/FunvideoFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/FunvideoFragment;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    .line 101
    iget-object v0, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->list:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$2(Lcom/aio/downloader/fragments/FunvideoFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->funList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 102
    iget-object v0, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->page:I
    invoke-static {v0}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$1(Lcom/aio/downloader/fragments/FunvideoFragment;)I

    move-result v0

    if-ne v0, v5, :cond_0

    .line 103
    new-instance v0, Lcom/aio/downloader/adapter/FunAllAdapter;

    iget-object v1, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    invoke-virtual {v1}, Lcom/aio/downloader/fragments/FunvideoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->list:Ljava/util/ArrayList;
    invoke-static {v2}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$2(Lcom/aio/downloader/fragments/FunvideoFragment;)Ljava/util/ArrayList;

    move-result-object v2

    .line 104
    iget-object v3, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->nativeAd:Lcom/facebook/ads/NativeAd;
    invoke-static {v3}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$3(Lcom/aio/downloader/fragments/FunvideoFragment;)Lcom/facebook/ads/NativeAd;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->fd_errer:Z
    invoke-static {v4}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$4(Lcom/aio/downloader/fragments/FunvideoFragment;)Z

    move-result v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/aio/downloader/adapter/FunAllAdapter;-><init>(Landroid/content/Context;Ljava/util/List;Lcom/facebook/ads/NativeAd;Z)V

    .line 103
    iput-object v0, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->funlistviewadapter:Lcom/aio/downloader/adapter/FunAllAdapter;

    .line 107
    iget-object v0, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    new-instance v1, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 108
    iget-object v2, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->funlistviewadapter:Lcom/aio/downloader/adapter/FunAllAdapter;

    invoke-direct {v1, v2}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 107
    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$5(Lcom/aio/downloader/fragments/FunvideoFragment;Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;)V

    .line 109
    iget-object v0, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    invoke-static {v0}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$6(Lcom/aio/downloader/fragments/FunvideoFragment;)Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->lv_fun_adult:Lcom/aio/downloader/refresh/PullableListView_load;
    invoke-static {v1}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$7(Lcom/aio/downloader/fragments/FunvideoFragment;)Lcom/aio/downloader/refresh/PullableListView_load;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 110
    iget-object v0, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->lv_fun_adult:Lcom/aio/downloader/refresh/PullableListView_load;
    invoke-static {v0}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$7(Lcom/aio/downloader/fragments/FunvideoFragment;)Lcom/aio/downloader/refresh/PullableListView_load;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    invoke-static {v1}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$6(Lcom/aio/downloader/fragments/FunvideoFragment;)Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView_load;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 112
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->lv_fun_adult:Lcom/aio/downloader/refresh/PullableListView_load;
    invoke-static {v0}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$7(Lcom/aio/downloader/fragments/FunvideoFragment;)Lcom/aio/downloader/refresh/PullableListView_load;

    move-result-object v0

    invoke-virtual {v0, v5}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 114
    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 4
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 81
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "http://welaf.com/fun/list.php?cat=video&page="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->page:I
    invoke-static {v3}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$1(Lcom/aio/downloader/fragments/FunvideoFragment;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 82
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 83
    .local v0, "jsonData":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 88
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 89
    const-string v0, "www"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "result="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 90
    if-nez p1, :cond_0

    .line 97
    :goto_0
    return-void

    .line 93
    :cond_0
    invoke-direct {p0, p1}, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->ShowResult(Ljava/lang/String;)V

    .line 95
    iget-object v0, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->progress_wheel_fun:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$0(Lcom/aio/downloader/fragments/FunvideoFragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 75
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 76
    iget-object v0, p0, Lcom/aio/downloader/fragments/FunvideoFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/FunvideoFragment;

    # getter for: Lcom/aio/downloader/fragments/FunvideoFragment;->progress_wheel_fun:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/FunvideoFragment;->access$0(Lcom/aio/downloader/fragments/FunvideoFragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 77
    return-void
.end method
