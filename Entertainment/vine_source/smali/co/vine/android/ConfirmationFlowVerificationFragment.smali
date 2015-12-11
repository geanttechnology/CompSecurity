.class public Lco/vine/android/ConfirmationFlowVerificationFragment;
.super Lco/vine/android/BaseControllerFragment;
.source "ConfirmationFlowVerificationFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ConfirmationFlowVerificationFragment$ConfirmationSessionListener;
    }
.end annotation


# static fields
.field public static final ARG_FROM_SIGNUP:Ljava/lang/String; = "from_sign_up"

.field public static final ARG_PHONE_NUMBER:Ljava/lang/String; = "phone_number"

.field private static final SEND_AGAIN_DELAY_MS:J = 0x2710L

.field private static final TRANSITION_DELAY_MS:J = 0x1f4L


# instance fields
.field private mConfirmationBox:Landroid/widget/EditText;

.field private mDone:Landroid/view/MenuItem;

.field private mErrorMessage:Landroid/widget/TextView;

.field private mFadeInAnimation:Landroid/view/animation/Animation;

.field private mFadeListener:Landroid/view/animation/Animation$AnimationListener;

.field private mFadeOutAnimation:Landroid/view/animation/Animation;

.field private mFadingIn:Landroid/view/View;

.field private mFadingOut:Landroid/view/View;

.field private mFromSignup:Z

.field private mHandler:Landroid/os/Handler;

.field private mMessage:Landroid/widget/TextView;

.field private mPhone:Ljava/lang/String;

.field private mProgressBar:Landroid/widget/ProgressBar;

.field private mSendAgain:Landroid/view/View;

.field private mSendAgainRunnable:Ljava/lang/Runnable;

.field private mSentAgain:Z

.field private mShowMessageRunnable:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Lco/vine/android/BaseControllerFragment;-><init>()V

    .line 179
    new-instance v0, Lco/vine/android/ConfirmationFlowVerificationFragment$2;

    invoke-direct {v0, p0}, Lco/vine/android/ConfirmationFlowVerificationFragment$2;-><init>(Lco/vine/android/ConfirmationFlowVerificationFragment;)V

    iput-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mShowMessageRunnable:Ljava/lang/Runnable;

    .line 209
    new-instance v0, Lco/vine/android/ConfirmationFlowVerificationFragment$3;

    invoke-direct {v0, p0}, Lco/vine/android/ConfirmationFlowVerificationFragment$3;-><init>(Lco/vine/android/ConfirmationFlowVerificationFragment;)V

    iput-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mSendAgainRunnable:Ljava/lang/Runnable;

    .line 216
    new-instance v0, Lco/vine/android/ConfirmationFlowVerificationFragment$4;

    invoke-direct {v0, p0}, Lco/vine/android/ConfirmationFlowVerificationFragment$4;-><init>(Lco/vine/android/ConfirmationFlowVerificationFragment;)V

    iput-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadeListener:Landroid/view/animation/Animation$AnimationListener;

    .line 250
    return-void
.end method

