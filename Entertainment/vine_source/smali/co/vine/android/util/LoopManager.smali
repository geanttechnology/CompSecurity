.class public Lco/vine/android/util/LoopManager;
.super Ljava/lang/Object;
.source "LoopManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/LoopManager$1;,
        Lco/vine/android/util/LoopManager$Record;
    }
.end annotation


# static fields
.field private static final DEBUGABLE:Z

.field private static final LOCK:[I

.field private static final TAG:Ljava/lang/String; = "VineLoopManager"

.field private static final sCounts:Lco/vine/android/util/LongSparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/util/LongSparseArray",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static sInstance:Lco/vine/android/util/LoopManager;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mPrefs:Landroid/content/SharedPreferences;

.field private mRecords:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lco/vine/android/util/LoopManager$Record;",
            ">;"
        }
    .end annotation
.end field

.field private mViewingId:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lco/vine/android/util/LoopManager;->LOCK:[I

    .line 25
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v0

    sput-boolean v0, Lco/vine/android/util/LoopManager;->DEBUGABLE:Z

    .line 32
    new-instance v0, Lco/vine/android/util/LongSparseArray;

    invoke-direct {v0}, Lco/vine/android/util/LongSparseArray;-><init>()V

    sput-object v0, Lco/vine/android/util/LoopManager;->sCounts:Lco/vine/android/util/LongSparseArray;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 119
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 120
    invoke-static {p1}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/util/LoopManager;->mPrefs:Landroid/content/SharedPreferences;

    .line 121
    new-instance v3, Ljava/util/LinkedList;

    invoke-direct {v3}, Ljava/util/LinkedList;-><init>()V

    iput-object v3, p0, Lco/vine/android/util/LoopManager;->mRecords:Ljava/util/LinkedList;

    .line 122
    iput-object p1, p0, Lco/vine/android/util/LoopManager;->mContext:Landroid/content/Context;

    .line 123
    const-wide/16 v3, 0x0

    iput-wide v3, p0, Lco/vine/android/util/LoopManager;->mViewingId:J

    .line 124
    iget-object v3, p0, Lco/vine/android/util/LoopManager;->mPrefs:Landroid/content/SharedPreferences;

    const-string v4, "pref_loop_count_records"

    invoke-static {}, Ljava/util/Collections;->emptySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;

    move-result-object v2

    .line 125
    .local v2, "savedLoops":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 126
    .local v1, "s":Ljava/lang/String;
    invoke-static {v1}, Lco/vine/android/util/LoopManager$Record;->fromSerializedString(Ljava/lang/String;)Lco/vine/android/util/LoopManager$Record;

    move-result-object v3

    invoke-virtual {p0, v3}, Lco/vine/android/util/LoopManager;->addRecord(Lco/vine/android/util/LoopManager$Record;)V

    goto :goto_0

    .line 128
    .end local v1    # "s":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method static synthetic access$000()Lco/vine/android/util/LongSparseArray;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lco/vine/android/util/LoopManager;->sCounts:Lco/vine/android/util/LongSparseArray;

    return-object v0
.end method

.method public static get(Landroid/content/Context;)Lco/vine/android/util/LoopManager;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 131
    sget-object v1, Lco/vine/android/util/LoopManager;->LOCK:[I

    monitor-enter v1

    .line 132
    :try_start_0
    sget-object v0, Lco/vine/android/util/LoopManager;->sInstance:Lco/vine/android/util/LoopManager;

    if-nez v0, :cond_0

    .line 133
    new-instance v0, Lco/vine/android/util/LoopManager;

    invoke-direct {v0, p0}, Lco/vine/android/util/LoopManager;-><init>(Landroid/content/Context;)V

    sput-object v0, Lco/vine/android/util/LoopManager;->sInstance:Lco/vine/android/util/LoopManager;

    .line 135
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 136
    sget-object v0, Lco/vine/android/util/LoopManager;->sInstance:Lco/vine/android/util/LoopManager;

    return-object v0

    .line 135
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public static getLocalLoopCount(J)I
    .locals 2
    .param p0, "postId"    # J

    .prologue
    .line 35
    sget-object v0, Lco/vine/android/util/LoopManager;->sCounts:Lco/vine/android/util/LongSparseArray;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, p0, p1, v1}, Lco/vine/android/util/LongSparseArray;->get(JLjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method


# virtual methods
.method public addRecord(Lco/vine/android/util/LoopManager$Record;)V
    .locals 7
    .param p1, "record"    # Lco/vine/android/util/LoopManager$Record;

    .prologue
    const/4 v6, -0x1

    .line 154
    sget-object v2, Lco/vine/android/util/LoopManager;->LOCK:[I

    monitor-enter v2

    .line 155
    :try_start_0
    iget-object v1, p0, Lco/vine/android/util/LoopManager;->mRecords:Ljava/util/LinkedList;

    invoke-virtual {v1, p1}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 156
    iget v1, p1, Lco/vine/android/util/LoopManager$Record;->loopCount:I

    if-lez v1, :cond_0

    .line 157
    sget-object v1, Lco/vine/android/util/LoopManager;->sCounts:Lco/vine/android/util/LongSparseArray;

    iget-wide v3, p1, Lco/vine/android/util/LoopManager$Record;->postId:J

    const/4 v5, -0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v1, v3, v4, v5}, Lco/vine/android/util/LongSparseArray;->get(JLjava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 158
    .local v0, "currentCount":I
    if-ne v0, v6, :cond_1

    .line 159
    sget-object v1, Lco/vine/android/util/LoopManager;->sCounts:Lco/vine/android/util/LongSparseArray;

    iget-wide v3, p1, Lco/vine/android/util/LoopManager$Record;->postId:J

    iget v5, p1, Lco/vine/android/util/LoopManager$Record;->loopCount:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v1, v3, v4, v5}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 164
    .end local v0    # "currentCount":I
    :cond_0
    :goto_0
    monitor-exit v2

    .line 165
    return-void

    .line 161
    .restart local v0    # "currentCount":I
    :cond_1
    sget-object v1, Lco/vine/android/util/LoopManager;->sCounts:Lco/vine/android/util/LongSparseArray;

    iget-wide v3, p1, Lco/vine/android/util/LoopManager$Record;->postId:J

    iget v5, p1, Lco/vine/android/util/LoopManager$Record;->loopCount:I

    add-int/2addr v5, v0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v1, v3, v4, v5}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    goto :goto_0

    .line 164
    .end local v0    # "currentCount":I
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public increment(J)V
    .locals 5
    .param p1, "postId"    # J

    .prologue
    .line 140
    sget-object v2, Lco/vine/android/util/LoopManager;->LOCK:[I

    monitor-enter v2

    .line 142
    :try_start_0
    iget-wide v3, p0, Lco/vine/android/util/LoopManager;->mViewingId:J

    cmp-long v1, v3, p1

    if-eqz v1, :cond_0

    .line 143
    new-instance v0, Lco/vine/android/util/LoopManager$Record;

    iget-object v1, p0, Lco/vine/android/util/LoopManager;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v3

    invoke-direct {v0, v3, v4, p1, p2}, Lco/vine/android/util/LoopManager$Record;-><init>(JJ)V

    .line 144
    .local v0, "record":Lco/vine/android/util/LoopManager$Record;
    invoke-virtual {p0, v0}, Lco/vine/android/util/LoopManager;->addRecord(Lco/vine/android/util/LoopManager$Record;)V

    .line 148
    :goto_0
    iput-wide p1, p0, Lco/vine/android/util/LoopManager;->mViewingId:J

    .line 149
    invoke-virtual {v0}, Lco/vine/android/util/LoopManager$Record;->increment()V

    .line 150
    monitor-exit v2

    .line 151
    return-void

    .line 146
    .end local v0    # "record":Lco/vine/android/util/LoopManager$Record;
    :cond_0
    iget-object v1, p0, Lco/vine/android/util/LoopManager;->mRecords:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->getLast()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/LoopManager$Record;

    .restart local v0    # "record":Lco/vine/android/util/LoopManager$Record;
    goto :goto_0

    .line 150
    .end local v0    # "record":Lco/vine/android/util/LoopManager$Record;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public popPendingLoops()Ljava/util/List;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lco/vine/android/util/LoopManager$Record;",
            ">;"
        }
    .end annotation

    .prologue
    .line 182
    new-instance v3, Ljava/util/LinkedList;

    invoke-direct {v3}, Ljava/util/LinkedList;-><init>()V

    .line 183
    .local v3, "substitute":Ljava/util/LinkedList;, "Ljava/util/LinkedList<Lco/vine/android/util/LoopManager$Record;>;"
    sget-object v7, Lco/vine/android/util/LoopManager;->LOCK:[I

    monitor-enter v7

    .line 184
    :try_start_0
    iget-object v1, p0, Lco/vine/android/util/LoopManager;->mRecords:Ljava/util/LinkedList;

    .line 185
    .local v1, "pendingLoops":Ljava/util/LinkedList;, "Ljava/util/LinkedList<Lco/vine/android/util/LoopManager$Record;>;"
    iput-object v3, p0, Lco/vine/android/util/LoopManager;->mRecords:Ljava/util/LinkedList;

    .line 187
    invoke-virtual {v1}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_0

    iget-wide v8, p0, Lco/vine/android/util/LoopManager;->mViewingId:J

    invoke-virtual {v1}, Ljava/util/LinkedList;->getLast()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/util/LoopManager$Record;

    iget-wide v10, v6, Lco/vine/android/util/LoopManager$Record;->postId:J

    cmp-long v6, v8, v10

    if-nez v6, :cond_0

    .line 188
    iget-object v6, p0, Lco/vine/android/util/LoopManager;->mRecords:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->removeLast()Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 190
    :cond_0
    monitor-exit v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 193
    iget-object v6, p0, Lco/vine/android/util/LoopManager;->mContext:Landroid/content/Context;

    invoke-static {v6}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v4

    .line 194
    .local v4, "userId":J
    invoke-virtual {v1}, Ljava/util/LinkedList;->listIterator()Ljava/util/ListIterator;

    move-result-object v0

    .local v0, "it":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Lco/vine/android/util/LoopManager$Record;>;"
    :cond_1
    :goto_0
    invoke-interface {v0}, Ljava/util/ListIterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 195
    invoke-interface {v0}, Ljava/util/ListIterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/LoopManager$Record;

    .line 196
    .local v2, "r":Lco/vine/android/util/LoopManager$Record;
    iget-wide v6, v2, Lco/vine/android/util/LoopManager$Record;->userId:J

    cmp-long v6, v6, v4

    if-eqz v6, :cond_1

    .line 197
    sget-object v7, Lco/vine/android/util/LoopManager;->LOCK:[I

    monitor-enter v7

    .line 198
    :try_start_1
    iget-object v6, p0, Lco/vine/android/util/LoopManager;->mRecords:Ljava/util/LinkedList;

    invoke-virtual {v6, v2}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 199
    monitor-exit v7
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 200
    invoke-interface {v0}, Ljava/util/ListIterator;->remove()V

    goto :goto_0

    .line 190
    .end local v0    # "it":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Lco/vine/android/util/LoopManager$Record;>;"
    .end local v1    # "pendingLoops":Ljava/util/LinkedList;, "Ljava/util/LinkedList<Lco/vine/android/util/LoopManager$Record;>;"
    .end local v2    # "r":Lco/vine/android/util/LoopManager$Record;
    .end local v4    # "userId":J
    :catchall_0
    move-exception v6

    :try_start_2
    monitor-exit v7
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v6

    .line 199
    .restart local v0    # "it":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Lco/vine/android/util/LoopManager$Record;>;"
    .restart local v1    # "pendingLoops":Ljava/util/LinkedList;, "Ljava/util/LinkedList<Lco/vine/android/util/LoopManager$Record;>;"
    .restart local v2    # "r":Lco/vine/android/util/LoopManager$Record;
    .restart local v4    # "userId":J
    :catchall_1
    move-exception v6

    :try_start_3
    monitor-exit v7
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v6

    .line 203
    .end local v2    # "r":Lco/vine/android/util/LoopManager$Record;
    :cond_2
    return-object v1
.end method

.method public save()V
    .locals 7

    .prologue
    .line 168
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 169
    .local v2, "recordsToSave":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    sget-object v4, Lco/vine/android/util/LoopManager;->LOCK:[I

    monitor-enter v4

    .line 170
    :try_start_0
    iget-object v3, p0, Lco/vine/android/util/LoopManager;->mRecords:Ljava/util/LinkedList;

    invoke-virtual {v3}, Ljava/util/LinkedList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/util/LoopManager$Record;

    .line 171
    .local v1, "r":Lco/vine/android/util/LoopManager$Record;
    invoke-virtual {v1}, Lco/vine/android/util/LoopManager$Record;->toSerializedString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 176
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "r":Lco/vine/android/util/LoopManager$Record;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 173
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    sget-boolean v3, Lco/vine/android/util/LoopManager;->DEBUGABLE:Z

    if-eqz v3, :cond_1

    .line 174
    const-string v3, "VineLoopManager"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Committing these loop records:\n"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p0}, Lco/vine/android/util/LoopManager;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 176
    :cond_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 177
    iget-object v3, p0, Lco/vine/android/util/LoopManager;->mPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string v4, "pref_loop_count_records"

    invoke-interface {v3, v4, v2}, Landroid/content/SharedPreferences$Editor;->putStringSet(Ljava/lang/String;Ljava/util/Set;)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 178
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    .prologue
    .line 215
    sget-object v4, Lco/vine/android/util/LoopManager;->LOCK:[I

    monitor-enter v4

    .line 216
    :try_start_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 217
    .local v2, "sb":Ljava/lang/StringBuilder;
    iget-object v3, p0, Lco/vine/android/util/LoopManager;->mRecords:Ljava/util/LinkedList;

    invoke-virtual {v3}, Ljava/util/LinkedList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/util/LoopManager$Record;

    .line 218
    .local v1, "r":Lco/vine/android/util/LoopManager$Record;
    invoke-virtual {v1}, Lco/vine/android/util/LoopManager$Record;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v5, 0xa

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 221
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "r":Lco/vine/android/util/LoopManager$Record;
    .end local v2    # "sb":Ljava/lang/StringBuilder;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 220
    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v2    # "sb":Ljava/lang/StringBuilder;
    :cond_0
    :try_start_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v3
.end method

.method public undoPopPendingLoops(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lco/vine/android/util/LoopManager$Record;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 207
    .local p1, "poppedRecords":Ljava/util/List;, "Ljava/util/List<Lco/vine/android/util/LoopManager$Record;>;"
    sget-object v1, Lco/vine/android/util/LoopManager;->LOCK:[I

    monitor-enter v1

    .line 208
    :try_start_0
    iget-object v0, p0, Lco/vine/android/util/LoopManager;->mRecords:Ljava/util/LinkedList;

    const/4 v2, 0x0

    invoke-virtual {v0, v2, p1}, Ljava/util/LinkedList;->addAll(ILjava/util/Collection;)Z

    .line 209
    invoke-virtual {p0}, Lco/vine/android/util/LoopManager;->save()V

    .line 210
    monitor-exit v1

    .line 211
    return-void

    .line 210
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
