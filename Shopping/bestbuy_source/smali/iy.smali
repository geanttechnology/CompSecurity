.class public Liy;
.super Lka;
.source "SourceFile"


# static fields
.field private static n:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation
.end field

.field private o:Lnb;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const/4 v0, 0x0

    sput v0, Liy;->n:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 37
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 38
    iput-object p3, p0, Liy;->g:Landroid/view/View;

    .line 39
    iput-object p4, p0, Liy;->a:Ljava/lang/String;

    .line 40
    iput-object p5, p0, Liy;->j:Ljava/lang/String;

    .line 41
    iput-object p7, p0, Liy;->l:Ljava/lang/String;

    .line 42
    iput-object p6, p0, Liy;->k:Ljava/lang/String;

    .line 43
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Liy;->o:Lnb;

    .line 44
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 29
    sput p0, Liy;->n:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 8

    .prologue
    .line 56
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    .line 57
    iget-object v1, p0, Liy;->a:Ljava/lang/String;

    iget-object v2, p0, Liy;->j:Ljava/lang/String;

    iget-object v3, p0, Liy;->k:Ljava/lang/String;

    iget-object v4, p0, Liy;->l:Ljava/lang/String;

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v7

    move-object v5, v0

    move-object v6, v0

    invoke-static/range {v0 .. v7}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Liy;->m:Ljava/util/ArrayList;

    .line 58
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 62
    const/4 v0, 0x0

    sput v0, Liy;->n:I

    .line 63
    iget-object v0, p0, Liy;->o:Lnb;

    invoke-virtual {v0, v2}, Lnb;->b(Z)V

    .line 64
    iget-object v0, p0, Liy;->o:Lnb;

    iget-object v1, p0, Liy;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lnb;->e(Ljava/lang/String;)V

    .line 65
    iget-object v0, p0, Liy;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Liy;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 68
    :cond_0
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 69
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    if-eqz v0, :cond_1

    .line 70
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    .line 71
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 72
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v1, :cond_1

    .line 73
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 74
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v1, :cond_1

    .line 76
    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a(Z)V

    .line 99
    :cond_1
    :goto_0
    return-void

    .line 80
    :cond_2
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    if-eqz v0, :cond_3

    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 81
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    iget-object v1, p0, Liy;->m:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->b(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 82
    :cond_3
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    if-eqz v0, :cond_4

    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 83
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->c()V

    goto :goto_0

    .line 84
    :cond_4
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    if-eqz v0, :cond_5

    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 85
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->b()V

    goto :goto_0

    .line 86
    :cond_5
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_6

    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 87
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 88
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v1, :cond_1

    iget-object v1, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 90
    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a(Z)V

    goto :goto_0

    .line 92
    :cond_6
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    if-eqz v0, :cond_7

    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 93
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a(Z)V

    goto/16 :goto_0

    .line 94
    :cond_7
    iget-object v0, p0, Liy;->f:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    if-eqz v0, :cond_8

    .line 95
    iget-object v0, p0, Liy;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->e()V

    goto/16 :goto_0

    .line 96
    :cond_8
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;

    if-eqz v0, :cond_1

    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 97
    iget-object v0, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->a(Z)V

    goto/16 :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 110
    iget-object v0, p0, Liy;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Liy;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 112
    :cond_0
    iget-object v0, p0, Liy;->f:Landroid/app/Activity;

    new-instance v1, Liy$1;

    invoke-direct {v1, p0}, Liy$1;-><init>(Liy;)V

    new-instance v2, Liy$2;

    invoke-direct {v2, p0}, Liy$2;-><init>(Liy;)V

    iget-boolean v3, p0, Liy;->e:Z

    sget v4, Liy;->n:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 123
    return-void
.end method

.method public d()V
    .locals 8

    .prologue
    .line 103
    sget v0, Liy;->n:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Liy;->n:I

    .line 104
    new-instance v0, Liy;

    iget-object v1, p0, Liy;->f:Landroid/app/Activity;

    iget-object v2, p0, Liy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Liy;->g:Landroid/view/View;

    iget-object v4, p0, Liy;->a:Ljava/lang/String;

    iget-object v5, p0, Liy;->j:Ljava/lang/String;

    iget-object v6, p0, Liy;->k:Ljava/lang/String;

    iget-object v7, p0, Liy;->l:Ljava/lang/String;

    invoke-direct/range {v0 .. v7}, Liy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 106
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 48
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 49
    iget-object v0, p0, Liy;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 50
    iget-object v0, p0, Liy;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 52
    :cond_0
    return-void
.end method
