.class Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;
.super Ljava/lang/Object;
.source "BookmarkMenuItemDelegate.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->setupFavorite(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;ZLandroid/widget/CheckBox;Lcom/xfinity/playerlib/model/VideoFavorite;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

.field final synthetic val$authenticatingFragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

.field final synthetic val$favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

.field final synthetic val$favoriteIndicator:Landroid/widget/CheckBox;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;Lcom/xfinity/playerlib/model/VideoFavorite;Landroid/widget/CheckBox;Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->val$favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->val$favoriteIndicator:Landroid/widget/CheckBox;

    iput-object p4, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->val$authenticatingFragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    # getter for: Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->access$000(Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;)Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->val$favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->val$favoriteIndicator:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->val$authenticatingFragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    invoke-virtual {v1, v2, v0, v3}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->executeAddRemove(Lcom/xfinity/playerlib/model/VideoFavorite;ZLcom/comcast/cim/android/view/launch/AuthenticatingFragment;)V

    .line 88
    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->val$favoriteIndicator:Landroid/widget/CheckBox;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->val$favoriteIndicator:Landroid/widget/CheckBox;

    .line 89
    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->val$favoriteIndicator:Landroid/widget/CheckBox;

    .line 90
    invoke-virtual {v0}, Landroid/widget/CheckBox;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_bookmarked_checkbox_selected:I

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 88
    :goto_1
    invoke-virtual {v1, v0}, Landroid/widget/CheckBox;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 92
    return-void

    .line 86
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 90
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate$1;->val$favoriteIndicator:Landroid/widget/CheckBox;

    .line 91
    invoke-virtual {v0}, Landroid/widget/CheckBox;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_bookmarked_checkbox_not_selected:I

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method
