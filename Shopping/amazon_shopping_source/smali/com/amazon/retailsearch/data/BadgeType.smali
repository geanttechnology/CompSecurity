.class public final enum Lcom/amazon/retailsearch/data/BadgeType;
.super Ljava/lang/Enum;
.source "BadgeType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/data/BadgeType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum ADD_ON:Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum AUTO_RIP:Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum BEST_SELLER:Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum PRIME:Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum PRIME_FRESH:Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum PRIME_ONE_DAY:Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum PRIME_PANTRY:Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum PRIME_STANDARD:Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum STARS1:Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum STARS2:Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum STARS3:Lcom/amazon/retailsearch/data/BadgeType;

.field public static final enum STARS4:Lcom/amazon/retailsearch/data/BadgeType;

.field private static badgeTypes:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/retailsearch/data/BadgeType;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private badgeDescriptionResource:Ljava/lang/Integer;

.field private badgeId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 15

    .prologue
    const/4 v14, 0x4

    const/4 v13, 0x3

    const/4 v12, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 20
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "PRIME"

    const-string/jumbo v7, "primeBadge"

    sget v8, Lcom/amazon/retailsearch/R$string;->prime_eligible:I

    invoke-direct {v5, v6, v10, v7, v8}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;I)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->PRIME:Lcom/amazon/retailsearch/data/BadgeType;

    .line 21
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "PRIME_FRESH"

    const-string/jumbo v7, "primeFreshBadge"

    sget v8, Lcom/amazon/retailsearch/R$string;->prime_fresh_eligible:I

    invoke-direct {v5, v6, v11, v7, v8}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;I)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->PRIME_FRESH:Lcom/amazon/retailsearch/data/BadgeType;

    .line 22
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "PRIME_ONE_DAY"

    const-string/jumbo v7, "primeOneDayBadge"

    invoke-direct {v5, v6, v12, v7}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->PRIME_ONE_DAY:Lcom/amazon/retailsearch/data/BadgeType;

    .line 23
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "PRIME_PANTRY"

    const-string/jumbo v7, "primePantryBadge"

    sget v8, Lcom/amazon/retailsearch/R$string;->prime_pantry_eligible:I

    invoke-direct {v5, v6, v13, v7, v8}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;I)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->PRIME_PANTRY:Lcom/amazon/retailsearch/data/BadgeType;

    .line 24
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "PRIME_STANDARD"

    const-string/jumbo v7, "primeStandardBadge"

    invoke-direct {v5, v6, v14, v7}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->PRIME_STANDARD:Lcom/amazon/retailsearch/data/BadgeType;

    .line 25
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "ADD_ON"

    const/4 v7, 0x5

    const-string/jumbo v8, "addOnBadge"

    sget v9, Lcom/amazon/retailsearch/R$string;->addon:I

    invoke-direct {v5, v6, v7, v8, v9}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;I)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->ADD_ON:Lcom/amazon/retailsearch/data/BadgeType;

    .line 26
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "AUTO_RIP"

    const/4 v7, 0x6

    const-string/jumbo v8, "autoRipBadge"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->AUTO_RIP:Lcom/amazon/retailsearch/data/BadgeType;

    .line 27
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "BEST_SELLER"

    const/4 v7, 0x7

    const-string/jumbo v8, "bestSellerBadge"

    sget v9, Lcom/amazon/retailsearch/R$string;->rs_results_best_seller_description:I

    invoke-direct {v5, v6, v7, v8, v9}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;I)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->BEST_SELLER:Lcom/amazon/retailsearch/data/BadgeType;

    .line 28
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "STARS1"

    const/16 v7, 0x8

    const-string/jumbo v8, "stars1Image"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->STARS1:Lcom/amazon/retailsearch/data/BadgeType;

    .line 29
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "STARS2"

    const/16 v7, 0x9

    const-string/jumbo v8, "stars2Image"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->STARS2:Lcom/amazon/retailsearch/data/BadgeType;

    .line 30
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "STARS3"

    const/16 v7, 0xa

    const-string/jumbo v8, "stars3Image"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->STARS3:Lcom/amazon/retailsearch/data/BadgeType;

    .line 31
    new-instance v5, Lcom/amazon/retailsearch/data/BadgeType;

    const-string/jumbo v6, "STARS4"

    const/16 v7, 0xb

    const-string/jumbo v8, "stars4Image"

    invoke-direct {v5, v6, v7, v8}, Lcom/amazon/retailsearch/data/BadgeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->STARS4:Lcom/amazon/retailsearch/data/BadgeType;

    .line 18
    const/16 v5, 0xc

    new-array v5, v5, [Lcom/amazon/retailsearch/data/BadgeType;

    sget-object v6, Lcom/amazon/retailsearch/data/BadgeType;->PRIME:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v6, v5, v10

    sget-object v6, Lcom/amazon/retailsearch/data/BadgeType;->PRIME_FRESH:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v6, v5, v11

    sget-object v6, Lcom/amazon/retailsearch/data/BadgeType;->PRIME_ONE_DAY:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v6, v5, v12

    sget-object v6, Lcom/amazon/retailsearch/data/BadgeType;->PRIME_PANTRY:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v6, v5, v13

    sget-object v6, Lcom/amazon/retailsearch/data/BadgeType;->PRIME_STANDARD:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v6, v5, v14

    const/4 v6, 0x5

    sget-object v7, Lcom/amazon/retailsearch/data/BadgeType;->ADD_ON:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v7, v5, v6

    const/4 v6, 0x6

    sget-object v7, Lcom/amazon/retailsearch/data/BadgeType;->AUTO_RIP:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v7, v5, v6

    const/4 v6, 0x7

    sget-object v7, Lcom/amazon/retailsearch/data/BadgeType;->BEST_SELLER:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v7, v5, v6

    const/16 v6, 0x8

    sget-object v7, Lcom/amazon/retailsearch/data/BadgeType;->STARS1:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v7, v5, v6

    const/16 v6, 0x9

    sget-object v7, Lcom/amazon/retailsearch/data/BadgeType;->STARS2:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v7, v5, v6

    const/16 v6, 0xa

    sget-object v7, Lcom/amazon/retailsearch/data/BadgeType;->STARS3:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v7, v5, v6

    const/16 v6, 0xb

    sget-object v7, Lcom/amazon/retailsearch/data/BadgeType;->STARS4:Lcom/amazon/retailsearch/data/BadgeType;

    aput-object v7, v5, v6

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->$VALUES:[Lcom/amazon/retailsearch/data/BadgeType;

    .line 37
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    sput-object v5, Lcom/amazon/retailsearch/data/BadgeType;->badgeTypes:Ljava/util/Map;

    .line 40
    invoke-static {}, Lcom/amazon/retailsearch/data/BadgeType;->values()[Lcom/amazon/retailsearch/data/BadgeType;

    move-result-object v4

    .line 41
    .local v4, "values":[Lcom/amazon/retailsearch/data/BadgeType;
    move-object v0, v4

    .local v0, "arr$":[Lcom/amazon/retailsearch/data/BadgeType;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 43
    .local v1, "badgeType":Lcom/amazon/retailsearch/data/BadgeType;
    sget-object v5, Lcom/amazon/retailsearch/data/BadgeType;->badgeTypes:Ljava/util/Map;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/data/BadgeType;->getBadgeId()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 45
    .end local v1    # "badgeType":Lcom/amazon/retailsearch/data/BadgeType;
    :cond_0
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p3, "badgeId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 52
    iput-object p3, p0, Lcom/amazon/retailsearch/data/BadgeType;->badgeId:Ljava/lang/String;

    .line 53
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/BadgeType;->badgeDescriptionResource:Ljava/lang/Integer;

    .line 54
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;I)V
    .locals 1
    .param p3, "badgeId"    # Ljava/lang/String;
    .param p4, "badgeDescriptionResource"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I)V"
        }
    .end annotation

    .prologue
    .line 61
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 62
    iput-object p3, p0, Lcom/amazon/retailsearch/data/BadgeType;->badgeId:Ljava/lang/String;

    .line 63
    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/BadgeType;->badgeDescriptionResource:Ljava/lang/Integer;

    .line 64
    return-void
.end method

.method public static getBadgeType(Ljava/lang/String;)Lcom/amazon/retailsearch/data/BadgeType;
    .locals 1
    .param p0, "badgeId"    # Ljava/lang/String;

    .prologue
    .line 87
    sget-object v0, Lcom/amazon/retailsearch/data/BadgeType;->badgeTypes:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/data/BadgeType;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/data/BadgeType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 18
    const-class v0, Lcom/amazon/retailsearch/data/BadgeType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/data/BadgeType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/data/BadgeType;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/retailsearch/data/BadgeType;->$VALUES:[Lcom/amazon/retailsearch/data/BadgeType;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/data/BadgeType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/data/BadgeType;

    return-object v0
.end method


# virtual methods
.method public getBadgeId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/retailsearch/data/BadgeType;->badgeId:Ljava/lang/String;

    return-object v0
.end method

.method public getDescriptionResource()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/retailsearch/data/BadgeType;->badgeDescriptionResource:Ljava/lang/Integer;

    return-object v0
.end method
