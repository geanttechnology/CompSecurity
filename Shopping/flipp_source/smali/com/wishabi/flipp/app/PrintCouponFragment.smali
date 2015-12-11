.class public Lcom/wishabi/flipp/app/PrintCouponFragment;
.super Landroid/app/Fragment;
.source "SourceFile"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/Fragment;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Landroid/database/Cursor;

.field private c:Landroid/view/MenuItem;

.field private d:Landroid/widget/Toast;

.field private e:Landroid/view/View;

.field private f:Landroid/support/v7/widget/RecyclerView;

.field private g:Landroid/widget/FrameLayout;

.field private h:Lcom/wishabi/flipp/widget/ck;

.field private i:Lcom/wishabi/flipp/b/ao;

.field private j:Z

.field private k:Ljava/lang/String;

.field private l:Landroid/util/SparseBooleanArray;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    const-class v0, Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/app/PrintCouponFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method

.method public static a()Lcom/wishabi/flipp/app/PrintCouponFragment;
    .locals 1

    .prologue
    .line 75
    new-instance v0, Lcom/wishabi/flipp/app/PrintCouponFragment;

    invoke-direct {v0}, Lcom/wishabi/flipp/app/PrintCouponFragment;-><init>()V

    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/PrintCouponFragment;)Lcom/wishabi/flipp/widget/ck;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->h:Lcom/wishabi/flipp/widget/ck;

    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/PrintCouponFragment;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 45
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->a(Ljava/lang/String;I)V

    return-void
.end method

.method private a(Ljava/lang/String;I)V
    .locals 4

    .prologue
    .line 451
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 452
    if-nez v0, :cond_1

    .line 476
    :cond_0
    :goto_0
    return-void

    .line 455
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->d:Landroid/widget/Toast;

    if-nez v1, :cond_2

    .line 456
    const v1, 0x7f030046

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 457
    if-eqz v1, :cond_0

    .line 460
    new-instance v2, Landroid/widget/Toast;

    invoke-direct {v2, v0}, Landroid/widget/Toast;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->d:Landroid/widget/Toast;

    .line 461
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->d:Landroid/widget/Toast;

    invoke-virtual {v0, v1}, Landroid/widget/Toast;->setView(Landroid/view/View;)V

    .line 462
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->d:Landroid/widget/Toast;

    const/16 v1, 0x50

    const/4 v2, 0x0

    const/16 v3, 0xa

    invoke-static {v3}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/Toast;->setGravity(III)V

    .line 465
    :cond_2
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 466
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->d:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->cancel()V

    goto :goto_0

    .line 470
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->d:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0b00c2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 472
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 474
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->d:Landroid/widget/Toast;

    invoke-virtual {v0, p2}, Landroid/widget/Toast;->setDuration(I)V

    .line 475
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->d:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method private b()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 324
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    if-nez v0, :cond_0

    .line 328
    :goto_0
    return-void

    .line 327
    :cond_0
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    const-string v3, "count"

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v3, "Coupon Redemption"

    invoke-virtual {v0, v3, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    const-string v2, "coupon sender"

    int-to-long v4, v1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v2, v6, v6, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V

    goto :goto_0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/PrintCouponFragment;)V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->c()V

    return-void
.end method

