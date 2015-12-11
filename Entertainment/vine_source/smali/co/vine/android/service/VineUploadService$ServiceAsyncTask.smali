.class public Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
.super Landroid/os/AsyncTask;
.source "VineUploadService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/VineUploadService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ServiceAsyncTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field public final action:Ljava/lang/String;

.field public final conversationRowId:J

.field private mExecutionStatus:I

.field private mIsDiscarded:Z

.field private mIsPrivate:Z

.field private mIsRetry:Z

.field private mListener:Lco/vine/android/service/UploadProgressListener;

.field public mUpload:Lco/vine/android/api/VineUpload;

.field public final path:Ljava/lang/String;

.field final synthetic this$0:Lco/vine/android/service/VineUploadService;

.field public final thumbnail:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lco/vine/android/service/VineUploadService;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Lco/vine/android/service/UploadProgressListener;)V
    .locals 4
    .param p2, "path"    # Ljava/lang/String;
    .param p3, "action"    # Ljava/lang/String;
    .param p4, "intent"    # Landroid/content/Intent;
    .param p5, "listener"    # Lco/vine/android/service/UploadProgressListener;

    .prologue
    const/4 v3, 0x0

    .line 874
    iput-object p1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 875
    iput-object p2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    .line 876
    iput-object p3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    .line 877
    const-string v0, "conversation_row_id"

    const-wide/16 v1, -0x1

    invoke-virtual {p4, v0, v1, v2}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->conversationRowId:J

    .line 878
    iput-object p5, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mListener:Lco/vine/android/service/UploadProgressListener;

    .line 879
    invoke-static {p2}, Lco/vine/android/recorder/RecordConfigUtils;->getThumbnailPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->thumbnail:Ljava/lang/String;

    .line 880
    const-string v0, "is_retry"

    invoke-virtual {p4, v0, v3}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mIsRetry:Z

    .line 881
    const-string v0, "is_private"

    invoke-virtual {p4, v0, v3}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mIsPrivate:Z

    .line 882
    return-void
.end method

