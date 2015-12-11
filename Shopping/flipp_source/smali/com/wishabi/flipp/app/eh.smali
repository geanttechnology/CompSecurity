.class final Lcom/wishabi/flipp/app/eh;
.super Lcom/wishabi/flipp/app/dn;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/SearchFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/SearchFragment;)V
    .locals 0

    .prologue
    .line 221
    iput-object p1, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/dn;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 4

    .prologue
    .line 224
    iget-object v0, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->g(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->g(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v0

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->h(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->h(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 239
    :cond_0
    :goto_0
    return-void

    .line 228
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->g(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 231
    iget-object v0, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->g(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->g(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v1

    const-string v2, "_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 232
    iget-object v1, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->h(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;

    move-result-object v1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 234
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 237
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/o;

    .line 238
    iget-object v1, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    iget v2, v0, Lcom/wishabi/flipp/content/o;->b:I

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/o;->a()Landroid/graphics/RectF;

    move-result-object v0

    const/4 v3, 0x0

    invoke-static {v1, v2, v0, v3}, Lcom/wishabi/flipp/app/SearchFragment;->a(Lcom/wishabi/flipp/app/SearchFragment;ILandroid/graphics/RectF;Ljava/lang/Boolean;)Lcom/wishabi/flipp/content/Flyer$Model;

    goto :goto_0
.end method

.method public final b(I)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 243
    iget-object v0, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->g(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->g(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v0

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_1

    .line 253
    :cond_0
    :goto_0
    return-void

    .line 246
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->g(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v0

    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 249
    iget-object v0, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->g(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->g(Lcom/wishabi/flipp/app/SearchFragment;)Landroid/database/Cursor;

    move-result-object v1

    const-string v2, "_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 250
    iget-object v1, p0, Lcom/wishabi/flipp/app/eh;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    new-array v2, v4, [I

    const/4 v3, 0x0

    aput v0, v2, v3

    sget-object v0, Lcom/wishabi/flipp/b/p;->c:Lcom/wishabi/flipp/b/p;

    invoke-static {v1, v2, v4, v0}, Lcom/wishabi/flipp/app/dr;->a(Landroid/app/Activity;[IZLcom/wishabi/flipp/b/p;)I

    goto :goto_0
.end method
