.class Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$8;
.super Ljava/lang/Object;
.source "NetworkCollectionsFragment.java"

# interfaces
.implements Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->getOnItemLongClickListener()Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 375
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$8;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemLongClick(Lit/sephiroth/android/library/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 7
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lit/sephiroth/android/library/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .line 378
    .local p1, "adapter":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<*>;"
    invoke-virtual {p1, p3}, Lit/sephiroth/android/library/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 379
    .local v0, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$8;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$8;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    new-instance v3, Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 380
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isAdult()Z

    move-result v6

    invoke-direct {v3, v4, v5, v6}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;Z)V

    .line 379
    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    .line 381
    const/4 v1, 0x1

    return v1
.end method
