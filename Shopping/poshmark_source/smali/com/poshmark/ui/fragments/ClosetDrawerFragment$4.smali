.class Lcom/poshmark/ui/fragments/ClosetDrawerFragment$4;
.super Ljava/lang/Object;
.source "ClosetDrawerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->updateViews()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ClosetDrawerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ClosetDrawerFragment;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$4;->this$0:Lcom/poshmark/ui/fragments/ClosetDrawerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 179
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$4;->this$0:Lcom/poshmark/ui/fragments/ClosetDrawerFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 180
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->hideDrawer()V

    .line 181
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$4;->this$0:Lcom/poshmark/ui/fragments/ClosetDrawerFragment;

    const-string v2, "Unblock User"

    const-string v3, "Are you sure you want to unblock this user?"

    new-instance v4, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$4$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$4$1;-><init>(Lcom/poshmark/ui/fragments/ClosetDrawerFragment$4;)V

    invoke-virtual {v1, v2, v3, v4}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->showConfirmationMessage(Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    .line 191
    return-void
.end method
