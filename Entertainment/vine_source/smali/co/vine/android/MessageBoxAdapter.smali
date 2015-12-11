.class public Lco/vine/android/MessageBoxAdapter;
.super Landroid/support/v4/widget/CursorAdapter;
.source "MessageBoxAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;
    }
.end annotation


# instance fields
.field private mAppController:Lco/vine/android/client/AppController;

.field private final mAvatars:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;>;"
        }
    .end annotation
.end field

.field private mContext:Landroid/content/Context;

.field private final mDefaultBg:Landroid/graphics/drawable/ColorDrawable;

.field private mFragment:Lco/vine/android/InboxFragment;

.field private mIdsToNotifyFail:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private mViewHolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Lco/vine/android/client/AppController;Lco/vine/android/InboxFragment;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .param p3, "fragment"    # Lco/vine/android/InboxFragment;
    .param p4, "flags"    # I

    .prologue
    .line 47
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p4}, Landroid/support/v4/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 42
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/MessageBoxAdapter;->mAvatars:Ljava/util/HashMap;

    .line 48
    iput-object p2, p0, Lco/vine/android/MessageBoxAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 49
    iput-object p1, p0, Lco/vine/android/MessageBoxAdapter;->mContext:Landroid/content/Context;

    .line 50
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/MessageBoxAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 51
    iput-object p3, p0, Lco/vine/android/MessageBoxAdapter;->mFragment:Lco/vine/android/InboxFragment;

    .line 53
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    iget-object v1, p0, Lco/vine/android/MessageBoxAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090039

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-direct {v0, v1}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    iput-object v0, p0, Lco/vine/android/MessageBoxAdapter;->mDefaultBg:Landroid/graphics/drawable/ColorDrawable;

    .line 54
    return-void
.end method

