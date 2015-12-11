.class public final enum Lcom/amazon/mShop/ui/resources/BadgeType;
.super Ljava/lang/Enum;
.source "BadgeType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/ui/resources/BadgeType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/ui/resources/BadgeType;

.field public static final enum ADD_ON:Lcom/amazon/mShop/ui/resources/BadgeType;

.field public static final enum PRIME:Lcom/amazon/mShop/ui/resources/BadgeType;

.field public static final enum PRIME_FRESH:Lcom/amazon/mShop/ui/resources/BadgeType;

.field public static final enum PRIME_PLUS:Lcom/amazon/mShop/ui/resources/BadgeType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 4
    new-instance v0, Lcom/amazon/mShop/ui/resources/BadgeType;

    const-string/jumbo v1, "PRIME_FRESH"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/ui/resources/BadgeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME_FRESH:Lcom/amazon/mShop/ui/resources/BadgeType;

    .line 5
    new-instance v0, Lcom/amazon/mShop/ui/resources/BadgeType;

    const-string/jumbo v1, "PRIME_PLUS"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/ui/resources/BadgeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME_PLUS:Lcom/amazon/mShop/ui/resources/BadgeType;

    .line 6
    new-instance v0, Lcom/amazon/mShop/ui/resources/BadgeType;

    const-string/jumbo v1, "PRIME"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/ui/resources/BadgeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME:Lcom/amazon/mShop/ui/resources/BadgeType;

    .line 7
    new-instance v0, Lcom/amazon/mShop/ui/resources/BadgeType;

    const-string/jumbo v1, "ADD_ON"

    invoke-direct {v0, v1, v5}, Lcom/amazon/mShop/ui/resources/BadgeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/ui/resources/BadgeType;->ADD_ON:Lcom/amazon/mShop/ui/resources/BadgeType;

    .line 3
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/mShop/ui/resources/BadgeType;

    sget-object v1, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME_FRESH:Lcom/amazon/mShop/ui/resources/BadgeType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME_PLUS:Lcom/amazon/mShop/ui/resources/BadgeType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME:Lcom/amazon/mShop/ui/resources/BadgeType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/ui/resources/BadgeType;->ADD_ON:Lcom/amazon/mShop/ui/resources/BadgeType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/mShop/ui/resources/BadgeType;->$VALUES:[Lcom/amazon/mShop/ui/resources/BadgeType;

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
    .line 3
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/ui/resources/BadgeType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/amazon/mShop/ui/resources/BadgeType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/ui/resources/BadgeType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/ui/resources/BadgeType;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/amazon/mShop/ui/resources/BadgeType;->$VALUES:[Lcom/amazon/mShop/ui/resources/BadgeType;

    invoke-virtual {v0}, [Lcom/amazon/mShop/ui/resources/BadgeType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/ui/resources/BadgeType;

    return-object v0
.end method
