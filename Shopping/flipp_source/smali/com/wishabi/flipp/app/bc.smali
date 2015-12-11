.class final Lcom/wishabi/flipp/app/bc;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FlyerActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FlyerActivity;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/wishabi/flipp/app/bc;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onGlobalLayout()V
    .locals 7

    .prologue
    .line 91
    iget-object v0, p0, Lcom/wishabi/flipp/app/bc;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FlyerActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 94
    instance-of v1, v0, Landroid/widget/FrameLayout;

    if-eqz v1, :cond_0

    .line 95
    iget-object v1, p0, Lcom/wishabi/flipp/app/bc;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    iget-object v2, p0, Lcom/wishabi/flipp/app/bc;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-static {v2}, Lcom/wishabi/flipp/app/FlyerActivity;->b(Lcom/wishabi/flipp/app/FlyerActivity;)Landroid/view/View;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/wishabi/flipp/app/FlyerActivity;->a(Lcom/wishabi/flipp/app/FlyerActivity;Landroid/view/View;)Landroid/view/View;

    .line 96
    iget-object v1, p0, Lcom/wishabi/flipp/app/bc;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerActivity;->c(Lcom/wishabi/flipp/app/FlyerActivity;)Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0b0142

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 98
    iget-object v2, p0, Lcom/wishabi/flipp/app/bc;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    const v3, 0x7f0e0100

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {}, Lcom/wishabi/flipp/util/q;->a()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Lcom/wishabi/flipp/app/FlyerActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 100
    iget-object v1, p0, Lcom/wishabi/flipp/app/bc;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerActivity;->c(Lcom/wishabi/flipp/app/FlyerActivity;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 101
    iget-object v1, p0, Lcom/wishabi/flipp/app/bc;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-static {v1}, Lcom/wishabi/flipp/app/FlyerActivity;->a(Lcom/wishabi/flipp/app/FlyerActivity;)V

    .line 104
    :cond_0
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-ge v1, v2, :cond_1

    .line 105
    invoke-virtual {v0}, Landroid/view/ViewGroup;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 109
    :goto_0
    return-void

    .line 107
    :cond_1
    invoke-virtual {v0}, Landroid/view/ViewGroup;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    goto :goto_0
.end method
