.class public Ljh;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:Landroid/view/View;

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private l:I

.field private m:I

.field private n:Lcom/bestbuy/android/api/lib/models/registry/Recommendations;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 25
    iput-object p3, p0, Ljh;->j:Landroid/view/View;

    .line 26
    iput-object p4, p0, Ljh;->a:Ljava/lang/String;

    .line 27
    iput p5, p0, Ljh;->m:I

    .line 28
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 39
    iget-object v0, p0, Ljh;->a:Ljava/lang/String;

    iget v1, p0, Ljh;->m:I

    invoke-static {v0, v1}, Lfs;->a(Ljava/lang/String;I)Lcom/bestbuy/android/api/lib/models/registry/Recommendations;

    move-result-object v0

    iput-object v0, p0, Ljh;->n:Lcom/bestbuy/android/api/lib/models/registry/Recommendations;

    .line 40
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    .line 44
    iget-object v0, p0, Ljh;->j:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Ljh;->j:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 47
    :cond_0
    iget-object v0, p0, Ljh;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljh;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 48
    iget-object v0, p0, Ljh;->n:Lcom/bestbuy/android/api/lib/models/registry/Recommendations;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;->getSkuList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Ljh;->k:Ljava/util/ArrayList;

    .line 49
    iget-object v0, p0, Ljh;->n:Lcom/bestbuy/android/api/lib/models/registry/Recommendations;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;->getTotal()I

    move-result v0

    iput v0, p0, Ljh;->l:I

    .line 50
    iget-object v0, p0, Ljh;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v1, p0, Ljh;->k:Ljava/util/ArrayList;

    iget v2, p0, Ljh;->l:I

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/util/ArrayList;I)V

    .line 52
    :cond_1
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 31
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 32
    iget-object v0, p0, Ljh;->j:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Ljh;->j:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 35
    :cond_0
    return-void
.end method
