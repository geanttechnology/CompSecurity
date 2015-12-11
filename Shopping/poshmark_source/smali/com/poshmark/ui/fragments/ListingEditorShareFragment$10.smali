.class Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;
.super Ljava/lang/Object;
.source "ListingEditorShareFragment.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->setupPartiesShareOptions(Ljava/util/List;Landroid/widget/LinearLayout;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V
    .locals 0

    .prologue
    .line 602
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 10
    .param p1, "compoundButton"    # Landroid/widget/CompoundButton;
    .param p2, "b"    # Z

    .prologue
    const/4 v9, 0x0

    .line 605
    move-object v6, p1

    check-cast v6, Landroid/widget/Switch;

    .line 606
    .local v6, "partySwitch":Landroid/widget/Switch;
    invoke-virtual {v6}, Landroid/widget/Switch;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 607
    .local v2, "eventId":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v4

    .line 608
    .local v4, "partiesController":Lcom/poshmark/controllers/GlobalPartiesController;
    invoke-virtual {v4}, Lcom/poshmark/controllers/GlobalPartiesController;->getCurrentParties()Ljava/util/List;

    move-result-object v0

    .line 610
    .local v0, "currentParties":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PartyEvent;>;"
    invoke-virtual {v6}, Landroid/widget/Switch;->isChecked()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 611
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_0

    .line 612
    invoke-virtual {v4, v2}, Lcom/poshmark/controllers/GlobalPartiesController;->getParty(Ljava/lang/String;)Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v5

    .line 613
    .local v5, "partyEvent":Lcom/poshmark/data_model/models/PartyEvent;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    # getter for: Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;
    invoke-static {v7}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->access$000(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)Lcom/poshmark/utils/ListingManager;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/ListingManager;->getNewListing()Lcom/poshmark/data_model/models/NewListing;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/poshmark/data_model/models/PartyEvent;->isListingEligibleForParty(Lcom/poshmark/data_model/models/NewListing;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 614
    new-instance v3, Ljava/lang/String;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    const v8, 0x7f060149

    invoke-virtual {v7, v8}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v3, v7}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 615
    .local v3, "msg":Ljava/lang/String;
    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v3, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 617
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    invoke-direct {v1, v7}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 618
    .local v1, "dialogBuilder":Landroid/app/AlertDialog$Builder;
    const v7, 0x1080027

    invoke-virtual {v1, v7}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 619
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    const v8, 0x7f0600d0

    invoke-virtual {v7, v8}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 620
    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 621
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    const v8, 0x7f0602be

    invoke-virtual {v7, v8}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    new-instance v8, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10$1;

    invoke-direct {v8, p0, v5}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10$1;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;Lcom/poshmark/data_model/models/PartyEvent;)V

    invoke-virtual {v1, v7, v8}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 630
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    const v8, 0x7f0601e1

    invoke-virtual {v7, v8}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    new-instance v8, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10$2;

    invoke-direct {v8, p0, v6}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10$2;-><init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;Landroid/widget/Switch;)V

    invoke-virtual {v1, v7, v8}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 637
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 639
    invoke-virtual {v6}, Landroid/widget/Switch;->performClick()Z

    .line 640
    invoke-virtual {v6, v9}, Landroid/widget/Switch;->setChecked(Z)V

    .line 641
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    # getter for: Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;
    invoke-static {v7}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->access$000(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)Lcom/poshmark/utils/ListingManager;

    move-result-object v7

    invoke-virtual {v7, v2}, Lcom/poshmark/utils/ListingManager;->removeEventId(Ljava/lang/String;)V

    .line 651
    .end local v1    # "dialogBuilder":Landroid/app/AlertDialog$Builder;
    .end local v3    # "msg":Ljava/lang/String;
    .end local v5    # "partyEvent":Lcom/poshmark/data_model/models/PartyEvent;
    :cond_0
    :goto_0
    return-void

    .line 643
    .restart local v5    # "partyEvent":Lcom/poshmark/data_model/models/PartyEvent;
    :cond_1
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    # getter for: Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;
    invoke-static {v7}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->access$000(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)Lcom/poshmark/utils/ListingManager;

    move-result-object v7

    invoke-virtual {v7, v2}, Lcom/poshmark/utils/ListingManager;->addEventId(Ljava/lang/String;)V

    goto :goto_0

    .line 649
    .end local v5    # "partyEvent":Lcom/poshmark/data_model/models/PartyEvent;
    :cond_2
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    # getter for: Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->listingManager:Lcom/poshmark/utils/ListingManager;
    invoke-static {v7}, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;->access$000(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)Lcom/poshmark/utils/ListingManager;

    move-result-object v7

    invoke-virtual {v7, v2}, Lcom/poshmark/utils/ListingManager;->removeEventId(Ljava/lang/String;)V

    goto :goto_0
.end method
