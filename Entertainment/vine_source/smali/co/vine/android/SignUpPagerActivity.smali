.class public Lco/vine/android/SignUpPagerActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "SignUpPagerActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/SignUpPagerActivity$SignUpListener;,
        Lco/vine/android/SignUpPagerActivity$SignUpPagerAdapter;
    }
.end annotation


# static fields
.field public static final EXTRA_FINISH:Ljava/lang/String; = "finish"

.field public static final EXTRA_LOGIN:Ljava/lang/String; = "user"

.field public static final FLOW_STEP_DETAILS:I = 0x1

.field public static final FLOW_STEP_NAME_AVATAR:I = 0x0

.field private static final NUM_PAGES:I = 0x2

.field public static final REQUEST_CODE_CONFIRM_PHONE:I = 0x675

.field private static final STATE_LOGIN:Ljava/lang/String; = "s_login"

.field private static final STATE_NAME:Ljava/lang/String; = "s_name"

.field private static final STATE_PASSWORD:Ljava/lang/String; = "s_password"

.field private static final STATE_PHONE:Ljava/lang/String; = "s_phone"

.field private static final STATE_PROFILE:Ljava/lang/String; = "s_profile"


# instance fields
.field private mAvatarFrag:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/support/v4/app/Fragment;",
            ">;"
        }
    .end annotation
.end field

.field private mDetailsFrag:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/support/v4/app/Fragment;",
            ">;"
        }
    .end annotation
.end field

.field private mFinish:Z

.field private mLogin:Ljava/lang/String;

.field private mName:Ljava/lang/String;

.field private mPager:Lco/vine/android/widget/ConfigurableViewPager;

.field private mPassword:Ljava/lang/String;

.field private mPhone:Ljava/lang/String;

.field private mProfile:Landroid/net/Uri;

.field private mTwitterUser:Lco/vine/android/api/TwitterUser;

.field private mVineLogin:Lco/vine/android/api/VineLogin;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    .line 260
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/SignUpPagerActivity;)Lco/vine/android/api/VineLogin;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpPagerActivity;

    .prologue
    .line 30
    iget-object v0, p0, Lco/vine/android/SignUpPagerActivity;->mVineLogin:Lco/vine/android/api/VineLogin;

    return-object v0
.end method

.method static synthetic access$102(Lco/vine/android/SignUpPagerActivity;Ljava/lang/ref/WeakReference;)Ljava/lang/ref/WeakReference;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SignUpPagerActivity;
    .param p1, "x1"    # Ljava/lang/ref/WeakReference;

    .prologue
    .line 30
    iput-object p1, p0, Lco/vine/android/SignUpPagerActivity;->mAvatarFrag:Ljava/lang/ref/WeakReference;

    return-object p1
.end method

.method static synthetic access$202(Lco/vine/android/SignUpPagerActivity;Ljava/lang/ref/WeakReference;)Ljava/lang/ref/WeakReference;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SignUpPagerActivity;
    .param p1, "x1"    # Ljava/lang/ref/WeakReference;

    .prologue
    .line 30
    iput-object p1, p0, Lco/vine/android/SignUpPagerActivity;->mDetailsFrag:Ljava/lang/ref/WeakReference;

    return-object p1
.end method

