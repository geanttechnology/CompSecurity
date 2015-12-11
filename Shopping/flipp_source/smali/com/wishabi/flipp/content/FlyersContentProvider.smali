.class public Lcom/wishabi/flipp/content/FlyersContentProvider;
.super Landroid/content/ContentProvider;
.source "SourceFile"


# static fields
.field private static final a:Landroid/content/UriMatcher;

.field private static final c:[Lcom/wishabi/flipp/content/x;


# instance fields
.field private b:Landroid/database/sqlite/SQLiteDatabase;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x5

    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    .line 39
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    .line 53
    sput-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.content.Flyer"

    const-string v2, "flyers"

    invoke-virtual {v0, v1, v2, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 54
    sget-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.content.Flyer"

    const-string v2, "flyers/#"

    invoke-virtual {v0, v1, v2, v5}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 55
    sget-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.content.Flyer"

    const-string v2, "categories"

    invoke-virtual {v0, v1, v2, v6}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 56
    sget-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.content.Flyer"

    const-string v2, "items"

    invoke-virtual {v0, v1, v2, v7}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 57
    sget-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.content.Flyer"

    const-string v2, "featured_items"

    invoke-virtual {v0, v1, v2, v8}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 58
    sget-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.content.Flyer"

    const-string v2, "coupons"

    const/4 v3, 0x6

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 59
    sget-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.content.Flyer"

    const-string v2, "coupon_categories"

    const/4 v3, 0x7

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 61
    sget-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.content.Flyer"

    const-string v2, "flyer_item_coupons"

    const/16 v3, 0x8

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 63
    sget-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.content.Flyer"

    const-string v2, "flyer_pages"

    const/16 v3, 0x9

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 74
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/wishabi/flipp/content/x;

    const/4 v1, 0x0

    new-instance v2, Lcom/wishabi/flipp/content/p;

    invoke-direct {v2}, Lcom/wishabi/flipp/content/p;-><init>()V

    aput-object v2, v0, v1

    new-instance v1, Lcom/wishabi/flipp/content/q;

    invoke-direct {v1}, Lcom/wishabi/flipp/content/q;-><init>()V

    aput-object v1, v0, v4

    new-instance v1, Lcom/wishabi/flipp/content/r;

    invoke-direct {v1}, Lcom/wishabi/flipp/content/r;-><init>()V

    aput-object v1, v0, v5

    new-instance v1, Lcom/wishabi/flipp/content/s;

    invoke-direct {v1}, Lcom/wishabi/flipp/content/s;-><init>()V

    aput-object v1, v0, v6

    new-instance v1, Lcom/wishabi/flipp/content/t;

    invoke-direct {v1}, Lcom/wishabi/flipp/content/t;-><init>()V

    aput-object v1, v0, v7

    new-instance v1, Lcom/wishabi/flipp/content/u;

    invoke-direct {v1}, Lcom/wishabi/flipp/content/u;-><init>()V

    aput-object v1, v0, v8

    const/4 v1, 0x6

    new-instance v2, Lcom/wishabi/flipp/content/v;

    invoke-direct {v2}, Lcom/wishabi/flipp/content/v;-><init>()V

    aput-object v2, v0, v1

    sput-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->c:[Lcom/wishabi/flipp/content/x;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    .line 284
    return-void
.end method

.method static synthetic a()[Lcom/wishabi/flipp/content/x;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->c:[Lcom/wishabi/flipp/content/x;

    return-object v0
.end method


# virtual methods
.method public applyBatch(Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/content/ContentProviderOperation;",
            ">;)[",
            "Landroid/content/ContentProviderResult;"
        }
    .end annotation

    .prologue
    .line 322
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 323
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 324
    new-array v3, v2, [Landroid/content/ContentProviderResult;

    .line 325
    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    .line 329
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_0

    .line 330
    :try_start_0
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentProviderOperation;

    .line 331
    invoke-virtual {v0}, Landroid/content/ContentProviderOperation;->getUri()Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 332
    invoke-virtual {v0, p0, v3, v1}, Landroid/content/ContentProviderOperation;->apply(Landroid/content/ContentProvider;[Landroid/content/ContentProviderResult;I)Landroid/content/ContentProviderResult;

    move-result-object v0

    aput-object v0, v3, v1

    .line 329
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 334
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 339
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 340
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/FlyersContentProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 342
    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    .line 343
    const/4 v4, 0x0

    invoke-virtual {v1, v0, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_1

    .line 339
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 344
    throw v0

    :cond_1
    return-object v3
.end method

.method public bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    .locals 10

    .prologue
    const/4 v5, 0x5

    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 590
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/FlyersContentProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    .line 591
    if-nez v3, :cond_0

    .line 630
    :goto_0
    return v1

    .line 596
    :cond_0
    sget-object v2, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    invoke-virtual {v2, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    .line 597
    const/4 v4, 0x1

    if-ne v2, v4, :cond_3

    .line 598
    const-string v0, "flyers"

    .line 612
    :cond_1
    :goto_1
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_a

    .line 614
    iget-object v2, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 616
    :try_start_0
    array-length v4, p2

    move v2, v1

    :goto_2
    if-ge v2, v4, :cond_9

    aget-object v5, p2, v2

    .line 617
    iget-object v6, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v7, 0x0

    const/4 v8, 0x5

    invoke-virtual {v6, v0, v7, v5, v8}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    .line 619
    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmp-long v5, v6, v8

    if-ltz v5, :cond_2

    .line 620
    add-int/lit8 v1, v1, 0x1

    .line 616
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 599
    :cond_3
    const/4 v4, 0x3

    if-ne v2, v4, :cond_4

    .line 600
    const-string v0, "categories"

    goto :goto_1

    .line 601
    :cond_4
    const/4 v4, 0x4

    if-ne v2, v4, :cond_5

    .line 602
    const-string v0, "items"

    goto :goto_1

    .line 603
    :cond_5
    if-ne v2, v5, :cond_6

    .line 604
    const-string v0, "featured_items"

    goto :goto_1

    .line 605
    :cond_6
    const/4 v4, 0x6

    if-ne v2, v4, :cond_7

    .line 606
    const-string v0, "coupons"

    goto :goto_1

    .line 607
    :cond_7
    const/4 v4, 0x7

    if-ne v2, v4, :cond_8

    .line 608
    const-string v0, "coupon_categories"

    goto :goto_1

    .line 609
    :cond_8
    const/16 v4, 0x8

    if-ne v2, v4, :cond_1

    .line 610
    const-string v0, "flyer_item_coupons"

    goto :goto_1

    .line 622
    :cond_9
    :try_start_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 623
    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v2, 0x0

    invoke-virtual {v0, p1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 625
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v0

    .line 630
    :cond_a
    invoke-super {p0, p1, p2}, Landroid/content/ContentProvider;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I

    move-result v1

    goto :goto_0
.end method

.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 3

    .prologue
    .line 635
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/FlyersContentProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 636
    if-nez v1, :cond_1

    .line 637
    const/4 v0, 0x0

    .line 675
    :cond_0
    :goto_0
    return v0

    .line 640
    :cond_1
    sget-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    .line 641
    packed-switch v0, :pswitch_data_0

    .line 670
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unknown URI "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 643
    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "flyers"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 673
    :goto_1
    if-lez v0, :cond_0

    iget-object v2, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v2

    if-nez v2, :cond_0

    .line 674
    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_0

    .line 646
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "flyers"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 649
    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "categories"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 652
    :pswitch_3
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "items"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 655
    :pswitch_4
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "featured_items"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 658
    :pswitch_5
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "coupons"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 661
    :pswitch_6
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "coupon_categories"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 664
    :pswitch_7
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "flyer_item_coupons"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 667
    :pswitch_8
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "flyer_pages"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 641
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 308
    const-string v0, "vnd.android.cursor.dir/vnd.flipp.flyer"

    return-object v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 10

    .prologue
    const-wide/16 v8, 0x0

    const/4 v6, 0x5

    const/4 v0, 0x0

    .line 515
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/FlyersContentProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 516
    if-nez v2, :cond_0

    .line 585
    :goto_0
    return-object v0

    .line 519
    :cond_0
    const-wide/16 v4, -0x1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 521
    sget-object v1, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v1

    .line 522
    packed-switch v1, :pswitch_data_0

    .line 579
    :pswitch_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "unsupported uri: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 524
    :pswitch_1
    iget-object v1, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "flyers"

    invoke-virtual {v1, v3, v0, p2, v6}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 526
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v8

    if-ltz v3, :cond_2

    .line 527
    sget-object v3, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 582
    :goto_1
    if-eqz v1, :cond_1

    iget-object v3, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v3

    if-nez v3, :cond_1

    .line 583
    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    :cond_1
    move-object v0, v1

    .line 585
    goto :goto_0

    .line 531
    :pswitch_2
    iget-object v1, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "categories"

    invoke-virtual {v1, v3, v0, p2, v6}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 533
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v8

    if-ltz v3, :cond_2

    .line 534
    sget-object v3, Lcom/wishabi/flipp/content/i;->b:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    goto :goto_1

    .line 538
    :pswitch_3
    iget-object v1, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "items"

    invoke-virtual {v1, v3, v0, p2, v6}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 540
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v8

    if-ltz v3, :cond_2

    .line 541
    sget-object v3, Lcom/wishabi/flipp/content/i;->c:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    goto :goto_1

    .line 544
    :pswitch_4
    iget-object v1, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "featured_items"

    invoke-virtual {v1, v3, v0, p2, v6}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 546
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v8

    if-ltz v3, :cond_2

    .line 547
    sget-object v3, Lcom/wishabi/flipp/content/i;->e:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    goto :goto_1

    .line 551
    :pswitch_5
    iget-object v1, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "coupons"

    invoke-virtual {v1, v3, v0, p2, v6}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 553
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v8

    if-ltz v3, :cond_2

    .line 554
    sget-object v3, Lcom/wishabi/flipp/content/i;->n:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    goto/16 :goto_1

    .line 558
    :pswitch_6
    iget-object v1, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "coupon_categories"

    invoke-virtual {v1, v3, v0, p2, v6}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 560
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v8

    if-ltz v3, :cond_2

    .line 561
    sget-object v3, Lcom/wishabi/flipp/content/i;->o:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    goto/16 :goto_1

    .line 565
    :pswitch_7
    iget-object v1, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "flyer_item_coupons"

    invoke-virtual {v1, v3, v0, p2, v6}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 567
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v8

    if-ltz v3, :cond_2

    .line 568
    sget-object v3, Lcom/wishabi/flipp/content/i;->p:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    goto/16 :goto_1

    .line 572
    :pswitch_8
    iget-object v1, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "flyer_pages"

    invoke-virtual {v1, v3, v0, p2, v6}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 574
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v8

    if-ltz v3, :cond_2

    .line 575
    sget-object v3, Lcom/wishabi/flipp/content/i;->d:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    goto/16 :goto_1

    :cond_2
    move-object v1, v0

    goto/16 :goto_1

    .line 522
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method public onCreate()Z
    .locals 2

    .prologue
    .line 313
    new-instance v0, Lcom/wishabi/flipp/content/w;

    invoke-virtual {p0}, Lcom/wishabi/flipp/content/FlyersContentProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/content/w;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/w;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    .line 314
    const/4 v0, 0x1

    return v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 11

    .prologue
    .line 351
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/FlyersContentProvider;->getContext()Landroid/content/Context;

    move-result-object v10

    .line 352
    if-nez v10, :cond_0

    .line 353
    const/4 v0, 0x0

    .line 404
    :goto_0
    return-object v0

    .line 356
    :cond_0
    sget-object v0, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    .line 357
    packed-switch v0, :pswitch_data_0

    .line 397
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "unsupported uri: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 359
    :pswitch_0
    if-nez p5, :cond_b

    const-string v7, "premium DESC, priority ASC, available_from DESC"

    :goto_1
    const-string v0, "filter_field"

    invoke-virtual {p1, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_8

    const-string v0, "filter_field"

    invoke-virtual {p1, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "filter_values"

    invoke-virtual {p1, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v0, :cond_1

    if-nez v1, :cond_2

    :cond_1
    const/4 v0, 0x0

    .line 400
    :goto_2
    if-nez v0, :cond_9

    .line 401
    const/4 v0, 0x0

    goto :goto_0

    .line 359
    :cond_2
    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    const-string v2, "categories"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    const-string v0, "categories.name"

    move-object v4, v0

    :goto_3
    if-nez p3, :cond_4

    const-string v0, ""

    :goto_4
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " in ("

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "?"

    array-length v3, v1

    const-string v5, ","

    invoke-static {v2, v3, v5}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ")"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    if-nez p4, :cond_5

    move-object v0, v1

    :goto_5
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "CASE "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v2, 0x0

    :goto_6
    array-length v6, v1

    if-ge v2, v6, :cond_6

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, "WHEN ? THEN "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, " "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    :cond_3
    invoke-static {v1}, Lcom/wishabi/flipp/util/q;->a([Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_a

    const/4 v0, 0x0

    goto/16 :goto_2

    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " AND "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_4

    :cond_5
    invoke-static {p4, v1}, Lcom/wishabi/flipp/util/a;->a([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    goto :goto_5

    :cond_6
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "END"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "categories.name"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "SELECT flyers.* FROM flyers, categories WHERE flyers._id = categories.flyer_id AND "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " ORDER BY "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :goto_7
    invoke-static {v0, v1}, Lcom/wishabi/flipp/util/a;->a([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    const-string v1, "query: \'%s\' args: \'%s\'"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v2, v3, v4

    const/4 v4, 0x1

    invoke-static {v0}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    iget-object v1, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1, v2, v0}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_2

    :cond_7
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "SELECT * FROM flyers WHERE "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " ORDER BY "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_7

    :cond_8
    const-string v0, "table: \'flyers\' projection: \'%s\' selection: \'%s\'selectionArgs: \'%s\' sort: \'%s\'"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p2}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p3, v1, v2

    const/4 v2, 0x2

    invoke-static {p4}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object v7, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "flyers"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_2

    .line 363
    :pswitch_1
    invoke-static {p1}, Landroid/content/ContentUris;->parseId(Landroid/net/Uri;)J

    move-result-wide v2

    .line 364
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "flyers"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "_id = "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v2, p2

    move-object v4, p4

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_2

    .line 369
    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v1, 0x1

    const-string v2, "categories"

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v9, 0x0

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object/from16 v8, p5

    invoke-virtual/range {v0 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_2

    .line 373
    :pswitch_3
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "items"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object/from16 v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_2

    .line 377
    :pswitch_4
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "featured_items"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object/from16 v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_2

    .line 381
    :pswitch_5
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "coupons"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object/from16 v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_2

    .line 385
    :pswitch_6
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v1, 0x1

    const-string v2, "coupon_categories"

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v9, 0x0

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object/from16 v8, p5

    invoke-virtual/range {v0 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_2

    .line 389
    :pswitch_7
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "flyer_item_coupons"

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v8, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object/from16 v7, p5

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_2

    .line 393
    :pswitch_8
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "flyer_pages"

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v8, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object/from16 v7, p5

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_2

    .line 403
    :cond_9
    invoke-virtual {v10}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto/16 :goto_0

    :cond_a
    move-object v4, v0

    goto/16 :goto_3

    :cond_b
    move-object/from16 v7, p5

    goto/16 :goto_1

    .line 357
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 681
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/FlyersContentProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 682
    if-nez v1, :cond_1

    .line 730
    :cond_0
    :goto_0
    return v0

    .line 686
    :cond_1
    sget-object v2, Lcom/wishabi/flipp/content/FlyersContentProvider;->a:Landroid/content/UriMatcher;

    invoke-virtual {v2, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 725
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unknown URI "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 688
    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "flyers"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 728
    :cond_2
    :goto_1
    if-lez v0, :cond_0

    iget-object v2, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v2

    if-nez v2, :cond_0

    .line 729
    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_0

    .line 691
    :pswitch_1
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    .line 692
    if-eqz v2, :cond_2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x2

    if-lt v2, v3, :cond_2

    .line 693
    iget-object v2, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "flyers"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v0, "_id = "

    invoke-direct {v4, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    const/4 v5, 0x1

    invoke-interface {v0, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, ""

    :goto_2
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, p2, v0, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v5, " AND ("

    invoke-direct {v0, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, ")"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    .line 701
    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "categories"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 704
    :pswitch_3
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "items"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 707
    :pswitch_4
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "featured_items"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 710
    :pswitch_5
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "coupons"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto/16 :goto_1

    .line 713
    :pswitch_6
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "coupon_categories"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto/16 :goto_1

    .line 717
    :pswitch_7
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "flyer_item_coupons"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto/16 :goto_1

    .line 721
    :pswitch_8
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyersContentProvider;->b:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "flyer_pages"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto/16 :goto_1

    .line 686
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method
