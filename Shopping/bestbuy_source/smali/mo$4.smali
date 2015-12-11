.class Lmo$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;Landroid/view/View;)V
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Landroid/content/Context;

.field final synthetic c:Lcom/bestbuy/android/base/BBYBaseFragment;

.field final synthetic d:Lcom/bestbuy/android/api/lib/models/registry/Entities;

.field final synthetic e:Lmo;


# direct methods
.method constructor <init>(Lmo;Landroid/view/View;Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/Entities;)V
    .locals 0

    .prologue
    .line 197
    iput-object p1, p0, Lmo$4;->e:Lmo;

    iput-object p2, p0, Lmo$4;->a:Landroid/view/View;

    iput-object p3, p0, Lmo$4;->b:Landroid/content/Context;

    iput-object p4, p0, Lmo$4;->c:Lcom/bestbuy/android/base/BBYBaseFragment;

    iput-object p5, p0, Lmo$4;->d:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    .line 200
    iget-object v0, p0, Lmo$4;->e:Lmo;

    invoke-static {v0}, Lmo;->a(Lmo;)Ljb;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lmo$4;->e:Lmo;

    invoke-static {v0}, Lmo;->a(Lmo;)Ljb;

    move-result-object v0

    invoke-virtual {v0}, Ljb;->getStatus()Landroid/os/AsyncTask$Status;

    move-result-object v0

    sget-object v1, Landroid/os/AsyncTask$Status;->RUNNING:Landroid/os/AsyncTask$Status;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lmo$4;->e:Lmo;

    invoke-static {v0}, Lmo;->a(Lmo;)Ljb;

    move-result-object v0

    invoke-virtual {v0}, Ljb;->getStatus()Landroid/os/AsyncTask$Status;

    move-result-object v0

    sget-object v1, Landroid/os/AsyncTask$Status;->PENDING:Landroid/os/AsyncTask$Status;

    if-ne v0, v1, :cond_1

    .line 211
    :cond_0
    :goto_0
    return-void

    .line 204
    :cond_1
    iget-object v0, p0, Lmo$4;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 205
    const/4 v6, 0x0

    .line 206
    if-eqz v0, :cond_2

    .line 207
    const v1, 0x7f0c0230

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    move-object v6, v0

    .line 209
    :cond_2
    iget-object v7, p0, Lmo$4;->e:Lmo;

    new-instance v0, Ljb;

    iget-object v1, p0, Lmo$4;->b:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    iget-object v2, p0, Lmo$4;->c:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lmo$4;->d:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentType()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lmo$4;->d:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lmo$4;->d:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getUuid()Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v6}, Ljb;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/widget/ProgressBar;)V

    invoke-static {v7, v0}, Lmo;->a(Lmo;Ljb;)Ljb;

    .line 210
    iget-object v0, p0, Lmo$4;->e:Lmo;

    invoke-static {v0}, Lmo;->a(Lmo;)Ljb;

    move-result-object v0

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljb;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
