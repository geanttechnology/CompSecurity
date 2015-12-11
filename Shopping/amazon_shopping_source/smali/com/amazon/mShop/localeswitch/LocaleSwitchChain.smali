.class public Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;
.super Ljava/lang/Object;
.source "LocaleSwitchChain.java"


# instance fields
.field private mContext:Landroid/content/Context;

.field private mCurrentIndex:I

.field private mLaunchIntent:Landroid/content/Intent;

.field private mLocaleName:Ljava/lang/String;

.field private mProcessorList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/localeswitch/LocaleSwitchProcessor;",
            ">;"
        }
    .end annotation
.end field

.field private mProgDiag:Lcom/amazon/mShop/AmazonProgressDialog;


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "localeName"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "launchIntent"    # Landroid/content/Intent;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mProcessorList:Ljava/util/List;

    .line 15
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mCurrentIndex:I

    .line 19
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mProgDiag:Lcom/amazon/mShop/AmazonProgressDialog;

    .line 22
    iput-object p1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mLocaleName:Ljava/lang/String;

    .line 23
    iput-object p2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mContext:Landroid/content/Context;

    .line 24
    iput-object p3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mLaunchIntent:Landroid/content/Intent;

    .line 25
    return-void
.end method


# virtual methods
.method public addProcessor(Lcom/amazon/mShop/localeswitch/LocaleSwitchProcessor;)Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;
    .locals 1
    .param p1, "p"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchProcessor;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mProcessorList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 29
    return-object p0
.end method

.method public getExistentProgDiag()Lcom/amazon/mShop/AmazonProgressDialog;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mProgDiag:Lcom/amazon/mShop/AmazonProgressDialog;

    return-object v0
.end method

.method public getLaunchIntent()Landroid/content/Intent;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mLaunchIntent:Landroid/content/Intent;

    return-object v0
.end method

.method public process()V
    .locals 4

    .prologue
    .line 33
    iget v1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mCurrentIndex:I

    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mProcessorList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ne v1, v2, :cond_0

    .line 38
    :goto_0
    return-void

    .line 36
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mProcessorList:Ljava/util/List;

    iget v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mCurrentIndex:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mCurrentIndex:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchProcessor;

    .line 37
    .local v0, "p":Lcom/amazon/mShop/localeswitch/LocaleSwitchProcessor;
    iget-object v1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mLocaleName:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mContext:Landroid/content/Context;

    invoke-interface {v0, v1, v2, p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchProcessor;->doProcess(Ljava/lang/String;Landroid/content/Context;Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;)V

    goto :goto_0
.end method

.method public setExistentProgressDialog(Lcom/amazon/mShop/AmazonProgressDialog;)V
    .locals 0
    .param p1, "dialog"    # Lcom/amazon/mShop/AmazonProgressDialog;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->mProgDiag:Lcom/amazon/mShop/AmazonProgressDialog;

    .line 46
    return-void
.end method
