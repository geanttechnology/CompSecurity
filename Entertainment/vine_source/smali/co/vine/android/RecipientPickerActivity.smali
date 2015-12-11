.class public Lco/vine/android/RecipientPickerActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "RecipientPickerActivity.java"

# interfaces
.implements Landroid/widget/TabHost$OnTabChangeListener;
.implements Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;
.implements Landroid/text/TextWatcher;
.implements Lco/vine/android/widget/TypefacesEditText$KeyboardListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/RecipientPickerActivity$RecipientItemClickListener;
    }
.end annotation


# static fields
.field public static final ARG_TAG:Ljava/lang/String; = "tag"

.field public static final EXTRA_IS_VM_ONBOARDING:Ljava/lang/String; = "is_vm_onboarding"

.field public static final EXTRA_MAX_LOOPS:Ljava/lang/String; = "max_loops"

.field public static final EXTRA_MESSAGE:Ljava/lang/String; = "message"

.field public static final EXTRA_POST_ID:Ljava/lang/String; = "post_id"

.field public static final EXTRA_PREVIEW_PATH:Ljava/lang/String; = "preview_path"

.field public static final EXTRA_SHARED_THUMB_URL:Ljava/lang/String; = "thumb_url"

.field public static final EXTRA_SHARED_VIDEO_URL:Ljava/lang/String; = "vid_url"

.field public static final EXTRA_THUMBNAIL_PATH:Ljava/lang/String; = "thumbnail_path"

.field public static final EXTRA_VIDEO_PATH:Ljava/lang/String; = "video_path"

.field private static final OVERFLOW_INDEX:I = 0x3

.field public static final TAG_ADDRESS_BOOK:Ljava/lang/String; = "address_book"

.field public static final TAG_FRIENDS:Ljava/lang/String; = "friends"


# instance fields
.field private isForcingFullList:Z

.field private mCaptionMessage:Ljava/lang/String;

.field private mDensity:F

.field private mFlowLayout:Lco/vine/android/views/FlowLayout;

.field private mIsVmOnboarding:Z

.field private final mLastExtra:Lco/vine/android/api/VineRecipient;

.field private mMaxLoops:I

.field private mOnboardingOverlay:Landroid/widget/TextView;

.field private mOverFlowView:Landroid/view/View;

.field private mPostId:J

.field private mProfileColor:I

.field private mQuery:Landroid/widget/EditText;

.field private mQueryHint:Ljava/lang/CharSequence;

.field private final mRecipients:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;"
        }
    .end annotation
.end field

.field private final mRecycledViews:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mSelectedForRemoval:I

.field private mSendButton:Landroid/widget/ImageView;

.field private mSharedThumbnailUrl:Ljava/lang/String;

.field private mSharedVideoUrl:Ljava/lang/String;

.field private mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

.field private mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

.field private mVideoPath:Ljava/lang/String;

.field private mViewPager:Landroid/support/v4/view/ViewPager;

.field private mVineGreen:I

.field private final mVmOnboardingFadeListener:Landroid/view/animation/Animation$AnimationListener;


# direct methods
.method public constructor <init>()V
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 55
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    .line 60
    const-wide/16 v1, -0x1

    const-wide/16 v4, 0x0

    move-object v3, v0

    invoke-static/range {v0 .. v5}, Lco/vine/android/api/VineRecipient;->fromEmail(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mLastExtra:Lco/vine/android/api/VineRecipient;

    .line 90
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    .line 91
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecycledViews:Ljava/util/ArrayList;

    .line 98
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    .line 235
    new-instance v0, Lco/vine/android/RecipientPickerActivity$3;

    invoke-direct {v0, p0}, Lco/vine/android/RecipientPickerActivity$3;-><init>(Lco/vine/android/RecipientPickerActivity;)V

    iput-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mVmOnboardingFadeListener:Landroid/view/animation/Animation$AnimationListener;

    .line 563
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/RecipientPickerActivity;)Landroid/view/animation/Animation$AnimationListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecipientPickerActivity;

    .prologue
    .line 55
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mVmOnboardingFadeListener:Landroid/view/animation/Animation$AnimationListener;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/RecipientPickerActivity;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecipientPickerActivity;

    .prologue
    .line 55
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mOnboardingOverlay:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/RecipientPickerActivity;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecipientPickerActivity;

    .prologue
    .line 55
    iget v0, p0, Lco/vine/android/RecipientPickerActivity;->mProfileColor:I

    return v0
.end method

