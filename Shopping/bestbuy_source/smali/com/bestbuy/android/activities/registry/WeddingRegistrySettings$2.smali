.class Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)V
    .locals 0

    .prologue
    .line 238
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 241
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->b(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    .line 242
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->c(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 243
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 244
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->e(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 245
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->f(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 246
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->g(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/widget/Spinner;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 247
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_0

    .line 248
    const/4 v6, 0x2

    invoke-virtual {v0, v7, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 251
    :cond_0
    const-string v6, ""

    .line 252
    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v6}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v6

    invoke-virtual {v6, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setEventDate(Ljava/lang/String;)V

    .line 253
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setRegistryName(Ljava/lang/String;)V

    .line 254
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v2

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddDescription(Ljava/lang/String;)V

    .line 255
    if-eqz v1, :cond_1

    .line 256
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 257
    array-length v3, v2

    if-le v3, v8, :cond_1

    .line 258
    aget-object v1, v2, v7

    .line 261
    :cond_1
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setEventLocation(Ljava/lang/String;)V

    .line 262
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v1

    invoke-virtual {v1, v5}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setEventCity(Ljava/lang/String;)V

    .line 263
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setEventState(Ljava/lang/String;)V

    .line 264
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;Ljava/lang/String;)Ljava/lang/String;

    .line 265
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->j(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->j(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 266
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    const-string v1, "sharedPrefs"

    invoke-virtual {v0, v1, v7}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 268
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    const-string v2, "LIST_UUID"

    const-string v3, ""

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;Ljava/lang/String;)Ljava/lang/String;

    .line 270
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->j(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setUuid(Ljava/lang/String;)V

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    const-string v1, "weddingregistrylists"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setListType(Ljava/lang/String;)V

    .line 277
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->k(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "BestBuy.com, Best Buy Stores"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 278
    const-string v0, "public"

    .line 281
    :goto_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setPrivacySetting(Ljava/lang/String;)V

    .line 282
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->k(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "BestBuy.com, Best Buy Stores, TheKnot.com"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 283
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    invoke-virtual {v0, v8}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setTheKnot(Z)V

    .line 284
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setMyregistry(Z)V

    .line 296
    :cond_4
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    if-eqz v0, :cond_5

    .line 297
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getFirstName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setFirstName(Ljava/lang/String;)V

    .line 298
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setLastName(Ljava/lang/String;)V

    .line 300
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    if-eqz v0, :cond_6

    .line 301
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCoRegistrantFirstName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCoregistrantFirstName(Ljava/lang/String;)V

    .line 302
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCoRegistrantLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCoregistrantLastName(Ljava/lang/String;)V

    .line 305
    :cond_6
    new-instance v0, Ljq;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v3}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v4}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Ljq;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 307
    return-void

    .line 280
    :cond_7
    const-string v0, "private"

    goto/16 :goto_0

    .line 285
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->k(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "BestBuy.com, Best Buy Stores, MyRegistry.com"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 286
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setTheKnot(Z)V

    .line 287
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    invoke-virtual {v0, v8}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setMyregistry(Z)V

    goto/16 :goto_1

    .line 288
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->k(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "BestBuy.com, Best Buy Stores, TheKnot.com, MyRegistry.com"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 289
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    invoke-virtual {v0, v8}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setTheKnot(Z)V

    .line 290
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    invoke-virtual {v0, v8}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setMyregistry(Z)V

    goto/16 :goto_1

    .line 291
    :cond_a
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->k(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "BestBuy.com, Best Buy Stores"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 292
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setTheKnot(Z)V

    .line 293
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-result-object v0

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setMyregistry(Z)V

    goto/16 :goto_1
.end method
