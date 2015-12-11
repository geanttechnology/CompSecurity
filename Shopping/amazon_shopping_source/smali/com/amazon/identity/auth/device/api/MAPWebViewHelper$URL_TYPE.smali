.class public final enum Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;
.super Ljava/lang/Enum;
.source "MAPWebViewHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "URL_TYPE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

.field public static final enum CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

.field public static final enum REGULAR:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

.field public static final enum SIGNIN:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 63
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    const-string/jumbo v1, "REGULAR"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->REGULAR:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    .line 64
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    const-string/jumbo v1, "SIGNIN"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->SIGNIN:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    .line 65
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    const-string/jumbo v1, "CONFIRM_CREDENTIAL"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    .line 61
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->REGULAR:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->SIGNIN:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->$VALUES:[Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

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
    .line 61
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 61
    const-class v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;
    .locals 1

    .prologue
    .line 61
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->$VALUES:[Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    return-object v0
.end method