.method private addSendIcon()V
    .locals 10

    .prologue
    const-wide v8, 0x4042400000000000L    # 36.5

    .line 265
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 266
    .local v3, "res":Landroid/content/res/Resources;
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->getFakeActionBar()Lco/vine/android/widget/FakeActionBar;

    move-result-object v0

    .line 267
    .local v0, "fakeActionBar":Lco/vine/android/widget/FakeActionBar;
    const v5, 0x7f090057

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    .line 268
    .local v1, "gray":I
    new-instance v4, Lco/vine/android/RecipientPickerActivity$4;

    invoke-direct {v4, p0, p0, v1}, Lco/vine/android/RecipientPickerActivity$4;-><init>(Lco/vine/android/RecipientPickerActivity;Landroid/content/Context;I)V

    .line 275
    .local v4, "sendButton":Landroid/widget/ImageView;
    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    iget v5, p0, Lco/vine/android/RecipientPickerActivity;->mDensity:F

    float-to-double v5, v5

    mul-double/2addr v5, v8

    double-to-int v5, v5

    iget v6, p0, Lco/vine/android/RecipientPickerActivity;->mDensity:F

    float-to-double v6, v6

    mul-double/2addr v6, v8

    double-to-int v6, v6

    invoke-direct {v2, v5, v6}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 276
    .local v2, "params":Landroid/view/ViewGroup$LayoutParams;
    const v5, 0x7f020137

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 277
    new-instance v5, Lco/vine/android/RecipientPickerActivity$5;

    invoke-direct {v5, p0}, Lco/vine/android/RecipientPickerActivity$5;-><init>(Lco/vine/android/RecipientPickerActivity;)V

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 283
    invoke-virtual {v4, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 284
    sget-object v5, Landroid/widget/ImageView$ScaleType;->CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 285
    invoke-virtual {v0}, Lco/vine/android/widget/FakeActionBar;->getActionBarRight()Landroid/widget/LinearLayout;

    move-result-object v5

    invoke-virtual {v5, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 286
    iput-object v4, p0, Lco/vine/android/RecipientPickerActivity;->mSendButton:Landroid/widget/ImageView;

    .line 287
    iget-object v5, p0, Lco/vine/android/RecipientPickerActivity;->mSendButton:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->isSendButtonEnabled()Z

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setEnabled(Z)V

    .line 288
    return-void
.end method

.method private bindOrCreateViewForRecipient(ILandroid/view/View;Lco/vine/android/api/VineRecipient;Z)Landroid/view/View;
    .locals 9
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "recipient"    # Lco/vine/android/api/VineRecipient;
    .param p4, "isSelected"    # Z

    .prologue
    const/high16 v8, 0x40000000    # 2.0f

    const/high16 v7, -0x1000000

    const/4 v6, 0x0

    .line 585
    if-nez p2, :cond_0

    .line 586
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v3

    const v4, 0x7f030081

    iget-object v5, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v3, v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    :cond_0
    move-object v3, p2

    .line 589
    check-cast v3, Landroid/widget/RelativeLayout;

    invoke-virtual {v3, v6}, Landroid/widget/RelativeLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/TypefacesTextView;

    .line 591
    .local v1, "displayTextView":Lco/vine/android/widget/TypefacesTextView;
    new-instance v3, Lco/vine/android/RecipientPickerActivity$RecipientItemClickListener;

    invoke-direct {v3, p0, p3, p1}, Lco/vine/android/RecipientPickerActivity$RecipientItemClickListener;-><init>(Lco/vine/android/RecipientPickerActivity;Lco/vine/android/api/VineRecipient;I)V

    invoke-virtual {v1, v3}, Lco/vine/android/widget/TypefacesTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 593
    iget v3, p3, Lco/vine/android/api/VineRecipient;->color:I

    if-lez v3, :cond_1

    iget v3, p3, Lco/vine/android/api/VineRecipient;->color:I

    sget v4, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-ne v3, v4, :cond_2

    .line 594
    :cond_1
    iget v3, p0, Lco/vine/android/RecipientPickerActivity;->mVineGreen:I

    iput v3, p3, Lco/vine/android/api/VineRecipient;->color:I

    .line 597
    :cond_2
    invoke-virtual {v1}, Lco/vine/android/widget/TypefacesTextView;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 601
    .local v0, "bg":Landroid/graphics/drawable/Drawable;
    instance-of v3, v0, Landroid/graphics/drawable/GradientDrawable;

    if-nez v3, :cond_3

    .line 602
    new-instance v2, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v2}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    .line 603
    .local v2, "gbg":Landroid/graphics/drawable/GradientDrawable;
    invoke-virtual {v2, v6}, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V

    .line 604
    iget v3, p0, Lco/vine/android/RecipientPickerActivity;->mDensity:F

    mul-float/2addr v3, v8

    invoke-virtual {v2, v3}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V

    .line 609
    :goto_0
    if-eqz p4, :cond_4

    .line 610
    iget v3, p0, Lco/vine/android/RecipientPickerActivity;->mDensity:F

    mul-float/2addr v3, v8

    float-to-int v3, v3

    iget v4, p3, Lco/vine/android/api/VineRecipient;->color:I

    or-int/2addr v4, v7

    invoke-virtual {v2, v3, v4}, Landroid/graphics/drawable/GradientDrawable;->setStroke(II)V

    .line 611
    invoke-virtual {v2, v6}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 612
    iget v3, p3, Lco/vine/android/api/VineRecipient;->color:I

    or-int/2addr v3, v7

    invoke-virtual {v1, v3}, Lco/vine/android/widget/TypefacesTextView;->setTextColor(I)V

    .line 632
    :goto_1
    invoke-static {v1, v2}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 633
    iget-object v3, p3, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    invoke-virtual {v1, v3}, Lco/vine/android/widget/TypefacesTextView;->setText(Ljava/lang/CharSequence;)V

    .line 635
    return-object p2

    .end local v2    # "gbg":Landroid/graphics/drawable/GradientDrawable;
    :cond_3
    move-object v2, v0

    .line 606
    check-cast v2, Landroid/graphics/drawable/GradientDrawable;

    .restart local v2    # "gbg":Landroid/graphics/drawable/GradientDrawable;
    goto :goto_0

    .line 614
    :cond_4
    invoke-virtual {v2, v6, v6}, Landroid/graphics/drawable/GradientDrawable;->setStroke(II)V

    .line 615
    iget v3, p3, Lco/vine/android/api/VineRecipient;->color:I

    or-int/2addr v3, v7

    invoke-virtual {v2, v3}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 630
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090083

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v1, v3}, Lco/vine/android/widget/TypefacesTextView;->setTextColor(I)V

    goto :goto_1
.end method

