.class public Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
.super Ljava/lang/Object;
.source "CategoryResult.java"


# instance fields
.field private category:Ljava/lang/String;

.field private displayName:Ljava/lang/String;

.field private parent:Ljava/lang/String;

.field private resultCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->category:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public setCategory(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->category:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->displayName:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setParent(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->parent:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public setResultCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 45
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->resultCount:I

    .line 46
    return-void
.end method
