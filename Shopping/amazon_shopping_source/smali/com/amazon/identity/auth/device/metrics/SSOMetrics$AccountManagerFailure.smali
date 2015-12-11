.class public final enum Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;
.super Ljava/lang/Enum;
.source "SSOMetrics.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/metrics/SSOMetrics;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AccountManagerFailure"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

.field public static final enum BAD_ARGUMENTS:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

.field public static final enum BAD_REQUEST:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

.field public static final enum CANCELED:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

.field public static final enum INVALID_RESPONSE:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

.field public static final enum NETWORK_ERROR:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

.field public static final enum REMOTE_EXCEPTION:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

.field public static final enum UNRECOGNIZED:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

.field public static final enum UNSUPPORTED_OPERATION:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;


# instance fields
.field private final mErrorCode:I

.field private final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .prologue
    const/4 v9, 0x6

    const/4 v8, 0x5

    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x1

    .line 49
    new-instance v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    const-string/jumbo v1, "BAD_ARGUMENTS"

    const/4 v2, 0x0

    const/4 v3, 0x7

    const-string/jumbo v4, "BadArguments"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->BAD_ARGUMENTS:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    .line 50
    new-instance v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    const-string/jumbo v1, "BAD_REQUEST"

    const/16 v2, 0x8

    const-string/jumbo v3, "BadRequest"

    invoke-direct {v0, v1, v5, v2, v3}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->BAD_REQUEST:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    .line 51
    new-instance v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    const-string/jumbo v1, "CANCELED"

    const/4 v2, 0x2

    const-string/jumbo v3, "Cancelled"

    invoke-direct {v0, v1, v2, v7, v3}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->CANCELED:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    .line 52
    new-instance v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    const-string/jumbo v1, "INVALID_RESPONSE"

    const-string/jumbo v2, "InvalidResponse"

    invoke-direct {v0, v1, v6, v8, v2}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->INVALID_RESPONSE:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    .line 53
    new-instance v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    const-string/jumbo v1, "NETWORK_ERROR"

    const-string/jumbo v2, "NetworkError"

    invoke-direct {v0, v1, v7, v6, v2}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->NETWORK_ERROR:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    .line 54
    new-instance v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    const-string/jumbo v1, "REMOTE_EXCEPTION"

    const-string/jumbo v2, "RemoteException"

    invoke-direct {v0, v1, v8, v5, v2}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->REMOTE_EXCEPTION:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    .line 55
    new-instance v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    const-string/jumbo v1, "UNSUPPORTED_OPERATION"

    const-string/jumbo v2, "UnsupportedOperation"

    invoke-direct {v0, v1, v9, v9, v2}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->UNSUPPORTED_OPERATION:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    .line 56
    new-instance v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    const-string/jumbo v1, "UNRECOGNIZED"

    const/4 v2, 0x7

    const/16 v3, 0x9

    const-string/jumbo v4, "UnrecognizedExternalError"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    .line 47
    const/16 v0, 0x8

    new-array v0, v0, [Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    const/4 v1, 0x0

    sget-object v2, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->BAD_ARGUMENTS:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    aput-object v2, v0, v1

    sget-object v1, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->BAD_REQUEST:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    aput-object v1, v0, v5

    const/4 v1, 0x2

    sget-object v2, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->CANCELED:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    aput-object v2, v0, v1

    sget-object v1, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->INVALID_RESPONSE:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->NETWORK_ERROR:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->REMOTE_EXCEPTION:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    aput-object v1, v0, v8

    sget-object v1, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->UNSUPPORTED_OPERATION:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    aput-object v1, v0, v9

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->$VALUES:[Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IILjava/lang/String;)V
    .locals 0
    .param p3, "accountManagerErrorCode"    # I
    .param p4, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 62
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 63
    iput p3, p0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->mErrorCode:I

    .line 64
    iput-object p4, p0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->mName:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public static getFromAccountManagerErrorCode(I)Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;
    .locals 5
    .param p0, "errorCode"    # I

    .prologue
    .line 79
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->values()[Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v1, v0, v2

    .line 81
    .local v1, "error":Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->getAccountManagerErrorCode()I

    move-result v4

    if-ne v4, p0, :cond_0

    .line 87
    .end local v1    # "error":Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;
    :goto_1
    return-object v1

    .line 79
    .restart local v1    # "error":Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 87
    .end local v1    # "error":Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;
    :cond_1
    sget-object v1, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 47
    const-class v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;
    .locals 1

    .prologue
    .line 47
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->$VALUES:[Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    return-object v0
.end method


# virtual methods
.method public getAccountManagerErrorCode()I
    .locals 1

    .prologue
    .line 74
    iget v0, p0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->mErrorCode:I

    return v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->mName:Ljava/lang/String;

    return-object v0
.end method
