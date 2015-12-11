.class public Ldi;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

.field private b:Landroid/widget/EditText;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 398
    iput-object p1, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 399
    iput-object p2, p0, Ldi;->b:Landroid/widget/EditText;

    .line 400
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 413
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 414
    iget-object v1, p0, Ldi;->b:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getId()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 441
    :goto_0
    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->c(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->f(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->e(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->g(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 442
    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->b(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z

    .line 445
    :goto_1
    return-void

    .line 416
    :sswitch_0
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 417
    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->c(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z

    goto :goto_0

    .line 419
    :cond_0
    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->c(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z

    goto :goto_0

    .line 422
    :sswitch_1
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x4

    if-le v0, v1, :cond_1

    .line 423
    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z

    goto :goto_0

    .line 426
    :cond_1
    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z

    goto :goto_0

    .line 429
    :sswitch_2
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 430
    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->e(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z

    goto :goto_0

    .line 432
    :cond_2
    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->e(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z

    goto :goto_0

    .line 435
    :sswitch_3
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0xe

    if-ne v0, v1, :cond_3

    .line 436
    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->f(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z

    goto :goto_0

    .line 438
    :cond_3
    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->f(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z

    goto/16 :goto_0

    .line 444
    :cond_4
    iget-object v0, p0, Ldi;->a:Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->b(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z

    goto :goto_1

    .line 414
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0c0374 -> :sswitch_2
        0x7f0c03e8 -> :sswitch_0
        0x7f0c03ea -> :sswitch_1
        0x7f0c03eb -> :sswitch_3
    .end sparse-switch
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 404
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 409
    return-void
.end method
