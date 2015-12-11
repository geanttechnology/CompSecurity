.class public Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;
.super Ljava/lang/Object;
.source "TwisterModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;,
        Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Builder;
    }
.end annotation


# instance fields
.field private editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

.field private editionsMetadata:Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

.field private editionsType:Ljava/lang/String;

.field private productTitle:Ljava/lang/String;

.field retailSearchDataProvider:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 45
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;)[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    return-object v0
.end method

.method static synthetic access$002(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;)[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;
    .param p1, "x1"    # [Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    return-object p1
.end method


# virtual methods
.method public getEditions()[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    return-object v0
.end method

.method public getEditionsMetadata()Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->editionsMetadata:Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

    return-object v0
.end method

.method public getEditionsType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->editionsType:Ljava/lang/String;

    return-object v0
.end method

.method public getProductTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->productTitle:Ljava/lang/String;

    return-object v0
.end method

.method public setEditionType(Ljava/lang/String;)V
    .locals 0
    .param p1, "editionsType"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->editionsType:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setEditions([Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;)V
    .locals 0
    .param p1, "editions"    # [Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    .line 92
    return-void
.end method

.method public setEditionsMetadata(Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;)V
    .locals 0
    .param p1, "editionsMetadata"    # Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

    .prologue
    .line 107
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->editionsMetadata:Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

    .line 108
    return-void
.end method

.method public setProductTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "productTitle"    # Ljava/lang/String;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->productTitle:Ljava/lang/String;

    .line 60
    return-void
.end method
