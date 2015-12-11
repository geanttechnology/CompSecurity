.class public Ldb;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

.field private b:Landroid/widget/EditText;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 346
    iput-object p1, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 347
    iput-object p2, p0, Ldb;->b:Landroid/widget/EditText;

    .line 348
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 363
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 364
    iget-object v1, p0, Ldb;->b:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getId()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 403
    :goto_0
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_6

    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_6

    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_6

    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->e(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_6

    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->f(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_6

    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->g(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_6

    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->h(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 404
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    .line 405
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    .line 411
    :goto_1
    return-void

    .line 366
    :sswitch_0
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 367
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto :goto_0

    .line 369
    :cond_0
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto :goto_0

    .line 372
    :sswitch_1
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 373
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->e(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto :goto_0

    .line 375
    :cond_1
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->e(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto :goto_0

    .line 378
    :sswitch_2
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 379
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->f(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto :goto_0

    .line 381
    :cond_2
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->f(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto :goto_0

    .line 384
    :sswitch_3
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x4

    if-le v0, v1, :cond_3

    .line 385
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->g(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto/16 :goto_0

    .line 388
    :cond_3
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->g(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto/16 :goto_0

    .line 391
    :sswitch_4
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 392
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->h(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto/16 :goto_0

    .line 394
    :cond_4
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->h(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto/16 :goto_0

    .line 397
    :sswitch_5
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_5

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0xe

    if-ne v0, v1, :cond_5

    .line 398
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->i(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto/16 :goto_0

    .line 400
    :cond_5
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->i(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto/16 :goto_0

    .line 408
    :cond_6
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    .line 409
    iget-object v0, p0, Ldb;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto/16 :goto_1

    .line 364
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0c00a7 -> :sswitch_0
        0x7f0c00a8 -> :sswitch_1
        0x7f0c0374 -> :sswitch_4
        0x7f0c03e8 -> :sswitch_2
        0x7f0c03ea -> :sswitch_3
        0x7f0c03eb -> :sswitch_5
    .end sparse-switch
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 353
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 359
    return-void
.end method
