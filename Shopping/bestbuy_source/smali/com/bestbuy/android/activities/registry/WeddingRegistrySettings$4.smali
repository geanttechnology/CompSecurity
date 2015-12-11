.class Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->f()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)V
    .locals 0

    .prologue
    .line 653
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 6

    .prologue
    .line 657
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 658
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 659
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;Ljava/lang/String;)Ljava/lang/String;

    .line 660
    new-instance v0, Ljc;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v3}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/view/View;

    move-result-object v3

    const-string v4, "weddingregistrylists"

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v5}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->j(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Ljc;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljc;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 661
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 662
    const-string v1, "Registry List Name"

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 663
    const-string v1, "Registry List Type"

    const-string v2, "weddingregistrylists"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 664
    const-string v1, "Registry List UUID"

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->j(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 665
    sget-object v1, Llu;->at:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 667
    :cond_0
    return-void
.end method
