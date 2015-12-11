.class public Lco/vine/android/service/VineServiceConnection;
.super Ljava/lang/Object;
.source "VineServiceConnection.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;
    }
.end annotation


# instance fields
.field private mContext:Landroid/content/Context;

.field private final mLock:[I

.field private final mPendingQueue:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lco/vine/android/service/PendingAction;",
            ">;"
        }
    .end annotation
.end field

.field private final mRequestQueue:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lco/vine/android/service/PendingAction;",
            ">;"
        }
    .end annotation
.end field

.field private mResponseHandler:Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;

.field private mService:Landroid/os/Messenger;

.field private mServiceResponder:Landroid/os/Messenger;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "handler"    # Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/service/VineServiceConnection;->mPendingQueue:Ljava/util/HashMap;

    .line 25
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/service/VineServiceConnection;->mRequestQueue:Ljava/util/HashMap;

    .line 28
    const/4 v0, 0x0

    new-array v0, v0, [I

    iput-object v0, p0, Lco/vine/android/service/VineServiceConnection;->mLock:[I

    .line 114
    new-instance v0, Landroid/os/Messenger;

    new-instance v1, Lco/vine/android/service/VineServiceConnection$1;

    invoke-direct {v1, p0}, Lco/vine/android/service/VineServiceConnection$1;-><init>(Lco/vine/android/service/VineServiceConnection;)V

    invoke-direct {v0, v1}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lco/vine/android/service/VineServiceConnection;->mServiceResponder:Landroid/os/Messenger;

    .line 33
    iput-object p1, p0, Lco/vine/android/service/VineServiceConnection;->mContext:Landroid/content/Context;

    .line 34
    iput-object p2, p0, Lco/vine/android/service/VineServiceConnection;->mResponseHandler:Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;

    .line 35
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/service/VineServiceConnection;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/VineServiceConnection;

    .prologue
    .line 21
    iget-object v0, p0, Lco/vine/android/service/VineServiceConnection;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/service/VineServiceConnection;)Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/VineServiceConnection;

    .prologue
    .line 21
    iget-object v0, p0, Lco/vine/android/service/VineServiceConnection;->mResponseHandler:Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;

    return-object v0
.end method

.method private getMessage(Lco/vine/android/service/PendingAction;)Landroid/os/Message;
    .locals 2
    .param p1, "action"    # Lco/vine/android/service/PendingAction;

    .prologue
    .line 61
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v0

    .line 62
    .local v0, "msg":Landroid/os/Message;
    iget v1, p1, Lco/vine/android/service/PendingAction;->actionCode:I

    iput v1, v0, Landroid/os/Message;->arg1:I

    .line 63
    iget-object v1, p1, Lco/vine/android/service/PendingAction;->bundle:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    .line 64
    iget-object v1, p0, Lco/vine/android/service/VineServiceConnection;->mServiceResponder:Landroid/os/Messenger;

    iput-object v1, v0, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    .line 65
    return-object v0
.end method

.method private sendMessage(Landroid/os/Messenger;Landroid/os/Message;)V
    .locals 3
    .param p1, "service"    # Landroid/os/Messenger;
    .param p2, "msg"    # Landroid/os/Message;

    .prologue
    .line 70
    :try_start_0
    invoke-virtual {p1, p2}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 74
    :goto_0
    return-void

    .line 71
    :catch_0
    move-exception v0

    .line 72
    .local v0, "e":Landroid/os/RemoteException;
    const-string v1, "Unable to send message to service"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method


# virtual methods
.method public cancelAll()V
    .locals 2

    .prologue
    .line 54
    iget-object v1, p0, Lco/vine/android/service/VineServiceConnection;->mLock:[I

    monitor-enter v1

    .line 55
    :try_start_0
    iget-object v0, p0, Lco/vine/android/service/VineServiceConnection;->mRequestQueue:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 56
    iget-object v0, p0, Lco/vine/android/service/VineServiceConnection;->mPendingQueue:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 57
    monitor-exit v1

    .line 58
    return-void

    .line 57
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public generateRequestId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    const/4 v0, 0x6

    invoke-static {v0}, Lco/vine/android/util/Util;->randomString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isBound()Z
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lco/vine/android/service/VineServiceConnection;->mService:Landroid/os/Messenger;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPending(Ljava/lang/String;)Z
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;

    .prologue
    .line 97
    iget-object v1, p0, Lco/vine/android/service/VineServiceConnection;->mLock:[I

    monitor-enter v1

    .line 98
    :try_start_0
    iget-object v0, p0, Lco/vine/android/service/VineServiceConnection;->mRequestQueue:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 99
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 6
    .param p1, "name"    # Landroid/content/ComponentName;
    .param p2, "binder"    # Landroid/os/IBinder;

    .prologue
    .line 78
    iget-object v4, p0, Lco/vine/android/service/VineServiceConnection;->mLock:[I

    monitor-enter v4

    .line 79
    :try_start_0
    new-instance v2, Landroid/os/Messenger;

    invoke-direct {v2, p2}, Landroid/os/Messenger;-><init>(Landroid/os/IBinder;)V

    .line 80
    .local v2, "service":Landroid/os/Messenger;
    iput-object v2, p0, Lco/vine/android/service/VineServiceConnection;->mService:Landroid/os/Messenger;

    .line 81
    iget-object v3, p0, Lco/vine/android/service/VineServiceConnection;->mRequestQueue:Ljava/util/HashMap;

    iget-object v5, p0, Lco/vine/android/service/VineServiceConnection;->mPendingQueue:Ljava/util/HashMap;

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 82
    iget-object v3, p0, Lco/vine/android/service/VineServiceConnection;->mPendingQueue:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/service/PendingAction;

    .line 83
    .local v0, "action":Lco/vine/android/service/PendingAction;
    invoke-direct {p0, v0}, Lco/vine/android/service/VineServiceConnection;->getMessage(Lco/vine/android/service/PendingAction;)Landroid/os/Message;

    move-result-object v3

    invoke-direct {p0, v2, v3}, Lco/vine/android/service/VineServiceConnection;->sendMessage(Landroid/os/Messenger;Landroid/os/Message;)V

    goto :goto_0

    .line 86
    .end local v0    # "action":Lco/vine/android/service/PendingAction;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "service":Landroid/os/Messenger;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 85
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "service":Landroid/os/Messenger;
    :cond_0
    :try_start_1
    iget-object v3, p0, Lco/vine/android/service/VineServiceConnection;->mPendingQueue:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->clear()V

    .line 86
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 87
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 2
    .param p1, "name"    # Landroid/content/ComponentName;

    .prologue
    .line 91
    iget-object v1, p0, Lco/vine/android/service/VineServiceConnection;->mLock:[I

    monitor-enter v1

    .line 92
    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lco/vine/android/service/VineServiceConnection;->mService:Landroid/os/Messenger;

    .line 93
    monitor-exit v1

    .line 94
    return-void

    .line 93
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public queueAndExecute(ILandroid/os/Bundle;)Ljava/lang/String;
    .locals 5
    .param p1, "actionCode"    # I
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 38
    invoke-virtual {p0}, Lco/vine/android/service/VineServiceConnection;->generateRequestId()Ljava/lang/String;

    move-result-object v1

    .line 39
    .local v1, "reqId":Ljava/lang/String;
    new-instance v0, Lco/vine/android/service/PendingAction;

    invoke-direct {v0, p1, p2}, Lco/vine/android/service/PendingAction;-><init>(ILandroid/os/Bundle;)V

    .line 40
    .local v0, "action":Lco/vine/android/service/PendingAction;
    const-string v3, "rid"

    invoke-virtual {p2, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    iget-object v4, p0, Lco/vine/android/service/VineServiceConnection;->mLock:[I

    monitor-enter v4

    .line 42
    :try_start_0
    iget-object v2, p0, Lco/vine/android/service/VineServiceConnection;->mService:Landroid/os/Messenger;

    .line 43
    .local v2, "service":Landroid/os/Messenger;
    if-eqz v2, :cond_0

    .line 44
    iget-object v3, p0, Lco/vine/android/service/VineServiceConnection;->mRequestQueue:Ljava/util/HashMap;

    invoke-virtual {v3, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    invoke-direct {p0, v0}, Lco/vine/android/service/VineServiceConnection;->getMessage(Lco/vine/android/service/PendingAction;)Landroid/os/Message;

    move-result-object v3

    invoke-direct {p0, v2, v3}, Lco/vine/android/service/VineServiceConnection;->sendMessage(Landroid/os/Messenger;Landroid/os/Message;)V

    .line 49
    :goto_0
    monitor-exit v4

    .line 50
    return-object v1

    .line 47
    :cond_0
    iget-object v3, p0, Lco/vine/android/service/VineServiceConnection;->mPendingQueue:Ljava/util/HashMap;

    invoke-virtual {v3, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 49
    .end local v2    # "service":Landroid/os/Messenger;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method public remove(Ljava/lang/String;)Lco/vine/android/service/PendingAction;
    .locals 3
    .param p1, "reqId"    # Ljava/lang/String;

    .prologue
    .line 103
    iget-object v2, p0, Lco/vine/android/service/VineServiceConnection;->mLock:[I

    monitor-enter v2

    .line 104
    :try_start_0
    iget-object v1, p0, Lco/vine/android/service/VineServiceConnection;->mRequestQueue:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/service/PendingAction;

    .line 105
    .local v0, "action":Lco/vine/android/service/PendingAction;
    iget-object v1, p0, Lco/vine/android/service/VineServiceConnection;->mRequestQueue:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 106
    monitor-exit v2

    return-object v0

    .line 107
    .end local v0    # "action":Lco/vine/android/service/PendingAction;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method
