.class public Lcom/facebook/widget/UserSettingsFragment;
.super Lcom/facebook/widget/FacebookFragment;
.source "SourceFile"


# static fields
.field private static final FIELDS:Ljava/lang/String; = "fields"

.field private static final ID:Ljava/lang/String; = "id"

.field private static final NAME:Ljava/lang/String; = "name"

.field private static final PICTURE:Ljava/lang/String; = "picture"

.field private static final REQUEST_FIELDS:Ljava/lang/String;


# instance fields
.field private connectedStateLabel:Landroid/widget/TextView;

.field private loginButton:Lcom/facebook/widget/LoginButton;

.field private loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

.field private sessionStatusCallback:Lcom/facebook/Session$StatusCallback;

.field private user:Lcom/facebook/model/GraphUser;

.field private userInfoSession:Lcom/facebook/Session;

.field private userProfilePic:Landroid/graphics/drawable/Drawable;

.field private userProfilePicID:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 54
    const-string v0, ","

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "id"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "name"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "picture"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/facebook/widget/UserSettingsFragment;->REQUEST_FIELDS:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/facebook/widget/FacebookFragment;-><init>()V

    .line 57
    new-instance v0, Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-direct {v0}, Lcom/facebook/widget/LoginButton$LoginButtonProperties;-><init>()V

    iput-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    return-void
.end method

.method static synthetic access$000(Lcom/facebook/widget/UserSettingsFragment;)Lcom/facebook/model/GraphUser;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->user:Lcom/facebook/model/GraphUser;

    return-object v0
.end method

.method static synthetic access$002(Lcom/facebook/widget/UserSettingsFragment;Lcom/facebook/model/GraphUser;)Lcom/facebook/model/GraphUser;
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/facebook/widget/UserSettingsFragment;->user:Lcom/facebook/model/GraphUser;

    return-object p1
.end method

.method static synthetic access$100(Lcom/facebook/widget/UserSettingsFragment;)V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/facebook/widget/UserSettingsFragment;->updateUI()V

    return-void
.end method

.method static synthetic access$200(Lcom/facebook/widget/UserSettingsFragment;)Lcom/facebook/widget/LoginButton;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButton:Lcom/facebook/widget/LoginButton;

    return-object v0
.end method

.method static synthetic access$300(Lcom/facebook/widget/UserSettingsFragment;Ljava/lang/String;Lcom/facebook/widget/ImageResponse;)V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Lcom/facebook/widget/UserSettingsFragment;->processImageResponse(Ljava/lang/String;Lcom/facebook/widget/ImageResponse;)V

    return-void
.end method

