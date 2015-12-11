.class Lcom/aio/downloader/fragments/Mp3SearchFragment$5;
.super Landroid/content/BroadcastReceiver;
.source "Mp3SearchFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/Mp3SearchFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Mp3SearchFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$5;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    .line 135
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/16 v3, 0x8

    .line 140
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$5;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->list:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$5(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 141
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$5;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$6(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Lcom/aio/downloader/refresh/PullableListView;

    move-result-object v1

    const v2, 0x7f0701db

    invoke-virtual {v1, v2}, Lcom/aio/downloader/refresh/PullableListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 142
    .local v0, "re":Landroid/widget/RelativeLayout;
    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 143
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$5;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$6(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Lcom/aio/downloader/refresh/PullableListView;

    move-result-object v1

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView;->setVisibility(I)V

    .line 144
    new-instance v1, Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;

    iget-object v2, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$5;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    invoke-direct {v1, v2}, Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;-><init>(Lcom/aio/downloader/fragments/Mp3SearchFragment;)V

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 146
    return-void
.end method
