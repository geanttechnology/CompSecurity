.class public final enum Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
.super Ljava/lang/Enum;
.source "RegisterDeviceErrorType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeChallengeResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeCustomerNotFound:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeDeviceNotRegisteredPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeDuplicateDeviceName:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeInternal:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeInvalidDevice:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeInvalidDirectedId:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeInvalidTokenPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeInvalidValue:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeMethodNotAllowed:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeMissingValue:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeNotImplemented:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeProtocolError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeServerError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeServerUnavailable:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeUnauthorizedPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeUnrecognizedFirs:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeUnrecognizedKindle:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

.field public static final enum RegisterDeviceErrorTypeUnrecognizedPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;


# instance fields
.field private mErrorString:Ljava/lang/String;


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
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeCustomerNotFound"

    const-string/jumbo v2, "Customer Not Found. The credential is invalid e.g. The input email/password does not match our record"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeCustomerNotFound:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 8
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeDeviceAlreadyRegistered"

    const-string/jumbo v2, "Device Already Registered"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 9
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeDeviceNotRegisteredPanda"

    const-string/jumbo v2, "Primary account not registered to device"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDeviceNotRegisteredPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 10
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeDuplicateDeviceName"

    const-string/jumbo v2, "The device name is duplicate to an existing one"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDuplicateDeviceName:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 12
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeUnrecognized"

    const-string/jumbo v2, "Unrecognized"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 13
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeChallengeResponse"

    const/4 v2, 0x5

    const-string/jumbo v3, "Challenge Response Received"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeChallengeResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 14
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeMissingValue"

    const/4 v2, 0x6

    const-string/jumbo v3, "One or more required values are missing"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeMissingValue:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 15
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeInvalidValue"

    const/4 v2, 0x7

    const-string/jumbo v3, "One or more required values are invalid"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidValue:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 16
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeInvalidTokenPanda"

    const/16 v2, 0x8

    const-string/jumbo v3, "The token used for registration in Panda is invalid"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidTokenPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 17
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeProtocolError"

    const/16 v2, 0x9

    const-string/jumbo v3, "The Protocol is not supported. SSL required"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeProtocolError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 18
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeMethodNotAllowed"

    const/16 v2, 0xa

    const-string/jumbo v3, "The HTTP method is not valid. For example, using POST instead of GET"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeMethodNotAllowed:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 19
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeServerError"

    const/16 v2, 0xb

    const-string/jumbo v3, "The server has encountered a runtime error, try again later"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeServerError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 20
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeNotImplemented"

    const/16 v2, 0xc

    const-string/jumbo v3, "The feature is not implemented"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeNotImplemented:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 21
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeInvalidDirectedId"

    const/16 v2, 0xd

    const-string/jumbo v3, "The directedId is invalid. e.g. The customer directedId is invalid. The device directedId is invalid"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidDirectedId:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 23
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeInvalidDevice"

    const/16 v2, 0xe

    const-string/jumbo v3, "The device information is invalid. The device serial number is too long"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidDevice:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 24
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeUnauthorizedPanda"

    const/16 v2, 0xf

    const-string/jumbo v3, "Unauthorized error from Panda"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnauthorizedPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 26
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeUnrecognizedFirs"

    const/16 v2, 0x10

    const-string/jumbo v3, "Unrecognized Firs"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognizedFirs:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 28
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeUnrecognizedKindle"

    const/16 v2, 0x11

    const-string/jumbo v3, "Unrecognized Kindle"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognizedKindle:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 30
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeUnrecognizedPanda"

    const/16 v2, 0x12

    const-string/jumbo v3, "Unrecognized Panda"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognizedPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 31
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeServerUnavailable"

    const/16 v2, 0x13

    const-string/jumbo v3, "The service temporarily overloaded or unavailable, try again later"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeServerUnavailable:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 32
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypeInternal"

    const/16 v2, 0x14

    const-string/jumbo v3, "Internal Server error, try again later"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInternal:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 35
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    const-string/jumbo v1, "RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary"

    const/16 v2, 0x15

    const-string/jumbo v3, "Failed to register a secondary account because the primary account associated with it was deregistered or not valid any more on server side. The device is deregistered."

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 4
    const/16 v0, 0x16

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeCustomerNotFound:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDeviceNotRegisteredPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDuplicateDeviceName:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeChallengeResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeMissingValue:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidValue:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidTokenPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeProtocolError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeMethodNotAllowed:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeServerError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeNotImplemented:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidDirectedId:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInvalidDevice:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnauthorizedPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognizedFirs:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognizedKindle:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognizedPanda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeServerUnavailable:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInternal:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "errorString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 41
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 42
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->mErrorString:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 4
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    .locals 1

    .prologue
    .line 4
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    return-object v0
.end method


# virtual methods
.method public getErrorString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->mErrorString:Ljava/lang/String;

    return-object v0
.end method
