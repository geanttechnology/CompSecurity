.class Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;
.super Ljava/lang/Object;
.source "NetworkCollectionsFragment.java"

# interfaces
.implements Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->createGallery(Landroid/view/ViewGroup;I)I
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

.field final synthetic val$collectionShadowLeft:Landroid/widget/ImageView;

.field final synthetic val$collectionShadowRight:Landroid/widget/ImageView;

.field final synthetic val$gallery:Lit/sephiroth/android/library/widget/HListView;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 153
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->val$gallery:Lit/sephiroth/android/library/widget/HListView;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->val$collectionShadowLeft:Landroid/widget/ImageView;

    iput-object p4, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->val$collectionShadowRight:Landroid/widget/ImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Lit/sephiroth/android/library/widget/AbsHListView;III)V
    .locals 0
    .param p1, "absHListView"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 170
    return-void
.end method

.method public onScrollStateChanged(Lit/sephiroth/android/library/widget/AbsHListView;I)V
    .locals 5
    .param p1, "absHListView"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 156
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->val$gallery:Lit/sephiroth/android/library/widget/HListView;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->val$collectionShadowLeft:Landroid/widget/ImageView;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->val$collectionShadowRight:Landroid/widget/ImageView;

    # invokes: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->adjustScrollShadows(Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V
    invoke-static {v1, v2, v3, v4}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$000(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V

    .line 157
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->isFlinging()Z

    move-result v0

    .line 158
    .local v0, "wasFlinging":Z
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # setter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->scrollState:I
    invoke-static {v1, p2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$102(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;I)I

    .line 161
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->isFlinging()Z

    move-result v1

    if-nez v1, :cond_0

    .line 162
    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$200()Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "notifyDataSetChanged because we are no longer flinging"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 163
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;->val$gallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/HListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->notifyDataSetChanged()V

    .line 165
    :cond_0
    return-void
.end method
