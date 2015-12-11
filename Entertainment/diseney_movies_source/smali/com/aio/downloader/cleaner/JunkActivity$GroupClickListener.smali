.class Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;
.super Ljava/lang/Object;
.source "JunkActivity.java"

# interfaces
.implements Landroid/widget/ExpandableListView$OnGroupClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/JunkActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "GroupClickListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/JunkActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/JunkActivity;)V
    .locals 0

    .prologue
    .line 305
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGroupClick(Landroid/widget/ExpandableListView;Landroid/view/View;IJ)Z
    .locals 3
    .param p1, "parent"    # Landroid/widget/ExpandableListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "groupPosition"    # I
    .param p4, "id"    # J

    .prologue
    const/4 v2, -0x1

    .line 309
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->expandFlag:I
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$56(Lcom/aio/downloader/cleaner/JunkActivity;)I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 311
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$49(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/view/PinnedHeaderExpandableListView;

    move-result-object v0

    invoke-virtual {v0, p3}, Lcom/xiaos/view/PinnedHeaderExpandableListView;->expandGroup(I)Z

    .line 313
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$49(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/view/PinnedHeaderExpandableListView;

    move-result-object v0

    invoke-virtual {v0, p3}, Lcom/xiaos/view/PinnedHeaderExpandableListView;->setSelectedGroup(I)V

    .line 314
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    invoke-static {v0, p3}, Lcom/aio/downloader/cleaner/JunkActivity;->access$57(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    .line 326
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 315
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->expandFlag:I
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$56(Lcom/aio/downloader/cleaner/JunkActivity;)I

    move-result v0

    if-ne v0, p3, :cond_1

    .line 316
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$49(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/view/PinnedHeaderExpandableListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->expandFlag:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$56(Lcom/aio/downloader/cleaner/JunkActivity;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/xiaos/view/PinnedHeaderExpandableListView;->collapseGroup(I)Z

    .line 317
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    invoke-static {v0, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$57(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    goto :goto_0

    .line 319
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$49(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/view/PinnedHeaderExpandableListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->expandFlag:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$56(Lcom/aio/downloader/cleaner/JunkActivity;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/xiaos/view/PinnedHeaderExpandableListView;->collapseGroup(I)Z

    .line 321
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$49(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/view/PinnedHeaderExpandableListView;

    move-result-object v0

    invoke-virtual {v0, p3}, Lcom/xiaos/view/PinnedHeaderExpandableListView;->expandGroup(I)Z

    .line 323
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$49(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/view/PinnedHeaderExpandableListView;

    move-result-object v0

    invoke-virtual {v0, p3}, Lcom/xiaos/view/PinnedHeaderExpandableListView;->setSelectedGroup(I)V

    .line 324
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    invoke-static {v0, p3}, Lcom/aio/downloader/cleaner/JunkActivity;->access$57(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    goto :goto_0
.end method
