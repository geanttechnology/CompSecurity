.class Lcom/amazon/mShop/AppExtensionsInitializer$AppFeatureConfiguration;
.super Ljava/lang/Object;
.source "AppExtensionsInitializer.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AppExtensionsInitializer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AppFeatureConfiguration"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/AppExtensionsInitializer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/AppExtensionsInitializer$1;

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/amazon/mShop/AppExtensionsInitializer$AppFeatureConfiguration;-><init>()V

    return-void
.end method


# virtual methods
.method public getFeatureState(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "feature"    # Ljava/lang/String;

    .prologue
    .line 55
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/feature/Features;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isFeatureActivated(Ljava/lang/String;)Z
    .locals 1
    .param p1, "feature"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