.method private setUserImage(Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;Landroid/graphics/Bitmap;Z)V
    .locals 4
    .param p1, "holder"    # Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;
    .param p2, "bmp"    # Landroid/graphics/Bitmap;
    .param p3, "loading"    # Z

    .prologue
    const/4 v1, 0x0

    .line 229
    iget-object v0, p1, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 230
    if-eqz p2, :cond_0

    .line 231
    iget-object v0, p1, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->image:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/MessageBoxAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 240
    :goto_0
    return-void

    .line 232
    :cond_0
    if-eqz p3, :cond_1

    .line 233
    iget-object v0, p1, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 234
    iget-object v0, p1, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->image:Landroid/widget/ImageView;

    iget-object v1, p0, Lco/vine/android/MessageBoxAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x106000d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    goto :goto_0

    .line 237
    :cond_1
    iget-object v0, p1, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 238
    iget-object v0, p1, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->image:Landroid/widget/ImageView;

    sget-object v1, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    const/high16 v2, -0x1000000

    iget v3, p1, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->color:I

    or-int/2addr v2, v3

    invoke-static {v0, v1, v2}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    goto :goto_0
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 19
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 68
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;

    .line 70
    .local v6, "holder":Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;
    const/16 v14, 0xe

    move-object/from16 v0, p3

    invoke-interface {v0, v14}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    .line 71
    .local v4, "count":I
    const/16 v14, 0x8

    move-object/from16 v0, p3

    invoke-interface {v0, v14}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v13

    .line 72
    .local v13, "username":Ljava/lang/String;
    const/4 v14, 0x1

    if-ne v4, v14, :cond_5

    .line 73
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->username:Landroid/widget/TextView;

    invoke-virtual {v14, v13}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 74
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->image:Landroid/widget/ImageView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 85
    :goto_0
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->loadMoreContent:Landroid/view/View;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/view/View;->setVisibility(I)V

    .line 86
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->loadMoreProgress:Landroid/view/View;

    const v15, 0x7f0a00b2

    invoke-virtual {v14, v15}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/view/View;->setVisibility(I)V

    .line 87
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->loadMore:Landroid/widget/FrameLayout;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 88
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->retryProgress:Landroid/view/View;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/view/View;->setVisibility(I)V

    .line 90
    const/4 v14, 0x2

    move-object/from16 v0, p3

    invoke-interface {v0, v14}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    .line 91
    .local v9, "timestamp":J
    const/4 v14, 0x1

    move-object/from16 v0, p2

    invoke-static {v0, v9, v10, v14}, Lco/vine/android/util/Util;->getRelativeTimeString(Landroid/content/Context;JZ)Ljava/lang/String;

    move-result-object v8

    .line 92
    .local v8, "relativeTime":Ljava/lang/String;
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->timestamp:Landroid/widget/TextView;

    invoke-virtual {v14, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 94
    const/16 v14, 0xd

    move-object/from16 v0, p3

    invoke-interface {v0, v14}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    .line 95
    .local v3, "color":I
    sget v14, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v3, v14, :cond_0

    if-gtz v3, :cond_1

    .line 96
    :cond_0
    const v14, 0xffffff

    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/MessageBoxAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v15}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v15

    const v16, 0x7f090096

    invoke-virtual/range {v15 .. v16}, Landroid/content/res/Resources;->getColor(I)I

    move-result v15

    and-int v3, v14, v15

    .line 98
    :cond_1
    iput v3, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->color:I

    .line 99
    const/4 v14, 0x4

    move-object/from16 v0, p3

    invoke-interface {v0, v14}, Landroid/database/Cursor;->getInt(I)I

    move-result v11

    .line 100
    .local v11, "unreadCount":I
    if-lez v11, :cond_8

    .line 101
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->unreadCount:Landroid/widget/TextView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 102
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->unreadCount:Landroid/widget/TextView;

    invoke-static {v11}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 103
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->unreadCount:Landroid/widget/TextView;

    invoke-virtual {v14}, Landroid/widget/TextView;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v14

    new-instance v15, Landroid/graphics/PorterDuffColorFilter;

    const/high16 v16, -0x1000000

    or-int v16, v16, v3

    sget-object v17, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct/range {v15 .. v17}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v14, v15}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 108
    :goto_1
    const/16 v14, 0xf

    move-object/from16 v0, p3

    invoke-interface {v0, v14}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 109
    .local v5, "errorMessage":Ljava/lang/String;
    const/4 v14, 0x1

    if-eq v4, v14, :cond_2

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-eqz v14, :cond_9

    .line 110
    :cond_2
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->username:Landroid/widget/TextView;

    const/high16 v15, -0x1000000

    or-int/2addr v15, v3

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setTextColor(I)V

    .line 111
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->failedUpload:Landroid/widget/ImageView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 112
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->timestamp:Landroid/widget/TextView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 113
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->tapToRetry:Landroid/widget/TextView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 124
    :goto_2
    const/16 v14, 0xc

    move-object/from16 v0, p3

    invoke-interface {v0, v14}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    .line 125
    .local v12, "url":Ljava/lang/String;
    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_d

    .line 126
    new-instance v7, Lco/vine/android/util/image/ImageKey;

    const/4 v14, 0x1

    invoke-direct {v7, v12, v14}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;Z)V

    .line 127
    .local v7, "key":Lco/vine/android/util/image/ImageKey;
    invoke-static {v12}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_a

    .line 128
    const/4 v14, 0x0

    const/4 v15, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v6, v14, v15}, Lco/vine/android/MessageBoxAdapter;->setUserImage(Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;Landroid/graphics/Bitmap;Z)V

    .line 148
    .end local v7    # "key":Lco/vine/android/util/image/ImageKey;
    :goto_3
    invoke-interface/range {p3 .. p3}, Landroid/database/Cursor;->isLast()Z

    move-result v14

    if-eqz v14, :cond_e

    .line 149
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->divider:Landroid/view/View;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/view/View;->setVisibility(I)V

    .line 150
    const/4 v14, 0x7

    move-object/from16 v0, p3

    invoke-interface {v0, v14}, Landroid/database/Cursor;->getInt(I)I

    move-result v14

    const/4 v15, 0x1

    if-eq v14, v15, :cond_4

    .line 151
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->divider:Landroid/view/View;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/view/View;->setVisibility(I)V

    .line 152
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->loadMore:Landroid/widget/FrameLayout;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 153
    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/MessageBoxAdapter;->mFragment:Lco/vine/android/InboxFragment;

    invoke-virtual {v14}, Lco/vine/android/InboxFragment;->isLoadingMore()Z

    move-result v14

    if-eqz v14, :cond_3

    .line 154
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->loadMoreContent:Landroid/view/View;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/view/View;->setVisibility(I)V

    .line 155
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->loadMoreProgress:Landroid/view/View;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/view/View;->setVisibility(I)V

    .line 157
    :cond_3
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->loadMore:Landroid/widget/FrameLayout;

    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/MessageBoxAdapter;->mFragment:Lco/vine/android/InboxFragment;

    invoke-virtual {v14, v15}, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 163
    :cond_4
    :goto_4
    return-void

    .line 76
    .end local v3    # "color":I
    .end local v5    # "errorMessage":Ljava/lang/String;
    .end local v8    # "relativeTime":Ljava/lang/String;
    .end local v9    # "timestamp":J
    .end local v11    # "unreadCount":I
    .end local v12    # "url":Ljava/lang/String;
    :cond_5
    const/4 v14, 0x2

    if-ne v4, v14, :cond_7

    .line 77
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v14, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/MessageBoxAdapter;->mContext:Landroid/content/Context;

    const v16, 0x7f0e004d

    invoke-virtual/range {v15 .. v16}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 78
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->username:Landroid/widget/TextView;

    invoke-virtual {v14, v13}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 83
    :cond_6
    :goto_5
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->image:Landroid/widget/ImageView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_0

    .line 79
    :cond_7
    const/4 v14, 0x2

    if-le v4, v14, :cond_6

    .line 80
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v14, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/MessageBoxAdapter;->mContext:Landroid/content/Context;

    const v16, 0x7f0e004c

    invoke-virtual/range {v15 .. v16}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v15

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    add-int/lit8 v18, v4, -0x1

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v15 .. v16}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 81
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->username:Landroid/widget/TextView;

    invoke-virtual {v14, v13}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_5

    .line 105
    .restart local v3    # "color":I
    .restart local v8    # "relativeTime":Ljava/lang/String;
    .restart local v9    # "timestamp":J
    .restart local v11    # "unreadCount":I
    :cond_8
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->unreadCount:Landroid/widget/TextView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 116
    .restart local v5    # "errorMessage":Ljava/lang/String;
    :cond_9
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->username:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/MessageBoxAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v15}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v15

    const v16, 0x7f09003f

    invoke-virtual/range {v15 .. v16}, Landroid/content/res/Resources;->getColor(I)I

    move-result v15

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setTextColor(I)V

    .line 117
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->unreadCount:Landroid/widget/TextView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 118
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->failedUpload:Landroid/widget/ImageView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 119
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->timestamp:Landroid/widget/TextView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 120
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->tapToRetry:Landroid/widget/TextView;

    const v15, 0x7f0e013b

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setText(I)V

    .line 121
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->tapToRetry:Landroid/widget/TextView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_2

    .line 130
    .restart local v7    # "key":Lco/vine/android/util/image/ImageKey;
    .restart local v12    # "url":Ljava/lang/String;
    :cond_a
    iput-object v7, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->avatarUrl:Lco/vine/android/util/image/ImageKey;

    .line 131
    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/MessageBoxAdapter;->mAvatars:Ljava/util/HashMap;

    invoke-virtual {v14, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/WeakReference;

    .line 132
    .local v2, "bmKey":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/graphics/Bitmap;>;"
    const/4 v1, 0x0

    .line 133
    .local v1, "bm":Landroid/graphics/Bitmap;
    if-eqz v2, :cond_b

    .line 134
    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "bm":Landroid/graphics/Bitmap;
    check-cast v1, Landroid/graphics/Bitmap;

    .line 136
    .restart local v1    # "bm":Landroid/graphics/Bitmap;
    :cond_b
    if-nez v1, :cond_c

    .line 137
    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/MessageBoxAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v14, v7}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 138
    if-eqz v1, :cond_c

    .line 139
    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/MessageBoxAdapter;->mAvatars:Ljava/util/HashMap;

    new-instance v15, Ljava/lang/ref/WeakReference;

    invoke-direct {v15, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v14, v7, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    :cond_c
    const/4 v14, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v6, v1, v14}, Lco/vine/android/MessageBoxAdapter;->setUserImage(Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;Landroid/graphics/Bitmap;Z)V

    goto/16 :goto_3

    .line 145
    .end local v1    # "bm":Landroid/graphics/Bitmap;
    .end local v2    # "bmKey":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/graphics/Bitmap;>;"
    .end local v7    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_d
    const/4 v14, 0x0

    const/4 v15, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v6, v14, v15}, Lco/vine/android/MessageBoxAdapter;->setUserImage(Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;Landroid/graphics/Bitmap;Z)V

    goto/16 :goto_3

    .line 160
    :cond_e
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->divider:Landroid/view/View;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/view/View;->setVisibility(I)V

    .line 161
    iget-object v14, v6, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->loadMore:Landroid/widget/FrameLayout;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/FrameLayout;->setVisibility(I)V

    goto/16 :goto_4
