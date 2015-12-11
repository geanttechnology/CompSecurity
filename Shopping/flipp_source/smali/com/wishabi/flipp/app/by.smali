.class final Lcom/wishabi/flipp/app/by;
.super Lcom/wishabi/flipp/b/ab;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/bx;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/bx;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 179
    iput-object p1, p0, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    invoke-direct {p0, p2}, Lcom/wishabi/flipp/b/ab;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method protected final a(Landroid/location/Location;I)V
    .locals 7

    .prologue
    const/4 v5, 0x0

    const/4 v1, 0x1

    const/4 v6, 0x0

    .line 182
    iget-object v0, p0, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/bx;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_0

    .line 206
    :goto_0
    return-void

    .line 184
    :cond_0
    if-nez p1, :cond_1

    move-object v4, v5

    .line 185
    :goto_1
    if-nez p1, :cond_2

    .line 187
    :goto_2
    iget-object v2, p0, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    if-eqz p1, :cond_3

    move v0, v1

    :goto_3
    invoke-static {v2, v0}, Lcom/wishabi/flipp/app/bx;->a(Lcom/wishabi/flipp/app/bx;Z)Z

    .line 188
    iget-object v0, p0, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    const/4 v2, 0x2

    if-eq p2, v2, :cond_4

    :goto_4
    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/bx;->b(Lcom/wishabi/flipp/app/bx;Z)Z

    .line 191
    new-instance v0, Lcom/wishabi/flipp/app/bz;

    iget-object v1, p0, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bx;->a(Lcom/wishabi/flipp/app/bx;)I

    move-result v2

    iget-object v1, p0, Lcom/wishabi/flipp/app/by;->a:Lcom/wishabi/flipp/app/bx;

    invoke-static {v1}, Lcom/wishabi/flipp/app/bx;->b(Lcom/wishabi/flipp/app/bx;)Ljava/lang/String;

    move-result-object v3

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/wishabi/flipp/app/bz;-><init>(Lcom/wishabi/flipp/app/by;ILjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V

    new-array v1, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/bz;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 184
    :cond_1
    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    goto :goto_1

    .line 185
    :cond_2
    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v5

    goto :goto_2

    :cond_3
    move v0, v6

    .line 187
    goto :goto_3

    :cond_4
    move v1, v6

    .line 188
    goto :goto_4
.end method
