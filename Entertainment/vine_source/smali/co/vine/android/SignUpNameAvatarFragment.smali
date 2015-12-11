.class public Lco/vine/android/SignUpNameAvatarFragment;
.super Lco/vine/android/BaseControllerFragment;
.source "SignUpNameAvatarFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;
.implements Landroid/view/View$OnClickListener;
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;
.implements Lco/vine/android/SetThumbnailTask$SetThumbnailListener;
.implements Lco/vine/android/ImagePicker$Listener;
.implements Lco/vine/android/util/ContactsHelper$ContactHelperListener;
.implements Lco/vine/android/widget/SpanClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/SignUpNameAvatarFragment$SignUpListener;
    }
.end annotation


# static fields
.field public static final ARG_LOGIN:Ljava/lang/String; = "user"

.field private static final DIALOG_REMOVE_TAKE_OR_CHOOSE_PHOTO:I = 0x3

.field private static final DIALOG_SET_PHOTO_OR_SKIP:I = 0x1

.field private static final DIALOG_TAKE_OR_CHOOSE_PHOTO:I = 0x2

.field public static final REQUEST_CODE_CHOOSE_PHOTO:I = 0x3

.field public static final REQUEST_CODE_CROP:I = 0x2

.field public static final REQUEST_CODE_TAKE_PHOTO:I = 0x1

.field private static final SPAN_PRIVACY_POLICY:I = 0x1

.field private static final SPAN_TOS:I = 0x2

.field private static final STATE_PROFILE_URI:Ljava/lang/String; = "state_pi"


# instance fields
.field private mHasPromptedForPhoto:Z

.field private mImagePicker:Lco/vine/android/ImagePicker;

.field private mLogin:Lco/vine/android/api/VineLogin;

.field private mName:Landroid/widget/EditText;

.field private mNextButton:Landroid/view/MenuItem;

.field private mPhoneNumber:Landroid/widget/EditText;

.field private mPhoneNumberContainer:Landroid/widget/RelativeLayout;

.field private mPhotoAttached:Z

.field private mProfileImage:Landroid/widget/ImageView;

.field private mProfileImageAction:Landroid/widget/ImageView;

.field private mProfileUri:Landroid/net/Uri;

.field private mProgress:Landroid/app/Dialog;

.field private mTwitterUser:Lco/vine/android/api/TwitterUser;

