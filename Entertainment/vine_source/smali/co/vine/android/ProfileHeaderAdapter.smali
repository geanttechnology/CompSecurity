.class public Lco/vine/android/ProfileHeaderAdapter;
.super Landroid/widget/BaseAdapter;
.source "ProfileHeaderAdapter.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ProfileHeaderAdapter$1;,
        Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;,
        Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;,
        Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;,
        Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;,
        Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;
    }
.end annotation


# static fields
.field private static final FOLLOWING:I = 0x2

.field private static final FOLLOW_REQUESTED:I = 0x3

.field private static final NOT_FOLLOWING:I = 0x1

.field private static final SPAN_FLAGS:I = 0x21

.field public static final TAB_LIKES:I = 0x1

.field public static final TAB_POST:I


# instance fields
.field private mAppController:Lco/vine/android/client/AppController;

.field private mBlocked:Z

.field private final mBold:Lco/vine/android/widget/TypefacesSpan;

.field private mContext:Landroid/content/Context;

.field private mCurrentTab:I

.field private mDetailPageHeight:I

.field private mFollowEventSource:Ljava/lang/String;

.field private mFollowState:I

.field private final mFragment:Lco/vine/android/ProfileFragment;

.field private mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

.field private mHolderPagerDetails:Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;

.field private mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

.field private mListener:Landroid/view/View$OnClickListener;

.field private mLocked:Z

.field private mMainPageHeight:I

.field private final mNumberUnSelectedColor:I

.field private final mRegular:Lco/vine/android/widget/TypefacesSpan;

.field private mShowActionsContainer:Z

.field private mTabSelectedColor:I

.field private mUser:Lco/vine/android/api/VineUser;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lco/vine/android/client/AppController;Lco/vine/android/ProfileFragment;ZZLjava/lang/String;ZZ)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .param p3, "fragment"    # Lco/vine/android/ProfileFragment;
    .param p4, "locked"    # Z
    .param p5, "blocked"    # Z
    .param p6, "followEventSource"    # Ljava/lang/String;
    .param p7, "hideProfileReposts"    # Z
    .param p8, "showActionsContainer"    # Z

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 80
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 71
    iput v5, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowState:I

    .line 81
    iput-object p1, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    .line 82
    iput-object p3, p0, Lco/vine/android/ProfileHeaderAdapter;->mListener:Landroid/view/View$OnClickListener;

    .line 83
    iput-object p2, p0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 84
    iput-object p3, p0, Lco/vine/android/ProfileHeaderAdapter;->mFragment:Lco/vine/android/ProfileFragment;

    .line 85
    iput-boolean p4, p0, Lco/vine/android/ProfileHeaderAdapter;->mLocked:Z

    .line 86
    iput-boolean p5, p0, Lco/vine/android/ProfileHeaderAdapter;->mBlocked:Z

    .line 87
    iput-object p6, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowEventSource:Ljava/lang/String;

    .line 89
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 90
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f090018

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    iput v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mNumberUnSelectedColor:I

    .line 92
    new-instance v1, Lco/vine/android/widget/TypefacesSpan;

    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v2

    const/4 v3, 0x1

    const/4 v4, 0x4

    invoke-virtual {v2, v3, v4}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v2

    invoke-direct {v1, v6, v2}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    iput-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mBold:Lco/vine/android/widget/TypefacesSpan;

    .line 94
    new-instance v1, Lco/vine/android/widget/TypefacesSpan;

    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v2

    const/4 v3, 0x2

    invoke-virtual {v2, v5, v3}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v2

    invoke-direct {v1, v6, v2}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    iput-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mRegular:Lco/vine/android/widget/TypefacesSpan;

    .line 97
    iput-boolean p8, p0, Lco/vine/android/ProfileHeaderAdapter;->mShowActionsContainer:Z

    .line 98
    iput v5, p0, Lco/vine/android/ProfileHeaderAdapter;->mCurrentTab:I

    .line 99
    return-void
.end method

.method static synthetic access$102(Lco/vine/android/ProfileHeaderAdapter;Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;)Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileHeaderAdapter;
    .param p1, "x1"    # Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    .prologue
    .line 45
    iput-object p1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    return-object p1
.end method

.method static synthetic access$200(Lco/vine/android/ProfileHeaderAdapter;)Lco/vine/android/api/VineUser;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ProfileHeaderAdapter;

    .prologue
    .line 45
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    return-object v0
.end method

.method static synthetic access$302(Lco/vine/android/ProfileHeaderAdapter;Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;)Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileHeaderAdapter;
    .param p1, "x1"    # Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;

    .prologue
    .line 45
    iput-object p1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerDetails:Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;

    return-object p1
.end method

