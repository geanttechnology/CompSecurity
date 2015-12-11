.class final Lcom/wishabi/flipp/app/aw;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FlippApplication;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FlippApplication;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/wishabi/flipp/app/aw;->a:Lcom/wishabi/flipp/app/FlippApplication;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onSharedPreferenceChanged(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 85
    const-string v0, "postal_code"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "allow_push"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 86
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/aw;->a:Lcom/wishabi/flipp/app/FlippApplication;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlippApplication;->a(Lcom/wishabi/flipp/app/FlippApplication;)V

    .line 97
    :cond_1
    :goto_0
    return-void

    .line 88
    :cond_2
    const-string v0, "keep_search_history"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 89
    const-string v0, "keep_search_history"

    const/4 v1, 0x1

    invoke-interface {p1, v0, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 92
    if-nez v0, :cond_3

    .line 93
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/wishabi/flipp/content/aj;->a(Landroid/content/Context;)V

    .line 95
    :cond_3
    invoke-static {v0}, Lcom/wishabi/flipp/content/SearchTermProvider;->a(Z)V

    goto :goto_0
.end method
