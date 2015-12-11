.class public final enum Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;
.super Ljava/lang/Enum;
.source "PublicURLProcessException.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/publicurl/PublicURLProcessException;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PublicURLErrorCode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

.field public static final enum ERROR_CODE_ERROR_HOSTNAME:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

.field public static final enum ERROR_CODE_ERROR_PATH:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

.field public static final enum ERROR_CODE_NEED_SIGNIN:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

.field public static final enum ERROR_CODE_NEED_SWITCH_LOCALE:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 8
    new-instance v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    const-string/jumbo v1, "ERROR_CODE_NEED_SWITCH_LOCALE"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_NEED_SWITCH_LOCALE:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    .line 9
    new-instance v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    const-string/jumbo v1, "ERROR_CODE_NEED_SIGNIN"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_NEED_SIGNIN:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    .line 10
    new-instance v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    const-string/jumbo v1, "ERROR_CODE_ERROR_HOSTNAME"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_ERROR_HOSTNAME:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    .line 11
    new-instance v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    const-string/jumbo v1, "ERROR_CODE_ERROR_PATH"

    invoke-direct {v0, v1, v5}, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_ERROR_PATH:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    .line 7
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    sget-object v1, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_NEED_SWITCH_LOCALE:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_NEED_SIGNIN:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_ERROR_HOSTNAME:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_ERROR_PATH:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->$VALUES:[Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

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
    .line 7
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->$VALUES:[Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    invoke-virtual {v0}, [Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    return-object v0
.end method