.method static synthetic access$400(Lco/vine/android/ProfileHeaderAdapter;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileHeaderAdapter;

    .prologue
    .line 45
    invoke-direct {p0}, Lco/vine/android/ProfileHeaderAdapter;->invalidateDetailHeight()V

    return-void
.end method

.method private invalidateCount(ILandroid/content/res/Resources;ILco/vine/android/widget/TypefacesTextView;)V
    .locals 10
    .param p1, "count"    # I
    .param p2, "res"    # Landroid/content/res/Resources;
    .param p3, "resId"    # I
    .param p4, "labelView"    # Lco/vine/android/widget/TypefacesTextView;

    .prologue
    const/16 v9, 0x22

    const/16 v8, 0x21

    .line 281
    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    int-to-long v6, p1

    invoke-static {p2, v6, v7}, Lco/vine/android/util/Util;->numberFormat(Landroid/content/res/Resources;J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {p2, p3, p1, v4}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 282
    .local v3, "text":Ljava/lang/String;
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0, v3}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 284
    .local v0, "builder":Landroid/text/SpannableStringBuilder;
    invoke-virtual {v3, v9}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    .line 285
    .local v2, "start":I
    add-int/lit8 v4, v2, 0x1

    invoke-virtual {v3, v9, v4}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    .line 287
    .local v1, "end":I
    iget-object v4, p0, Lco/vine/android/ProfileHeaderAdapter;->mBold:Lco/vine/android/widget/TypefacesSpan;

    invoke-static {v0, v4, v2, v1, v8}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 288
    iget-object v4, p0, Lco/vine/android/ProfileHeaderAdapter;->mRegular:Lco/vine/android/widget/TypefacesSpan;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    invoke-static {v0, v4, v1, v5, v8}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 290
    add-int/lit8 v4, v2, 0x1

    invoke-virtual {v0, v2, v4}, Landroid/text/SpannableStringBuilder;->delete(II)Landroid/text/SpannableStringBuilder;

    .line 291
    add-int/lit8 v4, v1, -0x1

    invoke-virtual {v0, v4, v1}, Landroid/text/SpannableStringBuilder;->delete(II)Landroid/text/SpannableStringBuilder;

    .line 293
    invoke-virtual {p4, v0}, Lco/vine/android/widget/TypefacesTextView;->setText(Ljava/lang/CharSequence;)V

    .line 294
    return-void
.end method

.method private invalidateCountAndTabColor(IILandroid/content/res/Resources;ILco/vine/android/widget/TypefacesTextView;)V
    .locals 0
    .param p1, "tab"    # I
    .param p2, "count"    # I
    .param p3, "res"    # Landroid/content/res/Resources;
    .param p4, "resId"    # I
    .param p5, "labelView"    # Lco/vine/android/widget/TypefacesTextView;

    .prologue
    .line 276
    invoke-direct {p0, p2, p3, p4, p5}, Lco/vine/android/ProfileHeaderAdapter;->invalidateCount(ILandroid/content/res/Resources;ILco/vine/android/widget/TypefacesTextView;)V

    .line 277
    invoke-direct {p0, p1, p5}, Lco/vine/android/ProfileHeaderAdapter;->invalidateTabColor(ILandroid/widget/TextView;)V

    .line 278
    return-void
.end method

.method private invalidateDetailHeight()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 261
    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerDetails:Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;

    if-eqz v3, :cond_0

    .line 262
    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerDetails:Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;

    iget-object v1, v3, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;->parent:Landroid/view/View;

    .line 263
    .local v1, "parent":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 264
    invoke-static {v4, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 265
    .local v0, "heightMeasureSpec":I
    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/content/Context;)Landroid/graphics/Point;

    move-result-object v3

    iget v3, v3, Landroid/graphics/Point;->x:I

    const/high16 v4, 0x40000000    # 2.0f

    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    .line 266
    .local v2, "widthMeasureSpec":I
    invoke-virtual {v1, v2, v0}, Landroid/view/View;->measure(II)V

    .line 267
    invoke-virtual {v1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v3

    iput v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mDetailPageHeight:I

    .line 268
    iget v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mMainPageHeight:I

    if-gtz v3, :cond_0

    .line 269
    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v3, v3, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v3}, Landroid/support/v4/view/ViewPager;->getHeight()I

    move-result v3

    iput v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mMainPageHeight:I

    .line 273
    .end local v0    # "heightMeasureSpec":I
    .end local v1    # "parent":Landroid/view/View;
    .end local v2    # "widthMeasureSpec":I
    :cond_0
    return-void
.end method

.method private invalidateTabColor(ILandroid/widget/TextView;)V
    .locals 1
    .param p1, "tab"    # I
    .param p2, "numberView"    # Landroid/widget/TextView;

    .prologue
    .line 297
    iget v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mCurrentTab:I

    if-ne v0, p1, :cond_0

    .line 298
    iget v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mTabSelectedColor:I

    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 302
    :goto_0
    return-void

    .line 300
    :cond_0
    iget v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mNumberUnSelectedColor:I

    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_0
.end method

.method private setImage(Landroid/graphics/Bitmap;)V
    .locals 5
    .param p1, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    const/16 v4, 0x8

    .line 477
    if-nez p1, :cond_1

    .line 478
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    iget-object v0, v0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageView:Landroid/widget/ImageView;

    const v1, 0x7f020065

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 479
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    iget-wide v0, v0, Lco/vine/android/api/VineUser;->userId:J

    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 480
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    iget-object v0, v0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageAction:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 488
    :goto_0
    return-void

    .line 482
    :cond_0
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    iget-object v0, v0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageAction:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 485
    :cond_1
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    iget-object v0, v0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageAction:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 486
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    iget-object v0, v0, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageView:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    iget-object v2, v2, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageView:Landroid/widget/ImageView;

    invoke-virtual {v2}, Landroid/widget/ImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method private setupFollowButton(Landroid/widget/Button;Lco/vine/android/api/VineUser;)V
    .locals 13
    .param p1, "followButton"    # Landroid/widget/Button;
    .param p2, "user"    # Lco/vine/android/api/VineUser;

    .prologue
    const/4 v12, 0x3

    const/high16 v11, -0x1000000

    const/4 v10, 0x2

    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 331
    iget v0, p2, Lco/vine/android/api/VineUser;->profileBackground:I

    .line 332
    .local v0, "color":I
    sget v3, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v0, v3, :cond_0

    if-gtz v0, :cond_1

    .line 333
    :cond_0
    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v6, 0x7f090096

    invoke-virtual {v3, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    .line 335
    :cond_1
    or-int/2addr v0, v11

    .line 337
    invoke-virtual {p2}, Lco/vine/android/api/VineUser;->hasFollowRequested()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 338
    iput v12, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowState:I

    .line 345
    :cond_2
    :goto_0
    iget v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowState:I

    if-ne v3, v10, :cond_6

    move v3, v4

    :goto_1
    invoke-virtual {p1, v3}, Landroid/widget/Button;->setActivated(Z)V

    .line 347
    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 348
    .local v2, "res":Landroid/content/res/Resources;
    iget v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowState:I

    if-ne v3, v10, :cond_7

    .line 349
    const v3, 0x7f090083

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {p1, v3}, Landroid/widget/Button;->setTextColor(I)V

    .line 350
    const v3, 0x7f0e0102

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 356
    :cond_3
    :goto_2
    iget v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowState:I

    if-eq v3, v12, :cond_8

    .line 357
    const v3, 0x7f020121

    invoke-static {v2, v0, v3, p1}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 358
    invoke-virtual {p1, v5, v5, v5, v5}, Landroid/widget/Button;->setPadding(IIII)V

    .line 366
    :goto_3
    return-void

    .line 339
    .end local v2    # "res":Landroid/content/res/Resources;
    :cond_4
    invoke-virtual {p2}, Lco/vine/android/api/VineUser;->isFollowing()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 340
    iput v10, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowState:I

    goto :goto_0

    .line 341
    :cond_5
    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v6

    iget-wide v8, p2, Lco/vine/android/api/VineUser;->userId:J

    cmp-long v3, v6, v8

    if-eqz v3, :cond_2

    .line 342
    iput v4, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowState:I

    goto :goto_0

    :cond_6
    move v3, v5

    .line 345
    goto :goto_1

    .line 351
    .restart local v2    # "res":Landroid/content/res/Resources;
    :cond_7
    iget v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowState:I

    if-ne v3, v4, :cond_3

    .line 352
    or-int v3, v0, v11

    invoke-virtual {p1, v3}, Landroid/widget/Button;->setTextColor(I)V

    .line 353
    const v3, 0x7f0e00fb

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 360
    :cond_8
    const v3, 0x7f09007b

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    .line 361
    .local v1, "gray":I
    const v3, 0x7f020121

    invoke-static {v2, v1, v3, p1}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 362
    invoke-virtual {p1, v1}, Landroid/widget/Button;->setTextColor(I)V

    .line 363
    const v3, 0x7f0e0100

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 364
    const v3, 0x7f0b007f

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    invoke-virtual {p1, v3, v5, v5, v5}, Landroid/widget/Button;->setPadding(IIII)V

    goto :goto_3
.end method

.method private setupMessageButton(Landroid/widget/Button;Lco/vine/android/api/VineUser;)V
    .locals 5
    .param p1, "messageButton"    # Landroid/widget/Button;
    .param p2, "profileUser"    # Lco/vine/android/api/VineUser;

    .prologue
    .line 321
    iget v0, p2, Lco/vine/android/api/VineUser;->profileBackground:I

    .line 322
    .local v0, "color":I
    sget v2, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v0, v2, :cond_0

    if-gtz v0, :cond_1

    .line 323
    :cond_0
    const v2, 0xffffff

    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090096

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    and-int v0, v2, v3

    .line 325
    :cond_1
    const/high16 v2, -0x1000000

    or-int/2addr v2, v0

    invoke-virtual {p1, v2}, Landroid/widget/Button;->setTextColor(I)V

    .line 326
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 327
    .local v1, "res":Landroid/content/res/Resources;
    const/high16 v2, 0x3d000000    # 0.03125f

    or-int/2addr v2, v0

    const v3, 0x7f0200b3

    invoke-static {v1, v2, v3, p1}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 328
    return-void
.end method


# virtual methods
.method public bindUser(Lco/vine/android/api/VineUser;)V
    .locals 17
    .param p1, "profileUser"    # Lco/vine/android/api/VineUser;

    .prologue
    .line 142
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    if-eqz v2, :cond_6

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    if-eqz v2, :cond_6

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerDetails:Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;

    if-eqz v2, :cond_6

    .line 143
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    .line 144
    move-object/from16 v0, p0

    iget-object v9, v0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    .line 145
    .local v9, "holder":Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;
    move-object/from16 v0, p0

    iget-object v11, v0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    .line 146
    .local v11, "holderMain":Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;
    move-object/from16 v0, p0

    iget-object v10, v0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerDetails:Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;

    .line 147
    .local v10, "holderDetails":Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 148
    .local v5, "res":Landroid/content/res/Resources;
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    invoke-static {v2}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 150
    :cond_0
    const/4 v2, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lco/vine/android/ProfileHeaderAdapter;->setImage(Landroid/graphics/Bitmap;)V

    .line 155
    :goto_0
    iget-object v2, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageView:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileHeaderAdapter;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 156
    iget-object v3, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageView:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mListener:Landroid/view/View$OnClickListener;

    check-cast v2, Landroid/view/View$OnLongClickListener;

    invoke-virtual {v3, v2}, Landroid/widget/ImageView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 157
    iget-object v2, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->username:Landroid/widget/TextView;

    move-object/from16 v0, p1

    iget-object v3, v0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 159
    move-object/from16 v0, p1

    iget v2, v0, Lco/vine/android/api/VineUser;->profileBackground:I

    if-lez v2, :cond_1

    .line 160
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->profileBackground:Landroid/widget/RelativeLayout;

    move-object/from16 v0, p1

    iget v3, v0, Lco/vine/android/api/VineUser;->profileBackground:I

    const/high16 v4, -0x1000000

    or-int/2addr v3, v4

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    .line 164
    :cond_1
    move-object/from16 v0, p1

    iget v13, v0, Lco/vine/android/api/VineUser;->profileBackground:I

    .line 165
    .local v13, "tabSelectedColor":I
    sget v2, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v13, v2, :cond_2

    if-gtz v13, :cond_3

    .line 166
    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090096

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v13

    .line 168
    :cond_3
    const/high16 v2, -0x1000000

    or-int/2addr v13, v2

    .line 170
    move-object/from16 v0, p0

    iput v13, v0, Lco/vine/android/ProfileHeaderAdapter;->mTabSelectedColor:I

    .line 172
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->profileTabArrowImage:Landroid/widget/ImageView;

    new-instance v3, Landroid/graphics/PorterDuffColorFilter;

    const/high16 v4, 0x4c000000    # 3.3554432E7f

    sget-object v6, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v3, v4, v6}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 174
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_8

    .line 175
    iget-object v2, v10, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;->description:Landroid/widget/TextView;

    move-object/from16 v0, p1

    iget-object v3, v0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 176
    iget-object v2, v10, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;->description:Landroid/widget/TextView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 181
    :goto_1
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_9

    .line 182
    iget-object v2, v10, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;->location:Landroid/widget/TextView;

    move-object/from16 v0, p1

    iget-object v3, v0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 183
    iget-object v2, v10, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;->location:Landroid/widget/TextView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 187
    :goto_2
    move-object/from16 v0, p1

    iget-wide v2, v0, Lco/vine/android/api/VineUser;->userId:J

    iput-wide v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->userId:J

    .line 189
    invoke-virtual/range {p1 .. p1}, Lco/vine/android/api/VineUser;->isVerified()Z

    move-result v2

    if-eqz v2, :cond_a

    .line 190
    iget-object v2, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->verified:Landroid/widget/ImageView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 195
    :goto_3
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mBlocked:Z

    if-nez v2, :cond_4

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    move-object/from16 v0, p1

    iget-wide v6, v0, Lco/vine/android/api/VineUser;->userId:J

    cmp-long v2, v2, v6

    if-nez v2, :cond_b

    .line 196
    :cond_4
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->messageButton:Landroid/widget/Button;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 203
    :goto_4
    iget-object v8, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->follow:Landroid/widget/Button;

    .line 204
    .local v8, "button":Landroid/widget/Button;
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mBlocked:Z

    if-nez v2, :cond_5

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    move-object/from16 v0, p1

    iget-wide v6, v0, Lco/vine/android/api/VineUser;->userId:J

    cmp-long v2, v2, v6

    if-nez v2, :cond_c

    .line 205
    :cond_5
    const/16 v2, 0x8

    invoke-virtual {v8, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 212
    :goto_5
    iget-object v12, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->settings:Landroid/widget/Button;

    .line 213
    .local v12, "settings":Landroid/widget/Button;
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    move-object/from16 v0, p1

    iget-wide v6, v0, Lco/vine/android/api/VineUser;->userId:J

    cmp-long v2, v2, v6

    if-nez v2, :cond_d

    .line 214
    const/4 v2, 0x0

    invoke-virtual {v12, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 215
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v12, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 220
    :goto_6
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mLocked:Z

    if-eqz v2, :cond_e

    .line 221
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->postsParent:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 222
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->likesParent:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 223
    iget-object v2, v10, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;->userLoopCount:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 224
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->profileTabArrow:Landroid/view/ViewGroup;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 244
    :goto_7
    iget-object v2, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->imageFrame:Landroid/widget/ImageView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 245
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->progress:Landroid/widget/ProgressBar;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 246
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->profileTabArrow:Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileHeaderAdapter;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 248
    move-object/from16 v0, p1

    iget v2, v0, Lco/vine/android/api/VineUser;->followerCount:I

    const v3, 0x7f0d0001

    iget-object v4, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->followers:Lco/vine/android/widget/TypefacesTextView;

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v5, v3, v4}, Lco/vine/android/ProfileHeaderAdapter;->invalidateCount(ILandroid/content/res/Resources;ILco/vine/android/widget/TypefacesTextView;)V

    .line 249
    move-object/from16 v0, p1

    iget v2, v0, Lco/vine/android/api/VineUser;->followingCount:I

    const v3, 0x7f0d0002

    iget-object v4, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->following:Lco/vine/android/widget/TypefacesTextView;

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v5, v3, v4}, Lco/vine/android/ProfileHeaderAdapter;->invalidateCount(ILandroid/content/res/Resources;ILco/vine/android/widget/TypefacesTextView;)V

    .line 251
    iget-object v2, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->followers:Lco/vine/android/widget/TypefacesTextView;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileHeaderAdapter;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Lco/vine/android/widget/TypefacesTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 252
    iget-object v2, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->following:Lco/vine/android/widget/TypefacesTextView;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileHeaderAdapter;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Lco/vine/android/widget/TypefacesTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 255
    .end local v5    # "res":Landroid/content/res/Resources;
    .end local v8    # "button":Landroid/widget/Button;
    .end local v9    # "holder":Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;
    .end local v10    # "holderDetails":Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;
    .end local v11    # "holderMain":Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;
    .end local v12    # "settings":Landroid/widget/Button;
    .end local v13    # "tabSelectedColor":I
    :cond_6
    invoke-direct/range {p0 .. p0}, Lco/vine/android/ProfileHeaderAdapter;->invalidateDetailHeight()V

    .line 257
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    .line 258
    return-void

    .line 152
    .restart local v5    # "res":Landroid/content/res/Resources;
    .restart local v9    # "holder":Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;
    .restart local v10    # "holderDetails":Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;
    .restart local v11    # "holderMain":Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;
    :cond_7
    new-instance v2, Lco/vine/android/util/image/ImageKey;

    move-object/from16 v0, p1

    iget-object v3, v0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;Z)V

    iput-object v2, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->userImageKey:Lco/vine/android/util/image/ImageKey;

    .line 153
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->userImageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {v2, v3}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lco/vine/android/ProfileHeaderAdapter;->setImage(Landroid/graphics/Bitmap;)V

    goto/16 :goto_0

    .line 178
    .restart local v13    # "tabSelectedColor":I
    :cond_8
    iget-object v2, v10, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;->description:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 185
    :cond_9
    iget-object v2, v10, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;->location:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_2

    .line 192
    :cond_a
    iget-object v2, v11, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->verified:Landroid/widget/ImageView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_3

    .line 198
    :cond_b
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->messageButton:Landroid/widget/Button;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 199
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->messageButton:Landroid/widget/Button;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileHeaderAdapter;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 200
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->messageButton:Landroid/widget/Button;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v2, v1}, Lco/vine/android/ProfileHeaderAdapter;->setupMessageButton(Landroid/widget/Button;Lco/vine/android/api/VineUser;)V

    goto/16 :goto_4

    .line 207
    .restart local v8    # "button":Landroid/widget/Button;
    :cond_c
    const/4 v2, 0x0

    invoke-virtual {v8, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 208
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v8, v1}, Lco/vine/android/ProfileHeaderAdapter;->setupFollowButton(Landroid/widget/Button;Lco/vine/android/api/VineUser;)V

    .line 209
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v8, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_5

    .line 217
    .restart local v12    # "settings":Landroid/widget/Button;
    :cond_d
    const/16 v2, 0x8

    invoke-virtual {v12, v2}, Landroid/widget/Button;->setVisibility(I)V

    goto/16 :goto_6

    .line 226
    :cond_e
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->postsParent:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 227
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->likesParent:Landroid/view/View;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 228
    iget-object v2, v10, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;->userLoopCount:Landroid/widget/TextView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 229
    iget-object v3, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->profileTabArrow:Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iget v2, v0, Lco/vine/android/ProfileHeaderAdapter;->mCurrentTab:I

    if-nez v2, :cond_10

    const/4 v2, 0x0

    :goto_8
    invoke-virtual {v3, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 230
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->likesParent:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileHeaderAdapter;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 231
    iget-object v2, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->postsParent:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileHeaderAdapter;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 234
    move-object/from16 v0, p1

    iget-wide v2, v0, Lco/vine/android/api/VineUser;->loopCount:J

    const-wide/32 v6, 0x7fffffff

    cmp-long v2, v2, v6

    if-lez v2, :cond_f

    .line 235
    const-wide/32 v2, 0x7fffffff

    move-object/from16 v0, p1

    iput-wide v2, v0, Lco/vine/android/api/VineUser;->loopCount:J

    .line 238
    :cond_f
    iget-object v2, v10, Lco/vine/android/ProfileHeaderAdapter$PagerDetailsViewHolder;->userLoopCount:Landroid/widget/TextView;

    const v3, 0x7f0d0004

    move-object/from16 v0, p1

    iget-wide v6, v0, Lco/vine/android/api/VineUser;->loopCount:J

    long-to-int v4, v6

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    move-object/from16 v0, p1

    iget-wide v14, v0, Lco/vine/android/api/VineUser;->loopCount:J

    const/16 v16, 0x0

    move/from16 v0, v16

    invoke-static {v5, v14, v15, v0}, Lco/vine/android/util/Util;->numberFormat(Landroid/content/res/Resources;JZ)Ljava/lang/String;

    move-result-object v14

    aput-object v14, v6, v7

    invoke-virtual {v5, v3, v4, v6}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 241
    const/4 v3, 0x1

    move-object/from16 v0, p1

    iget v4, v0, Lco/vine/android/api/VineUser;->likeCount:I

    const v6, 0x7f0d0003

    iget-object v7, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->likesLabel:Lco/vine/android/widget/TypefacesTextView;

    move-object/from16 v2, p0

    invoke-direct/range {v2 .. v7}, Lco/vine/android/ProfileHeaderAdapter;->invalidateCountAndTabColor(IILandroid/content/res/Resources;ILco/vine/android/widget/TypefacesTextView;)V

    .line 242
    const/4 v3, 0x0

    move-object/from16 v0, p1

    iget v4, v0, Lco/vine/android/api/VineUser;->postCount:I

    const v6, 0x7f0d0005

    iget-object v7, v9, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->postsLabel:Lco/vine/android/widget/TypefacesTextView;

    move-object/from16 v2, p0

    invoke-direct/range {v2 .. v7}, Lco/vine/android/ProfileHeaderAdapter;->invalidateCountAndTabColor(IILandroid/content/res/Resources;ILco/vine/android/widget/TypefacesTextView;)V

    goto/16 :goto_7

    .line 229
    :cond_10
    const/16 v2, 0x8

    goto :goto_8
.end method

.method public changeSelectedTab(I)V
    .locals 4
    .param p1, "tabId"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v0, 0x0

    .line 445
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    if-nez v1, :cond_0

    .line 463
    :goto_0
    return-void

    .line 448
    :cond_0
    sparse-switch p1, :sswitch_data_0

    .line 460
    :goto_1
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->postsLabel:Lco/vine/android/widget/TypefacesTextView;

    invoke-direct {p0, v0, v1}, Lco/vine/android/ProfileHeaderAdapter;->invalidateTabColor(ILandroid/widget/TextView;)V

    .line 461
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->likesLabel:Lco/vine/android/widget/TypefacesTextView;

    invoke-direct {p0, v3, v1}, Lco/vine/android/ProfileHeaderAdapter;->invalidateTabColor(ILandroid/widget/TextView;)V

    .line 462
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->profileTabArrow:Landroid/view/ViewGroup;

    iget v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mCurrentTab:I

    if-nez v2, :cond_1

    :goto_2
    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->setVisibility(I)V

    goto :goto_0

    .line 450
    :sswitch_0
    iput v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mCurrentTab:I

    .line 451
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mFragment:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1, v3}, Lco/vine/android/ProfileFragment;->changeMode(I)V

    goto :goto_1

    .line 455
    :sswitch_1
    iput v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mCurrentTab:I

    .line 456
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mFragment:Lco/vine/android/ProfileFragment;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Lco/vine/android/ProfileFragment;->changeMode(I)V

    goto :goto_1

    .line 462
    :cond_1
    const/16 v0, 0x8

    goto :goto_2

    .line 448
    :sswitch_data_0
    .sparse-switch
        0x7f0a0190 -> :sswitch_0
        0x7f0a0194 -> :sswitch_1
    .end sparse-switch
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 103
    const/4 v0, 0x1

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 108
    const/4 v0, 0x0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "i"    # I

    .prologue
    .line 113
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "i"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "root"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v0, 0x0

    .line 118
    if-nez p2, :cond_0

    .line 119
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f030076

    invoke-virtual {v1, v2, p3, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 121
    new-instance v1, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    invoke-direct {v1, p2}, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;-><init>(Landroid/view/View;)V

    iput-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    .line 122
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->pager:Landroid/support/v4/view/ViewPager;

    new-instance v2, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Lco/vine/android/ProfileHeaderAdapter$ProfileViewPagerAdapter;-><init>(Lco/vine/android/ProfileHeaderAdapter;Lco/vine/android/ProfileHeaderAdapter$1;)V

    invoke-virtual {v1, v2}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 123
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1, p0}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 126
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->progress:Landroid/widget/ProgressBar;

    invoke-virtual {v1, v0}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 127
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->dots:Lco/vine/android/widget/DotIndicators;

    invoke-virtual {v1, v0}, Lco/vine/android/widget/DotIndicators;->setFinalIcon(Z)V

    .line 128
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->dots:Lco/vine/android/widget/DotIndicators;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Lco/vine/android/widget/DotIndicators;->setNumberOfDots(I)V

    .line 130
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->dropDownHolder:Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;->revineParent:Landroid/view/View;

    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mFragment:Lco/vine/android/ProfileFragment;

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 132
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->profileActions:Landroid/view/ViewGroup;

    iget-boolean v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mShowActionsContainer:Z

    if-eqz v2, :cond_1

    :goto_0
    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 134
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileHeaderAdapter;->bindUser(Lco/vine/android/api/VineUser;)V

    .line 138
    :cond_0
    return-object p2

    .line 132
    :cond_1
    const/16 v0, 0x8

    goto :goto_0
