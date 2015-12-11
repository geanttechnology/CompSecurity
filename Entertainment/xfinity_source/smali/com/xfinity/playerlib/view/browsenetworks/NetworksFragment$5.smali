.class Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$5;
.super Ljava/lang/Object;
.source "NetworksFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getOnItemLongClickListener()Landroid/widget/AdapterView$OnItemLongClickListener;
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
    .line 226
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$5;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 1
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .line 229
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$5;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->executeOnItemClick(Landroid/widget/AdapterView;I)V
    invoke-static {v0, p1, p3}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$1500(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Landroid/widget/AdapterView;I)V

    .line 230
    const/4 v0, 0x1

    return v0
.end method
