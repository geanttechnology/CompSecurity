.class final Lxe;
.super Landroid/widget/RelativeLayout;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Labu;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    new-instance v0, Labu;

    invoke-direct {v0, p1, p2}, Labu;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lxe;->a:Labu;

    return-void
.end method


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    iget-object v0, p0, Lxe;->a:Labu;

    invoke-virtual {v0, p1}, Labu;->a(Landroid/view/MotionEvent;)V

    const/4 v0, 0x0

    return v0
.end method
