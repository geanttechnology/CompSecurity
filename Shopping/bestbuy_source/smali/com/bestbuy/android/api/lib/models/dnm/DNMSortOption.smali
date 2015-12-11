.class public Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;
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
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadSortOptions()Ljava/util/ArrayList;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;",
            ">;"
        }
    .end annotation

    .prologue
    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 31
    new-instance v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;-><init>()V

    .line 32
    const-string v2, "Customer Rating"

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->displayName:Ljava/lang/String;

    .line 33
    const-string v2, "rating"

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->value:Ljava/lang/String;

    .line 34
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 36
    new-instance v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;-><init>()V

    .line 37
    const-string v2, "Price Low to High"

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->displayName:Ljava/lang/String;

    .line 38
    const-string v2, "clearancePrice"

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->value:Ljava/lang/String;

    .line 39
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 46
    return-object v0
.end method


# virtual methods
.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->value:Ljava/lang/String;

    return-object v0
.end method
