.class public Lij;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:D

.field private k:D

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    sput v0, Lij;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDLjava/lang/String;)V
    .locals 2

    .prologue
    .line 31
    invoke-direct {p0, p1, p2, p3}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 26
    const/4 v0, 0x0

    iput-object v0, p0, Lij;->m:Ljava/util/ArrayList;

    .line 32
    iput-object p8, p0, Lij;->a:Ljava/lang/String;

    .line 33
    iput-wide p4, p0, Lij;->j:D

    .line 34
    iput-wide p6, p0, Lij;->k:D

    .line 35
    return-void
.end method


# virtual methods
.method public a()V
    .locals 9

    .prologue
    .line 46
    iget-object v1, p0, Lij;->f:Landroid/app/Activity;

    iget-wide v2, p0, Lij;->j:D

    iget-wide v4, p0, Lij;->k:D

    iget-object v6, p0, Lij;->a:Ljava/lang/String;

    const/4 v7, 0x1

    const/16 v8, 0x19

    invoke-static/range {v1 .. v8}, Lfs;->a(Landroid/app/Activity;DDLjava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    .line 47
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lij;->m:Ljava/util/ArrayList;

    .line 55
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 59
    iget-object v0, p0, Lij;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lij;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 62
    :cond_0
    const/4 v0, 0x0

    sput v0, Lij;->l:I

    .line 64
    iget-object v0, p0, Lij;->m:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    .line 65
    iget-object v0, p0, Lij;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lij;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 75
    :cond_1
    :goto_0
    return-void

    .line 68
    :cond_2
    iget-object v0, p0, Lij;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lij;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 69
    iget-object v0, p0, Lij;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v1, p0, Lij;->m:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 73
    :cond_3
    invoke-virtual {p0}, Lij;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Lij;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 80
    iget-object v0, p0, Lij;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 83
    :cond_0
    iget-object v0, p0, Lij;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lij;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 98
    :cond_1
    :goto_0
    return-void

    .line 95
    :cond_2
    iget-object v0, p0, Lij;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lij;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 96
    iget-object v0, p0, Lij;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    const-string v1, "that location"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 38
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 39
    iget-object v0, p0, Lij;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 40
    iget-object v0, p0, Lij;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 42
    :cond_0
    return-void
.end method
