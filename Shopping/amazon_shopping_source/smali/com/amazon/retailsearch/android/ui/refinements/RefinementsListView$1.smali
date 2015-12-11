.class Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;
.super Ljava/lang/Object;
.source "RefinementsListView.java"

# interfaces
.implements Landroid/widget/ExpandableListView$OnChildClickListener;


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
    .line 116
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onChildClick(Landroid/widget/ExpandableListView;Landroid/view/View;IIJ)Z
    .locals 7
    .param p1, "parent"    # Landroid/widget/ExpandableListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "groupPosition"    # I
    .param p4, "childPosition"    # I
    .param p5, "id"    # J

    .prologue
    const/4 v3, 0x1

    .line 121
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->getVisibility()I

    move-result v4

    const/16 v5, 0x8

    if-ne v4, v5, :cond_1

    .line 154
    :cond_0
    :goto_0
    return v3

    .line 125
    :cond_1
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
    invoke-static {v6}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    move-result-object v6

    invoke-virtual {v6, p3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupItem(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;

    move-result-object v6

    # invokes: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->getRefinementID(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;)Ljava/lang/String;
    invoke-static {v5, v6}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$200(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;)Ljava/lang/String;

    move-result-object v5

    # setter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->selectedGroupItemId:Ljava/lang/String;
    invoke-static {v4, v5}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$002(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;Ljava/lang/String;)Ljava/lang/String;

    .line 126
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # setter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->selectedChildPosition:I
    invoke-static {v4, p4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$302(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;I)I

    .line 127
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    move-result-object v4

    invoke-virtual {v4, p3, p4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getChildId(II)J

    move-result-wide v1

    .line 128
    .local v1, "childId":J
    const-wide/16 v4, 0x3

    cmp-long v4, v1, v4

    if-nez v4, :cond_3

    .line 130
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    move-result-object v4

    invoke-virtual {v4, p3, p4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .line 132
    .local v0, "child":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$400(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 134
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$400(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    move-result-object v4

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;->onRefinementClick(Ljava/lang/String;)V

    .line 150
    .end local v0    # "child":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    :cond_2
    :goto_1
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$400(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 152
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$400(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;->onHide()V

    goto :goto_0

    .line 137
    :cond_3
    const-wide/16 v4, 0x4

    cmp-long v4, v1, v4

    if-nez v4, :cond_4

    .line 139
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    move-result-object v4

    invoke-virtual {v4, p3, p4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;

    .line 141
    .local v0, "child":Lcom/amazon/searchapp/retailsearch/model/SelectedOption;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$400(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 143
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$400(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    move-result-object v4

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;->onRefinementClick(Ljava/lang/String;)V

    goto :goto_1

    .line 148
    .end local v0    # "child":Lcom/amazon/searchapp/retailsearch/model/SelectedOption;
    :cond_4
    const/4 v3, 0x0

    goto/16 :goto_0
.end method