.method private c()V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 331
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 332
    if-nez v0, :cond_1

    .line 421
    :cond_0
    :goto_0
    return-void

    .line 335
    :cond_1
    iget-object v2, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->h:Lcom/wishabi/flipp/widget/ck;

    if-eqz v2, :cond_0

    .line 338
    invoke-static {v0}, Lcom/wishabi/flipp/util/g;->a(Landroid/app/Activity;)V

    .line 341
    iget-object v2, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->h:Lcom/wishabi/flipp/widget/ck;

    iget-object v0, v2, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->size()I

    move-result v3

    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    move v0, v1

    :goto_1
    if-ge v0, v3, :cond_3

    iget-object v5, v2, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    invoke-virtual {v5, v0}, Landroid/util/SparseBooleanArray;->valueAt(I)Z

    move-result v5

    if-eqz v5, :cond_2

    iget-object v5, v2, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    invoke-virtual {v5, v0}, Landroid/util/SparseBooleanArray;->keyAt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_3
    invoke-static {v4}, Lcom/wishabi/flipp/util/a;->a(Ljava/util/List;)[I

    move-result-object v2

    .line 342
    array-length v0, v2

    if-nez v0, :cond_4

    .line 343
    const v0, 0x7f0e0167

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, v1}, Lcom/wishabi/flipp/app/PrintCouponFragment;->a(Ljava/lang/String;I)V

    goto :goto_0

    .line 348
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->h:Lcom/wishabi/flipp/widget/ck;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ck;->e:Ljava/lang/String;

    .line 349
    if-eqz v0, :cond_5

    .line 350
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 351
    :cond_5
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 352
    const v0, 0x7f0e0125

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, v1}, Lcom/wishabi/flipp/app/PrintCouponFragment;->a(Ljava/lang/String;I)V

    goto :goto_0

    .line 356
    :cond_6
    array-length v3, v2

    .line 357
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    if-eqz v4, :cond_7

    iget-object v5, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->c:Landroid/view/MenuItem;

    invoke-interface {v5, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    iget-object v5, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->g:Landroid/widget/FrameLayout;

    invoke-virtual {v5, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Landroid/app/Activity;->setProgressBarIndeterminateVisibility(Z)V

    .line 358
    :cond_7
    const v4, 0x7f0e0127

    invoke-virtual {p0, v4}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4, v1}, Lcom/wishabi/flipp/app/PrintCouponFragment;->a(Ljava/lang/String;I)V

    .line 360
    new-instance v4, Lcom/wishabi/flipp/app/dx;

    invoke-direct {v4, p0, v0, v2, v3}, Lcom/wishabi/flipp/app/dx;-><init>(Lcom/wishabi/flipp/app/PrintCouponFragment;Ljava/lang/String;[II)V

    iput-object v4, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->i:Lcom/wishabi/flipp/b/ao;

    .line 398
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->i:Lcom/wishabi/flipp/b/ao;

    new-array v3, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/b/ao;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 400
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 404
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    .line 405
    array-length v4, v2

    move v0, v1

    :goto_2
    if-ge v0, v4, :cond_8

    aget v1, v2, v0

    .line 406
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 405
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 408
    :cond_8
    new-instance v1, Lcom/wishabi/flipp/content/d;

    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    invoke-direct {v1, v0}, Lcom/wishabi/flipp/content/d;-><init>(Landroid/database/Cursor;)V

    .line 410
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    :goto_3
    if-eqz v0, :cond_0

    .line 411
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    iget v2, v1, Lcom/wishabi/flipp/content/d;->a:I

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 412
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 413
    new-instance v0, Lcom/wishabi/flipp/content/c;

    iget-object v2, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    invoke-direct {v0, v2, v1}, Lcom/wishabi/flipp/content/c;-><init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/d;)V

    .line 416
    sget-object v2, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    sget-object v4, Lcom/wishabi/flipp/b/q;->e:Lcom/wishabi/flipp/b/q;

    sget-object v5, Lcom/wishabi/flipp/b/p;->i:Lcom/wishabi/flipp/b/p;

    invoke-virtual {v2, v0, v4, v5}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/c;Lcom/wishabi/flipp/b/q;Lcom/wishabi/flipp/b/p;)V

    .line 410
    :cond_9
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    goto :goto_3
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/PrintCouponFragment;)V
    .locals 3

    .prologue
    .line 45
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->c:Landroid/view/MenuItem;

    const/4 v2, 0x1

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    iget-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->g:Landroid/widget/FrameLayout;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->setVisibility(I)V

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setProgressBarIndeterminateVisibility(Z)V

    :cond_0
    return-void
.end method


