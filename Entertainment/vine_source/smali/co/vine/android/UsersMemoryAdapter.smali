.class public Lco/vine/android/UsersMemoryAdapter;
.super Landroid/widget/BaseAdapter;
.source "UsersMemoryAdapter.java"


# instance fields
.field protected final mAppController:Lco/vine/android/client/AppController;

.field private final mContext:Landroid/content/Context;

.field private mFollow:Z

.field private mFriendships:Lco/vine/android/Friendships;

.field private mListener:Landroid/view/View$OnClickListener;

.field mLoggedInUserId:J

.field private final mProfileImageSize:I

.field private mSeenIds:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private mUsers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;"
        }
    .end annotation
.end field

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
.method public constructor <init>(Landroid/content/Context;Lco/vine/android/client/AppController;ZLandroid/view/View$OnClickListener;Lco/vine/android/Friendships;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .param p3, "follow"    # Z
    .param p4, "listener"    # Landroid/view/View$OnClickListener;
    .param p5, "friendships"    # Lco/vine/android/Friendships;

    .prologue
    .line 65
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 66
    iput-object p1, p0, Lco/vine/android/UsersMemoryAdapter;->mContext:Landroid/content/Context;

    .line 67
    iput-object p2, p0, Lco/vine/android/UsersMemoryAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 68
    invoke-virtual {p2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/UsersMemoryAdapter;->mLoggedInUserId:J

    .line 69
    iput-boolean p3, p0, Lco/vine/android/UsersMemoryAdapter;->mFollow:Z

    .line 70
    iput-object p4, p0, Lco/vine/android/UsersMemoryAdapter;->mListener:Landroid/view/View$OnClickListener;

    .line 71
    iput-object p5, p0, Lco/vine/android/UsersMemoryAdapter;->mFriendships:Lco/vine/android/Friendships;

    .line 72
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/UsersMemoryAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 73
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0087

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/UsersMemoryAdapter;->mProfileImageSize:I

    .line 74
    return-void
.end method

.method private setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "holder"    # Lco/vine/android/widget/UserViewHolder;
    .param p2, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 225
    iget-object v0, p1, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 226
    if-eqz p2, :cond_0

    .line 227
    iget-object v0, p1, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/UsersMemoryAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 231
    :goto_0
    return-void

    .line 229
    :cond_0
    iget-object v0, p1, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    const v1, 0x7f0200f7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method


# virtual methods
.method public bindView(Landroid/view/View;I)V
    .locals 17
    .param p1, "view"    # Landroid/view/View;
    .param p2, "position"    # I

    .prologue
    .line 107
    move-object/from16 v0, p0

    iget-object v12, v0, Lco/vine/android/UsersMemoryAdapter;->mUsers:Ljava/util/ArrayList;

    move/from16 v0, p2

    invoke-virtual {v12, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lco/vine/android/api/VineUser;

    .line 109
    .local v9, "user":Lco/vine/android/api/VineUser;
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lco/vine/android/widget/UserViewHolder;

    .line 110
    .local v5, "holder":Lco/vine/android/widget/UserViewHolder;
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->username:Landroid/widget/TextView;

    iget-object v13, v9, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    invoke-virtual {v12, v13}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 111
    iget-wide v12, v9, Lco/vine/android/api/VineUser;->userId:J

    iput-wide v12, v5, Lco/vine/android/widget/UserViewHolder;->userId:J

    .line 113
    iget-object v1, v9, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    .line 114
    .local v1, "description":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_0

    .line 115
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->bio:Landroid/widget/TextView;

    invoke-virtual {v12, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 116
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->bio:Landroid/widget/TextView;

    const/4 v13, 0x0

    invoke-virtual {v12, v13}, Landroid/widget/TextView;->setVisibility(I)V

    .line 122
    :goto_0
    iget-object v7, v9, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    .line 123
    .local v7, "location":Ljava/lang/String;
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_1

    .line 124
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->location:Landroid/widget/TextView;

    invoke-virtual {v12, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 125
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->location:Landroid/widget/TextView;

    const/4 v13, 0x0

    invoke-virtual {v12, v13}, Landroid/widget/TextView;->setVisibility(I)V

    .line 131
    :goto_1
    iget v12, v9, Lco/vine/android/api/VineUser;->verified:I

    const/4 v13, 0x1

    if-ne v12, v13, :cond_2

    .line 132
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->verified:Landroid/widget/ImageView;

    const/4 v13, 0x0

    invoke-virtual {v12, v13}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 138
    :goto_2
    iget-object v2, v5, Lco/vine/android/widget/UserViewHolder;->followButton:Landroid/widget/ImageButton;

    .line 139
    .local v2, "followButton":Landroid/widget/ImageButton;
    move-object/from16 v0, p0

    iget-boolean v12, v0, Lco/vine/android/UsersMemoryAdapter;->mFollow:Z

    if-eqz v12, :cond_6

    iget-wide v12, v5, Lco/vine/android/widget/UserViewHolder;->userId:J

    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/UsersMemoryAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v14}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v14

    cmp-long v12, v12, v14

    if-eqz v12, :cond_6

    .line 140
    const/4 v12, 0x0

    invoke-virtual {v2, v12}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 142
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/UsersMemoryAdapter;->mFriendships:Lco/vine/android/Friendships;

    .line 143
    .local v4, "friendships":Lco/vine/android/Friendships;
    iget-wide v10, v9, Lco/vine/android/api/VineUser;->userId:J

    .line 145
    .local v10, "userId":J
    if-eqz v4, :cond_4

    .line 146
    invoke-virtual {v4, v10, v11}, Lco/vine/android/Friendships;->contains(J)Z

    move-result v12

    if-eqz v12, :cond_3

    .line 147
    invoke-virtual {v4, v10, v11}, Lco/vine/android/Friendships;->isFollowing(J)Z

    move-result v3

    .line 155
    .local v3, "following":Z
    :goto_3
    new-instance v12, Lco/vine/android/FollowButtonViewHolder;

    invoke-direct {v12, v10, v11, v3}, Lco/vine/android/FollowButtonViewHolder;-><init>(JZ)V

    invoke-virtual {v2, v12}, Landroid/widget/ImageButton;->setTag(Ljava/lang/Object;)V

    .line 157
    if-eqz v3, :cond_5

    .line 158
    const v12, 0x7f020095

    invoke-virtual {v2, v12}, Landroid/widget/ImageButton;->setBackgroundResource(I)V

    .line 165
    .end local v3    # "following":Z
    .end local v4    # "friendships":Lco/vine/android/Friendships;
    .end local v10    # "userId":J
    :goto_4
    iget-object v8, v9, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    .line 166
    .local v8, "url":Ljava/lang/String;
    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_8

    .line 167
    new-instance v6, Lco/vine/android/util/image/ImageKey;

    move-object/from16 v0, p0

    iget v12, v0, Lco/vine/android/UsersMemoryAdapter;->mProfileImageSize:I

    move-object/from16 v0, p0

    iget v13, v0, Lco/vine/android/UsersMemoryAdapter;->mProfileImageSize:I

    const/4 v14, 0x1

    invoke-direct {v6, v8, v12, v13, v14}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZ)V

    .line 168
    .local v6, "key":Lco/vine/android/util/image/ImageKey;
    invoke-static {v8}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_7

    .line 169
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    sget-object v13, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    const/high16 v14, -0x1000000

    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/UsersMemoryAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v15}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v15

    const v16, 0x7f090096

    invoke-virtual/range {v15 .. v16}, Landroid/content/res/Resources;->getColor(I)I

    move-result v15

    or-int/2addr v14, v15

    invoke-static {v12, v13, v14}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    .line 177
    .end local v6    # "key":Lco/vine/android/util/image/ImageKey;
    :goto_5
    return-void

    .line 118
    .end local v2    # "followButton":Landroid/widget/ImageButton;
    .end local v7    # "location":Ljava/lang/String;
    .end local v8    # "url":Ljava/lang/String;
    :cond_0
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->bio:Landroid/widget/TextView;

    const-string v13, ""

    invoke-virtual {v12, v13}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 119
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->bio:Landroid/widget/TextView;

    const/16 v13, 0x8

    invoke-virtual {v12, v13}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 127
    .restart local v7    # "location":Ljava/lang/String;
    :cond_1
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->location:Landroid/widget/TextView;

    const-string v13, ""

    invoke-virtual {v12, v13}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 128
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->location:Landroid/widget/TextView;

    const/16 v13, 0x8

    invoke-virtual {v12, v13}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 134
    :cond_2
    iget-object v12, v5, Lco/vine/android/widget/UserViewHolder;->verified:Landroid/widget/ImageView;

    const/16 v13, 0x8

    invoke-virtual {v12, v13}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 149
    .restart local v2    # "followButton":Landroid/widget/ImageButton;
    .restart local v4    # "friendships":Lco/vine/android/Friendships;
    .restart local v10    # "userId":J
    :cond_3
    invoke-virtual {v9}, Lco/vine/android/api/VineUser;->isFollowing()Z

    move-result v3

    .restart local v3    # "following":Z
    goto :goto_3

    .line 152
    .end local v3    # "following":Z
    :cond_4
    invoke-virtual {v9}, Lco/vine/android/api/VineUser;->isFollowing()Z

    move-result v3

    .restart local v3    # "following":Z
    goto :goto_3

    .line 160
    :cond_5
    const v12, 0x7f020094

    invoke-virtual {v2, v12}, Landroid/widget/ImageButton;->setBackgroundResource(I)V

    goto :goto_4

    .line 163
    .end local v3    # "following":Z
    .end local v4    # "friendships":Lco/vine/android/Friendships;
    .end local v10    # "userId":J
    :cond_6
    const/16 v12, 0x8

    invoke-virtual {v2, v12}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_4

    .line 171
    .restart local v6    # "key":Lco/vine/android/util/image/ImageKey;
    .restart local v8    # "url":Ljava/lang/String;
    :cond_7
    iput-object v6, v5, Lco/vine/android/widget/UserViewHolder;->avatarUrl:Lco/vine/android/util/image/ImageKey;

    .line 172
    move-object/from16 v0, p0

    iget-object v12, v0, Lco/vine/android/UsersMemoryAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v12, v6}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v12

    move-object/from16 v0, p0

    invoke-direct {v0, v5, v12}, Lco/vine/android/UsersMemoryAdapter;->setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_5

    .line 175
    .end local v6    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_8
    const/4 v12, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v5, v12}, Lco/vine/android/UsersMemoryAdapter;->setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_5
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lco/vine/android/UsersMemoryAdapter;->mUsers:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    .line 200
    iget-object v0, p0, Lco/vine/android/UsersMemoryAdapter;->mUsers:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 202
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 207
    iget-object v0, p0, Lco/vine/android/UsersMemoryAdapter;->mUsers:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    .line 208
    iget-object v0, p0, Lco/vine/android/UsersMemoryAdapter;->mUsers:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 210
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 215
    iget-object v1, p0, Lco/vine/android/UsersMemoryAdapter;->mUsers:Ljava/util/ArrayList;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/UsersMemoryAdapter;->mUsers:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge p1, v1, :cond_0

    .line 216
    iget-object v1, p0, Lco/vine/android/UsersMemoryAdapter;->mUsers:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineUser;

    .line 217
    .local v0, "user":Lco/vine/android/api/VineUser;
    if-eqz v0, :cond_0

    .line 218
    iget-wide v1, v0, Lco/vine/android/api/VineUser;->userId:J

    .line 221
    .end local v0    # "user":Lco/vine/android/api/VineUser;
    :goto_0
    return-wide v1

    :cond_0
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;
    .annotation build Lorg/jetbrains/annotations/Nullable;
    .end annotation

    .prologue
    .line 80
    if-nez p2, :cond_0

    .line 81
    invoke-virtual {p0, p3}, Lco/vine/android/UsersMemoryAdapter;->newView(Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 85
    .local v0, "view":Landroid/view/View;
    :goto_0
    invoke-virtual {p0, v0, p1}, Lco/vine/android/UsersMemoryAdapter;->bindView(Landroid/view/View;I)V

    .line 86
    return-object v0

    .line 83
    .end local v0    # "view":Landroid/view/View;
    :cond_0
    move-object v0, p2

    .restart local v0    # "view":Landroid/view/View;
    goto :goto_0
.end method

.method public mergeData(Ljava/util/ArrayList;Z)V
    .locals 5
    .param p2, "mergeAfter"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 236
    .local p1, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    if-nez p2, :cond_0

    .line 237
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    iput-object v2, p0, Lco/vine/android/UsersMemoryAdapter;->mSeenIds:Ljava/util/HashSet;

    .line 238
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lco/vine/android/UsersMemoryAdapter;->mUsers:Ljava/util/ArrayList;

    .line 241
    :cond_0
    if-eqz p1, :cond_2

    .line 242
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineUser;

    .line 243
    .local v1, "user":Lco/vine/android/api/VineUser;
    iget-object v2, p0, Lco/vine/android/UsersMemoryAdapter;->mSeenIds:Ljava/util/HashSet;

    iget-wide v3, v1, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 244
    iget-object v2, p0, Lco/vine/android/UsersMemoryAdapter;->mSeenIds:Ljava/util/HashSet;

    iget-wide v3, v1, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 245
    iget-object v2, p0, Lco/vine/android/UsersMemoryAdapter;->mUsers:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 250
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "user":Lco/vine/android/api/VineUser;
    :cond_2
    if-eqz p1, :cond_3

    .line 251
    invoke-virtual {p0}, Lco/vine/android/UsersMemoryAdapter;->notifyDataSetChanged()V

    .line 253
    :cond_3
    return-void
.end method

.method public newView(Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 90
    iget-object v3, p0, Lco/vine/android/UsersMemoryAdapter;->mContext:Landroid/content/Context;

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 91
    .local v1, "layoutInflater":Landroid/view/LayoutInflater;
    const v3, 0x7f0300a4

    const/4 v4, 0x0

    invoke-virtual {v1, v3, p1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 93
    .local v2, "v":Landroid/view/View;
    new-instance v0, Lco/vine/android/widget/UserViewHolder;

    invoke-direct {v0, v2}, Lco/vine/android/widget/UserViewHolder;-><init>(Landroid/view/View;)V

    .line 95
    .local v0, "holder":Lco/vine/android/widget/UserViewHolder;
    iget-boolean v3, p0, Lco/vine/android/UsersMemoryAdapter;->mFollow:Z

    if-eqz v3, :cond_0

    .line 96
    iget-object v3, v0, Lco/vine/android/widget/UserViewHolder;->followButton:Landroid/widget/ImageButton;

    iget-object v4, p0, Lco/vine/android/UsersMemoryAdapter;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 101
    :goto_0
    iget-object v3, p0, Lco/vine/android/UsersMemoryAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v4, Ljava/lang/ref/WeakReference;

    invoke-direct {v4, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 102
    invoke-virtual {v2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 103
    return-object v2

    .line 98
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
    .line 180
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    monitor-enter p0

    :try_start_0
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 181
    .local v5, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;>;"
    iget-object v6, p0, Lco/vine/android/UsersMemoryAdapter;->mViewHolders:Ljava/util/ArrayList;

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

    .line 182
    .local v4, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    invoke-virtual {v4}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/UserViewHolder;

    .line 183
    .local v0, "holder":Lco/vine/android/widget/UserViewHolder;
    if-nez v0, :cond_1

    .line 184
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 180
    .end local v0    # "holder":Lco/vine/android/widget/UserViewHolder;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    .end local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 186
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

    .line 187
    .local v2, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 188
    iget-object v6, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v0, v6}, Lco/vine/android/UsersMemoryAdapter;->setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 192
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

    .line 193
    .local v3, "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    iget-object v6, p0, Lco/vine/android/UsersMemoryAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 195
    .end local v3    # "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    :cond_3
    monitor-exit p0

    return-void
.end method
