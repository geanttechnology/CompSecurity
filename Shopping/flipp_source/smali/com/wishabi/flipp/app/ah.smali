.class final Lcom/wishabi/flipp/app/ah;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;


# instance fields
.field final synthetic a:Landroid/app/Activity;

.field final synthetic b:Lcom/wishabi/flipp/app/FavoritesFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FavoritesFragment;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/wishabi/flipp/app/ah;->b:Lcom/wishabi/flipp/app/FavoritesFragment;

    iput-object p2, p0, Lcom/wishabi/flipp/app/ah;->a:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onSharedPreferenceChanged(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 97
    const-string v0, "postal_code"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 106
    :cond_0
    :goto_0
    return-void

    .line 100
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ah;->b:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->a(Lcom/wishabi/flipp/app/FavoritesFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v0

    invoke-virtual {v0, v3, v3}, Lcom/wishabi/flipp/widget/CollectionView;->scrollTo(II)V

    .line 101
    iget-object v0, p0, Lcom/wishabi/flipp/app/ah;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lcom/wishabi/flipp/app/ah;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/wishabi/flipp/app/ah;->b:Lcom/wishabi/flipp/app/FavoritesFragment;

    invoke-virtual {v0, v3, v1, v2}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_0
.end method
