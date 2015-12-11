.class public Lcom/pinterest/android/pdk/PDKException;
.super Ljava/lang/Exception;
.source "PDKException.java"


# static fields
.field static final serialVersionUID:J = 0x1L


# instance fields
.field protected _baseUrl:Ljava/lang/String;

.field private _detailMessage:Ljava/lang/String;

.field protected _method:Ljava/lang/String;

.field private _stausCode:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 11
    const/4 v0, -0x1

    iput v0, p0, Lcom/pinterest/android/pdk/PDKException;->_stausCode:I

    .line 12
    const-string v0, ""

    iput-object v0, p0, Lcom/pinterest/android/pdk/PDKException;->_detailMessage:Ljava/lang/String;

    .line 18
    return-void
.end method

.method public constructor <init>(Lcom/android/volley/VolleyError;)V
    .locals 4
    .param p1, "error"    # Lcom/android/volley/VolleyError;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 11
    const/4 v3, -0x1

    iput v3, p0, Lcom/pinterest/android/pdk/PDKException;->_stausCode:I

    .line 12
    const-string v3, ""

    iput-object v3, p0, Lcom/pinterest/android/pdk/PDKException;->_detailMessage:Ljava/lang/String;

    .line 31
    const-string v2, ""

    .line 32
    .local v2, "message":Ljava/lang/String;
    if-eqz p1, :cond_0

    iget-object v3, p1, Lcom/android/volley/VolleyError;->networkResponse:Lcom/android/volley/NetworkResponse;

    if-eqz v3, :cond_0

    iget-object v3, p1, Lcom/android/volley/VolleyError;->networkResponse:Lcom/android/volley/NetworkResponse;

    iget-object v3, v3, Lcom/android/volley/NetworkResponse;->data:[B

    if-eqz v3, :cond_0

    .line 33
    new-instance v2, Ljava/lang/String;

    .end local v2    # "message":Ljava/lang/String;
    iget-object v3, p1, Lcom/android/volley/VolleyError;->networkResponse:Lcom/android/volley/NetworkResponse;

    iget-object v3, v3, Lcom/android/volley/NetworkResponse;->data:[B

    invoke-direct {v2, v3}, Ljava/lang/String;-><init>([B)V

    .line 34
    .restart local v2    # "message":Ljava/lang/String;
    iput-object v2, p0, Lcom/pinterest/android/pdk/PDKException;->_detailMessage:Ljava/lang/String;

    .line 37
    :cond_0
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_2

    const-string v3, "{"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 39
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-static {v2}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 41
    .local v1, "errObj":Lorg/json/JSONObject;
    const-string v3, "status"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 42
    const-string v3, "status"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v3

    iput v3, p0, Lcom/pinterest/android/pdk/PDKException;->_stausCode:I

    .line 44
    :cond_1
    const-string v3, "messsage"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 45
    const-string v3, "message"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/pinterest/android/pdk/PDKException;->_detailMessage:Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 51
    .end local v1    # "errObj":Lorg/json/JSONObject;
    :cond_2
    :goto_0
    return-void

    .line 47
    :catch_0
    move-exception v0

    .line 48
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 11
    const/4 v0, -0x1

    iput v0, p0, Lcom/pinterest/android/pdk/PDKException;->_stausCode:I

    .line 12
    const-string v0, ""

    iput-object v0, p0, Lcom/pinterest/android/pdk/PDKException;->_detailMessage:Ljava/lang/String;

    .line 22
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKException;->_detailMessage:Ljava/lang/String;

    .line 23
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 11
    const/4 v0, -0x1

    iput v0, p0, Lcom/pinterest/android/pdk/PDKException;->_stausCode:I

    .line 12
    const-string v0, ""

    iput-object v0, p0, Lcom/pinterest/android/pdk/PDKException;->_detailMessage:Ljava/lang/String;

    .line 27
    return-void
.end method


# virtual methods
.method public getDetailMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKException;->_detailMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getStausCode()I
    .locals 1

    .prologue
    .line 63
    iget v0, p0, Lcom/pinterest/android/pdk/PDKException;->_stausCode:I

    return v0
.end method

.method public setDetailMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKException;->_detailMessage:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public setStausCode(I)V
    .locals 0
    .param p1, "stausCode"    # I

    .prologue
    .line 54
    iput p1, p0, Lcom/pinterest/android/pdk/PDKException;->_stausCode:I

    .line 55
    return-void
.end method
