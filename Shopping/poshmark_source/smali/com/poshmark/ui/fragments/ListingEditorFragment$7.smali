.class Lcom/poshmark/ui/fragments/ListingEditorFragment$7;
.super Ljava/lang/Object;
.source "ListingEditorFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingEditorFragment;->setupTouchListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V
    .locals 0

    .prologue
    .line 568
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 571
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    sget-object v4, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->GET_COLOR:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v4, v2, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 572
    new-instance v3, Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-direct {v3}, Lcom/poshmark/utils/meta_data/ColorPickerInfo;-><init>()V

    .line 573
    .local v3, "info":Lcom/poshmark/utils/meta_data/ColorPickerInfo;
    invoke-static {}, Lcom/poshmark/db/DbApi;->getAllColors()Ljava/util/List;

    move-result-object v2

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->allItems:Ljava/util/List;

    .line 574
    iget-object v2, v3, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/NewListing;->getColors()Ljava/util/List;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 575
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 576
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 577
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "COLOR_PICKER_MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->COLOR_LISTING_FLOW:Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE;->ordinal()I

    move-result v4

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 578
    const-class v2, Lcom/poshmark/ui/fragments/ColorPickerFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget v5, v5, Lcom/poshmark/ui/fragments/ListingEditorFragment;->DEFAULT_REQUEST_CODE:I

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 579
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "listing"

    const-string v6, "listing_select_color"

    const/4 v7, 0x0

    invoke-virtual {v2, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 580
    return-void
.end method
