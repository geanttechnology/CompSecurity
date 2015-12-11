.class public final enum Lcom/amazon/identity/auth/device/api/SigninOption;
.super Ljava/lang/Enum;
.source "SigninOption.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/api/SigninOption;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/api/SigninOption;

.field public static final enum MyAccountSignin:Lcom/amazon/identity/auth/device/api/SigninOption;

.field public static final enum WebviewConfirmCredentials:Lcom/amazon/identity/auth/device/api/SigninOption;

.field public static final enum WebviewCreateAccount:Lcom/amazon/identity/auth/device/api/SigninOption;

.field public static final enum WebviewSignin:Lcom/amazon/identity/auth/device/api/SigninOption;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 27
    new-instance v0, Lcom/amazon/identity/auth/device/api/SigninOption;

    const-string/jumbo v1, "WebviewSignin"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/SigninOption;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewSignin:Lcom/amazon/identity/auth/device/api/SigninOption;

    .line 37
    new-instance v0, Lcom/amazon/identity/auth/device/api/SigninOption;

    const-string/jumbo v1, "WebviewCreateAccount"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/api/SigninOption;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewCreateAccount:Lcom/amazon/identity/auth/device/api/SigninOption;

    .line 52
    new-instance v0, Lcom/amazon/identity/auth/device/api/SigninOption;

    const-string/jumbo v1, "MyAccountSignin"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/auth/device/api/SigninOption;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/SigninOption;->MyAccountSignin:Lcom/amazon/identity/auth/device/api/SigninOption;

    .line 61
    new-instance v0, Lcom/amazon/identity/auth/device/api/SigninOption;

    const-string/jumbo v1, "WebviewConfirmCredentials"

    invoke-direct {v0, v1, v5}, Lcom/amazon/identity/auth/device/api/SigninOption;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewConfirmCredentials:Lcom/amazon/identity/auth/device/api/SigninOption;

    .line 14
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/identity/auth/device/api/SigninOption;

    sget-object v1, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewSignin:Lcom/amazon/identity/auth/device/api/SigninOption;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewCreateAccount:Lcom/amazon/identity/auth/device/api/SigninOption;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/api/SigninOption;->MyAccountSignin:Lcom/amazon/identity/auth/device/api/SigninOption;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewConfirmCredentials:Lcom/amazon/identity/auth/device/api/SigninOption;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/identity/auth/device/api/SigninOption;->$VALUES:[Lcom/amazon/identity/auth/device/api/SigninOption;

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
    .line 14
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/SigninOption;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    const-class v0, Lcom/amazon/identity/auth/device/api/SigninOption;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/SigninOption;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/api/SigninOption;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/amazon/identity/auth/device/api/SigninOption;->$VALUES:[Lcom/amazon/identity/auth/device/api/SigninOption;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/api/SigninOption;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/api/SigninOption;

    return-object v0
.end method
