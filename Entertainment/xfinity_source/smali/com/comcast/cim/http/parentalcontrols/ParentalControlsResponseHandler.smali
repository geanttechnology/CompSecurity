.class public Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;
.super Lcom/comcast/cim/cmasl/xip/XipResponseHandler;
.source "ParentalControlsResponseHandler.java"


# instance fields
.field private final mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field private pcSettings:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "mapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/xip/XipResponseHandler;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 21
    return-void
.end method


# virtual methods
.method public getParentalControlsSettings()Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;->pcSettings:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    return-object v0
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 3
    .param p1, "inputStream"    # Ljava/io/InputStream;

    .prologue
    .line 26
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v2, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    invoke-virtual {v1, p1, v2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    iput-object v1, p0, Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;->pcSettings:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 30
    return-void

    .line 27
    :catch_0
    move-exception v0

    .line 28
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v1, v0}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v1
.end method
