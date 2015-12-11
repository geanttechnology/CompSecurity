.class public Lcom/bestbuy/android/api/lib/models/solr/SortOption;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private displayName:Ljava/lang/String;

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/solr/SortOption;
    .locals 2

    .prologue
    .line 39
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;-><init>()V

    .line 40
    const-string v1, "displayName"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->displayName:Ljava/lang/String;

    .line 41
    const-string v1, "value"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->value:Ljava/lang/String;

    .line 42
    return-object v0
.end method


# virtual methods
.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->value:Ljava/lang/String;

    return-object v0
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->displayName:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->value:Ljava/lang/String;

    .line 36
    return-void
.end method
