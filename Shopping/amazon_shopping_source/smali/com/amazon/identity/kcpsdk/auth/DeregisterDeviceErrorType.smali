.class public final enum Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;
.super Ljava/lang/Enum;
.source "DeregisterDeviceErrorType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

.field public static final enum DeregisterDeviceErrorTypeFailed:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 6
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    const-string/jumbo v1, "DeregisterDeviceErrorTypeFailed"

    invoke-direct {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;->DeregisterDeviceErrorTypeFailed:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    .line 4
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    const/4 v1, 0x0

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;->DeregisterDeviceErrorTypeFailed:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 4
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 4
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;
    .locals 1

    .prologue
    .line 4
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    return-object v0
.end method
