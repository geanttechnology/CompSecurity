.class public final enum Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;
.super Ljava/lang/Enum;
.source "RegisterDeviceRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CustomerAccountTokenType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

.field public static final enum ACCESS_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

.field public static final enum AT_MAIN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

.field public static final enum AUTH_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;


# instance fields
.field private final mValue:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 95
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    const-string/jumbo v1, "AT_MAIN"

    const-string/jumbo v2, "ATMain"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->AT_MAIN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    .line 96
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    const-string/jumbo v1, "ACCESS_TOKEN"

    const-string/jumbo v2, "AccessToken"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->ACCESS_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    .line 97
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    const-string/jumbo v1, "AUTH_TOKEN"

    const-string/jumbo v2, "AuthToken"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->AUTH_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    .line 93
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->AT_MAIN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->ACCESS_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->AUTH_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 101
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 102
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->mValue:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 93
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;
    .locals 1

    .prologue
    .line 93
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->$VALUES:[Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    invoke-virtual {v0}, [Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->mValue:Ljava/lang/String;

    return-object v0
.end method
