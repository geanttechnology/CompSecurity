.class public Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private categoryName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "cat_name"
    .end annotation
.end field

.field private categoryPath:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "cat_path"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategoryName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;->categoryName:Ljava/lang/String;

    return-object v0
.end method

.method public getCategoryPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;->categoryPath:Ljava/lang/String;

    return-object v0
.end method

.method public setCategoryName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;->categoryName:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setCategoryPath(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;->categoryPath:Ljava/lang/String;

    .line 52
    return-void
.end method
