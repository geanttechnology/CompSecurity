.class final enum Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;
.super Ljava/lang/Enum;
.source "CheckoutConfirmationFragment_Offers.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

.field public static final enum EXISTING_OFFER:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

.field public static final enum NEW_OFFER:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 50
    new-instance v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    const-string v1, "EXISTING_OFFER"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->EXISTING_OFFER:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    new-instance v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    const-string v1, "NEW_OFFER"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->NEW_OFFER:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->EXISTING_OFFER:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->NEW_OFFER:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    aput-object v1, v0, v3

    sput-object v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->$VALUES:[Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

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
    .line 50
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 50
    const-class v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->$VALUES:[Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    invoke-virtual {v0}, [Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    return-object v0
.end method
