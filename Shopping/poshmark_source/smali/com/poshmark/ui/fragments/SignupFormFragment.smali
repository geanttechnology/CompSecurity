.class public Lcom/poshmark/ui/fragments/SignupFormFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "SignupFormFragment.java"


# instance fields
.field private SELECT_PICTURE:I

.field private avataar:Landroid/widget/ImageView;

.field private avataarImageFile:Landroid/net/Uri;

.field private creationInProgress:Z

.field private email:Ljava/lang/String;

.field private emailEditText:Lcom/poshmark/ui/customviews/PMEditText;

.field private exprDate:Ljava/lang/String;

.field private externalToken:Ljava/lang/String;

.field private fbUserId:Ljava/lang/String;

.field private firstName:Ljava/lang/String;

.field private firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

.field private googleAvataarUrl:Ljava/lang/String;

.field private googleUserId:Ljava/lang/String;

.field private imageHeight:I

.field private imageWidth:I

.field private inviteCodeEditText:Lcom/poshmark/ui/customviews/PMEditText;

.field private isAvtaarImageSet:Z

.field private isFbSignup:Z

.field private isGoogleSignup:Z

.field private lastName:Ljava/lang/String;

.field private lastNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

.field private passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

.field private signInButton:Lcom/poshmark/ui/customviews/PMTextView;

.field private tosTextView:Landroid/widget/TextView;

.field private userCreated:Z

