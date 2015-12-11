.class public Lcom/amazon/mShop/cvsd/CVSDRefinmentsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "CVSDRefinmentsActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onStart()V
    .locals 1

    .prologue
    .line 9
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 11
    new-instance v0, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/cvsd/CVSDRefinementsView;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    .line 13
    .local v0, "root":Lcom/amazon/mShop/cvsd/CVSDRefinementsView;
    invoke-super {p0, v0}, Lcom/amazon/mShop/AmazonActivity;->setRootView(Landroid/view/View;)V

    .line 14
    return-void
.end method
