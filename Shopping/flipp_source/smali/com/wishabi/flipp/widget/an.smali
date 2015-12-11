.class public final Lcom/wishabi/flipp/widget/an;
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
.field private final c:Landroid/content/Context;

.field private final d:Ljava/lang/String;

.field private final e:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;"
        }
    .end annotation
.end field

.field private final f:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;"
        }
    .end annotation
.end field

.field private final g:Ljava/util/HashMap;
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

.field private final h:Lcom/wishabi/flipp/app/dn;

.field private final i:I

.field private final j:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Ljava/util/HashMap;Lcom/wishabi/flipp/app/dn;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;",
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
    const/4 v2, 0x0

    .line 88
    invoke-direct {p0}, Landroid/support/v7/widget/an;-><init>()V

    .line 91
    if-nez p4, :cond_0

    .line 96
    new-instance p4, Ljava/util/HashMap;

    invoke-direct {p4}, Ljava/util/HashMap;-><init>()V

    .line 98
    :cond_0
    iput-object p1, p0, Lcom/wishabi/flipp/widget/an;->c:Landroid/content/Context;

    .line 99
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/an;->d:Ljava/lang/String;

    .line 100
    iput-object p2, p0, Lcom/wishabi/flipp/widget/an;->e:Ljava/util/List;

    .line 101
    iput-object p3, p0, Lcom/wishabi/flipp/widget/an;->f:Ljava/util/List;

    .line 102
    iput-object p4, p0, Lcom/wishabi/flipp/widget/an;->g:Ljava/util/HashMap;

    .line 103
    iput-object p5, p0, Lcom/wishabi/flipp/widget/an;->h:Lcom/wishabi/flipp/app/dn;

    .line 109
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v1, v2

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/c;

    .line 110
    iget v0, v0, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 112
    if-eqz v0, :cond_5

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_5

    .line 113
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/2addr v0, v1

    :goto_1
    move v1, v0

    .line 115
    goto :goto_0

    .line 118
    :cond_1
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/c;

    .line 119
    iget v0, v0, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p4, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 121
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_2

    .line 122
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/2addr v1, v0

    goto :goto_2

    .line 126
    :cond_3
    iput v1, p0, Lcom/wishabi/flipp/widget/an;->i:I

    .line 127
    iget v0, p0, Lcom/wishabi/flipp/widget/an;->i:I

    if-lez v0, :cond_4

    const/4 v2, 0x1

    :cond_4
    iput-boolean v2, p0, Lcom/wishabi/flipp/widget/an;->j:Z

    .line 132
    return-void

    :cond_5
    move v0, v1

    goto :goto_1
.end method


# virtual methods
.method public final a()I
    .locals 2

    .prologue
    .line 251
    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->e:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/an;->f:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v1, v0

    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/an;->j:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final a(I)I
    .locals 1

    .prologue
    .line 136
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/an;->j:Z

    if-eqz v0, :cond_1

    .line 137
    if-nez p1, :cond_0

    .line 138
    const/4 v0, 0x0

    .line 149
    :goto_0
    return v0

    .line 140
    :cond_0
    add-int/lit8 p1, p1, -0x1

    .line 143
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->e:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge p1, v0, :cond_2

    .line 144
    const/4 v0, 0x1

    goto :goto_0

    .line 146
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->e:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ne p1, v0, :cond_3

    .line 147
    const/4 v0, 0x2

    goto :goto_0

    .line 149
    :cond_3
    const/4 v0, 0x3

    goto :goto_0
.end method

