.class public final Lcom/wishabi/flipp/widget/ck;
.super Landroid/support/v7/widget/an;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/an",
        "<",
        "Landroid/support/v7/widget/bi;",
        ">;"
    }
.end annotation


# instance fields
.field final c:Lcom/wishabi/flipp/util/l;

.field public final d:Landroid/util/SparseBooleanArray;

.field public e:Ljava/lang/String;

.field private final f:Landroid/content/Context;

.field private final g:Landroid/database/Cursor;

.field private final h:Ljava/lang/String;

.field private final i:Lcom/wishabi/flipp/widget/cw;

.field private final j:Lcom/wishabi/flipp/widget/cv;

.field private final k:Landroid/text/TextWatcher;

.field private final l:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;Ljava/lang/String;Landroid/util/SparseBooleanArray;Lcom/wishabi/flipp/widget/cw;)V
    .locals 19

    .prologue
    .line 214
    invoke-direct/range {p0 .. p0}, Landroid/support/v7/widget/an;-><init>()V

    .line 187
    new-instance v2, Lcom/wishabi/flipp/widget/cl;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/wishabi/flipp/widget/cl;-><init>(Lcom/wishabi/flipp/widget/ck;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/wishabi/flipp/widget/ck;->k:Landroid/text/TextWatcher;

    .line 215
    new-instance v2, Lcom/wishabi/flipp/util/l;

    invoke-direct {v2}, Lcom/wishabi/flipp/util/l;-><init>()V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    .line 216
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/wishabi/flipp/widget/ck;->f:Landroid/content/Context;

    .line 217
    move-object/from16 v0, p2

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    .line 218
    const/4 v2, 0x0

    invoke-static {v2}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/wishabi/flipp/widget/ck;->h:Ljava/lang/String;

    .line 219
    new-instance v2, Landroid/util/SparseBooleanArray;

    invoke-direct {v2}, Landroid/util/SparseBooleanArray;-><init>()V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    .line 220
    move-object/from16 v0, p5

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/wishabi/flipp/widget/ck;->i:Lcom/wishabi/flipp/widget/cw;

    .line 221
    new-instance v2, Lcom/wishabi/flipp/widget/cm;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/wishabi/flipp/widget/cm;-><init>(Lcom/wishabi/flipp/widget/ck;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/wishabi/flipp/widget/ck;->j:Lcom/wishabi/flipp/widget/cv;

    .line 253
    new-instance v2, Lcom/wishabi/flipp/util/o;

    const/4 v3, -0x2

    invoke-direct {v2, v3}, Lcom/wishabi/flipp/util/o;-><init>(I)V

    .line 255
    new-instance v3, Lcom/wishabi/flipp/util/m;

    const-wide/16 v4, -0x2

    const/4 v6, 0x0

    invoke-direct {v3, v4, v5, v6}, Lcom/wishabi/flipp/util/m;-><init>(JI)V

    invoke-virtual {v2, v3}, Lcom/wishabi/flipp/util/o;->a(Lcom/wishabi/flipp/util/m;)V

    .line 257
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v3, v2}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    .line 260
    new-instance v2, Lcom/wishabi/flipp/util/o;

    const/4 v3, -0x3

    invoke-direct {v2, v3}, Lcom/wishabi/flipp/util/o;-><init>(I)V

    .line 262
    new-instance v3, Lcom/wishabi/flipp/util/m;

    const-wide/16 v4, -0x3

    const/4 v6, 0x1

    invoke-direct {v3, v4, v5, v6}, Lcom/wishabi/flipp/util/m;-><init>(JI)V

    invoke-virtual {v2, v3}, Lcom/wishabi/flipp/util/o;->a(Lcom/wishabi/flipp/util/m;)V

    .line 264
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v3, v2}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    .line 265
    move-object/from16 v0, p3

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/wishabi/flipp/widget/ck;->e:Ljava/lang/String;

    .line 268
    const/4 v5, 0x0

    .line 269
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    const-string v3, "redemption_method"

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    .line 270
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    const-string v3, "barcode_image_url"

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v7

    .line 272
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    const-string v3, "_id"

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v8

    .line 273
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    const-string v3, "sent"

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v9

    .line 276
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    .line 277
    if-eqz v3, :cond_2

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v2, v9}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    const/4 v4, 0x1

    if-ne v2, v4, :cond_2

    const/4 v4, 0x1

    .line 280
    :goto_0
    if-eqz v3, :cond_6

    if-nez v4, :cond_6

    .line 281
    new-instance v10, Lcom/wishabi/flipp/util/o;

    const/4 v2, -0x4

    invoke-direct {v10, v2}, Lcom/wishabi/flipp/util/o;-><init>(I)V

    .line 284
    const/4 v2, 0x0

    move/from16 v18, v3

    move v3, v5

    move/from16 v5, v18

    .line 285
    :goto_1
    if-eqz v5, :cond_5

    if-nez v4, :cond_5

    .line 286
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v4, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    .line 287
    if-eqz p4, :cond_0

    move-object/from16 v0, p4

    invoke-virtual {v0, v4}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v5

    if-nez v5, :cond_0

    move-object/from16 v0, p4

    invoke-virtual {v0, v4}, Landroid/util/SparseBooleanArray;->indexOfKey(I)I

    move-result v5

    if-gez v5, :cond_3

    .line 290
    :cond_0
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    const/4 v11, 0x1

    invoke-virtual {v5, v4, v11}, Landroid/util/SparseBooleanArray;->put(IZ)V

    .line 291
    add-int/lit8 v2, v2, 0x1

    .line 295
    :goto_2
    new-instance v5, Lcom/wishabi/flipp/util/m;

    int-to-long v12, v4

    const/4 v4, 0x3

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v11}, Landroid/database/Cursor;->getPosition()I

    move-result v11

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-direct {v5, v12, v13, v4, v11}, Lcom/wishabi/flipp/util/m;-><init>(JILjava/lang/Object;)V

    invoke-virtual {v10, v5}, Lcom/wishabi/flipp/util/o;->b(Lcom/wishabi/flipp/util/m;)V

    .line 298
    if-nez v3, :cond_1

    .line 299
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v4, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 300
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1

    const-string v5, "print"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 302
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v4, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 303
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 304
    const/4 v3, 0x1

    .line 308
    :cond_1
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v4}, Landroid/database/Cursor;->moveToNext()Z

    move-result v5

    .line 309
    if-eqz v5, :cond_4

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v4, v9}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    const/4 v11, 0x1

    if-ne v4, v11, :cond_4

    const/4 v4, 0x1

    goto :goto_1

    .line 277
    :cond_2
    const/4 v4, 0x0

    goto/16 :goto_0

    .line 293
    :cond_3
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    const/4 v11, 0x0

    invoke-virtual {v5, v4, v11}, Landroid/util/SparseBooleanArray;->put(IZ)V

    goto :goto_2

    .line 309
    :cond_4
    const/4 v4, 0x0

    goto/16 :goto_1

    .line 312
    :cond_5
    new-instance v11, Lcom/wishabi/flipp/util/m;

    const-wide/16 v12, -0x4

    const/4 v14, 0x2

    new-instance v15, Lcom/wishabi/flipp/widget/cr;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ck;->f:Landroid/content/Context;

    move-object/from16 v16, v0

    const v17, 0x7f0e0103

    invoke-virtual/range {v16 .. v17}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v15, v0, v2}, Lcom/wishabi/flipp/widget/cr;-><init>(Ljava/lang/String;I)V

    invoke-direct {v11, v12, v13, v14, v15}, Lcom/wishabi/flipp/util/m;-><init>(JILjava/lang/Object;)V

    invoke-virtual {v10, v11}, Lcom/wishabi/flipp/util/o;->a(Lcom/wishabi/flipp/util/m;)V

    .line 316
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v2, v10}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    move/from16 v18, v5

    move v5, v3

    move/from16 v3, v18

    .line 320
    :cond_6
    :goto_3
    if-eqz v3, :cond_b

    if-eqz v4, :cond_b

    .line 321
    new-instance v10, Lcom/wishabi/flipp/util/o;

    const/4 v2, -0x5

    invoke-direct {v10, v2}, Lcom/wishabi/flipp/util/o;-><init>(I)V

    .line 324
    const/4 v2, 0x0

    move/from16 v18, v3

    move v3, v5

    move/from16 v5, v18

    .line 325
    :goto_4
    if-eqz v5, :cond_a

    if-eqz v4, :cond_a

    .line 326
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v4, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    .line 327
    if-eqz p4, :cond_8

    move-object/from16 v0, p4

    invoke-virtual {v0, v4}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 329
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    const/4 v11, 0x1

    invoke-virtual {v5, v4, v11}, Landroid/util/SparseBooleanArray;->put(IZ)V

    .line 330
    add-int/lit8 v2, v2, 0x1

    .line 334
    :goto_5
    new-instance v5, Lcom/wishabi/flipp/util/m;

    int-to-long v12, v4

    const/4 v4, 0x3

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v11}, Landroid/database/Cursor;->getPosition()I

    move-result v11

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-direct {v5, v12, v13, v4, v11}, Lcom/wishabi/flipp/util/m;-><init>(JILjava/lang/Object;)V

    invoke-virtual {v10, v5}, Lcom/wishabi/flipp/util/o;->b(Lcom/wishabi/flipp/util/m;)V

    .line 337
    if-nez v3, :cond_7

    .line 338
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v4, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 339
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_7

    const-string v5, "print"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 341
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v4, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 342
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 343
    const/4 v3, 0x1

    .line 347
    :cond_7
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v4}, Landroid/database/Cursor;->moveToNext()Z

    move-result v5

    .line 348
    if-eqz v5, :cond_9

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v4, v9}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    const/4 v11, 0x1

    if-ne v4, v11, :cond_9

    const/4 v4, 0x1

    goto :goto_4

    .line 332
    :cond_8
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    const/4 v11, 0x0

    invoke-virtual {v5, v4, v11}, Landroid/util/SparseBooleanArray;->put(IZ)V

    goto :goto_5

    .line 348
    :cond_9
    const/4 v4, 0x0

    goto :goto_4

    .line 351
    :cond_a
    new-instance v11, Lcom/wishabi/flipp/util/m;

    const-wide/16 v12, -0x5

    const/4 v14, 0x2

    new-instance v15, Lcom/wishabi/flipp/widget/cr;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ck;->f:Landroid/content/Context;

    move-object/from16 v16, v0

    const v17, 0x7f0e010b

    invoke-virtual/range {v16 .. v17}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v15, v0, v2}, Lcom/wishabi/flipp/widget/cr;-><init>(Ljava/lang/String;I)V

    invoke-direct {v11, v12, v13, v14, v15}, Lcom/wishabi/flipp/util/m;-><init>(JILjava/lang/Object;)V

    invoke-virtual {v10, v11}, Lcom/wishabi/flipp/util/o;->a(Lcom/wishabi/flipp/util/m;)V

    .line 355
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v2, v10}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    move/from16 v18, v5

    move v5, v3

    move/from16 v3, v18

    .line 356
    goto/16 :goto_3

    .line 358
    :cond_b
    move-object/from16 v0, p0

    iput-boolean v5, v0, Lcom/wishabi/flipp/widget/ck;->l:Z

    .line 359
    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 440
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/l;->c()I

    move-result v0

    return v0
