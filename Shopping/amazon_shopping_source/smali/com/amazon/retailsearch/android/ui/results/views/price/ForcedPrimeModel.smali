.class public Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
.super Ljava/lang/Object;
.source "ForcedPrimeModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel$Builder;
    }
.end annotation


# instance fields
.field private asin:Ljava/lang/String;

.field private lowerPriceMessage:Ljava/lang/String;

.field private priceAndLabel:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private productGroup:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 98
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->setLowerPriceMessage(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Ljava/util/List;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->setPriceAndLabel(Ljava/util/List;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->setAsin(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->setUrl(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->setProductGroup(Ljava/lang/String;)V

    return-void
.end method

.method private setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->asin:Ljava/lang/String;

    .line 66
    return-void
.end method

.method private setLowerPriceMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "lowerPriceMessage"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->lowerPriceMessage:Ljava/lang/String;

    .line 42
    return-void
.end method

.method private setPriceAndLabel(Ljava/util/List;)V
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
    .line 55
    .local p1, "priceAndLabel":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->priceAndLabel:Ljava/util/List;

    .line 56
    return-void
.end method

.method private setProductGroup(Ljava/lang/String;)V
    .locals 0
    .param p1, "productGroup"    # Ljava/lang/String;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->productGroup:Ljava/lang/String;

    .line 92
    return-void
.end method

.method private setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->url:Ljava/lang/String;

    .line 82
    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getLowerPriceMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->lowerPriceMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getPriceAndLabel()Ljava/util/List;
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
    .line 48
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->priceAndLabel:Ljava/util/List;

    return-object v0
.end method

.method public getProductGroup()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->productGroup:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->url:Ljava/lang/String;

    return-object v0
.end method
