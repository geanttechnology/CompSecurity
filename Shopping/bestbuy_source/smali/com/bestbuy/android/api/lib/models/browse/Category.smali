.class public Lcom/bestbuy/android/api/lib/models/browse/Category;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private categoryId:Ljava/lang/String;

.field private displayOnly:Ljava/lang/String;

.field private groups:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/browse/Category;",
            ">;"
        }
    .end annotation
.end field

.field private name:Ljava/lang/String;

.field private searchPath:Ljava/lang/String;

.field private widgetType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategoryId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->categoryId:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayOnly()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->displayOnly:Ljava/lang/String;

    return-object v0
.end method

.method public getGroups()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/browse/Category;",
            ">;"
        }
    .end annotation

    .prologue
    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->groups:Ljava/util/List;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->searchPath:Ljava/lang/String;

    return-object v0
.end method

.method public getWidgetType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->widgetType:Ljava/lang/String;

    return-object v0
.end method

.method public setCategoryId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->categoryId:Ljava/lang/String;

    .line 72
    return-void
.end method

.method public setDisplayOnly(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->displayOnly:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setGroups(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/browse/Category;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 95
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->groups:Ljava/util/List;

    .line 96
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->name:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setSearchPath(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->searchPath:Ljava/lang/String;

    .line 108
    return-void
.end method

.method public setWidgetType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/browse/Category;->widgetType:Ljava/lang/String;

    .line 48
    return-void
.end method
