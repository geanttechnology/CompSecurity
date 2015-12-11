.class Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$1;
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
    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$1;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$1;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d:Landroid/app/Activity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 88
    iget-object v1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$1;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$1;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->b(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)V

    .line 90
    return-void
.end method