# virtual methods
.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 7
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
    const/4 v5, 0x0

    .line 199
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 200
    if-nez v1, :cond_0

    .line 213
    :goto_0
    return-object v5

    .line 203
    :cond_0
    packed-switch p1, :pswitch_data_0

    goto :goto_0

    .line 207
    :pswitch_0
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->q:Landroid/net/Uri;

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v6, "*"

    aput-object v6, v3, v4

    const/4 v4, 0x1

    const-string v6, "clipped"

    aput-object v6, v3, v4

    const/4 v4, 0x2

    const-string v6, "sent"

    aput-object v6, v3, v4

    const-string v4, "clipped = 1 AND deleted = 0"

    const-string v6, "sent ASC, priority ASC, available_from DESC, _id DESC"

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v5, v0

    goto :goto_0

    .line 203
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2

    .prologue
    .line 174
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 175
    if-nez v0, :cond_0

    .line 181
    :goto_0
    return-void

    .line 178
    :cond_0
    const v0, 0x7f100008

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 179
    const v0, 0x7f0b0160

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->c:Landroid/view/MenuItem;

    .line 180
    iget-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->c:Landroid/view/MenuItem;

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->j:Z

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_1
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10

    .prologue
    const/4 v6, 0x1

    const/4 v3, 0x0

    const/4 v1, 0x0

    .line 81
    invoke-super {p0, p1, p2, p3}, Landroid/app/Fragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 83
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 84
    if-nez v0, :cond_0

    move-object v0, v1

    .line 169
    :goto_0
    return-object v0

    .line 87
    :cond_0
    invoke-virtual {p0, v6}, Lcom/wishabi/flipp/app/PrintCouponFragment;->setHasOptionsMenu(Z)V

    .line 90
    invoke-virtual {v0, v3}, Landroid/app/Activity;->setProgressBarIndeterminateVisibility(Z)V

    .line 92
    const v0, 0x7f030045

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 95
    const v0, 0x7f0b003e

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->e:Landroid/view/View;

    .line 96
    const v0, 0x7f0b0077

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->f:Landroid/support/v7/widget/RecyclerView;

    .line 97
    const v0, 0x7f0b0107

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->g:Landroid/widget/FrameLayout;

    .line 98
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->g:Landroid/widget/FrameLayout;

    const/16 v4, 0x8

    invoke-virtual {v0, v4}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 100
    invoke-static {}, Lcom/wishabi/flipp/util/i;->a()I

    move-result v0

    div-int/lit16 v0, v0, 0xb4

    const/4 v4, 0x2

    invoke-static {v0, v4}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 102
    new-instance v4, Landroid/support/v7/widget/s;

    invoke-direct {v4, v0}, Landroid/support/v7/widget/s;-><init>(I)V

    .line 104
    new-instance v5, Lcom/wishabi/flipp/app/dt;

    invoke-direct {v5, p0, v0}, Lcom/wishabi/flipp/app/dt;-><init>(Lcom/wishabi/flipp/app/PrintCouponFragment;I)V

    iput-object v5, v4, Landroid/support/v7/widget/s;->g:Landroid/support/v7/widget/v;

    .line 117
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->f:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/au;)V

    .line 120
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->f:Landroid/support/v7/widget/RecyclerView;

    const/high16 v4, 0x20000

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->setDescendantFocusability(I)V

    .line 121
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->f:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v6}, Landroid/support/v7/widget/RecyclerView;->setFocusable(Z)V

    .line 122
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->f:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v6}, Landroid/support/v7/widget/RecyclerView;->setFocusableInTouchMode(Z)V

    .line 123
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->f:Landroid/support/v7/widget/RecyclerView;

    new-instance v4, Lcom/wishabi/flipp/app/du;

    invoke-direct {v4, p0}, Lcom/wishabi/flipp/app/du;-><init>(Lcom/wishabi/flipp/app/PrintCouponFragment;)V

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 131
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->g:Landroid/widget/FrameLayout;

    new-instance v4, Lcom/wishabi/flipp/app/dv;

    invoke-direct {v4, p0}, Lcom/wishabi/flipp/app/dv;-><init>(Lcom/wishabi/flipp/app/PrintCouponFragment;)V

    invoke-virtual {v0, v4}, Landroid/widget/FrameLayout;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 139
    if-nez p3, :cond_4

    .line 141
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 142
    if-nez v0, :cond_3

    .line 143
    iput-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->k:Ljava/lang/String;

    .line 148
    :goto_1
    iput-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->l:Landroid/util/SparseBooleanArray;

    .line 165
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    .line 166
    if-eqz v0, :cond_2

    .line 167
    invoke-virtual {v0, v3, v1, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_2
    move-object v0, v2

    .line 169
    goto/16 :goto_0

    .line 145
    :cond_3
    const-string v4, "print_coupon_user_email"

    invoke-interface {v0, v4, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->k:Ljava/lang/String;

    goto :goto_1

    .line 150
    :cond_4
    const-string v0, "SAVE_STATE_EMAIL_KEY"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->k:Ljava/lang/String;

    .line 151
    const-string v0, "SAVE_STATE_SELECTION_ID_KEY"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v4

    .line 153
    const-string v0, "SAVE_STATE_SELECTION_VALUE_KEY"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getBooleanArray(Ljava/lang/String;)[Z

    move-result-object v5

    .line 155
    if-eqz v4, :cond_1

    if-eqz v5, :cond_1

    array-length v0, v4

    array-length v6, v5

    if-ne v0, v6, :cond_1

    .line 157
    new-instance v0, Landroid/util/SparseBooleanArray;

    invoke-direct {v0}, Landroid/util/SparseBooleanArray;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->l:Landroid/util/SparseBooleanArray;

    .line 158
    array-length v6, v4

    move v0, v3

    .line 159
    :goto_2
    if-ge v0, v6, :cond_1

    .line 160
    iget-object v7, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->l:Landroid/util/SparseBooleanArray;

    aget v8, v4, v0

    aget-boolean v9, v5, v0

    invoke-virtual {v7, v8, v9}, Landroid/util/SparseBooleanArray;->put(IZ)V

    .line 159
    add-int/lit8 v0, v0, 0x1

    goto :goto_2
.end method

.method public onHiddenChanged(Z)V
    .locals 0

    .prologue
    .line 312
    invoke-super {p0, p1}, Landroid/app/Fragment;->onHiddenChanged(Z)V

    .line 313
    return-void
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 6

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 45
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    if-eq v0, p2, :cond_0

    iput-object p2, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    if-eqz p2, :cond_0

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->e:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->f:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    iput-boolean v3, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->j:Z

    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->c:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->c:Landroid/view/MenuItem;

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->e:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->f:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    iput-boolean v2, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->j:Z

    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->c:Landroid/view/MenuItem;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->c:Landroid/view/MenuItem;

    invoke-interface {v0, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    :cond_2
    new-instance v0, Lcom/wishabi/flipp/widget/ck;

    iget-object v2, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    iget-object v3, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->k:Ljava/lang/String;

    iget-object v4, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->l:Landroid/util/SparseBooleanArray;

    new-instance v5, Lcom/wishabi/flipp/app/dw;

    invoke-direct {v5, p0}, Lcom/wishabi/flipp/app/dw;-><init>(Lcom/wishabi/flipp/app/PrintCouponFragment;)V

    invoke-direct/range {v0 .. v5}, Lcom/wishabi/flipp/widget/ck;-><init>(Landroid/content/Context;Landroid/database/Cursor;Ljava/lang/String;Landroid/util/SparseBooleanArray;Lcom/wishabi/flipp/widget/cw;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->h:Lcom/wishabi/flipp/widget/ck;

    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->f:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->h:Lcom/wishabi/flipp/widget/ck;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/an;)V

    invoke-direct {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->b()V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 2
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
    const/4 v1, 0x0

    .line 280
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 286
    :goto_0
    return-void

    .line 282
    :pswitch_0
    iput-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->b:Landroid/database/Cursor;

    .line 283
    iput-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->h:Lcom/wishabi/flipp/widget/ck;

    goto :goto_0

    .line 280
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 185
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 186
    if-nez v0, :cond_0

    .line 187
    invoke-super {p0, p1}, Landroid/app/Fragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    .line 194
    :goto_0
    return v0

    .line 189
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->c:Landroid/view/MenuItem;

    if-ne v0, p1, :cond_1

    .line 190
    invoke-direct {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->c()V

    .line 191
    const/4 v0, 0x1

    goto :goto_0

    .line 194
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Fragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 317
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 319
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->isHidden()Z

    move-result v0

    if-nez v0, :cond_0

    .line 320
    invoke-direct {p0}, Lcom/wishabi/flipp/app/PrintCouponFragment;->b()V

    .line 321
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 7

    .prologue
    const/4 v0, 0x0

    .line 290
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 292
    iget-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->h:Lcom/wishabi/flipp/widget/ck;

    if-nez v1, :cond_0

    .line 308
    :goto_0
    return-void

    .line 295
    :cond_0
    iget-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->h:Lcom/wishabi/flipp/widget/ck;

    iget-object v1, v1, Lcom/wishabi/flipp/widget/ck;->e:Ljava/lang/String;

    iput-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->k:Ljava/lang/String;

    .line 296
    const-string v1, "SAVE_STATE_EMAIL_KEY"

    iget-object v2, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->k:Ljava/lang/String;

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    iget-object v2, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->h:Lcom/wishabi/flipp/widget/ck;

    new-instance v3, Landroid/util/SparseBooleanArray;

    invoke-direct {v3}, Landroid/util/SparseBooleanArray;-><init>()V

    iget-object v1, v2, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    invoke-virtual {v1}, Landroid/util/SparseBooleanArray;->size()I

    move-result v4

    move v1, v0

    :goto_1
    if-ge v1, v4, :cond_1

    iget-object v5, v2, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseBooleanArray;->keyAt(I)I

    move-result v5

    iget-object v6, v2, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    invoke-virtual {v6, v1}, Landroid/util/SparseBooleanArray;->valueAt(I)Z

    move-result v6

    invoke-virtual {v3, v5, v6}, Landroid/util/SparseBooleanArray;->put(IZ)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_1
    iput-object v3, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->l:Landroid/util/SparseBooleanArray;

    .line 299
    iget-object v1, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->l:Landroid/util/SparseBooleanArray;

    invoke-virtual {v1}, Landroid/util/SparseBooleanArray;->size()I

    move-result v1

    .line 300
    new-array v2, v1, [I

    .line 301
    new-array v3, v1, [Z

    .line 302
    :goto_2
    if-ge v0, v1, :cond_2

    .line 303
    iget-object v4, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->l:Landroid/util/SparseBooleanArray;

    invoke-virtual {v4, v0}, Landroid/util/SparseBooleanArray;->keyAt(I)I

    move-result v4

    aput v4, v2, v0

    .line 304
    iget-object v4, p0, Lcom/wishabi/flipp/app/PrintCouponFragment;->l:Landroid/util/SparseBooleanArray;

    invoke-virtual {v4, v0}, Landroid/util/SparseBooleanArray;->valueAt(I)Z

    move-result v4

    aput-boolean v4, v3, v0

    .line 302
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 306
    :cond_2
    const-string v0, "SAVE_STATE_SELECTION_ID_KEY"

    invoke-virtual {p1, v0, v2}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    .line 307
    const-string v0, "SAVE_STATE_SELECTION_VALUE_KEY"

    invoke-virtual {p1, v0, v3}, Landroid/os/Bundle;->putBooleanArray(Ljava/lang/String;[Z)V

    goto :goto_0
.end method
