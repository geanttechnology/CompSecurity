.class Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)V
    .locals 0

    .prologue
    .line 170
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->a(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->a(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 179
    :goto_0
    return-void

    .line 176
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->a(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->a(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0801ea

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0
.end method
