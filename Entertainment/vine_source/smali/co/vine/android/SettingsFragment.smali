.class public Lco/vine/android/SettingsFragment;
.super Lco/vine/android/BaseControllerFragment;
.source "SettingsFragment.java"

# interfaces
.implements Lco/vine/android/SetThumbnailTask$SetThumbnailListener;
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;
.implements Landroid/view/View$OnClickListener;
.implements Lco/vine/android/ImagePicker$Listener;
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;
.implements Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
.implements Lco/vine/android/widget/TypingEditText$TypingListener;
.implements Lco/vine/android/widget/ColorPicker$ColorClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;,
        Lco/vine/android/SettingsFragment$SettingsListener;,
        Lco/vine/android/SettingsFragment$GetCacheSizeAsyncTask;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lco/vine/android/BaseControllerFragment;",
        "Lco/vine/android/SetThumbnailTask$SetThumbnailListener;",
        "Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;",
        "Landroid/view/View$OnClickListener;",
        "Lco/vine/android/ImagePicker$Listener;",
        "Landroid/widget/CompoundButton$OnCheckedChangeListener;",
        "Landroid/support/v4/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Lco/vine/android/widget/TypingEditText$TypingListener;",
        "Lco/vine/android/widget/ColorPicker$ColorClickListener;"
    }
.end annotation


# static fields
.field private static final DEBUG_TAP_THRESHOLD:I = 0x6

.field private static final DIALOG_CLEAR_CACHE:I = 0x6

.field private static final DIALOG_DEACTIVATE_ACCOUNT:I = 0x7

.field private static final DIALOG_DISCONNECT_TWITTER:I = 0x5

.field private static final DIALOG_FACEBOOK_DISCONNECT:I = 0xb

.field private static final DIALOG_LOGOUT:I = 0x4

.field private static final DIALOG_REMOVE_TAKE_OR_CHOOSE_PHOTO:I = 0x2

.field private static final DIALOG_TAKE_OR_CHOOSE_PHOTO:I = 0x1

.field private static final DIALOG_UNSAVED_CHANGES:I = 0x3

.field private static final DIALOG_VERIFY_EMAIL:I = 0x8

.field private static final DIALOG_VERIFY_EMAIL_SENT:I = 0xa

.field private static final DIALOG_VERIFY_PHONE:I = 0x9

.field private static final LOADER_ID_DEFAULT:I = 0x0

.field private static final REQUEST_CODE_CHOOSE_PHOTO:I = 0x5

.field private static final REQUEST_CODE_CONFIRM_PHONE:I = 0x7

.field private static final REQUEST_CODE_CROP:I = 0x4

.field private static final REQUEST_CODE_TAKE_PHOTO:I = 0x3

.field private static final REQUEST_GMS_RESOLUTION:I = 0x6

.field public static final RESULT_CACHE_CLEARED:I = 0x1

.field private static final STATE_AVATAR_URI:Ljava/lang/String; = "state_avatar_url"

.field private static final STATE_BACKGROUND_COLOR:Ljava/lang/String; = "state_background_color"

.field private static final STATE_COLOR_INDEX:Ljava/lang/String; = "state_color_index"

.field private static final STATE_DESCRIPTION:Ljava/lang/String; = "state_desc"

.field private static final STATE_EDITION:Ljava/lang/String; = "state_edition"

.field private static final STATE_EDITIONS_FETCHED:Ljava/lang/String; = "state_editions_fetched"

.field private static final STATE_EMAIL:Ljava/lang/String; = "state_email"

.field private static final STATE_LOCATION:Ljava/lang/String; = "state_loc"

.field private static final STATE_NAME:Ljava/lang/String; = "state_name"

.field private static final STATE_PHONE:Ljava/lang/String; = "state_phone"

.field private static final TAG:Ljava/lang/String; = "SettingsFragment"


# instance fields
.field private mAlertIcon:Landroid/widget/ImageView;

.field private mAppController:Lco/vine/android/client/AppController;

.field private mAvatarActionView:Landroid/widget/ImageView;

.field private mAvatarImageView:Landroid/widget/ImageView;

.field private mAvatarKey:Lco/vine/android/util/image/ImageKey;

.field private mAvatarUri:Landroid/net/Uri;

.field private mBackgroundColor:I

.field private mClearCacheValue:Landroid/widget/TextView;

.field private mColorIndex:I

.field private mDescription:Ljava/lang/String;

.field private mEditTextEmail:Landroid/widget/TextView;

.field private mEditTextPhone:Landroid/widget/TextView;

.field private mEdition:Ljava/lang/String;

.field private mEditionsFetched:Z

.field private mEditionsSpinner:Landroid/widget/Spinner;

.field private mEditor:Landroid/content/SharedPreferences$Editor;

.field private mEmail:Ljava/lang/String;

.field private mEmailVerified:Landroid/widget/ImageView;

.field private mErrorCode:I

.field private mFacebookValue:Landroid/widget/TextView;

.field private mFbSession:Lcom/facebook/Session;

.field private mImagePicker:Lco/vine/android/ImagePicker;

.field private mInviteSmsIntent:Landroid/content/Intent;

.field private mIsEmailVerified:Z

.field private mIsPhoneVerified:Z

.field private mLocation:Ljava/lang/String;

.field private mName:Ljava/lang/String;

.field private mNotifications:Landroid/view/ViewGroup;

.field private mOriginalAvatarUrl:Ljava/lang/String;

.field private mOriginalBackgroundColor:I

.field private mOriginalColorIndex:I

.field private mOriginalDescription:Ljava/lang/String;

.field private mOriginalEdition:Ljava/lang/String;

.field private mOriginalEmail:Ljava/lang/String;

.field private mOriginalEmailVerified:Z

.field private mOriginalLocation:Ljava/lang/String;

.field private mOriginalName:Ljava/lang/String;

.field private mOriginalPhone:Ljava/lang/String;

.field private mOriginalPhoneVerified:Z

.field private mPhone:Ljava/lang/String;

.field private mPhoneVerified:Landroid/widget/ImageView;

.field private mPhotoChanged:Z

.field private mPrefs:Landroid/content/SharedPreferences;

.field private mProfileBackground:Landroid/view/View;

.field private mProgress:Landroid/app/ProgressDialog;

.field private mScrollView:Landroid/widget/ScrollView;

.field private mSpinnerAdapter:Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;

.field private mThumbnail:Landroid/graphics/Bitmap;

.field private mTwitterConnected:Z

.field private mTwitterLogin:Z

