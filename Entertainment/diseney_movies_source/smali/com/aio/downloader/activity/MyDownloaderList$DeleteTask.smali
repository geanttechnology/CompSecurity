.class Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;
.super Ljava/lang/Object;
.source "MyDownloaderList.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyDownloaderList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DeleteTask"
.end annotation


# instance fields
.field private lin:Landroid/widget/LinearLayout;

.field final synthetic this$0:Lcom/aio/downloader/activity/MyDownloaderList;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList;Landroid/widget/LinearLayout;)V
    .locals 0
    .param p2, "lin"    # Landroid/widget/LinearLayout;

    .prologue
    .line 870
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 871
    iput-object p2, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->lin:Landroid/widget/LinearLayout;

    .line 872
    return-void
.end method


# virtual methods
.method public onDelete(Landroid/view/View;Lcom/aio/downloader/mydownload/DownloadMovieItem;Ljava/lang/Boolean;)V
    .locals 13
    .param p1, "taskView"    # Landroid/view/View;
    .param p2, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .param p3, "isalldelete"    # Ljava/lang/Boolean;

    .prologue
    .line 887
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 888
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->lin:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p1}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 890
    invoke-virtual {p2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDownloadFile()Lcom/aio/downloader/mydownload/DownloadFile;

    move-result-object v6

    .line 891
    .local v6, "d":Lcom/aio/downloader/mydownload/DownloadFile;
    if-eqz v6, :cond_0

    .line 892
    invoke-virtual {v6}, Lcom/aio/downloader/mydownload/DownloadFile;->stopDownload()V

    .line 895
    :cond_0
    new-instance v7, Ljava/io/File;

    invoke-virtual {p2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v7, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 896
    .local v7, "df":Ljava/io/File;
    invoke-virtual {v7}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 898
    invoke-virtual {v7}, Ljava/io/File;->delete()Z

    .line 902
    :cond_1
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 903
    const-string v1, "downloadtask2"

    const-string v2, "file_id=?"

    .line 904
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 902
    invoke-virtual {v0, v1, v2, v3}, Lnet/tsz/afinal/FinalDBChen;->deleteItem(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 964
    :cond_2
    :goto_0
    return-void

    .line 910
    .end local v6    # "d":Lcom/aio/downloader/mydownload/DownloadFile;
    .end local v7    # "df":Ljava/io/File;
    :cond_3
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->lin:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p1}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 912
    invoke-virtual {p2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDownloadFile()Lcom/aio/downloader/mydownload/DownloadFile;

    move-result-object v6

    .line 913
    .restart local v6    # "d":Lcom/aio/downloader/mydownload/DownloadFile;
    if-eqz v6, :cond_4

    .line 914
    invoke-virtual {v6}, Lcom/aio/downloader/mydownload/DownloadFile;->stopDownload()V

    .line 917
    :cond_4
    new-instance v7, Ljava/io/File;

    invoke-virtual {p2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v7, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 918
    .restart local v7    # "df":Ljava/io/File;
    invoke-virtual {v7}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 920
    invoke-virtual {v7}, Ljava/io/File;->delete()Z

    .line 924
    :cond_5
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 925
    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 926
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 924
    invoke-virtual {v0, v1, v2, v3}, Lnet/tsz/afinal/FinalDBChen;->deleteItem(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 935
    new-instance v9, Landroid/app/Notification;

    invoke-direct {v9}, Landroid/app/Notification;-><init>()V

    .line 936
    .local v9, "notification":Landroid/app/Notification;
    const/16 v0, 0x10

    iput v0, v9, Landroid/app/Notification;->flags:I

    .line 937
    const v0, 0x7f0200eb

    iput v0, v9, Landroid/app/Notification;->icon:I

    .line 938
    new-instance v8, Landroid/content/Intent;

    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 939
    const-class v1, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 938
    invoke-direct {v8, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 940
    .local v8, "intent1":Landroid/content/Intent;
    const/high16 v0, 0x10000000

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 943
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const/16 v1, 0x6e

    .line 944
    const/high16 v2, 0x8000000

    .line 942
    invoke-static {v0, v1, v8, v2}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v10

    .line 945
    .local v10, "pendingIntent":Landroid/app/PendingIntent;
    iput-object v10, v9, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 946
    new-instance v11, Landroid/widget/RemoteViews;

    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 947
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f030090

    .line 946
    invoke-direct {v11, v0, v1}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 948
    .local v11, "rv":Landroid/widget/RemoteViews;
    iget-object v12, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$0(Lcom/aio/downloader/activity/MyDownloaderList;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 949
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 948
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-static {v12, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$1(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/util/List;)V

    .line 950
    const v0, 0x7f07031c

    .line 951
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Downloading("

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyDownloaderList;->access$2(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") & Completed"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 952
    sget v2, Lcom/aio/downloader/utils/publicTools;->noticomplete:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 951
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 950
    invoke-virtual {v11, v0, v1}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 953
    iput-object v11, v9, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 954
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$2(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_6

    .line 955
    sget-object v0, Lcom/aio/downloader/activity/MyDownloaderList;->mNotificationManager:Landroid/app/NotificationManager;

    const/16 v1, 0x6e

    invoke-virtual {v0, v1, v9}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 958
    :cond_6
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$2(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_2

    .line 959
    sget-object v0, Lcom/aio/downloader/activity/MyDownloaderList;->mNotificationManager:Landroid/app/NotificationManager;

    const/16 v1, 0x6e

    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->cancel(I)V

    goto/16 :goto_0
.end method
