.class Lcom/bestbuy/android/activities/mybby/CIALoginFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$3;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$3;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$3;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f040005

    const v2, 0x7f040008

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentActivity;->overridePendingTransition(II)V

    .line 186
    return-void
.end method
