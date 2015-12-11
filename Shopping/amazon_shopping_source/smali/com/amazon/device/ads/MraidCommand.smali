.class abstract Lcom/amazon/device/ads/MraidCommand;
.super Ljava/lang/Object;
.source "MraidCommand.java"


# instance fields
.field protected mParams:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected mView:Lcom/amazon/device/ads/MraidView;


# direct methods
.method constructor <init>(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)V
    .locals 0
    .param p2, "view"    # Lcom/amazon/device/ads/MraidView;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/device/ads/MraidView;",
            ")V"
        }
    .end annotation

    .prologue
    .line 22
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/amazon/device/ads/MraidCommand;->mParams:Ljava/util/Map;

    .line 24
    iput-object p2, p0, Lcom/amazon/device/ads/MraidCommand;->mView:Lcom/amazon/device/ads/MraidView;

    .line 25
    return-void
.end method


# virtual methods
.method abstract execute()V
.end method

.method protected getBooleanFromParamsForKey(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 58
    const-string/jumbo v0, "true"

    iget-object v1, p0, Lcom/amazon/device/ads/MraidCommand;->mParams:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method protected getFloatFromParamsForKey(Ljava/lang/String;)F
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 46
    iget-object v3, p0, Lcom/amazon/device/ads/MraidCommand;->mParams:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 47
    .local v1, "s":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 52
    :goto_0
    return v2

    .line 50
    :cond_0
    :try_start_0
    invoke-static {p1}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    goto :goto_0

    .line 51
    :catch_0
    move-exception v0

    .line 52
    .local v0, "e":Ljava/lang/NumberFormatException;
    goto :goto_0
.end method

.method protected getIntArrayFromParamsForKey(Ljava/lang/String;)[Ljava/lang/Integer;
    .locals 9
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 62
    iget-object v8, p0, Lcom/amazon/device/ads/MraidCommand;->mParams:Ljava/util/Map;

    invoke-interface {v8, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 63
    .local v5, "s":Ljava/lang/String;
    if-nez v5, :cond_0

    const/4 v8, 0x0

    .line 75
    :goto_0
    return-object v8

    .line 65
    :cond_0
    const-string/jumbo v8, ","

    invoke-virtual {v5, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 66
    .local v6, "sv":[Ljava/lang/String;
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 67
    .local v4, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    move-object v0, v6

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_1
    if-ge v2, v3, :cond_1

    aget-object v7, v0, v2

    .line 69
    .local v7, "v":Ljava/lang/String;
    const/16 v8, 0xa

    :try_start_0
    invoke-static {v7, v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v4, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 67
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 71
    :catch_0
    move-exception v1

    .line 72
    .local v1, "e":Ljava/lang/NumberFormatException;
    const/4 v8, -0x1

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v4, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 75
    .end local v1    # "e":Ljava/lang/NumberFormatException;
    .end local v7    # "v":Ljava/lang/String;
    :cond_1
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v8

    new-array v8, v8, [Ljava/lang/Integer;

    invoke-virtual {v4, v8}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v8

    check-cast v8, [Ljava/lang/Integer;

    goto :goto_0
.end method

.method protected getIntFromParamsForKey(Ljava/lang/String;)I
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v2, -0x1

    .line 30
    iget-object v3, p0, Lcom/amazon/device/ads/MraidCommand;->mParams:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 31
    .local v1, "s":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 36
    :goto_0
    return v2

    .line 34
    :cond_0
    const/16 v3, 0xa

    :try_start_0
    invoke-static {v1, v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    goto :goto_0

    .line 35
    :catch_0
    move-exception v0

    .line 36
    .local v0, "e":Ljava/lang/NumberFormatException;
    goto :goto_0
.end method

.method protected getStringFromParamsForKey(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/device/ads/MraidCommand;->mParams:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method
