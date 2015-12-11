.class public Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
.super Ljava/lang/Exception;
.source "AndroidSDKException.java"


# instance fields
.field private errorCode:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;


# direct methods
.method public constructor <init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V
    .locals 1
    .param p1, "errorCode"    # Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    .prologue
    .line 14
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getReason()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 15
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->errorCode:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    .line 17
    return-void
.end method

.method public constructor <init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V
    .locals 0
    .param p1, "errorCode"    # Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 20
    invoke-direct {p0, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 21
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->errorCode:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    .line 22
    return-void
.end method

.method public constructor <init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "errorCode"    # Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 30
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getReason()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 31
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->errorCode:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    .line 32
    return-void
.end method


# virtual methods
.method public getErrorCode()Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->errorCode:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    return-object v0
.end method
