.class Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;
.super Ljava/io/FilterOutputStream;
.source "DiskLruCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FaultHidingOutputStream"
.end annotation


# instance fields
.field final synthetic this$1:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;


# direct methods
.method private constructor <init>(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Ljava/io/OutputStream;)V
    .locals 0
    .param p2, "out"    # Ljava/io/OutputStream;

    .prologue
    .line 852
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;->this$1:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;

    .line 853
    invoke-direct {p0, p2}, Ljava/io/FilterOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 854
    return-void
.end method

.method synthetic constructor <init>(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Ljava/io/OutputStream;Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;
    .param p2, "x1"    # Ljava/io/OutputStream;
    .param p3, "x2"    # Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$1;

    .prologue
    .line 851
    invoke-direct {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;-><init>(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Ljava/io/OutputStream;)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 3

    .prologue
    .line 876
    :try_start_0
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 881
    :goto_0
    return-void

    .line 877
    :catch_0
    move-exception v0

    .line 878
    .local v0, "e":Ljava/io/IOException;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 879
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;->this$1:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;

    const/4 v2, 0x1

    # setter for: Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->hasErrors:Z
    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->access$2002(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Z)Z

    goto :goto_0
.end method

.method public flush()V
    .locals 3

    .prologue
    .line 885
    :try_start_0
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1}, Ljava/io/OutputStream;->flush()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 890
    :goto_0
    return-void

    .line 886
    :catch_0
    move-exception v0

    .line 887
    .local v0, "e":Ljava/io/IOException;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 888
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;->this$1:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;

    const/4 v2, 0x1

    # setter for: Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->hasErrors:Z
    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->access$2002(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Z)Z

    goto :goto_0
.end method

.method public write(I)V
    .locals 3
    .param p1, "oneByte"    # I

    .prologue
    .line 858
    :try_start_0
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1, p1}, Ljava/io/OutputStream;->write(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 863
    :goto_0
    return-void

    .line 859
    :catch_0
    move-exception v0

    .line 860
    .local v0, "e":Ljava/io/IOException;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 861
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;->this$1:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;

    const/4 v2, 0x1

    # setter for: Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->hasErrors:Z
    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->access$2002(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Z)Z

    goto :goto_0
.end method

.method public write([BII)V
    .locals 3
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .prologue
    .line 867
    :try_start_0
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1, p1, p2, p3}, Ljava/io/OutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 872
    :goto_0
    return-void

    .line 868
    :catch_0
    move-exception v0

    .line 869
    .local v0, "e":Ljava/io/IOException;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 870
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor$FaultHidingOutputStream;->this$1:Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;

    const/4 v2, 0x1

    # setter for: Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->hasErrors:Z
    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;->access$2002(Lcom/disney/datg/videoplatforms/sdk/cache/DiskLruCache$Editor;Z)Z

    goto :goto_0
.end method
