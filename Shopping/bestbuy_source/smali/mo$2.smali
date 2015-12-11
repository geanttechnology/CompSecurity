.class final Lmo$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmo;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Lcom/bestbuy/android/api/lib/models/registry/Entities;Lmp;Landroid/view/View;Z)V
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Lmp;

.field final synthetic c:Z

.field final synthetic d:Landroid/content/Context;

.field final synthetic e:Lcom/bestbuy/android/base/BBYBaseFragment;

.field final synthetic f:Lcom/bestbuy/android/api/lib/models/registry/Entities;


# direct methods
.method constructor <init>(Landroid/view/View;Lmp;ZLandroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/Entities;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lmo$2;->a:Landroid/view/View;

    iput-object p2, p0, Lmo$2;->b:Lmp;

    iput-boolean p3, p0, Lmo$2;->c:Z

    iput-object p4, p0, Lmo$2;->d:Landroid/content/Context;

    iput-object p5, p0, Lmo$2;->e:Lcom/bestbuy/android/base/BBYBaseFragment;

    iput-object p6, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10

    .prologue
    const/4 v6, 0x1

    const/4 v9, 0x0

    .line 147
    iget-object v0, p0, Lmo$2;->a:Landroid/view/View;

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

    .line 148
    const/4 v7, 0x0

    .line 149
    if-eqz v0, :cond_0

    .line 150
    const v1, 0x7f0c0230

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    move-object v7, v0

    .line 153
    :cond_0
    iget-object v0, p0, Lmo$2;->b:Lmp;

    iget-object v0, v0, Lmp;->a:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getTag()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "Favorite this"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 154
    iget-boolean v0, p0, Lmo$2;->c:Z

    if-eqz v0, :cond_2

    .line 155
    new-instance v0, Ljv;

    iget-object v1, p0, Lmo$2;->d:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    iget-object v2, p0, Lmo$2;->e:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentUuid()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentType()Ljava/lang/String;

    move-result-object v5

    iget-object v8, p0, Lmo$2;->b:Lmp;

    invoke-direct/range {v0 .. v8}, Ljv;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/ProgressBar;Lmp;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljv;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 168
    :cond_1
    :goto_0
    return-void

    .line 158
    :cond_2
    new-instance v0, Ljv;

    iget-object v1, p0, Lmo$2;->d:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    iget-object v2, p0, Lmo$2;->e:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentUuid()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentType()Ljava/lang/String;

    move-result-object v5

    iget-object v8, p0, Lmo$2;->b:Lmp;

    invoke-direct/range {v0 .. v8}, Ljv;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/ProgressBar;Lmp;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljv;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 161
    :cond_3
    iget-object v0, p0, Lmo$2;->b:Lmp;

    iget-object v0, v0, Lmp;->a:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getTag()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "My Favorite"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 162
    new-instance v0, Ljv;

    iget-object v1, p0, Lmo$2;->d:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    iget-object v2, p0, Lmo$2;->e:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentUuid()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentType()Ljava/lang/String;

    move-result-object v5

    iget-object v8, p0, Lmo$2;->b:Lmp;

    move v6, v9

    invoke-direct/range {v0 .. v8}, Ljv;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/ProgressBar;Lmp;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljv;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 164
    :cond_4
    iget-object v0, p0, Lmo$2;->b:Lmp;

    iget-object v0, v0, Lmp;->a:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getTag()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "Our Favorite"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 165
    new-instance v0, Ljv;

    iget-object v1, p0, Lmo$2;->d:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    iget-object v2, p0, Lmo$2;->e:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentUuid()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lmo$2;->f:Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getParentType()Ljava/lang/String;

    move-result-object v5

    iget-object v8, p0, Lmo$2;->b:Lmp;

    move v6, v9

    invoke-direct/range {v0 .. v8}, Ljv;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/ProgressBar;Lmp;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljv;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0
.end method
