.class public Lco/vine/android/ReshareFragment;
.super Lco/vine/android/BaseControllerFragment;
.source "ReshareFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ReshareFragment$ReshareListener;
    }
.end annotation


# static fields
.field public static final ARG_DESCRIPTION:Ljava/lang/String; = "description"

.field public static final ARG_NETWORK:Ljava/lang/String; = "network"

.field public static final ARG_POST_ID:Ljava/lang/String; = "post_id"

.field public static final ARG_SHARE_URL:Ljava/lang/String; = "share_url"

.field public static final ARG_THUMBNAIL_URL:Ljava/lang/String; = "thumbnail_url"

.field public static final FRAGMENT_TAG:Ljava/lang/String; = "reshare"

.field private static final MAX_CHARS_TWITTER:I = 0x8c

.field public static final NETWORK_FACEBOOK:Ljava/lang/String; = "facebook"

.field public static final NETWORK_TWITTER:Ljava/lang/String; = "twitter"


# instance fields
.field private mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

.field private mCaption:Landroid/widget/EditText;

.field private mDescription:Ljava/lang/String;

.field private mNetwork:Ljava/lang/String;

.field private mPostId:J

.field private mProgress:Landroid/app/ProgressDialog;

.field private mShareProgress:Landroid/app/ProgressDialog;

.field private mShareUrl:Ljava/lang/String;

.field private mThumbnailKey:Lco/vine/android/util/image/ImageKey;

.field private mThumbnailUrl:Ljava/lang/String;

.field private mThumbnailView:Landroid/widget/ImageView;

.field private mTwitter:Lcom/twitter/android/sdk/Twitter;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Lco/vine/android/BaseControllerFragment;-><init>()V

    .line 71
    new-instance v0, Lco/vine/android/ReshareFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/ReshareFragment$1;-><init>(Lco/vine/android/ReshareFragment;)V

    iput-object v0, p0, Lco/vine/android/ReshareFragment;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    .line 324
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/ReshareFragment;)Landroid/app/ProgressDialog;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ReshareFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mShareProgress:Landroid/app/ProgressDialog;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/ReshareFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ReshareFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/ReshareFragment;)Landroid/app/ProgressDialog;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ReshareFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mProgress:Landroid/app/ProgressDialog;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/ReshareFragment;)Lco/vine/android/util/image/ImageKey;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ReshareFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mThumbnailKey:Lco/vine/android/util/image/ImageKey;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/ReshareFragment;Landroid/graphics/Bitmap;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ReshareFragment;
    .param p1, "x1"    # Landroid/graphics/Bitmap;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Lco/vine/android/ReshareFragment;->setThumbnailImage(Landroid/graphics/Bitmap;)V

    return-void
.end method

.method static synthetic access$500(Lco/vine/android/ReshareFragment;)Lco/vine/android/CaptchaRequestHelper;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ReshareFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    return-object v0
.end method

