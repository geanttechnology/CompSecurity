.class Lcom/conviva/utils/Utils$HTTPTask$HttpResponseHandler;
.super Ljava/lang/Object;

# interfaces
.implements Lorg/apache/http/client/ResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/conviva/utils/Utils$HTTPTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HttpResponseHandler"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lorg/apache/http/client/ResponseHandler",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/conviva/utils/Utils$HTTPTask;


# direct methods
.method private constructor <init>(Lcom/conviva/utils/Utils$HTTPTask;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/utils/Utils$HTTPTask$HttpResponseHandler;->this$1:Lcom/conviva/utils/Utils$HTTPTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/conviva/utils/Utils$HTTPTask;Lcom/conviva/utils/Utils$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/conviva/utils/Utils$HTTPTask$HttpResponseHandler;-><init>(Lcom/conviva/utils/Utils$HTTPTask;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic handleResponse(Lorg/apache/http/HttpResponse;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/apache/http/client/ClientProtocolException;,
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/conviva/utils/Utils$HTTPTask$HttpResponseHandler;->handleResponse(Lorg/apache/http/HttpResponse;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public handleResponse(Lorg/apache/http/HttpResponse;)Ljava/lang/Void;
    .locals 6

    const/4 v5, 0x0

    :try_start_0
    invoke-interface {p1}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v0

    const/16 v1, 0xc8

    if-ne v0, v1, :cond_1

    invoke-interface {p1}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v0

    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    const/16 v2, 0x400

    new-array v2, v2, [B

    :goto_0
    invoke-virtual {v0, v2}, Ljava/io/InputStream;->read([B)I

    move-result v3

    const/4 v4, -0x1

    if-eq v3, v4, :cond_0

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v4, v3}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/conviva/utils/Utils$HTTPTask$HttpResponseHandler;->this$1:Lcom/conviva/utils/Utils$HTTPTask;

    # invokes: Lcom/conviva/utils/Utils$HTTPTask;->doneHandler(Ljava/lang/Exception;[B)V
    invoke-static {v1, v0, v5}, Lcom/conviva/utils/Utils$HTTPTask;->access$200(Lcom/conviva/utils/Utils$HTTPTask;Ljava/lang/Exception;[B)V

    :goto_1
    return-object v5

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask$HttpResponseHandler;->this$1:Lcom/conviva/utils/Utils$HTTPTask;

    const/4 v2, 0x0

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    # invokes: Lcom/conviva/utils/Utils$HTTPTask;->doneHandler(Ljava/lang/Exception;[B)V
    invoke-static {v0, v2, v1}, Lcom/conviva/utils/Utils$HTTPTask;->access$200(Lcom/conviva/utils/Utils$HTTPTask;Ljava/lang/Exception;[B)V

    goto :goto_1

    :cond_1
    iget-object v1, p0, Lcom/conviva/utils/Utils$HTTPTask$HttpResponseHandler;->this$1:Lcom/conviva/utils/Utils$HTTPTask;

    new-instance v2, Ljava/lang/Exception;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Status code in HTTP response is not OK: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    const/4 v0, 0x0

    # invokes: Lcom/conviva/utils/Utils$HTTPTask;->doneHandler(Ljava/lang/Exception;[B)V
    invoke-static {v1, v2, v0}, Lcom/conviva/utils/Utils$HTTPTask;->access$200(Lcom/conviva/utils/Utils$HTTPTask;Ljava/lang/Exception;[B)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method
