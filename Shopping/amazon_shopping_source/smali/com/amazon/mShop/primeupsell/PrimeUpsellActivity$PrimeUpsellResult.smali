.class public final enum Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;
.super Ljava/lang/Enum;
.source "PrimeUpsellActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PrimeUpsellResult"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

.field public static final enum RESULT_LOAD_PAGE_ERROR:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

.field public static final enum RESULT_OFFER_PAGE_NOT_DISPLAYED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

.field public static final enum RESULT_SIGNUP_FAILURE:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

.field public static final enum RESULT_SIGNUP_SUCCESS:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

.field public static final enum RESULT_USER_CANCELLED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 22
    new-instance v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    const-string/jumbo v1, "RESULT_USER_CANCELLED"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_USER_CANCELLED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    .line 23
    new-instance v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    const-string/jumbo v1, "RESULT_SIGNUP_SUCCESS"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_SIGNUP_SUCCESS:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    .line 24
    new-instance v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    const-string/jumbo v1, "RESULT_SIGNUP_FAILURE"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_SIGNUP_FAILURE:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    .line 25
    new-instance v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    const-string/jumbo v1, "RESULT_OFFER_PAGE_NOT_DISPLAYED"

    invoke-direct {v0, v1, v5}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_OFFER_PAGE_NOT_DISPLAYED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    .line 26
    new-instance v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    const-string/jumbo v1, "RESULT_LOAD_PAGE_ERROR"

    invoke-direct {v0, v1, v6}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_LOAD_PAGE_ERROR:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    .line 21
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_USER_CANCELLED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_SIGNUP_SUCCESS:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_SIGNUP_FAILURE:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_OFFER_PAGE_NOT_DISPLAYED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_LOAD_PAGE_ERROR:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->$VALUES:[Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

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
    .line 21
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 21
    const-class v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->$VALUES:[Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    invoke-virtual {v0}, [Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    return-object v0
.end method
