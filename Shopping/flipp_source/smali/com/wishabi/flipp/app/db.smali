.class final Lcom/wishabi/flipp/app/db;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/cx;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cx;)V
    .locals 0

    .prologue
    .line 490
    iput-object p1, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 14

    .prologue
    const/4 v8, 0x1

    const/4 v6, 0x0

    const/4 v9, 0x0

    .line 493
    iget-object v0, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/cx;->getActivity()Landroid/app/Activity;

    move-result-object v10

    .line 494
    if-nez v10, :cond_1

    .line 584
    :cond_0
    :goto_0
    return-void

    .line 499
    :cond_1
    :try_start_0
    invoke-virtual {v10}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v7, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v7}, Lcom/wishabi/flipp/app/cx;->c(Lcom/wishabi/flipp/app/cx;)J

    move-result-wide v12

    invoke-static {v12, v13}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_3

    move-result-object v7

    .line 504
    if-eqz v7, :cond_3

    :try_start_1
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 505
    invoke-virtual {v10}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    const-string v2, "_id = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v5}, Lcom/wishabi/flipp/app/cx;->c(Lcom/wishabi/flipp/app/cx;)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 581
    :cond_2
    :goto_1
    if-eqz v7, :cond_0

    .line 582
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 510
    :cond_3
    :try_start_2
    new-instance v11, Landroid/content/ContentValues;

    invoke-direct {v11}, Landroid/content/ContentValues;-><init>()V

    .line 511
    const-string v0, "_id"

    iget-object v1, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v1}, Lcom/wishabi/flipp/app/cx;->c(Lcom/wishabi/flipp/app/cx;)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 512
    const-string v0, "flyer_id"

    iget-object v1, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v1}, Lcom/wishabi/flipp/app/cx;->b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;

    move-result-object v1

    iget v1, v1, Lcom/wishabi/flipp/content/af;->c:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 516
    :try_start_3
    invoke-virtual {v10}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->c:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v12, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v12}, Lcom/wishabi/flipp/app/cx;->c(Lcom/wishabi/flipp/app/cx;)J

    move-result-wide v12

    invoke-static {v12, v13}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_4

    move-result-object v1

    .line 520
    if-eqz v1, :cond_7

    :try_start_4
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 521
    const-string v0, "left"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 523
    const-string v2, "top"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    .line 525
    const-string v3, "right"

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    .line 527
    const-string v4, "bottom"

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    .line 529
    const-string v5, "bottom"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v11, v5, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 530
    const-string v4, "top"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v4, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 531
    const-string v2, "left"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v11, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 532
    const-string v0, "right"

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 540
    :goto_2
    if-eqz v1, :cond_4

    .line 541
    :try_start_5
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 546
    :cond_4
    :try_start_6
    invoke-virtual {v10}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v12, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v12}, Lcom/wishabi/flipp/app/cx;->b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;

    move-result-object v12

    iget v12, v12, Lcom/wishabi/flipp/content/af;->c:I

    invoke-static {v12}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 552
    if-eqz v6, :cond_a

    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 553
    const-string v1, "premium"

    const-string v0, "premium"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v8, :cond_9

    move v0, v8

    :goto_3
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v11, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 558
    :goto_4
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    new-instance v1, Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-direct {v1, v6}, Lcom/wishabi/flipp/content/Flyer$Model;-><init>(Landroid/database/Cursor;)V

    iget-object v2, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v2}, Lcom/wishabi/flipp/app/cx;->c(Lcom/wishabi/flipp/app/cx;)J

    move-result-wide v2

    sget-object v4, Lcom/wishabi/flipp/b/o;->e:Lcom/wishabi/flipp/b/o;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 562
    if-eqz v6, :cond_5

    .line 563
    :try_start_7
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 566
    :cond_5
    const-string v0, "merchant"

    iget-object v1, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v1}, Lcom/wishabi/flipp/app/cx;->b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;

    move-result-object v1

    iget-object v1, v1, Lcom/wishabi/flipp/content/af;->d:Ljava/lang/String;

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 567
    const-string v0, "merchant_logo"

    iget-object v1, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v1}, Lcom/wishabi/flipp/app/cx;->b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;

    move-result-object v1

    iget-object v1, v1, Lcom/wishabi/flipp/content/af;->e:Ljava/lang/String;

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 568
    const-string v0, "name"

    iget-object v1, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v1}, Lcom/wishabi/flipp/app/cx;->b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;

    move-result-object v1

    iget-object v1, v1, Lcom/wishabi/flipp/content/af;->f:Ljava/lang/String;

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 569
    const-string v0, "price"

    iget-object v1, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v1}, Lcom/wishabi/flipp/app/cx;->b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;

    move-result-object v1

    iget-object v1, v1, Lcom/wishabi/flipp/content/af;->j:Ljava/lang/String;

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 570
    const-string v0, "thumbnail"

    iget-object v1, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v1}, Lcom/wishabi/flipp/app/cx;->b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;

    move-result-object v1

    iget-object v1, v1, Lcom/wishabi/flipp/content/af;->h:Ljava/lang/String;

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 571
    const-string v0, "valid_to"

    iget-object v1, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v1}, Lcom/wishabi/flipp/app/cx;->b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;

    move-result-object v1

    iget-object v1, v1, Lcom/wishabi/flipp/content/af;->p:Ljava/lang/String;

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 572
    invoke-virtual {v10}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    invoke-virtual {v0, v1, v11}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 576
    iget-object v0, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cx;->d(Lcom/wishabi/flipp/app/cx;)Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cx;->d(Lcom/wishabi/flipp/app/cx;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 577
    iget-object v0, p0, Lcom/wishabi/flipp/app/db;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cx;->d(Lcom/wishabi/flipp/app/cx;)Ljava/util/ArrayList;

    move-result-object v0

    const/4 v1, 0x1

    sget-object v2, Lcom/wishabi/flipp/b/p;->b:Lcom/wishabi/flipp/b/p;

    const/4 v3, 0x1

    invoke-static {v0, v1, v2, v3}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;ZLcom/wishabi/flipp/b/p;Z)Z
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_1

    .line 581
    :catchall_0
    move-exception v0

    move-object v6, v7

    :goto_5
    if-eqz v6, :cond_6

    .line 582
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_6
    throw v0

    .line 534
    :cond_7
    :try_start_8
    const-string v0, "bottom"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 535
    const-string v0, "top"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 536
    const-string v0, "left"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 537
    const-string v0, "right"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v11, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    goto/16 :goto_2

    .line 540
    :catchall_1
    move-exception v0

    :goto_6
    if-eqz v1, :cond_8

    .line 541
    :try_start_9
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_8
    throw v0
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    :cond_9
    move v0, v9

    .line 553
    goto/16 :goto_3

    .line 556
    :cond_a
    :try_start_a
    const-string v0, "premium"

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v11, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_2

    goto/16 :goto_4

    .line 562
    :catchall_2
    move-exception v0

    if-eqz v6, :cond_b

    .line 563
    :try_start_b
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_b
    throw v0
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    .line 581
    :catchall_3
    move-exception v0

    goto :goto_5

    .line 540
    :catchall_4
    move-exception v0

    move-object v1, v6

    goto :goto_6
.end method
