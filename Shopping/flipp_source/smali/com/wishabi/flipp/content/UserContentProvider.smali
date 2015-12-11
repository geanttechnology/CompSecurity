.class public Lcom/wishabi/flipp/content/UserContentProvider;
.super Landroid/content/ContentProvider;
.source "SourceFile"


# static fields
.field private static c:[Ljava/lang/String;

.field private static d:[Ljava/lang/String;

.field private static final e:Landroid/content/UriMatcher;

.field private static final f:[Lcom/wishabi/flipp/content/bk;


# instance fields
.field private a:Landroid/database/sqlite/SQLiteDatabase;

.field private b:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    .line 61
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    .line 62
    sput-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "favorite_merchants"

    invoke-virtual {v0, v1, v2, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 64
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "clippings"

    invoke-virtual {v0, v1, v2, v5}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 65
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "read_flyers"

    invoke-virtual {v0, v1, v2, v6}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 66
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "sent_analytics"

    invoke-virtual {v0, v1, v2, v7}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 67
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "shopping_lists"

    const/4 v3, 0x5

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 68
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "shopping_list_items"

    const/4 v3, 0x6

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 70
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "shopping_list_items/categories"

    const/4 v3, 0x7

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 72
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "shopping_list_items/cat_order"

    const/16 v3, 0x8

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 74
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "coupons_query"

    const/16 v3, 0x9

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 75
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "coupons_for_items"

    const/16 v3, 0xa

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 77
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "items_for_coupons"

    const/16 v3, 0xc

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 79
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    const-string v1, "com.wishabi.flipp.models.User"

    const-string v2, "user_coupon_data"

    const/16 v3, 0xd

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 88
    new-array v0, v7, [Lcom/wishabi/flipp/content/bk;

    const/4 v1, 0x0

    new-instance v2, Lcom/wishabi/flipp/content/bc;

    invoke-direct {v2}, Lcom/wishabi/flipp/content/bc;-><init>()V

    aput-object v2, v0, v1

    new-instance v1, Lcom/wishabi/flipp/content/bd;

    invoke-direct {v1}, Lcom/wishabi/flipp/content/bd;-><init>()V

    aput-object v1, v0, v4

    new-instance v1, Lcom/wishabi/flipp/content/be;

    invoke-direct {v1}, Lcom/wishabi/flipp/content/be;-><init>()V

    aput-object v1, v0, v5

    new-instance v1, Lcom/wishabi/flipp/content/bf;

    invoke-direct {v1}, Lcom/wishabi/flipp/content/bf;-><init>()V

    aput-object v1, v0, v6

    sput-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->f:[Lcom/wishabi/flipp/content/bk;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    .line 831
    return-void
.end method

.method private a(Ljava/lang/String;[Ljava/lang/String;)I
    .locals 10

    .prologue
    const/4 v0, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    .line 371
    .line 373
    const-string v1, "user_coupon_data."

    invoke-virtual {p1, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 376
    :goto_0
    const-string v1, "flyerdb.coupons"

    .line 378
    if-eqz v0, :cond_0

    .line 379
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " LEFT JOIN user_coupon_data ON flyerdb.coupons._id = user_coupon_data._id"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 386
    :cond_0
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 387
    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 393
    :try_start_0
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "flyerdb.coupons._id AS coupon_id"

    aput-object v4, v2, v3

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v3, p1

    move-object v4, p2

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 395
    :try_start_1
    const-string v0, "coupon_id"

    invoke-static {v1, v0}, Lcom/wishabi/flipp/util/f;->b(Landroid/database/Cursor;Ljava/lang/String;)[Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    .line 398
    if-eqz v1, :cond_1

    .line 399
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 402
    :cond_1
    array-length v1, v0

    if-nez v1, :cond_3

    .line 411
    :goto_1
    return v8

    .line 398
    :catchall_0
    move-exception v0

    move-object v1, v9

    :goto_2
    if-eqz v1, :cond_2

    .line 399
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0

    .line 405
    :cond_3
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "flyerdb.coupons"

    const-string v3, "_id"

    invoke-static {v3, v0}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v8

    .line 408
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "user_coupon_data"

    const-string v3, "_id"

    invoke-static {v3, v0}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_1

    .line 398
    :catchall_1
    move-exception v0

    goto :goto_2

    :cond_4
    move v0, v8

    goto :goto_0
.end method

.method private a([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 10

    .prologue
    const/4 v5, 0x0

    const/4 v7, 0x1

    const/4 v3, 0x0

    .line 326
    .line 328
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 329
    if-eqz p1, :cond_0

    array-length v1, p1

    new-array v2, v1, [Ljava/lang/String;

    .line 332
    :goto_0
    if-eqz p1, :cond_5

    move v1, v3

    move v4, v3

    move v6, v3

    .line 333
    :goto_1
    array-length v8, p1

    if-ge v1, v8, :cond_6

    .line 334
    aget-object v8, p1, v1

    .line 335
    const-string v9, "category"

    invoke-virtual {v8, v9}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 336
    const-string v6, "category"

    const-string v9, "cat.name AS category"

    invoke-virtual {v8, v6, v9}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v6

    new-array v8, v3, [Ljava/lang/Object;

    invoke-static {v6, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v2, v1

    move v6, v7

    .line 333
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_0
    move-object v2, v5

    .line 329
    goto :goto_0

    .line 338
    :cond_1
    const-string v9, "user_coupon_data."

    invoke-virtual {v8, v9}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 339
    aput-object v8, v2, v1

    move v4, v7

    .line 340
    goto :goto_2

    .line 341
    :cond_2
    const-string v9, "clipped"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_3

    const-string v9, "sent"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 342
    :cond_3
    const-string v4, "IFNULL(user_coupon_data.%s, 0) AS %s"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    aput-object v8, v9, v3

    aput-object v8, v9, v7

    invoke-static {v4, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v1

    move v4, v7

    .line 343
    goto :goto_2

    .line 345
    :cond_4
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "c."

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v9, p1, v1

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v2, v1

    goto :goto_2

    :cond_5
    move v4, v3

    move v6, v3

    .line 350
    :cond_6
    const-string v1, "flyerdb.coupons c"

    .line 352
    if-nez v4, :cond_7

    if-eqz p2, :cond_8

    const-string v4, "user_coupon_data."

    invoke-virtual {p2, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_8

    :cond_7
    move v3, v7

    .line 355
    :cond_8
    if-eqz v6, :cond_9

    .line 356
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, " LEFT JOIN flyerdb.coupon_categories cat ON c._id = cat.coupon_id"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 358
    :cond_9
    if-eqz v3, :cond_a

    .line 359
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " LEFT JOIN user_coupon_data ON c._id = user_coupon_data._id"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 361
    :cond_a
    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 363
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    move-object v3, p2

    move-object v4, p3

    move-object v6, v5

    move-object v7, p4

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a()[Lcom/wishabi/flipp/content/bk;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->f:[Lcom/wishabi/flipp/content/bk;

    return-object v0
.end method

.method private b([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 14

    .prologue
    .line 417
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 418
    const-string v4, "flyerdb.flyer_item_coupons"

    .line 420
    const/4 v5, 0x0

    .line 421
    const/4 v3, 0x0

    .line 422
    const/4 v2, 0x0

    .line 423
    const/4 v1, 0x0

    .line 425
    array-length v8, p1

    const/4 v0, 0x0

    move v6, v0

    move v0, v1

    move v1, v2

    move v2, v3

    move v3, v5

    :goto_0
    if-ge v6, v8, :cond_7

    aget-object v9, p1, v6

    .line 426
    const-string v5, "flyerdb.coupons."

    invoke-virtual {v9, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 427
    const/4 v3, 0x1

    .line 436
    :cond_0
    :goto_1
    const-string v5, "flyerdb.coupons.*"

    invoke-virtual {v9, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 437
    sget-object v10, Lcom/wishabi/flipp/content/UserContentProvider;->c:[Ljava/lang/String;

    array-length v11, v10

    const/4 v5, 0x0

    :goto_2
    if-ge v5, v11, :cond_6

    aget-object v12, v10, v5

    .line 438
    const-string v13, "*"

    invoke-virtual {v9, v13, v12}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v12

    const/4 v13, 0x0

    new-array v13, v13, [Ljava/lang/Object;

    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v7, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 437
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 428
    :cond_1
    const-string v5, "flyerdb.flyers"

    invoke-virtual {v9, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 429
    const/4 v2, 0x1

    goto :goto_1

    .line 430
    :cond_2
    const-string v5, "user_coupon_data."

    invoke-virtual {v9, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 431
    const/4 v1, 0x1

    goto :goto_1

    .line 432
    :cond_3
    const-string v5, "clipped_items."

    invoke-virtual {v9, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 433
    const/4 v0, 0x1

    goto :goto_1

    .line 440
    :cond_4
    const-string v5, "user_coupon_data.*"

    invoke-virtual {v9, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 441
    sget-object v10, Lcom/wishabi/flipp/content/UserContentProvider;->d:[Ljava/lang/String;

    array-length v11, v10

    const/4 v5, 0x0

    :goto_3
    if-ge v5, v11, :cond_6

    aget-object v12, v10, v5

    .line 442
    const-string v13, "*"

    invoke-virtual {v9, v13, v12}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v12

    const/4 v13, 0x0

    new-array v13, v13, [Ljava/lang/Object;

    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v7, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 441
    add-int/lit8 v5, v5, 0x1

    goto :goto_3

    .line 444
    :cond_5
    invoke-virtual {v7, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 425
    :cond_6
    add-int/lit8 v5, v6, 0x1

    move v6, v5

    goto :goto_0

    .line 448
    :cond_7
    if-eqz v3, :cond_b

    .line 449
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " INNER JOIN flyerdb.coupons ON flyerdb.flyer_item_coupons.coupon_id = flyerdb.coupons._id"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 452
    :goto_4
    if-eqz v2, :cond_a

    .line 453
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " INNER JOIN flyerdb.flyers ON flyerdb.flyer_item_coupons.flyer_id = flyerdb.flyers._id"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 456
    :goto_5
    if-eqz v1, :cond_9

    .line 457
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " LEFT JOIN user_coupon_data ON flyerdb.flyer_item_coupons.coupon_id = user_coupon_data._id"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 460
    :goto_6
    if-eqz v0, :cond_8

    .line 461
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " LEFT JOIN clipped_items ON flyerdb.flyer_item_coupons.flyer_item_id = clipped_items._id"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 464
    :cond_8
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 465
    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 467
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v2

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v7, v2}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v7, p4

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0

    :cond_9
    move-object v1, v2

    goto :goto_6

    :cond_a
    move-object v2, v3

    goto :goto_5

    :cond_b
    move-object v3, v4

    goto :goto_4
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
    .line 805
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 806
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 807
    new-array v3, v2, [Landroid/content/ContentProviderResult;

    .line 808
    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    .line 812
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_0

    .line 813
    :try_start_0
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentProviderOperation;

    .line 814
    invoke-virtual {v0}, Landroid/content/ContentProviderOperation;->getUri()Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 815
    invoke-virtual {v0, p0, v3, v1}, Landroid/content/ContentProviderOperation;->apply(Landroid/content/ContentProvider;[Landroid/content/ContentProviderResult;I)Landroid/content/ContentProviderResult;

    move-result-object v0

    aput-object v0, v3, v1

    .line 812
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 817
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 822
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 823
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/UserContentProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 824
    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    .line 826
    const/4 v4, 0x0

    invoke-virtual {v1, v0, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_1

    .line 822
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 823
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/UserContentProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    .line 828
    throw v0

    :cond_1
    return-object v3
.end method

.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 3

    .prologue
    .line 691
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/UserContentProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 692
    if-nez v1, :cond_1

    .line 693
    const/4 v0, 0x0

    .line 741
    :cond_0
    :goto_0
    return v0

    .line 696
    :cond_1
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    .line 697
    packed-switch v0, :pswitch_data_0

    .line 735
    :pswitch_0
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

    .line 699
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "favorite_merchants"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 738
    :goto_1
    if-lez v0, :cond_0

    iget-object v2, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v2

    if-nez v2, :cond_0

    .line 739
    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_0

    .line 702
    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "clipped_items"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 705
    :pswitch_3
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "read_flyers"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 708
    :pswitch_4
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "sent_analytics"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 711
    :pswitch_5
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "shopping_lists"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 714
    :pswitch_6
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "shopping_list_items"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 717
    :pswitch_7
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "shopping_list_categories"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 721
    :pswitch_8
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "shopping_list_cat_order"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 725
    :pswitch_9
    invoke-direct {p0, p2, p3}, Lcom/wishabi/flipp/content/UserContentProvider;->a(Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 729
    :pswitch_a
    new-instance v0, Ljava/lang/IllegalAccessError;

    const-string v1, "Delete on associations_query URI is not supported"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v0

    .line 732
    :pswitch_b
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "user_coupon_data"

    invoke-virtual {v0, v2, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 697
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_0
        :pswitch_a
        :pswitch_b
    .end packed-switch
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 529
    const-string v0, "vnd.android.cursor.dir/vnd.flipp.flyer"

    return-object v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 8

    .prologue
    const-wide/16 v6, -0x1

    const/4 v4, 0x5

    const/4 v0, 0x0

    .line 534
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/UserContentProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 535
    if-nez v2, :cond_1

    .line 686
    :cond_0
    :goto_0
    return-object v0

    .line 538
    :cond_1
    sget-object v1, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v1

    .line 539
    packed-switch v1, :pswitch_data_0

    .line 683
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

    .line 541
    :pswitch_1
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "favorite_merchants"

    invoke-virtual {v1, v3, v0, p2, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 544
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v6

    if-eqz v3, :cond_0

    .line 545
    sget-object v3, Lcom/wishabi/flipp/content/i;->f:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 550
    iget-object v3, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v3

    if-nez v3, :cond_2

    .line 551
    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    :cond_2
    move-object v0, v1

    .line 553
    goto :goto_0

    .line 556
    :pswitch_2
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "clipped_items"

    invoke-virtual {v1, v3, v0, p2, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 559
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v6

    if-eqz v3, :cond_0

    .line 560
    sget-object v3, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 565
    iget-object v3, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v3

    if-nez v3, :cond_3

    .line 566
    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    :cond_3
    move-object v0, v1

    .line 568
    goto :goto_0

    .line 571
    :pswitch_3
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "read_flyers"

    invoke-virtual {v1, v3, v0, p2, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 574
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v6

    if-eqz v3, :cond_0

    .line 575
    sget-object v3, Lcom/wishabi/flipp/content/i;->h:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 580
    iget-object v3, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v3

    if-nez v3, :cond_4

    .line 581
    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    :cond_4
    move-object v0, v1

    .line 583
    goto/16 :goto_0

    .line 586
    :pswitch_4
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "sent_analytics"

    invoke-virtual {v1, v3, v0, p2, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 589
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v6

    if-eqz v3, :cond_0

    .line 590
    sget-object v3, Lcom/wishabi/flipp/content/i;->i:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 595
    iget-object v3, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v3

    if-nez v3, :cond_5

    .line 596
    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    :cond_5
    move-object v0, v1

    .line 598
    goto/16 :goto_0

    .line 601
    :pswitch_5
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "shopping_lists"

    invoke-virtual {v1, v3, v0, p2, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 604
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v6

    if-eqz v3, :cond_0

    .line 605
    sget-object v3, Lcom/wishabi/flipp/content/i;->j:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 610
    iget-object v3, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v3

    if-nez v3, :cond_6

    .line 611
    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    :cond_6
    move-object v0, v1

    .line 613
    goto/16 :goto_0

    .line 616
    :pswitch_6
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "shopping_list_items"

    invoke-virtual {v1, v3, v0, p2, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 619
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v6

    if-eqz v3, :cond_0

    .line 620
    sget-object v3, Lcom/wishabi/flipp/content/i;->k:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 625
    iget-object v3, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v3

    if-nez v3, :cond_7

    .line 626
    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    :cond_7
    move-object v0, v1

    .line 628
    goto/16 :goto_0

    .line 631
    :pswitch_7
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "shopping_list_categories"

    invoke-virtual {v1, v3, v0, p2, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 634
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v6

    if-eqz v3, :cond_0

    .line 635
    sget-object v3, Lcom/wishabi/flipp/content/i;->l:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 640
    iget-object v3, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v3

    if-nez v3, :cond_8

    .line 641
    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    :cond_8
    move-object v0, v1

    .line 643
    goto/16 :goto_0

    .line 646
    :pswitch_8
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "shopping_list_cat_order"

    invoke-virtual {v1, v3, v0, p2, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 649
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v6

    if-eqz v3, :cond_0

    .line 650
    sget-object v3, Lcom/wishabi/flipp/content/i;->m:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 655
    iget-object v3, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v3

    if-nez v3, :cond_9

    .line 656
    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    :cond_9
    move-object v0, v1

    .line 658
    goto/16 :goto_0

    .line 661
    :pswitch_9
    new-instance v0, Ljava/lang/IllegalAccessError;

    const-string v1, "Insert on the coupons_query URI is not supported"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v0

    .line 665
    :pswitch_a
    new-instance v0, Ljava/lang/IllegalAccessError;

    const-string v1, "Insert on associations_query URI is not supported"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v0

    .line 668
    :pswitch_b
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "user_coupon_data"

    invoke-virtual {v1, v3, v0, p2, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 671
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v3, v4, v6

    if-eqz v3, :cond_0

    .line 672
    sget-object v3, Lcom/wishabi/flipp/content/i;->t:Landroid/net/Uri;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 677
    iget-object v3, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v3

    if-nez v3, :cond_a

    .line 678
    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    :cond_a
    move-object v0, v1

    .line 680
    goto/16 :goto_0

    .line 539
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_0
        :pswitch_a
        :pswitch_b
    .end packed-switch
.end method

.method public onCreate()Z
    .locals 9

    .prologue
    const/4 v2, 0x0

    const/4 v8, 0x1

    .line 195
    new-instance v0, Lcom/wishabi/flipp/content/bj;

    invoke-virtual {p0}, Lcom/wishabi/flipp/content/UserContentProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/content/bj;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/bj;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    .line 196
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/UserContentProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "flyers.db"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 199
    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "attach database ? as flyerdb"

    new-array v4, v8, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v1, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 200
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "coupons"

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 201
    invoke-interface {v0}, Landroid/database/Cursor;->getColumnNames()[Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/wishabi/flipp/content/UserContentProvider;->c:[Ljava/lang/String;

    .line 202
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 204
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "user_coupon_data"

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 206
    invoke-interface {v0}, Landroid/database/Cursor;->getColumnNames()[Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/wishabi/flipp/content/UserContentProvider;->d:[Ljava/lang/String;

    .line 207
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 209
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->b:Landroid/os/Handler;

    .line 210
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/UserContentProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v1, Lcom/wishabi/flipp/content/bg;

    iget-object v2, p0, Lcom/wishabi/flipp/content/UserContentProvider;->b:Landroid/os/Handler;

    invoke-direct {v1, p0, v2}, Lcom/wishabi/flipp/content/bg;-><init>(Lcom/wishabi/flipp/content/UserContentProvider;Landroid/os/Handler;)V

    sget-object v2, Lcom/wishabi/flipp/content/i;->n:Landroid/net/Uri;

    invoke-virtual {v0, v2, v8, v1}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    sget-object v2, Lcom/wishabi/flipp/content/i;->t:Landroid/net/Uri;

    invoke-virtual {v0, v2, v8, v1}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    sget-object v2, Lcom/wishabi/flipp/content/i;->p:Landroid/net/Uri;

    invoke-virtual {v0, v2, v8, v1}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    sget-object v2, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    invoke-virtual {v0, v2, v8, v1}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    sget-object v2, Lcom/wishabi/flipp/content/i;->o:Landroid/net/Uri;

    invoke-virtual {v0, v2, v8, v1}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    new-instance v1, Lcom/wishabi/flipp/content/bh;

    iget-object v2, p0, Lcom/wishabi/flipp/content/UserContentProvider;->b:Landroid/os/Handler;

    invoke-direct {v1, p0, v2}, Lcom/wishabi/flipp/content/bh;-><init>(Lcom/wishabi/flipp/content/UserContentProvider;Landroid/os/Handler;)V

    sget-object v2, Lcom/wishabi/flipp/content/i;->n:Landroid/net/Uri;

    invoke-virtual {v0, v2, v8, v1}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    sget-object v2, Lcom/wishabi/flipp/content/i;->p:Landroid/net/Uri;

    invoke-virtual {v0, v2, v8, v1}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    sget-object v2, Lcom/wishabi/flipp/content/i;->t:Landroid/net/Uri;

    invoke-virtual {v0, v2, v8, v1}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    new-instance v1, Lcom/wishabi/flipp/content/bi;

    iget-object v2, p0, Lcom/wishabi/flipp/content/UserContentProvider;->b:Landroid/os/Handler;

    invoke-direct {v1, p0, v2}, Lcom/wishabi/flipp/content/bi;-><init>(Lcom/wishabi/flipp/content/UserContentProvider;Landroid/os/Handler;)V

    sget-object v2, Lcom/wishabi/flipp/content/i;->p:Landroid/net/Uri;

    invoke-virtual {v0, v2, v8, v1}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    sget-object v2, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    invoke-virtual {v0, v2, v8, v1}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    .line 211
    :cond_0
    return v8
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 9

    .prologue
    .line 217
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/UserContentProvider;->getContext()Landroid/content/Context;

    move-result-object v8

    .line 218
    if-nez v8, :cond_0

    .line 219
    const/4 v0, 0x0

    .line 276
    :goto_0
    return-object v0

    .line 222
    :cond_0
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    .line 223
    packed-switch v0, :pswitch_data_0

    .line 272
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

    .line 225
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "favorite_merchants"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 275
    :goto_1
    invoke-virtual {v8}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto :goto_0

    .line 229
    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "clipped_items"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_1

    .line 233
    :pswitch_3
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "read_flyers"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_1

    .line 237
    :pswitch_4
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "sent_analytics"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_1

    .line 241
    :pswitch_5
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "shopping_lists"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_1

    .line 245
    :pswitch_6
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    const/4 v4, 0x0

    const/4 v3, 0x0

    array-length v1, p2

    new-array v2, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    :goto_2
    array-length v5, p2

    if-ge v1, v5, :cond_3

    aget-object v5, p2, v1

    const-string v6, "category"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    const-string v4, "IFNULL(c.category, \'Other\') AS category"

    aput-object v4, v2, v1

    const/4 v4, 0x1

    :goto_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_1
    aget-object v5, p2, v1

    const-string v6, "cat_position"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const-string v3, "IFNULL(co.position, %d) AS cat_position"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const/16 v7, 0x3e8

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v1

    const/4 v3, 0x1

    goto :goto_3

    :cond_2
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "i."

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v6, p2, v1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v1

    goto :goto_3

    :cond_3
    const-string v1, "shopping_list_items i"

    if-nez v4, :cond_4

    if-eqz v3, :cond_5

    :cond_4
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, " LEFT JOIN shopping_list_categories c ON LOWER(i.name) = c.item_name"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :cond_5
    if-eqz v3, :cond_6

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " LEFT JOIN shopping_list_cat_order co ON c.category = co.category"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :cond_6
    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v3, p3

    move-object v4, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_1

    .line 249
    :pswitch_7
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "shopping_list_categories"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_1

    .line 253
    :pswitch_8
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "shopping_list_cat_order"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_1

    .line 257
    :pswitch_9
    invoke-direct {p0, p2, p3, p4, p5}, Lcom/wishabi/flipp/content/UserContentProvider;->a([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_1

    .line 264
    :pswitch_a
    invoke-direct {p0, p2, p3, p4, p5}, Lcom/wishabi/flipp/content/UserContentProvider;->b([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_1

    .line 268
    :pswitch_b
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "user_coupon_data"

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto/16 :goto_1

    .line 223
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_0
        :pswitch_a
        :pswitch_b
    .end packed-switch
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 3

    .prologue
    .line 747
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/UserContentProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 748
    if-nez v1, :cond_1

    .line 749
    const/4 v0, 0x0

    .line 798
    :cond_0
    :goto_0
    return v0

    .line 752
    :cond_1
    sget-object v0, Lcom/wishabi/flipp/content/UserContentProvider;->e:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 792
    :pswitch_0
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

    .line 754
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "favorite_merchants"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 795
    :goto_1
    if-lez v0, :cond_0

    iget-object v2, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v2

    if-nez v2, :cond_0

    .line 796
    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_0

    .line 758
    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "clipped_items"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 761
    :pswitch_3
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "read_flyers"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 764
    :pswitch_4
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "sent_analytics"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 767
    :pswitch_5
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "shopping_lists"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 770
    :pswitch_6
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "shopping_list_items"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 774
    :pswitch_7
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "shopping_list_categories"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 778
    :pswitch_8
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "shopping_list_cat_order"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 782
    :pswitch_9
    new-instance v0, Ljava/lang/IllegalAccessError;

    const-string v1, "Insert on the coupons_query URI is not supported"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v0

    .line 786
    :pswitch_a
    new-instance v0, Ljava/lang/IllegalAccessError;

    const-string v1, "Insert on associations_query URI is not supported"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v0

    .line 789
    :pswitch_b
    iget-object v0, p0, Lcom/wishabi/flipp/content/UserContentProvider;->a:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "user_coupon_data"

    invoke-virtual {v0, v2, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 752
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_0
        :pswitch_a
        :pswitch_b
    .end packed-switch
.end method