.end method

.method public final a(I)I
    .locals 1

    .prologue
    .line 454
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    .line 455
    if-nez v0, :cond_0

    .line 456
    const/4 v0, -0x1

    .line 458
    :goto_0
    return v0

    :cond_0
    iget v0, v0, Lcom/wishabi/flipp/util/m;->d:I

    goto :goto_0
.end method

.method public final a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/bi;
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, -0x1

    const/4 v3, -0x2

    const/4 v0, 0x0

    .line 364
    packed-switch p2, :pswitch_data_0

    .line 397
    :goto_0
    return-object v0

    .line 366
    :pswitch_0
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ck;->f:Landroid/content/Context;

    const v2, 0x7f030049

    invoke-static {v1, v2, v0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 367
    new-instance v0, Lcom/wishabi/flipp/widget/cx;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/widget/cx;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 370
    :pswitch_1
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ck;->f:Landroid/content/Context;

    const v2, 0x7f030047

    invoke-static {v1, v2, v0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 371
    new-instance v0, Lcom/wishabi/flipp/widget/cn;

    iget-object v2, p0, Lcom/wishabi/flipp/widget/ck;->f:Landroid/content/Context;

    iget-object v3, p0, Lcom/wishabi/flipp/widget/ck;->k:Landroid/text/TextWatcher;

    iget-object v4, p0, Lcom/wishabi/flipp/widget/ck;->i:Lcom/wishabi/flipp/widget/cw;

    invoke-direct {v0, v2, v1, v3, v4}, Lcom/wishabi/flipp/widget/cn;-><init>(Landroid/content/Context;Landroid/view/View;Landroid/text/TextWatcher;Lcom/wishabi/flipp/widget/cw;)V

    goto :goto_0

    .line 374
    :pswitch_2
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ck;->f:Landroid/content/Context;

    const v2, 0x7f030048

    invoke-static {v1, v2, v0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 376
    const/4 v0, 0x5

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 377
    new-instance v2, Landroid/support/v7/widget/av;

    invoke-direct {v2, v4, v3}, Landroid/support/v7/widget/av;-><init>(II)V

    .line 380
    invoke-virtual {v2, v5, v0, v5, v0}, Landroid/support/v7/widget/av;->setMargins(IIII)V

    .line 381
    invoke-virtual {v1, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 383
    new-instance v0, Lcom/wishabi/flipp/widget/cs;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/widget/cs;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 386
    :pswitch_3
    new-instance v1, Lcom/wishabi/flipp/widget/CouponCell;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ck;->f:Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/wishabi/flipp/widget/CouponCell;-><init>(Landroid/content/Context;)V

    .line 388
    new-instance v0, Landroid/support/v7/widget/av;

    invoke-direct {v0, v4, v3}, Landroid/support/v7/widget/av;-><init>(II)V

    .line 391
    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/CouponCell;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 393
    new-instance v0, Lcom/wishabi/flipp/widget/ct;

    iget-object v2, p0, Lcom/wishabi/flipp/widget/ck;->j:Lcom/wishabi/flipp/widget/cv;

    invoke-direct {v0, v1, v2}, Lcom/wishabi/flipp/widget/ct;-><init>(Landroid/view/View;Lcom/wishabi/flipp/widget/cv;)V

    goto :goto_0

    .line 364
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public final a(Landroid/support/v7/widget/bi;I)V
    .locals 11

    .prologue
    const/4 v9, 0x0

    const/4 v5, 0x0

    .line 402
    invoke-virtual {p0, p2}, Lcom/wishabi/flipp/widget/ck;->a(I)I

    move-result v0

    .line 404
    packed-switch v0, :pswitch_data_0

    .line 433
    :goto_0
    return-void

    .line 406
    :pswitch_0
    check-cast p1, Lcom/wishabi/flipp/widget/cn;

    .line 407
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ck;->e:Ljava/lang/String;

    iget-boolean v1, p0, Lcom/wishabi/flipp/widget/ck;->l:Z

    iget-object v2, p1, Lcom/wishabi/flipp/widget/cn;->l:Landroid/widget/EditText;

    invoke-virtual {v2, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p1, Lcom/wishabi/flipp/widget/cn;->m:Landroid/widget/LinearLayout;

    if-eqz v1, :cond_0

    :goto_1
    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    :cond_0
    const/16 v5, 0x8

    goto :goto_1

    .line 410
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p2}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    .line 411
    iget-object v0, v0, Lcom/wishabi/flipp/util/m;->e:Ljava/lang/Object;

    check-cast v0, Lcom/wishabi/flipp/widget/cr;

    .line 412
    check-cast p1, Lcom/wishabi/flipp/widget/cs;

    .line 413
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ck;->f:Landroid/content/Context;

    iget-object v2, p1, Lcom/wishabi/flipp/widget/cs;->k:Landroid/widget/TextView;

    iget-object v3, v0, Lcom/wishabi/flipp/widget/cr;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v2, p1, Lcom/wishabi/flipp/widget/cs;->l:Landroid/widget/TextView;

    const v3, 0x7f0e010a

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    iget v0, v0, Lcom/wishabi/flipp/widget/cr;->b:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v4, v5

    invoke-virtual {v1, v3, v4}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 417
    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p2}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v1

    .line 418
    iget-object v0, v1, Lcom/wishabi/flipp/util/m;->e:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    .line 419
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    invoke-interface {v0, v3}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v0

    if-nez v0, :cond_1

    .line 420
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Couldn\'t move cursor to position "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 423
    :cond_1
    iget-wide v0, v1, Lcom/wishabi/flipp/util/m;->a:J

    long-to-int v0, v0

    .line 424
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    invoke-virtual {v1, v0}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v6

    .line 426
    check-cast p1, Lcom/wishabi/flipp/widget/ct;

    .line 427
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ck;->f:Landroid/content/Context;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ck;->h:Ljava/lang/String;

    iget-object v2, p1, Lcom/wishabi/flipp/widget/ct;->k:Lcom/wishabi/flipp/widget/CouponCell;

    iget-object v4, p0, Lcom/wishabi/flipp/widget/ck;->g:Landroid/database/Cursor;

    if-eqz v6, :cond_2

    sget v7, Lcom/wishabi/flipp/widget/z;->b:I

    :goto_2
    const/16 v6, 0x104

    invoke-static {v6}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v8

    move v6, v5

    move-object v10, v9

    invoke-static/range {v0 .. v10}, Lcom/wishabi/flipp/widget/aw;->a(Landroid/content/Context;Ljava/lang/String;Lcom/wishabi/flipp/widget/CouponCell;ILandroid/database/Cursor;ZZIILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V

    goto/16 :goto_0

    :cond_2
    sget v7, Lcom/wishabi/flipp/widget/z;->c:I

    goto :goto_2

    .line 404
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final b(I)J
    .locals 2

    .prologue
    .line 445
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    .line 446
    if-nez v0, :cond_0

    .line 447
    const-wide/16 v0, -0x1

    .line 449
    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, v0, Lcom/wishabi/flipp/util/m;->a:J

    goto :goto_0
.end method
