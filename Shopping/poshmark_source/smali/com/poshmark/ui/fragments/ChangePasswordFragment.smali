.class public Lcom/poshmark/ui/fragments/ChangePasswordFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ChangePasswordFragment.java"


# instance fields
.field isPasswordSet:Z

.field private newPassword:Lcom/poshmark/ui/customviews/PMEditText;

.field private newPasswordCopy:Lcom/poshmark/ui/customviews/PMEditText;

.field private originalPassword:Lcom/poshmark/ui/customviews/PMEditText;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 31
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->isPasswordSet:Z

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->updateView()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->isFormValid()Z

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)Lcom/poshmark/ui/customviews/PMEditText;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->originalPassword:Lcom/poshmark/ui/customviews/PMEditText;

    return-object v0
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)Lcom/poshmark/ui/customviews/PMEditText;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPassword:Lcom/poshmark/ui/customviews/PMEditText;

    return-object v0
.end method

.method private checkIfPasswordIsSet()V
    .locals 1

    .prologue
    .line 64
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 65
    new-instance v0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment$1;-><init>(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->checkIfPasswordSet(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 80
    return-void
.end method

.method private isFormValid()Z
    .locals 4

    .prologue
    const/4 v1, 0x1

    .line 145
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 146
    .local v0, "validateTxt":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->originalPassword:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v2

    if-nez v2, :cond_0

    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->isPasswordSet:Z

    if-eqz v2, :cond_0

    .line 147
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->originalPassword:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v3, v1}, Lcom/poshmark/ui/customviews/PMEditText;->getValidatorString(Z)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 150
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPassword:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v2

    if-nez v2, :cond_3

    .line 151
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPassword:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 156
    :cond_1
    :goto_0
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    .line 157
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060148

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    const/4 v1, 0x0

    .line 161
    :cond_2
    return v1

    .line 152
    :cond_3
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPassword:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPasswordCopy:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 153
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const v3, 0x7f0601c2

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private setupNextActionButton()V
    .locals 2

    .prologue
    .line 83
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v0

    .line 84
    .local v0, "nextActionButton":Landroid/widget/Button;
    if-nez v0, :cond_0

    .line 117
    :goto_0
    return-void

    .line 87
    :cond_0
    const v1, 0x7f0600bf

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 88
    new-instance v1, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;-><init>(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method private setupViews()V
    .locals 3

    .prologue
    .line 120
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->getView()Landroid/view/View;

    move-result-object v0

    .line 121
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->originalPassword:Lcom/poshmark/ui/customviews/PMEditText;

    .line 122
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->originalPassword:Lcom/poshmark/ui/customviews/PMEditText;

    sget-object v2, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 123
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->originalPassword:Lcom/poshmark/ui/customviews/PMEditText;

    new-instance v2, Landroid/text/method/PasswordTransformationMethod;

    invoke-direct {v2}, Landroid/text/method/PasswordTransformationMethod;-><init>()V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setTransformationMethod(Landroid/text/method/TransformationMethod;)V

    .line 125
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->originalPassword:Lcom/poshmark/ui/customviews/PMEditText;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setVisibility(I)V

    .line 127
    const v1, 0x7f0c009f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPassword:Lcom/poshmark/ui/customviews/PMEditText;

    .line 128
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPassword:Lcom/poshmark/ui/customviews/PMEditText;

    sget-object v2, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 129
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPassword:Lcom/poshmark/ui/customviews/PMEditText;

    new-instance v2, Landroid/text/method/PasswordTransformationMethod;

    invoke-direct {v2}, Landroid/text/method/PasswordTransformationMethod;-><init>()V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setTransformationMethod(Landroid/text/method/TransformationMethod;)V

    .line 131
    const v1, 0x7f0c00a0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPasswordCopy:Lcom/poshmark/ui/customviews/PMEditText;

    .line 132
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPasswordCopy:Lcom/poshmark/ui/customviews/PMEditText;

    sget-object v2, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 133
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPasswordCopy:Lcom/poshmark/ui/customviews/PMEditText;

    new-instance v2, Landroid/text/method/PasswordTransformationMethod;

    invoke-direct {v2}, Landroid/text/method/PasswordTransformationMethod;-><init>()V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setTransformationMethod(Landroid/text/method/TransformationMethod;)V

    .line 134
    return-void
.end method

.method private updateView()V
    .locals 3

    .prologue
    .line 137
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->isPasswordSet:Z

    if-eqz v1, :cond_0

    .line 138
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->getView()Landroid/view/View;

    move-result-object v0

    .line 139
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->originalPassword:Lcom/poshmark/ui/customviews/PMEditText;

    .line 140
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->originalPassword:Lcom/poshmark/ui/customviews/PMEditText;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditText;->setVisibility(I)V

    .line 142
    .end local v0    # "v":Landroid/view/View;
    :cond_0
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 47
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 48
    const v0, 0x7f060077

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->setTitle(I)V

    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->checkIfPasswordIsSet()V

    .line 50
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->setupViews()V

    .line 51
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 35
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 36
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 40
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 41
    const v1, 0x7f030021

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 42
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 60
    const-string v0, "change_password_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 61
    return-void
.end method

.method public setupActionBar()V
    .locals 0

    .prologue
    .line 55
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 56
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->setupNextActionButton()V

    .line 57
    return-void
.end method
