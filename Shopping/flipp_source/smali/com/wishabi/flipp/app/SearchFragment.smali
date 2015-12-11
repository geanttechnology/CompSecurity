.class public Lcom/wishabi/flipp/app/SearchFragment;
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


# instance fields
.field private A:Z

.field private B:Z

.field private C:Z

.field private D:Z

.field private final E:Lcom/wishabi/flipp/widget/ec;

.field private final F:Lcom/wishabi/flipp/app/dn;

.field private final G:Lcom/wishabi/flipp/app/dn;

.field private final H:Lcom/wishabi/flipp/app/dn;

.field private final I:Lcom/wishabi/flipp/app/dn;

.field private final J:Lcom/wishabi/flipp/widget/dr;

.field a:Ljava/lang/String;

.field b:I

.field private c:Lcom/wishabi/flipp/widget/SearchView;

.field private d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/ai;",
            ">;"
        }
    .end annotation
.end field

.field private e:Landroid/database/Cursor;

.field private f:Landroid/database/Cursor;

.field private g:Lcom/wishabi/flipp/content/ae;

.field private h:Landroid/util/SparseBooleanArray;

.field private i:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;>;"
        }
    .end annotation
.end field

.field private j:Landroid/database/Cursor;

.field private k:Landroid/database/Cursor;

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

.field private m:Z

.field private n:Lcom/wishabi/flipp/widget/CollectionView;

.field private o:Lcom/wishabi/flipp/widget/ShoppingListPopup;

.field private p:Lcom/wishabi/flipp/widget/ZeroCaseView;

.field private q:Lcom/wishabi/flipp/widget/ZeroCaseView;

.field private r:Lcom/wishabi/flipp/widget/ci;

.field private s:Lcom/wishabi/flipp/widget/al;

.field private t:Landroid/view/View;

.field private u:Lcom/wishabi/flipp/b/aq;

.field private v:Z

.field private w:I

.field private x:Z

.field private y:Z