.method private setThumbnailImage(Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 316
    if-eqz p1, :cond_0

    .line 317
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mThumbnailView:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/ReshareFragment;->mThumbnailView:Landroid/widget/ImageView;

    invoke-virtual {v2}, Landroid/widget/ImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 322
    :goto_0
    return-void

    .line 319
    :cond_0
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mThumbnailView:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 320
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mThumbnailView:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f09007f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    goto :goto_0
.end method

.method private validateSocialConnect()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 114
    const-string v1, "facebook"

    iget-object v2, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 115
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->isConnectedToFacebook(Landroid/app/Activity;)Z

    move-result v0

    .line 121
    :cond_0
    :goto_0
    return v0

    .line 116
    :cond_1
    const-string v1, "twitter"

    iget-object v2, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 119
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "settings_twitter_connected"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    goto :goto_0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x0

    .line 135
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 138
    const-string v5, "facebook"

    iget-object v6, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 139
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v5, v6, v8}, Lco/vine/android/client/AppController;->getValidFacebookSession(Landroid/app/Activity;Z)Lcom/facebook/Session;

    move-result-object v3

    .line 140
    .local v3, "session":Lcom/facebook/Session;
    if-nez v3, :cond_3

    .line 141
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5, p0}, Lco/vine/android/client/AppController;->connectToFacebookInitialize(Landroid/support/v4/app/Fragment;)V

    .line 163
    .end local v3    # "session":Lcom/facebook/Session;
    :cond_0
    :goto_0
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mCaption:Landroid/widget/EditText;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->setLines(I)V

    .line 164
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mCaption:Landroid/widget/EditText;

    invoke-virtual {v5, v8}, Landroid/widget/EditText;->setHorizontallyScrolling(Z)V

    .line 166
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mThumbnailUrl:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 167
    new-instance v5, Lco/vine/android/util/image/ImageKey;

    iget-object v6, p0, Lco/vine/android/ReshareFragment;->mThumbnailUrl:Ljava/lang/String;

    invoke-direct {v5, v6}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;)V

    iput-object v5, p0, Lco/vine/android/ReshareFragment;->mThumbnailKey:Lco/vine/android/util/image/ImageKey;

    .line 168
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v6, p0, Lco/vine/android/ReshareFragment;->mThumbnailKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {v5, v6}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v5

    invoke-direct {p0, v5}, Lco/vine/android/ReshareFragment;->setThumbnailImage(Landroid/graphics/Bitmap;)V

    .line 170
    :cond_1
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mDescription:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 171
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mCaption:Landroid/widget/EditText;

    iget-object v6, p0, Lco/vine/android/ReshareFragment;->mDescription:Ljava/lang/String;

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 173
    :cond_2
    return-void

    .line 143
    .restart local v3    # "session":Lcom/facebook/Session;
    :cond_3
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getPendingFacebookToken()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 144
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->sendFacebookToken()Ljava/lang/String;

    goto :goto_0

    .line 147
    .end local v3    # "session":Lcom/facebook/Session;
    :cond_4
    const-string v5, "twitter"

    iget-object v6, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 148
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 149
    .local v1, "activity":Landroid/app/Activity;
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    invoke-virtual {v5}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v5

    invoke-static {v1, v5}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 151
    .local v0, "ac":Landroid/accounts/Account;
    invoke-static {v1}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v2

    .line 152
    .local v2, "am":Landroid/accounts/AccountManager;
    if-eqz v0, :cond_5

    if-nez v2, :cond_6

    .line 153
    :cond_5
    new-instance v5, Lco/vine/android/VineLoggingException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Account or AM is null: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v5}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 155
    :cond_6
    const-string v5, "account_t_token"

    invoke-virtual {v2, v0, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 156
    .local v4, "token":Ljava/lang/String;
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 157
    iget-object v5, p0, Lco/vine/android/ReshareFragment;->mTwitter:Lcom/twitter/android/sdk/Twitter;

    invoke-static {v5, v1}, Lco/vine/android/client/AppController;->startTwitterAuthWithFinish(Lcom/twitter/android/sdk/Twitter;Landroid/app/Activity;)V

    goto/16 :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 12
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const-wide/16 v10, 0x0

    const/4 v9, -0x1

    .line 241
    if-nez p2, :cond_1

    .line 242
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 313
    :cond_0
    :goto_0
    return-void

    .line 245
    :cond_1
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    invoke-virtual {v0, p1, p2, p3}, Lco/vine/android/CaptchaRequestHelper;->onActivityResult(IILandroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 246
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mShareProgress:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mShareProgress:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 247
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mShareProgress:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->hide()V

    goto :goto_0

    .line 252
    :cond_2
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mProgress:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mProgress:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-nez v0, :cond_4

    .line 253
    :cond_3
    new-instance v7, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f0f0037

    invoke-direct {v7, v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 255
    .local v7, "d":Landroid/app/ProgressDialog;
    const v0, 0x7f0e0120

    invoke-virtual {p0, v0}, Lco/vine/android/ReshareFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 256
    const/4 v0, 0x0

    invoke-virtual {v7, v0}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 257
    invoke-virtual {v7}, Landroid/app/ProgressDialog;->show()V

    .line 258
    iput-object v7, p0, Lco/vine/android/ReshareFragment;->mProgress:Landroid/app/ProgressDialog;

    .line 261
    .end local v7    # "d":Landroid/app/ProgressDialog;
    :cond_4
    packed-switch p1, :pswitch_data_0

    .line 286
    const-string v0, "Facebook auth came back: {}"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 287
    if-ne p2, v9, :cond_0

    .line 288
    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v8

    .line 289
    .local v8, "session":Lcom/facebook/Session;
    if-eqz v8, :cond_6

    .line 290
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v8, v0, p1, p2, p3}, Lcom/facebook/Session;->onActivityResult(Landroid/app/Activity;IILandroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 292
    invoke-virtual {v8}, Lcom/facebook/Session;->getPermissions()Ljava/util/List;

    move-result-object v0

    const-string v1, "publish_actions"

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 293
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v8}, Lcom/facebook/Session;->getAccessToken()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lco/vine/android/client/AppController;->setPendingFacebookToken(Landroid/content/Context;Ljava/lang/String;)V

    .line 295
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->sendFacebookToken()Ljava/lang/String;

    goto :goto_0

    .line 263
    .end local v8    # "session":Lcom/facebook/Session;
    :pswitch_0
    if-ne p2, v9, :cond_0

    .line 264
    const-string v0, "screen_name"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 265
    .local v2, "username":Ljava/lang/String;
    const-string v0, "tk"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 266
    .local v3, "token":Ljava/lang/String;
    const-string v0, "ts"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 267
    .local v4, "secret":Ljava/lang/String;
    const-string v0, "user_id"

    invoke-virtual {p3, v0, v10, v11}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v5

    .line 268
    .local v5, "userId":J
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->connectTwitter(Lco/vine/android/client/Session;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;

    goto/16 :goto_0

    .line 274
    .end local v2    # "username":Ljava/lang/String;
    .end local v3    # "token":Ljava/lang/String;
    .end local v4    # "secret":Ljava/lang/String;
    .end local v5    # "userId":J
    :pswitch_1
    if-ne p2, v9, :cond_0

    .line 275
    const-string v0, "screen_name"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 277
    .restart local v2    # "username":Ljava/lang/String;
    const-string v0, "token"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 278
    .restart local v3    # "token":Ljava/lang/String;
    const-string v0, "secret"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 279
    .restart local v4    # "secret":Ljava/lang/String;
    const-string v0, "user_id"

    invoke-virtual {p3, v0, v10, v11}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v5

    .line 280
    .restart local v5    # "userId":J
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->connectTwitter(Lco/vine/android/client/Session;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;

    goto/16 :goto_0

    .line 297
    .end local v2    # "username":Ljava/lang/String;
    .end local v3    # "token":Ljava/lang/String;
    .end local v4    # "secret":Ljava/lang/String;
    .end local v5    # "userId":J
    .restart local v8    # "session":Lcom/facebook/Session;
    :cond_5
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    new-instance v1, Lco/vine/android/ReshareFragment$2;

    invoke-direct {v1, p0}, Lco/vine/android/ReshareFragment$2;-><init>(Lco/vine/android/ReshareFragment;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 303
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0, p0}, Lco/vine/android/client/AppController;->connectToFacebookPublish(Landroid/support/v4/app/Fragment;)V

    goto/16 :goto_0

    .line 307
    :cond_6
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseControllerFragment;->onActivityResult(IILandroid/content/Intent;)V

    goto/16 :goto_0

    .line 261
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 89
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onCreate(Landroid/os/Bundle;)V

    .line 90
    new-instance v1, Lco/vine/android/ReshareFragment$ReshareListener;

    invoke-direct {v1, p0}, Lco/vine/android/ReshareFragment$ReshareListener;-><init>(Lco/vine/android/ReshareFragment;)V

    iput-object v1, p0, Lco/vine/android/ReshareFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 92
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 93
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/ReshareFragment;->mPostId:J

    .line 94
    const-string v1, "description"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ReshareFragment;->mDescription:Ljava/lang/String;

    .line 95
    const-string v1, "network"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    .line 96
    const-string v1, "share_url"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ReshareFragment;->mShareUrl:Ljava/lang/String;

    .line 97
    iget-object v1, p0, Lco/vine/android/ReshareFragment;->mShareUrl:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 98
    const-string v1, ""

    iput-object v1, p0, Lco/vine/android/ReshareFragment;->mShareUrl:Ljava/lang/String;

    .line 100
    :cond_0
    const-string v1, "thumbnail_url"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ReshareFragment;->mThumbnailUrl:Ljava/lang/String;

    .line 101
    iget-object v1, p0, Lco/vine/android/ReshareFragment;->mThumbnailUrl:Ljava/lang/String;

    if-nez v1, :cond_1

    .line 102
    const-string v1, ""

    iput-object v1, p0, Lco/vine/android/ReshareFragment;->mThumbnailUrl:Ljava/lang/String;

    .line 104
    :cond_1
    new-instance v1, Lcom/twitter/android/sdk/Twitter;

    sget-object v2, Lco/vine/android/client/TwitterVineApp;->API_KEY:Ljava/lang/String;

    sget-object v3, Lco/vine/android/client/TwitterVineApp;->API_SECRET:Ljava/lang/String;

    invoke-direct {v1, v2, v3}, Lcom/twitter/android/sdk/Twitter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v1, p0, Lco/vine/android/ReshareFragment;->mTwitter:Lcom/twitter/android/sdk/Twitter;

    .line 106
    if-eqz p1, :cond_2

    .line 107
    iget-object v1, p0, Lco/vine/android/ReshareFragment;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    invoke-virtual {v1, p1}, Lco/vine/android/CaptchaRequestHelper;->restorePendingCaptchaRequest(Landroid/os/Bundle;)V

    .line 110
    :cond_2
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lco/vine/android/ReshareFragment;->setHasOptionsMenu(Z)V

    .line 111
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 186
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->isDetached()Z

    move-result v1

    if-nez v1, :cond_1

    .line 187
    const v1, 0x7f100011

    invoke-virtual {p2, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 188
    const v1, 0x7f0a0245

    invoke-interface {p1, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 190
    .local v0, "menuItem":Landroid/view/MenuItem;
    :try_start_0
    const-string v1, "facebook"

    iget-object v2, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 191
    const v1, 0x7f0e0202

    invoke-virtual {p0, v1}, Lco/vine/android/ReshareFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 195
    :cond_0
    :goto_0
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseControllerFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 201
    .end local v0    # "menuItem":Landroid/view/MenuItem;
    :cond_1
    :goto_1
    return-void

    .line 192
    .restart local v0    # "menuItem":Landroid/view/MenuItem;
    :cond_2
    const-string v1, "twitter"

    iget-object v2, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 193
    const v1, 0x7f0e0203

    invoke-virtual {p0, v1}, Lco/vine/android/ReshareFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 196
    :catch_0
    move-exception v1

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 178
    const v1, 0x7f030088

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 179
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0a0166

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lco/vine/android/ReshareFragment;->mCaption:Landroid/widget/EditText;

    .line 180
    const v1, 0x7f0a0065

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lco/vine/android/ReshareFragment;->mThumbnailView:Landroid/widget/ImageView;

    .line 181
    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 11
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v5, 0x1

    const/4 v10, 0x0

    .line 205
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v6

    packed-switch v6, :pswitch_data_0

    .line 234
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v5

    :goto_0
    return v5

    .line 208
    :pswitch_0
    iget-object v6, p0, Lco/vine/android/ReshareFragment;->mShareUrl:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    rsub-int v6, v6, 0x8c

    add-int/lit8 v0, v6, -0x1

    .line 209
    .local v0, "characterLimit":I
    const-string v6, "twitter"

    iget-object v7, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    iget-object v6, p0, Lco/vine/android/ReshareFragment;->mCaption:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-interface {v6}, Landroid/text/Editable;->length()I

    move-result v6

    if-le v6, v0, :cond_0

    .line 210
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    const v7, 0x7f0e01ae

    new-array v8, v5, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-virtual {p0, v7, v8}, Lco/vine/android/ReshareFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 212
    :cond_0
    invoke-direct {p0}, Lco/vine/android/ReshareFragment;->validateSocialConnect()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 213
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    const-string v7, "input_method"

    invoke-virtual {v6, v7}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/inputmethod/InputMethodManager;

    .line 215
    .local v2, "imm":Landroid/view/inputmethod/InputMethodManager;
    iget-object v6, p0, Lco/vine/android/ReshareFragment;->mCaption:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v6

    invoke-virtual {v2, v6, v10}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 217
    iget-object v6, p0, Lco/vine/android/ReshareFragment;->mCaption:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 218
    .local v3, "message":Ljava/lang/String;
    iget-object v6, p0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v7, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    iget-wide v8, p0, Lco/vine/android/ReshareFragment;->mPostId:J

    invoke-virtual {v6, v7, v3, v8, v9}, Lco/vine/android/client/AppController;->sharePost(Ljava/lang/String;Ljava/lang/String;J)V

    .line 219
    new-instance v1, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    const v7, 0x7f0f0037

    invoke-direct {v1, v6, v7}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 221
    .local v1, "d":Landroid/app/ProgressDialog;
    const v6, 0x7f0e021a

    invoke-virtual {p0, v6}, Lco/vine/android/ReshareFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 222
    invoke-virtual {v1, v10}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 223
    invoke-virtual {v1}, Landroid/app/ProgressDialog;->show()V

    .line 224
    iput-object v1, p0, Lco/vine/android/ReshareFragment;->mShareProgress:Landroid/app/ProgressDialog;

    goto/16 :goto_0

    .line 226
    .end local v1    # "d":Landroid/app/ProgressDialog;
    .end local v2    # "imm":Landroid/view/inputmethod/InputMethodManager;
    .end local v3    # "message":Ljava/lang/String;
    :cond_1
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    invoke-virtual {v7, v10, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lco/vine/android/ReshareFragment;->mNetwork:Ljava/lang/String;

    invoke-virtual {v7, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 227
    .local v4, "properNetwork":Ljava/lang/String;
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    const v7, 0x7f0e0206

    new-array v8, v5, [Ljava/lang/Object;

    aput-object v4, v8, v10

    invoke-virtual {p0, v7, v8}, Lco/vine/android/ReshareFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    .line 229
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto/16 :goto_0

    .line 205
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0245
        :pswitch_0
    .end packed-switch
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 126
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onResume()V

    .line 127
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mCaption:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    .line 128
    invoke-virtual {p0}, Lco/vine/android/ReshareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/ReshareFragment;->mCaption:Landroid/widget/EditText;

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 130
    :cond_0
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    invoke-virtual {v0}, Lco/vine/android/CaptchaRequestHelper;->handlePendingCaptchaRequest()V

    .line 131
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 397
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 398
    iget-object v0, p0, Lco/vine/android/ReshareFragment;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/CaptchaRequestHelper;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 399
    return-void
.end method
