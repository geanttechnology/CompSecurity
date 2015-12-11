.class public Lcom/poshmark/data_model/models/BadgeCount;
.super Ljava/lang/Object;
.source "BadgeCount.java"


# static fields
.field public static count:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 7
    const/4 v0, 0x0

    sput v0, Lcom/poshmark/data_model/models/BadgeCount;->count:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized incrementCount()V
    .locals 2

    .prologue
    .line 10
    const-class v1, Lcom/poshmark/data_model/models/BadgeCount;

    monitor-enter v1

    :try_start_0
    sget v0, Lcom/poshmark/data_model/models/BadgeCount;->count:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/poshmark/data_model/models/BadgeCount;->count:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 11
    monitor-exit v1

    return-void

    .line 10
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized resetCount()V
    .locals 2

    .prologue
    .line 14
    const-class v0, Lcom/poshmark/data_model/models/BadgeCount;

    monitor-enter v0

    const/4 v1, 0x0

    :try_start_0
    sput v1, Lcom/poshmark/data_model/models/BadgeCount;->count:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 15
    monitor-exit v0

    return-void

    .line 14
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized setCountValue(I)V
    .locals 2
    .param p0, "val"    # I

    .prologue
    .line 18
    const-class v0, Lcom/poshmark/data_model/models/BadgeCount;

    monitor-enter v0

    :try_start_0
    sput p0, Lcom/poshmark/data_model/models/BadgeCount;->count:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 19
    monitor-exit v0

    return-void

    .line 18
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method
