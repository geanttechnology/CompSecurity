.class public Lcom/xfinity/playerlib/model/EditorialMovie;
.super Lcom/xfinity/playerlib/model/EditorialProgram;
.source "EditorialMovie.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/EditorialProgram;-><init>()V

    return-void
.end method


# virtual methods
.method public getMerlinIdNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    return-object v0
.end method

.method public isMovie()Z
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x1

    return v0
.end method

.method public parse(Ljava/util/LinkedHashMap;)V
    .locals 7
    .param p1, "movie"    # Ljava/util/LinkedHashMap;

    .prologue
    .line 12
    const-string v4, "entityMerlinId"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 13
    .local v1, "merlinId":Ljava/lang/String;
    const-string v4, "entityType"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 14
    .local v3, "type":Ljava/lang/String;
    const-string v4, "name"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 15
    .local v2, "title":Ljava/lang/String;
    const-string v4, "videoBrand"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 16
    .local v0, "brand":Ljava/lang/String;
    const-string v4, "videoProviderCode"

    invoke-virtual {p1, v4}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/EditorialMovie;->setProviderCode(Ljava/lang/String;)V

    .line 18
    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/model/EditorialMovie;->setTitle(Ljava/lang/String;)V

    .line 19
    new-instance v4, Lcom/xfinity/playerlib/model/MerlinId;

    invoke-static {v3}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v5

    invoke-static {v1}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/EditorialMovie;->setMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 20
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/EditorialMovie;->setBrand(Ljava/lang/String;)V

    .line 21
    return-void
.end method
