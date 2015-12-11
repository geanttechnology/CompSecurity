.class final Lcom/wishabi/flipp/app/ef;
.super Lcom/wishabi/flipp/app/dn;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/SearchFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/SearchFragment;)V
    .locals 0

    .prologue
    .line 142
    iput-object p1, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/dn;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 7

    .prologue
    .line 146
    iget-object v0, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->b(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->b(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v0

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_1

    .line 153
    :cond_0
    :goto_0
    return-void

    .line 149
    :cond_1
    new-instance v0, Lcom/wishabi/flipp/content/ad;

    iget-object v1, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->b(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v1

    iget-object v2, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v2}, Lcom/wishabi/flipp/app/SearchFragment;->c(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/content/ae;

    move-result-object v2

    invoke-direct {v0, v1, v2, p1}, Lcom/wishabi/flipp/content/ad;-><init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/ae;I)V

    .line 152
    iget-object v1, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    iget-object v2, v0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget v3, v0, Lcom/wishabi/flipp/content/ad;->c:I

    invoke-interface {v2, v3}, Landroid/database/Cursor;->moveToPosition(I)Z

    iget-object v2, v0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget-object v3, v0, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    iget v3, v3, Lcom/wishabi/flipp/content/ae;->k:I

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    new-instance v3, Landroid/graphics/RectF;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/ad;->c()I

    move-result v4

    int-to-float v4, v4

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/ad;->a()I

    move-result v5

    int-to-float v5, v5

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/ad;->d()I

    move-result v6

    int-to-float v6, v6

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/ad;->b()I

    move-result v0

    int-to-float v0, v0

    invoke-direct {v3, v4, v5, v6, v0}, Landroid/graphics/RectF;-><init>(FFFF)V

    const/4 v0, 0x0

    invoke-static {v1, v2, v3, v0}, Lcom/wishabi/flipp/app/SearchFragment;->a(Lcom/wishabi/flipp/app/SearchFragment;ILandroid/graphics/RectF;Ljava/lang/Boolean;)Lcom/wishabi/flipp/content/Flyer$Model;

    goto :goto_0
.end method

.method public final b(I)V
    .locals 4

    .prologue
    .line 157
    iget-object v0, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->e(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->e(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 174
    :cond_0
    :goto_0
    return-void

    .line 161
    :cond_1
    new-instance v0, Lcom/wishabi/flipp/content/ad;

    iget-object v1, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->b(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v1

    iget-object v2, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v2}, Lcom/wishabi/flipp/app/SearchFragment;->c(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/content/ae;

    move-result-object v2

    invoke-direct {v0, v1, v2, p1}, Lcom/wishabi/flipp/content/ad;-><init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/ae;I)V

    .line 164
    iget-object v1, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->e(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/ad;->e()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 167
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 170
    invoke-static {v0}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;)[I

    move-result-object v0

    .line 171
    iget-object v1, p0, Lcom/wishabi/flipp/app/ef;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const/4 v2, 0x0

    sget-object v3, Lcom/wishabi/flipp/b/p;->g:Lcom/wishabi/flipp/b/p;

    invoke-static {v1, v0, v2, v3}, Lcom/wishabi/flipp/app/dr;->a(Landroid/app/Activity;[IZLcom/wishabi/flipp/b/p;)I

    goto :goto_0
.end method
