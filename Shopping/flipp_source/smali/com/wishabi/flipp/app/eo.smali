.class public final Lcom/wishabi/flipp/app/eo;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Landroid/content/Context;IIILcom/wishabi/flipp/widget/ec;)Lcom/wishabi/flipp/widget/dz;
    .locals 2

    .prologue
    .line 29
    new-instance v0, Lcom/wishabi/flipp/widget/dz;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/widget/dz;-><init>(Landroid/content/Context;)V

    .line 30
    new-instance v1, Lcom/wishabi/flipp/app/ep;

    invoke-direct {v1, p0, p2, p3, p1}, Lcom/wishabi/flipp/app/ep;-><init>(Landroid/content/Context;III)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/dz;->setTabAdapter(Lcom/wishabi/flipp/widget/eb;)V

    .line 75
    invoke-virtual {v0, p4}, Lcom/wishabi/flipp/widget/dz;->setTabClickListener(Lcom/wishabi/flipp/widget/ec;)V

    .line 76
    return-object v0
.end method
