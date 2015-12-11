.class final Lcom/wishabi/flipp/b/c;
.super Lcom/wishabi/flipp/b/ab;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/b/a;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/a;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 1091
    iput-object p1, p0, Lcom/wishabi/flipp/b/c;->a:Lcom/wishabi/flipp/b/a;

    invoke-direct {p0, p2}, Lcom/wishabi/flipp/b/ab;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method protected final a(Landroid/location/Location;I)V
    .locals 4

    .prologue
    .line 1094
    if-eqz p2, :cond_0

    const/4 v0, 0x1

    if-eq p2, v0, :cond_0

    .line 1097
    iget-object v0, p0, Lcom/wishabi/flipp/b/c;->a:Lcom/wishabi/flipp/b/a;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;Landroid/location/Location;)Landroid/location/Location;

    .line 1100
    iget-object v0, p0, Lcom/wishabi/flipp/b/c;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v0}, Lcom/wishabi/flipp/b/a;->k(Lcom/wishabi/flipp/b/a;)V

    .line 1118
    :goto_0
    return-void

    .line 1105
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/c;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v0, p1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;Landroid/location/Location;)Landroid/location/Location;

    .line 1107
    if-nez p1, :cond_1

    .line 1109
    iget-object v0, p0, Lcom/wishabi/flipp/b/c;->a:Lcom/wishabi/flipp/b/a;

    invoke-static {v0}, Lcom/wishabi/flipp/b/a;->k(Lcom/wishabi/flipp/b/a;)V

    goto :goto_0

    .line 1112
    :cond_1
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1113
    const-string v1, "lat"

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1114
    const-string v1, "lon"

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1115
    const-string v1, "accuracy"

    invoke-virtual {p1}, Landroid/location/Location;->getAccuracy()F

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1116
    iget-object v1, p0, Lcom/wishabi/flipp/b/c;->a:Lcom/wishabi/flipp/b/a;

    const-string v2, "app_open"

    invoke-static {v1, v2, v0}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/b/a;Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0
.end method
