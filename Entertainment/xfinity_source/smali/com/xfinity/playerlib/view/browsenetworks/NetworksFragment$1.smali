.class Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$1;
.super Ljava/lang/Object;
.source "NetworksFragment.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
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
    .line 99
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$1;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 5
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 107
    invoke-virtual {p1}, Landroid/widget/AbsListView;->getTag()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 108
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$1;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_networks_single_grid:I

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Landroid/widget/AbsListView;->getTag()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    add-int/lit8 v4, p2, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    add-int v4, p2, p3

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 110
    :cond_0
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "i"    # I

    .prologue
    .line 103
    return-void
.end method
