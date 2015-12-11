.class final Lcom/wishabi/flipp/app/bv;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field a:F

.field b:F

.field c:F

.field d:F

.field e:I

.field private f:I

.field private g:I

.field private h:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/wishabi/flipp/app/bw;Landroid/database/Cursor;)V
    .locals 1

    .prologue
    .line 190
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 191
    iget v0, p1, Lcom/wishabi/flipp/app/bw;->a:I

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bv;->f:I

    .line 192
    iget v0, p1, Lcom/wishabi/flipp/app/bw;->b:I

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bv;->g:I

    .line 193
    iget v0, p1, Lcom/wishabi/flipp/app/bw;->c:I

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getFloat(I)F

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bv;->a:F

    .line 194
    iget v0, p1, Lcom/wishabi/flipp/app/bw;->d:I

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getFloat(I)F

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bv;->b:F

    .line 195
    iget v0, p1, Lcom/wishabi/flipp/app/bw;->e:I

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getFloat(I)F

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bv;->c:F

    .line 196
    iget v0, p1, Lcom/wishabi/flipp/app/bw;->f:I

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getFloat(I)F

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bv;->d:F

    .line 197
    iget v0, p1, Lcom/wishabi/flipp/app/bw;->g:I

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/bv;->h:Ljava/lang/String;

    .line 198
    iget v0, p1, Lcom/wishabi/flipp/app/bw;->h:I

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bv;->e:I

    .line 199
    return-void
.end method
