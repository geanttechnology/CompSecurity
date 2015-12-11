.class Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadTask;
.super Landroid/os/AsyncTask;
.source "MManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/a9/creditcardreaderlibrary/metrics/MManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MetricUploadTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Object;",
        "Ljava/lang/Void;",
        "Lorg/apache/http/HttpResponse;",
        ">;"
    }
.end annotation


# instance fields
.field private m_metricUploadListener:Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 233
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 235
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadTask;->m_metricUploadListener:Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;

    return-void
.end method

.method synthetic constructor <init>(Lcom/a9/creditcardreaderlibrary/metrics/MManager$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/a9/creditcardreaderlibrary/metrics/MManager$1;

    .prologue
    .line 233
    invoke-direct {p0}, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 233
    invoke-virtual {p0, p1}, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadTask;->doInBackground([Ljava/lang/Object;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Object;)Lorg/apache/http/HttpResponse;
    .locals 11
    .param p1, "params"    # [Ljava/lang/Object;

    .prologue
    .line 242
    const/4 v8, 0x0

    :try_start_0
    aget-object v4, p1, v8

    check-cast v4, Lorg/json/JSONObject;

    .line 243
    .local v4, "jsonObject":Lorg/json/JSONObject;
    const/4 v8, 0x1

    aget-object v8, p1, v8

    check-cast v8, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;

    iput-object v8, p0, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadTask;->m_metricUploadListener:Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;

    .line 245
    new-instance v1, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v1}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 246
    .local v1, "httpParameters":Lorg/apache/http/params/HttpParams;
    const/16 v7, 0xbb8

    .line 247
    .local v7, "timeoutConnection":I
    invoke-static {v1, v7}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 249
    new-instance v5, Ljava/util/ArrayList;

    const/4 v8, 0x1

    invoke-direct {v5, v8}, Ljava/util/ArrayList;-><init>(I)V

    .line 250
    .local v5, "nameValuePairs":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v8, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v9, "DATA"

    invoke-virtual {v4}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v8, v9, v10}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v5, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 252
    new-instance v3, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v3, v1}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/params/HttpParams;)V

    .line 254
    .local v3, "httpclient":Lorg/apache/http/client/HttpClient;
    new-instance v2, Lorg/apache/http/client/methods/HttpPost;

    const-string/jumbo v8, "https://eventlog-visualsearch.amazon.com/vsmetrics"

    invoke-direct {v2, v8}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 255
    .local v2, "httpPost":Lorg/apache/http/client/methods/HttpPost;
    new-instance v8, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    invoke-direct {v8, v5}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;)V

    invoke-virtual {v2, v8}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 257
    invoke-interface {v3, v2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 263
    .end local v1    # "httpParameters":Lorg/apache/http/params/HttpParams;
    .end local v2    # "httpPost":Lorg/apache/http/client/methods/HttpPost;
    .end local v3    # "httpclient":Lorg/apache/http/client/HttpClient;
    .end local v4    # "jsonObject":Lorg/json/JSONObject;
    .end local v5    # "nameValuePairs":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    .end local v7    # "timeoutConnection":I
    :goto_0
    return-object v6

    .line 260
    :catch_0
    move-exception v0

    .line 261
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 263
    const/4 v6, 0x0

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 233
    check-cast p1, Lorg/apache/http/HttpResponse;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadTask;->onPostExecute(Lorg/apache/http/HttpResponse;)V

    return-void
.end method

.method protected onPostExecute(Lorg/apache/http/HttpResponse;)V
    .locals 1
    .param p1, "result"    # Lorg/apache/http/HttpResponse;

    .prologue
    .line 269
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadTask;->m_metricUploadListener:Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;

    # invokes: Lcom/a9/creditcardreaderlibrary/metrics/MManager;->onHttpResponseReceived(Lorg/apache/http/HttpResponse;Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;)V
    invoke-static {p1, v0}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->access$100(Lorg/apache/http/HttpResponse;Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;)V

    .line 271
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 272
    return-void
.end method
