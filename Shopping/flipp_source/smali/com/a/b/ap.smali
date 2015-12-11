.class public final Lcom/a/b/ap;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field a:I

.field public b:Landroid/graphics/Bitmap;

.field public c:[B

.field public d:I

.field public e:Ljava/util/concurrent/atomic/AtomicInteger;

.field private f:Landroid/net/Uri;

.field private g:I

.field private h:I

.field private i:Z

.field private j:Z

.field private k:F

.field private l:F

.field private m:F

.field private n:Z

.field private o:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/a/b/ay;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Landroid/net/Uri;)V
    .locals 1

    .prologue
    .line 157
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 158
    iput-object p1, p0, Lcom/a/b/ap;->f:Landroid/net/Uri;

    .line 159
    const/4 v0, 0x0

    iput v0, p0, Lcom/a/b/ap;->g:I

    .line 160
    return-void
.end method


# virtual methods
.method public final a(II)Lcom/a/b/ap;
    .locals 2

    .prologue
    .line 220
    if-gtz p1, :cond_0

    .line 221
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Width must be positive number."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 223
    :cond_0
    if-gtz p2, :cond_1

    .line 224
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Height must be positive number."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 226
    :cond_1
    iput p1, p0, Lcom/a/b/ap;->a:I

    .line 227
    iput p2, p0, Lcom/a/b/ap;->h:I

    .line 228
    return-object p0
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/a/b/ap;->f:Landroid/net/Uri;

    if-nez v0, :cond_0

    iget v0, p0, Lcom/a/b/ap;->g:I

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final b()Lcom/a/b/ao;
    .locals 18

    .prologue
    .line 329
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/a/b/ap;->j:Z

    if-eqz v1, :cond_0

    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/a/b/ap;->i:Z

    if-eqz v1, :cond_0

    .line 330
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Center crop and center inside can not be used together."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 332
    :cond_0
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/a/b/ap;->i:Z

    if-eqz v1, :cond_1

    move-object/from16 v0, p0

    iget v1, v0, Lcom/a/b/ap;->a:I

    if-nez v1, :cond_1

    .line 333
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Center crop requires calling resize."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 335
    :cond_1
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/a/b/ap;->j:Z

    if-eqz v1, :cond_2

    move-object/from16 v0, p0

    iget v1, v0, Lcom/a/b/ap;->a:I

    if-nez v1, :cond_2

    .line 336
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Center inside requires calling resize."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 338
    :cond_2
    new-instance v1, Lcom/a/b/ao;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/a/b/ap;->f:Landroid/net/Uri;

    move-object/from16 v0, p0

    iget v3, v0, Lcom/a/b/ap;->g:I

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/a/b/ap;->o:Ljava/util/List;

    move-object/from16 v0, p0

    iget v5, v0, Lcom/a/b/ap;->a:I

    move-object/from16 v0, p0

    iget v6, v0, Lcom/a/b/ap;->h:I

    move-object/from16 v0, p0

    iget-boolean v7, v0, Lcom/a/b/ap;->i:Z

    move-object/from16 v0, p0

    iget-boolean v8, v0, Lcom/a/b/ap;->j:Z

    move-object/from16 v0, p0

    iget v9, v0, Lcom/a/b/ap;->k:F

    move-object/from16 v0, p0

    iget v10, v0, Lcom/a/b/ap;->l:F

    move-object/from16 v0, p0

    iget v11, v0, Lcom/a/b/ap;->m:F

    move-object/from16 v0, p0

    iget-boolean v12, v0, Lcom/a/b/ap;->n:Z

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/a/b/ap;->b:Landroid/graphics/Bitmap;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/a/b/ap;->c:[B

    move-object/from16 v0, p0

    iget v15, v0, Lcom/a/b/ap;->d:I

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/a/b/ap;->e:Ljava/util/concurrent/atomic/AtomicInteger;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-direct/range {v1 .. v17}, Lcom/a/b/ao;-><init>(Landroid/net/Uri;ILjava/util/List;IIZZFFFZLandroid/graphics/Bitmap;[BILjava/util/concurrent/atomic/AtomicInteger;B)V

    return-object v1
.end method
