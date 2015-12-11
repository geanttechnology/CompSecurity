.class public Lco/vine/android/UsersAdapter;
.super Landroid/support/v4/widget/CursorAdapter;
.source "UsersAdapter.java"


# instance fields
.field protected final mAppController:Lco/vine/android/client/AppController;

.field private mFollow:Z

.field private mFriendships:Lco/vine/android/Friendships;

.field private mListener:Landroid/view/View$OnClickListener;

.field mLoggedInUserId:J

.field private final mProfileImageSize:I

.field protected final mViewHolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/widget/UserViewHolder;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Lco/vine/android/client/AppController;ZLandroid/view/View$OnClickListener;Lco/vine/android/Friendships;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .param p3, "follow"    # Z
    .param p4, "listener"    # Landroid/view/View$OnClickListener;
    .param p5, "friendships"    # Lco/vine/android/Friendships;
    .param p6, "flags"    # I

    .prologue
    .line 71
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p6}, Landroid/support/v4/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 72
    iput-object p2, p0, Lco/vine/android/UsersAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 73
    invoke-virtual {p2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/UsersAdapter;->mLoggedInUserId:J

    .line 74
    iput-boolean p3, p0, Lco/vine/android/UsersAdapter;->mFollow:Z

    .line 75
    iput-object p4, p0, Lco/vine/android/UsersAdapter;->mListener:Landroid/view/View$OnClickListener;

    .line 76
    iput-object p5, p0, Lco/vine/android/UsersAdapter;->mFriendships:Lco/vine/android/Friendships;

    .line 77
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/UsersAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 78
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0087

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/UsersAdapter;->mProfileImageSize:I

    .line 79
    return-void
.end method

.method private setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "holder"    # Lco/vine/android/widget/UserViewHolder;
    .param p2, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 206
    iget-object v0, p1, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 207
    if-eqz p2, :cond_0

    .line 208
    iget-object v0, p1, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/UsersAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 212
    :goto_0
    return-void

    .line 210
    :cond_0
    iget-object v0, p1, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    const v1, 0x7f0200f7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 16
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 101
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lco/vine/android/widget/UserViewHolder;

    .line 102
    .local v5, "holder":Lco/vine/android/widget/UserViewHolder;
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->username:Landroid/widget/TextView;

    const/16 v12, 0xd

    move-object/from16 v0, p3

    invoke-interface {v0, v12}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 103
    const/4 v11, 0x1

    move-object/from16 v0, p3

    invoke-interface {v0, v11}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v11

    iput-wide v11, v5, Lco/vine/android/widget/UserViewHolder;->userId:J

    .line 105
    const/4 v11, 0x5

    move-object/from16 v0, p3

    invoke-interface {v0, v11}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 106
    .local v1, "description":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_0

    .line 107
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->bio:Landroid/widget/TextView;

    invoke-virtual {v11, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 108
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->bio:Landroid/widget/TextView;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setVisibility(I)V

    .line 114
    :goto_0
    const/4 v11, 0x6

    move-object/from16 v0, p3

    invoke-interface {v0, v11}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 115
    .local v7, "location":Ljava/lang/String;
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_1

    .line 116
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->location:Landroid/widget/TextView;

    invoke-virtual {v11, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 117
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->location:Landroid/widget/TextView;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setVisibility(I)V

    .line 123
    :goto_1
    const/16 v11, 0xe

    move-object/from16 v0, p3

    invoke-interface {v0, v11}, Landroid/database/Cursor;->getInt(I)I

    move-result v11

    const/4 v12, 0x1

    if-ne v11, v12, :cond_2

    .line 124
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->verified:Landroid/widget/ImageView;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 130
    :goto_2
    iget-object v2, v5, Lco/vine/android/widget/UserViewHolder;->followButton:Landroid/widget/ImageButton;

    .line 131
    .local v2, "followButton":Landroid/widget/ImageButton;
    move-object/from16 v0, p0

    iget-boolean v11, v0, Lco/vine/android/UsersAdapter;->mFollow:Z

    if-eqz v11, :cond_8

    iget-wide v11, v5, Lco/vine/android/widget/UserViewHolder;->userId:J

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/UsersAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v13}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v13

    cmp-long v11, v11, v13

    if-eqz v11, :cond_8

    .line 132
    const/4 v11, 0x0

    invoke-virtual {v2, v11}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 134
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/UsersAdapter;->mFriendships:Lco/vine/android/Friendships;

    .line 135
    .local v4, "friendships":Lco/vine/android/Friendships;
    const/4 v11, 0x1

    move-object/from16 v0, p3

    invoke-interface {v0, v11}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    .line 137
    .local v9, "userId":J
    if-eqz v4, :cond_5

    .line 138
    invoke-virtual {v4, v9, v10}, Lco/vine/android/Friendships;->contains(J)Z

    move-result v11

    if-eqz v11, :cond_3

    .line 139
    invoke-virtual {v4, v9, v10}, Lco/vine/android/Friendships;->isFollowing(J)Z

    move-result v3

    .line 149
    .local v3, "following":Z
    :goto_3
    new-instance v11, Lco/vine/android/FollowButtonViewHolder;

    invoke-direct {v11, v9, v10, v3}, Lco/vine/android/FollowButtonViewHolder;-><init>(JZ)V

    invoke-virtual {v2, v11}, Landroid/widget/ImageButton;->setTag(Ljava/lang/Object;)V

    .line 151
    if-eqz v3, :cond_7

    .line 152
    const v11, 0x7f020095

    invoke-virtual {v2, v11}, Landroid/widget/ImageButton;->setBackgroundResource(I)V

    .line 159
    .end local v3    # "following":Z
    .end local v4    # "friendships":Lco/vine/android/Friendships;
    .end local v9    # "userId":J
    :goto_4
    const/4 v11, 0x2

    move-object/from16 v0, p3

    invoke-interface {v0, v11}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 160
    .local v8, "url":Ljava/lang/String;
    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_a

    .line 161
    new-instance v6, Lco/vine/android/util/image/ImageKey;

    move-object/from16 v0, p0

    iget v11, v0, Lco/vine/android/UsersAdapter;->mProfileImageSize:I

    move-object/from16 v0, p0

    iget v12, v0, Lco/vine/android/UsersAdapter;->mProfileImageSize:I

    const/4 v13, 0x1

    invoke-direct {v6, v8, v11, v12, v13}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZ)V

    .line 162
    .local v6, "key":Lco/vine/android/util/image/ImageKey;
    invoke-static {v8}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_9

    .line 163
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    sget-object v12, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    const/high16 v13, -0x1000000

    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/UsersAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v14}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    const v15, 0x7f090096

    invoke-virtual {v14, v15}, Landroid/content/res/Resources;->getColor(I)I

    move-result v14

    or-int/2addr v13, v14

    invoke-static {v11, v12, v13}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    .line 171
    .end local v6    # "key":Lco/vine/android/util/image/ImageKey;
    :goto_5
    return-void

    .line 110
    .end local v2    # "followButton":Landroid/widget/ImageButton;
    .end local v7    # "location":Ljava/lang/String;
    .end local v8    # "url":Ljava/lang/String;
    :cond_0
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->bio:Landroid/widget/TextView;

    const-string v12, ""

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 111
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->bio:Landroid/widget/TextView;

    const/16 v12, 0x8

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 119
    .restart local v7    # "location":Ljava/lang/String;
    :cond_1
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->location:Landroid/widget/TextView;

    const-string v12, ""

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 120
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->location:Landroid/widget/TextView;

    const/16 v12, 0x8

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 126
    :cond_2
    iget-object v11, v5, Lco/vine/android/widget/UserViewHolder;->verified:Landroid/widget/ImageView;

    const/16 v12, 0x8

    invoke-virtual {v11, v12}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 141
    .restart local v2    # "followButton":Landroid/widget/ImageButton;
    .restart local v4    # "friendships":Lco/vine/android/Friendships;
    .restart local v9    # "userId":J
    :cond_3
    const/16 v11, 0xa

    move-object/from16 v0, p3

    invoke-interface {v0, v11}, Landroid/database/Cursor;->getInt(I)I

    move-result v11

    and-int/lit8 v11, v11, 0x1

    if-lez v11, :cond_4

    const/4 v3, 0x1

    .restart local v3    # "following":Z
    :goto_6
    goto/16 :goto_3

    .end local v3    # "following":Z
    :cond_4
    const/4 v3, 0x0

    goto :goto_6

    .line 145
    :cond_5
    const/16 v11, 0xa

    move-object/from16 v0, p3

    invoke-interface {v0, v11}, Landroid/database/Cursor;->getInt(I)I

    move-result v11

    and-int/lit8 v11, v11, 0x1

    if-lez v11, :cond_6

    const/4 v3, 0x1

    .restart local v3    # "following":Z
    :goto_7
    goto/16 :goto_3

    .end local v3    # "following":Z
    :cond_6
    const/4 v3, 0x0

    goto :goto_7

    .line 154
    .restart local v3    # "following":Z
    :cond_7
    const v11, 0x7f020094

    invoke-virtual {v2, v11}, Landroid/widget/ImageButton;->setBackgroundResource(I)V

    goto/16 :goto_4

    .line 157
    .end local v3    # "following":Z
    .end local v4    # "friendships":Lco/vine/android/Friendships;
    .end local v9    # "userId":J
    :cond_8
    const/16 v11, 0x8

    invoke-virtual {v2, v11}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto/16 :goto_4

    .line 165
    .restart local v6    # "key":Lco/vine/android/util/image/ImageKey;
    .restart local v8    # "url":Ljava/lang/String;
    :cond_9
    iput-object v6, v5, Lco/vine/android/widget/UserViewHolder;->avatarUrl:Lco/vine/android/util/image/ImageKey;

    .line 166
    move-object/from16 v0, p0

    iget-object v11, v0, Lco/vine/android/UsersAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v11, v6}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v11

    move-object/from16 v0, p0

    invoke-direct {v0, v5, v11}, Lco/vine/android/UsersAdapter;->setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_5

    .line 169
    .end local v6    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_a
    const/4 v11, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v5, v11}, Lco/vine/android/UsersAdapter;->setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_5
