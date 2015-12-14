.class public Lcom/livemixtapes/Login;
.super Landroid/app/Activity;
.source "Login.java"


# instance fields
.field private continueAsGuest:Landroid/widget/TextView;

.field private forgotPassword:Landroid/widget/TextView;

.field private layout:Landroid/widget/LinearLayout;

.field private loading:Ljava/lang/Boolean;

.field private loginBtn:Landroid/widget/FrameLayout;

.field private loginLoading:Landroid/widget/ProgressBar;

.field mRegisterTask:Landroid/os/AsyncTask;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/AsyncTask",
            "<",
            "Ljava/lang/Void;",
            "Ljava/lang/Void;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private password:Landroid/widget/EditText;

.field private passwordBox:Landroid/widget/LinearLayout;

.field private passwordClear:Landroid/widget/ImageButton;

.field private signupBtn:Landroid/widget/Button;

.field private username:Landroid/widget/EditText;

.field private usernameBox:Landroid/widget/LinearLayout;

.field private usernameClear:Landroid/widget/ImageButton;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 48
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 56
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Login;->loading:Ljava/lang/Boolean;

    .line 48
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/Login;)V
    .locals 0

    .prologue
    .line 239
    invoke-direct {p0}, Lcom/livemixtapes/Login;->hideKeyboards()V

    return-void
.end method

