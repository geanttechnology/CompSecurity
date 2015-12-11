.class public Lcom/pinterest/android/pdk/PDKRequest;
.super Lcom/android/volley/toolbox/JsonObjectRequest;
.source "PDKRequest.java"


# instance fields
.field private _callback:Lcom/pinterest/android/pdk/PDKCallback;

.field private _headers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(ILjava/lang/String;Lorg/json/JSONObject;Lcom/android/volley/Response$Listener;Lcom/android/volley/Response$ErrorListener;)V
    .locals 1
    .param p1, "method"    # I
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "jsonRequest"    # Lorg/json/JSONObject;
    .param p5, "errorListener"    # Lcom/android/volley/Response$ErrorListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "Lcom/android/volley/Response$Listener",
            "<",
            "Lorg/json/JSONObject;",
            ">;",
            "Lcom/android/volley/Response$ErrorListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 23
    .local p4, "listener":Lcom/android/volley/Response$Listener;, "Lcom/android/volley/Response$Listener<Lorg/json/JSONObject;>;"
    invoke-direct/range {p0 .. p5}, Lcom/android/volley/toolbox/JsonObjectRequest;-><init>(ILjava/lang/String;Lorg/json/JSONObject;Lcom/android/volley/Response$Listener;Lcom/android/volley/Response$ErrorListener;)V

    .line 18
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/pinterest/android/pdk/PDKRequest;->_headers:Ljava/util/Map;

    .line 24
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Lorg/json/JSONObject;Lcom/pinterest/android/pdk/PDKCallback;Ljava/util/Map;)V
    .locals 6
    .param p1, "method"    # I
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "object"    # Lorg/json/JSONObject;
    .param p4, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "Lcom/pinterest/android/pdk/PDKCallback;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 27
    .local p5, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    move-object v0, p0

    move v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/android/volley/toolbox/JsonObjectRequest;-><init>(ILjava/lang/String;Lorg/json/JSONObject;Lcom/android/volley/Response$Listener;Lcom/android/volley/Response$ErrorListener;)V

    .line 18
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/pinterest/android/pdk/PDKRequest;->_headers:Ljava/util/Map;

    .line 28
    iput-object p4, p0, Lcom/pinterest/android/pdk/PDKRequest;->_callback:Lcom/pinterest/android/pdk/PDKCallback;

    .line 29
    iput-object p5, p0, Lcom/pinterest/android/pdk/PDKRequest;->_headers:Ljava/util/Map;

    .line 30
    return-void
.end method


# virtual methods
.method public getHeaders()Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/android/volley/AuthFailureError;
        }
    .end annotation

    .prologue
    .line 35
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKRequest;->_headers:Ljava/util/Map;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKRequest;->_headers:Ljava/util/Map;

    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 36
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/pinterest/android/pdk/PDKRequest;->_headers:Ljava/util/Map;

    .line 38
    :cond_1
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKRequest;->_headers:Ljava/util/Map;

    return-object v0
.end method

.method protected parseNetworkResponse(Lcom/android/volley/NetworkResponse;)Lcom/android/volley/Response;
    .locals 2
    .param p1, "response"    # Lcom/android/volley/NetworkResponse;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/volley/NetworkResponse;",
            ")",
            "Lcom/android/volley/Response",
            "<",
            "Lorg/json/JSONObject;",
            ">;"
        }
    .end annotation

    .prologue
    .line 44
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKRequest;->_callback:Lcom/pinterest/android/pdk/PDKCallback;

    iget-object v1, p1, Lcom/android/volley/NetworkResponse;->headers:Ljava/util/Map;

    invoke-virtual {v0, v1}, Lcom/pinterest/android/pdk/PDKCallback;->setResponseHeaders(Ljava/util/Map;)V

    .line 45
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKRequest;->_callback:Lcom/pinterest/android/pdk/PDKCallback;

    iget v1, p1, Lcom/android/volley/NetworkResponse;->statusCode:I

    invoke-virtual {v0, v1}, Lcom/pinterest/android/pdk/PDKCallback;->setStatusCode(I)V

    .line 46
    invoke-super {p0, p1}, Lcom/android/volley/toolbox/JsonObjectRequest;->parseNetworkResponse(Lcom/android/volley/NetworkResponse;)Lcom/android/volley/Response;

    move-result-object v0

    return-object v0
.end method
