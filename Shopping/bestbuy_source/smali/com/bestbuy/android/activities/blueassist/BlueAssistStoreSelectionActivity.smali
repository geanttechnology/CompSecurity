.class public Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"

# interfaces
.implements Lahx;
.implements Landroid/view/View$OnClickListener;
.implements Lqo;
.implements Lqp;


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private A:Z

.field private B:Ljava/lang/String;

.field private C:Ljava/lang/String;

.field private D:Ljava/lang/String;

.field private E:Ljava/lang/String;

.field private F:Ljava/lang/String;

.field private G:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field

.field private b:Lnb;

.field private c:Landroid/widget/FrameLayout;

.field private d:Landroid/widget/ImageView;

.field private e:Landroid/widget/ImageView;

.field private f:Lqm;

.field private g:Z

.field private h:I

.field private i:D

.field private j:D

.field private k:Z

.field private l:Landroid/view/View;

.field private m:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

.field private n:Z

.field private o:Ljava/lang/String;

.field private p:Z

.field private q:I

.field private r:Z

.field private s:Landroid/widget/SearchView;

.field private t:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private u:Landroid/widget/LinearLayout;

.field private v:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;

.field private w:Landroid/widget/ImageView;

.field private x:Landroid/widget/ImageView;

.field private y:Landroid/widget/RelativeLayout;

.field private z:Lcom/bestbuy/android/bbyobjects/BBYTextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 61
    const-class v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 57
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 67
    iput v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->h:I

    .line 70
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->k:Z

    .line 74
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->n:Z

    .line 76
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->p:Z

    .line 77
    iput v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->q:I

    .line 78
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->r:Z

    .line 93
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->G:Ljava/util/ArrayList;

    return-void
.end method

.method private a(DD)V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 278
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->g:Z

    .line 279
    iput-wide p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->i:D

    .line 280
    iput-wide p3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->j:D

    .line 281
    new-instance v0, Lhx;

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->l:Landroid/view/View;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3, p4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object v1, p0

    move-object v6, v2

    invoke-direct/range {v0 .. v6}, Lhx;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhx;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 282
    return-void
.end method

.method private b()V
    .locals 2

    .prologue
    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->l:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 213
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

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->f:Lqm;

    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->f:Lqm;

    invoke-interface {v0}, Lqm;->b()V

    .line 219
    return-void
.end method

