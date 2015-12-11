.class Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;
.super Ljava/lang/Object;
.source "PinnedHeaderExpandableAdapter.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;-><init>(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;


# direct methods
.method constructor <init>(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    .line 309
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 6
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    .line 312
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    iget-object v2, v2, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-virtual {v2}, Landroid/widget/CheckBox;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 313
    .local v1, "position":I
    if-nez v1, :cond_2

    .line 314
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    invoke-static {v2, p2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$6(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Z)V

    .line 315
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$1(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v0, v2, :cond_1

    .line 319
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->checkListener:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$7(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

    move-result-object v2

    invoke-interface {v2, v3}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;->ClickGroupCheckBox(I)V

    .line 341
    .end local v0    # "i":I
    :cond_0
    :goto_1
    return-void

    .line 316
    .restart local v0    # "i":I
    :cond_1
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$1(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wjj/eneity/RuningApp;

    iput-boolean p2, v2, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    .line 315
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 320
    .end local v0    # "i":I
    :cond_2
    if-ne v1, v3, :cond_4

    .line 321
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    invoke-static {v2, p2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$8(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Z)V

    .line 322
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_2
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$3(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v0, v2, :cond_3

    .line 325
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->checkListener:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$7(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

    move-result-object v2

    invoke-interface {v2, v4}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;->ClickGroupCheckBox(I)V

    goto :goto_1

    .line 323
    :cond_3
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$3(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wjj/eneity/RubSoftware;

    iput-boolean p2, v2, Lcom/wjj/eneity/RubSoftware;->ischecked:Z

    .line 322
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 326
    .end local v0    # "i":I
    :cond_4
    if-ne v1, v4, :cond_6

    .line 327
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    invoke-static {v2, p2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$9(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Z)V

    .line 328
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_3
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$4(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v0, v2, :cond_5

    .line 331
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->checkListener:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$7(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

    move-result-object v2

    invoke-interface {v2, v5}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;->ClickGroupCheckBox(I)V

    goto :goto_1

    .line 329
    :cond_5
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$4(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wjj/eneity/Canliu;

    iput-boolean p2, v2, Lcom/wjj/eneity/Canliu;->ischecked:Z

    .line 328
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 332
    .end local v0    # "i":I
    :cond_6
    if-ne v1, v5, :cond_0

    .line 333
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    invoke-static {v2, p2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$10(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Z)V

    .line 335
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_4
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$5(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v0, v2, :cond_7

    .line 338
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->checkListener:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$7(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

    move-result-object v2

    const/4 v3, 0x4

    invoke-interface {v2, v3}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;->ClickGroupCheckBox(I)V

    goto/16 :goto_1

    .line 336
    :cond_7
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;->this$1:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v2

    # getter for: Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;
    invoke-static {v2}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->access$5(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wjj/eneity/SoftApk;

    iput-boolean p2, v2, Lcom/wjj/eneity/SoftApk;->ischecked:Z

    .line 335
    add-int/lit8 v0, v0, 0x1

    goto :goto_4
.end method
