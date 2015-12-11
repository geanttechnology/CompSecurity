.class public final enum Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;
.super Ljava/lang/Enum;
.source "SearchLayoutType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

.field public static final enum FlipBook:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

.field public static final enum Gallery:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

.field public static final enum Grid:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

.field public static final enum List:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

.field public static final enum Split:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 4
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    const-string/jumbo v1, "List"

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->List:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    .line 5
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    const-string/jumbo v1, "Grid"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->Grid:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    .line 6
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    const-string/jumbo v1, "Gallery"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->Gallery:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    .line 7
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    const-string/jumbo v1, "FlipBook"

    invoke-direct {v0, v1, v5}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->FlipBook:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    .line 8
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    const-string/jumbo v1, "Split"

    invoke-direct {v0, v1, v6}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->Split:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    .line 3
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->List:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->Grid:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->Gallery:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->FlipBook:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->Split:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->$VALUES:[Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

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

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->$VALUES:[Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    return-object v0
.end method
