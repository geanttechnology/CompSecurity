.class public Lcom/livemixtapes/ui/BaseActivity;
.super Landroid/support/v4/app/FragmentActivity;
.source "BaseActivity.java"


# instance fields
.field protected app:Lcom/livemixtapes/App;

.field hud:Lcom/livemixtapes/ui/ProgressHUD;

.field protected layoutBack:Landroid/widget/LinearLayout;

.field protected textViewBack:Landroid/widget/TextView;

.field protected textViewTitle:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 20
    invoke-direct {p0}, Landroid/support/v4/app/FragmentActivity;-><init>()V

    .line 26
    iput-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->textViewTitle:Landroid/widget/TextView;

    .line 28
    iput-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->hud:Lcom/livemixtapes/ui/ProgressHUD;

    .line 20
    return-void
.end method


# virtual methods
.method protected afterAppear()V
    .locals 0

    .prologue
    .line 72
    return-void
.end method

.method protected attachEvent()V
    .locals 0

    .prologue
    .line 56
    return-void
.end method

.method protected finishScreen()V
    .locals 0

    .prologue
    .line 88
    invoke-virtual {p0}, Lcom/livemixtapes/ui/BaseActivity;->finish()V

    .line 89
    return-void
.end method

.method public getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;
    .locals 5

    .prologue
    .line 112
    invoke-virtual {p0}, Lcom/livemixtapes/ui/BaseActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 114
    .local v0, "fragmentTransaction":Landroid/app/FragmentTransaction;
    sget v1, Lcom/livemixtapes/ui/SlideAnimation;->FRAGMENT_START_ENTER:I

    sget v2, Lcom/livemixtapes/ui/SlideAnimation;->FRAGMENT_START_LEAVE:I

    .line 115
    sget v3, Lcom/livemixtapes/ui/SlideAnimation;->FRAGMENT_FINISH_LEAVE:I

    sget v4, Lcom/livemixtapes/ui/SlideAnimation;->FRAGMENT_FINISH_ENTER:I

    .line 114
    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/app/FragmentTransaction;->setCustomAnimations(IIII)Landroid/app/FragmentTransaction;

    .line 117
    return-object v0
.end method

.method public hideProgressBar()V
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->hud:Lcom/livemixtapes/ui/ProgressHUD;

    if-eqz v0, :cond_0

    .line 107
    iget-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->hud:Lcom/livemixtapes/ui/ProgressHUD;

    invoke-virtual {v0}, Lcom/livemixtapes/ui/ProgressHUD;->hide()V

    .line 109
    :cond_0
    return-void
.end method

.method public onBackPressed()V
    .locals 0

    .prologue
    .line 65
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 67
    invoke-static {p0}, Lcom/livemixtapes/ui/SlideAnimation;->startCloseAnimation(Landroid/app/Activity;)V

    .line 68
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;I)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .param p2, "layout_id"    # I

    .prologue
    .line 31
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/livemixtapes/ui/BaseActivity;->requestWindowFeature(I)Z

    .line 32
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 33
    invoke-virtual {p0, p2}, Lcom/livemixtapes/ui/BaseActivity;->setContentView(I)V

    .line 35
    invoke-virtual {p0}, Lcom/livemixtapes/ui/BaseActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/App;

    iput-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->app:Lcom/livemixtapes/App;

    .line 37
    iget-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->app:Lcom/livemixtapes/App;

    iput-object p0, v0, Lcom/livemixtapes/App;->currentActivity:Lcom/livemixtapes/ui/BaseActivity;

    .line 39
    invoke-virtual {p0}, Lcom/livemixtapes/ui/BaseActivity;->synthesize()V

    .line 41
    invoke-virtual {p0}, Lcom/livemixtapes/ui/BaseActivity;->attachEvent()V

    .line 43
    invoke-virtual {p0}, Lcom/livemixtapes/ui/BaseActivity;->afterAppear()V

    .line 45
    invoke-static {p0}, Lcom/livemixtapes/ui/SlideAnimation;->startOpenAnimation(Landroid/app/Activity;)V

    .line 46
    return-void
.end method

.method public bridge synthetic onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1

    .prologue
    .line 1
    invoke-super {p0, p1, p2, p3, p4}, Landroid/support/v4/app/FragmentActivity;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1

    .prologue
    .line 1
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/app/FragmentActivity;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 60
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onResume()V

    .line 61
    return-void
.end method

.method protected setBackButtonTitle(Ljava/lang/String;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 92
    iget-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->textViewBack:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->textViewBack:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 95
    :cond_0
    return-void
.end method

.method protected setTitle(Ljava/lang/String;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->textViewTitle:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 98
    iget-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->textViewTitle:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 100
    :cond_0
    return-void
.end method

.method public showErrorMessage(Ljava/lang/String;)V
    .locals 3
    .param p1, "error"    # Ljava/lang/String;

    .prologue
    .line 75
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 76
    const v1, 0x1080027

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 77
    invoke-virtual {p0}, Lcom/livemixtapes/ui/BaseActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0a003a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 78
    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 79
    const-string v1, "OK"

    new-instance v2, Lcom/livemixtapes/ui/BaseActivity$1;

    invoke-direct {v2, p0}, Lcom/livemixtapes/ui/BaseActivity$1;-><init>(Lcom/livemixtapes/ui/BaseActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 85
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 86
    return-void
.end method

.method public showProgressBar(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 103
    const/4 v0, 0x1

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {p0, p1, v0, v1, v2}, Lcom/livemixtapes/ui/ProgressHUD;->show(Landroid/content/Context;Ljava/lang/CharSequence;ZZLandroid/content/DialogInterface$OnCancelListener;)Lcom/livemixtapes/ui/ProgressHUD;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->hud:Lcom/livemixtapes/ui/ProgressHUD;

    .line 104
    return-void
.end method

.method protected synthesize()V
    .locals 1

    .prologue
    .line 49
    const v0, 0x7f08006d

    invoke-virtual {p0, v0}, Lcom/livemixtapes/ui/BaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->layoutBack:Landroid/widget/LinearLayout;

    .line 50
    const v0, 0x7f08006f

    invoke-virtual {p0, v0}, Lcom/livemixtapes/ui/BaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->textViewBack:Landroid/widget/TextView;

    .line 51
    const v0, 0x7f08006c

    invoke-virtual {p0, v0}, Lcom/livemixtapes/ui/BaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/ui/BaseActivity;->textViewTitle:Landroid/widget/TextView;

    .line 52
    return-void
.end method
