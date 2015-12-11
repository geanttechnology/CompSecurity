.class public final Lcom/wishabi/flipp/app/dr;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Landroid/app/Activity;[IZLcom/wishabi/flipp/b/p;)I
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 77
    if-nez p0, :cond_1

    .line 98
    :cond_0
    :goto_0
    return v0

    .line 80
    :cond_1
    if-eqz p1, :cond_0

    array-length v1, p1

    if-eqz v1, :cond_0

    .line 83
    invoke-virtual {p0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    .line 84
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/content/res/Configuration;->isLayoutSizeAtLeast(I)Z

    move-result v0

    if-eqz v0, :cond_2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x11

    if-lt v0, v1, :cond_2

    .line 87
    invoke-static {p1, p2, p3}, Lcom/wishabi/flipp/app/aa;->a([IZLcom/wishabi/flipp/b/p;)Lcom/wishabi/flipp/app/aa;

    move-result-object v0

    .line 89
    invoke-virtual {p0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "CouponDialogTag"

    invoke-virtual {v0, v1, v2}, Lcom/wishabi/flipp/app/aa;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 91
    sget v0, Lcom/wishabi/flipp/app/ds;->b:I

    goto :goto_0

    .line 93
    :cond_2
    invoke-static {p1, p2, p3}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->a([IZLcom/wishabi/flipp/b/p;)Landroid/content/Intent;

    move-result-object v0

    .line 95
    invoke-virtual {p0, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 96
    const v0, 0x7f040001

    const v1, 0x7f040002

    invoke-virtual {p0, v0, v1}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 98
    sget v0, Lcom/wishabi/flipp/app/ds;->a:I

    goto :goto_0
.end method
