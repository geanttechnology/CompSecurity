.class Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


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
    .line 107
    iput-object p1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$3;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 109
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x10

    if-ne v0, v1, :cond_0

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$3;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;Z)Z

    .line 114
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$3;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$3;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->e(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$3;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v0

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setEnabled(Z)V

    .line 119
    :goto_1
    return-void

    .line 112
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$3;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;Z)Z

    goto :goto_0

    .line 117
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$3;->a:Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setEnabled(Z)V

    goto :goto_1
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 120
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 121
    return-void
.end method
