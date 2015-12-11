.class public final enum Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;
.super Ljava/lang/Enum;
.source "HttpMethod.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

.field public static final enum DELETE:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

.field public static final enum GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

.field public static final enum HEAD:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

.field public static final enum OPTIONS:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

.field public static final enum POST:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

.field public static final enum PUT:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

.field public static final enum TRACE:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 10
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    const-string/jumbo v1, "DELETE"

    invoke-direct {v0, v1, v3}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->DELETE:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    .line 11
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    const-string/jumbo v1, "GET"

    invoke-direct {v0, v1, v4}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    .line 12
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    const-string/jumbo v1, "HEAD"

    invoke-direct {v0, v1, v5}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->HEAD:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    .line 13
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    const-string/jumbo v1, "OPTIONS"

    invoke-direct {v0, v1, v6}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->OPTIONS:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    .line 14
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    const-string/jumbo v1, "POST"

    invoke-direct {v0, v1, v7}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->POST:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    .line 15
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    const-string/jumbo v1, "PUT"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->PUT:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    .line 16
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    const-string/jumbo v1, "TRACE"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->TRACE:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    .line 9
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->DELETE:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->HEAD:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->OPTIONS:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->POST:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->PUT:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->TRACE:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

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

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    return-object v0
.end method

.method public static values()[Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v0}, [Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->name()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
