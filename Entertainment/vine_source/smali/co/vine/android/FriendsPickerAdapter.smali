.class public Lco/vine/android/FriendsPickerAdapter;
.super Landroid/support/v4/widget/CursorAdapter;
.source "FriendsPickerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/FriendsPickerAdapter$1;
    }
.end annotation


# instance fields
.field private mAppController:Lco/vine/android/client/AppController;

.field private final mFragment:Lco/vine/android/FriendsRecipientPickerFragment;

.field private mLatestRefreshTime:J

.field private final mSelectedBackgroundMap:Lco/vine/android/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/util/SparseArray",
            "<",
            "Landroid/graphics/drawable/Drawable;",
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
            "Lco/vine/android/FriendsPickerViewHolder;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Lco/vine/android/client/AppController;ILco/vine/android/FriendsRecipientPickerFragment;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .param p3, "flags"    # I
    .param p4, "fragment"    # Lco/vine/android/FriendsRecipientPickerFragment;

    .prologue
    .line 39
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p3}, Landroid/support/v4/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 35
    new-instance v0, Lco/vine/android/util/SparseArray;

    invoke-direct {v0}, Lco/vine/android/util/SparseArray;-><init>()V

    iput-object v0, p0, Lco/vine/android/FriendsPickerAdapter;->mSelectedBackgroundMap:Lco/vine/android/util/SparseArray;

    .line 40
    iput-object p2, p0, Lco/vine/android/FriendsPickerAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 41
    iput-object p4, p0, Lco/vine/android/FriendsPickerAdapter;->mFragment:Lco/vine/android/FriendsRecipientPickerFragment;

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/FriendsPickerAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 43
    return-void
.end method