.method private fetchUserInfo()V
    .locals 5

    .prologue
    .line 285
    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getSession()Lcom/facebook/Session;

    move-result-object v0

    .line 286
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/facebook/Session;->isOpened()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 287
    iget-object v1, p0, Lcom/facebook/widget/UserSettingsFragment;->userInfoSession:Lcom/facebook/Session;

    if-eq v0, v1, :cond_0

    .line 288
    new-instance v1, Lcom/facebook/widget/UserSettingsFragment$1;

    invoke-direct {v1, p0, v0}, Lcom/facebook/widget/UserSettingsFragment$1;-><init>(Lcom/facebook/widget/UserSettingsFragment;Lcom/facebook/Session;)V

    invoke-static {v0, v1}, Lcom/facebook/Request;->newMeRequest(Lcom/facebook/Session;Lcom/facebook/Request$GraphUserCallback;)Lcom/facebook/Request;

    move-result-object v1

    .line 300
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 301
    const-string v3, "fields"

    sget-object v4, Lcom/facebook/widget/UserSettingsFragment;->REQUEST_FIELDS:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 302
    invoke-virtual {v1, v2}, Lcom/facebook/Request;->setParameters(Landroid/os/Bundle;)V

    .line 303
    const/4 v2, 0x1

    new-array v2, v2, [Lcom/facebook/Request;

    const/4 v3, 0x0

    aput-object v1, v2, v3

    invoke-static {v2}, Lcom/facebook/Request;->executeBatchAsync([Lcom/facebook/Request;)Lcom/facebook/RequestAsyncTask;

    .line 304
    iput-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->userInfoSession:Lcom/facebook/Session;

    .line 309
    :cond_0
    :goto_0
    return-void

    .line 307
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->user:Lcom/facebook/model/GraphUser;

    goto :goto_0
.end method

.method private getImageRequest()Lcom/facebook/widget/ImageRequest;
    .locals 7

    .prologue
    .line 356
    const/4 v0, 0x0

    .line 358
    :try_start_0
    new-instance v1, Lcom/facebook/widget/ImageRequest$Builder;

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lcom/facebook/widget/UserSettingsFragment;->user:Lcom/facebook/model/GraphUser;

    invoke-interface {v3}, Lcom/facebook/model/GraphUser;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/facebook/android/R$dimen;->com_facebook_usersettingsfragment_profile_picture_width:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/facebook/android/R$dimen;->com_facebook_usersettingsfragment_profile_picture_height:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v5

    invoke-static {v3, v4, v5}, Lcom/facebook/widget/ImageRequest;->getProfilePictureUrl(Ljava/lang/String;II)Ljava/net/URL;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/facebook/widget/ImageRequest$Builder;-><init>(Landroid/content/Context;Ljava/net/URL;)V

    .line 365
    invoke-virtual {v1, p0}, Lcom/facebook/widget/ImageRequest$Builder;->setCallerTag(Ljava/lang/Object;)Lcom/facebook/widget/ImageRequest$Builder;

    move-result-object v1

    new-instance v2, Lcom/facebook/widget/UserSettingsFragment$2;

    invoke-direct {v2, p0}, Lcom/facebook/widget/UserSettingsFragment$2;-><init>(Lcom/facebook/widget/UserSettingsFragment;)V

    invoke-virtual {v1, v2}, Lcom/facebook/widget/ImageRequest$Builder;->setCallback(Lcom/facebook/widget/ImageRequest$Callback;)Lcom/facebook/widget/ImageRequest$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/widget/ImageRequest$Builder;->build()Lcom/facebook/widget/ImageRequest;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 376
    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private processImageResponse(Ljava/lang/String;Lcom/facebook/widget/ImageResponse;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 380
    if-eqz p2, :cond_0

    .line 381
    invoke-virtual {p2}, Lcom/facebook/widget/ImageResponse;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 382
    if-eqz v0, :cond_0

    .line 383
    new-instance v1, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 384
    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/facebook/android/R$dimen;->com_facebook_usersettingsfragment_profile_picture_width:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/facebook/android/R$dimen;->com_facebook_usersettingsfragment_profile_picture_height:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    invoke-virtual {v1, v5, v5, v0, v2}, Landroid/graphics/drawable/BitmapDrawable;->setBounds(IIII)V

    .line 387
    iput-object v1, p0, Lcom/facebook/widget/UserSettingsFragment;->userProfilePic:Landroid/graphics/drawable/Drawable;

    .line 388
    iput-object p1, p0, Lcom/facebook/widget/UserSettingsFragment;->userProfilePicID:Ljava/lang/String;

    .line 389
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {v0, v4, v1, v4, v4}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 390
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {p2}, Lcom/facebook/widget/ImageResponse;->getRequest()Lcom/facebook/widget/ImageRequest;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/widget/ImageRequest;->getImageUrl()Ljava/net/URL;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 393
    :cond_0
    return-void
.end method

.method private updateUI()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 312
    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->isAdded()Z

    move-result v0

    if-nez v0, :cond_0

    .line 353
    :goto_0
    return-void

    .line 315
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->isSessionOpen()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 316
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/facebook/android/R$color;->com_facebook_usersettingsfragment_connected_text_color:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 317
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    const/high16 v1, 0x3f800000    # 1.0f

    const/high16 v2, -0x40800000    # -1.0f

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/facebook/android/R$color;->com_facebook_usersettingsfragment_connected_shadow_color:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v0, v1, v6, v2, v3}, Landroid/widget/TextView;->setShadowLayer(FFFI)V

    .line 320
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->user:Lcom/facebook/model/GraphUser;

    if-eqz v0, :cond_3

    .line 321
    invoke-direct {p0}, Lcom/facebook/widget/UserSettingsFragment;->getImageRequest()Lcom/facebook/widget/ImageRequest;

    move-result-object v0

    .line 322
    if-eqz v0, :cond_1

    .line 323
    invoke-virtual {v0}, Lcom/facebook/widget/ImageRequest;->getImageUrl()Ljava/net/URL;

    move-result-object v1

    .line 325
    iget-object v2, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getTag()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/net/URL;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 326
    iget-object v2, p0, Lcom/facebook/widget/UserSettingsFragment;->user:Lcom/facebook/model/GraphUser;

    invoke-interface {v2}, Lcom/facebook/model/GraphUser;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/facebook/widget/UserSettingsFragment;->userProfilePicID:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 327
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/facebook/widget/UserSettingsFragment;->userProfilePic:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v5, v2, v5, v5}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 328
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 334
    :cond_1
    :goto_1
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/facebook/widget/UserSettingsFragment;->user:Lcom/facebook/model/GraphUser;

    invoke-interface {v1}, Lcom/facebook/model/GraphUser;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 330
    :cond_2
    invoke-static {v0}, Lcom/facebook/widget/ImageDownloader;->downloadAsync(Lcom/facebook/widget/ImageRequest;)V

    goto :goto_1

    .line 336
    :cond_3
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/facebook/android/R$string;->com_facebook_usersettingsfragment_logged_in:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 338
    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/facebook/android/R$drawable;->com_facebook_profile_default_icon:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 339
    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/facebook/android/R$dimen;->com_facebook_usersettingsfragment_profile_picture_width:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/facebook/android/R$dimen;->com_facebook_usersettingsfragment_profile_picture_height:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    invoke-virtual {v0, v7, v7, v1, v2}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 342
    iget-object v1, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {v1, v5, v0, v5, v5}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_0

    .line 345
    :cond_4
    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/facebook/android/R$color;->com_facebook_usersettingsfragment_not_connected_text_color:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    .line 346
    iget-object v1, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 347
    iget-object v1, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {v1, v6, v6, v6, v0}, Landroid/widget/TextView;->setShadowLayer(FFFI)V

    .line 348
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/facebook/android/R$string;->com_facebook_usersettingsfragment_not_logged_in:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 350
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {v0, v5, v5, v5, v5}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 351
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    goto/16 :goto_0
.end method


# virtual methods
.method public clearPermissions()V
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-virtual {v0}, Lcom/facebook/widget/LoginButton$LoginButtonProperties;->clearPermissions()V

    .line 202
    return-void
.end method

.method public getDefaultAudience()Lcom/facebook/SessionDefaultAudience;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-virtual {v0}, Lcom/facebook/widget/LoginButton$LoginButtonProperties;->getDefaultAudience()Lcom/facebook/SessionDefaultAudience;

    move-result-object v0

    return-object v0
.end method

.method public getLoginBehavior()Lcom/facebook/SessionLoginBehavior;
    .locals 1

    .prologue
    .line 227
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-virtual {v0}, Lcom/facebook/widget/LoginButton$LoginButtonProperties;->getLoginBehavior()Lcom/facebook/SessionLoginBehavior;

    move-result-object v0

    return-object v0
.end method

.method public getOnErrorListener()Lcom/facebook/widget/LoginButton$OnErrorListener;
    .locals 1

    .prologue
    .line 246
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-virtual {v0}, Lcom/facebook/widget/LoginButton$LoginButtonProperties;->getOnErrorListener()Lcom/facebook/widget/LoginButton$OnErrorListener;

    move-result-object v0

    return-object v0
.end method

.method getPermissions()Ljava/util/List;
    .locals 1

    .prologue
    .line 281
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-virtual {v0}, Lcom/facebook/widget/LoginButton$LoginButtonProperties;->getPermissions()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSessionStatusCallback()Lcom/facebook/Session$StatusCallback;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->sessionStatusCallback:Lcom/facebook/Session$StatusCallback;

    return-object v0
.end method

.method public bridge synthetic onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 47
    invoke-super {p0, p1}, Lcom/facebook/widget/FacebookFragment;->onActivityCreated(Landroid/os/Bundle;)V

    return-void
.end method

.method public bridge synthetic onActivityResult(IILandroid/content/Intent;)V
    .locals 0

    .prologue
    .line 47
    invoke-super {p0, p1, p2, p3}, Lcom/facebook/widget/FacebookFragment;->onActivityResult(IILandroid/content/Intent;)V

    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 88
    invoke-super {p0, p1}, Lcom/facebook/widget/FacebookFragment;->onCreate(Landroid/os/Bundle;)V

    .line 89
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/facebook/widget/UserSettingsFragment;->setRetainInstance(Z)V

    .line 90
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    .line 67
    sget v0, Lcom/facebook/android/R$layout;->com_facebook_usersettingsfragment:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 68
    sget v0, Lcom/facebook/android/R$id;->com_facebook_usersettingsfragment_login_button:I

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/facebook/widget/LoginButton;

    iput-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButton:Lcom/facebook/widget/LoginButton;

    .line 69
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButton:Lcom/facebook/widget/LoginButton;

    iget-object v2, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-virtual {v0, v2}, Lcom/facebook/widget/LoginButton;->setProperties(Lcom/facebook/widget/LoginButton$LoginButtonProperties;)V

    .line 70
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButton:Lcom/facebook/widget/LoginButton;

    invoke-virtual {v0, p0}, Lcom/facebook/widget/LoginButton;->setFragment(Landroid/support/v4/app/Fragment;)V

    .line 71
    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getSession()Lcom/facebook/Session;

    move-result-object v0

    .line 72
    if-eqz v0, :cond_0

    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/facebook/Session;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 73
    iget-object v2, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButton:Lcom/facebook/widget/LoginButton;

    invoke-virtual {v2, v0}, Lcom/facebook/widget/LoginButton;->setSession(Lcom/facebook/Session;)V

    .line 75
    :cond_0
    sget v0, Lcom/facebook/android/R$id;->com_facebook_usersettingsfragment_profile_name:I

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->connectedStateLabel:Landroid/widget/TextView;

    .line 78
    invoke-virtual {v1}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-nez v0, :cond_1

    .line 79
    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/facebook/android/R$color;->com_facebook_blue:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/view/View;->setBackgroundColor(I)V

    .line 83
    :goto_0
    return-object v1

    .line 81
    :cond_1
    invoke-virtual {v1}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/graphics/drawable/Drawable;->setDither(Z)V

    goto :goto_0
.end method

.method public bridge synthetic onDestroy()V
    .locals 0

    .prologue
    .line 47
    invoke-super {p0}, Lcom/facebook/widget/FacebookFragment;->onDestroy()V

    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 97
    invoke-super {p0}, Lcom/facebook/widget/FacebookFragment;->onResume()V

    .line 98
    invoke-direct {p0}, Lcom/facebook/widget/UserSettingsFragment;->fetchUserInfo()V

    .line 99
    invoke-direct {p0}, Lcom/facebook/widget/UserSettingsFragment;->updateUI()V

    .line 100
    return-void
.end method

.method protected onSessionStateChange(Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 271
    invoke-direct {p0}, Lcom/facebook/widget/UserSettingsFragment;->fetchUserInfo()V

    .line 272
    invoke-direct {p0}, Lcom/facebook/widget/UserSettingsFragment;->updateUI()V

    .line 274
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->sessionStatusCallback:Lcom/facebook/Session$StatusCallback;

    if-eqz v0, :cond_0

    .line 275
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->sessionStatusCallback:Lcom/facebook/Session$StatusCallback;

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getSession()Lcom/facebook/Session;

    move-result-object v1

    invoke-interface {v0, v1, p1, p2}, Lcom/facebook/Session$StatusCallback;->call(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    .line 277
    :cond_0
    return-void
.end method

.method public setDefaultAudience(Lcom/facebook/SessionDefaultAudience;)V
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-virtual {v0, p1}, Lcom/facebook/widget/LoginButton$LoginButtonProperties;->setDefaultAudience(Lcom/facebook/SessionDefaultAudience;)V

    .line 132
    return-void
.end method

.method public setLoginBehavior(Lcom/facebook/SessionLoginBehavior;)V
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-virtual {v0, p1}, Lcom/facebook/widget/LoginButton$LoginButtonProperties;->setLoginBehavior(Lcom/facebook/SessionLoginBehavior;)V

    .line 215
    return-void
.end method

.method public setOnErrorListener(Lcom/facebook/widget/LoginButton$OnErrorListener;)V
    .locals 1

    .prologue
    .line 237
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-virtual {v0, p1}, Lcom/facebook/widget/LoginButton$LoginButtonProperties;->setOnErrorListener(Lcom/facebook/widget/LoginButton$OnErrorListener;)V

    .line 238
    return-void
.end method

.method public setPublishPermissions(Ljava/util/List;)V
    .locals 2

    .prologue
    .line 193
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getSession()Lcom/facebook/Session;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/facebook/widget/LoginButton$LoginButtonProperties;->setPublishPermissions(Ljava/util/List;Lcom/facebook/Session;)V

    .line 194
    return-void
.end method

.method public setReadPermissions(Ljava/util/List;)V
    .locals 2

    .prologue
    .line 167
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButtonProperties:Lcom/facebook/widget/LoginButton$LoginButtonProperties;

    invoke-virtual {p0}, Lcom/facebook/widget/UserSettingsFragment;->getSession()Lcom/facebook/Session;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/facebook/widget/LoginButton$LoginButtonProperties;->setReadPermissions(Ljava/util/List;Lcom/facebook/Session;)V

    .line 168
    return-void
.end method

.method public setSession(Lcom/facebook/Session;)V
    .locals 1

    .prologue
    .line 115
    invoke-super {p0, p1}, Lcom/facebook/widget/FacebookFragment;->setSession(Lcom/facebook/Session;)V

    .line 116
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButton:Lcom/facebook/widget/LoginButton;

    if-eqz v0, :cond_0

    .line 117
    iget-object v0, p0, Lcom/facebook/widget/UserSettingsFragment;->loginButton:Lcom/facebook/widget/LoginButton;

    invoke-virtual {v0, p1}, Lcom/facebook/widget/LoginButton;->setSession(Lcom/facebook/Session;)V

    .line 119
    :cond_0
    invoke-direct {p0}, Lcom/facebook/widget/UserSettingsFragment;->fetchUserInfo()V

    .line 120
    invoke-direct {p0}, Lcom/facebook/widget/UserSettingsFragment;->updateUI()V

    .line 121
    return-void
.end method

.method public setSessionStatusCallback(Lcom/facebook/Session$StatusCallback;)V
    .locals 0

    .prologue
    .line 256
    iput-object p1, p0, Lcom/facebook/widget/UserSettingsFragment;->sessionStatusCallback:Lcom/facebook/Session$StatusCallback;

    .line 257
    return-void
.end method