.method public static getIntent(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 2
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "postId"    # J
    .param p3, "vidUrl"    # Ljava/lang/String;
    .param p4, "thumbUrl"    # Ljava/lang/String;

    .prologue
    .line 482
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/RecipientPickerActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 483
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 484
    const-string v1, "vid_url"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 485
    const-string v1, "thumb_url"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 486
    return-object v0
.end method

.method public static getIntent(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Landroid/content/Intent;
    .locals 2
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "videoPath"    # Ljava/lang/String;
    .param p3, "thumbnailPath"    # Ljava/lang/String;
    .param p4, "previewPath"    # Ljava/lang/String;
    .param p5, "maxLoops"    # I
    .param p6, "isVmOnboarding"    # Z

    .prologue
    .line 491
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/RecipientPickerActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 492
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "message"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 493
    const-string v1, "video_path"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 494
    const-string v1, "thumbnail_path"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 495
    const-string v1, "preview_path"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 496
    const-string v1, "max_loops"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 497
    const-string v1, "is_vm_onboarding"

    invoke-virtual {v0, v1, p6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 498
    return-object v0
.end method

.method private invalidateDisplayForExtra(I)V
    .locals 5
    .param p1, "n"    # I

    .prologue
    const/4 v2, 0x1

    .line 354
    if-ne p1, v2, :cond_0

    .line 355
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mLastExtra:Lco/vine/android/api/VineRecipient;

    const v1, 0x7f0e004d

    invoke-virtual {p0, v1}, Lco/vine/android/RecipientPickerActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    .line 359
    :goto_0
    return-void

    .line 357
    :cond_0
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mLastExtra:Lco/vine/android/api/VineRecipient;

    const v1, 0x7f0e004c

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {p0, v1, v2}, Lco/vine/android/RecipientPickerActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    goto :goto_0
.end method

.method private invalidateEditTextUI(ILco/vine/android/api/VineRecipient;ZZ)V
    .locals 10
    .param p1, "index"    # I
    .param p2, "recipient"    # Lco/vine/android/api/VineRecipient;
    .param p3, "isAdding"    # Z
    .param p4, "wasInOverflowMode"    # Z

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x2

    const/4 v7, 0x3

    const/4 v6, 0x0

    .line 362
    const-string v2, "Invalidate UI: adding: {}, original index: {}, wasOverflow: {}."

    invoke-static {p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {p4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-static {v2, v3, v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 363
    const-string v2, "Before child count: {}."

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v3}, Lco/vine/android/views/FlowLayout;->getChildCount()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 364
    if-eqz p3, :cond_3

    .line 365
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->isInOverflowMode()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 366
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x3

    invoke-direct {p0, v2}, Lco/vine/android/RecipientPickerActivity;->invalidateDisplayForExtra(I)V

    .line 367
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mOverFlowView:Landroid/view/View;

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mLastExtra:Lco/vine/android/api/VineRecipient;

    invoke-direct {p0, p1, v2, v3, v6}, Lco/vine/android/RecipientPickerActivity;->bindOrCreateViewForRecipient(ILandroid/view/View;Lco/vine/android/api/VineRecipient;Z)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mOverFlowView:Landroid/view/View;

    .line 368
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v2}, Lco/vine/android/views/FlowLayout;->getChildCount()I

    move-result v2

    const/4 v3, 0x4

    if-gt v2, v3, :cond_0

    .line 369
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mOverFlowView:Landroid/view/View;

    invoke-virtual {v2, v3, v7}, Lco/vine/android/views/FlowLayout;->addView(Landroid/view/View;I)V

    .line 413
    :cond_0
    :goto_0
    const-string v2, "After child count: {}."

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v3}, Lco/vine/android/views/FlowLayout;->getChildCount()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 414
    return-void

    .line 373
    :cond_1
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecycledViews:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 374
    invoke-direct {p0, p1, v9, p2, v6}, Lco/vine/android/RecipientPickerActivity;->bindOrCreateViewForRecipient(ILandroid/view/View;Lco/vine/android/api/VineRecipient;Z)Landroid/view/View;

    move-result-object v1

    .line 378
    .local v1, "viewToAdd":Landroid/view/View;
    :goto_1
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v3}, Lco/vine/android/views/FlowLayout;->getChildCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v2, v1, v3}, Lco/vine/android/views/FlowLayout;->addView(Landroid/view/View;I)V

    goto :goto_0

    .line 376
    .end local v1    # "viewToAdd":Landroid/view/View;
    :cond_2
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecycledViews:Ljava/util/ArrayList;

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mRecycledViews:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    invoke-direct {p0, p1, v2, p2, v6}, Lco/vine/android/RecipientPickerActivity;->bindOrCreateViewForRecipient(ILandroid/view/View;Lco/vine/android/api/VineRecipient;Z)Landroid/view/View;

    move-result-object v1

    .restart local v1    # "viewToAdd":Landroid/view/View;
    goto :goto_1

    .line 381
    .end local v1    # "viewToAdd":Landroid/view/View;
    :cond_3
    if-eqz p4, :cond_7

    .line 382
    if-ge p1, v7, :cond_6

    .line 383
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v2, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineRecipient;

    .line 384
    .local v0, "recipientToAdd":Lco/vine/android/api/VineRecipient;
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecycledViews:Ljava/util/ArrayList;

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v3, p1}, Lco/vine/android/views/FlowLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 385
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v2, p1}, Lco/vine/android/views/FlowLayout;->removeViewAt(I)V

    .line 387
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecycledViews:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 388
    invoke-direct {p0, p1, v9, v0, v6}, Lco/vine/android/RecipientPickerActivity;->bindOrCreateViewForRecipient(ILandroid/view/View;Lco/vine/android/api/VineRecipient;Z)Landroid/view/View;

    move-result-object v1

    .line 392
    .restart local v1    # "viewToAdd":Landroid/view/View;
    :goto_2
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v2, v1, v8}, Lco/vine/android/views/FlowLayout;->addView(Landroid/view/View;I)V

    .line 393
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->isInOverflowMode()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 394
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x3

    invoke-direct {p0, v2}, Lco/vine/android/RecipientPickerActivity;->invalidateDisplayForExtra(I)V

    .line 395
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mOverFlowView:Landroid/view/View;

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mLastExtra:Lco/vine/android/api/VineRecipient;

    invoke-direct {p0, p1, v2, v3, v6}, Lco/vine/android/RecipientPickerActivity;->bindOrCreateViewForRecipient(ILandroid/view/View;Lco/vine/android/api/VineRecipient;Z)Landroid/view/View;

    .line 405
    .end local v0    # "recipientToAdd":Lco/vine/android/api/VineRecipient;
    .end local v1    # "viewToAdd":Landroid/view/View;
    :cond_4
    :goto_3
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->isInOverflowMode()Z

    move-result v2

    if-nez v2, :cond_0

    .line 406
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mOverFlowView:Landroid/view/View;

    invoke-virtual {v2, v3}, Lco/vine/android/views/FlowLayout;->removeView(Landroid/view/View;)V

    goto/16 :goto_0

    .line 390
    .restart local v0    # "recipientToAdd":Lco/vine/android/api/VineRecipient;
    :cond_5
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecycledViews:Ljava/util/ArrayList;

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mRecycledViews:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    invoke-direct {p0, p1, v2, v0, v6}, Lco/vine/android/RecipientPickerActivity;->bindOrCreateViewForRecipient(ILandroid/view/View;Lco/vine/android/api/VineRecipient;Z)Landroid/view/View;

    move-result-object v1

    .restart local v1    # "viewToAdd":Landroid/view/View;
    goto :goto_2

    .line 398
    .end local v0    # "recipientToAdd":Lco/vine/android/api/VineRecipient;
    .end local v1    # "viewToAdd":Landroid/view/View;
    :cond_6
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->isInOverflowMode()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 399
    if-eq p1, v7, :cond_4

    .line 400
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x3

    invoke-direct {p0, v2}, Lco/vine/android/RecipientPickerActivity;->invalidateDisplayForExtra(I)V

    .line 401
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mOverFlowView:Landroid/view/View;

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mLastExtra:Lco/vine/android/api/VineRecipient;

    invoke-direct {p0, p1, v2, v3, v6}, Lco/vine/android/RecipientPickerActivity;->bindOrCreateViewForRecipient(ILandroid/view/View;Lco/vine/android/api/VineRecipient;Z)Landroid/view/View;

    goto :goto_3

    .line 409
    :cond_7
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecycledViews:Ljava/util/ArrayList;

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v3, p1}, Lco/vine/android/views/FlowLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 410
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v2, p1}, Lco/vine/android/views/FlowLayout;->removeViewAt(I)V

    goto/16 :goto_0
.end method

