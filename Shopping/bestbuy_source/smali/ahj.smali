.class final Lahj;
.super Landroid/widget/ViewSwitcher;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Labu;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0, p1}, Landroid/widget/ViewSwitcher;-><init>(Landroid/content/Context;)V

    new-instance v0, Labu;

    invoke-direct {v0, p1}, Labu;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lahj;->a:Labu;

    return-void
.end method

.method static synthetic a(Lahj;)Labu;
    .locals 1

    iget-object v0, p0, Lahj;->a:Labu;

    return-object v0
.end method


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    iget-object v0, p0, Lahj;->a:Labu;

    invoke-virtual {v0, p1}, Labu;->a(Landroid/view/MotionEvent;)V

    const/4 v0, 0x0

    return v0
.end method
