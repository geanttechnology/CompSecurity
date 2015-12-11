.class Lcom/bestbuy/android/activities/registry/FindRegistry$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/FindRegistry;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/FindRegistry;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/FindRegistry;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/FindRegistry$2;->a:Lcom/bestbuy/android/activities/registry/FindRegistry;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 76
    new-instance v1, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;-><init>()V

    .line 77
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 78
    const-string v0, "data"

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/FindRegistry$2;->a:Lcom/bestbuy/android/activities/registry/FindRegistry;

    invoke-static {v3}, Lcom/bestbuy/android/activities/registry/FindRegistry;->a(Lcom/bestbuy/android/activities/registry/FindRegistry;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/FindRegistry$2;->a:Lcom/bestbuy/android/activities/registry/FindRegistry;

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/FindRegistry;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 80
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->setArguments(Landroid/os/Bundle;)V

    .line 81
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v2, 0x7f0c0033

    invoke-virtual {v0, v2, v1}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 82
    return-void
.end method