.field private userNameEditText:Lcom/poshmark/ui/customviews/PMEditText;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 58
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 59
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->SELECT_PICTURE:I

    .line 71
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isAvtaarImageSet:Z

    .line 83
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->userCreated:Z

    .line 84
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->creationInProgress:Z

    .line 85
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isFbSignup:Z

    .line 86
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isGoogleSignup:Z

    .line 88
    iput v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->imageHeight:I

    .line 89
    iput v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->imageWidth:I

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/SignupFormFragment;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 58
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/SignupFormFragment;->launchUrl(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1000(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->emailEditText:Lcom/poshmark/ui/customviews/PMEditText;

    return-object v0
.end method

.method static synthetic access$102(Lcom/poshmark/ui/fragments/SignupFormFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;
    .param p1, "x1"    # I

    .prologue
    .line 58
    iput p1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->imageHeight:I

    return p1
.end method

.method static synthetic access$1100(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->inviteCodeEditText:Lcom/poshmark/ui/customviews/PMEditText;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/poshmark/ui/fragments/SignupFormFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isFbSignup:Z

    return v0
.end method

.method static synthetic access$1300(Lcom/poshmark/ui/fragments/SignupFormFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->externalToken:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/poshmark/ui/fragments/SignupFormFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->exprDate:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/poshmark/ui/fragments/SignupFormFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isGoogleSignup:Z

    return v0
.end method

.method static synthetic access$1600(Lcom/poshmark/ui/fragments/SignupFormFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isAvtaarImageSet:Z

    return v0
.end method

.method static synthetic access$1702(Lcom/poshmark/ui/fragments/SignupFormFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 58
    iput-boolean p1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->creationInProgress:Z

    return p1
.end method

.method static synthetic access$1800(Lcom/poshmark/ui/fragments/SignupFormFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->fireTrackingCalls()V

    return-void
.end method

.method static synthetic access$1902(Lcom/poshmark/ui/fragments/SignupFormFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 58
    iput-boolean p1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->userCreated:Z

    return p1
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/SignupFormFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataar:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$302(Lcom/poshmark/ui/fragments/SignupFormFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;
    .param p1, "x1"    # I

    .prologue
    .line 58
    iput p1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->imageWidth:I

    return p1
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/SignupFormFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->SELECT_PICTURE:I

    return v0
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/SignupFormFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->isFormValid()Z

    move-result v0

    return v0
.end method

.method static synthetic access$600(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->userNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    return-object v0
.end method

.method static synthetic access$700(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    return-object v0
.end method

.method static synthetic access$800(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    return-object v0
.end method

.method static synthetic access$900(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignupFormFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->lastNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    return-object v0
.end method

.method private displayForm()V
    .locals 15

    .prologue
    const v14, 0x7f0c02d8

    const/4 v13, 0x0

    .line 236
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v11

    const v12, 0x7f0c0100

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 237
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v11

    const v12, 0x7f0c0101

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->lastNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 238
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v11

    const v12, 0x7f0c00ff

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->emailEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 240
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v11

    const v12, 0x7f0c0102

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 241
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    sget-object v12, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/PMEditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 242
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    new-instance v12, Landroid/text/method/PasswordTransformationMethod;

    invoke-direct {v12}, Landroid/text/method/PasswordTransformationMethod;-><init>()V

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/PMEditText;->setTransformationMethod(Landroid/text/method/TransformationMethod;)V

    .line 244
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v11

    const v12, 0x7f0c02df

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->userNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 245
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v11

    const v12, 0x7f0c02e0

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/customviews/PMEditText;

    iput-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->inviteCodeEditText:Lcom/poshmark/ui/customviews/PMEditText;

    .line 246
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v11

    invoke-virtual {v11, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->signInButton:Lcom/poshmark/ui/customviews/PMTextView;

    .line 248
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f06029a

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 249
    .local v10, "tosText":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f060299

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 250
    .local v9, "termsText":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f06021d

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 252
    .local v7, "privacyText":Ljava/lang/String;
    new-instance v8, Landroid/text/SpannableStringBuilder;

    invoke-direct {v8, v10}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 253
    .local v8, "ssb":Landroid/text/SpannableStringBuilder;
    invoke-virtual {v10, v9}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    .line 254
    .local v3, "idx1":I
    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v11

    add-int v4, v3, v11

    .line 255
    .local v4, "idx2":I
    new-instance v11, Lcom/poshmark/ui/fragments/SignupFormFragment$1;

    invoke-direct {v11, p0}, Lcom/poshmark/ui/fragments/SignupFormFragment$1;-><init>(Lcom/poshmark/ui/fragments/SignupFormFragment;)V

    invoke-virtual {v8, v11, v3, v4, v13}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 263
    invoke-virtual {v10, v7}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    .line 264
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v11

    add-int v4, v3, v11

    .line 266
    new-instance v11, Lcom/poshmark/ui/fragments/SignupFormFragment$2;

    invoke-direct {v11, p0}, Lcom/poshmark/ui/fragments/SignupFormFragment$2;-><init>(Lcom/poshmark/ui/fragments/SignupFormFragment;)V

    invoke-virtual {v8, v11, v3, v4, v13}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 274
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v11

    const v12, 0x7f0c02e2

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/TextView;

    iput-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->tosTextView:Landroid/widget/TextView;

    .line 275
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->tosTextView:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 276
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->tosTextView:Landroid/widget/TextView;

    sget-object v12, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {v11, v8, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 278
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->firstName:Ljava/lang/String;

    if-eqz v11, :cond_0

    .line 279
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v12, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->firstName:Ljava/lang/String;

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 282
    :cond_0
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->lastName:Ljava/lang/String;

    if-eqz v11, :cond_1

    .line 283
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->lastNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v12, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->lastName:Ljava/lang/String;

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 286
    :cond_1
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->email:Ljava/lang/String;

    if-eqz v11, :cond_2

    .line 287
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->emailEditText:Lcom/poshmark/ui/customviews/PMEditText;

    iget-object v12, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->email:Ljava/lang/String;

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/PMEditText;->setText(Ljava/lang/CharSequence;)V

    .line 291
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v11

    const v12, 0x7f0c00fe

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/ImageView;

    iput-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataar:Landroid/widget/ImageView;

    .line 292
    iget-boolean v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isAvtaarImageSet:Z

    if-nez v11, :cond_5

    .line 293
    iget-boolean v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isFbSignup:Z

    if-eqz v11, :cond_4

    .line 294
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->fbUserId:Ljava/lang/String;

    iget-object v12, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataar:Landroid/widget/ImageView;

    invoke-static {v11, v12}, Lcom/poshmark/utils/ViewUtils;->loadFbAvataar(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 304
    :cond_3
    :goto_0
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataar:Landroid/widget/ImageView;

    new-instance v12, Lcom/poshmark/ui/fragments/SignupFormFragment$3;

    invoke-direct {v12, p0}, Lcom/poshmark/ui/fragments/SignupFormFragment$3;-><init>(Lcom/poshmark/ui/fragments/SignupFormFragment;)V

    invoke-virtual {v11, v12}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 321
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v11

    const v12, 0x7f0c02e1

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 322
    .local v1, "doneButton":Landroid/widget/Button;
    new-instance v11, Lcom/poshmark/ui/fragments/SignupFormFragment$4;

    invoke-direct {v11, p0}, Lcom/poshmark/ui/fragments/SignupFormFragment$4;-><init>(Lcom/poshmark/ui/fragments/SignupFormFragment;)V

    invoke-virtual {v1, v11}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 412
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v11

    invoke-virtual {v11, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->signInButton:Lcom/poshmark/ui/customviews/PMTextView;

    .line 413
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->signInButton:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v12, Lcom/poshmark/ui/fragments/SignupFormFragment$5;

    invoke-direct {v12, p0}, Lcom/poshmark/ui/fragments/SignupFormFragment$5;-><init>(Lcom/poshmark/ui/fragments/SignupFormFragment;)V

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 422
    const v11, 0x7f060103

    invoke-virtual {p0, v11}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 423
    .local v2, "existingAccountText":Ljava/lang/String;
    new-instance v8, Landroid/text/SpannableStringBuilder;

    .end local v8    # "ssb":Landroid/text/SpannableStringBuilder;
    invoke-direct {v8, v2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 424
    .restart local v8    # "ssb":Landroid/text/SpannableStringBuilder;
    const v11, 0x7f060296

    invoke-virtual {p0, v11}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 426
    .local v5, "loginText":Ljava/lang/String;
    invoke-virtual {v2, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    .line 427
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v11

    add-int v4, v3, v11

    .line 428
    new-instance v11, Lcom/poshmark/ui/fragments/SignupFormFragment$6;

    invoke-direct {v11, p0}, Lcom/poshmark/ui/fragments/SignupFormFragment$6;-><init>(Lcom/poshmark/ui/fragments/SignupFormFragment;)V

    invoke-virtual {v8, v11, v3, v4, v13}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 435
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->signInButton:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/PMTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 436
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->signInButton:Lcom/poshmark/ui/customviews/PMTextView;

    sget-object v12, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {v11, v8, v12}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 437
    return-void

    .line 295
    .end local v1    # "doneButton":Landroid/widget/Button;
    .end local v2    # "existingAccountText":Ljava/lang/String;
    .end local v5    # "loginText":Ljava/lang/String;
    :cond_4
    iget-boolean v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isGoogleSignup:Z

    if-eqz v11, :cond_3

    .line 296
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->googleAvataarUrl:Ljava/lang/String;

    iget-object v12, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataar:Landroid/widget/ImageView;

    invoke-static {v11, v12}, Lcom/poshmark/utils/ViewUtils;->loadGooglePlusAvataar(Ljava/lang/String;Landroid/widget/ImageView;)V

    goto :goto_0

    .line 299
    :cond_5
    new-instance v6, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v6}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 300
    .local v6, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v11, 0x1

    iput-boolean v11, v6, Landroid/graphics/BitmapFactory$Options;->inMutable:Z

    .line 301
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataarImageFile:Landroid/net/Uri;

    invoke-virtual {v11}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11, v6}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 302
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    iget-object v11, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataar:Landroid/widget/ImageView;

    invoke-virtual {v11, v0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto/16 :goto_0
.end method

.method private fireTrackingCalls()V
    .locals 7

    .prologue
    .line 443
    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isFbSignup:Z

    if-eqz v4, :cond_1

    .line 444
    const-string v3, "facebook_sign_up_screen"

    .line 445
    .local v3, "viewName":Ljava/lang/String;
    const-string v0, "facebook_signup"

    .line 446
    .local v0, "eventName":Ljava/lang/String;
    const-string v1, "signup_type/facebook"

    .line 456
    .local v1, "label":Ljava/lang/String;
    :goto_0
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    const-string v5, "user"

    invoke-virtual {v4, v3, v5, v0, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 462
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getHasOffersObject()Lcom/mobileapptracker/MobileAppTracker;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 463
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getHasOffersObject()Lcom/mobileapptracker/MobileAppTracker;

    move-result-object v4

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/mobileapptracker/MobileAppTracker;->setUserId(Ljava/lang/String;)V

    .line 464
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getHasOffersObject()Lcom/mobileapptracker/MobileAppTracker;

    move-result-object v4

    const-string v5, "signup"

    invoke-virtual {v4, v5}, Lcom/mobileapptracker/MobileAppTracker;->measureAction(Ljava/lang/String;)V

    .line 468
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getKochavaTracker()Lcom/kochava/android/tracker/Feature;

    move-result-object v4

    const-string v5, "signup"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Lcom/kochava/android/tracker/Feature;->event(Ljava/lang/String;Ljava/lang/String;)V

    .line 470
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lnet/singular/sdk/Singular;->setCustomUserId(Ljava/lang/String;)V

    .line 471
    const-string v4, "signup"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;Ljava/lang/String;)V

    .line 472
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Lcom/facebook/appevents/AppEventsLogger;->newLogger(Landroid/content/Context;)Lcom/facebook/appevents/AppEventsLogger;

    move-result-object v2

    .line 473
    .local v2, "logger":Lcom/facebook/appevents/AppEventsLogger;
    const-string v4, "signup"

    invoke-virtual {v2, v4}, Lcom/facebook/appevents/AppEventsLogger;->logEvent(Ljava/lang/String;)V

    .line 474
    return-void

    .line 447
    .end local v0    # "eventName":Ljava/lang/String;
    .end local v1    # "label":Ljava/lang/String;
    .end local v2    # "logger":Lcom/facebook/appevents/AppEventsLogger;
    .end local v3    # "viewName":Ljava/lang/String;
    :cond_1
    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isGoogleSignup:Z

    if-eqz v4, :cond_2

    .line 448
    const-string v3, "google_sign_up_screen"

    .line 449
    .restart local v3    # "viewName":Ljava/lang/String;
    const-string v0, "gp_signup"

    .line 450
    .restart local v0    # "eventName":Ljava/lang/String;
    const-string v1, "signup_type/googlePlus"

    .restart local v1    # "label":Ljava/lang/String;
    goto :goto_0

    .line 452
    .end local v0    # "eventName":Ljava/lang/String;
    .end local v1    # "label":Ljava/lang/String;
    .end local v3    # "viewName":Ljava/lang/String;
    :cond_2
    const-string v3, "email_sign_up_screen"

    .line 453
    .restart local v3    # "viewName":Ljava/lang/String;
    const-string v0, "email_signup"

    .line 454
    .restart local v0    # "eventName":Ljava/lang/String;
    const-string v1, "signup_type/email"

    .restart local v1    # "label":Ljava/lang/String;
    goto :goto_0
.end method

.method private isFormValid()Z
    .locals 4

    .prologue
    .line 205
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 206
    .local v0, "validateTxt":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->userNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_0

    .line 207
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->userNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 210
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->emailEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_1

    .line 211
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->emailEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 214
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_2

    .line 215
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 218
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->lastNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_4

    .line 219
    :cond_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 222
    :cond_4
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isAvtaarImageSet:Z

    if-nez v1, :cond_5

    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isFbSignup:Z

    if-nez v1, :cond_5

    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isGoogleSignup:Z

    if-nez v1, :cond_5

    .line 223
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f060278

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 225
    :cond_5
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_6

    .line 226
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060148

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 227
    const/4 v1, 0x0

    .line 229
    :goto_0
    return v1

    :cond_6
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private launchUrl(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "analyticsPageName"    # Ljava/lang/String;

    .prologue
    .line 477
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 478
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 479
    const-string v2, "ANALYTICS_PAGE_NAME"

    invoke-virtual {v1, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 480
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 481
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 482
    return-void
.end method


# virtual methods
.method public handleBack()Z
    .locals 1

    .prologue
    .line 192
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->logout()V

    .line 193
    const/4 v0, 0x0

    return v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 146
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 148
    if-eqz p1, :cond_0

    .line 149
    const-string v1, "IS_IMAGE_SET"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isAvtaarImageSet:Z

    .line 150
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isAvtaarImageSet:Z

    if-eqz v1, :cond_0

    .line 151
    const-string v1, "IMAGE_FILE"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 152
    .local v0, "fileName":Ljava/lang/String;
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataarImageFile:Landroid/net/Uri;

    .line 156
    .end local v0    # "fileName":Ljava/lang/String;
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->displayForm()V

    .line 157
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 5
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v4, 0x1

    .line 176
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 177
    const/4 v3, -0x1

    if-ne p2, v3, :cond_0

    .line 178
    iget v3, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->SELECT_PICTURE:I

    if-ne p1, v3, :cond_0

    .line 179
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 180
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "IMAGE_FILE_URI"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Landroid/net/Uri;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataarImageFile:Landroid/net/Uri;

    .line 181
    new-instance v2, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v2}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 182
    .local v2, "options":Landroid/graphics/BitmapFactory$Options;
    iput-boolean v4, v2, Landroid/graphics/BitmapFactory$Options;->inMutable:Z

    .line 183
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataarImageFile:Landroid/net/Uri;

    invoke-virtual {v3}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v2}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 184
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataar:Landroid/widget/ImageView;

    invoke-virtual {v3, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 185
    iput-boolean v4, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isAvtaarImageSet:Z

    .line 188
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    .end local v2    # "options":Landroid/graphics/BitmapFactory$Options;
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 95
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 96
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 97
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_1

    .line 98
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "FIRST_NAME"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->firstName:Ljava/lang/String;

    .line 99
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "LAST_NAME"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->lastName:Ljava/lang/String;

    .line 100
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "EMAIL"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->email:Ljava/lang/String;

    .line 103
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "FB_SIGNUP"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isFbSignup:Z

    .line 104
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isFbSignup:Z

    if-eqz v1, :cond_0

    .line 105
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "EXPIRY_DATE"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->exprDate:Ljava/lang/String;

    .line 106
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "USERID"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->fbUserId:Ljava/lang/String;

    .line 107
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "TOKEN"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->externalToken:Ljava/lang/String;

    .line 111
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "GOOGLE_SIGNUP"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isGoogleSignup:Z

    .line 112
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isGoogleSignup:Z

    if-eqz v1, :cond_1

    .line 113
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "USERID"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->googleUserId:Ljava/lang/String;

    .line 114
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "TOKEN"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->externalToken:Ljava/lang/String;

    .line 115
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "GOOGLE_AVATAAR_URL"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->googleAvataarUrl:Ljava/lang/String;

    .line 118
    :cond_1
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 122
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 123
    const v1, 0x7f060276

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/SignupFormFragment;->setTitle(I)V

    .line 124
    const v1, 0x7f0300be

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 125
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 140
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 141
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->userCreated:Z

    .line 142
    return-void
.end method

.method public onPMResume()V
    .locals 4

    .prologue
    .line 161
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 162
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->userCreated:Z

    if-eqz v2, :cond_1

    .line 165
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 166
    .local v1, "parent":Lcom/poshmark/ui/PMActivity;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 167
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_CREATE:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->ordinal()I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 168
    const-class v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 172
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "parent":Lcom/poshmark/ui/PMActivity;
    :cond_0
    :goto_0
    return-void

    .line 169
    :cond_1
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->creationInProgress:Z

    if-eqz v2, :cond_0

    .line 170
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f060190

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/SignupFormFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 130
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 131
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->isAvtaarImageSet:Z

    if-eqz v0, :cond_0

    .line 132
    const-string v0, "IMAGE_FILE"

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->avataarImageFile:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    const-string v0, "IS_IMAGE_SET"

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 136
    :cond_0
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->externalToken:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->externalToken:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 198
    const-string v0, "facebook_sign_up_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 201
    :goto_0
    return-void

    .line 200
    :cond_0
    const-string v0, "email_sign_up_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0
.end method
