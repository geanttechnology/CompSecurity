.class final Lcom/wishabi/flipp/app/u;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/CouponFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/CouponFragment;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lcom/wishabi/flipp/app/u;->a:Lcom/wishabi/flipp/app/CouponFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onSharedPreferenceChanged(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 113
    iget-object v0, p0, Lcom/wishabi/flipp/app/u;->a:Lcom/wishabi/flipp/app/CouponFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/CouponFragment;->isAdded()Z

    move-result v0

    if-nez v0, :cond_1

    .line 127
    :cond_0
    :goto_0
    return-void

    .line 116
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/u;->a:Lcom/wishabi/flipp/app/CouponFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/CouponFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    .line 117
    if-eqz v0, :cond_0

    .line 120
    const-string v1, "postal_code"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "coupon_category_order"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 122
    :cond_2
    const/4 v1, 0x2

    iget-object v2, p0, Lcom/wishabi/flipp/app/u;->a:Lcom/wishabi/flipp/app/CouponFragment;

    invoke-virtual {v0, v1, v3, v2}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 124
    const/4 v1, 0x3

    iget-object v2, p0, Lcom/wishabi/flipp/app/u;->a:Lcom/wishabi/flipp/app/CouponFragment;

    invoke-virtual {v0, v1, v3, v2}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_0
.end method