.end method

.method public onImageLoaded(Ljava/util/HashMap;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 466
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    if-eqz v1, :cond_0

    .line 467
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->userImageKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v1, :cond_0

    .line 468
    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolderPagerMain:Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;

    iget-object v1, v1, Lco/vine/android/ProfileHeaderAdapter$PagerMainViewHolder;->userImageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/image/UrlImage;

    .line 469
    .local v0, "urlImage":Lco/vine/android/util/image/UrlImage;
    if-eqz v0, :cond_0

    .line 470
    iget-object v1, v0, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v1}, Lco/vine/android/ProfileHeaderAdapter;->setImage(Landroid/graphics/Bitmap;)V

    .line 474
    .end local v0    # "urlImage":Lco/vine/android/util/image/UrlImage;
    :cond_0
    return-void
.end method

.method public onPageScrollStateChanged(I)V
    .locals 0
    .param p1, "i"    # I

    .prologue
    .line 510
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 4
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F
    .param p3, "positionOffsetPixels"    # I

    .prologue
    .line 492
    const/4 v2, 0x0

    cmpl-float v2, p2, v2

    if-lez v2, :cond_0

    iget v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mMainPageHeight:I

    if-lez v2, :cond_0

    iget v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mDetailPageHeight:I

    iget v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mMainPageHeight:I

    if-le v2, v3, :cond_0

    .line 493
    iget v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mDetailPageHeight:I

    iget v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mMainPageHeight:I

    sub-int v0, v2, v3

    .line 494
    .local v0, "delta":I
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v2, v2, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 495
    .local v1, "param":Landroid/view/ViewGroup$LayoutParams;
    iget v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mMainPageHeight:I

    int-to-float v2, v2

    int-to-float v3, v0

    mul-float/2addr v3, p2

    add-float/2addr v2, v3

    float-to-int v2, v2

    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 496
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v2, v2, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2, v1}, Landroid/support/v4/view/ViewPager;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 498
    .end local v0    # "delta":I
    .end local v1    # "param":Landroid/view/ViewGroup$LayoutParams;
    :cond_0
    return-void
