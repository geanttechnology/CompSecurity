.class public Lcom/amazon/mShop/appstore/UninstalledActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "UninstalledActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 16
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->appstore_uninstalled_activity:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/appstore/UninstalledActivity;->pushView(I)V

    .line 17
    return-void
.end method
