.class public final Lcom/wishabi/flipp/content/c;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final A:Ljava/lang/String;

.field public final a:I

.field public final b:Ljava/lang/Integer;

.field public final c:Ljava/lang/String;

.field public final d:Ljava/lang/String;

.field public final e:Ljava/lang/Integer;

.field public final f:Lcom/wishabi/flipp/content/f;

.field public final g:Ljava/lang/String;

.field public final h:Ljava/lang/String;

.field public final i:Ljava/lang/String;

.field public final j:Lcom/wishabi/flipp/content/e;

.field public final k:Ljava/lang/String;

.field public final l:Ljava/lang/String;

.field public final m:Ljava/lang/String;

.field public final n:Ljava/lang/String;

.field public final o:I

.field public final p:Z

.field public final q:Z

.field public final r:Z

.field private final s:Ljava/lang/String;

.field private final t:Ljava/lang/Double;

.field private final u:Ljava/lang/Double;

.field private final v:Ljava/lang/Integer;

.field private final w:Ljava/lang/Integer;

.field private final x:Ljava/lang/String;

.field private final y:Ljava/lang/String;

.field private final z:Z


# direct methods
.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 1

    .prologue
    .line 246
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/content/c;-><init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/d;)V

    .line 247
    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/d;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 249
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 250
    if-nez p2, :cond_0

    .line 251
    new-instance p2, Lcom/wishabi/flipp/content/d;

    invoke-direct {p2, p1}, Lcom/wishabi/flipp/content/d;-><init>(Landroid/database/Cursor;)V

    .line 253
    :cond_0
    iget v0, p2, Lcom/wishabi/flipp/content/d;->a:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/c;->a:I

    .line 254
    iget v0, p2, Lcom/wishabi/flipp/content/d;->b:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->c(Landroid/database/Cursor;I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->b:Ljava/lang/Integer;

    .line 255
    iget v0, p2, Lcom/wishabi/flipp/content/d;->c:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->d(Landroid/database/Cursor;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->c:Ljava/lang/String;

    .line 256
    iget v0, p2, Lcom/wishabi/flipp/content/d;->d:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->d(Landroid/database/Cursor;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->d:Ljava/lang/String;

    .line 257
    iget v0, p2, Lcom/wishabi/flipp/content/d;->e:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->c(Landroid/database/Cursor;I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->e:Ljava/lang/Integer;

    .line 258
    iget v0, p2, Lcom/wishabi/flipp/content/d;->f:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 259
    invoke-static {v0}, Lcom/wishabi/flipp/content/f;->a(Ljava/lang/String;)Lcom/wishabi/flipp/content/f;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->f:Lcom/wishabi/flipp/content/f;

    .line 260
    iget v0, p2, Lcom/wishabi/flipp/content/d;->g:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->d(Landroid/database/Cursor;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->g:Ljava/lang/String;

    .line 261
    iget v0, p2, Lcom/wishabi/flipp/content/d;->h:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->d(Landroid/database/Cursor;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->h:Ljava/lang/String;

    .line 262
    iget v0, p2, Lcom/wishabi/flipp/content/d;->i:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->d(Landroid/database/Cursor;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->s:Ljava/lang/String;

    .line 263
    iget v0, p2, Lcom/wishabi/flipp/content/d;->j:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->a(Landroid/database/Cursor;I)Ljava/lang/Double;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    .line 264
    iget v0, p2, Lcom/wishabi/flipp/content/d;->k:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->a(Landroid/database/Cursor;I)Ljava/lang/Double;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    .line 265
    iget v0, p2, Lcom/wishabi/flipp/content/d;->l:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->c(Landroid/database/Cursor;I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    .line 266
    iget v0, p2, Lcom/wishabi/flipp/content/d;->m:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->c(Landroid/database/Cursor;I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    .line 267
    iget v0, p2, Lcom/wishabi/flipp/content/d;->n:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->d(Landroid/database/Cursor;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->i:Ljava/lang/String;

    .line 268
    iget v0, p2, Lcom/wishabi/flipp/content/d;->o:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 269
    invoke-static {v0}, Lcom/wishabi/flipp/content/e;->a(Ljava/lang/String;)Lcom/wishabi/flipp/content/e;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->j:Lcom/wishabi/flipp/content/e;

    .line 270
    iget v0, p2, Lcom/wishabi/flipp/content/d;->p:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->x:Ljava/lang/String;

    .line 271
    iget v0, p2, Lcom/wishabi/flipp/content/d;->q:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->d(Landroid/database/Cursor;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->y:Ljava/lang/String;

    .line 272
    iget v0, p2, Lcom/wishabi/flipp/content/d;->r:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->k:Ljava/lang/String;

    .line 273
    iget v0, p2, Lcom/wishabi/flipp/content/d;->s:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->d(Landroid/database/Cursor;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->l:Ljava/lang/String;

    .line 274
    iget v0, p2, Lcom/wishabi/flipp/content/d;->t:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->m:Ljava/lang/String;

    .line 275
    iget v0, p2, Lcom/wishabi/flipp/content/d;->u:I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/f;->d(Landroid/database/Cursor;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->n:Ljava/lang/String;

    .line 276
    iget v0, p2, Lcom/wishabi/flipp/content/d;->v:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v1, :cond_1

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lcom/wishabi/flipp/content/c;->z:Z

    .line 277
    iget v0, p2, Lcom/wishabi/flipp/content/d;->w:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/c;->o:I

    .line 278
    iget v0, p2, Lcom/wishabi/flipp/content/d;->x:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/c;->A:Ljava/lang/String;

    .line 279
    iget v0, p2, Lcom/wishabi/flipp/content/d;->y:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v1, :cond_2

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lcom/wishabi/flipp/content/c;->p:Z

    .line 281
    iget v0, p2, Lcom/wishabi/flipp/content/d;->z:I

    if-ltz v0, :cond_3

    iget v0, p2, Lcom/wishabi/flipp/content/d;->z:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v1, :cond_3

    move v0, v1

    :goto_2
    iput-boolean v0, p0, Lcom/wishabi/flipp/content/c;->q:Z

    .line 283
    iget v0, p2, Lcom/wishabi/flipp/content/d;->A:I

    if-ltz v0, :cond_4

    iget v0, p2, Lcom/wishabi/flipp/content/d;->A:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v1, :cond_4

    :goto_3
    iput-boolean v1, p0, Lcom/wishabi/flipp/content/c;->r:Z

    .line 285
    return-void

    :cond_1
    move v0, v2

    .line 276
    goto :goto_0

    :cond_2
    move v0, v2

    .line 279
    goto :goto_1

    :cond_3
    move v0, v2

    .line 281
    goto :goto_2

    :cond_4
    move v1, v2

    .line 283
    goto :goto_3
.end method


# virtual methods
.method public final a(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 531
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->A:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public final a()[Ljava/lang/String;
    .locals 12

    .prologue
    const v11, 0x7f0e011b

    const/4 v1, 0x0

    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 331
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v3

    .line 332
    if-nez v3, :cond_0

    move-object v0, v1

    .line 443
    :goto_0
    return-object v0

    .line 335
    :cond_0
    const/4 v0, 0x3

    new-array v2, v0, [Ljava/lang/String;

    .line 338
    iget-boolean v0, p0, Lcom/wishabi/flipp/content/c;->z:Z

    if-eqz v0, :cond_1

    .line 339
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->s:Ljava/lang/String;

    aput-object v0, v2, v8

    move-object v0, v2

    .line 340
    goto :goto_0

    .line 343
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->f:Lcom/wishabi/flipp/content/f;

    sget-object v4, Lcom/wishabi/flipp/content/f;->a:Lcom/wishabi/flipp/content/f;

    if-ne v0, v4, :cond_3

    .line 344
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmpl-double v0, v4, v6

    if-lez v0, :cond_2

    .line 345
    const v0, 0x7f0e011d

    invoke-virtual {v3, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v8

    .line 346
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/wishabi/flipp/util/q;->a(D)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v9

    .line 347
    aput-object v1, v2, v10

    :cond_2
    :goto_1
    move-object v0, v2

    .line 443
    goto :goto_0

    .line 349
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->f:Lcom/wishabi/flipp/content/f;

    sget-object v4, Lcom/wishabi/flipp/content/f;->b:Lcom/wishabi/flipp/content/f;

    if-ne v0, v4, :cond_4

    .line 350
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmpl-double v0, v4, v6

    if-lez v0, :cond_2

    .line 352
    new-instance v0, Ljava/text/DecimalFormat;

    invoke-direct {v0}, Ljava/text/DecimalFormat;-><init>()V

    .line 353
    iget-object v4, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    const-wide/high16 v6, 0x4059000000000000L    # 100.0

    mul-double/2addr v4, v6

    invoke-virtual {v0, v4, v5}, Ljava/text/NumberFormat;->format(D)Ljava/lang/String;

    move-result-object v0

    .line 355
    aput-object v1, v2, v8

    .line 356
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "%"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v9

    .line 357
    invoke-virtual {v3, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v10

    goto :goto_1

    .line 359
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->f:Lcom/wishabi/flipp/content/f;

    sget-object v4, Lcom/wishabi/flipp/content/f;->c:Lcom/wishabi/flipp/content/f;

    if-ne v0, v4, :cond_2

    .line 360
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_2

    .line 362
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    sget-object v4, Ljava/util/Locale;->CANADA_FRENCH:Ljava/util/Locale;

    invoke-virtual {v0, v4}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 364
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmpl-double v0, v4, v6

    if-lez v0, :cond_6

    .line 366
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_5

    .line 367
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const v4, 0x7f0e0119

    new-array v5, v10, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    aput-object v6, v5, v8

    iget-object v6, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    aput-object v6, v5, v9

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const v4, 0x7f0e011c

    new-array v5, v9, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    invoke-virtual {v6}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    invoke-static {v6, v7}, Lcom/wishabi/flipp/util/q;->a(D)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v3, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v8

    .line 377
    :goto_2
    aput-object v1, v2, v9

    .line 378
    aput-object v1, v2, v10

    goto/16 :goto_1

    .line 373
    :cond_5
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const v4, 0x7f0e0118

    new-array v5, v9, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    aput-object v6, v5, v8

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v4, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/wishabi/flipp/util/q;->a(D)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v3, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v8

    goto :goto_2

    .line 379
    :cond_6
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmpl-double v0, v4, v6

    if-lez v0, :cond_8

    .line 383
    new-instance v0, Ljava/text/DecimalFormat;

    invoke-direct {v0}, Ljava/text/DecimalFormat;-><init>()V

    .line 384
    iget-object v4, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    const-wide/high16 v6, 0x4059000000000000L    # 100.0

    mul-double/2addr v4, v6

    invoke-virtual {v0, v4, v5}, Ljava/text/NumberFormat;->format(D)Ljava/lang/String;

    move-result-object v0

    .line 386
    iget-object v4, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    if-eqz v4, :cond_7

    iget-object v4, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-lez v4, :cond_7

    .line 387
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const v5, 0x7f0e0119

    new-array v6, v10, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    aput-object v7, v6, v8

    iget-object v7, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    aput-object v7, v6, v9

    invoke-virtual {v3, v5, v6}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const v5, 0x7f0e011c

    new-array v6, v9, [Ljava/lang/Object;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v7, "%"

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v6, v8

    invoke-virtual {v3, v5, v6}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v3, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v8

    .line 397
    :goto_3
    aput-object v1, v2, v9

    .line 398
    aput-object v1, v2, v10

    goto/16 :goto_1

    .line 393
    :cond_7
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const v5, 0x7f0e0118

    new-array v6, v9, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    aput-object v7, v6, v8

    invoke-virtual {v3, v5, v6}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "% "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v3, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v8

    goto :goto_3

    .line 399
    :cond_8
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_2

    .line 402
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const v4, 0x7f0e0119

    new-array v5, v10, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    aput-object v6, v5, v8

    iget-object v6, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    aput-object v6, v5, v9

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const v4, 0x7f0e011a

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v8

    .line 405
    aput-object v1, v2, v9

    .line 406
    aput-object v1, v2, v10

    goto/16 :goto_1

    .line 410
    :cond_9
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmpl-double v0, v4, v6

    if-lez v0, :cond_b

    .line 411
    const v4, 0x7f0e0119

    new-array v5, v10, [Ljava/lang/Object;

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    aput-object v0, v5, v8

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_a

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    :goto_4
    aput-object v0, v5, v9

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v8

    .line 415
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const v4, 0x7f0e011c

    new-array v5, v9, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    invoke-virtual {v6}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    invoke-static {v6, v7}, Lcom/wishabi/flipp/util/q;->a(D)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v3, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v9

    .line 418
    aput-object v1, v2, v10

    goto/16 :goto_1

    .line 411
    :cond_a
    const-string v0, ""

    goto :goto_4

    .line 419
    :cond_b
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    if-eqz v0, :cond_d

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmpl-double v0, v4, v6

    if-lez v0, :cond_d

    .line 421
    new-instance v0, Ljava/text/DecimalFormat;

    invoke-direct {v0}, Ljava/text/DecimalFormat;-><init>()V

    .line 422
    iget-object v4, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    const-wide/high16 v6, 0x4059000000000000L    # 100.0

    mul-double/2addr v4, v6

    invoke-virtual {v0, v4, v5}, Ljava/text/NumberFormat;->format(D)Ljava/lang/String;

    move-result-object v4

    .line 424
    const v5, 0x7f0e0119

    new-array v6, v10, [Ljava/lang/Object;

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    aput-object v0, v6, v8

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_c

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    :goto_5
    aput-object v0, v6, v9

    invoke-virtual {v3, v5, v6}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v8

    .line 428
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const v5, 0x7f0e011c

    new-array v6, v9, [Ljava/lang/Object;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v7, "%"

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v6, v8

    invoke-virtual {v3, v5, v6}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v3, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v9

    .line 431
    aput-object v1, v2, v10

    goto/16 :goto_1

    .line 424
    :cond_c
    const-string v0, ""

    goto :goto_5

    .line 432
    :cond_d
    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_2

    .line 434
    const v0, 0x7f0e0119

    new-array v4, v10, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    aput-object v5, v4, v8

    iget-object v5, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    aput-object v5, v4, v9

    invoke-virtual {v3, v0, v4}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v8

    .line 436
    const v0, 0x7f0e011a

    invoke-virtual {v3, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v9

    .line 437
    aput-object v1, v2, v10

    goto/16 :goto_1
.end method

.method public final toString()Ljava/lang/String;
    .locals 3

    .prologue
    const/16 v2, 0x27

    .line 540
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Model{mCouponId="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Lcom/wishabi/flipp/content/c;->a:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mMerchantId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->b:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mMerchantName=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mMerchantLogoUrl=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mCouponVendorId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->e:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mType="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->f:Lcom/wishabi/flipp/content/f;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mBrand=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->g:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mBrandLogoUrl=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->h:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mSaleStory=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->s:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mDollarsOff="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->t:Ljava/lang/Double;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mPercentOff="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->u:Ljava/lang/Double;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mQualifyingQuantity="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->v:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mRewardQuantity="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->w:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mPromotionText=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->i:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mRedemptionMethod="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->j:Lcom/wishabi/flipp/content/e;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mAvailableFrom=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->x:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mAvailableTo=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->y:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mValidFrom=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->k:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mValidTo=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->l:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mCouponImageUrl=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->m:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mBarcodeImageUrl=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->n:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mUseSaleStory="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/wishabi/flipp/content/c;->z:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mPriority="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/content/c;->o:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mPostalCode=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/c;->A:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mDeleted=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/wishabi/flipp/content/c;->p:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
