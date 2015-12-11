.class public final Lcom/wishabi/flipp/widget/ci;
.super Lcom/wishabi/flipp/widget/da;
.source "SourceFile"


# static fields
.field private static final f:Lb/a/a/i;


# instance fields
.field final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/ai;",
            ">;"
        }
    .end annotation
.end field

.field final b:Landroid/database/Cursor;

.field final c:Lcom/wishabi/flipp/content/ae;

.field final d:Ljava/util/HashMap;
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

.field final e:Lcom/wishabi/flipp/util/l;

.field private final g:Landroid/util/SparseBooleanArray;

.field private final h:Landroid/database/Cursor;

.field private final i:Lcom/wishabi/flipp/widget/ZeroCaseView;

.field private final k:Landroid/content/Context;

.field private final l:Lcom/wishabi/flipp/app/dn;

.field private final m:Lcom/wishabi/flipp/app/dn;

.field private final n:Lcom/wishabi/flipp/widget/ec;

.field private final o:I

.field private final p:I

.field private final q:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    const-string v0, "America/Toronto"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Lb/a/a/i;->a(Ljava/util/TimeZone;)Lb/a/a/i;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/widget/ci;->f:Lb/a/a/i;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/database/Cursor;Lcom/wishabi/flipp/content/ae;Ljava/util/List;Landroid/util/SparseBooleanArray;Ljava/util/HashMap;Lcom/wishabi/flipp/widget/ZeroCaseView;Lcom/wishabi/flipp/app/dn;Lcom/wishabi/flipp/app/dn;IIILcom/wishabi/flipp/widget/ec;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/database/Cursor;",
            "Landroid/database/Cursor;",
            "Lcom/wishabi/flipp/content/ae;",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/ai;",
            ">;",
            "Landroid/util/SparseBooleanArray;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;>;",
            "Lcom/wishabi/flipp/widget/ZeroCaseView;",
            "Lcom/wishabi/flipp/app/dn;",
            "Lcom/wishabi/flipp/app/dn;",
            "III",
            "Lcom/wishabi/flipp/widget/ec;",
            ")V"
        }
    .end annotation

    .prologue
    .line 82
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/da;-><init>()V

    .line 61
    new-instance v1, Lcom/wishabi/flipp/util/l;

    invoke-direct {v1}, Lcom/wishabi/flipp/util/l;-><init>()V

    iput-object v1, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    .line 83
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ci;->k:Landroid/content/Context;

    .line 84
    iput-object p2, p0, Lcom/wishabi/flipp/widget/ci;->h:Landroid/database/Cursor;

    .line 85
    iput-object p6, p0, Lcom/wishabi/flipp/widget/ci;->g:Landroid/util/SparseBooleanArray;

    .line 86
    iput-object p3, p0, Lcom/wishabi/flipp/widget/ci;->b:Landroid/database/Cursor;

    .line 87
    iput-object p4, p0, Lcom/wishabi/flipp/widget/ci;->c:Lcom/wishabi/flipp/content/ae;

    .line 88
    iput-object p7, p0, Lcom/wishabi/flipp/widget/ci;->d:Ljava/util/HashMap;

    .line 89
    iput-object p8, p0, Lcom/wishabi/flipp/widget/ci;->i:Lcom/wishabi/flipp/widget/ZeroCaseView;

    .line 90
    iput-object p5, p0, Lcom/wishabi/flipp/widget/ci;->a:Ljava/util/List;

    .line 91
    iput-object p9, p0, Lcom/wishabi/flipp/widget/ci;->l:Lcom/wishabi/flipp/app/dn;

    .line 92
    iput-object p10, p0, Lcom/wishabi/flipp/widget/ci;->m:Lcom/wishabi/flipp/app/dn;

    .line 93
    iput p11, p0, Lcom/wishabi/flipp/widget/ci;->o:I

    .line 94
    move/from16 v0, p12

    iput v0, p0, Lcom/wishabi/flipp/widget/ci;->p:I

    .line 95
    move/from16 v0, p13

    iput v0, p0, Lcom/wishabi/flipp/widget/ci;->q:I

    .line 96
    move-object/from16 v0, p14

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ci;->n:Lcom/wishabi/flipp/widget/ec;

    .line 98
    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/wishabi/flipp/util/o;->a(II)Lcom/wishabi/flipp/util/o;

    move-result-object v1

    .line 100
    const/4 v2, -0x1

    iput v2, v1, Lcom/wishabi/flipp/util/o;->d:I

    .line 101
    iget-object v2, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v2, v1}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    .line 104
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->b:Landroid/database/Cursor;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->b:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_0

    .line 105
    const/4 v1, 0x2

    iget-object v2, p0, Lcom/wishabi/flipp/widget/ci;->b:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v2

    invoke-static {v1, v2}, Lcom/wishabi/flipp/util/o;->a(II)Lcom/wishabi/flipp/util/o;

    move-result-object v1

    .line 107
    const/4 v2, 0x2

    iput v2, v1, Lcom/wishabi/flipp/util/o;->d:I

    .line 108
    iget-object v2, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v2, v1}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    .line 112
    :cond_0
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->h:Landroid/database/Cursor;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->h:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_1

    .line 113
    const/4 v1, 0x1

    iget-object v2, p0, Lcom/wishabi/flipp/widget/ci;->h:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v2

    invoke-static {v1, v2}, Lcom/wishabi/flipp/util/o;->a(II)Lcom/wishabi/flipp/util/o;

    move-result-object v1

    .line 115
    const/4 v2, 0x1

    iput v2, v1, Lcom/wishabi/flipp/util/o;->d:I

    .line 116
    iget-object v2, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v2, v1}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    .line 120
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->a:Ljava/util/List;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    .line 121
    const/4 v1, 0x3

    iget-object v2, p0, Lcom/wishabi/flipp/widget/ci;->a:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-static {v1, v2}, Lcom/wishabi/flipp/util/o;->a(II)Lcom/wishabi/flipp/util/o;

    move-result-object v1

    .line 123
    const/4 v2, 0x3

    iput v2, v1, Lcom/wishabi/flipp/util/o;->d:I

    .line 124
    iget-object v2, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v2, v1}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    .line 128
    :cond_2
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1}, Lcom/wishabi/flipp/util/l;->b()I

    move-result v1

    if-nez v1, :cond_3

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->i:Lcom/wishabi/flipp/widget/ZeroCaseView;

    if-eqz v1, :cond_3

    .line 129
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1}, Lcom/wishabi/flipp/util/l;->a()V

    .line 130
    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/wishabi/flipp/util/o;->a(II)Lcom/wishabi/flipp/util/o;

    move-result-object v1

    .line 132
    const/4 v2, 0x6

    iput v2, v1, Lcom/wishabi/flipp/util/o;->d:I

    .line 133
    iget-object v2, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v2, v1}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    .line 136
    :cond_3
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 137
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1}, Lcom/wishabi/flipp/util/l;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/util/o;

    .line 138
    invoke-virtual {v1}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 140
    :cond_4
    invoke-virtual {p0, v2}, Lcom/wishabi/flipp/widget/ci;->a(Ljava/util/List;)V

    .line 141
    return-void
