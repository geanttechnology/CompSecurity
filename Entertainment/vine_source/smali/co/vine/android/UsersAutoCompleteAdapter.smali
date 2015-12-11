.class public Lco/vine/android/UsersAutoCompleteAdapter;
.super Landroid/support/v4/widget/CursorAdapter;
.source "UsersAutoCompleteAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;
    }
.end annotation


# instance fields
.field private mAppController:Lco/vine/android/client/AppController;

.field private final mProfileImageSize:I

.field protected final mViewHolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lco/vine/android/client/AppController;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "appController"    # Lco/vine/android/client/AppController;

    .prologue
    .line 40
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Landroid/support/v4/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;Z)V

    .line 41
    iput-object p2, p0, Lco/vine/android/UsersAutoCompleteAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/UsersAutoCompleteAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 43
    invoke-virtual {p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0087

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/UsersAutoCompleteAdapter;->mProfileImageSize:I

    .line 44
    return-void
.end method

.method private setUserImage(Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "holder"    # Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;
    .param p2, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 134
    iget-object v0, p1, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;->image:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 135
    if-eqz p2, :cond_0

    .line 136
    iget-object v0, p1, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;->image:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/UsersAutoCompleteAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 140
    :goto_0
    return-void

    .line 138
    :cond_0
    iget-object v0, p1, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;->image:Landroid/widget/ImageView;

    const v1, 0x7f0200f7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v5, 0x1

    .line 59
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;

    .line 60
    .local v0, "holder":Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;
    invoke-interface {p3, v5}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    iput-wide v3, v0, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;->userId:J

    .line 62
    const/4 v3, 0x3

    invoke-interface {p3, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 63
    .local v2, "url":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 64
    new-instance v1, Lco/vine/android/util/image/ImageKey;

    iget v3, p0, Lco/vine/android/UsersAutoCompleteAdapter;->mProfileImageSize:I

    iget v4, p0, Lco/vine/android/UsersAutoCompleteAdapter;->mProfileImageSize:I

    invoke-direct {v1, v2, v3, v4, v5}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZ)V

    .line 65
    .local v1, "key":Lco/vine/android/util/image/ImageKey;
    invoke-static {v2}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 66
    iget-object v3, v0, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;->image:Landroid/widget/ImageView;

    sget-object v4, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    const/high16 v5, -0x1000000

    iget-object v6, p0, Lco/vine/android/UsersAutoCompleteAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f090096

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    or-int/2addr v5, v6

    invoke-static {v3, v4, v5}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    .line 74
    .end local v1    # "key":Lco/vine/android/util/image/ImageKey;
    :goto_0
    iget-object v3, v0, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;->userNameView:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "@"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/4 v5, 0x2

    invoke-interface {p3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 75
    return-void

    .line 68
    .restart local v1    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_0
    iput-object v1, v0, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;->avatarUrl:Lco/vine/android/util/image/ImageKey;

    .line 69
    iget-object v3, p0, Lco/vine/android/UsersAutoCompleteAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3, v1}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v3

    invoke-direct {p0, v0, v3}, Lco/vine/android/UsersAutoCompleteAdapter;->setUserImage(Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 72
    .end local v1    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_1
    const/4 v3, 0x0

    invoke-direct {p0, v0, v3}, Lco/vine/android/UsersAutoCompleteAdapter;->setUserImage(Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 6
    .param p1, "position"    # I

    .prologue
    .line 79
    invoke-super {p0, p1}, Landroid/support/v4/widget/CursorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    .line 82
    .local v0, "c":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    .line 83
    const/4 v4, 0x1

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 84
    .local v1, "id":J
    const/4 v4, 0x2

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 89
    .local v3, "tagName":Ljava/lang/String;
    :goto_0
    new-instance v4, Lco/vine/android/api/VineTypeAhead;

    const-string v5, "mention"

    invoke-direct {v4, v5, v3, v1, v2}, Lco/vine/android/api/VineTypeAhead;-><init>(Ljava/lang/String;Ljava/lang/String;J)V

    return-object v4

    .line 86
    .end local v1    # "id":J
    .end local v3    # "tagName":Ljava/lang/String;
    :cond_0
    const-wide/16 v1, 0x0

    .line 87
    .restart local v1    # "id":J
    const-string v3, ""

    .restart local v3    # "tagName":Ljava/lang/String;
    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 94
    invoke-super {p0, p1}, Landroid/support/v4/widget/CursorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    .line 95
    .local v0, "c":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    .line 96
    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 98
    :goto_0
    return-wide v1

    :cond_0
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 48
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 49
    .local v0, "layoutInflater":Landroid/view/LayoutInflater;
    const v3, 0x7f0300a0

    const/4 v4, 0x0

    invoke-virtual {v0, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 50
    .local v1, "rowView":Landroid/view/View;
    new-instance v2, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;

    invoke-direct {v2, p0, v1}, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;-><init>(Lco/vine/android/UsersAutoCompleteAdapter;Landroid/view/View;)V

    .line 51
    .local v2, "vh":Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;
    iget-object v3, v2, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;->image:Landroid/widget/ImageView;

    sget-object v4, Landroid/widget/ImageView$ScaleType;->FIT_CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 52
    iget-object v3, p0, Lco/vine/android/UsersAutoCompleteAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v4, Ljava/lang/ref/WeakReference;

    invoke-direct {v4, v2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 53
    invoke-virtual {v1, v2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 54
    return-object v1
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
    .line 115
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    monitor-enter p0

    :try_start_0
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 117
    .local v5, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;>;>;"
    iget-object v6, p0, Lco/vine/android/UsersAutoCompleteAdapter;->mViewHolders:Ljava/util/ArrayList;

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

    .line 118
    .local v4, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;>;"
    invoke-virtual {v4}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;

    .line 119
    .local v0, "holder":Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;
    if-nez v0, :cond_1

    .line 120
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 115
    .end local v0    # "holder":Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;>;"
    .end local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;>;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 122
    .restart local v0    # "holder":Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;>;"
    .restart local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;>;>;"
    :cond_1
    :try_start_1
    iget-object v6, v0, Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;->avatarUrl:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 123
    .local v2, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 124
    iget-object v6, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v0, v6}, Lco/vine/android/UsersAutoCompleteAdapter;->setUserImage(Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 128
    .end local v0    # "holder":Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;>;"
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

    .line 129
    .local v3, "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;>;"
    iget-object v6, p0, Lco/vine/android/UsersAutoCompleteAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 131
    .end local v3    # "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/UsersAutoCompleteAdapter$UserDropDownViewHolder;>;"
    :cond_3
    monitor-exit p0

    return-void
.end method
