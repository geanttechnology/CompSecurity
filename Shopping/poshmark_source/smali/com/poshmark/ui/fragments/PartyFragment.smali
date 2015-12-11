.class public Lcom/poshmark/ui/fragments/PartyFragment;
.super Lcom/poshmark/ui/fragments/PMFilterableFragment;
.source "PartyFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/ListingNotificationHandler;


# instance fields
.field private adapter:Landroid/widget/CursorAdapter;

.field private bIsActiveParty:Z

.field private event:Lcom/poshmark/data_model/models/PartyEvent;

.field private eventData:Lcom/poshmark/data_model/models/PMData;

.field private eventId:Ljava/lang/String;

.field private eventListView:Lcom/poshmark/ui/customviews/PMListView;

.field private headerView:Landroid/view/View;

.field private selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

.field private viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 55
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;-><init>()V

    .line 58
    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    .line 59
    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    .line 60
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->bIsActiveParty:Z

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/PartyFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PartyFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/PartyFragment;->getPartyListings(Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/PartyFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PartyFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 55
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/PartyFragment;->handlePastEventResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/PartyFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PartyFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Z

    .prologue
    .line 55
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/PartyFragment;->handleFilterResultsResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/PartyFragment;)Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PartyFragment;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    return-object v0
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/PartyFragment;)Lcom/poshmark/data_model/models/PartyEvent;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PartyFragment;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    return-object v0
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/PartyFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PartyFragment;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventId:Ljava/lang/String;

    return-object v0
.end method

