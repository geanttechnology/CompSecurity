.class final Luk/co/senab/actionbarpulltorefresh/library/l;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Luk/co/senab/actionbarpulltorefresh/library/e;


# instance fields
.field final synthetic a:Luk/co/senab/actionbarpulltorefresh/library/j;


# direct methods
.method constructor <init>(Luk/co/senab/actionbarpulltorefresh/library/j;)V
    .locals 0

    .prologue
    .line 482
    iput-object p1, p0, Luk/co/senab/actionbarpulltorefresh/library/l;->a:Luk/co/senab/actionbarpulltorefresh/library/j;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/app/Activity;)Landroid/content/Context;
    .locals 3

    .prologue
    .line 485
    const/4 v0, 0x0

    .line 486
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xe

    if-lt v1, v2, :cond_0

    .line 487
    invoke-virtual {p1}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v1

    .line 488
    if-eqz v1, :cond_0

    .line 489
    invoke-virtual {v1}, Landroid/app/ActionBar;->getThemedContext()Landroid/content/Context;

    move-result-object v0

    .line 492
    :cond_0
    if-nez v0, :cond_1

    .line 495
    :goto_0
    return-object p1

    :cond_1
    move-object p1, v0

    goto :goto_0
.end method
