.class final Lcom/wishabi/flipp/app/as;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FeaturedFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FeaturedFragment;)V
    .locals 0

    .prologue
    .line 290
    iput-object p1, p0, Lcom/wishabi/flipp/app/as;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onSharedPreferenceChanged(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 294
    const-string v0, "postal_code"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 300
    :goto_0
    return-void

    .line 297
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/as;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FeaturedFragment;->e(Lcom/wishabi/flipp/app/FeaturedFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v0

    invoke-virtual {v0, v3, v3}, Lcom/wishabi/flipp/widget/CollectionView;->scrollTo(II)V

    .line 298
    iget-object v0, p0, Lcom/wishabi/flipp/app/as;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FeaturedFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/wishabi/flipp/app/as;->a:Lcom/wishabi/flipp/app/FeaturedFragment;

    invoke-virtual {v0, v3, v1, v2}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_0
.end method
