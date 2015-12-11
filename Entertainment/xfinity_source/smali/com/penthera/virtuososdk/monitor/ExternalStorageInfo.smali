.class public Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;
.super Landroid/content/BroadcastReceiver;
.source "ExternalStorageInfo.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo$IExternalStorageObserver;
    }
.end annotation


# static fields
.field private static iInstance:Ljava/lang/ref/SoftReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/SoftReference",
            "<",
            "Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;",
            ">;"
        }
    .end annotation
.end field

.field private static final iSuffixArray:[Ljava/lang/String;


# instance fields
.field private final LOG_TAG:Ljava/lang/String;

.field iBytesFree:D

.field private iObservers:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo$IExternalStorageObserver;",
            ">;"
        }
    .end annotation
.end field

.field iPercentFree:I

.field private iStat:Landroid/os/StatFs;

.field iStorageState:Ljava/lang/String;

.field iTotalBytes:D


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 29
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "bytes"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "KB"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "MB"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "GB"

    aput-object v2, v0, v1

    sput-object v0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iSuffixArray:[Ljava/lang/String;

    .line 24
    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    .line 168
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 27
    const-class v0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->LOG_TAG:Ljava/lang/String;

    .line 37
    new-instance v0, Landroid/os/StatFs;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iStat:Landroid/os/StatFs;

    .line 51
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iObservers:Ljava/util/Vector;

    .line 169
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iObservers:Ljava/util/Vector;

    .line 170
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->reset()V

    .line 171
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->update()V

    .line 172
    return-void
.end method

.method public static getInstance()Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;
    .locals 2

    .prologue
    .line 180
    const/4 v0, 0x0

    .line 181
    .local v0, "instance":Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;
    sget-object v1, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iInstance:Ljava/lang/ref/SoftReference;

    if-eqz v1, :cond_0

    .line 182
    sget-object v1, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iInstance:Ljava/lang/ref/SoftReference;

    invoke-virtual {v1}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "instance":Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;
    check-cast v0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;

    .line 185
    .restart local v0    # "instance":Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;
    :cond_0
    if-nez v0, :cond_1

    .line 186
    new-instance v0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;

    .end local v0    # "instance":Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;
    invoke-direct {v0}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;-><init>()V

    .line 187
    .restart local v0    # "instance":Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;
    new-instance v1, Ljava/lang/ref/SoftReference;

    invoke-direct {v1, v0}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    sput-object v1, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iInstance:Ljava/lang/ref/SoftReference;

    .line 190
    :cond_1
    return-object v0
.end method

.method private declared-synchronized notifyObservers(Ljava/lang/String;)V
    .locals 3
    .param p1, "state"    # Ljava/lang/String;

    .prologue
    .line 99
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iObservers:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-nez v2, :cond_0

    .line 103
    monitor-exit p0

    return-void

    .line 99
    :cond_0
    :try_start_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo$IExternalStorageObserver;

    .line 101
    .local v0, "observer":Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo$IExternalStorageObserver;
    invoke-interface {v0, p1}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo$IExternalStorageObserver;->onExternalStorageStateChange(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 99
    .end local v0    # "observer":Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo$IExternalStorageObserver;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private reset()V
    .locals 2

    .prologue
    const-wide/16 v0, 0x0

    .line 200
    iput-wide v0, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iTotalBytes:D

    .line 201
    iput-wide v0, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iBytesFree:D

    .line 202
    const/4 v0, 0x0

    iput v0, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iPercentFree:I

    .line 203
    return-void
.end method


# virtual methods
.method public isMounted()Z
    .locals 2

    .prologue
    .line 237
    const-string v0, "mounted"

    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iStorageState:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 239
    const/4 v0, 0x1

    .line 242
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isWritable()Z
    .locals 10

    .prologue
    .line 256
    const/4 v0, 0x0

    .line 259
    .local v0, "canWrite":Z
    :try_start_0
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 260
    .local v6, "sb":Ljava/lang/StringBuilder;
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 261
    .local v3, "f":Ljava/io/File;
    if-nez v3, :cond_0

    move v1, v0

    .line 280
    .end local v0    # "canWrite":Z
    .end local v3    # "f":Ljava/io/File;
    .end local v6    # "sb":Ljava/lang/StringBuilder;
    .local v1, "canWrite":I
    :goto_0
    return v1

    .line 264
    .end local v1    # "canWrite":I
    .restart local v0    # "canWrite":Z
    .restart local v3    # "f":Ljava/io/File;
    .restart local v6    # "sb":Ljava/lang/StringBuilder;
    :cond_0
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 265
    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 267
    const-string v7, "virtuoso"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 268
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "/.irw"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 270
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 272
    .local v5, "pathName":Ljava/lang/String;
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 273
    .local v4, "path":Ljava/io/File;
    invoke-virtual {v4}, Ljava/io/File;->createNewFile()Z

    .line 274
    invoke-virtual {v4}, Ljava/io/File;->delete()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 275
    const/4 v0, 0x1

    .end local v3    # "f":Ljava/io/File;
    .end local v4    # "path":Ljava/io/File;
    .end local v5    # "pathName":Ljava/lang/String;
    .end local v6    # "sb":Ljava/lang/StringBuilder;
    :goto_1
    move v1, v0

    .line 280
    .restart local v1    # "canWrite":I
    goto :goto_0

    .line 276
    .end local v1    # "canWrite":I
    :catch_0
    move-exception v2

    .line 277
    .local v2, "e":Ljava/lang/Exception;
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public declared-synchronized onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "aIntent"    # Landroid/content/Intent;

    .prologue
    .line 109
    monitor-enter p0

    :try_start_0
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 111
    .local v0, "action":Ljava/lang/String;
    const-string v1, "android.intent.action.MEDIA_REMOVED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 112
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->LOG_TAG:Ljava/lang/String;

    const-string v2, "onReceive(): The sdcard has been unmounted: "

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->update()V

    .line 114
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->notifyObservers(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 136
    :goto_0
    monitor-exit p0

    return-void

    .line 116
    :cond_0
    :try_start_1
    const-string v1, "android.intent.action.MEDIA_MOUNTED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 117
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->LOG_TAG:Ljava/lang/String;

    const-string v2, "onReceive(): The sdcard mounting has been restored: "

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->update()V

    .line 119
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->notifyObservers(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 109
    .end local v0    # "action":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 121
    .restart local v0    # "action":Ljava/lang/String;
    :cond_1
    :try_start_2
    const-string v1, "android.intent.action.MEDIA_SHARED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 122
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->update()V

    .line 123
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->notifyObservers(Ljava/lang/String;)V

    goto :goto_0

    .line 125
    :cond_2
    const-string v1, "android.intent.action.MEDIA_UNMOUNTED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 126
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->update()V

    .line 127
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->notifyObservers(Ljava/lang/String;)V

    goto :goto_0

    .line 129
    :cond_3
    const-string v1, "android.intent.action.MEDIA_BAD_REMOVAL"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 130
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->update()V

    .line 131
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->notifyObservers(Ljava/lang/String;)V

    goto :goto_0

    .line 134
    :cond_4
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "onReceive(): Received action we don\'t handle: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public update()V
    .locals 6

    .prologue
    .line 211
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iStorageState:Ljava/lang/String;

    .line 213
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iStorageState:Ljava/lang/String;

    const-string v2, "mounted"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 214
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->reset()V

    .line 227
    :cond_0
    :goto_0
    return-void

    .line 218
    :cond_1
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iStat:Landroid/os/StatFs;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/os/StatFs;->restat(Ljava/lang/String;)V

    .line 220
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iStat:Landroid/os/StatFs;

    invoke-virtual {v1}, Landroid/os/StatFs;->getBlockSize()I

    move-result v1

    int-to-float v0, v1

    .line 221
    .local v0, "blockSize":F
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iStat:Landroid/os/StatFs;

    invoke-virtual {v1}, Landroid/os/StatFs;->getBlockCount()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v0

    float-to-double v2, v1

    iput-wide v2, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iTotalBytes:D

    .line 222
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iStat:Landroid/os/StatFs;

    invoke-virtual {v1}, Landroid/os/StatFs;->getAvailableBlocks()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v0

    float-to-double v2, v1

    iput-wide v2, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iBytesFree:D

    .line 224
    iget-wide v2, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iTotalBytes:D

    const-wide/16 v4, 0x0

    cmpl-double v1, v2, v4

    if-lez v1, :cond_0

    .line 225
    iget-wide v2, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iBytesFree:D

    const-wide/high16 v4, 0x4059000000000000L    # 100.0

    mul-double/2addr v2, v4

    iget-wide v4, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iTotalBytes:D

    div-double/2addr v2, v4

    const-wide/high16 v4, 0x3fe0000000000000L    # 0.5

    add-double/2addr v2, v4

    double-to-int v1, v2

    iput v1, p0, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->iPercentFree:I

    goto :goto_0
.end method
