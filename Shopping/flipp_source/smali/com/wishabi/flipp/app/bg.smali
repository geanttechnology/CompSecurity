.class final Lcom/wishabi/flipp/app/bg;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/dr;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FlyerCarouselFragment;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/wishabi/flipp/app/bg;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 185
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 201
    :goto_0
    return-void

    .line 188
    :cond_0
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 189
    const-string v1, "name"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    const-string v1, "position"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 191
    const-string v1, "checked"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 192
    const-string v1, "datetime_updated"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 193
    const-string v1, "shopping_list_id"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 196
    iget-object v1, p0, Lcom/wishabi/flipp/app/bg;->a:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 197
    sget-object v2, Lcom/wishabi/flipp/content/i;->k:Landroid/net/Uri;

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 199
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    sget v1, Lcom/wishabi/flipp/b/s;->b:I

    const/4 v2, -0x1

    invoke-virtual {v0, p1, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;II)V

    goto :goto_0
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 205
    const/4 v0, 0x0

    return v0
.end method
