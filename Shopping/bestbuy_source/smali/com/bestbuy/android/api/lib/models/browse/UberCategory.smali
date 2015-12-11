.class public Lcom/bestbuy/android/api/lib/models/browse/UberCategory;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field private categoryId:Ljava/lang/String;

.field private categoryName:Ljava/lang/String;

.field private categoryValue:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategoryId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/browse/UberCategory;->categoryId:Ljava/lang/String;

    return-object v0
.end method

.method public getCategoryName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/browse/UberCategory;->categoryName:Ljava/lang/String;

    return-object v0
.end method

.method public getCategoryValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/browse/UberCategory;->categoryValue:Ljava/lang/String;

    return-object v0
.end method

.method public setCategoryId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/browse/UberCategory;->categoryId:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public setCategoryName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 21
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/browse/UberCategory;->categoryName:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public setCategoryValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/browse/UberCategory;->categoryValue:Ljava/lang/String;

    .line 30
    return-void
.end method