.end method


# virtual methods
.method protected final a(IILandroid/view/View;)Landroid/view/View;
    .locals 12

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v9, 0x0

    .line 201
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/ci;->c(I)I

    move-result v0

    .line 202
    sget-object v1, Lcom/wishabi/flipp/widget/ci;->f:Lb/a/a/i;

    invoke-static {v1}, Lb/a/a/b;->a(Lb/a/a/i;)Lb/a/a/b;

    move-result-object v4

    .line 204
    packed-switch v0, :pswitch_data_0

    .line 281
    :pswitch_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid section and index for item in search"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 206
    :pswitch_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "SearchAdapter is is asking for item in the tab bar section.  The tab bar should be a header"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 209
    :pswitch_2
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->i:Lcom/wishabi/flipp/widget/ZeroCaseView;

    .line 279
    :goto_0
    return-object v1

    .line 211
    :pswitch_3
    if-eqz p3, :cond_2

    check-cast p3, Lcom/wishabi/flipp/widget/az;

    .line 214
    :goto_1
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/widget/ci;->a(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    .line 215
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "merchant"

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, " "

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, "name"

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p3, v1}, Lcom/wishabi/flipp/widget/az;->setFlyerName(Ljava/lang/String;)V

    .line 219
    const-string v1, "valid_from"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 221
    const-string v5, "valid_to"

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 223
    invoke-static {}, Lb/a/a/d/aa;->a()Lb/a/a/d/d;

    move-result-object v6

    .line 224
    invoke-virtual {v6, v1}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v7

    .line 225
    invoke-virtual {v6, v5}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v6

    .line 227
    if-eqz v1, :cond_0

    if-eqz v5, :cond_0

    .line 228
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->k:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {v1, v7, v4, v6}, Lcom/wishabi/flipp/util/e;->a(Landroid/content/res/Resources;Lb/a/a/b;Lb/a/a/b;Lb/a/a/b;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p3, v1}, Lcom/wishabi/flipp/widget/az;->setFlyerDate(Ljava/lang/String;)V

    .line 231
    :cond_0
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->g:Landroid/util/SparseBooleanArray;

    if-eqz v1, :cond_1

    .line 232
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->g:Landroid/util/SparseBooleanArray;

    const-string v5, "flyer_id"

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v0, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-virtual {v1, v5}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v1

    if-nez v1, :cond_3

    move v1, v2

    :goto_2
    invoke-virtual {p3, v1}, Lcom/wishabi/flipp/widget/az;->setUnread(Z)V

    .line 234
    :cond_1
    invoke-virtual {v4, v7}, Lb/a/a/b;->a(Lb/a/a/z;)I

    move-result v1

    if-gez v1, :cond_4

    :goto_3
    invoke-virtual {p3, v2}, Lcom/wishabi/flipp/widget/az;->setUpcoming(Z)V

    .line 235
    const-string v1, "thumbnail"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Lcom/wishabi/flipp/widget/az;->setThumbnailUrl(Ljava/lang/String;)V

    move-object v1, p3

    .line 237
    goto/16 :goto_0

    .line 211
    :cond_2
    new-instance p3, Lcom/wishabi/flipp/widget/az;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->k:Landroid/content/Context;

    invoke-direct {p3, v0}, Lcom/wishabi/flipp/widget/az;-><init>(Landroid/content/Context;)V

    goto/16 :goto_1

    :cond_3
    move v1, v3

    .line 232
    goto :goto_2

    :cond_4
    move v2, v3

    .line 234
    goto :goto_3

    .line 240
    :pswitch_4
    if-eqz p3, :cond_5

    check-cast p3, Lcom/wishabi/flipp/widget/a;

    move-object v1, p3

    .line 243
    :goto_4
    new-instance v7, Lcom/wishabi/flipp/content/ad;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->b:Landroid/database/Cursor;

    iget-object v2, p0, Lcom/wishabi/flipp/widget/ci;->c:Lcom/wishabi/flipp/content/ae;

    invoke-direct {v7, v0, v2, p2}, Lcom/wishabi/flipp/content/ad;-><init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/ae;I)V

    .line 246
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->k:Landroid/content/Context;

    invoke-static {}, Lb/a/a/d/aa;->a()Lb/a/a/d/d;

    move-result-object v2

    iget-object v3, v7, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget v4, v7, Lcom/wishabi/flipp/content/ad;->c:I

    invoke-interface {v3, v4}, Landroid/database/Cursor;->moveToPosition(I)Z

    iget-object v3, v7, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget-object v4, v7, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    iget v4, v4, Lcom/wishabi/flipp/content/ae;->f:I

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_6

    invoke-virtual {v2, v3}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v2

    :goto_5
    iget-object v3, v7, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget v4, v7, Lcom/wishabi/flipp/content/ad;->c:I

    invoke-interface {v3, v4}, Landroid/database/Cursor;->moveToPosition(I)Z

    iget-object v3, v7, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget-object v4, v7, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    iget v4, v4, Lcom/wishabi/flipp/content/ae;->g:I

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v4, v7, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget v5, v7, Lcom/wishabi/flipp/content/ad;->c:I

    invoke-interface {v4, v5}, Landroid/database/Cursor;->moveToPosition(I)Z

    iget-object v4, v7, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget-object v5, v7, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    iget v5, v5, Lcom/wishabi/flipp/content/ae;->h:I

    invoke-interface {v4, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iget-object v5, v7, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget v6, v7, Lcom/wishabi/flipp/content/ad;->c:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->moveToPosition(I)Z

    iget-object v5, v7, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget-object v6, v7, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    iget v6, v6, Lcom/wishabi/flipp/content/ae;->j:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    iget-object v6, v7, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget v8, v7, Lcom/wishabi/flipp/content/ad;->c:I

    invoke-interface {v6, v8}, Landroid/database/Cursor;->moveToPosition(I)Z

    iget-object v6, v7, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget-object v8, v7, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    iget v8, v8, Lcom/wishabi/flipp/content/ae;->i:I

    invoke-interface {v6, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    sget v8, Lcom/wishabi/flipp/widget/f;->a:I

    iget-object v10, p0, Lcom/wishabi/flipp/widget/ci;->d:Ljava/util/HashMap;

    if-nez v10, :cond_7

    :goto_6
    iget-object v10, p0, Lcom/wishabi/flipp/widget/ci;->m:Lcom/wishabi/flipp/app/dn;

    move v7, p2

    invoke-static/range {v0 .. v10}, Lcom/wishabi/flipp/widget/aw;->a(Landroid/content/Context;Lcom/wishabi/flipp/widget/a;Lb/a/a/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V

    goto/16 :goto_0

    .line 240
    :cond_5
    new-instance v1, Lcom/wishabi/flipp/widget/a;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->k:Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/wishabi/flipp/widget/a;-><init>(Landroid/content/Context;)V

    goto :goto_4

    :cond_6
    move-object v2, v9

    .line 246
    goto :goto_5

    :cond_7
    iget-object v9, p0, Lcom/wishabi/flipp/widget/ci;->d:Ljava/util/HashMap;

    invoke-virtual {v7}, Lcom/wishabi/flipp/content/ad;->e()J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v9, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/ArrayList;

    move-object v9, v7

    goto :goto_6

    .line 263
    :pswitch_5
    if-eqz p3, :cond_8

    check-cast p3, Lcom/wishabi/flipp/widget/a;

    move-object v1, p3

    .line 266
    :goto_7
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/widget/ci;->a(II)Ljava/lang/Object;

    move-result-object v0

    move-object v7, v0

    check-cast v7, Lcom/wishabi/flipp/content/ai;

    .line 267
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->k:Landroid/content/Context;

    iget-object v2, v7, Lcom/wishabi/flipp/content/ai;->i:Lb/a/a/b;

    iget-object v3, v7, Lcom/wishabi/flipp/content/ai;->d:Landroid/net/Uri;

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, v7, Lcom/wishabi/flipp/content/ai;->c:Ljava/lang/String;

    iget-object v5, v7, Lcom/wishabi/flipp/content/ai;->g:Ljava/lang/String;

    iget-object v6, v7, Lcom/wishabi/flipp/content/ai;->f:Ljava/lang/String;

    sget v8, Lcom/wishabi/flipp/widget/f;->a:I

    iget-object v10, p0, Lcom/wishabi/flipp/widget/ci;->d:Ljava/util/HashMap;

    if-nez v10, :cond_9

    :goto_8
    iget-object v10, p0, Lcom/wishabi/flipp/widget/ci;->l:Lcom/wishabi/flipp/app/dn;

    move v7, p2

    invoke-static/range {v0 .. v10}, Lcom/wishabi/flipp/widget/aw;->a(Landroid/content/Context;Lcom/wishabi/flipp/widget/a;Lb/a/a/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V

    goto/16 :goto_0

    .line 263
    :cond_8
    new-instance v1, Lcom/wishabi/flipp/widget/a;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->k:Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/wishabi/flipp/widget/a;-><init>(Landroid/content/Context;)V

    goto :goto_7

    .line 267
    :cond_9
    iget-object v9, p0, Lcom/wishabi/flipp/widget/ci;->d:Ljava/util/HashMap;

    iget-wide v10, v7, Lcom/wishabi/flipp/content/ai;->a:J

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v9, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/ArrayList;

    move-object v9, v7

    goto :goto_8

    .line 204
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method protected final a(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v5, 0x0

    .line 288
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/ci;->b(I)I

    move-result v1

    .line 290
    packed-switch v1, :pswitch_data_0

    .line 316
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid search section"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 292
    :pswitch_0
    if-eqz p2, :cond_1

    .line 313
    :cond_0
    :goto_0
    return-object p2

    .line 294
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->k:Landroid/content/Context;

    iget v1, p0, Lcom/wishabi/flipp/widget/ci;->o:I

    iget v2, p0, Lcom/wishabi/flipp/widget/ci;->p:I

    iget v3, p0, Lcom/wishabi/flipp/widget/ci;->q:I

    iget-object v4, p0, Lcom/wishabi/flipp/widget/ci;->n:Lcom/wishabi/flipp/widget/ec;

    invoke-static {v0, v1, v2, v3, v4}, Lcom/wishabi/flipp/app/eo;->a(Landroid/content/Context;IIILcom/wishabi/flipp/widget/ec;)Lcom/wishabi/flipp/widget/dz;

    move-result-object p2

    goto :goto_0

    .line 298
    :pswitch_1
    check-cast p2, Landroid/widget/TextView;

    .line 299
    if-nez p2, :cond_2

    .line 300
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->k:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v2, 0x7f03002b

    invoke-virtual {v0, v2, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    move-object p2, v0

    .line 303
    :cond_2
    if-ne v1, v3, :cond_3

    invoke-static {}, Lcom/wishabi/flipp/util/q;->b()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 307
    :goto_1
    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 303
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->k:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0d0008

    iget-object v2, p0, Lcom/wishabi/flipp/widget/ci;->a:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/wishabi/flipp/widget/ci;->a:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 310
    :pswitch_2
    if-nez p2, :cond_0

    .line 313
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->k:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f030009

    invoke-virtual {v0, v1, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    goto :goto_0

    .line 290
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method protected final a(I)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 149
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->c(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    .line 150
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    iget-object v1, v1, Lcom/wishabi/flipp/util/l;->a:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v1

    iget v0, v0, Lcom/wishabi/flipp/util/o;->c:I

    sub-int v0, p1, v0

    invoke-virtual {p0, v1, v0}, Lcom/wishabi/flipp/widget/ci;->a(II)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method final a(II)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 159
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->b(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    .line 161
    iget v0, v0, Lcom/wishabi/flipp/util/o;->b:I

    packed-switch v0, :pswitch_data_0

    .line 175
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "invalid section index"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 163
    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->i:Lcom/wishabi/flipp/widget/ZeroCaseView;

    .line 173
    :goto_0
    return-object v0

    .line 165
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->h:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 166
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->h:Landroid/database/Cursor;

    invoke-interface {v0, p2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 167
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->h:Landroid/database/Cursor;

    goto :goto_0

    .line 169
    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->b:Landroid/database/Cursor;

    if-eqz v0, :cond_1

    .line 170
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->b:Landroid/database/Cursor;

    invoke-interface {v0, p2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 171
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->b:Landroid/database/Cursor;

    goto :goto_0

    .line 173
    :pswitch_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 161
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public final b(I)I
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->b(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    iget v0, v0, Lcom/wishabi/flipp/util/o;->b:I

    return v0
.end method

.method protected final c(I)I
    .locals 1

    .prologue
    .line 323
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->b(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    iget v0, v0, Lcom/wishabi/flipp/util/o;->d:I

    return v0
.end method

.method protected final d(I)I
    .locals 2

    .prologue
    .line 328
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/ci;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 338
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid search section"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 331
    :pswitch_0
    const/4 v0, 0x0

    .line 336
    :goto_0
    return v0

    .line 333
    :pswitch_1
    const/4 v0, 0x5

    goto :goto_0

    .line 336
    :pswitch_2
    const/4 v0, 0x4

    goto :goto_0

    .line 328
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final getViewTypeCount()I
    .locals 1

    .prologue
    .line 344
    const/4 v0, 0x7

    return v0
.end method
