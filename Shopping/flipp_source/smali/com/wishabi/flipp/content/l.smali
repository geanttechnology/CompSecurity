.class public final Lcom/wishabi/flipp/content/l;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Z)Landroid/content/Loader;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            "Z)",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 54
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " AND coupons_deleted = 0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 56
    if-eqz p3, :cond_0

    .line 57
    sget-object v0, Lcom/wishabi/flipp/content/ag;->v:[I

    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->a([I)[Ljava/lang/String;

    move-result-object v0

    .line 60
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " AND "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "display_type"

    invoke-static {v2, v0}, Lcom/wishabi/flipp/util/f;->b(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 62
    invoke-static {p2, v0}, Lcom/wishabi/flipp/util/a;->a([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 65
    :goto_0
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->r:Landroid/net/Uri;

    const/4 v1, 0x4

    new-array v3, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v6, "flyerdb.flyer_item_coupons._id AS _id"

    aput-object v6, v3, v1

    const/4 v1, 0x1

    const-string v6, "flyerdb.flyer_item_coupons.flyer_item_id AS flyer_item_id"

    aput-object v6, v3, v1

    const/4 v1, 0x2

    const-string v6, "flyerdb.coupons.* AS coupons_*"

    aput-object v6, v3, v1

    const/4 v1, 0x3

    const-string v6, "user_coupon_data.* AS user_coupon_data_*"

    aput-object v6, v3, v1

    const-string v6, "flyer_item_id ASC, coupons_priority ASC, coupons_available_from DESC, coupons__id DESC"

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0

    :cond_0
    move-object v5, p2

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;[IZZ)Landroid/content/Loader;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "[IZZ)",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/16 v5, 0x3b6

    const/4 v6, 0x1

    const/4 v2, 0x0

    .line 86
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    array-length v3, p1

    move v1, v2

    :goto_0
    if-ge v1, v3, :cond_0

    aget v4, p1, v1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 87
    :cond_0
    invoke-static {}, Ljava/util/Collections;->reverseOrder()Ljava/util/Comparator;

    move-result-object v1

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 88
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-le v1, v5, :cond_1

    .line 89
    invoke-interface {v0, v2, v5}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v0

    .line 91
    :cond_1
    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->a(Ljava/util/List;)[Ljava/lang/String;

    move-result-object v5

    .line 93
    const/4 v0, 0x3

    new-array v3, v0, [Ljava/lang/String;

    const-string v0, "flyer_item_coupons.*"

    aput-object v0, v3, v2

    const-string v0, "flyerdb.flyers.merchant as merchant_name"

    aput-object v0, v3, v6

    const/4 v0, 0x2

    const-string v1, "flyerdb.flyers.merchant_id as merchant_id"

    aput-object v1, v3, v0

    .line 99
    if-eqz p2, :cond_2

    .line 100
    new-array v0, v6, [Ljava/lang/String;

    const-string v1, "CASE WHEN clipped_items._id IS NULL THEN 0 ELSE 1 END AS item_clipped"

    aput-object v1, v0, v2

    invoke-static {v3, v0}, Lcom/wishabi/flipp/util/a;->a([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 104
    :cond_2
    const-string v0, "coupon_id"

    invoke-static {v0, v5}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 105
    if-eqz p3, :cond_3

    .line 108
    sget-object v0, Lcom/wishabi/flipp/content/ag;->v:[I

    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->a([I)[Ljava/lang/String;

    move-result-object v1

    .line 111
    if-nez v4, :cond_4

    .line 112
    const-string v0, ""

    .line 116
    :goto_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "display_type"

    invoke-static {v2, v1}, Lcom/wishabi/flipp/util/f;->b(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 117
    invoke-static {v5, v1}, Lcom/wishabi/flipp/util/a;->a([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 120
    :cond_3
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->r:Landroid/net/Uri;

    if-eqz p2, :cond_5

    const-string v6, "coupon_id ASC, item_clipped DESC, item_rank ASC, _id DESC"

    :goto_2
    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0

    .line 114
    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " AND "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 120
    :cond_5
    const-string v6, "coupon_id ASC, item_rank ASC, _id DESC"

    goto :goto_2
.end method

.method public static a(Landroid/content/Context;[J)Landroid/content/Loader;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "[J)",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/16 v6, 0x3b6

    const/4 v2, 0x0

    .line 32
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    array-length v3, p1

    move v1, v2

    :goto_0
    if-ge v1, v3, :cond_0

    aget-wide v4, p1, v1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 33
    :cond_0
    invoke-static {}, Ljava/util/Collections;->reverseOrder()Ljava/util/Comparator;

    move-result-object v1

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 34
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-le v1, v6, :cond_1

    .line 35
    invoke-interface {v0, v2, v6}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v0

    .line 37
    :cond_1
    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->a(Ljava/util/List;)[Ljava/lang/String;

    move-result-object v0

    .line 38
    const-string v1, "flyer_item_id"

    invoke-static {v1, v0}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 39
    const/4 v2, 0x1

    invoke-static {p0, v1, v0, v2}, Lcom/wishabi/flipp/content/l;->a(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Z)Landroid/content/Loader;

    move-result-object v0

    return-object v0
.end method

.method public static a(Landroid/database/Cursor;)Ljava/util/HashMap;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 131
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 133
    if-nez p0, :cond_0

    move-object v0, v1

    .line 155
    :goto_0
    return-object v0

    .line 136
    :cond_0
    const-string v0, "flyer_item_id"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    .line 138
    new-instance v3, Lcom/wishabi/flipp/content/d;

    const-string v0, "coupons_"

    const-string v4, "user_coupon_data_"

    invoke-direct {v3, p0, v0, v4}, Lcom/wishabi/flipp/content/d;-><init>(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    invoke-interface {p0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    :goto_1
    if-eqz v0, :cond_2

    .line 142
    new-instance v4, Lcom/wishabi/flipp/content/c;

    invoke-direct {v4, p0, v3}, Lcom/wishabi/flipp/content/c;-><init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/d;)V

    .line 144
    invoke-interface {p0, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    .line 145
    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 147
    if-nez v0, :cond_1

    .line 148
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 149
    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v1, v5, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 152
    :cond_1
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 141
    invoke-interface {p0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    goto :goto_1

    :cond_2
    move-object v0, v1

    .line 155
    goto :goto_0
.end method

.method public static a(Landroid/database/Cursor;Z)Ljava/util/HashMap;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            "Z)",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 165
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 166
    new-instance v2, Lcom/wishabi/flipp/content/m;

    const-string v0, "merchant_name"

    const-string v3, "merchant_id"

    invoke-direct {v2, p0, v0, v3}, Lcom/wishabi/flipp/content/m;-><init>(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)V

    .line 169
    invoke-interface {p0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    :goto_0
    if-eqz v0, :cond_3

    .line 170
    new-instance v3, Lcom/wishabi/flipp/content/o;

    invoke-direct {v3, p0, v2}, Lcom/wishabi/flipp/content/o;-><init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/m;)V

    .line 171
    iget v0, v3, Lcom/wishabi/flipp/content/o;->c:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 173
    if-nez v0, :cond_0

    .line 174
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 175
    iget v4, v3, Lcom/wishabi/flipp/content/o;->c:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 178
    :cond_0
    if-eqz p1, :cond_1

    iget v4, v3, Lcom/wishabi/flipp/content/o;->o:I

    const/16 v5, 0xdeb

    if-eq v4, v5, :cond_2

    .line 180
    :cond_1
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 169
    :cond_2
    invoke-interface {p0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    goto :goto_0

    .line 185
    :cond_3
    return-object v1
.end method

.method public static b(Landroid/database/Cursor;)Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 160
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/wishabi/flipp/content/l;->a(Landroid/database/Cursor;Z)Ljava/util/HashMap;

    move-result-object v0

    return-object v0
.end method
