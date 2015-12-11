.class public Lco/vine/android/widget/FollowStateButton;
.super Landroid/widget/Button;
.source "FollowStateButton.java"


# static fields
.field public static final STATE_FOLLOWING:I = 0x3

.field public static final STATE_FOLLOW_REQUESTED:I = 0x4

.field public static final STATE_NOT_FOLLOWING:I = 0x2

.field public static final STATE_SELF:I = 0x1


# instance fields
.field private mColor:I

.field private mFollowRequestedDrawableRes:I

.field private mFollowRequestedText:I

.field private mFollowRequestedTextColor:I

.field private mFollowingDrawableRes:I

.field private mFollowingText:I

.field private mFollowingTextColor:I

.field private mNotFollowingDrawableRes:I

.field private mNotFollowingText:I

.field private mNotFollowingTextColor:I

.field private mSelfDrawableRes:I

.field private mSelfText:I

.field private mSelfTextColor:I

.field private mState:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 42
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/widget/FollowStateButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 43
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 46
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/FollowStateButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 47
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const v6, 0x7f09005c

    const/4 v5, 0x5

    const/4 v4, 0x0

    .line 50
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/Button;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 51
    sget-object v2, Lco/vine/android/R$styleable;->FollowStateButton:[I

    invoke-virtual {p1, p2, v2, p3, v4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 54
    .local v0, "a":Landroid/content/res/TypedArray;
    const v2, 0x7f0200c0

    invoke-virtual {v0, v4, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mSelfDrawableRes:I

    .line 56
    const/4 v2, 0x3

    const v3, 0x7f0200b4

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mNotFollowingDrawableRes:I

    .line 59
    const/4 v2, 0x6

    const v3, 0x7f0200b7

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mFollowingDrawableRes:I

    .line 61
    const/16 v2, 0x9

    const v3, 0x7f0200bd

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mFollowRequestedDrawableRes:I

    .line 64
    const/4 v2, 0x1

    const v3, 0x7f0e01c5

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mSelfText:I

    .line 66
    const/4 v2, 0x4

    const v3, 0x7f0e00fb

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mNotFollowingText:I

    .line 68
    const/4 v2, 0x7

    const v3, 0x7f0e0102

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mFollowingText:I

    .line 70
    const/16 v2, 0xa

    const v3, 0x7f0e0100

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mFollowRequestedText:I

    .line 73
    invoke-virtual {p0}, Lco/vine/android/widget/FollowStateButton;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 75
    .local v1, "res":Landroid/content/res/Resources;
    const/4 v2, 0x2

    const v3, 0x7f090070

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mSelfTextColor:I

    .line 77
    invoke-virtual {v1, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v0, v5, v2}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mNotFollowingTextColor:I

    .line 79
    const v2, 0x7f090051

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v0, v5, v2}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mFollowingTextColor:I

    .line 81
    const/16 v2, 0xb

    invoke-virtual {v1, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mFollowRequestedTextColor:I

    .line 84
    const v2, 0x7f090096

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/FollowStateButton;->mColor:I

    .line 85
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 87
    invoke-virtual {p0}, Lco/vine/android/widget/FollowStateButton;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0b0044

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    invoke-virtual {p0, v2, v4, v4, v4}, Lco/vine/android/widget/FollowStateButton;->setPadding(IIII)V

    .line 88
    invoke-virtual {p0}, Lco/vine/android/widget/FollowStateButton;->invalidate()V

    .line 89
    return-void
.end method

.method private setColors()V
    .locals 3

    .prologue
    .line 123
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mColor:I

    .line 124
    .local v0, "color":I
    const/4 v1, -0x1

    iput v1, p0, Lco/vine/android/widget/FollowStateButton;->mFollowingTextColor:I

    .line 125
    iput v0, p0, Lco/vine/android/widget/FollowStateButton;->mNotFollowingTextColor:I

    .line 126
    iput v0, p0, Lco/vine/android/widget/FollowStateButton;->mFollowRequestedTextColor:I

    .line 127
    invoke-virtual {p0}, Lco/vine/android/widget/FollowStateButton;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-eqz v1, :cond_0

    iget v1, p0, Lco/vine/android/widget/FollowStateButton;->mState:I

    const/4 v2, 0x1

    if-eq v1, v2, :cond_0

    .line 128
    invoke-virtual {p0}, Lco/vine/android/widget/FollowStateButton;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v1, v0, v2}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 130
    :cond_0
    return-void
.end method

.method private setState(I)V
    .locals 1
    .param p1, "state"    # I

    .prologue
    .line 171
    packed-switch p1, :pswitch_data_0

    .line 200
    :goto_0
    invoke-direct {p0}, Lco/vine/android/widget/FollowStateButton;->setColors()V

    .line 201
    return-void

    .line 173
    :pswitch_0
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mSelfDrawableRes:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setBackgroundResource(I)V

    .line 174
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mSelfText:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setText(I)V

    .line 175
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mSelfTextColor:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setTextColor(I)V

    .line 176
    const/4 v0, 0x1

    iput v0, p0, Lco/vine/android/widget/FollowStateButton;->mState:I

    goto :goto_0

    .line 180
    :pswitch_1
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mNotFollowingDrawableRes:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setBackgroundResource(I)V

    .line 181
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mNotFollowingText:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setText(I)V

    .line 182
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mNotFollowingTextColor:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setTextColor(I)V

    .line 183
    const/4 v0, 0x2

    iput v0, p0, Lco/vine/android/widget/FollowStateButton;->mState:I

    goto :goto_0

    .line 187
    :pswitch_2
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mFollowingDrawableRes:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setBackgroundResource(I)V

    .line 188
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mFollowingText:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setText(I)V

    .line 189
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mFollowingTextColor:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setTextColor(I)V

    .line 190
    const/4 v0, 0x3

    iput v0, p0, Lco/vine/android/widget/FollowStateButton;->mState:I

    goto :goto_0

    .line 194
    :pswitch_3
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mFollowRequestedDrawableRes:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setBackgroundResource(I)V

    .line 195
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mFollowRequestedText:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setText(I)V

    .line 196
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mFollowRequestedTextColor:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setTextColor(I)V

    goto :goto_0

    .line 171
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method


# virtual methods
.method public follow(Lco/vine/android/api/VineUser;)V
    .locals 3
    .param p1, "user"    # Lco/vine/android/api/VineUser;

    .prologue
    const/4 v2, 0x4

    const/4 v1, 0x3

    .line 142
    invoke-virtual {p1}, Lco/vine/android/api/VineUser;->isPrivate()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 143
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mState:I

    if-eq v0, v2, :cond_0

    .line 144
    invoke-direct {p0, v2}, Lco/vine/android/widget/FollowStateButton;->setState(I)V

    .line 145
    invoke-virtual {p0}, Lco/vine/android/widget/FollowStateButton;->invalidate()V

    .line 153
    :cond_0
    :goto_0
    return-void

    .line 148
    :cond_1
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mState:I

    if-eq v0, v1, :cond_0

    .line 149
    invoke-direct {p0, v1}, Lco/vine/android/widget/FollowStateButton;->setState(I)V

    .line 150
    invoke-virtual {p0}, Lco/vine/android/widget/FollowStateButton;->invalidate()V

    goto :goto_0
.end method

.method public getState()I
    .locals 1

    .prologue
    .line 133
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mState:I

    return v0
.end method

.method public setUser(JLco/vine/android/api/VineUser;)V
    .locals 2
    .param p1, "ownerId"    # J
    .param p3, "user"    # Lco/vine/android/api/VineUser;

    .prologue
    .line 98
    iget v0, p3, Lco/vine/android/api/VineUser;->profileBackground:I

    iput v0, p0, Lco/vine/android/widget/FollowStateButton;->mColor:I

    .line 99
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mColor:I

    sget v1, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v0, v1, :cond_0

    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mColor:I

    if-gtz v0, :cond_1

    .line 100
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/widget/FollowStateButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090096

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/widget/FollowStateButton;->mColor:I

    .line 103
    :cond_1
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mColor:I

    const/high16 v1, -0x1000000

    or-int/2addr v0, v1

    iput v0, p0, Lco/vine/android/widget/FollowStateButton;->mColor:I

    .line 105
    iget-wide v0, p3, Lco/vine/android/api/VineUser;->userId:J

    cmp-long v0, p1, v0

    if-nez v0, :cond_2

    .line 106
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setState(I)V

    .line 115
    :goto_0
    invoke-direct {p0}, Lco/vine/android/widget/FollowStateButton;->setColors()V

    .line 116
    invoke-virtual {p0}, Lco/vine/android/widget/FollowStateButton;->invalidate()V

    .line 117
    return-void

    .line 107
    :cond_2
    invoke-virtual {p3}, Lco/vine/android/api/VineUser;->hasFollowRequested()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 108
    const/4 v0, 0x4

    invoke-direct {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setState(I)V

    goto :goto_0

    .line 109
    :cond_3
    invoke-virtual {p3}, Lco/vine/android/api/VineUser;->isFollowing()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 110
    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setState(I)V

    goto :goto_0

    .line 112
    :cond_4
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lco/vine/android/widget/FollowStateButton;->setState(I)V

    goto :goto_0
.end method

.method public unfollow()V
    .locals 2

    .prologue
    const/4 v1, 0x2

    .line 159
    iget v0, p0, Lco/vine/android/widget/FollowStateButton;->mState:I

    if-eq v0, v1, :cond_0

    .line 160
    invoke-direct {p0, v1}, Lco/vine/android/widget/FollowStateButton;->setState(I)V

    .line 161
    invoke-virtual {p0}, Lco/vine/android/widget/FollowStateButton;->invalidate()V

    .line 163
    :cond_0
    return-void
.end method
