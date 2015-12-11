.class public Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"

# interfaces
.implements Lahx;
.implements Landroid/view/View$OnClickListener;
.implements Lbu;
.implements Lqo;
.implements Lqp;


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Lnb;

.field private c:Landroid/widget/SearchView;

.field private d:Landroid/widget/LinearLayout;

.field private e:Landroid/widget/ImageView;

.field private f:Landroid/widget/ImageView;

.field private g:I

.field private h:Z

.field private i:Landroid/view/View;

.field private j:Z

.field private k:D

.field private l:D

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field

.field private n:Ljz;

.field private o:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

.field private p:Lqm;

.field private q:Z

.field private r:Landroid/widget/RelativeLayout;

.field private s:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private t:Ljava/lang/String;

.field private u:Landroid/widget/FrameLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 62
    const-class v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 59
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 67
    iput v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->g:I

    .line 68
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->h:Z

    .line 72
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->m:Ljava/util/ArrayList;

    .line 76
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->q:Z

    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->t:Ljava/lang/String;

    return-object p1
.end method

.method private a(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation

    .prologue
    .line 269
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 270
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 271
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v3

    .line 272
    if-eqz v3, :cond_0

    .line 273
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLocationSubType()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Mobile Store"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 274
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 278
    :cond_1
    return-object v1
.end method

.method private a(DD)V
    .locals 11

    .prologue
    .line 221
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->j:Z

    .line 222
    iput-wide p1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->k:D

    .line 223
    iput-wide p3, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->l:D

    .line 224
    new-instance v0, Ljz;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->i:Landroid/view/View;

    iget v8, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->g:I

    const/16 v9, 0x32

    move-object v1, p0

    move-wide v4, p1

    move-wide v6, p3

    invoke-direct/range {v0 .. v9}, Ljz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDII)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->n:Ljz;

    .line 225
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->n:Ljz;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 226
    return-void
.end method

.method private b()Z
    .locals 2

    .prologue
    .line 200
    const-string v0, "location"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 201
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private c()V
    .locals 2

    .prologue
    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->i:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 206
    new-instance v0, Lqn;

    invoke-direct {v0, p0}, Lqn;-><init>(Landroid/content/Context;)V

    sget-object v1, Lahy;->a:Lpx;

    invoke-virtual {v0, v1}, Lqn;->a(Lpx;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqo;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqp;)Lqn;

    move-result-object v0

    invoke-virtual {v0}, Lqn;->b()Lqm;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->p:Lqm;

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->p:Lqm;

    invoke-interface {v0}, Lqm;->b()V

    .line 212
    return-void
.end method

.method private d()V
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 215
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->i:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    const-string v1, ""

    invoke-virtual {v0, v1, v2}, Landroid/widget/SearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->b:Lnb;

    invoke-virtual {v0}, Lnb;->y()D

    move-result-wide v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->b:Lnb;

    invoke-virtual {v2}, Lnb;->z()D

    move-result-wide v2

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a(DD)V

    .line 218
    return-void
.end method

.method private e()V
    .locals 3

    .prologue
    .line 229
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 244
    :goto_0
    return-void

    .line 232
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 233
    const-string v1, "<font face = \'Sans-Serif\'>Location providers are disabled. Please enable it from your device\'s Location settings.</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 235
    const-string v1, "<font face = \'Sans-Serif\'>OK</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$2;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$2;-><init>(Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 242
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    .line 243
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 283
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->u:Landroid/widget/FrameLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 284
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->d:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 285
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->d:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0035

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 286
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->t:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 287
    return-void
.end method

