.class public Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/view/View;

.field private b:Landroid/view/View;

.field private c:Z

.field private g:Ljava/lang/String;

.field private h:Ljava/lang/String;

.field private i:Landroid/widget/EditText;

.field private j:Landroid/widget/EditText;

.field private k:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private l:Z

.field private m:Z

.field private n:Landroid/widget/LinearLayout;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 41
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 31
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->c:Z

    .line 35
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->l:Z

    .line 36
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->m:Z

    .line 43
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)Lcom/bestbuy/android/bbyobjects/BBYButton;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYButton;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;Z)Z
    .locals 0

    .prologue
    .line 28
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->l:Z

    return p1
.end method

.method private b()V
    .locals 6

    .prologue
    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->i:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->j:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 150
    new-instance v0, Lho;

    iget-object v1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->b:Landroid/view/View;

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Lho;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    .line 151
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lho;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 152
    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->b()V

    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;Z)Z
    .locals 0

    .prologue
    .line 28
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->m:Z

    return p1
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->h:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)Z
    .locals 1

    .prologue
    .line 28
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->l:Z

    return v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)Z
    .locals 1

    .prologue
    .line 28
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->m:Z

    return v0
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 47
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 48
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d:Landroid/app/Activity;

    .line 49
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->f:Lnb;

    move-object v0, p1

    .line 50
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 51
    iget-object v1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    move-object v0, p1

    .line 52
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, " Gift Card Balance"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 53
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 54
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 58
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 59
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 63
    const v0, 0x7f030065

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a:Landroid/view/View;

    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->b:Landroid/view/View;

    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0161

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->n:Landroid/widget/LinearLayout;

    .line 67
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 68
    if-eqz v0, :cond_1

    .line 69
    const-string v1, "gift_id"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 70
    const-string v1, "gift_id"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->g:Ljava/lang/String;

    .line 71
    iget-object v1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->g:Ljava/lang/String;

    const-string v2, "0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 72
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->c:Z

    .line 75
    :cond_0
    const-string v1, "screen_title"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 76
    const-string v1, "screen_title"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->h:Ljava/lang/String;

    .line 80
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0166

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->i:Landroid/widget/EditText;

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0168

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->j:Landroid/widget/EditText;

    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0169

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYButton;

    new-instance v1, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$1;-><init>(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 94
    const-string v1, "android.hardware.camera"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->n:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$2;-><init>(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 102
    :cond_2
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->c:Z

    if-nez v0, :cond_3

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->i:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->g:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 104
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->l:Z

    .line 107
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->i:Landroid/widget/EditText;

    new-instance v1, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$3;-><init>(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->j:Landroid/widget/EditText;

    new-instance v1, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$4;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment$4;-><init>(Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->a:Landroid/view/View;

    return-object v0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 175
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d:Landroid/app/Activity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 177
    iget-object v1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->i:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 178
    iget-object v1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->j:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 179
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->f:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 182
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 156
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, " Gift Card Balance"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/giftcard/ManualEnterGiftCardDetailsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 159
    return-void
.end method