.method private notifyItemRemoval(Lco/vine/android/api/VineRecipient;)V
    .locals 4
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 666
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v1

    .line 667
    .local v1, "fragments":Ljava/util/List;, "Ljava/util/List<Landroid/support/v4/app/Fragment;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 668
    .local v0, "f":Landroid/support/v4/app/Fragment;
    instance-of v3, v0, Lco/vine/android/BaseRecipientPickerFragment;

    if-eqz v3, :cond_0

    .line 669
    check-cast v0, Lco/vine/android/BaseRecipientPickerFragment;

    .end local v0    # "f":Landroid/support/v4/app/Fragment;
    invoke-virtual {v0, p1}, Lco/vine/android/BaseRecipientPickerFragment;->onRecipientItemRemoved(Lco/vine/android/api/VineRecipient;)V

    goto :goto_0

    .line 672
    :cond_1
    return-void
.end method

.method private setItemForRemoval(I)V
    .locals 4
    .param p1, "index"    # I

    .prologue
    .line 652
    iget v0, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    if-ltz v0, :cond_0

    .line 653
    iget v1, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    iget v2, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    invoke-virtual {v0, v2}, Lco/vine/android/views/FlowLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    iget v3, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineRecipient;

    const/4 v3, 0x0

    invoke-direct {p0, v1, v2, v0, v3}, Lco/vine/android/RecipientPickerActivity;->bindOrCreateViewForRecipient(ILandroid/view/View;Lco/vine/android/api/VineRecipient;Z)Landroid/view/View;

    .line 657
    :cond_0
    if-ltz p1, :cond_1

    .line 658
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v0, p1}, Lco/vine/android/views/FlowLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineRecipient;

    const/4 v2, 0x1

    invoke-direct {p0, p1, v1, v0, v2}, Lco/vine/android/RecipientPickerActivity;->bindOrCreateViewForRecipient(ILandroid/view/View;Lco/vine/android/api/VineRecipient;Z)Landroid/view/View;

    .line 662
    :cond_1
    iput p1, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    .line 663
    return-void
.end method


