.class final Lcom/wishabi/flipp/app/eg;
.super Lcom/wishabi/flipp/app/dn;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/SearchFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/SearchFragment;)V
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/dn;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 12

    .prologue
    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 181
    iget-object v0, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 196
    :cond_0
    :goto_0
    return-void

    .line 186
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/ai;

    .line 188
    if-eqz v0, :cond_0

    .line 191
    iget-object v1, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    iget v2, v0, Lcom/wishabi/flipp/content/ai;->b:I

    iget-object v3, v0, Lcom/wishabi/flipp/content/ai;->e:Landroid/graphics/RectF;

    iget-boolean v4, v0, Lcom/wishabi/flipp/content/ai;->h:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v1, v2, v3, v4}, Lcom/wishabi/flipp/app/SearchFragment;->a(Lcom/wishabi/flipp/app/SearchFragment;ILandroid/graphics/RectF;Ljava/lang/Boolean;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v2

    .line 194
    sget-object v3, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-wide v4, v0, Lcom/wishabi/flipp/content/ai;->a:J

    iget-object v0, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->f(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/lang/String;

    move-result-object v1

    if-eqz v2, :cond_0

    const-string v0, " "

    invoke-virtual {v1, v0, v11}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    array-length v6, v0

    if-le v6, v10, :cond_2

    aget-object v6, v0, v9

    invoke-static {v6}, Lcom/wishabi/flipp/util/q;->b(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    aget-object v0, v0, v10

    :goto_1
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    const-string v7, "flyer_id"

    iget v8, v2, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v7, "analytics_payload"

    iget-object v8, v2, Lcom/wishabi/flipp/content/Flyer$Model;->o:Ljava/lang/String;

    invoke-virtual {v6, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v7, "flyer_run_id"

    iget v8, v2, Lcom/wishabi/flipp/content/Flyer$Model;->b:I

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v7, "flyer_type_id"

    iget v8, v2, Lcom/wishabi/flipp/content/Flyer$Model;->c:I

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v7, "merchant_id"

    iget v8, v2, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v7, "flyer_item_id"

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v6, v7, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v4, "q"

    invoke-virtual {v6, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v4, "q_raw"

    invoke-virtual {v6, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "postal_code"

    iget-object v4, v3, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    invoke-virtual {v6, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "rank"

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v6, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "search_hit"

    invoke-virtual {v3, v1, v6, v9}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    const-string v1, "search hit"

    const-string v4, "search hit | %s"

    new-array v5, v10, [Ljava/lang/Object;

    aput-object v0, v5, v9

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "search hit | %s | MER %s | MID %d | FID %d"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v0, v6, v9

    iget-object v0, v2, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v0, v6, v10

    iget v0, v2, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v6, v11

    const/4 v0, 0x3

    iget v2, v2, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v6, v0

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    int-to-long v6, p1

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v3, v1, v4, v0, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V

    goto/16 :goto_0

    :cond_2
    move-object v0, v1

    goto/16 :goto_1
.end method

.method public final b(I)V
    .locals 4

    .prologue
    .line 200
    iget-object v0, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->e(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->e(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 217
    :cond_0
    :goto_0
    return-void

    .line 204
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/ai;

    .line 205
    if-eqz v0, :cond_0

    .line 208
    iget-object v1, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->e(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/HashMap;

    move-result-object v1

    iget-wide v2, v0, Lcom/wishabi/flipp/content/ai;->a:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 210
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 213
    invoke-static {v0}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;)[I

    move-result-object v0

    .line 214
    iget-object v1, p0, Lcom/wishabi/flipp/app/eg;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const/4 v2, 0x0

    sget-object v3, Lcom/wishabi/flipp/b/p;->g:Lcom/wishabi/flipp/b/p;

    invoke-static {v1, v0, v2, v3}, Lcom/wishabi/flipp/app/dr;->a(Landroid/app/Activity;[IZLcom/wishabi/flipp/b/p;)I

    goto :goto_0
.end method
