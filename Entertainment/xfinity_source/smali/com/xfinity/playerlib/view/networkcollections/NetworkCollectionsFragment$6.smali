.class Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$6;
.super Ljava/lang/Object;
.source "NetworkCollectionsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->displayScreenProgramsIfReady()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

.field final synthetic val$category:Lcom/xfinity/playerlib/model/tags/OrderedTag;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/OrderedTag;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 308
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$6;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$6;->val$category:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 311
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 312
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$6;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$6;->val$category:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->createBundle(Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 313
    const-string v1, "showFilterButton"

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$6;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->showFilterButton:Z
    invoke-static {v2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$900(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Z

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 314
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$6;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->startActivity(Landroid/content/Intent;)V

    .line 315
    return-void
.end method
