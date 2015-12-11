.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;
.super Ljava/lang/Object;
.source "SuperSaverShippingModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel$Builder;
    }
.end annotation


# instance fields
.field private superSaverShippingStyledText:Ljava/util/List;
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
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    return-void
.end method


# virtual methods
.method public getSuperSaverShippingStyledText()Ljava/util/List;
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
    .line 28
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;->superSaverShippingStyledText:Ljava/util/List;

    return-object v0
.end method

.method public setSuperSaverShippingStyledText(Ljava/util/List;)V
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
    .line 37
    .local p1, "superSaverShippingStyledText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;->superSaverShippingStyledText:Ljava/util/List;

    .line 38
    return-void
.end method
