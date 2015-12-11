.class public final enum Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;
.super Ljava/lang/Enum;
.source "RegisterDeviceRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "RegisterEndpointEnum"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

.field public static final enum FIRS:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

.field public static final enum Panda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 113
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    const-string/jumbo v1, "FIRS"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->FIRS:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    .line 114
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    const-string/jumbo v1, "Panda"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->Panda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    .line 111
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->FIRS:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->Panda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

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
    .line 111
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 111
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;
    .locals 1

    .prologue
    .line 111
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    return-object v0
.end method