.method static synthetic access$1(Lcom/livemixtapes/Login;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 234
    invoke-direct {p0, p1}, Lcom/livemixtapes/Login;->hideKeyboard(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$10(Lcom/livemixtapes/Login;)V
    .locals 0

    .prologue
    .line 317
    invoke-direct {p0}, Lcom/livemixtapes/Login;->login()V

    return-void
.end method

.method static synthetic access$11(Lcom/livemixtapes/Login;)V
    .locals 0

    .prologue
    .line 288
    invoke-direct {p0}, Lcom/livemixtapes/Login;->openSignup()V

    return-void
.end method

.method static synthetic access$12(Lcom/livemixtapes/Login;)V
    .locals 0

    .prologue
    .line 284
    invoke-direct {p0}, Lcom/livemixtapes/Login;->openRadio()V

    return-void
.end method

.method static synthetic access$13(Lcom/livemixtapes/Login;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 244
    invoke-direct {p0, p1}, Lcom/livemixtapes/Login;->showKeyboard(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$14(Lcom/livemixtapes/Login;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/livemixtapes/Login;->loading:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$15(Lcom/livemixtapes/Login;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/livemixtapes/Login;->loginLoading:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$16(Lcom/livemixtapes/Login;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 359
    invoke-direct {p0, p1, p2}, Lcom/livemixtapes/Login;->showDialog(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$17(Lcom/livemixtapes/Login;Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 253
    invoke-direct {p0, p1, p2}, Lcom/livemixtapes/Login;->shake(Landroid/view/View;Ljava/lang/Runnable;)V

    return-void
.end method

.method static synthetic access$2(Lcom/livemixtapes/Login;)Landroid/widget/FrameLayout;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/livemixtapes/Login;->loginBtn:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method static synthetic access$3(Lcom/livemixtapes/Login;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$4(Lcom/livemixtapes/Login;)Landroid/widget/ImageButton;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/livemixtapes/Login;->usernameClear:Landroid/widget/ImageButton;

    return-object v0
.end method

.method static synthetic access$5(Lcom/livemixtapes/Login;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$6(Lcom/livemixtapes/Login;)Landroid/widget/ImageButton;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/livemixtapes/Login;->passwordClear:Landroid/widget/ImageButton;

    return-object v0
.end method

.method static synthetic access$7(Lcom/livemixtapes/Login;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/livemixtapes/Login;->usernameBox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$8(Lcom/livemixtapes/Login;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 249
    invoke-direct {p0, p1}, Lcom/livemixtapes/Login;->shake(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$9(Lcom/livemixtapes/Login;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/livemixtapes/Login;->passwordBox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method private hideKeyboard(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 235
    const-string v1, "input_method"

    invoke-virtual {p0, v1}, Lcom/livemixtapes/Login;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 236
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    invoke-virtual {p1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 237
    return-void
.end method

.method private hideKeyboards()V
    .locals 1

    .prologue
    .line 240
    iget-object v0, p0, Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/Login;->hideKeyboard(Landroid/view/View;)V

    .line 241
    iget-object v0, p0, Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/Login;->hideKeyboard(Landroid/view/View;)V

    .line 242
    return-void
.end method

.method private login()V
    .locals 3

    .prologue
    .line 318
    iget-object v0, p0, Lcom/livemixtapes/Login;->loading:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 357
    :goto_0
    return-void

    .line 321
    :cond_0
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Login;->loading:Ljava/lang/Boolean;

    .line 322
    iget-object v0, p0, Lcom/livemixtapes/Login;->loginLoading:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 324
    iget-object v0, p0, Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v0

    .line 325
    iget-object v1, p0, Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v1

    .line 327
    new-instance v2, Lcom/livemixtapes/Login$14;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$14;-><init>(Lcom/livemixtapes/Login;)V

    .line 324
    invoke-static {v0, v1, v2}, Lcom/livemixtapes/User;->login(Ljava/lang/String;Ljava/lang/String;Lcom/livemixtapes/User$UserCallback;)V

    goto :goto_0
.end method

.method private openRadio()V
    .locals 2

    .prologue
    .line 285
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/livemixtapes/MainActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->startActivity(Landroid/content/Intent;)V

    .line 286
    return-void
.end method

.method private openSignup()V
    .locals 2

    .prologue
    .line 289
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/livemixtapes/SignUp;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->startActivity(Landroid/content/Intent;)V

    .line 290
    return-void
.end method

.method private refresh()V
    .locals 2

    .prologue
    .line 293
    iget-object v0, p0, Lcom/livemixtapes/Login;->loading:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 315
    :goto_0
    return-void

    .line 296
    :cond_0
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Login;->loading:Ljava/lang/Boolean;

    .line 297
    iget-object v0, p0, Lcom/livemixtapes/Login;->loginLoading:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 299
    new-instance v0, Lcom/livemixtapes/Login$13;

    invoke-direct {v0, p0}, Lcom/livemixtapes/Login$13;-><init>(Lcom/livemixtapes/Login;)V

    invoke-static {v0}, Lcom/livemixtapes/User;->refresh(Lcom/livemixtapes/User$UserCallback;)V

    goto :goto_0
.end method

.method private setListeners()V
    .locals 3

    .prologue
    .line 99
    new-instance v0, Lcom/livemixtapes/Login$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/Login$1;-><init>(Lcom/livemixtapes/Login;)V

    .line 108
    .local v0, "keyboardHider":Landroid/view/View$OnFocusChangeListener;
    iget-object v1, p0, Lcom/livemixtapes/Login;->layout:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 110
    iget-object v1, p0, Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;

    new-instance v2, Lcom/livemixtapes/Login$2;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$2;-><init>(Lcom/livemixtapes/Login;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 119
    iget-object v1, p0, Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;

    new-instance v2, Lcom/livemixtapes/Login$3;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$3;-><init>(Lcom/livemixtapes/Login;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 133
    iget-object v1, p0, Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;

    new-instance v2, Lcom/livemixtapes/Login$4;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$4;-><init>(Lcom/livemixtapes/Login;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 154
    iget-object v1, p0, Lcom/livemixtapes/Login;->usernameClear:Landroid/widget/ImageButton;

    new-instance v2, Lcom/livemixtapes/Login$5;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$5;-><init>(Lcom/livemixtapes/Login;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 162
    iget-object v1, p0, Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;

    new-instance v2, Lcom/livemixtapes/Login$6;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$6;-><init>(Lcom/livemixtapes/Login;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 183
    iget-object v1, p0, Lcom/livemixtapes/Login;->passwordClear:Landroid/widget/ImageButton;

    new-instance v2, Lcom/livemixtapes/Login$7;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$7;-><init>(Lcom/livemixtapes/Login;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 191
    iget-object v1, p0, Lcom/livemixtapes/Login;->loginBtn:Landroid/widget/FrameLayout;

    new-instance v2, Lcom/livemixtapes/Login$8;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$8;-><init>(Lcom/livemixtapes/Login;)V

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 210
    iget-object v1, p0, Lcom/livemixtapes/Login;->signupBtn:Landroid/widget/Button;

    new-instance v2, Lcom/livemixtapes/Login$9;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$9;-><init>(Lcom/livemixtapes/Login;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 218
    iget-object v1, p0, Lcom/livemixtapes/Login;->forgotPassword:Landroid/widget/TextView;

    new-instance v2, Lcom/livemixtapes/Login$10;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$10;-><init>(Lcom/livemixtapes/Login;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 225
    iget-object v1, p0, Lcom/livemixtapes/Login;->continueAsGuest:Landroid/widget/TextView;

    new-instance v2, Lcom/livemixtapes/Login$11;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$11;-><init>(Lcom/livemixtapes/Login;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 232
    return-void
.end method

.method private shake(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 250
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/livemixtapes/Login;->shake(Landroid/view/View;Ljava/lang/Runnable;)V

    .line 251
    return-void
.end method

.method private shake(Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "callback"    # Ljava/lang/Runnable;

    .prologue
    .line 254
    const v1, 0x7f04000a

    invoke-static {p0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 256
    .local v0, "anim":Landroid/view/animation/Animation;
    new-instance v1, Lcom/livemixtapes/Login$12;

    invoke-direct {v1, p0, p2}, Lcom/livemixtapes/Login$12;-><init>(Lcom/livemixtapes/Login;Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 281
    invoke-virtual {p1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 282
    return-void
.end method

.method private showDialog(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 360
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 361
    const-string v1, "OK"

    new-instance v2, Lcom/livemixtapes/Login$15;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$15;-><init>(Lcom/livemixtapes/Login;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 366
    const v1, 0x1080027

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 367
    return-void
.end method

.method private showKeyboard(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 245
    const-string v1, "input_method"

    invoke-virtual {p0, v1}, Lcom/livemixtapes/Login;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 246
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 247
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x1

    .line 61
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    new-array v0, v3, [Ljava/lang/Object;

    const/4 v1, 0x0

    .line 62
    const-string v2, "LOGIN ACTIVITY"

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 63
    invoke-virtual {p0, v3}, Lcom/livemixtapes/Login;->requestWindowFeature(I)Z

    .line 65
    const v0, 0x7f030023

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->setContentView(I)V

    .line 67
    const v0, 0x7f080084

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/Login;->layout:Landroid/widget/LinearLayout;

    .line 70
    :try_start_0
    iget-object v0, p0, Lcom/livemixtapes/Login;->layout:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lcom/livemixtapes/App;->scaleViewGroup(Landroid/view/ViewGroup;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 76
    :goto_0
    const v0, 0x7f08008c

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/livemixtapes/Login;->loginBtn:Landroid/widget/FrameLayout;

    .line 77
    const v0, 0x7f08008f

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/livemixtapes/Login;->signupBtn:Landroid/widget/Button;

    .line 79
    const v0, 0x7f080087

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;

    .line 80
    const v0, 0x7f08008a

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;

    .line 82
    const v0, 0x7f08008e

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/Login;->forgotPassword:Landroid/widget/TextView;

    .line 83
    const v0, 0x7f080090

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/Login;->continueAsGuest:Landroid/widget/TextView;

    .line 85
    const v0, 0x7f080086

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/Login;->usernameBox:Landroid/widget/LinearLayout;

    .line 86
    const v0, 0x7f080089

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/Login;->passwordBox:Landroid/widget/LinearLayout;

    .line 88
    const v0, 0x7f080088

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/Login;->usernameClear:Landroid/widget/ImageButton;

    .line 89
    const v0, 0x7f08008b

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/Login;->passwordClear:Landroid/widget/ImageButton;

    .line 91
    const v0, 0x7f08008d

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Login;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/livemixtapes/Login;->loginLoading:Landroid/widget/ProgressBar;

    .line 93
    invoke-direct {p0}, Lcom/livemixtapes/Login;->setListeners()V

    .line 96
    return-void

    .line 72
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 0

    .prologue
    .line 375
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 377
    return-void
.end method
