.class public Lco/vine/android/LoginTwitterActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "LoginTwitterActivity.java"

# interfaces
.implements Landroid/text/TextWatcher;
.implements Lco/vine/android/widget/SpanClickListener;
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/LoginTwitterActivity$LoginTwitterListener;
    }
.end annotation


# static fields
.field private static final DIALOG_ACTIVATE_ACCOUNT:I = 0x1

.field public static final EXTRA_FINISH:Ljava/lang/String; = "finish"

.field public static final EXTRA_SCREEN_NAME:Ljava/lang/String; = "screen_name"

.field public static final EXTRA_SECRET:Ljava/lang/String; = "secret"

.field public static final EXTRA_TOKEN:Ljava/lang/String; = "token"

.field public static final EXTRA_USER_ID:Ljava/lang/String; = "user_id"

.field private static final SPAN_VINE_PP:I = 0x1

.field private static final SPAN_VINE_TOS:I = 0x2

.field private static final STATE_VINE_LOGIN:Ljava/lang/String; = "vine_login"


# instance fields
.field private mFinish:Z

.field private mPassword:Landroid/widget/EditText;

.field private mSignIn:Landroid/view/MenuItem;

.field private mUsername:Landroid/widget/EditText;

.field private mVineLogin:Lco/vine/android/api/VineLogin;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    .line 240
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/LoginTwitterActivity;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/LoginTwitterActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lco/vine/android/LoginTwitterActivity;->login(Z)V

    return-void
.end method

