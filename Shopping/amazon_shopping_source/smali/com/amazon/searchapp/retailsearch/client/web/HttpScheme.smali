.class public final enum Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;
.super Ljava/lang/Enum;
.source "HttpScheme.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

.field public static final enum HTTP:Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

.field public static final enum HTTPS:Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 10
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    const-string/jumbo v1, "HTTP"

    const-string/jumbo v2, "http"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->HTTP:Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    .line 11
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    const-string/jumbo v1, "HTTPS"

    const-string/jumbo v2, "https"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->HTTPS:Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    .line 9
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->HTTP:Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->HTTPS:Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

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
    .line 19
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 20
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->name:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    return-object v0
.end method

.method public static values()[Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    invoke-virtual {v0}, [Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/HttpScheme;->name:Ljava/lang/String;

    return-object v0
.end method