.method static synthetic access$300(Lco/vine/android/SignUpPagerActivity;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpPagerActivity;

    .prologue
    .line 30
    iget-boolean v0, p0, Lco/vine/android/SignUpPagerActivity;->mFinish:Z

    return v0
.end method

.method static synthetic access$400(Lco/vine/android/SignUpPagerActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpPagerActivity;

    .prologue
    .line 30
    iget-object v0, p0, Lco/vine/android/SignUpPagerActivity;->mPhone:Ljava/lang/String;

    return-object v0
.end method

.method public static getIntent(Landroid/content/Context;Landroid/os/Bundle;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 89
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/SignUpPagerActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 90
    .local v0, "intent":Landroid/content/Intent;
    if-eqz p1, :cond_0

    .line 91
    invoke-virtual {v0, p1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 93
    :cond_0
    return-object v0
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 196
    packed-switch p1, :pswitch_data_0

    .line 202
    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mPager:Lco/vine/android/widget/ConfigurableViewPager;

    invoke-virtual {v1}, Lco/vine/android/widget/ConfigurableViewPager;->getCurrentItem()I

    move-result v1

    packed-switch v1, :pswitch_data_1

    .line 224
    :cond_0
    :goto_0
    return-void

    .line 198
    :pswitch_0
    invoke-static {p0}, Lco/vine/android/FindFriendsNUXActivity;->start(Landroid/content/Context;)V

    goto :goto_0

    .line 204
    :pswitch_1
    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mAvatarFrag:Ljava/lang/ref/WeakReference;

    if-eqz v1, :cond_0

    .line 205
    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mAvatarFrag:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 206
    .local v0, "frag":Landroid/support/v4/app/Fragment;
    if-eqz v0, :cond_0

    .line 207
    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0

    .line 213
    .end local v0    # "frag":Landroid/support/v4/app/Fragment;
    :pswitch_2
    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mDetailsFrag:Ljava/lang/ref/WeakReference;

    if-eqz v1, :cond_0

    .line 214
    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mDetailsFrag:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 215
    .restart local v0    # "frag":Landroid/support/v4/app/Fragment;
    if-eqz v0, :cond_0

    .line 216
    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0

    .line 196
    nop

    :pswitch_data_0
    .packed-switch 0x675
        :pswitch_0
    .end packed-switch

    .line 202
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 108
    iget-object v0, p0, Lco/vine/android/SignUpPagerActivity;->mPager:Lco/vine/android/widget/ConfigurableViewPager;

    invoke-virtual {v0}, Lco/vine/android/widget/ConfigurableViewPager;->getCurrentItem()I

    move-result v0

    if-nez v0, :cond_0

    .line 109
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onBackPressed()V

    .line 113
    :goto_0
    return-void

    .line 111
    :cond_0
    iget-object v0, p0, Lco/vine/android/SignUpPagerActivity;->mPager:Lco/vine/android/widget/ConfigurableViewPager;

    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mPager:Lco/vine/android/widget/ConfigurableViewPager;

    invoke-virtual {v1}, Lco/vine/android/widget/ConfigurableViewPager;->getCurrentItem()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/ConfigurableViewPager;->setCurrentItem(I)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 63
    const v1, 0x7f030093

    invoke-super {p0, p1, v1, v2}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 65
    invoke-virtual {p0}, Lco/vine/android/SignUpPagerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 66
    .local v0, "i":Landroid/content/Intent;
    if-eqz v0, :cond_0

    .line 67
    const-string v1, "finish"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/SignUpPagerActivity;->mFinish:Z

    .line 70
    :cond_0
    const v1, 0x7f0a00da

    invoke-virtual {p0, v1}, Lco/vine/android/SignUpPagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/ConfigurableViewPager;

    iput-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mPager:Lco/vine/android/widget/ConfigurableViewPager;

    .line 71
    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mPager:Lco/vine/android/widget/ConfigurableViewPager;

    invoke-virtual {v1, v2}, Lco/vine/android/widget/ConfigurableViewPager;->setSwipingEnabled(Z)V

    .line 72
    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mPager:Lco/vine/android/widget/ConfigurableViewPager;

    new-instance v2, Lco/vine/android/SignUpPagerActivity$SignUpPagerAdapter;

    invoke-virtual {p0}, Lco/vine/android/SignUpPagerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lco/vine/android/SignUpPagerActivity$SignUpPagerAdapter;-><init>(Lco/vine/android/SignUpPagerActivity;Landroid/support/v4/app/FragmentManager;)V

    invoke-virtual {v1, v2}, Lco/vine/android/widget/ConfigurableViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 74
    new-instance v1, Lco/vine/android/SignUpPagerActivity$SignUpListener;

    invoke-direct {v1, p0}, Lco/vine/android/SignUpPagerActivity$SignUpListener;-><init>(Lco/vine/android/SignUpPagerActivity;)V

    iput-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 75
    invoke-virtual {p0}, Lco/vine/android/SignUpPagerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "user"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineLogin;

    iput-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mVineLogin:Lco/vine/android/api/VineLogin;

    .line 77
    if-eqz p1, :cond_1

    .line 78
    const-string v1, "s_login"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mLogin:Ljava/lang/String;

    .line 79
    const-string v1, "s_name"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mName:Ljava/lang/String;

    .line 80
    const-string v1, "s_password"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mPassword:Ljava/lang/String;

    .line 81
    const-string v1, "s_phone"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mPhone:Ljava/lang/String;

    .line 82
    const-string v1, "s_profile"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    iput-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mProfile:Landroid/net/Uri;

    .line 85
    :cond_1
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {p0, v1, v2, v3, v4}, Lco/vine/android/SignUpPagerActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 86
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 117
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 123
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 119
    :pswitch_0
    invoke-virtual {p0}, Lco/vine/android/SignUpPagerActivity;->onBackPressed()V

    .line 120
    const/4 v0, 0x1

    goto :goto_0

    .line 117
    nop

    :pswitch_data_0
    .packed-switch 0x102002c
        :pswitch_0
    .end packed-switch
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 98
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 99
    const-string v0, "s_login"

    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mLogin:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    const-string v0, "s_password"

    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mPassword:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    const-string v0, "s_name"

    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mName:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    const-string v0, "s_phone"

    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mPhone:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    const-string v0, "s_profile"

    iget-object v1, p0, Lco/vine/android/SignUpPagerActivity;->mProfile:Landroid/net/Uri;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 104
    return-void
.end method

.method protected setBarTitle(I)V
    .locals 2
    .param p1, "resId"    # I

    .prologue
    const/4 v1, 0x0

    .line 167
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p0, v1, v0, p1, v1}, Lco/vine/android/SignUpPagerActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 168
    return-void
.end method

.method public setLogin(Ljava/lang/String;)V
    .locals 0
    .param p1, "login"    # Ljava/lang/String;

    .prologue
    .line 171
    iput-object p1, p0, Lco/vine/android/SignUpPagerActivity;->mLogin:Ljava/lang/String;

    .line 172
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 183
    iput-object p1, p0, Lco/vine/android/SignUpPagerActivity;->mName:Ljava/lang/String;

    .line 184
    return-void
.end method

.method public setPassword(Ljava/lang/String;)V
    .locals 0
    .param p1, "password"    # Ljava/lang/String;

    .prologue
    .line 175
    iput-object p1, p0, Lco/vine/android/SignUpPagerActivity;->mPassword:Ljava/lang/String;

    .line 176
    return-void
.end method

.method public setPhone(Ljava/lang/String;)V
    .locals 0
    .param p1, "phone"    # Ljava/lang/String;

    .prologue
    .line 179
    iput-object p1, p0, Lco/vine/android/SignUpPagerActivity;->mPhone:Ljava/lang/String;

    .line 180
    return-void
.end method

.method public setProfile(Landroid/net/Uri;)V
    .locals 0
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 187
    iput-object p1, p0, Lco/vine/android/SignUpPagerActivity;->mProfile:Landroid/net/Uri;

    .line 188
    return-void
.end method

.method public setTwitterUser(Lco/vine/android/api/TwitterUser;)V
    .locals 0
    .param p1, "tUser"    # Lco/vine/android/api/TwitterUser;

    .prologue
    .line 191
    iput-object p1, p0, Lco/vine/android/SignUpPagerActivity;->mTwitterUser:Lco/vine/android/api/TwitterUser;

    .line 192
    return-void
.end method

.method protected toNextStep()V
    .locals 11

    .prologue
    const v3, 0x7f0f0037

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 129
    iget-object v0, p0, Lco/vine/android/SignUpPagerActivity;->mPager:Lco/vine/android/widget/ConfigurableViewPager;

    invoke-virtual {v0}, Lco/vine/android/widget/ConfigurableViewPager;->getCurrentItem()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 164
    :goto_0
    return-void

    .line 131
    :pswitch_0
    iget-object v0, p0, Lco/vine/android/SignUpPagerActivity;->mTwitterUser:Lco/vine/android/api/TwitterUser;

    if-eqz v0, :cond_0

    .line 132
    new-instance v10, Landroid/app/ProgressDialog;

    invoke-direct {v10, p0, v3}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 134
    .local v10, "dialog":Landroid/app/ProgressDialog;
    const v0, 0x7f0e0129

    invoke-virtual {p0, v0}, Lco/vine/android/SignUpPagerActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v10, v0}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 135
    invoke-virtual {v10, v2}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 137
    :try_start_0
    invoke-virtual {v10}, Landroid/app/ProgressDialog;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 141
    :goto_1
    iput-object v10, p0, Lco/vine/android/SignUpPagerActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 142
    iget-object v0, p0, Lco/vine/android/SignUpPagerActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/SignUpPagerActivity;->mName:Ljava/lang/String;

    iget-object v4, p0, Lco/vine/android/SignUpPagerActivity;->mPhone:Ljava/lang/String;

    iget-object v5, p0, Lco/vine/android/SignUpPagerActivity;->mProfile:Landroid/net/Uri;

    iget-object v6, p0, Lco/vine/android/SignUpPagerActivity;->mTwitterUser:Lco/vine/android/api/TwitterUser;

    iget-object v7, p0, Lco/vine/android/SignUpPagerActivity;->mVineLogin:Lco/vine/android/api/VineLogin;

    move-object v2, v1

    invoke-virtual/range {v0 .. v7}, Lco/vine/android/client/AppController;->signUp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Lco/vine/android/api/TwitterUser;Lco/vine/android/api/VineLogin;)Ljava/lang/String;

    goto :goto_0

    .line 145
    .end local v10    # "dialog":Landroid/app/ProgressDialog;
    :cond_0
    iget-object v0, p0, Lco/vine/android/SignUpPagerActivity;->mPager:Lco/vine/android/widget/ConfigurableViewPager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/ConfigurableViewPager;->setCurrentItem(I)V

    goto :goto_0

    .line 150
    :pswitch_1
    new-instance v10, Landroid/app/ProgressDialog;

    invoke-direct {v10, p0, v3}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 152
    .restart local v10    # "dialog":Landroid/app/ProgressDialog;
    iput-object v10, p0, Lco/vine/android/SignUpPagerActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 153
    invoke-virtual {v10, v2}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 154
    const v0, 0x7f0e0221

    invoke-virtual {p0, v0}, Lco/vine/android/SignUpPagerActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v10, v0}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 156
    :try_start_1
    invoke-virtual {v10}, Landroid/app/ProgressDialog;->show()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 160
    :goto_2
    iget-object v2, p0, Lco/vine/android/SignUpPagerActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/SignUpPagerActivity;->mLogin:Ljava/lang/String;

    iget-object v4, p0, Lco/vine/android/SignUpPagerActivity;->mPassword:Ljava/lang/String;

    iget-object v5, p0, Lco/vine/android/SignUpPagerActivity;->mName:Ljava/lang/String;

    iget-object v6, p0, Lco/vine/android/SignUpPagerActivity;->mPhone:Ljava/lang/String;

    iget-object v7, p0, Lco/vine/android/SignUpPagerActivity;->mProfile:Landroid/net/Uri;

    move-object v8, v1

    move-object v9, v1

    invoke-virtual/range {v2 .. v9}, Lco/vine/android/client/AppController;->signUp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Lco/vine/android/api/TwitterUser;Lco/vine/android/api/VineLogin;)Ljava/lang/String;

    goto :goto_0

    .line 138
    :catch_0
    move-exception v0

    goto :goto_1

    .line 157
    :catch_1
    move-exception v0

    goto :goto_2

    .line 129
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
