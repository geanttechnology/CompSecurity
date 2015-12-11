.class Lcom/aio/downloader/fragments/AppGlobalTopFragment$4;
.super Ljava/lang/Object;
.source "AppGlobalTopFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/AppGlobalTopFragment;->init(Landroid/view/View;)V
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
.field final synthetic this$0:Lcom/aio/downloader/fragments/AppGlobalTopFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/AppGlobalTopFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/AppGlobalTopFragment$4;->this$0:Lcom/aio/downloader/fragments/AppGlobalTopFragment;

    .line 289
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "arg1"    # Landroid/view/View;
    .param p3, "arg2"    # I
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
    .line 296
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    :try_start_0
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/fragments/AppGlobalTopFragment$4;->this$0:Lcom/aio/downloader/fragments/AppGlobalTopFragment;

    invoke-virtual {v1}, Lcom/aio/downloader/fragments/AppGlobalTopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 297
    const-class v2, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 296
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 298
    .local v0, "ti":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/fragments/AppGlobalTopFragment$4;->this$0:Lcom/aio/downloader/fragments/AppGlobalTopFragment;

    # getter for: Lcom/aio/downloader/fragments/AppGlobalTopFragment;->isfa:Z
    invoke-static {v1}, Lcom/aio/downloader/fragments/AppGlobalTopFragment;->access$4(Lcom/aio/downloader/fragments/AppGlobalTopFragment;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 300
    const-string v2, "myid"

    iget-object v1, p0, Lcom/aio/downloader/fragments/AppGlobalTopFragment$4;->this$0:Lcom/aio/downloader/fragments/AppGlobalTopFragment;

    # getter for: Lcom/aio/downloader/fragments/AppGlobalTopFragment;->list:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/fragments/AppGlobalTopFragment;->access$5(Lcom/aio/downloader/fragments/AppGlobalTopFragment;)Ljava/util/ArrayList;

    move-result-object v1

    add-int/lit8 v3, p3, -0x1

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 305
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/fragments/AppGlobalTopFragment$4;->this$0:Lcom/aio/downloader/fragments/AppGlobalTopFragment;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/fragments/AppGlobalTopFragment;->startActivity(Landroid/content/Intent;)V

    .line 312
    .end local v0    # "ti":Landroid/content/Intent;
    :goto_1
    return-void

    .line 302
    .restart local v0    # "ti":Landroid/content/Intent;
    :cond_0
    const-string v2, "myid"

    iget-object v1, p0, Lcom/aio/downloader/fragments/AppGlobalTopFragment$4;->this$0:Lcom/aio/downloader/fragments/AppGlobalTopFragment;

    # getter for: Lcom/aio/downloader/fragments/AppGlobalTopFragment;->list:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/fragments/AppGlobalTopFragment;->access$5(Lcom/aio/downloader/fragments/AppGlobalTopFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 307
    .end local v0    # "ti":Landroid/content/Intent;
    :catch_0
    move-exception v1

    goto :goto_1
.end method
