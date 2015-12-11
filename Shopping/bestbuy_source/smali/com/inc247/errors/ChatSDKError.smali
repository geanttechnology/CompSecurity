.class public Lcom/inc247/errors/ChatSDKError;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private errorCode:I

.field private errorMsg:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    invoke-virtual {p1}, Lcom/inc247/errors/ChatSDKErrorCodes;->getMsg()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/inc247/errors/ChatSDKError;->errorMsg:Ljava/lang/String;

    .line 21
    invoke-virtual {p1}, Lcom/inc247/errors/ChatSDKErrorCodes;->getId()I

    move-result v0

    iput v0, p0, Lcom/inc247/errors/ChatSDKError;->errorCode:I

    .line 22
    return-void
.end method


# virtual methods
.method public getErrorCode()I
    .locals 1

    .prologue
    .line 29
    iget v0, p0, Lcom/inc247/errors/ChatSDKError;->errorCode:I

    return v0
.end method

.method public getErrorMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/inc247/errors/ChatSDKError;->errorMsg:Ljava/lang/String;

    return-object v0
.end method
