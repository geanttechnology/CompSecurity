.class public Lcom/comcast/cim/android/view/common/CALDialogFragment;
.super Landroid/app/DialogFragment;
.source "CALDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;,
        Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;
    }
.end annotation


# instance fields
.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private final appLauncher:Lcom/comcast/cim/utils/AppLauncher;

.field private buttonLayout:Landroid/widget/LinearLayout;

.field protected buttonList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;",
            ">;"
        }
    .end annotation
.end field

.field private inflater:Landroid/view/LayoutInflater;

.field private final launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

.field onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

.field onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

.field private tryAgainListener:Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;

.field private final userManager:Lcom/comcast/cim/model/user/UserManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    .line 53
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getLaunchStrategy()Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    .line 54
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getUserManager()Lcom/comcast/cim/model/user/UserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 55
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAndroidDevice()Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 56
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAppLauncher()Lcom/comcast/cim/utils/AppLauncher;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->appLauncher:Lcom/comcast/cim/utils/AppLauncher;

    .line 68
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/view/common/CALDialogFragment;)Lcom/comcast/cim/model/user/UserManager;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->userManager:Lcom/comcast/cim/model/user/UserManager;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/android/view/common/CALDialogFragment;)Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    return-object v0
.end method

.method static synthetic access$200(Lcom/comcast/cim/android/view/common/CALDialogFragment;)Lcom/comcast/cim/utils/AppLauncher;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->appLauncher:Lcom/comcast/cim/utils/AppLauncher;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/cim/android/view/common/CALDialogFragment;)Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->tryAgainListener:Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/cim/android/view/common/CALDialogFragment;Landroid/content/Context;Landroid/widget/TextView;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .param p1, "x1"    # Landroid/content/Context;
    .param p2, "x2"    # Landroid/widget/TextView;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->copyViewText(Landroid/content/Context;Landroid/widget/TextView;)V

    return-void
.end method

