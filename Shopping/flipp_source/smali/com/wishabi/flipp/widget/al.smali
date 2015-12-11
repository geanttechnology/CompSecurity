.class public final Lcom/wishabi/flipp/widget/al;
.super Lcom/wishabi/flipp/widget/da;
.source "SourceFile"


# instance fields
.field final a:Lcom/wishabi/flipp/util/l;

.field private final b:Landroid/content/Context;

.field private final c:Landroid/database/Cursor;

.field private final d:Landroid/database/Cursor;

.field private final e:Ljava/util/HashMap;
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

.field private final f:I

.field private final g:I

.field private final h:I

.field private final i:Ljava/lang/String;

.field private final k:Z

.field private final l:Lcom/wishabi/flipp/widget/ZeroCaseView;

.field private final m:Lcom/wishabi/flipp/widget/ec;

.field private final n:Lcom/wishabi/flipp/app/dn;

.field private final o:Lcom/wishabi/flipp/app/dn;

.field private p:I

.field private q:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/database/Cursor;Ljava/util/HashMap;IIIZLcom/wishabi/flipp/widget/ZeroCaseView;Lcom/wishabi/flipp/widget/ec;Lcom/wishabi/flipp/app/dn;Lcom/wishabi/flipp/app/dn;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/database/Cursor;",
            "Landroid/database/Cursor;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;>;IIIZ",
            "Lcom/wishabi/flipp/widget/ZeroCaseView;",
            "Lcom/wishabi/flipp/widget/ec;",
            "Lcom/wishabi/flipp/app/dn;",
            "Lcom/wishabi/flipp/app/dn;",
            ")V"
        }
    .end annotation

    .prologue
    .line 70
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/da;-><init>()V

    .line 57
    new-instance v0, Lcom/wishabi/flipp/util/l;

    invoke-direct {v0}, Lcom/wishabi/flipp/util/l;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    .line 58
    const/4 v0, -0x1

    iput v0, p0, Lcom/wishabi/flipp/widget/al;->p:I

    .line 59
    const/4 v0, -0x1

    iput v0, p0, Lcom/wishabi/flipp/widget/al;->q:I

    .line 72
    iput-object p1, p0, Lcom/wishabi/flipp/widget/al;->b:Landroid/content/Context;

    .line 73
    iput-object p2, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    .line 74
    iput-object p3, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    .line 75
    iput-object p4, p0, Lcom/wishabi/flipp/widget/al;->e:Ljava/util/HashMap;

    .line 76
    iput p5, p0, Lcom/wishabi/flipp/widget/al;->f:I

    .line 77
    iput p6, p0, Lcom/wishabi/flipp/widget/al;->g:I

    .line 78
    iput p7, p0, Lcom/wishabi/flipp/widget/al;->h:I

    .line 79
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/al;->i:Ljava/lang/String;

    .line 80
    iput-boolean p8, p0, Lcom/wishabi/flipp/widget/al;->k:Z

    .line 81
    iput-object p9, p0, Lcom/wishabi/flipp/widget/al;->l:Lcom/wishabi/flipp/widget/ZeroCaseView;

    .line 82
    iput-object p10, p0, Lcom/wishabi/flipp/widget/al;->m:Lcom/wishabi/flipp/widget/ec;

    .line 83
    iput-object p11, p0, Lcom/wishabi/flipp/widget/al;->n:Lcom/wishabi/flipp/app/dn;

    .line 84
    iput-object p12, p0, Lcom/wishabi/flipp/widget/al;->o:Lcom/wishabi/flipp/app/dn;

    .line 86
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    const-string v1, "_id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/al;->p:I

    .line 89
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    if-eqz v0, :cond_1

    .line 90
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    const-string v1, "_id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/al;->q:I

    .line 92
    :cond_1
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/wishabi/flipp/util/o;->a(II)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    const/4 v1, -0x1

    iput v1, v0, Lcom/wishabi/flipp/util/o;->d:I

    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_2

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    const-string v2, "Clippings"

    invoke-static {v0, v1, v2}, Lcom/wishabi/flipp/util/o;->a(IILjava/lang/String;)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    const/4 v1, 0x1

    iput v1, v0, Lcom/wishabi/flipp/util/o;->d:I

    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_3

    const/4 v0, 0x2

    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    const-string v2, "Coupons"

    invoke-static {v0, v1, v2}, Lcom/wishabi/flipp/util/o;->a(IILjava/lang/String;)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    const/4 v1, 0x2

    iput v1, v0, Lcom/wishabi/flipp/util/o;->d:I

    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/l;->b()I

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->l:Lcom/wishabi/flipp/widget/ZeroCaseView;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/l;->a()V

    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/util/o;->a(II)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    const/4 v1, 0x5

    iput v1, v0, Lcom/wishabi/flipp/util/o;->d:I

    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/util/l;->a(Lcom/wishabi/flipp/util/o;)V

    :cond_4
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/l;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/o;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_5
    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/widget/al;->a(Ljava/util/List;)V

    .line 93
    return-void
