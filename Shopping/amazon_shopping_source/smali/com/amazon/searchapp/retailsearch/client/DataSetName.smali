.class public final enum Lcom/amazon/searchapp/retailsearch/client/DataSetName;
.super Ljava/lang/Enum;
.source "DataSetName.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/searchapp/retailsearch/client/DataSetName;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/searchapp/retailsearch/client/DataSetName;

.field public static final enum DEFAULT:Lcom/amazon/searchapp/retailsearch/client/DataSetName;

.field public static final enum REFINEMENTS:Lcom/amazon/searchapp/retailsearch/client/DataSetName;

.field public static final enum RESULTS:Lcom/amazon/searchapp/retailsearch/client/DataSetName;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 12
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    const-string/jumbo v1, "DEFAULT"

    const-string/jumbo v2, "default"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/searchapp/retailsearch/client/DataSetName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DataSetName;->DEFAULT:Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    .line 13
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    const-string/jumbo v1, "RESULTS"

    const-string/jumbo v2, "results"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/searchapp/retailsearch/client/DataSetName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DataSetName;->RESULTS:Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    .line 14
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    const-string/jumbo v1, "REFINEMENTS"

    const-string/jumbo v2, "refinements"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/searchapp/retailsearch/client/DataSetName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DataSetName;->REFINEMENTS:Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    .line 11
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DataSetName;->DEFAULT:Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DataSetName;->RESULTS:Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/DataSetName;->REFINEMENTS:Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/DataSetName;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/DataSetName;

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
    .line 22
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 23
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/DataSetName;->name:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DataSetName;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    return-object v0
.end method

.method public static values()[Lcom/amazon/searchapp/retailsearch/client/DataSetName;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/DataSetName;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    invoke-virtual {v0}, [Lcom/amazon/searchapp/retailsearch/client/DataSetName;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/searchapp/retailsearch/client/DataSetName;

    return-object v0
.end method
