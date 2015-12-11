.class Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$2;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 97
    new-instance v0, Lmf;

    invoke-direct {v0}, Lmf;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$2;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d:Landroid/app/Activity;

    const-string v2, "GIFT_CARD"

    iget-object v3, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$2;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->c(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lmf;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    return-void
.end method
