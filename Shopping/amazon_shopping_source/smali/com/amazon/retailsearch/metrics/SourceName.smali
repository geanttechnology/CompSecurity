.class public final enum Lcom/amazon/retailsearch/metrics/SourceName;
.super Ljava/lang/Enum;
.source "SourceName.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/metrics/SourceName;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/metrics/SourceName;

.field public static final enum AssetsSRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

.field public static final enum Engagement:Lcom/amazon/retailsearch/metrics/SourceName;

.field public static final enum Filter:Lcom/amazon/retailsearch/metrics/SourceName;

.field public static final enum ISS:Lcom/amazon/retailsearch/metrics/SourceName;

.field public static final enum PersonalizedISSSRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

.field public static final enum SRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

.field public static final enum Search:Lcom/amazon/retailsearch/metrics/SourceName;

.field public static final enum SearchInit:Lcom/amazon/retailsearch/metrics/SourceName;

.field public static final enum ShopByDepartment:Lcom/amazon/retailsearch/metrics/SourceName;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 11
    new-instance v0, Lcom/amazon/retailsearch/metrics/SourceName;

    const-string/jumbo v1, "Search"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/metrics/SourceName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    .line 12
    new-instance v0, Lcom/amazon/retailsearch/metrics/SourceName;

    const-string/jumbo v1, "SearchInit"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/metrics/SourceName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->SearchInit:Lcom/amazon/retailsearch/metrics/SourceName;

    .line 13
    new-instance v0, Lcom/amazon/retailsearch/metrics/SourceName;

    const-string/jumbo v1, "SRDSRequest"

    invoke-direct {v0, v1, v5}, Lcom/amazon/retailsearch/metrics/SourceName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->SRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

    .line 14
    new-instance v0, Lcom/amazon/retailsearch/metrics/SourceName;

    const-string/jumbo v1, "AssetsSRDSRequest"

    invoke-direct {v0, v1, v6}, Lcom/amazon/retailsearch/metrics/SourceName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->AssetsSRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

    .line 15
    new-instance v0, Lcom/amazon/retailsearch/metrics/SourceName;

    const-string/jumbo v1, "Filter"

    invoke-direct {v0, v1, v7}, Lcom/amazon/retailsearch/metrics/SourceName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->Filter:Lcom/amazon/retailsearch/metrics/SourceName;

    .line 16
    new-instance v0, Lcom/amazon/retailsearch/metrics/SourceName;

    const-string/jumbo v1, "ISS"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SourceName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->ISS:Lcom/amazon/retailsearch/metrics/SourceName;

    .line 17
    new-instance v0, Lcom/amazon/retailsearch/metrics/SourceName;

    const-string/jumbo v1, "PersonalizedISSSRDSRequest"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SourceName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->PersonalizedISSSRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

    .line 18
    new-instance v0, Lcom/amazon/retailsearch/metrics/SourceName;

    const-string/jumbo v1, "ShopByDepartment"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SourceName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->ShopByDepartment:Lcom/amazon/retailsearch/metrics/SourceName;

    .line 19
    new-instance v0, Lcom/amazon/retailsearch/metrics/SourceName;

    const-string/jumbo v1, "Engagement"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SourceName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->Engagement:Lcom/amazon/retailsearch/metrics/SourceName;

    .line 9
    const/16 v0, 0x9

    new-array v0, v0, [Lcom/amazon/retailsearch/metrics/SourceName;

    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->SearchInit:Lcom/amazon/retailsearch/metrics/SourceName;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->SRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->AssetsSRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Filter:Lcom/amazon/retailsearch/metrics/SourceName;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/retailsearch/metrics/SourceName;->ISS:Lcom/amazon/retailsearch/metrics/SourceName;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/retailsearch/metrics/SourceName;->PersonalizedISSSRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/retailsearch/metrics/SourceName;->ShopByDepartment:Lcom/amazon/retailsearch/metrics/SourceName;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/retailsearch/metrics/SourceName;->Engagement:Lcom/amazon/retailsearch/metrics/SourceName;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->$VALUES:[Lcom/amazon/retailsearch/metrics/SourceName;

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
    .line 9
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/SourceName;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/metrics/SourceName;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/metrics/SourceName;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->$VALUES:[Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/metrics/SourceName;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/metrics/SourceName;

    return-object v0
.end method
