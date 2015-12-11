.class Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;
.super Ljava/lang/Object;
.source "PriceModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "UIPriceInfo"
.end annotation


# instance fields
.field label:Ljava/lang/String;

.field price:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;
    .param p2, "label"    # Ljava/lang/String;

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;->price:Ljava/lang/String;

    .line 48
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;->label:Ljava/lang/String;

    .line 49
    return-void
.end method


# virtual methods
.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;->price:Ljava/lang/String;

    return-object v0
.end method

.method public setLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;->label:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;->price:Ljava/lang/String;

    .line 64
    return-void
.end method