.end method

.method public onPageSelected(I)V
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 502
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v0, v0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->dots:Lco/vine/android/widget/DotIndicators;

    if-eqz v0, :cond_0

    .line 503
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v0, v0, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->dots:Lco/vine/android/widget/DotIndicators;

    invoke-virtual {v0, p1}, Lco/vine/android/widget/DotIndicators;->setActiveDot(I)V

    .line 505
    :cond_0
    return-void
.end method

.method public onProfileHeaderClick(Landroid/view/View;Lco/vine/android/ProfileFragment;Lco/vine/android/api/VineUser;)V
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "fragment"    # Lco/vine/android/ProfileFragment;
    .param p3, "user"    # Lco/vine/android/api/VineUser;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 385
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    .line 386
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 442
    :cond_0
    :goto_0
    :sswitch_0
    return-void

    .line 388
    :sswitch_1
    const-string v2, "Profile"

    invoke-static {v2}, Lco/vine/android/util/FlurryUtils;->trackVisitFindFriends(Ljava/lang/String;)V

    .line 389
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lco/vine/android/SettingsActivity;

    invoke-direct {v1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 390
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 394
    .end local v1    # "intent":Landroid/content/Intent;
    :sswitch_2
    iget v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowState:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_1

    .line 395
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    iget-object v4, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-wide v4, v4, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->userId:J

    invoke-virtual {v2, v3, v4, v5, v6}, Lco/vine/android/client/AppController;->unfollowUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 397
    iput v7, p3, Lco/vine/android/api/VineUser;->following:I

    .line 398
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v2, v2, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->follow:Landroid/widget/Button;

    invoke-direct {p0, v2, p3}, Lco/vine/android/ProfileHeaderAdapter;->setupFollowButton(Landroid/widget/Button;Lco/vine/android/api/VineUser;)V

    .line 399
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowEventSource:Ljava/lang/String;

    invoke-static {v2}, Lco/vine/android/util/FlurryUtils;->trackFollow(Ljava/lang/String;)V

    goto :goto_0

    .line 400
    :cond_1
    iget v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowState:I

    if-ne v2, v6, :cond_3

    .line 401
    invoke-virtual {p3}, Lco/vine/android/api/VineUser;->isPrivate()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 402
    iget v2, p3, Lco/vine/android/api/VineUser;->followStatus:I

    or-int/lit8 v2, v2, 0x2

    iput v2, p3, Lco/vine/android/api/VineUser;->followStatus:I

    .line 407
    :goto_1
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-object v2, v2, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->follow:Landroid/widget/Button;

    invoke-direct {p0, v2, p3}, Lco/vine/android/ProfileHeaderAdapter;->setupFollowButton(Landroid/widget/Button;Lco/vine/android/api/VineUser;)V

    .line 408
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    iget-object v4, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    iget-wide v4, v4, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->userId:J

    invoke-virtual {v2, v3, v4, v5, v6}, Lco/vine/android/client/AppController;->followUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 404
    :cond_2
    iput v6, p3, Lco/vine/android/api/VineUser;->following:I

    .line 405
    iput v6, p3, Lco/vine/android/api/VineUser;->repostsEnabled:I

    goto :goto_1

    .line 410
    :cond_3
    iget v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mFollowState:I

    const/4 v3, 0x3

    if-ne v2, v3, :cond_0

    goto :goto_0

    .line 420
    :sswitch_3
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mFragment:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    instance-of v2, v2, Lco/vine/android/HomeTabActivity;

    if-eqz v2, :cond_4

    .line 421
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mFragment:Lco/vine/android/ProfileFragment;

    invoke-virtual {v2}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lco/vine/android/HomeTabActivity;

    invoke-virtual {v2}, Lco/vine/android/HomeTabActivity;->resetNav()V

    .line 423
    :cond_4
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    invoke-virtual {p0, v2}, Lco/vine/android/ProfileHeaderAdapter;->changeSelectedTab(I)V

    goto/16 :goto_0

    .line 427
    :sswitch_4
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v2, :cond_0

    .line 428
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    iget-wide v2, v2, Lco/vine/android/api/VineUser;->userId:J

    iget-object v4, p0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_5

    .line 429
    const-string v2, "Profile"

    invoke-static {v2}, Lco/vine/android/util/FlurryUtils;->trackVisitSettings(Ljava/lang/String;)V

    .line 430
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lco/vine/android/SettingsActivity;

    invoke-direct {v2, v0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 432
    :cond_5
    invoke-static {v7}, Lco/vine/android/util/FlurryUtils;->trackProfileImageClick(Z)V

    .line 433
    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    iget-object v2, v2, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    const v3, 0x7f0e021e

    invoke-static {v0, v2, v3}, Lco/vine/android/ImageActivity;->start(Landroid/content/Context;Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 386
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0a0063 -> :sswitch_4
        0x7f0a018c -> :sswitch_1
        0x7f0a018d -> :sswitch_2
        0x7f0a018e -> :sswitch_0
        0x7f0a0190 -> :sswitch_3
        0x7f0a0194 -> :sswitch_3
    .end sparse-switch
.end method

.method public onProfileHeaderLongClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 369
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 382
    :cond_0
    :goto_0
    return-void

    .line 371
    :pswitch_0
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    iget-wide v0, v0, Lco/vine/android/api/VineUser;->userId:J

    iget-object v2, p0, Lco/vine/android/ProfileHeaderAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 372
    const/4 v0, 0x1

    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackProfileImageClick(Z)V

    .line 373
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/view/View;->performHapticFeedback(I)Z

    .line 374
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lco/vine/android/ProfileHeaderAdapter;->mUser:Lco/vine/android/api/VineUser;

    iget-object v1, v1, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    const v2, 0x7f0e021e

    invoke-static {v0, v1, v2}, Lco/vine/android/ImageActivity;->start(Landroid/content/Context;Ljava/lang/String;I)V

    goto :goto_0

    .line 369
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0063
        :pswitch_0
    .end packed-switch
.end method

.method public updatePostCount(II)V
    .locals 11
    .param p1, "count"    # I
    .param p2, "tabToUpdate"    # I

    .prologue
    const/4 v6, 0x1

    const/4 v1, 0x0

    .line 305
    iget-object v10, p0, Lco/vine/android/ProfileHeaderAdapter;->mHolder:Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;

    .line 306
    .local v10, "holder":Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;
    iget-object v0, p0, Lco/vine/android/ProfileHeaderAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 307
    .local v3, "res":Landroid/content/res/Resources;
    if-eqz v3, :cond_0

    if-eqz v10, :cond_0

    .line 308
    if-nez p2, :cond_1

    .line 309
    const v4, 0x7f0d0005

    iget-object v5, v10, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->postsLabel:Lco/vine/android/widget/TypefacesTextView;

    move-object v0, p0

    move v2, p1

    invoke-direct/range {v0 .. v5}, Lco/vine/android/ProfileHeaderAdapter;->invalidateCountAndTabColor(IILandroid/content/res/Resources;ILco/vine/android/widget/TypefacesTextView;)V

    .line 311
    iget-object v0, v10, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->likesLabel:Lco/vine/android/widget/TypefacesTextView;

    invoke-direct {p0, v6, v0}, Lco/vine/android/ProfileHeaderAdapter;->invalidateTabColor(ILandroid/widget/TextView;)V

    .line 318
    :cond_0
    :goto_0
    return-void

    .line 313
    :cond_1
    const v8, 0x7f0d0003

    iget-object v9, v10, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->likesLabel:Lco/vine/android/widget/TypefacesTextView;

    move-object v4, p0

    move v5, v6

    move v6, p1

    move-object v7, v3

    invoke-direct/range {v4 .. v9}, Lco/vine/android/ProfileHeaderAdapter;->invalidateCountAndTabColor(IILandroid/content/res/Resources;ILco/vine/android/widget/TypefacesTextView;)V

    .line 315
    iget-object v0, v10, Lco/vine/android/ProfileHeaderAdapter$ProfileViewHolder;->postsLabel:Lco/vine/android/widget/TypefacesTextView;

    invoke-direct {p0, v1, v0}, Lco/vine/android/ProfileHeaderAdapter;->invalidateTabColor(ILandroid/widget/TextView;)V

    goto :goto_0
.end method
