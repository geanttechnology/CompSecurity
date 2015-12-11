.class public Lco/vine/android/util/IntentionalObjectCounter;
.super Ljava/lang/Object;
.source "IntentionalObjectCounter.java"


# static fields
.field private static final LOCK:[I

.field public static final RECORDER_INSTANCE_COUNT:Ljava/lang/String; = "recorder"

.field private static final sInstances:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Ljava/lang/Object;",
            ">;>;>;"
        }
    .end annotation
.end field


# instance fields
.field private final mItem:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field public final mKey:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lco/vine/android/util/IntentionalObjectCounter;->LOCK:[I

    .line 15
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lco/vine/android/util/IntentionalObjectCounter;->sInstances:Ljava/util/HashMap;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "item"    # Ljava/lang/Object;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lco/vine/android/util/IntentionalObjectCounter;->mKey:Ljava/lang/String;

    .line 22
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lco/vine/android/util/IntentionalObjectCounter;->mItem:Ljava/lang/ref/WeakReference;

    .line 23
    return-void
.end method

.method public static add(Ljava/lang/String;Ljava/lang/ref/WeakReference;)V
    .locals 3
    .param p0, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 38
    .local p1, "item":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;"
    invoke-static {p0}, Lco/vine/android/util/IntentionalObjectCounter;->getCounter(Ljava/lang/String;)Ljava/util/HashSet;

    move-result-object v0

    .line 39
    .local v0, "counter":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;>;"
    sget-object v2, Lco/vine/android/util/IntentionalObjectCounter;->LOCK:[I

    monitor-enter v2

    .line 40
    :try_start_0
    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 41
    monitor-exit v2

    .line 42
    return-void

    .line 41
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public static getCount(Ljava/lang/String;)I
    .locals 3
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 52
    invoke-static {p0}, Lco/vine/android/util/IntentionalObjectCounter;->getCounter(Ljava/lang/String;)Ljava/util/HashSet;

    move-result-object v0

    .line 53
    .local v0, "counter":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;>;"
    sget-object v2, Lco/vine/android/util/IntentionalObjectCounter;->LOCK:[I

    monitor-enter v2

    .line 54
    :try_start_0
    invoke-virtual {v0}, Ljava/util/HashSet;->size()I

    move-result v1

    monitor-exit v2

    return v1

    .line 55
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private static getCounter(Ljava/lang/String;)Ljava/util/HashSet;
    .locals 3
    .param p0, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 60
    sget-object v2, Lco/vine/android/util/IntentionalObjectCounter;->LOCK:[I

    monitor-enter v2

    .line 61
    :try_start_0
    sget-object v1, Lco/vine/android/util/IntentionalObjectCounter;->sInstances:Ljava/util/HashMap;

    invoke-virtual {v1, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashSet;

    .line 62
    .local v0, "counter":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;>;"
    if-nez v0, :cond_0

    .line 63
    new-instance v0, Ljava/util/HashSet;

    .end local v0    # "counter":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;>;"
    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 64
    .restart local v0    # "counter":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;>;"
    sget-object v1, Lco/vine/android/util/IntentionalObjectCounter;->sInstances:Ljava/util/HashMap;

    invoke-virtual {v1, p0, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    :cond_0
    monitor-exit v2

    return-object v0

    .line 67
    .end local v0    # "counter":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public static release(Ljava/lang/String;Ljava/lang/ref/WeakReference;)V
    .locals 3
    .param p0, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 45
    .local p1, "item":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;"
    invoke-static {p0}, Lco/vine/android/util/IntentionalObjectCounter;->getCounter(Ljava/lang/String;)Ljava/util/HashSet;

    move-result-object v0

    .line 46
    .local v0, "counter":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;>;"
    sget-object v2, Lco/vine/android/util/IntentionalObjectCounter;->LOCK:[I

    monitor-enter v2

    .line 47
    :try_start_0
    invoke-virtual {v0, p1}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    .line 48
    monitor-exit v2

    .line 49
    return-void

    .line 48
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method


# virtual methods
.method public add()V
    .locals 2

    .prologue
    .line 26
    iget-object v0, p0, Lco/vine/android/util/IntentionalObjectCounter;->mKey:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/util/IntentionalObjectCounter;->mItem:Ljava/lang/ref/WeakReference;

    invoke-static {v0, v1}, Lco/vine/android/util/IntentionalObjectCounter;->add(Ljava/lang/String;Ljava/lang/ref/WeakReference;)V

    .line 27
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lco/vine/android/util/IntentionalObjectCounter;->mKey:Ljava/lang/String;

    invoke-static {v0}, Lco/vine/android/util/IntentionalObjectCounter;->getCount(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public release()V
    .locals 2

    .prologue
    .line 30
    iget-object v0, p0, Lco/vine/android/util/IntentionalObjectCounter;->mKey:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/util/IntentionalObjectCounter;->mItem:Ljava/lang/ref/WeakReference;

    invoke-static {v0, v1}, Lco/vine/android/util/IntentionalObjectCounter;->release(Ljava/lang/String;Ljava/lang/ref/WeakReference;)V

    .line 31
    return-void
.end method
