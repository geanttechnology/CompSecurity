.class Lcom/squareup/tape/FileObjectQueue$1;
.super Ljava/lang/Object;
.source "FileObjectQueue.java"

# interfaces
.implements Lcom/squareup/tape/QueueFile$ElementReader;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/squareup/tape/FileObjectQueue;->setListener(Lcom/squareup/tape/ObjectQueue$Listener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/squareup/tape/FileObjectQueue;

.field final synthetic val$listener:Lcom/squareup/tape/ObjectQueue$Listener;


# direct methods
.method constructor <init>(Lcom/squareup/tape/FileObjectQueue;Lcom/squareup/tape/ObjectQueue$Listener;)V
    .locals 0
    .param p1, "this$0"    # Lcom/squareup/tape/FileObjectQueue;

    .prologue
    .line 75
    .local p0, "this":Lcom/squareup/tape/FileObjectQueue$1;, "Lcom/squareup/tape/FileObjectQueue.1;"
    iput-object p1, p0, Lcom/squareup/tape/FileObjectQueue$1;->this$0:Lcom/squareup/tape/FileObjectQueue;

    iput-object p2, p0, Lcom/squareup/tape/FileObjectQueue$1;->val$listener:Lcom/squareup/tape/ObjectQueue$Listener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public read(Ljava/io/InputStream;I)V
    .locals 4
    .param p1, "in"    # Ljava/io/InputStream;
    .param p2, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 78
    .local p0, "this":Lcom/squareup/tape/FileObjectQueue$1;, "Lcom/squareup/tape/FileObjectQueue.1;"
    new-array v0, p2, [B

    .line 79
    .local v0, "data":[B
    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1, p2}, Ljava/io/InputStream;->read([BII)I

    .line 81
    iget-object v1, p0, Lcom/squareup/tape/FileObjectQueue$1;->val$listener:Lcom/squareup/tape/ObjectQueue$Listener;

    iget-object v2, p0, Lcom/squareup/tape/FileObjectQueue$1;->this$0:Lcom/squareup/tape/FileObjectQueue;

    iget-object v3, p0, Lcom/squareup/tape/FileObjectQueue$1;->this$0:Lcom/squareup/tape/FileObjectQueue;

    # getter for: Lcom/squareup/tape/FileObjectQueue;->converter:Lcom/squareup/tape/FileObjectQueue$Converter;
    invoke-static {v3}, Lcom/squareup/tape/FileObjectQueue;->access$000(Lcom/squareup/tape/FileObjectQueue;)Lcom/squareup/tape/FileObjectQueue$Converter;

    move-result-object v3

    invoke-interface {v3, v0}, Lcom/squareup/tape/FileObjectQueue$Converter;->from([B)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/squareup/tape/ObjectQueue$Listener;->onAdd(Lcom/squareup/tape/ObjectQueue;Ljava/lang/Object;)V

    .line 82
    return-void
.end method
