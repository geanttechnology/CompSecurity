.class public final enum Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;
.super Ljava/lang/Enum;
.source "SearchParameterName.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum ALIAS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum API_VERSION:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum ASINS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum CLIENT_REQUEST_ID:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum DATA_SET:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum IE:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum IMAGE_CROP:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum IMAGE_RESOLUTION:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum KEYWORDS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum MAX_RESULTS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum MERCHANT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum NODE:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum PAGE:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum REFINEMENT_HISTORY:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum RESPONSE_FORMAT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum SEARCH_METHOD:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

.field public static final enum SORT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 10
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "API_VERSION"

    const-string/jumbo v2, "dataVersion"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->API_VERSION:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 11
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "CLIENT_ID"

    const-string/jumbo v2, "cid"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 12
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "RESPONSE_FORMAT"

    const-string/jumbo v2, "format"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->RESPONSE_FORMAT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 13
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "DATA_SET"

    const-string/jumbo v2, "dataset"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->DATA_SET:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 14
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "ALIAS"

    const-string/jumbo v2, "i"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->ALIAS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 15
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "KEYWORDS"

    const/4 v2, 0x5

    const-string/jumbo v3, "k"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->KEYWORDS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 16
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "NODE"

    const/4 v2, 0x6

    const-string/jumbo v3, "n"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->NODE:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 17
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "MERCHANT"

    const/4 v2, 0x7

    const-string/jumbo v3, "me"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->MERCHANT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 18
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "REFINEMENT_HISTORY"

    const/16 v2, 0x8

    const-string/jumbo v3, "rh"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->REFINEMENT_HISTORY:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 19
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "SORT"

    const/16 v2, 0x9

    const-string/jumbo v3, "s"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->SORT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 20
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "PAGE"

    const/16 v2, 0xa

    const-string/jumbo v3, "p"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->PAGE:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 21
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "MAX_RESULTS"

    const/16 v2, 0xb

    const-string/jumbo v3, "maxResults"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->MAX_RESULTS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 22
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "IE"

    const/16 v2, 0xc

    const-string/jumbo v3, "ie"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->IE:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 23
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "IMAGE_RESOLUTION"

    const/16 v2, 0xd

    const-string/jumbo v3, "imgRes"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->IMAGE_RESOLUTION:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 24
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "IMAGE_CROP"

    const/16 v2, 0xe

    const-string/jumbo v3, "imgCrop"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->IMAGE_CROP:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 25
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "SEARCH_METHOD"

    const/16 v2, 0xf

    const-string/jumbo v3, "searchMethod"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->SEARCH_METHOD:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 26
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "CLIENT_REQUEST_ID"

    const/16 v2, 0x10

    const-string/jumbo v3, "cri"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->CLIENT_REQUEST_ID:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 27
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    const-string/jumbo v1, "ASINS"

    const/16 v2, 0x11

    const-string/jumbo v3, "asins"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->ASINS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    .line 9
    const/16 v0, 0x12

    new-array v0, v0, [Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->API_VERSION:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->RESPONSE_FORMAT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->DATA_SET:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->ALIAS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->KEYWORDS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->NODE:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->MERCHANT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->REFINEMENT_HISTORY:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->SORT:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->PAGE:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->MAX_RESULTS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->IE:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->IMAGE_RESOLUTION:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->IMAGE_CROP:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->SEARCH_METHOD:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->CLIENT_REQUEST_ID:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->ASINS:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 35
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 36
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->name:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    return-object v0
.end method

.method public static values()[Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v0}, [Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->name:Ljava/lang/String;

    return-object v0
.end method
