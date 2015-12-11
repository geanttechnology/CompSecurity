.class Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;
.super Ljava/lang/Object;
.source "RefinementsListView.java"

# interfaces
.implements Landroid/widget/ExpandableListView$OnGroupClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->createListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)V
    .locals 0

    .prologue
    .line 177
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGroupClick(Landroid/widget/ExpandableListView;Landroid/view/View;IJ)Z
    .locals 6
    .param p1, "parent"    # Landroid/widget/ExpandableListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "groupPosition"    # I
    .param p4, "id"    # J

    .prologue
    const/4 v5, 0x1

    .line 181
    move v1, p3

    .line 182
    .local v1, "position":I
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    move-result-object v2

    invoke-virtual {v2, p3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->isGroupSeeMoreLink(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 184
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    move-result-object v2

    const-string/jumbo v3, "dept"

    invoke-virtual {v2, v3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupPosition(Ljava/lang/String;)I

    move-result v1

    .line 191
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-virtual {v2, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->isGroupExpanded(I)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 193
    if-eq v1, p3, :cond_2

    .line 195
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-virtual {v2, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setSelectedGroup(I)V

    .line 214
    :goto_0
    return v5

    .line 186
    :cond_1
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    move-result-object v2

    invoke-virtual {v2, p3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->isAddressInfo(I)Z

    move-result v2

    if-eqz v2, :cond_0

    goto :goto_0

    .line 199
    :cond_2
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-virtual {v2, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->collapseGroupWithAnimation(I)Z

    .line 200
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    const/4 v3, 0x0

    # setter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->lastExpandedGroupItemId:Ljava/lang/String;
    invoke-static {v2, v3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$602(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 205
    :cond_3
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupItem(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;

    move-result-object v3

    # invokes: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->getRefinementID(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;)Ljava/lang/String;
    invoke-static {v2, v3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$200(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;)Ljava/lang/String;

    move-result-object v0

    .line 206
    .local v0, "currItemId":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->lastExpandedGroupItemId:Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$600(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_4

    if-eqz v0, :cond_4

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->lastExpandedGroupItemId:Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$600(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 208
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->lastExpandedGroupItemId:Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$600(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupPosition(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->collapseGroupWithAnimation(I)Z

    .line 210
    :cond_4
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # setter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->lastExpandedGroupItemId:Ljava/lang/String;
    invoke-static {v2, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$602(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;Ljava/lang/String;)Ljava/lang/String;

    .line 211
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-virtual {v2, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->smoothScrollToPosition(I)V

    .line 212
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-virtual {v2, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->expandGroupWithAnimation(I)Z

    goto :goto_0
.end method
