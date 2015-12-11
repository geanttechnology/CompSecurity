.class public Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private a:Landroid/widget/EditText;

.field private b:Landroid/widget/EditText;

.field private c:Landroid/widget/TextView;

.field private g:Landroid/widget/EditText;

.field private h:Landroid/widget/EditText;

.field private i:Landroid/widget/Spinner;

.field private j:Landroid/widget/EditText;

.field private k:Landroid/widget/RelativeLayout;

.field private l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

.field private m:Ljava/util/Calendar;

.field private n:Landroid/app/DatePickerDialog$OnDateSetListener;

.field private o:Landroid/view/View;

.field private p:Landroid/widget/RelativeLayout;

.field private q:Landroid/widget/ImageView;

.field private r:Landroid/widget/ImageView;

.field private s:Ljava/lang/String;

.field private t:Ljava/lang/String;

.field private u:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private v:I


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V
    .locals 0

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 66
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 67
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 70
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 71
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->s:Ljava/lang/String;

    .line 72
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;)Ljava/util/Calendar;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->m:Ljava/util/Calendar;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->j:Landroid/widget/EditText;

    return-object v0
.end method

.method private b()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 196
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 197
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v8}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 199
    :cond_0
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 200
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 201
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->b:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 202
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->g:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 203
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->h:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->i:Landroid/widget/Spinner;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 205
    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->j:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 206
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v7, v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setShippingAddress(Ljava/lang/String;)V

    .line 207
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddDescription(Ljava/lang/String;)V

    .line 208
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventLocation(Ljava/lang/String;)V

    .line 209
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v2, v5}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventCity(Ljava/lang/String;)V

    .line 210
    if-eqz v0, :cond_4

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_4

    const-string v2, "Select a state"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 211
    const-string v0, ""

    .line 215
    :cond_1
    :goto_0
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventState(Ljava/lang/String;)V

    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventDate(Ljava/lang/String;)V

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setCreatedBy(Ljava/lang/String;)V

    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setLastModifiedBy(Ljava/lang/String;)V

    .line 219
    const-string v0, "data"

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->s:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->s:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 222
    :cond_2
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 223
    const-string v1, "bb.createList"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 224
    sget-object v1, Llu;->z:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 227
    :cond_3
    new-instance v0, Lja;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->o:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-direct {v0, v1, p0, v2, v3}, Lja;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lja;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 228
    return-void

    .line 212
    :cond_4
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 213
    const-string v2, "-"

    invoke-virtual {v0, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v8, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 231
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->u:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 232
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->s:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->s:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 233
    new-instance v0, Liy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v3, 0x0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->s:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v6

    const-string v7, "1"

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Liy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 238
    :goto_0
    return-void

    .line 236
    :cond_0
    invoke-virtual {p0, v8}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->b(Z)V

    goto :goto_0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V
    .locals 3

    .prologue
    .line 162
    if-eqz p1, :cond_3

    .line 163
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine1()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine2()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getCity()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getPhone()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getZipCode()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getState()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a:Landroid/widget/EditText;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine1()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine2()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getCity()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getState()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getZipCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getPhone()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine1()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressLine1(Ljava/lang/String;)V

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine2()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressLine2(Ljava/lang/String;)V

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getCity()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setCity(Ljava/lang/String;)V

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getPhone()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setPhone(Ljava/lang/String;)V

    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getState()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setState(Ljava/lang/String;)V

    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getZipCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setZipCode(Ljava/lang/String;)V

    .line 174
    :cond_0
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getEventDate()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->j:Landroid/widget/EditText;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getEventDate()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getEventDate()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventDate(Ljava/lang/String;)V

    .line 178
    :cond_1
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getEventLocation()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 179
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->g:Landroid/widget/EditText;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getEventLocation()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getEventLocation()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventLocation(Ljava/lang/String;)V

    .line 182
    :cond_2
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddDescription()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->b:Landroid/widget/EditText;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddDescription(Ljava/lang/String;)V

    .line 187
    :cond_3
    return-void
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;I)V
    .locals 0

    .prologue
    .line 318
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 319
    iput p2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->v:I

    .line 320
    return-void
