.class public final enum Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;
.super Ljava/lang/Enum;
.source "RenameDeviceErrorType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

.field public static final enum RenameDeviceErrorTypeAlreadyUsed:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

.field public static final enum RenameDeviceErrorTypeInvalidInput:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

.field public static final enum RenameDeviceErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 6
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    const-string/jumbo v1, "RenameDeviceErrorTypeInvalidInput"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;->RenameDeviceErrorTypeInvalidInput:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    .line 7
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    const-string/jumbo v1, "RenameDeviceErrorTypeAlreadyUsed"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;->RenameDeviceErrorTypeAlreadyUsed:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    .line 8
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    const-string/jumbo v1, "RenameDeviceErrorTypeUnrecognized"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;->RenameDeviceErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    .line 4
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;->RenameDeviceErrorTypeInvalidInput:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;->RenameDeviceErrorTypeAlreadyUsed:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;->RenameDeviceErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

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

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 4
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;
    .locals 1

    .prologue
    .line 4
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    return-object v0
.end method
