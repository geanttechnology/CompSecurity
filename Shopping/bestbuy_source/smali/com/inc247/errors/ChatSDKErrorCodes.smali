.class public final enum Lcom/inc247/errors/ChatSDKErrorCodes;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/inc247/errors/ChatSDKErrorCodes;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum ChatSDKChatNotStartedError:Lcom/inc247/errors/ChatSDKErrorCodes;

.field public static final enum ChatSDKEndError:Lcom/inc247/errors/ChatSDKErrorCodes;

.field public static final enum ChatSDKInvalidParameterError:Lcom/inc247/errors/ChatSDKErrorCodes;

.field public static final enum ChatSDKNetworkError:Lcom/inc247/errors/ChatSDKErrorCodes;

.field public static final enum ChatSDKStartError:Lcom/inc247/errors/ChatSDKErrorCodes;

.field public static final enum ChatSDKUnknownError:Lcom/inc247/errors/ChatSDKErrorCodes;

.field private static final synthetic ENUM$VALUES:[Lcom/inc247/errors/ChatSDKErrorCodes;


# instance fields
.field private final id:I

.field private final msg:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 12
    new-instance v0, Lcom/inc247/errors/ChatSDKErrorCodes;

    const-string v1, "ChatSDKStartError"

    const-string v2, "An error occurred during chat launch."

    invoke-direct {v0, v1, v5, v5, v2}, Lcom/inc247/errors/ChatSDKErrorCodes;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKStartError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 13
    new-instance v0, Lcom/inc247/errors/ChatSDKErrorCodes;

    const-string v1, "ChatSDKNetworkError"

    const-string v2, "Network error occurred in agent availability check."

    invoke-direct {v0, v1, v6, v6, v2}, Lcom/inc247/errors/ChatSDKErrorCodes;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKNetworkError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 14
    new-instance v0, Lcom/inc247/errors/ChatSDKErrorCodes;

    const-string v1, "ChatSDKEndError"

    const-string v2, "An error occurred during ending chat session"

    invoke-direct {v0, v1, v7, v7, v2}, Lcom/inc247/errors/ChatSDKErrorCodes;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKEndError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 15
    new-instance v0, Lcom/inc247/errors/ChatSDKErrorCodes;

    const-string v1, "ChatSDKUnknownError"

    const-string v2, "An unknown error occurred in the SDK.This will end the active chat session"

    invoke-direct {v0, v1, v8, v8, v2}, Lcom/inc247/errors/ChatSDKErrorCodes;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKUnknownError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 16
    new-instance v0, Lcom/inc247/errors/ChatSDKErrorCodes;

    const-string v1, "ChatSDKChatNotStartedError"

    const-string v2, "An error occurred as startChat has not been called prior to calling other methods on an active chat session"

    invoke-direct {v0, v1, v9, v9, v2}, Lcom/inc247/errors/ChatSDKErrorCodes;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKChatNotStartedError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 17
    new-instance v0, Lcom/inc247/errors/ChatSDKErrorCodes;

    const-string v1, "ChatSDKInvalidParameterError"

    const/4 v2, 0x5

    const/4 v3, 0x5

    const-string v4, "An error occurred, as the parameters inside configuration xml are not valid."

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/inc247/errors/ChatSDKErrorCodes;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKInvalidParameterError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 10
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/inc247/errors/ChatSDKErrorCodes;

    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKStartError:Lcom/inc247/errors/ChatSDKErrorCodes;

    aput-object v1, v0, v5

    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKNetworkError:Lcom/inc247/errors/ChatSDKErrorCodes;

    aput-object v1, v0, v6

    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKEndError:Lcom/inc247/errors/ChatSDKErrorCodes;

    aput-object v1, v0, v7

    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKUnknownError:Lcom/inc247/errors/ChatSDKErrorCodes;

    aput-object v1, v0, v8

    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKChatNotStartedError:Lcom/inc247/errors/ChatSDKErrorCodes;

    aput-object v1, v0, v9

    const/4 v1, 0x5

    sget-object v2, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKInvalidParameterError:Lcom/inc247/errors/ChatSDKErrorCodes;

    aput-object v2, v0, v1

    sput-object v0, Lcom/inc247/errors/ChatSDKErrorCodes;->ENUM$VALUES:[Lcom/inc247/errors/ChatSDKErrorCodes;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IILjava/lang/String;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 28
    iput p3, p0, Lcom/inc247/errors/ChatSDKErrorCodes;->id:I

    .line 29
    iput-object p4, p0, Lcom/inc247/errors/ChatSDKErrorCodes;->msg:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/inc247/errors/ChatSDKErrorCodes;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/inc247/errors/ChatSDKErrorCodes;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/inc247/errors/ChatSDKErrorCodes;

    return-object v0
.end method

.method public static values()[Lcom/inc247/errors/ChatSDKErrorCodes;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/inc247/errors/ChatSDKErrorCodes;->ENUM$VALUES:[Lcom/inc247/errors/ChatSDKErrorCodes;

    array-length v1, v0

    new-array v2, v1, [Lcom/inc247/errors/ChatSDKErrorCodes;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method


# virtual methods
.method public getId()I
    .locals 1

    .prologue
    .line 37
    iget v0, p0, Lcom/inc247/errors/ChatSDKErrorCodes;->id:I

    return v0
.end method

.method public getMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/inc247/errors/ChatSDKErrorCodes;->msg:Ljava/lang/String;

    return-object v0
.end method
