.class final Lcom/wishabi/flipp/app/da;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/content/af;

.field final synthetic b:Lcom/wishabi/flipp/app/cx;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cx;Lcom/wishabi/flipp/content/af;)V
    .locals 0

    .prologue
    .line 452
    iput-object p1, p0, Lcom/wishabi/flipp/app/da;->b:Lcom/wishabi/flipp/app/cx;

    iput-object p2, p0, Lcom/wishabi/flipp/app/da;->a:Lcom/wishabi/flipp/content/af;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v6, 0x0

    .line 455
    iget-object v0, p0, Lcom/wishabi/flipp/app/da;->b:Lcom/wishabi/flipp/app/cx;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/cx;->getActivity()Landroid/app/Activity;

    move-result-object v7

    .line 457
    if-eqz v7, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/da;->a:Lcom/wishabi/flipp/content/af;

    iget-object v0, v0, Lcom/wishabi/flipp/content/af;->s:Ljava/lang/String;

    invoke-static {v0}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 482
    :cond_0
    :goto_0
    return-void

    .line 463
    :cond_1
    :try_start_0
    invoke-virtual {v7}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v8, p0, Lcom/wishabi/flipp/app/da;->b:Lcom/wishabi/flipp/app/cx;

    invoke-static {v8}, Lcom/wishabi/flipp/app/cx;->b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;

    move-result-object v8

    iget v8, v8, Lcom/wishabi/flipp/content/af;->c:I

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 470
    if-eqz v1, :cond_2

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 471
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    new-instance v2, Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-direct {v2, v1}, Lcom/wishabi/flipp/content/Flyer$Model;-><init>(Landroid/database/Cursor;)V

    iget-object v3, p0, Lcom/wishabi/flipp/app/da;->b:Lcom/wishabi/flipp/app/cx;

    invoke-static {v3}, Lcom/wishabi/flipp/app/cx;->c(Lcom/wishabi/flipp/app/cx;)J

    move-result-wide v4

    sget-object v3, Lcom/wishabi/flipp/b/o;->b:Lcom/wishabi/flipp/b/o;

    invoke-virtual {v0, v2, v4, v5, v3}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 476
    :cond_2
    if-eqz v1, :cond_3

    .line 477
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 480
    :cond_3
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    iget-object v2, p0, Lcom/wishabi/flipp/app/da;->a:Lcom/wishabi/flipp/content/af;

    iget-object v2, v2, Lcom/wishabi/flipp/content/af;->s:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {v7, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 476
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_1
    if-eqz v1, :cond_4

    .line 477
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0

    .line 476
    :catchall_1
    move-exception v0

    goto :goto_1
.end method
