.class public final Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;
.super Ljava/lang/Object;
.source "RetrySyncDirtyDataScheduler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "RetrySyncDirtyDataUnscheduler"
.end annotation


# instance fields
.field private final mDirtyDataIntent:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

.field private final mLastScheduledDirtySyncTime:Ljava/lang/Long;

.field final synthetic this$0:Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;


# direct methods
.method private constructor <init>(Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;Ljava/lang/Long;)V
    .locals 0
    .param p2, "dirtyDataIntent"    # Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    .param p3, "lastScheduledDirtySyncTime"    # Ljava/lang/Long;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;->this$0:Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;->mDirtyDataIntent:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    .line 41
    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;->mLastScheduledDirtySyncTime:Ljava/lang/Long;

    .line 42
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;Ljava/lang/Long;Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;
    .param p2, "x1"    # Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;
    .param p3, "x2"    # Ljava/lang/Long;
    .param p4, "x3"    # Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$1;

    .prologue
    .line 32
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;-><init>(Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;Ljava/lang/Long;)V

    return-void
.end method


# virtual methods
.method public markDataNotDirty()V
    .locals 3

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;->this$0:Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;

    # getter for: Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mLock:[Ljava/lang/Object;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->access$000(Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;)[Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 48
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;->mDirtyDataIntent:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    if-nez v0, :cond_0

    .line 50
    # getter for: Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->access$100()Ljava/lang/String;

    .line 51
    monitor-exit v1

    .line 56
    :goto_0
    return-void

    .line 54
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;->this$0:Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;

    # getter for: Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->mAlarmManager:Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->access$200(Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;)Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;

    move-result-object v0

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;->mDirtyDataIntent:Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->cancel(Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;)V

    .line 55
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;->this$0:Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler$RetrySyncDirtyDataUnscheduler;->mLastScheduledDirtySyncTime:Ljava/lang/Long;

    # invokes: Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->setNextScheduledDirtyDataSync(Ljava/lang/Long;)V
    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;->access$300(Lcom/amazon/identity/auth/device/storage/RetrySyncDirtyDataScheduler;Ljava/lang/Long;)V

    .line 56
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
