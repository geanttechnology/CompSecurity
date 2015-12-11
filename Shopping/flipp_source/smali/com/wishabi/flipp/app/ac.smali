.class final Lcom/wishabi/flipp/app/ac;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/DrawerFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/DrawerFragment;)V
    .locals 0

    .prologue
    .line 228
    iput-object p1, p0, Lcom/wishabi/flipp/app/ac;->a:Lcom/wishabi/flipp/app/DrawerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onSharedPreferenceChanged(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 232
    const-string v0, "postal_code"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 237
    :goto_0
    return-void

    .line 235
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ac;->a:Lcom/wishabi/flipp/app/DrawerFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/DrawerFragment;->a(Lcom/wishabi/flipp/app/DrawerFragment;)Landroid/widget/TextView;

    move-result-object v0

    const-string v1, "postal_code"

    const/4 v2, 0x0

    invoke-interface {p1, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
