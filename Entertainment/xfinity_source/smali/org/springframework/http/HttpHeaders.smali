.class public Lorg/springframework/http/HttpHeaders;
.super Ljava/lang/Object;
.source "HttpHeaders.java"

# interfaces
.implements Lorg/springframework/util/MultiValueMap;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lorg/springframework/util/MultiValueMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# static fields
.field private static final DATE_FORMATS:[Ljava/lang/String;

.field private static GMT:Ljava/util/TimeZone;


# instance fields
.field private final headers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 99
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "EEE, dd MMM yyyy HH:mm:ss zzz"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "EEE, dd-MMM-yy HH:mm:ss zzz"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "EEE MMM dd HH:mm:ss yyyy"

    aput-object v2, v0, v1

    sput-object v0, Lorg/springframework/http/HttpHeaders;->DATE_FORMATS:[Ljava/lang/String;

    .line 105
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    sput-object v0, Lorg/springframework/http/HttpHeaders;->GMT:Ljava/util/TimeZone;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    .line 133
    new-instance v0, Lorg/springframework/util/LinkedCaseInsensitiveMap;

    const/16 v1, 0x8

    sget-object v2, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Lorg/springframework/util/LinkedCaseInsensitiveMap;-><init>(ILjava/util/Locale;)V

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lorg/springframework/http/HttpHeaders;-><init>(Ljava/util/Map;Z)V

    .line 134
    return-void
.end method

.method private constructor <init>(Ljava/util/Map;Z)V
    .locals 6
    .param p2, "readOnly"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;Z)V"
        }
    .end annotation

    .prologue
    .line 113
    .local p1, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 114
    const-string v4, "\'headers\' must not be null"

    invoke-static {p1, v4}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 115
    if-eqz p2, :cond_1

    .line 116
    new-instance v2, Lorg/springframework/util/LinkedCaseInsensitiveMap;

    invoke-interface {p1}, Ljava/util/Map;->size()I

    move-result v4

    sget-object v5, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v2, v4, v5}, Lorg/springframework/util/LinkedCaseInsensitiveMap;-><init>(ILjava/util/Locale;)V

    .line 118
    .local v2, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 119
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    .line 120
    .local v3, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v2, v4, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 122
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v3    # "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    invoke-static {v2}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v4

    iput-object v4, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    .line 127
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    :goto_1
    return-void

    .line 125
    :cond_1
    iput-object p1, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    goto :goto_1
.end method

.method public static readOnlyHttpHeaders(Lorg/springframework/http/HttpHeaders;)Lorg/springframework/http/HttpHeaders;
    .locals 2
    .param p0, "headers"    # Lorg/springframework/http/HttpHeaders;

    .prologue
    .line 140
    new-instance v0, Lorg/springframework/http/HttpHeaders;

    const/4 v1, 0x1

    invoke-direct {v0, p0, v1}, Lorg/springframework/http/HttpHeaders;-><init>(Ljava/util/Map;Z)V

    return-object v0
.end method


