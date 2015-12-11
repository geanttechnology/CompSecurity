.class public final enum Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
.super Ljava/lang/Enum;
.source "FIRSErrorType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

.field public static final enum FIRSErrorTypeCustomerNotFound:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

.field public static final enum FIRSErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

.field public static final enum FIRSErrorTypeDuplicateAccountName:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

.field public static final enum FIRSErrorTypeInternalError:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

.field public static final enum FIRSErrorTypeInvalidAccountFound:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

.field public static final enum FIRSErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;


# instance fields
.field private final mErrorCode:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 6
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    const-string/jumbo v1, "FIRSErrorTypeCustomerNotFound"

    const-string/jumbo v2, "customer_not_found"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeCustomerNotFound:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .line 7
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    const-string/jumbo v1, "FIRSErrorTypeDeviceAlreadyRegistered"

    const-string/jumbo v2, "device_already_registered"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .line 8
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    const-string/jumbo v1, "FIRSErrorTypeDuplicateAccountName"

    const-string/jumbo v2, "duplicate_account_name"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeDuplicateAccountName:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .line 9
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    const-string/jumbo v1, "FIRSErrorTypeInternalError"

    const-string/jumbo v2, "message"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeInternalError:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .line 10
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    const-string/jumbo v1, "FIRSErrorTypeUnrecognized"

    const-string/jumbo v2, "unrecognized"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .line 15
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    const-string/jumbo v1, "FIRSErrorTypeInvalidAccountFound"

    const/4 v2, 0x5

    const-string/jumbo v3, "invalid_account_found"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeInvalidAccountFound:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .line 4
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeCustomerNotFound:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeDuplicateAccountName:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeInternalError:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->FIRSErrorTypeInvalidAccountFound:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->$VALUES:[Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "errorCode"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 21
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->mErrorCode:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 4
    const-class v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    .locals 1

    .prologue
    .line 4
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->$VALUES:[Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    return-object v0
.end method


# virtual methods
.method public getErrorCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->mErrorCode:Ljava/lang/String;

    return-object v0
.end method
