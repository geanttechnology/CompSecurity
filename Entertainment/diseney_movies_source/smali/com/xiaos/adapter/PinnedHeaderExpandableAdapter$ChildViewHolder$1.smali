.class Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;
.super Ljava/lang/Object;
.source "PinnedHeaderExpandableAdapter.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;-><init>(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;


# direct methods
.method constructor <init>(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    .line 148
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 3
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 152
    iget-object v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    iget-object v1, v1, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-virtual {v1}, Landroid/widget/CheckBox;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 153
    .local v0, "position":I
    iget-object v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v1

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index:I
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)I

    move-result v1

    if-nez v1, :cond_1

    .line 154
    iget-object v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v1

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$1(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/eneity/RuningApp;

    iput-boolean p2, v1, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    .line 173
    :cond_0
    :goto_0
    return-void

    .line 155
    :cond_1
    iget-object v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v1

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index:I
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_2

    .line 157
    iget-object v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$2(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;I)V

    .line 158
    iget-object v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v1

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$3(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/eneity/RubSoftware;

    iput-boolean p2, v1, Lcom/wjj/eneity/RubSoftware;->ischecked:Z

    goto :goto_0

    .line 168
    :cond_2
    iget-object v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v1

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index:I
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)I

    move-result v1

    const/4 v2, 0x2

    if-ne v1, v2, :cond_3

    .line 169
    iget-object v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v1

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$4(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/eneity/Canliu;

    iput-boolean p2, v1, Lcom/wjj/eneity/Canliu;->ischecked:Z

    goto :goto_0

    .line 170
    :cond_3
    iget-object v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v1

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index:I
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)I

    move-result v1

    const/4 v2, 0x3

    if-ne v1, v2, :cond_0

    .line 171
    iget-object v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v1

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;
    invoke-static {v1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$5(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/eneity/SoftApk;

    iput-boolean p2, v1, Lcom/wjj/eneity/SoftApk;->ischecked:Z

    goto :goto_0
.end method