.method public final a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/bi;
    .locals 6

    .prologue
    const/4 v5, -0x2

    const/4 v4, 0x0

    const/4 v3, -0x1

    .line 155
    packed-switch p2, :pswitch_data_0

    .line 201
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 157
    :pswitch_0
    new-instance v1, Lcom/wishabi/flipp/widget/u;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->c:Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/wishabi/flipp/widget/u;-><init>(Landroid/content/Context;)V

    .line 159
    const/4 v0, 0x5

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 160
    new-instance v2, Landroid/support/v7/widget/av;

    invoke-direct {v2, v3, v5}, Landroid/support/v7/widget/av;-><init>(II)V

    .line 163
    invoke-virtual {v2, v4, v4, v4, v0}, Landroid/support/v7/widget/av;->setMargins(IIII)V

    .line 164
    invoke-virtual {v1, v2}, Lcom/wishabi/flipp/widget/u;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 166
    new-instance v0, Lcom/wishabi/flipp/widget/ao;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/widget/ao;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 169
    :pswitch_1
    new-instance v1, Lcom/wishabi/flipp/widget/cd;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->c:Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/wishabi/flipp/widget/cd;-><init>(Landroid/content/Context;)V

    .line 171
    new-instance v0, Landroid/support/v7/widget/av;

    const/16 v2, 0xd2

    invoke-static {v2}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v2

    invoke-direct {v0, v3, v2}, Landroid/support/v7/widget/av;-><init>(II)V

    .line 174
    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/cd;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 176
    new-instance v0, Lcom/wishabi/flipp/widget/aq;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/widget/aq;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 179
    :pswitch_2
    new-instance v1, Landroid/view/View;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->c:Landroid/content/Context;

    invoke-direct {v1, v0}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 181
    new-instance v0, Landroid/support/v7/widget/av;

    invoke-direct {v0, v3, v4}, Landroid/support/v7/widget/av;-><init>(II)V

    .line 183
    invoke-virtual {v1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 185
    new-instance v0, Lcom/wishabi/flipp/widget/ar;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/widget/ar;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 188
    :pswitch_3
    new-instance v1, Lcom/wishabi/flipp/widget/CouponCell;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->c:Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/wishabi/flipp/widget/CouponCell;-><init>(Landroid/content/Context;)V

    .line 190
    new-instance v0, Landroid/support/v7/widget/av;

    invoke-direct {v0, v3, v5}, Landroid/support/v7/widget/av;-><init>(II)V

    .line 193
    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/CouponCell;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 194
    const/16 v0, 0x104

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/CouponCell;->setContainerHeight(I)V

    .line 197
    new-instance v0, Lcom/wishabi/flipp/widget/ap;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/widget/ap;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 155
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public final a(Landroid/support/v7/widget/bi;I)V
    .locals 12

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 206
    invoke-virtual {p0, p2}, Lcom/wishabi/flipp/widget/an;->a(I)I

    move-result v0

    .line 207
    packed-switch v0, :pswitch_data_0

    .line 242
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 209
    :pswitch_1
    check-cast p1, Lcom/wishabi/flipp/widget/ao;

    .line 210
    iget-object v0, p1, Lcom/wishabi/flipp/widget/ao;->k:Lcom/wishabi/flipp/widget/u;

    iget v1, p0, Lcom/wishabi/flipp/widget/an;->i:I

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/u;->setCount(I)V

    goto :goto_0

    .line 214
    :pswitch_2
    invoke-virtual {p0, p2}, Lcom/wishabi/flipp/widget/an;->d(I)Lcom/wishabi/flipp/content/c;

    move-result-object v4

    .line 215
    if-eqz v4, :cond_0

    .line 216
    check-cast p1, Lcom/wishabi/flipp/widget/aq;

    .line 219
    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->g:Ljava/util/HashMap;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->g:Ljava/util/HashMap;

    iget v1, v4, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    move-object v6, v0

    .line 222
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->c:Landroid/content/Context;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/an;->d:Ljava/lang/String;

    iget-object v2, p1, Lcom/wishabi/flipp/widget/aq;->k:Lcom/wishabi/flipp/widget/cd;

    const/16 v3, 0xd2

    invoke-static {v3}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v5

    iget-object v7, p0, Lcom/wishabi/flipp/widget/an;->h:Lcom/wishabi/flipp/app/dn;

    move v3, p2

    invoke-static/range {v0 .. v7}, Lcom/wishabi/flipp/widget/aw;->a(Landroid/content/Context;Ljava/lang/String;Lcom/wishabi/flipp/widget/cd;ILcom/wishabi/flipp/content/c;ILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V

    goto :goto_0

    .line 229
    :pswitch_3
    invoke-virtual {p0, p2}, Lcom/wishabi/flipp/widget/an;->d(I)Lcom/wishabi/flipp/content/c;

    move-result-object v4

    .line 230
    if-eqz v4, :cond_0

    .line 231
    check-cast p1, Lcom/wishabi/flipp/widget/ap;

    .line 234
    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->g:Ljava/util/HashMap;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->g:Ljava/util/HashMap;

    iget v1, v4, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    move-object v10, v0

    .line 237
    :goto_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->c:Landroid/content/Context;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/an;->d:Ljava/lang/String;

    iget-object v2, p1, Lcom/wishabi/flipp/widget/ap;->k:Lcom/wishabi/flipp/widget/CouponCell;

    sget v7, Lcom/wishabi/flipp/widget/z;->a:I

    const/16 v3, 0x104

    invoke-static {v3}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v9

    iget-object v11, p0, Lcom/wishabi/flipp/widget/an;->h:Lcom/wishabi/flipp/app/dn;

    move v3, p2

    move v6, v5

    move v8, v5

    invoke-static/range {v0 .. v11}, Lcom/wishabi/flipp/widget/aw;->a(Landroid/content/Context;Ljava/lang/String;Lcom/wishabi/flipp/widget/CouponCell;ILcom/wishabi/flipp/content/c;ZZIZILjava/util/ArrayList;Lcom/wishabi/flipp/app/dn;)V

    goto :goto_0

    :cond_2
    move-object v10, v6

    .line 234
    goto :goto_1

    .line 207
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public final d(I)Lcom/wishabi/flipp/content/c;
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 256
    iget-boolean v1, p0, Lcom/wishabi/flipp/widget/an;->j:Z

    if-eqz v1, :cond_2

    .line 257
    if-nez p1, :cond_1

    .line 273
    :cond_0
    :goto_0
    return-object v0

    .line 260
    :cond_1
    add-int/lit8 p1, p1, -0x1

    .line 263
    :cond_2
    iget-object v1, p0, Lcom/wishabi/flipp/widget/an;->e:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge p1, v1, :cond_3

    .line 264
    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->e:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/c;

    goto :goto_0

    .line 267
    :cond_3
    iget-object v1, p0, Lcom/wishabi/flipp/widget/an;->e:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-eq p1, v1, :cond_0

    .line 271
    iget-object v0, p0, Lcom/wishabi/flipp/widget/an;->e:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    sub-int v0, p1, v0

    add-int/lit8 v0, v0, -0x1

    .line 273
    iget-object v1, p0, Lcom/wishabi/flipp/widget/an;->f:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/c;

    goto :goto_0
.end method
