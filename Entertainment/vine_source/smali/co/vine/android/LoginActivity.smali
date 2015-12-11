.class public Lco/vine/android/LoginActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "LoginActivity.java"

# interfaces
.implements Landroid/text/TextWatcher;
.implements Landroid/view/View$OnClickListener;
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/LoginActivity$LoginSessionListener;
    }
.end annotation


# static fields
.field private static final DIALOG_ACTIVATE_ACCOUNT:I = 0x1

.field public static final EXTRA_FINISH:Ljava/lang/String; = "finish"


# instance fields
.field private mFinish:Z

.field private mLoginButton:Landroid/view/MenuItem;

.field private mPassword:Landroid/widget/EditText;

.field private mUsername:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    .line 238
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/LoginActivity;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/LoginActivity;

    .prologue
    .line 35
    invoke-direct {p0}, Lco/vine/android/LoginActivity;->validate()Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lco/vine/android/LoginActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/LoginActivity;

    .prologue
    .line 35
    iget-object v0, p0, Lco/vine/android/LoginActivity;->mPassword:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/LoginActivity;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/LoginActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lco/vine/android/LoginActivity;->login(Z)V

    return-void
.end method

.method public static getIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 52
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/LoginActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    return-object v0
.end method

.method public static getIntentWithFinish(Landroid/content/Context;)Landroid/content/Intent;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 56
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/LoginActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 57
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "finish"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 58
    return-object v0
.end method

.method private login(Z)V
    .locals 9
    .param p1, "reactivate"    # Z

    .prologue
    const/4 v1, 0x0

    .line 152
    iget-object v3, p0, Lco/vine/android/LoginActivity;->mUsername:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 153
    .local v2, "username":Ljava/lang/String;
    iget-object v3, p0, Lco/vine/android/LoginActivity;->mPassword:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 154
    .local v7, "password":Ljava/lang/String;
    new-instance v6, Landroid/app/ProgressDialog;

    const v3, 0x7f0f0037

    invoke-direct {v6, p0, v3}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 155
    .local v6, "dialog":Landroid/app/ProgressDialog;
    const/4 v3, 0x0

    invoke-virtual {v6, v3}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 156
    const v3, 0x7f0e0120

    invoke-virtual {p0, v3}, Lco/vine/android/LoginActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v6, v3}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 158
    :try_start_0
    invoke-virtual {v6}, Landroid/app/ProgressDialog;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 162
    :goto_0
    iput-object v6, p0, Lco/vine/android/LoginActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 164
    iget-object v3, p0, Lco/vine/android/LoginActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3, v2}, Lco/vine/android/client/AppController;->getSession(Ljava/lang/String;)Lco/vine/android/client/Session;

    move-result-object v8

    .line 165
    .local v8, "s":Lco/vine/android/client/Session;
    new-instance v0, Lco/vine/android/api/VineLogin;

    const-wide/16 v3, 0x0

    move-object v5, v1

    invoke-direct/range {v0 .. v5}, Lco/vine/android/api/VineLogin;-><init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V

    .line 167
    .local v0, "login":Lco/vine/android/api/VineLogin;
    iget-object v1, p0, Lco/vine/android/LoginActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1, v8, v0, v7, p1}, Lco/vine/android/client/AppController;->login(Lco/vine/android/client/Session;Lco/vine/android/api/VineLogin;Ljava/lang/String;Z)Ljava/lang/String;

    .line 168
    return-void

    .line 159
    .end local v0    # "login":Lco/vine/android/api/VineLogin;
    .end local v8    # "s":Lco/vine/android/client/Session;
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method private validate()Z
    .locals 2

    .prologue
    .line 147
    iget-object v0, p0, Lco/vine/android/LoginActivity;->mUsername:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    const/4 v1, 0x3

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lco/vine/android/LoginActivity;->mPassword:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    const/16 v1, 0x8

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2
    .param p1, "editable"    # Landroid/text/Editable;

    .prologue
    .line 119
    iget-object v0, p0, Lco/vine/android/LoginActivity;->mLoginButton:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 120
    iget-object v0, p0, Lco/vine/android/LoginActivity;->mLoginButton:Landroid/view/MenuItem;

    invoke-direct {p0}, Lco/vine/android/LoginActivity;->validate()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 122
    :cond_0
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 111
    return-void
.end method

