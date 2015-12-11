.class public Lcom/wishabi/flipp/app/ClippingsFragment;
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
.field private final a:Lcom/wishabi/flipp/widget/p;

.field private final b:Lcom/wishabi/flipp/app/dn;

.field private final c:Lcom/wishabi/flipp/app/k;

.field private d:Lcom/wishabi/flipp/widget/CollectionView;

.field private e:Lcom/wishabi/flipp/widget/ZeroCaseView;

.field private f:Landroid/database/Cursor;

.field private g:Landroid/database/Cursor;

.field private h:Ljava/util/HashMap;
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

.field private i:Ljava/util/HashMap;
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

.field private j:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 127
    new-instance v0, Lcom/wishabi/flipp/app/f;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/f;-><init>(Lcom/wishabi/flipp/app/ClippingsFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->a:Lcom/wishabi/flipp/widget/p;

    .line 239
    new-instance v0, Lcom/wishabi/flipp/app/g;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/g;-><init>(Lcom/wishabi/flipp/app/ClippingsFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->b:Lcom/wishabi/flipp/app/dn;

    .line 266
    new-instance v0, Lcom/wishabi/flipp/app/h;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/h;-><init>(Lcom/wishabi/flipp/app/ClippingsFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->c:Lcom/wishabi/flipp/app/k;

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/ClippingsFragment;)Lcom/wishabi/flipp/widget/CollectionView;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    return-object v0
.end method

.method private static a(Landroid/database/Cursor;)Ljava/util/ArrayList;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    .line 786
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 787
    if-eqz p0, :cond_0

    invoke-interface {p0}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_1

    .line 804
    :cond_0
    return-object v0

    .line 790
    :cond_1
    const/4 v1, 0x0

    invoke-static {v1}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 791
    const-string v1, "_id"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    .line 792
    const-string v1, "deleted"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    .line 793
    const-string v1, "postal_code"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    .line 794
    const-string v1, "sent"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    .line 796
    invoke-interface {p0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    :goto_0
    if-eqz v1, :cond_0

    .line 798
    invoke-interface {p0, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-ne v1, v7, :cond_2

    invoke-interface {p0, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    :cond_2
    invoke-interface {p0, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-ne v1, v7, :cond_4

    .line 801
    :cond_3
    invoke-interface {p0, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 797
    :cond_4
    invoke-interface {p0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    goto :goto_0
.end method

.method private a()V
    .locals 5

    .prologue
    .line 487
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->f:Landroid/database/Cursor;

    if-nez v0, :cond_1

    .line 493
    :cond_0
    :goto_0
    return-void

    .line 490
    :cond_1
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v1, "clippings"

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;)V

    .line 491
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->f:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    iget-object v2, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v2

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    const-string v4, "count"

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "coupon_count"

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "Clippings"

    invoke-virtual {v0, v1, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0
.end method

.method private a(I)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 731
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 733
    if-nez v0, :cond_1

    .line 783
    :cond_0
    :goto_0
    return-void

    .line 736
    :cond_1
    invoke-virtual {v0}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 738
    if-eqz v1, :cond_0

    .line 741
    packed-switch p1, :pswitch_data_0

    goto :goto_0

    .line 743
    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    iget-object v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/CollectionView;->getMultiChoiceModeListener()Lcom/wishabi/flipp/widget/p;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    goto :goto_0

    .line 751
    :pswitch_1
    sget-object v0, Lcom/wishabi/flipp/util/g;->a:Lb/a/a/i;

    invoke-static {v0}, Lb/a/a/b;->a(Lb/a/a/i;)Lb/a/a/b;

    move-result-object v0

    .line 752
    invoke-static {}, Lb/a/a/d/aa;->c()Lb/a/a/d/d;

    move-result-object v2

    if-nez v2, :cond_2

    invoke-virtual {v0}, Lb/a/a/a/b;->toString()Ljava/lang/String;

    move-result-object v0

    .line 753
    :goto_1
    sget-object v2, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    const-string v3, "valid_to < ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 756
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 759
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Landroid/database/Cursor;)Ljava/util/ArrayList;

    move-result-object v0

    .line 761
    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 764
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 765
    const-string v3, "clipped"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 767
    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->a(Ljava/util/List;)[Ljava/lang/String;

    move-result-object v0

    .line 768
    sget-object v3, Lcom/wishabi/flipp/content/i;->t:Landroid/net/Uri;

    const-string v4, "_id"

    invoke-static {v4, v0}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v2, v4, v0}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_0

    .line 752
    :cond_2
    invoke-virtual {v2, v0}, Lb/a/a/d/d;->a(Lb/a/a/z;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 773
    :pswitch_2
    sget-object v0, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    invoke-virtual {v1, v0, v4, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_0

    .line 777
    :pswitch_3
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 778
    const-string v2, "clipped"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 779
    sget-object v2, Lcom/wishabi/flipp/content/i;->t:Landroid/net/Uri;

    invoke-virtual {v1, v2, v0, v4, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_0

    .line 741
    :pswitch_data_0
    .packed-switch 0x7f0b0151
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/ClippingsFragment;I)V
    .locals 10

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v7, 0x0

    .line 55
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v8

    if-eqz v8, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    if-eqz v0, :cond_1

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/g;->a(I)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/g;->getItemViewType(I)I

    move-result v0

    if-nez v0, :cond_2

    move-object v0, v1

    check-cast v0, Landroid/database/Cursor;

    const-string v1, "left"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v2

    const-string v1, "top"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v3

    const-string v1, "right"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v4

    const-string v1, "bottom"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v5

    const-string v1, "flyer_id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0, v2, v3, v4, v5}, Landroid/graphics/RectF;-><init>(FFFF)V

    move-object v6, v0

    move-object v5, v1

    :goto_0
    :try_start_0
    invoke-virtual {v8}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "flyer_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v9, 0x0

    aput-object v5, v4, v9

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    if-eqz v1, :cond_0

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    if-nez v0, :cond_4

    :cond_0
    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_1
    :goto_1
    return-void

    :cond_2
    if-ne v0, v3, :cond_3

    check-cast v1, Landroid/database/Cursor;

    const-string v0, "_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->i:Ljava/util/HashMap;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/o;

    iget v1, v0, Lcom/wishabi/flipp/content/o;->b:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/o;->a()Landroid/graphics/RectF;

    move-result-object v0

    move-object v6, v0

    move-object v5, v1

    goto :goto_0

    :cond_3
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Invalid index for item click: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_4
    :try_start_2
    new-instance v0, Lcom/wishabi/flipp/content/FlyerActivityIntent;

    invoke-direct {v0, v8, v1, v6}, Lcom/wishabi/flipp/content/FlyerActivityIntent;-><init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/graphics/RectF;)V

    invoke-virtual {v8, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    const v0, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v8, v0, v2}, Landroid/app/Activity;->overridePendingTransition(II)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_1

    :catchall_0
    move-exception v0

    move-object v1, v7

    :goto_2
    if-eqz v1, :cond_5

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v0

    :catchall_1
    move-exception v0

    goto :goto_2
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/ClippingsFragment;Z)V
    .locals 2

    .prologue
    .line 55
    iput-boolean p1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->j:Z

    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    if-eqz v0, :cond_0

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->j:Z

    iput-boolean v1, v0, Lcom/wishabi/flipp/widget/g;->g:Z

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/g;->notifyDataSetChanged()V

    :cond_0
    return-void
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/ClippingsFragment;)Landroid/database/Cursor;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    return-object v0
.end method

.method private b()V
    .locals 7

    .prologue
    .line 600
    new-instance v0, Lcom/wishabi/flipp/widget/g;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->f:Landroid/database/Cursor;

    iget-object v3, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    iget-object v4, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->h:Ljava/util/HashMap;

    iget-object v5, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->i:Ljava/util/HashMap;

    iget-object v6, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->b:Lcom/wishabi/flipp/app/dn;

    invoke-direct/range {v0 .. v6}, Lcom/wishabi/flipp/widget/g;-><init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/database/Cursor;Ljava/util/HashMap;Ljava/util/HashMap;Lcom/wishabi/flipp/app/dn;)V

    .line 607
    iget-object v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/CollectionView;->getActivatedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/CollectionView;->getActivatedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v1

    invoke-virtual {v1}, Landroid/util/SparseBooleanArray;->clone()Landroid/util/SparseBooleanArray;

    move-result-object v1

    .line 611
    :goto_0
    iget-boolean v2, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->j:Z

    iput-boolean v2, v0, Lcom/wishabi/flipp/widget/g;->g:Z

    .line 612
    iget-object v2, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v2, v0}, Lcom/wishabi/flipp/widget/CollectionView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 614
    if-nez v1, :cond_2

    .line 623
    :cond_0
    return-void

    .line 607
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    .line 618
    :cond_2
    const/4 v0, 0x0

    :goto_1
    invoke-virtual {v1}, Landroid/util/SparseBooleanArray;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 619
    invoke-virtual {v1, v0}, Landroid/util/SparseBooleanArray;->keyAt(I)I

    move-result v2

    .line 620
    invoke-virtual {v1, v2}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v3

    .line 621
    iget-object v4, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v4, v2, v3}, Lcom/wishabi/flipp/widget/CollectionView;->a(IZ)V

    .line 618
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/ClippingsFragment;I)V
    .locals 6

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 55
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/g;->a(I)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/g;->getItemViewType(I)I

    move-result v4

    if-nez v4, :cond_2

    move-object v0, v1

    check-cast v0, Landroid/database/Cursor;

    const-string v1, "_id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    iget-object v5, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->h:Ljava/util/HashMap;

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-static {v0}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;)[I

    move-result-object v1

    sget-object v0, Lcom/wishabi/flipp/b/p;->h:Lcom/wishabi/flipp/b/p;

    :goto_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v5

    if-ne v4, v2, :cond_5

    :goto_2
    invoke-static {v5, v1, v2, v0}, Lcom/wishabi/flipp/app/dr;->a(Landroid/app/Activity;[IZLcom/wishabi/flipp/b/p;)I

    goto :goto_0

    :cond_2
    if-ne v4, v2, :cond_4

    check-cast v1, Landroid/database/Cursor;

    const-string v0, "_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    const-string v0, "deleted"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v2, :cond_3

    move v0, v2

    :goto_3
    if-nez v0, :cond_0

    new-array v1, v2, [I

    aput v5, v1, v3

    sget-object v0, Lcom/wishabi/flipp/b/p;->f:Lcom/wishabi/flipp/b/p;

    goto :goto_1

    :cond_3
    move v0, v3

    goto :goto_3

    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Invalid index for coupon click: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_5
    move v2, v3

    goto :goto_2
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/ClippingsFragment;)Landroid/database/Cursor;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->f:Landroid/database/Cursor;

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/ClippingsFragment;I)V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(I)V

    return-void
.end method


# virtual methods
.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 11
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
    const/4 v5, 0x1

    const/4 v3, 0x0

    .line 497
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 498
    if-nez v1, :cond_1

    .line 519
    :cond_0
    :goto_0
    return-object v3

    .line 501
    :cond_1
    packed-switch p1, :pswitch_data_0

    .line 522
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bad loader id"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 503
    :pswitch_0
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    const-string v6, "merchant, flyer_id, left"

    move-object v4, v3

    move-object v5, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v0

    goto :goto_0

    .line 506
    :pswitch_1
    const-string v0, "item_ids"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getLongArray(Ljava/lang/String;)[J

    move-result-object v0

    .line 507
    if-eqz v0, :cond_0

    .line 509
    invoke-static {v1, v0}, Lcom/wishabi/flipp/content/l;->a(Landroid/content/Context;[J)Landroid/content/Loader;

    move-result-object v3

    goto :goto_0

    .line 512
    :pswitch_2
    new-instance v4, Landroid/content/CursorLoader;

    sget-object v6, Lcom/wishabi/flipp/content/i;->q:Landroid/net/Uri;

    const/4 v0, 0x3

    new-array v7, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v2, "*"

    aput-object v2, v7, v0

    const-string v0, "sent"

    aput-object v0, v7, v5

    const/4 v0, 0x2

    const-string v2, "clipped"

    aput-object v2, v7, v0

    const-string v8, "clipped = 1"

    const-string v10, "deleted ASC, priority ASC"

    move-object v5, v1

    move-object v9, v3

    invoke-direct/range {v4 .. v10}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v4

    goto :goto_0

    .line 516
    :pswitch_3
    const-string v0, "coupon_ids"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v0

    .line 517
    if-eqz v0, :cond_0

    .line 519
    invoke-static {v1, v0, v5, v5}, Lcom/wishabi/flipp/content/l;->a(Landroid/content/Context;[IZZ)Landroid/content/Loader;

    move-result-object v3

    goto :goto_0

    .line 501
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 662
    const/high16 v0, 0x7f100000

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 663
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v3, 0x0

    const/4 v1, 0x0

    .line 290
    invoke-super {p0, p1, p2, p3}, Landroid/app/Fragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 292
    invoke-virtual {p0, v8}, Lcom/wishabi/flipp/app/ClippingsFragment;->setHasOptionsMenu(Z)V

    .line 294
    const v0, 0x7f030008

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 296
    if-nez v2, :cond_0

    move-object v0, v1

    .line 344
    :goto_0
    return-object v0

    .line 299
    :cond_0
    const v0, 0x7f0b003e

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ZeroCaseView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->e:Lcom/wishabi/flipp/widget/ZeroCaseView;

    .line 301
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->e:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v4, 0x7f0200d4

    invoke-virtual {v0, v4}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setIcon(I)V

    .line 302
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->e:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v4, 0x7f0e00e6

    invoke-virtual {v0, v4}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setTitle(I)V

    .line 303
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->e:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v4, 0x7f0e00e7

    invoke-virtual {v0, v4}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setSubTitle(I)V

    .line 305
    const v0, 0x7f0b003f

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/CollectionView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    .line 307
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    if-nez v0, :cond_1

    move-object v0, v1

    .line 308
    goto :goto_0

    .line 310
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    iget-object v4, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->e:Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v0, v4}, Lcom/wishabi/flipp/widget/CollectionView;->setEmptyView(Landroid/view/View;)V

    .line 311
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    const/4 v4, 0x3

    invoke-virtual {v0, v4}, Lcom/wishabi/flipp/widget/CollectionView;->setChoiceMode(I)V

    .line 313
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    iget-object v4, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->a:Lcom/wishabi/flipp/widget/p;

    invoke-virtual {v0, v4}, Lcom/wishabi/flipp/widget/CollectionView;->setMultiChoiceModeListener(Lcom/wishabi/flipp/widget/p;)V

    .line 315
    new-instance v0, Lcom/wishabi/flipp/widget/eg;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-direct {v0, v4}, Lcom/wishabi/flipp/widget/eg;-><init>(Landroid/content/Context;)V

    .line 316
    new-instance v4, Lcom/wishabi/flipp/widget/h;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v5

    iget-object v6, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-direct {v4, v5, v6}, Lcom/wishabi/flipp/widget/h;-><init>(Landroid/content/Context;Lcom/wishabi/flipp/widget/CollectionView;)V

    iput-object v4, v0, Lcom/wishabi/flipp/widget/eg;->b:Lcom/wishabi/flipp/widget/eh;

    .line 317
    iget-object v4, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v4, v0}, Lcom/wishabi/flipp/widget/CollectionView;->setLayout(Lcom/wishabi/flipp/widget/n;)V

    .line 319
    if-eqz p3, :cond_2

    .line 320
    const-string v0, "activatedClippingPositions"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v4

    .line 323
    if-eqz v4, :cond_2

    .line 324
    array-length v5, v4

    move v0, v3

    :goto_1
    if-ge v0, v5, :cond_2

    aget v6, v4, v0

    .line 325
    iget-object v7, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v7, v6, v8}, Lcom/wishabi/flipp/widget/CollectionView;->a(IZ)V

    .line 324
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 330
    :cond_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const-string v4, "EditDialogFragment"

    invoke-virtual {v0, v4}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/i;

    .line 335
    if-eqz v0, :cond_3

    .line 336
    iget-object v4, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->c:Lcom/wishabi/flipp/app/k;

    iput-object v4, v0, Lcom/wishabi/flipp/app/i;->a:Lcom/wishabi/flipp/app/k;

    .line 338
    :cond_3
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    .line 339
    if-eqz v0, :cond_4

    .line 340
    invoke-virtual {v0, v3, v1, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 341
    const/4 v3, 0x2

    invoke-virtual {v0, v3, v1, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_4
    move-object v0, v2

    .line 344
    goto/16 :goto_0
.end method

.method public onHiddenChanged(Z)V
    .locals 1

    .prologue
    .line 471
    invoke-super {p0, p1}, Landroid/app/Fragment;->onHiddenChanged(Z)V

    .line 472
    if-nez p1, :cond_1

    .line 473
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->a()V

    .line 476
    :cond_0
    :goto_0
    return-void

    .line 474
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    if-eqz v0, :cond_0

    .line 475
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->a()V

    goto :goto_0
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 8

    .prologue
    .line 55
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v2

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad loader id"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->f:Landroid/database/Cursor;

    if-eq v0, p2, :cond_0

    iput-object p2, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->f:Landroid/database/Cursor;

    if-eqz v2, :cond_0

    if-nez p2, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    const-string v0, "_id"

    invoke-interface {p2}, Landroid/database/Cursor;->getPosition()I

    move-result v3

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v1

    new-array v4, v1, [J

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    const/4 v0, 0x0

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_2

    :goto_1
    add-int/lit8 v1, v0, 0x1

    invoke-interface {p2, v5}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    aput-wide v6, v4, v0

    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-nez v0, :cond_6

    :cond_2
    invoke-interface {p2, v3}, Landroid/database/Cursor;->moveToPosition(I)Z

    array-length v0, v4

    if-lez v0, :cond_3

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "item_ids"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->putLongArray(Ljava/lang/String;[J)V

    const/4 v1, 0x1

    invoke-virtual {v2, v1, v0, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_3
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->b()V

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->isHidden()Z

    move-result v0

    if-nez v0, :cond_4

    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->a()V

    :cond_4
    :goto_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/FragmentManager;->invalidateOptionsMenu()V

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    if-eq v0, p2, :cond_0

    iput-object p2, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    const-string v0, "_id"

    invoke-static {p2, v0}, Lcom/wishabi/flipp/util/f;->a(Landroid/database/Cursor;Ljava/lang/String;)[I

    move-result-object v0

    array-length v1, v0

    if-lez v1, :cond_5

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    const-string v3, "coupon_ids"

    invoke-virtual {v1, v3, v0}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    const/4 v0, 0x3

    invoke-virtual {v2, v0, v1, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_5
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->b()V

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->isHidden()Z

    move-result v0

    if-nez v0, :cond_4

    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->a()V

    goto :goto_2

    :pswitch_2
    invoke-static {p2}, Lcom/wishabi/flipp/content/l;->a(Landroid/database/Cursor;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->h:Ljava/util/HashMap;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->b()V

    goto :goto_2

    :pswitch_3
    invoke-static {p2}, Lcom/wishabi/flipp/content/l;->b(Landroid/database/Cursor;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->i:Ljava/util/HashMap;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->b()V

    goto :goto_2

    :cond_6
    move v0, v1

    goto :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
        :pswitch_3
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

    .line 638
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 656
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad loader id"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 640
    :pswitch_0
    iput-object v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->f:Landroid/database/Cursor;

    .line 641
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->b()V

    .line 654
    :goto_0
    return-void

    .line 644
    :pswitch_1
    iput-object v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->h:Ljava/util/HashMap;

    .line 645
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->b()V

    goto :goto_0

    .line 648
    :pswitch_2
    iput-object v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    .line 649
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->b()V

    goto :goto_0

    .line 652
    :pswitch_3
    iput-object v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->i:Ljava/util/HashMap;

    .line 653
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->b()V

    goto :goto_0

    .line 638
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 5

    .prologue
    const/4 v0, 0x1

    .line 691
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 693
    if-nez v1, :cond_0

    .line 694
    invoke-super {p0, p1}, Landroid/app/Fragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    .line 707
    :goto_0
    return v0

    .line 696
    :cond_0
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    const v2, 0x7f0b0151

    if-ne v1, v2, :cond_1

    .line 697
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    invoke-direct {p0, v1}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(I)V

    goto :goto_0

    .line 701
    :cond_1
    new-instance v1, Lcom/wishabi/flipp/app/i;

    invoke-direct {v1}, Lcom/wishabi/flipp/app/i;-><init>()V

    .line 702
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 703
    const-string v3, "EDIT_MENU_ITEM_KEY"

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 704
    invoke-virtual {v1, v2}, Lcom/wishabi/flipp/app/i;->setArguments(Landroid/os/Bundle;)V

    .line 705
    iget-object v2, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->c:Lcom/wishabi/flipp/app/k;

    iput-object v2, v1, Lcom/wishabi/flipp/app/i;->a:Lcom/wishabi/flipp/app/k;

    .line 706
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    const-string v3, "EditDialogFragment"

    invoke-virtual {v1, v2, v3}, Lcom/wishabi/flipp/app/i;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)V
    .locals 14

    .prologue
    .line 667
    invoke-super {p0, p1}, Landroid/app/Fragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V

    .line 669
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_3

    const/4 v0, 0x1

    .line 670
    :goto_0
    iget-object v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->f:Landroid/database/Cursor;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->f:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_4

    const/4 v1, 0x1

    .line 672
    :goto_1
    const v2, 0x7f0b0152

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v4

    .line 675
    iget-object v2, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->g:Landroid/database/Cursor;

    invoke-static {v2}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Landroid/database/Cursor;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    iget-object v5, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->f:Landroid/database/Cursor;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    if-eqz v5, :cond_0

    invoke-interface {v5}, Landroid/database/Cursor;->getCount()I

    move-result v3

    if-nez v3, :cond_5

    :cond_0
    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_8

    :cond_1
    const/4 v2, 0x1

    :goto_2
    invoke-interface {v4, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 679
    const v2, 0x7f0b0151

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v3

    .line 680
    if-nez v0, :cond_2

    if-eqz v1, :cond_9

    :cond_2
    const/4 v2, 0x1

    :goto_3
    invoke-interface {v3, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 682
    const v2, 0x7f0b0154

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v2

    .line 683
    invoke-interface {v2, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 685
    const v0, 0x7f0b0153

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 686
    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 687
    return-void

    .line 669
    :cond_3
    const/4 v0, 0x0

    goto :goto_0

    .line 670
    :cond_4
    const/4 v1, 0x0

    goto :goto_1

    .line 675
    :cond_5
    sget-object v3, Lcom/wishabi/flipp/util/g;->a:Lb/a/a/i;

    invoke-static {v3}, Lb/a/a/b;->a(Lb/a/a/i;)Lb/a/a/b;

    move-result-object v6

    const-string v3, "_id"

    invoke-interface {v5, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v7

    const-string v3, "valid_to"

    invoke-interface {v5, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v8

    invoke-static {}, Lb/a/a/d/aa;->a()Lb/a/a/d/d;

    move-result-object v9

    invoke-interface {v5}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    :goto_4
    if-eqz v3, :cond_0

    invoke-interface {v5, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_6

    invoke-virtual {v9, v3}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v3

    invoke-static {v6}, Lb/a/a/f;->a(Lb/a/a/z;)J

    move-result-wide v10

    invoke-virtual {v3}, Lb/a/a/a/b;->a()J

    move-result-wide v12

    cmp-long v3, v12, v10

    if-gez v3, :cond_7

    const/4 v3, 0x1

    :goto_5
    if-eqz v3, :cond_6

    invoke-interface {v5, v7}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_6
    invoke-interface {v5}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    goto :goto_4

    :cond_7
    const/4 v3, 0x0

    goto :goto_5

    :cond_8
    const/4 v2, 0x0

    goto :goto_2

    .line 680
    :cond_9
    const/4 v2, 0x0

    goto :goto_3
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 480
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 482
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->isHidden()Z

    move-result v0

    if-nez v0, :cond_0

    .line 483
    invoke-direct {p0}, Lcom/wishabi/flipp/app/ClippingsFragment;->a()V

    .line 484
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    .line 712
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 714
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getActivatedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v0

    if-nez v0, :cond_1

    .line 716
    :cond_0
    const-string v0, "activatedClippingPositions"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    .line 728
    :goto_0
    return-void

    .line 720
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ClippingsFragment;->d:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getActivatedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v1

    .line 723
    invoke-virtual {v1}, Landroid/util/SparseBooleanArray;->size()I

    move-result v0

    new-array v2, v0, [I

    .line 724
    const/4 v0, 0x0

    invoke-virtual {v1}, Landroid/util/SparseBooleanArray;->size()I

    move-result v3

    :goto_1
    if-ge v0, v3, :cond_2

    .line 725
    invoke-virtual {v1, v0}, Landroid/util/SparseBooleanArray;->keyAt(I)I

    move-result v4

    aput v4, v2, v0

    .line 724
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 727
    :cond_2
    const-string v0, "activatedClippingPositions"

    invoke-virtual {p1, v0, v2}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    goto :goto_0
.end method