.method private addButton(Landroid/view/ViewGroup;ILcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;)Landroid/widget/Button;
    .locals 2
    .param p1, "viewGroup"    # Landroid/view/ViewGroup;
    .param p2, "buttonNum"    # I
    .param p3, "button"    # Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    .prologue
    .line 374
    iget-object v0, p3, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;->text:Ljava/lang/String;

    new-instance v1, Lcom/comcast/cim/android/view/common/CALDialogFragment$14;

    invoke-direct {v1, p0, p3, p2}, Lcom/comcast/cim/android/view/common/CALDialogFragment$14;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;I)V

    invoke-direct {p0, p1, v0, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    move-result-object v0

    return-object v0
.end method

.method private addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;
    .locals 5
    .param p1, "viewGroup"    # Landroid/view/ViewGroup;
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "onClickListener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 388
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    if-lez v2, :cond_0

    .line 389
    new-instance v1, Landroid/view/View;

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 390
    .local v1, "divider":Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v3, 0x1

    const/4 v4, -0x1

    invoke-direct {v2, v3, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 391
    sget v2, Lcom/comcast/cim/android/R$color;->MediumGray:I

    invoke-virtual {v1, v2}, Landroid/view/View;->setBackgroundResource(I)V

    .line 392
    invoke-virtual {p1, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 395
    .end local v1    # "divider":Landroid/view/View;
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->inflater:Landroid/view/LayoutInflater;

    sget v3, Lcom/comcast/cim/android/R$layout;->caldialogfragment_button:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, p1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 396
    .local v0, "button":Landroid/widget/Button;
    invoke-virtual {v0, p2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 397
    invoke-virtual {v0, p3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 398
    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 400
    return-object v0
.end method

.method private copyViewText(Landroid/content/Context;Landroid/widget/TextView;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "textView"    # Landroid/widget/TextView;

    .prologue
    .line 326
    const-string v1, "clipboard"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ClipboardManager;

    .line 327
    .local v0, "cm":Landroid/content/ClipboardManager;
    invoke-virtual {p2}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/ClipboardManager;->setText(Ljava/lang/CharSequence;)V

    .line 328
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$string;->toast_copied:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {p1, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 329
    return-void
.end method

.method private createDefaultErrorDialogView(Landroid/view/View;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "args"    # Landroid/os/Bundle;

    .prologue
    .line 243
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setMoreInfoButton(Landroid/view/View;Landroid/os/Bundle;)V

    .line 245
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$string;->dlg_btn_ok:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/comcast/cim/android/view/common/CALDialogFragment$9;

    invoke-direct {v2, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$9;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    invoke-direct {p0, v0, v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 252
    return-object p1
.end method

.method private createRetryableErrorDialogView(Ljava/lang/String;Landroid/view/View;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "args"    # Landroid/os/Bundle;

    .prologue
    .line 256
    invoke-direct {p0, p2, p3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setMoreInfoButton(Landroid/view/View;Landroid/os/Bundle;)V

    .line 258
    const/4 v0, 0x0

    .line 259
    .local v0, "text":Ljava/lang/String;
    const-string v1, "errorDlgRetryIgnore"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 260
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$string;->dlg_btn_ignore:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 265
    :goto_0
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    new-instance v2, Lcom/comcast/cim/android/view/common/CALDialogFragment$10;

    invoke-direct {v2, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$10;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    invoke-direct {p0, v1, v0, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 272
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->tryAgainListener:Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;

    if-eqz v1, :cond_0

    .line 273
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/comcast/cim/android/R$string;->dlg_btn_try_again:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/comcast/cim/android/view/common/CALDialogFragment$11;

    invoke-direct {v3, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$11;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    invoke-direct {p0, v1, v2, v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 282
    :cond_0
    return-object p2

    .line 262
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$string;->dlg_btn_cancel:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .locals 3
    .param p0, "tag"    # Ljava/lang/String;

    .prologue
    .line 82
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 83
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "tag"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    new-instance v1, Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-direct {v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;-><init>()V

    .line 85
    .local v1, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 87
    return-object v1
.end method

.method private setMessage(Landroid/view/View;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 364
    sget v1, Lcom/comcast/cim/android/R$id;->txt1:I

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 365
    .local v0, "description":Landroid/widget/TextView;
    if-eqz v0, :cond_1

    if-eqz p2, :cond_1

    .line 366
    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 367
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 371
    :cond_0
    :goto_0
    return-void

    .line 368
    :cond_1
    if-eqz v0, :cond_0

    .line 369
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method private setMoreInfoButton(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;
    .param p2, "args"    # Landroid/os/Bundle;

    .prologue
    .line 286
    const-string v2, "additionalInfo"

    invoke-virtual {p2, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 287
    .local v1, "stackTraceString":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 288
    sget v2, Lcom/comcast/cim/android/R$id;->txt2:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 289
    .local v0, "stackTrace":Landroid/widget/TextView;
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 290
    new-instance v2, Landroid/text/method/ScrollingMovementMethod;

    invoke-direct {v2}, Landroid/text/method/ScrollingMovementMethod;-><init>()V

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 292
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$string;->dlg_btn_more_info:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/comcast/cim/android/view/common/CALDialogFragment$12;

    invoke-direct {v4, p0, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$12;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;Landroid/widget/TextView;)V

    invoke-direct {p0, v2, v3, v4}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 306
    new-instance v2, Lcom/comcast/cim/android/view/common/CALDialogFragment$13;

    invoke-direct {v2, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$13;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 314
    .end local v0    # "stackTrace":Landroid/widget/TextView;
    :cond_0
    return-void
.end method


# virtual methods
.method public addArguments(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "additionalArgs"    # Landroid/os/Bundle;

    .prologue
    .line 91
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 92
    .local v0, "args":Landroid/os/Bundle;
    if-nez v0, :cond_0

    .line 93
    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 97
    :goto_0
    return-void

    .line 95
    :cond_0
    invoke-virtual {v0, p1}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 424
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    if-eqz v0, :cond_0

    .line 425
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    invoke-interface {v0, p1}, Landroid/content/DialogInterface$OnCancelListener;->onCancel(Landroid/content/DialogInterface;)V

    .line 428
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 429
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 101
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onCreate(Landroid/os/Bundle;)V

    .line 102
    if-eqz p1, :cond_0

    .line 103
    const-string v0, "dismissOnOrientationChange"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 104
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->dismiss()V

    .line 107
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 122
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->inflater:Landroid/view/LayoutInflater;

    .line 124
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v7}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isKindle()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 125
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v7

    invoke-virtual {v7}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v7

    const/16 v8, 0x400

    invoke-virtual {v7, v8}, Landroid/view/Window;->addFlags(I)V

    .line 128
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 130
    .local v0, "args":Landroid/os/Bundle;
    sget v7, Lcom/comcast/cim/android/R$layout;->dlg_default:I

    const/4 v8, 0x0

    invoke-virtual {p1, v7, p2, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v6

    .line 131
    .local v6, "view":Landroid/view/View;
    sget v7, Lcom/comcast/cim/android/R$id;->button_layout:I

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/LinearLayout;

    iput-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    .line 133
    const-string v7, "title"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 134
    .local v5, "title":Ljava/lang/String;
    invoke-virtual {p0, v5, v6}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setTitle(Ljava/lang/String;Landroid/view/View;)V

    .line 135
    const-string v7, "description"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setMessage(Landroid/view/View;Ljava/lang/String;)V

    .line 137
    const-string v7, "tag"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 138
    .local v4, "tag":Ljava/lang/String;
    const-string v7, "errorDlg"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 139
    invoke-direct {p0, v6, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->createDefaultErrorDialogView(Landroid/view/View;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v6

    .line 225
    :cond_1
    :goto_0
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonList:Ljava/util/List;

    if-eqz v7, :cond_9

    .line 226
    const/4 v2, 0x1

    .line 227
    .local v2, "buttonIndex":I
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonList:Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_9

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    .line 228
    .local v1, "button":Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;
    iget-object v8, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    add-int/lit8 v3, v2, 0x1

    .end local v2    # "buttonIndex":I
    .local v3, "buttonIndex":I
    invoke-direct {p0, v8, v2, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;ILcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;)Landroid/widget/Button;

    move v2, v3

    .line 229
    .end local v3    # "buttonIndex":I
    .restart local v2    # "buttonIndex":I
    goto :goto_1

    .line 140
    .end local v1    # "button":Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;
    .end local v2    # "buttonIndex":I
    :cond_2
    const-string v7, "errorDlgXipProvisioning"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 141
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/comcast/cim/android/R$string;->dlg_btn_sign_out:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    new-instance v9, Lcom/comcast/cim/android/view/common/CALDialogFragment$1;

    invoke-direct {v9, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$1;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    invoke-direct {p0, v7, v8, v9}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    goto :goto_0

    .line 149
    :cond_3
    const-string v7, "errorDlgRetryable"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_4

    const-string v7, "errorDlgRetryIgnore"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 150
    :cond_4
    invoke-direct {p0, v4, v6, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->createRetryableErrorDialogView(Ljava/lang/String;Landroid/view/View;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v6

    goto :goto_0

    .line 151
    :cond_5
    const-string v7, "openAnotherAppDlg"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_6

    .line 152
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/comcast/cim/android/R$string;->alert_launch_another_application:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setMessage(Landroid/view/View;Ljava/lang/String;)V

    .line 154
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/comcast/cim/android/R$string;->dlg_btn_ok:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    new-instance v9, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;

    invoke-direct {v9, p0, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$2;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;Landroid/os/Bundle;)V

    invoke-direct {p0, v7, v8, v9}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 168
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/comcast/cim/android/R$string;->dlg_btn_cancel:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    new-instance v9, Lcom/comcast/cim/android/view/common/CALDialogFragment$3;

    invoke-direct {v9, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$3;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    invoke-direct {p0, v7, v8, v9}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    goto/16 :goto_0

    .line 174
    :cond_6
    const-string v7, "hsdPromptDlg"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 175
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/comcast/cim/android/R$string;->HAVE_HIGH_SPEED_INTERNET_QUESTION:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setMessage(Landroid/view/View;Ljava/lang/String;)V

    .line 176
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/comcast/cim/android/R$string;->dlg_btn_yes:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    new-instance v9, Lcom/comcast/cim/android/view/common/CALDialogFragment$4;

    invoke-direct {v9, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$4;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    invoke-direct {p0, v7, v8, v9}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 189
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/comcast/cim/android/R$string;->dlg_btn_no:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    new-instance v9, Lcom/comcast/cim/android/view/common/CALDialogFragment$5;

    invoke-direct {v9, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$5;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    invoke-direct {p0, v7, v8, v9}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    goto/16 :goto_0

    .line 201
    :cond_7
    const-string v7, "messageDlg"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_8

    .line 202
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/comcast/cim/android/R$string;->dlg_btn_ok:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    new-instance v9, Lcom/comcast/cim/android/view/common/CALDialogFragment$6;

    invoke-direct {v9, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$6;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    invoke-direct {p0, v7, v8, v9}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    goto/16 :goto_0

    .line 208
    :cond_8
    const-string v7, "cancelableMessageDlg"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 209
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/comcast/cim/android/R$string;->dlg_btn_ok:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    new-instance v9, Lcom/comcast/cim/android/view/common/CALDialogFragment$7;

    invoke-direct {v9, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$7;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    invoke-direct {p0, v7, v8, v9}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 216
    iget-object v7, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/comcast/cim/android/R$string;->dlg_btn_cancel:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    new-instance v9, Lcom/comcast/cim/android/view/common/CALDialogFragment$8;

    invoke-direct {v9, p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment$8;-><init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V

    invoke-direct {p0, v7, v8, v9}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addButton(Landroid/view/ViewGroup;Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    goto/16 :goto_0

    .line 232
    :cond_9
    if-eqz v6, :cond_a

    .end local v6    # "view":Landroid/view/View;
    :goto_2
    return-object v6

    .restart local v6    # "view":Landroid/view/View;
    :cond_a
    invoke-super {p0, p1, p2, p3}, Landroid/app/DialogFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v6

    goto :goto_2
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 417
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    if-eqz v0, :cond_0

    .line 418
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    invoke-interface {v0, p1}, Landroid/content/DialogInterface$OnDismissListener;->onDismiss(Landroid/content/DialogInterface;)V

    .line 420
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 319
    invoke-super {p0}, Landroid/app/DialogFragment;->onResume()V

    .line 322
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$dimen;->dialog_default_width:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    const/4 v2, -0x2

    invoke-virtual {v0, v1, v2}, Landroid/view/Window;->setLayout(II)V

    .line 323
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 111
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->tryAgainListener:Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;

    if-nez v0, :cond_0

    .line 114
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "dismissOnOrientationChange"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 115
    :cond_0
    const-string v0, "dismissOnOrientationChange"

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 118
    :cond_1
    return-void
.end method

.method public setButtonList(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 412
    .local p1, "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->buttonList:Ljava/util/List;

    .line 413
    return-void
.end method

.method public setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 436
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    .line 437
    return-void
.end method

.method public setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/content/DialogInterface$OnDismissListener;

    .prologue
    .line 432
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    .line 433
    return-void
.end method

.method setTitle(Ljava/lang/String;Landroid/view/View;)V
    .locals 10
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    const/4 v9, 0x1

    .line 332
    const/4 v1, 0x0

    .line 333
    .local v1, "hasTitle":Z
    if-eqz p1, :cond_1

    .line 334
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v6

    invoke-virtual {v6, p1}, Landroid/app/Dialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 335
    const/4 v1, 0x1

    .line 350
    :goto_0
    if-eqz v1, :cond_0

    iget-object v6, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v6}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isKindleOrFromAmazonStore()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 351
    sget v6, Lcom/comcast/cim/android/R$id;->divider:I

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 352
    .local v0, "divider":Landroid/view/View;
    sget v6, Lcom/comcast/cim/android/R$color;->light_blue:I

    invoke-virtual {v0, v6}, Landroid/view/View;->setBackgroundResource(I)V

    .line 353
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 355
    .local v2, "params":Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 356
    .local v4, "r":Landroid/content/res/Resources;
    const/high16 v6, 0x40000000    # 2.0f

    invoke-virtual {v4}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v7

    invoke-static {v9, v6, v7}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v3

    .line 358
    .local v3, "px":F
    float-to-int v6, v3

    iput v6, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 361
    .end local v0    # "divider":Landroid/view/View;
    .end local v2    # "params":Landroid/view/ViewGroup$LayoutParams;
    .end local v3    # "px":F
    .end local v4    # "r":Landroid/content/res/Resources;
    :cond_0
    return-void

    .line 337
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v6

    const-string v7, "tag"

    invoke-virtual {v6, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 338
    .local v5, "tag":Ljava/lang/String;
    const-string v6, "errorDlg"

    invoke-virtual {v5, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 339
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v6

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/comcast/cim/android/R$string;->dlg_title_error:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/app/Dialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 340
    const/4 v1, 0x1

    goto :goto_0

    .line 342
    :cond_2
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6, v9}, Landroid/view/Window;->requestFeature(I)Z

    .line 343
    sget v6, Lcom/comcast/cim/android/R$id;->divider:I

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 344
    .restart local v0    # "divider":Landroid/view/View;
    const/16 v6, 0x8

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public setTryAgainListener(Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)V
    .locals 0
    .param p1, "tryAgainListener"    # Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;

    .prologue
    .line 440
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment;->tryAgainListener:Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;

    .line 441
    return-void
.end method