.method completeLogin(ILjava/lang/String;I)V
    .locals 2
    .param p1, "statusCode"    # I
    .param p2, "reason"    # Ljava/lang/String;
    .param p3, "errorCode"    # I

    .prologue
    .line 171
    packed-switch p1, :pswitch_data_0

    .line 180
    sget-object v1, Lco/vine/android/api/VineError$VineKnownErrors;->ACCOUNT_DEACTIVATED:Lco/vine/android/api/VineError$VineKnownErrors;

    iget v1, v1, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    if-ne p3, v1, :cond_1

    .line 181
    const/4 v1, 0x1

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v0

    .line 183
    .local v0, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v1, 0x7f0e01ce

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 184
    const v1, 0x7f0e01cf

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 185
    const v1, 0x7f0e0057

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 186
    const v1, 0x7f0e01cd

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 187
    invoke-virtual {p0}, Lco/vine/android/LoginActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    .line 194
    .end local v0    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :goto_0
    return-void

    .line 173
    :pswitch_0
    iget-boolean v1, p0, Lco/vine/android/LoginActivity;->mFinish:Z

    if-nez v1, :cond_0

    .line 174
    invoke-static {p0}, Lco/vine/android/StartActivity;->toStart(Landroid/content/Context;)V

    .line 176
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/LoginActivity;->finish()V

    goto :goto_0

    .line 189
    :cond_1
    invoke-static {p0, p2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 171
    nop

    :pswitch_data_0
    .packed-switch 0xc8
        :pswitch_0
    .end packed-switch
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 198
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 212
    :goto_0
    return-void

    .line 200
    :pswitch_0
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lco/vine/android/ResetPasswordActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 201
    .local v1, "i":Landroid/content/Intent;
    iget-object v2, p0, Lco/vine/android/LoginActivity;->mUsername:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 202
    .local v0, "email":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 203
    const-string v2, "email"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 205
    :cond_0
    invoke-virtual {p0, v1}, Lco/vine/android/LoginActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 198
    :pswitch_data_0
    .packed-switch 0x7f0a011a
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 11
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 63
    const v4, 0x7f030051

    invoke-super {p0, p1, v4, v8}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 65
    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    const v6, 0x7f0e0123

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {p0, v4, v5, v6, v7}, Lco/vine/android/LoginActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 67
    new-instance v4, Lco/vine/android/LoginActivity$LoginSessionListener;

    invoke-direct {v4, p0}, Lco/vine/android/LoginActivity$LoginSessionListener;-><init>(Lco/vine/android/LoginActivity;)V

    iput-object v4, p0, Lco/vine/android/LoginActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 69
    const v4, 0x7f0a0115

    invoke-virtual {p0, v4}, Lco/vine/android/LoginActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lco/vine/android/LoginActivity;->mUsername:Landroid/widget/EditText;

    .line 70
    iget-object v4, p0, Lco/vine/android/LoginActivity;->mUsername:Landroid/widget/EditText;

    invoke-static {p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v5

    invoke-virtual {v5, v8, v10}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 72
    iget-object v4, p0, Lco/vine/android/LoginActivity;->mUsername:Landroid/widget/EditText;

    invoke-virtual {v4, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 74
    const v4, 0x7f0a0118

    invoke-virtual {p0, v4}, Lco/vine/android/LoginActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lco/vine/android/LoginActivity;->mPassword:Landroid/widget/EditText;

    .line 75
    iget-object v4, p0, Lco/vine/android/LoginActivity;->mPassword:Landroid/widget/EditText;

    invoke-static {p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v5

    invoke-virtual {v5, v8, v10}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 77
    iget-object v4, p0, Lco/vine/android/LoginActivity;->mPassword:Landroid/widget/EditText;

    invoke-virtual {v4, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 79
    iget-object v4, p0, Lco/vine/android/LoginActivity;->mPassword:Landroid/widget/EditText;

    new-instance v5, Lco/vine/android/LoginActivity$1;

    invoke-direct {v5, p0}, Lco/vine/android/LoginActivity$1;-><init>(Lco/vine/android/LoginActivity;)V

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 91
    new-array v2, v9, [Landroid/text/style/StyleSpan;

    new-instance v4, Landroid/text/style/StyleSpan;

    invoke-direct {v4, v9}, Landroid/text/style/StyleSpan;-><init>(I)V

    aput-object v4, v2, v8

    .line 93
    .local v2, "mStyleSpanBoldSingle":[Landroid/text/style/StyleSpan;
    const v4, 0x7f0a011a

    invoke-virtual {p0, v4}, Lco/vine/android/LoginActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 94
    .local v1, "mResetPassword":Landroid/widget/TextView;
    const v4, 0x7f0e011f

    invoke-virtual {p0, v4}, Lco/vine/android/LoginActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 95
    .local v3, "resetText":Ljava/lang/String;
    const/16 v4, 0x22

    invoke-static {v2, v3, v4}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v4

    sget-object v5, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {v1, v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 98
    invoke-virtual {v1, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 100
    invoke-virtual {p0}, Lco/vine/android/LoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 101
    .local v0, "i":Landroid/content/Intent;
    if-eqz v0, :cond_0

    .line 102
    const-string v4, "finish"

    invoke-virtual {v0, v4, v8}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v4

    iput-boolean v4, p0, Lco/vine/android/LoginActivity;->mFinish:Z

    .line 106
    :goto_0
    return-void

    .line 104
    :cond_0
    iput-boolean v8, p0, Lco/vine/android/LoginActivity;->mFinish:Z

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 126
    invoke-virtual {p0}, Lco/vine/android/LoginActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v1, 0x7f100008

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 127
    const v0, 0x7f0a0248

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/LoginActivity;->mLoginButton:Landroid/view/MenuItem;

    .line 128
    const/4 v0, 0x1

    return v0
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 216
    packed-switch p2, :pswitch_data_0

    .line 236
    :goto_0
    :pswitch_0
    return-void

    .line 218
    :pswitch_1
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 220
    :pswitch_2
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/LoginActivity;->login(Z)V

    goto :goto_0

    .line 216
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
    .end packed-switch

    .line 218
    :pswitch_data_1
    .packed-switch -0x2
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 133
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 141
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 135
    :pswitch_0
    invoke-direct {p0}, Lco/vine/android/LoginActivity;->validate()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 136
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/LoginActivity;->login(Z)V

    .line 138
    :cond_0
    const/4 v0, 0x1

    goto :goto_0

    .line 133
    :pswitch_data_0
    .packed-switch 0x7f0a0248
        :pswitch_0
    .end packed-switch
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 115
    return-void
.end method
