.class public final enum Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;
.super Ljava/lang/Enum;
.source "AccountManagerConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "COOKIE_TYPE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

.field public static final enum COOKIE:Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

.field public static final enum DELEGATED_COOKIE:Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 153
    new-instance v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    const-string/jumbo v1, "COOKIE"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;->COOKIE:Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    .line 154
    new-instance v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    const-string/jumbo v1, "DELEGATED_COOKIE"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;->DELEGATED_COOKIE:Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    .line 151
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    sget-object v1, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;->COOKIE:Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;->DELEGATED_COOKIE:Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;->$VALUES:[Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

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
    .line 151
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 151
    const-class v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;
    .locals 1

    .prologue
    .line 151
    sget-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;->$VALUES:[Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    return-object v0
.end method
