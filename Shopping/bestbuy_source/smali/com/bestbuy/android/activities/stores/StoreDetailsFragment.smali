.class public Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Llg;


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

.field private b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

.field private c:Landroid/widget/LinearLayout;

.field private g:Landroid/widget/LinearLayout;

.field private h:Landroid/widget/LinearLayout;

.field private i:Lhm;

.field private j:Ljava/lang/String;

.field private k:Landroid/view/View;

.field private l:Landroid/view/View;

.field private m:Lnb;

.field private n:Landroid/view/View;

.field private o:Landroid/widget/RelativeLayout;

.field private p:Landroid/widget/RelativeLayout;

.field private q:Lcom/bestbuy/android/activities/stores/DialogSpinner;

.field private r:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private s:Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;

.field private t:Landroid/widget/RelativeLayout;

.field private u:Ljava/lang/String;

.field private v:Landroid/widget/LinearLayout;

.field private w:Landroid/widget/FrameLayout;

.field private x:Ldy;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 79
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 80
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/store/BBYStore;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 86
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 87
    iput-object p2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->j:Ljava/lang/String;

    .line 88
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 89
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 82
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 83
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->j:Ljava/lang/String;

    .line 84
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->r:Ljava/util/ArrayList;

    return-object v0
.end method

.method private a(Landroid/net/Uri;)V
    .locals 3

    .prologue
    .line 313
    new-instance v0, Llf;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->u:Ljava/lang/String;

    invoke-direct {v0, v1, p1, v2, p0}, Llf;-><init>(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Llg;)V

    .line 314
    invoke-virtual {v0}, Llf;->show()V

    .line 315
    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->l:Landroid/view/View;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->s:Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    return-object v0
.end method

