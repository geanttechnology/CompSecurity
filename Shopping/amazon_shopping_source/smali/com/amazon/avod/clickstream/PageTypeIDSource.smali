.class public final enum Lcom/amazon/avod/clickstream/PageTypeIDSource;
.super Ljava/lang/Enum;
.source "PageTypeIDSource.java"

# interfaces
.implements Lcom/amazon/avod/clickstream/ClickstreamParam;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/avod/clickstream/PageTypeIDSource;",
        ">;",
        "Lcom/amazon/avod/clickstream/ClickstreamParam;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/avod/clickstream/PageTypeIDSource;

.field public static final enum ASIN:Lcom/amazon/avod/clickstream/PageTypeIDSource;

.field public static final enum IMDB_CAST_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

.field public static final enum IMDB_CHARACTER_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

.field public static final enum IMDB_SCENE_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

.field public static final enum IMDB_SOUNDTRACK_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

.field public static final enum IMDB_TRIVIA_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

.field public static final enum XRAY_DOCUMENT_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;


# instance fields
.field private final mReportableString:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 19
    new-instance v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;

    const-string/jumbo v1, "ASIN"

    const-string/jumbo v2, "ASIN"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/avod/clickstream/PageTypeIDSource;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;->ASIN:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    .line 22
    new-instance v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;

    const-string/jumbo v1, "XRAY_DOCUMENT_ID"

    const-string/jumbo v2, "VSID"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/avod/clickstream/PageTypeIDSource;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;->XRAY_DOCUMENT_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    .line 25
    new-instance v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;

    const-string/jumbo v1, "IMDB_CAST_ID"

    const-string/jumbo v2, "NCONST"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/avod/clickstream/PageTypeIDSource;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;->IMDB_CAST_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    .line 28
    new-instance v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;

    const-string/jumbo v1, "IMDB_CHARACTER_ID"

    const-string/jumbo v2, "CHCONST"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/avod/clickstream/PageTypeIDSource;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;->IMDB_CHARACTER_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    .line 31
    new-instance v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;

    const-string/jumbo v1, "IMDB_SOUNDTRACK_ID"

    const-string/jumbo v2, "SNCONST"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/avod/clickstream/PageTypeIDSource;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;->IMDB_SOUNDTRACK_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    .line 34
    new-instance v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;

    const-string/jumbo v1, "IMDB_TRIVIA_ID"

    const/4 v2, 0x5

    const-string/jumbo v3, "TRCONST"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageTypeIDSource;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;->IMDB_TRIVIA_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    .line 41
    new-instance v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;

    const-string/jumbo v1, "IMDB_SCENE_ID"

    const/4 v2, 0x6

    const-string/jumbo v3, "SCCONST"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/avod/clickstream/PageTypeIDSource;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;->IMDB_SCENE_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    .line 11
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/amazon/avod/clickstream/PageTypeIDSource;

    sget-object v1, Lcom/amazon/avod/clickstream/PageTypeIDSource;->ASIN:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/avod/clickstream/PageTypeIDSource;->XRAY_DOCUMENT_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/avod/clickstream/PageTypeIDSource;->IMDB_CAST_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/avod/clickstream/PageTypeIDSource;->IMDB_CHARACTER_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/avod/clickstream/PageTypeIDSource;->IMDB_SOUNDTRACK_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/avod/clickstream/PageTypeIDSource;->IMDB_TRIVIA_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/avod/clickstream/PageTypeIDSource;->IMDB_SCENE_ID:Lcom/amazon/avod/clickstream/PageTypeIDSource;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;->$VALUES:[Lcom/amazon/avod/clickstream/PageTypeIDSource;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 2
    .param p3, "reportableString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 46
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x14

    if-gt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string/jumbo v1, "PageTypeIDSource length limit exceeded."

    invoke-static {v0, v1}, Lcom/google/common/base/Preconditions;->checkArgument(ZLjava/lang/Object;)V

    .line 49
    iput-object p3, p0, Lcom/amazon/avod/clickstream/PageTypeIDSource;->mReportableString:Ljava/lang/String;

    .line 50
    return-void

    .line 46
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/avod/clickstream/PageTypeIDSource;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;

    return-object v0
.end method

.method public static values()[Lcom/amazon/avod/clickstream/PageTypeIDSource;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/avod/clickstream/PageTypeIDSource;->$VALUES:[Lcom/amazon/avod/clickstream/PageTypeIDSource;

    invoke-virtual {v0}, [Lcom/amazon/avod/clickstream/PageTypeIDSource;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/avod/clickstream/PageTypeIDSource;

    return-object v0
.end method


# virtual methods
.method public getReportableString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/avod/clickstream/PageTypeIDSource;->mReportableString:Ljava/lang/String;

    return-object v0
.end method
