.class public Lco/vine/android/ConfirmationFlowEntryFragment;
.super Lco/vine/android/BaseControllerFragment;
.source "ConfirmationFlowEntryFragment.java"

# interfaces
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# static fields
.field public static final ARG_PHONE_NUMBER:Ljava/lang/String; = "phone_number"

.field public static final STATE_PHONE_NUMBER:Ljava/lang/String; = "phone_number"


# instance fields
.field private mNext:Landroid/view/MenuItem;

.field private mNextEnabled:Z

.field private mPhone:Ljava/lang/String;

.field private mPhoneNumberBox:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lco/vine/android/BaseControllerFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lco/vine/android/ConfirmationFlowEntryFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConfirmationFlowEntryFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lco/vine/android/ConfirmationFlowEntryFragment;->toggleNextAction(Z)V

    return-void
.end method

.method private toggleNextAction(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 129
    iput-boolean p1, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mNextEnabled:Z

    .line 130
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mNext:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 131
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mNext:Landroid/view/MenuItem;

    invoke-interface {v0, p1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 133
    :cond_0
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 40
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onCreate(Landroid/os/Bundle;)V

    .line 41
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lco/vine/android/ConfirmationFlowEntryFragment;->setHasOptionsMenu(Z)V

    .line 42
    invoke-virtual {p0}, Lco/vine/android/ConfirmationFlowEntryFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 43
    .local v0, "args":Landroid/os/Bundle;
    if-eqz v0, :cond_1

    .line 44
    const-string v1, "phone_number"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mPhone:Ljava/lang/String;

    .line 48
    :cond_0
    :goto_0
    return-void

    .line 45
    :cond_1
    if-eqz p1, :cond_0

    .line 46
    const-string v1, "phone_number"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mPhone:Ljava/lang/String;

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 137
    const v0, 0x7f10000b

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 138
    const v0, 0x7f0a0246

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mNext:Landroid/view/MenuItem;

    .line 139
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mNext:Landroid/view/MenuItem;

    iget-boolean v1, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mNextEnabled:Z

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 140
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseControllerFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 141
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 64
    const v4, 0x7f030027

    const/4 v5, 0x0

    invoke-virtual {p1, v4, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 65
    .local v3, "v":Landroid/view/View;
    const v4, 0x7f0a0085

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    .line 67
    .local v2, "phoneNumberBox":Landroid/widget/EditText;
    const v4, 0x7f0a0084

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 68
    .local v0, "confirmation":Landroid/widget/TextView;
    const v4, 0x7f0e008a

    invoke-virtual {p0, v4}, Lco/vine/android/ConfirmationFlowEntryFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 71
    iget-object v1, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mPhone:Ljava/lang/String;

    .line 72
    .local v1, "phone":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 73
    invoke-virtual {v2, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 74
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v2, v4}, Landroid/widget/EditText;->setSelection(I)V

    .line 77
    :cond_0
    new-instance v4, Lco/vine/android/ConfirmationFlowEntryFragment$1;

    invoke-direct {v4, p0, v2}, Lco/vine/android/ConfirmationFlowEntryFragment$1;-><init>(Lco/vine/android/ConfirmationFlowEntryFragment;Landroid/widget/EditText;)V

    invoke-virtual {v2, v4}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 95
    iput-object v2, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mPhoneNumberBox:Landroid/widget/EditText;

    .line 97
    return-object v3
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 6
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 102
    packed-switch p2, :pswitch_data_0

    .line 126
    :cond_0
    :goto_0
    return-void

    .line 104
    :pswitch_0
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 106
    :pswitch_1
    invoke-virtual {p0}, Lco/vine/android/ConfirmationFlowEntryFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 107
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_0

    .line 108
    new-instance v2, Lco/vine/android/ConfirmationFlowVerificationFragment;

    invoke-direct {v2}, Lco/vine/android/ConfirmationFlowVerificationFragment;-><init>()V

    .line 109
    .local v2, "frag":Landroid/support/v4/app/Fragment;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 110
    .local v1, "args":Landroid/os/Bundle;
    const-string v3, "phone_number"

    iget-object v4, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mPhone:Ljava/lang/String;

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    const-string v3, "from_sign_up"

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 112
    invoke-virtual {v2, v1}, Landroid/support/v4/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 114
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    const v4, 0x7f040017

    const v5, 0x7f040018

    invoke-virtual {v3, v4, v5}, Landroid/support/v4/app/FragmentTransaction;->setCustomAnimations(II)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    const v4, 0x7f0a0102

    invoke-virtual {v3, v4, v2}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_0

    .line 102
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch

    .line 104
    :pswitch_data_1
    .packed-switch -0x1
        :pswitch_1
    .end packed-switch
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 8
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 153
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 174
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v2

    :cond_0
    :goto_0
    return v2

    .line 155
    :pswitch_0
    iget-object v4, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mPhoneNumberBox:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    .line 156
    .local v0, "e":Landroid/text/Editable;
    if-eqz v0, :cond_0

    .line 159
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mPhone:Ljava/lang/String;

    .line 161
    const/4 v4, 0x3

    invoke-static {v3, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(II)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v1

    .line 164
    .local v1, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    invoke-virtual {v1, p0, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 165
    const v4, 0x7f0e026f

    invoke-virtual {v1, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v4

    const v5, 0x7f0e0117

    new-array v6, v3, [Ljava/lang/Object;

    iget-object v7, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mPhone:Ljava/lang/String;

    aput-object v7, v6, v2

    invoke-virtual {p0, v5, v6}, Lco/vine/android/ConfirmationFlowEntryFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(Ljava/lang/String;)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    const v4, 0x7f0e0163

    invoke-virtual {v2, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    const v4, 0x7f0e0057

    invoke-virtual {v2, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    invoke-virtual {p0}, Lco/vine/android/ConfirmationFlowEntryFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    invoke-virtual {v2, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    move v2, v3

    .line 171
    goto :goto_0

    .line 153
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0246
        :pswitch_0
    .end packed-switch
.end method

.method public onPause()V
    .locals 3

    .prologue
    .line 52
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onPause()V

    .line 53
    invoke-virtual {p0}, Lco/vine/android/ConfirmationFlowEntryFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mPhoneNumberBox:Landroid/widget/EditText;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 54
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 145
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onResume()V

    .line 146
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mPhone:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 147
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/ConfirmationFlowEntryFragment;->toggleNextAction(Z)V

    .line 149
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 58
    const-string v0, "phone_number"

    iget-object v1, p0, Lco/vine/android/ConfirmationFlowEntryFragment;->mPhone:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 60
    return-void
.end method
