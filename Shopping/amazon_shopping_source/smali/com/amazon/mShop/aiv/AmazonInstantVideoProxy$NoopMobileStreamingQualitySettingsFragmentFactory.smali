.class Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$NoopMobileStreamingQualitySettingsFragmentFactory;
.super Ljava/lang/Object;
.source "AmazonInstantVideoProxy.java"

# interfaces
.implements Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "NoopMobileStreamingQualitySettingsFragmentFactory"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 264
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1;

    .prologue
    .line 264
    invoke-direct {p0}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$NoopMobileStreamingQualitySettingsFragmentFactory;-><init>()V

    return-void
.end method


# virtual methods
.method public createInstance()Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 269
    new-instance v0, Landroid/support/v4/app/Fragment;

    invoke-direct {v0}, Landroid/support/v4/app/Fragment;-><init>()V

    return-object v0
.end method
