.class Lcom/amazon/mShop/mobileads/MobileAdsLayout$1;
.super Ljava/lang/Object;
.source "MobileAdsLayout.java"

# interfaces
.implements Lcom/amazon/mShop/AmazonActivity$NewIntentListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/mobileads/MobileAdsLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mobileads/MobileAdsLayout;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$1;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleNewIntent(Landroid/content/Intent;)V
    .locals 1
    .param p1, "newIntent"    # Landroid/content/Intent;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$1;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    invoke-virtual {v0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->collapseAd()Z

    .line 97
    return-void
.end method
