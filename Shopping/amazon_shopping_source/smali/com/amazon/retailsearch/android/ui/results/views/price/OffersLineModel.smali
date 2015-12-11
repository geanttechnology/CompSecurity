.class public Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;
.super Ljava/lang/Object;
.source "OffersLineModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel$Builder;
    }
.end annotation


# instance fields
.field private styledText:Ljava/util/List;
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
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    return-void
.end method


# virtual methods
.method public getStyledText()Ljava/util/List;
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
    .line 27
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;->styledText:Ljava/util/List;

    return-object v0
.end method

.method public setStyledText(Ljava/util/List;)V
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
    .line 35
    .local p1, "styledText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;->styledText:Ljava/util/List;

    .line 36
    return-void
.end method
