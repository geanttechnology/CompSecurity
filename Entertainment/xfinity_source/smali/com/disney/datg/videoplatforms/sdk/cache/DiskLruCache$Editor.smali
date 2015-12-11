.class public final Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;
.super Ljava/lang/Object;
.source "DiskLruCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "Editor"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;
    }
.end annotation


# instance fields
.field private final entry:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;

.field private hasErrors:Z

.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;


# direct methods
.method private constructor <init>(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;)V
    .locals 0
    .param p2, "entry"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;

    .prologue
    .line 772
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->this$0:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 773
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->entry:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;

    .line 774
    return-void
.end method

.method synthetic constructor <init>(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;
    .param p2, "x1"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;
    .param p3, "x2"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$1;

    .prologue
    .line 768
    invoke-direct {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;-><init>(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;)V

    return-void
.end method

.method static synthetic access$1400(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;)Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;

    .prologue
    .line 768
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->entry:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;

    return-object v0
.end method

.method static synthetic access$2002(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;
    .param p1, "x1"    # Z

    .prologue
    .line 768
    iput-boolean p1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->hasErrors:Z

    return p1
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
    .line 848
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->this$0:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    const/4 v1, 0x0

    # invokes: Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->completeEdit(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Z)V
    invoke-static {v0, p0, v1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->access$1900(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Z)V

    .line 849
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
    .line 835
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->hasErrors:Z

    if-eqz v0, :cond_0

    .line 836
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->this$0:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    const/4 v1, 0x0

    # invokes: Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->completeEdit(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Z)V
    invoke-static {v0, p0, v1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->access$1900(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Z)V

    .line 837
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->this$0:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->entry:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;->key:Ljava/lang/String;
    invoke-static {v1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;->access$1100(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->remove(Ljava/lang/String;)Z

    .line 841
    :goto_0
    return-void

    .line 839
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->this$0:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    const/4 v1, 0x1

    # invokes: Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->completeEdit(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Z)V
    invoke-static {v0, p0, v1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;->access$1900(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Z)V

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
    .line 809
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->this$0:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache;

    monitor-enter v1

    .line 810
    :try_start_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->entry:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;->currentEditor:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;->access$700(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;)Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;

    move-result-object v0

    if-eq v0, p0, :cond_0

    .line 811
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 814
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 813
    :cond_0
    :try_start_1
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;

    new-instance v2, Ljava/io/FileOutputStream;

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->entry:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;

    invoke-virtual {v3, p1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    const/4 v3, 0x0

    invoke-direct {v0, p0, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;-><init>(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Ljava/io/OutputStream;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$1;)V

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v0
.end method
