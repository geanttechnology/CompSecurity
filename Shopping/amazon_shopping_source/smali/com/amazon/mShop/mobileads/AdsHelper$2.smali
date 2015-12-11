.class final Lcom/amazon/mShop/mobileads/AdsHelper$2;
.super Ljava/lang/Object;
.source "AdsHelper.java"

# interfaces
.implements Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mobileads/AdsHelper;->openUserPreferences(Lcom/amazon/mShop/AmazonActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$activity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonProgressDialog;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/amazon/mShop/mobileads/AdsHelper$2;->val$progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    iput-object p2, p0, Lcom/amazon/mShop/mobileads/AdsHelper$2;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onRegistrationInfoReady(Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;)V
    .locals 1
    .param p1, "info"    # Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;

    .prologue
    .line 93
    if-eqz p1, :cond_0

    .line 96
    new-instance v0, Lcom/amazon/mShop/mobileads/AdsHelper$2$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/mobileads/AdsHelper$2$1;-><init>(Lcom/amazon/mShop/mobileads/AdsHelper$2;)V

    invoke-static {v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->fetchAdPreferencesURL(Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;)V

    .line 108
    :goto_0
    return-void

    .line 106
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/AdsHelper$2;->val$progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonProgressDialog;->dismiss()V

    goto :goto_0
.end method
