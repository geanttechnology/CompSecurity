.class Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$2;
.super Ljava/lang/Object;
.source "PhoneNetworkCollectionsFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

.field final synthetic val$network:Lcom/xfinity/playerlib/model/tags/Network;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;Lcom/xfinity/playerlib/model/tags/Network;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    .prologue
    .line 254
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$2;->this$1:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$2;->val$network:Lcom/xfinity/playerlib/model/tags/Network;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .param p2, "view"    # Landroid/view/View;
    .param p3, "pos"    # I
    .param p4, "l"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 257
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p2}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 258
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$2;->val$network:Lcom/xfinity/playerlib/model/tags/Network;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$2;->this$1:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->categoryAdapter:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$1000(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;

    move-result-object v2

    invoke-virtual {v2, p3}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->getItem(I)Lcom/xfinity/playerlib/model/tags/OrderedTag;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->createBundle(Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 260
    const-string v1, "showFilterButton"

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$2;->this$1:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->showFilterButton:Z
    invoke-static {v2}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$1100(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Z

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 262
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$2;->this$1:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->startActivity(Landroid/content/Intent;)V

    .line 263
    return-void
.end method
