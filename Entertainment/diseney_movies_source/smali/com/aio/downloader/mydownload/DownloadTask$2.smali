.class Lcom/aio/downloader/mydownload/DownloadTask$2;
.super Landroid/content/BroadcastReceiver;
.source "DownloadTask.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/mydownload/DownloadTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/mydownload/DownloadTask;


# direct methods
.method constructor <init>(Lcom/aio/downloader/mydownload/DownloadTask;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    .line 137
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 11
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    const v9, 0x7f070276

    const/4 v8, 0x1

    .line 142
    const-string v5, "type"

    invoke-virtual {p2, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 143
    .local v3, "type":Ljava/lang/String;
    const-string v5, "mjmj"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "*******"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 145
    const-string v5, "pause"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 147
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mc:Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$0(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 148
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->view:Landroid/view/View;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$1(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/view/View;

    move-result-object v5

    .line 149
    invoke-virtual {v5, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 148
    check-cast v1, Landroid/widget/TextView;

    .line 150
    .local v1, "mybtn":Landroid/widget/TextView;
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDownloadFile()Lcom/aio/downloader/mydownload/DownloadFile;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadFile;->stopDownload()V

    .line 151
    if-eqz v1, :cond_0

    .line 153
    const-string v5, "Start"

    invoke-virtual {v1, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 155
    :cond_0
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mc:Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$0(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;

    move-result-object v5

    iput-boolean v8, v5, Lcom/aio/downloader/mydownload/DownloadTask$MyOnClick;->clickState:Z

    .line 186
    .end local v1    # "mybtn":Landroid/widget/TextView;
    :cond_1
    :goto_0
    return-void

    .line 158
    :cond_2
    const-string v5, "resume"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 159
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->view:Landroid/view/View;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$1(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/view/View;

    move-result-object v5

    .line 160
    invoke-virtual {v5, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 159
    check-cast v1, Landroid/widget/TextView;

    .line 161
    .restart local v1    # "mybtn":Landroid/widget/TextView;
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->view:Landroid/view/View;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$1(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/view/View;

    move-result-object v5

    .line 162
    const v6, 0x7f07027c

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 161
    check-cast v0, Landroid/widget/TextView;

    .line 164
    .local v0, "current_progress":Landroid/widget/TextView;
    if-eqz v1, :cond_3

    .line 166
    const-string v5, "Pause"

    invoke-virtual {v1, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 167
    const/4 v5, 0x4

    invoke-virtual {v1, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 168
    const-string v5, "#cccccc"

    invoke-static {v5}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setTextColor(I)V

    .line 169
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v5

    .line 170
    const v6, 0x7f0b0020

    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 169
    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 172
    :cond_3
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDownloadUrl()Ljava/lang/String;

    move-result-object v4

    .line 173
    .local v4, "url":Ljava/lang/String;
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v2

    .line 174
    .local v2, "path":Ljava/lang/String;
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v5

    new-instance v6, Lcom/aio/downloader/mydownload/DownloadFile;

    invoke-direct {v6}, Lcom/aio/downloader/mydownload/DownloadFile;-><init>()V

    .line 175
    new-instance v7, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    iget-object v8, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    iget-object v9, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->view:Landroid/view/View;
    invoke-static {v9}, Lcom/aio/downloader/mydownload/DownloadTask;->access$1(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/view/View;

    move-result-object v9

    iget-object v10, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v10}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v10

    invoke-direct {v7, v8, v9, v10}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;-><init>(Lcom/aio/downloader/mydownload/DownloadTask;Landroid/view/View;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 174
    invoke-virtual {v6, v4, v2, v7}, Lcom/aio/downloader/mydownload/DownloadFile;->startDownloadFileByUrl(Ljava/lang/String;Ljava/lang/String;Lnet/tsz/afinal/http/AjaxCallBack;)Lcom/aio/downloader/mydownload/DownloadFile;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadFile(Lcom/aio/downloader/mydownload/DownloadFile;)V

    goto/16 :goto_0

    .line 182
    .end local v0    # "current_progress":Landroid/widget/TextView;
    .end local v1    # "mybtn":Landroid/widget/TextView;
    .end local v2    # "path":Ljava/lang/String;
    .end local v4    # "url":Ljava/lang/String;
    :cond_4
    const-string v5, "delete"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 183
    iget-object v5, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->onDeleteTaskListener:Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;
    invoke-static {v5}, Lcom/aio/downloader/mydownload/DownloadTask;->access$4(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->view:Landroid/view/View;
    invoke-static {v6}, Lcom/aio/downloader/mydownload/DownloadTask;->access$1(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/view/View;

    move-result-object v6

    iget-object v7, p0, Lcom/aio/downloader/mydownload/DownloadTask$2;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v7}, Lcom/aio/downloader/mydownload/DownloadTask;->access$2(Lcom/aio/downloader/mydownload/DownloadTask;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v7

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    invoke-interface {v5, v6, v7, v8}, Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;->onDelete(Landroid/view/View;Lcom/aio/downloader/mydownload/DownloadMovieItem;Ljava/lang/Boolean;)V

    goto/16 :goto_0
.end method
