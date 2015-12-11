.class public Lco/vine/android/MenuUsersAdapter;
.super Landroid/support/v4/widget/CursorAdapter;
.source "MenuUsersAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;
    }
.end annotation


# instance fields
.field protected final mAppController:Lco/vine/android/client/AppController;

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

.field private mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

.field private mLatestRefreshTime:J

.field private final mProfileImageSize:I

.field protected final mViewHolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;",
            ">;>;"
        }
    .end annotation
.end field

.field private mZeroHolder:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Lco/vine/android/client/AppController;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .param p3, "flags"    # I

    .prologue
    .line 41
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p3}, Landroid/support/v4/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 33
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/MenuUsersAdapter;->mAvatars:Ljava/util/HashMap;

    .line 42
    iput-object p2, p0, Lco/vine/android/MenuUsersAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/MenuUsersAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 44
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0087

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/MenuUsersAdapter;->mProfileImageSize:I

    .line 45
    return-void
.end method

.method private invalidateDividerVisibility(Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;Landroid/database/Cursor;)V
    .locals 8
    .param p1, "holder"    # Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;
    .param p2, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/16 v5, 0x8

    const/4 v4, 0x0

    .line 133
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 134
    iget-object v0, p1, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    .line 135
    .local v0, "lastItem":Lco/vine/android/api/VineRecipient;
    invoke-static {p2}, Lco/vine/android/provider/VineDatabaseSQL$UsersQuery;->getVineRecipient(Landroid/database/Cursor;)Lco/vine/android/api/VineRecipient;

    move-result-object v2

    .line 136
    .local v2, "nextItem":Lco/vine/android/api/VineRecipient;
    iget v1, v0, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    .line 137
    .local v1, "lastSectionIndex":I
    iget v6, v2, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    if-ne v6, v1, :cond_0

    iget v6, v2, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    if-eqz v6, :cond_2

    invoke-virtual {v2}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    :cond_0
    const/4 v3, 0x1

    .line 139
    .local v3, "shouldHide":Z
    :goto_0
    iget-object v6, p1, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->divider:Landroid/view/View;

    if-eqz v3, :cond_1

    move v4, v5

    :cond_1
    invoke-virtual {v6, v4}, Landroid/view/View;->setVisibility(I)V

    .line 140
    invoke-interface {p2}, Landroid/database/Cursor;->moveToPrevious()Z

    .line 144
    .end local v0    # "lastItem":Lco/vine/android/api/VineRecipient;
    .end local v1    # "lastSectionIndex":I
    .end local v2    # "nextItem":Lco/vine/android/api/VineRecipient;
    .end local v3    # "shouldHide":Z
    :goto_1
    return-void

    .restart local v0    # "lastItem":Lco/vine/android/api/VineRecipient;
    .restart local v1    # "lastSectionIndex":I
    .restart local v2    # "nextItem":Lco/vine/android/api/VineRecipient;
    :cond_2
    move v3, v4

    .line 137
    goto :goto_0

    .line 142
    .end local v0    # "lastItem":Lco/vine/android/api/VineRecipient;
    .end local v1    # "lastSectionIndex":I
    .end local v2    # "nextItem":Lco/vine/android/api/VineRecipient;
    :cond_3
    iget-object v4, p1, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->divider:Landroid/view/View;

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1
.end method

