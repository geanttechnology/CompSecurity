.class public Lcom/poshmark/data_model/models/Catalog;
.super Ljava/lang/Object;
.source "Catalog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/Catalog$GlobalFeatures;,
        Lcom/poshmark/data_model/models/Catalog$Catalogue;,
        Lcom/poshmark/data_model/models/Catalog$Size;,
        Lcom/poshmark/data_model/models/Catalog$Entry;
    }
.end annotation


# static fields
.field public static DEPT_WOMEN:Ljava/lang/String;


# instance fields
.field public catalog:Lcom/poshmark/data_model/models/Catalog$Catalogue;

.field public colors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation
.end field

.field public global_features:Lcom/poshmark/data_model/models/Catalog$GlobalFeatures;

.field public updated_at:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-string v0, "Women"

    sput-object v0, Lcom/poshmark/data_model/models/Catalog;->DEPT_WOMEN:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    return-void
.end method


# virtual methods
.method public getCategoryList()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Catalog$Entry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 48
    iget-object v2, p0, Lcom/poshmark/data_model/models/Catalog;->catalog:Lcom/poshmark/data_model/models/Catalog$Catalogue;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/poshmark/data_model/models/Catalog;->catalog:Lcom/poshmark/data_model/models/Catalog$Catalogue;

    iget-object v2, v2, Lcom/poshmark/data_model/models/Catalog$Catalogue;->departments:Ljava/util/List;

    if-eqz v2, :cond_1

    .line 49
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/Catalog;->catalog:Lcom/poshmark/data_model/models/Catalog$Catalogue;

    iget-object v2, v2, Lcom/poshmark/data_model/models/Catalog$Catalogue;->departments:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 50
    iget-object v2, p0, Lcom/poshmark/data_model/models/Catalog;->catalog:Lcom/poshmark/data_model/models/Catalog$Catalogue;

    iget-object v2, v2, Lcom/poshmark/data_model/models/Catalog$Catalogue;->departments:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/Catalog$Entry;

    .line 51
    .local v0, "entry":Lcom/poshmark/data_model/models/Catalog$Entry;
    if-eqz v0, :cond_0

    iget-object v2, v0, Lcom/poshmark/data_model/models/Catalog$Entry;->display:Ljava/lang/String;

    sget-object v3, Lcom/poshmark/data_model/models/Catalog;->DEPT_WOMEN:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 52
    iget-object v2, v0, Lcom/poshmark/data_model/models/Catalog$Entry;->categories:Ljava/util/List;

    .line 56
    .end local v0    # "entry":Lcom/poshmark/data_model/models/Catalog$Entry;
    .end local v1    # "i":I
    :goto_1
    return-object v2

    .line 49
    .restart local v0    # "entry":Lcom/poshmark/data_model/models/Catalog$Entry;
    .restart local v1    # "i":I
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 56
    .end local v0    # "entry":Lcom/poshmark/data_model/models/Catalog$Entry;
    .end local v1    # "i":I
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method
