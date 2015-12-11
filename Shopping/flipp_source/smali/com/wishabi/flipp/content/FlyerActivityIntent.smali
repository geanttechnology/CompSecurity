.class public Lcom/wishabi/flipp/content/FlyerActivityIntent;
.super Landroid/content/Intent;
.source "SourceFile"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 1

    .prologue
    .line 16
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/content/FlyerActivityIntent;-><init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/graphics/RectF;)V

    .line 17
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;Landroid/graphics/RectF;)V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-direct {p0, p1, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 22
    sget v0, Lcom/wishabi/flipp/app/bm;->a:I

    invoke-direct {p0, p2, p3}, Lcom/wishabi/flipp/content/FlyerActivityIntent;->a(Landroid/database/Cursor;Landroid/graphics/RectF;)V

    .line 23
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/wishabi/flipp/content/Flyer$Model;Landroid/graphics/RectF;)V
    .locals 1

    .prologue
    .line 27
    sget v0, Lcom/wishabi/flipp/app/bm;->a:I

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/wishabi/flipp/content/FlyerActivityIntent;-><init>(Landroid/content/Context;Lcom/wishabi/flipp/content/Flyer$Model;Landroid/graphics/RectF;I)V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/wishabi/flipp/content/Flyer$Model;Landroid/graphics/RectF;I)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 34
    const-class v0, Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-direct {p0, p1, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 35
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/wishabi/flipp/content/Flyer$Model;

    aput-object p2, v0, v1

    .line 36
    invoke-direct {p0, v0, v1, p3, p4}, Lcom/wishabi/flipp/content/FlyerActivityIntent;->a([Lcom/wishabi/flipp/content/Flyer$Model;ILandroid/graphics/RectF;I)V

    .line 37
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/wishabi/flipp/content/o;)V
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 41
    const-class v0, Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-direct {p0, p1, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 45
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "flyer_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget v7, p2, Lcom/wishabi/flipp/content/o;->b:I

    invoke-static {v7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 49
    if-eqz v1, :cond_0

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 50
    invoke-virtual {p2}, Lcom/wishabi/flipp/content/o;->a()Landroid/graphics/RectF;

    move-result-object v0

    sget v2, Lcom/wishabi/flipp/app/bm;->a:I

    invoke-direct {p0, v1, v0}, Lcom/wishabi/flipp/content/FlyerActivityIntent;->a(Landroid/database/Cursor;Landroid/graphics/RectF;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 54
    :cond_0
    if-eqz v1, :cond_1

    .line 55
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 57
    :cond_1
    return-void

    .line 54
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_0
    if-eqz v1, :cond_2

    .line 55
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0

    .line 54
    :catchall_1
    move-exception v0

    goto :goto_0
.end method

.method private a(Landroid/database/Cursor;Landroid/graphics/RectF;)V
    .locals 5

    .prologue
    .line 61
    invoke-interface {p1}, Landroid/database/Cursor;->getPosition()I

    move-result v3

    .line 62
    invoke-interface {p1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    new-array v4, v0, [Lcom/wishabi/flipp/content/Flyer$Model;

    .line 63
    const/4 v1, 0x0

    .line 64
    invoke-interface {p1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    :goto_0
    if-eqz v0, :cond_0

    .line 65
    add-int/lit8 v2, v1, 0x1

    new-instance v0, Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-direct {v0, p1}, Lcom/wishabi/flipp/content/Flyer$Model;-><init>(Landroid/database/Cursor;)V

    aput-object v0, v4, v1

    .line 64
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    move v1, v2

    goto :goto_0

    .line 67
    :cond_0
    sget v0, Lcom/wishabi/flipp/app/bm;->a:I

    invoke-direct {p0, v4, v3, p2, v0}, Lcom/wishabi/flipp/content/FlyerActivityIntent;->a([Lcom/wishabi/flipp/content/Flyer$Model;ILandroid/graphics/RectF;I)V

    .line 69
    return-void
.end method

.method private a([Lcom/wishabi/flipp/content/Flyer$Model;ILandroid/graphics/RectF;I)V
    .locals 2

    .prologue
    .line 73
    const-string v0, "models"

    invoke-virtual {p0, v0, p1}, Lcom/wishabi/flipp/content/FlyerActivityIntent;->putExtra(Ljava/lang/String;[Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 74
    const-string v0, "position"

    invoke-virtual {p0, v0, p2}, Lcom/wishabi/flipp/content/FlyerActivityIntent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 75
    const-string v0, "flyer_mode"

    add-int/lit8 v1, p4, -0x1

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/content/FlyerActivityIntent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 77
    if-nez p3, :cond_0

    .line 84
    :goto_0
    return-void

    .line 80
    :cond_0
    const-string v0, "left"

    iget v1, p3, Landroid/graphics/RectF;->left:F

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/content/FlyerActivityIntent;->putExtra(Ljava/lang/String;F)Landroid/content/Intent;

    .line 81
    const-string v0, "top"

    iget v1, p3, Landroid/graphics/RectF;->top:F

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/content/FlyerActivityIntent;->putExtra(Ljava/lang/String;F)Landroid/content/Intent;

    .line 82
    const-string v0, "right"

    iget v1, p3, Landroid/graphics/RectF;->right:F

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/content/FlyerActivityIntent;->putExtra(Ljava/lang/String;F)Landroid/content/Intent;

    .line 83
    const-string v0, "bottom"

    iget v1, p3, Landroid/graphics/RectF;->bottom:F

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/content/FlyerActivityIntent;->putExtra(Ljava/lang/String;F)Landroid/content/Intent;

    goto :goto_0
.end method
