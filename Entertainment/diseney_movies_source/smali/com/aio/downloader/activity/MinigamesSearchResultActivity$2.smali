.class Lcom/aio/downloader/activity/MinigamesSearchResultActivity$2;
.super Ljava/lang/Object;
.source "MinigamesSearchResultActivity.java"

# interfaces
.implements Landroid/view/View$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->buildListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$2;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "v"    # Landroid/view/View;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 124
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_0

    .line 125
    const/16 v1, 0x42

    if-ne p2, v1, :cond_0

    .line 127
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$2;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$7(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 129
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$2;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    iget-object v2, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$2;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$7(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$2(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;Ljava/lang/String;)V

    .line 131
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$2;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->list:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$6(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 132
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$2;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;
    invoke-static {v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$5(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Lcom/aio/downloader/refresh/PullableListView;

    move-result-object v1

    .line 133
    const v2, 0x7f0701db

    invoke-virtual {v1, v2}, Lcom/aio/downloader/refresh/PullableListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 132
    check-cast v0, Landroid/widget/RelativeLayout;

    .line 134
    .local v0, "re":Landroid/widget/RelativeLayout;
    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 135
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$2;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;
    invoke-static {v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$5(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Lcom/aio/downloader/refresh/PullableListView;

    move-result-object v1

    invoke-virtual {v1, v4}, Lcom/aio/downloader/refresh/PullableListView;->setVisibility(I)V

    .line 137
    new-instance v1, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;

    iget-object v2, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$2;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    invoke-direct {v1, v2}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;-><init>(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 146
    .end local v0    # "re":Landroid/widget/RelativeLayout;
    :cond_0
    return v3
.end method
