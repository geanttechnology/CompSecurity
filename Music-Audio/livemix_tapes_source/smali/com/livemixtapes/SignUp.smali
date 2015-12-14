.class public Lcom/livemixtapes/SignUp;
.super Lcom/livemixtapes/ui/BaseActivity;
.source "SignUp.java"


# static fields
.field static final DATE_DIALOG_ID:I


# instance fields
.field private continueAsGuest:Landroid/widget/TextView;

.field private countrySelector:Landroid/widget/Spinner;

.field private forgotPassword:Landroid/widget/TextView;

.field private genderFemale:Landroid/widget/RadioButton;

.field private genderMale:Landroid/widget/RadioButton;

.field private layout:Landroid/widget/LinearLayout;

.field layoutBack:Landroid/widget/LinearLayout;

.field private loading:Ljava/lang/Boolean;

.field private mDateDisplay:Landroid/widget/TextView;

.field private mDateSetListener:Landroid/app/DatePickerDialog$OnDateSetListener;

.field private mDay:I

.field private mMonth:I

.field private mYear:I

.field private nextBtn:Landroid/widget/FrameLayout;

.field private password:Landroid/widget/EditText;

.field private passwordBox:Landroid/widget/LinearLayout;

.field private passwordClear:Landroid/widget/ImageButton;

.field private signupLoading:Landroid/widget/ProgressBar;

.field private signup_birthdate:Landroid/widget/EditText;

.field private signup_birthdatebox:Landroid/widget/LinearLayout;

.field private signup_birthdateclear:Landroid/widget/ImageButton;

.field private signup_confirmemail:Landroid/widget/EditText;

.field private signup_confirmemailbox:Landroid/widget/LinearLayout;

.field private signup_confirmemailclear:Landroid/widget/ImageButton;

.field private signup_confirmpassword:Landroid/widget/EditText;

.field private signup_confirmpasswordbox:Landroid/widget/LinearLayout;

.field private signup_confirmpasswordclear:Landroid/widget/ImageButton;

.field private signup_countrybox:Landroid/widget/LinearLayout;

.field private signup_email:Landroid/widget/EditText;

.field private signup_emailbox:Landroid/widget/LinearLayout;

.field private signup_emailclear:Landroid/widget/ImageButton;

.field private signup_firstname:Landroid/widget/EditText;

.field private signup_firstnamebox:Landroid/widget/LinearLayout;

.field private signup_firstnameclear:Landroid/widget/ImageButton;

.field private signup_genderbox:Landroid/widget/LinearLayout;

.field private signup_lastname:Landroid/widget/EditText;

.field private signup_lastnamebox:Landroid/widget/LinearLayout;

.field private signup_lastnameclear:Landroid/widget/ImageButton;

.field private signup_password:Landroid/widget/EditText;

.field private signup_passwordbox:Landroid/widget/LinearLayout;

.field private signup_passwordclear:Landroid/widget/ImageButton;

.field private signup_postalcode:Landroid/widget/EditText;

.field private signup_postalcodebox:Landroid/widget/LinearLayout;

.field private signup_postalcodeclear:Landroid/widget/ImageButton;

.field private signup_tos:Landroid/widget/CheckBox;

.field private signup_toscheckbox:Landroid/widget/LinearLayout;

.field private username:Landroid/widget/EditText;

.field private usernameBox:Landroid/widget/LinearLayout;

.field private usernameClear:Landroid/widget/ImageButton;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/livemixtapes/ui/BaseActivity;-><init>()V

    .line 66
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->loading:Ljava/lang/Boolean;

    .line 707
    new-instance v0, Lcom/livemixtapes/SignUp$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/SignUp$1;-><init>(Lcom/livemixtapes/SignUp;)V

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->mDateSetListener:Landroid/app/DatePickerDialog$OnDateSetListener;

    .line 43
    return-void
.end method

