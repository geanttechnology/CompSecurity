.class final Lcom/wishabi/flipp/app/bh;
.super Landroid/support/v4/view/ch;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)V
    .locals 0

    .prologue
    .line 210
    iput-object p1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-direct {p0}, Landroid/support/v4/view/ch;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 14

    .prologue
    const-wide/16 v12, 0x1f40

    const/4 v10, 0x2

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 213
    iget-object v0, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0, p1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;I)V

    .line 216
    iget-object v0, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v0

    if-eqz v0, :cond_5

    move v0, v2

    .line 220
    :goto_0
    if-eqz v0, :cond_0

    .line 221
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 223
    if-eqz v0, :cond_0

    .line 224
    const-string v1, "tutorial_showed_cross_browse"

    .line 226
    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    .line 227
    if-nez v4, :cond_0

    .line 228
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 232
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)[Landroid/os/Parcelable;

    move-result-object v0

    aget-object v0, v0, p1

    check-cast v0, Lcom/wishabi/flipp/content/Flyer$Model;

    .line 233
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v1, v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Lcom/wishabi/flipp/content/Flyer$Model;)Lcom/wishabi/flipp/content/Flyer$Model;

    .line 234
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    iget-boolean v4, v0, Lcom/wishabi/flipp/content/Flyer$Model;->n:Z

    invoke-static {v1, v4}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Z)Z

    .line 235
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    iget v4, v0, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v1, v4}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;I)I

    .line 236
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    iget v4, v0, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 237
    iget-object v4, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->f(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    move-result-object v1

    invoke-virtual {v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->getAdapter()Landroid/support/v4/view/ae;

    move-result-object v1

    iget-object v5, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v5}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->f(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    move-result-object v5

    iget-object v6, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v6}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->f(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    move-result-object v6

    invoke-virtual {v6}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->getCurrentItem()I

    move-result v6

    invoke-virtual {v1, v5, v6}, Landroid/support/v4/view/ae;->a(Landroid/view/ViewGroup;I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/app/bo;

    invoke-static {v4, v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bo;

    .line 239
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->g(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)V

    .line 241
    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v4, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v4}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->h(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z

    move-result v4

    iput-boolean v4, v1, Lcom/wishabi/flipp/b/a;->r:Z

    .line 242
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->i(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z

    .line 244
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->j(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z

    move-result v1

    if-nez v1, :cond_a

    .line 245
    sget-object v4, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v5

    invoke-virtual {v4}, Lcom/wishabi/flipp/b/a;->b()V

    if-eqz v5, :cond_1

    iput-boolean v3, v4, Lcom/wishabi/flipp/b/a;->d:Z

    const-string v1, "flyerView"

    invoke-virtual {v4, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;)V

    const-string v1, "open"

    const-string v6, "open | MER %s | MID %d"

    new-array v7, v10, [Ljava/lang/Object;

    iget-object v8, v5, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v8, v7, v3

    iget v8, v5, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v2

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "open | MER %s | MID %d | FID %d"

    const/4 v8, 0x3

    new-array v8, v8, [Ljava/lang/Object;

    iget-object v9, v5, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v9, v8, v3

    iget v9, v5, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v2

    iget v9, v5, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v1, v6, v7}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    iput-object v1, v4, Lcom/wishabi/flipp/b/a;->g:Ljava/util/Timer;

    iget-object v1, v4, Lcom/wishabi/flipp/b/a;->g:Ljava/util/Timer;

    new-instance v6, Lcom/wishabi/flipp/b/m;

    invoke-direct {v6, v4, v5}, Lcom/wishabi/flipp/b/m;-><init>(Lcom/wishabi/flipp/b/a;Lcom/wishabi/flipp/content/Flyer$Model;)V

    invoke-virtual {v1, v6, v12, v13}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    sget-object v1, Lcom/wishabi/flipp/b/r;->a:Lcom/wishabi/flipp/b/r;

    invoke-virtual {v4, v5, v1}, Lcom/wishabi/flipp/b/a;->b(Lcom/wishabi/flipp/content/Flyer$Model;Lcom/wishabi/flipp/b/r;)Z

    move-result v6

    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    const-string v1, "flyer_id"

    iget v8, v5, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v1, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "analytics_payload"

    iget-object v8, v5, Lcom/wishabi/flipp/content/Flyer$Model;->o:Ljava/lang/String;

    invoke-virtual {v7, v1, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "flyer_run_id"

    iget v8, v5, Lcom/wishabi/flipp/content/Flyer$Model;->b:I

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v1, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "flyer_type_id"

    iget v8, v5, Lcom/wishabi/flipp/content/Flyer$Model;->c:I

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v1, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "merchant_id"

    iget v8, v5, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v1, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v8, "flipp_premium_merchant"

    iget-boolean v1, v5, Lcom/wishabi/flipp/content/Flyer$Model;->e:Z

    if-eqz v1, :cond_6

    const-string v1, "1"

    :goto_1
    invoke-virtual {v7, v8, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "postal_code"

    iget-object v8, v5, Lcom/wishabi/flipp/content/Flyer$Model;->f:Ljava/lang/String;

    invoke-virtual {v7, v1, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v8, "repeat"

    if-eqz v6, :cond_7

    const-string v1, "1"

    :goto_2
    invoke-virtual {v7, v8, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v6, "lat"

    iget-object v1, v4, Lcom/wishabi/flipp/b/a;->c:Landroid/location/Location;

    if-eqz v1, :cond_8

    iget-object v1, v4, Lcom/wishabi/flipp/b/a;->c:Landroid/location/Location;

    invoke-virtual {v1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v1

    :goto_3
    invoke-virtual {v7, v6, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v6, "lon"

    iget-object v1, v4, Lcom/wishabi/flipp/b/a;->c:Landroid/location/Location;

    if-eqz v1, :cond_9

    iget-object v1, v4, Lcom/wishabi/flipp/b/a;->c:Landroid/location/Location;

    invoke-virtual {v1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v1

    :goto_4
    invoke-virtual {v7, v6, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "Flyer Open"

    invoke-static {v1, v7}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    const-string v1, "open"

    invoke-virtual {v4, v1, v7, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    sget-object v1, Lcom/wishabi/flipp/b/r;->a:Lcom/wishabi/flipp/b/r;

    invoke-virtual {v4, v5, v1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;Lcom/wishabi/flipp/b/r;)V

    .line 251
    :cond_1
    :goto_5
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/bo;->a()V

    .line 254
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v1

    iput-boolean v2, v1, Lcom/wishabi/flipp/app/bo;->g:Z

    iget-object v4, v1, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    if-eqz v4, :cond_2

    iget-boolean v4, v1, Lcom/wishabi/flipp/app/bo;->g:Z

    if-eqz v4, :cond_b

    iget-object v1, v1, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a()V

    .line 256
    :cond_2
    :goto_6
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 257
    if-eqz v1, :cond_3

    .line 258
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 259
    const-string v5, "_id"

    iget-object v6, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v6}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->l(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 260
    const-string v5, "valid_to"

    iget-object v0, v0, Lcom/wishabi/flipp/content/Flyer$Model;->m:Ljava/lang/String;

    invoke-virtual {v4, v5, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 261
    invoke-virtual {v1}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->h:Landroid/net/Uri;

    invoke-virtual {v0, v1, v4}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 265
    :cond_3
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    iget-object v0, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->m(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z

    move-result v0

    if-nez v0, :cond_c

    move v0, v2

    :goto_7
    invoke-static {v1, v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->c(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Z)Z

    .line 266
    iget-object v0, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->n(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z

    .line 268
    iget-object v0, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    .line 269
    if-eqz v0, :cond_4

    .line 270
    const/4 v1, 0x0

    iget-object v4, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-virtual {v0, v3, v1, v4}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 273
    iget-object v0, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bo;->b()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 274
    iget-object v0, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->o(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/widget/FlyerToolbar;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/FlyerToolbar;->setProgressVisible(Z)V

    .line 278
    :cond_4
    :goto_8
    return-void

    :cond_5
    move v0, v3

    .line 216
    goto/16 :goto_0

    .line 245
    :cond_6
    const-string v1, "0"

    goto/16 :goto_1

    :cond_7
    const-string v1, "0"

    goto/16 :goto_2

    :cond_8
    const-string v1, "0"

    goto/16 :goto_3

    :cond_9
    const-string v1, "0"

    goto/16 :goto_4

    .line 247
    :cond_a
    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v4, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v4}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/content/Flyer$Model;

    move-result-object v4

    invoke-virtual {v1}, Lcom/wishabi/flipp/b/a;->b()V

    new-instance v5, Ljava/util/Timer;

    invoke-direct {v5}, Ljava/util/Timer;-><init>()V

    iput-object v5, v1, Lcom/wishabi/flipp/b/a;->g:Ljava/util/Timer;

    iget-object v5, v1, Lcom/wishabi/flipp/b/a;->g:Ljava/util/Timer;

    new-instance v6, Lcom/wishabi/flipp/b/l;

    invoke-direct {v6, v1, v4}, Lcom/wishabi/flipp/b/l;-><init>(Lcom/wishabi/flipp/b/a;Lcom/wishabi/flipp/content/Flyer$Model;)V

    invoke-virtual {v5, v6, v12, v13}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 248
    iget-object v1, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->k(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Z

    goto/16 :goto_5

    .line 254
    :cond_b
    iget-object v1, v1, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iget-object v1, v1, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/bn;->a()V

    goto/16 :goto_6

    :cond_c
    move v0, v3

    .line 265
    goto :goto_7

    .line 276
    :cond_d
    iget-object v0, p0, Lcom/wishabi/flipp/app/bh;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)Lcom/wishabi/flipp/app/bo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bo;->c()V

    goto :goto_8
.end method
