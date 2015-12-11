.class public Lco/vine/android/SignUpDetailsFragment;
.super Lco/vine/android/BaseFragment;
.source "SignUpDetailsFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;
.implements Lco/vine/android/widget/SpanClickListener;
.implements Lco/vine/android/util/ContactsHelper$ContactHelperListener;


# static fields
.field private static final SPAN_PRIVACY_POLICY:I = 0x1

.field private static final SPAN_TOS:I = 0x2


# instance fields
.field private mDoneButton:Landroid/view/MenuItem;

.field private mEmail:Landroid/widget/EditText;

.field private mPassword:Landroid/widget/EditText;

.field private mPhone:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Lco/vine/android/BaseFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lco/vine/android/SignUpDetailsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpDetailsFragment;

    .prologue
    .line 38
    invoke-direct {p0}, Lco/vine/android/SignUpDetailsFragment;->validate()Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lco/vine/android/SignUpDetailsFragment;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpDetailsFragment;

    .prologue
    .line 38
    iget-object v0, p0, Lco/vine/android/SignUpDetailsFragment;->mPhone:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/SignUpDetailsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpDetailsFragment;

    .prologue
    .line 38
    invoke-direct {p0}, Lco/vine/android/SignUpDetailsFragment;->onNextClicked()Z

    move-result v0

    return v0
.end method

.method private onNextClicked()Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 145
    invoke-virtual {p0}, Lco/vine/android/SignUpDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/SignUpDetailsFragment;->mEmail:Landroid/widget/EditText;

    invoke-static {v2, v3, v1}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 146
    invoke-virtual {p0}, Lco/vine/android/SignUpDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/SignUpPagerActivity;

    .line 147
    .local v0, "activity":Lco/vine/android/SignUpPagerActivity;
    if-eqz v0, :cond_0

    .line 148
    iget-object v1, p0, Lco/vine/android/SignUpDetailsFragment;->mEmail:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setLogin(Ljava/lang/String;)V

    .line 149
    iget-object v1, p0, Lco/vine/android/SignUpDetailsFragment;->mPassword:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setPassword(Ljava/lang/String;)V

    .line 150
    iget-object v1, p0, Lco/vine/android/SignUpDetailsFragment;->mPhone:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setPhone(Ljava/lang/String;)V

    .line 151
    invoke-virtual {v0}, Lco/vine/android/SignUpPagerActivity;->toNextStep()V

    .line 152
    const/4 v1, 0x1

    .line 154
    :cond_0
    return v1
.end method