.method private d()V
    .locals 6

    .prologue
    const/4 v5, 0x6

    const/4 v4, 0x3

    .line 318
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 319
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getPhone()Ljava/lang/String;

    move-result-object v1

    .line 320
    const-string v2, "\\D"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 321
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v1, v5, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 323
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "<font face = \'Sans-Serif\'>"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "</font>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 324
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800e0

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$2;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$2;-><init>(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 333
    const-string v1, "<font face = \'Sans-Serif\'>Cancel</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$3;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$3;-><init>(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 340
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 341
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 342
    const v1, 0x102000b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 343
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 344
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 225
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->s:Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->q:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setVisibility(I)V

    .line 227
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;->getCategories()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->r:Ljava/util/ArrayList;

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->r:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    .line 230
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->r:Ljava/util/ArrayList;

    const-string v1, "site_wide"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 231
    if-ltz v0, :cond_0

    .line 232
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->r:Ljava/util/ArrayList;

    invoke-static {v1, v5, v0}, Ljava/util/Collections;->swap(Ljava/util/List;II)V

    .line 233
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 234
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->r:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 235
    const-string v3, "site_wide"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 236
    const-string v3, "site_wide"

    const-string v4, "All Products"

    invoke-virtual {v0, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 238
    :cond_1
    const-string v3, "&amp;"

    const-string v4, "&"

    invoke-virtual {v0, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 241
    :cond_2
    new-instance v0, Landroid/widget/ArrayAdapter;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    const v3, 0x7f03002c

    invoke-direct {v0, v2, v3, v1}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 242
    const v1, 0x1090009

    invoke-virtual {v0, v1}, Landroid/widget/ArrayAdapter;->setDropDownViewResource(I)V

    .line 243
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->q:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 246
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->r:Ljava/util/ArrayList;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->r:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->r:Ljava/util/ArrayList;

    const-string v1, "error"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->q:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setVisibility(I)V

    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->t:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 250
    :cond_4
    return-void
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/remix/Store;)V
    .locals 3

    .prologue
    .line 220
    new-instance v0, Llh;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-direct {v0, v1, v2, p1}, Llh;-><init>(Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/store/BBYStore;Lcom/bestbuy/android/api/lib/models/remix/Store;)V

    .line 221
    invoke-virtual {v0}, Llh;->show()V

    .line 222
    return-void
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V
    .locals 10

    .prologue
    const v4, 0x7f0c03d3

    const v3, 0x7f0c03d2

    const v9, 0x7f0c03d0

    const/4 v6, 0x1

    const/4 v8, 0x0

    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->k:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->k:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 193
    :cond_0
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 194
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080344

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 195
    new-array v1, v6, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v8

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 196
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLocationSubType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Mobile Store"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "MOST POPULAR"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const v1, 0x7f02001a

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->o:Landroid/widget/RelativeLayout;

    const v1, 0x7f020031

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 200
    new-instance v0, Lhg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->l:Landroid/view/View;

    const-string v4, "abcat0800000"

    const/4 v5, 0x0

    const/16 v7, 0xa

    move-object v2, p0

    invoke-direct/range {v0 .. v8}, Lhg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;IIZ)V

    .line 201
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhg;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 208
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    const v1, 0x7f0c010e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "<i>Welcome to: </i>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 210
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, " - "

    const-string v2, "\n"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 211
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLocationSubType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "Mobile Store"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "BEST BUY MOBILE \n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 216
    :goto_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getCity()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getState()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getZipCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->u:Ljava/lang/String;

    .line 217
    return-void

    .line 203
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "BEST DEALS HERE"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const v1, 0x7f020022

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    .line 205
    new-instance v0, Lhm;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->l:Landroid/view/View;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, p0, v2, v3}, Lhm;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->i:Lhm;

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->i:Lhm;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhm;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 214
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/16 v7, 0x8

    const/4 v4, 0x1

    const/4 v6, 0x0

    .line 253
    if-eqz p1, :cond_2

    .line 254
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    const-string v5, "stores"

    move-object v2, p1

    move-object v3, p0

    invoke-direct/range {v0 .. v5}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->x:Ldy;

    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->x:Ldy;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 256
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    invoke-static {v1}, Lll;->a(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->startAnimation(Landroid/view/animation/Animation;)V

    .line 257
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v4, :cond_0

    .line 258
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPagingEnabled(Z)V

    .line 259
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->t:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 260
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setVisibility(I)V

    .line 261
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLocationSubType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Mobile Store"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 262
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "store"

    const-string v2, "storeloadmostpopular"

    invoke-virtual {v0, v1, v2, p1}, Lcom/bestbuy/android/activities/home/HomeActivity;->loadMostPopularRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 272
    :cond_1
    :goto_0
    return-void

    .line 269
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setVisibility(I)V

    .line 270
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->t:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 355
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 275
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->w:Landroid/widget/FrameLayout;

    if-eqz v0, :cond_0

    .line 276
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->w:Landroid/widget/FrameLayout;

    invoke-static {v0}, Lll;->a(Landroid/view/View;)V

    .line 280
    :cond_0
    return-void
.end method

.method public c()Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    .locals 1

    .prologue
    .line 358
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 103
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 104
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->m:Lnb;

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 107
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->m:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideStoresSearchActionBar(Landroid/app/Activity;)V

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 110
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 93
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 94
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    .line 95
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v1, 0x1

    .line 284
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->c:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_1

    .line 285
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->j:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->j:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 286
    new-instance v0, Ljx;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->k:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->j:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Ljx;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljx;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 310
    :cond_0
    :goto_0
    return-void

    .line 288
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->h:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_2

    .line 289
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getCity()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getState()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getZipCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 290
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0801d0

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->m:Lnb;

    invoke-virtual {v2}, Lnb;->y()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->m:Lnb;

    invoke-virtual {v2}, Lnb;->z()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&daddr="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&hl=en"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 293
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "The BBYStore driving url is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 294
    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a(Landroid/net/Uri;)V

    goto/16 :goto_0

    .line 295
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->g:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_3

    .line 296
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d()V

    goto/16 :goto_0

    .line 297
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->p:Landroid/widget/RelativeLayout;

    if-eq p1, v0, :cond_0

    .line 304
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->v:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    .line 305
    new-instance v8, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v8}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 306
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "MostPopular"

    const-string v3, "Most Popular"

    const-string v4, "abcat0800000"

    const/4 v5, 0x0

    const-string v6, "Stores"

    const/16 v7, 0xa

    invoke-direct/range {v0 .. v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 307
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v2, v8, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 308
    invoke-virtual {v8, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 98
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 99
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const v2, 0x7f0c0064

    const/4 v4, 0x0

    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    if-nez v0, :cond_1

    .line 140
    const v0, 0x7f030102

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    .line 141
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->m:Lnb;

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    const v1, 0x7f0c02ed

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->c:Landroid/widget/LinearLayout;

    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    const v1, 0x7f0c014f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->g:Landroid/widget/LinearLayout;

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    const v1, 0x7f0c03d1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->h:Landroid/widget/LinearLayout;

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->k:Landroid/view/View;

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->l:Landroid/view/View;

    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    const v1, 0x7f0c0071

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->w:Landroid/widget/FrameLayout;

    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    const v1, 0x7f0c005e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    .line 152
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    const v1, 0x7f0c03cf

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->o:Landroid/widget/RelativeLayout;

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    const v1, 0x7f0c03d5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->t:Landroid/widget/RelativeLayout;

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    const v1, 0x7f0c03d4

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/stores/DialogSpinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->q:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    const v1, 0x7f0c03d7

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->p:Landroid/widget/RelativeLayout;

    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->p:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 158
    new-instance v1, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;

    const/4 v0, 0x1

    const-string v2, "MORE DEALS HERE"

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v0, v2, v3}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;)V

    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    const v2, 0x7f0c0073

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->v:Landroid/widget/LinearLayout;

    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->v:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 162
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v2, 0x7f0c03d6

    invoke-virtual {v0, v2, v1}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->j:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->j:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 164
    new-instance v0, Ljx;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->k:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->j:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Ljx;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljx;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 167
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->p:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->q:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    new-instance v1, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$1;-><init>(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 186
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->w:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v4}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 187
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    return-object v0

    .line 166
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V

    goto :goto_0

    .line 184
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->n:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_1
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 119
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->m:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 123
    return-void
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 114
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroyView()V

    .line 115
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 126
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 128
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->j:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->j:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 130
    new-instance v0, Ljx;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->k:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->j:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Ljx;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljx;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 132
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->x:Ldy;

    if-eqz v0, :cond_1

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->x:Ldy;

    invoke-virtual {v0}, Ldy;->notifyDataSetChanged()V

    .line 135
    :cond_1
    return-void
.end method
