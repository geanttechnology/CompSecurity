.class Lcom/aio/downloader/activity/FunGifActivity$1;
.super Landroid/os/Handler;
.source "FunGifActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/FunGifActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunGifActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunGifActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    .line 77
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 8
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/16 v7, 0x123

    const/4 v6, 0x0

    const/16 v5, 0x8

    .line 79
    iget v3, p1, Landroid/os/Message;->what:I

    if-eq v3, v7, :cond_0

    iget v3, p1, Landroid/os/Message;->what:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_3

    .line 81
    :cond_0
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->progress_wheel_gif:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunGifActivity;->access$0(Lcom/aio/downloader/activity/FunGifActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 82
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->iv_gif:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunGifActivity;->access$1(Lcom/aio/downloader/activity/FunGifActivity;)Landroid/widget/ImageView;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 84
    iget v3, p1, Landroid/os/Message;->what:I

    if-ne v3, v7, :cond_2

    .line 85
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/io/File;

    .line 86
    .local v1, "file":Ljava/io/File;
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->gifView:Lcom/ant/liao/GifView;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunGifActivity;->access$2(Lcom/aio/downloader/activity/FunGifActivity;)Lcom/ant/liao/GifView;

    move-result-object v3

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/ant/liao/GifView;->setGifImage(Ljava/lang/String;)V

    .line 87
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    iget-object v4, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->gifView:Lcom/ant/liao/GifView;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunGifActivity;->access$2(Lcom/aio/downloader/activity/FunGifActivity;)Lcom/ant/liao/GifView;

    move-result-object v4

    invoke-virtual {v4}, Lcom/ant/liao/GifView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/aio/downloader/activity/FunGifActivity;->access$3(Lcom/aio/downloader/activity/FunGifActivity;Landroid/view/ViewTreeObserver;)V

    .line 154
    .end local v1    # "file":Ljava/io/File;
    :cond_1
    :goto_0
    return-void

    .line 90
    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 91
    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "AIO_GIF"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->gif_name:Ljava/lang/String;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunGifActivity;->access$4(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".gif"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 90
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 92
    .local v2, "gifpath":Ljava/lang/String;
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->gifView:Lcom/ant/liao/GifView;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunGifActivity;->access$2(Lcom/aio/downloader/activity/FunGifActivity;)Lcom/ant/liao/GifView;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/ant/liao/GifView;->setGifImage(Ljava/lang/String;)V

    .line 93
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    iget-object v4, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->gifView:Lcom/ant/liao/GifView;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunGifActivity;->access$2(Lcom/aio/downloader/activity/FunGifActivity;)Lcom/ant/liao/GifView;

    move-result-object v4

    invoke-virtual {v4}, Lcom/ant/liao/GifView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/aio/downloader/activity/FunGifActivity;->access$3(Lcom/aio/downloader/activity/FunGifActivity;Landroid/view/ViewTreeObserver;)V

    .line 101
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/FunGifActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 102
    const-string v4, "Download Complete"

    const/4 v5, 0x0

    .line 101
    invoke-static {v3, v4, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    .line 102
    invoke-virtual {v3}, Landroid/widget/Toast;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 107
    :try_start_1
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/FunGifActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    .line 108
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 109
    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "AIO_GIF"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 108
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 109
    new-instance v5, Ljava/lang/StringBuilder;

    iget-object v6, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->gif_name:Ljava/lang/String;
    invoke-static {v6}, Lcom/aio/downloader/activity/FunGifActivity;->access$4(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 110
    const-string v6, ".gif"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 109
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 110
    const/4 v6, 0x0

    .line 106
    invoke-static {v3, v4, v5, v6}, Landroid/provider/MediaStore$Images$Media;->insertImage(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 115
    :goto_1
    :try_start_2
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    new-instance v4, Landroid/content/Intent;

    .line 116
    const-string v5, "android.intent.action.MEDIA_SCANNER_SCAN_FILE"

    .line 117
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "file://"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 119
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v7

    .line 118
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 120
    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "AIO_GIF"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->gif_name:Ljava/lang/String;
    invoke-static {v7}, Lcom/aio/downloader/activity/FunGifActivity;->access$4(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 121
    const-string v7, ".gif"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 117
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 115
    invoke-virtual {v3, v4}, Lcom/aio/downloader/activity/FunGifActivity;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    .line 123
    :catch_0
    move-exception v0

    .line 126
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 111
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v0

    .line 112
    .local v0, "e":Ljava/io/FileNotFoundException;
    :try_start_3
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_1

    .line 140
    .end local v0    # "e":Ljava/io/FileNotFoundException;
    .end local v2    # "gifpath":Ljava/lang/String;
    :cond_3
    iget v3, p1, Landroid/os/Message;->what:I

    const/4 v4, 0x2

    if-ne v3, v4, :cond_4

    .line 141
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/FunGifActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "File does not exist!"

    invoke-static {v3, v4, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    .line 142
    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 143
    :cond_4
    iget v3, p1, Landroid/os/Message;->what:I

    const/4 v4, 0x3

    if-ne v3, v4, :cond_5

    .line 144
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/FunGifActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "File does not exist!"

    invoke-static {v3, v4, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    .line 145
    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 146
    :cond_5
    iget v3, p1, Landroid/os/Message;->what:I

    const/4 v4, 0x4

    if-ne v3, v4, :cond_1

    .line 147
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->progress_wheel_gif:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunGifActivity;->access$0(Lcom/aio/downloader/activity/FunGifActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 148
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->iv_gif:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunGifActivity;->access$1(Lcom/aio/downloader/activity/FunGifActivity;)Landroid/widget/ImageView;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 149
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 150
    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "AIO_GIF"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->gif_name:Ljava/lang/String;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunGifActivity;->access$4(Lcom/aio/downloader/activity/FunGifActivity;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".gif"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 149
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 151
    .restart local v2    # "gifpath":Ljava/lang/String;
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->gifView:Lcom/ant/liao/GifView;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunGifActivity;->access$2(Lcom/aio/downloader/activity/FunGifActivity;)Lcom/ant/liao/GifView;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/ant/liao/GifView;->setGifImage(Ljava/lang/String;)V

    .line 152
    iget-object v3, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    iget-object v4, p0, Lcom/aio/downloader/activity/FunGifActivity$1;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity;->gifView:Lcom/ant/liao/GifView;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunGifActivity;->access$2(Lcom/aio/downloader/activity/FunGifActivity;)Lcom/ant/liao/GifView;

    move-result-object v4

    invoke-virtual {v4}, Lcom/ant/liao/GifView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/aio/downloader/activity/FunGifActivity;->access$3(Lcom/aio/downloader/activity/FunGifActivity;Landroid/view/ViewTreeObserver;)V

    goto/16 :goto_0
.end method
