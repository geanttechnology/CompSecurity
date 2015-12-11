.class Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$CoverArtLoadListener;
.super Ljava/lang/Object;
.source "BookmarksAdapter.java"

# interfaces
.implements Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "CoverArtLoadListener"
.end annotation


# instance fields
.field holder:Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;
    .param p2, "holder"    # Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;

    .prologue
    .line 168
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$CoverArtLoadListener;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 169
    iput-object p2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$CoverArtLoadListener;->holder:Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;

    .line 170
    return-void
.end method


# virtual methods
.method public onLoad(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;
    .param p3, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 174
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$CoverArtLoadListener;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;

    # getter for: Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->isTablet:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->access$000(Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 175
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$CoverArtLoadListener;->holder:Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->title:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 177
    :cond_0
    return-void
.end method

.method public onLoadError(Landroid/widget/ImageView;Ljava/lang/String;)V
    .locals 0
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 181
    return-void
.end method
