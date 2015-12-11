.class public Lco/vine/android/service/VineUploadService;
.super Landroid/app/Service;
.source "VineUploadService.java"

# interfaces
.implements Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/service/VineUploadService$SessionChangedReceiver;,
        Lco/vine/android/service/VineUploadService$ServiceAsyncTask;,
        Lco/vine/android/service/VineUploadService$IPCProgressListener;,
        Lco/vine/android/service/VineUploadService$NotificationProgressListener;,
        Lco/vine/android/service/VineUploadService$IncomingHandler;
    }
.end annotation


# static fields
.field public static final ACTION_CLEAR_NOTIFICATIONS:Ljava/lang/String; = "clear_notifications"

.field public static final ACTION_DISCARD:Ljava/lang/String; = "discard"

.field public static final ACTION_DISCARD_ALL:Ljava/lang/String; = "discard_all"

.field public static final ACTION_DRAFT_UPGRADE_COUNT:Ljava/lang/String; = "action_get_draft_count"

.field public static final ACTION_NOTIFY_FAILED:Ljava/lang/String; = "cNotify"

.field public static final ACTION_POST:Ljava/lang/String; = "bPost"

.field public static final ACTION_PREMERGE_AND_POST:Ljava/lang/String; = "bMergeAndPost"

.field public static final ACTION_SHOW_NOTIFICATIONS:Ljava/lang/String; = "show_notifications"

.field public static final ACTION_UPLOAD:Ljava/lang/String; = "aUpload"

.field public static final ACTION_UPLOAD_RESULT:Ljava/lang/String; = "co.vine.android.UPLOAD_RESULT"

.field public static final AG_CHANNEL_ID:Ljava/lang/String; = "channelId"

.field public static final AG_CONVERSATION_ROW_ID:Ljava/lang/String; = "conversation_row_id"

.field public static final AG_DESCRIPTION:Ljava/lang/String; = "description"

.field public static final AG_ENTITIES:Ljava/lang/String; = "entities"

.field public static final AG_HASH:Ljava/lang/String; = "hash"

.field public static final AG_IS_PRIVATE:Ljava/lang/String; = "is_private"

.field public static final AG_MAX_LOOPS:Ljava/lang/String; = "maxLoops"

.field public static final AG_MESSAGE:Ljava/lang/String; = "message"

.field public static final AG_MESSAGE_ROW_ID:Ljava/lang/String; = "message_row_id"

.field public static final AG_PATH:Ljava/lang/String; = "path"

.field public static final AG_POST_ID:Ljava/lang/String; = "postId"

.field public static final AG_POST_TO_FACEBOOK:Ljava/lang/String; = "postToFacebook"

.field public static final AG_POST_TO_TWITTER:Ljava/lang/String; = "postToTwitter"

.field public static final AG_RECIPIENTS:Ljava/lang/String; = "recipients"

.field public static final AG_REFERENCE:Ljava/lang/String; = "reference"

.field public static final AG_SHOW_NOTIFICATIONS:Ljava/lang/String; = "show_notifications"

.field public static final AG_THUMBNAIL:Ljava/lang/String; = "thumbnail"

.field public static final AG_THUMB_URL:Ljava/lang/String; = "thumbUrl"

.field public static final AG_TIMESTAMP:Ljava/lang/String; = "created"

.field public static final AG_UPLOAD:Ljava/lang/String; = "upload"

.field public static final AG_UPLOAD_RESULT:Ljava/lang/String; = "upload_status"

.field public static final AG_VIDEO_URL:Ljava/lang/String; = "videoUrl"

.field public static final EXTRA_IS_ACTIVE:Ljava/lang/String; = "is_active"

.field public static final EXTRA_SUCCESS:Ljava/lang/String; = "success"

.field public static final EXTRA_TRANSCODE_PROGRESS:Ljava/lang/String; = "transcode_progress"

.field public static final EXTRA_UPLOAD_PROGRESS:Ljava/lang/String; = "upload_progress"

.field private static final MAX_BITMAP_SIZE:I = 0xa

.field public static final MESSAGE_COUNT_UPDATE:I = 0x8

.field public static final MESSAGE_POST_FINISHED:I = 0x7

.field public static final MESSAGE_RESULT_RECEIVER_WAS_SET:I = 0x3

.field public static final MESSAGE_SET_RESULT_RECEIVER:I = 0x1

.field public static final MESSAGE_TRANSCODE_PROGRESS_CHANGED:I = 0x5

.field public static final MESSAGE_TRANSCODE_STARTED:I = 0x4

.field public static final MESSAGE_UNSET_DRAFT_RECEIVER:I = 0x9

.field public static final MESSAGE_UNSET_RESULT_RECEIVER:I = 0x2

.field public static final MESSAGE_UPLOAD_PROGRESS_CHANGED:I = 0x6

.field private static final NOTIFICATION_FAILED_ID:I = 0x0

.field private static final NOTIFICATION_PROGRESS_ID:I = 0x1

.field private static final NOTIFICATION_TAG:Ljava/lang/String; = "upload_notification"

.field public static final RESULT_NEED_POST_INFO:I = 0x3

.field public static final RESULT_STATUS_FAILED:I = 0x1

.field public static final RESULT_STATUS_SUCCEEDED:I = 0x2

.field public static final RESULT_STATUS_UPLOADING:I = 0x0

.field private static final SMALL_ICON:I = 0x7f0201ff

.field private static final TAG:Ljava/lang/String; = "VineUploadService"

.field private static sShowProgress:Z

.field private static sUploadResultReceiver:Landroid/os/Messenger;


# instance fields
.field private mBitmaps:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private mCurrentTask:Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

.field private mDefaultNotificationIcon:Landroid/graphics/Bitmap;

.field private mIsBinded:Z

.field private final mLock:[I

.field private mMessenger:Landroid/os/Messenger;

.field private mNotificationManager:Landroid/app/NotificationManager;

.field private mNotificationPanelSize:I

.field private mPendingTasks:Ljava/util/LinkedHashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashSet",
            "<",
            "Lco/vine/android/service/VineUploadService$ServiceAsyncTask;",
            ">;"
        }
    .end annotation
.end field

.field private mPendingVMTasks:Ljava/util/LinkedHashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashSet",
            "<",
            "Lco/vine/android/service/VineUploadService$ServiceAsyncTask;",
            ">;"
        }
    .end annotation
.end field

.field private mSessionChangedReceiver:Lco/vine/android/service/VineUploadService$SessionChangedReceiver;

.field private mStartIds:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mUploadManager:Lco/vine/android/util/UploadManager;

