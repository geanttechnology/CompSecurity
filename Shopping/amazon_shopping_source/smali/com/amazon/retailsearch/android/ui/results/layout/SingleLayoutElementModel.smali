.class public Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;
.super Ljava/lang/Object;
.source "SingleLayoutElementModel.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;


# instance fields
.field private canonicalModel:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 0
    .param p1, "model"    # Ljava/lang/Object;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;->canonicalModel:Ljava/lang/Object;

    .line 24
    return-void
.end method

.method public static create(Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;
    .locals 1
    .param p0, "model"    # Ljava/lang/Object;

    .prologue
    .line 40
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;-><init>(Ljava/lang/Object;)V

    return-object v0
.end method


# virtual methods
.method public getAllModels()Ljava/util/List;
    .locals 3
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
    .line 35
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;->canonicalModel:Ljava/lang/Object;

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getCanonicalModel()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;->canonicalModel:Ljava/lang/Object;

    return-object v0
.end method
