.class public Lcom/bestbuy/android/api/lib/models/search/FacetValues;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private categoryPath:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "cat_path"
    .end annotation
.end field

.field private count:I

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategoryPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->categoryPath:Ljava/lang/String;

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 31
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->count:I

    return v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->value:Ljava/lang/String;

    return-object v0
.end method

.method public setCategoryPath(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->categoryPath:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public setCount(I)V
    .locals 0

    .prologue
    .line 38
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->count:I

    .line 39
    return-void
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->value:Ljava/lang/String;

    .line 60
    return-void
.end method
