.class public Lcom/bestbuy/android/api/lib/models/pdp/Categories;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private subCategories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/PDPCategory;",
            ">;"
        }
    .end annotation
.end field

.field private uberCategory:Lcom/bestbuy/android/api/lib/models/pdp/PDPCategory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSubCategories()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/PDPCategory;",
            ">;"
        }
    .end annotation

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/Categories;->subCategories:Ljava/util/List;

    return-object v0
.end method

.method public getUberCategory()Lcom/bestbuy/android/api/lib/models/pdp/PDPCategory;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/Categories;->uberCategory:Lcom/bestbuy/android/api/lib/models/pdp/PDPCategory;

    return-object v0
.end method

.method public setSubCategories(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/PDPCategory;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/Categories;->subCategories:Ljava/util/List;

    .line 32
    return-void
.end method

.method public setUberCategory(Lcom/bestbuy/android/api/lib/models/pdp/PDPCategory;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/Categories;->uberCategory:Lcom/bestbuy/android/api/lib/models/pdp/PDPCategory;

    .line 24
    return-void
.end method
