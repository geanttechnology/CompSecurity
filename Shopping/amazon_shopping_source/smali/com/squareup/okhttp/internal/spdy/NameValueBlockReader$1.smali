.class Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader$1;
.super Ljava/lang/Object;
.source "NameValueBlockReader.java"

# interfaces
.implements Lcom/squareup/okhttp/internal/okio/Source;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;-><init>(Lcom/squareup/okhttp/internal/okio/BufferedSource;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;

.field final synthetic val$source:Lcom/squareup/okhttp/internal/okio/BufferedSource;


# direct methods
.method constructor <init>(Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;Lcom/squareup/okhttp/internal/okio/BufferedSource;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader$1;->this$0:Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;

    iput-object p2, p0, Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader$1;->val$source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 50
    iget-object v0, p0, Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader$1;->val$source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    invoke-interface {v0}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->close()V

    .line 51
    return-void
.end method

.method public deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Source;
    .locals 1
    .param p1, "deadline"    # Lcom/squareup/okhttp/internal/okio/Deadline;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader$1;->val$source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    invoke-interface {v0, p1}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Source;

    .line 55
    return-object p0
.end method

.method public read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J
    .locals 7
    .param p1, "sink"    # Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .param p2, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v2, -0x1

    .line 42
    iget-object v4, p0, Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader$1;->this$0:Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;

    # getter for: Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;->compressedLimit:I
    invoke-static {v4}, Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;->access$000(Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;)I

    move-result v4

    if-nez v4, :cond_0

    move-wide v0, v2

    .line 46
    :goto_0
    return-wide v0

    .line 43
    :cond_0
    iget-object v4, p0, Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader$1;->val$source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    iget-object v5, p0, Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader$1;->this$0:Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;

    # getter for: Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;->compressedLimit:I
    invoke-static {v5}, Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;->access$000(Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;)I

    move-result v5

    int-to-long v5, v5

    invoke-static {p2, p3, v5, v6}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v5

    invoke-interface {v4, p1, v5, v6}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J

    move-result-wide v0

    .line 44
    .local v0, "read":J
    cmp-long v4, v0, v2

    if-nez v4, :cond_1

    move-wide v0, v2

    goto :goto_0

    .line 45
    :cond_1
    iget-object v2, p0, Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader$1;->this$0:Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;

    # -= operator for: Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;->compressedLimit:I
    invoke-static {v2, v0, v1}, Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;->access$022(Lcom/squareup/okhttp/internal/spdy/NameValueBlockReader;J)I

    goto :goto_0
.end method
