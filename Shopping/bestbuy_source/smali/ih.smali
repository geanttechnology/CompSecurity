.class public Lih;
.super Lka;
.source "SourceFile"


# static fields
.field private static a:I


# instance fields
.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const/4 v0, 0x0

    sput v0, Lih;->a:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Landroid/view/View;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 22
    iput-object p3, p0, Lih;->g:Landroid/view/View;

    .line 23
    iput-object p4, p0, Lih;->j:Ljava/util/ArrayList;

    .line 24
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lih;->j:Ljava/util/ArrayList;

    invoke-static {v0}, Lfs;->a(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lih;->k:Ljava/util/ArrayList;

    .line 41
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 60
    iget-object v0, p0, Lih;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lih;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 63
    :cond_0
    iget-object v0, p0, Lih;->k:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lih;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 64
    const/4 v0, 0x0

    sput v0, Lih;->a:I

    .line 65
    iget-object v0, p0, Lih;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lih;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 66
    iget-object v0, p0, Lih;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    iget-object v1, p0, Lih;->k:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a(Ljava/util/ArrayList;)V

    .line 70
    :cond_1
    :goto_0
    return-void

    .line 68
    :cond_2
    invoke-virtual {p0}, Lih;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 51
    iget-object v0, p0, Lih;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lih;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 54
    :cond_0
    iget-object v0, p0, Lih;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lih;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 55
    iget-object v0, p0, Lih;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->b()V

    .line 56
    :cond_1
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 45
    sget v0, Lih;->a:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lih;->a:I

    .line 46
    new-instance v0, Lih;

    iget-object v1, p0, Lih;->f:Landroid/app/Activity;

    iget-object v2, p0, Lih;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lih;->g:Landroid/view/View;

    iget-object v4, p0, Lih;->j:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v3, v4}, Lih;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lih;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 47
    return-void
.end method

.method public e()V
    .locals 0

    .prologue
    .line 35
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 27
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 28
    iget-object v0, p0, Lih;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 29
    iget-object v0, p0, Lih;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 31
    :cond_0
    return-void
.end method
