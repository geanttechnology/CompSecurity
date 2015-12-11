.class public final enum Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
.super Ljava/lang/Enum;
.source "OpenIdRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "REQUEST_TYPE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

.field public static final enum AUTHENTICATE:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

.field public static final enum CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

.field public static final enum REGISTER:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

.field public static final enum SIGN_IN:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 106
    new-instance v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    const-string/jumbo v1, "SIGN_IN"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->SIGN_IN:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    .line 112
    new-instance v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    const-string/jumbo v1, "REGISTER"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->REGISTER:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    .line 118
    new-instance v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    const-string/jumbo v1, "CONFIRM_CREDENTIAL"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    .line 124
    new-instance v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    const-string/jumbo v1, "AUTHENTICATE"

    invoke-direct {v0, v1, v5}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->AUTHENTICATE:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    .line 100
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    sget-object v1, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->SIGN_IN:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->REGISTER:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->AUTHENTICATE:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->$VALUES:[Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

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
    .line 100
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 100
    const-class v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .locals 1

    .prologue
    .line 100
    sget-object v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->$VALUES:[Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    return-object v0
.end method