.method private c()V
    .locals 4

    .prologue
    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->v:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;

    if-nez v0, :cond_0

    .line 254
    new-instance v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->G:Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;-><init>(Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->v:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;

    .line 255
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->d:Landroid/widget/ImageView;

    const v1, 0x7f020045

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 256
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->k:Z

    if-eqz v0, :cond_1

    .line 257
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->d:Landroid/widget/ImageView;

    const v1, 0x7f020046

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 258
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 259
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->k:Z

    .line 270
    :goto_0
    return-void

    .line 262
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->k:Z

    .line 263
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x7f0c0033

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->v:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_0
.end method

.method private d()V
    .locals 4

    .prologue
    .line 273
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->l:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 274
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->b:Lnb;

    invoke-virtual {v0}, Lnb;->y()D

    move-result-wide v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->b:Lnb;

    invoke-virtual {v2}, Lnb;->z()D

    move-result-wide v2

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->a(DD)V

    .line 275
    return-void
.end method

.method private e()Z
    .locals 2

    .prologue
    .line 320
    const-string v0, "location"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 321
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private f()V
    .locals 3

    .prologue
    .line 325
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 340
    :goto_0
    return-void

    .line 328
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 329
    const-string v1, "<font face = \'Sans-Serif\'>Location providers are disabled. Please enable it from your device\'s Location settings.</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 331
    const-string v1, "<font face = \'Sans-Serif\'>OK</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity$2;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity$2;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 338
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    .line 339
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 245
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 246
    const-string v1, "bb.apErrorCode"

    const-string v2, "Bad location"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 247
    sget-object v1, Llu;->aN:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 249
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->u:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 250
    return-void
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V
    .locals 4

    .prologue
    .line 410
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 411
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 412
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080050

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 413
    iget-boolean v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->A:Z

    if-eqz v2, :cond_0

    .line 414
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080141

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->B:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 415
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080143

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->C:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 416
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080144

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->D:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 417
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080140

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->E:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 418
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800b9

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->F:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 420
    :cond_0
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 421
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->startActivity(Landroid/content/Intent;)V

    .line 422
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 8

    .prologue
    const/4 v1, 0x1

    const/4 v7, 0x0

    const/4 v2, 0x0

    .line 221
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->o:Ljava/lang/String;

    .line 222
    iput v7, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->h:I

    .line 223
    invoke-static {p1}, Lnr;->c(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 224
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v6

    .line 226
    :goto_0
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 228
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->r:Z

    .line 229
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->g:Z

    .line 230
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->k:Z

    if-eqz v0, :cond_1

    .line 231
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->v:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;

    .line 234
    :goto_1
    new-instance v0, Lhx;

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->l:Landroid/view/View;

    move-object v1, p0

    move-object v4, v2

    move-object v5, v2

    invoke-direct/range {v0 .. v6}, Lhx;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhx;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 237
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 238
    const-string v1, "bb.searchTerm"

    invoke-virtual {v0, v1, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 239
    const-string v1, "bb.numResults"

    const-string v2, "25"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 240
    sget-object v1, Llu;->aa:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 241
    return-void

    .line 233
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->m:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    goto :goto_1

    :cond_2
    move-object v6, p1

    goto :goto_0
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 374
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->G:Ljava/util/ArrayList;

    .line 375
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->v:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;

    iget v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->h:I

    invoke-virtual {v0, p1, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->a(Ljava/util/ArrayList;I)V

    .line 376
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->m:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    iget v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->h:I

    iget-boolean v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->n:Z

    invoke-virtual {v0, p0, p1, v1, v2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->a(Landroid/app/Activity;Ljava/util/ArrayList;IZ)V

    .line 377
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2

    .prologue
    .line 380
    const/16 v0, 0x3e8

    if-ne p1, v0, :cond_0

    .line 381
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->e()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 383
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->e:Landroid/widget/ImageView;

    const v1, 0x7f0200d9

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 384
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->d()V

    .line 390
    :cond_0
    :goto_0
    return-void

    .line 386
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->e:Landroid/widget/ImageView;

    const v1, 0x7f0200da

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method

.method public onBackPressed()V
    .locals 3

    .prologue
    .line 394
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 395
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v1

    const/4 v2, 0x1

    if-le v1, v2, :cond_0

    .line 396
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 399
    :goto_0
    return-void

    .line 398
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->finish()V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 344
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->d:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_1

    .line 345
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->e()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 346
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->c()V

    .line 370
    :cond_0
    :goto_0
    return-void

    .line 348
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->e:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_3

    .line 349
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->l:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 350
    sget-object v0, Llu;->ah:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 351
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->e()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 352
    iput v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->h:I

    .line 353
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->r:Z

    .line 354
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->d()V

    goto :goto_0

    .line 356
    :cond_2
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->f()V

    goto :goto_0

    .line 358
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->t:Lcom/bestbuy/android/bbyobjects/BBYButton;

    if-ne p1, v0, :cond_4

    .line 359
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.LOCATION_SOURCE_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 360
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 361
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->x:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_5

    .line 362
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->finish()V

    goto :goto_0

    .line 363
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->w:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_0

    .line 364
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 365
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 366
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->startActivity(Landroid/content/Intent;)V

    .line 367
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->finish()V

    .line 368
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 311
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->f:Lqm;

    sget-object v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->REQUEST:Lcom/google/android/gms/location/LocationRequest;

    invoke-interface {v0, v1, v2, p0}, Lahr;->a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;

    .line 312
    return-void
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 3

    .prologue
    .line 298
    invoke-virtual {p1}, Lpp;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 300
    const/16 v0, 0x2328

    :try_start_0
    invoke-virtual {p1, p0, v0}, Lpp;->a(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 307
    :goto_0
    return-void

    .line 301
    :catch_0
    move-exception v0

    .line 302
    invoke-virtual {v0}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    goto :goto_0

    .line 305
    :cond_0
    sget-object v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->a:Ljava/lang/String;

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
    .line 316
    sget-object v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->a:Ljava/lang/String;

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

    .line 317
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const v5, 0x7f0c0033

    const v4, -0x777778

    const/4 v3, 0x0

    .line 97
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 98
    const v0, 0x7f030014

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->setContentView(I)V

    .line 99
    sget-object v0, Llu;->aM:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 100
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->b:Lnb;

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->b:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->i(Z)V

    .line 102
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 103
    const-string v0, "input_method"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 104
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 105
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 107
    :cond_0
    const v0, 0x7f0c0032

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SearchView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    .line 108
    const v0, 0x7f0c0034

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->u:Landroid/widget/LinearLayout;

    .line 110
    const v0, 0x7f0c0037

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->t:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 111
    const v0, 0x7f0c0067

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->w:Landroid/widget/ImageView;

    .line 112
    const v0, 0x7f0c0068

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->x:Landroid/widget/ImageView;

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->t:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->w:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->x:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    const v1, 0x7f080352

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/SearchView;->setQueryHint(Ljava/lang/CharSequence;)V

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->onActionViewExpanded()V

    .line 118
    const-string v0, "search"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/SearchManager;

    .line 119
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/app/SearchManager;->getSearchableInfo(Landroid/content/ComponentName;)Landroid/app/SearchableInfo;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->setSearchableInfo(Landroid/app/SearchableInfo;)V

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "android:id/search_src_text"

    invoke-virtual {v0, v1, v3, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 121
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 122
    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 123
    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setHintTextColor(I)V

    .line 124
    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "android:id/search_plate"

    invoke-virtual {v0, v1, v3, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 126
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 127
    if-eqz v0, :cond_1

    .line 128
    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 130
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 131
    if-eqz v0, :cond_2

    .line 132
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 133
    if-eqz v0, :cond_2

    .line 134
    const-string v1, "blueassist_update"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->A:Z

    .line 135
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080141

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->B:Ljava/lang/String;

    .line 136
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080143

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->C:Ljava/lang/String;

    .line 137
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080144

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->D:Ljava/lang/String;

    .line 138
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080140

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->E:Ljava/lang/String;

    .line 139
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800b9

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->F:Ljava/lang/String;

    .line 144
    :cond_2
    :try_start_0
    const-string v0, "blueassist_storelist"

    invoke-static {p0, v0}, Lnj;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->G:Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 149
    :goto_0
    :try_start_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "android:id/search_mag_icon"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 150
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 151
    if-eqz v0, :cond_3

    .line 152
    const v1, 0x7f02017f

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 153
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "android:id/search_close_btn"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 154
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    invoke-virtual {v1, v0}, Landroid/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 155
    if-eqz v0, :cond_4

    .line 156
    const v1, 0x7f02017e

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 161
    :cond_4
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->s:Landroid/widget/SearchView;

    new-instance v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity$1;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/SearchView;->setOnQueryTextListener(Landroid/widget/SearchView$OnQueryTextListener;)V

    .line 174
    invoke-virtual {p0, v5}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->c:Landroid/widget/FrameLayout;

    .line 175
    const v0, 0x7f0c0069

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->d:Landroid/widget/ImageView;

    .line 176
    const v0, 0x7f0c0031

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->e:Landroid/widget/ImageView;

    .line 177
    const v0, 0x7f0c0064

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->l:Landroid/view/View;

    .line 179
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->d:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->e:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->G:Ljava/util/ArrayList;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->G:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 182
    :cond_5
    new-instance v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->v:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;

    .line 183
    new-instance v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;-><init>(Landroid/app/Activity;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->m:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    .line 184
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->b()V

    .line 189
    :goto_2
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 190
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 191
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->m:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    const-string v2, "BlueAssistStoreListFragment"

    invoke-virtual {v0, v5, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 192
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 193
    const v0, 0x7f0c0020

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->y:Landroid/widget/RelativeLayout;

    .line 194
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->y:Landroid/widget/RelativeLayout;

    const v1, 0x7f0c015e

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->z:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->y:Landroid/widget/RelativeLayout;

    const v1, 0x7f0c015f

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 196
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->z:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v2, 0x7f08021f

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 197
    const v1, 0x7f0802fa

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 198
    sget-object v0, Llu;->aL:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 199
    return-void

    .line 145
    :catch_0
    move-exception v0

    .line 146
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 157
    :catch_1
    move-exception v0

    .line 158
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 186
    :cond_6
    new-instance v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->G:Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;-><init>(Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->v:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;

    .line 187
    new-instance v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->G:Ljava/util/ArrayList;

    invoke-direct {v0, p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->m:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    goto :goto_2
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1

    .prologue
    .line 403
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 404
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->onBackPressed()V

    .line 406
    :cond_0
    invoke-super {p0, p1, p2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public onLocationChanged(Landroid/location/Location;)V
    .locals 4

    .prologue
    .line 286
    if-eqz p1, :cond_0

    .line 288
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->b:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->a(D)V

    .line 289
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->b:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->b(D)V

    .line 290
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->f:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 291
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->f:Lqm;

    invoke-interface {v0, v1, p0}, Lahr;->a(Lqm;Lahx;)Lqq;

    .line 293
    :cond_0
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->d()V

    .line 294
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 203
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 204
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->e()Z

    move-result v0

    if-nez v0, :cond_0

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->l:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 207
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->e:Landroid/widget/ImageView;

    const v1, 0x7f0200da

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 209
    :cond_0
    return-void
.end method
