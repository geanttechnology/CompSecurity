.class final Landroid/support/v4/app/bx;
.super Landroid/support/v4/app/bv;
.source "SourceFile"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 555
    invoke-direct {p0}, Landroid/support/v4/app/bv;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/support/v4/app/bq;)Landroid/app/Notification;
    .locals 10

    .prologue
    .line 558
    iget-object v0, p1, Landroid/support/v4/app/bq;->a:Landroid/content/Context;

    iget-object v1, p1, Landroid/support/v4/app/bq;->B:Landroid/app/Notification;

    iget-object v2, p1, Landroid/support/v4/app/bq;->b:Ljava/lang/CharSequence;

    iget-object v3, p1, Landroid/support/v4/app/bq;->c:Ljava/lang/CharSequence;

    iget-object v4, p1, Landroid/support/v4/app/bq;->h:Ljava/lang/CharSequence;

    iget-object v5, p1, Landroid/support/v4/app/bq;->f:Landroid/widget/RemoteViews;

    iget v6, p1, Landroid/support/v4/app/bq;->i:I

    iget-object v7, p1, Landroid/support/v4/app/bq;->d:Landroid/app/PendingIntent;

    iget-object v8, p1, Landroid/support/v4/app/bq;->e:Landroid/app/PendingIntent;

    iget-object v9, p1, Landroid/support/v4/app/bq;->g:Landroid/graphics/Bitmap;

    invoke-static/range {v0 .. v9}, Landroid/support/v4/app/ck;->a(Landroid/content/Context;Landroid/app/Notification;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/widget/RemoteViews;ILandroid/app/PendingIntent;Landroid/app/PendingIntent;Landroid/graphics/Bitmap;)Landroid/app/Notification;

    move-result-object v0

    return-object v0
.end method
