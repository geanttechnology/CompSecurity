.class public Lcom/adobe/ave/VideoEngineException;
.super Ljava/lang/Exception;
.source "VideoEngineException.java"


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private errorCode:Lcom/adobe/ave/MediaErrorCode;

.field private errorMessage:Ljava/lang/String;


# direct methods
.method constructor <init>(I)V
    .locals 5
    .param p1, "err"    # I

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 34
    sget-object v1, Lcom/adobe/ave/MediaErrorCode;->GENERIC_ERROR:Lcom/adobe/ave/MediaErrorCode;

    iput-object v1, p0, Lcom/adobe/ave/VideoEngineException;->errorCode:Lcom/adobe/ave/MediaErrorCode;

    .line 35
    invoke-static {}, Lcom/adobe/ave/MediaErrorCode;->values()[Lcom/adobe/ave/MediaErrorCode;

    move-result-object v2

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v0, v2, v1

    .line 37
    .local v0, "m":Lcom/adobe/ave/MediaErrorCode;
    invoke-virtual {v0}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v4

    if-ne v4, p1, :cond_1

    .line 39
    iput-object v0, p0, Lcom/adobe/ave/VideoEngineException;->errorCode:Lcom/adobe/ave/MediaErrorCode;

    .line 43
    .end local v0    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_0
    return-void

    .line 35
    .restart local v0    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method constructor <init>(ILjava/lang/String;)V
    .locals 5
    .param p1, "err"    # I
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-direct {p0, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 49
    sget-object v1, Lcom/adobe/ave/MediaErrorCode;->GENERIC_ERROR:Lcom/adobe/ave/MediaErrorCode;

    iput-object v1, p0, Lcom/adobe/ave/VideoEngineException;->errorCode:Lcom/adobe/ave/MediaErrorCode;

    .line 50
    invoke-static {}, Lcom/adobe/ave/MediaErrorCode;->values()[Lcom/adobe/ave/MediaErrorCode;

    move-result-object v2

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v0, v2, v1

    .line 52
    .local v0, "m":Lcom/adobe/ave/MediaErrorCode;
    invoke-virtual {v0}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v4

    if-ne v4, p1, :cond_1

    .line 54
    iput-object v0, p0, Lcom/adobe/ave/VideoEngineException;->errorCode:Lcom/adobe/ave/MediaErrorCode;

    .line 59
    .end local v0    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_0
    iput-object p2, p0, Lcom/adobe/ave/VideoEngineException;->errorMessage:Ljava/lang/String;

    .line 60
    return-void

    .line 50
    .restart local v0    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method constructor <init>(Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Lcom/adobe/ave/MediaErrorCode;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-direct {p0, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 65
    iput-object p1, p0, Lcom/adobe/ave/VideoEngineException;->errorCode:Lcom/adobe/ave/MediaErrorCode;

    .line 66
    iput-object p2, p0, Lcom/adobe/ave/VideoEngineException;->errorMessage:Ljava/lang/String;

    .line 67
    return-void
.end method


# virtual methods
.method public getDetailMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/adobe/ave/VideoEngineException;->errorMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getErrorCode()Lcom/adobe/ave/MediaErrorCode;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/adobe/ave/VideoEngineException;->errorCode:Lcom/adobe/ave/MediaErrorCode;

    return-object v0
.end method
