.class public Lco/vine/android/FriendSearchAdapter;
.super Landroid/widget/ArrayAdapter;
.source "FriendSearchAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lco/vine/android/api/VineUser;",
        ">;"
    }
.end annotation


# instance fields
.field private final mAppController:Lco/vine/android/client/AppController;

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

.field private final mVineGreen:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Lco/vine/android/client/AppController;Ljava/util/List;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lco/vine/android/client/AppController;",
            "Ljava/util/List",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 37
    .local p3, "users":Ljava/util/List;, "Ljava/util/List<Lco/vine/android/api/VineUser;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 38
    iput-object p2, p0, Lco/vine/android/FriendSearchAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 39
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0087

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/FriendSearchAdapter;->mProfileImageSize:I

    .line 40
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/FriendSearchAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 41
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090096

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/FriendSearchAdapter;->mVineGreen:I

    .line 42
    return-void
.end method

.method private setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "holder"    # Lco/vine/android/widget/UserViewHolder;
    .param p2, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 111
    iget-object v0, p1, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 112
    if-eqz p2, :cond_0

    .line 113
    iget-object v0, p1, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    invoke-virtual {p0}, Lco/vine/android/FriendSearchAdapter;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 118
    :goto_0
    return-void

    .line 116
    :cond_0
    iget-object v0, p1, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    const v1, 0x7f0200f7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method


# virtual methods
.method public getItemId(I)J
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 95
    invoke-virtual {p0, p1}, Lco/vine/android/FriendSearchAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineUser;

    .line 96
    .local v0, "user":Lco/vine/android/api/VineUser;
    iget-wide v1, v0, Lco/vine/android/api/VineUser;->userId:J

    return-wide v1
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 9
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 47
    if-eqz p2, :cond_0

    .line 48
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/UserViewHolder;

    .line 49
    .local v0, "holder":Lco/vine/android/widget/UserViewHolder;
    iget-object v5, p0, Lco/vine/android/FriendSearchAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v6, Ljava/lang/ref/WeakReference;

    invoke-direct {v6, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 56
    :goto_0
    invoke-virtual {p0, p1}, Lco/vine/android/FriendSearchAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/api/VineUser;

    .line 57
    .local v4, "user":Lco/vine/android/api/VineUser;
    iget-object v5, v0, Lco/vine/android/widget/UserViewHolder;->username:Landroid/widget/TextView;

    iget-object v6, v4, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 58
    iget-object v3, v4, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    .line 59
    .local v3, "url":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 60
    new-instance v2, Lco/vine/android/util/image/ImageKey;

    iget v5, p0, Lco/vine/android/FriendSearchAdapter;->mProfileImageSize:I

    iget v6, p0, Lco/vine/android/FriendSearchAdapter;->mProfileImageSize:I

    const/4 v7, 0x1

    invoke-direct {v2, v3, v5, v6, v7}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZ)V

    .line 61
    .local v2, "key":Lco/vine/android/util/image/ImageKey;
    invoke-static {v3}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 62
    iget-object v5, v0, Lco/vine/android/widget/UserViewHolder;->image:Landroid/widget/ImageView;

    sget-object v6, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    const/high16 v7, -0x1000000

    iget v8, p0, Lco/vine/android/FriendSearchAdapter;->mVineGreen:I

    or-int/2addr v7, v8

    invoke-static {v5, v6, v7}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    .line 71
    .end local v2    # "key":Lco/vine/android/util/image/ImageKey;
    :goto_1
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 72
    return-object p2

    .line 51
    .end local v0    # "holder":Lco/vine/android/widget/UserViewHolder;
    .end local v3    # "url":Ljava/lang/String;
    .end local v4    # "user":Lco/vine/android/api/VineUser;
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/FriendSearchAdapter;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 52
    .local v1, "inflater":Landroid/view/LayoutInflater;
    const v5, 0x7f0300a3

    const/4 v6, 0x0

    invoke-virtual {v1, v5, p3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 53
    new-instance v0, Lco/vine/android/widget/UserViewHolder;

    invoke-direct {v0, p2}, Lco/vine/android/widget/UserViewHolder;-><init>(Landroid/view/View;)V

    .restart local v0    # "holder":Lco/vine/android/widget/UserViewHolder;
    goto :goto_0

    .line 64
    .end local v1    # "inflater":Landroid/view/LayoutInflater;
    .restart local v2    # "key":Lco/vine/android/util/image/ImageKey;
    .restart local v3    # "url":Ljava/lang/String;
    .restart local v4    # "user":Lco/vine/android/api/VineUser;
    :cond_1
    iput-object v2, v0, Lco/vine/android/widget/UserViewHolder;->avatarUrl:Lco/vine/android/util/image/ImageKey;

    .line 65
    iget-object v5, p0, Lco/vine/android/FriendSearchAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5, v2}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v5

    invoke-direct {p0, v0, v5}, Lco/vine/android/FriendSearchAdapter;->setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_1

    .line 68
    .end local v2    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_2
    const/4 v5, 0x0

    invoke-direct {p0, v0, v5}, Lco/vine/android/FriendSearchAdapter;->setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_1
.end method

.method public setData(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 101
    .local p1, "users":Ljava/util/List;, "Ljava/util/List<Lco/vine/android/api/VineUser;>;"
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xb

    if-lt v2, v3, :cond_1

    .line 102
    invoke-virtual {p0, p1}, Lco/vine/android/FriendSearchAdapter;->addAll(Ljava/util/Collection;)V

    .line 108
    :cond_0
    return-void

    .line 104
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineUser;

    .line 105
    .local v1, "user":Lco/vine/android/api/VineUser;
    invoke-virtual {p0, v1}, Lco/vine/android/FriendSearchAdapter;->add(Ljava/lang/Object;)V

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
    .line 76
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    monitor-enter p0

    :try_start_0
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 77
    .local v5, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;>;"
    iget-object v6, p0, Lco/vine/android/FriendSearchAdapter;->mViewHolders:Ljava/util/ArrayList;

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

    .line 78
    .local v4, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    invoke-virtual {v4}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/UserViewHolder;

    .line 79
    .local v0, "holder":Lco/vine/android/widget/UserViewHolder;
    if-nez v0, :cond_1

    .line 80
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 76
    .end local v0    # "holder":Lco/vine/android/widget/UserViewHolder;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    .end local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 82
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

    .line 83
    .local v2, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 84
    iget-object v6, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v0, v6}, Lco/vine/android/FriendSearchAdapter;->setUserImage(Lco/vine/android/widget/UserViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 88
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

    .line 89
    .local v3, "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    iget-object v6, p0, Lco/vine/android/FriendSearchAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 91
    .end local v3    # "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/UserViewHolder;>;"
    :cond_3
    monitor-exit p0

    return-void
.end method
