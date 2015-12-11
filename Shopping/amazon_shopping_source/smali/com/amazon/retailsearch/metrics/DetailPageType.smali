.class public final enum Lcom/amazon/retailsearch/metrics/DetailPageType;
.super Ljava/lang/Enum;
.source "DetailPageType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/metrics/DetailPageType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/metrics/DetailPageType;

.field public static final enum FORCED_PRIME:Lcom/amazon/retailsearch/metrics/DetailPageType;

.field public static final enum MAIN:Lcom/amazon/retailsearch/metrics/DetailPageType;

.field public static final enum NEWER_EDITION:Lcom/amazon/retailsearch/metrics/DetailPageType;

.field public static final enum TWISTER:Lcom/amazon/retailsearch/metrics/DetailPageType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 17
    new-instance v0, Lcom/amazon/retailsearch/metrics/DetailPageType;

    const-string/jumbo v1, "MAIN"

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/DetailPageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/DetailPageType;->MAIN:Lcom/amazon/retailsearch/metrics/DetailPageType;

    .line 20
    new-instance v0, Lcom/amazon/retailsearch/metrics/DetailPageType;

    const-string/jumbo v1, "NEWER_EDITION"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/metrics/DetailPageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/DetailPageType;->NEWER_EDITION:Lcom/amazon/retailsearch/metrics/DetailPageType;

    .line 21
    new-instance v0, Lcom/amazon/retailsearch/metrics/DetailPageType;

    const-string/jumbo v1, "TWISTER"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/metrics/DetailPageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/DetailPageType;->TWISTER:Lcom/amazon/retailsearch/metrics/DetailPageType;

    .line 22
    new-instance v0, Lcom/amazon/retailsearch/metrics/DetailPageType;

    const-string/jumbo v1, "FORCED_PRIME"

    invoke-direct {v0, v1, v5}, Lcom/amazon/retailsearch/metrics/DetailPageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/DetailPageType;->FORCED_PRIME:Lcom/amazon/retailsearch/metrics/DetailPageType;

    .line 14
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/retailsearch/metrics/DetailPageType;

    sget-object v1, Lcom/amazon/retailsearch/metrics/DetailPageType;->MAIN:Lcom/amazon/retailsearch/metrics/DetailPageType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/retailsearch/metrics/DetailPageType;->NEWER_EDITION:Lcom/amazon/retailsearch/metrics/DetailPageType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/metrics/DetailPageType;->TWISTER:Lcom/amazon/retailsearch/metrics/DetailPageType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/retailsearch/metrics/DetailPageType;->FORCED_PRIME:Lcom/amazon/retailsearch/metrics/DetailPageType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/retailsearch/metrics/DetailPageType;->$VALUES:[Lcom/amazon/retailsearch/metrics/DetailPageType;

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
    .line 14
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/DetailPageType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    const-class v0, Lcom/amazon/retailsearch/metrics/DetailPageType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/metrics/DetailPageType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/metrics/DetailPageType;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/amazon/retailsearch/metrics/DetailPageType;->$VALUES:[Lcom/amazon/retailsearch/metrics/DetailPageType;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/metrics/DetailPageType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/metrics/DetailPageType;

    return-object v0
.end method
