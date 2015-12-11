.class Lnet/tsz/afinal/FinalHttp$2;
.super Ljava/lang/Object;
.source "FinalHttp.java"

# interfaces
.implements Lorg/apache/http/HttpRequestInterceptor;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/tsz/afinal/FinalHttp;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/tsz/afinal/FinalHttp;


# direct methods
.method constructor <init>(Lnet/tsz/afinal/FinalHttp;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lnet/tsz/afinal/FinalHttp$2;->this$0:Lnet/tsz/afinal/FinalHttp;

    .line 140
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public process(Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)V
    .locals 5
    .param p1, "request"    # Lorg/apache/http/HttpRequest;
    .param p2, "context"    # Lorg/apache/http/protocol/HttpContext;

    .prologue
    .line 146
    const-string v1, "AIO"

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcom/aio/downloader/utils/publicTools;->downkey:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/utils/MD5;->getMD5(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lorg/apache/http/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    const-string v1, "User-Agent"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {}, Lnet/tsz/afinal/FinalHttp;->set_a_random_user_agent()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "AIOCLEANER"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lorg/apache/http/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 151
    const-string v1, "vfvf"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "id====="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "///////md5id====="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    invoke-static {v3}, Lcom/aio/downloader/utils/MD5;->getMD5(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "//////webkey===="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/aio/downloader/utils/publicTools;->downkey:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\u4e24\u4e2a====="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v4, Lcom/aio/downloader/utils/publicTools;->downkey:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/aio/downloader/utils/MD5;->getMD5(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    const-string v1, "Accept-Encoding"

    invoke-interface {p1, v1}, Lorg/apache/http/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 153
    const-string v1, "Accept-Encoding"

    const-string v2, "gzip"

    invoke-interface {p1, v1, v2}, Lorg/apache/http/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    :cond_0
    iget-object v1, p0, Lnet/tsz/afinal/FinalHttp$2;->this$0:Lnet/tsz/afinal/FinalHttp;

    # getter for: Lnet/tsz/afinal/FinalHttp;->clientHeaderMap:Ljava/util/Map;
    invoke-static {v1}, Lnet/tsz/afinal/FinalHttp;->access$0(Lnet/tsz/afinal/FinalHttp;)Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-nez v1, :cond_1

    .line 159
    return-void

    .line 155
    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 156
    .local v0, "header":Ljava/lang/String;
    iget-object v1, p0, Lnet/tsz/afinal/FinalHttp$2;->this$0:Lnet/tsz/afinal/FinalHttp;

    # getter for: Lnet/tsz/afinal/FinalHttp;->clientHeaderMap:Ljava/util/Map;
    invoke-static {v1}, Lnet/tsz/afinal/FinalHttp;->access$0(Lnet/tsz/afinal/FinalHttp;)Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {p1, v0, v1}, Lorg/apache/http/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
