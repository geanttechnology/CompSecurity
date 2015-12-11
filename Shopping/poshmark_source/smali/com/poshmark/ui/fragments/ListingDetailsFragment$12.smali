.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$12;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateListingInfo(Landroid/widget/LinearLayout;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

.field final synthetic val$msg:Lcom/poshmark/data_model/models/inner_models/SystemMessage;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;Lcom/poshmark/data_model/models/inner_models/SystemMessage;)V
    .locals 0

    .prologue
    .line 810
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$12;->val$msg:Lcom/poshmark/data_model/models/inner_models/SystemMessage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 813
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 814
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "URL"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$12;->val$msg:Lcom/poshmark/data_model/models/inner_models/SystemMessage;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->getDestinationUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 815
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 816
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 817
    return-void
.end method
