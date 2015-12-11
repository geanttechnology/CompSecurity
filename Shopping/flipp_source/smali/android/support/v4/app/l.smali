.class public final Landroid/support/v4/app/l;
.super Landroid/support/v4/a/a;
.source "SourceFile"


# direct methods
.method static a(Landroid/support/v4/app/db;)Landroid/support/v4/app/o;
    .locals 1

    .prologue
    .line 210
    const/4 v0, 0x0

    .line 211
    if-eqz p0, :cond_0

    .line 212
    new-instance v0, Landroid/support/v4/app/m;

    invoke-direct {v0, p0}, Landroid/support/v4/app/m;-><init>(Landroid/support/v4/app/db;)V

    .line 214
    :cond_0
    return-object v0
.end method
