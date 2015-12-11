.class Lmo$6;
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

.field final synthetic e:Lmp;

.field final synthetic f:Lmo;


# direct methods
.method constructor <init>(Lmo;Landroid/view/View;Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;)V
    .locals 0

    .prologue
    .line 233
    iput-object p1, p0, Lmo$6;->f:Lmo;

    iput-object p2, p0, Lmo$6;->a:Landroid/view/View;

    iput-object p3, p0, Lmo$6;->b:Landroid/content/Context;

    iput-object p4, p0, Lmo$6;->c:Lcom/bestbuy/android/base/BBYBaseFragment;

    iput-object p5, p0, Lmo$6;->d:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    iput-object p6, p0, Lmo$6;->e:Lmp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10

    .prologue
    const/16 v9, 0xa

    .line 236
    iget-object v0, p0, Lmo$6;->f:Lmo;

    invoke-static {v0}, Lmo;->b(Lmo;)I

    move-result v0

    if-ge v0, v9, :cond_1

    .line 237
    iget-object v0, p0, Lmo$6;->f:Lmo;

    iget-object v1, p0, Lmo$6;->f:Lmo;

    invoke-static {v1}, Lmo;->b(Lmo;)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-static {v0, v1}, Lmo;->a(Lmo;I)I

    .line 238
    iget-object v0, p0, Lmo$6;->a:Landroid/view/View;

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

    .line 239
    const/4 v7, 0x0

    .line 240
    if-eqz v0, :cond_0

    .line 241
    const v1, 0x7f0c0230

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    move-object v7, v0

    .line 243
    :cond_0
    new-instance v0, Ljw;

    iget-object v1, p0, Lmo$6;->b:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    iget-object v2, p0, Lmo$6;->c:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lmo$6;->d:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentUuid()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lmo$6;->d:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lmo$6;->d:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentType()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lmo$6;->f:Lmo;

    invoke-static {v6}, Lmo;->b(Lmo;)I

    move-result v6

    iget-object v8, p0, Lmo$6;->e:Lmp;

    invoke-direct/range {v0 .. v8}, Ljw;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/widget/ProgressBar;Lmp;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljw;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 245
    :cond_1
    iget-object v0, p0, Lmo$6;->f:Lmo;

    invoke-static {v0}, Lmo;->b(Lmo;)I

    move-result v0

    if-ne v0, v9, :cond_2

    .line 246
    iget-object v0, p0, Lmo$6;->e:Lmp;

    iget-object v0, v0, Lmp;->c:Landroid/widget/ImageView;

    const v1, 0x7f020007

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 248
    :cond_2
    return-void
.end method
