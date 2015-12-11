.class public Lcom/flow/android/engine/models/FlowStateEngineIO;
.super Ljava/lang/Object;
.source "FlowStateEngineIO.java"


# instance fields
.field private application:Ljava/lang/String;

.field private clientDeviceID:Ljava/lang/String;

.field private clientSessionID:Ljava/lang/String;

.field private clientVersion:Ljava/lang/String;

.field private errorReportingServer:Ljava/lang/String;

.field private imgServer:Ljava/lang/String;

.field private isDataCollectionDisabled:Z

.field private printToScreen:Z

.field private secret:Ljava/lang/String;

.field private textServer:Ljava/lang/String;

.field private useLogFile:Z

.field private username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getApplication()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->application:Ljava/lang/String;

    return-object v0
.end method

.method public getClientDeviceID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->clientDeviceID:Ljava/lang/String;

    return-object v0
.end method

.method public getClientSessionID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->clientSessionID:Ljava/lang/String;

    return-object v0
.end method

.method public getClientVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->clientVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getErrorReportingServer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->errorReportingServer:Ljava/lang/String;

    return-object v0
.end method

.method public getImgServer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->imgServer:Ljava/lang/String;

    return-object v0
.end method

.method public getSecret()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->secret:Ljava/lang/String;

    return-object v0
.end method

.method public getTextServer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->textServer:Ljava/lang/String;

    return-object v0
.end method

.method public getUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->username:Ljava/lang/String;

    return-object v0
.end method

.method public isDataCollectionDisabled()Z
    .locals 1

    .prologue
    .line 106
    iget-boolean v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->isDataCollectionDisabled:Z

    return v0
.end method

.method public isPrintToScreen()Z
    .locals 1

    .prologue
    .line 90
    iget-boolean v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->printToScreen:Z

    return v0
.end method

.method public isUseLogFile()Z
    .locals 1

    .prologue
    .line 98
    iget-boolean v0, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->useLogFile:Z

    return v0
.end method

.method public setApplication(Ljava/lang/String;)V
    .locals 0
    .param p1, "application"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->application:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setClientDeviceID(Ljava/lang/String;)V
    .locals 0
    .param p1, "clientDeviceID"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->clientDeviceID:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setClientSessionID(Ljava/lang/String;)V
    .locals 0
    .param p1, "clientSessionID"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->clientSessionID:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setClientVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "clientVersion"    # Ljava/lang/String;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->clientVersion:Ljava/lang/String;

    .line 47
    return-void
.end method

.method public setDataCollectionDisabled(Z)V
    .locals 0
    .param p1, "isDataCollectionDisabled"    # Z

    .prologue
    .line 110
    iput-boolean p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->isDataCollectionDisabled:Z

    .line 111
    return-void
.end method

.method public setErrorReportingServer(Ljava/lang/String;)V
    .locals 0
    .param p1, "errorReportingServer"    # Ljava/lang/String;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->errorReportingServer:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setImgServer(Ljava/lang/String;)V
    .locals 0
    .param p1, "imgServer"    # Ljava/lang/String;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->imgServer:Ljava/lang/String;

    .line 71
    return-void
.end method

.method public setPrintToScreen(Z)V
    .locals 0
    .param p1, "printToScreen"    # Z

    .prologue
    .line 94
    iput-boolean p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->printToScreen:Z

    .line 95
    return-void
.end method

.method public setSecret(Ljava/lang/String;)V
    .locals 0
    .param p1, "secret"    # Ljava/lang/String;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->secret:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setTextServer(Ljava/lang/String;)V
    .locals 0
    .param p1, "textServer"    # Ljava/lang/String;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->textServer:Ljava/lang/String;

    .line 79
    return-void
.end method

.method public setUseLogFile(Z)V
    .locals 0
    .param p1, "useLogFile"    # Z

    .prologue
    .line 102
    iput-boolean p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->useLogFile:Z

    .line 103
    return-void
.end method

.method public setUsername(Ljava/lang/String;)V
    .locals 0
    .param p1, "username"    # Ljava/lang/String;

    .prologue
    .line 22
    iput-object p1, p0, Lcom/flow/android/engine/models/FlowStateEngineIO;->username:Ljava/lang/String;

    .line 23
    return-void
.end method
