.class Lcom/android/debug/hv/ViewServer$UncloseableOuputStream;
.super Ljava/io/OutputStream;
.source "ViewServer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/debug/hv/ViewServer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "UncloseableOuputStream"
.end annotation


# instance fields
.field private final mStream:Ljava/io/OutputStream;


# direct methods
.method constructor <init>(Ljava/io/OutputStream;)V
    .locals 0
    .param p1, "stream"    # Ljava/io/OutputStream;

    .prologue
    .line 460
    invoke-direct {p0}, Ljava/io/OutputStream;-><init>()V

    .line 461
    iput-object p1, p0, Lcom/android/debug/hv/ViewServer$UncloseableOuputStream;->mStream:Ljava/io/OutputStream;

    .line 462
    return-void
.end method


# virtual methods
.method public close()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 466
    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 469
    iget-object v0, p0, Lcom/android/debug/hv/ViewServer$UncloseableOuputStream;->mStream:Ljava/io/OutputStream;

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 473
    iget-object v0, p0, Lcom/android/debug/hv/ViewServer$UncloseableOuputStream;->mStream:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V

    .line 474
    return-void
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 477
    iget-object v0, p0, Lcom/android/debug/hv/ViewServer$UncloseableOuputStream;->mStream:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 481
    iget-object v0, p0, Lcom/android/debug/hv/ViewServer$UncloseableOuputStream;->mStream:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public write(I)V
    .locals 1
    .param p1, "oneByte"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 494
    iget-object v0, p0, Lcom/android/debug/hv/ViewServer$UncloseableOuputStream;->mStream:Ljava/io/OutputStream;

    invoke-virtual {v0, p1}, Ljava/io/OutputStream;->write(I)V

    .line 495
    return-void
.end method

.method public write([B)V
    .locals 1
    .param p1, "buffer"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 490
    iget-object v0, p0, Lcom/android/debug/hv/ViewServer$UncloseableOuputStream;->mStream:Ljava/io/OutputStream;

    invoke-virtual {v0, p1}, Ljava/io/OutputStream;->write([B)V

    .line 491
    return-void
.end method

.method public write([BII)V
    .locals 1
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "count"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 486
    iget-object v0, p0, Lcom/android/debug/hv/ViewServer$UncloseableOuputStream;->mStream:Ljava/io/OutputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/OutputStream;->write([BII)V

    .line 487
    return-void
.end method
