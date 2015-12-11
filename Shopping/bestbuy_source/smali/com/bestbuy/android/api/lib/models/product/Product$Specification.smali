.class public Lcom/bestbuy/android/api/lib/models/product/Product$Specification;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private definition:Ljava/lang/String;

.field private displayName:Ljava/lang/String;

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1976
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadProductSpecificationData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$Specification;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1998
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1999
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 2000
    new-instance v2, Lcom/bestbuy/android/api/lib/models/product/Product$Specification;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/product/Product$Specification;-><init>()V

    .line 2001
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 2002
    if-eqz v3, :cond_0

    .line 2003
    const-string v4, "definition"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$Specification;->definition:Ljava/lang/String;

    .line 2004
    const-string v4, "displayName"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$Specification;->displayName:Ljava/lang/String;

    .line 2005
    const-string v4, "value"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lcom/bestbuy/android/api/lib/models/product/Product$Specification;->value:Ljava/lang/String;

    .line 2007
    :cond_0
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1999
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2009
    :cond_1
    return-object v1
.end method


# virtual methods
.method public getDefinition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1986
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Specification;->definition:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1990
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Specification;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1994
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$Specification;->value:Ljava/lang/String;

    return-object v0
.end method
