.class public Lcom/pinterest/android/pdk/PDKCallback;
.super Ljava/lang/Object;
.source "PDKCallback.java"

# interfaces
.implements Lcom/android/volley/Response$Listener;
.implements Lcom/android/volley/Response$ErrorListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/android/volley/Response$Listener",
        "<",
        "Lorg/json/JSONObject;",
        ">;",
        "Lcom/android/volley/Response$ErrorListener;"
    }
.end annotation


# instance fields
.field private _params:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private _path:Ljava/lang/String;

.field private _responseHeaders:Ljava/util/Map;
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

.field private _statusCode:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onErrorResponse(Lcom/android/volley/VolleyError;)V
    .locals 1
    .param p1, "error"    # Lcom/android/volley/VolleyError;

    .prologue
    .line 28
    new-instance v0, Lcom/pinterest/android/pdk/PDKException;

    invoke-direct {v0, p1}, Lcom/pinterest/android/pdk/PDKException;-><init>(Lcom/android/volley/VolleyError;)V

    invoke-virtual {p0, v0}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 29
    return-void
.end method

.method public onFailure(Lcom/pinterest/android/pdk/PDKException;)V
    .locals 0
    .param p1, "exception"    # Lcom/pinterest/android/pdk/PDKException;

    .prologue
    .line 43
    return-void
.end method

.method public bridge synthetic onResponse(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 12
    check-cast p1, Lorg/json/JSONObject;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/pinterest/android/pdk/PDKCallback;->onResponse(Lorg/json/JSONObject;)V

    return-void
.end method

.method public onResponse(Lorg/json/JSONObject;)V
    .locals 1
    .param p1, "response"    # Lorg/json/JSONObject;

    .prologue
    .line 22
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/pinterest/android/pdk/PDKCallback;->onSuccess(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 25
    :goto_0
    return-void

    .line 23
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onSuccess(Lcom/pinterest/android/pdk/PDKResponse;)V
    .locals 0
    .param p1, "response"    # Lcom/pinterest/android/pdk/PDKResponse;

    .prologue
    .line 40
    return-void
.end method

.method public onSuccess(Lorg/json/JSONObject;)V
    .locals 2
    .param p1, "response"    # Lorg/json/JSONObject;

    .prologue
    .line 32
    new-instance v0, Lcom/pinterest/android/pdk/PDKResponse;

    invoke-direct {v0, p1}, Lcom/pinterest/android/pdk/PDKResponse;-><init>(Lorg/json/JSONObject;)V

    .line 33
    .local v0, "apiResponse":Lcom/pinterest/android/pdk/PDKResponse;
    iget v1, p0, Lcom/pinterest/android/pdk/PDKCallback;->_statusCode:I

    invoke-virtual {v0, v1}, Lcom/pinterest/android/pdk/PDKResponse;->setStatusCode(I)V

    .line 34
    iget-object v1, p0, Lcom/pinterest/android/pdk/PDKCallback;->_path:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/pinterest/android/pdk/PDKResponse;->setPath(Ljava/lang/String;)V

    .line 35
    iget-object v1, p0, Lcom/pinterest/android/pdk/PDKCallback;->_params:Ljava/util/HashMap;

    invoke-virtual {v0, v1}, Lcom/pinterest/android/pdk/PDKResponse;->setParams(Ljava/util/HashMap;)V

    .line 36
    invoke-virtual {p0, v0}, Lcom/pinterest/android/pdk/PDKCallback;->onSuccess(Lcom/pinterest/android/pdk/PDKResponse;)V

    .line 37
    return-void
.end method

.method public setParams(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 58
    .local p1, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKCallback;->_params:Ljava/util/HashMap;

    .line 59
    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKCallback;->_path:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setResponseHeaders(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 46
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKCallback;->_responseHeaders:Ljava/util/Map;

    .line 47
    return-void
.end method

.method public setStatusCode(I)V
    .locals 0
    .param p1, "code"    # I

    .prologue
    .line 50
    iput p1, p0, Lcom/pinterest/android/pdk/PDKCallback;->_statusCode:I

    .line 51
    return-void
.end method
