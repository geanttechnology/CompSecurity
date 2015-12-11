.class public Lcom/poshmark/utils/StringUtils;
.super Ljava/lang/Object;
.source "StringUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/StringUtils$ListingDetailsSerializer;,
        Lcom/poshmark/utils/StringUtils$ListingDetailsDeserializer;,
        Lcom/poshmark/utils/StringUtils$UriSerializer;,
        Lcom/poshmark/utils/StringUtils$UriDeserializer;
    }
.end annotation


# static fields
.field private static final NON_THIN:Ljava/lang/String; = "[^iIl1\\.,\']"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 216
    return-void
.end method

.method public static abbreviatedStringRepresentationOfNumber(I)Ljava/lang/String;
    .locals 11
    .param p0, "number"    # I

    .prologue
    const/high16 v10, 0x41200000    # 10.0f

    const/4 v8, 0x1

    const/4 v9, 0x0

    const/high16 v7, 0x447a0000    # 1000.0f

    .line 36
    const-string v0, "0"

    .line 37
    .local v0, "numberString":Ljava/lang/String;
    if-gtz p0, :cond_0

    move-object v1, v0

    .line 60
    .end local v0    # "numberString":Ljava/lang/String;
    .local v1, "numberString":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 40
    .end local v1    # "numberString":Ljava/lang/String;
    .restart local v0    # "numberString":Ljava/lang/String;
    :cond_0
    int-to-float v6, p0

    div-float v2, v6, v7

    .line 41
    .local v2, "quotient":F
    cmpl-float v6, v2, v10

    if-ltz v6, :cond_1

    cmpg-float v6, v2, v7

    if-gez v6, :cond_1

    .line 43
    const-string v6, "%dk"

    new-array v7, v8, [Ljava/lang/Object;

    float-to-int v8, v2

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :goto_1
    move-object v1, v0

    .line 60
    .end local v0    # "numberString":Ljava/lang/String;
    .restart local v1    # "numberString":Ljava/lang/String;
    goto :goto_0

    .line 45
    .end local v1    # "numberString":Ljava/lang/String;
    .restart local v0    # "numberString":Ljava/lang/String;
    :cond_1
    cmpl-float v6, v2, v7

    if-ltz v6, :cond_3

    .line 47
    div-float v4, v2, v7

    .line 48
    .local v4, "secondaryQuotient":F
    mul-float v6, v4, v10

    div-float v5, v6, v10

    .line 49
    .local v5, "temp":F
    float-to-int v6, v5

    int-to-float v6, v6

    sub-float v3, v5, v6

    .line 51
    .local v3, "result":F
    const/4 v6, 0x0

    cmpl-float v6, v3, v6

    if-eqz v6, :cond_2

    .line 52
    const-string v6, "%.1fm"

    new-array v7, v8, [Ljava/lang/Object;

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 54
    :cond_2
    const-string v6, "%dm"

    new-array v7, v8, [Ljava/lang/Object;

    float-to-int v8, v5

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 58
    .end local v3    # "result":F
    .end local v4    # "secondaryQuotient":F
    .end local v5    # "temp":F
    :cond_3
    const-string v6, "%d"

    new-array v7, v8, [Ljava/lang/Object;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public static ellipsize(Ljava/lang/String;I)Ljava/lang/String;
    .locals 7
    .param p0, "text"    # Ljava/lang/String;
    .param p1, "max"    # I

    .prologue
    const/16 v6, 0x20

    const/4 v5, -0x1

    const/4 v4, 0x0

    .line 69
    invoke-static {p0}, Lcom/poshmark/utils/StringUtils;->textWidth(Ljava/lang/String;)I

    move-result v2

    if-gt v2, p1, :cond_0

    .line 92
    .end local p0    # "text":Ljava/lang/String;
    :goto_0
    return-object p0

    .line 74
    .restart local p0    # "text":Ljava/lang/String;
    :cond_0
    add-int/lit8 v2, p1, -0x3

    invoke-virtual {p0, v6, v2}, Ljava/lang/String;->lastIndexOf(II)I

    move-result v0

    .line 77
    .local v0, "end":I
    if-ne v0, v5, :cond_1

    .line 78
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    add-int/lit8 v3, p1, -0x3

    invoke-virtual {p0, v4, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "..."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 81
    :cond_1
    move v1, v0

    .line 83
    .local v1, "newEnd":I
    :cond_2
    move v0, v1

    .line 84
    add-int/lit8 v2, v0, 0x1

    invoke-virtual {p0, v6, v2}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    .line 87
    if-ne v1, v5, :cond_3

    .line 88
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    .line 90
    :cond_3
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0, v4, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "..."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/utils/StringUtils;->textWidth(Ljava/lang/String;)I

    move-result v2

    if-lt v2, p1, :cond_2

    .line 92
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0, v4, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "..."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0
.end method

.method public static fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;
    .locals 3
    .param p0, "json"    # Ljava/lang/String;
    .param p1, "listOfObject"    # Lcom/google/gson/reflect/TypeToken;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Lcom/google/gson/reflect/TypeToken;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 120
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    .line 121
    .local v0, "gson":Lcom/google/gson/Gson;
    invoke-virtual {p1}, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    instance-of v2, v0, Lcom/google/gson/Gson;

    if-nez v2, :cond_0

    invoke-virtual {v0, p0, v1}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    .end local v0    # "gson":Lcom/google/gson/Gson;
    :goto_0
    return-object v1

    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, p0, v1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method public static fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
    .param p0, "jsonStr"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 114
    .local p1, "cl":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    .line 115
    .local v0, "gson":Lcom/google/gson/Gson;
    instance-of v2, v0, Lcom/google/gson/Gson;

    if-nez v2, :cond_0

    invoke-virtual {v0, p0, p1}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    .line 116
    .end local v0    # "gson":Lcom/google/gson/Gson;
    .local v1, "o":Ljava/lang/Object;, "TT;"
    :goto_0
    return-object v1

    .line 115
    .end local v1    # "o":Ljava/lang/Object;, "TT;"
    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, p0, p1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method public static imageListFromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/util/List;
    .locals 4
    .param p0, "json"    # Ljava/lang/String;
    .param p1, "listOfObject"    # Lcom/google/gson/reflect/TypeToken;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/google/gson/reflect/TypeToken;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Picture;",
            ">;"
        }
    .end annotation

    .prologue
    .line 134
    new-instance v1, Lcom/google/gson/GsonBuilder;

    invoke-direct {v1}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-class v2, Landroid/net/Uri;

    new-instance v3, Lcom/poshmark/utils/StringUtils$UriDeserializer;

    invoke-direct {v3}, Lcom/poshmark/utils/StringUtils$UriDeserializer;-><init>()V

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/GsonBuilder;->registerTypeAdapter(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v0

    .line 138
    .local v0, "gson":Lcom/google/gson/Gson;
    invoke-virtual {p1}, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    instance-of v2, v0, Lcom/google/gson/Gson;

    if-nez v2, :cond_0

    invoke-virtual {v0, p0, v1}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    .end local v0    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v1, Ljava/util/List;

    return-object v1

    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, p0, v1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method public static imageListToJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;
    .locals 5
    .param p1, "listOfObject"    # Ljava/lang/reflect/Type;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<*>;",
            "Ljava/lang/reflect/Type;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 125
    .local p0, "list":Ljava/util/List;, "Ljava/util/List<*>;"
    new-instance v2, Lcom/google/gson/GsonBuilder;

    invoke-direct {v2}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-class v3, Landroid/net/Uri;

    new-instance v4, Lcom/poshmark/utils/StringUtils$UriSerializer;

    invoke-direct {v4}, Lcom/poshmark/utils/StringUtils$UriSerializer;-><init>()V

    invoke-virtual {v2, v3, v4}, Lcom/google/gson/GsonBuilder;->registerTypeAdapter(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v0

    .line 129
    .local v0, "gson":Lcom/google/gson/Gson;
    instance-of v2, v0, Lcom/google/gson/Gson;

    if-nez v2, :cond_0

    invoke-virtual {v0, p0, p1}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    .line 130
    .end local v0    # "gson":Lcom/google/gson/Gson;
    .local v1, "json":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 129
    .end local v1    # "json":Ljava/lang/String;
    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, p0, p1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "seperator"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 226
    .local p0, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p0, p1}, Lorg/apache/commons/lang3/StringUtils;->join(Ljava/lang/Iterable;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static listingDetailsFromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/util/List;
    .locals 4
    .param p0, "json"    # Ljava/lang/String;
    .param p1, "listOfObject"    # Lcom/google/gson/reflect/TypeToken;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/google/gson/reflect/TypeToken;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Picture;",
            ">;"
        }
    .end annotation

    .prologue
    .line 151
    new-instance v1, Lcom/google/gson/GsonBuilder;

    invoke-direct {v1}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-class v2, Landroid/net/Uri;

    new-instance v3, Lcom/poshmark/utils/StringUtils$UriDeserializer;

    invoke-direct {v3}, Lcom/poshmark/utils/StringUtils$UriDeserializer;-><init>()V

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/GsonBuilder;->registerTypeAdapter(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v0

    .line 155
    .local v0, "gson":Lcom/google/gson/Gson;
    invoke-virtual {p1}, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    instance-of v2, v0, Lcom/google/gson/Gson;

    if-nez v2, :cond_0

    invoke-virtual {v0, p0, v1}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    .end local v0    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v1, Ljava/util/List;

    return-object v1

    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, p0, v1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method public static listingDetailsToJson(Lcom/poshmark/data_model/models/ListingDetails;Ljava/lang/reflect/Type;)Ljava/lang/String;
    .locals 5
    .param p0, "details"    # Lcom/poshmark/data_model/models/ListingDetails;
    .param p1, "listOfObject"    # Ljava/lang/reflect/Type;

    .prologue
    .line 142
    new-instance v2, Lcom/google/gson/GsonBuilder;

    invoke-direct {v2}, Lcom/google/gson/GsonBuilder;-><init>()V

    const-class v3, Landroid/net/Uri;

    new-instance v4, Lcom/poshmark/utils/StringUtils$UriSerializer;

    invoke-direct {v4}, Lcom/poshmark/utils/StringUtils$UriSerializer;-><init>()V

    invoke-virtual {v2, v3, v4}, Lcom/google/gson/GsonBuilder;->registerTypeAdapter(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v0

    .line 146
    .local v0, "gson":Lcom/google/gson/Gson;
    const-class v2, Lcom/poshmark/data_model/models/ListingDetails;

    instance-of v3, v0, Lcom/google/gson/Gson;

    if-nez v3, :cond_0

    invoke-virtual {v0, p0, v2}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    .line 147
    .end local v0    # "gson":Lcom/google/gson/Gson;
    .local v1, "json":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 146
    .end local v1    # "json":Ljava/lang/String;
    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, p0, v2}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method private static textWidth(Ljava/lang/String;)I
    .locals 3
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const-string v1, "[^iIl1\\.,\']"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    return v0
.end method

.method public static toJson(Lcom/poshmark/data_model/models/MetaItem;Ljava/lang/reflect/Type;)Ljava/lang/String;
    .locals 3
    .param p0, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;
    .param p1, "listOfObject"    # Ljava/lang/reflect/Type;

    .prologue
    .line 108
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    .line 109
    .local v0, "gson":Lcom/google/gson/Gson;
    instance-of v2, v0, Lcom/google/gson/Gson;

    if-nez v2, :cond_0

    invoke-virtual {v0, p0, p1}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    .line 110
    .end local v0    # "gson":Lcom/google/gson/Gson;
    .local v1, "json":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 109
    .end local v1    # "json":Ljava/lang/String;
    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, p0, p1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static toJson(Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p0, "o"    # Ljava/lang/Object;

    .prologue
    .line 96
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    .line 97
    .local v0, "gson":Lcom/google/gson/Gson;
    instance-of v2, v0, Lcom/google/gson/Gson;

    if-nez v2, :cond_0

    invoke-virtual {v0, p0}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 98
    .end local v0    # "gson":Lcom/google/gson/Gson;
    .local v1, "json":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 97
    .end local v1    # "json":Ljava/lang/String;
    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, p0}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;
    .locals 3
    .param p1, "listOfObject"    # Ljava/lang/reflect/Type;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<*>;",
            "Ljava/lang/reflect/Type;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 102
    .local p0, "list":Ljava/util/List;, "Ljava/util/List<*>;"
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    .line 103
    .local v0, "gson":Lcom/google/gson/Gson;
    instance-of v2, v0, Lcom/google/gson/Gson;

    if-nez v2, :cond_0

    invoke-virtual {v0, p0, p1}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    .line 104
    .end local v0    # "gson":Lcom/google/gson/Gson;
    .local v1, "json":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 103
    .end local v1    # "json":Ljava/lang/String;
    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, p0, p1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static toJson(Ljava/util/Map;Ljava/lang/reflect/Type;)Ljava/lang/String;
    .locals 3
    .param p1, "mapContentType"    # Ljava/lang/reflect/Type;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/poshmark/webcommands/WebCommand;",
            ">;",
            "Ljava/lang/reflect/Type;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 171
    .local p0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Lcom/poshmark/webcommands/WebCommand;>;"
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    .line 172
    .local v0, "gson":Lcom/google/gson/Gson;
    instance-of v2, v0, Lcom/google/gson/Gson;

    if-nez v2, :cond_0

    invoke-virtual {v0, p0, p1}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    .line 173
    .end local v0    # "gson":Lcom/google/gson/Gson;
    .local v1, "json":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 172
    .end local v1    # "json":Ljava/lang/String;
    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, p0, p1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static urlEncode(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 231
    :try_start_0
    const-string v1, "UTF-8"

    invoke-static {p0, v1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 234
    :goto_0
    return-object v1

    .line 232
    :catch_0
    move-exception v0

    .line 233
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, ""

    const-string v2, "UTF-8 should always be supported"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 234
    const-string v1, ""

    goto :goto_0
.end method
