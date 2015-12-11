.class public final enum Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

.field public static final enum SOLRSortBestSelling:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

.field public static final enum SOLRSortBrandAZ:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

.field public static final enum SOLRSortBrandZA:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

.field public static final enum SOLRSortHighestRatings:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

.field public static final enum SOLRSortNewArrivals:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

.field public static final enum SOLRSortNone:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

.field public static final enum SOLRSortPriceHighToLow:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

.field public static final enum SOLRSortPriceLowToHigh:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

.field public static final enum SOLRSortReleaseData:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

.field public static final enum SOLRSortTitleAZ:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

.field public static final enum SOLRSortTitleZA:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;


# instance fields
.field private final sortDesc:Ljava/lang/String;

.field private final sortOrder:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 4
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    const-string v1, "SOLRSortPriceLowToHigh"

    const-string v2, "&sort=Price-Low-To-High"

    const-string v3, "Price Low to High"

    invoke-direct {v0, v1, v5, v2, v3}, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortPriceLowToHigh:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    .line 5
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    const-string v1, "SOLRSortPriceHighToLow"

    const-string v2, "&sort=Price-High-To-Low"

    const-string v3, "Price High to Low"

    invoke-direct {v0, v1, v6, v2, v3}, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortPriceHighToLow:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    .line 6
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    const-string v1, "SOLRSortBrandAZ"

    const-string v2, "&sort=Brand-A-Z"

    const-string v3, "Brand A-Z"

    invoke-direct {v0, v1, v7, v2, v3}, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortBrandAZ:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    .line 7
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    const-string v1, "SOLRSortBrandZA"

    const-string v2, "&sort=Brand-Z-A"

    const-string v3, "Brand Z-A"

    invoke-direct {v0, v1, v8, v2, v3}, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortBrandZA:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    .line 8
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    const-string v1, "SOLRSortTitleAZ"

    const-string v2, "&sort=Title-A-Z"

    const-string v3, "Title A-Z"

    invoke-direct {v0, v1, v9, v2, v3}, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortTitleAZ:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    .line 9
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    const-string v1, "SOLRSortTitleZA"

    const/4 v2, 0x5

    const-string v3, "&sort=Title-Z-A"

    const-string v4, "Title Z-A"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortTitleZA:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    .line 10
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    const-string v1, "SOLRSortBestSelling"

    const/4 v2, 0x6

    const-string v3, "&sort=Best-Selling"

    const-string v4, "Best Selling"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortBestSelling:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    .line 11
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    const-string v1, "SOLRSortReleaseData"

    const/4 v2, 0x7

    const-string v3, "&sort=Release-Date"

    const-string v4, "Release Date"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortReleaseData:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    .line 12
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    const-string v1, "SOLRSortNewArrivals"

    const/16 v2, 0x8

    const-string v3, "&sort=New-Arrivals"

    const-string v4, "Newest Arrivals"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortNewArrivals:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    .line 13
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    const-string v1, "SOLRSortHighestRatings"

    const/16 v2, 0x9

    const-string v3, "&sort=Highest-Rated"

    const-string v4, "Highest Rated"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortHighestRatings:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    .line 14
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    const-string v1, "SOLRSortNone"

    const/16 v2, 0xa

    const-string v3, ""

    const-string v4, ""

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortNone:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    .line 3
    const/16 v0, 0xb

    new-array v0, v0, [Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    sget-object v1, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortPriceLowToHigh:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    aput-object v1, v0, v5

    sget-object v1, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortPriceHighToLow:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    aput-object v1, v0, v6

    sget-object v1, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortBrandAZ:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    aput-object v1, v0, v7

    sget-object v1, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortBrandZA:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    aput-object v1, v0, v8

    sget-object v1, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortTitleAZ:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    aput-object v1, v0, v9

    const/4 v1, 0x5

    sget-object v2, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortTitleZA:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortBestSelling:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortReleaseData:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortNewArrivals:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortHighestRatings:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->SOLRSortNone:Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    aput-object v2, v0, v1

    sput-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->$VALUES:[Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 28
    iput-object p3, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->sortOrder:Ljava/lang/String;

    .line 29
    iput-object p4, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->sortDesc:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;
    .locals 1

    .prologue
    .line 3
    const-class v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    return-object v0
.end method

.method public static values()[Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->$VALUES:[Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    invoke-virtual {v0}, [Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;

    return-object v0
.end method


# virtual methods
.method public getSortDesc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->sortDesc:Ljava/lang/String;

    return-object v0
.end method

.method public getSortOrder()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SolrSortOrder;->sortOrder:Ljava/lang/String;

    return-object v0
.end method