.end method

.method public a(Z)V
    .locals 1

    .prologue
    .line 241
    if-eqz p1, :cond_0

    .line 242
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->b(Z)V

    .line 244
    :cond_0
    return-void
.end method

.method public b(Z)V
    .locals 9

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 247
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 248
    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v4

    .line 249
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    move v3, v1

    .line 250
    :goto_0
    if-ltz v3, :cond_7

    .line 251
    invoke-interface {v4, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/app/Fragment;

    .line 252
    instance-of v2, v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v2, :cond_2

    .line 253
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getTag()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getTag()Ljava/lang/String;

    move-result-object v1

    const-string v2, "RegistryAndGiftsFragment"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 254
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 250
    :cond_0
    :goto_1
    add-int/lit8 v1, v3, -0x1

    move v3, v1

    goto :goto_0

    .line 256
    :cond_1
    new-instance v1, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;-><init>()V

    .line 257
    const-string v2, "MyWishListsFragment"

    invoke-virtual {v0, v1, v7, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto :goto_1

    .line 261
    :cond_2
    if-nez p1, :cond_5

    .line 262
    const-string v2, "mywishlistsfragment"

    .line 266
    :goto_2
    if-eqz v1, :cond_3

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getTag()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 267
    :cond_3
    instance-of v1, v1, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;

    if-eqz v1, :cond_6

    .line 268
    sput-boolean v8, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->a:Z

    .line 269
    sput-boolean v8, Lcom/bestbuy/android/activities/home/HomeActivity;->inPDPFragment:Z

    .line 270
    sput-boolean v7, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    .line 271
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 272
    if-eqz p1, :cond_4

    .line 273
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 274
    const-string v2, "bb.prevPageLink"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->f()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "Create a Wishlist"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v2, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 275
    const-string v2, "bb.createList"

    const-string v5, "1"

    invoke-virtual {v1, v2, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 276
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Llu;->L:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->t:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 278
    :cond_4
    new-instance v1, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->u:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v1, v7, p0, v2}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;-><init>(ZLcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 279
    const-string v2, "WishListWithProductsFragment"

    invoke-virtual {v0, v1, v7, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto :goto_1

    .line 264
    :cond_5
    const-string v2, "WishListFragmentContainer"

    goto :goto_2

    .line 281
    :cond_6
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    goto/16 :goto_1

    .line 286
    :cond_7
    return-void
.end method

.method public g()V
    .locals 0

    .prologue
    .line 191
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->b()V

    .line 192
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 158
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 159
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 3

    .prologue
    .line 76
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 77
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    move-object v0, p1

    .line 78
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f0800a3

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 79
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    if-eqz v0, :cond_0

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->t:Ljava/lang/String;

    .line 82
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Llu;->O:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->t:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 85
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 290
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a:Landroid/widget/EditText;

    if-eq p1, v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->q:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_4

    .line 291
    :cond_0
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    const/4 v3, 0x0

    iget v4, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->v:I

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->s:Ljava/lang/String;

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Lcom/bestbuy/android/base/BBYBaseFragment;ZILjava/lang/String;)V

    .line 292
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 293
    instance-of v1, v2, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-eqz v1, :cond_1

    move-object v1, v2

    .line 294
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v1, v0, v6}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 296
    :cond_1
    instance-of v1, v2, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v1, :cond_2

    move-object v1, v2

    .line 297
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v1, v0, v6}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 299
    :cond_2
    instance-of v1, v2, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v1, :cond_3

    .line 300
    check-cast v2, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v2, v0, v6}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 315
    :cond_3
    :goto_0
    return-void

    .line 302
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->r:Landroid/widget/ImageView;

    if-eq p1, v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->j:Landroid/widget/EditText;

    if-ne p1, v0, :cond_6

    .line 303
    :cond_5
    new-instance v0, Landroid/app/DatePickerDialog;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->n:Landroid/app/DatePickerDialog$OnDateSetListener;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->m:Ljava/util/Calendar;

    invoke-virtual {v3, v6}, Ljava/util/Calendar;->get(I)I

    move-result v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->m:Ljava/util/Calendar;

    const/4 v5, 0x2

    invoke-virtual {v4, v5}, Ljava/util/Calendar;->get(I)I

    move-result v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->m:Ljava/util/Calendar;

    const/4 v6, 0x5

    invoke-virtual {v5, v6}, Ljava/util/Calendar;->get(I)I

    move-result v5

    invoke-direct/range {v0 .. v5}, Landroid/app/DatePickerDialog;-><init>(Landroid/content/Context;Landroid/app/DatePickerDialog$OnDateSetListener;III)V

    .line 307
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->getDatePicker()Landroid/widget/DatePicker;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    sub-long/2addr v2, v4

    invoke-virtual {v1, v2, v3}, Landroid/widget/DatePicker;->setMinDate(J)V

    .line 308
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->getDatePicker()Landroid/widget/DatePicker;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide v4, 0x757b12c00L

    add-long/2addr v2, v4

    invoke-virtual {v1, v2, v3}, Landroid/widget/DatePicker;->setMaxDate(J)V

    .line 309
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->show()V

    goto :goto_0

    .line 310
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->k:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_7

    .line 311
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->b()V

    goto :goto_0

    .line 312
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->p:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_3

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 89
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 90
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    .line 104
    const v0, 0x7f030117

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 105
    const v0, 0x7f0c0076

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->p:Landroid/widget/RelativeLayout;

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v2, 0x10

    invoke-virtual {v0, v2}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 107
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->o:Landroid/view/View;

    .line 108
    const v0, 0x7f0c0411

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->q:Landroid/widget/ImageView;

    .line 109
    const v0, 0x7f0c041e

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->r:Landroid/widget/ImageView;

    .line 110
    const v0, 0x7f0c0410

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a:Landroid/widget/EditText;

    .line 111
    const v0, 0x7f0c0413

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->b:Landroid/widget/EditText;

    .line 112
    const v0, 0x7f0c0415

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->c:Landroid/widget/TextView;

    .line 113
    const v0, 0x7f0c0416

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->g:Landroid/widget/EditText;

    .line 114
    const v0, 0x7f0c0418

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->h:Landroid/widget/EditText;

    .line 115
    const v0, 0x7f0c041a

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->i:Landroid/widget/Spinner;

    .line 116
    const v0, 0x7f0c041d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->j:Landroid/widget/EditText;

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a:Landroid/widget/EditText;

    invoke-virtual {v0, p0}, Landroid/widget/EditText;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->q:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 119
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->m:Ljava/util/Calendar;

    .line 120
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions$1;-><init>(Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->n:Landroid/app/DatePickerDialog$OnDateSetListener;

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->r:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->j:Landroid/widget/EditText;

    invoke-virtual {v0, p0}, Landroid/widget/EditText;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 140
    const v0, 0x7f0c0420

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->k:Landroid/widget/RelativeLayout;

    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->k:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->p:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->t:Ljava/lang/String;

    const-string v2, "school"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->c:Landroid/widget/TextView;

    const v2, 0x7f0802ec

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(I)V

    .line 148
    :goto_0
    return-object v1

    .line 146
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->c:Landroid/widget/TextView;

    const v2, 0x7f080216

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 152
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f08014a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 155
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 94
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 95
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchVisibility(Landroid/app/Activity;Z)V

    .line 96
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f0800a3

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 97
    sput-boolean v3, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f08014a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V

    .line 100
    return-void
.end method
