.class Lnet/tsz/afinal/bitmap/core/LruDiskCache$1;
.super Ljava/lang/Object;
.source "LruDiskCache.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lnet/tsz/afinal/bitmap/core/LruDiskCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;


# direct methods
.method constructor <init>(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$1;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    .line 266
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 1
    invoke-virtual {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$1;->call()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/Void;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 268
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$1;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    monitor-enter v1

    .line 269
    :try_start_0
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$1;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)Ljava/io/Writer;

    move-result-object v0

    if-nez v0, :cond_0

    .line 270
    monitor-exit v1

    .line 278
    :goto_0
    return-object v3

    .line 272
    :cond_0
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$1;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    # invokes: Lnet/tsz/afinal/bitmap/core/LruDiskCache;->trimToSize()V
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->access$1(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)V

    .line 273
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$1;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    # invokes: Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalRebuildRequired()Z
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->access$2(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 274
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$1;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    # invokes: Lnet/tsz/afinal/bitmap/core/LruDiskCache;->rebuildJournal()V
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->access$3(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)V

    .line 275
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$1;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    const/4 v2, 0x0

    invoke-static {v0, v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->access$4(Lnet/tsz/afinal/bitmap/core/LruDiskCache;I)V

    .line 268
    :cond_1
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
