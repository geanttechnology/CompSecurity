.class Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;
.super Ljava/lang/Object;
.source "Response.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/okhttp/internal/http/Response;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ParsedHeaders"
.end annotation


# instance fields
.field lastModified:Ljava/util/Date;

.field private varyFields:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/squareup/okhttp/internal/http/Headers;)V
    .locals 9
    .param p1, "headers"    # Lcom/squareup/okhttp/internal/http/Headers;

    .prologue
    .line 299
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 297
    invoke-static {}, Ljava/util/Collections;->emptySet()Ljava/util/Set;

    move-result-object v7

    iput-object v7, p0, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->varyFields:Ljava/util/Set;

    .line 300
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Headers;->size()I

    move-result v7

    if-ge v2, v7, :cond_3

    .line 301
    invoke-virtual {p1, v2}, Lcom/squareup/okhttp/internal/http/Headers;->name(I)Ljava/lang/String;

    move-result-object v1

    .line 302
    .local v1, "fieldName":Ljava/lang/String;
    invoke-virtual {p1, v2}, Lcom/squareup/okhttp/internal/http/Headers;->value(I)Ljava/lang/String;

    move-result-object v5

    .line 303
    .local v5, "value":Ljava/lang/String;
    const-string/jumbo v7, "Last-Modified"

    invoke-virtual {v7, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 304
    invoke-static {v5}, Lcom/squareup/okhttp/internal/http/HttpDate;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v7

    iput-object v7, p0, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->lastModified:Ljava/util/Date;

    .line 300
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 305
    :cond_1
    const-string/jumbo v7, "Vary"

    invoke-virtual {v7, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 307
    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->varyFields:Ljava/util/Set;

    invoke-interface {v7}, Ljava/util/Set;->isEmpty()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 308
    new-instance v7, Ljava/util/TreeSet;

    sget-object v8, Ljava/lang/String;->CASE_INSENSITIVE_ORDER:Ljava/util/Comparator;

    invoke-direct {v7, v8}, Ljava/util/TreeSet;-><init>(Ljava/util/Comparator;)V

    iput-object v7, p0, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->varyFields:Ljava/util/Set;

    .line 310
    :cond_2
    const-string/jumbo v7, ","

    invoke-virtual {v5, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_1
    if-ge v3, v4, :cond_0

    aget-object v6, v0, v3

    .line 311
    .local v6, "varyField":Ljava/lang/String;
    iget-object v7, p0, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->varyFields:Ljava/util/Set;

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 310
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 315
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "fieldName":Ljava/lang/String;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    .end local v5    # "value":Ljava/lang/String;
    .end local v6    # "varyField":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method synthetic constructor <init>(Lcom/squareup/okhttp/internal/http/Headers;Lcom/squareup/okhttp/internal/http/Response$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/squareup/okhttp/internal/http/Headers;
    .param p2, "x1"    # Lcom/squareup/okhttp/internal/http/Response$1;

    .prologue
    .line 292
    invoke-direct {p0, p1}, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;-><init>(Lcom/squareup/okhttp/internal/http/Headers;)V

    return-void
.end method

.method static synthetic access$700(Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;

    .prologue
    .line 292
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->varyFields:Ljava/util/Set;

    return-object v0
.end method