.method private createPartyHeaderView()V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/16 v8, 0x8

    const/4 v7, 0x0

    .line 422
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 423
    .local v1, "inflater":Landroid/view/LayoutInflater;
    const v4, 0x7f030096

    const/4 v5, 0x0

    invoke-virtual {v1, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    .line 425
    new-instance v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    invoke-direct {v4}, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;-><init>()V

    iput-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    .line 427
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c023e

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/RoundedImageView;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->partyCovershotImageView:Lcom/poshmark/ui/customviews/RoundedImageView;

    .line 428
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c023f

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomCovershotLayout:Landroid/widget/LinearLayout;

    .line 429
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0240

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomCovershotIconView:Landroid/widget/ImageView;

    .line 430
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0241

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomTitleTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 431
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0242

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomDescriptionTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 434
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0069

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    .line 435
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v5, 0x7f0c006a

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    iput-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    .line 436
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->filterWidget:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-virtual {v4, p0}, Lcom/poshmark/ui/customviews/ListingsFilterWidget;->setOwnerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 437
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->hideFilterButtonsForSingleFacet()V

    .line 439
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0243

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->hostLabel:Lcom/poshmark/ui/customviews/PMTextView;

    .line 440
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PartyEvent;->getHosts()Ljava/util/List;

    move-result-object v0

    .line 441
    .local v0, "hosts":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Host;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    if-gt v4, v9, :cond_1

    .line 442
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->hostLabel:Lcom/poshmark/ui/customviews/PMTextView;

    const v5, 0x7f060140

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    .line 448
    :goto_0
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0244

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/GridLayout;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->hostImagesLayout:Landroid/widget/GridLayout;

    .line 449
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->hostImagesLayout:Landroid/widget/GridLayout;

    invoke-static {v4, v0, v5}, Lcom/poshmark/utils/ViewUtils;->populatePartyHostsInLayout(Landroid/content/Context;Ljava/util/List;Landroid/widget/GridLayout;)V

    .line 451
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0245

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->timerIconView:Landroid/widget/ImageView;

    .line 452
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0246

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->listingCountIconView:Landroid/widget/ImageView;

    .line 453
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0247

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->partyInfoTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 455
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 456
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->timerIconView:Landroid/widget/ImageView;

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 457
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->listingCountIconView:Landroid/widget/ImageView;

    invoke-virtual {v4, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 458
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->partyInfoTextView:Lcom/poshmark/ui/customviews/PMTextView;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/PartyEvent;->getFormattedPendingTime()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 477
    :cond_0
    :goto_1
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0248

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomsIconView:Landroid/widget/ImageView;

    .line 478
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c0249

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomsLabel:Lcom/poshmark/ui/customviews/PMTextView;

    .line 479
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomsLabel:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v5, Lcom/poshmark/ui/fragments/PartyFragment$7;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/PartyFragment$7;-><init>(Lcom/poshmark/ui/fragments/PartyFragment;)V

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 487
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    const v6, 0x7f0c024a

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v4, v5, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->viewDetailsLabel:Lcom/poshmark/ui/customviews/PMTextView;

    .line 488
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->viewDetailsLabel:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v5, Lcom/poshmark/ui/fragments/PartyFragment$8;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/PartyFragment$8;-><init>(Lcom/poshmark/ui/fragments/PartyFragment;)V

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 499
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PartyEvent;->hasShowrooms()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 500
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomsIconView:Landroid/widget/ImageView;

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 501
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomsLabel:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v4, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 502
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->viewDetailsLabel:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v4, v8}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 510
    :goto_2
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->updateHeaderForSelectedShowroom()V

    .line 511
    return-void

    .line 445
    :cond_1
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->hostLabel:Lcom/poshmark/ui/customviews/PMTextView;

    const v5, 0x7f060142

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    goto/16 :goto_0

    .line 460
    :cond_2
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 461
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->timerIconView:Landroid/widget/ImageView;

    invoke-virtual {v4, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 462
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->listingCountIconView:Landroid/widget/ImageView;

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 464
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PartyEvent;->getListingCount()I

    move-result v2

    .line 465
    .local v2, "listingCount":I
    if-nez v2, :cond_3

    .line 466
    const v4, 0x7f0601d2

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/PartyFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 474
    .local v3, "listingCountText":Ljava/lang/String;
    :goto_3
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->partyInfoTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v4, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1

    .line 468
    .end local v3    # "listingCountText":Ljava/lang/String;
    :cond_3
    if-ne v2, v9, :cond_4

    .line 469
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const v5, 0x7f060167

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/PartyFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .restart local v3    # "listingCountText":Ljava/lang/String;
    goto :goto_3

    .line 472
    .end local v3    # "listingCountText":Ljava/lang/String;
    :cond_4
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const v5, 0x7f06018f

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/PartyFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .restart local v3    # "listingCountText":Ljava/lang/String;
    goto :goto_3

    .line 505
    .end local v2    # "listingCount":I
    .end local v3    # "listingCountText":Ljava/lang/String;
    :cond_5
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomsIconView:Landroid/widget/ImageView;

    invoke-virtual {v4, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 506
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomsLabel:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v4, v8}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 507
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->viewDetailsLabel:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v4, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto/16 :goto_2
.end method

.method private getPartyListings(Z)V
    .locals 3
    .param p1, "isPagination"    # Z

    .prologue
    const/4 v2, 0x0

    .line 203
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->isDefault()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 204
    :cond_0
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->bIsActiveParty:Z

    if-eqz v1, :cond_2

    .line 205
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->isFilterApplied:Z

    if-eqz v1, :cond_1

    .line 206
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/PartyFragment;->loadFilterResults(Z)V

    .line 230
    :goto_0
    return-void

    .line 208
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel;->clearAvailability()V

    .line 209
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 210
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel;->clearCount()V

    .line 211
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/PartyFragment;->loadEventListings(Z)V

    .line 212
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    .line 215
    :cond_2
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->isFilterApplied:Z

    if-nez v1, :cond_4

    .line 217
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v0

    .line 218
    .local v0, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v0, :cond_3

    iget-object v1, v0, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 219
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 221
    :cond_3
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    const-string v2, "available"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 223
    .end local v0    # "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    :cond_4
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/PartyFragment;->loadFilterResults(Z)V

    goto :goto_0

    .line 227
    :cond_5
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 228
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/PartyFragment;->loadEventListings(Z)V

    goto :goto_0
.end method

.method private handleFilterResultsResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 6
    .param p2, "isPagination"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/SearchResults;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 314
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/SearchResults;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->hideProgressDialog()V

    .line 315
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v2

    if-nez v2, :cond_2

    .line 316
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getLabelForAnalytics()Ljava/lang/String;

    move-result-object v1

    .line 317
    .local v1, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "listings_filtered"

    invoke-virtual {v2, v3, v4, v5, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 319
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/SearchResults;

    .line 320
    .local v0, "data":Lcom/poshmark/data_model/models/SearchResults;
    if-nez p2, :cond_1

    .line 321
    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    .line 322
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 323
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 324
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 325
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/SearchResults;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 326
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->showDefaultEmptyContentView()V

    .line 328
    :cond_0
    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v2, Lcom/poshmark/data_model/models/SearchResults;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/SearchResults;->getFacets()Lcom/poshmark/data_model/models/Facets;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/PartyFragment;->saveFacetLists(Lcom/poshmark/data_model/models/Facets;)V

    .line 338
    .end local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    .end local v1    # "label":Ljava/lang/String;
    :goto_0
    return-void

    .line 331
    .restart local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    .restart local v1    # "label":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v2, v0}, Lcom/poshmark/data_model/models/PMData;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 332
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 336
    .end local v0    # "data":Lcom/poshmark/data_model/models/SearchResults;
    .end local v1    # "label":Ljava/lang/String;
    :cond_2
    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/PartyFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private handlePastEventResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    .locals 5
    .param p2, "isPagination"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/PartyEventListings;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 341
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PartyEventListings;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->hideProgressDialog()V

    .line 342
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_2

    .line 344
    if-nez p2, :cond_1

    .line 345
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMData;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    .line 346
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMData;->createHashAndRemoveDups()V

    .line 347
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 348
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 349
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setSelection(I)V

    .line 350
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PartyEventListings;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PartyEventListings;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 351
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->showDefaultEmptyContentView()V

    .line 363
    :cond_0
    :goto_0
    return-void

    .line 354
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/PMData;->append(Lcom/poshmark/data_model/models/PMData;)V

    .line 355
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    goto :goto_0

    .line 359
    :cond_2
    if-nez p2, :cond_0

    .line 360
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_PARTY_LISTINGS:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0600ea

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PartyFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private loadEventListings(Z)V
    .locals 4
    .param p1, "isPagination"    # Z

    .prologue
    .line 233
    const/4 v0, 0x0

    .line 234
    .local v0, "collectionId":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    if-eqz v1, :cond_0

    .line 235
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->getId()Ljava/lang/String;

    move-result-object v0

    .line 237
    :cond_0
    if-nez p1, :cond_1

    .line 238
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 239
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventId:Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v3, Lcom/poshmark/ui/fragments/PartyFragment$3;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/PartyFragment$3;-><init>(Lcom/poshmark/ui/fragments/PartyFragment;)V

    invoke-static {v1, v0, v2, v3}, Lcom/poshmark/http/api/PMApi;->getEventSummaryListings(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 262
    :goto_0
    return-void

    .line 251
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventId:Ljava/lang/String;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PMData;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/PartyFragment$4;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/PartyFragment$4;-><init>(Lcom/poshmark/ui/fragments/PartyFragment;)V

    invoke-static {v1, v0, v2, v3}, Lcom/poshmark/http/api/PMApi;->getEventSummaryListings(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private loadFilterResults(Z)V
    .locals 7
    .param p1, "isPagination"    # Z

    .prologue
    const/4 v6, 0x0

    .line 265
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    .line 267
    .local v2, "model":Lcom/poshmark/utils/SearchFilterModel;
    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getPrimaryFilters()Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->addEvent(Ljava/lang/String;)V

    .line 269
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    const-string v5, "brand"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 270
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    const-string v5, "category_v2"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 271
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    const-string v5, "size"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 272
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    const-string v5, "color"

    invoke-virtual {v4, v5}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 273
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/SearchFilterModel;->clearCount()V

    .line 275
    if-eqz p1, :cond_0

    .line 276
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PMData;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/poshmark/utils/SearchFilterModel;->setNextPageId(Ljava/lang/String;)V

    .line 278
    :cond_0
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 279
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 280
    .local v1, "gson":Lcom/google/gson/Gson;
    instance-of v4, v1, Lcom/google/gson/Gson;

    if-nez v4, :cond_1

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 282
    .end local v1    # "gson":Lcom/google/gson/Gson;
    .local v3, "searchString":Ljava/lang/String;
    :goto_0
    if-eqz p1, :cond_2

    .line 283
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PMData;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/poshmark/ui/fragments/PartyFragment$5;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/PartyFragment$5;-><init>(Lcom/poshmark/ui/fragments/PartyFragment;)V

    invoke-static {v3, v4, v6, v6, v5}, Lcom/poshmark/http/api/PMApi;->getSearchResults(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 305
    :goto_1
    return-void

    .line 280
    .end local v3    # "searchString":Ljava/lang/String;
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v2}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 293
    .restart local v3    # "searchString":Ljava/lang/String;
    :cond_2
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/PMListView;->removeEmptyContentView()V

    .line 294
    const-string v4, "pa"

    new-instance v5, Lcom/poshmark/ui/fragments/PartyFragment$6;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/PartyFragment$6;-><init>(Lcom/poshmark/ui/fragments/PartyFragment;)V

    invoke-static {v3, v6, v4, v6, v5}, Lcom/poshmark/http/api/PMApi;->getSearchResults(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_1
.end method

.method private setFilterWidgetVisibility()V
    .locals 2

    .prologue
    .line 308
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->isDefault()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 309
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 311
    :cond_1
    return-void
.end method

.method private setShowroom(I)V
    .locals 3
    .param p1, "showroomIndex"    # I

    .prologue
    .line 367
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getCollections()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-gt v1, p1, :cond_1

    .line 384
    :cond_0
    :goto_0
    return-void

    .line 370
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getCollections()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    .line 371
    .local v0, "info":Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    if-eq v1, v0, :cond_2

    .line 372
    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    .line 373
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->updateHeaderForSelectedShowroom()V

    .line 375
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060190

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/PartyFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 376
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/PartyFragment;->getPartyListings(Z)V

    .line 381
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->isDefault()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 382
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/PartyFragment;->showRefreshButton(Z)V

    goto :goto_0
.end method

.method private setupListView()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 177
    new-instance v0, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, -0x80000000

    invoke-direct {v0, v1, p0, v4, v2}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->adapter:Landroid/widget/CursorAdapter;

    .line 178
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0259

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 179
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->createPartyHeaderView()V

    .line 180
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->adapter:Landroid/widget/CursorAdapter;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->headerView:Landroid/view/View;

    new-instance v3, Lcom/poshmark/ui/fragments/PartyFragment$2;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/PartyFragment$2;-><init>(Lcom/poshmark/ui/fragments/PartyFragment;)V

    invoke-virtual {v0, v1, v2, v4, v3}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 187
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 188
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    if-nez v0, :cond_2

    .line 189
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->filterWidgetLayout:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 190
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PartyFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 191
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/PartyFragment;->getPartyListings(Z)V

    .line 197
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    if-eqz v0, :cond_1

    .line 198
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 200
    :cond_1
    return-void

    .line 193
    :cond_2
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->setFilterWidgetVisibility()V

    goto :goto_0
.end method

.method private updateHeaderForSelectedShowroom()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 388
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PartyEvent;->hasShowrooms()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    if-eqz v0, :cond_2

    .line 389
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->isDefault()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 390
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->partyCovershotImageView:Lcom/poshmark/ui/customviews/RoundedImageView;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/RoundedImageView;->setVisibility(I)V

    .line 391
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomCovershotLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 392
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomTitleTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 393
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomDescriptionTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 394
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getCovershot()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->partyCovershotImageView:Lcom/poshmark/ui/customviews/RoundedImageView;

    iget-object v2, v2, Lcom/poshmark/ui/customviews/RoundedImageView;->listener:Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;

    invoke-virtual {v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;)V

    .line 405
    :goto_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->getPostCount()I

    move-result v0

    if-ltz v0, :cond_0

    .line 406
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->partyInfoTextView:Lcom/poshmark/ui/customviews/PMTextView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->getPostCount()I

    move-result v1

    invoke-static {v1}, Lcom/poshmark/utils/NumberUtils;->getIntegerAsGroupedString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 409
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomTitleTextView:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const v2, 0x7f06026d

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/PartyFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 410
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomDescriptionTextView:Lcom/poshmark/ui/customviews/PMTextView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->getDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 419
    :goto_1
    return-void

    .line 397
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->partyCovershotImageView:Lcom/poshmark/ui/customviews/RoundedImageView;

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/RoundedImageView;->setVisibility(I)V

    .line 398
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomCovershotLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 399
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomTitleTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 400
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomDescriptionTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 402
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomCovershotLayout:Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->getCovershotBGColor()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 403
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomCovershotIconView:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->getWhiteOutlineIconDrawable()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_0

    .line 413
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->partyCovershotImageView:Lcom/poshmark/ui/customviews/RoundedImageView;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/RoundedImageView;->setVisibility(I)V

    .line 414
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomCovershotLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 415
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomTitleTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 416
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->showroomDescriptionTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 417
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getCovershot()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewHolder:Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/PartyHeaderViewHolder;->partyCovershotImageView:Lcom/poshmark/ui/customviews/RoundedImageView;

    iget-object v2, v2, Lcom/poshmark/ui/customviews/RoundedImageView;->listener:Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;

    invoke-virtual {v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;)V

    goto :goto_1
.end method


# virtual methods
.method public addCommentToListing(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 544
    return-void
.end method

.method public deleteListing(Ljava/lang/String;)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 560
    return-void
.end method

.method public filterContent()V
    .locals 1

    .prologue
    .line 524
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    .line 525
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->isFilterApplied:Z

    .line 526
    return-void
.end method

.method public fireSearch()V
    .locals 2

    .prologue
    .line 514
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->isFilterApplied:Z

    .line 515
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 516
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->toggleDrawer()V

    .line 518
    const v1, 0x7f060190

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/PartyFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/PartyFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 519
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/PartyFragment;->loadFilterResults(Z)V

    .line 520
    return-void
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 167
    const-string v0, "pa"

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v3, 0x0

    .line 570
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.poshmark.intents.FILTER_SELECTION_ACTION"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 571
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->facetsAvailable()Z

    move-result v1

    if-nez v1, :cond_1

    .line 572
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/PartyFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 573
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    const-string v2, "1"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel;->setCount(Ljava/lang/String;)V

    .line 574
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    const-string v2, "brand"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 575
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    const-string v2, "category_v2"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 576
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    const-string v2, "size"

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/FilterResultsManager;->setFacet(Ljava/lang/String;)V

    .line 577
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel;->getPrimaryFilters()Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->addEvent(Ljava/lang/String;)V

    .line 579
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchRequestString()Ljava/lang/String;

    move-result-object v0

    .line 580
    .local v0, "filterQuery":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    if-eqz v1, :cond_0

    .line 581
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventData:Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMData;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/PartyFragment$9;

    invoke-direct {v2, p0, p1}, Lcom/poshmark/ui/fragments/PartyFragment$9;-><init>(Lcom/poshmark/ui/fragments/PartyFragment;Landroid/content/Intent;)V

    invoke-static {v0, v1, v3, v3, v2}, Lcom/poshmark/http/api/PMApi;->getSearchResults(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 608
    .end local v0    # "filterQuery":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 593
    :cond_1
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->handleNotification(Landroid/content/Intent;)V

    goto :goto_0

    .line 596
    :cond_2
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->handleNotification(Landroid/content/Intent;)V

    .line 597
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.poshmark.intents.EVENTS_FETCH_COMPLETE"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 598
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    if-nez v1, :cond_0

    .line 599
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/controllers/GlobalPartiesController;->getParty(Ljava/lang/String;)Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    .line 600
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    if-eqz v1, :cond_0

    .line 601
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/controllers/GlobalPartiesController;->isCurrentParty(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->bIsActiveParty:Z

    .line 602
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->setupListView()V

    .line 603
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->setupActionBar()V

    goto :goto_0
.end method

.method public likeListing(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "likeStatus"    # Z

    .prologue
    .line 552
    return-void
.end method

.method public newListingCreated()V
    .locals 0

    .prologue
    .line 565
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 126
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 127
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    if-eqz v0, :cond_0

    .line 128
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->setupListView()V

    .line 133
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 70
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreate(Landroid/os/Bundle;)V

    .line 71
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/poshmark/notifications/ListingNotificationManager;->registerListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V

    .line 72
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v1

    const-string v2, "com.poshmark.intents.EVENTS_FETCH_COMPLETE"

    invoke-virtual {v1, v2, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 80
    const-class v1, Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/PartyFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .line 81
    .local v0, "e":Ljava/lang/Object;
    if-eqz v0, :cond_1

    .line 82
    check-cast v0, Lcom/poshmark/data_model/models/PartyEvent;

    .end local v0    # "e":Ljava/lang/Object;
    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    .line 83
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventId:Ljava/lang/String;

    .line 84
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/controllers/GlobalPartiesController;->isCurrentParty(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->bIsActiveParty:Z

    .line 85
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->hasShowrooms()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 86
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getDefaultShowroom()Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    .line 100
    :cond_0
    :goto_0
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/poshmark/notifications/ListingNotificationManager;->registerListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V

    .line 101
    return-void

    .line 88
    .restart local v0    # "e":Ljava/lang/Object;
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "ID"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventId:Ljava/lang/String;

    .line 89
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/controllers/GlobalPartiesController;->isModelPopulated()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 90
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/controllers/GlobalPartiesController;->getParty(Ljava/lang/String;)Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    .line 91
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    if-eqz v1, :cond_0

    .line 92
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->hasShowrooms()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 93
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getDefaultShowroom()Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->selectedShowroom:Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    .line 95
    :cond_2
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/controllers/GlobalPartiesController;->isCurrentParty(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/PartyFragment;->bIsActiveParty:Z

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 105
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 106
    const v1, 0x7f030099

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 107
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 6
    .param p1, "b"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    .line 137
    invoke-super {p0, p1, p2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onFragmentResult(Landroid/os/Bundle;I)V

    .line 138
    const/4 v1, 0x1

    if-ne p2, v1, :cond_0

    .line 139
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "party"

    const-string v4, "party_change_showroom"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    const-string v1, "SHOWROOM_INDEX"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 141
    .local v0, "showroomIndex":I
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/PartyFragment;->setShowroom(I)V

    .line 143
    .end local v0    # "showroomIndex":I
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 120
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onPause()V

    .line 121
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 122
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 112
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->onResume()V

    .line 113
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    if-eqz v0, :cond_0

    .line 114
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->eventListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 116
    :cond_0
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 172
    const-string v0, "party_feed_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 173
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 147
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 148
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->setupActionBar()V

    .line 150
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    if-eqz v0, :cond_0

    .line 151
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PartyFragment;->setTitle(Ljava/lang/String;)V

    .line 152
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PartyFragment;->showRefreshButton(Z)V

    .line 153
    new-instance v0, Lcom/poshmark/ui/fragments/PartyFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/PartyFragment$1;-><init>(Lcom/poshmark/ui/fragments/PartyFragment;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PartyFragment;->setRefreshActionButtonListener(Landroid/view/View$OnClickListener;)V

    .line 163
    :cond_0
    return-void
.end method

.method public updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 0
    .param p1, "listing"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 536
    return-void
.end method