.end method


# virtual methods
.method public final a(II)I
    .locals 1

    .prologue
    .line 244
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/widget/al;->b(II)I

    move-result v0

    return v0
.end method

.method protected final a(IILandroid/view/View;)Landroid/view/View;
    .locals 11

    .prologue
    const/4 v9, 0x0

    const/16 v8, 0x104

    const/4 v6, 0x1

    .line 160
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/al;->c(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 200
    :pswitch_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid section id requested"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 162
    :pswitch_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "SearchAdapter is is asking for item in the tab bar section.  The tab bar should be a header"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 165
    :pswitch_2
    iget-object v2, p0, Lcom/wishabi/flipp/widget/al;->l:Lcom/wishabi/flipp/widget/ZeroCaseView;

    .line 197
    :goto_0
    return-object v2

    .line 167
    :pswitch_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    invoke-interface {v0, p2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 168
    if-eqz p3, :cond_1

    check-cast p3, Lcom/wishabi/flipp/widget/CouponCell;

    move-object v2, p3

    .line 171
    :goto_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    iget v1, p0, Lcom/wishabi/flipp/widget/al;->q:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    .line 173
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->b:Landroid/content/Context;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->i:Ljava/lang/String;

    iget-object v4, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    const/4 v5, 0x0

    sget v7, Lcom/wishabi/flipp/widget/z;->a:I

    invoke-static {v8}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v8

    iget-object v10, p0, Lcom/wishabi/flipp/widget/al;->e:Ljava/util/HashMap;

    if-eqz v10, :cond_0

    iget-object v9, p0, Lcom/wishabi/flipp/widget/al;->e:Ljava/util/HashMap;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v9, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/ArrayList;

    move-object v9, v3

    :cond_0
    iget-object v10, p0, Lcom/wishabi/flipp/widget/al;->o:Lcom/wishabi/flipp/app/dn;

    move v3, p2

    invoke-static/range {v0 .. v10}, Lcom/wishabi/flipp/widget/aw;->a(Landroid/content/Context;Ljava/lang/String;Lcom/wishabi/flipp/widget/CouponCell;ILandroid/database/Cursor;ZZIILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V

    goto :goto_0

    .line 168
    :cond_1
    new-instance v2, Lcom/wishabi/flipp/widget/CouponCell;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->b:Landroid/content/Context;

    invoke-direct {v2, v0}, Lcom/wishabi/flipp/widget/CouponCell;-><init>(Landroid/content/Context;)V

    goto :goto_1

    .line 183
    :pswitch_4
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    invoke-interface {v0, p2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 185
    if-eqz p3, :cond_3

    check-cast p3, Lcom/wishabi/flipp/widget/CouponCell;

    move-object v2, p3

    .line 188
    :goto_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    iget v1, p0, Lcom/wishabi/flipp/widget/al;->p:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    .line 190
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->b:Landroid/content/Context;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->i:Ljava/lang/String;

    iget-object v4, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    iget-boolean v5, p0, Lcom/wishabi/flipp/widget/al;->k:Z

    sget v7, Lcom/wishabi/flipp/widget/z;->a:I

    invoke-static {v8}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v8

    iget-object v10, p0, Lcom/wishabi/flipp/widget/al;->e:Ljava/util/HashMap;

    if-eqz v10, :cond_2

    iget-object v9, p0, Lcom/wishabi/flipp/widget/al;->e:Ljava/util/HashMap;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v9, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/ArrayList;

    move-object v9, v3

    :cond_2
    iget-object v10, p0, Lcom/wishabi/flipp/widget/al;->n:Lcom/wishabi/flipp/app/dn;

    move v3, p2

    invoke-static/range {v0 .. v10}, Lcom/wishabi/flipp/widget/aw;->a(Landroid/content/Context;Ljava/lang/String;Lcom/wishabi/flipp/widget/CouponCell;ILandroid/database/Cursor;ZZIILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V

    goto :goto_0

    .line 185
    :cond_3
    new-instance v2, Lcom/wishabi/flipp/widget/CouponCell;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->b:Landroid/content/Context;

    invoke-direct {v2, v0}, Lcom/wishabi/flipp/widget/CouponCell;-><init>(Landroid/content/Context;)V

    goto :goto_2

    .line 160
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method protected final a(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 206
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/al;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 231
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "invalid section type requested"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 208
    :pswitch_0
    if-eqz p2, :cond_1

    .line 229
    :cond_0
    :goto_0
    return-object p2

    .line 210
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->b:Landroid/content/Context;

    iget v1, p0, Lcom/wishabi/flipp/widget/al;->f:I

    iget v2, p0, Lcom/wishabi/flipp/widget/al;->g:I

    iget v3, p0, Lcom/wishabi/flipp/widget/al;->h:I

    iget-object v4, p0, Lcom/wishabi/flipp/widget/al;->m:Lcom/wishabi/flipp/widget/ec;

    invoke-static {v0, v1, v2, v3, v4}, Lcom/wishabi/flipp/app/eo;->a(Landroid/content/Context;IIILcom/wishabi/flipp/widget/ec;)Lcom/wishabi/flipp/widget/dz;

    move-result-object p2

    goto :goto_0

    .line 213
    :pswitch_1
    if-nez p2, :cond_0

    .line 216
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->b:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f030009

    invoke-virtual {v0, v1, p3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    goto :goto_0

    .line 219
    :pswitch_2
    check-cast p2, Landroid/widget/TextView;

    .line 220
    if-nez p2, :cond_2

    .line 221
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->b:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f03002b

    invoke-virtual {v0, v1, p3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 224
    :goto_1
    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v2, 0x7f0d0000

    iget-object v3, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    invoke-interface {v3}, Landroid/database/Cursor;->getCount()I

    move-result v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    invoke-interface {v5}, Landroid/database/Cursor;->getCount()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 228
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    move-object p2, v0

    .line 229
    goto :goto_0

    :cond_2
    move-object v0, p2

    goto :goto_1

    .line 206
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final a(I)Ljava/lang/Object;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 136
    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1, p1}, Lcom/wishabi/flipp/util/l;->c(I)Lcom/wishabi/flipp/util/o;

    move-result-object v1

    .line 137
    iget v2, v1, Lcom/wishabi/flipp/util/o;->c:I

    sub-int v2, p1, v2

    .line 139
    iget v1, v1, Lcom/wishabi/flipp/util/o;->b:I

    packed-switch v1, :pswitch_data_0

    .line 153
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid position idx"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 141
    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->l:Lcom/wishabi/flipp/widget/ZeroCaseView;

    .line 151
    :cond_0
    :goto_0
    return-object v0

    .line 143
    :pswitch_1
    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-ge v2, v1, :cond_0

    .line 145
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    invoke-interface {v0, v2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 146
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->d:Landroid/database/Cursor;

    goto :goto_0

    .line 148
    :pswitch_2
    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-ge v2, v1, :cond_0

    .line 150
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    invoke-interface {v0, v2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 151
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->c:Landroid/database/Cursor;

    goto :goto_0

    .line 139
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final b(I)I
    .locals 1

    .prologue
    .line 248
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->b(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    iget v0, v0, Lcom/wishabi/flipp/util/o;->b:I

    return v0
.end method

.method protected final c(I)I
    .locals 1

    .prologue
    .line 253
    iget-object v0, p0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->b(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    iget v0, v0, Lcom/wishabi/flipp/util/o;->d:I

    return v0
.end method

.method protected final d(I)I
    .locals 2

    .prologue
    .line 258
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/al;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 266
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid search section"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 260
    :pswitch_0
    const/4 v0, 0x0

    .line 264
    :goto_0
    return v0

    .line 262
    :pswitch_1
    const/4 v0, 0x4

    goto :goto_0

    .line 264
    :pswitch_2
    const/4 v0, 0x3

    goto :goto_0

    .line 258
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final getViewTypeCount()I
    .locals 1

    .prologue
    .line 272
    const/4 v0, 0x6

    return v0
.end method