.method private setUserImage(Lco/vine/android/FriendsPickerViewHolder;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "holder"    # Lco/vine/android/FriendsPickerViewHolder;
    .param p2, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v1, 0x0

    .line 174
    iget-object v0, p1, Lco/vine/android/FriendsPickerViewHolder;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 175
    if-eqz p2, :cond_0

    .line 176
    iget-object v0, p1, Lco/vine/android/FriendsPickerViewHolder;->image:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/FriendsPickerAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 180
    :goto_0
    return-void

    .line 178
    :cond_0
    iget-object v0, p1, Lco/vine/android/FriendsPickerViewHolder;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method


# virtual methods
.method public bindView(ILandroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 11
    .param p1, "position"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 94
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/FriendsPickerViewHolder;

    .local v2, "holder":Lco/vine/android/FriendsPickerViewHolder;
    move-object v6, p4

    .line 96
    check-cast v6, Lco/vine/android/provider/FriendsPickerExclusiveCursor;

    .line 98
    .local v6, "theCursor":Lco/vine/android/provider/FriendsPickerExclusiveCursor;
    invoke-virtual {v6, p1}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->getItem(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lco/vine/android/api/VineRecipient;

    iput-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    .line 100
    if-nez p1, :cond_5

    .line 101
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-wide v8, v8, Lco/vine/android/api/VineRecipient;->lastFriendRefresh:J

    iput-wide v8, p0, Lco/vine/android/FriendsPickerAdapter;->mLatestRefreshTime:J

    .line 102
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionIndicator:Landroid/view/View;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    .line 103
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionTitle:Landroid/widget/TextView;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 104
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionTitle:Landroid/widget/TextView;

    iget-object v9, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v9, v9, Lco/vine/android/api/VineRecipient;->sectionTitle:Ljava/lang/String;

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget v8, v8, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    if-eqz v8, :cond_4

    .line 106
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionSort:Landroid/widget/TextView;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 107
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionSort:Landroid/widget/TextView;

    iget-object v9, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {v9}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 131
    :cond_0
    :goto_0
    add-int/lit8 v8, p1, 0x1

    invoke-virtual {v6}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->getCount()I

    move-result v9

    if-ge v8, v9, :cond_1

    .line 132
    iget-object v9, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    add-int/lit8 v8, p1, 0x1

    invoke-virtual {v6, v8}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->getItem(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lco/vine/android/api/VineRecipient;

    invoke-virtual {p0, v9, v8}, Lco/vine/android/FriendsPickerAdapter;->haveSectionIndicator(Lco/vine/android/api/VineRecipient;Lco/vine/android/api/VineRecipient;)Z

    move-result v8

    if-eqz v8, :cond_8

    .line 133
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->divider:Landroid/view/View;

    const/16 v9, 0x8

    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    .line 139
    :cond_1
    :goto_1
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget v0, v8, Lco/vine/android/api/VineRecipient;->color:I

    .line 140
    .local v0, "color":I
    sget v8, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v0, v8, :cond_2

    if-gtz v0, :cond_3

    .line 141
    :cond_2
    const v8, 0xffffff

    iget-object v9, p0, Lco/vine/android/FriendsPickerAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v9}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const v10, 0x7f090096

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    and-int v0, v8, v9

    .line 144
    :cond_3
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->username:Landroid/widget/TextView;

    iget-object v9, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v9, v9, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 145
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->username:Landroid/widget/TextView;

    const/high16 v9, -0x1000000

    or-int/2addr v9, v0

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 146
    invoke-virtual {p3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    iget-object v9, p0, Lco/vine/android/FriendsPickerAdapter;->mFragment:Lco/vine/android/FriendsRecipientPickerFragment;

    iget-object v10, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {v9, v10}, Lco/vine/android/FriendsRecipientPickerFragment;->isRecipientSelected(Lco/vine/android/api/VineRecipient;)Z

    move-result v9

    invoke-virtual {v2, v8, v9}, Lco/vine/android/FriendsPickerViewHolder;->setSelected(Landroid/content/res/Resources;Z)V

    .line 148
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v7, v8, Lco/vine/android/api/VineRecipient;->avatarUrl:Ljava/lang/String;

    .line 149
    .local v7, "url":Ljava/lang/String;
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_a

    .line 150
    new-instance v3, Lco/vine/android/util/image/ImageKey;

    const/4 v8, 0x1

    invoke-direct {v3, v7, v8}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;Z)V

    .line 151
    .local v3, "key":Lco/vine/android/util/image/ImageKey;
    invoke-static {v7}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_9

    .line 152
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->image:Landroid/widget/ImageView;

    sget-object v9, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    const/high16 v10, -0x1000000

    or-int/2addr v10, v0

    invoke-static {v8, v9, v10}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    .line 160
    .end local v3    # "key":Lco/vine/android/util/image/ImageKey;
    :goto_2
    return-void

    .line 109
    .end local v0    # "color":I
    .end local v7    # "url":Ljava/lang/String;
    :cond_4
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionSort:Landroid/widget/TextView;

    const/16 v9, 0x8

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 112
    :cond_5
    add-int/lit8 v8, p1, -0x1

    invoke-virtual {v6, v8}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->getItem(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/api/VineRecipient;

    .line 113
    .local v4, "lastItem":Lco/vine/android/api/VineRecipient;
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {p0, v4, v8}, Lco/vine/android/FriendsPickerAdapter;->haveSectionIndicator(Lco/vine/android/api/VineRecipient;Lco/vine/android/api/VineRecipient;)Z

    move-result v1

    .line 114
    .local v1, "haveSectionIndicator":Z
    iget-object v9, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionIndicator:Landroid/view/View;

    if-eqz v1, :cond_6

    const/4 v8, 0x0

    :goto_3
    invoke-virtual {v9, v8}, Landroid/view/View;->setVisibility(I)V

    .line 115
    if-eqz v1, :cond_0

    .line 116
    iget v5, v4, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    .line 117
    .local v5, "lastSectionIndex":I
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget v8, v8, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    if-eq v8, v5, :cond_7

    .line 118
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionTitle:Landroid/widget/TextView;

    iget-object v9, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v9, v9, Lco/vine/android/api/VineRecipient;->sectionTitle:Ljava/lang/String;

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 119
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionTitle:Landroid/widget/TextView;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 123
    :goto_4
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    iget v8, v8, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    if-eqz v8, :cond_0

    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {v8}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 125
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionSort:Landroid/widget/TextView;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 126
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionSort:Landroid/widget/TextView;

    iget-object v9, v2, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {v9}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 114
    .end local v5    # "lastSectionIndex":I
    :cond_6
    const/16 v8, 0x8

    goto :goto_3

    .line 121
    .restart local v5    # "lastSectionIndex":I
    :cond_7
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->sectionTitle:Landroid/widget/TextView;

    const/16 v9, 0x8

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_4

    .line 135
    .end local v1    # "haveSectionIndicator":Z
    .end local v4    # "lastItem":Lco/vine/android/api/VineRecipient;
    .end local v5    # "lastSectionIndex":I
    :cond_8
    iget-object v8, v2, Lco/vine/android/FriendsPickerViewHolder;->divider:Landroid/view/View;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1

    .line 154
    .restart local v0    # "color":I
    .restart local v3    # "key":Lco/vine/android/util/image/ImageKey;
    .restart local v7    # "url":Ljava/lang/String;
    :cond_9
    iput-object v3, v2, Lco/vine/android/FriendsPickerViewHolder;->avatarUrl:Lco/vine/android/util/image/ImageKey;

    .line 155
    iget-object v8, p0, Lco/vine/android/FriendsPickerAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v8, v3}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v8

    invoke-direct {p0, v2, v8}, Lco/vine/android/FriendsPickerAdapter;->setUserImage(Lco/vine/android/FriendsPickerViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_2

    .line 158
    .end local v3    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_a
    const/4 v8, 0x0

    invoke-direct {p0, v2, v8}, Lco/vine/android/FriendsPickerAdapter;->setUserImage(Lco/vine/android/FriendsPickerViewHolder;Landroid/graphics/Bitmap;)V

    goto/16 :goto_2
.end method

.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 86
    invoke-interface {p3}, Landroid/database/Cursor;->getPosition()I

    move-result v0

    invoke-virtual {p0, v0, p1, p2, p3}, Lco/vine/android/FriendsPickerAdapter;->bindView(ILandroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V

    .line 87
    return-void
.end method

.method public getItemId(I)J
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 164
    invoke-virtual {p0}, Lco/vine/android/FriendsPickerAdapter;->getCount()I

    move-result v1

    if-ge p1, v1, :cond_0

    .line 165
    invoke-super {p0, p1}, Landroid/support/v4/widget/CursorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    .line 166
    .local v0, "c":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    .line 167
    check-cast v0, Lco/vine/android/provider/FriendsPickerExclusiveCursor;

    .end local v0    # "c":Landroid/database/Cursor;
    invoke-virtual {v0, p1}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineRecipient;

    iget-wide v1, v1, Lco/vine/android/api/VineRecipient;->userId:J

    .line 170
    :goto_0
    return-wide v1

    :cond_0
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 47
    iget-object v0, p0, Lco/vine/android/FriendsPickerAdapter;->mCursor:Landroid/database/Cursor;

    check-cast v0, Lco/vine/android/provider/FriendsPickerExclusiveCursor;

    .line 48
    .local v0, "cursor":Lco/vine/android/provider/FriendsPickerExclusiveCursor;
    sget-object v1, Lco/vine/android/FriendsPickerAdapter$1;->$SwitchMap$co$vine$android$provider$ExclusiveHybridCursor$Mode:[I

    invoke-virtual {v0}, Lco/vine/android/provider/FriendsPickerExclusiveCursor;->getMode()Lco/vine/android/provider/ExclusiveHybridCursor$Mode;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/provider/ExclusiveHybridCursor$Mode;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 58
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/widget/CursorAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    :goto_0
    return-object v1

    .line 50
    :pswitch_0
    if-nez p2, :cond_0

    .line 51
    iget-object v1, p0, Lco/vine/android/FriendsPickerAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {p0, v1, v0, p3}, Lco/vine/android/FriendsPickerAdapter;->newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 53
    :cond_0
    iget-object v1, p0, Lco/vine/android/FriendsPickerAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {p0, p1, p2, v1, v0}, Lco/vine/android/FriendsPickerAdapter;->bindView(ILandroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V

    move-object v1, p2

    .line 54
    goto :goto_0

    .line 48
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public haveSectionIndicator(Lco/vine/android/api/VineRecipient;Lco/vine/android/api/VineRecipient;)Z
    .locals 2
    .param p1, "lastItem"    # Lco/vine/android/api/VineRecipient;
    .param p2, "thisItem"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 90
    iget v0, p2, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    iget v1, p1, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    if-ne v0, v1, :cond_0

    iget v0, p2, Lco/vine/android/api/VineRecipient;->sectionIndex:I

    if-eqz v0, :cond_1

    invoke-virtual {p2}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lco/vine/android/api/VineRecipient;->getTextSortKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 65
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 66
    .local v1, "layoutInflater":Landroid/view/LayoutInflater;
    const v3, 0x7f030080

    const/4 v4, 0x0

    invoke-virtual {v1, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 67
    .local v2, "v":Landroid/view/View;
    new-instance v0, Lco/vine/android/FriendsPickerViewHolder;

    iget-object v3, p0, Lco/vine/android/FriendsPickerAdapter;->mSelectedBackgroundMap:Lco/vine/android/util/SparseArray;

    invoke-direct {v0, p1, v3, v2}, Lco/vine/android/FriendsPickerViewHolder;-><init>(Landroid/content/Context;Lco/vine/android/util/SparseArray;Landroid/view/View;)V

    .line 68
    .local v0, "holder":Lco/vine/android/FriendsPickerViewHolder;
    iget-object v3, p0, Lco/vine/android/FriendsPickerAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v4, Ljava/lang/ref/WeakReference;

    invoke-direct {v4, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 69
    invoke-virtual {v2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 70
    return-object v2
.end method

.method public onRecipientItemRemoved(Lco/vine/android/api/VineRecipient;)V
    .locals 5
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;

    .prologue
    .line 74
    iget-object v3, p0, Lco/vine/android/FriendsPickerAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 75
    .local v0, "h":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/FriendsPickerViewHolder;>;"
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/FriendsPickerViewHolder;

    .line 76
    .local v1, "holder":Lco/vine/android/FriendsPickerViewHolder;
    if-eqz v1, :cond_0

    .line 77
    iget-object v3, v1, Lco/vine/android/FriendsPickerViewHolder;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {p1, v3}, Lco/vine/android/api/VineRecipient;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 78
    iget-object v3, p0, Lco/vine/android/FriendsPickerAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Lco/vine/android/FriendsPickerViewHolder;->setSelected(Landroid/content/res/Resources;Z)V

    goto :goto_0

    .line 82
    .end local v0    # "h":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/FriendsPickerViewHolder;>;"
    .end local v1    # "holder":Lco/vine/android/FriendsPickerViewHolder;
    :cond_1
    return-void
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
    .line 183
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    monitor-enter p0

    :try_start_0
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 185
    .local v5, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/FriendsPickerViewHolder;>;>;"
    iget-object v6, p0, Lco/vine/android/FriendsPickerAdapter;->mViewHolders:Ljava/util/ArrayList;

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

    .line 186
    .local v4, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/FriendsPickerViewHolder;>;"
    invoke-virtual {v4}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/FriendsPickerViewHolder;

    .line 187
    .local v0, "holder":Lco/vine/android/FriendsPickerViewHolder;
    if-nez v0, :cond_1

    .line 188
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 183
    .end local v0    # "holder":Lco/vine/android/FriendsPickerViewHolder;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/FriendsPickerViewHolder;>;"
    .end local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/FriendsPickerViewHolder;>;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 190
    .restart local v0    # "holder":Lco/vine/android/FriendsPickerViewHolder;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/FriendsPickerViewHolder;>;"
    .restart local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/FriendsPickerViewHolder;>;>;"
    :cond_1
    :try_start_1
    iget-object v6, v0, Lco/vine/android/FriendsPickerViewHolder;->avatarUrl:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 191
    .local v2, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 192
    iget-object v6, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v0, v6}, Lco/vine/android/FriendsPickerAdapter;->setUserImage(Lco/vine/android/FriendsPickerViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 196
    .end local v0    # "holder":Lco/vine/android/FriendsPickerViewHolder;
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/FriendsPickerViewHolder;>;"
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

    .line 197
    .local v3, "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/FriendsPickerViewHolder;>;"
    iget-object v6, p0, Lco/vine/android/FriendsPickerAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 199
    .end local v3    # "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/FriendsPickerViewHolder;>;"
    :cond_3
    monitor-exit p0

    return-void
.end method
