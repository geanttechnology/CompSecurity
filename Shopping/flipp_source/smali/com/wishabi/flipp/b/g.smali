.class public final Lcom/wishabi/flipp/b/g;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/b/a;


# direct methods
.method public constructor <init>(Lcom/wishabi/flipp/b/a;)V
    .locals 0

    .prologue
    .line 298
    iput-object p1, p0, Lcom/wishabi/flipp/b/g;->a:Lcom/wishabi/flipp/b/a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onSharedPreferenceChanged(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 302
    const-string v0, "postal_code"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 303
    iget-object v0, p0, Lcom/wishabi/flipp/b/g;->a:Lcom/wishabi/flipp/b/a;

    const-string v1, "postal_code"

    const/4 v2, 0x0

    invoke-interface {p1, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;Ljava/lang/String;)Ljava/lang/String;

    .line 304
    :cond_0
    return-void
.end method