# virtual methods
.method public addRecipient(Lco/vine/android/api/VineRecipient;)V
    .locals 5
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 295
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->isInOverflowMode()Z

    move-result v0

    .line 296
    .local v0, "wasInOverFlowMode":Z
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 297
    const-string v1, "Recipient added: {} {} {}"

    iget-object v2, p1, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    iget-wide v3, p1, Lco/vine/android/api/VineRecipient;->userId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iget-object v4, p1, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    invoke-static {v1, v2, v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 298
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getHint()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 299
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getHint()Ljava/lang/CharSequence;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mQueryHint:Ljava/lang/CharSequence;

    .line 300
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    const-string v2, ""

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 302
    :cond_0
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 303
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    const-string v2, ""

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 305
    :cond_1
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    const/4 v2, 0x1

    invoke-direct {p0, v1, p1, v2, v0}, Lco/vine/android/RecipientPickerActivity;->invalidateEditTextUI(ILco/vine/android/api/VineRecipient;ZZ)V

    .line 306
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mSendButton:Landroid/widget/ImageView;

    if-eqz v1, :cond_2

    .line 307
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mSendButton:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->isSendButtonEnabled()Z

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setEnabled(Z)V

    .line 309
    :cond_2
    return-void
.end method

.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "editable"    # Landroid/text/Editable;

    .prologue
    .line 518
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 514
    return-void
.end method

.method public getCount()I
    .locals 2

    .prologue
    .line 675
    iget-boolean v0, p0, Lco/vine/android/RecipientPickerActivity;->isForcingFullList:Z

    if-eqz v0, :cond_0

    .line 676
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 678
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x3

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    goto :goto_0
.end method

.method public isFakeActionBarEnabled()Z
    .locals 1

    .prologue
    .line 581
    const/4 v0, 0x1

    return v0
.end method

.method public isInOverflowMode()Z
    .locals 2

    .prologue
    .line 683
    iget-boolean v0, p0, Lco/vine/android/RecipientPickerActivity;->isForcingFullList:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->getCount()I

    move-result v1

    if-le v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isRecipientSelected(Lco/vine/android/api/VineRecipient;)Z
    .locals 1
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 327
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isSendButtonEnabled()Z
    .locals 1

    .prologue
    .line 291
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isShowing(Ljava/lang/String;)Z
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 469
    if-eqz p1, :cond_0

    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v0}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 474
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseControllerActionBarActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 475
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 476
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v1, v0, Lco/vine/android/BaseRecipientPickerFragment;

    if-eqz v1, :cond_0

    .line 477
    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 479
    :cond_0
    return-void
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 523
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 524
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 528
    :goto_0
    return-void

    .line 526
    :cond_0
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onBackPressed()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 22
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 107
    const v18, 0x7f03007d

    const/16 v19, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v18

    move/from16 v3, v19

    invoke-super {v0, v1, v2, v3}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 108
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v12

    .line 109
    .local v12, "intent":Landroid/content/Intent;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    const v19, 0x7f090096

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getColor(I)I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/RecipientPickerActivity;->mVineGreen:I

    .line 110
    const-string v18, "video_path"

    move-object/from16 v0, v18

    invoke-virtual {v12, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecipientPickerActivity;->mVideoPath:Ljava/lang/String;

    .line 112
    const/16 v18, 0x0

    invoke-static/range {v18 .. v18}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v18

    const/16 v19, 0x1

    invoke-static/range {v19 .. v19}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v19

    const v20, 0x7f0e01c0

    const/16 v21, 0x1

    invoke-static/range {v21 .. v21}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v21

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    move/from16 v3, v20

    move-object/from16 v4, v21

    invoke-virtual {v0, v1, v2, v3, v4}, Lco/vine/android/RecipientPickerActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 114
    invoke-static/range {p0 .. p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v18

    const-string v19, "profile_background"

    sget v20, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    invoke-interface/range {v18 .. v20}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/RecipientPickerActivity;->mProfileColor:I

    .line 117
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecipientPickerActivity;->mProfileColor:I

    move/from16 v18, v0

    sget v19, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecipientPickerActivity;->mProfileColor:I

    move/from16 v18, v0

    if-gtz v18, :cond_1

    .line 118
    :cond_0
    const v18, 0xffffff

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v19

    const v20, 0x7f090096

    invoke-virtual/range {v19 .. v20}, Landroid/content/res/Resources;->getColor(I)I

    move-result v19

    and-int v18, v18, v19

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/RecipientPickerActivity;->mProfileColor:I

    .line 121
    :cond_1
    const/high16 v18, -0x1000000

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecipientPickerActivity;->mProfileColor:I

    move/from16 v19, v0

    or-int v18, v18, v19

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/RecipientPickerActivity;->mProfileColor:I

    .line 123
    const v18, 0x7f0a011c

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lco/vine/android/RecipientPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    .line 124
    .local v14, "scrollBar":Lco/vine/android/widget/tabs/ViewPagerScrollBar;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecipientPickerActivity;->mProfileColor:I

    move/from16 v18, v0

    move/from16 v0, v18

    invoke-virtual {v14, v0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setLineColor(I)V

    .line 125
    const/16 v18, 0x2

    move/from16 v0, v18

    invoke-virtual {v14, v0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setRange(I)V

    .line 127
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecipientPickerActivity;->mProfileColor:I

    move/from16 v18, v0

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v19

    const v20, 0x7f090057

    invoke-virtual/range {v19 .. v20}, Landroid/content/res/Resources;->getColor(I)I

    move-result v19

    invoke-static/range {v18 .. v19}, Lco/vine/android/widget/tabs/TabIndicator;->createTextColorList(II)Landroid/content/res/ColorStateList;

    move-result-object v9

    .line 129
    .local v9, "indicatorStateList":Landroid/content/res/ColorStateList;
    const v18, 0x7f0a00da

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lco/vine/android/RecipientPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/support/v4/view/ViewPager;

    .line 130
    .local v17, "viewPager":Landroid/support/v4/view/ViewPager;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    const v19, 0x7f0b0054

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v18

    invoke-virtual/range {v17 .. v18}, Landroid/support/v4/view/ViewPager;->setPageMargin(I)V

    .line 131
    const v18, 0x7f09000e

    invoke-virtual/range {v17 .. v18}, Landroid/support/v4/view/ViewPager;->setPageMarginDrawable(I)V

    .line 132
    const/16 v18, 0x1

    invoke-virtual/range {v17 .. v18}, Landroid/support/v4/view/ViewPager;->setOffscreenPageLimit(I)V

    .line 134
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/RecipientPickerActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    .line 135
    .local v15, "tabHost":Lco/vine/android/widget/tabs/IconTabHost;
    new-instance v16, Lco/vine/android/widget/tabs/TabsAdapter;

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    move-object/from16 v2, v17

    invoke-direct {v0, v1, v15, v2, v14}, Lco/vine/android/widget/tabs/TabsAdapter;-><init>(Lco/vine/android/BaseControllerActionBarActivity;Landroid/widget/TabHost;Landroid/support/v4/view/ViewPager;Lco/vine/android/widget/tabs/ViewPagerScrollBar;)V

    .line 136
    .local v16, "tabsAdapter":Lco/vine/android/widget/tabs/TabsAdapter;
    const/16 v18, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lco/vine/android/widget/tabs/TabsAdapter;->setSetActionBarColorOnPageSelectedEnabled(Z)V

    .line 137
    invoke-static/range {p0 .. p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v11

    .line 138
    .local v11, "inflater":Landroid/view/LayoutInflater;
    move-object/from16 v0, p0

    invoke-virtual {v15, v0}, Lco/vine/android/widget/tabs/IconTabHost;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    .line 139
    move-object/from16 v0, p0

    invoke-virtual {v15, v0}, Lco/vine/android/widget/tabs/IconTabHost;->setOnTabClickedListener(Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;)V

    .line 142
    new-instance v7, Landroid/os/Bundle;

    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    .line 143
    .local v7, "friendsBundle":Landroid/os/Bundle;
    const-string v18, "tag"

    const-string v19, "friends"

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v7, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    const-string v18, "refresh"

    const/16 v19, 0x1

    move-object/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v7, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 145
    const-string v18, "empty_desc"

    const v19, 0x7f0e0151

    move-object/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v7, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 147
    const v18, 0x7f030062

    const v19, 0x7f0e023f

    const/16 v20, 0x0

    move/from16 v0, v18

    move/from16 v1, v19

    move/from16 v2, v20

    invoke-static {v11, v0, v15, v1, v2}, Lco/vine/android/widget/tabs/TabIndicator;->newTextIndicator(Landroid/view/LayoutInflater;ILandroid/widget/TabHost;IZ)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v8

    .line 151
    .local v8, "indicator":Lco/vine/android/widget/tabs/TabIndicator;
    invoke-virtual {v8}, Lco/vine/android/widget/tabs/TabIndicator;->getIndicatorText()Landroid/widget/TextView;

    move-result-object v10

    .line 152
    .local v10, "indicatorText":Landroid/widget/TextView;
    invoke-virtual {v10, v9}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 153
    invoke-static/range {p0 .. p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v18

    move-object/from16 v0, v18

    iget-object v0, v0, Lco/vine/android/widget/Typefaces;->boldContent:Landroid/graphics/Typeface;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v10, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 155
    const-string v18, "friends"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Lco/vine/android/widget/tabs/IconTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    move-result-object v18

    const-class v19, Lco/vine/android/FriendsRecipientPickerFragment;

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2, v7}, Lco/vine/android/widget/tabs/TabsAdapter;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 160
    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    .line 161
    .local v6, "contactsBundle":Landroid/os/Bundle;
    const-string v18, "tag"

    const-string v19, "address_book"

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v6, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    const-string v18, "refresh"

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v6, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 163
    const-string v18, "empty_desc"

    const v19, 0x7f0e014f

    move-object/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v6, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 165
    const v18, 0x7f030062

    const v19, 0x7f0e0237

    const/16 v20, 0x0

    move/from16 v0, v18

    move/from16 v1, v19

    move/from16 v2, v20

    invoke-static {v11, v0, v15, v1, v2}, Lco/vine/android/widget/tabs/TabIndicator;->newTextIndicator(Landroid/view/LayoutInflater;ILandroid/widget/TabHost;IZ)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v8

    .line 169
    invoke-virtual {v8}, Lco/vine/android/widget/tabs/TabIndicator;->getIndicatorText()Landroid/widget/TextView;

    move-result-object v10

    .line 170
    invoke-virtual {v10, v9}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 171
    invoke-static/range {p0 .. p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v18

    move-object/from16 v0, v18

    iget-object v0, v0, Lco/vine/android/widget/Typefaces;->regularContentBold:Landroid/graphics/Typeface;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v10, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 173
    const-string v18, "address_book"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Lco/vine/android/widget/tabs/IconTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    move-result-object v18

    const-class v19, Lco/vine/android/ContactsRecipientPickerFragment;

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2, v6}, Lco/vine/android/widget/tabs/TabsAdapter;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 177
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "message"

    invoke-virtual/range {v18 .. v19}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecipientPickerActivity;->mCaptionMessage:Ljava/lang/String;

    .line 178
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "max_loops"

    const/16 v20, 0x0

    invoke-virtual/range {v18 .. v20}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/RecipientPickerActivity;->mMaxLoops:I

    .line 179
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "post_id"

    const-wide/16 v20, 0x0

    invoke-virtual/range {v18 .. v21}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v18

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lco/vine/android/RecipientPickerActivity;->mPostId:J

    .line 180
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "vid_url"

    invoke-virtual/range {v18 .. v19}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecipientPickerActivity;->mSharedVideoUrl:Ljava/lang/String;

    .line 181
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "thumb_url"

    invoke-virtual/range {v18 .. v19}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecipientPickerActivity;->mSharedThumbnailUrl:Ljava/lang/String;

    .line 183
    const v18, 0x1020013

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lco/vine/android/RecipientPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/view/ViewGroup;

    .line 184
    .local v5, "background":Landroid/view/ViewGroup;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    const v19, 0x7f090083

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getColor(I)I

    move-result v18

    move/from16 v0, v18

    invoke-virtual {v5, v0}, Landroid/view/ViewGroup;->setBackgroundColor(I)V

    .line 186
    const v18, 0x7f0a01a6

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lco/vine/android/RecipientPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v18

    check-cast v18, Lco/vine/android/views/FlowLayout;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    .line 188
    const v18, 0x7f03007f

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    move/from16 v0, v18

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v11, v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v13

    check-cast v13, Lco/vine/android/widget/TypefacesEditText;

    .line 189
    .local v13, "query":Lco/vine/android/widget/TypefacesEditText;
    move-object/from16 v0, p0

    invoke-virtual {v13, v0}, Lco/vine/android/widget/TypefacesEditText;->setKeyboardListener(Lco/vine/android/widget/TypefacesEditText$KeyboardListener;)V

    .line 190
    move-object/from16 v0, p0

    invoke-virtual {v13, v0}, Lco/vine/android/widget/TypefacesEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 191
    const/high16 v18, 0x80000

    move/from16 v0, v18

    invoke-virtual {v13, v0}, Lco/vine/android/widget/TypefacesEditText;->setInputType(I)V

    .line 192
    invoke-static/range {p0 .. p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v18

    move-object/from16 v0, v18

    iget-object v0, v0, Lco/vine/android/widget/Typefaces;->boldContent:Landroid/graphics/Typeface;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v13, v0}, Lco/vine/android/widget/TypefacesEditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 194
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v0, v13}, Lco/vine/android/views/FlowLayout;->addView(Landroid/view/View;)V

    .line 196
    move-object/from16 v0, p0

    iput-object v13, v0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    .line 197
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    move-object/from16 v18, v0

    new-instance v19, Lco/vine/android/RecipientPickerActivity$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/RecipientPickerActivity$1;-><init>(Lco/vine/android/RecipientPickerActivity;)V

    invoke-virtual/range {v18 .. v19}, Landroid/widget/EditText;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 203
    move-object/from16 v0, v16

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecipientPickerActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    .line 204
    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecipientPickerActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    .line 206
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "is_vm_onboarding"

    const/16 v20, 0x0

    invoke-virtual/range {v18 .. v20}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/RecipientPickerActivity;->mIsVmOnboarding:Z

    .line 207
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/RecipientPickerActivity;->mIsVmOnboarding:Z

    move/from16 v18, v0

    if-eqz v18, :cond_2

    .line 208
    const v18, 0x7f0a01a7

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lco/vine/android/RecipientPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v18

    check-cast v18, Landroid/widget/TextView;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecipientPickerActivity;->mOnboardingOverlay:Landroid/widget/TextView;

    .line 209
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecipientPickerActivity;->mOnboardingOverlay:Landroid/widget/TextView;

    move-object/from16 v18, v0

    const v19, 0x7f0e020e

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/RecipientPickerActivity;->getString(I)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 210
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecipientPickerActivity;->mOnboardingOverlay:Landroid/widget/TextView;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    invoke-virtual/range {v18 .. v19}, Landroid/widget/TextView;->setVisibility(I)V

    .line 211
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecipientPickerActivity;->mOnboardingOverlay:Landroid/widget/TextView;

    move-object/from16 v18, v0

    new-instance v19, Lco/vine/android/RecipientPickerActivity$2;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/RecipientPickerActivity$2;-><init>(Lco/vine/android/RecipientPickerActivity;)V

    invoke-virtual/range {v18 .. v19}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 222
    :cond_2
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecipientPickerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v18

    move-object/from16 v0, v18

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    move/from16 v18, v0

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/RecipientPickerActivity;->mDensity:F

    .line 223
    return-void
.end method

.method public onCurrentTabClicked()V
    .locals 0

    .prologue
    .line 443
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->scrollTop()V

    .line 444
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 532
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onDestroy()V

    .line 533
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v0, p0}, Landroid/widget/EditText;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    .line 534
    return-void
.end method

.method public onItemClick(Lco/vine/android/api/VineRecipient;)V
    .locals 2
    .param p1, "item"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 639
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mLastExtra:Lco/vine/android/api/VineRecipient;

    if-ne v1, p1, :cond_0

    .line 640
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lco/vine/android/RecipientPickerActivity;->setForceFullList(Z)V

    .line 649
    :goto_0
    return-void

    .line 642
    :cond_0
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 643
    .local v0, "index":I
    iget v1, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    if-ne v1, v0, :cond_1

    .line 644
    const/4 v1, -0x1

    invoke-direct {p0, v1}, Lco/vine/android/RecipientPickerActivity;->setItemForRemoval(I)V

    goto :goto_0

    .line 646
    :cond_1
    invoke-direct {p0, v0}, Lco/vine/android/RecipientPickerActivity;->setItemForRemoval(I)V

    goto :goto_0
.end method

.method public onKeyboardDismissed()V
    .locals 1

    .prologue
    .line 688
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/RecipientPickerActivity;->setForceFullList(Z)V

    .line 689
    return-void
.end method

.method public onPostCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 253
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onPostCreate(Landroid/os/Bundle;)V

    .line 254
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 255
    .local v2, "res":Landroid/content/res/Resources;
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->getFakeActionBar()Lco/vine/android/widget/FakeActionBar;

    move-result-object v1

    .line 256
    .local v1, "fakeActionBar":Lco/vine/android/widget/FakeActionBar;
    const v3, 0x7f02014c

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 257
    .local v0, "backIcon":Landroid/graphics/drawable/Drawable;
    new-instance v3, Landroid/graphics/PorterDuffColorFilter;

    iget v4, p0, Lco/vine/android/RecipientPickerActivity;->mProfileColor:I

    sget-object v5, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v3, v4, v5}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v0, v3}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 258
    invoke-virtual {v1}, Lco/vine/android/widget/FakeActionBar;->getBackIcon()Landroid/widget/ImageView;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 259
    invoke-virtual {v1}, Lco/vine/android/widget/FakeActionBar;->getTitleView()Landroid/widget/TextView;

    move-result-object v3

    invoke-static {p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v4

    iget-object v4, v4, Lco/vine/android/widget/Typefaces;->mediumContent:Landroid/graphics/Typeface;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 260
    invoke-virtual {v1}, Lco/vine/android/widget/FakeActionBar;->getTitleView()Landroid/widget/TextView;

    move-result-object v3

    const/4 v4, 0x2

    const/high16 v5, 0x41900000    # 18.0f

    invoke-virtual {v3, v4, v5}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 261
    invoke-direct {p0}, Lco/vine/android/RecipientPickerActivity;->addSendIcon()V

    .line 262
    return-void
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 418
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onResume()V

    .line 419
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v1

    iput v1, v0, Lco/vine/android/widget/tabs/TabsAdapter;->previousTab:I

    .line 420
    return-void
.end method

.method public onSendButtonClicked()V
    .locals 15

    .prologue
    const-wide/16 v13, 0x0

    const-wide/16 v2, -0x1

    const/4 v1, 0x0

    .line 331
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 332
    iget-wide v4, p0, Lco/vine/android/RecipientPickerActivity;->mPostId:J

    cmp-long v0, v4, v13

    if-lez v0, :cond_3

    .line 333
    new-instance v4, Ljava/util/ArrayList;

    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-direct {v4, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iget-wide v5, p0, Lco/vine/android/RecipientPickerActivity;->mPostId:J

    iget-object v7, p0, Lco/vine/android/RecipientPickerActivity;->mSharedVideoUrl:Ljava/lang/String;

    iget-object v8, p0, Lco/vine/android/RecipientPickerActivity;->mSharedThumbnailUrl:Ljava/lang/String;

    move-object v0, p0

    invoke-static/range {v0 .. v8}, Lco/vine/android/service/VineUploadService;->getVMSharePostIntent(Landroid/content/Context;ZJLjava/util/ArrayList;JLjava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/RecipientPickerActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 340
    :goto_0
    invoke-static {p0}, Lco/vine/android/service/VineUploadService;->getShowProgressIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/RecipientPickerActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 342
    iget-boolean v0, p0, Lco/vine/android/RecipientPickerActivity;->mIsVmOnboarding:Z

    if-nez v0, :cond_0

    iget-wide v0, p0, Lco/vine/android/RecipientPickerActivity;->mPostId:J

    cmp-long v0, v0, v13

    if-gtz v0, :cond_1

    .line 343
    :cond_0
    new-instance v12, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-class v1, Lco/vine/android/HomeTabActivity;

    invoke-direct {v12, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 344
    .local v12, "i":Landroid/content/Intent;
    const-string v0, "co.vine.android.VM_SENT"

    invoke-virtual {v12, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 345
    const-string v0, "is_vm_onboarding"

    iget-boolean v1, p0, Lco/vine/android/RecipientPickerActivity;->mIsVmOnboarding:Z

    invoke-virtual {v12, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 346
    const/high16 v0, 0x4000000

    invoke-virtual {v12, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 347
    invoke-virtual {p0, v12}, Lco/vine/android/RecipientPickerActivity;->startActivity(Landroid/content/Intent;)V

    .line 349
    .end local v12    # "i":Landroid/content/Intent;
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->finish()V

    .line 351
    :cond_2
    return-void

    .line 336
    :cond_3
    iget-object v5, p0, Lco/vine/android/RecipientPickerActivity;->mVideoPath:Ljava/lang/String;

    new-instance v9, Ljava/util/ArrayList;

    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-direct {v9, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iget-object v10, p0, Lco/vine/android/RecipientPickerActivity;->mCaptionMessage:Ljava/lang/String;

    iget v11, p0, Lco/vine/android/RecipientPickerActivity;->mMaxLoops:I

    move-object v4, p0

    move v6, v1

    move-wide v7, v2

    invoke-static/range {v4 .. v11}, Lco/vine/android/service/VineUploadService;->getVMPostIntent(Landroid/content/Context;Ljava/lang/String;ZJLjava/util/ArrayList;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/RecipientPickerActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    goto :goto_0
.end method

.method public onSupportContentChanged()V
    .locals 2

    .prologue
    .line 429
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onSupportContentChanged()V

    .line 430
    const v0, 0x1020012

    invoke-virtual {p0, v0}, Lco/vine/android/RecipientPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/tabs/IconTabHost;

    iput-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    .line 431
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    if-nez v0, :cond_0

    .line 432
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Your content must have a TabHost whose id attribute is \'android.R.id.tabhost\'"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 437
    :cond_0
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v0}, Lco/vine/android/widget/tabs/IconTabHost;->setup()V

    .line 438
    const v0, 0x7f0a00da

    invoke-virtual {p0, v0}, Lco/vine/android/RecipientPickerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    .line 439
    return-void
.end method

.method public onTabChanged(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 424
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 425
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 503
    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 504
    .local v0, "currentFragment":Landroid/support/v4/app/Fragment;
    instance-of v1, v0, Lco/vine/android/BaseRecipientPickerFragment;

    if-eqz v1, :cond_0

    .line 505
    check-cast v0, Lco/vine/android/BaseRecipientPickerFragment;

    .end local v0    # "currentFragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v0, p1, p2, p3, p4}, Lco/vine/android/BaseRecipientPickerFragment;->onTextChanged(Ljava/lang/CharSequence;III)V

    .line 507
    :cond_0
    if-lez p4, :cond_1

    .line 508
    const/4 v1, -0x1

    invoke-direct {p0, v1}, Lco/vine/android/RecipientPickerActivity;->setItemForRemoval(I)V

    .line 510
    :cond_1
    return-void
.end method

.method public removeRecipient(Lco/vine/android/api/VineRecipient;)V
    .locals 6
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 312
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->isInOverflowMode()Z

    move-result v1

    .line 313
    .local v1, "wasInOverFlowMode":Z
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v2, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 314
    .local v0, "originalIndex":I
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v2, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 315
    const-string v2, "Recipient removed: {} {} {}"

    iget-object v3, p1, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    iget-wide v4, p1, Lco/vine/android/api/VineRecipient;->userId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    iget-object v5, p1, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    invoke-static {v2, v3, v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 316
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-nez v2, :cond_0

    .line 317
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mQueryHint:Ljava/lang/CharSequence;

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 319
    :cond_0
    const/4 v2, 0x0

    invoke-direct {p0, v0, p1, v2, v1}, Lco/vine/android/RecipientPickerActivity;->invalidateEditTextUI(ILco/vine/android/api/VineRecipient;ZZ)V

    .line 320
    const/4 v2, -0x1

    iput v2, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    .line 321
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mSendButton:Landroid/widget/ImageView;

    if-eqz v2, :cond_1

    .line 322
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mSendButton:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->isSendButtonEnabled()Z

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setEnabled(Z)V

    .line 324
    :cond_1
    return-void
.end method

.method public scrollTop()V
    .locals 4

    .prologue
    .line 447
    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    if-nez v3, :cond_1

    .line 466
    :cond_0
    :goto_0
    return-void

    .line 451
    :cond_1
    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 453
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v3, v0, Lco/vine/android/BaseCursorListFragment;

    if-eqz v3, :cond_0

    .line 457
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v2

    .line 458
    .local v2, "view":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 459
    const v3, 0x102000a

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/twitter/android/widget/TopScrollable;

    .line 461
    .local v1, "list":Lcom/twitter/android/widget/TopScrollable;
    if-eqz v1, :cond_0

    invoke-interface {v1}, Lcom/twitter/android/widget/TopScrollable;->scrollTop()Z

    move-result v3

    if-nez v3, :cond_0

    .line 463
    check-cast v0, Lco/vine/android/BaseCursorListFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v0}, Lco/vine/android/BaseCursorListFragment;->invokeScrollFirstItem()V

    goto :goto_0
.end method

.method public sendKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 6
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v3, 0x1

    .line 693
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v4

    if-ne v4, v3, :cond_3

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v4

    const/16 v5, 0x43

    if-ne v4, v5, :cond_3

    .line 694
    iget v4, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    if-gez v4, :cond_2

    .line 695
    iget-object v4, p0, Lco/vine/android/RecipientPickerActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    .line 696
    .local v2, "txt":Landroid/text/Editable;
    if-eqz v2, :cond_3

    invoke-interface {v2}, Landroid/text/Editable;->length()I

    move-result v4

    if-nez v4, :cond_3

    .line 697
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->isInOverflowMode()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 698
    invoke-virtual {p0, v3}, Lco/vine/android/RecipientPickerActivity;->setForceFullList(Z)V

    .line 715
    .end local v2    # "txt":Landroid/text/Editable;
    :cond_0
    :goto_0
    return v3

    .line 700
    .restart local v2    # "txt":Landroid/text/Editable;
    :cond_1
    iget-object v4, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_0

    .line 701
    iget-object v4, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    add-int/lit8 v0, v4, -0x1

    .line 702
    .local v0, "indexToRemove":I
    iget v4, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    if-gez v4, :cond_0

    .line 703
    invoke-direct {p0, v0}, Lco/vine/android/RecipientPickerActivity;->setItemForRemoval(I)V

    goto :goto_0

    .line 710
    .end local v0    # "indexToRemove":I
    .end local v2    # "txt":Landroid/text/Editable;
    :cond_2
    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    iget v4, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineRecipient;

    .line 711
    .local v1, "toRemove":Lco/vine/android/api/VineRecipient;
    invoke-virtual {p0, v1}, Lco/vine/android/RecipientPickerActivity;->removeRecipient(Lco/vine/android/api/VineRecipient;)V

    .line 712
    invoke-direct {p0, v1}, Lco/vine/android/RecipientPickerActivity;->notifyItemRemoval(Lco/vine/android/api/VineRecipient;)V

    .line 715
    .end local v1    # "toRemove":Lco/vine/android/api/VineRecipient;
    :cond_3
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public setForceFullList(Z)V
    .locals 6
    .param p1, "forceFullList"    # Z

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x3

    .line 537
    iget-boolean v1, p0, Lco/vine/android/RecipientPickerActivity;->isForcingFullList:Z

    .line 538
    .local v1, "wasForceFullList":Z
    if-ne v1, p1, :cond_1

    .line 561
    :cond_0
    :goto_0
    return-void

    .line 541
    :cond_1
    iput-boolean p1, p0, Lco/vine/android/RecipientPickerActivity;->isForcingFullList:Z

    .line 542
    if-eqz p1, :cond_2

    .line 546
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v2, v4}, Lco/vine/android/views/FlowLayout;->removeViewAt(I)V

    .line 547
    const/4 v0, 0x3

    .local v0, "i":I
    :goto_1
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 548
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mRecipients:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VineRecipient;

    invoke-direct {p0, v0, v2, v5, v5}, Lco/vine/android/RecipientPickerActivity;->invalidateEditTextUI(ILco/vine/android/api/VineRecipient;ZZ)V

    .line 547
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 551
    .end local v0    # "i":I
    :cond_2
    invoke-virtual {p0}, Lco/vine/android/RecipientPickerActivity;->isInOverflowMode()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 552
    iget v2, p0, Lco/vine/android/RecipientPickerActivity;->mSelectedForRemoval:I

    if-lt v2, v4, :cond_3

    .line 553
    const/4 v2, -0x1

    invoke-direct {p0, v2}, Lco/vine/android/RecipientPickerActivity;->setItemForRemoval(I)V

    .line 555
    :cond_3
    :goto_2
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v2}, Lco/vine/android/views/FlowLayout;->getChildCount()I

    move-result v2

    const/4 v3, 0x4

    if-le v2, v3, :cond_4

    .line 556
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mFlowLayout:Lco/vine/android/views/FlowLayout;

    invoke-virtual {v2, v4}, Lco/vine/android/views/FlowLayout;->removeViewAt(I)V

    goto :goto_2

    .line 558
    :cond_4
    iget-object v2, p0, Lco/vine/android/RecipientPickerActivity;->mLastExtra:Lco/vine/android/api/VineRecipient;

    const/4 v3, 0x0

    invoke-direct {p0, v4, v2, v5, v3}, Lco/vine/android/RecipientPickerActivity;->invalidateEditTextUI(ILco/vine/android/api/VineRecipient;ZZ)V

    goto :goto_0
.end method

.method public showPage(Ljava/lang/String;)V
    .locals 5
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 226
    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/TabsAdapter;->getTabs()Ljava/util/ArrayList;

    move-result-object v2

    .line 227
    .local v2, "tabs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/widget/tabs/TabInfo;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v0, v3, :cond_1

    .line 228
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/tabs/TabInfo;

    .line 229
    .local v1, "tab":Lco/vine/android/widget/tabs/TabInfo;
    invoke-virtual {v1}, Lco/vine/android/widget/tabs/TabInfo;->getTag()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 230
    iget-object v3, p0, Lco/vine/android/RecipientPickerActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    const/4 v4, 0x1

    invoke-virtual {v3, v0, v4}, Landroid/support/v4/view/ViewPager;->setCurrentItem(IZ)V

    .line 227
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 233
    .end local v1    # "tab":Lco/vine/android/widget/tabs/TabInfo;
    :cond_1
    return-void
.end method
