.class Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;
.super Ljava/lang/Object;
.source "BookmarkUtils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;ZLcom/xfinity/playerlib/view/favorite/BookmarkEventListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

.field final synthetic val$accessibilityFragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

.field final synthetic val$bookmarkEventListener:Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;

.field final synthetic val$isAdded:Z

.field final synthetic val$liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;ZLcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;->val$liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    iput-boolean p3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;->val$isAdded:Z

    iput-object p4, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;->val$accessibilityFragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    iput-object p5, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;->val$bookmarkEventListener:Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 57
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;->val$liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;->val$isAdded:Z

    iget-object v3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;->val$accessibilityFragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$2;->val$bookmarkEventListener:Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->executeAddRemove(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;ZLcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;)V

    .line 59
    return-void
.end method
