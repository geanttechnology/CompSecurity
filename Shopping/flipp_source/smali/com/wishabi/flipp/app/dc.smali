.class final Lcom/wishabi/flipp/app/dc;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/cx;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cx;)V
    .locals 0

    .prologue
    .line 588
    iput-object p1, p0, Lcom/wishabi/flipp/app/dc;->a:Lcom/wishabi/flipp/app/cx;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 11

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    const/4 v6, 0x0

    .line 591
    iget-object v0, p0, Lcom/wishabi/flipp/app/dc;->a:Lcom/wishabi/flipp/app/cx;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/cx;->getActivity()Landroid/app/Activity;

    move-result-object v7

    .line 592
    if-nez v7, :cond_0

    .line 622
    :goto_0
    return-void

    .line 597
    :cond_0
    :try_start_0
    invoke-virtual {v7}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v8, p0, Lcom/wishabi/flipp/app/dc;->a:Lcom/wishabi/flipp/app/cx;

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

    .line 604
    if-eqz v1, :cond_1

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 605
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    new-instance v2, Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-direct {v2, v1}, Lcom/wishabi/flipp/content/Flyer$Model;-><init>(Landroid/database/Cursor;)V

    iget-object v3, p0, Lcom/wishabi/flipp/app/dc;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v3}, Lcom/wishabi/flipp/app/cx;->c(Lcom/wishabi/flipp/app/cx;)J

    move-result-wide v4

    sget-object v3, Lcom/wishabi/flipp/b/o;->f:Lcom/wishabi/flipp/b/o;

    invoke-virtual {v0, v2, v4, v5, v3}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 610
    :cond_1
    if-eqz v1, :cond_2

    .line 611
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 614
    :cond_2
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 615
    iget-object v1, p0, Lcom/wishabi/flipp/app/dc;->a:Lcom/wishabi/flipp/app/cx;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/cx;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0e012a

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/wishabi/flipp/app/dc;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v4}, Lcom/wishabi/flipp/app/cx;->b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;

    move-result-object v4

    iget-object v4, v4, Lcom/wishabi/flipp/content/af;->d:Ljava/lang/String;

    aput-object v4, v3, v9

    iget-object v4, p0, Lcom/wishabi/flipp/app/dc;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v4}, Lcom/wishabi/flipp/app/cx;->b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;

    move-result-object v4

    invoke-virtual {v4}, Lcom/wishabi/flipp/content/af;->a()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v10

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 618
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 620
    const-string v1, "text/plain"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 621
    invoke-static {v0, v6}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 610
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_1
    if-eqz v1, :cond_3

    .line 611
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v0

    .line 610
    :catchall_1
    move-exception v0

    goto :goto_1
.end method
