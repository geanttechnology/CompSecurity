.class Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$1;
.super Ljava/lang/Object;
.source "BookmarkUtils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

.field final synthetic val$accessibilityFragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

.field final synthetic val$favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

.field final synthetic val$isAdded:Z


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;Lcom/xfinity/playerlib/model/VideoFavorite;ZLcom/comcast/cim/android/view/launch/AuthenticatingFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$1;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$1;->val$favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    iput-boolean p3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$1;->val$isAdded:Z

    iput-object p4, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$1;->val$accessibilityFragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 42
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$1;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$1;->val$favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$1;->val$isAdded:Z

    iget-object v3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$1;->val$accessibilityFragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    invoke-virtual {v0, v1, v2, v3}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->executeAddRemove(Lcom/xfinity/playerlib/model/VideoFavorite;ZLcom/comcast/cim/android/view/launch/AuthenticatingFragment;)V

    .line 44
    return-void
.end method
