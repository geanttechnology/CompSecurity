.class public abstract Lcom/comcast/cim/android/authentication/AuthenticationActivity;
.super Lcom/comcast/cim/android/view/common/BaseActivity;
.source "AuthenticationActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/comcast/cim/model/user/XipUser;",
        "S::",
        "Lcom/comcast/cim/model/user/service/UserSettings;",
        ">",
        "Lcom/comcast/cim/android/view/common/BaseActivity;"
    }
.end annotation


# instance fields
.field private handler:Landroid/os/Handler;

.field private internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private passwordField:Landroid/widget/EditText;

.field private signInListener:Lcom/comcast/cim/android/authentication/SignInListener;

.field private signinButton:Landroid/view/View;

.field private signinButtonLabel:Landroid/widget/TextView;

.field private userIdField:Landroid/widget/EditText;

.field private viewFlipper:Landroid/widget/ViewFlipper;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 36
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;-><init>()V

    .line 58
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getSignInListener()Lcom/comcast/cim/android/authentication/SignInListener;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signInListener:Lcom/comcast/cim/android/authentication/SignInListener;

    .line 60
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->handler:Landroid/os/Handler;

    .line 62
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 315
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Lcom/comcast/cim/model/user/XipUser;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->fetchCurrentUserData()Lcom/comcast/cim/model/user/XipUser;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Lcom/comcast/cim/model/user/XipUser;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;
    .param p1, "x1"    # Lcom/comcast/cim/model/user/XipUser;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->updateUser(Lcom/comcast/cim/model/user/XipUser;)V

    return-void
.end method

.method static synthetic access$200(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Landroid/widget/ViewFlipper;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->viewFlipper:Landroid/widget/ViewFlipper;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)Landroid/content/DialogInterface$OnCancelListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->createSigninErrorCancelListener()Landroid/content/DialogInterface$OnCancelListener;

    move-result-object v0

    return-object v0
.end method

.method private applyListener(II)V
    .locals 2
    .param p1, "viewId"    # I
    .param p2, "urlId"    # I

    .prologue
    .line 138
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 139
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 140
    new-instance v1, Lcom/comcast/cim/android/authentication/AuthenticationActivity$3;

    invoke-direct {v1, p0, p2}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$3;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;I)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 150
    :cond_0
    return-void
.end method

.method private clearIdAndPasswordEditTexts()V
    .locals 1

    .prologue
    .line 177
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->userIdField:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getEditableText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->clear()V

    .line 178
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->passwordField:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getEditableText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->clear()V

    .line 179
    return-void
.end method

.method private createSigninErrorCancelListener()Landroid/content/DialogInterface$OnCancelListener;
    .locals 1

    .prologue
    .line 260
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    new-instance v0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$6;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$6;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V

    return-object v0
.end method

.method private fetchCurrentUserData()Lcom/comcast/cim/model/user/XipUser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 134
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getUserManager()Lcom/comcast/cim/model/user/XipUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/XipUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/model/user/XipUser;

    return-object v0
.end method

