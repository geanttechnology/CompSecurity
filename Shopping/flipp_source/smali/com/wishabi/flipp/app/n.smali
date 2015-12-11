.class public Lcom/wishabi/flipp/app/n;
.super Lcom/wishabi/flipp/app/dl;
.source "SourceFile"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/wishabi/flipp/app/dl;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private c:Landroid/support/v7/widget/RecyclerView;

.field private d:Landroid/view/View;

.field private e:[I

.field private f:Z

.field private g:Z

.field private h:Lcom/wishabi/flipp/b/p;

.field private i:I

.field private j:Landroid/database/Cursor;

.field private k:Lcom/wishabi/flipp/widget/aa;

.field private l:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;>;"
        }
    .end annotation
.end field

.field private m:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/wishabi/flipp/content/b;",
            ">;"
        }
    .end annotation
.end field

.field private n:Lcom/wishabi/flipp/widget/ae;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 79
    const-class v0, Lcom/wishabi/flipp/app/n;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/app/n;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Lcom/wishabi/flipp/app/dl;-><init>()V

    return-void
.end method

.method public static a([IZLcom/wishabi/flipp/b/p;)Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 59
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 60
    const-string v1, "SAVE_STATE_COUPON_IDS_KEY"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    .line 61
    const-string v1, "SAVE_STATE_SHOW_ASSOCIATION_KEY"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 62
    const-string v1, "SAVE_STATE_SOURCE"

    iget v2, p2, Lcom/wishabi/flipp/b/p;->j:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 63
    return-object v0
.end method

.method public static a(Landroid/os/Bundle;)Lcom/wishabi/flipp/app/n;
    .locals 1

    .prologue
    .line 74
    new-instance v0, Lcom/wishabi/flipp/app/n;

    invoke-direct {v0}, Lcom/wishabi/flipp/app/n;-><init>()V

    .line 75
    invoke-virtual {v0, p0}, Lcom/wishabi/flipp/app/n;->setArguments(Landroid/os/Bundle;)V

    .line 76
    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/n;)Lcom/wishabi/flipp/widget/aa;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->k:Lcom/wishabi/flipp/widget/aa;

    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/n;Ljava/util/HashMap;)Ljava/util/HashMap;
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/wishabi/flipp/app/n;->m:Ljava/util/HashMap;

    return-object p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/n;I)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 53
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/n;->getActivity()Landroid/app/Activity;

    move-result-object v2

    if-eqz v2, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->k:Lcom/wishabi/flipp/widget/aa;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->l:Ljava/util/HashMap;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->k:Lcom/wishabi/flipp/widget/aa;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/aa;->d(I)Lcom/wishabi/flipp/content/c;

    move-result-object v1

    if-eqz v1, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->l:Ljava/util/HashMap;

    iget v3, v1, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    sget-object v3, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    if-eqz v1, :cond_1

    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    const-string v5, "coupon_id"

    iget v1, v1, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v5, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, ""

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_3

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/o;

    iget v0, v0, Lcom/wishabi/flipp/content/o;->a:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_0
    const-string v0, ","

    invoke-static {v1, v0}, Lcom/wishabi/flipp/util/q;->a(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_1
    const-string v1, "matchup_ids"

    invoke-virtual {v4, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "matchup_feedback"

    invoke-virtual {v3, v0, v4, v6}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    :cond_1
    const v0, 0x7f030046

    const/4 v1, 0x0

    invoke-static {v2, v0, v1}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_2

    const v0, 0x7f0b00c2

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const v3, 0x7f0e0080

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(I)V

    new-instance v0, Landroid/widget/Toast;

    invoke-direct {v0, v2}, Landroid/widget/Toast;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, v1}, Landroid/widget/Toast;->setView(Landroid/view/View;)V

    const/16 v1, 0x50

    const/16 v2, 0xa

    invoke-static {v2}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v2

    invoke-virtual {v0, v1, v6, v2}, Landroid/widget/Toast;->setGravity(III)V

    invoke-virtual {v0, v6}, Landroid/widget/Toast;->setDuration(I)V

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    :cond_2
    return-void

    :cond_3
    move-object v0, v1

    goto :goto_1
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/n;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->l:Ljava/util/HashMap;

    return-object v0
.end method

.method private b()V
    .locals 7

    .prologue
    .line 449
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/n;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 450
    if-nez v1, :cond_1

    .line 515
    :cond_0
    :goto_0
    return-void

    .line 453
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->j:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 456
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->m:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    .line 459
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/n;->f:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->l:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    .line 462
    :cond_2
    new-instance v2, Lcom/wishabi/flipp/content/d;

    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->j:Landroid/database/Cursor;

    invoke-direct {v2, v0}, Lcom/wishabi/flipp/content/d;-><init>(Landroid/database/Cursor;)V

    .line 463
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 464
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 465
    const/4 v0, 0x0

    .line 466
    :goto_1
    iget-object v4, p0, Lcom/wishabi/flipp/app/n;->j:Landroid/database/Cursor;

    invoke-interface {v4}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v4

    if-nez v4, :cond_3

    .line 467
    new-instance v4, Lcom/wishabi/flipp/content/c;

    iget-object v5, p0, Lcom/wishabi/flipp/app/n;->j:Landroid/database/Cursor;

    invoke-direct {v4, v5, v2}, Lcom/wishabi/flipp/content/c;-><init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/d;)V

    .line 468
    new-instance v5, Landroid/util/Pair;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-direct {v5, v6, v4}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v3, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 470
    iget-object v4, p0, Lcom/wishabi/flipp/app/n;->j:Landroid/database/Cursor;

    invoke-interface {v4}, Landroid/database/Cursor;->moveToNext()Z

    .line 471
    add-int/lit8 v0, v0, 0x1

    .line 472
    goto :goto_1

    .line 475
    :cond_3
    new-instance v0, Lcom/wishabi/flipp/app/m;

    iget-object v2, p0, Lcom/wishabi/flipp/app/n;->l:Ljava/util/HashMap;

    invoke-direct {v0, v2}, Lcom/wishabi/flipp/app/m;-><init>(Ljava/util/HashMap;)V

    .line 476
    invoke-static {v3, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 479
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 480
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/util/Pair;

    .line 481
    iget-object v0, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 484
    :cond_4
    new-instance v0, Lcom/wishabi/flipp/widget/aa;

    iget-object v3, p0, Lcom/wishabi/flipp/app/n;->l:Ljava/util/HashMap;

    iget-object v4, p0, Lcom/wishabi/flipp/app/n;->m:Ljava/util/HashMap;

    iget-object v5, p0, Lcom/wishabi/flipp/app/n;->n:Lcom/wishabi/flipp/widget/ae;

    invoke-direct/range {v0 .. v5}, Lcom/wishabi/flipp/widget/aa;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/util/HashMap;Ljava/util/HashMap;Lcom/wishabi/flipp/widget/ae;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/n;->k:Lcom/wishabi/flipp/widget/aa;

    .line 486
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->c:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/wishabi/flipp/app/n;->k:Lcom/wishabi/flipp/widget/aa;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->a(Landroid/support/v7/widget/an;)V

    .line 489
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/n;->g:Z

    if-nez v0, :cond_5

    .line 490
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    sget-object v1, Lcom/wishabi/flipp/b/q;->a:Lcom/wishabi/flipp/b/q;

    iget-object v3, p0, Lcom/wishabi/flipp/app/n;->h:Lcom/wishabi/flipp/b/p;

    invoke-virtual {v0, v2, v1, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/util/ArrayList;Lcom/wishabi/flipp/b/q;Lcom/wishabi/flipp/b/p;)V

    .line 492
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/n;->g:Z

    .line 496
    :cond_5
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->d:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/app/n;->i:I

    int-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lcom/wishabi/flipp/app/s;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/s;-><init>(Lcom/wishabi/flipp/app/n;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    .line 507
    new-instance v0, Lcom/wishabi/flipp/app/t;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/t;-><init>(Lcom/wishabi/flipp/app/n;)V

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlippApplication;->a(Ljava/lang/Runnable;)Z

    goto/16 :goto_0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/n;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->m:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/n;)V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Lcom/wishabi/flipp/app/n;->b()V

    return-void
.end method

.method static synthetic e(Lcom/wishabi/flipp/app/n;)Landroid/view/View;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->d:Landroid/view/View;

    return-object v0
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 112
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onCreate(Landroid/os/Bundle;)V

    .line 114
    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/n;->getArguments()Landroid/os/Bundle;

    move-result-object p1

    .line 116
    :cond_0
    if-eqz p1, :cond_1

    .line 117
    const-string v0, "SAVE_STATE_COUPON_IDS_KEY"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/n;->e:[I

    .line 118
    const-string v0, "SAVE_STATE_SHOW_ASSOCIATION_KEY"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/n;->f:Z

    .line 119
    const-string v0, "SAVE_STATE_SOURCE"

    const/4 v1, -0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    invoke-static {v0}, Lcom/wishabi/flipp/b/p;->a(I)Lcom/wishabi/flipp/b/p;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/n;->h:Lcom/wishabi/flipp/b/p;

    .line 120
    const-string v0, "SAVE_STATE_SENT_ANALYTICS"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/n;->g:Z

    .line 123
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/n;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/high16 v1, 0x10e0000

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/n;->i:I

    .line 125
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v9, 0x1

    const/4 v0, 0x0

    const/4 v8, 0x0

    .line 342
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/n;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 343
    if-nez v1, :cond_1

    .line 363
    :cond_0
    :goto_0
    return-object v0

    .line 346
    :cond_1
    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 347
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 350
    iget-object v2, p0, Lcom/wishabi/flipp/app/n;->e:[I

    invoke-static {v2}, Lcom/wishabi/flipp/util/q;->a([I)[Ljava/lang/String;

    move-result-object v6

    .line 351
    invoke-static {v6}, Lcom/wishabi/flipp/util/a;->a([Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 354
    packed-switch p1, :pswitch_data_0

    .line 366
    new-instance v0, Ljava/security/InvalidParameterException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Invalid loader id "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 356
    :pswitch_0
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->q:Landroid/net/Uri;

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/String;

    const-string v4, "*"

    aput-object v4, v3, v8

    const-string v4, "clipped"

    aput-object v4, v3, v9

    const/4 v4, 0x2

    const-string v7, "sent"

    aput-object v7, v3, v4

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "c._id"

    invoke-static {v7, v6}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v7, " AND postal_code = ? AND deleted = 0"

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-array v7, v9, [Ljava/lang/String;

    aput-object v5, v7, v8

    invoke-static {v6, v7}, Lcom/wishabi/flipp/util/a;->a([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    const-string v6, "priority ASC, available_from DESC, _id DESC"

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 363
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->e:[I

    invoke-static {v1, v0, v8, v8}, Lcom/wishabi/flipp/content/l;->a(Landroid/content/Context;[IZZ)Landroid/content/Loader;

    move-result-object v0

    goto :goto_0

    .line 354
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 0

    .prologue
    .line 293
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v0, 0x0

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 131
    invoke-super {p0, p1, p2, p3}, Lcom/wishabi/flipp/app/dl;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 133
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/n;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 134
    if-nez v1, :cond_1

    .line 286
    :cond_0
    :goto_0
    return-object v0

    .line 137
    :cond_1
    invoke-virtual {p0, v3}, Lcom/wishabi/flipp/app/n;->setHasOptionsMenu(Z)V

    .line 139
    const v1, 0x7f03001c

    invoke-virtual {p1, v1, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 141
    if-eqz v1, :cond_0

    .line 144
    const v0, 0x7f0b0077

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/n;->c:Landroid/support/v7/widget/RecyclerView;

    .line 145
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->c:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-direct {v2}, Landroid/support/v7/widget/LinearLayoutManager;-><init>()V

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/au;)V

    .line 146
    const v0, 0x7f0b0078

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/n;->d:Landroid/view/View;

    .line 148
    new-instance v0, Lcom/wishabi/flipp/app/o;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/o;-><init>(Lcom/wishabi/flipp/app/n;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/n;->n:Lcom/wishabi/flipp/widget/ae;

    .line 278
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->e:[I

    if-eqz v0, :cond_2

    .line 279
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->e:[I

    array-length v0, v0

    .line 280
    if-ne v0, v3, :cond_3

    .line 281
    const v0, 0x7f0e0078

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/n;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/n;->b(Ljava/lang/String;)V

    :cond_2
    :goto_1
    move-object v0, v1

    .line 286
    goto :goto_0

    .line 283
    :cond_3
    const v2, 0x7f0e0079

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/wishabi/flipp/app/n;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/n;->b(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 2

    .prologue
    .line 53
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/n;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "on load finished "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid loader id"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/n;->j:Landroid/database/Cursor;

    if-eq v0, p2, :cond_0

    iput-object p2, p0, Lcom/wishabi/flipp/app/n;->j:Landroid/database/Cursor;

    if-eqz p2, :cond_0

    invoke-direct {p0}, Lcom/wishabi/flipp/app/n;->b()V

    :cond_0
    :goto_0
    return-void

    :pswitch_1
    const/4 v0, 0x1

    invoke-static {p2, v0}, Lcom/wishabi/flipp/content/l;->a(Landroid/database/Cursor;Z)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/n;->l:Ljava/util/HashMap;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/n;->b()V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 403
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "on load reset "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 405
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 414
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid loader id"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 407
    :pswitch_0
    iput-object v2, p0, Lcom/wishabi/flipp/app/n;->j:Landroid/database/Cursor;

    .line 408
    iput-object v2, p0, Lcom/wishabi/flipp/app/n;->k:Lcom/wishabi/flipp/widget/aa;

    .line 412
    :goto_0
    return-void

    .line 411
    :pswitch_1
    iput-object v2, p0, Lcom/wishabi/flipp/app/n;->l:Ljava/util/HashMap;

    goto :goto_0

    .line 405
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 4

    .prologue
    .line 306
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/n;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 307
    if-nez v0, :cond_0

    .line 308
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    .line 322
    :goto_0
    return v0

    .line 310
    :cond_0
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    const v2, 0x7f0b0158

    if-ne v1, v2, :cond_1

    .line 314
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 315
    const-string v2, "TODO coupon share message here"

    .line 316
    const-string v3, "android.intent.extra.TEXT"

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 317
    const-string v2, "text/plain"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 318
    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 319
    const/4 v0, 0x1

    goto :goto_0

    .line 322
    :cond_1
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onResume()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 327
    invoke-super {p0}, Lcom/wishabi/flipp/app/dl;->onResume()V

    .line 328
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/n;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/n;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-static {v3}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0, v4, v3, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    iget-boolean v2, p0, Lcom/wishabi/flipp/app/n;->f:Z

    if-eqz v2, :cond_0

    const/4 v2, 0x1

    invoke-virtual {v0, v2, v3, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_0
    new-instance v0, Lcom/wishabi/flipp/app/r;

    iget-object v2, p0, Lcom/wishabi/flipp/app/n;->e:[I

    invoke-direct {v0, p0, v2, v1}, Lcom/wishabi/flipp/app/r;-><init>(Lcom/wishabi/flipp/app/n;[ILjava/lang/String;)V

    new-array v1, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/r;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 329
    :cond_1
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 333
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 334
    const-string v0, "SAVE_STATE_COUPON_IDS_KEY"

    iget-object v1, p0, Lcom/wishabi/flipp/app/n;->e:[I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    .line 335
    const-string v0, "SAVE_STATE_SHOW_ASSOCIATION_KEY"

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/n;->f:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 336
    const-string v0, "SAVE_STATE_SOURCE"

    iget-object v1, p0, Lcom/wishabi/flipp/app/n;->h:Lcom/wishabi/flipp/b/p;

    iget v1, v1, Lcom/wishabi/flipp/b/p;->j:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 337
    const-string v0, "SAVE_STATE_SENT_ANALYTICS"

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/n;->g:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 338
    return-void
.end method
