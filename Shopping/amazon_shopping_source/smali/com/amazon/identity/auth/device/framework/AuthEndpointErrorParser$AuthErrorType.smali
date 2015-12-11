.class public final enum Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
.super Ljava/lang/Enum;
.source "AuthEndpointErrorParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AuthErrorType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum AuthenticationChallenged:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum CredentialError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum DeviceAlreadyRegistered:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum DuplicateDeviceName:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum Forbidden:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum GenericError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum InvalidDirectedId:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum InvalidToken:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum InvalidValue:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum MethodNotAllowed:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum MissingValue:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum NetworkFailure:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum NotImplemented:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum ParseError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum ProtocolError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum ServerError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

.field public static final enum ServiceUnavailable:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;


# instance fields
.field private final mCode:Ljava/lang/String;

.field private final mError:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field private final mRetry:Z


# direct methods
.method static constructor <clinit>()V
    .locals 13

    .prologue
    const/4 v12, 0x4

    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v2, 0x0

    .line 15
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v1, "MissingValue"

    const-string/jumbo v3, "MissingValue"

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v4, v2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->MissingValue:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 16
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "InvalidValue"

    const-string/jumbo v6, "InvalidValue"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v5, v9

    move v7, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->InvalidValue:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 17
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "InvalidToken"

    const-string/jumbo v6, "InvalidToken"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v5, v10

    move v7, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->InvalidToken:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 18
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "ProtocolError"

    const-string/jumbo v6, "ProtocolError"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v5, v11

    move v7, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ProtocolError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 19
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "CredentialError"

    const-string/jumbo v6, "CredentialError"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->CUSTOMER_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v5, v12

    move v7, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->CredentialError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 20
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "Forbidden"

    const/4 v5, 0x5

    const-string/jumbo v6, "Forbidden"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v7, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->Forbidden:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 21
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "MethodNotAllowed"

    const/4 v5, 0x6

    const-string/jumbo v6, "MethodNotAllowed"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v7, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->MethodNotAllowed:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 22
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "ServerError"

    const/4 v5, 0x7

    const-string/jumbo v6, "ServerError"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v7, v9

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ServerError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 23
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "ServiceUnavailable"

    const/16 v5, 0x8

    const-string/jumbo v6, "ServiceUnavailable"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v7, v9

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ServiceUnavailable:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 24
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "NotImplemented"

    const/16 v5, 0x9

    const-string/jumbo v6, "NotImplemented"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v7, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->NotImplemented:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 25
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "InvalidDirectedId"

    const/16 v5, 0xa

    const-string/jumbo v6, "InvalidDirectedId"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v7, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->InvalidDirectedId:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 26
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "DeviceAlreadyRegistered"

    const/16 v5, 0xb

    const-string/jumbo v6, "DeviceAlreadyRegistered"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DEVICE_ALREADY_REGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v7, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->DeviceAlreadyRegistered:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 27
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "DuplicateDeviceName"

    const/16 v5, 0xc

    const-string/jumbo v6, "DuplicateDeviceName"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DUPLICATE_DEVICE_NAME:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v7, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->DuplicateDeviceName:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 28
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v1, "GenericError"

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->GenericError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 29
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "AuthenticationChallenged"

    const/16 v5, 0xe

    const-string/jumbo v6, "AuthenticationChallenged"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_CHALLENGED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v7, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->AuthenticationChallenged:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 30
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "ParseError"

    const/16 v5, 0xf

    const-string/jumbo v6, "ParseError"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v7, v9

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ParseError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 31
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v4, "NetworkFailure"

    const/16 v5, 0x10

    const-string/jumbo v6, "NetworkFailure"

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move v7, v9

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    sput-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->NetworkFailure:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    .line 13
    const/16 v0, 0x11

    new-array v0, v0, [Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    sget-object v1, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->MissingValue:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->InvalidValue:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v1, v0, v9

    sget-object v1, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->InvalidToken:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v1, v0, v10

    sget-object v1, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ProtocolError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v1, v0, v11

    sget-object v1, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->CredentialError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v1, v0, v12

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->Forbidden:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->MethodNotAllowed:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ServerError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ServiceUnavailable:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->NotImplemented:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->InvalidDirectedId:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->DeviceAlreadyRegistered:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->DuplicateDeviceName:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->GenericError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->AuthenticationChallenged:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ParseError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->NetworkFailure:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->$VALUES:[Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 40
    const/16 v2, 0xd

    const-string/jumbo v3, "GenericError"

    const/4 v4, 0x0

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;-><init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    .line 41
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;ZLcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V
    .locals 0
    .param p3, "code"    # Ljava/lang/String;
    .param p4, "retry"    # Z
    .param p5, "error"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z",
            "Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;",
            ")V"
        }
    .end annotation

    .prologue
    .line 44
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 45
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->mCode:Ljava/lang/String;

    .line 46
    iput-boolean p4, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->mRetry:Z

    .line 47
    iput-object p5, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->mError:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 48
    return-void
.end method

.method public static getAuthErrorTypeFromCode(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    .locals 5
    .param p0, "code"    # Ljava/lang/String;

    .prologue
    .line 67
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->values()[Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 69
    .local v3, "value":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->getCode()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 75
    .end local v3    # "value":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    :goto_1
    return-object v3

    .line 67
    .restart local v3    # "value":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 75
    .end local v3    # "value":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    :cond_1
    sget-object v3, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->GenericError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->$VALUES:[Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    return-object v0
.end method


# virtual methods
.method public getCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->mCode:Ljava/lang/String;

    return-object v0
.end method

.method public getRegistrationError()Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->mError:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    return-object v0
.end method

.method public getRetry()Z
    .locals 1

    .prologue
    .line 57
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->mRetry:Z

    return v0
.end method
