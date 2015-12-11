.class public Lcom/comcast/cim/android/authentication/AuthResponseHandler;
.super Lcom/comcast/cim/cmasl/xip/XipResponseHandler;
.source "AuthResponseHandler.java"


# instance fields
.field private authKeys:Lcom/comcast/cim/model/user/AuthKeys;

.field private objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 1
    .param p1, "objectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/xip/XipResponseHandler;-><init>()V

    .line 12
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/android/authentication/AuthResponseHandler;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    .line 17
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthResponseHandler;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 18
    return-void
.end method


# virtual methods
.method public getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthResponseHandler;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;

    return-object v0
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 3
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 27
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthResponseHandler;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v2, Lcom/comcast/cim/model/user/AuthKeys;

    invoke-virtual {v1, p1, v2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/model/user/AuthKeys;

    iput-object v1, p0, Lcom/comcast/cim/android/authentication/AuthResponseHandler;->authKeys:Lcom/comcast/cim/model/user/AuthKeys;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 31
    return-void

    .line 28
    :catch_0
    move-exception v0

    .line 29
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v1, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
