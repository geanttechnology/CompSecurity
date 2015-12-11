.class public final enum Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;
.super Ljava/lang/Enum;
.source "AuthPortalHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AuthTokenExchangeType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

.field public static final enum DMSTokenToOauthTokenExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

.field public static final enum OauthRefreshToAccessExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

.field public static final enum OauthRefreshToCookieExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

.field public static final enum OauthRefreshToDelegationAccessExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 61
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    const-string/jumbo v1, "DMSTokenToOauthTokenExchange"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->DMSTokenToOauthTokenExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    .line 62
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    const-string/jumbo v1, "OauthRefreshToAccessExchange"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->OauthRefreshToAccessExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    .line 63
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    const-string/jumbo v1, "OauthRefreshToCookieExchange"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->OauthRefreshToCookieExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    .line 64
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    const-string/jumbo v1, "OauthRefreshToDelegationAccessExchange"

    invoke-direct {v0, v1, v5}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->OauthRefreshToDelegationAccessExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    .line 59
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    sget-object v1, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->DMSTokenToOauthTokenExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->OauthRefreshToAccessExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->OauthRefreshToCookieExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->OauthRefreshToDelegationAccessExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->$VALUES:[Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

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
    .line 59
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 59
    const-class v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->$VALUES:[Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    return-object v0
.end method
