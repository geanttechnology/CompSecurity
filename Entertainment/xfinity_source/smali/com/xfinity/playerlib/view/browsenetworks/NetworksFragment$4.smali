.class Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$4;
.super Ljava/lang/Object;
.source "NetworksFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getOnItemClickListener()Landroid/widget/AdapterView$OnItemClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 215
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$4;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
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
    .line 218
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$1400()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "onItemClick()"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 219
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$4;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->executeOnItemClick(Landroid/widget/AdapterView;I)V
    invoke-static {v0, p1, p3}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$1500(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Landroid/widget/AdapterView;I)V

    .line 220
    return-void
.end method
