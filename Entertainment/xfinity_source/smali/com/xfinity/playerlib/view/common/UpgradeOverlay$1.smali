.class Lcom/xfinity/playerlib/view/common/UpgradeOverlay$1;
.super Ljava/lang/Object;
.source "UpgradeOverlay.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/common/UpgradeOverlay;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/common/UpgradeOverlay;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/common/UpgradeOverlay;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay$1;->this$0:Lcom/xfinity/playerlib/view/common/UpgradeOverlay;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay$1;->this$0:Lcom/xfinity/playerlib/view/common/UpgradeOverlay;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->save()V

    .line 36
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay$1;->this$0:Lcom/xfinity/playerlib/view/common/UpgradeOverlay;

    const-string v1, "UpgradeOverlay"

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->dismissOverlay(Ljava/lang/String;)V

    .line 37
    return-void
.end method