.field private z:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 65
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 112
    const/4 v0, 0x0

    iput v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->w:I

    .line 128
    new-instance v0, Lcom/wishabi/flipp/app/dz;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/dz;-><init>(Lcom/wishabi/flipp/app/SearchFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->E:Lcom/wishabi/flipp/widget/ec;

    .line 141
    new-instance v0, Lcom/wishabi/flipp/app/ef;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/ef;-><init>(Lcom/wishabi/flipp/app/SearchFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->F:Lcom/wishabi/flipp/app/dn;

    .line 177
    new-instance v0, Lcom/wishabi/flipp/app/eg;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/eg;-><init>(Lcom/wishabi/flipp/app/SearchFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->G:Lcom/wishabi/flipp/app/dn;

    .line 220
    new-instance v0, Lcom/wishabi/flipp/app/eh;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/eh;-><init>(Lcom/wishabi/flipp/app/SearchFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->H:Lcom/wishabi/flipp/app/dn;

    .line 256
    new-instance v0, Lcom/wishabi/flipp/app/ei;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/ei;-><init>(Lcom/wishabi/flipp/app/SearchFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->I:Lcom/wishabi/flipp/app/dn;

    .line 295
    new-instance v0, Lcom/wishabi/flipp/app/ej;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/ej;-><init>(Lcom/wishabi/flipp/app/SearchFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->J:Lcom/wishabi/flipp/widget/dr;

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/SearchFragment;I)I
    .locals 0

    .prologue
    .line 65
    iput p1, p0, Lcom/wishabi/flipp/app/SearchFragment;->w:I

    return p1
.end method

.method private a(ILandroid/graphics/RectF;Ljava/lang/Boolean;)Lcom/wishabi/flipp/content/Flyer$Model;
    .locals 9

    .prologue
    const/4 v6, 0x0

    .line 855
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v7

    .line 856
    if-nez v7, :cond_0

    move-object v0, v6

    .line 890
    :goto_0
    return-object v0

    .line 860
    :cond_0
    :try_start_0
    invoke-virtual {v7}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "flyer_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 866
    if-eqz v1, :cond_1

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    if-nez v0, :cond_3

    .line 867
    :cond_1
    if-eqz v1, :cond_2

    .line 873
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    move-object v0, v6

    goto :goto_0

    .line 869
    :cond_3
    :try_start_2
    new-instance v0, Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/content/Flyer$Model;-><init>(Landroid/database/Cursor;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 872
    if-eqz v1, :cond_4

    .line 873
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 876
    :cond_4
    if-eqz p3, :cond_5

    .line 877
    invoke-virtual {p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    iput-boolean v1, v0, Lcom/wishabi/flipp/content/Flyer$Model;->e:Z

    .line 879
    :cond_5
    iget v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->b:I

    sget v2, Lcom/wishabi/flipp/app/en;->b:I

    if-ne v1, v2, :cond_7

    .line 880
    new-instance v1, Lcom/wishabi/flipp/content/FlyerActivityIntent;

    sget v2, Lcom/wishabi/flipp/app/bm;->b:I

    invoke-direct {v1, v7, v0, p2, v2}, Lcom/wishabi/flipp/content/FlyerActivityIntent;-><init>(Landroid/content/Context;Lcom/wishabi/flipp/content/Flyer$Model;Landroid/graphics/RectF;I)V

    invoke-virtual {v7, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 887
    :goto_1
    const v1, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v7, v1, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0

    .line 872
    :catchall_0
    move-exception v0

    :goto_2
    if-eqz v6, :cond_6

    .line 873
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_6
    throw v0

    .line 884
    :cond_7
    new-instance v1, Lcom/wishabi/flipp/content/FlyerActivityIntent;

    invoke-direct {v1, v7, v0, p2}, Lcom/wishabi/flipp/content/FlyerActivityIntent;-><init>(Landroid/content/Context;Lcom/wishabi/flipp/content/Flyer$Model;Landroid/graphics/RectF;)V

    invoke-virtual {v7, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1

    .line 872
    :catchall_1
    move-exception v0

    move-object v6, v1

    goto :goto_2
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/SearchFragment;ILandroid/graphics/RectF;Ljava/lang/Boolean;)Lcom/wishabi/flipp/content/Flyer$Model;
    .locals 1

    .prologue
    .line 65
    invoke-direct {p0, p1, p2, p3}, Lcom/wishabi/flipp/app/SearchFragment;->a(ILandroid/graphics/RectF;Ljava/lang/Boolean;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/SearchFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lcom/wishabi/flipp/app/SearchFragment;->d:Ljava/util/List;

    return-object p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/SearchFragment;)V
    .locals 0

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->b()V

    return-void
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->f:Landroid/database/Cursor;

    return-object v0
.end method

.method private b()V
    .locals 15

    .prologue
    .line 895
    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->e()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->f()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->i:Ljava/util/HashMap;

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->z:Z

    if-nez v0, :cond_3

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->l:Ljava/util/HashMap;

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->A:Z

    if-nez v0, :cond_3

    :cond_1
    const/4 v0, 0x1

    :goto_0
    if-nez v0, :cond_4

    .line 921
    :cond_2
    :goto_1
    return-void

    .line 895
    :cond_3
    const/4 v0, 0x0

    goto :goto_0

    .line 899
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->setEmptyView(Landroid/view/View;)V

    .line 900
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->r:Lcom/wishabi/flipp/widget/ci;

    .line 901
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->s:Lcom/wishabi/flipp/widget/al;

    .line 903
    iget v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->w:I

    packed-switch v0, :pswitch_data_0

    .line 911
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid search tab clicked"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 905
    :pswitch_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    if-eqz v1, :cond_5

    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->e()Z

    move-result v0

    if-nez v0, :cond_6

    .line 914
    :cond_5
    :goto_2
    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->c()V

    .line 916
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->D:Z

    if-nez v0, :cond_2

    .line 917
    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->d()V

    .line 918
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->D:Z

    goto :goto_1

    .line 905
    :cond_6
    new-instance v0, Lcom/wishabi/flipp/widget/ci;

    iget-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    iget-boolean v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->y:Z

    if-eqz v3, :cond_7

    iget-object v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->f:Landroid/database/Cursor;

    :goto_3
    iget-boolean v4, p0, Lcom/wishabi/flipp/app/SearchFragment;->y:Z

    if-eqz v4, :cond_8

    iget-object v4, p0, Lcom/wishabi/flipp/app/SearchFragment;->g:Lcom/wishabi/flipp/content/ae;

    :goto_4
    iget-boolean v5, p0, Lcom/wishabi/flipp/app/SearchFragment;->z:Z

    if-eqz v5, :cond_9

    iget-object v5, p0, Lcom/wishabi/flipp/app/SearchFragment;->d:Ljava/util/List;

    :goto_5
    iget-object v6, p0, Lcom/wishabi/flipp/app/SearchFragment;->h:Landroid/util/SparseBooleanArray;

    iget-boolean v7, p0, Lcom/wishabi/flipp/app/SearchFragment;->z:Z

    if-eqz v7, :cond_a

    iget-object v7, p0, Lcom/wishabi/flipp/app/SearchFragment;->i:Ljava/util/HashMap;

    :goto_6
    iget-object v8, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    iget-object v9, p0, Lcom/wishabi/flipp/app/SearchFragment;->G:Lcom/wishabi/flipp/app/dn;

    iget-object v10, p0, Lcom/wishabi/flipp/app/SearchFragment;->F:Lcom/wishabi/flipp/app/dn;

    iget v11, p0, Lcom/wishabi/flipp/app/SearchFragment;->w:I

    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->h()I

    move-result v12

    iget-object v13, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    if-eqz v13, :cond_b

    iget-object v13, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    invoke-interface {v13}, Landroid/database/Cursor;->getCount()I

    move-result v13

    :goto_7
    iget-object v14, p0, Lcom/wishabi/flipp/app/SearchFragment;->E:Lcom/wishabi/flipp/widget/ec;

    invoke-direct/range {v0 .. v14}, Lcom/wishabi/flipp/widget/ci;-><init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/database/Cursor;Lcom/wishabi/flipp/content/ae;Ljava/util/List;Landroid/util/SparseBooleanArray;Ljava/util/HashMap;Lcom/wishabi/flipp/widget/ZeroCaseView;Lcom/wishabi/flipp/app/dn;Lcom/wishabi/flipp/app/dn;IIILcom/wishabi/flipp/widget/ec;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->r:Lcom/wishabi/flipp/widget/ci;

    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    iget-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->r:Lcom/wishabi/flipp/widget/ci;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/CollectionView;->setAdapter(Landroid/widget/ListAdapter;)V

    new-instance v0, Lcom/wishabi/flipp/widget/eg;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/widget/eg;-><init>(Landroid/content/Context;)V

    new-instance v2, Lcom/wishabi/flipp/widget/cj;

    iget-object v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-direct {v2, v1, v3}, Lcom/wishabi/flipp/widget/cj;-><init>(Landroid/content/Context;Lcom/wishabi/flipp/widget/CollectionView;)V

    iput-object v2, v0, Lcom/wishabi/flipp/widget/eg;->b:Lcom/wishabi/flipp/widget/eh;

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/CollectionView;->setLayout(Lcom/wishabi/flipp/widget/n;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    new-instance v1, Lcom/wishabi/flipp/app/ec;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/ec;-><init>(Lcom/wishabi/flipp/app/SearchFragment;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->setOnItemClickListener(Lcom/wishabi/flipp/widget/r;)V

    new-instance v0, Lcom/wishabi/flipp/app/ed;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/ed;-><init>(Lcom/wishabi/flipp/app/SearchFragment;)V

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlippApplication;->a(Ljava/lang/Runnable;)Z

    goto :goto_2

    :cond_7
    const/4 v3, 0x0

    goto :goto_3

    :cond_8
    const/4 v4, 0x0

    goto :goto_4

    :cond_9
    const/4 v5, 0x0

    goto :goto_5

    :cond_a
    const/4 v7, 0x0

    goto :goto_6

    :cond_b
    const/4 v13, 0x0

    goto :goto_7

    .line 908
    :pswitch_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    if-eqz v1, :cond_5

    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->f()Z

    move-result v0

    if-eqz v0, :cond_5

    new-instance v0, Lcom/wishabi/flipp/widget/al;

    iget-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    iget-boolean v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->B:Z

    if-eqz v3, :cond_c

    iget-object v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->k:Landroid/database/Cursor;

    :goto_8
    iget-object v4, p0, Lcom/wishabi/flipp/app/SearchFragment;->l:Ljava/util/HashMap;

    iget v5, p0, Lcom/wishabi/flipp/app/SearchFragment;->w:I

    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->h()I

    move-result v6

    iget-object v7, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    if-eqz v7, :cond_d

    iget-object v7, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v7

    :goto_9
    iget-boolean v8, p0, Lcom/wishabi/flipp/app/SearchFragment;->C:Z

    iget-object v9, p0, Lcom/wishabi/flipp/app/SearchFragment;->q:Lcom/wishabi/flipp/widget/ZeroCaseView;

    iget-object v10, p0, Lcom/wishabi/flipp/app/SearchFragment;->E:Lcom/wishabi/flipp/widget/ec;

    iget-object v11, p0, Lcom/wishabi/flipp/app/SearchFragment;->H:Lcom/wishabi/flipp/app/dn;

    iget-object v12, p0, Lcom/wishabi/flipp/app/SearchFragment;->I:Lcom/wishabi/flipp/app/dn;

    invoke-direct/range {v0 .. v12}, Lcom/wishabi/flipp/widget/al;-><init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/database/Cursor;Ljava/util/HashMap;IIIZLcom/wishabi/flipp/widget/ZeroCaseView;Lcom/wishabi/flipp/widget/ec;Lcom/wishabi/flipp/app/dn;Lcom/wishabi/flipp/app/dn;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->s:Lcom/wishabi/flipp/widget/al;

    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    iget-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->s:Lcom/wishabi/flipp/widget/al;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/CollectionView;->setAdapter(Landroid/widget/ListAdapter;)V

    new-instance v0, Lcom/wishabi/flipp/widget/eg;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/widget/eg;-><init>(Landroid/content/Context;)V

    new-instance v2, Lcom/wishabi/flipp/widget/am;

    iget-object v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-direct {v2, v1, v3}, Lcom/wishabi/flipp/widget/am;-><init>(Landroid/content/Context;Lcom/wishabi/flipp/widget/CollectionView;)V

    iput-object v2, v0, Lcom/wishabi/flipp/widget/eg;->b:Lcom/wishabi/flipp/widget/eh;

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/CollectionView;->setLayout(Lcom/wishabi/flipp/widget/n;)V

    goto/16 :goto_2

    :cond_c
    const/4 v3, 0x0

    goto :goto_8

    :cond_d
    const/4 v7, 0x0

    goto :goto_9

    .line 903
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/content/ae;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->g:Lcom/wishabi/flipp/content/ae;

    return-object v0
.end method

.method private c()V
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 1021
    .line 1022
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    if-eqz v0, :cond_1

    .line 1023
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 1024
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    const-string v2, "merchant"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    move v0, v1

    .line 1025
    :goto_0
    iget-object v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    invoke-interface {v3}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v3

    if-nez v3, :cond_2

    if-nez v0, :cond_2

    .line 1026
    iget-object v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 1028
    iget-object v4, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1029
    const/4 v0, 0x1

    .line 1031
    :cond_0
    iget-object v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    :cond_1
    move v0, v1

    .line 1036
    :cond_2
    iget-boolean v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->m:Z

    if-eqz v2, :cond_3

    if-nez v0, :cond_3

    .line 1037
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->o:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    iget-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v2, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Ljava/lang/String;Z)V

    .line 1040
    :goto_1
    return-void

    .line 1039
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->o:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Z)V

    goto :goto_1
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->d:Ljava/util/List;

    return-object v0
.end method

.method private d()V
    .locals 14

    .prologue
    const/4 v8, 0x1

    const/4 v3, 0x0

    .line 1048
    const-string v0, ""

    .line 1049
    sget-object v1, Lcom/wishabi/flipp/app/ee;->a:[I

    iget v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->b:I

    add-int/lit8 v2, v2, -0x1

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    move-object v1, v0

    .line 1062
    :goto_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->i:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    .line 1063
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->i:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    move v2, v3

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 1064
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/2addr v0, v2

    move v2, v0

    goto :goto_1

    .line 1051
    :pswitch_0
    const-string v0, "global"

    move-object v1, v0

    .line 1052
    goto :goto_0

    .line 1054
    :pswitch_1
    const-string v0, "sl"

    move-object v1, v0

    .line 1055
    goto :goto_0

    .line 1057
    :pswitch_2
    const-string v0, "global"

    move-object v1, v0

    goto :goto_0

    :cond_0
    move v2, v3

    .line 1068
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->l:Ljava/util/HashMap;

    if-eqz v0, :cond_2

    .line 1069
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->l:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v5

    move v4, v3

    :goto_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 1070
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/2addr v0, v4

    move v4, v0

    goto :goto_2

    :cond_2
    move v4, v3

    .line 1073
    :cond_3
    sget-object v10, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v7, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    :goto_3
    iget-object v5, p0, Lcom/wishabi/flipp/app/SearchFragment;->d:Ljava/util/List;

    if-eqz v5, :cond_7

    iget-object v5, p0, Lcom/wishabi/flipp/app/SearchFragment;->d:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    :goto_4
    iget-object v6, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    if-eqz v6, :cond_8

    iget-object v6, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v6

    move v9, v6

    :goto_5
    if-eqz v7, :cond_5

    const-string v6, " "

    const/4 v11, 0x2

    invoke-virtual {v7, v6, v11}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v6

    array-length v11, v6

    if-le v11, v8, :cond_9

    aget-object v11, v6, v3

    invoke-static {v11}, Lcom/wishabi/flipp/util/q;->b(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_9

    aget-object v6, v6, v8

    :goto_6
    add-int v11, v0, v5

    add-int/2addr v11, v9

    new-instance v12, Ljava/util/HashMap;

    invoke-direct {v12}, Ljava/util/HashMap;-><init>()V

    const-string v13, "q"

    invoke-virtual {v12, v13, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v13, "q_raw"

    invoke-virtual {v12, v13, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v7, "postal_code"

    iget-object v13, v10, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    invoke-virtual {v12, v7, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v7, "flyer_count"

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v12, v7, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "item_count"

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v12, v0, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "coupon_count"

    invoke-static {v9}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v12, v0, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "flyer_match_count"

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v12, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "coupon_match_count"

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v12, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "count"

    invoke-static {v11}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v12, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "mode"

    invoke-virtual {v12, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "Searched"

    invoke-static {v0, v12}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    const-string v0, "searched"

    invoke-virtual {v10, v0, v12, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    const-string v0, "searched"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "searched | "

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "searched | "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, " | "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    int-to-long v4, v11

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v10, v0, v2, v1, v4}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "fb_search_string"

    invoke-virtual {v0, v1, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "fb_success"

    if-lez v11, :cond_4

    move v3, v8

    :cond_4
    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v1, "fb_mobile_search"

    invoke-virtual {v10, v1, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 1078
    :cond_5
    return-void

    :cond_6
    move v0, v3

    .line 1073
    goto/16 :goto_3

    :cond_7
    move v5, v3

    goto/16 :goto_4

    :cond_8
    move v9, v3

    goto/16 :goto_5

    :cond_9
    move-object v6, v7

    goto/16 :goto_6

    .line 1049
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method static synthetic e(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->i:Ljava/util/HashMap;

    return-object v0
.end method

.method private e()Z
    .locals 1

    .prologue
    .line 1081
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->d:Ljava/util/List;

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->z:Z

    if-nez v0, :cond_3

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->x:Z

    if-nez v0, :cond_3

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->f:Landroid/database/Cursor;

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->y:Z

    if-nez v0, :cond_3

    :cond_2
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic f(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    return-object v0
.end method

.method private f()Z
    .locals 1

    .prologue
    .line 1087
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->A:Z

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic g(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    return-object v0
.end method

.method private g()V
    .locals 3

    .prologue
    .line 1096
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v0

    .line 1097
    if-nez v0, :cond_1

    .line 1111
    :cond_0
    :goto_0
    return-void

    .line 1100
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->c:Lcom/wishabi/flipp/widget/SearchView;

    if-eqz v1, :cond_0

    iget v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->b:I

    if-eqz v1, :cond_0

    .line 1104
    iget v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->b:I

    sget v2, Lcom/wishabi/flipp/app/en;->c:I

    if-ne v1, v2, :cond_2

    .line 1105
    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->c:Lcom/wishabi/flipp/widget/SearchView;

    const v2, 0x7f0e011f

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/SearchView;->setQueryHint(Ljava/lang/CharSequence;)V

    .line 1108
    :cond_2
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1109
    const-string v1, "search_mode"

    iget v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->b:I

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1110
    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->c:Lcom/wishabi/flipp/widget/SearchView;

    const-string v2, "com.wishabi.flipp.search_bundle"

    invoke-virtual {v1, v2, v0}, Lcom/wishabi/flipp/widget/SearchView;->setSearchExtraData(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method private h()I
    .locals 2

    .prologue
    .line 1114
    const/4 v0, 0x0

    .line 1116
    iget-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->z:Z

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->d:Ljava/util/List;

    if-eqz v1, :cond_0

    .line 1117
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x0

    .line 1119
    :cond_0
    iget-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->x:Z

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    if-eqz v1, :cond_1

    .line 1120
    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    add-int/2addr v0, v1

    .line 1122
    :cond_1
    return v0
.end method

.method static synthetic h(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->l:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic i(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->k:Landroid/database/Cursor;

    return-object v0
.end method

.method static synthetic j(Lcom/wishabi/flipp/app/SearchFragment;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->o:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Z)V

    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->m:Z

    return-void
.end method

.method static synthetic k(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/b/aq;
    .locals 1

    .prologue
    .line 65
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->u:Lcom/wishabi/flipp/b/aq;

    return-object v0
.end method

.method static synthetic l(Lcom/wishabi/flipp/app/SearchFragment;)Z
    .locals 1

    .prologue
    .line 65
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->A:Z

    return v0
.end method

.method static synthetic m(Lcom/wishabi/flipp/app/SearchFragment;)Z
    .locals 1

    .prologue
    .line 65
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->B:Z

    return v0
.end method

.method static synthetic n(Lcom/wishabi/flipp/app/SearchFragment;)Z
    .locals 1

    .prologue
    .line 65
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->y:Z

    return v0
.end method

.method static synthetic o(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/widget/ZeroCaseView;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    return-object v0
.end method

.method static synthetic p(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/widget/CollectionView;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    return-object v0
.end method

.method static synthetic q(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/widget/ci;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->r:Lcom/wishabi/flipp/widget/ci;

    return-object v0
.end method

.method static synthetic r(Lcom/wishabi/flipp/app/SearchFragment;)Z
    .locals 1

    .prologue
    .line 65
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->z:Z

    return v0
.end method


# virtual methods
.method public final a()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 575
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/CollectionView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 576
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/CollectionView;->setEmptyView(Landroid/view/View;)V

    .line 577
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0, v3, v3}, Lcom/wishabi/flipp/widget/CollectionView;->scrollTo(II)V

    .line 578
    iput-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    .line 579
    iput-boolean v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->m:Z

    .line 581
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->u:Lcom/wishabi/flipp/b/aq;

    if-eqz v0, :cond_0

    .line 582
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->u:Lcom/wishabi/flipp/b/aq;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/aq;->cancel(Z)Z

    .line 583
    iput-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->u:Lcom/wishabi/flipp/b/aq;

    .line 587
    :cond_0
    iput-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->d:Ljava/util/List;

    .line 588
    iput-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->f:Landroid/database/Cursor;

    .line 589
    iput-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    .line 590
    iput-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->h:Landroid/util/SparseBooleanArray;

    .line 593
    iput-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    .line 594
    iput-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->l:Ljava/util/HashMap;

    .line 595
    iput-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->i:Ljava/util/HashMap;

    .line 596
    iput-boolean v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->D:Z

    .line 597
    return-void
.end method

.method public final a(I)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v1, 0x1

    .line 687
    sget-object v0, Lcom/wishabi/flipp/app/ee;->a:[I

    add-int/lit8 v2, p1, -0x1

    aget v0, v0, v2

    packed-switch v0, :pswitch_data_0

    .line 718
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid search mode"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 689
    :pswitch_0
    iput-boolean v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->v:Z

    .line 690
    iput-boolean v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->x:Z

    .line 691
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->y:Z

    .line 692
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->z:Z

    .line 693
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->A:Z

    .line 694
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->B:Z

    .line 695
    iput-boolean v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->C:Z

    .line 720
    :goto_0
    iput p1, p0, Lcom/wishabi/flipp/app/SearchFragment;->b:I

    .line 722
    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->g()V

    .line 723
    return-void

    .line 698
    :pswitch_1
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->v:Z

    .line 699
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->x:Z

    .line 700
    iput-boolean v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->y:Z

    .line 701
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->z:Z

    .line 702
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->A:Z

    .line 703
    iput-boolean v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->B:Z

    .line 704
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->C:Z

    goto :goto_0

    .line 707
    :pswitch_2
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->v:Z

    .line 708
    iget v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->b:I

    if-nez v0, :cond_0

    move v0, v1

    :goto_1
    iput v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->w:I

    .line 710
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->x:Z

    .line 711
    iput-boolean v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->y:Z

    .line 712
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->z:Z

    .line 713
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->A:Z

    .line 714
    iput-boolean v3, p0, Lcom/wishabi/flipp/app/SearchFragment;->B:Z

    .line 715
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->C:Z

    goto :goto_0

    .line 708
    :cond_0
    iget v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->w:I

    goto :goto_1

    .line 687
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final a(Ljava/lang/String;Z)V
    .locals 11

    .prologue
    const v10, 0x7f0e00f2

    const v6, 0x7f0200d7

    const/4 v9, 0x0

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 600
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 601
    if-nez v2, :cond_1

    .line 680
    :cond_0
    :goto_0
    return-void

    .line 604
    :cond_1
    invoke-static {v9}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 605
    if-eqz v4, :cond_0

    .line 608
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->a()V

    .line 609
    iput-object p1, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    .line 610
    iput-boolean p2, p0, Lcom/wishabi/flipp/app/SearchFragment;->m:Z

    .line 611
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->t:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->setEmptyView(Landroid/view/View;)V

    .line 612
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    iget v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->b:I

    sget v3, Lcom/wishabi/flipp/app/en;->a:I

    if-ne v1, v3, :cond_5

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v3, 0x7f0200bf

    invoke-virtual {v1, v3}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setIcon(I)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v3, 0x7f0e00f1

    invoke-virtual {v1, v3}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setTitle(I)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v3, 0x7f0e00f4

    invoke-virtual {v1, v3}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setSubTitle(I)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v3, 0x7f0e00f6

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v0, v5, v7

    invoke-virtual {p0, v3, v5}, Lcom/wishabi/flipp/app/SearchFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    new-instance v5, Lcom/wishabi/flipp/app/eb;

    invoke-direct {v5, p0, v0}, Lcom/wishabi/flipp/app/eb;-><init>(Lcom/wishabi/flipp/app/SearchFragment;Ljava/lang/String;)V

    invoke-virtual {v1, v3, v5}, Lcom/wishabi/flipp/widget/ZeroCaseView;->a(Ljava/lang/String;Landroid/view/View$OnClickListener;)V

    :goto_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->q:Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v1, v6}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setIcon(I)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->q:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v3, 0x7f0e00f3

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v0, v5, v7

    invoke-virtual {p0, v3, v5}, Lcom/wishabi/flipp/app/SearchFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setTitle(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->q:Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v0, v10}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setSubTitle(I)V

    .line 614
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v6

    .line 615
    if-eqz v6, :cond_0

    .line 618
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->x:Z

    if-eqz v0, :cond_2

    .line 619
    invoke-virtual {v6, v7, v9, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 620
    invoke-virtual {v6, v8, v9, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 623
    :cond_2
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->y:Z

    if-nez v0, :cond_3

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->z:Z

    if-nez v0, :cond_3

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->A:Z

    if-nez v0, :cond_3

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->B:Z

    if-eqz v0, :cond_0

    .line 627
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->u:Lcom/wishabi/flipp/b/aq;

    if-eqz v0, :cond_4

    .line 628
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->u:Lcom/wishabi/flipp/b/aq;

    invoke-virtual {v0, v8}, Lcom/wishabi/flipp/b/aq;->cancel(Z)Z

    .line 630
    :cond_4
    new-instance v0, Lcom/wishabi/flipp/app/ea;

    invoke-virtual {v2}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    iget-object v5, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Lcom/wishabi/flipp/app/ea;-><init>(Lcom/wishabi/flipp/app/SearchFragment;Landroid/content/Context;Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Landroid/app/LoaderManager;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->u:Lcom/wishabi/flipp/b/aq;

    .line 679
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->u:Lcom/wishabi/flipp/b/aq;

    new-array v1, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/aq;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 612
    :cond_5
    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v1, v6}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setIcon(I)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v3, 0x7f0e00f3

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v0, v5, v7

    invoke-virtual {p0, v3, v5}, Lcom/wishabi/flipp/app/SearchFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setTitle(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v1, v10}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setSubTitle(I)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/ZeroCaseView;->a()V

    goto :goto_1
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 12
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
    const/4 v7, 0x3

    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v8, 0x0

    const/4 v3, 0x0

    .line 413
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 414
    if-nez v1, :cond_1

    .line 485
    :cond_0
    :goto_0
    return-object v3

    .line 417
    :cond_1
    packed-switch p1, :pswitch_data_0

    .line 489
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Invalid loader id"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 419
    :pswitch_0
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->h:Landroid/net/Uri;

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v0

    goto :goto_0

    .line 422
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 425
    invoke-static {v3}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 427
    if-eqz v6, :cond_0

    .line 430
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    const-string v4, "postal_code = ? AND merchant like ?"

    new-array v5, v11, [Ljava/lang/String;

    aput-object v6, v5, v8

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "%"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const/16 v7, 0x25

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v10

    const-string v6, "premium DESC, merchant ASC"

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v0

    goto :goto_0

    .line 436
    :pswitch_2
    const-string v0, "item_ids"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getLongArray(Ljava/lang/String;)[J

    move-result-object v0

    .line 437
    if-eqz v0, :cond_0

    .line 439
    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->a([J)[Ljava/lang/String;

    move-result-object v5

    .line 440
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    const-string v4, "_id"

    invoke-static {v4, v5}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v0

    goto :goto_0

    .line 444
    :pswitch_3
    const-string v0, "coupon_ids"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v0

    .line 445
    if-eqz v0, :cond_0

    .line 447
    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->a([I)[Ljava/lang/String;

    move-result-object v4

    .line 449
    const-string v0, "c._id"

    invoke-static {v0, v4, v8}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v6

    .line 450
    if-eqz v6, :cond_2

    invoke-static {v4, v4}, Lcom/wishabi/flipp/util/a;->a([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    move-object v5, v0

    .line 452
    :goto_1
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->q:Landroid/net/Uri;

    new-array v3, v7, [Ljava/lang/String;

    const-string v7, "*"

    aput-object v7, v3, v8

    const-string v7, "sent"

    aput-object v7, v3, v10

    const-string v7, "clipped"

    aput-object v7, v3, v11

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "c._id"

    invoke-static {v8, v4}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v7, " AND deleted = 0"

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v0

    goto/16 :goto_0

    :cond_2
    move-object v5, v4

    .line 450
    goto :goto_1

    .line 459
    :pswitch_4
    const-string v0, "coupon_ids"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v0

    .line 460
    if-eqz v0, :cond_0

    .line 462
    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->a([I)[Ljava/lang/String;

    move-result-object v9

    .line 464
    new-instance v4, Landroid/content/CursorLoader;

    sget-object v6, Lcom/wishabi/flipp/content/i;->q:Landroid/net/Uri;

    new-array v7, v7, [Ljava/lang/String;

    const-string v0, "*"

    aput-object v0, v7, v8

    const-string v0, "sent"

    aput-object v0, v7, v10

    const-string v0, "clipped"

    aput-object v0, v7, v11

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "c._id"

    invoke-static {v2, v9}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " AND clipped = 1 AND deleted = 0"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    move-object v5, v1

    move-object v10, v3

    invoke-direct/range {v4 .. v10}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v4

    goto/16 :goto_0

    .line 473
    :pswitch_5
    const-string v0, "coupon_ids"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v0

    .line 474
    if-eqz v0, :cond_0

    .line 477
    invoke-static {v1, v0, v8, v10}, Lcom/wishabi/flipp/content/l;->a(Landroid/content/Context;[IZZ)Landroid/content/Loader;

    move-result-object v3

    goto/16 :goto_0

    .line 481
    :pswitch_6
    const-string v0, "item_ids"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getLongArray(Ljava/lang/String;)[J

    move-result-object v0

    .line 482
    if-eqz v0, :cond_0

    .line 485
    invoke-static {v1, v0}, Lcom/wishabi/flipp/content/l;->a(Landroid/content/Context;[J)Landroid/content/Loader;

    move-result-object v3

    goto/16 :goto_0

    .line 417
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_6
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 757
    invoke-super {p0, p1, p2}, Landroid/app/Fragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 759
    const v0, 0x7f100009

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 761
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 762
    const v0, 0x7f0b0155

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 763
    if-eqz v0, :cond_0

    if-nez v1, :cond_1

    .line 785
    :cond_0
    :goto_0
    return-void

    .line 766
    :cond_1
    iget-boolean v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->v:Z

    if-nez v2, :cond_2

    .line 767
    invoke-interface {v0, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0

    .line 771
    :cond_2
    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/SearchView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->c:Lcom/wishabi/flipp/widget/SearchView;

    .line 772
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->c:Lcom/wishabi/flipp/widget/SearchView;

    if-eqz v0, :cond_0

    .line 776
    const-string v0, "search"

    invoke-virtual {v1, v0}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/SearchManager;

    .line 778
    iget-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->c:Lcom/wishabi/flipp/widget/SearchView;

    invoke-virtual {v1}, Landroid/app/Activity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/SearchManager;->getSearchableInfo(Landroid/content/ComponentName;)Landroid/app/SearchableInfo;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/wishabi/flipp/widget/SearchView;->setSearchableInfo(Landroid/app/SearchableInfo;)V

    .line 780
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->c:Lcom/wishabi/flipp/widget/SearchView;

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/SearchView;->setIconifiedByDefault(Z)V

    .line 781
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->c:Lcom/wishabi/flipp/widget/SearchView;

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v3}, Lcom/wishabi/flipp/widget/SearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    .line 782
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->c:Lcom/wishabi/flipp/widget/SearchView;

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/SearchView;->setFocusable(Z)V

    .line 784
    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->g()V

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8

    .prologue
    .line 333
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/SearchFragment;->setHasOptionsMenu(Z)V

    .line 335
    const v0, 0x7f03004a

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 337
    if-nez v1, :cond_0

    .line 338
    const/4 v0, 0x0

    .line 408
    :goto_0
    return-object v0

    .line 340
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 341
    if-nez v0, :cond_1

    .line 342
    const/4 v0, 0x0

    goto :goto_0

    .line 344
    :cond_1
    new-instance v2, Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-direct {v2, v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    .line 345
    iget-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    new-instance v3, Lcom/wishabi/flipp/app/ek;

    invoke-direct {v3, p0}, Lcom/wishabi/flipp/app/ek;-><init>(Lcom/wishabi/flipp/app/SearchFragment;)V

    invoke-virtual {v2, v3}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 353
    new-instance v2, Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-direct {v2, v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->q:Lcom/wishabi/flipp/widget/ZeroCaseView;

    .line 354
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->q:Lcom/wishabi/flipp/widget/ZeroCaseView;

    new-instance v2, Lcom/wishabi/flipp/app/el;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/el;-><init>(Lcom/wishabi/flipp/app/SearchFragment;)V

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 362
    const v0, 0x7f0b0078

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->t:Landroid/view/View;

    .line 364
    const v0, 0x7f0b0118

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 366
    new-instance v2, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v2}, Landroid/view/animation/LinearInterpolator;-><init>()V

    new-instance v3, Landroid/animation/LayoutTransition;

    invoke-direct {v3}, Landroid/animation/LayoutTransition;-><init>()V

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    const v5, 0x7f050001

    invoke-static {v4, v5}, Landroid/animation/AnimatorInflater;->loadAnimator(Landroid/content/Context;I)Landroid/animation/Animator;

    move-result-object v4

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v5

    const v6, 0x7f050003

    invoke-static {v5, v6}, Landroid/animation/AnimatorInflater;->loadAnimator(Landroid/content/Context;I)Landroid/animation/Animator;

    move-result-object v5

    const/4 v6, 0x2

    invoke-virtual {v3, v6, v4}, Landroid/animation/LayoutTransition;->setAnimator(ILandroid/animation/Animator;)V

    const/4 v4, 0x3

    invoke-virtual {v3, v4, v5}, Landroid/animation/LayoutTransition;->setAnimator(ILandroid/animation/Animator;)V

    const/4 v4, 0x2

    const-wide/16 v6, 0x0

    invoke-virtual {v3, v4, v6, v7}, Landroid/animation/LayoutTransition;->setStartDelay(IJ)V

    const/4 v4, 0x3

    const-wide/16 v6, 0x0

    invoke-virtual {v3, v4, v6, v7}, Landroid/animation/LayoutTransition;->setStartDelay(IJ)V

    const/4 v4, 0x0

    const-wide/16 v6, 0x0

    invoke-virtual {v3, v4, v6, v7}, Landroid/animation/LayoutTransition;->setStartDelay(IJ)V

    const/4 v4, 0x1

    const-wide/16 v6, 0x0

    invoke-virtual {v3, v4, v6, v7}, Landroid/animation/LayoutTransition;->setStartDelay(IJ)V

    const-wide/16 v4, 0xc8

    invoke-virtual {v3, v4, v5}, Landroid/animation/LayoutTransition;->setDuration(J)V

    const/4 v4, 0x2

    invoke-virtual {v3, v4, v2}, Landroid/animation/LayoutTransition;->setInterpolator(ILandroid/animation/TimeInterpolator;)V

    const/4 v4, 0x3

    invoke-virtual {v3, v4, v2}, Landroid/animation/LayoutTransition;->setInterpolator(ILandroid/animation/TimeInterpolator;)V

    const/4 v4, 0x0

    invoke-virtual {v3, v4, v2}, Landroid/animation/LayoutTransition;->setInterpolator(ILandroid/animation/TimeInterpolator;)V

    const/4 v4, 0x1

    invoke-virtual {v3, v4, v2}, Landroid/animation/LayoutTransition;->setInterpolator(ILandroid/animation/TimeInterpolator;)V

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setLayoutTransition(Landroid/animation/LayoutTransition;)V

    .line 368
    const v0, 0x7f0b003f

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/CollectionView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    .line 372
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->n:Lcom/wishabi/flipp/widget/CollectionView;

    new-instance v2, Lcom/wishabi/flipp/app/em;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/em;-><init>(Lcom/wishabi/flipp/app/SearchFragment;)V

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/CollectionView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 380
    const v0, 0x7f0b00ad

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ShoppingListPopup;

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->o:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    .line 382
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->o:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    iget-object v2, p0, Lcom/wishabi/flipp/app/SearchFragment;->J:Lcom/wishabi/flipp/widget/dr;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->setShoppingListPopupListener(Lcom/wishabi/flipp/widget/dr;)V

    .line 384
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->o:Lcom/wishabi/flipp/widget/ShoppingListPopup;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ShoppingListPopup;->a(Z)V

    .line 386
    if-eqz p3, :cond_3

    .line 387
    const-string v0, "search_mode"

    const/4 v2, -0x1

    invoke-virtual {p3, v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 388
    const/4 v2, -0x1

    if-eq v0, v2, :cond_2

    .line 389
    invoke-static {}, Lcom/wishabi/flipp/app/en;->a()[I

    move-result-object v2

    aget v0, v2, v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/SearchFragment;->a(I)V

    .line 391
    :cond_2
    const-string v0, "SAVE_STATE_SEARCH_TAB_KEY"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->w:I

    .line 392
    const-string v0, "mQuery"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 393
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 394
    const/4 v2, 0x0

    invoke-virtual {p0, v0, v2}, Lcom/wishabi/flipp/app/SearchFragment;->a(Ljava/lang/String;Z)V

    .line 398
    :goto_1
    const-string v0, "SAVE_STATE_REQUEST_BUTTON_KEY"

    const/4 v2, 0x1

    invoke-virtual {p3, v0, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 400
    if-nez v0, :cond_3

    .line 401
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v2, 0x7f0200c4

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setIcon(I)V

    .line 402
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v2, 0x7f0e00f5

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setTitle(I)V

    .line 403
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setSubTitle(Ljava/lang/String;)V

    .line 404
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->a()V

    :cond_3
    move-object v0, v1

    .line 408
    goto/16 :goto_0

    .line 396
    :cond_4
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SearchFragment;->a()V

    goto :goto_1
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 567
    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    .line 568
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->u:Lcom/wishabi/flipp/b/aq;

    if-eqz v0, :cond_0

    .line 569
    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->u:Lcom/wishabi/flipp/b/aq;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/aq;->cancel(Z)Z

    .line 570
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->u:Lcom/wishabi/flipp/b/aq;

    .line 572
    :cond_0
    return-void
.end method

.method public onHiddenChanged(Z)V
    .locals 2

    .prologue
    .line 737
    invoke-super {p0, p1}, Landroid/app/Fragment;->onHiddenChanged(Z)V

    .line 739
    if-nez p1, :cond_0

    .line 740
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v1, "search"

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;)V

    .line 741
    :cond_0
    return-void
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 3

    .prologue
    .line 65
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid loader for search fragment"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    new-instance v0, Landroid/util/SparseBooleanArray;

    invoke-direct {v0}, Landroid/util/SparseBooleanArray;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->h:Landroid/util/SparseBooleanArray;

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    :goto_0
    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->h:Landroid/util/SparseBooleanArray;

    const-string v1, "_id"

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseBooleanArray;->put(IZ)V

    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    goto :goto_0

    :cond_0
    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->b()V

    :goto_1
    return-void

    :pswitch_1
    iput-object p2, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->b()V

    goto :goto_1

    :pswitch_2
    iput-object p2, p0, Lcom/wishabi/flipp/app/SearchFragment;->f:Landroid/database/Cursor;

    new-instance v0, Lcom/wishabi/flipp/content/ae;

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->f:Landroid/database/Cursor;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/content/ae;-><init>(Landroid/database/Cursor;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->g:Lcom/wishabi/flipp/content/ae;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->b()V

    goto :goto_1

    :pswitch_3
    iput-object p2, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->b()V

    goto :goto_1

    :pswitch_4
    iput-object p2, p0, Lcom/wishabi/flipp/app/SearchFragment;->k:Landroid/database/Cursor;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->b()V

    goto :goto_1

    :pswitch_5
    invoke-static {p2}, Lcom/wishabi/flipp/content/l;->b(Landroid/database/Cursor;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->l:Ljava/util/HashMap;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->b()V

    goto :goto_1

    :pswitch_6
    invoke-static {p2}, Lcom/wishabi/flipp/content/l;->a(Landroid/database/Cursor;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->i:Ljava/util/HashMap;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->b()V

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_6
        :pswitch_3
        :pswitch_4
        :pswitch_5
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

    .line 536
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 559
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid loader for search fragment"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 538
    :pswitch_0
    iput-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->h:Landroid/util/SparseBooleanArray;

    .line 562
    :goto_0
    invoke-direct {p0}, Lcom/wishabi/flipp/app/SearchFragment;->b()V

    .line 563
    return-void

    .line 541
    :pswitch_1
    iput-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->e:Landroid/database/Cursor;

    goto :goto_0

    .line 544
    :pswitch_2
    iput-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->f:Landroid/database/Cursor;

    goto :goto_0

    .line 547
    :pswitch_3
    iput-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->j:Landroid/database/Cursor;

    goto :goto_0

    .line 550
    :pswitch_4
    iput-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->k:Landroid/database/Cursor;

    goto :goto_0

    .line 553
    :pswitch_5
    iput-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->l:Ljava/util/HashMap;

    goto :goto_0

    .line 556
    :pswitch_6
    iput-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->i:Ljava/util/HashMap;

    goto :goto_0

    .line 536
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_6
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 731
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 732
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v1, "search"

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;)V

    .line 733
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 745
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 746
    const-string v0, "mQuery"

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->a:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 747
    const-string v0, "SAVE_STATE_SEARCH_TAB_KEY"

    iget v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->w:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 748
    const-string v0, "search_mode"

    iget v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->b:I

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 750
    iget v0, p0, Lcom/wishabi/flipp/app/SearchFragment;->b:I

    sget v1, Lcom/wishabi/flipp/app/en;->a:I

    if-ne v0, v1, :cond_0

    .line 751
    const-string v0, "SAVE_STATE_REQUEST_BUTTON_KEY"

    iget-object v1, p0, Lcom/wishabi/flipp/app/SearchFragment;->p:Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/ZeroCaseView;->b()Z

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 753
    :cond_0
    return-void
.end method
