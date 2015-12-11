.class public Lfu;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static a:Lfv;

.field private static b:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-class v0, Lfu;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lfu;->b:Ljava/lang/String;

    .line 37
    sget-object v0, Lfv;->a:Lfv;

    sput-object v0, Lfu;->a:Lfv;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 692
    return-void
.end method

.method public static a()Lfv;
    .locals 1

    .prologue
    .line 86
    sget-object v0, Lfu;->a:Lfv;

    return-object v0
.end method

.method public static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 5

    .prologue
    .line 124
    const-string v0, ""

    .line 125
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lfu;->a:Lfv;

    iget-object v2, v2, Lfv;->c:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/products(upc="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&active=*&marketplace=*)"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 127
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 128
    const-string v3, "format"

    const-string v4, "json"

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 129
    const-string v3, "show"

    const-string v4, "all"

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 130
    const-string v3, "apiKey"

    sget-object v4, Lfu;->a:Lfv;

    iget-object v4, v4, Lfv;->d:Ljava/lang/String;

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    const/4 v3, 0x0

    :try_start_0
    invoke-static {v1, v3, v2}, Lgw;->a(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 136
    :goto_0
    return-object v0

    .line 133
    :catch_0
    move-exception v1

    .line 134
    sget-object v2, Lfu;->b:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not get getProductDetailsUsingUPCCode: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static a(Lft;)V
    .locals 1

    .prologue
    .line 71
    sget-object v0, Lft;->a:Lft;

    if-ne p0, v0, :cond_0

    .line 72
    sget-object v0, Lfv;->a:Lfv;

    sput-object v0, Lfu;->a:Lfv;

    .line 78
    :goto_0
    return-void

    .line 73
    :cond_0
    sget-object v0, Lft;->l:Lft;

    if-ne p0, v0, :cond_1

    .line 74
    sget-object v0, Lfv;->b:Lfv;

    sput-object v0, Lfu;->a:Lfv;

    goto :goto_0

    .line 76
    :cond_1
    sget-object v0, Lfv;->a:Lfv;

    sput-object v0, Lfu;->a:Lfv;

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 56
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lfv;->a(Ljava/lang/String;)Lfv;

    move-result-object v0

    .line 57
    iput-object p1, v0, Lfv;->d:Ljava/lang/String;

    .line 58
    iput-object p0, v0, Lfv;->c:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public static b(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/remix/Store;
    .locals 5

    .prologue
    .line 771
    const-string v0, ""

    .line 772
    invoke-static {}, Lfu;->a()Lfv;

    move-result-object v0

    .line 773
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, v0, Lfv;->c:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/stores(storeId="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 775
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 776
    const-string v3, "format"

    const-string v4, "json"

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 777
    const-string v3, "show"

    const-string v4, "all"

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 778
    const-string v3, "page"

    const-string v4, "1"

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 779
    const-string v3, "apiKey"

    iget-object v0, v0, Lfv;->d:Ljava/lang/String;

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 781
    const/4 v0, 0x0

    :try_start_0
    invoke-static {v1, v0, v2}, Lgw;->a(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 786
    invoke-static {v0}, Lfu;->c(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/remix/Store;

    move-result-object v0

    return-object v0

    .line 782
    :catch_0
    move-exception v0

    .line 783
    sget-object v1, Lfu;->b:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not get Full Product Detail by Sku: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 784
    throw v0
.end method

.method private static c(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/remix/Store;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 790
    if-nez p0, :cond_1

    .line 799
    :cond_0
    :goto_0
    return-object v0

    .line 793
    :cond_1
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 794
    const-string v2, "stores"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 795
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 796
    new-instance v0, Lcom/bestbuy/android/api/lib/models/remix/Store;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/bestbuy/android/api/lib/models/remix/Store;-><init>(Lorg/json/JSONObject;)V

    goto :goto_0
.end method