.field private mVineGreen:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Lco/vine/android/BaseControllerFragment;-><init>()V

    .line 481
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/SignUpNameAvatarFragment;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpNameAvatarFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/SignUpNameAvatarFragment;ILandroid/view/View;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpNameAvatarFragment;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroid/view/View;

    .prologue
    .line 58
    invoke-direct {p0, p1, p2}, Lco/vine/android/SignUpNameAvatarFragment;->onEditorActionClicked(ILandroid/view/View;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$1002(Lco/vine/android/SignUpNameAvatarFragment;Lco/vine/android/api/TwitterUser;)Lco/vine/android/api/TwitterUser;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SignUpNameAvatarFragment;
    .param p1, "x1"    # Lco/vine/android/api/TwitterUser;

    .prologue
    .line 58
    iput-object p1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mTwitterUser:Lco/vine/android/api/TwitterUser;

    return-object p1
.end method

.method static synthetic access$200(Lco/vine/android/SignUpNameAvatarFragment;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpNameAvatarFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhoneNumber:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/SignUpNameAvatarFragment;)Landroid/widget/RelativeLayout;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpNameAvatarFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhoneNumberContainer:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$402(Lco/vine/android/SignUpNameAvatarFragment;Landroid/net/Uri;)Landroid/net/Uri;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SignUpNameAvatarFragment;
    .param p1, "x1"    # Landroid/net/Uri;

    .prologue
    .line 58
    iput-object p1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    return-object p1
.end method

.method static synthetic access$500(Lco/vine/android/SignUpNameAvatarFragment;Landroid/graphics/Bitmap;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SignUpNameAvatarFragment;
    .param p1, "x1"    # Landroid/graphics/Bitmap;

    .prologue
    .line 58
    invoke-direct {p0, p1}, Lco/vine/android/SignUpNameAvatarFragment;->setAvatar(Landroid/graphics/Bitmap;)V

    return-void
.end method

.method static synthetic access$600(Lco/vine/android/SignUpNameAvatarFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpNameAvatarFragment;

    .prologue
    .line 58
    iget-boolean v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhotoAttached:Z

    return v0
.end method

.method static synthetic access$700(Lco/vine/android/SignUpNameAvatarFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpNameAvatarFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileImage:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$800(Lco/vine/android/SignUpNameAvatarFragment;)Lco/vine/android/ImagePicker;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpNameAvatarFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    return-object v0
.end method

.method static synthetic access$900(Lco/vine/android/SignUpNameAvatarFragment;)Landroid/app/Dialog;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SignUpNameAvatarFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProgress:Landroid/app/Dialog;

    return-object v0
.end method

.method private addPhoto()V
    .locals 7

    .prologue
    const v6, 0x7f0e0242

    const v5, 0x7f0e021e

    const v4, 0x7f0e005b

    const/4 v3, 0x0

    .line 320
    iget-boolean v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhotoAttached:Z

    if-eqz v2, :cond_0

    .line 321
    const/4 v2, 0x3

    invoke-static {v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v1

    .line 323
    .local v1, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    invoke-virtual {v1, p0, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 324
    invoke-virtual {v1, v5}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    const v3, 0x7f0e01a4

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    invoke-virtual {v2, v6}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    invoke-virtual {v2, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    .line 342
    :goto_0
    return-void

    .line 330
    .end local v1    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_0
    const/4 v2, 0x2

    invoke-static {v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v1

    .line 332
    .restart local v1    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    invoke-virtual {v1, p0, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 334
    const v2, 0x7f0e021e

    :try_start_0
    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    const v3, 0x7f0e0242

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    const v3, 0x7f0e005b

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 338
    :catch_0
    move-exception v0

    .line 339
    .local v0, "e":Ljava/lang/IllegalStateException;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private nextClicked()V
    .locals 3

    .prologue
    .line 237
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/SignUpPagerActivity;

    .line 238
    .local v0, "activity":Lco/vine/android/SignUpPagerActivity;
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setName(Ljava/lang/String;)V

    .line 239
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhoneNumber:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setPhone(Ljava/lang/String;)V

    .line 240
    iget-boolean v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhotoAttached:Z

    if-eqz v1, :cond_0

    .line 241
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setProfile(Landroid/net/Uri;)V

    .line 243
    :cond_0
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mTwitterUser:Lco/vine/android/api/TwitterUser;

    if-eqz v1, :cond_1

    .line 244
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mTwitterUser:Lco/vine/android/api/TwitterUser;

    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lco/vine/android/api/TwitterUser;->name:Ljava/lang/String;

    .line 245
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mTwitterUser:Lco/vine/android/api/TwitterUser;

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setTwitterUser(Lco/vine/android/api/TwitterUser;)V

    .line 247
    :cond_1
    invoke-virtual {v0}, Lco/vine/android/SignUpPagerActivity;->toNextStep()V

    .line 248
    return-void
.end method

.method private onEditorActionClicked(ILandroid/view/View;)Z
    .locals 4
    .param p1, "actionId"    # I
    .param p2, "v"    # Landroid/view/View;

    .prologue
    .line 157
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 158
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_0

    const/4 v2, 0x6

    if-ne p1, v2, :cond_0

    invoke-direct {p0}, Lco/vine/android/SignUpNameAvatarFragment;->validate()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 159
    const-string v2, "input_method"

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/inputmethod/InputMethodManager;

    .line 161
    .local v1, "imm":Landroid/view/inputmethod/InputMethodManager;
    invoke-virtual {p2}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 162
    invoke-direct {p0, v0}, Lco/vine/android/SignUpNameAvatarFragment;->onNextClicked(Landroid/app/Activity;)Z

    .line 164
    .end local v1    # "imm":Landroid/view/inputmethod/InputMethodManager;
    :cond_0
    const/4 v2, 0x1

    return v2
.end method

.method private onNextClicked(Landroid/app/Activity;)Z
    .locals 4
    .param p1, "a"    # Landroid/app/Activity;

    .prologue
    .line 263
    invoke-direct {p0}, Lco/vine/android/SignUpNameAvatarFragment;->showProfilePhotoPrompt()Z

    move-result v1

    if-nez v1, :cond_1

    move-object v0, p1

    .line 264
    check-cast v0, Lco/vine/android/SignUpPagerActivity;

    .line 265
    .local v0, "activity":Lco/vine/android/SignUpPagerActivity;
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setName(Ljava/lang/String;)V

    .line 266
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhoneNumber:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setPhone(Ljava/lang/String;)V

    .line 267
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    invoke-virtual {v1}, Lco/vine/android/ImagePicker;->getSavedImageUri()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setProfile(Landroid/net/Uri;)V

    .line 268
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mTwitterUser:Lco/vine/android/api/TwitterUser;

    if-eqz v1, :cond_0

    .line 269
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mTwitterUser:Lco/vine/android/api/TwitterUser;

    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lco/vine/android/api/TwitterUser;->name:Ljava/lang/String;

    .line 270
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mTwitterUser:Lco/vine/android/api/TwitterUser;

    invoke-virtual {v0, v1}, Lco/vine/android/SignUpPagerActivity;->setTwitterUser(Lco/vine/android/api/TwitterUser;)V

    .line 272
    :cond_0
    invoke-direct {p0}, Lco/vine/android/SignUpNameAvatarFragment;->nextClicked()V

    .line 274
    .end local v0    # "activity":Lco/vine/android/SignUpPagerActivity;
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 275
    const/4 v1, 0x1

    return v1
.end method

.method private setAvatar(Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "bm"    # Landroid/graphics/Bitmap;

    .prologue
    .line 352
    if-eqz p1, :cond_0

    .line 353
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileImage:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileImage:Landroid/widget/ImageView;

    invoke-virtual {v2}, Landroid/widget/ImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 354
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileImage:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 355
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileImageAction:Landroid/widget/ImageView;

    const v1, 0x7f020064

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 356
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhotoAttached:Z

    .line 363
    :goto_0
    return-void

    .line 358
    :cond_0
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileImage:Landroid/widget/ImageView;

    const v1, 0x7f020065

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 359
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileImage:Landroid/widget/ImageView;

    iget v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mVineGreen:I

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v1, v2}, Landroid/widget/ImageView;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 360
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileImageAction:Landroid/widget/ImageView;

    const v1, 0x7f020061

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 361
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhotoAttached:Z

    goto :goto_0
.end method

.method private showProfilePhotoPrompt()Z
    .locals 6

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 218
    iget-object v4, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    if-nez v4, :cond_0

    iget-boolean v4, p0, Lco/vine/android/SignUpNameAvatarFragment;->mHasPromptedForPhoto:Z

    if-nez v4, :cond_0

    iget-boolean v4, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhotoAttached:Z

    if-nez v4, :cond_0

    .line 219
    invoke-static {v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v4

    const v5, 0x7f0e019b

    invoke-virtual {v4, v5}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v4

    const v5, 0x7f0e01c4

    invoke-virtual {v4, v5}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v4

    const v5, 0x7f0e0227

    invoke-virtual {v4, v5}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v1

    .line 224
    .local v1, "promptDialogSupportFragment":Lco/vine/android/widgets/PromptDialogSupportFragment;
    invoke-virtual {v1, p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setListener(Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;)V

    .line 226
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    invoke-virtual {v1, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 230
    iput-boolean v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mHasPromptedForPhoto:Z

    .line 233
    .end local v1    # "promptDialogSupportFragment":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :goto_0
    return v2

    .line 227
    .restart local v1    # "promptDialogSupportFragment":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :catch_0
    move-exception v0

    .local v0, "e":Ljava/lang/IllegalStateException;
    move v2, v3

    .line 228
    goto :goto_0

    .end local v0    # "e":Ljava/lang/IllegalStateException;
    .end local v1    # "promptDialogSupportFragment":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_0
    move v2, v3

    .line 233
    goto :goto_0
.end method

.method private validate()Z
    .locals 2

    .prologue
    .line 316
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    const/4 v1, 0x3

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
    .line 288
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mNextButton:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 289
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mNextButton:Landroid/view/MenuItem;

    invoke-direct {p0}, Lco/vine/android/SignUpNameAvatarFragment;->validate()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 291
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
    .line 280
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 346
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 347
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090096

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    const/high16 v1, -0x1000000

    or-int/2addr v0, v1

    iput v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mVineGreen:I

    .line 348
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/SignUpNameAvatarFragment;->setAvatar(Landroid/graphics/Bitmap;)V

    .line 349
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 6
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "extras"    # Landroid/content/Intent;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    const/4 v3, -0x1

    .line 367
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseControllerFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 368
    packed-switch p1, :pswitch_data_0

    .line 400
    :cond_0
    :goto_0
    return-void

    .line 371
    :pswitch_0
    if-ne p2, v3, :cond_2

    .line 373
    if-ne p1, v4, :cond_1

    .line 374
    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    .line 378
    .local v2, "uri":Landroid/net/Uri;
    :goto_1
    new-instance v3, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const-class v5, Lco/vine/android/EditProfileCropActivity;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v4, "uri"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    move-result-object v1

    .line 380
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/4 v4, 0x2

    invoke-virtual {v3, v1, v4}, Landroid/support/v4/app/FragmentActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 376
    .end local v1    # "intent":Landroid/content/Intent;
    .end local v2    # "uri":Landroid/net/Uri;
    :cond_1
    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v2

    .restart local v2    # "uri":Landroid/net/Uri;
    goto :goto_1

    .line 382
    .end local v2    # "uri":Landroid/net/Uri;
    :cond_2
    iput-object v5, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    goto :goto_0

    .line 387
    :pswitch_1
    if-ne p2, v3, :cond_3

    if-eqz p3, :cond_3

    .line 388
    const-string v3, "uri"

    invoke-virtual {p3, v3}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    .line 389
    .local v0, "croppedUri":Landroid/net/Uri;
    if-eqz v0, :cond_0

    .line 390
    iget-object v3, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    invoke-static {v3}, Lco/vine/android/util/image/ImageUtils;->deleteTempPic(Landroid/net/Uri;)Z

    .line 391
    iput-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    .line 392
    new-instance v3, Lco/vine/android/SetThumbnailTask;

    invoke-direct {v3, p0}, Lco/vine/android/SetThumbnailTask;-><init>(Landroid/support/v4/app/Fragment;)V

    new-array v4, v4, [Landroid/net/Uri;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v3, v4}, Lco/vine/android/SetThumbnailTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 395
    .end local v0    # "croppedUri":Landroid/net/Uri;
    :cond_3
    iput-object v5, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    goto :goto_0

    .line 368
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 409
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 414
    :goto_0
    return-void

    .line 411
    :pswitch_0
    invoke-direct {p0}, Lco/vine/android/SignUpNameAvatarFragment;->addPhoto()V

    goto :goto_0

    .line 409
    :pswitch_data_0
    .packed-switch 0x7f0a0103
        :pswitch_0
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 97
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onCreate(Landroid/os/Bundle;)V

    .line 98
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mAppController:Lco/vine/android/client/AppController;

    .line 100
    if-eqz p1, :cond_0

    const-string v1, "state_pi"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 101
    const-string v1, "state_pi"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    iput-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    .line 102
    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    if-eqz v1, :cond_0

    .line 103
    new-instance v1, Lco/vine/android/SetThumbnailTask;

    invoke-direct {v1, p0}, Lco/vine/android/SetThumbnailTask;-><init>(Landroid/support/v4/app/Fragment;)V

    new-array v2, v5, [Landroid/net/Uri;

    iget-object v3, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    aput-object v3, v2, v4

    invoke-virtual {v1, v2}, Lco/vine/android/SetThumbnailTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 107
    :cond_0
    invoke-virtual {p0, v5}, Lco/vine/android/SignUpNameAvatarFragment;->setHasOptionsMenu(Z)V

    .line 108
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lco/vine/android/SignUpPagerActivity;

    const v2, 0x7f0e0124

    invoke-virtual {v1, v2}, Lco/vine/android/SignUpPagerActivity;->setBarTitle(I)V

    .line 110
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 111
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_1

    const-string v1, "user"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 112
    const-string v1, "user"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineLogin;

    iput-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mLogin:Lco/vine/android/api/VineLogin;

    .line 114
    :cond_1
    new-instance v1, Lco/vine/android/SignUpNameAvatarFragment$SignUpListener;

    invoke-direct {v1, p0}, Lco/vine/android/SignUpNameAvatarFragment$SignUpListener;-><init>(Lco/vine/android/SignUpNameAvatarFragment;)V

    iput-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 115
    iput-boolean v4, p0, Lco/vine/android/SignUpNameAvatarFragment;->mHasPromptedForPhoto:Z

    .line 117
    new-instance v1, Lco/vine/android/ImagePicker;

    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/SignUpNameAvatarFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v3

    invoke-direct {v1, v2, p0, v3, v4}, Lco/vine/android/ImagePicker;-><init>(Landroid/app/Activity;Lco/vine/android/ImagePicker$Listener;J)V

    iput-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    .line 119
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 210
    const v0, 0x7f10000b

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 211
    const v0, 0x7f0a0246

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mNextButton:Landroid/view/MenuItem;

    .line 212
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mNextButton:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 213
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mNextButton:Landroid/view/MenuItem;

    invoke-direct {p0}, Lco/vine/android/SignUpNameAvatarFragment;->validate()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 215
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 13
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "root"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 123
    const v10, 0x7f030095

    const/4 v11, 0x0

    invoke-virtual {p1, v10, p2, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v9

    .line 124
    .local v9, "view":Landroid/view/View;
    const v10, 0x7f0a021e

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 125
    .local v4, "mTos":Landroid/widget/TextView;
    const/4 v10, 0x2

    new-array v0, v10, [Landroid/text/style/StyleSpan;

    const/4 v10, 0x0

    new-instance v11, Landroid/text/style/StyleSpan;

    const/4 v12, 0x1

    invoke-direct {v11, v12}, Landroid/text/style/StyleSpan;-><init>(I)V

    aput-object v11, v0, v10

    const/4 v10, 0x1

    new-instance v11, Landroid/text/style/StyleSpan;

    const/4 v12, 0x1

    invoke-direct {v11, v12}, Landroid/text/style/StyleSpan;-><init>(I)V

    aput-object v11, v0, v10

    .line 127
    .local v0, "boldStyle":[Landroid/text/style/StyleSpan;
    const v10, 0x7f0e0220

    invoke-virtual {p0, v10}, Lco/vine/android/SignUpNameAvatarFragment;->getString(I)Ljava/lang/String;

    move-result-object v10

    const/16 v11, 0x22

    invoke-static {v0, v10, v11}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v6

    .line 130
    .local v6, "spanned":Landroid/text/Spanned;
    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 131
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v10

    invoke-virtual {v4, v10}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 133
    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    check-cast v1, Landroid/text/Spannable;

    .line 134
    .local v1, "clickSpannable":Landroid/text/Spannable;
    const/4 v10, 0x0

    invoke-interface {v6}, Landroid/text/Spanned;->length()I

    move-result v11

    const-class v12, Landroid/text/style/StyleSpan;

    invoke-interface {v6, v10, v11, v12}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Landroid/text/style/StyleSpan;

    .line 135
    .local v7, "spans":[Landroid/text/style/StyleSpan;
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 138
    .local v5, "res":Landroid/content/res/Resources;
    const/4 v10, 0x0

    aget-object v10, v7, v10

    invoke-interface {v6, v10}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v8

    .line 139
    .local v8, "start":I
    const/4 v10, 0x0

    aget-object v10, v7, v10

    invoke-interface {v6, v10}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v3

    .line 140
    .local v3, "end":I
    new-instance v2, Lco/vine/android/widget/StyledClickableSpan;

    const/4 v10, 0x1

    const/4 v11, 0x0

    invoke-direct {v2, v10, v11, p0}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 142
    .local v2, "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    const v10, 0x7f09008d

    invoke-virtual {v5, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v10

    invoke-virtual {v2, v10}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 143
    const/16 v10, 0x21

    invoke-static {v1, v2, v8, v3, v10}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 147
    const/4 v10, 0x1

    aget-object v10, v7, v10

    invoke-interface {v6, v10}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v8

    .line 148
    const/4 v10, 0x1

    aget-object v10, v7, v10

    invoke-interface {v6, v10}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v3

    .line 149
    new-instance v2, Lco/vine/android/widget/StyledClickableSpan;

    .end local v2    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    const/4 v10, 0x2

    const/4 v11, 0x0

    invoke-direct {v2, v10, v11, p0}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 150
    .restart local v2    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    const v10, 0x7f09008d

    invoke-virtual {v5, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v10

    invoke-virtual {v2, v10}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 151
    const/16 v10, 0x21

    invoke-static {v1, v2, v8, v3, v10}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 153
    return-object v9
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    const/4 v2, 0x3

    const/4 v1, 0x1

    .line 418
    packed-switch p2, :pswitch_data_0

    .line 465
    :goto_0
    return-void

    .line 420
    :pswitch_0
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 426
    :pswitch_1
    invoke-direct {p0}, Lco/vine/android/SignUpNameAvatarFragment;->nextClicked()V

    goto :goto_0

    .line 422
    :pswitch_2
    invoke-direct {p0}, Lco/vine/android/SignUpNameAvatarFragment;->addPhoto()V

    goto :goto_0

    .line 433
    :pswitch_3
    packed-switch p3, :pswitch_data_2

    :pswitch_4
    goto :goto_0

    .line 439
    :pswitch_5
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    invoke-virtual {v0, v2}, Lco/vine/android/ImagePicker;->chooseImage(I)V

    goto :goto_0

    .line 435
    :pswitch_6
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    invoke-virtual {v0, v1}, Lco/vine/android/ImagePicker;->captureImage(I)V

    goto :goto_0

    .line 446
    :pswitch_7
    packed-switch p3, :pswitch_data_3

    goto :goto_0

    .line 452
    :pswitch_8
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    invoke-virtual {v0, v1}, Lco/vine/android/ImagePicker;->captureImage(I)V

    goto :goto_0

    .line 448
    :pswitch_9
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/SignUpNameAvatarFragment;->setThumbnailImage(Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 456
    :pswitch_a
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    invoke-virtual {v0, v2}, Lco/vine/android/ImagePicker;->chooseImage(I)V

    goto :goto_0

    .line 418
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_3
        :pswitch_7
    .end packed-switch

    .line 420
    :pswitch_data_1
    .packed-switch -0x2
        :pswitch_1
        :pswitch_2
    .end packed-switch

    .line 433
    :pswitch_data_2
    .packed-switch -0x3
        :pswitch_5
        :pswitch_4
        :pswitch_6
    .end packed-switch

    .line 446
    :pswitch_data_3
    .packed-switch -0x3
        :pswitch_8
        :pswitch_a
        :pswitch_9
    .end packed-switch
.end method

.method public onEmailLoaded(Ljava/lang/String;)V
    .locals 0
    .param p1, "email"    # Ljava/lang/String;

    .prologue
    .line 313
    return-void
.end method

.method public onNameLoaded(Ljava/lang/String;)V
    .locals 2
    .param p1, "nameText"    # Ljava/lang/String;

    .prologue
    .line 296
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    .line 297
    .local v0, "name":Landroid/widget/EditText;
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 298
    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 299
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setSelection(I)V

    .line 301
    :cond_0
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 252
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 257
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 254
    :pswitch_0
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-direct {p0, v0}, Lco/vine/android/SignUpNameAvatarFragment;->onNextClicked(Landroid/app/Activity;)Z

    move-result v0

    goto :goto_0

    .line 252
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0246
        :pswitch_0
    .end packed-switch
.end method

.method public onPhoneNumberLoaded(Ljava/lang/String;)V
    .locals 1
    .param p1, "phoneNumber"    # Ljava/lang/String;

    .prologue
    .line 305
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhoneNumber:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhoneNumber:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 307
    iget-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhoneNumber:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 309
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 469
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 470
    const-string v0, "state_pi"

    iget-object v1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 471
    return-void
.end method

.method public onSpanClicked(Landroid/view/View;ILjava/lang/Object;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/Object;

    .prologue
    .line 535
    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    if-nez v1, :cond_0

    .line 553
    :goto_0
    return-void

    .line 538
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lco/vine/android/WebViewActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 539
    .local v0, "i":Landroid/content/Intent;
    packed-switch p2, :pswitch_data_0

    goto :goto_0

    .line 541
    :pswitch_0
    const-string v1, "type"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 552
    :goto_1
    invoke-virtual {p0, v0}, Lco/vine/android/SignUpNameAvatarFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 545
    :pswitch_1
    const-string v1, "type"

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    goto :goto_1

    .line 539
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
    .line 284
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 169
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseControllerFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 170
    const v2, 0x7f0a021f

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    .line 171
    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    invoke-virtual {v2, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 172
    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mName:Landroid/widget/EditText;

    new-instance v3, Lco/vine/android/SignUpNameAvatarFragment$1;

    invoke-direct {v3, p0}, Lco/vine/android/SignUpNameAvatarFragment$1;-><init>(Lco/vine/android/SignUpNameAvatarFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 178
    const v2, 0x7f0a0219

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    iput-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhoneNumberContainer:Landroid/widget/RelativeLayout;

    .line 180
    const v2, 0x7f0a021a

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhoneNumber:Landroid/widget/EditText;

    .line 181
    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhoneNumber:Landroid/widget/EditText;

    invoke-virtual {v2, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 182
    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhoneNumber:Landroid/widget/EditText;

    new-instance v3, Lco/vine/android/SignUpNameAvatarFragment$2;

    invoke-direct {v3, p0}, Lco/vine/android/SignUpNameAvatarFragment$2;-><init>(Lco/vine/android/SignUpNameAvatarFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 188
    const v2, 0x7f0a0103

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 190
    .local v1, "userImageRoot":Landroid/view/View;
    const v2, 0x7f0a022b

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileImageAction:Landroid/widget/ImageView;

    .line 191
    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileImageAction:Landroid/widget/ImageView;

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 192
    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 194
    const v2, 0x7f0a0063

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileImage:Landroid/widget/ImageView;

    .line 196
    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mLogin:Lco/vine/android/api/VineLogin;

    if-eqz v2, :cond_0

    .line 197
    new-instance v0, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lco/vine/android/SignUpNameAvatarFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f0f0037

    invoke-direct {v0, v2, v3}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 198
    .local v0, "d":Landroid/app/ProgressDialog;
    const v2, 0x7f0e011c

    invoke-virtual {p0, v2}, Lco/vine/android/SignUpNameAvatarFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 199
    invoke-virtual {v0, v4}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 200
    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 201
    iput-object v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProgress:Landroid/app/Dialog;

    .line 202
    iget-object v2, p0, Lco/vine/android/SignUpNameAvatarFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/SignUpNameAvatarFragment;->mLogin:Lco/vine/android/api/VineLogin;

    invoke-virtual {v2, v3}, Lco/vine/android/client/AppController;->fetchTwitterUser(Lco/vine/android/api/VineLogin;)Ljava/lang/String;

    .line 205
    .end local v0    # "d":Landroid/app/ProgressDialog;
    :cond_0
    invoke-static {p0, p0}, Lco/vine/android/util/ContactsHelper;->loadContacts(Landroid/support/v4/app/Fragment;Lco/vine/android/util/ContactsHelper$ContactHelperListener;)V

    .line 206
    return-void
.end method

.method public setAvatarUrl(Landroid/net/Uri;)V
    .locals 0
    .param p1, "url"    # Landroid/net/Uri;

    .prologue
    .line 404
    iput-object p1, p0, Lco/vine/android/SignUpNameAvatarFragment;->mProfileUri:Landroid/net/Uri;

    .line 405
    return-void
.end method

.method public setThumbnailImage(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bm"    # Landroid/graphics/Bitmap;

    .prologue
    .line 475
    invoke-direct {p0, p1}, Lco/vine/android/SignUpNameAvatarFragment;->setAvatar(Landroid/graphics/Bitmap;)V

    .line 476
    iget-boolean v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mPhotoAttached:Z

    if-eqz v0, :cond_0

    .line 477
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/SignUpNameAvatarFragment;->mHasPromptedForPhoto:Z

    .line 479
    :cond_0
    return-void
.end method
