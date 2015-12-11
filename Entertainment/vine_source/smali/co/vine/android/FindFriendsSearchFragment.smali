.class public Lco/vine/android/FindFriendsSearchFragment;
.super Lco/vine/android/BaseControllerFragment;
.source "FindFriendsSearchFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field public static final ARG_LAYOUT:Ljava/lang/String; = "layout"


# instance fields
.field private mBold:[Landroid/text/style/StyleSpan;

.field private mLayoutRes:I

.field private mSmsIntent:Landroid/content/Intent;

.field private mView:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lco/vine/android/BaseControllerFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 40
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 41
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lco/vine/android/FindFriendsSearchFragment;->mSmsIntent:Landroid/content/Intent;

    .line 42
    iget-object v0, p0, Lco/vine/android/FindFriendsSearchFragment;->mSmsIntent:Landroid/content/Intent;

    const-string v1, "vnd.android-dir/mms-sms"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 43
    iget-object v0, p0, Lco/vine/android/FindFriendsSearchFragment;->mSmsIntent:Landroid/content/Intent;

    const-string v1, "sms_body"

    invoke-virtual {p0}, Lco/vine/android/FindFriendsSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lco/vine/android/util/Util;->getSmsMessage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 44
    iget-object v0, p0, Lco/vine/android/FindFriendsSearchFragment;->mSmsIntent:Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/FindFriendsSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->resolveActivity(Landroid/content/pm/PackageManager;)Landroid/content/ComponentName;

    move-result-object v0

    if-nez v0, :cond_0

    .line 45
    iget-object v0, p0, Lco/vine/android/FindFriendsSearchFragment;->mView:Landroid/view/View;

    const v1, 0x7f0a00f3

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 47
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 74
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 100
    :goto_0
    return-void

    .line 76
    :pswitch_0
    const-string v1, "sms"

    const-string v2, "FindFriends"

    invoke-static {v1, v2}, Lco/vine/android/util/FlurryUtils;->trackInvite(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    iget-object v1, p0, Lco/vine/android/FindFriendsSearchFragment;->mSmsIntent:Landroid/content/Intent;

    const v2, 0x7f0e01be

    invoke-virtual {p0, v2}, Lco/vine/android/FindFriendsSearchFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p0, v1}, Lco/vine/android/FindFriendsSearchFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 81
    :pswitch_1
    const-string v1, "email"

    const-string v2, "FindFriends"

    invoke-static {v1, v2}, Lco/vine/android/util/FlurryUtils;->trackInvite(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SENDTO"

    const-string v2, "mailto"

    const-string v3, ""

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Landroid/net/Uri;->fromParts(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 84
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "android.intent.extra.SUBJECT"

    const v2, 0x7f0e00e6

    invoke-virtual {p0, v2}, Lco/vine/android/FindFriendsSearchFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 86
    const-string v1, "android.intent.extra.TEXT"

    invoke-virtual {p0}, Lco/vine/android/FindFriendsSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lco/vine/android/util/Util;->getEmailMessage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 87
    const v1, 0x7f0e00e4

    invoke-virtual {p0, v1}, Lco/vine/android/FindFriendsSearchFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p0, v1}, Lco/vine/android/FindFriendsSearchFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 92
    .end local v0    # "intent":Landroid/content/Intent;
    :pswitch_2
    const-string v1, "FindFriends"

    invoke-static {v1}, Lco/vine/android/util/FlurryUtils;->trackVisitSearch(Ljava/lang/String;)V

    .line 93
    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/FindFriendsSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const-class v3, Lco/vine/android/SearchActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v1}, Lco/vine/android/FindFriendsSearchFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 74
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a00f2
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 31
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onCreate(Landroid/os/Bundle;)V

    .line 32
    new-array v1, v4, [Landroid/text/style/StyleSpan;

    new-instance v2, Landroid/text/style/StyleSpan;

    invoke-direct {v2, v4}, Landroid/text/style/StyleSpan;-><init>(I)V

    aput-object v2, v1, v3

    iput-object v1, p0, Lco/vine/android/FindFriendsSearchFragment;->mBold:[Landroid/text/style/StyleSpan;

    .line 34
    invoke-virtual {p0}, Lco/vine/android/FindFriendsSearchFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 35
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "layout"

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lco/vine/android/FindFriendsSearchFragment;->mLayoutRes:I

    .line 36
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v6, 0x22

    .line 52
    iget v4, p0, Lco/vine/android/FindFriendsSearchFragment;->mLayoutRes:I

    const/4 v5, 0x0

    invoke-virtual {p1, v4, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 54
    .local v3, "v":Landroid/view/View;
    const v4, 0x7f0a00f2

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 55
    .local v2, "search":Landroid/widget/Button;
    iget-object v4, p0, Lco/vine/android/FindFriendsSearchFragment;->mBold:[Landroid/text/style/StyleSpan;

    const v5, 0x7f0e00ea

    invoke-virtual {p0, v5}, Lco/vine/android/FindFriendsSearchFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5, v6}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 57
    invoke-virtual {v2, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 59
    const v4, 0x7f0a00f3

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 60
    .local v1, "inviteText":Landroid/widget/Button;
    iget-object v4, p0, Lco/vine/android/FindFriendsSearchFragment;->mBold:[Landroid/text/style/StyleSpan;

    const v5, 0x7f0e00eb

    invoke-virtual {p0, v5}, Lco/vine/android/FindFriendsSearchFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5, v6}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 62
    invoke-virtual {v1, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 64
    const v4, 0x7f0a00f4

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 65
    .local v0, "inviteEmail":Landroid/widget/Button;
    iget-object v4, p0, Lco/vine/android/FindFriendsSearchFragment;->mBold:[Landroid/text/style/StyleSpan;

    const v5, 0x7f0e00e9

    invoke-virtual {p0, v5}, Lco/vine/android/FindFriendsSearchFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5, v6}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 67
    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 68
    iput-object v3, p0, Lco/vine/android/FindFriendsSearchFragment;->mView:Landroid/view/View;

    .line 69
    return-object v3
.end method
