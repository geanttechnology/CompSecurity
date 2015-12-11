.class Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->e()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)V
    .locals 0

    .prologue
    .line 289
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 10

    .prologue
    .line 292
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->b(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v2

    .line 293
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->f(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    .line 294
    const-string v0, ""

    .line 295
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->g(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v4, "Public"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 296
    const-string v0, "public"

    move-object v1, v0

    .line 300
    :goto_0
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->h(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 301
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->i(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 302
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->j(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 303
    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->k(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 304
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v7}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->l(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/Spinner;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 305
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v8}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->e(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/EditText;

    move-result-object v8

    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    .line 308
    iget-object v9, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v9}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v9

    if-eqz v9, :cond_2

    .line 309
    iget-object v9, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v9}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v9

    invoke-virtual {v9, v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setListType(Ljava/lang/String;)V

    .line 310
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setRegistryName(Ljava/lang/String;)V

    .line 311
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setPrivacySetting(Ljava/lang/String;)V

    .line 312
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v1

    invoke-virtual {v1, v4}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setShippingAddress(Ljava/lang/String;)V

    .line 313
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v1

    invoke-virtual {v1, v5}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddDescription(Ljava/lang/String;)V

    .line 314
    if-eqz v0, :cond_0

    .line 315
    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 316
    array-length v2, v1

    const/4 v3, 0x3

    if-lt v2, v3, :cond_0

    .line 317
    const/4 v0, 0x0

    aget-object v0, v1, v0

    .line 319
    :cond_0
    const-string v1, "Select"

    invoke-virtual {v7, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 321
    const-string v1, ""

    .line 322
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventState(Ljava/lang/String;)V

    .line 326
    :goto_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventLocation(Ljava/lang/String;)V

    .line 327
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v0

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventCity(Ljava/lang/String;)V

    .line 328
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v0

    invoke-virtual {v0, v8}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventDate(Ljava/lang/String;)V

    .line 329
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->b(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setUuid(Ljava/lang/String;)V

    .line 330
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setRecepient(Lcom/bestbuy/android/api/lib/models/registry/Recipient;)V

    .line 331
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    if-eqz v0, :cond_1

    .line 332
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getFirstName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setFirstName(Ljava/lang/String;)V

    .line 333
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setLastName(Ljava/lang/String;)V

    .line 335
    :cond_1
    new-instance v0, Ljr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->m(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Ljr;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljr;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 340
    :cond_2
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->b(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->setRecipient(Lcom/bestbuy/android/api/lib/models/registry/Recipient;)V

    .line 341
    return-void

    .line 297
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->g(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v4, "Private"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 298
    const-string v0, "private"

    move-object v1, v0

    goto/16 :goto_0

    .line 324
    :cond_4
    :try_start_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v1

    invoke-virtual {v1, v7}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventState(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    .line 337
    :catch_0
    move-exception v0

    .line 338
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2

    :cond_5
    move-object v1, v0

    goto/16 :goto_0
.end method
