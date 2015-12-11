.class Lco/vine/android/ChannelsListFragment$ChannelsAdapter;
.super Landroid/support/v4/widget/CursorAdapter;
.source "ChannelsListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ChannelsListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ChannelsAdapter"
.end annotation


# instance fields
.field private final mViewHolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/ChannelsListFragment$ChannelViewHolder;",
            ">;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lco/vine/android/ChannelsListFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/ChannelsListFragment;Landroid/content/Context;Lco/vine/android/client/AppController;I)V
    .locals 1
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "appController"    # Lco/vine/android/client/AppController;
    .param p4, "flags"    # I

    .prologue
    .line 169
    iput-object p1, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->this$0:Lco/vine/android/ChannelsListFragment;

    .line 170
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0, p4}, Landroid/support/v4/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 171
    iput-object p3, p1, Lco/vine/android/ChannelsListFragment;->mAppController:Lco/vine/android/client/AppController;

    .line 172
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 173
    return-void
.end method

.method private setChannelImage(Lco/vine/android/ChannelsListFragment$ChannelViewHolder;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "holder"    # Lco/vine/android/ChannelsListFragment$ChannelViewHolder;
    .param p2, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 233
    if-eqz p2, :cond_0

    .line 234
    iget-object v0, p1, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;->channelImage:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 240
    :goto_0
    return-void

    .line 236
    :cond_0
    iget-object v0, p1, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;->channelImage:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 237
    iget-object v0, p1, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;->channelImage:Landroid/widget/ImageView;

    iget-object v1, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f09007f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    goto :goto_0
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 189
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;

    .line 190
    .local v0, "holder":Lco/vine/android/ChannelsListFragment$ChannelViewHolder;
    iget-object v3, v0, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;->channelTitle:Landroid/widget/TextView;

    const/4 v4, 0x2

    invoke-interface {p3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 191
    const/4 v3, 0x1

    invoke-interface {p3, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    iput-wide v3, v0, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;->channelId:J

    .line 192
    iget-wide v3, v0, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;->channelId:J

    iget-object v5, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->this$0:Lco/vine/android/ChannelsListFragment;

    # getter for: Lco/vine/android/ChannelsListFragment;->mSelectedChannel:J
    invoke-static {v5}, Lco/vine/android/ChannelsListFragment;->access$000(Lco/vine/android/ChannelsListFragment;)J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_0

    .line 193
    iget-object v3, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->this$0:Lco/vine/android/ChannelsListFragment;

    invoke-virtual {v3}, Lco/vine/android/ChannelsListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090055

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {p1, v3}, Landroid/view/View;->setBackgroundColor(I)V

    .line 199
    :goto_0
    iget-object v3, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->this$0:Lco/vine/android/ChannelsListFragment;

    invoke-virtual {v3}, Lco/vine/android/ChannelsListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->densityDpi:I

    const/16 v4, 0xf0

    if-ge v3, v4, :cond_1

    .line 200
    const/16 v3, 0x8

    invoke-interface {p3, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 205
    .local v1, "iconFullUrl":Ljava/lang/String;
    :goto_1
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 206
    new-instance v2, Lco/vine/android/util/image/ImageKey;

    invoke-direct {v2, v1}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;)V

    .line 207
    .local v2, "key":Lco/vine/android/util/image/ImageKey;
    iput-object v2, v0, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;->channelImageKey:Lco/vine/android/util/image/ImageKey;

    .line 208
    iget-object v3, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->this$0:Lco/vine/android/ChannelsListFragment;

    iget-object v3, v3, Lco/vine/android/ChannelsListFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3, v2}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v3

    invoke-direct {p0, v0, v3}, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->setChannelImage(Lco/vine/android/ChannelsListFragment$ChannelViewHolder;Landroid/graphics/Bitmap;)V

    .line 212
    .end local v2    # "key":Lco/vine/android/util/image/ImageKey;
    :goto_2
    return-void

    .line 195
    .end local v1    # "iconFullUrl":Ljava/lang/String;
    :cond_0
    iget-object v3, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->this$0:Lco/vine/android/ChannelsListFragment;

    invoke-virtual {v3}, Lco/vine/android/ChannelsListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090083

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {p1, v3}, Landroid/view/View;->setBackgroundColor(I)V

    goto :goto_0

    .line 202
    :cond_1
    const/16 v3, 0x9

    invoke-interface {p3, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "iconFullUrl":Ljava/lang/String;
    goto :goto_1

    .line 210
    :cond_2
    const/4 v3, 0x0

    invoke-direct {p0, v0, v3}, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->setChannelImage(Lco/vine/android/ChannelsListFragment$ChannelViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_2
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 177
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 178
    .local v1, "layoutInflater":Landroid/view/LayoutInflater;
    const v3, 0x7f030023

    const/4 v4, 0x0

    invoke-virtual {v1, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 180
    .local v2, "v":Landroid/view/View;
    new-instance v0, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;

    iget-object v3, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->this$0:Lco/vine/android/ChannelsListFragment;

    invoke-direct {v0, v3, v2}, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;-><init>(Lco/vine/android/ChannelsListFragment;Landroid/view/View;)V

    .line 182
    .local v0, "holder":Lco/vine/android/ChannelsListFragment$ChannelViewHolder;
    iget-object v3, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v4, Ljava/lang/ref/WeakReference;

    invoke-direct {v4, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 183
    invoke-virtual {v2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 184
    return-object v2
.end method

.method public declared-synchronized setChannelImages(Ljava/util/HashMap;)V
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
    .line 215
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    monitor-enter p0

    :try_start_0
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 216
    .local v5, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/ChannelsListFragment$ChannelViewHolder;>;>;"
    iget-object v6, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->mViewHolders:Ljava/util/ArrayList;

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

    .line 217
    .local v4, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ChannelsListFragment$ChannelViewHolder;>;"
    invoke-virtual {v4}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;

    .line 218
    .local v0, "holder":Lco/vine/android/ChannelsListFragment$ChannelViewHolder;
    if-nez v0, :cond_1

    .line 219
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 215
    .end local v0    # "holder":Lco/vine/android/ChannelsListFragment$ChannelViewHolder;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ChannelsListFragment$ChannelViewHolder;>;"
    .end local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/ChannelsListFragment$ChannelViewHolder;>;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 221
    .restart local v0    # "holder":Lco/vine/android/ChannelsListFragment$ChannelViewHolder;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ChannelsListFragment$ChannelViewHolder;>;"
    .restart local v5    # "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/ChannelsListFragment$ChannelViewHolder;>;>;"
    :cond_1
    :try_start_1
    iget-object v6, v0, Lco/vine/android/ChannelsListFragment$ChannelViewHolder;->channelImageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 222
    .local v2, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 223
    iget-object v6, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v0, v6}, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->setChannelImage(Lco/vine/android/ChannelsListFragment$ChannelViewHolder;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 227
    .end local v0    # "holder":Lco/vine/android/ChannelsListFragment$ChannelViewHolder;
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ChannelsListFragment$ChannelViewHolder;>;"
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

    .line 228
    .local v3, "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ChannelsListFragment$ChannelViewHolder;>;"
    iget-object v6, p0, Lco/vine/android/ChannelsListFragment$ChannelsAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 230
    .end local v3    # "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ChannelsListFragment$ChannelViewHolder;>;"
    :cond_3
    monitor-exit p0

    return-void
.end method
