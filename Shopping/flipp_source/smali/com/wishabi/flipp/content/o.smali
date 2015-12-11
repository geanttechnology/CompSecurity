.class public final Lcom/wishabi/flipp/content/o;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final a:I

.field public final b:I

.field final c:I

.field public final d:Landroid/graphics/RectF;

.field public final e:Ljava/lang/Float;

.field public final f:Ljava/lang/Float;

.field public final g:Ljava/lang/Float;

.field public final h:Ljava/lang/String;

.field public final i:Ljava/lang/Float;

.field public final j:Ljava/lang/Float;

.field public final k:Ljava/lang/Float;

.field public final l:Z

.field public final m:Ljava/lang/Integer;

.field public final n:Ljava/lang/String;

.field final o:I

.field public final p:I

.field private final q:J

.field private final r:Ljava/lang/Float;

.field private final s:I


# direct methods
.method public constructor <init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/m;)V
    .locals 5

    .prologue
    const/4 v0, 0x1

    const/4 v4, -0x1

    .line 304
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 305
    iget v1, p2, Lcom/wishabi/flipp/content/m;->a:I

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/content/o;->a:I

    .line 306
    iget v1, p2, Lcom/wishabi/flipp/content/m;->b:I

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/content/o;->b:I

    .line 307
    iget v1, p2, Lcom/wishabi/flipp/content/m;->c:I

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/wishabi/flipp/content/o;->q:J

    .line 308
    iget v1, p2, Lcom/wishabi/flipp/content/m;->d:I

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/content/o;->c:I

    .line 309
    new-instance v1, Landroid/graphics/RectF;

    invoke-direct {v1}, Landroid/graphics/RectF;-><init>()V

    iput-object v1, p0, Lcom/wishabi/flipp/content/o;->d:Landroid/graphics/RectF;

    .line 310
    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->d:Landroid/graphics/RectF;

    iget v2, p2, Lcom/wishabi/flipp/content/m;->e:I

    invoke-interface {p1, v2}, Landroid/database/Cursor;->getFloat(I)F

    move-result v2

    iput v2, v1, Landroid/graphics/RectF;->left:F

    .line 311
    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->d:Landroid/graphics/RectF;

    iget v2, p2, Lcom/wishabi/flipp/content/m;->f:I

    invoke-interface {p1, v2}, Landroid/database/Cursor;->getFloat(I)F

    move-result v2

    iput v2, v1, Landroid/graphics/RectF;->top:F

    .line 312
    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->d:Landroid/graphics/RectF;

    iget v2, p2, Lcom/wishabi/flipp/content/m;->g:I

    invoke-interface {p1, v2}, Landroid/database/Cursor;->getFloat(I)F

    move-result v2

    iput v2, v1, Landroid/graphics/RectF;->right:F

    .line 313
    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->d:Landroid/graphics/RectF;

    iget v2, p2, Lcom/wishabi/flipp/content/m;->h:I

    invoke-interface {p1, v2}, Landroid/database/Cursor;->getFloat(I)F

    move-result v2

    iput v2, v1, Landroid/graphics/RectF;->bottom:F

    .line 314
    iget v1, p2, Lcom/wishabi/flipp/content/m;->i:I

    invoke-static {p1, v1}, Lcom/wishabi/flipp/util/f;->b(Landroid/database/Cursor;I)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/content/o;->e:Ljava/lang/Float;

    .line 316
    iget v1, p2, Lcom/wishabi/flipp/content/m;->j:I

    invoke-static {p1, v1}, Lcom/wishabi/flipp/util/f;->b(Landroid/database/Cursor;I)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/content/o;->f:Ljava/lang/Float;

    .line 318
    iget v1, p2, Lcom/wishabi/flipp/content/m;->k:I

    invoke-static {p1, v1}, Lcom/wishabi/flipp/util/f;->b(Landroid/database/Cursor;I)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/content/o;->g:Ljava/lang/Float;

    .line 320
    iget v1, p2, Lcom/wishabi/flipp/content/m;->l:I

    invoke-static {p1, v1}, Lcom/wishabi/flipp/util/f;->d(Landroid/database/Cursor;I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/content/o;->h:Ljava/lang/String;

    .line 322
    iget v1, p2, Lcom/wishabi/flipp/content/m;->m:I

    invoke-static {p1, v1}, Lcom/wishabi/flipp/util/f;->b(Landroid/database/Cursor;I)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/content/o;->i:Ljava/lang/Float;

    .line 324
    iget v1, p2, Lcom/wishabi/flipp/content/m;->n:I

    invoke-static {p1, v1}, Lcom/wishabi/flipp/util/f;->b(Landroid/database/Cursor;I)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/content/o;->r:Ljava/lang/Float;

    .line 326
    iget v1, p2, Lcom/wishabi/flipp/content/m;->o:I

    invoke-static {p1, v1}, Lcom/wishabi/flipp/util/f;->b(Landroid/database/Cursor;I)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/content/o;->j:Ljava/lang/Float;

    .line 328
    iget v1, p2, Lcom/wishabi/flipp/content/m;->p:I

    invoke-static {p1, v1}, Lcom/wishabi/flipp/util/f;->b(Landroid/database/Cursor;I)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/content/o;->k:Ljava/lang/Float;

    .line 330
    iget v1, p2, Lcom/wishabi/flipp/content/m;->q:I

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-ne v1, v0, :cond_1

    :goto_0
    iput-boolean v0, p0, Lcom/wishabi/flipp/content/o;->l:Z

    .line 331
    iget v0, p2, Lcom/wishabi/flipp/content/m;->r:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/o;->m:Ljava/lang/Integer;

    .line 332
    iget v0, p2, Lcom/wishabi/flipp/content/m;->s:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/o;->s:I

    .line 334
    iget v0, p2, Lcom/wishabi/flipp/content/m;->t:I

    if-eq v0, v4, :cond_2

    .line 335
    iget v0, p2, Lcom/wishabi/flipp/content/m;->t:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/content/o;->n:Ljava/lang/String;

    .line 339
    :goto_1
    iget v0, p2, Lcom/wishabi/flipp/content/m;->u:I

    if-eq v0, v4, :cond_3

    .line 340
    iget v0, p2, Lcom/wishabi/flipp/content/m;->u:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/o;->o:I

    .line 344
    :goto_2
    sget v0, Lcom/wishabi/flipp/content/n;->c:I

    .line 345
    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->i:Ljava/lang/Float;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->j:Ljava/lang/Float;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->k:Ljava/lang/Float;

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lcom/wishabi/flipp/content/o;->l:Z

    if-eqz v1, :cond_0

    .line 347
    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->f:Ljava/lang/Float;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->g:Ljava/lang/Float;

    if-eqz v1, :cond_4

    .line 348
    sget v0, Lcom/wishabi/flipp/content/n;->a:I

    .line 352
    :cond_0
    :goto_3
    iput v0, p0, Lcom/wishabi/flipp/content/o;->p:I

    .line 353
    return-void

    .line 330
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 337
    :cond_2
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/content/o;->n:Ljava/lang/String;

    goto :goto_1

    .line 342
    :cond_3
    iput v4, p0, Lcom/wishabi/flipp/content/o;->o:I

    goto :goto_2

    .line 349
    :cond_4
    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->e:Ljava/lang/Float;

    if-eqz v1, :cond_0

    .line 350
    sget v0, Lcom/wishabi/flipp/content/n;->b:I

    goto :goto_3
.end method


# virtual methods
.method public final a()Landroid/graphics/RectF;
    .locals 2

    .prologue
    .line 396
    new-instance v0, Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->d:Landroid/graphics/RectF;

    invoke-direct {v0, v1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    return-object v0
.end method

.method public final b()Z
    .locals 2

    .prologue
    .line 480
    iget v0, p0, Lcom/wishabi/flipp/content/o;->p:I

    sget v1, Lcom/wishabi/flipp/content/n;->a:I

    if-eq v0, v1, :cond_0

    iget v0, p0, Lcom/wishabi/flipp/content/o;->p:I

    sget v1, Lcom/wishabi/flipp/content/n;->b:I

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 357
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Model{mId="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Lcom/wishabi/flipp/content/o;->a:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mFlyerId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/content/o;->b:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mItemId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/wishabi/flipp/content/o;->q:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mCouponId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/content/o;->c:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mItemRect="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->d:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mItemCurrentPrice="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->e:Ljava/lang/Float;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mItemOriginalPrice="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->f:Ljava/lang/Float;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mItemDollarsOff="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->g:Ljava/lang/Float;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mItemCutoutUrl=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->h:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x27

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mCouponDollarsOff="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->i:Ljava/lang/Float;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mTotalSavings="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->r:Ljava/lang/Float;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mFinalPrice="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->j:Ljava/lang/Float;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mPercentOff="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->k:Ljava/lang/Float;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mDisplayFinalPrice="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/wishabi/flipp/content/o;->l:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mDisplayType="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->m:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mItemRank="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/content/o;->s:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mMerchantName="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/content/o;->n:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mMerchantId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/content/o;->o:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
