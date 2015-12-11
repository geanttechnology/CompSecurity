.class Lcom/squareup/tape/QueueFile$1;
.super Ljava/lang/Object;
.source "QueueFile.java"

# interfaces
.implements Lcom/squareup/tape/QueueFile$ElementReader;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/squareup/tape/QueueFile;->toString()Ljava/lang/String;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field first:Z

.field final synthetic this$0:Lcom/squareup/tape/QueueFile;

.field final synthetic val$builder:Ljava/lang/StringBuilder;


# direct methods
.method constructor <init>(Lcom/squareup/tape/QueueFile;Ljava/lang/StringBuilder;)V
    .locals 1
    .param p1, "this$0"    # Lcom/squareup/tape/QueueFile;

    .prologue
    .line 538
    iput-object p1, p0, Lcom/squareup/tape/QueueFile$1;->this$0:Lcom/squareup/tape/QueueFile;

    iput-object p2, p0, Lcom/squareup/tape/QueueFile$1;->val$builder:Ljava/lang/StringBuilder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 539
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/squareup/tape/QueueFile$1;->first:Z

    return-void
.end method


# virtual methods
.method public read(Ljava/io/InputStream;I)V
    .locals 2
    .param p1, "in"    # Ljava/io/InputStream;
    .param p2, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 542
    iget-boolean v0, p0, Lcom/squareup/tape/QueueFile$1;->first:Z

    if-eqz v0, :cond_0

    .line 543
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/squareup/tape/QueueFile$1;->first:Z

    .line 547
    :goto_0
    iget-object v0, p0, Lcom/squareup/tape/QueueFile$1;->val$builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 548
    return-void

    .line 545
    :cond_0
    iget-object v0, p0, Lcom/squareup/tape/QueueFile$1;->val$builder:Ljava/lang/StringBuilder;

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method
