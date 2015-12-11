.class Lcom/amazon/mShop/AppExtensionsInitializer$AppWeblabClient;
.super Ljava/lang/Object;
.source "AppExtensionsInitializer.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AppExtensionsInitializer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AppWeblabClient"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/AppExtensionsInitializer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/AppExtensionsInitializer$1;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/amazon/mShop/AppExtensionsInitializer$AppWeblabClient;-><init>()V

    return-void
.end method


# virtual methods
.method public getTreatment(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "feature"    # Ljava/lang/String;

    .prologue
    .line 69
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/feature/Features;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public postFeatureTrigger(Ljava/lang/String;)V
    .locals 0
    .param p1, "feature"    # Ljava/lang/String;

    .prologue
    .line 77
    invoke-static {p1}, Lcom/amazon/mShop/feature/WeblabCsmUtils;->postFeatureTrigger(Ljava/lang/String;)V

    .line 78
    return-void
.end method