.method static synthetic access$100(Lco/vine/android/LoginTwitterActivity;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/LoginTwitterActivity;

    .prologue
    .line 42
    iget-boolean v0, p0, Lco/vine/android/LoginTwitterActivity;->mFinish:Z

    return v0
.end method

.method static synthetic access$202(Lco/vine/android/LoginTwitterActivity;Lco/vine/android/api/VineLogin;)Lco/vine/android/api/VineLogin;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/LoginTwitterActivity;
    .param p1, "x1"    # Lco/vine/android/api/VineLogin;

    .prologue
    .line 42
    iput-object p1, p0, Lco/vine/android/LoginTwitterActivity;->mVineLogin:Lco/vine/android/api/VineLogin;

    return-object p1
.end method

.method public static getIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 70
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/LoginTwitterActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    return-object v0
.end method

.method public static getIntentWithFinish(Landroid/content/Context;)Landroid/content/Intent;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 74
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/LoginTwitterActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 75
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "finish"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 76
    return-object v0
.end method

.method private login(Z)V
    .locals 9
    .param p1, "reactivate"    # Z

    .prologue
    .line 196
    invoke-direct {p0}, Lco/vine/android/LoginTwitterActivity;->validate()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 197
    new-instance v7, Landroid/app/ProgressDialog;

    const v0, 0x7f0f0037

    invoke-direct {v7, p0, v0}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 198
    .local v7, "dialog":Landroid/app/ProgressDialog;
    const v0, 0x7f0e021d

    invoke-virtual {p0, v0}, Lco/vine/android/LoginTwitterActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 199
    const/4 v0, 0x0

    invoke-virtual {v7, v0}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 201
    :try_start_0
    invoke-virtual {v7}, Landroid/app/ProgressDialog;->show()V
    :try_end_0
    .catch Landroid/view/WindowManager$BadTokenException; {:try_start_0 .. :try_end_0} :catch_0

    .line 205
    :goto_0
    iput-object v7, p0, Lco/vine/android/LoginTwitterActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 206
    if-nez p1, :cond_1

    .line 207
    iget-object v0, p0, Lco/vine/android/LoginTwitterActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/LoginTwitterActivity;->mUsername:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/LoginTwitterActivity;->mPassword:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->loginWithxAuth(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 217
    .end local v7    # "dialog":Landroid/app/ProgressDialog;
    :cond_0
    :goto_1
    return-void

    .line 209
    .restart local v7    # "dialog":Landroid/app/ProgressDialog;
    :cond_1
    iget-object v0, p0, Lco/vine/android/LoginTwitterActivity;->mVineLogin:Lco/vine/android/api/VineLogin;

    if-eqz v0, :cond_2

    .line 210
    iget-object v8, p0, Lco/vine/android/LoginTwitterActivity;->mVineLogin:Lco/vine/android/api/VineLogin;

    .line 211
    .local v8, "login":Lco/vine/android/api/VineLogin;
    iget-object v0, p0, Lco/vine/android/LoginTwitterActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, v8, Lco/vine/android/api/VineLogin;->twitterUsername:Ljava/lang/String;

    iget-object v2, v8, Lco/vine/android/api/VineLogin;->twitterToken:Ljava/lang/String;

    iget-object v3, v8, Lco/vine/android/api/VineLogin;->twitterSecret:Ljava/lang/String;

    iget-wide v4, v8, Lco/vine/android/api/VineLogin;->twitterUserId:J

    const/4 v6, 0x1

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->loginCheckTwitter(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)Ljava/lang/String;

    goto :goto_1

    .line 214
    .end local v8    # "login":Lco/vine/android/api/VineLogin;
    :cond_2
    const v0, 0x7f0e00d0

    invoke-static {p0, v0}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_1

    .line 202
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private validate()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 186
    iget-object v1, p0, Lco/vine/android/LoginTwitterActivity;->mUsername:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->length()I

    move-result v1

    if-lt v1, v0, :cond_0

    iget-object v1, p0, Lco/vine/android/LoginTwitterActivity;->mPassword:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->length()I

    move-result v1

    if-lt v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "editable"    # Landroid/text/Editable;

    .prologue
    .line 183
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 172
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 13
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 80
    const v9, 0x7f0300aa

    const/4 v10, 0x0

    invoke-super {p0, p1, v9, v10}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 82
    const/4 v9, 0x1

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    const/4 v10, 0x1

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    const v11, 0x7f0e012b

    const/4 v12, 0x1

    invoke-static {v12}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v12

    invoke-virtual {p0, v9, v10, v11, v12}, Lco/vine/android/LoginTwitterActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 84
    const v9, 0x7f0a0115

    invoke-virtual {p0, v9}, Lco/vine/android/LoginTwitterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/EditText;

    iput-object v9, p0, Lco/vine/android/LoginTwitterActivity;->mUsername:Landroid/widget/EditText;

    .line 85
    iget-object v9, p0, Lco/vine/android/LoginTwitterActivity;->mUsername:Landroid/widget/EditText;

    invoke-static {p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v10

    const/4 v11, 0x0

    const/4 v12, 0x2

    invoke-virtual {v10, v11, v12}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/EditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 87
    iget-object v9, p0, Lco/vine/android/LoginTwitterActivity;->mUsername:Landroid/widget/EditText;

    invoke-virtual {v9, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 89
    const v9, 0x7f0a0118

    invoke-virtual {p0, v9}, Lco/vine/android/LoginTwitterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/EditText;

    iput-object v9, p0, Lco/vine/android/LoginTwitterActivity;->mPassword:Landroid/widget/EditText;

    .line 90
    iget-object v9, p0, Lco/vine/android/LoginTwitterActivity;->mPassword:Landroid/widget/EditText;

    invoke-static {p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v10

    const/4 v11, 0x0

    const/4 v12, 0x2

    invoke-virtual {v10, v11, v12}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/EditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 92
    iget-object v9, p0, Lco/vine/android/LoginTwitterActivity;->mPassword:Landroid/widget/EditText;

    invoke-virtual {v9, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 94
    iget-object v9, p0, Lco/vine/android/LoginTwitterActivity;->mPassword:Landroid/widget/EditText;

    new-instance v10, Lco/vine/android/LoginTwitterActivity$1;

    invoke-direct {v10, p0}, Lco/vine/android/LoginTwitterActivity$1;-><init>(Lco/vine/android/LoginTwitterActivity;)V

    invoke-virtual {v9, v10}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 103
    invoke-virtual {p0}, Lco/vine/android/LoginTwitterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v9

    const-string v10, "finish"

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v9

    iput-boolean v9, p0, Lco/vine/android/LoginTwitterActivity;->mFinish:Z

    .line 105
    new-instance v9, Lco/vine/android/LoginTwitterActivity$LoginTwitterListener;

    invoke-direct {v9, p0}, Lco/vine/android/LoginTwitterActivity$LoginTwitterListener;-><init>(Lco/vine/android/LoginTwitterActivity;)V

    iput-object v9, p0, Lco/vine/android/LoginTwitterActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 107
    const v9, 0x7f0a021e

    invoke-virtual {p0, v9}, Lco/vine/android/LoginTwitterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 108
    .local v4, "mTos":Landroid/widget/TextView;
    const/4 v9, 0x2

    new-array v0, v9, [Landroid/text/style/StyleSpan;

    const/4 v9, 0x0

    new-instance v10, Landroid/text/style/StyleSpan;

    const/4 v11, 0x1

    invoke-direct {v10, v11}, Landroid/text/style/StyleSpan;-><init>(I)V

    aput-object v10, v0, v9

    const/4 v9, 0x1

    new-instance v10, Landroid/text/style/StyleSpan;

    const/4 v11, 0x1

    invoke-direct {v10, v11}, Landroid/text/style/StyleSpan;-><init>(I)V

    aput-object v10, v0, v9

    .line 110
    .local v0, "boldStyle":[Landroid/text/style/StyleSpan;
    const v9, 0x7f0e012d

    invoke-virtual {p0, v9}, Lco/vine/android/LoginTwitterActivity;->getString(I)Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x22

    invoke-static {v0, v9, v10}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v6

    .line 113
    .local v6, "spanned":Landroid/text/Spanned;
    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 114
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v9

    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 116
    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    check-cast v1, Landroid/text/Spannable;

    .line 117
    .local v1, "clickSpannable":Landroid/text/Spannable;
    const/4 v9, 0x0

    invoke-interface {v6}, Landroid/text/Spanned;->length()I

    move-result v10

    const-class v11, Landroid/text/style/StyleSpan;

    invoke-interface {v6, v9, v10, v11}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Landroid/text/style/StyleSpan;

    .line 118
    .local v7, "spans":[Landroid/text/style/StyleSpan;
    invoke-virtual {p0}, Lco/vine/android/LoginTwitterActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 121
    .local v5, "res":Landroid/content/res/Resources;
    const/4 v9, 0x0

    aget-object v9, v7, v9

    invoke-interface {v6, v9}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v8

    .line 122
    .local v8, "start":I
    const/4 v9, 0x0

    aget-object v9, v7, v9

    invoke-interface {v6, v9}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v3

    .line 123
    .local v3, "end":I
    new-instance v2, Lco/vine/android/widget/StyledClickableSpan;

    const/4 v9, 0x2

    const/4 v10, 0x0

    invoke-direct {v2, v9, v10, p0}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 125
    .local v2, "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    const v9, 0x7f09008d

    invoke-virtual {v5, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v2, v9}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 126
    const/16 v9, 0x21

    invoke-static {v1, v2, v8, v3, v9}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 129
    if-eqz p1, :cond_0

    const-string v9, "vine_login"

    invoke-virtual {p1, v9}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 130
    const-string v9, "vine_login"

    invoke-virtual {p1, v9}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v9

    check-cast v9, Lco/vine/android/api/VineLogin;

    iput-object v9, p0, Lco/vine/android/LoginTwitterActivity;->mVineLogin:Lco/vine/android/api/VineLogin;

    .line 134
    :cond_0
    const/4 v9, 0x1

    aget-object v9, v7, v9

    invoke-interface {v6, v9}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v8

    .line 135
    const/4 v9, 0x1

    aget-object v9, v7, v9

    invoke-interface {v6, v9}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v3

    .line 136
    new-instance v2, Lco/vine/android/widget/StyledClickableSpan;

    .end local v2    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    const/4 v9, 0x1

    const/4 v10, 0x0

    invoke-direct {v2, v9, v10, p0}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 137
    .restart local v2    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    const v9, 0x7f09008d

    invoke-virtual {v5, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v2, v9}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 138
    const/16 v9, 0x21

    invoke-static {v1, v2, v8, v3, v9}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 140
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 152
    invoke-virtual {p0}, Lco/vine/android/LoginTwitterActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v1, 0x7f100008

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 153
    const v0, 0x7f0a0248

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/LoginTwitterActivity;->mSignIn:Landroid/view/MenuItem;

    .line 154
    const/4 v0, 0x1

    return v0
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 221
    packed-switch p2, :pswitch_data_0

    .line 238
    :goto_0
    return-void

    .line 223
    :pswitch_0
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 225
    :pswitch_1
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/LoginTwitterActivity;->login(Z)V

    goto :goto_0

    .line 221
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch

    .line 223
    :pswitch_data_1
    .packed-switch -0x1
        :pswitch_1
    .end packed-switch
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 159
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 165
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 161
    :pswitch_0
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/LoginTwitterActivity;->login(Z)V

    .line 162
    const/4 v0, 0x1

    goto :goto_0

    .line 159
    :pswitch_data_0
    .packed-switch 0x7f0a0248
        :pswitch_0
    .end packed-switch
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 144
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 145
    iget-object v0, p0, Lco/vine/android/LoginTwitterActivity;->mVineLogin:Lco/vine/android/api/VineLogin;

    if-eqz v0, :cond_0

    .line 146
    const-string v0, "vine_login"

    iget-object v1, p0, Lco/vine/android/LoginTwitterActivity;->mVineLogin:Lco/vine/android/api/VineLogin;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 148
    :cond_0
    return-void
.end method

.method public onSpanClicked(Landroid/view/View;ILjava/lang/Object;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/Object;

    .prologue
    .line 326
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/WebViewActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 327
    .local v0, "i":Landroid/content/Intent;
    packed-switch p2, :pswitch_data_0

    .line 341
    :goto_0
    return-void

    .line 329
    :pswitch_0
    const-string v1, "type"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 340
    :goto_1
    invoke-virtual {p0, v0}, Lco/vine/android/LoginTwitterActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 333
    :pswitch_1
    const-string v1, "type"

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    goto :goto_1

    .line 327
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 176
    iget-object v0, p0, Lco/vine/android/LoginTwitterActivity;->mSignIn:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 177
    iget-object v0, p0, Lco/vine/android/LoginTwitterActivity;->mSignIn:Landroid/view/MenuItem;

    invoke-direct {p0}, Lco/vine/android/LoginTwitterActivity;->validate()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 179
    :cond_0
    return-void
.end method
