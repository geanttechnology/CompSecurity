.class public final Lcom/wishabi/flipp/widget/g;
.super Lcom/wishabi/flipp/widget/da;
.source "SourceFile"


# instance fields
.field final a:Landroid/database/Cursor;

.field final b:Landroid/database/Cursor;

.field final c:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;>;"
        }
    .end annotation
.end field

.field final d:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;>;"
        }
    .end annotation
.end field

.field final e:Lcom/wishabi/flipp/util/l;

.field f:[F

.field public g:Z

.field h:I

.field i:I

.field private final k:Landroid/content/Context;

.field private final l:Ljava/lang/String;

.field private final m:Lcom/wishabi/flipp/app/dn;

.field private n:I

.field private o:I

.field private p:I

.field private q:I

.field private r:I

.field private s:I

.field private t:I

.field private u:I

.field private v:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/database/Cursor;Ljava/util/HashMap;Ljava/util/HashMap;Lcom/wishabi/flipp/app/dn;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/database/Cursor;",
            "Landroid/database/Cursor;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;>;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;>;",
            "Lcom/wishabi/flipp/app/dn;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v0, 0x0

    const/4 v2, -0x1

    .line 72
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/da;-><init>()V

    .line 51
    new-instance v1, Lcom/wishabi/flipp/util/l;

    invoke-direct {v1}, Lcom/wishabi/flipp/util/l;-><init>()V

    iput-object v1, p0, Lcom/wishabi/flipp/widget/g;->e:Lcom/wishabi/flipp/util/l;

    .line 56
    iput v2, p0, Lcom/wishabi/flipp/widget/g;->n:I

    .line 57
    iput v2, p0, Lcom/wishabi/flipp/widget/g;->o:I

    .line 58
    iput v2, p0, Lcom/wishabi/flipp/widget/g;->p:I

    .line 59
    iput v2, p0, Lcom/wishabi/flipp/widget/g;->q:I

    .line 60
    iput v2, p0, Lcom/wishabi/flipp/widget/g;->h:I

    .line 61
    iput v2, p0, Lcom/wishabi/flipp/widget/g;->r:I

    .line 62
    iput v2, p0, Lcom/wishabi/flipp/widget/g;->s:I

    .line 63
    iput v2, p0, Lcom/wishabi/flipp/widget/g;->t:I

    .line 64
    iput v2, p0, Lcom/wishabi/flipp/widget/g;->u:I

    .line 65
    iput v2, p0, Lcom/wishabi/flipp/widget/g;->v:I

    .line 67
    iput v2, p0, Lcom/wishabi/flipp/widget/g;->i:I

    .line 73
    iput-object p1, p0, Lcom/wishabi/flipp/widget/g;->k:Landroid/content/Context;

    .line 74
    const/4 v1, 0x0

    invoke-static {v1}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/widget/g;->l:Ljava/lang/String;

    .line 75
    iput-object p2, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    .line 76
    iput-object p3, p0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    .line 77
    iput-object p4, p0, Lcom/wishabi/flipp/widget/g;->c:Ljava/util/HashMap;

    .line 78
    iput-object p5, p0, Lcom/wishabi/flipp/widget/g;->d:Ljava/util/HashMap;

    .line 79
    iput-object p6, p0, Lcom/wishabi/flipp/widget/g;->m:Lcom/wishabi/flipp/app/dn;

    .line 81
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    if-eqz v1, :cond_0

    .line 82
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    const-string v2, "top"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/widget/g;->n:I

    .line 83
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    const-string v2, "bottom"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/widget/g;->o:I

    .line 84
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    const-string v2, "left"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/widget/g;->p:I

    .line 85
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    const-string v2, "right"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/widget/g;->q:I

    .line 86
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    const-string v2, "_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/widget/g;->h:I

    .line 87
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    const-string v2, "valid_to"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/widget/g;->r:I

    .line 88
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    const-string v2, "thumbnail"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/widget/g;->s:I

    .line 89
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    const-string v2, "name"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/widget/g;->t:I

    .line 90
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    const-string v2, "merchant"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/widget/g;->u:I

    .line 91
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    const-string v2, "merchant_logo"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/widget/g;->v:I

    .line 94
    :cond_0
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    if-eqz v1, :cond_1

    .line 95
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    const-string v2, "_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/wishabi/flipp/widget/g;->i:I

    .line 98
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_2

    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    const-string v2, "Flyers"

    invoke-static {v0, v1, v2}, Lcom/wishabi/flipp/util/o;->a(IILjava/lang/String;)Lcom/wishabi/flipp/util/o;

    move-result-object v1

    iput v0, v1, Lcom/wishabi/flipp/util/o;->d:I

    iget-object v2, p0, Lcom/wishabi/flipp/widget/g;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v2, v1}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    new-array v1, v1, [F

    iput-object v1, p0, Lcom/wishabi/flipp/widget/g;->f:[F

    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    :goto_0
    if-ge v0, v1, :cond_2

    iget-object v2, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    invoke-interface {v2, v0}, Landroid/database/Cursor;->moveToPosition(I)Z

    iget-object v2, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    iget v3, p0, Lcom/wishabi/flipp/widget/g;->o:I

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getFloat(I)F

    move-result v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    iget v4, p0, Lcom/wishabi/flipp/widget/g;->n:I

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getFloat(I)F

    move-result v3

    sub-float/2addr v2, v3

    iget-object v3, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    iget v4, p0, Lcom/wishabi/flipp/widget/g;->q:I

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getFloat(I)F

    move-result v3

    iget-object v4, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    iget v5, p0, Lcom/wishabi/flipp/widget/g;->p:I

    invoke-interface {v4, v5}, Landroid/database/Cursor;->getFloat(I)F

    move-result v4

    sub-float/2addr v3, v4

    iget-object v4, p0, Lcom/wishabi/flipp/widget/g;->f:[F

    div-float/2addr v2, v3

    aput v2, v4, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_3

    iget-object v0, p0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    const-string v1, "Coupons"

    invoke-static {v6, v0, v1}, Lcom/wishabi/flipp/util/o;->a(IILjava/lang/String;)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    iput v6, v0, Lcom/wishabi/flipp/util/o;->d:I

    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    :cond_3
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/wishabi/flipp/widget/g;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/l;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/o;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_4
    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/widget/g;->a(Ljava/util/List;)V

    .line 99
    return-void
.end method


# virtual methods
.method public final a(II)I
    .locals 1

    .prologue
    .line 251
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/widget/g;->b(II)I

    move-result v0

    return v0
.end method

.method protected final a(IILandroid/view/View;)Landroid/view/View;
    .locals 17

    .prologue
    .line 160
    invoke-virtual/range {p0 .. p2}, Lcom/wishabi/flipp/widget/g;->b(II)I

    move-result v9

    .line 161
    invoke-virtual/range {p0 .. p1}, Lcom/wishabi/flipp/widget/g;->b(I)I

    move-result v2

    .line 163
    packed-switch v2, :pswitch_data_0

    .line 215
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "Invalid section id requested"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 165
    :pswitch_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    move/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v2

    if-nez v2, :cond_0

    .line 166
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Couldn\'t move cursor to position "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move/from16 v0, p2

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 169
    :cond_0
    if-eqz p3, :cond_1

    check-cast p3, Lcom/wishabi/flipp/widget/a;

    move-object/from16 v3, p3

    .line 172
    :goto_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    move-object/from16 v0, p0

    iget v4, v0, Lcom/wishabi/flipp/widget/g;->h:I

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v12

    .line 174
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    move-object/from16 v0, p0

    iget v4, v0, Lcom/wishabi/flipp/widget/g;->r:I

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 175
    invoke-static {}, Lb/a/a/d/aa;->a()Lb/a/a/d/d;

    move-result-object v4

    .line 176
    if-eqz v2, :cond_2

    invoke-virtual {v4, v2}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v4

    .line 179
    :goto_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/g;->k:Landroid/content/Context;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    move-object/from16 v0, p0

    iget v6, v0, Lcom/wishabi/flipp/widget/g;->s:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    move-object/from16 v0, p0

    iget v7, v0, Lcom/wishabi/flipp/widget/g;->t:I

    invoke-interface {v6, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    move-object/from16 v0, p0

    iget v8, v0, Lcom/wishabi/flipp/widget/g;->v:I

    invoke-interface {v7, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    move-object/from16 v0, p0

    iget v10, v0, Lcom/wishabi/flipp/widget/g;->u:I

    invoke-interface {v8, v10}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    move-object/from16 v0, p0

    iget-boolean v10, v0, Lcom/wishabi/flipp/widget/g;->g:Z

    if-eqz v10, :cond_3

    sget v10, Lcom/wishabi/flipp/widget/f;->b:I

    :goto_2
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/wishabi/flipp/widget/g;->c:Ljava/util/HashMap;

    if-nez v11, :cond_4

    const/4 v11, 0x0

    :goto_3
    move-object/from16 v0, p0

    iget-boolean v12, v0, Lcom/wishabi/flipp/widget/g;->g:Z

    if-eqz v12, :cond_5

    const/4 v12, 0x0

    :goto_4
    invoke-static/range {v2 .. v12}, Lcom/wishabi/flipp/widget/aw;->a(Landroid/content/Context;Lcom/wishabi/flipp/widget/a;Lb/a/a/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V

    .line 212
    :goto_5
    return-object v3

    .line 169
    :cond_1
    new-instance v3, Lcom/wishabi/flipp/widget/a;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/g;->k:Landroid/content/Context;

    invoke-direct {v3, v2}, Lcom/wishabi/flipp/widget/a;-><init>(Landroid/content/Context;)V

    goto :goto_0

    .line 176
    :cond_2
    const/4 v4, 0x0

    goto :goto_1

    .line 179
    :cond_3
    sget v10, Lcom/wishabi/flipp/widget/f;->a:I

    goto :goto_2

    :cond_4
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/wishabi/flipp/widget/g;->c:Ljava/util/HashMap;

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/ArrayList;

    goto :goto_3

    :cond_5
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/wishabi/flipp/widget/g;->m:Lcom/wishabi/flipp/app/dn;

    goto :goto_4

    .line 195
    :pswitch_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    move/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v2

    if-nez v2, :cond_6

    .line 196
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Couldn\'t move cursor to position "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move/from16 v0, p2

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 199
    :cond_6
    if-eqz p3, :cond_7

    check-cast p3, Lcom/wishabi/flipp/widget/CouponCell;

    move-object/from16 v8, p3

    .line 202
    :goto_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    move-object/from16 v0, p0

    iget v3, v0, Lcom/wishabi/flipp/widget/g;->i:I

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    .line 204
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/wishabi/flipp/widget/g;->k:Landroid/content/Context;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/wishabi/flipp/widget/g;->l:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    const/4 v11, 0x0

    const/4 v12, 0x1

    move-object/from16 v0, p0

    iget-boolean v3, v0, Lcom/wishabi/flipp/widget/g;->g:Z

    if-eqz v3, :cond_8

    sget v13, Lcom/wishabi/flipp/widget/z;->d:I

    :goto_7
    const/16 v3, 0x104

    invoke-static {v3}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v14

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/widget/g;->d:Ljava/util/HashMap;

    if-eqz v3, :cond_9

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/widget/g;->d:Ljava/util/HashMap;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    move-object v15, v2

    :goto_8
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/wishabi/flipp/widget/g;->g:Z

    if-eqz v2, :cond_a

    const/16 v16, 0x0

    :goto_9
    invoke-static/range {v6 .. v16}, Lcom/wishabi/flipp/widget/aw;->a(Landroid/content/Context;Ljava/lang/String;Lcom/wishabi/flipp/widget/CouponCell;ILandroid/database/Cursor;ZZIILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V

    move-object v3, v8

    .line 212
    goto/16 :goto_5

    .line 199
    :cond_7
    new-instance v8, Lcom/wishabi/flipp/widget/CouponCell;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/g;->k:Landroid/content/Context;

    invoke-direct {v8, v2}, Lcom/wishabi/flipp/widget/CouponCell;-><init>(Landroid/content/Context;)V

    goto :goto_6

    .line 204
    :cond_8
    sget v13, Lcom/wishabi/flipp/widget/z;->a:I

    goto :goto_7

    :cond_9
    const/4 v15, 0x0

    goto :goto_8

    :cond_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/wishabi/flipp/widget/g;->m:Lcom/wishabi/flipp/app/dn;

    move-object/from16 v16, v0

    goto :goto_9

    .line 163
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected final a(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3

    .prologue
    .line 222
    check-cast p2, Landroid/widget/TextView;

    .line 223
    if-nez p2, :cond_1

    .line 224
    iget-object v0, p0, Lcom/wishabi/flipp/widget/g;->k:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f03002b

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p3, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 227
    :goto_0
    if-eqz v0, :cond_0

    .line 228
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/g;->b(I)I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 239
    :cond_0
    :goto_1
    return-object v0

    .line 230
    :pswitch_0
    invoke-static {}, Lcom/wishabi/flipp/util/q;->b()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 234
    :pswitch_1
    const v1, 0x7f0e0086

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1

    :cond_1
    move-object v0, p2

    goto :goto_0

    .line 228
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public final a(I)Ljava/lang/Object;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 138
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1, p1}, Lcom/wishabi/flipp/util/l;->c(I)Lcom/wishabi/flipp/util/o;

    move-result-object v1

    .line 139
    iget v2, v1, Lcom/wishabi/flipp/util/o;->c:I

    sub-int v2, p1, v2

    .line 141
    iget v1, v1, Lcom/wishabi/flipp/util/o;->b:I

    packed-switch v1, :pswitch_data_0

    .line 153
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid position idx"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 143
    :pswitch_0
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lt v2, v1, :cond_1

    .line 151
    :cond_0
    :goto_0
    return-object v0

    .line 145
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    invoke-interface {v0, v2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 146
    iget-object v0, p0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    goto :goto_0

    .line 148
    :pswitch_1
    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-ge v2, v1, :cond_0

    .line 150
    iget-object v0, p0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    invoke-interface {v0, v2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 151
    iget-object v0, p0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    goto :goto_0

    .line 141
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public final b(I)I
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/wishabi/flipp/widget/g;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->b(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    iget v0, v0, Lcom/wishabi/flipp/util/o;->b:I

    return v0
.end method

.method protected final c(I)I
    .locals 1

    .prologue
    .line 264
    iget-object v0, p0, Lcom/wishabi/flipp/widget/g;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->b(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    iget v0, v0, Lcom/wishabi/flipp/util/o;->d:I

    return v0
.end method

.method protected final d(I)I
    .locals 1

    .prologue
    .line 269
    const/4 v0, 0x2

    return v0
.end method

.method public final getViewTypeCount()I
    .locals 1

    .prologue
    .line 274
    const/4 v0, 0x3

    return v0
.end method
