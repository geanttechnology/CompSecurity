.class public final enum Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
.super Ljava/lang/Enum;
.source "KindleWebserviceErrorType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

.field public static final enum KindleWebserviceErrorTypeCredentialsRequired:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

.field public static final enum KindleWebserviceErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

.field public static final enum KindleWebserviceErrorTypeDuplicateDeviceName:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

.field public static final enum KindleWebserviceErrorTypeFileNotFound:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

.field public static final enum KindleWebserviceErrorTypeInsufficientFunds:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

.field public static final enum KindleWebserviceErrorTypeInternalError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

.field public static final enum KindleWebserviceErrorTypeInvalidAsin:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

.field public static final enum KindleWebserviceErrorTypeInvalidOrder:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

.field public static final enum KindleWebserviceErrorTypeUnbuyError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

.field public static final enum KindleWebserviceErrorTypeUnknownError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

.field public static final enum KindleWebserviceErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 6
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    const-string/jumbo v1, "KindleWebserviceErrorTypeFileNotFound"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeFileNotFound:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 7
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    const-string/jumbo v1, "KindleWebserviceErrorTypeDeviceAlreadyRegistered"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 8
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    const-string/jumbo v1, "KindleWebserviceErrorTypeCredentialsRequired"

    invoke-direct {v0, v1, v5}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeCredentialsRequired:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 9
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    const-string/jumbo v1, "KindleWebserviceErrorTypeInvalidAsin"

    invoke-direct {v0, v1, v6}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInvalidAsin:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 10
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    const-string/jumbo v1, "KindleWebserviceErrorTypeInvalidOrder"

    invoke-direct {v0, v1, v7}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInvalidOrder:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 11
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    const-string/jumbo v1, "KindleWebserviceErrorTypeInsufficientFunds"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInsufficientFunds:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 12
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    const-string/jumbo v1, "KindleWebserviceErrorTypeUnknownError"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeUnknownError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 13
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    const-string/jumbo v1, "KindleWebserviceErrorTypeUnbuyError"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeUnbuyError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 14
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    const-string/jumbo v1, "KindleWebserviceErrorTypeDuplicateDeviceName"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeDuplicateDeviceName:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 15
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    const-string/jumbo v1, "KindleWebserviceErrorTypeInternalError"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInternalError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 16
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    const-string/jumbo v1, "KindleWebserviceErrorTypeUnrecognized"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 4
    const/16 v0, 0xb

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeFileNotFound:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeCredentialsRequired:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInvalidAsin:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInvalidOrder:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInsufficientFunds:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeUnknownError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeUnbuyError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeDuplicateDeviceName:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeInternalError:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->KindleWebserviceErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->$VALUES:[Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 4
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 4
    const-class v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    .locals 1

    .prologue
    .line 4
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->$VALUES:[Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    return-object v0
.end method
