.class public final Lcom/wishabi/flipp/content/m;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:I

.field final b:I

.field final c:I

.field final d:I

.field final e:I

.field final f:I

.field final g:I

.field final h:I

.field final i:I

.field final j:I

.field final k:I

.field final l:I

.field final m:I

.field final n:I

.field final o:I

.field final p:I

.field final q:I

.field final r:I

.field final s:I

.field final t:I

.field final u:I


# direct methods
.method public constructor <init>(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 249
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 250
    const-string v0, "_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->a:I

    .line 251
    const-string v0, "flyer_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->b:I

    .line 252
    const-string v0, "flyer_item_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->c:I

    .line 253
    const-string v0, "coupon_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->d:I

    .line 254
    const-string v0, "left"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->e:I

    .line 255
    const-string v0, "top"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->f:I

    .line 256
    const-string v0, "right"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->g:I

    .line 257
    const-string v0, "bottom"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->h:I

    .line 258
    const-string v0, "item_current_price"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->i:I

    .line 259
    const-string v0, "item_original_price"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->j:I

    .line 261
    const-string v0, "item_dollars_off"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->k:I

    .line 262
    const-string v0, "item_cutout_url"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->l:I

    .line 263
    const-string v0, "coupon_dollars_off"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->m:I

    .line 265
    const-string v0, "total_savings"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->n:I

    .line 266
    const-string v0, "final_price"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->o:I

    .line 267
    const-string v0, "percent_off"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->p:I

    .line 268
    const-string v0, "display_final_price"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->q:I

    .line 270
    const-string v0, "display_type"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->r:I

    .line 271
    const-string v0, "item_rank"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->s:I

    .line 274
    invoke-interface {p1, p2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->t:I

    .line 277
    invoke-interface {p1, p3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/m;->u:I

    .line 279
    return-void
.end method
