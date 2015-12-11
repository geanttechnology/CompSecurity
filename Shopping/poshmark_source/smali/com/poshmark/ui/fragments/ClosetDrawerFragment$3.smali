.class Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;
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
    .line 144
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ClosetDrawerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 147
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ClosetDrawerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMContainerActivity;

    .line 148
    .local v1, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v1}, Lcom/poshmark/ui/PMContainerActivity;->hideDrawer()V

    .line 149
    new-instance v0, Lcom/poshmark/utils/ReportUserDialog;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ClosetDrawerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3$1;-><init>(Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;)V

    invoke-direct {v0, v2, v3}, Lcom/poshmark/utils/ReportUserDialog;-><init>(Landroid/app/Activity;Lcom/poshmark/utils/ReportUserDialog$ReportReasonListener;)V

    .line 158
    .local v0, "alert":Lcom/poshmark/utils/ReportUserDialog;
    invoke-virtual {v0}, Lcom/poshmark/utils/ReportUserDialog;->show()V

    .line 159
    return-void
.end method