.end method

.method public getItemId(I)J
    .locals 4
    .param p1, "position"    # I

    .prologue
    const-wide/16 v1, 0x0

    .line 193
    invoke-super {p0, p1}, Landroid/support/v4/widget/CursorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    .line 194
    .local v0, "c":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    .line 195
    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 196
    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 201
    :cond_0
    return-wide v1
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 83
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 84
    .local v1, "layoutInflater":Landroid/view/LayoutInflater;
    const v3, 0x7f0300a4

    const/4 v4, 0x0

    invoke-virtual {v1, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 86
    .local v2, "v":Landroid/view/View;
    new-instance v0, Lco/vine/android/widget/UserViewHolder;

    invoke-direct {v0, v2}, Lco/vine/android/widget/UserViewHolder;-><init>(Landroid/view/View;)V

    .line 88
    .local v0, "holder":Lco/vine/android/widget/UserViewHolder;
    iget-boolean v3, p0, Lco/vine/android/UsersAdapter;->mFollow:Z

    if-eqz v3, :cond_0

    .line 89
    iget-object v3, v0, Lco/vine/android/widget/UserViewHolder;->followButton:Landroid/widget/ImageButton;

    iget-object v4, p0, Lco/vine/android/UsersAdapter;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 94
    :goto_0
    iget-object v3, p0, Lco/vine/android/UsersAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v4, Ljava/lang/ref/WeakReference;

    invoke-direct {v4, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 95
    invoke-virtual {v2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 96
    return-object v2

    .line 91
    :cond_0
    iget-object v3, v0, Lco/vine/android/widget/UserViewHolder;->followButton:Landroid/widget/ImageButton;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0
.end method

.method public declared-synchronized setUserImages(Ljava/util/HashMap;)V
    .locals 7
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
    .line 174
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    monitor-enter p0

    :try_start_0
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 175
    .local v5, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;>;"
    iget-object v6, p0, Lco/vine/android/UsersAdapter;->mViewHolders:Ljava/util/ArrayList;

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

    .line 176
    .local v4, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    invoke-virtual {v4}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/UserViewHolder;

    .line 177
    .local v0, "holder":Lco/vine/android/widget/UserViewHolder;
    if-nez v0, :cond_1

    .line 178
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 174
    .end local v0    # "holder":Lco/vine/android/widget/UserViewHolder;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    .end local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 180
    .restart local v0    # "holder":Lco/vine/android/widget/UserViewHolder;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    .restart local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;>;"
    :cond_1
    :try_start_1
    iget-object v6, v0, Lco/vine/android/widget/UserViewHolder;->avatarUrl:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 181
    .local v2, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 182
    iget-object v6, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v0, v6}, Lco/vine/android/UsersAdapter;->setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 186
    .end local v0    # "holder":Lco/vine/android/widget/UserViewHolder;
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
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

    .line 187
    .local v3, "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    iget-object v6, p0, Lco/vine/android/UsersAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 189
    .end local v3    # "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    :cond_3
    monitor-exit p0

    return-void
.end method
