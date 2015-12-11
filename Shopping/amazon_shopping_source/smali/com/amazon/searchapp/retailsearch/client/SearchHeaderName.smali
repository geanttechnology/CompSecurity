.class public final enum Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;
.super Ljava/lang/Enum;
.source "SearchHeaderName.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

.field public static final enum APP_ID:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

.field public static final enum CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

.field public static final enum PLATFORM:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 10
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    const-string/jumbo v1, "CLIENT_ID"

    const-string/jumbo v2, "x-search-client-id"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    .line 11
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    const-string/jumbo v1, "APP_ID"

    const-string/jumbo v2, "x-search-app-id"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->APP_ID:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    .line 12
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    const-string/jumbo v1, "PLATFORM"

    const-string/jumbo v2, "x-search-platform"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->PLATFORM:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    .line 9
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->APP_ID:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->PLATFORM:Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

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
    .line 20
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 21
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->name:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    return-object v0
.end method

.method public static values()[Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    invoke-virtual {v0}, [Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchHeaderName;->name:Ljava/lang/String;

    return-object v0
.end method
