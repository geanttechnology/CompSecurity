.class Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->a(Z)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;)V
    .locals 0

    .prologue
    .line 329
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment$1;->a:Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4

    .prologue
    .line 332
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 333
    new-instance v1, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    const/4 v0, 0x0

    invoke-direct {v1, v0}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;-><init>(Z)V

    .line 334
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment$1;->a:Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 335
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 336
    const v2, 0x7f0c0033

    const-string v3, "EmptyWeddingRegistryContainer"

    invoke-virtual {v0, v2, v1, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 337
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 338
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 339
    return-void
.end method
