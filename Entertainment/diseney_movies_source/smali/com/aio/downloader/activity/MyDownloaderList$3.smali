.class Lcom/aio/downloader/activity/MyDownloaderList$3;
.super Landroid/content/BroadcastReceiver;
.source "MyDownloaderList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyDownloaderList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyDownloaderList;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    .line 180
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 20
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 186
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/MyApplcation;->getStartDownloadMovieItem()Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v9

    .line 188
    .local v9, "down":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v1

    .line 189
    const v2, 0x7f030068

    const/4 v3, 0x0

    .line 188
    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v18

    .line 192
    .local v18, "view2":Landroid/view/View;
    const v1, 0x7f070277

    move-object/from16 v0, v18

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v12

    .line 191
    check-cast v12, Landroid/widget/ImageView;

    .line 193
    .local v12, "movie_headimage":Landroid/widget/ImageView;
    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v13

    .line 194
    .local v13, "myurl":Ljava/lang/String;
    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v17

    .line 195
    .local v17, "serial":I
    const-string v1, "qwa"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "serial="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move/from16 v0, v17

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 196
    const/16 v1, 0x6e

    move/from16 v0, v17

    if-ne v0, v1, :cond_2

    .line 198
    new-instance v8, Lcom/aio/downloader/utils/MyAppInfo;

    move-object/from16 v0, p1

    invoke-direct {v8, v0}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 200
    .local v8, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_0
    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v8, v1}, Lcom/aio/downloader/utils/MyAppInfo;->getAppIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    .line 201
    .local v7, "appIcon":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v12, v7}, Landroid/widget/ImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 211
    .end local v7    # "appIcon":Landroid/graphics/drawable/Drawable;
    .end local v8    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :cond_0
    :goto_0
    const/4 v1, 0x7

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v9, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 213
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->listview_lin:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->access$15(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/LinearLayout;

    move-result-object v1

    move-object/from16 v0, v18

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 215
    new-instance v1, Lcom/aio/downloader/mydownload/DownloadTask;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/MyDownloaderList;->getmContext()Landroid/content/Context;

    move-result-object v2

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-direct {v1, v2, v0, v9, v3}, Lcom/aio/downloader/mydownload/DownloadTask;-><init>(Landroid/content/Context;Landroid/view/View;Lcom/aio/downloader/mydownload/DownloadMovieItem;Z)V

    .line 216
    new-instance v2, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->listview_lin:Landroid/widget/LinearLayout;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyDownloaderList;->access$15(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/LinearLayout;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;Landroid/widget/LinearLayout;)V

    invoke-virtual {v1, v2}, Lcom/aio/downloader/mydownload/DownloadTask;->setOnDeleteTaskListener(Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;)V

    .line 217
    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "app"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 218
    new-instance v14, Landroid/app/Notification;

    invoke-direct {v14}, Landroid/app/Notification;-><init>()V

    .line 219
    .local v14, "notification":Landroid/app/Notification;
    const/16 v1, 0x10

    iput v1, v14, Landroid/app/Notification;->flags:I

    .line 220
    const v1, 0x7f0200ec

    iput v1, v14, Landroid/app/Notification;->icon:I

    .line 221
    new-instance v11, Landroid/content/Intent;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 222
    const-class v2, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 221
    invoke-direct {v11, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 223
    .local v11, "intent1":Landroid/content/Intent;
    const/high16 v1, 0x10000000

    invoke-virtual {v11, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 226
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const/16 v2, 0x6e

    .line 227
    const/high16 v3, 0x8000000

    .line 225
    invoke-static {v1, v2, v11, v3}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v15

    .line 228
    .local v15, "pendingIntent":Landroid/app/PendingIntent;
    iput-object v15, v14, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 229
    new-instance v16, Landroid/widget/RemoteViews;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 230
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f030090

    .line 229
    move-object/from16 v0, v16

    invoke-direct {v0, v1, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 231
    .local v16, "rv":Landroid/widget/RemoteViews;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->access$0(Lcom/aio/downloader/activity/MyDownloaderList;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    .line 232
    const-class v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v5, "downloadtask2"

    const/4 v6, 0x0

    .line 231
    invoke-virtual/range {v1 .. v6}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    move-object/from16 v0, v19

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/MyDownloaderList;->access$1(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/util/List;)V

    .line 233
    const v1, 0x7f07031c

    .line 234
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Downloading("

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyDownloaderList;->access$2(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") & Completed"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 235
    sget v3, Lcom/aio/downloader/utils/publicTools;->noticomplete:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 234
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 233
    move-object/from16 v0, v16

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 236
    const v1, 0x7f07031b

    .line 237
    const-string v2, "kk:mm"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-static {v2, v3, v4}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v2

    .line 236
    move-object/from16 v0, v16

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 238
    move-object/from16 v0, v16

    iput-object v0, v14, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 239
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->access$2(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 240
    sget-object v1, Lcom/aio/downloader/activity/MyDownloaderList;->mNotificationManager:Landroid/app/NotificationManager;

    const/16 v2, 0x6e

    invoke-virtual {v1, v2, v14}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 244
    .end local v11    # "intent1":Landroid/content/Intent;
    .end local v14    # "notification":Landroid/app/Notification;
    .end local v15    # "pendingIntent":Landroid/app/PendingIntent;
    .end local v16    # "rv":Landroid/widget/RemoteViews;
    :cond_1
    return-void

    .line 202
    .restart local v8    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_0
    move-exception v10

    .line 204
    .local v10, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v10}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_0

    .line 207
    .end local v8    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v10    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_2
    const/16 v1, 0x6e

    move/from16 v0, v17

    if-eq v0, v1, :cond_0

    .line 208
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/activity/MyDownloaderList$3;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->access$14(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v1

    invoke-virtual {v1, v13, v12}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    goto/16 :goto_0
.end method
