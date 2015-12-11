.class public Lgm;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static a:Lgn;

.field private static final b:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lgm;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lgm;->b:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 163
    return-void
.end method

.method public static a()Lgn;
    .locals 1

    .prologue
    .line 65
    sget-object v0, Lgm;->a:Lgn;

    return-object v0
.end method

.method private static a(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 276
    .line 277
    invoke-static {p0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->loadOffersData(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    .line 278
    return-object v0
.end method

.method public static a(Lft;)V
    .locals 1

    .prologue
    .line 53
    sget-object v0, Lft;->a:Lft;

    if-ne p0, v0, :cond_0

    .line 54
    sget-object v0, Lgn;->a:Lgn;

    sput-object v0, Lgm;->a:Lgn;

    .line 62
    :goto_0
    return-void

    .line 55
    :cond_0
    sget-object v0, Lft;->e:Lft;

    if-eq p0, v0, :cond_1

    sget-object v0, Lft;->g:Lft;

    if-eq p0, v0, :cond_1

    sget-object v0, Lft;->h:Lft;

    if-ne p0, v0, :cond_2

    .line 56
    :cond_1
    sget-object v0, Lgn;->b:Lgn;

    sput-object v0, Lgm;->a:Lgn;

    goto :goto_0

    .line 57
    :cond_2
    sget-object v0, Lft;->l:Lft;

    if-ne p0, v0, :cond_3

    .line 58
    sget-object v0, Lgn;->c:Lgn;

    sput-object v0, Lgm;->a:Lgn;

    goto :goto_0

    .line 60
    :cond_3
    sget-object v0, Lgn;->a:Lgn;

    sput-object v0, Lgm;->a:Lgn;

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 47
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lgn;->a(Ljava/lang/String;)Lgn;

    move-result-object v0

    .line 48
    iput-object p1, v0, Lgn;->e:Ljava/lang/String;

    .line 49
    iput-object p0, v0, Lgn;->d:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public static b()Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 232
    const-string v0, ""

    .line 233
    invoke-static {}, Lgm;->a()Lgn;

    move-result-object v0

    .line 234
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, v0, Lgn;->d:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/api/v1/offer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 235
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 236
    const-string v3, "api_key"

    iget-object v0, v0, Lgn;->e:Ljava/lang/String;

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 237
    const-string v0, "channel_key"

    const-string v3, "bby-mobile-app-promo-banner"

    invoke-interface {v2, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 239
    const/4 v0, 0x0

    :try_start_0
    invoke-static {v1, v0, v2}, Lgw;->a(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    .line 240
    invoke-static {v0}, Lgm;->a(Ljava/lang/String;)Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 241
    :catch_0
    move-exception v0

    .line 242
    sget-object v1, Lgm;->b:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not get SKU Based Offers: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 243
    throw v0
.end method

.method private static b(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 287
    .line 288
    invoke-static {p0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->loadOffersData(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    .line 289
    return-object v0
.end method

.method public static c()Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 254
    const-string v0, ""

    .line 255
    invoke-static {}, Lgm;->a()Lgn;

    move-result-object v0

    .line 256
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, v0, Lgn;->d:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/api/v1/offer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 257
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 258
    const-string v3, "api_key"

    iget-object v0, v0, Lgn;->e:Ljava/lang/String;

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 259
    const-string v0, "channel_key"

    const-string v3, "life-events"

    invoke-interface {v2, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 260
    const-string v0, "priority="

    const-string v3, "true"

    invoke-interface {v2, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 262
    const/4 v0, 0x0

    :try_start_0
    invoke-static {v1, v0, v2}, Lgw;->a(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    .line 263
    invoke-static {v0}, Lgm;->b(Ljava/lang/String;)Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 264
    :catch_0
    move-exception v0

    .line 265
    sget-object v1, Lgm;->b:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not get SKU Based Offers: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 266
    throw v0
.end method
