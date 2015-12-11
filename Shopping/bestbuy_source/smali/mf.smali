.class public Lmf;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static b:Ljava/lang/String;


# instance fields
.field private a:Ljava/lang/String;

.field private c:Lnb;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-string v0, "0"

    sput-object v0, Lmf;->b:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmf;->a:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public a(Landroid/app/Activity;)Landroid/support/v4/app/Fragment;
    .locals 3

    .prologue
    .line 56
    check-cast p1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 57
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v0

    .line 59
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 60
    if-eqz v0, :cond_0

    instance-of v2, v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->isVisible()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 63
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(IILandroid/content/Intent;Landroid/app/Activity;)V
    .locals 10

    .prologue
    const/4 v4, 0x0

    const/4 v9, 0x7

    const v8, 0x7f0c0033

    const/4 v7, 0x1

    const/4 v2, 0x0

    .line 67
    const/16 v0, 0x63

    if-ne p1, v0, :cond_3

    .line 68
    sget v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->PRODUCT_SCAN:I

    if-ne p2, v0, :cond_6

    if-eqz p3, :cond_6

    .line 69
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lmf;->c:Lnb;

    .line 70
    const-string v1, ""

    .line 71
    const-string v0, ""

    .line 72
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "ProductScan"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 73
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    const-string v5, "ProductId"

    invoke-virtual {v4, v5}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 74
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v4, "ProductId"

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 76
    :cond_0
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    const-string v5, "SkuId"

    invoke-virtual {v4, v5}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 77
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v4, "SkuId"

    invoke-virtual {v1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 79
    :cond_1
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    const-string v5, "fromLifeEventsProductScan"

    invoke-virtual {v4, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v4

    .line 80
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v5

    const-string v6, "uuid"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lmf;->d:Ljava/lang/String;

    .line 81
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v5

    const-string v6, "type"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lmf;->e:Ljava/lang/String;

    .line 83
    if-nez v4, :cond_5

    .line 84
    const-string v4, "?c="

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 85
    const-string v0, "?c="

    invoke-virtual {v3, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {v3, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 86
    const-string v1, "?c="

    const-string v3, ""

    invoke-virtual {v0, v1, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 87
    invoke-virtual {v0, v2, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 88
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {v0, v9, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    move-object v0, p4

    .line 90
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 91
    new-instance v3, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    const-string v4, ""

    invoke-direct {v3, v1, v4, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 92
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-direct {v1, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;-><init>(Ljava/lang/String;)V

    .line 93
    check-cast p4, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {p4}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    .line 94
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v5

    move v0, v2

    .line 95
    :goto_0
    add-int/lit8 v2, v5, -0x1

    if-ge v0, v2, :cond_2

    .line 96
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 95
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 98
    :cond_2
    invoke-virtual {v4, v8}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 99
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_3

    .line 100
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 101
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 102
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    .line 103
    invoke-virtual {v0, v1, v7}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 104
    invoke-virtual {v1, v3, v7}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 150
    :cond_3
    :goto_1
    return-void

    .line 108
    :cond_4
    if-eqz v1, :cond_3

    .line 109
    check-cast p4, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p4, v1, v0, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_1

    .line 112
    :cond_5
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "skuid"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 114
    invoke-static {p4, v1}, Lls;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 115
    invoke-virtual {p0, p4}, Lmf;->a(Landroid/app/Activity;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 116
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 117
    new-instance v2, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    iget-object v3, p0, Lmf;->d:Ljava/lang/String;

    iget-object v4, p0, Lmf;->e:Ljava/lang/String;

    invoke-direct {v2, p4, v1, v3, v4}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    const-string v1, "ScannedItemFragment"

    invoke-virtual {v0, v2, v7, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto :goto_1

    .line 121
    :cond_6
    if-nez p2, :cond_7

    .line 122
    iget-object v0, p0, Lmf;->a:Ljava/lang/String;

    const-string v1, "SCAN CANCELED"

    invoke-static {v0, v1}, Lkf;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 124
    :cond_7
    sget v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->GC_SCAN_SUCCESS:I

    if-ne p2, v0, :cond_8

    .line 125
    if-eqz p3, :cond_3

    const-string v0, "gift_id"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 126
    const-string v0, "gift_id"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 127
    new-instance v1, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;-><init>()V

    .line 128
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 129
    const-string v3, "gift_id"

    invoke-virtual {v2, v3, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->setArguments(Landroid/os/Bundle;)V

    .line 131
    check-cast p4, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {p4}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 132
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 133
    const-string v2, "ManualEnterGiftCardDetailsFragment"

    invoke-virtual {v0, v8, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 135
    invoke-virtual {v0, v4}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 136
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_1

    .line 139
    :cond_8
    sget v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->MANUAL_ENTER:I

    if-ne p2, v0, :cond_3

    .line 140
    new-instance v0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;-><init>()V

    .line 141
    check-cast p4, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {p4}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 142
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 143
    const-string v2, "ManualEnterGiftCardDetailsFragment"

    invoke-virtual {v1, v8, v0, v2}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 145
    invoke-virtual {v1, v4}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 146
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto/16 :goto_1
.end method

.method public a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 52
    const-string v4, ""

    const-string v5, ""

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lmf;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    return-void
.end method

.method public a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 37
    sput-object p2, Lmf;->b:Ljava/lang/String;

    .line 38
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.GET_CONTENT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 39
    if-eqz v0, :cond_0

    .line 40
    const-string v1, "screen_name"

    sget-object v2, Lmf;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 41
    const-string v1, "screen_title"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 42
    const-string v1, "uuid"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 43
    const-string v1, "type"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 44
    const-class v1, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Landroid/content/Intent;->setClassName(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    .line 45
    const/16 v1, 0x63

    invoke-virtual {p1, v0, v1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 46
    const v0, 0x7f04000e

    const v1, 0x7f040005

    invoke-virtual {p1, v0, v1}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 48
    :cond_0
    return-void
.end method