.field private mVineServiceConnection:Lco/vine/android/service/VineServiceConnection;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 67
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 140
    const/4 v0, 0x0

    new-array v0, v0, [I

    iput-object v0, p0, Lco/vine/android/service/VineUploadService;->mLock:[I

    .line 149
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/service/VineUploadService;->mNotificationPanelSize:I

    .line 153
    new-instance v0, Lco/vine/android/service/VineServiceConnection;

    invoke-direct {v0, p0, p0}, Lco/vine/android/service/VineServiceConnection;-><init>(Landroid/content/Context;Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;)V

    iput-object v0, p0, Lco/vine/android/service/VineUploadService;->mVineServiceConnection:Lco/vine/android/service/VineServiceConnection;

    .line 1043
    return-void
.end method

.method static synthetic access$100()Landroid/os/Messenger;
    .locals 1

    .prologue
    .line 67
    sget-object v0, Lco/vine/android/service/VineUploadService;->sUploadResultReceiver:Landroid/os/Messenger;

    return-object v0
.end method

.method static synthetic access$1000(Lco/vine/android/service/VineUploadService;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 67
    invoke-direct {p0, p1}, Lco/vine/android/service/VineUploadService;->markPreMergedMessageAsUploadFailed(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$102(Landroid/os/Messenger;)Landroid/os/Messenger;
    .locals 0
    .param p0, "x0"    # Landroid/os/Messenger;

    .prologue
    .line 67
    sput-object p0, Lco/vine/android/service/VineUploadService;->sUploadResultReceiver:Landroid/os/Messenger;

    return-object p0
.end method

.method static synthetic access$1100(Lco/vine/android/service/VineUploadService;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 67
    invoke-direct {p0, p1}, Lco/vine/android/service/VineUploadService;->discardUpload(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1200(Lco/vine/android/service/VineUploadService;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;

    .prologue
    .line 67
    invoke-direct {p0}, Lco/vine/android/service/VineUploadService;->executeNext()V

    return-void
.end method

.method static synthetic access$200(Lco/vine/android/service/VineUploadService;)Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;

    .prologue
    .line 67
    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mCurrentTask:Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    return-object v0
.end method

.method static synthetic access$202(Lco/vine/android/service/VineUploadService;Lco/vine/android/service/VineUploadService$ServiceAsyncTask;)Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;
    .param p1, "x1"    # Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    .prologue
    .line 67
    iput-object p1, p0, Lco/vine/android/service/VineUploadService;->mCurrentTask:Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    return-object p1
.end method

.method static synthetic access$300(Lco/vine/android/service/VineUploadService;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;

    .prologue
    .line 67
    invoke-direct {p0}, Lco/vine/android/service/VineUploadService;->stopIfNoTasksLeft()V

    return-void
.end method

.method static synthetic access$400(Lco/vine/android/service/VineUploadService;I)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;
    .param p1, "x1"    # I

    .prologue
    .line 67
    invoke-direct {p0, p1}, Lco/vine/android/service/VineUploadService;->clearNotification(I)V

    return-void
.end method

.method static synthetic access$500(Lco/vine/android/service/VineUploadService;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;

    .prologue
    .line 67
    invoke-direct {p0}, Lco/vine/android/service/VineUploadService;->cancelFailedNofitication()V

    return-void
.end method

.method static synthetic access$600(Lco/vine/android/service/VineUploadService;Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 67
    invoke-direct {p0, p1}, Lco/vine/android/service/VineUploadService;->setScaledNotificationIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/service/VineUploadService;Landroid/support/v4/app/NotificationCompat$Builder;I)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;
    .param p1, "x1"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .param p2, "x2"    # I

    .prologue
    .line 67
    invoke-direct {p0, p1, p2}, Lco/vine/android/service/VineUploadService;->showNotification(Landroid/support/v4/app/NotificationCompat$Builder;I)V

    return-void
.end method

.method static synthetic access$800(Lco/vine/android/service/VineUploadService;)Lco/vine/android/service/VineServiceConnection;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;

    .prologue
    .line 67
    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mVineServiceConnection:Lco/vine/android/service/VineServiceConnection;

    return-object v0
.end method

.method static synthetic access$900(Lco/vine/android/service/VineUploadService;)Lco/vine/android/util/UploadManager;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/VineUploadService;

    .prologue
    .line 67
    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mUploadManager:Lco/vine/android/util/UploadManager;

    return-object v0
.end method

.method private declared-synchronized cancelFailedNofitication()V
    .locals 1

    .prologue
    .line 391
    monitor-enter p0

    :try_start_0
    invoke-static {p0}, Lco/vine/android/util/UploadManager;->uploadListIsEmpty(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 392
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/service/VineUploadService;->clearNotification(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 394
    :cond_0
    monitor-exit p0

    return-void

    .line 391
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized clearNotification(I)V
    .locals 2
    .param p1, "id"    # I

    .prologue
    .line 387
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mNotificationManager:Landroid/app/NotificationManager;

    const-string v1, "upload_notification"

    invoke-virtual {v0, v1, p1}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 388
    monitor-exit p0

    return-void

    .line 387
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private discardTask(Ljava/lang/String;)V
    .locals 6
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    .line 690
    const-string v4, "Discard task for path={}"

    invoke-static {v4, p1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 691
    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mCurrentTask:Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    .line 692
    .local v0, "currentTask":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    if-eqz v0, :cond_0

    iget-object v4, v0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    invoke-static {v4, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 693
    invoke-virtual {v0, v5}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->setIsDiscarded(Z)V

    .line 694
    invoke-virtual {v0, v5}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->cancel(Z)Z

    .line 695
    const-string v4, "In-progress task has been cancelled, path={}"

    invoke-static {v4, p1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 698
    :cond_0
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 699
    .local v3, "tasks":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    iget-object v4, p0, Lco/vine/android/service/VineUploadService;->mPendingTasks:Ljava/util/LinkedHashSet;

    invoke-virtual {v4}, Ljava/util/LinkedHashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    .line 700
    .local v2, "task":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    if-eqz v2, :cond_1

    iget-object v4, v2, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    invoke-static {v4, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 701
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 705
    .end local v2    # "task":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    :cond_2
    iget-object v4, p0, Lco/vine/android/service/VineUploadService;->mPendingVMTasks:Ljava/util/LinkedHashSet;

    invoke-virtual {v4}, Ljava/util/LinkedHashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_3
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    .line 706
    .restart local v2    # "task":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    if-eqz v2, :cond_3

    iget-object v4, v2, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    invoke-static {v4, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 707
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 711
    .end local v2    # "task":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    :cond_4
    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_5

    .line 712
    const-string v4, "Queued task(s) will be cancelled."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 713
    iget-object v4, p0, Lco/vine/android/service/VineUploadService;->mPendingTasks:Ljava/util/LinkedHashSet;

    invoke-virtual {v4, v3}, Ljava/util/LinkedHashSet;->removeAll(Ljava/util/Collection;)Z

    .line 714
    iget-object v4, p0, Lco/vine/android/service/VineUploadService;->mPendingVMTasks:Ljava/util/LinkedHashSet;

    invoke-virtual {v4, v3}, Ljava/util/LinkedHashSet;->removeAll(Ljava/util/Collection;)Z

    .line 716
    :cond_5
    invoke-direct {p0, p1}, Lco/vine/android/service/VineUploadService;->discardUpload(Ljava/lang/String;)V

    .line 717
    return-void
.end method

.method private discardUpload(Ljava/lang/String;)V
    .locals 4
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 720
    const-string v0, "Discard video: {}"

    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 721
    const-string v0, "Discard encoded video: {}"

    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p1}, Lco/vine/android/util/UploadManager;->getVersionFromPath(Ljava/lang/String;)Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v3

    iget-object v3, v3, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 722
    const-string v0, "Discard thumbnail: {}"

    new-instance v1, Ljava/io/File;

    invoke-static {p1}, Lco/vine/android/recorder/RecordConfigUtils;->getThumbnailPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 723
    invoke-static {p0, p1}, Lco/vine/android/util/UploadManager;->deleteUploadRecord(Landroid/content/Context;Ljava/lang/String;)V

    .line 724
    invoke-direct {p0}, Lco/vine/android/service/VineUploadService;->cancelFailedNofitication()V

    .line 725
    return-void
.end method

.method private executeNext()V
    .locals 7

    .prologue
    .line 602
    const-string v3, "Pending tasks: {}"

    iget-object v4, p0, Lco/vine/android/service/VineUploadService;->mPendingTasks:Ljava/util/LinkedHashSet;

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 603
    const-string v3, "Pending vm tasks: {}"

    iget-object v4, p0, Lco/vine/android/service/VineUploadService;->mPendingVMTasks:Ljava/util/LinkedHashSet;

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 604
    iget-object v3, p0, Lco/vine/android/service/VineUploadService;->mCurrentTask:Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    if-eqz v3, :cond_0

    .line 605
    const-string v3, "mCurrentTask is not null, will not execute next"

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 635
    :goto_0
    return-void

    .line 609
    :cond_0
    iget-object v4, p0, Lco/vine/android/service/VineUploadService;->mLock:[I

    monitor-enter v4

    .line 611
    :try_start_0
    iget-object v3, p0, Lco/vine/android/service/VineUploadService;->mPendingVMTasks:Ljava/util/LinkedHashSet;

    invoke-virtual {v3}, Ljava/util/LinkedHashSet;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_2

    .line 612
    iget-object v2, p0, Lco/vine/android/service/VineUploadService;->mPendingVMTasks:Ljava/util/LinkedHashSet;

    .line 616
    .local v2, "taskQueue":Ljava/util/LinkedHashSet;, "Ljava/util/LinkedHashSet<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    :goto_1
    invoke-virtual {v2}, Ljava/util/LinkedHashSet;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_3

    .line 617
    invoke-virtual {v2}, Ljava/util/LinkedHashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 618
    .local v1, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    .line 619
    .local v0, "currentTask":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    invoke-direct {p0, v0}, Lco/vine/android/service/VineUploadService;->isRunning(Lco/vine/android/service/VineUploadService$ServiceAsyncTask;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 620
    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v3}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 621
    const-string v3, "Started executing task: action={}, path={}"

    iget-object v5, v0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    iget-object v6, v0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->path:Ljava/lang/String;

    invoke-static {v3, v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 624
    :cond_1
    iput-object v0, p0, Lco/vine/android/service/VineUploadService;->mCurrentTask:Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    .line 625
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    .line 634
    .end local v0    # "currentTask":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    .end local v1    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    :goto_2
    monitor-exit v4

    goto :goto_0

    .end local v2    # "taskQueue":Ljava/util/LinkedHashSet;, "Ljava/util/LinkedHashSet<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 614
    :cond_2
    :try_start_1
    iget-object v2, p0, Lco/vine/android/service/VineUploadService;->mPendingTasks:Ljava/util/LinkedHashSet;

    .restart local v2    # "taskQueue":Ljava/util/LinkedHashSet;, "Ljava/util/LinkedHashSet<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    goto :goto_1

    .line 627
    :cond_3
    new-instance v3, Landroid/os/Handler;

    invoke-direct {v3}, Landroid/os/Handler;-><init>()V

    new-instance v5, Lco/vine/android/service/VineUploadService$1;

    invoke-direct {v5, p0}, Lco/vine/android/service/VineUploadService$1;-><init>(Lco/vine/android/service/VineUploadService;)V

    invoke-virtual {v3, v5}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_2
.end method

.method public static getClearNotificationsIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 185
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/VineUploadService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 186
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "clear_notifications"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 187
    return-object v0
.end method

.method public static getDiscardAllIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 179
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/VineUploadService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 180
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "discard_all"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 181
    return-object v0
.end method

.method public static getDiscardIntent(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 172
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/VineUploadService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 173
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "discard"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 174
    const-string v1, "path"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 175
    return-object v0
.end method

.method public static getNotifyFailedIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 15
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x2

    const/4 v14, 0x1

    .line 275
    const/4 v10, 0x0

    .line 276
    .local v10, "path":Ljava/lang/String;
    const-string v11, "status=? AND is_private=?"

    .line 277
    .local v11, "selection":Ljava/lang/String;
    new-array v4, v2, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v4, v0

    const-string v0, "0"

    aput-object v0, v4, v14

    .line 278
    .local v4, "selArgs":[Ljava/lang/String;
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->getActiveSessionReadOnly()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v8

    .line 279
    .local v8, "ownerId":J
    sget-object v0, Lco/vine/android/provider/VineUploads$Uploads;->CONTENT_URI:Landroid/net/Uri;

    invoke-static {v0, v8, v9}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 280
    .local v1, "contentUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lco/vine/android/provider/VineUploadsDatabaseSQL$UploadsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v3, "status=? AND is_private=?"

    const-string v5, "_id ASC"

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 282
    .local v6, "c":Landroid/database/Cursor;
    if-eqz v6, :cond_2

    .line 283
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 286
    :cond_0
    invoke-interface {v6, v14}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    .line 287
    .local v12, "tempPath":Ljava/lang/String;
    invoke-static {v12}, Lco/vine/android/util/UploadManager;->getVersionFromPath(Ljava/lang/String;)Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v13

    .line 288
    .local v13, "version":Lco/vine/android/recorder/RecordSessionVersion;
    sget-object v0, Lco/vine/android/recorder/RecordSessionVersion;->SW_MP4:Lco/vine/android/recorder/RecordSessionVersion;

    if-eq v13, v0, :cond_3

    .line 289
    move-object v10, v12

    .line 293
    :goto_0
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-nez v0, :cond_0

    .line 295
    .end local v12    # "tempPath":Ljava/lang/String;
    .end local v13    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    :cond_1
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 297
    :cond_2
    if-eqz v10, :cond_4

    .line 298
    new-instance v7, Landroid/content/Intent;

    const-class v0, Lco/vine/android/service/VineUploadService;

    invoke-direct {v7, p0, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 299
    .local v7, "intent":Landroid/content/Intent;
    const-string v0, "cNotify"

    invoke-virtual {v7, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 300
    const-string v0, "path"

    invoke-virtual {v7, v0, v10}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 303
    .end local v7    # "intent":Landroid/content/Intent;
    :goto_1
    return-object v7

    .line 291
    .restart local v12    # "tempPath":Ljava/lang/String;
    .restart local v13    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    :cond_3
    invoke-static {p0, v10}, Lco/vine/android/util/UploadManager;->removeFromUploadQueue(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 303
    .end local v12    # "tempPath":Ljava/lang/String;
    .end local v13    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    :cond_4
    const/4 v7, 0x0

    goto :goto_1
.end method

.method public static getPostIntent(Landroid/content/Context;Lco/vine/android/api/VineUpload;Z)Landroid/content/Intent;
    .locals 18
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "upload"    # Lco/vine/android/api/VineUpload;
    .param p2, "isRetry"    # Z

    .prologue
    .line 197
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 198
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    invoke-static {v2}, Lco/vine/android/api/VineUpload$PostInfo;->fromJsonString(Ljava/lang/String;)Lco/vine/android/api/VineUpload$PostInfo;

    move-result-object v16

    .line 199
    .local v16, "postInfo":Lco/vine/android/api/VineUpload$PostInfo;
    move-object/from16 v0, p1

    iget-object v3, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    move-object/from16 v0, v16

    iget-object v4, v0, Lco/vine/android/api/VineUpload$PostInfo;->caption:Ljava/lang/String;

    move-object/from16 v0, v16

    iget-boolean v5, v0, Lco/vine/android/api/VineUpload$PostInfo;->postToTwitter:Z

    move-object/from16 v0, v16

    iget-boolean v6, v0, Lco/vine/android/api/VineUpload$PostInfo;->postToFacebook:Z

    move-object/from16 v0, v16

    iget-wide v7, v0, Lco/vine/android/api/VineUpload$PostInfo;->channelId:J

    move-object/from16 v0, v16

    iget-object v10, v0, Lco/vine/android/api/VineUpload$PostInfo;->entities:Ljava/util/ArrayList;

    move-object/from16 v0, v16

    iget-object v11, v0, Lco/vine/android/api/VineUpload$PostInfo;->recipients:Ljava/util/ArrayList;

    move-object/from16 v0, v16

    iget-object v12, v0, Lco/vine/android/api/VineUpload$PostInfo;->message:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-wide v13, v0, Lco/vine/android/api/VineUpload;->conversationRowId:J

    move-object/from16 v0, v16

    iget v15, v0, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    move-object/from16 v2, p0

    move/from16 v9, p2

    invoke-static/range {v2 .. v15}, Lco/vine/android/service/VineUploadService;->getPostIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZJZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;JI)Landroid/content/Intent;

    move-result-object v17

    .line 203
    .local v17, "result":Landroid/content/Intent;
    const-string v2, "upload"

    move-object/from16 v0, v17

    move-object/from16 v1, p1

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 206
    .end local v16    # "postInfo":Lco/vine/android/api/VineUpload$PostInfo;
    .end local v17    # "result":Landroid/content/Intent;
    :goto_0
    return-object v17

    :cond_0
    const/16 v17, 0x0

    goto :goto_0
.end method

.method public static getPostIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZJZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;JI)Landroid/content/Intent;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "caption"    # Ljava/lang/String;
    .param p3, "postToTwitter"    # Z
    .param p4, "postToFacebook"    # Z
    .param p5, "channelId"    # J
    .param p7, "isRetry"    # Z
    .param p10, "message"    # Ljava/lang/String;
    .param p11, "conversationRowId"    # J
    .param p13, "maxLoops"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "ZZJZ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;",
            "Ljava/lang/String;",
            "JI)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 214
    .local p8, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    .local p9, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lco/vine/android/service/VineUploadService;

    invoke-direct {v2, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 215
    .local v2, "intent":Landroid/content/Intent;
    const-string v3, "bPost"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 216
    const-string v3, "is_retry"

    invoke-virtual {v2, v3, p7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 217
    const-string v3, "path"

    invoke-virtual {v2, v3, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 218
    const-string v3, "description"

    invoke-virtual {v2, v3, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 219
    const-string v3, "postToTwitter"

    invoke-virtual {v2, v3, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 220
    const-string v3, "postToFacebook"

    invoke-virtual {v2, v3, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 221
    const-string v3, "channelId"

    invoke-virtual {v2, v3, p5, p6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 222
    const-string v3, "entities"

    invoke-virtual {v2, v3, p8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 223
    const-string v3, "recipients"

    invoke-virtual {v2, v3, p9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 224
    const-string v3, "message"

    move-object/from16 v0, p10

    invoke-virtual {v2, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 225
    const-string v3, "created"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-virtual {v2, v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 226
    const-string v3, "conversation_row_id"

    move-wide/from16 v0, p11

    invoke-virtual {v2, v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 227
    const-string v3, "maxLoops"

    move/from16 v0, p13

    invoke-virtual {v2, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 228
    return-object v2
.end method

.method public static getShowProgressIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 191
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/VineUploadService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 192
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "show_notifications"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 193
    return-object v0
.end method

.method public static getUploadIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)Landroid/content/Intent;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "hash"    # Ljava/lang/String;
    .param p3, "thumbnail"    # Ljava/lang/String;
    .param p4, "reference"    # Ljava/lang/String;
    .param p5, "isMessaging"    # Z
    .param p6, "conversationRowId"    # J

    .prologue
    .line 158
    const/4 v1, 0x0

    sput-boolean v1, Lco/vine/android/service/VineUploadService;->sShowProgress:Z

    .line 159
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/VineUploadService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 160
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "aUpload"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 161
    const-string v1, "path"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 162
    const-string v1, "hash"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 163
    const-string v1, "thumbnail"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 164
    const-string v1, "reference"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 165
    const-string v1, "is_private"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 166
    const-string v1, "show_notifications"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 167
    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, p6, p7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 168
    return-object v0
.end method

.method public static getVMPostIntent(Landroid/content/Context;Ljava/lang/String;ZJJLjava/util/ArrayList;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)Landroid/content/Intent;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "isRetry"    # Z
    .param p3, "mergedMessageIdForRetry"    # J
    .param p5, "conversationRowId"    # J
    .param p8, "message"    # Ljava/lang/String;
    .param p9, "postId"    # J
    .param p11, "videoUrl"    # Ljava/lang/String;
    .param p12, "thumbUrl"    # Ljava/lang/String;
    .param p13, "maxLoops"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "ZJJ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;",
            "Ljava/lang/String;",
            "J",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "I)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 244
    .local p7, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    new-instance v2, Landroid/content/Intent;

    const-class v4, Lco/vine/android/service/VineUploadService;

    invoke-direct {v2, p0, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 246
    .local v2, "intent":Landroid/content/Intent;
    if-eqz p2, :cond_1

    .line 247
    const-string v4, "bPost"

    invoke-virtual {v2, v4}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 248
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 250
    new-instance v3, Lco/vine/android/api/VineUpload;

    invoke-direct {v3}, Lco/vine/android/api/VineUpload;-><init>()V

    .line 251
    .local v3, "upload":Lco/vine/android/api/VineUpload;
    iput-wide p3, v3, Lco/vine/android/api/VineUpload;->mergedMessageId:J

    .line 252
    const/4 v4, 0x1

    iput-boolean v4, v3, Lco/vine/android/api/VineUpload;->isPrivate:Z

    .line 253
    const/4 v4, 0x1

    iput v4, v3, Lco/vine/android/api/VineUpload;->status:I

    .line 254
    iput-wide p5, v3, Lco/vine/android/api/VineUpload;->conversationRowId:J

    .line 255
    const-string v4, "upload"

    invoke-virtual {v2, v4, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 260
    .end local v3    # "upload":Lco/vine/android/api/VineUpload;
    :cond_0
    :goto_0
    const-string v4, "is_private"

    const/4 v5, 0x1

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 261
    const-string v4, "is_retry"

    invoke-virtual {v2, v4, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 262
    const-string v4, "path"

    invoke-virtual {v2, v4, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 263
    const-string v4, "recipients"

    invoke-virtual {v2, v4, p7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 264
    const-string v4, "message"

    invoke-virtual {v2, v4, p8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 265
    const-string v4, "postId"

    move-wide/from16 v0, p9

    invoke-virtual {v2, v4, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 266
    const-string v4, "videoUrl"

    move-object/from16 v0, p11

    invoke-virtual {v2, v4, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 267
    const-string v4, "thumbUrl"

    move-object/from16 v0, p12

    invoke-virtual {v2, v4, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 268
    const-string v4, "created"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-virtual {v2, v4, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 269
    const-string v4, "conversation_row_id"

    invoke-virtual {v2, v4, p5, p6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 270
    const-string v4, "maxLoops"

    move/from16 v0, p13

    invoke-virtual {v2, v4, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 271
    return-object v2

    .line 258
    :cond_1
    const-string v4, "bMergeAndPost"

    invoke-virtual {v2, v4}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method

.method public static getVMPostIntent(Landroid/content/Context;Ljava/lang/String;ZJLjava/util/ArrayList;Ljava/lang/String;I)Landroid/content/Intent;
    .locals 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "isRetry"    # Z
    .param p3, "conversationRowId"    # J
    .param p6, "message"    # Ljava/lang/String;
    .param p7, "maxLoops"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "ZJ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;",
            "Ljava/lang/String;",
            "I)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 239
    .local p5, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    const-wide/16 v3, -0x1

    const-wide/16 v9, -0x1

    const/4 v11, 0x0

    const/4 v12, 0x0

    move-object v0, p0

    move-object v1, p1

    move/from16 v2, p2

    move-wide/from16 v5, p3

    move-object/from16 v7, p5

    move-object/from16 v8, p6

    move/from16 v13, p7

    invoke-static/range {v0 .. v13}, Lco/vine/android/service/VineUploadService;->getVMPostIntent(Landroid/content/Context;Ljava/lang/String;ZJJLjava/util/ArrayList;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static getVMSharePostIntent(Landroid/content/Context;ZJLjava/util/ArrayList;JLjava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "isRetry"    # Z
    .param p2, "conversationRowId"    # J
    .param p5, "postId"    # J
    .param p7, "videoUrl"    # Ljava/lang/String;
    .param p8, "thumbUrl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "ZJ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;J",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 233
    .local p4, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    const/4 v1, 0x0

    const-wide/16 v3, -0x1

    const/4 v8, 0x0

    const/4 v13, 0x0

    move-object v0, p0

    move v2, p1

    move-wide/from16 v5, p2

    move-object/from16 v7, p4

    move-wide/from16 v9, p5

    move-object/from16 v11, p7

    move-object/from16 v12, p8

    invoke-static/range {v0 .. v13}, Lco/vine/android/service/VineUploadService;->getVMPostIntent(Landroid/content/Context;Ljava/lang/String;ZJJLjava/util/ArrayList;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method private isRunning(Lco/vine/android/service/VineUploadService$ServiceAsyncTask;)Z
    .locals 2
    .param p1, "task"    # Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    .prologue
    .line 403
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getStatus()Landroid/os/AsyncTask$Status;

    move-result-object v0

    sget-object v1, Landroid/os/AsyncTask$Status;->RUNNING:Landroid/os/AsyncTask$Status;

    invoke-virtual {v0, v1}, Landroid/os/AsyncTask$Status;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private markPreMergedMessageAsUploadFailed(Ljava/lang/String;)V
    .locals 3
    .param p1, "uploadPath"    # Ljava/lang/String;

    .prologue
    .line 595
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 596
    .local v0, "b":Landroid/os/Bundle;
    const/4 v1, 0x1

    invoke-static {p0, v1}, Lco/vine/android/client/VineAccountHelper;->getActiveSession(Landroid/content/Context;Z)Lco/vine/android/client/Session;

    move-result-object v1

    invoke-static {v0, v1}, Lco/vine/android/client/AppController;->injectServiceBundle(Landroid/os/Bundle;Lco/vine/android/client/Session;)Landroid/os/Bundle;

    .line 597
    const-string v1, "upload_path"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 598
    iget-object v1, p0, Lco/vine/android/service/VineUploadService;->mVineServiceConnection:Lco/vine/android/service/VineServiceConnection;

    const/16 v2, 0x64

    invoke-virtual {v1, v2, v0}, Lco/vine/android/service/VineServiceConnection;->queueAndExecute(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 599
    return-void
.end method

.method private preMergeMessage(Lco/vine/android/api/VineUpload;)V
    .locals 3
    .param p1, "upload"    # Lco/vine/android/api/VineUpload;

    .prologue
    .line 588
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 589
    .local v0, "b":Landroid/os/Bundle;
    const/4 v1, 0x1

    invoke-static {p0, v1}, Lco/vine/android/client/VineAccountHelper;->getActiveSession(Landroid/content/Context;Z)Lco/vine/android/client/Session;

    move-result-object v1

    invoke-static {v0, v1}, Lco/vine/android/client/AppController;->injectServiceBundle(Landroid/os/Bundle;Lco/vine/android/client/Session;)Landroid/os/Bundle;

    .line 590
    const-string v1, "upload"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 591
    iget-object v1, p0, Lco/vine/android/service/VineUploadService;->mVineServiceConnection:Lco/vine/android/service/VineServiceConnection;

    const/16 v2, 0x5d

    invoke-virtual {v1, v2, v0}, Lco/vine/android/service/VineServiceConnection;->queueAndExecute(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 592
    return-void
.end method

.method private processCommand(Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Lco/vine/android/service/UploadProgressListener;)V
    .locals 21
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "action"    # Ljava/lang/String;
    .param p3, "intent"    # Landroid/content/Intent;
    .param p4, "listener"    # Lco/vine/android/service/UploadProgressListener;

    .prologue
    .line 460
    const-string v4, "Process command for action={}, path={}"

    move-object/from16 v0, p2

    move-object/from16 v1, p1

    invoke-static {v4, v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 461
    new-instance v3, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    move-object/from16 v4, p0

    move-object/from16 v5, p1

    move-object/from16 v6, p2

    move-object/from16 v7, p3

    move-object/from16 v8, p4

    invoke-direct/range {v3 .. v8}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;-><init>(Lco/vine/android/service/VineUploadService;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Lco/vine/android/service/UploadProgressListener;)V

    .line 463
    .local v3, "newTask":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    const-string v4, "aUpload"

    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 464
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/service/VineUploadService;->mPendingTasks:Ljava/util/LinkedHashSet;

    invoke-virtual {v4, v3}, Ljava/util/LinkedHashSet;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/service/VineUploadService;->mPendingVMTasks:Ljava/util/LinkedHashSet;

    invoke-virtual {v4, v3}, Ljava/util/LinkedHashSet;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 465
    const-string v4, "hash"

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 466
    .local v6, "hash":Ljava/lang/String;
    const-string v4, "is_private"

    const/4 v5, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v8

    .line 467
    .local v8, "isPrivate":Z
    const-string v4, "reference"

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 468
    .local v7, "reference":Ljava/lang/String;
    const-string v4, "conversation_row_id"

    const-wide/16 v12, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v4, v12, v13}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v9

    .line 470
    .local v9, "conversationRowId":J
    const-wide/16 v11, -0x1

    move-object/from16 v4, p0

    move-object/from16 v5, p1

    invoke-static/range {v4 .. v12}, Lco/vine/android/util/UploadManager;->addOrUpdateUpload(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJ)V

    .line 472
    if-eqz v8, :cond_1

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineUploadService;->mPendingVMTasks:Ljava/util/LinkedHashSet;

    move-object/from16 v19, v0

    .line 473
    .local v19, "taskQueue":Ljava/util/LinkedHashSet;, "Ljava/util/LinkedHashSet<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    :goto_0
    move-object/from16 v0, v19

    invoke-virtual {v0, v3}, Ljava/util/LinkedHashSet;->add(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 474
    const-string v4, "Upload task added for path={}"

    move-object/from16 v0, p1

    invoke-static {v4, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 564
    .end local v6    # "hash":Ljava/lang/String;
    .end local v7    # "reference":Ljava/lang/String;
    .end local v8    # "isPrivate":Z
    .end local v9    # "conversationRowId":J
    .end local v19    # "taskQueue":Ljava/util/LinkedHashSet;, "Ljava/util/LinkedHashSet<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    :cond_0
    :goto_1
    invoke-direct/range {p0 .. p0}, Lco/vine/android/service/VineUploadService;->executeNext()V

    .line 565
    :goto_2
    return-void

    .line 472
    .restart local v6    # "hash":Ljava/lang/String;
    .restart local v7    # "reference":Ljava/lang/String;
    .restart local v8    # "isPrivate":Z
    .restart local v9    # "conversationRowId":J
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineUploadService;->mPendingTasks:Ljava/util/LinkedHashSet;

    move-object/from16 v19, v0

    goto :goto_0

    .line 477
    .end local v6    # "hash":Ljava/lang/String;
    .end local v7    # "reference":Ljava/lang/String;
    .end local v8    # "isPrivate":Z
    .end local v9    # "conversationRowId":J
    :cond_2
    const-string v4, "Upload task is already in queue for path={}"

    move-object/from16 v0, p1

    invoke-static {v4, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_1

    .line 479
    :cond_3
    const-string v4, "bMergeAndPost"

    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 481
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineUploadService;->getPostInfoFromIntent(Landroid/content/Intent;)Lco/vine/android/api/VineUpload$PostInfo;

    move-result-object v17

    .line 483
    .local v17, "info":Lco/vine/android/api/VineUpload$PostInfo;
    invoke-static/range {p1 .. p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 485
    invoke-static/range {p0 .. p1}, Lco/vine/android/util/UploadManager;->getUpload(Landroid/content/Context;Ljava/lang/String;)Lco/vine/android/api/VineUpload;

    move-result-object v20

    .line 486
    .local v20, "upload":Lco/vine/android/api/VineUpload;
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    move-object/from16 v2, v17

    invoke-static {v0, v1, v2}, Lco/vine/android/util/UploadManager;->setPostInfo(Landroid/content/Context;Lco/vine/android/api/VineUpload;Lco/vine/android/api/VineUpload$PostInfo;)V

    .line 495
    :goto_3
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lco/vine/android/service/VineUploadService;->preMergeMessage(Lco/vine/android/api/VineUpload;)V

    goto :goto_1

    .line 489
    .end local v20    # "upload":Lco/vine/android/api/VineUpload;
    :cond_4
    new-instance v20, Lco/vine/android/api/VineUpload;

    invoke-direct/range {v20 .. v20}, Lco/vine/android/api/VineUpload;-><init>()V

    .line 490
    .restart local v20    # "upload":Lco/vine/android/api/VineUpload;
    invoke-virtual/range {v17 .. v17}, Lco/vine/android/api/VineUpload$PostInfo;->toString()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v20

    iput-object v4, v0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    .line 491
    const/4 v4, 0x1

    move-object/from16 v0, v20

    iput-boolean v4, v0, Lco/vine/android/api/VineUpload;->isPrivate:Z

    .line 492
    const/4 v4, 0x1

    move-object/from16 v0, v20

    iput v4, v0, Lco/vine/android/api/VineUpload;->status:I

    .line 493
    const-string v4, "conversation_row_id"

    const-wide/16 v12, -0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v4, v12, v13}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v4

    move-object/from16 v0, v20

    iput-wide v4, v0, Lco/vine/android/api/VineUpload;->conversationRowId:J

    goto :goto_3

    .line 496
    .end local v17    # "info":Lco/vine/android/api/VineUpload$PostInfo;
    .end local v20    # "upload":Lco/vine/android/api/VineUpload;
    :cond_5
    const-string v4, "bPost"

    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_d

    .line 497
    invoke-static/range {p0 .. p1}, Lco/vine/android/util/UploadManager;->getUpload(Landroid/content/Context;Ljava/lang/String;)Lco/vine/android/api/VineUpload;

    move-result-object v20

    .line 498
    .restart local v20    # "upload":Lco/vine/android/api/VineUpload;
    if-nez v20, :cond_6

    .line 499
    const-string v4, "upload"

    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v20

    .end local v20    # "upload":Lco/vine/android/api/VineUpload;
    check-cast v20, Lco/vine/android/api/VineUpload;

    .line 502
    .restart local v20    # "upload":Lco/vine/android/api/VineUpload;
    :cond_6
    if-nez v20, :cond_7

    .line 503
    const-string v4, "Error posting. No upload via path nor via argument: {}."

    move-object/from16 v0, p1

    invoke-static {v4, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V

    goto/16 :goto_2

    .line 508
    :cond_7
    move-object/from16 v0, v20

    iget-object v4, v0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 509
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineUploadService;->getPostInfoFromIntent(Landroid/content/Intent;)Lco/vine/android/api/VineUpload$PostInfo;

    move-result-object v17

    .line 510
    .restart local v17    # "info":Lco/vine/android/api/VineUpload$PostInfo;
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    move-object/from16 v2, v17

    invoke-static {v0, v1, v2}, Lco/vine/android/util/UploadManager;->setPostInfo(Landroid/content/Context;Lco/vine/android/api/VineUpload;Lco/vine/android/api/VineUpload$PostInfo;)V

    .line 513
    .end local v17    # "info":Lco/vine/android/api/VineUpload$PostInfo;
    :cond_8
    move-object/from16 v0, v20

    iget v0, v0, Lco/vine/android/api/VineUpload;->status:I

    move/from16 v18, v0

    .line 514
    .local v18, "status":I
    packed-switch v18, :pswitch_data_0

    .line 549
    const-string v4, "Invalid state={} for path={}"

    move-object/from16 v0, v20

    iget v5, v0, Lco/vine/android/api/VineUpload;->status:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-static {v4, v5, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_1

    .line 516
    :pswitch_0
    new-instance v11, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    const-string v14, "aUpload"

    move-object/from16 v12, p0

    move-object/from16 v13, p1

    move-object/from16 v15, p3

    move-object/from16 v16, p4

    invoke-direct/range {v11 .. v16}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;-><init>(Lco/vine/android/service/VineUploadService;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Lco/vine/android/service/UploadProgressListener;)V

    .line 518
    .local v11, "uploadTask":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    move-object/from16 v0, v20

    iget-boolean v4, v0, Lco/vine/android/api/VineUpload;->isPrivate:Z

    if-eqz v4, :cond_a

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineUploadService;->mPendingVMTasks:Ljava/util/LinkedHashSet;

    move-object/from16 v19, v0

    .line 519
    .restart local v19    # "taskQueue":Ljava/util/LinkedHashSet;, "Ljava/util/LinkedHashSet<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    :goto_4
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/service/VineUploadService;->mCurrentTask:Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    invoke-virtual {v11, v4}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_9

    .line 520
    move-object/from16 v0, v19

    invoke-virtual {v0, v11}, Ljava/util/LinkedHashSet;->add(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 521
    const-string v4, "Upload task added for path={}"

    iget-object v5, v11, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    move-object/from16 v0, p1

    invoke-static {v4, v0, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 524
    :cond_9
    move-object/from16 v0, v19

    invoke-virtual {v0, v3}, Ljava/util/LinkedHashSet;->add(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 525
    const-string v4, "Post task added for path={}"

    iget-object v5, v3, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    move-object/from16 v0, p1

    invoke-static {v4, v0, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_1

    .line 518
    .end local v19    # "taskQueue":Ljava/util/LinkedHashSet;, "Ljava/util/LinkedHashSet<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    :cond_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineUploadService;->mPendingTasks:Ljava/util/LinkedHashSet;

    move-object/from16 v19, v0

    goto :goto_4

    .line 533
    .end local v11    # "uploadTask":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    :pswitch_1
    move-object/from16 v0, v20

    iget-object v4, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_b

    move-object/from16 v0, v20

    iget-object v4, v0, Lco/vine/android/api/VineUpload;->videoUrl:Ljava/lang/String;

    if-nez v4, :cond_b

    .line 534
    const/4 v4, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-static {v0, v1, v4}, Lco/vine/android/util/UploadManager;->setStatus(Landroid/content/Context;Lco/vine/android/api/VineUpload;I)V

    .line 535
    const/4 v4, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-static {v0, v1, v4}, Lco/vine/android/service/VineUploadService;->getPostIntent(Landroid/content/Context;Lco/vine/android/api/VineUpload;Z)Landroid/content/Intent;

    move-result-object v4

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lco/vine/android/service/VineUploadService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    goto/16 :goto_2

    .line 539
    :cond_b
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/service/VineUploadService;->mCurrentTask:Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    invoke-virtual {v3, v4}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 540
    move-object/from16 v0, v20

    iget-boolean v4, v0, Lco/vine/android/api/VineUpload;->isPrivate:Z

    if-eqz v4, :cond_c

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineUploadService;->mPendingVMTasks:Ljava/util/LinkedHashSet;

    move-object/from16 v19, v0

    .line 541
    .restart local v19    # "taskQueue":Ljava/util/LinkedHashSet;, "Ljava/util/LinkedHashSet<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    :goto_5
    move-object/from16 v0, v20

    iput-object v0, v3, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->mUpload:Lco/vine/android/api/VineUpload;

    .line 542
    move-object/from16 v0, v19

    invoke-virtual {v0, v3}, Ljava/util/LinkedHashSet;->add(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 543
    const-string v4, "Post task added for path={}"

    iget-object v5, v3, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->action:Ljava/lang/String;

    move-object/from16 v0, p1

    invoke-static {v4, v0, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_1

    .line 540
    .end local v19    # "taskQueue":Ljava/util/LinkedHashSet;, "Ljava/util/LinkedHashSet<Lco/vine/android/service/VineUploadService$ServiceAsyncTask;>;"
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineUploadService;->mPendingTasks:Ljava/util/LinkedHashSet;

    move-object/from16 v19, v0

    goto :goto_5

    .line 553
    .end local v18    # "status":I
    .end local v20    # "upload":Lco/vine/android/api/VineUpload;
    :cond_d
    const-string v4, "cNotify"

    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_e

    .line 554
    invoke-static/range {p1 .. p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 556
    const/4 v4, 0x1

    sput-boolean v4, Lco/vine/android/service/VineUploadService;->sShowProgress:Z

    .line 557
    const-string v4, "Notify failed upload for path={}."

    move-object/from16 v0, p1

    invoke-static {v4, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 558
    invoke-direct/range {p0 .. p1}, Lco/vine/android/service/VineUploadService;->showFailedNotification(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 560
    :cond_e
    const-string v4, "discard"

    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 561
    invoke-direct/range {p0 .. p1}, Lco/vine/android/service/VineUploadService;->discardTask(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 514
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method private setScaledNotificationIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 5
    .param p1, "thumbnailPath"    # Ljava/lang/String;

    .prologue
    .line 661
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 662
    iget-object v2, p0, Lco/vine/android/service/VineUploadService;->mBitmaps:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 663
    .local v0, "bm":Landroid/graphics/Bitmap;
    if-nez v0, :cond_2

    .line 664
    iget v2, p0, Lco/vine/android/service/VineUploadService;->mNotificationPanelSize:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    .line 665
    invoke-virtual {p0}, Lco/vine/android/service/VineUploadService;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0b0060

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    iput v2, p0, Lco/vine/android/service/VineUploadService;->mNotificationPanelSize:I

    .line 667
    :cond_0
    invoke-static {p1}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 668
    .local v1, "thumbnailBitmap":Landroid/graphics/Bitmap;
    if-eqz v1, :cond_3

    .line 669
    iget v2, p0, Lco/vine/android/service/VineUploadService;->mNotificationPanelSize:I

    iget v3, p0, Lco/vine/android/service/VineUploadService;->mNotificationPanelSize:I

    const/4 v4, 0x1

    invoke-static {v1, v2, v3, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 670
    if-eqz v0, :cond_3

    .line 671
    iget-object v2, p0, Lco/vine/android/service/VineUploadService;->mBitmaps:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->size()I

    move-result v2

    const/16 v3, 0xa

    if-lt v2, v3, :cond_1

    .line 672
    iget-object v2, p0, Lco/vine/android/service/VineUploadService;->mBitmaps:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->clear()V

    .line 674
    :cond_1
    iget-object v2, p0, Lco/vine/android/service/VineUploadService;->mBitmaps:Ljava/util/HashMap;

    invoke-virtual {v2, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 686
    .end local v0    # "bm":Landroid/graphics/Bitmap;
    .end local v1    # "thumbnailBitmap":Landroid/graphics/Bitmap;
    :cond_2
    :goto_0
    return-object v0

    .line 682
    :cond_3
    iget-object v2, p0, Lco/vine/android/service/VineUploadService;->mDefaultNotificationIcon:Landroid/graphics/Bitmap;

    if-nez v2, :cond_4

    .line 683
    invoke-virtual {p0}, Lco/vine/android/service/VineUploadService;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020198

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/service/VineUploadService;->mDefaultNotificationIcon:Landroid/graphics/Bitmap;

    .line 685
    :cond_4
    iget-object v2, p0, Lco/vine/android/service/VineUploadService;->mBitmaps:Ljava/util/HashMap;

    iget-object v3, p0, Lco/vine/android/service/VineUploadService;->mDefaultNotificationIcon:Landroid/graphics/Bitmap;

    invoke-virtual {v2, p1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 686
    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mDefaultNotificationIcon:Landroid/graphics/Bitmap;

    goto :goto_0
.end method

.method private showFailedNotification(Ljava/lang/String;)V
    .locals 7
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 638
    invoke-static {p0, p1}, Lco/vine/android/util/UploadManager;->getUpload(Landroid/content/Context;Ljava/lang/String;)Lco/vine/android/api/VineUpload;

    move-result-object v3

    .line 639
    .local v3, "upload":Lco/vine/android/api/VineUpload;
    if-nez v3, :cond_0

    .line 655
    :goto_0
    return-void

    .line 641
    :cond_0
    const-string v4, "Show failed notification for {}, upload expired? {}."

    invoke-virtual {v3}, Lco/vine/android/api/VineUpload;->isExpired()Z

    move-result v5

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-static {v4, p1, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 642
    new-instance v1, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-direct {v1, p0}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    .line 643
    .local v1, "nb":Landroid/support/v4/app/NotificationCompat$Builder;
    const v4, 0x7f0201ff

    invoke-virtual {v1, v4}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 645
    iget-object v4, v3, Lco/vine/android/api/VineUpload;->thumbnailPath:Ljava/lang/String;

    invoke-direct {p0, v4}, Lco/vine/android/service/VineUploadService;->setScaledNotificationIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/support/v4/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 647
    const-string v4, "co.vine.android.UPLOAD_LIST"

    invoke-static {p0, v4}, Lco/vine/android/StartActivity;->getStartIntent(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 648
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {p0, v6, v0, v6}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    .line 649
    .local v2, "pendingIntent":Landroid/app/PendingIntent;
    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 651
    const v4, 0x7f0e017b

    invoke-virtual {p0, v4}, Lco/vine/android/service/VineUploadService;->getText(I)Ljava/lang/CharSequence;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 652
    const v4, 0x7f0e0244

    invoke-virtual {p0, v4}, Lco/vine/android/service/VineUploadService;->getText(I)Ljava/lang/CharSequence;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 653
    invoke-virtual {v1, v6}, Landroid/support/v4/app/NotificationCompat$Builder;->setAutoCancel(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 654
    invoke-direct {p0, v1, v6}, Lco/vine/android/service/VineUploadService;->showNotification(Landroid/support/v4/app/NotificationCompat$Builder;I)V

    goto :goto_0
.end method

.method private declared-synchronized showNotification(Landroid/support/v4/app/NotificationCompat$Builder;I)V
    .locals 4
    .param p1, "nb"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .param p2, "id"    # I

    .prologue
    .line 375
    monitor-enter p0

    :try_start_0
    sget-boolean v1, Lco/vine/android/service/VineUploadService;->sShowProgress:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 378
    :try_start_1
    iget-object v1, p0, Lco/vine/android/service/VineUploadService;->mNotificationManager:Landroid/app/NotificationManager;

    const-string v2, "upload_notification"

    invoke-virtual {p1}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v3

    invoke-virtual {v1, v2, p2, v3}, Landroid/app/NotificationManager;->notify(Ljava/lang/String;ILandroid/app/Notification;)V
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 384
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 379
    :catch_0
    move-exception v0

    .line 380
    .local v0, "e":Ljava/lang/RuntimeException;
    const/4 v1, 0x0

    :try_start_2
    invoke-virtual {p1, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 381
    iget-object v1, p0, Lco/vine/android/service/VineUploadService;->mNotificationManager:Landroid/app/NotificationManager;

    const-string v2, "upload_notification"

    invoke-virtual {p1}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v3

    invoke-virtual {v1, v2, p2, v3}, Landroid/app/NotificationManager;->notify(Ljava/lang/String;ILandroid/app/Notification;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 375
    .end local v0    # "e":Ljava/lang/RuntimeException;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private stopIfNoTasksLeft()V
    .locals 1

    .prologue
    .line 397
    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mPendingVMTasks:Ljava/util/LinkedHashSet;

    invoke-virtual {v0}, Ljava/util/LinkedHashSet;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mPendingTasks:Ljava/util/LinkedHashSet;

    invoke-virtual {v0}, Ljava/util/LinkedHashSet;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mCurrentTask:Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    invoke-direct {p0, v0}, Lco/vine/android/service/VineUploadService;->isRunning(Lco/vine/android/service/VineUploadService$ServiceAsyncTask;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 398
    invoke-direct {p0}, Lco/vine/android/service/VineUploadService;->stopService()V

    .line 400
    :cond_0
    return-void
.end method

.method private stopService()V
    .locals 4

    .prologue
    .line 407
    iget-object v3, p0, Lco/vine/android/service/VineUploadService;->mLock:[I

    monitor-enter v3

    .line 408
    :try_start_0
    iget-object v2, p0, Lco/vine/android/service/VineUploadService;->mStartIds:Ljava/util/LinkedList;

    invoke-virtual {v2}, Ljava/util/LinkedList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    .line 409
    .local v1, "key":Ljava/lang/Integer;
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {p0, v2}, Lco/vine/android/service/VineUploadService;->stopSelf(I)V

    goto :goto_0

    .line 412
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "key":Ljava/lang/Integer;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 411
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    iget-object v2, p0, Lco/vine/android/service/VineUploadService;->mStartIds:Ljava/util/LinkedList;

    invoke-virtual {v2}, Ljava/util/LinkedList;->clear()V

    .line 412
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 413
    return-void
.end method


# virtual methods
.method public getPostInfoFromIntent(Landroid/content/Intent;)Lco/vine/android/api/VineUpload$PostInfo;
    .locals 21
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 568
    const-string v3, "description"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 569
    .local v4, "caption":Ljava/lang/String;
    const-string v3, "postToTwitter"

    const/16 v19, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-virtual {v0, v3, v1}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v5

    .line 570
    .local v5, "postToTwitter":Z
    const-string v3, "postToFacebook"

    const/16 v19, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-virtual {v0, v3, v1}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v6

    .line 571
    .local v6, "postToFacebook":Z
    const-string v3, "channelId"

    const-wide/16 v19, -0x1

    move-object/from16 v0, p1

    move-wide/from16 v1, v19

    invoke-virtual {v0, v3, v1, v2}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v7

    .line 572
    .local v7, "channelId":J
    const-string v3, "entities"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getParcelableArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v9

    .line 573
    .local v9, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    const-string v3, "message"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 574
    .local v10, "message":Ljava/lang/String;
    const-string v3, "postId"

    const-wide/16 v19, -0x1

    move-object/from16 v0, p1

    move-wide/from16 v1, v19

    invoke-virtual {v0, v3, v1, v2}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v11

    .line 575
    .local v11, "postId":J
    const-string v3, "videoUrl"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 576
    .local v13, "videoUrl":Ljava/lang/String;
    const-string v3, "thumbUrl"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 577
    .local v14, "thumbUrl":Ljava/lang/String;
    const-string v3, "maxLoops"

    const/16 v19, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v19

    invoke-virtual {v0, v3, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v18

    .line 578
    .local v18, "maxLoops":I
    const-string v3, "created"

    const-wide/16 v19, 0x0

    move-object/from16 v0, p1

    move-wide/from16 v1, v19

    invoke-virtual {v0, v3, v1, v2}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v15

    .line 579
    .local v15, "created":J
    const-string v3, "recipients"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v17

    check-cast v17, Ljava/util/ArrayList;

    .line 582
    .local v17, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    new-instance v3, Lco/vine/android/api/VineUpload$PostInfo;

    invoke-direct/range {v3 .. v18}, Lco/vine/android/api/VineUpload$PostInfo;-><init>(Ljava/lang/String;ZZJLjava/util/ArrayList;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/util/ArrayList;I)V

    return-object v3
.end method

.method public handleServiceResponse(IILjava/lang/String;Landroid/os/Bundle;)V
    .locals 15
    .param p1, "what"    # I
    .param p2, "responseCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 1056
    sparse-switch p1, :sswitch_data_0

    .line 1105
    :cond_0
    :goto_0
    return-void

    .line 1058
    :sswitch_0
    const-string v11, "upload"

    move-object/from16 v0, p4

    invoke-virtual {v0, v11}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v9

    check-cast v9, Lco/vine/android/api/VineUpload;

    .line 1059
    .local v9, "upload":Lco/vine/android/api/VineUpload;
    const/16 v11, 0xc8

    move/from16 v0, p2

    if-ne v0, v11, :cond_3

    .line 1060
    const-string v11, "Post successful."

    invoke-static {v11}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 1061
    invoke-direct {p0}, Lco/vine/android/service/VineUploadService;->cancelFailedNofitication()V

    .line 1062
    iget-boolean v11, v9, Lco/vine/android/api/VineUpload;->isPrivate:Z

    if-nez v11, :cond_2

    .line 1063
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v6

    .line 1064
    .local v6, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v6}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 1065
    .local v1, "e":Landroid/content/SharedPreferences$Editor;
    const-string v11, "profile_post_count"

    const-string v12, "profile_post_count"

    const/4 v13, 0x0

    invoke-interface {v6, v12, v13}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v12

    add-int/lit8 v12, v12, 0x1

    invoke-interface {v1, v11, v12}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 1067
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 1076
    .end local v1    # "e":Landroid/content/SharedPreferences$Editor;
    .end local v6    # "prefs":Landroid/content/SharedPreferences;
    :cond_1
    :goto_1
    const-string v11, "should_delete_upload"

    const/4 v12, 0x0

    move-object/from16 v0, p4

    invoke-virtual {v0, v11, v12}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v7

    .line 1077
    .local v7, "saveUpload":Z
    iget-object v11, v9, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-static {v11}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_0

    if-nez v7, :cond_0

    .line 1078
    iget-object v11, v9, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-direct {p0, v11}, Lco/vine/android/service/VineUploadService;->discardUpload(Ljava/lang/String;)V

    goto :goto_0

    .line 1069
    .end local v7    # "saveUpload":Z
    :cond_2
    const-string v11, "post_url"

    move-object/from16 v0, p4

    invoke-virtual {v0, v11}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 1070
    .local v10, "videoUrl":Ljava/lang/String;
    const-string v11, "thumbnail_url"

    move-object/from16 v0, p4

    invoke-virtual {v0, v11}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 1071
    .local v8, "thumbUrl":Ljava/lang/String;
    if-eqz v10, :cond_1

    if-eqz v8, :cond_1

    .line 1072
    iget-object v11, v9, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-static {p0, v11, v10, v8}, Lco/vine/android/util/UploadManager;->prepopulateCache(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 1081
    .end local v8    # "thumbUrl":Ljava/lang/String;
    .end local v10    # "videoUrl":Ljava/lang/String;
    :cond_3
    invoke-static {p0}, Lco/vine/android/service/VineUploadService;->getNotifyFailedIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v2

    .line 1082
    .local v2, "failedIntent":Landroid/content/Intent;
    if-eqz v2, :cond_0

    .line 1083
    invoke-virtual {p0, v2}, Lco/vine/android/service/VineUploadService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1084
    if-eqz v9, :cond_0

    .line 1085
    const/4 v11, 0x2

    iget-object v12, v9, Lco/vine/android/api/VineUpload;->captchaUrl:Ljava/lang/String;

    invoke-static {p0, v9, v11, v12}, Lco/vine/android/util/UploadManager;->setStatus(Landroid/content/Context;Lco/vine/android/api/VineUpload;ILjava/lang/String;)V

    goto :goto_0

    .line 1093
    .end local v2    # "failedIntent":Landroid/content/Intent;
    .end local v9    # "upload":Lco/vine/android/api/VineUpload;
    :sswitch_1
    const-string v11, "upload"

    move-object/from16 v0, p4

    invoke-virtual {v0, v11}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v9

    check-cast v9, Lco/vine/android/api/VineUpload;

    .line 1094
    .restart local v9    # "upload":Lco/vine/android/api/VineUpload;
    const-string v11, "premerged_message_id"

    move-object/from16 v0, p4

    invoke-virtual {v0, v11}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 1095
    .local v4, "messageRowId":J
    iput-wide v4, v9, Lco/vine/android/api/VineUpload;->mergedMessageId:J

    .line 1096
    invoke-virtual {v9}, Lco/vine/android/api/VineUpload;->getPostInfo()Lco/vine/android/api/VineUpload$PostInfo;

    move-result-object v3

    .line 1097
    .local v3, "info":Lco/vine/android/api/VineUpload$PostInfo;
    const-string v11, "Pre merge message complete. Path {} Row {} {}"

    iget-object v12, v9, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    invoke-virtual {v3}, Lco/vine/android/api/VineUpload$PostInfo;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v11, v12, v13, v14}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1098
    iget-object v11, v9, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    if-eqz v11, :cond_4

    .line 1099
    invoke-static {p0, v9, v3}, Lco/vine/android/util/UploadManager;->setPostInfo(Landroid/content/Context;Lco/vine/android/api/VineUpload;Lco/vine/android/api/VineUpload$PostInfo;)V

    .line 1100
    iget-object v11, v9, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-static {p0, v11, v4, v5}, Lco/vine/android/util/UploadManager;->setUploadMessageRowId(Landroid/content/Context;Ljava/lang/String;J)V

    .line 1102
    :cond_4
    const/4 v11, 0x0

    invoke-static {p0, v9, v11}, Lco/vine/android/service/VineUploadService;->getPostIntent(Landroid/content/Context;Lco/vine/android/api/VineUpload;Z)Landroid/content/Intent;

    move-result-object v11

    invoke-virtual {p0, v11}, Lco/vine/android/service/VineUploadService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    goto/16 :goto_0

    .line 1056
    nop

    :sswitch_data_0
    .sparse-switch
        0x5d -> :sswitch_1
        0x62 -> :sswitch_0
    .end sparse-switch
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 1033
    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mMessenger:Landroid/os/Messenger;

    invoke-virtual {v0}, Landroid/os/Messenger;->getBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public onCreate()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 309
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 310
    new-instance v1, Ljava/util/LinkedHashSet;

    invoke-direct {v1}, Ljava/util/LinkedHashSet;-><init>()V

    iput-object v1, p0, Lco/vine/android/service/VineUploadService;->mPendingTasks:Ljava/util/LinkedHashSet;

    .line 311
    new-instance v1, Ljava/util/LinkedHashSet;

    invoke-direct {v1}, Ljava/util/LinkedHashSet;-><init>()V

    iput-object v1, p0, Lco/vine/android/service/VineUploadService;->mPendingVMTasks:Ljava/util/LinkedHashSet;

    .line 312
    new-instance v1, Lco/vine/android/util/UploadManager;

    invoke-direct {v1, p0}, Lco/vine/android/util/UploadManager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lco/vine/android/service/VineUploadService;->mUploadManager:Lco/vine/android/util/UploadManager;

    .line 313
    new-instance v1, Ljava/util/LinkedList;

    invoke-direct {v1}, Ljava/util/LinkedList;-><init>()V

    iput-object v1, p0, Lco/vine/android/service/VineUploadService;->mStartIds:Ljava/util/LinkedList;

    .line 314
    const-string v1, "notification"

    invoke-virtual {p0, v1}, Lco/vine/android/service/VineUploadService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/NotificationManager;

    iput-object v1, p0, Lco/vine/android/service/VineUploadService;->mNotificationManager:Landroid/app/NotificationManager;

    .line 315
    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->resetActiveSession()V

    .line 316
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 317
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string v1, "co.vine.android.session.logout"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 318
    const-string v1, "co.vine.android.session.login"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 319
    new-instance v1, Lco/vine/android/service/VineUploadService$SessionChangedReceiver;

    invoke-direct {v1, p0}, Lco/vine/android/service/VineUploadService$SessionChangedReceiver;-><init>(Lco/vine/android/service/VineUploadService;)V

    iput-object v1, p0, Lco/vine/android/service/VineUploadService;->mSessionChangedReceiver:Lco/vine/android/service/VineUploadService$SessionChangedReceiver;

    .line 320
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lco/vine/android/service/VineUploadService;->mBitmaps:Ljava/util/HashMap;

    .line 321
    iget-object v1, p0, Lco/vine/android/service/VineUploadService;->mSessionChangedReceiver:Lco/vine/android/service/VineUploadService$SessionChangedReceiver;

    const-string v2, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v1, v0, v2, v3}, Lco/vine/android/service/VineUploadService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 322
    new-instance v1, Landroid/os/Messenger;

    new-instance v2, Lco/vine/android/service/VineUploadService$IncomingHandler;

    invoke-direct {v2, p0, v3}, Lco/vine/android/service/VineUploadService$IncomingHandler;-><init>(Lco/vine/android/service/VineUploadService;Lco/vine/android/service/VineUploadService$1;)V

    invoke-direct {v1, v2}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object v1, p0, Lco/vine/android/service/VineUploadService;->mMessenger:Landroid/os/Messenger;

    .line 324
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lco/vine/android/service/VineService;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iget-object v2, p0, Lco/vine/android/service/VineUploadService;->mVineServiceConnection:Lco/vine/android/service/VineServiceConnection;

    const/4 v3, 0x1

    invoke-virtual {p0, v1, v2, v3}, Lco/vine/android/service/VineUploadService;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/service/VineUploadService;->mIsBinded:Z

    .line 326
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 365
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 366
    iget-boolean v0, p0, Lco/vine/android/service/VineUploadService;->mIsBinded:Z

    if-eqz v0, :cond_0

    .line 367
    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mVineServiceConnection:Lco/vine/android/service/VineServiceConnection;

    invoke-virtual {p0, v0}, Lco/vine/android/service/VineUploadService;->unbindService(Landroid/content/ServiceConnection;)V

    .line 369
    :cond_0
    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mSessionChangedReceiver:Lco/vine/android/service/VineUploadService$SessionChangedReceiver;

    if-eqz v0, :cond_1

    .line 370
    iget-object v0, p0, Lco/vine/android/service/VineUploadService;->mSessionChangedReceiver:Lco/vine/android/service/VineUploadService$SessionChangedReceiver;

    invoke-virtual {p0, v0}, Lco/vine/android/service/VineUploadService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 372
    :cond_1
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 11
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    const/4 v7, 0x1

    .line 417
    const-string v8, "onStartCommand, intent={}"

    invoke-static {v8, p1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 418
    iget-object v8, p0, Lco/vine/android/service/VineUploadService;->mLock:[I

    monitor-enter v8

    .line 419
    :try_start_0
    iget-object v9, p0, Lco/vine/android/service/VineUploadService;->mStartIds:Ljava/util/LinkedList;

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 420
    if-nez p1, :cond_0

    .line 421
    const/4 v7, 0x2

    monitor-exit v8

    .line 454
    :goto_0
    return v7

    .line 424
    :cond_0
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 425
    .local v0, "action":Ljava/lang/String;
    const-string v9, "path"

    invoke-virtual {p1, v9}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 426
    .local v3, "path":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 427
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string v9, "VineUploadService must be started with an explicit intent; set an action."

    invoke-direct {v7, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 453
    .end local v0    # "action":Ljava/lang/String;
    .end local v3    # "path":Ljava/lang/String;
    :catchall_0
    move-exception v7

    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v7

    .line 429
    .restart local v0    # "action":Ljava/lang/String;
    .restart local v3    # "path":Ljava/lang/String;
    :cond_1
    :try_start_1
    const-string v9, "discard_all"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 430
    invoke-static {p0}, Lco/vine/android/util/UploadManager;->getAllPaths(Landroid/content/Context;)Ljava/util/LinkedHashMap;

    move-result-object v5

    .line 431
    .local v5, "paths":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-virtual {v5}, Ljava/util/LinkedHashMap;->keySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 432
    .local v4, "pathToDiscard":Ljava/lang/String;
    invoke-direct {p0, v4}, Lco/vine/android/service/VineUploadService;->discardTask(Ljava/lang/String;)V

    goto :goto_1

    .line 434
    .end local v4    # "pathToDiscard":Ljava/lang/String;
    :cond_2
    invoke-direct {p0}, Lco/vine/android/service/VineUploadService;->cancelFailedNofitication()V

    .line 453
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v5    # "paths":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/String;Ljava/lang/Integer;>;"
    :goto_2
    monitor-exit v8

    goto :goto_0

    .line 435
    :cond_3
    const-string v9, "show_notifications"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 436
    const/4 v9, 0x1

    sput-boolean v9, Lco/vine/android/service/VineUploadService;->sShowProgress:Z

    goto :goto_2

    .line 437
    :cond_4
    const-string v9, "clear_notifications"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 438
    const/4 v9, 0x0

    sput-boolean v9, Lco/vine/android/service/VineUploadService;->sShowProgress:Z

    .line 439
    const/4 v9, 0x0

    invoke-direct {p0, v9}, Lco/vine/android/service/VineUploadService;->clearNotification(I)V

    .line 440
    const/4 v9, 0x1

    invoke-direct {p0, v9}, Lco/vine/android/service/VineUploadService;->clearNotification(I)V

    goto :goto_2

    .line 442
    :cond_5
    const/4 v2, 0x0

    .line 443
    .local v2, "listener":Lco/vine/android/service/UploadProgressListener;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_6

    .line 444
    const-string v9, "show_notifications"

    const/4 v10, 0x0

    invoke-virtual {p1, v9, v10}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v6

    .line 445
    .local v6, "showNotifications":Z
    if-eqz v6, :cond_7

    .line 446
    new-instance v2, Lco/vine/android/service/VineUploadService$NotificationProgressListener;

    .end local v2    # "listener":Lco/vine/android/service/UploadProgressListener;
    invoke-direct {v2, p0, v3}, Lco/vine/android/service/VineUploadService$NotificationProgressListener;-><init>(Lco/vine/android/service/VineUploadService;Ljava/lang/String;)V

    .line 451
    .end local v6    # "showNotifications":Z
    .restart local v2    # "listener":Lco/vine/android/service/UploadProgressListener;
    :cond_6
    :goto_3
    invoke-direct {p0, v3, v0, p1, v2}, Lco/vine/android/service/VineUploadService;->processCommand(Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Lco/vine/android/service/UploadProgressListener;)V

    goto :goto_2

    .line 448
    .restart local v6    # "showNotifications":Z
    :cond_7
    new-instance v2, Lco/vine/android/service/VineUploadService$IPCProgressListener;

    .end local v2    # "listener":Lco/vine/android/service/UploadProgressListener;
    invoke-direct {v2, p0, v3}, Lco/vine/android/service/VineUploadService$IPCProgressListener;-><init>(Lco/vine/android/service/VineUploadService;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .restart local v2    # "listener":Lco/vine/android/service/UploadProgressListener;
    goto :goto_3
.end method

.method public onUnbind(Landroid/content/Intent;)Z
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 1038
    const/4 v0, 0x0

    sput-object v0, Lco/vine/android/service/VineUploadService;->sUploadResultReceiver:Landroid/os/Messenger;

    .line 1039
    invoke-direct {p0}, Lco/vine/android/service/VineUploadService;->stopIfNoTasksLeft()V

    .line 1040
    const/4 v0, 0x0

    return v0
.end method
