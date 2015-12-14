.class public Lcom/livemixtapes/ui/ProgressHUD;
.super Landroid/app/Dialog;
.source "ProgressHUD.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    .line 19
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "theme"    # I

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 23
    return-void
.end method

.method public static show(Landroid/content/Context;Ljava/lang/CharSequence;ZZLandroid/content/DialogInterface$OnCancelListener;)Lcom/livemixtapes/ui/ProgressHUD;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "message"    # Ljava/lang/CharSequence;
    .param p2, "indeterminate"    # Z
    .param p3, "cancelable"    # Z
    .param p4, "cancelListener"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    const v4, 0x7f0800f6

    .line 43
    new-instance v0, Lcom/livemixtapes/ui/ProgressHUD;

    const v3, 0x7f09009b

    invoke-direct {v0, p0, v3}, Lcom/livemixtapes/ui/ProgressHUD;-><init>(Landroid/content/Context;I)V

    .line 44
    .local v0, "dialog":Lcom/livemixtapes/ui/ProgressHUD;
    const-string v3, ""

    invoke-virtual {v0, v3}, Lcom/livemixtapes/ui/ProgressHUD;->setTitle(Ljava/lang/CharSequence;)V

    .line 45
    const v3, 0x7f030034

    invoke-virtual {v0, v3}, Lcom/livemixtapes/ui/ProgressHUD;->setContentView(I)V

    .line 46
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v3

    if-nez v3, :cond_1

    .line 47
    :cond_0
    invoke-virtual {v0, v4}, Lcom/livemixtapes/ui/ProgressHUD;->findViewById(I)Landroid/view/View;

    move-result-object v3

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    .line 52
    :goto_0
    invoke-virtual {v0, p3}, Lcom/livemixtapes/ui/ProgressHUD;->setCancelable(Z)V

    .line 53
    invoke-virtual {v0, p4}, Lcom/livemixtapes/ui/ProgressHUD;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 54
    invoke-virtual {v0}, Lcom/livemixtapes/ui/ProgressHUD;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v3

    const/16 v4, 0x11

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->gravity:I

    .line 55
    invoke-virtual {v0}, Lcom/livemixtapes/ui/ProgressHUD;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v1

    .line 56
    .local v1, "lp":Landroid/view/WindowManager$LayoutParams;
    const v3, 0x3e4ccccd    # 0.2f

    iput v3, v1, Landroid/view/WindowManager$LayoutParams;->dimAmount:F

    .line 57
    invoke-virtual {v0}, Lcom/livemixtapes/ui/ProgressHUD;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 59
    invoke-virtual {v0}, Lcom/livemixtapes/ui/ProgressHUD;->show()V

    .line 60
    return-object v0

    .line 49
    .end local v1    # "lp":Landroid/view/WindowManager$LayoutParams;
    :cond_1
    invoke-virtual {v0, v4}, Lcom/livemixtapes/ui/ProgressHUD;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 50
    .local v2, "txt":Landroid/widget/TextView;
    invoke-virtual {v2, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method


# virtual methods
.method public onWindowFocusChanged(Z)V
    .locals 3
    .param p1, "hasFocus"    # Z

    .prologue
    .line 27
    const v2, 0x7f0800f5

    invoke-virtual {p0, v2}, Lcom/livemixtapes/ui/ProgressHUD;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 28
    .local v0, "imageView":Landroid/widget/ImageView;
    invoke-virtual {v0}, Landroid/widget/ImageView;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/AnimationDrawable;

    .line 29
    .local v1, "spinner":Landroid/graphics/drawable/AnimationDrawable;
    invoke-virtual {v1}, Landroid/graphics/drawable/AnimationDrawable;->start()V

    .line 30
    return-void
.end method

.method public setMessage(Ljava/lang/CharSequence;)V
    .locals 4
    .param p1, "message"    # Ljava/lang/CharSequence;

    .prologue
    const v3, 0x7f0800f6

    .line 33
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 34
    invoke-virtual {p0, v3}, Lcom/livemixtapes/ui/ProgressHUD;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 35
    invoke-virtual {p0, v3}, Lcom/livemixtapes/ui/ProgressHUD;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 36
    .local v0, "txt":Landroid/widget/TextView;
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 37
    invoke-virtual {v0}, Landroid/widget/TextView;->invalidate()V

    .line 39
    .end local v0    # "txt":Landroid/widget/TextView;
    :cond_0
    return-void
.end method
