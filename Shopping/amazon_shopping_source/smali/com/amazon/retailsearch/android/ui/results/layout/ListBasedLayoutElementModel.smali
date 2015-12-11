.class public Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;
.super Ljava/lang/Object;
.source "ListBasedLayoutElementModel.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;


# instance fields
.field private models:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p1, "models":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;->models:Ljava/util/List;

    .line 26
    return-void
.end method

.method public static create(Ljava/util/List;)Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;)",
            "Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;"
        }
    .end annotation

    .prologue
    .line 46
    .local p0, "models":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;-><init>(Ljava/util/List;)V

    return-object v0
.end method


# virtual methods
.method public getAllModels()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;->models:Ljava/util/List;

    return-object v0
.end method

.method public getCanonicalModel()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;->models:Ljava/util/List;

    invoke-static {v0}, Lcom/amazon/retailsearch/util/Utils;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 33
    const/4 v0, 0x0

    .line 35
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;->models:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method
