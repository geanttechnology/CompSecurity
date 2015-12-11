.class final Lcom/poshmark/http/api/PMApiError$1;
.super Ljava/util/HashMap;
.source "PMApiError.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/http/api/PMApiError;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/Class;",
        "Lcom/poshmark/data_model/models/PMErrorType;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 117
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 119
    const-class v0, Lorg/apache/http/NoHttpResponseException;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_FAILURE:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/http/api/PMApiError$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 120
    const-class v0, Ljava/net/UnknownHostException;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_FAILURE:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/http/api/PMApiError$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 121
    const-class v0, Lorg/apache/http/conn/HttpHostConnectException;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_FAILURE:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/http/api/PMApiError$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 122
    const-class v0, Ljava/net/SocketException;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_FAILURE:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/http/api/PMApiError$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 123
    const-class v0, Ljavax/net/ssl/SSLException;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_FAILURE:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/http/api/PMApiError$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 125
    const-class v0, Ljava/io/InterruptedIOException;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_TIMEOUT:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/http/api/PMApiError$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 126
    const-class v0, Ljava/net/SocketTimeoutException;

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->CONNECTION_TIMEOUT:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/http/api/PMApiError$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    return-void
.end method
