.class public Lcom/poshmark/ui/fragments/PartyInviteFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "PartyInviteFragment.java"


# instance fields
.field private event:Lcom/poshmark/data_model/models/PartyEvent;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/PartyInviteFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PartyInviteFragment;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->showPartyGuidelines()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/PartyInviteFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PartyInviteFragment;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->showPartyInviteOptions()V

    return-void
.end method

.method private setupView(Landroid/view/View;)V
    .locals 12
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 80
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v6

    .line 82
    .local v6, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    const v10, 0x7f0c024b

    invoke-virtual {p1, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 83
    .local v0, "covershotBGView":Landroid/widget/ImageView;
    iget-object v10, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PartyEvent;->getCovershot()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v10, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 85
    const v10, 0x7f0c024c

    invoke-virtual {p1, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/RoundedImageView;

    .line 86
    .local v1, "covershotImageView":Lcom/poshmark/ui/customviews/RoundedImageView;
    const/4 v10, 0x1

    invoke-virtual {v1, v10}, Lcom/poshmark/ui/customviews/RoundedImageView;->setHasBorder(Z)V

    .line 87
    iget-object v10, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PartyEvent;->getCovershot()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v10, v1}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 89
    const v10, 0x7f0c024d

    invoke-virtual {p1, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/PMTextView;

    .line 90
    .local v9, "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v10, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 92
    const v10, 0x7f0c024e

    invoke-virtual {p1, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Lcom/poshmark/ui/customviews/PMTextView;

    .line 93
    .local v8, "startView":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v10, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v10

    if-eqz v10, :cond_0

    .line 94
    const v10, 0x7f06013d

    invoke-virtual {p0, v10}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 103
    :goto_0
    const v10, 0x7f0c0135

    invoke-virtual {p1, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    .line 104
    .local v2, "descriptionView":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v10, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PartyEvent;->getDescription()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v2, v10}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 106
    iget-object v10, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PartyEvent;->getHosts()Ljava/util/List;

    move-result-object v4

    .line 107
    .local v4, "hosts":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Host;>;"
    const v10, 0x7f0c0252

    invoke-virtual {p1, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/GridLayout;

    .line 108
    .local v5, "hostsLayout":Landroid/widget/GridLayout;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-static {v10, v4, v5}, Lcom/poshmark/utils/ViewUtils;->populatePartyHostsInLayout(Landroid/content/Context;Ljava/util/List;Landroid/widget/GridLayout;)V

    .line 110
    const v10, 0x7f0c0250

    invoke-virtual {p1, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    .line 111
    .local v3, "guidelinesView":Lcom/poshmark/ui/customviews/PMTextView;
    new-instance v10, Lcom/poshmark/ui/fragments/PartyInviteFragment$1;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/PartyInviteFragment$1;-><init>(Lcom/poshmark/ui/fragments/PartyInviteFragment;)V

    invoke-virtual {v3, v10}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 118
    const v10, 0x7f0c0253

    invoke-virtual {p1, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Lcom/poshmark/ui/customviews/PMButton;

    .line 119
    .local v7, "inviteButton":Lcom/poshmark/ui/customviews/PMButton;
    new-instance v10, Lcom/poshmark/ui/fragments/PartyInviteFragment$2;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/PartyInviteFragment$2;-><init>(Lcom/poshmark/ui/fragments/PartyInviteFragment;)V

    invoke-virtual {v7, v10}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 125
    return-void

    .line 96
    .end local v2    # "descriptionView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v3    # "guidelinesView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v4    # "hosts":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Host;>;"
    .end local v5    # "hostsLayout":Landroid/widget/GridLayout;
    .end local v7    # "inviteButton":Lcom/poshmark/ui/customviews/PMButton;
    :cond_0
    iget-object v10, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v10

    if-eqz v10, :cond_1

    .line 97
    const v10, 0x7f060090

    invoke-virtual {p0, v10}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 100
    :cond_1
    iget-object v10, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcom/poshmark/data_model/models/PartyEvent;->getStartDateTimeString(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method private showPartyGuidelines()V
    .locals 4

    .prologue
    .line 67
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 68
    .local v0, "activity":Lcom/poshmark/ui/PMContainerActivity;
    const/4 v1, 0x0

    const-class v2, Lcom/poshmark/ui/fragments/PartyGuidelinesFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMContainerActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 69
    return-void
.end method

.method private showPartyInviteOptions()V
    .locals 4

    .prologue
    .line 72
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 73
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 75
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 76
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 55
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 56
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 57
    const v0, 0x7f0601ed

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->setTitle(I)V

    .line 60
    :goto_0
    return-void

    .line 59
    :cond_0
    const v0, 0x7f0601f1

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->setTitle(I)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 33
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 34
    const-class v2, Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .line 35
    .local v0, "e":Ljava/lang/Object;
    if-eqz v0, :cond_1

    .line 36
    check-cast v0, Lcom/poshmark/data_model/models/PartyEvent;

    .end local v0    # "e":Ljava/lang/Object;
    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    .line 43
    :cond_0
    :goto_0
    return-void

    .line 38
    .restart local v0    # "e":Ljava/lang/Object;
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "ID"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 39
    .local v1, "eventId":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/controllers/GlobalPartiesController;->isModelPopulated()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 40
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/poshmark/controllers/GlobalPartiesController;->getParty(Ljava/lang/String;)Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->event:Lcom/poshmark/data_model/models/PartyEvent;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 47
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 48
    const v1, 0x7f030097

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 49
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/PartyInviteFragment;->setupView(Landroid/view/View;)V

    .line 50
    return-object v0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 63
    const-string v0, "party_invite_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PartyInviteFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 64
    return-void
.end method
