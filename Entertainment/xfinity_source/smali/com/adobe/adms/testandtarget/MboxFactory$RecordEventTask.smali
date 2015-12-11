.class Lcom/adobe/adms/testandtarget/MboxFactory$RecordEventTask;
.super Ljava/lang/Object;
.source "MboxFactory.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/adms/testandtarget/MboxFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RecordEventTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/adobe/adms/testandtarget/MboxFactory;Ljava/lang/String;)V
    .locals 0
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 222
    iput-object p1, p0, Lcom/adobe/adms/testandtarget/MboxFactory$RecordEventTask;->this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

    .line 223
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 224
    iput-object p2, p0, Lcom/adobe/adms/testandtarget/MboxFactory$RecordEventTask;->url:Ljava/lang/String;

    .line 225
    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 229
    new-instance v2, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v2}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    .line 230
    .local v2, "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    new-instance v1, Lorg/apache/http/client/methods/HttpGet;

    iget-object v3, p0, Lcom/adobe/adms/testandtarget/MboxFactory$RecordEventTask;->url:Ljava/lang/String;

    invoke-direct {v1, v3}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 231
    .local v1, "getRequest":Lorg/apache/http/client/methods/HttpGet;
    const-string v3, "User-Agent"

    const-string v4, "Apache-HttpClient (Test&Target Android SDK)"

    invoke-virtual {v1, v3, v4}, Lorg/apache/http/client/methods/HttpGet;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    iget-object v3, p0, Lcom/adobe/adms/testandtarget/MboxFactory$RecordEventTask;->this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

    # getter for: Lcom/adobe/adms/testandtarget/MboxFactory;->cookies:Ljava/lang/String;
    invoke-static {v3}, Lcom/adobe/adms/testandtarget/MboxFactory;->access$000(Lcom/adobe/adms/testandtarget/MboxFactory;)Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 233
    const-string v3, "Cookie"

    iget-object v4, p0, Lcom/adobe/adms/testandtarget/MboxFactory$RecordEventTask;->this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

    # getter for: Lcom/adobe/adms/testandtarget/MboxFactory;->cookies:Ljava/lang/String;
    invoke-static {v4}, Lcom/adobe/adms/testandtarget/MboxFactory;->access$000(Lcom/adobe/adms/testandtarget/MboxFactory;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lorg/apache/http/client/methods/HttpGet;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 236
    :cond_0
    :try_start_0
    invoke-virtual {v2, v1}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    .line 237
    iget-object v3, p0, Lcom/adobe/adms/testandtarget/MboxFactory$RecordEventTask;->this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

    invoke-virtual {v2}, Lorg/apache/http/impl/client/DefaultHttpClient;->getCookieStore()Lorg/apache/http/client/CookieStore;

    move-result-object v4

    # invokes: Lcom/adobe/adms/testandtarget/MboxFactory;->saveCookies(Lorg/apache/http/client/CookieStore;)V
    invoke-static {v3, v4}, Lcom/adobe/adms/testandtarget/MboxFactory;->access$100(Lcom/adobe/adms/testandtarget/MboxFactory;Lorg/apache/http/client/CookieStore;)V
    :try_end_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 245
    :goto_0
    return-void

    .line 239
    :catch_0
    move-exception v0

    .line 240
    .local v0, "e":Lorg/apache/http/client/ClientProtocolException;
    const-string v3, "MboxFactory"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "EXCEPTION: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lorg/apache/http/client/ClientProtocolException;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 242
    .end local v0    # "e":Lorg/apache/http/client/ClientProtocolException;
    :catch_1
    move-exception v0

    .line 243
    .local v0, "e":Ljava/io/IOException;
    const-string v3, "MboxFactory"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "EXCEPTION: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