.end method

.method public getItemId(I)J
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 167
    invoke-virtual {p0}, Lco/vine/android/MessageBoxAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 168
    .local v0, "cursor":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 169
    const/4 v1, 0x3

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 171
    :goto_0
    return-wide v1

    :cond_0
    invoke-super {p0, p1}, Landroid/support/v4/widget/CursorAdapter;->getItemId(I)J

    move-result-wide v1

    goto :goto_0
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 58
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 59
    .local v1, "layoutInflater":Landroid/view/LayoutInflater;
    const v3, 0x7f03004c

    const/4 v4, 0x0

    invoke-virtual {v1, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 60
    .local v2, "v":Landroid/view/View;
    new-instance v0, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;

    invoke-direct {v0, p0, v2}, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;-><init>(Lco/vine/android/MessageBoxAdapter;Landroid/view/View;)V

    .line 61
    .local v0, "holder":Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;
    invoke-virtual {v2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 62
    iget-object v3, p0, Lco/vine/android/MessageBoxAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v4, Ljava/lang/ref/WeakReference;

    invoke-direct {v4, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 63
    return-object v2
.end method

.method public setIdsToNotifyFailed(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 176
    .local p1, "idsToNotifyFailed":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    iput-object p1, p0, Lco/vine/android/MessageBoxAdapter;->mIdsToNotifyFail:Ljava/util/ArrayList;

    .line 177
    return-void
.end method

.method public declared-synchronized setUserImages(Ljava/util/HashMap;)V
    .locals 10
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
    .line 210
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    monitor-enter p0

    :try_start_0
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 211
    .local v5, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;>;>;"
    iget-object v6, p0, Lco/vine/android/MessageBoxAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/ref/WeakReference;

    .line 212
    .local v4, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;>;"
    invoke-virtual {v4}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;

    .line 213
    .local v0, "holder":Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;
    if-nez v0, :cond_1

    .line 214
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 210
    .end local v0    # "holder":Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;>;"
    .end local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;>;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 216
    .restart local v0    # "holder":Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;>;"
    .restart local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;>;>;"
    :cond_1
    :try_start_1
    iget-object v6, v0, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->avatarUrl:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 217
    .local v2, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 218
    iget-object v6, p0, Lco/vine/android/MessageBoxAdapter;->mAvatars:Ljava/util/HashMap;

    iget-object v7, v0, Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;->avatarUrl:Lco/vine/android/util/image/ImageKey;

    new-instance v8, Ljava/lang/ref/WeakReference;

    iget-object v9, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {v8, v9}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v6, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 219
    iget-object v6, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    const/4 v7, 0x1

    invoke-direct {p0, v0, v6, v7}, Lco/vine/android/MessageBoxAdapter;->setUserImage(Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;Landroid/graphics/Bitmap;Z)V

    goto :goto_0

    .line 223
    .end local v0    # "holder":Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;>;"
    :cond_2
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/ref/WeakReference;

    .line 224
    .local v3, "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;>;"
    iget-object v6, p0, Lco/vine/android/MessageBoxAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 226
    .end local v3    # "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MessageBoxAdapter$ConversationViewHolder;>;"
    :cond_3
    monitor-exit p0

    return-void
.end method
