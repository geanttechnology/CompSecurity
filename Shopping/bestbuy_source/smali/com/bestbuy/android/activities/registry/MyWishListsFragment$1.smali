.class Lcom/bestbuy/android/activities/registry/MyWishListsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/MyWishListsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/MyWishListsFragment;)V
    .locals 0

    .prologue
    .line 115
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment$1;->a:Lcom/bestbuy/android/activities/registry/MyWishListsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment$1;->a:Lcom/bestbuy/android/activities/registry/MyWishListsFragment;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->a(Ljava/lang/String;)V

    .line 119
    return-void
.end method
