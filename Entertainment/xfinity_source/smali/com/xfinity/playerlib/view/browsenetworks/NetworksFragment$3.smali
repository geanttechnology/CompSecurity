.class Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$3;
.super Ljava/lang/Object;
.source "NetworksFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->fixScrollYPosition()V
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
    .line 203
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 205
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->bodyContainer:Landroid/view/ViewGroup;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$1000(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getScrollY()I

    move-result v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworksHeader:Landroid/view/View;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$1100(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getHeight()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 206
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->bodyContainer:Landroid/view/ViewGroup;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$1300(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Landroid/view/ViewGroup;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->bodyContainer:Landroid/view/ViewGroup;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$1200(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Landroid/view/ViewGroup;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getScrollX()I

    move-result v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/ViewGroup;->scrollTo(II)V

    .line 208
    :cond_0
    return-void
.end method