.method private validate()Z
    .locals 2

    .prologue
    .line 174
    iget-object v0, p0, Lco/vine/android/SignUpDetailsFragment;->mEmail:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SignUpDetailsFragment;->mEmail:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    const/4 v1, 0x3

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lco/vine/android/SignUpDetailsFragment;->mPassword:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SignUpDetailsFragment;->mPassword:Landroid/widget/EditText;

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
    .line 168
    iget-object v0, p0, Lco/vine/android/SignUpDetailsFragment;->mDoneButton:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 169
    iget-object v0, p0, Lco/vine/android/SignUpDetailsFragment;->mDoneButton:Landroid/view/MenuItem;

    invoke-direct {p0}, Lco/vine/android/SignUpDetailsFragment;->validate()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 171
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
    .line 160
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 52
    invoke-super {p0, p1}, Lco/vine/android/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 53
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/SignUpDetailsFragment;->setHasOptionsMenu(Z)V

    .line 54
    invoke-virtual {p0}, Lco/vine/android/SignUpDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/SignUpPagerActivity;

    const v1, 0x7f0e0124

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setBarTitle(I)V

    .line 55
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 124
    const v1, 0x7f100004

    invoke-virtual {p2, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 125
    const v1, 0x7f0a0245

    invoke-interface {p1, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 126
    .local v0, "doneButton":Landroid/view/MenuItem;
    if-eqz v0, :cond_0

    .line 127
    invoke-direct {p0}, Lco/vine/android/SignUpDetailsFragment;->validate()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 129
    :cond_0
    iput-object v0, p0, Lco/vine/android/SignUpDetailsFragment;->mDoneButton:Landroid/view/MenuItem;

    .line 130
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "root"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 119
    const v0, 0x7f030094

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onEmailLoaded(Ljava/lang/String;)V
    .locals 2
    .param p1, "emailText"    # Ljava/lang/String;

    .prologue
    .line 214
    iget-object v0, p0, Lco/vine/android/SignUpDetailsFragment;->mEmail:Landroid/widget/EditText;

    .line 215
    .local v0, "email":Landroid/widget/EditText;
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 216
    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 217
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setSelection(I)V

    .line 219
    :cond_0
    return-void
.end method

.method public onNameLoaded(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 203
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 134
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 139
    invoke-super {p0, p1}, Lco/vine/android/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 136
    :pswitch_0
    invoke-direct {p0}, Lco/vine/android/SignUpDetailsFragment;->onNextClicked()Z

    move-result v0

    goto :goto_0

    .line 134
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0245
        :pswitch_0
    .end packed-switch
.end method

.method public onPhoneNumberLoaded(Ljava/lang/String;)V
    .locals 1
    .param p1, "phoneNumber"    # Ljava/lang/String;

    .prologue
    .line 207
    iget-object v0, p0, Lco/vine/android/SignUpDetailsFragment;->mPhone:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 208
    iget-object v0, p0, Lco/vine/android/SignUpDetailsFragment;->mPhone:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 210
    :cond_0
    return-void
.end method

.method public onSpanClicked(Landroid/view/View;ILjava/lang/Object;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/Object;

    .prologue
    .line 180
    invoke-virtual {p0}, Lco/vine/android/SignUpDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    if-nez v1, :cond_0

    .line 198
    :goto_0
    return-void

    .line 183
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SignUpDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lco/vine/android/WebViewActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 184
    .local v0, "i":Landroid/content/Intent;
    packed-switch p2, :pswitch_data_0

    goto :goto_0

    .line 186
    :pswitch_0
    const-string v1, "type"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 197
    :goto_1
    invoke-virtual {p0, v0}, Lco/vine/android/SignUpDetailsFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 190
    :pswitch_1
    const-string v1, "type"

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    goto :goto_1

    .line 184
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 164
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 13
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 59
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 60
    const v9, 0x7f0a0215

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/EditText;

    iput-object v9, p0, Lco/vine/android/SignUpDetailsFragment;->mEmail:Landroid/widget/EditText;

    .line 61
    iget-object v9, p0, Lco/vine/android/SignUpDetailsFragment;->mEmail:Landroid/widget/EditText;

    invoke-virtual {v9, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 63
    const v9, 0x7f0a0217

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/EditText;

    iput-object v9, p0, Lco/vine/android/SignUpDetailsFragment;->mPassword:Landroid/widget/EditText;

    .line 64
    iget-object v9, p0, Lco/vine/android/SignUpDetailsFragment;->mPassword:Landroid/widget/EditText;

    invoke-virtual {v9, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 65
    iget-object v9, p0, Lco/vine/android/SignUpDetailsFragment;->mPassword:Landroid/widget/EditText;

    invoke-virtual {p0}, Lco/vine/android/SignUpDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-static {v10}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v10

    const/4 v11, 0x0

    const/4 v12, 0x2

    invoke-virtual {v10, v11, v12}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/EditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 68
    const v9, 0x7f0a021a

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/EditText;

    iput-object v9, p0, Lco/vine/android/SignUpDetailsFragment;->mPhone:Landroid/widget/EditText;

    .line 69
    iget-object v9, p0, Lco/vine/android/SignUpDetailsFragment;->mPhone:Landroid/widget/EditText;

    new-instance v10, Lco/vine/android/SignUpDetailsFragment$1;

    invoke-direct {v10, p0}, Lco/vine/android/SignUpDetailsFragment$1;-><init>(Lco/vine/android/SignUpDetailsFragment;)V

    invoke-virtual {v9, v10}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 84
    const v9, 0x7f0a021e

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 85
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

    .line 87
    .local v0, "boldStyle":[Landroid/text/style/StyleSpan;
    const v9, 0x7f0e0220

    invoke-virtual {p0, v9}, Lco/vine/android/SignUpDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x22

    invoke-static {v0, v9, v10}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v6

    .line 90
    .local v6, "spanned":Landroid/text/Spanned;
    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 91
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v9

    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 93
    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    check-cast v1, Landroid/text/Spannable;

    .line 94
    .local v1, "clickSpannable":Landroid/text/Spannable;
    const/4 v9, 0x0

    invoke-interface {v6}, Landroid/text/Spanned;->length()I

    move-result v10

    const-class v11, Landroid/text/style/StyleSpan;

    invoke-interface {v6, v9, v10, v11}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Landroid/text/style/StyleSpan;

    .line 95
    .local v7, "spans":[Landroid/text/style/StyleSpan;
    invoke-virtual {p0}, Lco/vine/android/SignUpDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 98
    .local v5, "res":Landroid/content/res/Resources;
    const/4 v9, 0x0

    aget-object v9, v7, v9

    invoke-interface {v6, v9}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v8

    .line 99
    .local v8, "start":I
    const/4 v9, 0x0

    aget-object v9, v7, v9

    invoke-interface {v6, v9}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v3

    .line 100
    .local v3, "end":I
    new-instance v2, Lco/vine/android/widget/StyledClickableSpan;

    const/4 v9, 0x1

    const/4 v10, 0x0

    invoke-direct {v2, v9, v10, p0}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 102
    .local v2, "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    const v9, 0x7f09008d

    invoke-virtual {v5, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v2, v9}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 103
    const/16 v9, 0x21

    invoke-static {v1, v2, v8, v3, v9}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 107
    const/4 v9, 0x1

    aget-object v9, v7, v9

    invoke-interface {v6, v9}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v8

    .line 108
    const/4 v9, 0x1

    aget-object v9, v7, v9

    invoke-interface {v6, v9}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v3

    .line 109
    new-instance v2, Lco/vine/android/widget/StyledClickableSpan;

    .end local v2    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    const/4 v9, 0x2

    const/4 v10, 0x0

    invoke-direct {v2, v9, v10, p0}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 110
    .restart local v2    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    const v9, 0x7f09008d

    invoke-virtual {v5, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v2, v9}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 111
    const/16 v9, 0x21

    invoke-static {v1, v2, v8, v3, v9}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 114
    invoke-static {p0, p0}, Lco/vine/android/util/ContactsHelper;->loadContacts(Landroid/support/v4/app/Fragment;Lco/vine/android/util/ContactsHelper$ContactHelperListener;)V

    .line 115
    return-void
.end method
