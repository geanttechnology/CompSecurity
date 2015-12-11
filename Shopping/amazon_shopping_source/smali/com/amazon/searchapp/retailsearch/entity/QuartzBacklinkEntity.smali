.class public Lcom/amazon/searchapp/retailsearch/entity/QuartzBacklinkEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "QuartzBacklinkEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/QuartzBacklink;


# instance fields
.field private formattedLabel:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getFormattedLabel()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/QuartzBacklinkEntity;->formattedLabel:Ljava/util/List;

    return-object v0
.end method

.method public setFormattedLabel(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p1, "formattedLabel":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/QuartzBacklinkEntity;->formattedLabel:Ljava/util/List;

    .line 34
    return-void
.end method
