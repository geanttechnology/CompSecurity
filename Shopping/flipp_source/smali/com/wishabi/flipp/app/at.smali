.class final Lcom/wishabi/flipp/app/at;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/ec;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FeaturedFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FeaturedFragment;)V
    .locals 0

    .prologue
    .line 433
    iput-object p1, p0, Lcom/wishabi/flipp/app/at;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(II)Z
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 437
    if-ne p1, p2, :cond_0

    .line 457
    :goto_0
    return v0

    .line 440
    :cond_0
    packed-switch p2, :pswitch_data_0

    goto :goto_0

    .line 442
    :pswitch_0
    iget-object v1, p0, Lcom/wishabi/flipp/app/at;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    sget-object v2, Lcom/wishabi/flipp/widget/cb;->a:Lcom/wishabi/flipp/widget/cb;

    invoke-static {v1, v2}, Lcom/wishabi/flipp/app/FeaturedFragment;->a(Lcom/wishabi/flipp/app/FeaturedFragment;Lcom/wishabi/flipp/widget/cb;)V

    .line 453
    :goto_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/at;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/FeaturedFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v1

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/wishabi/flipp/app/at;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-virtual {v1, v0, v2, v3}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 455
    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v2, p0, Lcom/wishabi/flipp/app/at;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-static {v2}, Lcom/wishabi/flipp/app/FeaturedFragment;->c(Lcom/wishabi/flipp/app/FeaturedFragment;)Lcom/wishabi/flipp/widget/cb;

    move-result-object v2

    invoke-static {v2}, Lcom/wishabi/flipp/app/FeaturedFragment;->a(Lcom/wishabi/flipp/widget/cb;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    const-string v4, "sort"

    invoke-virtual {v3, v4, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v4, "change_sort"

    invoke-virtual {v1, v4, v3, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    const-string v0, "Home"

    const-string v3, "Home | Sort Changed"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Home | Sort Changed | SORT "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v3, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 457
    const/4 v0, 0x1

    goto :goto_0

    .line 445
    :pswitch_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/at;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    sget-object v2, Lcom/wishabi/flipp/widget/cb;->b:Lcom/wishabi/flipp/widget/cb;

    invoke-static {v1, v2}, Lcom/wishabi/flipp/app/FeaturedFragment;->a(Lcom/wishabi/flipp/app/FeaturedFragment;Lcom/wishabi/flipp/widget/cb;)V

    goto :goto_1

    .line 448
    :pswitch_2
    iget-object v1, p0, Lcom/wishabi/flipp/app/at;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    sget-object v2, Lcom/wishabi/flipp/widget/cb;->c:Lcom/wishabi/flipp/widget/cb;

    invoke-static {v1, v2}, Lcom/wishabi/flipp/app/FeaturedFragment;->a(Lcom/wishabi/flipp/app/FeaturedFragment;Lcom/wishabi/flipp/widget/cb;)V

    goto :goto_1

    .line 440
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