# virtual methods
.method public bridge synthetic add(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 56
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p2, Ljava/lang/String;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lorg/springframework/http/HttpHeaders;->add(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public add(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "headerName"    # Ljava/lang/String;
    .param p2, "headerValue"    # Ljava/lang/String;

    .prologue
    .line 622
    iget-object v1, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 623
    .local v0, "headerValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez v0, :cond_0

    .line 624
    new-instance v0, Ljava/util/LinkedList;

    .end local v0    # "headerValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    .line 625
    .restart local v0    # "headerValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v1, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 627
    :cond_0
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 628
    return-void
.end method

.method public clear()V
    .locals 1

    .prologue
    .line 693
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 694
    return-void
.end method

.method public containsKey(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;

    .prologue
    .line 669
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public containsValue(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 673
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsValue(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public entrySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/util/Map$Entry",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;>;"
        }
    .end annotation

    .prologue
    .line 705
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "other"    # Ljava/lang/Object;

    .prologue
    .line 711
    if-ne p0, p1, :cond_0

    .line 712
    const/4 v1, 0x1

    .line 718
    :goto_0
    return v1

    .line 714
    :cond_0
    instance-of v1, p1, Lorg/springframework/http/HttpHeaders;

    if-nez v1, :cond_1

    .line 715
    const/4 v1, 0x0

    goto :goto_0

    :cond_1
    move-object v0, p1

    .line 717
    check-cast v0, Lorg/springframework/http/HttpHeaders;

    .line 718
    .local v0, "otherHeaders":Lorg/springframework/http/HttpHeaders;
    iget-object v1, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    iget-object v2, v0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-virtual {v1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method

.method public bridge synthetic get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 56
    invoke-virtual {p0, p1}, Lorg/springframework/http/HttpHeaders;->get(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public get(Ljava/lang/Object;)Ljava/util/List;
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 677
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public getContentEncoding()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lorg/springframework/http/ContentCodingType;",
            ">;"
        }
    .end annotation

    .prologue
    .line 348
    const-string v1, "Content-Encoding"

    invoke-virtual {p0, v1}, Lorg/springframework/http/HttpHeaders;->getFirst(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 349
    .local v0, "value":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lorg/springframework/http/ContentCodingType;->parseCodingTypes(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v1

    goto :goto_0
.end method

.method public getContentLength()J
    .locals 4

    .prologue
    .line 366
    const-string v1, "Content-Length"

    invoke-virtual {p0, v1}, Lorg/springframework/http/HttpHeaders;->getFirst(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 367
    .local v0, "value":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    :goto_0
    return-wide v2

    :cond_0
    const-wide/16 v2, -0x1

    goto :goto_0
.end method

.method public getContentType()Lorg/springframework/http/MediaType;
    .locals 2

    .prologue
    .line 386
    const-string v1, "Content-Type"

    invoke-virtual {p0, v1}, Lorg/springframework/http/HttpHeaders;->getFirst(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 387
    .local v0, "value":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lorg/springframework/http/MediaType;->parseMediaType(Ljava/lang/String;)Lorg/springframework/http/MediaType;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getFirst(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "headerName"    # Ljava/lang/String;

    .prologue
    .line 609
    iget-object v1, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 610
    .local v0, "headerValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 723
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 665
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public keySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 697
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 56
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p2, Ljava/util/List;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lorg/springframework/http/HttpHeaders;->put(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public put(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 681
    .local p2, "value":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public putAll(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<+",
            "Ljava/lang/String;",
            "+",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 689
    .local p1, "m":Ljava/util/Map;, "Ljava/util/Map<+Ljava/lang/String;+Ljava/util/List<Ljava/lang/String;>;>;"
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 690
    return-void
.end method

.method public bridge synthetic remove(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 56
    invoke-virtual {p0, p1}, Lorg/springframework/http/HttpHeaders;->remove(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public remove(Ljava/lang/Object;)Ljava/util/List;
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 685
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public set(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "headerName"    # Ljava/lang/String;
    .param p2, "headerValue"    # Ljava/lang/String;

    .prologue
    .line 639
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    .line 640
    .local v0, "headerValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 641
    iget-object v1, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 642
    return-void
.end method

.method public setAccept(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/springframework/http/MediaType;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 148
    .local p1, "acceptableMediaTypes":Ljava/util/List;, "Ljava/util/List<Lorg/springframework/http/MediaType;>;"
    const-string v0, "Accept"

    invoke-static {p1}, Lorg/springframework/http/MediaType;->toString(Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lorg/springframework/http/HttpHeaders;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    return-void
.end method

.method public setAcceptCharset(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/nio/charset/Charset;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 166
    .local p1, "acceptableCharsets":Ljava/util/List;, "Ljava/util/List<Ljava/nio/charset/Charset;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 167
    .local v0, "builder":Ljava/lang/StringBuilder;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/nio/charset/Charset;>;"
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 168
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/nio/charset/Charset;

    .line 169
    .local v1, "charset":Ljava/nio/charset/Charset;
    invoke-virtual {v1}, Ljava/nio/charset/Charset;->name()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v3, v4}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 170
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 171
    const-string v3, ", "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 174
    .end local v1    # "charset":Ljava/nio/charset/Charset;
    :cond_1
    const-string v3, "Accept-Charset"

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lorg/springframework/http/HttpHeaders;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    return-void
.end method

.method public setContentDispositionFormData(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "filename"    # Ljava/lang/String;

    .prologue
    const/16 v2, 0x22

    .line 314
    const-string v1, "\'name\' must not be null"

    invoke-static {p1, v1}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 315
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "form-data; name=\""

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 316
    .local v0, "builder":Ljava/lang/StringBuilder;
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 317
    if-eqz p2, :cond_0

    .line 318
    const-string v1, "; filename=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 319
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 321
    :cond_0
    const-string v1, "Content-Disposition"

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lorg/springframework/http/HttpHeaders;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 322
    return-void
.end method

.method public setContentLength(J)V
    .locals 3
    .param p1, "contentLength"    # J

    .prologue
    .line 357
    const-string v0, "Content-Length"

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lorg/springframework/http/HttpHeaders;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    return-void
.end method

.method public setContentType(Lorg/springframework/http/MediaType;)V
    .locals 4
    .param p1, "mediaType"    # Lorg/springframework/http/MediaType;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 375
    invoke-virtual {p1}, Lorg/springframework/http/MediaType;->isWildcardType()Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    const-string v3, "\'Content-Type\' cannot contain wildcard type \'*\'"

    invoke-static {v0, v3}, Lorg/springframework/util/Assert;->isTrue(ZLjava/lang/String;)V

    .line 376
    invoke-virtual {p1}, Lorg/springframework/http/MediaType;->isWildcardSubtype()Z

    move-result v0

    if-nez v0, :cond_1

    :goto_1
    const-string v0, "\'Content-Type\' cannot contain wildcard subtype \'*\'"

    invoke-static {v1, v0}, Lorg/springframework/util/Assert;->isTrue(ZLjava/lang/String;)V

    .line 377
    const-string v0, "Content-Type"

    invoke-virtual {p1}, Lorg/springframework/http/MediaType;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lorg/springframework/http/HttpHeaders;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 378
    return-void

    :cond_0
    move v0, v2

    .line 375
    goto :goto_0

    :cond_1
    move v1, v2

    .line 376
    goto :goto_1
.end method

.method public size()I
    .locals 1

    .prologue
    .line 661
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 728
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public values()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 701
    iget-object v0, p0, Lorg/springframework/http/HttpHeaders;->headers:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method