.field private mVersionTapCount:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 87
    invoke-direct {p0}, Lco/vine/android/BaseControllerFragment;-><init>()V

    .line 167
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/SettingsFragment;->mEditionsFetched:Z

    .line 1708
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/SettingsFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mClearCacheValue:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/SettingsFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1002(Lco/vine/android/SettingsFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 87
    iput-boolean p1, p0, Lco/vine/android/SettingsFragment;->mIsPhoneVerified:Z

    return p1
.end method

.method static synthetic access$102(Lco/vine/android/SettingsFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$1100(Lco/vine/android/SettingsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-boolean v0, p0, Lco/vine/android/SettingsFragment;->mOriginalPhoneVerified:Z

    return v0
.end method

.method static synthetic access$1200(Lco/vine/android/SettingsFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mEdition:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1202(Lco/vine/android/SettingsFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lco/vine/android/SettingsFragment;->mEdition:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$1300(Lco/vine/android/SettingsFragment;)Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mSpinnerAdapter:Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;

    return-object v0
.end method

.method static synthetic access$1400(Lco/vine/android/SettingsFragment;)Lco/vine/android/util/image/ImageKey;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAvatarKey:Lco/vine/android/util/image/ImageKey;

    return-object v0
.end method

.method static synthetic access$1500(Lco/vine/android/SettingsFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAvatarImageView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    return-object v0
.end method

.method static synthetic access$1700(Lco/vine/android/SettingsFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mFacebookValue:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1800(Lco/vine/android/SettingsFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    invoke-direct {p0}, Lco/vine/android/SettingsFragment;->invalidateFacebookSessionUI()V

    return-void
.end method

.method static synthetic access$1900(Lco/vine/android/SettingsFragment;)Landroid/content/SharedPreferences$Editor;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mEditor:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/SettingsFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mDescription:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2000(Lco/vine/android/SettingsFragment;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget v0, p0, Lco/vine/android/SettingsFragment;->mColorIndex:I

    return v0
.end method

.method static synthetic access$2002(Lco/vine/android/SettingsFragment;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # I

    .prologue
    .line 87
    iput p1, p0, Lco/vine/android/SettingsFragment;->mColorIndex:I

    return p1
.end method

.method static synthetic access$202(Lco/vine/android/SettingsFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lco/vine/android/SettingsFragment;->mDescription:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$2102(Lco/vine/android/SettingsFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lco/vine/android/SettingsFragment;->mOriginalEdition:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$2200(Lco/vine/android/SettingsFragment;)Lco/vine/android/client/AppController;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    return-object v0
.end method

.method static synthetic access$2302(Lco/vine/android/SettingsFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 87
    iput-boolean p1, p0, Lco/vine/android/SettingsFragment;->mTwitterLogin:Z

    return p1
.end method

.method static synthetic access$2400(Lco/vine/android/SettingsFragment;)Landroid/content/SharedPreferences;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mPrefs:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$2500(Lco/vine/android/SettingsFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    invoke-direct {p0}, Lco/vine/android/SettingsFragment;->updateVerificationIcons()V

    return-void
.end method

.method static synthetic access$2602(Lco/vine/android/SettingsFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 87
    iput-boolean p1, p0, Lco/vine/android/SettingsFragment;->mEditionsFetched:Z

    return p1
.end method

.method static synthetic access$2700(Lco/vine/android/SettingsFragment;)Landroid/widget/Spinner;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mEditionsSpinner:Landroid/widget/Spinner;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/SettingsFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mLocation:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$302(Lco/vine/android/SettingsFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lco/vine/android/SettingsFragment;->mLocation:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$400(Lco/vine/android/SettingsFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$402(Lco/vine/android/SettingsFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$500(Lco/vine/android/SettingsFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalEmail:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/SettingsFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalPhone:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$702(Lco/vine/android/SettingsFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 87
    iput-boolean p1, p0, Lco/vine/android/SettingsFragment;->mIsEmailVerified:Z

    return p1
.end method

.method static synthetic access$800(Lco/vine/android/SettingsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-boolean v0, p0, Lco/vine/android/SettingsFragment;->mOriginalEmailVerified:Z

    return v0
.end method

.method static synthetic access$900(Lco/vine/android/SettingsFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;

    .prologue
    .line 87
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mPhone:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$902(Lco/vine/android/SettingsFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/SettingsFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lco/vine/android/SettingsFragment;->mPhone:Ljava/lang/String;

    return-object p1
.end method

.method private invalidateFacebookSessionUI()V
    .locals 3

    .prologue
    .line 623
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->getValidFacebookSession(Landroid/app/Activity;Z)Lcom/facebook/Session;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/SettingsFragment;->mFbSession:Lcom/facebook/Session;

    .line 624
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mFbSession:Lcom/facebook/Session;

    if-eqz v0, :cond_0

    .line 625
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mFacebookValue:Landroid/widget/TextView;

    const v1, 0x7f0e01da

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 629
    :goto_0
    return-void

    .line 627
    :cond_0
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mFacebookValue:Landroid/widget/TextView;

    const v1, 0x7f0e01f1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0
.end method

.method private isDirty()Z
    .locals 2

    .prologue
    .line 203
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalName:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalEmail:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalDescription:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mDescription:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalLocation:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mLocation:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalPhone:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mPhone:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalEdition:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mEdition:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Lco/vine/android/SettingsFragment;->mOriginalColorIndex:I

    iget v1, p0, Lco/vine/android/SettingsFragment;->mColorIndex:I

    if-ne v0, v1, :cond_0

    iget-boolean v0, p0, Lco/vine/android/SettingsFragment;->mPhotoChanged:Z

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private resetPrefs()V
    .locals 3

    .prologue
    .line 189
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mEditor:Landroid/content/SharedPreferences$Editor;

    .line 190
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "settings_profile_name"

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalName:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 191
    const-string v1, "settings_profile_description"

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalDescription:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 192
    const-string v1, "settings_profile_location"

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalLocation:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 193
    const-string v1, "settings_profile_email"

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalEmail:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 194
    const-string v1, "settings_profile_phone"

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalPhone:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 195
    const-string v1, "settings_profile_avatar_url"

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalAvatarUrl:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 196
    const-string v1, "settings_edition"

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalEdition:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 197
    const-string v1, "color_index"

    iget v2, p0, Lco/vine/android/SettingsFragment;->mOriginalColorIndex:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 198
    const-string v1, "profile_background"

    iget v2, p0, Lco/vine/android/SettingsFragment;->mOriginalBackgroundColor:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 199
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 200
    return-void
.end method

.method private setImage(Landroid/graphics/Bitmap;Z)V
    .locals 3
    .param p1, "bmp"    # Landroid/graphics/Bitmap;
    .param p2, "edited"    # Z

    .prologue
    .line 974
    iput-object p1, p0, Lco/vine/android/SettingsFragment;->mThumbnail:Landroid/graphics/Bitmap;

    .line 975
    if-nez p1, :cond_0

    .line 976
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAvatarImageView:Landroid/widget/ImageView;

    const v1, 0x7f020065

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 977
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAvatarActionView:Landroid/widget/ImageView;

    const v1, 0x7f020061

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 982
    :goto_0
    return-void

    .line 979
    :cond_0
    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mAvatarActionView:Landroid/widget/ImageView;

    if-eqz p2, :cond_1

    const v0, 0x7f020062

    :goto_1
    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 980
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAvatarImageView:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mAvatarImageView:Landroid/widget/ImageView;

    invoke-virtual {v2}, Landroid/widget/ImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 979
    :cond_1
    const v0, 0x7f020064

    goto :goto_1
.end method

.method private setOriginalPreferenceValues()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 238
    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mPrefs:Landroid/content/SharedPreferences;

    .line 239
    .local v1, "prefs":Landroid/content/SharedPreferences;
    const-string v2, "settings_profile_name"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalName:Ljava/lang/String;

    .line 240
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalName:Ljava/lang/String;

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;

    .line 241
    const-string v2, "settings_profile_description"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalDescription:Ljava/lang/String;

    .line 242
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalDescription:Ljava/lang/String;

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mDescription:Ljava/lang/String;

    .line 243
    const-string v2, "settings_profile_location"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalLocation:Ljava/lang/String;

    .line 244
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalLocation:Ljava/lang/String;

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mLocation:Ljava/lang/String;

    .line 245
    const-string v2, "settings_profile_email"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalEmail:Ljava/lang/String;

    .line 246
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalEmail:Ljava/lang/String;

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    .line 247
    const-string v2, "settings_profile_phone"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalPhone:Ljava/lang/String;

    .line 248
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalPhone:Ljava/lang/String;

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mPhone:Ljava/lang/String;

    .line 249
    const-string v2, "settings_edition"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalEdition:Ljava/lang/String;

    .line 250
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalEdition:Ljava/lang/String;

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mEdition:Ljava/lang/String;

    .line 251
    const-string v2, "settings_twitter_connected"

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lco/vine/android/SettingsFragment;->mTwitterConnected:Z

    .line 254
    const-string v2, "settings_profile_avatar_url"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    .line 255
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/SettingsFragment;->mOriginalAvatarUrl:Ljava/lang/String;

    .line 256
    const-string v2, "profile_background"

    sget v3, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lco/vine/android/SettingsFragment;->mBackgroundColor:I

    .line 258
    iget v2, p0, Lco/vine/android/SettingsFragment;->mBackgroundColor:I

    iput v2, p0, Lco/vine/android/SettingsFragment;->mOriginalBackgroundColor:I

    .line 259
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v2, Lco/vine/android/Settings;->PROFILE_BACKGROUND_COLORS:[I

    array-length v2, v2

    if-ge v0, v2, :cond_0

    .line 260
    sget-object v2, Lco/vine/android/Settings;->PROFILE_BACKGROUND_COLORS:[I

    aget v2, v2, v0

    iget v3, p0, Lco/vine/android/SettingsFragment;->mBackgroundColor:I

    if-ne v2, v3, :cond_1

    .line 261
    iput v0, p0, Lco/vine/android/SettingsFragment;->mOriginalColorIndex:I

    .line 265
    :cond_0
    iget v2, p0, Lco/vine/android/SettingsFragment;->mOriginalColorIndex:I

    iput v2, p0, Lco/vine/android/SettingsFragment;->mColorIndex:I

    .line 266
    const-string v2, "profile_email_verified"

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lco/vine/android/SettingsFragment;->mOriginalEmailVerified:Z

    .line 267
    iget-boolean v2, p0, Lco/vine/android/SettingsFragment;->mOriginalEmailVerified:Z

    iput-boolean v2, p0, Lco/vine/android/SettingsFragment;->mIsEmailVerified:Z

    .line 268
    const-string v2, "profile_phone_verified"

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lco/vine/android/SettingsFragment;->mOriginalPhoneVerified:Z

    .line 269
    iget-boolean v2, p0, Lco/vine/android/SettingsFragment;->mOriginalPhoneVerified:Z

    iput-boolean v2, p0, Lco/vine/android/SettingsFragment;->mIsPhoneVerified:Z

    .line 270
    return-void

    .line 259
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private updateProfile(Landroid/net/Uri;)V
    .locals 9
    .param p1, "avatarUri"    # Landroid/net/Uri;

    .prologue
    .line 1694
    invoke-direct {p0}, Lco/vine/android/SettingsFragment;->validate()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1695
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalName:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackChangedName()V

    .line 1696
    :cond_0
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalDescription:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mDescription:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackChangedDescription()V

    .line 1697
    :cond_1
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalLocation:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mLocation:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackChangedLocation()V

    .line 1698
    :cond_2
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalEmail:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackChangedEmail()V

    .line 1699
    :cond_3
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mOriginalEdition:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mEdition:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackChangedEdition()V

    .line 1701
    :cond_4
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;

    iget-object v3, p0, Lco/vine/android/SettingsFragment;->mDescription:Ljava/lang/String;

    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mLocation:Ljava/lang/String;

    iget-object v5, p0, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    iget-object v6, p0, Lco/vine/android/SettingsFragment;->mPhone:Ljava/lang/String;

    iget-boolean v7, p0, Lco/vine/android/SettingsFragment;->mPhotoChanged:Z

    if-eqz v7, :cond_6

    move-object v7, p1

    :goto_0
    iget v8, p0, Lco/vine/android/SettingsFragment;->mBackgroundColor:I

    invoke-virtual/range {v0 .. v8}, Lco/vine/android/client/AppController;->updateProfile(Lco/vine/android/client/Session;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;I)Ljava/lang/String;

    .line 1704
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mEdition:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->updateEdition(Lco/vine/android/client/Session;Ljava/lang/String;)Ljava/lang/String;

    .line 1706
    :cond_5
    return-void

    .line 1701
    :cond_6
    const/4 v7, 0x0

    goto :goto_0
.end method

.method private updateVerificationIcons()V
    .locals 8

    .prologue
    const v7, 0x7f0201d8

    const v6, 0x7f0201d7

    const/16 v5, 0x8

    const/4 v4, 0x0

    .line 1653
    const/4 v1, 0x0

    .line 1655
    .local v1, "res":Landroid/content/res/Resources;
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getResources()Landroid/content/res/Resources;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 1661
    :goto_0
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mEditTextEmail:Landroid/widget/TextView;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mEditTextEmail:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1662
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mEmailVerified:Landroid/widget/ImageView;

    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1674
    :cond_0
    :goto_1
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mEditTextPhone:Landroid/widget/TextView;

    if-eqz v2, :cond_4

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mEditTextPhone:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1675
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mPhoneVerified:Landroid/widget/ImageView;

    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1686
    :cond_1
    :goto_2
    return-void

    .line 1656
    :catch_0
    move-exception v0

    .line 1658
    .local v0, "e":Ljava/lang/Exception;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 1664
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_2
    if-eqz v1, :cond_0

    .line 1665
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mEmailVerified:Landroid/widget/ImageView;

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1666
    iget-boolean v2, p0, Lco/vine/android/SettingsFragment;->mIsEmailVerified:Z

    if-eqz v2, :cond_3

    .line 1667
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mEmailVerified:Landroid/widget/ImageView;

    invoke-virtual {v1, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 1669
    :cond_3
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mEmailVerified:Landroid/widget/ImageView;

    invoke-virtual {v1, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 1677
    :cond_4
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mPhoneVerified:Landroid/widget/ImageView;

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1678
    if-eqz v1, :cond_1

    .line 1679
    iget-boolean v2, p0, Lco/vine/android/SettingsFragment;->mIsPhoneVerified:Z

    if-eqz v2, :cond_5

    .line 1680
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mPhoneVerified:Landroid/widget/ImageView;

    invoke-virtual {v1, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_2

    .line 1682
    :cond_5
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mPhoneVerified:Landroid/widget/ImageView;

    invoke-virtual {v1, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_2
.end method

.method private validate()Z
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 1621
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 1622
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    iget-object v3, p0, Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1623
    if-eqz v0, :cond_0

    .line 1624
    const v3, 0x7f0e0149

    invoke-static {v0, v3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 1649
    :cond_0
    :goto_0
    return v2

    .line 1628
    :cond_1
    iget-object v3, p0, Lco/vine/android/SettingsFragment;->mLocation:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    const/16 v4, 0x20

    if-le v3, v4, :cond_2

    .line 1629
    if-eqz v0, :cond_0

    .line 1630
    const v3, 0x7f0e0014

    invoke-static {v0, v3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0

    .line 1635
    :cond_2
    iget-object v3, p0, Lco/vine/android/SettingsFragment;->mDescription:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    const/16 v4, 0x8c

    if-le v3, v4, :cond_3

    .line 1636
    if-eqz v0, :cond_0

    .line 1637
    const v3, 0x7f0e0009

    invoke-static {v0, v3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0

    .line 1642
    :cond_3
    if-eqz v0, :cond_4

    .line 1643
    new-instance v1, Landroid/app/ProgressDialog;

    const v2, 0x7f0f0037

    invoke-direct {v1, v0, v2}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 1645
    .local v1, "progressDialog":Landroid/app/ProgressDialog;
    const v2, 0x7f0e0201

    invoke-virtual {p0, v2}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 1646
    invoke-virtual {v1}, Landroid/app/ProgressDialog;->show()V

    .line 1647
    iput-object v1, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    .line 1649
    .end local v1    # "progressDialog":Landroid/app/ProgressDialog;
    :cond_4
    const/4 v2, 0x1

    goto :goto_0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v7, 0x8

    .line 986
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 987
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    .line 988
    .local v1, "args":Landroid/os/Bundle;
    if-eqz v1, :cond_0

    .line 989
    const-string v4, "action"

    invoke-virtual {v1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 991
    .local v0, "action":Ljava/lang/String;
    sget-object v4, Lco/vine/android/HomeTabActivity;->ACTION_VERIFICATION_COMPLETE:Ljava/lang/String;

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 992
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mScrollView:Landroid/widget/ScrollView;

    .line 993
    .local v2, "scrollView":Landroid/widget/ScrollView;
    const v4, 0x7f0a01f5

    invoke-virtual {v2, v4}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 994
    .local v3, "verified":Landroid/view/View;
    new-instance v4, Lco/vine/android/SettingsFragment$7;

    invoke-direct {v4, p0, v2, v3}, Lco/vine/android/SettingsFragment$7;-><init>(Lco/vine/android/SettingsFragment;Landroid/widget/ScrollView;Landroid/view/View;)V

    invoke-virtual {v2, v4}, Landroid/widget/ScrollView;->post(Ljava/lang/Runnable;)Z

    .line 1002
    .end local v0    # "action":Ljava/lang/String;
    .end local v2    # "scrollView":Landroid/widget/ScrollView;
    .end local v3    # "verified":Landroid/view/View;
    :cond_0
    new-instance v4, Landroid/content/Intent;

    const-string v5, "android.intent.action.VIEW"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iput-object v4, p0, Lco/vine/android/SettingsFragment;->mInviteSmsIntent:Landroid/content/Intent;

    .line 1003
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mInviteSmsIntent:Landroid/content/Intent;

    const-string v5, "vnd.android-dir/mms-sms"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 1004
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mInviteSmsIntent:Landroid/content/Intent;

    const-string v5, "sms_body"

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/util/Util;->getSmsMessage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1005
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mInviteSmsIntent:Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-virtual {v5}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/content/Intent;->resolveActivity(Landroid/content/pm/PackageManager;)Landroid/content/ComponentName;

    move-result-object v4

    if-nez v4, :cond_1

    .line 1006
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mScrollView:Landroid/widget/ScrollView;

    const v5, 0x7f0a01ff

    invoke-virtual {v4, v5}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, v7}, Landroid/view/View;->setVisibility(I)V

    .line 1007
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mScrollView:Landroid/widget/ScrollView;

    const v5, 0x7f0a0200

    invoke-virtual {v4, v5}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, v7}, Landroid/view/View;->setVisibility(I)V

    .line 1010
    :cond_1
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 19
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "extras"    # Landroid/content/Intent;

    .prologue
    .line 1014
    invoke-super/range {p0 .. p3}, Lco/vine/android/BaseControllerFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 1015
    packed-switch p1, :pswitch_data_0

    .line 1119
    const-string v3, "Facebook auth came back: {}"

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1120
    const/4 v3, -0x1

    move/from16 v0, p2

    if-ne v0, v3, :cond_b

    .line 1121
    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v15

    .line 1122
    .local v15, "session":Lcom/facebook/Session;
    if-eqz v15, :cond_a

    .line 1123
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    move/from16 v0, p1

    move/from16 v1, p2

    move-object/from16 v2, p3

    invoke-virtual {v15, v3, v0, v1, v2}, Lcom/facebook/Session;->onActivityResult(Landroid/app/Activity;IILandroid/content/Intent;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 1125
    invoke-virtual {v15}, Lcom/facebook/Session;->getPermissions()Ljava/util/List;

    move-result-object v3

    const-string v4, "publish_actions"

    invoke-interface {v3, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 1126
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v15}, Lcom/facebook/Session;->getAccessToken()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lco/vine/android/client/AppController;->setPendingFacebookToken(Landroid/content/Context;Ljava/lang/String;)V

    .line 1128
    new-instance v12, Landroid/app/ProgressDialog;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/4 v4, 0x2

    invoke-direct {v12, v3, v4}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 1130
    .local v12, "d":Landroid/app/ProgressDialog;
    const v3, 0x7f0e0120

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v12, v3}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 1131
    const/4 v3, 0x0

    invoke-virtual {v12, v3}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 1132
    invoke-virtual {v12}, Landroid/app/ProgressDialog;->show()V

    .line 1133
    move-object/from16 v0, p0

    iput-object v12, v0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    .line 1134
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->sendFacebookToken()Ljava/lang/String;

    .line 1157
    .end local v12    # "d":Landroid/app/ProgressDialog;
    .end local v15    # "session":Lcom/facebook/Session;
    :cond_0
    :goto_0
    return-void

    .line 1018
    :pswitch_0
    const/4 v3, -0x1

    move/from16 v0, p2

    if-ne v0, v3, :cond_0

    .line 1020
    const/4 v3, 0x3

    move/from16 v0, p1

    if-ne v0, v3, :cond_1

    .line 1021
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    move-object/from16 v16, v0

    .line 1025
    .local v16, "uri":Landroid/net/Uri;
    :goto_1
    new-instance v3, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const-class v17, Lco/vine/android/EditProfileCropActivity;

    move-object/from16 v0, v17

    invoke-direct {v3, v4, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v4, "uri"

    move-object/from16 v0, v16

    invoke-virtual {v3, v4, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    move-result-object v14

    .line 1027
    .local v14, "intent":Landroid/content/Intent;
    const/4 v3, 0x4

    move-object/from16 v0, p0

    invoke-virtual {v0, v14, v3}, Lco/vine/android/SettingsFragment;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 1023
    .end local v14    # "intent":Landroid/content/Intent;
    .end local v16    # "uri":Landroid/net/Uri;
    :cond_1
    invoke-virtual/range {p3 .. p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v16

    .restart local v16    # "uri":Landroid/net/Uri;
    goto :goto_1

    .line 1032
    .end local v16    # "uri":Landroid/net/Uri;
    :pswitch_1
    const/4 v3, -0x1

    move/from16 v0, p2

    if-ne v0, v3, :cond_0

    if-eqz p3, :cond_0

    .line 1033
    const-string v3, "uri"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v11

    check-cast v11, Landroid/net/Uri;

    .line 1034
    .local v11, "croppedUri":Landroid/net/Uri;
    if-eqz v11, :cond_2

    .line 1035
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    invoke-static {v3}, Lco/vine/android/util/image/ImageUtils;->deleteTempPic(Landroid/net/Uri;)Z

    .line 1036
    move-object/from16 v0, p0

    iput-object v11, v0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    .line 1037
    new-instance v3, Lco/vine/android/SetThumbnailTask;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lco/vine/android/SetThumbnailTask;-><init>(Landroid/support/v4/app/Fragment;)V

    const/4 v4, 0x1

    new-array v4, v4, [Landroid/net/Uri;

    const/16 v17, 0x0

    aput-object v11, v4, v17

    invoke-virtual {v3, v4}, Lco/vine/android/SetThumbnailTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1039
    :cond_2
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lco/vine/android/SettingsFragment;->mPhotoChanged:Z

    goto :goto_0

    .line 1044
    .end local v11    # "croppedUri":Landroid/net/Uri;
    :pswitch_2
    const/4 v3, -0x1

    move/from16 v0, p2

    if-ne v0, v3, :cond_3

    .line 1045
    const-string v3, "screen_name"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1046
    .local v5, "username":Ljava/lang/String;
    const-string v3, "tk"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 1047
    .local v6, "token":Ljava/lang/String;
    const-string v3, "ts"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 1048
    .local v7, "secret":Ljava/lang/String;
    const-string v3, "user_id"

    const-wide/16 v17, 0x0

    move-object/from16 v0, p3

    move-wide/from16 v1, v17

    invoke-virtual {v0, v3, v1, v2}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v8

    .line 1049
    .local v8, "userId":J
    new-instance v12, Landroid/app/ProgressDialog;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f0f0037

    invoke-direct {v12, v3, v4}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 1051
    .restart local v12    # "d":Landroid/app/ProgressDialog;
    const v3, 0x7f0e021d

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v12, v3}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 1052
    const/4 v3, 0x0

    invoke-virtual {v12, v3}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 1053
    invoke-virtual {v12}, Landroid/app/ProgressDialog;->show()V

    .line 1054
    move-object/from16 v0, p0

    iput-object v12, v0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    .line 1055
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v4

    invoke-virtual/range {v3 .. v9}, Lco/vine/android/client/AppController;->connectTwitter(Lco/vine/android/client/Session;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;

    goto/16 :goto_0

    .line 1058
    .end local v5    # "username":Ljava/lang/String;
    .end local v6    # "token":Ljava/lang/String;
    .end local v7    # "secret":Ljava/lang/String;
    .end local v8    # "userId":J
    .end local v12    # "d":Landroid/app/ProgressDialog;
    :cond_3
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f0e00ce

    invoke-static {v3, v4}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto/16 :goto_0

    .line 1063
    :pswitch_3
    const/4 v3, -0x1

    move/from16 v0, p2

    if-ne v0, v3, :cond_4

    .line 1064
    const-string v3, "screen_name"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1066
    .restart local v5    # "username":Ljava/lang/String;
    const-string v3, "token"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 1067
    .restart local v6    # "token":Ljava/lang/String;
    const-string v3, "secret"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 1068
    .restart local v7    # "secret":Ljava/lang/String;
    const-string v3, "user_id"

    const-wide/16 v17, 0x0

    move-object/from16 v0, p3

    move-wide/from16 v1, v17

    invoke-virtual {v0, v3, v1, v2}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v8

    .line 1069
    .restart local v8    # "userId":J
    new-instance v12, Landroid/app/ProgressDialog;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f0f0037

    invoke-direct {v12, v3, v4}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 1071
    .restart local v12    # "d":Landroid/app/ProgressDialog;
    const v3, 0x7f0e021d

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v12, v3}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 1072
    const/4 v3, 0x0

    invoke-virtual {v12, v3}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 1073
    invoke-virtual {v12}, Landroid/app/ProgressDialog;->show()V

    .line 1074
    move-object/from16 v0, p0

    iput-object v12, v0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    .line 1075
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v4

    invoke-virtual/range {v3 .. v9}, Lco/vine/android/client/AppController;->connectTwitter(Lco/vine/android/client/Session;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;

    goto/16 :goto_0

    .line 1077
    .end local v5    # "username":Ljava/lang/String;
    .end local v6    # "token":Ljava/lang/String;
    .end local v7    # "secret":Ljava/lang/String;
    .end local v8    # "userId":J
    .end local v12    # "d":Landroid/app/ProgressDialog;
    :cond_4
    if-eqz p2, :cond_0

    .line 1079
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f0e00d0

    invoke-static {v3, v4}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto/16 :goto_0

    .line 1084
    :pswitch_4
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    .line 1085
    .local v10, "activity":Landroid/app/Activity;
    invoke-static {v10}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->isGooglePlayServicesAvailable(Landroid/content/Context;)I

    move-result v13

    .line 1086
    .local v13, "errorCode":I
    if-nez v13, :cond_7

    .line 1087
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/SettingsFragment;->mNotifications:Landroid/view/ViewGroup;

    if-eqz v3, :cond_5

    .line 1088
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/SettingsFragment;->mNotifications:Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    invoke-virtual {v3, v0}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1090
    :cond_5
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/SettingsFragment;->mAlertIcon:Landroid/widget/ImageView;

    if-eqz v3, :cond_6

    .line 1091
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/SettingsFragment;->mAlertIcon:Landroid/widget/ImageView;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1094
    :cond_6
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v17

    move-wide/from16 v0, v17

    invoke-static {v10, v0, v1}, Lco/vine/android/service/GCMRegistrationService;->getRegisterIntent(Landroid/content/Context;J)Landroid/content/Intent;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/support/v4/app/FragmentActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    goto/16 :goto_0

    .line 1097
    :cond_7
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f0e024b

    invoke-static {v3, v4}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto/16 :goto_0

    .line 1102
    .end local v10    # "activity":Landroid/app/Activity;
    .end local v13    # "errorCode":I
    :pswitch_5
    packed-switch p2, :pswitch_data_1

    goto/16 :goto_0

    .line 1104
    :pswitch_6
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/SettingsFragment;->mPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string v4, "profile_phone_verified"

    const/16 v17, 0x1

    move/from16 v0, v17

    invoke-interface {v3, v4, v0}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1105
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lco/vine/android/SettingsFragment;->mIsPhoneVerified:Z

    .line 1106
    invoke-direct/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->updateVerificationIcons()V

    goto/16 :goto_0

    .line 1110
    :pswitch_7
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lco/vine/android/SettingsFragment;->mIsPhoneVerified:Z

    .line 1111
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/SettingsFragment;->mPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string v4, "profile_phone_verified"

    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-interface {v3, v4, v0}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1112
    invoke-direct/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->updateVerificationIcons()V

    goto/16 :goto_0

    .line 1136
    .restart local v15    # "session":Lcom/facebook/Session;
    :cond_8
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    new-instance v4, Lco/vine/android/SettingsFragment$8;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lco/vine/android/SettingsFragment$8;-><init>(Lco/vine/android/SettingsFragment;)V

    invoke-virtual {v3, v4}, Landroid/support/v4/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 1142
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v0, p0

    invoke-virtual {v3, v0}, Lco/vine/android/client/AppController;->connectToFacebookPublish(Landroid/support/v4/app/Fragment;)V

    goto/16 :goto_0

    .line 1145
    :cond_9
    invoke-direct/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->invalidateFacebookSessionUI()V

    goto/16 :goto_0

    .line 1148
    :cond_a
    invoke-direct/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->invalidateFacebookSessionUI()V

    .line 1149
    invoke-super/range {p0 .. p3}, Lco/vine/android/BaseControllerFragment;->onActivityResult(IILandroid/content/Intent;)V

    goto/16 :goto_0

    .line 1152
    .end local v15    # "session":Lcom/facebook/Session;
    :cond_b
    invoke-direct/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->invalidateFacebookSessionUI()V

    goto/16 :goto_0

    .line 1015
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_4
        :pswitch_5
    .end packed-switch

    .line 1102
    :pswitch_data_1
    .packed-switch 0x5f7
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public onBackPressed()V
    .locals 3

    .prologue
    .line 640
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 641
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    invoke-direct {p0}, Lco/vine/android/SettingsFragment;->isDirty()Z

    move-result v2

    if-eqz v2, :cond_1

    if-eqz v0, :cond_1

    .line 642
    const/4 v2, 0x3

    invoke-static {v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v1

    .line 644
    .local v1, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v2, 0x7f0e01ff

    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 645
    const v2, 0x7f0e01dc

    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 646
    const v2, 0x7f0e01e3

    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 647
    const/4 v2, 0x0

    invoke-virtual {v1, p0, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 648
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    .line 657
    .end local v1    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_0
    :goto_0
    return-void

    .line 650
    :cond_1
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    if-eqz v2, :cond_2

    .line 651
    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    invoke-virtual {v2}, Landroid/app/ProgressDialog;->dismiss()V

    .line 653
    :cond_2
    if-eqz v0, :cond_0

    .line 654
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_0
.end method

.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 0
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 634
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 15
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1373
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getId()I

    move-result v10

    sparse-switch v10, :sswitch_data_0

    .line 1618
    :cond_0
    :goto_0
    return-void

    .line 1375
    :sswitch_0
    iget-object v10, p0, Lco/vine/android/SettingsFragment;->mFbSession:Lcom/facebook/Session;

    if-eqz v10, :cond_1

    .line 1376
    const/16 v10, 0xb

    invoke-static {v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v6

    .line 1378
    .local v6, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const/4 v10, 0x0

    invoke-virtual {v6, p0, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 1379
    const v10, 0x7f0e01e4

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v10

    const v11, 0x7f0e0288

    invoke-virtual {v10, v11}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v10

    const v11, 0x7f0e0057

    invoke-virtual {v10, v11}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1383
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v10

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1384
    :catch_0
    move-exception v1

    .line 1385
    .local v1, "e":Ljava/lang/Exception;
    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 1388
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_1
    iget-object v10, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    const/4 v12, 0x0

    invoke-virtual {v10, v11, v12}, Lco/vine/android/client/AppController;->getValidFacebookSession(Landroid/app/Activity;Z)Lcom/facebook/Session;

    move-result-object v8

    .line 1390
    .local v8, "session":Lcom/facebook/Session;
    if-nez v8, :cond_2

    .line 1391
    iget-object v10, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v10, p0}, Lco/vine/android/client/AppController;->connectToFacebookInitialize(Landroid/support/v4/app/Fragment;)V

    goto :goto_0

    .line 1393
    :cond_2
    iget-object v10, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v10}, Lco/vine/android/client/AppController;->getPendingFacebookToken()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_0

    .line 1394
    iget-object v10, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v10}, Lco/vine/android/client/AppController;->sendFacebookToken()Ljava/lang/String;

    goto :goto_0

    .line 1401
    .end local v8    # "session":Lcom/facebook/Session;
    :sswitch_1
    iget-object v10, p0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    if-eqz v10, :cond_3

    iget-object v10, p0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    invoke-virtual {v10}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_3

    .line 1402
    const/4 v10, 0x2

    invoke-static {v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v6

    .line 1404
    .restart local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const/4 v10, 0x0

    invoke-virtual {v6, p0, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 1405
    const v10, 0x7f0e021e

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v10

    const v11, 0x7f0e01a4

    invoke-virtual {v10, v11}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v10

    const v11, 0x7f0e0242

    invoke-virtual {v10, v11}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v10

    const v11, 0x7f0e005b

    invoke-virtual {v10, v11}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1410
    :try_start_1
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v10

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_0

    .line 1411
    :catch_1
    move-exception v1

    .line 1412
    .restart local v1    # "e":Ljava/lang/Exception;
    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 1415
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_3
    const/4 v10, 0x1

    invoke-static {v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v6

    .line 1417
    .restart local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const/4 v10, 0x0

    invoke-virtual {v6, p0, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 1418
    const v10, 0x7f0e021e

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v10

    const v11, 0x7f0e0242

    invoke-virtual {v10, v11}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v10

    const v11, 0x7f0e005b

    invoke-virtual {v10, v11}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1422
    :try_start_2
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v10

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto/16 :goto_0

    .line 1423
    :catch_2
    move-exception v1

    .line 1424
    .restart local v1    # "e":Ljava/lang/Exception;
    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 1430
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :sswitch_2
    iget-boolean v10, p0, Lco/vine/android/SettingsFragment;->mTwitterLogin:Z

    if-eqz v10, :cond_4

    .line 1431
    const/4 v10, 0x5

    invoke-static {v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v6

    .line 1433
    .restart local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v10, 0x7f0e01e5

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1434
    const v10, 0x7f0e01e4

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1435
    const v10, 0x7f0e0057

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1436
    const/4 v10, 0x0

    invoke-virtual {v6, p0, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 1438
    :try_start_3
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v10

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    goto/16 :goto_0

    .line 1439
    :catch_3
    move-exception v1

    .line 1440
    .restart local v1    # "e":Ljava/lang/Exception;
    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 1443
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_4
    iget-object v10, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v10}, Lco/vine/android/client/AppController;->getTwitter()Lcom/twitter/android/sdk/Twitter;

    move-result-object v9

    .line 1444
    .local v9, "twitter":Lcom/twitter/android/sdk/Twitter;
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 1445
    .local v0, "activity":Landroid/app/Activity;
    invoke-static {v9, v0}, Lco/vine/android/client/AppController;->startTwitterAuthWithFinish(Lcom/twitter/android/sdk/Twitter;Landroid/app/Activity;)V

    goto/16 :goto_0

    .line 1450
    .end local v0    # "activity":Landroid/app/Activity;
    .end local v9    # "twitter":Lcom/twitter/android/sdk/Twitter;
    :sswitch_3
    const/4 v10, 0x4

    invoke-static {v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v6

    .line 1452
    .restart local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v10, 0x7f0e0131

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1453
    const v10, 0x7f0e0130

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1454
    const v10, 0x7f0e0057

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1455
    const/4 v10, 0x0

    invoke-virtual {v6, p0, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 1457
    :try_start_4
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v10

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    goto/16 :goto_0

    .line 1458
    :catch_4
    move-exception v1

    .line 1459
    .restart local v1    # "e":Ljava/lang/Exception;
    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 1464
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :sswitch_4
    new-instance v3, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    const-class v11, Lco/vine/android/ResetPasswordActivity;

    invoke-direct {v3, v10, v11}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1465
    .local v3, "i":Landroid/content/Intent;
    iget-object v10, p0, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_5

    .line 1466
    const-string v10, "email"

    iget-object v11, p0, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    invoke-virtual {v3, v10, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1468
    :cond_5
    invoke-virtual {p0, v3}, Lco/vine/android/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1472
    .end local v3    # "i":Landroid/content/Intent;
    :sswitch_5
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackContentControls()V

    .line 1473
    new-instance v10, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    const-class v12, Lco/vine/android/ContentControlsActivity;

    invoke-direct {v10, v11, v12}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v10}, Lco/vine/android/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1477
    :sswitch_6
    new-instance v10, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    const-class v12, Lco/vine/android/PrivacyControlsActivity;

    invoke-direct {v10, v11, v12}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v10}, Lco/vine/android/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1481
    :sswitch_7
    const-string v10, "Settings"

    invoke-static {v10}, Lco/vine/android/util/FlurryUtils;->trackVisitFindFriends(Ljava/lang/String;)V

    .line 1482
    new-instance v10, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    const-class v12, Lco/vine/android/FindFriendsActivity;

    invoke-direct {v10, v11, v12}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v10}, Lco/vine/android/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1486
    :sswitch_8
    const-string v10, "email"

    const-string v11, "Settings"

    invoke-static {v10, v11}, Lco/vine/android/util/FlurryUtils;->trackInvite(Ljava/lang/String;Ljava/lang/String;)V

    .line 1487
    new-instance v4, Landroid/content/Intent;

    const-string v10, "android.intent.action.SENDTO"

    const-string v11, "mailto"

    const-string v12, ""

    const/4 v13, 0x0

    invoke-static {v11, v12, v13}, Landroid/net/Uri;->fromParts(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v11

    invoke-direct {v4, v10, v11}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 1489
    .local v4, "intent":Landroid/content/Intent;
    const-string v10, "android.intent.extra.SUBJECT"

    const v11, 0x7f0e00e6

    invoke-virtual {p0, v11}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v4, v10, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1491
    const-string v10, "android.intent.extra.TEXT"

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    invoke-static {v11}, Lco/vine/android/util/Util;->getEmailMessage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v4, v10, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1492
    const v10, 0x7f0e00e4

    invoke-virtual {p0, v10}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-static {v4, v10}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v10

    invoke-virtual {p0, v10}, Lco/vine/android/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1497
    .end local v4    # "intent":Landroid/content/Intent;
    :sswitch_9
    const-string v10, "sms"

    const-string v11, "Settings"

    invoke-static {v10, v11}, Lco/vine/android/util/FlurryUtils;->trackInvite(Ljava/lang/String;Ljava/lang/String;)V

    .line 1498
    iget-object v10, p0, Lco/vine/android/SettingsFragment;->mInviteSmsIntent:Landroid/content/Intent;

    const v11, 0x7f0e01be

    invoke-virtual {p0, v11}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v10

    invoke-virtual {p0, v10}, Lco/vine/android/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1503
    :sswitch_a
    const/4 v10, 0x6

    invoke-static {v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v6

    .line 1505
    .restart local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v10, 0x7f0e01d6

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1506
    const v10, 0x7f0e0057

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1507
    const v10, 0x7f0e01d5

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1508
    const/4 v10, 0x0

    invoke-virtual {v6, p0, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 1509
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v10

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    goto/16 :goto_0

    .line 1513
    .end local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :sswitch_b
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackPrivacyPolicy()V

    .line 1514
    new-instance v3, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    const-class v11, Lco/vine/android/WebViewActivity;

    invoke-direct {v3, v10, v11}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1515
    .restart local v3    # "i":Landroid/content/Intent;
    const-string v10, "type"

    const/4 v11, 0x1

    invoke-virtual {v3, v10, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1517
    invoke-virtual {p0, v3}, Lco/vine/android/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1521
    .end local v3    # "i":Landroid/content/Intent;
    :sswitch_c
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackTos()V

    .line 1522
    new-instance v3, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    const-class v11, Lco/vine/android/WebViewActivity;

    invoke-direct {v3, v10, v11}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1523
    .restart local v3    # "i":Landroid/content/Intent;
    const-string v10, "type"

    const/4 v11, 0x2

    invoke-virtual {v3, v10, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1524
    invoke-virtual {p0, v3}, Lco/vine/android/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1528
    .end local v3    # "i":Landroid/content/Intent;
    :sswitch_d
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackAttribution()V

    .line 1529
    new-instance v3, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    const-class v11, Lco/vine/android/WebViewActivity;

    invoke-direct {v3, v10, v11}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1530
    .restart local v3    # "i":Landroid/content/Intent;
    const-string v10, "type"

    const/4 v11, 0x5

    invoke-virtual {v3, v10, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1531
    invoke-virtual {p0, v3}, Lco/vine/android/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1535
    .end local v3    # "i":Landroid/content/Intent;
    :sswitch_e
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackDeactivateAccount()V

    .line 1536
    const/4 v10, 0x7

    invoke-static {v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v6

    .line 1538
    .restart local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v10, 0x7f0e01df

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1539
    const v10, 0x7f0e01e0

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1540
    const v10, 0x7f0e0057

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1541
    const v10, 0x7f0e01de

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1542
    const/4 v10, 0x0

    invoke-virtual {v6, p0, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 1544
    :try_start_5
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v10

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_5

    goto/16 :goto_0

    .line 1545
    :catch_5
    move-exception v1

    .line 1546
    .restart local v1    # "e":Ljava/lang/Exception;
    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 1551
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :sswitch_f
    iget v10, p0, Lco/vine/android/SettingsFragment;->mVersionTapCount:I

    add-int/lit8 v10, v10, 0x1

    iput v10, p0, Lco/vine/android/SettingsFragment;->mVersionTapCount:I

    .line 1552
    iget v10, p0, Lco/vine/android/SettingsFragment;->mVersionTapCount:I

    const/4 v11, 0x6

    if-lt v10, v11, :cond_6

    .line 1553
    const/4 v10, 0x0

    iput v10, p0, Lco/vine/android/SettingsFragment;->mVersionTapCount:I

    .line 1554
    new-instance v10, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    const-class v12, Lco/vine/android/DebugHomeActivity;

    invoke-direct {v10, v11, v12}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v10}, Lco/vine/android/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1555
    :cond_6
    iget v10, p0, Lco/vine/android/SettingsFragment;->mVersionTapCount:I

    const/4 v11, 0x5

    if-ne v10, v11, :cond_7

    .line 1556
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    const-string v11, "One more!"

    invoke-static {v10, v11}, Lco/vine/android/util/Util;->showShortCenteredToast(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1559
    :cond_7
    :try_start_6
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v10

    const-string v11, "co.vine.android"

    const/4 v12, 0x0

    invoke-virtual {v10, v11, v12}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v7

    .line 1560
    .local v7, "pi":Landroid/content/pm/PackageInfo;
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Version Code: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    iget v12, v7, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Lco/vine/android/util/Util;->showShortCenteredToast(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_6

    goto/16 :goto_0

    .line 1561
    .end local v7    # "pi":Landroid/content/pm/PackageInfo;
    :catch_6
    move-exception v1

    .line 1562
    .restart local v1    # "e":Ljava/lang/Exception;
    const-string v10, "Failed to show version code."

    invoke-static {v10, v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 1568
    .end local v1    # "e":Ljava/lang/Exception;
    :sswitch_10
    invoke-static {}, Lco/vine/android/LocaleDialog;->newInstance()Lco/vine/android/LocaleDialog;

    move-result-object v5

    .line 1569
    .local v5, "ldf":Lco/vine/android/LocaleDialog;
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v10

    const-string v11, "locale"

    invoke-virtual {v5, v10, v11}, Lco/vine/android/LocaleDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1574
    .end local v5    # "ldf":Lco/vine/android/LocaleDialog;
    :sswitch_11
    iget-object v10, p0, Lco/vine/android/SettingsFragment;->mEditionsSpinner:Landroid/widget/Spinner;

    invoke-virtual {v10}, Landroid/widget/Spinner;->performClick()Z

    goto/16 :goto_0

    .line 1579
    :sswitch_12
    iget v10, p0, Lco/vine/android/SettingsFragment;->mErrorCode:I

    if-eqz v10, :cond_8

    .line 1580
    iget v10, p0, Lco/vine/android/SettingsFragment;->mErrorCode:I

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    const/4 v12, 0x6

    invoke-static {v10, v11, v12}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->getErrorDialog(ILandroid/app/Activity;I)Landroid/app/Dialog;

    move-result-object v2

    .line 1582
    .local v2, "errorDialog":Landroid/app/Dialog;
    invoke-virtual {v2}, Landroid/app/Dialog;->show()V

    goto/16 :goto_0

    .line 1584
    .end local v2    # "errorDialog":Landroid/app/Dialog;
    :cond_8
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackNotificationSettings()V

    .line 1585
    new-instance v10, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    const-class v12, Lco/vine/android/NotificationSettingsActivity;

    invoke-direct {v10, v11, v12}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v10}, Lco/vine/android/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1590
    :sswitch_13
    iget-boolean v10, p0, Lco/vine/android/SettingsFragment;->mIsEmailVerified:Z

    if-nez v10, :cond_0

    .line 1593
    const/16 v10, 0x8

    invoke-static {v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v6

    .line 1595
    .restart local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const/4 v10, 0x0

    invoke-virtual {v6, p0, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 1596
    const v10, 0x7f0e0083

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v10

    const v11, 0x7f0e0081

    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    iget-object v14, p0, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    aput-object v14, v12, v13

    invoke-virtual {p0, v11, v12}, Lco/vine/android/SettingsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(Ljava/lang/String;)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v10

    const/high16 v11, 0x1040000

    invoke-virtual {v10, v11}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 1600
    :try_start_7
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v10

    invoke-virtual {v6, v10}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_7

    goto/16 :goto_0

    .line 1601
    :catch_7
    move-exception v1

    .line 1602
    .restart local v1    # "e":Ljava/lang/Exception;
    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 1607
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v6    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :sswitch_14
    iget-boolean v10, p0, Lco/vine/android/SettingsFragment;->mIsPhoneVerified:Z

    if-nez v10, :cond_0

    .line 1610
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    iget-object v11, p0, Lco/vine/android/SettingsFragment;->mPhone:Ljava/lang/String;

    const/4 v12, 0x0

    invoke-static {v10, v11, v12}, Lco/vine/android/ConfirmationFlowActivity;->getIntent(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v3

    .line 1611
    .restart local v3    # "i":Landroid/content/Intent;
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    const/4 v11, 0x7

    invoke-virtual {v10, v3, v11}, Landroid/support/v4/app/FragmentActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto/16 :goto_0

    .line 1373
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0a0063 -> :sswitch_1
        0x7f0a0145 -> :sswitch_7
        0x7f0a0147 -> :sswitch_12
        0x7f0a01f3 -> :sswitch_13
        0x7f0a01f6 -> :sswitch_14
        0x7f0a01f8 -> :sswitch_11
        0x7f0a01f9 -> :sswitch_11
        0x7f0a01fb -> :sswitch_4
        0x7f0a01fc -> :sswitch_5
        0x7f0a01fd -> :sswitch_6
        0x7f0a01fe -> :sswitch_12
        0x7f0a01ff -> :sswitch_9
        0x7f0a0201 -> :sswitch_8
        0x7f0a0202 -> :sswitch_2
        0x7f0a0205 -> :sswitch_0
        0x7f0a0208 -> :sswitch_a
        0x7f0a020b -> :sswitch_c
        0x7f0a020c -> :sswitch_b
        0x7f0a020d -> :sswitch_d
        0x7f0a020e -> :sswitch_10
        0x7f0a020f -> :sswitch_e
        0x7f0a0210 -> :sswitch_3
        0x7f0a0211 -> :sswitch_f
    .end sparse-switch
.end method

.method public onColorClick(I)V
    .locals 11
    .param p1, "colorIndex"    # I

    .prologue
    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    const/high16 v7, -0x1000000

    .line 705
    iget v5, p0, Lco/vine/android/SettingsFragment;->mColorIndex:I

    if-ltz v5, :cond_1

    .line 706
    sget-object v5, Lco/vine/android/Settings;->PROFILE_BACKGROUND_COLORS:[I

    iget v6, p0, Lco/vine/android/SettingsFragment;->mColorIndex:I

    aget v2, v5, v6

    .line 710
    .local v2, "origColor":I
    :goto_0
    iput p1, p0, Lco/vine/android/SettingsFragment;->mColorIndex:I

    .line 711
    sget-object v5, Lco/vine/android/Settings;->PROFILE_BACKGROUND_COLORS:[I

    iget v6, p0, Lco/vine/android/SettingsFragment;->mColorIndex:I

    aget v5, v5, v6

    iput v5, p0, Lco/vine/android/SettingsFragment;->mBackgroundColor:I

    .line 712
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    or-int v5, v2, v7

    invoke-direct {v0, v5}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 713
    .local v0, "from":Landroid/graphics/drawable/ColorDrawable;
    new-instance v4, Landroid/graphics/drawable/ColorDrawable;

    iget v5, p0, Lco/vine/android/SettingsFragment;->mBackgroundColor:I

    or-int/2addr v5, v7

    invoke-direct {v4, v5}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 714
    .local v4, "to":Landroid/graphics/drawable/ColorDrawable;
    new-instance v3, Landroid/graphics/drawable/TransitionDrawable;

    new-array v5, v10, [Landroid/graphics/drawable/Drawable;

    aput-object v0, v5, v8

    aput-object v4, v5, v9

    invoke-direct {v3, v5}, Landroid/graphics/drawable/TransitionDrawable;-><init>([Landroid/graphics/drawable/Drawable;)V

    .line 716
    .local v3, "td":Landroid/graphics/drawable/TransitionDrawable;
    iget-object v5, p0, Lco/vine/android/SettingsFragment;->mProfileBackground:Landroid/view/View;

    if-eqz v5, :cond_0

    .line 717
    iget-object v5, p0, Lco/vine/android/SettingsFragment;->mProfileBackground:Landroid/view/View;

    invoke-virtual {v5, v3}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 718
    const/16 v5, 0x64

    invoke-virtual {v3, v5}, Landroid/graphics/drawable/TransitionDrawable;->startTransition(I)V

    .line 720
    :cond_0
    new-instance v3, Landroid/graphics/drawable/TransitionDrawable;

    .end local v3    # "td":Landroid/graphics/drawable/TransitionDrawable;
    new-array v5, v10, [Landroid/graphics/drawable/Drawable;

    aput-object v0, v5, v8

    aput-object v4, v5, v9

    invoke-direct {v3, v5}, Landroid/graphics/drawable/TransitionDrawable;-><init>([Landroid/graphics/drawable/Drawable;)V

    .line 721
    .restart local v3    # "td":Landroid/graphics/drawable/TransitionDrawable;
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x10

    if-le v5, v6, :cond_2

    .line 722
    invoke-virtual {p0, v3}, Lco/vine/android/SettingsFragment;->setActionBarTransition(Landroid/graphics/drawable/TransitionDrawable;)V

    .line 726
    :goto_1
    new-instance v1, Landroid/content/Intent;

    const-string v5, "co.vine.android.profileColor"

    invoke-direct {v1, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 727
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    const-string v6, "co.vine.android.BROADCAST"

    invoke-virtual {v5, v1, v6}, Landroid/support/v4/app/FragmentActivity;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 728
    return-void

    .line 708
    .end local v0    # "from":Landroid/graphics/drawable/ColorDrawable;
    .end local v1    # "intent":Landroid/content/Intent;
    .end local v2    # "origColor":I
    .end local v3    # "td":Landroid/graphics/drawable/TransitionDrawable;
    .end local v4    # "to":Landroid/graphics/drawable/ColorDrawable;
    :cond_1
    sget v2, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    .restart local v2    # "origColor":I
    goto :goto_0

    .line 724
    .restart local v0    # "from":Landroid/graphics/drawable/ColorDrawable;
    .restart local v3    # "td":Landroid/graphics/drawable/TransitionDrawable;
    .restart local v4    # "to":Landroid/graphics/drawable/ColorDrawable;
    :cond_2
    iget v5, p0, Lco/vine/android/SettingsFragment;->mBackgroundColor:I

    invoke-virtual {p0, v5}, Lco/vine/android/SettingsFragment;->setActionBarColor(I)V

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 274
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onCreate(Landroid/os/Bundle;)V

    .line 275
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/SettingsFragment;->setHasOptionsMenu(Z)V

    .line 276
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/SettingsFragment;->mPrefs:Landroid/content/SharedPreferences;

    .line 277
    new-instance v0, Lco/vine/android/SettingsFragment$SettingsListener;

    invoke-direct {v0, p0}, Lco/vine/android/SettingsFragment$SettingsListener;-><init>(Lco/vine/android/SettingsFragment;)V

    iput-object v0, p0, Lco/vine/android/SettingsFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 278
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    .line 279
    new-instance v0, Lco/vine/android/ImagePicker;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    invoke-direct {v0, v1, p0, v2, v3}, Lco/vine/android/ImagePicker;-><init>(Landroid/app/Activity;Lco/vine/android/ImagePicker$Listener;J)V

    iput-object v0, p0, Lco/vine/android/SettingsFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    .line 280
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/SettingsFragment;->mEditor:Landroid/content/SharedPreferences$Editor;

    .line 281
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 7
    .param p1, "i"    # I
    .param p2, "bundle"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 669
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Lco/vine/android/provider/Vine$Editions;->CONTENT_URI:Landroid/net/Uri;

    sget-object v3, Lco/vine/android/provider/VineDatabaseSQL$EditionsQuery;->PROJECTION:[Ljava/lang/String;

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 4
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    const v3, 0x7f0a0245

    const/4 v2, 0x1

    .line 661
    const v1, 0x7f100012

    invoke-virtual {p2, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 662
    invoke-interface {p1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 663
    .local v0, "menuItem":Landroid/view/MenuItem;
    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 664
    invoke-interface {p1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 665
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 44
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 320
    const v40, 0x7f03008f

    const/16 v41, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v40

    move-object/from16 v2, p2

    move/from16 v3, v41

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v38

    .line 322
    .local v38, "v":Landroid/view/View;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v33

    .line 324
    .local v33, "res":Landroid/content/res/Resources;
    invoke-direct/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->setOriginalPreferenceValues()V

    .line 326
    if-eqz p3, :cond_0

    .line 327
    const-string v40, "state_name"

    move-object/from16 v0, p3

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v40

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;

    .line 328
    const-string v40, "state_desc"

    move-object/from16 v0, p3

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v40

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mDescription:Ljava/lang/String;

    .line 329
    const-string v40, "state_loc"

    move-object/from16 v0, p3

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v40

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mLocation:Ljava/lang/String;

    .line 330
    const-string v40, "state_phone"

    move-object/from16 v0, p3

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v40

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mPhone:Ljava/lang/String;

    .line 331
    const-string v40, "state_email"

    move-object/from16 v0, p3

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v40

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    .line 332
    const-string v40, "state_editions_fetched"

    move-object/from16 v0, p3

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v40

    move/from16 v0, v40

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/SettingsFragment;->mEditionsFetched:Z

    .line 333
    const-string v40, "state_edition"

    move-object/from16 v0, p3

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v40

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mEdition:Ljava/lang/String;

    .line 334
    const-string v40, "state_avatar_url"

    move-object/from16 v0, p3

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v40

    check-cast v40, Landroid/net/Uri;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    .line 335
    const-string v40, "state_background_color"

    move-object/from16 v0, p3

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v40

    move/from16 v0, v40

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/SettingsFragment;->mBackgroundColor:I

    .line 336
    const-string v40, "state_color_index"

    move-object/from16 v0, p3

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v40

    move/from16 v0, v40

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/SettingsFragment;->mColorIndex:I

    .line 339
    :cond_0
    const v40, 0x7f0a00e0

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v40

    check-cast v40, Landroid/widget/ScrollView;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mScrollView:Landroid/widget/ScrollView;

    .line 341
    const v40, 0x7f0a01f3

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v40

    check-cast v40, Landroid/widget/ImageView;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mEmailVerified:Landroid/widget/ImageView;

    .line 342
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mEmailVerified:Landroid/widget/ImageView;

    move-object/from16 v40, v0

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 344
    const v40, 0x7f0a01f6

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v40

    check-cast v40, Landroid/widget/ImageView;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mPhoneVerified:Landroid/widget/ImageView;

    .line 345
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mPhoneVerified:Landroid/widget/ImageView;

    move-object/from16 v40, v0

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 347
    const v40, 0x7f0a0213

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lco/vine/android/widget/ColorPicker;

    .line 348
    .local v11, "colorPicker":Lco/vine/android/widget/ColorPicker;
    move-object/from16 v0, p0

    invoke-virtual {v11, v0}, Lco/vine/android/widget/ColorPicker;->setOnColorClickListener(Lco/vine/android/widget/ColorPicker$ColorClickListener;)V

    .line 349
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/SettingsFragment;->mColorIndex:I

    move/from16 v40, v0

    move/from16 v0, v40

    invoke-virtual {v11, v0}, Lco/vine/android/widget/ColorPicker;->setColorIndex(I)V

    .line 351
    const v40, 0x7f0a0103

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v32

    check-cast v32, Landroid/view/ViewGroup;

    .line 352
    .local v32, "profileBackground":Landroid/view/ViewGroup;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/SettingsFragment;->mBackgroundColor:I

    move/from16 v40, v0

    const/high16 v41, -0x1000000

    or-int v40, v40, v41

    move-object/from16 v0, v32

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setBackgroundColor(I)V

    .line 354
    move-object/from16 v0, v32

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mProfileBackground:Landroid/view/View;

    .line 356
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/SettingsFragment;->mBackgroundColor:I

    move/from16 v40, v0

    move-object/from16 v0, p0

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Lco/vine/android/SettingsFragment;->setActionBarColor(I)V

    .line 358
    const v40, 0x7f0a01fd

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v30

    check-cast v30, Landroid/widget/TextView;

    .line 359
    .local v30, "privacyControls":Landroid/widget/TextView;
    move-object/from16 v0, v30

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 361
    const v40, 0x7f0a0063

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v40

    check-cast v40, Landroid/widget/ImageView;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mAvatarImageView:Landroid/widget/ImageView;

    .line 362
    const v40, 0x7f0a022b

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v40

    check-cast v40, Landroid/widget/ImageView;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mAvatarActionView:Landroid/widget/ImageView;

    .line 363
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mAvatarActionView:Landroid/widget/ImageView;

    move-object/from16 v40, v0

    const/16 v41, 0x0

    invoke-virtual/range {v40 .. v41}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 364
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    move-object/from16 v40, v0

    if-nez v40, :cond_2

    const-string v7, ""

    .line 365
    .local v7, "avatarUrl":Ljava/lang/String;
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mAvatarImageView:Landroid/widget/ImageView;

    move-object/from16 v40, v0

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 366
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mThumbnail:Landroid/graphics/Bitmap;

    move-object/from16 v40, v0

    if-eqz v40, :cond_3

    .line 367
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mThumbnail:Landroid/graphics/Bitmap;

    move-object/from16 v40, v0

    const/16 v41, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v40

    move/from16 v2, v41

    invoke-direct {v0, v1, v2}, Lco/vine/android/SettingsFragment;->setImage(Landroid/graphics/Bitmap;Z)V

    .line 381
    :goto_1
    const v40, 0x7f0a01f1

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v19

    check-cast v19, Landroid/widget/EditText;

    .line 382
    .local v19, "editTextName":Landroid/widget/EditText;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;

    move-object/from16 v40, v0

    move-object/from16 v0, v19

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 383
    new-instance v40, Lco/vine/android/SettingsFragment$1;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/SettingsFragment$1;-><init>(Lco/vine/android/SettingsFragment;)V

    move-object/from16 v0, v19

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 398
    const v40, 0x7f0a019d

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v16

    check-cast v16, Landroid/widget/EditText;

    .line 399
    .local v16, "editTextDescription":Landroid/widget/EditText;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mDescription:Ljava/lang/String;

    move-object/from16 v40, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 400
    const v40, 0x7f0e01e2

    move-object/from16 v0, v16

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setHint(I)V

    .line 401
    new-instance v40, Lco/vine/android/SettingsFragment$2;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/SettingsFragment$2;-><init>(Lco/vine/android/SettingsFragment;)V

    move-object/from16 v0, v16

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 416
    const v40, 0x7f0a019e

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v18

    check-cast v18, Landroid/widget/EditText;

    .line 417
    .local v18, "editTextLocation":Landroid/widget/EditText;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mLocation:Ljava/lang/String;

    move-object/from16 v40, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 418
    const v40, 0x7f0e01f0

    move-object/from16 v0, v18

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setHint(I)V

    .line 419
    new-instance v40, Lco/vine/android/SettingsFragment$3;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/SettingsFragment$3;-><init>(Lco/vine/android/SettingsFragment;)V

    move-object/from16 v0, v18

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 435
    const v40, 0x7f0a01f4

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Lco/vine/android/widget/TypingEditText;

    .line 436
    .local v17, "editTextEmail":Lco/vine/android/widget/TypingEditText;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    move-object/from16 v40, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Lco/vine/android/widget/TypingEditText;->setText(Ljava/lang/CharSequence;)V

    .line 437
    const/16 v40, 0x20

    move-object/from16 v0, v17

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Lco/vine/android/widget/TypingEditText;->setInputType(I)V

    .line 438
    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/TypingEditText;->setTypingListener(Lco/vine/android/widget/TypingEditText$TypingListener;)V

    .line 439
    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mEditTextEmail:Landroid/widget/TextView;

    .line 441
    new-instance v40, Lco/vine/android/SettingsFragment$4;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/SettingsFragment$4;-><init>(Lco/vine/android/SettingsFragment;)V

    move-object/from16 v0, v17

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Lco/vine/android/widget/TypingEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 461
    const v40, 0x7f0a01f7

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v20

    check-cast v20, Lco/vine/android/widget/TypingEditText;

    .line 462
    .local v20, "editTextPhone":Lco/vine/android/widget/TypingEditText;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mPhone:Ljava/lang/String;

    move-object/from16 v40, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Lco/vine/android/widget/TypingEditText;->setText(Ljava/lang/CharSequence;)V

    .line 463
    const/16 v40, 0x3

    move-object/from16 v0, v20

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Lco/vine/android/widget/TypingEditText;->setInputType(I)V

    .line 464
    new-instance v40, Lco/vine/android/SettingsFragment$5;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/SettingsFragment$5;-><init>(Lco/vine/android/SettingsFragment;)V

    move-object/from16 v0, v20

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Lco/vine/android/widget/TypingEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 485
    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/TypingEditText;->setTypingListener(Lco/vine/android/widget/TypingEditText$TypingListener;)V

    .line 486
    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mEditTextPhone:Landroid/widget/TextView;

    .line 488
    const v40, 0x7f0a01fa

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v40

    check-cast v40, Landroid/widget/Spinner;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mEditionsSpinner:Landroid/widget/Spinner;

    .line 489
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mEditionsSpinner:Landroid/widget/Spinner;

    move-object/from16 v40, v0

    const/16 v41, 0x0

    invoke-virtual/range {v40 .. v41}, Landroid/widget/Spinner;->setFocusable(Z)V

    .line 490
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mEditionsSpinner:Landroid/widget/Spinner;

    move-object/from16 v40, v0

    new-instance v41, Lco/vine/android/SettingsFragment$6;

    move-object/from16 v0, v41

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/SettingsFragment$6;-><init>(Lco/vine/android/SettingsFragment;)V

    invoke-virtual/range {v40 .. v41}, Landroid/widget/Spinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 502
    const v40, 0x7f0a01f8

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v40

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 503
    const v40, 0x7f0a01f9

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v40

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 505
    new-instance v40, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;-><init>(Lco/vine/android/SettingsFragment;)V

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mSpinnerAdapter:Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;

    .line 507
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mEditionsSpinner:Landroid/widget/Spinner;

    move-object/from16 v40, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mSpinnerAdapter:Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;

    move-object/from16 v41, v0

    invoke-virtual/range {v40 .. v41}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 509
    const v40, 0x7f0a01fb

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v28

    check-cast v28, Landroid/widget/TextView;

    .line 510
    .local v28, "password":Landroid/widget/TextView;
    move-object/from16 v0, v28

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 512
    const v40, 0x7f0a01fc

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/widget/TextView;

    .line 513
    .local v12, "content":Landroid/widget/TextView;
    move-object/from16 v0, p0

    invoke-virtual {v12, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 515
    const v40, 0x7f0a0147

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v40

    check-cast v40, Landroid/view/ViewGroup;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mNotifications:Landroid/view/ViewGroup;

    .line 516
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isGoogle()Z

    move-result v40

    if-eqz v40, :cond_7

    .line 517
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mNotifications:Landroid/view/ViewGroup;

    move-object/from16 v40, v0

    const/16 v41, 0x0

    invoke-virtual/range {v40 .. v41}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 518
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mNotifications:Landroid/view/ViewGroup;

    move-object/from16 v40, v0

    const v41, 0x7f0a01fe

    invoke-virtual/range {v40 .. v41}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v40

    check-cast v40, Landroid/widget/ImageView;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mAlertIcon:Landroid/widget/ImageView;

    .line 519
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v40

    invoke-static/range {v40 .. v40}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->isGooglePlayServicesAvailable(Landroid/content/Context;)I

    move-result v40

    move/from16 v0, v40

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/SettingsFragment;->mErrorCode:I

    .line 520
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/SettingsFragment;->mErrorCode:I

    move/from16 v40, v0

    if-eqz v40, :cond_6

    .line 521
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mAlertIcon:Landroid/widget/ImageView;

    move-object/from16 v40, v0

    const/16 v41, 0x0

    invoke-virtual/range {v40 .. v41}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 522
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mAlertIcon:Landroid/widget/ImageView;

    move-object/from16 v40, v0

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 526
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mNotifications:Landroid/view/ViewGroup;

    move-object/from16 v40, v0

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 538
    :goto_3
    const v40, 0x7f0a0145

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v23

    check-cast v23, Landroid/widget/TextView;

    .line 539
    .local v23, "findFriends":Landroid/widget/TextView;
    move-object/from16 v0, v23

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 541
    const v40, 0x7f0a01ff

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v25

    check-cast v25, Landroid/widget/TextView;

    .line 542
    .local v25, "inviteViaText":Landroid/widget/TextView;
    move-object/from16 v0, v25

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 544
    const v40, 0x7f0a0201

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v24

    check-cast v24, Landroid/widget/TextView;

    .line 545
    .local v24, "inviteViaEmail":Landroid/widget/TextView;
    move-object/from16 v0, v24

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 547
    const v40, 0x7f0a0202

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v36

    check-cast v36, Landroid/widget/RelativeLayout;

    .line 548
    .local v36, "twitterConnect":Landroid/widget/RelativeLayout;
    const v40, 0x7f020076

    move-object/from16 v0, v36

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 549
    const v40, 0x7f0a0204

    move-object/from16 v0, v36

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v37

    check-cast v37, Landroid/widget/TextView;

    .line 552
    .local v37, "twitterConnectedTextView":Landroid/widget/TextView;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v40

    invoke-static/range {v40 .. v40}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v5

    .line 553
    .local v5, "am":Landroid/accounts/AccountManager;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v40

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v41, v0

    invoke-virtual/range {v41 .. v41}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v41

    invoke-virtual/range {v41 .. v41}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v41

    invoke-static/range {v40 .. v41}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v4

    .line 555
    .local v4, "acc":Landroid/accounts/Account;
    if-eqz v4, :cond_8

    invoke-static {v5, v4}, Lco/vine/android/client/VineAccountHelper;->getLoginType(Landroid/accounts/AccountManager;Landroid/accounts/Account;)I

    move-result v40

    const/16 v41, 0x2

    move/from16 v0, v40

    move/from16 v1, v41

    if-ne v0, v1, :cond_8

    .line 557
    new-instance v40, Ljava/lang/StringBuilder;

    invoke-direct/range {v40 .. v40}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v41, 0x40

    invoke-virtual/range {v40 .. v41}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v40

    invoke-static {v5, v4}, Lco/vine/android/client/VineAccountHelper;->getTwitterUsername(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v41

    invoke-virtual/range {v40 .. v41}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v40

    invoke-virtual/range {v40 .. v40}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v40

    move-object/from16 v0, v37

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 558
    const/16 v40, 0x1

    move/from16 v0, v40

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/SettingsFragment;->mTwitterLogin:Z

    .line 567
    :goto_4
    move-object/from16 v0, v36

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 569
    const v40, 0x7f0a0205

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Landroid/widget/RelativeLayout;

    .line 570
    .local v21, "facebookConnect":Landroid/widget/RelativeLayout;
    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 571
    const v40, 0x7f0a0206

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v22

    check-cast v22, Landroid/widget/TextView;

    .line 572
    .local v22, "facebookLabel":Landroid/widget/TextView;
    const v40, 0x7f0e00d5

    move-object/from16 v0, v22

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 573
    const v40, 0x7f0a0207

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v40

    check-cast v40, Landroid/widget/TextView;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mFacebookValue:Landroid/widget/TextView;

    .line 574
    invoke-direct/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->invalidateFacebookSessionUI()V

    .line 575
    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 577
    const v40, 0x7f0a0208

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/RelativeLayout;

    .line 578
    .local v9, "clearCache":Landroid/widget/RelativeLayout;
    move-object/from16 v0, p0

    invoke-virtual {v9, v0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 580
    const v40, 0x7f0a0209

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/TextView;

    .line 581
    .local v10, "clearCacheLabel":Landroid/widget/TextView;
    const v40, 0x7f0e01d4

    move-object/from16 v0, p0

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v40

    move-object/from16 v0, v40

    invoke-virtual {v10, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 583
    const v40, 0x7f0a020a

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v40

    check-cast v40, Landroid/widget/TextView;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mClearCacheValue:Landroid/widget/TextView;

    .line 584
    new-instance v40, Lco/vine/android/SettingsFragment$GetCacheSizeAsyncTask;

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/SettingsFragment$GetCacheSizeAsyncTask;-><init>(Lco/vine/android/SettingsFragment;)V

    const/16 v41, 0x0

    move/from16 v0, v41

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v41, v0

    invoke-virtual/range {v40 .. v41}, Lco/vine/android/SettingsFragment$GetCacheSizeAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 586
    const v40, 0x7f0a020b

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v34

    check-cast v34, Landroid/widget/TextView;

    .line 587
    .local v34, "termsOfService":Landroid/widget/TextView;
    move-object/from16 v0, v34

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 589
    const v40, 0x7f0a020c

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v31

    check-cast v31, Landroid/widget/TextView;

    .line 590
    .local v31, "privacyPolicy":Landroid/widget/TextView;
    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 592
    const v40, 0x7f0a020d

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 593
    .local v6, "attribution":Landroid/widget/TextView;
    move-object/from16 v0, p0

    invoke-virtual {v6, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 595
    const v40, 0x7f0a020f

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Landroid/widget/TextView;

    .line 596
    .local v13, "deactivateAccount":Landroid/widget/TextView;
    move-object/from16 v0, p0

    invoke-virtual {v13, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 598
    const v40, 0x7f0a0210

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v27

    check-cast v27, Landroid/widget/Button;

    .line 599
    .local v27, "logout":Landroid/widget/Button;
    move-object/from16 v0, v27

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 601
    const v40, 0x7f0a0211

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v39

    check-cast v39, Landroid/widget/LinearLayout;

    .line 602
    .local v39, "version":Landroid/widget/LinearLayout;
    const v40, 0x7f0a0212

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v35

    check-cast v35, Landroid/widget/TextView;

    .line 605
    .local v35, "tv":Landroid/widget/TextView;
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v40

    invoke-virtual/range {v40 .. v40}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v40

    const-string v41, "co.vine.android"

    const/16 v42, 0x0

    invoke-virtual/range {v40 .. v42}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v29

    .line 606
    .local v29, "pi":Landroid/content/pm/PackageInfo;
    const v40, 0x7f0e01c6

    const/16 v41, 0x1

    move/from16 v0, v41

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v41, v0

    const/16 v42, 0x0

    move-object/from16 v0, v29

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    move-object/from16 v43, v0

    aput-object v43, v41, v42

    move-object/from16 v0, p0

    move/from16 v1, v40

    move-object/from16 v2, v41

    invoke-virtual {v0, v1, v2}, Lco/vine/android/SettingsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v40

    move-object/from16 v0, v35

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 611
    .end local v29    # "pi":Landroid/content/pm/PackageInfo;
    :goto_5
    move-object/from16 v0, v39

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 613
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isI18nOn()Z

    move-result v40

    if-eqz v40, :cond_1

    .line 614
    const v40, 0x7f0a020e

    move-object/from16 v0, v38

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v26

    check-cast v26, Landroid/widget/TextView;

    .line 615
    .local v26, "locale":Landroid/widget/TextView;
    const/16 v40, 0x0

    move-object/from16 v0, v26

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 616
    move-object/from16 v0, v26

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 619
    .end local v26    # "locale":Landroid/widget/TextView;
    :cond_1
    return-object v38

    .line 364
    .end local v4    # "acc":Landroid/accounts/Account;
    .end local v5    # "am":Landroid/accounts/AccountManager;
    .end local v6    # "attribution":Landroid/widget/TextView;
    .end local v7    # "avatarUrl":Ljava/lang/String;
    .end local v9    # "clearCache":Landroid/widget/RelativeLayout;
    .end local v10    # "clearCacheLabel":Landroid/widget/TextView;
    .end local v12    # "content":Landroid/widget/TextView;
    .end local v13    # "deactivateAccount":Landroid/widget/TextView;
    .end local v16    # "editTextDescription":Landroid/widget/EditText;
    .end local v17    # "editTextEmail":Lco/vine/android/widget/TypingEditText;
    .end local v18    # "editTextLocation":Landroid/widget/EditText;
    .end local v19    # "editTextName":Landroid/widget/EditText;
    .end local v20    # "editTextPhone":Lco/vine/android/widget/TypingEditText;
    .end local v21    # "facebookConnect":Landroid/widget/RelativeLayout;
    .end local v22    # "facebookLabel":Landroid/widget/TextView;
    .end local v23    # "findFriends":Landroid/widget/TextView;
    .end local v24    # "inviteViaEmail":Landroid/widget/TextView;
    .end local v25    # "inviteViaText":Landroid/widget/TextView;
    .end local v27    # "logout":Landroid/widget/Button;
    .end local v28    # "password":Landroid/widget/TextView;
    .end local v31    # "privacyPolicy":Landroid/widget/TextView;
    .end local v34    # "termsOfService":Landroid/widget/TextView;
    .end local v35    # "tv":Landroid/widget/TextView;
    .end local v36    # "twitterConnect":Landroid/widget/RelativeLayout;
    .end local v37    # "twitterConnectedTextView":Landroid/widget/TextView;
    .end local v39    # "version":Landroid/widget/LinearLayout;
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    move-object/from16 v40, v0

    invoke-virtual/range {v40 .. v40}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v7

    goto/16 :goto_0

    .line 368
    .restart local v7    # "avatarUrl":Ljava/lang/String;
    :cond_3
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v40

    if-nez v40, :cond_5

    .line 369
    invoke-static {v7}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v40

    if-eqz v40, :cond_4

    .line 370
    const/16 v40, 0x0

    const/16 v41, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v40

    move/from16 v2, v41

    invoke-direct {v0, v1, v2}, Lco/vine/android/SettingsFragment;->setImage(Landroid/graphics/Bitmap;Z)V

    goto/16 :goto_1

    .line 372
    :cond_4
    const v40, 0x7f0b0088

    move-object/from16 v0, v33

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v14

    .line 373
    .local v14, "dimen":I
    new-instance v40, Lco/vine/android/util/image/ImageKey;

    const/16 v41, 0x1

    move-object/from16 v0, v40

    move/from16 v1, v41

    invoke-direct {v0, v7, v14, v14, v1}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZ)V

    move-object/from16 v0, v40

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SettingsFragment;->mAvatarKey:Lco/vine/android/util/image/ImageKey;

    .line 374
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v40, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mAvatarKey:Lco/vine/android/util/image/ImageKey;

    move-object/from16 v41, v0

    invoke-virtual/range {v40 .. v41}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v8

    .line 375
    .local v8, "bmp":Landroid/graphics/Bitmap;
    const/16 v40, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v40

    invoke-direct {v0, v8, v1}, Lco/vine/android/SettingsFragment;->setImage(Landroid/graphics/Bitmap;Z)V

    goto/16 :goto_1

    .line 378
    .end local v8    # "bmp":Landroid/graphics/Bitmap;
    .end local v14    # "dimen":I
    :cond_5
    const/16 v40, 0x0

    const/16 v41, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v40

    move/from16 v2, v41

    invoke-direct {v0, v1, v2}, Lco/vine/android/SettingsFragment;->setImage(Landroid/graphics/Bitmap;Z)V

    goto/16 :goto_1

    .line 524
    .restart local v12    # "content":Landroid/widget/TextView;
    .restart local v16    # "editTextDescription":Landroid/widget/EditText;
    .restart local v17    # "editTextEmail":Lco/vine/android/widget/TypingEditText;
    .restart local v18    # "editTextLocation":Landroid/widget/EditText;
    .restart local v19    # "editTextName":Landroid/widget/EditText;
    .restart local v20    # "editTextPhone":Lco/vine/android/widget/TypingEditText;
    .restart local v28    # "password":Landroid/widget/TextView;
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mAlertIcon:Landroid/widget/ImageView;

    move-object/from16 v40, v0

    const/16 v41, 0x8

    invoke-virtual/range {v40 .. v41}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 529
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SettingsFragment;->mNotifications:Landroid/view/ViewGroup;

    move-object/from16 v40, v0

    const/16 v41, 0x8

    invoke-virtual/range {v40 .. v41}, Landroid/view/ViewGroup;->setVisibility(I)V

    goto/16 :goto_3

    .line 559
    .restart local v4    # "acc":Landroid/accounts/Account;
    .restart local v5    # "am":Landroid/accounts/AccountManager;
    .restart local v23    # "findFriends":Landroid/widget/TextView;
    .restart local v24    # "inviteViaEmail":Landroid/widget/TextView;
    .restart local v25    # "inviteViaText":Landroid/widget/TextView;
    .restart local v36    # "twitterConnect":Landroid/widget/RelativeLayout;
    .restart local v37    # "twitterConnectedTextView":Landroid/widget/TextView;
    :cond_8
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/SettingsFragment;->mTwitterConnected:Z

    move/from16 v40, v0

    if-eqz v40, :cond_9

    .line 561
    const-string v40, ""

    move-object/from16 v0, v37

    move-object/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 562
    const/16 v40, 0x1

    move/from16 v0, v40

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/SettingsFragment;->mTwitterLogin:Z

    goto/16 :goto_4

    .line 564
    :cond_9
    const v40, 0x7f0e01d9

    move-object/from16 v0, v37

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 565
    const/16 v40, 0x0

    move/from16 v0, v40

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/SettingsFragment;->mTwitterLogin:Z

    goto/16 :goto_4

    .line 608
    .restart local v6    # "attribution":Landroid/widget/TextView;
    .restart local v9    # "clearCache":Landroid/widget/RelativeLayout;
    .restart local v10    # "clearCacheLabel":Landroid/widget/TextView;
    .restart local v13    # "deactivateAccount":Landroid/widget/TextView;
    .restart local v21    # "facebookConnect":Landroid/widget/RelativeLayout;
    .restart local v22    # "facebookLabel":Landroid/widget/TextView;
    .restart local v27    # "logout":Landroid/widget/Button;
    .restart local v31    # "privacyPolicy":Landroid/widget/TextView;
    .restart local v34    # "termsOfService":Landroid/widget/TextView;
    .restart local v35    # "tv":Landroid/widget/TextView;
    .restart local v39    # "version":Landroid/widget/LinearLayout;
    :catch_0
    move-exception v15

    .line 609
    .local v15, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v40, "SettingsFragment"

    const-string v41, "Error retrieving package info:"

    move-object/from16 v0, v40

    move-object/from16 v1, v41

    invoke-static {v0, v1, v15}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_5
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 10
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    const/4 v9, 0x5

    const/4 v8, 0x3

    const/4 v7, 0x1

    const v6, 0x7f0f0037

    const/4 v5, 0x0

    .line 1194
    packed-switch p2, :pswitch_data_0

    .line 1369
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 1196
    :pswitch_1
    packed-switch p3, :pswitch_data_1

    :pswitch_2
    goto :goto_0

    .line 1202
    :pswitch_3
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    invoke-virtual {v4, v9}, Lco/vine/android/ImagePicker;->chooseImage(I)V

    goto :goto_0

    .line 1198
    :pswitch_4
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    invoke-virtual {v4, v8}, Lco/vine/android/ImagePicker;->captureImage(I)V

    goto :goto_0

    .line 1209
    :pswitch_5
    packed-switch p3, :pswitch_data_2

    goto :goto_0

    .line 1211
    :pswitch_6
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mFbSession:Lcom/facebook/Session;

    if-eqz v4, :cond_1

    .line 1212
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mFbSession:Lcom/facebook/Session;

    invoke-virtual {v4}, Lcom/facebook/Session;->closeAndClearTokenInformation()V

    .line 1213
    const/4 v4, 0x0

    iput-object v4, p0, Lco/vine/android/SettingsFragment;->mFbSession:Lcom/facebook/Session;

    .line 1215
    :cond_1
    invoke-direct {p0}, Lco/vine/android/SettingsFragment;->invalidateFacebookSessionUI()V

    goto :goto_0

    .line 1221
    :pswitch_7
    packed-switch p3, :pswitch_data_3

    goto :goto_0

    .line 1229
    :pswitch_8
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    invoke-virtual {v4, v8}, Lco/vine/android/ImagePicker;->captureImage(I)V

    goto :goto_0

    .line 1223
    :pswitch_9
    const/4 v4, 0x0

    invoke-virtual {p0, v4}, Lco/vine/android/SettingsFragment;->setThumbnailImage(Landroid/graphics/Bitmap;)V

    .line 1224
    iput-boolean v7, p0, Lco/vine/android/SettingsFragment;->mPhotoChanged:Z

    .line 1225
    const-string v4, ""

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    goto :goto_0

    .line 1233
    :pswitch_a
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mImagePicker:Lco/vine/android/ImagePicker;

    invoke-virtual {v4, v9}, Lco/vine/android/ImagePicker;->chooseImage(I)V

    goto :goto_0

    .line 1240
    :pswitch_b
    packed-switch p3, :pswitch_data_4

    goto :goto_0

    .line 1242
    :pswitch_c
    invoke-direct {p0}, Lco/vine/android/SettingsFragment;->resetPrefs()V

    .line 1243
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 1244
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_0

    .line 1245
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_0

    .line 1256
    .end local v0    # "activity":Landroid/support/v4/app/FragmentActivity;
    :pswitch_d
    packed-switch p3, :pswitch_data_5

    goto :goto_0

    .line 1258
    :pswitch_e
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackLogout()V

    .line 1259
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mFbSession:Lcom/facebook/Session;

    if-eqz v4, :cond_2

    .line 1260
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mFbSession:Lcom/facebook/Session;

    invoke-virtual {v4}, Lcom/facebook/Session;->closeAndClearTokenInformation()V

    .line 1262
    :cond_2
    invoke-direct {p0}, Lco/vine/android/SettingsFragment;->invalidateFacebookSessionUI()V

    .line 1263
    new-instance v1, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v1, v4, v6}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 1265
    .local v1, "d":Landroid/app/ProgressDialog;
    const v4, 0x7f0e011e

    invoke-virtual {p0, v4}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 1266
    invoke-virtual {v1, v5}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 1267
    invoke-virtual {v1}, Landroid/app/ProgressDialog;->show()V

    .line 1268
    iput-object v1, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    .line 1269
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v5, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    invoke-virtual {v4, v5}, Lco/vine/android/client/AppController;->logout(Lco/vine/android/client/Session;)Ljava/lang/String;

    goto/16 :goto_0

    .line 1279
    .end local v1    # "d":Landroid/app/ProgressDialog;
    :pswitch_f
    packed-switch p3, :pswitch_data_6

    goto/16 :goto_0

    .line 1281
    :pswitch_10
    new-instance v1, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v1, v4, v6}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 1283
    .restart local v1    # "d":Landroid/app/ProgressDialog;
    const v4, 0x7f0e01e6

    invoke-virtual {p0, v4}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 1284
    invoke-virtual {v1, v5}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 1285
    invoke-virtual {v1}, Landroid/app/ProgressDialog;->show()V

    .line 1286
    iput-object v1, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    .line 1287
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v5, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    invoke-virtual {v4, v5}, Lco/vine/android/client/AppController;->disconnectTwitter(Lco/vine/android/client/Session;)Ljava/lang/String;

    goto/16 :goto_0

    .line 1297
    .end local v1    # "d":Landroid/app/ProgressDialog;
    :pswitch_11
    packed-switch p3, :pswitch_data_7

    goto/16 :goto_0

    .line 1299
    :pswitch_12
    new-instance v1, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v1, v4, v6}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 1301
    .restart local v1    # "d":Landroid/app/ProgressDialog;
    const v4, 0x7f0e01d7

    invoke-virtual {p0, v4}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 1302
    invoke-virtual {v1, v5}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 1303
    invoke-virtual {v1}, Landroid/app/ProgressDialog;->show()V

    .line 1304
    iput-object v1, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    .line 1305
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4, v7}, Lco/vine/android/client/AppController;->clearDbCache(Z)Ljava/lang/String;

    goto/16 :goto_0

    .line 1315
    .end local v1    # "d":Landroid/app/ProgressDialog;
    :pswitch_13
    packed-switch p3, :pswitch_data_8

    goto/16 :goto_0

    .line 1317
    :pswitch_14
    new-instance v1, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v1, v4, v6}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 1319
    .restart local v1    # "d":Landroid/app/ProgressDialog;
    const v4, 0x7f0e01e1

    invoke-virtual {p0, v4}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 1320
    invoke-virtual {v1, v5}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 1321
    invoke-virtual {v1}, Landroid/app/ProgressDialog;->show()V

    .line 1322
    iput-object v1, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    .line 1323
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->deactivateAccount()Ljava/lang/String;

    goto/16 :goto_0

    .line 1333
    .end local v1    # "d":Landroid/app/ProgressDialog;
    :pswitch_15
    packed-switch p3, :pswitch_data_9

    goto/16 :goto_0

    .line 1335
    :pswitch_16
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mEditTextPhone:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    .line 1336
    .local v3, "phone":Ljava/lang/CharSequence;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 1337
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v5, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v7}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v7

    invoke-virtual {v4, v5, v6, v7, v8}, Lco/vine/android/client/AppController;->requestPhoneVerification(Lco/vine/android/client/Session;Ljava/lang/String;J)Ljava/lang/String;

    goto/16 :goto_0

    .line 1350
    .end local v3    # "phone":Ljava/lang/CharSequence;
    :pswitch_17
    packed-switch p3, :pswitch_data_a

    goto/16 :goto_0

    .line 1352
    :pswitch_18
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mEditTextEmail:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    .line 1353
    .local v2, "email":Ljava/lang/CharSequence;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 1354
    iget-object v4, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v5, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v7}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v7

    invoke-virtual {v4, v5, v6, v7, v8}, Lco/vine/android/client/AppController;->requestEmailVerification(Lco/vine/android/client/Session;Ljava/lang/String;J)Ljava/lang/String;

    goto/16 :goto_0

    .line 1194
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_7
        :pswitch_b
        :pswitch_d
        :pswitch_f
        :pswitch_11
        :pswitch_13
        :pswitch_17
        :pswitch_15
        :pswitch_0
        :pswitch_5
    .end packed-switch

    .line 1196
    :pswitch_data_1
    .packed-switch -0x3
        :pswitch_3
        :pswitch_2
        :pswitch_4
    .end packed-switch

    .line 1209
    :pswitch_data_2
    .packed-switch -0x1
        :pswitch_6
    .end packed-switch

    .line 1221
    :pswitch_data_3
    .packed-switch -0x3
        :pswitch_8
        :pswitch_a
        :pswitch_9
    .end packed-switch

    .line 1240
    :pswitch_data_4
    .packed-switch -0x1
        :pswitch_c
    .end packed-switch

    .line 1256
    :pswitch_data_5
    .packed-switch -0x1
        :pswitch_e
    .end packed-switch

    .line 1279
    :pswitch_data_6
    .packed-switch -0x1
        :pswitch_10
    .end packed-switch

    .line 1297
    :pswitch_data_7
    .packed-switch -0x1
        :pswitch_12
    .end packed-switch

    .line 1315
    :pswitch_data_8
    .packed-switch -0x1
        :pswitch_14
    .end packed-switch

    .line 1333
    :pswitch_data_9
    .packed-switch -0x1
        :pswitch_16
    .end packed-switch

    .line 1350
    :pswitch_data_a
    .packed-switch -0x1
        :pswitch_18
    .end packed-switch
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 1
    .param p2, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 677
    .local p1, "cursorLoader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    iget-boolean v0, p0, Lco/vine/android/SettingsFragment;->mEditionsFetched:Z

    if-nez v0, :cond_0

    .line 678
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->getEditions()V

    .line 679
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/SettingsFragment;->mEditionsFetched:Z

    .line 681
    :cond_0
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mSpinnerAdapter:Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;

    invoke-virtual {v0, p2}, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 682
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mSpinnerAdapter:Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->setSelectionToUserEdition()V

    .line 683
    return-void
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 87
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/SettingsFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/support/v4/content/Loader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 686
    .local p1, "cursorLoader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 1172
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 1187
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 1174
    :pswitch_0
    invoke-direct {p0}, Lco/vine/android/SettingsFragment;->isDirty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1175
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    invoke-direct {p0, v0}, Lco/vine/android/SettingsFragment;->updateProfile(Landroid/net/Uri;)V

    .line 1184
    :cond_0
    :goto_1
    const/4 v0, 0x1

    goto :goto_0

    .line 1177
    :cond_1
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_2

    .line 1178
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 1180
    :cond_2
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1181
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_1

    .line 1172
    :pswitch_data_0
    .packed-switch 0x7f0a0245
        :pswitch_0
    .end packed-switch
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 216
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onPause()V

    .line 217
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    .line 218
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 220
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 285
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onResume()V

    .line 286
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->fetchUsersMe(J)Ljava/lang/String;

    .line 287
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mSpinnerAdapter:Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->getCursor()Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_1

    .line 288
    invoke-virtual {p0}, Lco/vine/android/SettingsFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p0}, Landroid/support/v4/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 293
    :cond_0
    :goto_0
    return-void

    .line 289
    :cond_1
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mSpinnerAdapter:Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment$EditionsSpinnerAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/SettingsFragment;->mEditionsFetched:Z

    if-nez v0, :cond_0

    .line 290
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/SettingsFragment;->mEditionsFetched:Z

    .line 291
    iget-object v0, p0, Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->getEditions()V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 224
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 225
    const-string v0, "state_name"

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    const-string v0, "state_desc"

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mDescription:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 227
    const-string v0, "state_loc"

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mLocation:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 228
    const-string v0, "state_phone"

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mPhone:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 229
    const-string v0, "state_email"

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    const-string v0, "state_edition"

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mEdition:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 231
    const-string v0, "state_editions_fetched"

    iget-boolean v1, p0, Lco/vine/android/SettingsFragment;->mEditionsFetched:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 232
    const-string v0, "state_avatar_url"

    iget-object v1, p0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 233
    const-string v0, "state_background_color"

    iget v1, p0, Lco/vine/android/SettingsFragment;->mBackgroundColor:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 234
    const-string v0, "state_color_index"

    iget v1, p0, Lco/vine/android/SettingsFragment;->mColorIndex:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 235
    return-void
.end method

.method public onTypingTimeout(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 690
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 700
    :goto_0
    return-void

    .line 693
    :sswitch_0
    invoke-direct {p0}, Lco/vine/android/SettingsFragment;->updateVerificationIcons()V

    goto :goto_0

    .line 690
    :sswitch_data_0
    .sparse-switch
        0x7f0a01e8 -> :sswitch_0
        0x7f0a0219 -> :sswitch_0
    .end sparse-switch
.end method

.method public setAvatarUrl(Landroid/net/Uri;)V
    .locals 0
    .param p1, "url"    # Landroid/net/Uri;

    .prologue
    .line 1161
    iput-object p1, p0, Lco/vine/android/SettingsFragment;->mAvatarUri:Landroid/net/Uri;

    .line 1162
    return-void
.end method

.method public setThumbnailImage(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 970
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lco/vine/android/SettingsFragment;->setImage(Landroid/graphics/Bitmap;Z)V

    .line 971
    return-void
.end method
