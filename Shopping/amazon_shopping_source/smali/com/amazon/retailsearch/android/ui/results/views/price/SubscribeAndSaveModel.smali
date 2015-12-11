.class public Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;
.super Ljava/lang/Object;
.source "SubscribeAndSaveModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel$Builder;
    }
.end annotation


# instance fields
.field private price:Ljava/lang/String;

.field private priceLabel:Ljava/lang/String;

.field private saveMoreText:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->setPrice(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->setPriceLabel(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->setSaveMoreText(Ljava/lang/String;)V

    return-void
.end method

.method private setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->price:Ljava/lang/String;

    .line 43
    return-void
.end method

.method private setPriceLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "priceLabel"    # Ljava/lang/String;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->priceLabel:Ljava/lang/String;

    .line 59
    return-void
.end method

.method private setSaveMoreText(Ljava/lang/String;)V
    .locals 0
    .param p1, "saveMoreText"    # Ljava/lang/String;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->saveMoreText:Ljava/lang/String;

    .line 75
    return-void
.end method


# virtual methods
.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getPriceLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->priceLabel:Ljava/lang/String;

    return-object v0
.end method

.method public getSaveMoreText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->saveMoreText:Ljava/lang/String;

    return-object v0
.end method
