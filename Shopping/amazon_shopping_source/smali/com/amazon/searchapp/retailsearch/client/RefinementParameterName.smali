.class public final enum Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;
.super Ljava/lang/Enum;
.source "RefinementParameterName.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

.field public static final enum KEYWORDS:Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

.field public static final enum NODE:Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 11
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

    const-string/jumbo v1, "KEYWORDS"

    const-string/jumbo v2, "k"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;->KEYWORDS:Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

    .line 14
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

    const-string/jumbo v1, "NODE"

    const-string/jumbo v2, "n"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;->NODE:Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

    .line 9
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;->KEYWORDS:Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;->NODE:Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

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
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;->name:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

    return-object v0
.end method

.method public static values()[Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

    invoke-virtual {v0}, [Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/searchapp/retailsearch/client/RefinementParameterName;

    return-object v0
.end method
