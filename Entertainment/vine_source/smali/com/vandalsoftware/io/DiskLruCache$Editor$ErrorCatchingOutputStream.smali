.class Lcom/vandalsoftware/io/DiskLruCache$Editor$ErrorCatchingOutputStream;
.super Ljava/io/FilterOutputStream;
.source "DiskLruCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/vandalsoftware/io/DiskLruCache$Editor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ErrorCatchingOutputStream"
.end annotation


# instance fields
.field final synthetic this$1:Lcom/vandalsoftware/io/DiskLruCache$Editor;


# direct methods
.method private constructor <init>(Lcom/vandalsoftware/io/DiskLruCache$Editor;Ljava/io/OutputStream;)V
    .locals 0
    .param p2, "out"    # Ljava/io/OutputStream;

    .prologue
    .line 694
    iput-object p1, p0, Lcom/vandalsoftware/io/DiskLruCache$Editor$ErrorCatchingOutputStream;->this$1:Lcom/vandalsoftware/io/DiskLruCache$Editor;

    .line 695
    invoke-direct {p0, p2}, Ljava/io/FilterOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 696
    return-void
.end method

.method synthetic constructor <init>(Lcom/vandalsoftware/io/DiskLruCache$Editor;Ljava/io/OutputStream;Lcom/vandalsoftware/io/DiskLruCache$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/vandalsoftware/io/DiskLruCache$Editor;
    .param p2, "x1"    # Ljava/io/OutputStream;
    .param p3, "x2"    # Lcom/vandalsoftware/io/DiskLruCache$1;

    .prologue
    .line 693
    invoke-direct {p0, p1, p2}, Lcom/vandalsoftware/io/DiskLruCache$Editor$ErrorCatchingOutputStream;-><init>(Lcom/vandalsoftware/io/DiskLruCache$Editor;Ljava/io/OutputStream;)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 721
    :try_start_0
    iget-object v1, p0, Lcom/vandalsoftware/io/DiskLruCache$Editor$ErrorCatchingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 726
    return-void

    .line 722
    :catch_0
    move-exception v0

    .line 723
    .local v0, "e":Ljava/io/IOException;
    iget-object v1, p0, Lcom/vandalsoftware/io/DiskLruCache$Editor$ErrorCatchingOutputStream;->this$1:Lcom/vandalsoftware/io/DiskLruCache$Editor;

    const/4 v2, 0x1

    # setter for: Lcom/vandalsoftware/io/DiskLruCache$Editor;->hasErrors:Z
    invoke-static {v1, v2}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->access$1402(Lcom/vandalsoftware/io/DiskLruCache$Editor;Z)Z

    .line 724
    throw v0
.end method

.method public flush()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 731
    :try_start_0
    iget-object v1, p0, Lcom/vandalsoftware/io/DiskLruCache$Editor$ErrorCatchingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1}, Ljava/io/OutputStream;->flush()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 736
    return-void

    .line 732
    :catch_0
    move-exception v0

    .line 733
    .local v0, "e":Ljava/io/IOException;
    iget-object v1, p0, Lcom/vandalsoftware/io/DiskLruCache$Editor$ErrorCatchingOutputStream;->this$1:Lcom/vandalsoftware/io/DiskLruCache$Editor;

    const/4 v2, 0x1

    # setter for: Lcom/vandalsoftware/io/DiskLruCache$Editor;->hasErrors:Z
    invoke-static {v1, v2}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->access$1402(Lcom/vandalsoftware/io/DiskLruCache$Editor;Z)Z

    .line 734
    throw v0
.end method

.method public write(I)V
    .locals 3
    .param p1, "oneByte"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 701
    :try_start_0
    iget-object v1, p0, Lcom/vandalsoftware/io/DiskLruCache$Editor$ErrorCatchingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1, p1}, Ljava/io/OutputStream;->write(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 706
    return-void

    .line 702
    :catch_0
    move-exception v0

    .line 703
    .local v0, "e":Ljava/io/IOException;
    iget-object v1, p0, Lcom/vandalsoftware/io/DiskLruCache$Editor$ErrorCatchingOutputStream;->this$1:Lcom/vandalsoftware/io/DiskLruCache$Editor;

    const/4 v2, 0x1

    # setter for: Lcom/vandalsoftware/io/DiskLruCache$Editor;->hasErrors:Z
    invoke-static {v1, v2}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->access$1402(Lcom/vandalsoftware/io/DiskLruCache$Editor;Z)Z

    .line 704
    throw v0
.end method

.method public write([BII)V
    .locals 3
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 711
    :try_start_0
    iget-object v1, p0, Lcom/vandalsoftware/io/DiskLruCache$Editor$ErrorCatchingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1, p1, p2, p3}, Ljava/io/OutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 716
    return-void

    .line 712
    :catch_0
    move-exception v0

    .line 713
    .local v0, "e":Ljava/io/IOException;
    iget-object v1, p0, Lcom/vandalsoftware/io/DiskLruCache$Editor$ErrorCatchingOutputStream;->this$1:Lcom/vandalsoftware/io/DiskLruCache$Editor;

    const/4 v2, 0x1

    # setter for: Lcom/vandalsoftware/io/DiskLruCache$Editor;->hasErrors:Z
    invoke-static {v1, v2}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->access$1402(Lcom/vandalsoftware/io/DiskLruCache$Editor;Z)Z

    .line 714
    throw v0
.end method
