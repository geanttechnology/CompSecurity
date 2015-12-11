.class public final enum Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
.super Ljava/lang/Enum;
.source "MAPAccountManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MAPAccountManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "RegistrationError"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum ACCOUNT_ALREADY_EXISTS:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum AUTHENTICATION_CHALLENGED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum AUTHENTICATION_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum BAD_SECRET:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum CUSTOMER_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum DEREGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum DEVICE_ALREADY_REGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum DUPLICATE_DEVICE_NAME:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum NO_ACCOUNT:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum UI_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public static final enum UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;


# instance fields
.field private final mName:Ljava/lang/String;

.field private final mValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 349
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "ACCOUNT_ALREADY_EXISTS"

    const-string/jumbo v2, "AccountAlreadyExists"

    invoke-direct {v0, v1, v5, v5, v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ACCOUNT_ALREADY_EXISTS:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 353
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "NETWORK_FAILURE"

    const-string/jumbo v2, "NetworkFailure"

    invoke-direct {v0, v1, v6, v6, v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 357
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "AUTHENTICATION_FAILED"

    const-string/jumbo v2, "AuthenticationFailed"

    invoke-direct {v0, v1, v7, v7, v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 361
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "PARSE_ERROR"

    const-string/jumbo v2, "ParseError"

    invoke-direct {v0, v1, v8, v8, v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 365
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "CUSTOMER_NOT_FOUND"

    const-string/jumbo v2, "CustomerNotFound"

    invoke-direct {v0, v1, v9, v9, v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->CUSTOMER_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 369
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "DEVICE_ALREADY_REGISTERED"

    const/4 v2, 0x5

    const/4 v3, 0x5

    const-string/jumbo v4, "DeviceAlreadyRegistered"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DEVICE_ALREADY_REGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 373
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "DUPLICATE_DEVICE_NAME"

    const/4 v2, 0x6

    const/4 v3, 0x6

    const-string/jumbo v4, "DuplicateDeviceName"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DUPLICATE_DEVICE_NAME:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 377
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "DEREGISTER_FAILED"

    const/4 v2, 0x7

    const/4 v3, 0x7

    const-string/jumbo v4, "DeregisterFailed"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DEREGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 381
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "UNRECOGNIZED"

    const/16 v2, 0x8

    const/16 v3, 0x8

    const-string/jumbo v4, "Unrecognized"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 385
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "REGISTER_FAILED"

    const/16 v2, 0x9

    const/16 v3, 0x9

    const-string/jumbo v4, "RegisterFailed"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 389
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "BAD_REQUEST"

    const/16 v2, 0xa

    const/16 v3, 0xa

    const-string/jumbo v4, "BadRequest"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 393
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "ALREADY_DEREGISTERED"

    const/16 v2, 0xb

    const/16 v3, 0xb

    const-string/jumbo v4, "AlreadyDeregistered"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 397
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "BAD_SECRET"

    const/16 v2, 0xc

    const/16 v3, 0xc

    const-string/jumbo v4, "BadSecret"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_SECRET:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 401
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "NO_ACCOUNT"

    const/16 v2, 0xd

    const/16 v3, 0xd

    const-string/jumbo v4, "NoAccount"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NO_ACCOUNT:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 405
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "UI_NOT_FOUND"

    const/16 v2, 0xe

    const/16 v3, 0xe

    const-string/jumbo v4, "UINotFound"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UI_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 409
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED"

    const/16 v2, 0xf

    const/16 v3, 0xf

    const-string/jumbo v4, "DelegateeAccountAlreadyDeregistered"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 428
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "AUTHENTICATION_CHALLENGED"

    const/16 v2, 0x10

    const/16 v3, 0x10

    const-string/jumbo v4, "AuthenticationChallenged"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_CHALLENGED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 344
    const/16 v0, 0x11

    new-array v0, v0, [Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ACCOUNT_ALREADY_EXISTS:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v1, v0, v8

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->CUSTOMER_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v1, v0, v9

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DEVICE_ALREADY_REGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DUPLICATE_DEVICE_NAME:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DEREGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_SECRET:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NO_ACCOUNT:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UI_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_CHALLENGED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->$VALUES:[Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IILjava/lang/String;)V
    .locals 0
    .param p3, "value"    # I
    .param p4, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 434
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 435
    iput p3, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->mValue:I

    .line 436
    iput-object p4, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->mName:Ljava/lang/String;

    .line 437
    return-void
.end method

.method public static fromValue(I)Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .locals 2
    .param p0, "value"    # I

    .prologue
    .line 451
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->fromValueHelper(I)Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move-result-object v0

    .line 453
    .local v0, "error":Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    if-eqz v0, :cond_0

    .line 455
    return-object v0

    .line 459
    :cond_0
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v1}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v1
.end method

.method public static fromValue(ILcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .locals 1
    .param p0, "value"    # I
    .param p1, "defaultValue"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .prologue
    .line 465
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->fromValueHelper(I)Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move-result-object v0

    .line 467
    .local v0, "error":Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    if-eqz v0, :cond_0

    .end local v0    # "error":Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    :goto_0
    return-object v0

    .restart local v0    # "error":Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    :cond_0
    move-object v0, p1

    goto :goto_0
.end method

.method private static fromValueHelper(I)Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .locals 5
    .param p0, "value"    # I

    .prologue
    .line 472
    invoke-static {}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->values()[Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v1, v0, v2

    .line 474
    .local v1, "error":Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v4

    if-ne v4, p0, :cond_0

    .line 480
    .end local v1    # "error":Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    :goto_1
    return-object v1

    .line 472
    .restart local v1    # "error":Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 480
    .end local v1    # "error":Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 344
    const-class v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .locals 1

    .prologue
    .line 344
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->$VALUES:[Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 446
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public value()I
    .locals 1

    .prologue
    .line 441
    iget v0, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->mValue:I

    return v0
.end method