.method private onComplete()V
    .locals 4

    .prologue
    .line 988
    const-class v2, Lco/vine/android/service/VineUploadService;

    monitor-enter v2

    .line 989
    :try_start_0
    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    const/4 v3, 0x1

    # invokes: Lco/vine/android/service/VineUploadService;->clearNotification(I)V
    invoke-static {v1, v3}, Lco/vine/android/service/VineUploadService;->access$400(Lco/vine/android/service/VineUploadService;I)V

    .line 990
    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    const/4 v3, 0x0

    # setter for: Lco/vine/android/service/VineUploadService;->mCurrentTask:Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    invoke-static {v1, v3}, Lco/vine/android/service/VineUploadService;->access$202(Lco/vine/android/service/VineUploadService;Lco/vine/android/service/VineUploadService$ServiceAsyncTask;)Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    .line 991
    new-instance v0, Landroid/content/Intent;

    const-string v1, "co.vine.android.UPLOAD_RESULT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 992
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "upload_status"

    iget v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mExecutionStatus:I

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 993
    const-string v1, "path"

    iget-object v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 994
    const-string v1, "thumbnail"

    iget-object v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->thumbnail:Ljava/lang/String;

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 995
    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    const-string v3, "co.vine.android.BROADCAST"

    invoke-virtual {v1, v0, v3}, Lco/vine/android/service/VineUploadService;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 996
    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    # invokes: Lco/vine/android/service/VineUploadService;->executeNext()V
    invoke-static {v1}, Lco/vine/android/service/VineUploadService;->access$1200(Lco/vine/android/service/VineUploadService;)V

    .line 997
    monitor-exit v2

    .line 998
    return-void

    .line 997
    .end local v0    # "intent":Landroid/content/Intent;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Boolean;
    .locals 15
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 886
    const-class v14, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    monitor-enter v14

    .line 888
    :try_start_0
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    if-nez v0, :cond_0

    .line 889
    invoke-virtual {p0}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    invoke-static {v0, v1}, Lco/vine/android/util/UploadManager;->getUpload(Landroid/content/Context;Ljava/lang/String;)Lco/vine/android/api/VineUpload;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    .line 891
    :cond_0
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    iget v0, v0, Lco/vine/android/api/VineUpload;->status:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_2

    .line 892
    :cond_1
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    :try_start_1
    monitor-exit v14
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 948
    :goto_0
    return-object v0

    .line 895
    :cond_2
    :try_start_2
    const-string v0, "bPost"

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 896
    new-instance v8, Landroid/os/Bundle;

    invoke-direct {v8}, Landroid/os/Bundle;-><init>()V

    .line 897
    .local v8, "b":Landroid/os/Bundle;
    const-string v0, "upload"

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    invoke-virtual {v8, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 898
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    # getter for: Lco/vine/android/service/VineUploadService;->mVineServiceConnection:Lco/vine/android/service/VineServiceConnection;
    invoke-static {v0}, Lco/vine/android/service/VineUploadService;->access$800(Lco/vine/android/service/VineUploadService;)Lco/vine/android/service/VineServiceConnection;

    move-result-object v0

    const/16 v1, 0x62

    invoke-virtual {v0, v1, v8}, Lco/vine/android/service/VineServiceConnection;->queueAndExecute(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 899
    iget-boolean v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mIsRetry:Z

    if-nez v0, :cond_3

    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mListener:Lco/vine/android/service/UploadProgressListener;

    if-eqz v0, :cond_3

    .line 900
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mListener:Lco/vine/android/service/UploadProgressListener;

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->thumbnail:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lco/vine/android/service/UploadProgressListener;->showPostNotification(Ljava/lang/String;)V

    .line 902
    :cond_3
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v0

    :try_start_3
    monitor-exit v14

    goto :goto_0

    .line 949
    .end local v8    # "b":Landroid/os/Bundle;
    :catchall_0
    move-exception v0

    monitor-exit v14
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v0

    .line 903
    :cond_4
    :try_start_4
    const-string v0, "aUpload"

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 904
    new-instance v12, Ljava/io/File;

    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    invoke-direct {v12, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 905
    .local v12, "original":Ljava/io/File;
    invoke-virtual {v12}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 906
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    invoke-static {v0}, Lco/vine/android/recorder/HashAsyncTask;->getMD5Checksum(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 907
    .local v11, "hash":Ljava/lang/String;
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    iget-object v10, v0, Lco/vine/android/api/VineUpload;->hash:Ljava/lang/String;

    .line 908
    .local v10, "expected":Ljava/lang/String;
    invoke-virtual {v11, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 909
    if-eqz v10, :cond_5

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_5

    .line 910
    const-string v0, "Invalid hash: actual {}, expected {}."

    invoke-static {v0, v11, v10}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 911
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-object v0

    :try_start_5
    monitor-exit v14
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_0

    .line 913
    :cond_5
    :try_start_6
    new-instance v0, Lco/vine/android/VineLoggingException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Expected hash was invalid: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 919
    .end local v10    # "expected":Ljava/lang/String;
    .end local v11    # "hash":Ljava/lang/String;
    :cond_6
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    invoke-static {v0}, Lco/vine/android/util/UploadManager;->getVersionFromPath(Ljava/lang/String;)Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v7

    .line 921
    .local v7, "version":Lco/vine/android/recorder/RecordSessionVersion;
    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    .line 922
    .local v3, "finalPath":Ljava/lang/String;
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mListener:Lco/vine/android/service/UploadProgressListener;

    if-eqz v0, :cond_7

    .line 923
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mListener:Lco/vine/android/service/UploadProgressListener;

    invoke-virtual {v12}, Ljava/io/File;->length()J

    move-result-wide v1

    new-instance v4, Ljava/io/File;

    iget-object v5, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->thumbnail:Ljava/lang/String;

    invoke-direct {v4, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/io/File;->length()J

    move-result-wide v4

    add-long/2addr v1, v4

    iput-wide v1, v0, Lco/vine/android/service/UploadProgressListener;->size:J

    .line 926
    :cond_7
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    # getter for: Lco/vine/android/service/VineUploadService;->mUploadManager:Lco/vine/android/util/UploadManager;
    invoke-static {v0}, Lco/vine/android/service/VineUploadService;->access$900(Lco/vine/android/service/VineUploadService;)Lco/vine/android/util/UploadManager;

    move-result-object v0

    iget-object v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mListener:Lco/vine/android/service/UploadProgressListener;

    iget-object v4, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->thumbnail:Ljava/lang/String;

    iget-object v5, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    iget-boolean v6, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mIsPrivate:Z

    move-object v1, p0

    invoke-virtual/range {v0 .. v7}, Lco/vine/android/util/UploadManager;->upload(Lco/vine/android/service/VineUploadService$ServiceAsyncTask;Lco/vine/android/service/UploadProgressListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLco/vine/android/recorder/RecordSessionVersion;)[Ljava/lang/String;

    move-result-object v13

    .line 930
    .local v13, "uris":[Ljava/lang/String;
    invoke-virtual {p0}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_8

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-result-object v0

    :try_start_7
    monitor-exit v14
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_0

    .line 932
    :cond_8
    if-eqz v13, :cond_a

    .line 933
    :try_start_8
    invoke-virtual {p0}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    invoke-static {v0, v1}, Lco/vine/android/util/UploadManager;->setUploadTime(Landroid/content/Context;Lco/vine/android/api/VineUpload;)V

    .line 934
    invoke-virtual {p0}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    invoke-static {v0, v1, v13}, Lco/vine/android/util/UploadManager;->setUris(Landroid/content/Context;Lco/vine/android/api/VineUpload;[Ljava/lang/String;)V

    .line 935
    invoke-virtual {p0}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lco/vine/android/util/UploadManager;->setStatus(Landroid/content/Context;Lco/vine/android/api/VineUpload;I)V

    .line 936
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    iget-object v0, v0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_9

    .line 937
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    invoke-virtual {p0}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    iget-boolean v4, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mIsRetry:Z

    invoke-static {v1, v2, v4}, Lco/vine/android/service/VineUploadService;->getPostIntent(Landroid/content/Context;Lco/vine/android/api/VineUpload;Z)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineUploadService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 939
    :cond_9
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_0
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    move-result-object v0

    :try_start_9
    monitor-exit v14
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    goto/16 :goto_0

    .line 941
    :cond_a
    :try_start_a
    const-string v0, "Current status: {}"

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    iget v1, v1, Lco/vine/android/api/VineUpload;->status:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 942
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_0
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    move-result-object v0

    :try_start_b
    monitor-exit v14

    goto/16 :goto_0

    .line 945
    .end local v3    # "finalPath":Ljava/lang/String;
    .end local v7    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    .end local v12    # "original":Ljava/io/File;
    .end local v13    # "uris":[Ljava/lang/String;
    :catch_0
    move-exception v9

    .line 946
    .local v9, "e":Ljava/lang/Exception;
    const-string v0, "Failed to upload."

    invoke-static {v0, v9}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 948
    .end local v9    # "e":Ljava/lang/Exception;
    :cond_b
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    monitor-exit v14
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    goto/16 :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 860
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1006
    if-ne p0, p1, :cond_1

    .line 1016
    :cond_0
    :goto_0
    return v1

    .line 1007
    :cond_1
    instance-of v3, p1, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    if-nez v3, :cond_2

    move v1, v2

    goto :goto_0

    :cond_2
    move-object v0, p1

    .line 1009
    check-cast v0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    .line 1011
    .local v0, "that":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    iget-object v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    if-eqz v3, :cond_4

    iget-object v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    :cond_3
    move v1, v2

    .line 1012
    goto :goto_0

    .line 1011
    :cond_4
    iget-object v3, v0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    if-nez v3, :cond_3

    .line 1013
    :cond_5
    iget-object v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    if-eqz v3, :cond_6

    iget-object v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 1014
    goto :goto_0

    .line 1013
    :cond_6
    iget-object v3, v0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 1001
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 1021
    iget-object v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 1022
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 1023
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 1021
    goto :goto_0
.end method

.method protected onCancelled()V
    .locals 3

    .prologue
    .line 980
    const-string v0, "Task cancelled. {}, {}."

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    iget-object v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 981
    iget-boolean v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mIsDiscarded:Z

    if-nez v0, :cond_0

    .line 982
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    # invokes: Lco/vine/android/service/VineUploadService;->discardUpload(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lco/vine/android/service/VineUploadService;->access$1100(Lco/vine/android/service/VineUploadService;Ljava/lang/String;)V

    .line 984
    :cond_0
    invoke-direct {p0}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->onComplete()V

    .line 985
    return-void
.end method

.method protected onPostExecute(Ljava/lang/Boolean;)V
    .locals 6
    .param p1, "success"    # Ljava/lang/Boolean;

    .prologue
    const/4 v5, 0x2

    .line 954
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    .line 955
    .local v1, "taskSuccessful":Z
    iget-boolean v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mIsDiscarded:Z

    if-nez v2, :cond_1

    .line 956
    if-eqz v1, :cond_2

    .line 957
    iput v5, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mExecutionStatus:I

    .line 958
    const-string v2, "aUpload"

    iget-object v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    iget-object v2, v2, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 959
    const/4 v2, 0x3

    iput v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mExecutionStatus:I

    .line 974
    :cond_0
    :goto_0
    invoke-direct {p0}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->onComplete()V

    .line 976
    :cond_1
    return-void

    .line 962
    :cond_2
    const/4 v2, 0x1

    iput v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mExecutionStatus:I

    .line 963
    invoke-virtual {p0}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lco/vine/android/service/VineUploadService;->getNotifyFailedIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 964
    .local v0, "failedIntent":Landroid/content/Intent;
    if-eqz v0, :cond_0

    .line 965
    iget-object v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    invoke-virtual {v2, v0}, Lco/vine/android/service/VineUploadService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 966
    iget-object v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    if-eqz v2, :cond_0

    .line 967
    invoke-virtual {p0}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    const/4 v4, 0x0

    invoke-static {v2, v3, v5, v4}, Lco/vine/android/util/UploadManager;->setStatus(Landroid/content/Context;Lco/vine/android/api/VineUpload;ILjava/lang/String;)V

    .line 968
    const-string v2, "aUpload"

    iget-object v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    iget-boolean v2, v2, Lco/vine/android/api/VineUpload;->isPrivate:Z

    if-eqz v2, :cond_0

    .line 969
    iget-object v2, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->this$0:Lco/vine/android/service/VineUploadService;

    iget-object v3, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    iget-object v3, v3, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    # invokes: Lco/vine/android/service/VineUploadService;->markPreMergedMessageAsUploadFailed(Ljava/lang/String;)V
    invoke-static {v2, v3}, Lco/vine/android/service/VineUploadService;->access$1000(Lco/vine/android/service/VineUploadService;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 860
    check-cast p1, Ljava/lang/Boolean;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->onPostExecute(Ljava/lang/Boolean;)V

    return-void
.end method

.method public setIsDiscarded(Z)V
    .locals 0
    .param p1, "isDiscarded"    # Z

    .prologue
    .line 1027
    iput-boolean p1, p0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mIsDiscarded:Z

    .line 1028
    return-void
.end method