.method public a(IIIZI)V
    .locals 10

    .prologue
    .line 359
    if-eqz p4, :cond_0

    .line 360
    if-le p3, p5, :cond_0

    .line 362
    const/4 p4, 0x0

    .line 365
    :cond_0
    if-nez p4, :cond_1

    sub-int v0, p3, p2

    if-ne p1, v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->q:Z

    if-eqz v0, :cond_1

    .line 366
    iget v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->g:I

    add-int/lit8 v0, v0, 0xa

    iput v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->g:I

    .line 367
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->h:Z

    if-eqz v0, :cond_2

    .line 368
    iget-object v4, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->t:Ljava/lang/String;

    .line 369
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 370
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->j:Z

    .line 371
    new-instance v0, Ljy;

    const/4 v2, 0x0

    const/4 v3, 0x0

    iget v5, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->g:I

    const/16 v6, 0x32

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Ljy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;II)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 381
    :cond_1
    :goto_0
    return-void

    .line 374
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->n:Ljz;

    if-eqz v0, :cond_1

    .line 375
    new-instance v0, Ljz;

    const/4 v2, 0x0

    const/4 v3, 0x0

    iget-wide v4, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->k:D

    iget-wide v6, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->l:D

    iget v8, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->g:I

    const/16 v9, 0x32

    move-object v1, p0

    invoke-direct/range {v0 .. v9}, Ljz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDII)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->n:Ljz;

    .line 376
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->n:Ljz;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V
    .locals 3

    .prologue
    .line 348
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 349
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 350
    const-string v2, "SelectedStore"

    invoke-virtual {v1, v2, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 351
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 352
    const/4 v1, -0x1

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->setResult(ILandroid/content/Intent;)V

    .line 353
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->finish()V

    .line 354
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->overridePendingTransition(II)V

    .line 355
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 8

    .prologue
    const/4 v1, 0x1

    const/4 v7, 0x0

    .line 185
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->t:Ljava/lang/String;

    .line 186
    iput v7, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->g:I

    .line 187
    invoke-static {p1}, Lnr;->c(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 188
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v4

    .line 190
    :goto_0
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 192
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->h:Z

    .line 193
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->j:Z

    .line 194
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->o:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    .line 195
    new-instance v0, Ljy;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->i:Landroid/view/View;

    iget v5, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->g:I

    const/16 v6, 0x32

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Ljy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;II)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 197
    :cond_0
    return-void

    :cond_1
    move-object v4, p1

    goto :goto_0
.end method

.method public a(Ljava/util/ArrayList;Z)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    const/16 v3, 0x8

    .line 259
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    .line 260
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->u:Landroid/widget/FrameLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 261
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->d:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 262
    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->m:Ljava/util/ArrayList;

    .line 263
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->q:Z

    .line 264
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->r:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 265
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->o:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    iget v2, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->g:I

    invoke-virtual {v1, p0, v0, v2, p2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->a(Landroid/app/Activity;Ljava/util/ArrayList;IZ)V

    .line 266
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2

    .prologue
    .line 247
    const/16 v0, 0x3e8

    if-ne p1, v0, :cond_0

    .line 248
    invoke-direct {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 249
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->f:Landroid/widget/ImageView;

    const v1, 0x7f0200d9

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 250
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->r:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 256
    :cond_0
    :goto_0
    return-void

    .line 252
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->f:Landroid/widget/ImageView;

    const v1, 0x7f0200da

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->r:Landroid/widget/RelativeLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 291
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->f:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_2

    .line 292
    invoke-direct {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->b()Z

    move-result v0

    if-nez v0, :cond_1

    .line 293
    invoke-direct {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->e()V

    .line 309
    :cond_0
    :goto_0
    return-void

    .line 295
    :cond_1
    iput v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->g:I

    .line 296
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->h:Z

    .line 297
    invoke-direct {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->d()V

    goto :goto_0

    .line 299
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->e:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_3

    .line 300
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 301
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 302
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->startActivity(Landroid/content/Intent;)V

    .line 303
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->finish()V

    .line 304
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->overridePendingTransition(II)V

    goto :goto_0

    .line 305
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->s:Lcom/bestbuy/android/bbyobjects/BBYButton;

    if-ne p1, v0, :cond_0

    .line 306
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.LOCATION_SOURCE_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 307
    const/16 v1, 0x3e8

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 314
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->p:Lqm;

    sget-object v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->REQUEST:Lcom/google/android/gms/location/LocationRequest;

    invoke-interface {v0, v1, v2, p0}, Lahr;->a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;

    .line 315
    return-void
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 3

    .prologue
    .line 324
    invoke-virtual {p1}, Lpp;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 326
    const/16 v0, 0x2328

    :try_start_0
    invoke-virtual {p1, p0, v0}, Lpp;->a(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 333
    :goto_0
    return-void

    .line 327
    :catch_0
    move-exception v0

    .line 328
    invoke-virtual {v0}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    goto :goto_0

    .line 331
    :cond_0
    sget-object v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services connection failed with code "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lpp;->c()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onConnectionSuspended(I)V
    .locals 3

    .prologue
    .line 319
    sget-object v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services suspended cause:  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 7

    .prologue
    const v6, 0x7f0c0033

    const/4 v5, 0x0

    const v4, -0x777778

    const/4 v3, 0x0

    .line 98
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 99
    const v0, 0x7f030002

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->setContentView(I)V

    .line 100
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->b:Lnb;

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->b:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->i(Z)V

    .line 102
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 104
    const v0, 0x7f0c0032

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SearchView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    .line 105
    const v0, 0x7f0c0034

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->d:Landroid/widget/LinearLayout;

    .line 106
    const v0, 0x7f0c0036

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->r:Landroid/widget/RelativeLayout;

    .line 107
    invoke-virtual {p0, v6}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->u:Landroid/widget/FrameLayout;

    .line 108
    const v0, 0x7f0c0031

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->f:Landroid/widget/ImageView;

    .line 109
    const v0, 0x7f0c0030

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->e:Landroid/widget/ImageView;

    .line 110
    const v0, 0x7f0c0064

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->i:Landroid/view/View;

    .line 111
    const v0, 0x7f0c0037

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->s:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    const v1, 0x7f080352

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/SearchView;->setQueryHint(Ljava/lang/CharSequence;)V

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->onActionViewExpanded()V

    .line 115
    const-string v0, "search"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/SearchManager;

    .line 116
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/app/SearchManager;->getSearchableInfo(Landroid/content/ComponentName;)Landroid/app/SearchableInfo;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->setSearchableInfo(Landroid/app/SearchableInfo;)V

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "android:id/search_src_text"

    invoke-virtual {v0, v1, v3, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 118
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 119
    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 120
    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setHintTextColor(I)V

    .line 121
    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "android:id/search_plate"

    invoke-virtual {v0, v1, v3, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 123
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 124
    if-eqz v0, :cond_0

    .line 125
    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 129
    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "android:id/search_mag_icon"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 130
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 131
    if-eqz v0, :cond_1

    .line 132
    const v1, 0x7f02017f

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 133
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "android:id/search_close_btn"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 134
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 135
    if-eqz v0, :cond_2

    .line 136
    const v1, 0x7f02017e

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 141
    :cond_2
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c:Landroid/widget/SearchView;

    new-instance v1, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$1;-><init>(Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/SearchView;->setOnQueryTextListener(Landroid/widget/SearchView$OnQueryTextListener;)V

    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->m:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 161
    :cond_3
    new-instance v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;-><init>(Landroid/app/Activity;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->o:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    .line 162
    invoke-direct {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->c()V

    .line 167
    :goto_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 168
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 169
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->o:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    const-string v2, "BlueAssistStoreListFragment"

    invoke-virtual {v0, v6, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 170
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 172
    invoke-direct {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->b()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->r:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->i:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    .line 179
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->f:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->e:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->s:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 182
    return-void

    .line 137
    :catch_0
    move-exception v0

    .line 138
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 164
    :cond_4
    new-instance v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->m:Ljava/util/ArrayList;

    invoke-direct {v0, p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->o:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    goto :goto_1

    .line 176
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->r:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_2
.end method

.method public onLocationChanged(Landroid/location/Location;)V
    .locals 4

    .prologue
    .line 337
    if-eqz p1, :cond_0

    .line 338
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->b:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->a(D)V

    .line 339
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->b:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->b(D)V

    .line 340
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->p:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 341
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->p:Lqm;

    invoke-interface {v0, v1, p0}, Lahr;->a(Lqm;Lahx;)Lqq;

    .line 343
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->r:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 344
    invoke-direct {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->d()V

    .line 345
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 84
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 85
    invoke-direct {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->b()Z

    move-result v0

    if-nez v0, :cond_0

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->i:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->r:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->f:Landroid/widget/ImageView;

    const v1, 0x7f0200da

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 90
    :cond_0
    const-string v0, "input_method"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 91
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 92
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 94
    :cond_1
    return-void
.end method
