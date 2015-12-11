.class Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$6;
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
    .line 223
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$6;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 226
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$6;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMContainerActivity;

    .line 227
    .local v1, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v1}, Lcom/poshmark/ui/PMContainerActivity;->hideDrawer()V

    .line 228
    new-instance v0, Lcom/poshmark/utils/ReportListingDialog;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$6;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$6$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$6$1;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$6;)V

    invoke-direct {v0, v2, v3}, Lcom/poshmark/utils/ReportListingDialog;-><init>(Landroid/app/Activity;Lcom/poshmark/utils/ReportListingDialog$ReportReasonListener;)V

    .line 237
    .local v0, "alert":Lcom/poshmark/utils/ReportListingDialog;
    invoke-virtual {v0}, Lcom/poshmark/utils/ReportListingDialog;->show()V

    .line 238
    return-void
.end method