.method private prepForSignIn()V
    .locals 2

    .prologue
    .line 163
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    invoke-direct {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->clearIdAndPasswordEditTexts()V

    .line 164
    invoke-virtual {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->hideSigningInSpinner()V

    .line 166
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/comcast/cim/android/authentication/AuthenticationActivity$4;

    invoke-direct {v1, p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$4;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 174
    return-void
.end method

.method private updateUser(Lcom/comcast/cim/model/user/XipUser;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 129
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    .local p1, "user":Lcom/comcast/cim/model/user/XipUser;, "TT;"
    invoke-virtual {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getUserManager()Lcom/comcast/cim/model/user/XipUserManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/comcast/cim/model/user/XipUserManager;->setUser(Lcom/comcast/cim/model/user/User;)V

    .line 130
    return-void
.end method


# virtual methods
.method protected getErrorResourceForException(Ljava/lang/Exception;)I
    .locals 5
    .param p1, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 243
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    sget v1, Lcom/comcast/cim/android/R$string;->UNKNOWN_ERROR:I

    .line 245
    .local v1, "error":I
    instance-of v3, p1, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    if-eqz v3, :cond_2

    move-object v0, p1

    .line 246
    check-cast v0, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    .line 247
    .local v0, "cimHttpException":Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;
    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;->getStatusCode()I

    move-result v2

    .line 248
    .local v2, "errorCode":I
    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;->getDetailedStatusCode()I

    move-result v3

    const/16 v4, 0xbbc

    if-eq v3, v4, :cond_0

    const/16 v3, 0x191

    if-eq v2, v3, :cond_0

    const/16 v3, 0x193

    if-ne v2, v3, :cond_1

    .line 250
    :cond_0
    sget v1, Lcom/comcast/cim/android/R$string;->ENTER_VALID_CREDENTIALS:I

    .line 256
    .end local v0    # "cimHttpException":Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;
    .end local v2    # "errorCode":I
    :cond_1
    :goto_0
    return v1

    .line 252
    :cond_2
    instance-of v3, p1, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 253
    sget v1, Lcom/comcast/cim/android/R$string;->CHECK_INTERNET_CONNECTION:I

    goto :goto_0
.end method

.method protected getPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 189
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->passwordField:Landroid/widget/EditText;

    if-nez v0, :cond_0

    .line 190
    const/4 v0, 0x0

    .line 192
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->passwordField:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected abstract getUserManager()Lcom/comcast/cim/model/user/XipUserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/user/XipUserManager",
            "<TT;TS;>;"
        }
    .end annotation
.end method

.method protected getUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 182
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->userIdField:Landroid/widget/EditText;

    if-nez v0, :cond_0

    .line 183
    const/4 v0, 0x0

    .line 185
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->userIdField:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getWindowToken()Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 304
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->passwordField:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method protected hideSigningInSpinner()V
    .locals 3

    .prologue
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    const/4 v2, 0x1

    .line 204
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signinButton:Landroid/view/View;

    sget v1, Lcom/comcast/cim/android/R$id;->sign_in_progress:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 205
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signinButtonLabel:Landroid/widget/TextView;

    const-string v1, "Sign In"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 206
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->userIdField:Landroid/widget/EditText;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 207
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->passwordField:Landroid/widget/EditText;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 208
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signinButton:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setEnabled(Z)V

    .line 209
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    const/4 v3, 0x0

    .line 68
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 70
    sget v0, Lcom/comcast/cim/android/R$layout;->sign_in:I

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->setContentView(I)V

    .line 72
    sget v0, Lcom/comcast/cim/android/R$id;->password:I

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->passwordField:Landroid/widget/EditText;

    .line 73
    sget v0, Lcom/comcast/cim/android/R$id;->user_id:I

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->userIdField:Landroid/widget/EditText;

    .line 74
    sget v0, Lcom/comcast/cim/android/R$id;->sign_in:I

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signinButton:Landroid/view/View;

    .line 75
    sget v0, Lcom/comcast/cim/android/R$id;->sign_in_label:I

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signinButtonLabel:Landroid/widget/TextView;

    .line 76
    sget v0, Lcom/comcast/cim/android/R$id;->flipper:I

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ViewFlipper;

    iput-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->viewFlipper:Landroid/widget/ViewFlipper;

    .line 78
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->passwordField:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->userIdField:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v1

    invoke-virtual {v0, v1, v3}, Landroid/widget/EditText;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 79
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->passwordField:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signInListener:Lcom/comcast/cim/android/authentication/SignInListener;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 81
    sget v0, Lcom/comcast/cim/android/R$id;->sign_in:I

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signinButton:Landroid/view/View;

    .line 82
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signinButton:Landroid/view/View;

    iget-object v1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signInListener:Lcom/comcast/cim/android/authentication/SignInListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 84
    sget v0, Lcom/comcast/cim/android/R$id;->need_id:I

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/comcast/cim/android/authentication/AuthenticationActivity$1;

    invoke-direct {v1, p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$1;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 92
    sget v0, Lcom/comcast/cim/android/R$id;->forgot_password:I

    sget v1, Lcom/comcast/cim/android/R$string;->URL_FORGOT_PASSWORD:I

    invoke-direct {p0, v0, v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->applyListener(II)V

    .line 94
    sget v0, Lcom/comcast/cim/android/R$id;->need_help_icon:I

    sget v1, Lcom/comcast/cim/android/R$string;->URL_NEED_HELP:I

    invoke-direct {p0, v0, v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->applyListener(II)V

    .line 96
    sget v0, Lcom/comcast/cim/android/R$id;->need_help_signing_in:I

    sget v1, Lcom/comcast/cim/android/R$string;->URL_NEED_HELP:I

    invoke-direct {p0, v0, v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->applyListener(II)V

    .line 98
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->userIdField:Landroid/widget/EditText;

    new-instance v1, Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;

    iget-object v2, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->userIdField:Landroid/widget/EditText;

    invoke-direct {v1, p0, v2}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Landroid/widget/EditText;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 99
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->passwordField:Landroid/widget/EditText;

    new-instance v1, Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;

    iget-object v2, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->passwordField:Landroid/widget/EditText;

    invoke-direct {v1, p0, v2}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Landroid/widget/EditText;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 102
    new-instance v0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;)V

    new-array v1, v3, [Ljava/lang/Void;

    .line 124
    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 126
    return-void
.end method

.method protected onPostSignIn()V
    .locals 0

    .prologue
    .line 287
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    return-void
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 154
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->onResume()V

    .line 155
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->viewFlipper:Landroid/widget/ViewFlipper;

    if-eqz v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->viewFlipper:Landroid/widget/ViewFlipper;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ViewFlipper;->setDisplayedChild(I)V

    .line 159
    :cond_0
    invoke-direct {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->prepForSignIn()V

    .line 160
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 291
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    const/4 v0, 0x0

    return v0
.end method

.method public onSigninFailed(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 212
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 213
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;

    invoke-direct {v1, p0, p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$5;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Ljava/lang/Exception;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 240
    :cond_0
    return-void
.end method

.method public onSigninSuccess(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)V
    .locals 2
    .param p1, "userCredentials"    # Lcom/comcast/cim/android/authentication/UserCredentials;
    .param p2, "authKeys"    # Lcom/comcast/cim/model/user/AuthKeys;

    .prologue
    .line 268
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 269
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/cim/android/authentication/AuthenticationActivity$7;-><init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 279
    :cond_0
    return-void
.end method

.method public showSigningInSpinner()V
    .locals 3

    .prologue
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    const/4 v2, 0x0

    .line 196
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signinButton:Landroid/view/View;

    sget v1, Lcom/comcast/cim/android/R$id;->sign_in_progress:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 197
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signinButtonLabel:Landroid/widget/TextView;

    const-string v1, "Signing In"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 198
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->userIdField:Landroid/widget/EditText;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 199
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->passwordField:Landroid/widget/EditText;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 200
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->signinButton:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setEnabled(Z)V

    .line 201
    return-void
.end method

.method public showZeroLengthDialog()V
    .locals 5

    .prologue
    .line 295
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>;"
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 296
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "description"

    invoke-virtual {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$string;->zero_length_userpass_error:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    const-string v2, "errorDlg"

    invoke-static {v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v1

    .line 299
    .local v1, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 300
    invoke-virtual {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    const-string v3, "caldialogfragment"

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 301
    return-void
.end method
