.class Lcom/aio/downloader/activity/AppDetailsActivity$19;
.super Ljava/lang/Object;
.source "AppDetailsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$19;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 897
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x1

    .line 920
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$19;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->caocao:I
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$74(Lcom/aio/downloader/activity/AppDetailsActivity;)I

    move-result v1

    if-eq v1, v2, :cond_0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$19;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->myjpush:I
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$75(Lcom/aio/downloader/activity/AppDetailsActivity;)I

    move-result v1

    if-ne v1, v2, :cond_1

    .line 921
    :cond_0
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$19;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 922
    const-class v2, Lcom/aio/downloader/activity/MyMainActivity;

    .line 921
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 923
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "acquire_url_start"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 924
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$19;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    .line 925
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$19;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->finish()V

    .line 930
    .end local v0    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 927
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$19;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->finish()V

    goto :goto_0
.end method
