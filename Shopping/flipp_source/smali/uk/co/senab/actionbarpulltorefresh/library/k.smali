.class final Luk/co/senab/actionbarpulltorefresh/library/k;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Landroid/view/ViewGroup;

.field final synthetic b:Luk/co/senab/actionbarpulltorefresh/library/j;


# direct methods
.method constructor <init>(Luk/co/senab/actionbarpulltorefresh/library/j;Landroid/view/ViewGroup;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Luk/co/senab/actionbarpulltorefresh/library/k;->b:Luk/co/senab/actionbarpulltorefresh/library/j;

    iput-object p2, p0, Luk/co/senab/actionbarpulltorefresh/library/k;->a:Landroid/view/ViewGroup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 8

    .prologue
    .line 126
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/k;->a:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getWindowToken()Landroid/os/IBinder;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 128
    iget-object v6, p0, Luk/co/senab/actionbarpulltorefresh/library/k;->b:Luk/co/senab/actionbarpulltorefresh/library/j;

    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/k;->b:Luk/co/senab/actionbarpulltorefresh/library/j;

    iget-object v7, v0, Luk/co/senab/actionbarpulltorefresh/library/j;->d:Landroid/view/View;

    iget-object v0, v6, Luk/co/senab/actionbarpulltorefresh/library/j;->c:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    iget-object v1, v6, Luk/co/senab/actionbarpulltorefresh/library/j;->o:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    const/4 v1, -0x1

    const/4 v2, -0x2

    invoke-virtual {v7}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    if-eqz v0, :cond_0

    iget v1, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    iget v2, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    :cond_0
    new-instance v0, Landroid/view/WindowManager$LayoutParams;

    const/16 v3, 0x3e8

    const/16 v4, 0x118

    const/4 v5, -0x3

    invoke-direct/range {v0 .. v5}, Landroid/view/WindowManager$LayoutParams;-><init>(IIIII)V

    const/4 v1, 0x0

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->x:I

    iget-object v1, v6, Luk/co/senab/actionbarpulltorefresh/library/j;->o:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->top:I

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    const/16 v1, 0x30

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->gravity:I

    invoke-virtual {v7, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    iget-object v1, v6, Luk/co/senab/actionbarpulltorefresh/library/j;->c:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    invoke-interface {v1, v7, v0}, Landroid/view/WindowManager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 133
    :goto_0
    return-void

    .line 131
    :cond_1
    iget-object v0, p0, Luk/co/senab/actionbarpulltorefresh/library/k;->a:Landroid/view/ViewGroup;

    invoke-virtual {v0, p0}, Landroid/view/ViewGroup;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method
