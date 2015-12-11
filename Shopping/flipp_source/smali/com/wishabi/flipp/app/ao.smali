.class final Lcom/wishabi/flipp/app/ao;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/r;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FeaturedFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FeaturedFragment;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/wishabi/flipp/app/ao;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/wishabi/flipp/widget/CollectionView;I)V
    .locals 10

    .prologue
    const/4 v2, 0x0

    .line 145
    iget-object v0, p0, Lcom/wishabi/flipp/app/ao;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FeaturedFragment;->a(Lcom/wishabi/flipp/app/FeaturedFragment;)Lcom/wishabi/flipp/widget/bw;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/wishabi/flipp/widget/bw;->e(I)I

    move-result v3

    .line 147
    iget-object v0, p0, Lcom/wishabi/flipp/app/ao;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FeaturedFragment;->a(Lcom/wishabi/flipp/app/FeaturedFragment;)Lcom/wishabi/flipp/widget/bw;

    move-result-object v0

    iget-object v0, v0, Lcom/wishabi/flipp/widget/bw;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    move v1, v2

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/by;

    iget v5, v0, Lcom/wishabi/flipp/widget/by;->a:I

    if-ne v5, v3, :cond_2

    .line 149
    :goto_1
    if-eqz v3, :cond_0

    if-ltz v1, :cond_0

    .line 151
    sget-object v0, Lcom/wishabi/flipp/app/av;->a:[I

    add-int/lit8 v3, v3, -0x1

    aget v0, v0, v3

    packed-switch v0, :pswitch_data_0

    .line 159
    const-string v0, "Unknown"

    .line 163
    :goto_2
    sget-object v3, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v4, p0, Lcom/wishabi/flipp/app/ao;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-static {v4}, Lcom/wishabi/flipp/app/FeaturedFragment;->b(Lcom/wishabi/flipp/app/FeaturedFragment;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/wishabi/flipp/app/ao;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-static {v5}, Lcom/wishabi/flipp/app/FeaturedFragment;->c(Lcom/wishabi/flipp/app/FeaturedFragment;)Lcom/wishabi/flipp/widget/cb;

    move-result-object v5

    invoke-virtual {v5}, Lcom/wishabi/flipp/widget/cb;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    sub-int v1, p2, v1

    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    const-string v7, "Category"

    invoke-virtual {v6, v7, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v7, "Sort"

    invoke-virtual {v6, v7, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v7, "Placement"

    invoke-virtual {v6, v7, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v7, "Position"

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v7, "flyer_click"

    invoke-virtual {v3, v7, v6, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    const-string v6, "Flyer Clicked"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "Flyer Clicked | "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    const-string v8, "Flyer Clicked | %s | SORT %s | PLACE %s"

    const/4 v9, 0x3

    new-array v9, v9, [Ljava/lang/Object;

    aput-object v4, v9, v2

    const/4 v4, 0x1

    aput-object v5, v9, v4

    const/4 v4, 0x2

    aput-object v0, v9, v4

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    int-to-long v4, v1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v3, v6, v7, v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V

    .line 168
    :cond_0
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 169
    if-nez v0, :cond_4

    .line 185
    :cond_1
    :goto_3
    return-void

    .line 147
    :cond_2
    iget v0, v0, Lcom/wishabi/flipp/widget/by;->b:I

    add-int/2addr v0, v1

    move v1, v0

    goto/16 :goto_0

    :cond_3
    const/4 v1, -0x1

    goto/16 :goto_1

    .line 153
    :pswitch_0
    const-string v0, "Promoted"

    goto :goto_2

    .line 156
    :pswitch_1
    const-string v0, "Organic"

    goto :goto_2

    .line 172
    :cond_4
    invoke-interface {v0, p2}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    .line 173
    if-eqz v0, :cond_1

    .line 176
    iget-object v1, p0, Lcom/wishabi/flipp/app/ao;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/FeaturedFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 177
    if-eqz v1, :cond_1

    .line 180
    new-instance v3, Lcom/wishabi/flipp/content/FlyerActivityIntent;

    invoke-direct {v3, v1, v0}, Lcom/wishabi/flipp/content/FlyerActivityIntent;-><init>(Landroid/content/Context;Landroid/database/Cursor;)V

    invoke-virtual {v1, v3, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 183
    const v0, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_3

    .line 151
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
