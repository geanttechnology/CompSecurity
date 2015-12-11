.class Lcom/aio/downloader/activity/TodaysPickActivity$4;
.super Ljava/lang/Object;
.source "TodaysPickActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/TodaysPickActivity;->onCreate(Landroid/os/Bundle;)V
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
.field final synthetic this$0:Lcom/aio/downloader/activity/TodaysPickActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$4;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    .line 192
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
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
    .line 198
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$4;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    .line 199
    const-class v2, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 198
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 200
    .local v0, "ti":Landroid/content/Intent;
    const-string v2, "myid"

    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$4;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->list:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$5(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 201
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$4;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V

    .line 203
    return-void
.end method
