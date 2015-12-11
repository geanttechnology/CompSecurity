.class public final enum Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;
.super Ljava/lang/Enum;
.source "DeepLinkUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/DeepLinkUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DEEPLINK_DESTINATION"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum ACCOUNT:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum BRAND_PAGE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum BRAND_PICKER:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum CLOSET:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum EXPANDED_MIFU:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum FIND_PEOPLE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum INVALID:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum LISTING_DETAILS:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum MAPP_PAGE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum MYBUNDLES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum MYLIKES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum NEWS:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum PARTIES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum PARTY:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum SEARCH_BRAND:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum SEARCH_CATEGORY:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum SEARCH_KEYWORD:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum SELL:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum SHARES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum SHOP:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

.field public static final enum SHOWROOM:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 49
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "INVALID"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->INVALID:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 50
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "SHOP"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SHOP:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 51
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "PARTIES"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->PARTIES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 52
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "SELL"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SELL:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 53
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "NEWS"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->NEWS:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 54
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "ACCOUNT"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->ACCOUNT:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 55
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "CLOSET"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->CLOSET:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 56
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "LISTING_DETAILS"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->LISTING_DETAILS:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 57
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "PARTY"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->PARTY:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 58
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "SHOWROOM"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SHOWROOM:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 59
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "SHARES"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SHARES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 60
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "MYLIKES"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->MYLIKES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 61
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "MYBUNDLES"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->MYBUNDLES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 62
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "EXPANDED_MIFU"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->EXPANDED_MIFU:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 63
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "SEARCH_KEYWORD"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SEARCH_KEYWORD:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 64
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "SEARCH_CATEGORY"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SEARCH_CATEGORY:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 65
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "SEARCH_BRAND"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SEARCH_BRAND:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 66
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "MAPP_PAGE"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->MAPP_PAGE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 67
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "BRAND_PICKER"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->BRAND_PICKER:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 68
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "BRAND_PAGE"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->BRAND_PAGE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 69
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    const-string v1, "FIND_PEOPLE"

    const/16 v2, 0x14

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->FIND_PEOPLE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    .line 48
    const/16 v0, 0x15

    new-array v0, v0, [Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    sget-object v1, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->INVALID:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SHOP:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->PARTIES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SELL:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->NEWS:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->ACCOUNT:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->CLOSET:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->LISTING_DETAILS:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->PARTY:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SHOWROOM:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SHARES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->MYLIKES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->MYBUNDLES:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->EXPANDED_MIFU:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SEARCH_KEYWORD:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SEARCH_CATEGORY:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->SEARCH_BRAND:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->MAPP_PAGE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->BRAND_PICKER:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->BRAND_PAGE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->FIND_PEOPLE:Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->$VALUES:[Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

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
    .line 48
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 48
    const-class v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;
    .locals 1

    .prologue
    .line 48
    sget-object v0, Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->$VALUES:[Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    invoke-virtual {v0}, [Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/DeepLinkUtils$DEEPLINK_DESTINATION;

    return-object v0
.end method
