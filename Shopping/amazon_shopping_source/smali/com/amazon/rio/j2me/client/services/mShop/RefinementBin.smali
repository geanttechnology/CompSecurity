.class public Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;
.super Ljava/lang/Object;
.source "RefinementBin.java"


# instance fields
.field private ancestors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RefinementValue;",
            ">;"
        }
    .end annotation
.end field

.field private anyName:Ljava/lang/String;

.field private binId:Ljava/lang/String;

.field private binType:Ljava/lang/Integer;

.field private hasMore:Ljava/lang/Boolean;

.field private layout:Ljava/lang/Integer;

.field private name:Ljava/lang/String;

.field private selectMode:Ljava/lang/Integer;

.field private values:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RefinementValue;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setAncestors(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RefinementValue;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 115
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RefinementValue;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;->ancestors:Ljava/util/List;

    .line 116
    return-void
.end method

.method public setAnyName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;->anyName:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public setBinId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;->binId:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setBinType(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 128
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;->binType:Ljava/lang/Integer;

    .line 129
    return-void
.end method

.method public setHasMore(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;->hasMore:Ljava/lang/Boolean;

    .line 77
    return-void
.end method

.method public setLayout(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;->layout:Ljava/lang/Integer;

    .line 90
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;->name:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setSelectMode(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;->selectMode:Ljava/lang/Integer;

    .line 103
    return-void
.end method

.method public setValues(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RefinementValue;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 50
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RefinementValue;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;->values:Ljava/util/List;

    .line 51
    return-void
.end method
