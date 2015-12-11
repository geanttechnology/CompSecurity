.class public Ljd;
.super Lka;
.source "SourceFile"


# static fields
.field private static m:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation
.end field

.field private n:Z

.field private o:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    sput v0, Ljd;->m:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View;)V
    .locals 1

    .prologue
    .line 35
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 32
    const/4 v0, 0x0

    iput-boolean v0, p0, Ljd;->o:Z

    .line 36
    iput-object p3, p0, Ljd;->a:Ljava/lang/String;

    .line 37
    iput-object p4, p0, Ljd;->k:Ljava/lang/String;

    .line 38
    iput-object p5, p0, Ljd;->j:Ljava/lang/String;

    .line 39
    iput-boolean p6, p0, Ljd;->n:Z

    .line 40
    iput-object p7, p0, Ljd;->g:Landroid/view/View;

    .line 41
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 25
    sput p0, Ljd;->m:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 63
    iget-object v0, p0, Ljd;->a:Ljava/lang/String;

    iget-object v1, p0, Ljd;->k:Ljava/lang/String;

    iget-object v2, p0, Ljd;->j:Ljava/lang/String;

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v1, v2, v3}, Lfs;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Ljd;->l:Ljava/util/ArrayList;

    .line 64
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 68
    iget-object v0, p0, Ljd;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Ljd;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 71
    :cond_0
    const/4 v0, 0x0

    sput v0, Ljd;->m:I

    .line 72
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 73
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v1, p0, Ljd;->l:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Ljava/util/ArrayList;)V

    .line 89
    :cond_1
    :goto_0
    return-void

    .line 74
    :cond_2
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;

    if-eqz v0, :cond_3

    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 75
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;

    iget-object v1, p0, Ljd;->l:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 76
    :cond_3
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    if-eqz v0, :cond_4

    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 77
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    iget-object v1, p0, Ljd;->l:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 78
    :cond_4
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;

    if-eqz v0, :cond_5

    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 79
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;

    iget-object v1, p0, Ljd;->l:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/MyRegistryDetailsFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 82
    :cond_5
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;

    if-eqz v0, :cond_6

    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 83
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;

    iget-object v1, p0, Ljd;->l:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 84
    :cond_6
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v0, :cond_7

    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 85
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    iget-object v1, p0, Ljd;->l:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 86
    :cond_7
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 87
    iget-object v0, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;

    iget-object v1, p0, Ljd;->l:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->b(Ljava/util/ArrayList;)V

    goto/16 :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 99
    iget-object v0, p0, Ljd;->f:Landroid/app/Activity;

    new-instance v1, Ljd$1;

    invoke-direct {v1, p0}, Ljd$1;-><init>(Ljd;)V

    new-instance v2, Ljd$2;

    invoke-direct {v2, p0}, Ljd$2;-><init>(Ljd;)V

    iget-boolean v3, p0, Ljd;->e:Z

    sget v4, Ljd;->m:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 110
    return-void
.end method

.method public d()V
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 93
    sget v0, Ljd;->m:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljd;->m:I

    .line 94
    new-instance v0, Ljd;

    iget-object v1, p0, Ljd;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljd;->a:Ljava/lang/String;

    iget-object v4, p0, Ljd;->k:Ljava/lang/String;

    iget-object v5, p0, Ljd;->j:Ljava/lang/String;

    iget-object v7, p0, Ljd;->g:Landroid/view/View;

    invoke-direct/range {v0 .. v7}, Ljd;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljd;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 95
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 54
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 55
    iget-object v0, p0, Ljd;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Ljd;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 57
    iget-object v0, p0, Ljd;->g:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->bringToFront()V

    .line 59
    :cond_0
    return-void
.end method
