.class public Lgf;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 34
    new-instance v0, Lgz;

    invoke-direct {v0, p0}, Lgz;-><init>(Landroid/content/Context;)V

    .line 35
    const-string v1, "EP_CONTEXT_ID"

    invoke-virtual {v0, v1, p1}, Lgz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    return-void
.end method

.method public static a(Landroid/content/Context;)Z
    .locals 2

    .prologue
    .line 21
    new-instance v0, Lgz;

    invoke-direct {v0, p0}, Lgz;-><init>(Landroid/content/Context;)V

    .line 22
    const-string v1, "EP_CONTEXT_ID"

    invoke-virtual {v0, v1}, Lgz;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 23
    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static b(Landroid/content/Context;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 28
    new-instance v0, Lgz;

    invoke-direct {v0, p0}, Lgz;-><init>(Landroid/content/Context;)V

    .line 29
    const-string v1, "EP_CONTEXT_ID"

    invoke-virtual {v0, v1}, Lgz;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 30
    return-object v0
.end method
