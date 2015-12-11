.class Lcom/aio/downloader/activity/FunImagePagerActivity$1;
.super Landroid/os/Handler;
.source "FunImagePagerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/FunImagePagerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$1;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    .line 104
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v3, 0x0

    .line 107
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 153
    :goto_0
    return-void

    .line 116
    :pswitch_0
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$1;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "Download Complete"

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 121
    :try_start_1
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$1;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 122
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 123
    const-string v3, "AIO_PICTURE"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 122
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 123
    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$1;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->picture_name:Ljava/lang/String;
    invoke-static {v4}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, ".jpg"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 124
    const/4 v4, 0x0

    .line 120
    invoke-static {v1, v2, v3, v4}, Landroid/provider/MediaStore$Images$Media;->insertImage(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 129
    :goto_1
    :try_start_2
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$1;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    new-instance v2, Landroid/content/Intent;

    .line 130
    const-string v3, "android.intent.action.MEDIA_SCANNER_SCAN_FILE"

    .line 131
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 132
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 133
    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "AIO_PICTURE"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$1;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->picture_name:Ljava/lang/String;
    invoke-static {v5}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 134
    const-string v5, ".jpg"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 131
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 129
    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/FunImagePagerActivity;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    .line 136
    :catch_0
    move-exception v0

    .line 139
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 125
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v0

    .line 126
    .local v0, "e":Ljava/io/FileNotFoundException;
    :try_start_3
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_1

    .line 145
    .end local v0    # "e":Ljava/io/FileNotFoundException;
    :pswitch_1
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$1;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "File does not exist!"

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 150
    :pswitch_2
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$1;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "File does not exist!"

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 107
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