.method private setUserImage(Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "holder"    # Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;
    .param p2, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 176
    iget-object v0, p1, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->image:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 177
    if-eqz p2, :cond_0

    .line 178
    iget-object v0, p1, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->image:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/MenuUsersAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 182
    :goto_0
    return-void

    .line 180
    :cond_0
    iget-object v0, p1, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->image:Landroid/widget/ImageView;

    const v1, 0x7f0200f7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 12
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 68
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;

    .line 69
    .local v2, "holder":Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;
    invoke-static {p3}, Lco/vine/android/provider/VineDatabaseSQL$UsersQuery;->getVineRecipient(Landroid/database/Cursor;)Lco/vine/android/api/VineRecipient;

    move-result-object v8

    iput-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    .line 70
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->friendName:Landroid/widget/TextView;

    iget-object v9, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v9, v9, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 71
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v8, v8, Lco/vine/android/api/VineRecipient;->avatarUrl:Ljava/lang/String;

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 72
    new-instance v3, Lco/vine/android/util/image/ImageKey;

    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v8, v8, Lco/vine/android/api/VineRecipient;->avatarUrl:Ljava/lang/String;

    iget v9, p0, Lco/vine/android/MenuUsersAdapter;->mProfileImageSize:I

    iget v10, p0, Lco/vine/android/MenuUsersAdapter;->mProfileImageSize:I

    const/4 v11, 0x1

    invoke-direct {v3, v8, v9, v10, v11}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZ)V

    .line 74
    .local v3, "key":Lco/vine/android/util/image/ImageKey;
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v8, v8, Lco/vine/android/api/VineRecipient;->avatarUrl:Ljava/lang/String;

    invoke-static {v8}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 75
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->image:Landroid/widget/ImageView;

    sget-object v9, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    const/high16 v10, -0x1000000

    iget-object v11, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget v11, v11, Lco/vine/android/api/VineRecipient;->color:I

    or-int/2addr v10, v11

    invoke-static {v8, v9, v10}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    .line 95
    .end local v3    # "key":Lco/vine/android/util/image/ImageKey;
    :goto_0
    invoke-interface {p3}, Landroid/database/Cursor;->getPosition()I

    move-result v6

    .line 97
    .local v6, "position":I
    iput v6, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->position:I

    .line 99
    if-nez v6, :cond_4

    .line 100
    new-instance v8, Ljava/lang/ref/WeakReference;

    invoke-direct {v8, v2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v8, p0, Lco/vine/android/MenuUsersAdapter;->mZeroHolder:Ljava/lang/ref/WeakReference;

    .line 101
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-wide v8, v8, Lco/vine/android/api/VineRecipient;->lastFriendRefresh:J

    iput-wide v8, p0, Lco/vine/android/MenuUsersAdapter;->mLatestRefreshTime:J

    .line 102
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->sectionIndicator:Landroid/view/View;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    .line 103
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->sectionTitle:Landroid/widget/TextView;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 104
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->sectionTitle:Landroid/widget/TextView;

    iget-object v9, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v9, v9, Lco/vine/android/api/VineRecipient;->sectionTitle:Ljava/lang/String;

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->sectionSort:Landroid/widget/TextView;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 106
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->sectionSort:Landroid/widget/TextView;

    iget-object v9, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {v9}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 129
    :goto_1
    invoke-direct {p0, v2, p3}, Lco/vine/android/MenuUsersAdapter;->invalidateDividerVisibility(Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;Landroid/database/Cursor;)V

    .line 130
    return-void

    .line 77
    .end local v6    # "position":I
    .restart local v3    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_0
    iput-object v3, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->avatarKey:Lco/vine/android/util/image/ImageKey;

    .line 78
    iget-object v8, p0, Lco/vine/android/MenuUsersAdapter;->mAvatars:Ljava/util/HashMap;

    invoke-virtual {v8, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 79
    .local v1, "bmKey":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/graphics/Bitmap;>;"
    const/4 v0, 0x0

    .line 80
    .local v0, "bm":Landroid/graphics/Bitmap;
    if-eqz v1, :cond_1

    .line 81
    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "bm":Landroid/graphics/Bitmap;
    check-cast v0, Landroid/graphics/Bitmap;

    .line 83
    .restart local v0    # "bm":Landroid/graphics/Bitmap;
    :cond_1
    if-nez v0, :cond_2

    .line 84
    iget-object v8, p0, Lco/vine/android/MenuUsersAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v8, v3}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 85
    if-eqz v0, :cond_2

    .line 86
    iget-object v8, p0, Lco/vine/android/MenuUsersAdapter;->mAvatars:Ljava/util/HashMap;

    new-instance v9, Ljava/lang/ref/WeakReference;

    invoke-direct {v9, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v8, v3, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    :cond_2
    invoke-direct {p0, v2, v0}, Lco/vine/android/MenuUsersAdapter;->setUserImage(Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 92
    .end local v0    # "bm":Landroid/graphics/Bitmap;
    .end local v1    # "bmKey":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/graphics/Bitmap;>;"
    .end local v3    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_3
    const/4 v8, 0x0

    invoke-direct {p0, v2, v8}, Lco/vine/android/MenuUsersAdapter;->setUserImage(Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 108
    .restart local v6    # "position":I
    :cond_4
    invoke-interface {p3}, Landroid/database/Cursor;->moveToPrevious()Z

    .line 109
    invoke-static {p3}, Lco/vine/android/provider/VineDatabaseSQL$UsersQuery;->getVineRecipient(Landroid/database/Cursor;)Lco/vine/android/api/VineRecipient;

    move-result-object v4

    .line 110
    .local v4, "lastItem":Lco/vine/android/api/VineRecipient;
    invoke-interface {p3}, Landroid/database/Cursor;->moveToNext()Z

    .line 111
    iget v5, v4, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    .line 112
    .local v5, "lastSectionIndex":I
    const/4 v7, 0x0

    .line 113
    .local v7, "sectionIndicatorVisible":Z
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget v8, v8, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    if-eq v8, v5, :cond_6

    .line 114
    const/4 v7, 0x1

    .line 115
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->sectionTitle:Landroid/widget/TextView;

    iget-object v9, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v9, v9, Lco/vine/android/api/VineRecipient;->sectionTitle:Ljava/lang/String;

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 116
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->sectionTitle:Landroid/widget/TextView;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 120
    :goto_2
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget v8, v8, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    if-eqz v8, :cond_5

    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {v8}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_5

    .line 122
    const/4 v7, 0x1

    .line 123
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->sectionSort:Landroid/widget/TextView;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 124
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->sectionSort:Landroid/widget/TextView;

    iget-object v9, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {v9}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 126
    :cond_5
    iget-object v9, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->sectionIndicator:Landroid/view/View;

    if-eqz v7, :cond_7

    const/4 v8, 0x0

    :goto_3
    invoke-virtual {v9, v8}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1

    .line 118
    :cond_6
    iget-object v8, v2, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->sectionTitle:Landroid/widget/TextView;

    const/16 v9, 0x8

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_2

    .line 126
    :cond_7
    const/16 v8, 0x8

    goto :goto_3
.end method

.method public getItemId(I)J
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 167
    invoke-super {p0, p1}, Landroid/support/v4/widget/CursorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    .line 168
    .local v0, "c":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    .line 169
    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 171
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

    .prologue
    .line 49
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;

    if-nez v0, :cond_0

    .line 50
    const/4 v0, 0x0

    invoke-super {p0, p1, v0, p3}, Landroid/support/v4/widget/CursorAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 52
    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/widget/CursorAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

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
    const v3, 0x7f030057

    const/4 v4, 0x0

    invoke-virtual {v1, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 60
    .local v2, "v":Landroid/view/View;
    new-instance v0, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;

    invoke-direct {v0, p1, v2}, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;-><init>(Landroid/content/Context;Landroid/view/View;)V

    .line 61
    .local v0, "holder":Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;
    iget-object v3, p0, Lco/vine/android/MenuUsersAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v4, Ljava/lang/ref/WeakReference;

    invoke-direct {v4, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 62
    invoke-virtual {v2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 63
    return-object v2
.end method

.method public setInboxAdapter(Lco/vine/android/MessageBoxAdapter;)V
    .locals 0
    .param p1, "inboxAdapter"    # Lco/vine/android/MessageBoxAdapter;

    .prologue
    .line 185
    iput-object p1, p0, Lco/vine/android/MenuUsersAdapter;->mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

    .line 186
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
    .line 147
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    monitor-enter p0

    :try_start_0
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 148
    .local v5, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;>;>;"
    iget-object v6, p0, Lco/vine/android/MenuUsersAdapter;->mViewHolders:Ljava/util/ArrayList;

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

    .line 149
    .local v4, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;>;"
    invoke-virtual {v4}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;

    .line 150
    .local v0, "holder":Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;
    if-nez v0, :cond_1

    .line 151
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 147
    .end local v0    # "holder":Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;>;"
    .end local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;>;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 153
    .restart local v0    # "holder":Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;>;"
    .restart local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;>;>;"
    :cond_1
    :try_start_1
    iget-object v6, v0, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->avatarKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 154
    .local v2, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 155
    iget-object v6, p0, Lco/vine/android/MenuUsersAdapter;->mAvatars:Ljava/util/HashMap;

    iget-object v7, v0, Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;->avatarKey:Lco/vine/android/util/image/ImageKey;

    new-instance v8, Ljava/lang/ref/WeakReference;

    iget-object v9, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {v8, v9}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v6, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 156
    iget-object v6, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v0, v6}, Lco/vine/android/MenuUsersAdapter;->setUserImage(Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 160
    .end local v0    # "holder":Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;>;"
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

    .line 161
    .local v3, "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;>;"
    iget-object v6, p0, Lco/vine/android/MenuUsersAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 163
    .end local v3    # "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/MenuUsersAdapter$FriendsViewHolder;>;"
    :cond_3
    monitor-exit p0

    return-void
.end method