.method static synthetic access$10(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$11(Lcom/livemixtapes/SignUp;)Landroid/widget/ImageButton;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->passwordClear:Landroid/widget/ImageButton;

    return-object v0
.end method

.method static synthetic access$12(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->usernameBox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 487
    invoke-direct {p0, p1}, Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$14(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_email:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$15(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_emailbox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$16(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmemail:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$17(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmemailbox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$18(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->passwordBox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$19(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_password:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2(Lcom/livemixtapes/SignUp;I)V
    .locals 0

    .prologue
    .line 71
    iput p1, p0, Lcom/livemixtapes/SignUp;->mYear:I

    return-void
.end method

.method static synthetic access$20(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_passwordbox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$21(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmpassword:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$22(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmpasswordbox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$23(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_firstname:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$24(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_firstnamebox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$25(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_lastname:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$26(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_lastnamebox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$27(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_postalcode:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$28(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_postalcodebox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$29(Lcom/livemixtapes/SignUp;)Landroid/widget/RadioButton;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->genderMale:Landroid/widget/RadioButton;

    return-object v0
.end method

.method static synthetic access$3(Lcom/livemixtapes/SignUp;I)V
    .locals 0

    .prologue
    .line 72
    iput p1, p0, Lcom/livemixtapes/SignUp;->mMonth:I

    return-void
.end method

.method static synthetic access$30(Lcom/livemixtapes/SignUp;)Landroid/widget/RadioButton;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->genderFemale:Landroid/widget/RadioButton;

    return-object v0
.end method

.method static synthetic access$31(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_genderbox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$32(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_birthdate:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$33(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_birthdatebox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$34(Lcom/livemixtapes/SignUp;)Landroid/widget/CheckBox;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_tos:Landroid/widget/CheckBox;

    return-object v0
.end method

.method static synthetic access$35(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_toscheckbox:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$36(Lcom/livemixtapes/SignUp;)Landroid/widget/Spinner;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->countrySelector:Landroid/widget/Spinner;

    return-object v0
.end method

.method static synthetic access$37(Lcom/livemixtapes/SignUp;)V
    .locals 0

    .prologue
    .line 574
    invoke-direct {p0}, Lcom/livemixtapes/SignUp;->signup()V

    return-void
.end method

.method static synthetic access$38(Lcom/livemixtapes/SignUp;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 482
    invoke-direct {p0, p1}, Lcom/livemixtapes/SignUp;->showKeyboard(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$39(Lcom/livemixtapes/SignUp;)V
    .locals 0

    .prologue
    .line 545
    invoke-direct {p0}, Lcom/livemixtapes/SignUp;->openRadio()V

    return-void
.end method

.method static synthetic access$4(Lcom/livemixtapes/SignUp;I)V
    .locals 0

    .prologue
    .line 73
    iput p1, p0, Lcom/livemixtapes/SignUp;->mDay:I

    return-void
.end method

.method static synthetic access$40(Lcom/livemixtapes/SignUp;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/livemixtapes/SignUp;->loading:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$41(Lcom/livemixtapes/SignUp;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signupLoading:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$42(Lcom/livemixtapes/SignUp;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 683
    invoke-direct {p0, p1, p2}, Lcom/livemixtapes/SignUp;->showDialog(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$5(Lcom/livemixtapes/SignUp;)V
    .locals 0

    .prologue
    .line 697
    invoke-direct {p0}, Lcom/livemixtapes/SignUp;->updateDisplay()V

    return-void
.end method

.method static synthetic access$6(Lcom/livemixtapes/SignUp;)V
    .locals 0

    .prologue
    .line 467
    invoke-direct {p0}, Lcom/livemixtapes/SignUp;->hideKeyboards()V

    return-void
.end method

.method static synthetic access$7(Lcom/livemixtapes/SignUp;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 462
    invoke-direct {p0, p1}, Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$8(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->username:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$9(Lcom/livemixtapes/SignUp;)Landroid/widget/ImageButton;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->usernameClear:Landroid/widget/ImageButton;

    return-object v0
.end method

.method private hideKeyboard(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 463
    const-string v1, "input_method"

    invoke-virtual {p0, v1}, Lcom/livemixtapes/SignUp;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 464
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    invoke-virtual {p1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 465
    return-void
.end method

.method private hideKeyboards()V
    .locals 1

    .prologue
    .line 468
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->username:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V

    .line 469
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V

    .line 470
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_password:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V

    .line 471
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_email:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V

    .line 472
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmemail:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V

    .line 473
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_password:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V

    .line 474
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmpassword:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V

    .line 475
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_firstname:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V

    .line 476
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_lastname:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V

    .line 477
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signup_postalcode:Landroid/widget/EditText;

    invoke-direct {p0, v0}, Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V

    .line 480
    return-void
.end method

.method private openRadio()V
    .locals 0

    .prologue
    .line 547
    return-void
.end method

.method private refresh()V
    .locals 2

    .prologue
    .line 550
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->loading:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 572
    :goto_0
    return-void

    .line 552
    :cond_0
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->loading:Ljava/lang/Boolean;

    .line 553
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->signupLoading:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 556
    new-instance v0, Lcom/livemixtapes/SignUp$15;

    invoke-direct {v0, p0}, Lcom/livemixtapes/SignUp$15;-><init>(Lcom/livemixtapes/SignUp;)V

    .line 555
    invoke-static {v0}, Lcom/livemixtapes/User;->refresh(Lcom/livemixtapes/User$UserCallback;)V

    goto :goto_0
.end method

.method private setBoxBehavior(Landroid/widget/EditText;Landroid/widget/ImageButton;)V
    .locals 1
    .param p1, "box_text"    # Landroid/widget/EditText;
    .param p2, "box_clear"    # Landroid/widget/ImageButton;

    .prologue
    .line 186
    new-instance v0, Lcom/livemixtapes/SignUp$3;

    invoke-direct {v0, p0}, Lcom/livemixtapes/SignUp$3;-><init>(Lcom/livemixtapes/SignUp;)V

    invoke-virtual {p1, v0}, Landroid/widget/EditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 198
    new-instance v0, Lcom/livemixtapes/SignUp$4;

    invoke-direct {v0, p0, p1, p2}, Lcom/livemixtapes/SignUp$4;-><init>(Lcom/livemixtapes/SignUp;Landroid/widget/EditText;Landroid/widget/ImageButton;)V

    invoke-virtual {p1, v0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 220
    new-instance v0, Lcom/livemixtapes/SignUp$5;

    invoke-direct {v0, p0, p1}, Lcom/livemixtapes/SignUp$5;-><init>(Lcom/livemixtapes/SignUp;Landroid/widget/EditText;)V

    invoke-virtual {p2, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 228
    return-void
.end method

.method private setListeners()V
    .locals 3

    .prologue
    .line 233
    new-instance v0, Lcom/livemixtapes/SignUp$6;

    invoke-direct {v0, p0}, Lcom/livemixtapes/SignUp$6;-><init>(Lcom/livemixtapes/SignUp;)V

    .line 242
    .local v0, "keyboardHider":Landroid/view/View$OnFocusChangeListener;
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->layout:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 244
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;

    new-instance v2, Lcom/livemixtapes/SignUp$7;

    invoke-direct {v2, p0}, Lcom/livemixtapes/SignUp$7;-><init>(Lcom/livemixtapes/SignUp;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 257
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->signup_email:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/livemixtapes/SignUp;->signup_emailclear:Landroid/widget/ImageButton;

    invoke-direct {p0, v1, v2}, Lcom/livemixtapes/SignUp;->setBoxBehavior(Landroid/widget/EditText;Landroid/widget/ImageButton;)V

    .line 258
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->signup_confirmemail:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/livemixtapes/SignUp;->signup_confirmemailclear:Landroid/widget/ImageButton;

    invoke-direct {p0, v1, v2}, Lcom/livemixtapes/SignUp;->setBoxBehavior(Landroid/widget/EditText;Landroid/widget/ImageButton;)V

    .line 259
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->signup_password:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/livemixtapes/SignUp;->signup_passwordclear:Landroid/widget/ImageButton;

    invoke-direct {p0, v1, v2}, Lcom/livemixtapes/SignUp;->setBoxBehavior(Landroid/widget/EditText;Landroid/widget/ImageButton;)V

    .line 260
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->signup_confirmpassword:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/livemixtapes/SignUp;->signup_confirmpasswordclear:Landroid/widget/ImageButton;

    invoke-direct {p0, v1, v2}, Lcom/livemixtapes/SignUp;->setBoxBehavior(Landroid/widget/EditText;Landroid/widget/ImageButton;)V

    .line 261
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->signup_firstname:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/livemixtapes/SignUp;->signup_firstnameclear:Landroid/widget/ImageButton;

    invoke-direct {p0, v1, v2}, Lcom/livemixtapes/SignUp;->setBoxBehavior(Landroid/widget/EditText;Landroid/widget/ImageButton;)V

    .line 262
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->signup_lastname:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/livemixtapes/SignUp;->signup_lastnameclear:Landroid/widget/ImageButton;

    invoke-direct {p0, v1, v2}, Lcom/livemixtapes/SignUp;->setBoxBehavior(Landroid/widget/EditText;Landroid/widget/ImageButton;)V

    .line 263
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->signup_postalcode:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/livemixtapes/SignUp;->signup_postalcodeclear:Landroid/widget/ImageButton;

    invoke-direct {p0, v1, v2}, Lcom/livemixtapes/SignUp;->setBoxBehavior(Landroid/widget/EditText;Landroid/widget/ImageButton;)V

    .line 264
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->signup_birthdate:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/livemixtapes/SignUp;->signup_birthdateclear:Landroid/widget/ImageButton;

    invoke-direct {p0, v1, v2}, Lcom/livemixtapes/SignUp;->setBoxBehavior(Landroid/widget/EditText;Landroid/widget/ImageButton;)V

    .line 280
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->username:Landroid/widget/EditText;

    new-instance v2, Lcom/livemixtapes/SignUp$8;

    invoke-direct {v2, p0}, Lcom/livemixtapes/SignUp$8;-><init>(Lcom/livemixtapes/SignUp;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 303
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->usernameClear:Landroid/widget/ImageButton;

    new-instance v2, Lcom/livemixtapes/SignUp$9;

    invoke-direct {v2, p0}, Lcom/livemixtapes/SignUp$9;-><init>(Lcom/livemixtapes/SignUp;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 311
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;

    new-instance v2, Lcom/livemixtapes/SignUp$10;

    invoke-direct {v2, p0}, Lcom/livemixtapes/SignUp$10;-><init>(Lcom/livemixtapes/SignUp;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 331
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->passwordClear:Landroid/widget/ImageButton;

    new-instance v2, Lcom/livemixtapes/SignUp$11;

    invoke-direct {v2, p0}, Lcom/livemixtapes/SignUp$11;-><init>(Lcom/livemixtapes/SignUp;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 339
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->nextBtn:Landroid/widget/FrameLayout;

    new-instance v2, Lcom/livemixtapes/SignUp$12;

    invoke-direct {v2, p0}, Lcom/livemixtapes/SignUp$12;-><init>(Lcom/livemixtapes/SignUp;)V

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 442
    iget-object v1, p0, Lcom/livemixtapes/SignUp;->layoutBack:Landroid/widget/LinearLayout;

    new-instance v2, Lcom/livemixtapes/SignUp$13;

    invoke-direct {v2, p0}, Lcom/livemixtapes/SignUp$13;-><init>(Lcom/livemixtapes/SignUp;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 452
    return-void
.end method

.method private shake(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 488
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;Ljava/lang/Runnable;)V

    .line 489
    return-void
.end method

.method private shake(Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "callback"    # Ljava/lang/Runnable;

    .prologue
    .line 492
    const v1, 0x7f04000a

    invoke-static {p0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 494
    .local v0, "anim":Landroid/view/animation/Animation;
    new-instance v1, Lcom/livemixtapes/SignUp$14;

    invoke-direct {v1, p0, p2}, Lcom/livemixtapes/SignUp$14;-><init>(Lcom/livemixtapes/SignUp;Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 542
    invoke-virtual {p1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 543
    return-void
.end method

.method private showDialog(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 684
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 685
    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 686
    invoke-virtual {v0, p2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 687
    const-string v1, "OK"

    new-instance v2, Lcom/livemixtapes/SignUp$17;

    invoke-direct {v2, p0}, Lcom/livemixtapes/SignUp$17;-><init>(Lcom/livemixtapes/SignUp;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 693
    const v1, 0x1080027

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 694
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 695
    return-void
.end method

.method private showKeyboard(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 483
    const-string v1, "input_method"

    invoke-virtual {p0, v1}, Lcom/livemixtapes/SignUp;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 484
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 485
    return-void
.end method

.method private signup()V
    .locals 15

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 575
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->loading:Ljava/lang/Boolean;

    invoke-virtual {v8}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 681
    :goto_0
    return-void

    .line 577
    :cond_0
    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    iput-object v8, p0, Lcom/livemixtapes/SignUp;->loading:Ljava/lang/Boolean;

    .line 578
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->signupLoading:Landroid/widget/ProgressBar;

    invoke-virtual {v8, v10}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 582
    invoke-virtual {p0}, Lcom/livemixtapes/SignUp;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f0f0001

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v13

    .line 583
    .local v13, "country_array":[Ljava/lang/String;
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->countrySelector:Landroid/widget/Spinner;

    invoke-virtual {v8}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v8

    aget-object v5, v13, v8

    .line 584
    .local v5, "form_country":Ljava/lang/String;
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->signup_birthdate:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-interface {v8}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v12

    .line 586
    .local v12, "all_birthday":Ljava/lang/String;
    const-string v8, "/"

    invoke-virtual {v12, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v14

    .line 587
    .local v14, "split_birthday":[Ljava/lang/String;
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->signup_email:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-interface {v8}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v1

    .line 588
    .local v1, "form_email":Ljava/lang/String;
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->signup_firstname:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-interface {v8}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v3

    .local v3, "form_firstname":Ljava/lang/String;
    new-array v8, v11, [Ljava/lang/Object;

    .line 590
    aget-object v9, v14, v10

    aput-object v9, v8, v10

    invoke-static {v8}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 591
    const/4 v7, 0x0

    .line 593
    .local v7, "form_gender":Ljava/lang/String;
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->genderMale:Landroid/widget/RadioButton;

    invoke-virtual {v8}, Landroid/widget/RadioButton;->isChecked()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 595
    const-string v7, "M"

    .line 602
    :cond_1
    :goto_1
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->signup_lastname:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-interface {v8}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v4

    .line 603
    .local v4, "form_lastname":Ljava/lang/String;
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->signup_password:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-interface {v8}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v2

    .line 604
    .local v2, "form_password":Ljava/lang/String;
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->username:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-interface {v8}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v0

    .line 605
    .local v0, "form_username":Ljava/lang/String;
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->signup_postalcode:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-interface {v8}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v6

    .line 623
    .local v6, "form_postalcode":Ljava/lang/String;
    aget-object v8, v14, v10

    .line 624
    aget-object v9, v14, v11

    .line 625
    const/4 v10, 0x2

    aget-object v10, v14, v10

    .line 628
    new-instance v11, Lcom/livemixtapes/SignUp$16;

    invoke-direct {v11, p0}, Lcom/livemixtapes/SignUp$16;-><init>(Lcom/livemixtapes/SignUp;)V

    .line 614
    invoke-static/range {v0 .. v11}, Lcom/livemixtapes/User;->signup(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/livemixtapes/User$SignupCallback;)V

    goto/16 :goto_0

    .line 597
    .end local v0    # "form_username":Ljava/lang/String;
    .end local v2    # "form_password":Ljava/lang/String;
    .end local v4    # "form_lastname":Ljava/lang/String;
    .end local v6    # "form_postalcode":Ljava/lang/String;
    :cond_2
    iget-object v8, p0, Lcom/livemixtapes/SignUp;->genderFemale:Landroid/widget/RadioButton;

    invoke-virtual {v8}, Landroid/widget/RadioButton;->isChecked()Z

    move-result v8

    if-eqz v8, :cond_1

    .line 599
    const-string v7, "F"

    goto :goto_1
.end method

.method private updateDisplay()V
    .locals 3

    .prologue
    .line 698
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->mDateDisplay:Landroid/widget/TextView;

    .line 699
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 701
    iget v2, p0, Lcom/livemixtapes/SignUp;->mMonth:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 702
    iget v2, p0, Lcom/livemixtapes/SignUp;->mDay:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 703
    iget v2, p0, Lcom/livemixtapes/SignUp;->mYear:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 698
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 704
    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .locals 0

    .prologue
    .line 459
    invoke-super {p0}, Lcom/livemixtapes/ui/BaseActivity;->onBackPressed()V

    .line 460
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const v5, 0x7f08012d

    const v4, 0x7f08011a

    const v3, 0x7f080119

    const v2, 0x7f080118

    .line 99
    const v0, 0x7f03003c

    invoke-super {p0, p1, v0}, Lcom/livemixtapes/ui/BaseActivity;->onCreate(Landroid/os/Bundle;I)V

    .line 101
    const v0, 0x7f08010d

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->layout:Landroid/widget/LinearLayout;

    .line 104
    :try_start_0
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->layout:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lcom/livemixtapes/App;->scaleViewGroup(Landroid/view/ViewGroup;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 112
    :goto_0
    invoke-virtual {p0, v5}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->mDateDisplay:Landroid/widget/TextView;

    .line 114
    const v0, 0x7f080125

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->countrySelector:Landroid/widget/Spinner;

    .line 115
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->countrySelector:Landroid/widget/Spinner;

    const/16 v1, 0xe4

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setSelection(I)V

    .line 116
    const v0, 0x7f080131

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->nextBtn:Landroid/widget/FrameLayout;

    .line 118
    const v0, 0x7f080110

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->username:Landroid/widget/EditText;

    .line 119
    invoke-virtual {p0, v3}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;

    .line 121
    const v0, 0x7f080113

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_email:Landroid/widget/EditText;

    .line 122
    const v0, 0x7f080116

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmemail:Landroid/widget/EditText;

    .line 123
    invoke-virtual {p0, v3}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_password:Landroid/widget/EditText;

    .line 124
    const v0, 0x7f08011c

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmpassword:Landroid/widget/EditText;

    .line 125
    const v0, 0x7f08011f

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_firstname:Landroid/widget/EditText;

    .line 126
    const v0, 0x7f080122

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_lastname:Landroid/widget/EditText;

    .line 127
    const v0, 0x7f080127

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_postalcode:Landroid/widget/EditText;

    .line 128
    invoke-virtual {p0, v5}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_birthdate:Landroid/widget/EditText;

    .line 131
    const v0, 0x7f080130

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_tos:Landroid/widget/CheckBox;

    .line 133
    const v0, 0x7f08012f

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_toscheckbox:Landroid/widget/LinearLayout;

    .line 136
    const v0, 0x7f08010f

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->usernameBox:Landroid/widget/LinearLayout;

    .line 137
    invoke-virtual {p0, v2}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->passwordBox:Landroid/widget/LinearLayout;

    .line 139
    const v0, 0x7f080112

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_emailbox:Landroid/widget/LinearLayout;

    .line 140
    const v0, 0x7f080115

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmemailbox:Landroid/widget/LinearLayout;

    .line 141
    invoke-virtual {p0, v2}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_passwordbox:Landroid/widget/LinearLayout;

    .line 142
    const v0, 0x7f08011b

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmpasswordbox:Landroid/widget/LinearLayout;

    .line 143
    const v0, 0x7f08011e

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_firstnamebox:Landroid/widget/LinearLayout;

    .line 144
    const v0, 0x7f080121

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_lastnamebox:Landroid/widget/LinearLayout;

    .line 145
    const v0, 0x7f080126

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_postalcodebox:Landroid/widget/LinearLayout;

    .line 146
    const v0, 0x7f08012c

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_birthdatebox:Landroid/widget/LinearLayout;

    .line 148
    const v0, 0x7f080129

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_genderbox:Landroid/widget/LinearLayout;

    .line 150
    const v0, 0x7f08012a

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->genderMale:Landroid/widget/RadioButton;

    .line 151
    const v0, 0x7f08012b

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->genderFemale:Landroid/widget/RadioButton;

    .line 153
    const v0, 0x7f080111

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->usernameClear:Landroid/widget/ImageButton;

    .line 154
    invoke-virtual {p0, v4}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->passwordClear:Landroid/widget/ImageButton;

    .line 156
    const v0, 0x7f080114

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_emailclear:Landroid/widget/ImageButton;

    .line 157
    const v0, 0x7f080117

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmemailclear:Landroid/widget/ImageButton;

    .line 158
    invoke-virtual {p0, v4}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_passwordclear:Landroid/widget/ImageButton;

    .line 159
    const v0, 0x7f08011d

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_confirmpasswordclear:Landroid/widget/ImageButton;

    .line 160
    const v0, 0x7f080120

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_firstnameclear:Landroid/widget/ImageButton;

    .line 161
    const v0, 0x7f080123

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_lastnameclear:Landroid/widget/ImageButton;

    .line 162
    const v0, 0x7f080128

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_postalcodeclear:Landroid/widget/ImageButton;

    .line 163
    const v0, 0x7f08012e

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signup_birthdateclear:Landroid/widget/ImageButton;

    .line 165
    const v0, 0x7f080132

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->signupLoading:Landroid/widget/ProgressBar;

    .line 169
    iget-object v0, p0, Lcom/livemixtapes/SignUp;->mDateDisplay:Landroid/widget/TextView;

    new-instance v1, Lcom/livemixtapes/SignUp$2;

    invoke-direct {v1, p0}, Lcom/livemixtapes/SignUp$2;-><init>(Lcom/livemixtapes/SignUp;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 176
    const v0, 0x7f08006d

    invoke-virtual {p0, v0}, Lcom/livemixtapes/SignUp;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/SignUp;->layoutBack:Landroid/widget/LinearLayout;

    .line 178
    invoke-direct {p0}, Lcom/livemixtapes/SignUp;->setListeners()V

    .line 181
    return-void

    .line 107
    :catch_0
    move-exception v0

    goto/16 :goto_0
.end method

.method protected onCreateDialog(I)Landroid/app/Dialog;
    .locals 6
    .param p1, "id"    # I

    .prologue
    .line 719
    packed-switch p1, :pswitch_data_0

    .line 725
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 721
    :pswitch_0
    new-instance v0, Landroid/app/DatePickerDialog;

    .line 722
    iget-object v2, p0, Lcom/livemixtapes/SignUp;->mDateSetListener:Landroid/app/DatePickerDialog$OnDateSetListener;

    .line 723
    iget v3, p0, Lcom/livemixtapes/SignUp;->mYear:I

    iget v4, p0, Lcom/livemixtapes/SignUp;->mMonth:I

    iget v5, p0, Lcom/livemixtapes/SignUp;->mDay:I

    move-object v1, p0

    .line 721
    invoke-direct/range {v0 .. v5}, Landroid/app/DatePickerDialog;-><init>(Landroid/content/Context;Landroid/app/DatePickerDialog$OnDateSetListener;III)V

    goto :goto_0

    .line 719
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public bridge synthetic onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1

    .prologue
    .line 1
    invoke-super {p0, p1, p2, p3, p4}, Lcom/livemixtapes/ui/BaseActivity;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1

    .prologue
    .line 1
    invoke-super {p0, p1, p2, p3}, Lcom/livemixtapes/ui/BaseActivity;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 85
    invoke-super {p0}, Lcom/livemixtapes/ui/BaseActivity;->onResume()V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    .line 87
    const-string v3, "LOGGING SIGNUP ACTIVITY"

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 88
    invoke-virtual {p0}, Lcom/livemixtapes/SignUp;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/App;

    .line 90
    .local v0, "application":Lcom/livemixtapes/App;
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    const-string v2, "Image~SignupActivity"

    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->setScreenName(Ljava/lang/String;)V

    .line 93
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;

    invoke-direct {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;->build()Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->send(Ljava/util/Map;)V

    .line 95
    return-void
.end method
