.class public Lcr;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

.field private b:Landroid/widget/EditText;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 236
    iput-object p1, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 237
    iput-object p2, p0, Lcr;->b:Landroid/widget/EditText;

    .line 238
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 254
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 255
    iget-object v1, p0, Lcr;->b:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 281
    :goto_0
    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->a(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;)Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;)Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;)Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->d(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 282
    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->e(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z

    .line 285
    :goto_1
    return-void

    .line 257
    :pswitch_0
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 258
    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->a(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z

    goto :goto_0

    .line 260
    :cond_0
    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->a(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z

    goto :goto_0

    .line 263
    :pswitch_1
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 264
    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z

    goto :goto_0

    .line 266
    :cond_1
    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z

    goto :goto_0

    .line 269
    :pswitch_2
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 270
    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z

    goto :goto_0

    .line 272
    :cond_2
    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z

    goto :goto_0

    .line 275
    :pswitch_3
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 276
    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->d(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z

    goto :goto_0

    .line 278
    :cond_3
    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->d(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z

    goto :goto_0

    .line 284
    :cond_4
    iget-object v0, p0, Lcr;->a:Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->e(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z

    goto :goto_1

    .line 255
    nop

    :pswitch_data_0
    .packed-switch 0x7f0c00a7
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 244
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 250
    return-void
.end method
