.class public Lcom/wishabi/flipp/content/a;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final a:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    const-class v0, Lcom/wishabi/flipp/content/a;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/a;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 570
    return-void
.end method

.method public static a(Lcom/wishabi/flipp/content/c;ZLcom/wishabi/flipp/b/p;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 679
    if-nez p0, :cond_0

    .line 684
    :goto_0
    return v0

    .line 682
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    const/4 v2, 0x1

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 683
    invoke-virtual {v1, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 684
    invoke-static {v1, p1, p2, v0}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;ZLcom/wishabi/flipp/b/p;Z)Z

    move-result v0

    goto :goto_0
.end method

.method public static a(Ljava/util/ArrayList;ZLcom/wishabi/flipp/b/p;Z)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;Z",
            "Lcom/wishabi/flipp/b/p;",
            "Z)Z"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 691
    if-nez p0, :cond_0

    .line 706
    :goto_0
    return v2

    .line 694
    :cond_0
    if-eqz p1, :cond_3

    .line 695
    if-eqz p3, :cond_2

    sget-object v0, Lcom/wishabi/flipp/b/q;->d:Lcom/wishabi/flipp/b/q;

    move-object v1, v0

    .line 698
    :goto_1
    invoke-virtual {p0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/c;

    .line 700
    iget-boolean v4, v0, Lcom/wishabi/flipp/content/c;->q:Z

    if-nez v4, :cond_1

    .line 701
    sget-object v4, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    invoke-virtual {v4, v0, v1, p2}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/c;Lcom/wishabi/flipp/b/q;Lcom/wishabi/flipp/b/p;)V

    goto :goto_2

    .line 695
    :cond_2
    sget-object v0, Lcom/wishabi/flipp/b/q;->c:Lcom/wishabi/flipp/b/q;

    move-object v1, v0

    goto :goto_1

    .line 705
    :cond_3
    invoke-static {p0}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;)[I

    move-result-object v1

    .line 706
    const-string v3, "clipped"

    if-eqz p1, :cond_4

    const/4 v0, 0x1

    :goto_3
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v1, v3, v0}, Lcom/wishabi/flipp/content/a;->a([ILjava/lang/String;Ljava/lang/Object;)Z

    move-result v2

    goto :goto_0

    :cond_4
    move v0, v2

    goto :goto_3
.end method

.method public static a([I)Z
    .locals 2

    .prologue
    .line 672
    const-string v0, "sent"

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {p0, v0, v1}, Lcom/wishabi/flipp/content/a;->a([ILjava/lang/String;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private static a([ILjava/lang/String;Ljava/lang/Object;)Z
    .locals 11

    .prologue
    const/4 v7, 0x1

    const/4 v3, 0x0

    const/4 v6, 0x0

    .line 623
    if-eqz p0, :cond_0

    array-length v0, p0

    if-nez v0, :cond_1

    :cond_0
    move v0, v6

    .line 664
    :goto_0
    return v0

    .line 626
    :cond_1
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    if-nez p2, :cond_3

    :cond_2
    move v0, v6

    .line 627
    goto :goto_0

    .line 630
    :cond_3
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_4

    .line 631
    :goto_1
    if-nez v3, :cond_7

    move v0, v6

    .line 632
    goto :goto_0

    .line 630
    :cond_4
    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->t:Landroid/net/Uri;

    new-array v2, v7, [Ljava/lang/String;

    const-string v4, "_id"

    aput-object v4, v2, v6

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    if-nez v2, :cond_5

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    :goto_2
    move-object v3, v0

    goto :goto_1

    :cond_5
    const-string v0, "_id"

    invoke-interface {v2, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    new-instance v0, Ljava/util/HashSet;

    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    :goto_3
    if-eqz v1, :cond_6

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    goto :goto_3

    :cond_6
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_2

    .line 634
    :cond_7
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v0

    .line 635
    if-nez v0, :cond_8

    move v0, v6

    .line 636
    goto :goto_0

    .line 638
    :cond_8
    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 641
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 642
    array-length v4, p0

    move v0, v6

    :goto_4
    if-ge v0, v4, :cond_a

    aget v5, p0, v0

    .line 644
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v3, v8}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_9

    .line 645
    sget-object v8, Lcom/wishabi/flipp/content/i;->t:Landroid/net/Uri;

    invoke-static {v8}, Landroid/content/ContentProviderOperation;->newUpdate(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;

    move-result-object v8

    const-string v9, "_id = ?"

    new-array v10, v7, [Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v10, v6

    invoke-virtual {v8, v9, v10}, Landroid/content/ContentProviderOperation$Builder;->withSelection(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;

    move-result-object v5

    invoke-virtual {v5, p1, p2}, Landroid/content/ContentProviderOperation$Builder;->withValue(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/ContentProviderOperation$Builder;->build()Landroid/content/ContentProviderOperation;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 642
    :goto_5
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 651
    :cond_9
    sget-object v8, Lcom/wishabi/flipp/content/i;->t:Landroid/net/Uri;

    invoke-static {v8}, Landroid/content/ContentProviderOperation;->newInsert(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;

    move-result-object v8

    const-string v9, "_id"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v8, v9, v5}, Landroid/content/ContentProviderOperation$Builder;->withValue(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;

    move-result-object v5

    invoke-virtual {v5, p1, p2}, Landroid/content/ContentProviderOperation$Builder;->withValue(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/ContentProviderOperation$Builder;->build()Landroid/content/ContentProviderOperation;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_5

    .line 658
    :cond_a
    :try_start_0
    const-string v0, "com.wishabi.flipp.models.User"

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentResolver;->applyBatch(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/content/OperationApplicationException; {:try_start_0 .. :try_end_0} :catch_1

    move v0, v7

    .line 659
    goto/16 :goto_0

    .line 660
    :catch_0
    move-exception v0

    :goto_6
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    move v0, v6

    .line 664
    goto/16 :goto_0

    .line 660
    :catch_1
    move-exception v0

    goto :goto_6
.end method

.method public static a(Ljava/util/ArrayList;)[I
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;)[I"
        }
    .end annotation

    .prologue
    .line 746
    if-nez p0, :cond_0

    .line 747
    const/4 v0, 0x0

    .line 754
    :goto_0
    return-object v0

    .line 749
    :cond_0
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v1, v0, [I

    .line 750
    const/4 v0, 0x0

    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v3

    move v2, v0

    :goto_1
    if-ge v2, v3, :cond_1

    .line 751
    invoke-virtual {p0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/c;

    .line 752
    iget v0, v0, Lcom/wishabi/flipp/content/c;->a:I

    aput v0, v1, v2

    .line 750
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    :cond_1
    move-object v0, v1

    .line 754
    goto :goto_0
.end method
