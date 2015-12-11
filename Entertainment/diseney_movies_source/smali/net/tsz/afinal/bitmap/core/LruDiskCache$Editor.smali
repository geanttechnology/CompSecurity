.class public final Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
.super Ljava/lang/Object;
.source "LruDiskCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lnet/tsz/afinal/bitmap/core/LruDiskCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "Editor"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor$FaultHidingOutputStream;
    }
.end annotation


# instance fields
.field private final entry:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

.field private hasErrors:Z

.field final synthetic this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;


# direct methods
.method private constructor <init>(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)V
    .locals 0
    .param p2, "entry"    # Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    .prologue
    .line 773
    iput-object p1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 774
    iput-object p2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->entry:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    .line 775
    return-void
.end method

.method synthetic constructor <init>(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;)V
    .locals 0

    .prologue
    .line 773
    invoke-direct {p0, p1, p2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;-><init>(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)V

    return-void
.end method

.method static synthetic access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;Z)V
    .locals 0

    .prologue
    .line 771
    iput-boolean p1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->hasErrors:Z

    return-void
.end method

.method static synthetic access$2(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    .locals 1

    .prologue
    .line 770
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->entry:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    return-object v0
.end method


# virtual methods
.method public abort()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 849
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    const/4 v1, 0x0

    # invokes: Lnet/tsz/afinal/bitmap/core/LruDiskCache;->completeEdit(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;Z)V
    invoke-static {v0, p0, v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->access$8(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;Z)V

    .line 850
    return-void
.end method

.method public commit()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 836
    iget-boolean v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->hasErrors:Z

    if-eqz v0, :cond_0

    .line 837
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    const/4 v1, 0x0

    # invokes: Lnet/tsz/afinal/bitmap/core/LruDiskCache;->completeEdit(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;Z)V
    invoke-static {v0, p0, v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->access$8(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;Z)V

    .line 838
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->entry:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->key:Ljava/lang/String;
    invoke-static {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$2(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->remove(Ljava/lang/String;)Z

    .line 842
    :goto_0
    return-void

    .line 840
    :cond_0
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    const/4 v1, 0x1

    # invokes: Lnet/tsz/afinal/bitmap/core/LruDiskCache;->completeEdit(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;Z)V
    invoke-static {v0, p0, v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->access$8(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;Z)V

    goto :goto_0
.end method

.method public getString(I)Ljava/lang/String;
    .locals 2
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 798
    invoke-virtual {p0, p1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->newInputStream(I)Ljava/io/InputStream;

    move-result-object v0

    .line 799
    .local v0, "in":Ljava/io/InputStream;
    if-eqz v0, :cond_0

    # invokes: Lnet/tsz/afinal/bitmap/core/LruDiskCache;->inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->access$6(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public newInputStream(I)Ljava/io/InputStream;
    .locals 3
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 782
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    monitor-enter v1

    .line 783
    :try_start_0
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->entry:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->currentEditor:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    move-result-object v0

    if-eq v0, p0, :cond_0

    .line 784
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 782
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 786
    :cond_0
    :try_start_1
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->entry:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->readable:Z
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$1(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 787
    monitor-exit v1

    const/4 v0, 0x0

    .line 789
    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Ljava/io/FileInputStream;

    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->entry:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    invoke-virtual {v2, p1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public newOutputStream(I)Ljava/io/OutputStream;
    .locals 4
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 810
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->this$0:Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    monitor-enter v1

    .line 811
    :try_start_0
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->entry:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->currentEditor:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    move-result-object v0

    if-eq v0, p0, :cond_0

    .line 812
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 810
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 814
    :cond_0
    :try_start_1
    new-instance v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor$FaultHidingOutputStream;

    new-instance v2, Ljava/io/FileOutputStream;

    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->entry:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    invoke-virtual {v3, p1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    const/4 v3, 0x0

    invoke-direct {v0, p0, v2, v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor$FaultHidingOutputStream;-><init>(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;Ljava/io/OutputStream;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor$FaultHidingOutputStream;)V

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v0
.end method

.method public set(ILjava/lang/String;)V
    .locals 4
    .param p1, "index"    # I
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 822
    const/4 v0, 0x0

    .line 824
    .local v0, "writer":Ljava/io/Writer;
    :try_start_0
    new-instance v1, Ljava/io/OutputStreamWriter;

    invoke-virtual {p0, p1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v2

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache;->UTF_8:Ljava/nio/charset/Charset;
    invoke-static {}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->access$7()Ljava/nio/charset/Charset;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 825
    .end local v0    # "writer":Ljava/io/Writer;
    .local v1, "writer":Ljava/io/Writer;
    :try_start_1
    invoke-virtual {v1, p2}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 827
    invoke-static {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 829
    return-void

    .line 826
    .end local v1    # "writer":Ljava/io/Writer;
    .restart local v0    # "writer":Ljava/io/Writer;
    :catchall_0
    move-exception v2

    .line 827
    :goto_0
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 828
    throw v2

    .line 826
    .end local v0    # "writer":Ljava/io/Writer;
    .restart local v1    # "writer":Ljava/io/Writer;
    :catchall_1
    move-exception v2

    move-object v0, v1

    .end local v1    # "writer":Ljava/io/Writer;
    .restart local v0    # "writer":Ljava/io/Writer;
    goto :goto_0
.end method
