.class public Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;
.super Ljava/lang/Object;
.source "GoldboxLaunchParamters.java"


# instance fields
.field private mCategory:Ljava/lang/String;

.field private mDealType:Ljava/lang/String;

.field private mTitle:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "dealType"    # Ljava/lang/String;
    .param p2, "category"    # Ljava/lang/String;
    .param p3, "title"    # Ljava/lang/String;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;->mDealType:Ljava/lang/String;

    .line 15
    iput-object p2, p0, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;->mCategory:Ljava/lang/String;

    .line 16
    iput-object p3, p0, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;->mTitle:Ljava/lang/String;

    .line 17
    return-void
.end method


# virtual methods
.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;->mCategory:Ljava/lang/String;

    return-object v0
.end method

.method public getDealType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;->mDealType:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;->mTitle:Ljava/lang/String;

    return-object v0
.end method