.method static synthetic access$100(Lco/vine/android/ConfirmationFlowVerificationFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConfirmationFlowVerificationFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lco/vine/android/ConfirmationFlowVerificationFragment;->toggleDoneAction(Z)V

    return-void
.end method

.method static synthetic access$1000(Lco/vine/android/ConfirmationFlowVerificationFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConfirmationFlowVerificationFragment;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mErrorMessage:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/ConfirmationFlowVerificationFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConfirmationFlowVerificationFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lco/vine/android/ConfirmationFlowVerificationFragment;->toggleErrorMessage(Z)V

    return-void
.end method

.method static synthetic access$300(Lco/vine/android/ConfirmationFlowVerificationFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConfirmationFlowVerificationFragment;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mSendAgain:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/ConfirmationFlowVerificationFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConfirmationFlowVerificationFragment;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadingIn:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$500(Lco/vine/android/ConfirmationFlowVerificationFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConfirmationFlowVerificationFragment;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadingOut:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/ConfirmationFlowVerificationFragment;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConfirmationFlowVerificationFragment;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mSendAgainRunnable:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/ConfirmationFlowVerificationFragment;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConfirmationFlowVerificationFragment;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$800(Lco/vine/android/ConfirmationFlowVerificationFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConfirmationFlowVerificationFragment;

    .prologue
    .line 28
    iget-boolean v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mSentAgain:Z

    return v0
.end method

.method static synthetic access$900(Lco/vine/android/ConfirmationFlowVerificationFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConfirmationFlowVerificationFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lco/vine/android/ConfirmationFlowVerificationFragment;->showProgressBar(Z)V

    return-void
.end method

.method private clearTextViewAnimations()V
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mMessage:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->clearAnimation()V

    .line 206
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mErrorMessage:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->clearAnimation()V

    .line 207
    return-void
.end method

.method private showProgressBar(Z)V
    .locals 2
    .param p1, "show"    # Z

    .prologue
    .line 157
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mProgressBar:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 158
    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mProgressBar:Landroid/widget/ProgressBar;

    if-eqz p1, :cond_1

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 160
    :cond_0
    return-void

    .line 158
    :cond_1
    const/16 v0, 0x8

    goto :goto_0
.end method

.method private toggleDoneAction(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 125
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mDone:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 126
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mDone:Landroid/view/MenuItem;

    invoke-interface {v0, p1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 128
    :cond_0
    return-void
.end method

.method private toggleErrorMessage(Z)V
    .locals 2
    .param p1, "show"    # Z

    .prologue
    .line 187
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mMessage:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mErrorMessage:Landroid/widget/TextView;

    if-nez v0, :cond_1

    .line 202
    :cond_0
    :goto_0
    return-void

    .line 190
    :cond_1
    invoke-direct {p0}, Lco/vine/android/ConfirmationFlowVerificationFragment;->clearTextViewAnimations()V

    .line 191
    if-eqz p1, :cond_2

    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mErrorMessage:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_2

    .line 192
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mMessage:Landroid/widget/TextView;

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadeOutAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 193
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mErrorMessage:Landroid/widget/TextView;

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadeInAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 194
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mErrorMessage:Landroid/widget/TextView;

    iput-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadingIn:Landroid/view/View;

    .line 195
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mMessage:Landroid/widget/TextView;

    iput-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadingOut:Landroid/view/View;

    goto :goto_0

    .line 196
    :cond_2
    if-nez p1, :cond_0

    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mMessage:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_0

    .line 197
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mMessage:Landroid/widget/TextView;

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadeInAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 198
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mErrorMessage:Landroid/widget/TextView;

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadeOutAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 199
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mMessage:Landroid/widget/TextView;

    iput-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadingIn:Landroid/view/View;

    .line 200
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mErrorMessage:Landroid/widget/TextView;

    iput-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadingOut:Landroid/view/View;

    goto :goto_0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 72
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 74
    iget-boolean v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFromSignup:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mPhone:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 75
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mPhone:Ljava/lang/String;

    invoke-static {v0, v1}, Lco/vine/android/ConfirmationFlowActivity;->requestPhoneVerification(Lco/vine/android/client/AppController;Ljava/lang/String;)V

    .line 77
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 164
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 177
    :goto_0
    return-void

    .line 166
    :pswitch_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mSentAgain:Z

    .line 167
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mPhone:Ljava/lang/String;

    invoke-static {v0, v1}, Lco/vine/android/ConfirmationFlowActivity;->requestPhoneVerification(Lco/vine/android/client/AppController;Ljava/lang/String;)V

    .line 168
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mShowMessageRunnable:Ljava/lang/Runnable;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 169
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mSendAgain:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 173
    :pswitch_1
    invoke-virtual {p0}, Lco/vine/android/ConfirmationFlowVerificationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/FindFriendsNUXActivity;->start(Landroid/content/Context;)V

    goto :goto_0

    .line 164
    :pswitch_data_0
    .packed-switch 0x7f0a0089
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 54
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onCreate(Landroid/os/Bundle;)V

    .line 55
    new-instance v1, Lco/vine/android/ConfirmationFlowVerificationFragment$ConfirmationSessionListener;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lco/vine/android/ConfirmationFlowVerificationFragment$ConfirmationSessionListener;-><init>(Lco/vine/android/ConfirmationFlowVerificationFragment;Lco/vine/android/ConfirmationFlowVerificationFragment$1;)V

    iput-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 56
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lco/vine/android/ConfirmationFlowVerificationFragment;->setHasOptionsMenu(Z)V

    .line 57
    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mHandler:Landroid/os/Handler;

    .line 58
    invoke-virtual {p0}, Lco/vine/android/ConfirmationFlowVerificationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f040010

    invoke-static {v1, v2}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadeOutAnimation:Landroid/view/animation/Animation;

    .line 59
    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadeOutAnimation:Landroid/view/animation/Animation;

    iget-object v2, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadeListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v1, v2}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 60
    invoke-virtual {p0}, Lco/vine/android/ConfirmationFlowVerificationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f04000e

    invoke-static {v1, v2}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadeInAnimation:Landroid/view/animation/Animation;

    .line 61
    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadeInAnimation:Landroid/view/animation/Animation;

    iget-object v2, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFadeListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v1, v2}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 63
    invoke-virtual {p0}, Lco/vine/android/ConfirmationFlowVerificationFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 64
    .local v0, "args":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 65
    const-string v1, "phone_number"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mPhone:Ljava/lang/String;

    .line 66
    const-string v1, "from_sign_up"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFromSignup:Z

    .line 68
    :cond_0
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 132
    const v0, 0x7f100004

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 133
    const v0, 0x7f0a0245

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mDone:Landroid/view/MenuItem;

    .line 134
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseControllerFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 135
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 9
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const v8, 0x7f0a0086

    const/4 v7, 0x0

    .line 81
    const v4, 0x7f030028

    invoke-virtual {p1, v4, p2, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 82
    .local v3, "v":Landroid/view/View;
    if-nez v3, :cond_0

    .line 83
    const/4 v3, 0x0

    .line 121
    .end local v3    # "v":Landroid/view/View;
    :goto_0
    return-object v3

    .line 86
    .restart local v3    # "v":Landroid/view/View;
    :cond_0
    invoke-virtual {v3, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 87
    .local v0, "confirmation":Landroid/widget/TextView;
    const v4, 0x7f0e0088

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    iget-object v6, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mPhone:Ljava/lang/String;

    aput-object v6, v5, v7

    invoke-virtual {p0, v4, v5}, Lco/vine/android/ConfirmationFlowVerificationFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 89
    iget-boolean v4, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mFromSignup:Z

    if-eqz v4, :cond_1

    .line 90
    const v4, 0x7f0a008a

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 91
    .local v2, "skip":Landroid/view/View;
    invoke-virtual {v2, v7}, Landroid/view/View;->setVisibility(I)V

    .line 92
    invoke-virtual {v2, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 95
    .end local v2    # "skip":Landroid/view/View;
    :cond_1
    const v4, 0x7f0a0085

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    .line 96
    .local v1, "confirmationBox":Landroid/widget/EditText;
    new-instance v4, Lco/vine/android/ConfirmationFlowVerificationFragment$1;

    invoke-direct {v4, p0, v1}, Lco/vine/android/ConfirmationFlowVerificationFragment$1;-><init>(Lco/vine/android/ConfirmationFlowVerificationFragment;Landroid/widget/EditText;)V

    invoke-virtual {v1, v4}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 114
    iput-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mConfirmationBox:Landroid/widget/EditText;

    .line 115
    invoke-virtual {v3, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mMessage:Landroid/widget/TextView;

    .line 116
    const v4, 0x7f0a0087

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mErrorMessage:Landroid/widget/TextView;

    .line 118
    const v4, 0x7f0a0089

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mSendAgain:Landroid/view/View;

    .line 119
    const v4, 0x7f0a0088

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ProgressBar;

    iput-object v4, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mProgressBar:Landroid/widget/ProgressBar;

    goto :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 5
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 139
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 151
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    :cond_0
    :goto_0
    return v1

    .line 141
    :pswitch_0
    iget-object v3, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mConfirmationBox:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    .line 142
    .local v0, "e":Landroid/text/Editable;
    if-eqz v0, :cond_0

    .line 145
    invoke-direct {p0, v2}, Lco/vine/android/ConfirmationFlowVerificationFragment;->showProgressBar(Z)V

    .line 146
    invoke-interface {p1, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 147
    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lco/vine/android/client/AppController;->verifyPhoneNumber(Lco/vine/android/client/Session;Ljava/lang/String;)Ljava/lang/String;

    move v1, v2

    .line 148
    goto :goto_0

    .line 139
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0245
        :pswitch_0
    .end packed-switch
.end method

.method public onPause()V
    .locals 3

    .prologue
    .line 244
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onPause()V

    .line 245
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mShowMessageRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 246
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mSendAgainRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 247
    invoke-virtual {p0}, Lco/vine/android/ConfirmationFlowVerificationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mConfirmationBox:Landroid/widget/EditText;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 248
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 238
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onResume()V

    .line 239
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment;->mSendAgain:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 240
    return-void
.end method
