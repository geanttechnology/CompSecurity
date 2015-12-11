.class public Lgd;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static a:Lge;

.field private static final b:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lgd;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lgd;->b:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    return-void
.end method

.method public static a(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;
    .locals 4

    .prologue
    .line 145
    const-string v0, ""

    .line 146
    invoke-static {}, Lgd;->a()Lge;

    move-result-object v0

    .line 147
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, v0, Lge;->d:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/stats/top_deals/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 148
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 149
    const-string v3, "api_key"

    iget-object v0, v0, Lge;->e:Ljava/lang/String;

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 151
    const/4 v0, 0x0

    :try_start_0
    invoke-static {v1, v0, v2}, Lgw;->a(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    .line 152
    invoke-static {v0}, Lgd;->b(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 153
    :catch_0
    move-exception v0

    .line 154
    sget-object v1, Lgd;->b:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error making GET request: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    throw v0
.end method

.method public static a()Lge;
    .locals 1

    .prologue
    .line 74
    sget-object v0, Lgd;->a:Lge;

    return-object v0
.end method

.method public static a(Lft;)V
    .locals 1

    .prologue
    .line 55
    sget-object v0, Lft;->a:Lft;

    if-ne p0, v0, :cond_0

    .line 56
    sget-object v0, Lge;->a:Lge;

    sput-object v0, Lgd;->a:Lge;

    .line 64
    :goto_0
    return-void

    .line 57
    :cond_0
    sget-object v0, Lft;->b:Lft;

    if-ne p0, v0, :cond_1

    .line 58
    sget-object v0, Lge;->b:Lge;

    sput-object v0, Lgd;->a:Lge;

    goto :goto_0

    .line 59
    :cond_1
    sget-object v0, Lft;->l:Lft;

    if-ne p0, v0, :cond_2

    .line 60
    sget-object v0, Lge;->c:Lge;

    sput-object v0, Lgd;->a:Lge;

    goto :goto_0

    .line 62
    :cond_2
    sget-object v0, Lge;->a:Lge;

    sput-object v0, Lgd;->a:Lge;

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 49
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lge;->a(Ljava/lang/String;)Lge;

    move-result-object v0

    .line 50
    iput-object p1, v0, Lge;->e:Ljava/lang/String;

    .line 51
    iput-object p0, v0, Lge;->d:Ljava/lang/String;

    .line 52
    return-void
.end method

.method private static b(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;
    .locals 13

    .prologue
    const/4 v1, 0x0

    .line 170
    new-instance v3, Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;-><init>()V

    .line 171
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 172
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 173
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 174
    if-eqz v4, :cond_4

    .line 175
    invoke-virtual {v4}, Lorg/json/JSONObject;->names()Lorg/json/JSONArray;

    move-result-object v7

    .line 176
    if-eqz v7, :cond_4

    move v0, v1

    .line 177
    :goto_0
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_3

    .line 178
    invoke-virtual {v7, v0}, Lorg/json/JSONArray;->isNull(I)Z

    move-result v2

    if-nez v2, :cond_2

    .line 179
    invoke-virtual {v7, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 180
    const-string v2, "categories"

    invoke-virtual {v8, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 181
    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v9

    .line 182
    if-eqz v9, :cond_1

    .line 183
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    move v2, v1

    .line 184
    :goto_1
    invoke-virtual {v9}, Lorg/json/JSONArray;->length()I

    move-result v11

    if-ge v2, v11, :cond_0

    .line 185
    invoke-virtual {v9, v2}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v11

    const-string v12, "sku"

    invoke-virtual {v11, v12}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 184
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 188
    :cond_0
    invoke-interface {v6, v8, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 190
    :cond_1
    invoke-virtual {v5, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 177
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 194
    :cond_3
    invoke-virtual {v3, v6}, Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;->setDeals(Ljava/util/Map;)V

    .line 195
    invoke-virtual {v3, v5}, Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;->setCategories(Ljava/util/ArrayList;)V

    .line 198
    :cond_4
    return-object v3
.end method
