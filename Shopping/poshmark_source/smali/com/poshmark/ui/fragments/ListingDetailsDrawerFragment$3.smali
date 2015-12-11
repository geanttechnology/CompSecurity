.class Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$3;
.super Ljava/lang/Object;
.source "ListingDetailsDrawerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->updateDrawer(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;)V
    .locals 0

    .prologue
    .line 156
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 161
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 162
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->hideDrawer()V

    .line 164
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    const v3, 0x7f06019f

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    const v4, 0x7f06019e

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$3$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$3$1;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$3;)V

    invoke-virtual {v1, v2, v3, v4}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->showConfirmationMessage(Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    .line 174
    return-void
.end method
