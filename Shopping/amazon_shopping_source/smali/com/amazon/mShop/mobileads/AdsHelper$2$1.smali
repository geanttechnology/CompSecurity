.class Lcom/amazon/mShop/mobileads/AdsHelper$2$1;
.super Ljava/lang/Object;
.source "AdsHelper.java"

# interfaces
.implements Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mobileads/AdsHelper$2;->onRegistrationInfoReady(Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mobileads/AdsHelper$2;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mobileads/AdsHelper$2;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lcom/amazon/mShop/mobileads/AdsHelper$2$1;->this$0:Lcom/amazon/mShop/mobileads/AdsHelper$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdPreferencesURLFetched(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/AdsHelper$2$1;->this$0:Lcom/amazon/mShop/mobileads/AdsHelper$2;

    iget-object v0, v0, Lcom/amazon/mShop/mobileads/AdsHelper$2;->val$progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonProgressDialog;->dismiss()V

    .line 101
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/AdsHelper$2$1;->this$0:Lcom/amazon/mShop/mobileads/AdsHelper$2;

    iget-object v0, v0, Lcom/amazon/mShop/mobileads/AdsHelper$2;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0, p1}, Lcom/amazon/mShop/util/ActivityUtils;->startAdsWebActivity(Landroid/content/Context;Ljava/lang/String;)Z

    .line 102
    return-void
.end method
