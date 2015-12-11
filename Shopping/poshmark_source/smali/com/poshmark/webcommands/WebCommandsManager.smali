.class public Lcom/poshmark/webcommands/WebCommandsManager;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"


# static fields
.field public static JAVASCRIPT_NULL:Ljava/lang/String;


# instance fields
.field fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

.field parentActivity:Lcom/poshmark/ui/PMActivity;

.field pendingCommands:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/poshmark/webcommands/WebCommand;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 85
    const-string v0, "null"

    sput-object v0, Lcom/poshmark/webcommands/WebCommandsManager;->JAVASCRIPT_NULL:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/ui/PMActivity;Lcom/poshmark/ui/fragments/MappPageFragment;)V
    .locals 1
    .param p1, "parentActivity"    # Lcom/poshmark/ui/PMActivity;
    .param p2, "fragment"    # Lcom/poshmark/ui/fragments/MappPageFragment;

    .prologue
    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    .line 88
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    .line 89
    iput-object p2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    .line 90
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/webcommands/WebCommandsManager;)Lcom/poshmark/ui/fragments/MappPageFragment;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/webcommands/WebCommandsManager;

    .prologue
    .line 80
    invoke-direct {p0}, Lcom/poshmark/webcommands/WebCommandsManager;->getCurrentVisibleMappPageFragment()Lcom/poshmark/ui/fragments/MappPageFragment;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/webcommands/WebCommandsManager;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 80
    invoke-direct {p0, p1}, Lcom/poshmark/webcommands/WebCommandsManager;->closeTillPage(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lcom/poshmark/webcommands/WebCommandsManager;Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/webcommands/WebCommandsManager;
    .param p1, "x1"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 80
    invoke-direct {p0, p1}, Lcom/poshmark/webcommands/WebCommandsManager;->pushWebView(Lcom/poshmark/webcommands/WebCommand;)V

    return-void
.end method

.method private alertForWebView(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 2
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 292
    new-instance v0, Lcom/poshmark/utils/UIThreadTask;

    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v0, v1}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 293
    .local v0, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v1, Lcom/poshmark/webcommands/WebCommandsManager$2;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/webcommands/WebCommandsManager$2;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;Lcom/poshmark/webcommands/WebCommand;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 334
    invoke-virtual {v0, p1}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 337
    return-void
.end method

.method private cancelListing(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 3
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 645
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;

    if-ne v1, v2, :cond_0

    .line 646
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    check-cast v0, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;

    .line 647
    .local v0, "pageFragment":Lcom/poshmark/ui/fragments/ListingValidationPageFragment;
    invoke-virtual {v0, p1}, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;->cancelListing(Lcom/poshmark/webcommands/WebCommand;)V

    .line 649
    .end local v0    # "pageFragment":Lcom/poshmark/ui/fragments/ListingValidationPageFragment;
    :cond_0
    return-void
.end method

.method private checkoutOffer(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 715
    iget-object v2, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "offer"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 716
    .local v0, "offerId":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 717
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/poshmark/webcommands/WebCommand;->commandHashCode()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 718
    new-instance v2, Lcom/poshmark/webcommands/CompleteOfferHandler;

    invoke-direct {v2}, Lcom/poshmark/webcommands/CompleteOfferHandler;-><init>()V

    invoke-virtual {p0, p1, v2}, Lcom/poshmark/webcommands/WebCommandsManager;->addCompletionHandlerToCommand(Lcom/poshmark/webcommands/WebCommand;Lcom/poshmark/webcommands/CommandCompletionHandler;)V

    .line 719
    new-instance v1, Lcom/poshmark/utils/UIThreadTask;

    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v1, v2}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 720
    .local v1, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v2, Lcom/poshmark/webcommands/WebCommandsManager$12;

    invoke-direct {v2, p0, v0, p1}, Lcom/poshmark/webcommands/WebCommandsManager$12;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;Lcom/poshmark/webcommands/WebCommand;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 750
    invoke-virtual {v1, p1}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 753
    .end local v1    # "task":Lcom/poshmark/utils/UIThreadTask;
    :cond_0
    return-void
.end method

.method private closeNPages(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 6
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 197
    iget-object v4, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v5, "n"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 198
    .local v3, "val":Ljava/lang/String;
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 199
    .local v0, "pageCount":I
    iget-object v4, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v4}, Lcom/poshmark/ui/PMActivity;->getFragmentStackCount()I

    move-result v2

    .line 200
    .local v2, "totalFragmentStackCount":I
    if-ne v0, v2, :cond_1

    .line 202
    iget-object v4, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v4}, Lcom/poshmark/ui/PMActivity;->finish()V

    .line 228
    :cond_0
    :goto_0
    return-void

    .line 203
    :cond_1
    if-ge v0, v2, :cond_0

    .line 204
    new-instance v1, Lcom/poshmark/utils/UIThreadTask;

    iget-object v4, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v1, v4}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 205
    .local v1, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v4, Lcom/poshmark/webcommands/WebCommandsManager$1;

    invoke-direct {v4, p0, v0, p1}, Lcom/poshmark/webcommands/WebCommandsManager$1;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;ILcom/poshmark/webcommands/WebCommand;)V

    invoke-virtual {v1, v4}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 217
    invoke-virtual {v1, p1}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private closeTillPage(Ljava/lang/String;)Z
    .locals 11
    .param p1, "pageName"    # Ljava/lang/String;

    .prologue
    .line 583
    iget-object v9, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v9}, Lcom/poshmark/ui/PMActivity;->getFragmentStackCount()I

    move-result v7

    .line 584
    .local v7, "stackCount":I
    const/4 v5, 0x0

    .line 585
    .local v5, "pageFound":Z
    const/4 v8, 0x0

    .line 586
    .local v8, "zapCount":I
    const/4 v6, 0x0

    .line 588
    .local v6, "returnVal":Z
    iget-object v9, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v9}, Lcom/poshmark/ui/PMActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 590
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    move v3, v7

    .local v3, "i":I
    :goto_0
    if-lez v3, :cond_0

    .line 591
    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/fragments/PMFragment;

    .line 592
    .local v2, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v2, :cond_2

    instance-of v9, v2, Lcom/poshmark/ui/fragments/MappPageFragment;

    if-eqz v9, :cond_2

    move-object v4, v2

    .line 593
    check-cast v4, Lcom/poshmark/ui/fragments/MappPageFragment;

    .line 594
    .local v4, "mappPageFragment":Lcom/poshmark/ui/fragments/MappPageFragment;
    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MappPageFragment;->getPageName()Ljava/lang/String;

    move-result-object v0

    .line 595
    .local v0, "destPageName":Ljava/lang/String;
    if-eqz v0, :cond_2

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 596
    const/4 v5, 0x1

    .line 603
    .end local v0    # "destPageName":Ljava/lang/String;
    .end local v2    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    .end local v4    # "mappPageFragment":Lcom/poshmark/ui/fragments/MappPageFragment;
    :cond_0
    if-eqz v5, :cond_1

    if-lez v8, :cond_1

    .line 604
    iget-object v9, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const/4 v10, 0x1

    invoke-virtual {v9, v8, v10}, Lcom/poshmark/ui/PMActivity;->popTopNFragments(IZ)V

    .line 605
    const/4 v6, 0x1

    .line 608
    :cond_1
    return v6

    .line 600
    .restart local v2    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_2
    add-int/lit8 v8, v8, 0x1

    .line 590
    add-int/lit8 v3, v3, -0x1

    goto :goto_0
.end method

.method private closeTillPageAndPushWebView(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 612
    iget-object v2, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "pageName"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 613
    .local v0, "pageName":Ljava/lang/String;
    new-instance v1, Lcom/poshmark/utils/UIThreadTask;

    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v1, v2}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 614
    .local v1, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v2, Lcom/poshmark/webcommands/WebCommandsManager$9;

    invoke-direct {v2, p0, v0, p1}, Lcom/poshmark/webcommands/WebCommandsManager$9;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;Lcom/poshmark/webcommands/WebCommand;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 621
    invoke-virtual {v1, p1}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 622
    return-void
.end method

.method private closeTillPageAndRefresh(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 626
    iget-object v2, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "pageName"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 627
    .local v0, "pageName":Ljava/lang/String;
    new-instance v1, Lcom/poshmark/utils/UIThreadTask;

    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v1, v2}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 628
    .local v1, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v2, Lcom/poshmark/webcommands/WebCommandsManager$10;

    invoke-direct {v2, p0, v0}, Lcom/poshmark/webcommands/WebCommandsManager$10;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 640
    invoke-virtual {v1, p1}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 642
    return-void
.end method

.method private closeWebView(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 1
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 557
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->finish()V

    .line 558
    return-void
.end method

.method private dismissModal(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 791
    invoke-direct {p0, p1}, Lcom/poshmark/webcommands/WebCommandsManager;->closeWebView(Lcom/poshmark/webcommands/WebCommand;)V

    .line 792
    return-void
.end method

.method private editListing(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 2
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 883
    new-instance v0, Lcom/poshmark/utils/UIThreadTask;

    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v0, v1}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 884
    .local v0, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v1, Lcom/poshmark/webcommands/WebCommandsManager$14;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/webcommands/WebCommandsManager$14;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;Lcom/poshmark/webcommands/WebCommand;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 913
    invoke-virtual {v0, p1}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 914
    return-void
.end method

.method private editMyProfile(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 239
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 240
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "MODE"

    sget-object v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_EDIT:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->ordinal()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 241
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 242
    return-void
.end method

.method private executeAPI(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 787
    return-void
.end method

.method private findPeople(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 3
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    const/4 v2, 0x0

    .line 832
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v1, Lcom/poshmark/ui/fragments/FindPeopleFragment;

    invoke-virtual {v0, v2, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 833
    return-void
.end method

.method private finishedListing(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 3
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 652
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-class v2, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;

    if-ne v1, v2, :cond_0

    .line 653
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    check-cast v0, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;

    .line 654
    .local v0, "pageFragment":Lcom/poshmark/ui/fragments/ListingValidationPageFragment;
    invoke-virtual {v0, p1}, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;->finishedListing(Lcom/poshmark/webcommands/WebCommand;)V

    .line 656
    .end local v0    # "pageFragment":Lcom/poshmark/ui/fragments/ListingValidationPageFragment;
    :cond_0
    return-void
.end method

.method private getContacts(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 6
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 529
    iget-object v3, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v4, "callback"

    invoke-interface {v3, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 530
    iget-object v3, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v4, "callback"

    const-string v5, "pmapp_fetched_contacts"

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 532
    :cond_0
    new-instance v0, Lcom/poshmark/utils/AndroidContacts;

    invoke-direct {v0}, Lcom/poshmark/utils/AndroidContacts;-><init>()V

    .line 533
    .local v0, "contacts":Lcom/poshmark/utils/AndroidContacts;
    invoke-virtual {v0}, Lcom/poshmark/utils/AndroidContacts;->getAllPhoneContacts()Ljava/lang/String;

    move-result-object v1

    .line 534
    .local v1, "contactsJson":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    instance-of v3, v3, Lcom/poshmark/ui/fragments/MappPageFragment;

    if-eqz v3, :cond_1

    .line 535
    new-instance v2, Lcom/poshmark/utils/UIThreadTask;

    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v2, v3}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 536
    .local v2, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v3, Lcom/poshmark/webcommands/WebCommandsManager$8;

    invoke-direct {v3, p0, p1, v1}, Lcom/poshmark/webcommands/WebCommandsManager$8;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;Lcom/poshmark/webcommands/WebCommand;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 542
    invoke-virtual {v2, p1}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 544
    .end local v2    # "task":Lcom/poshmark/utils/UIThreadTask;
    :cond_1
    return-void
.end method

.method private getCurrentVisibleMappPageFragment()Lcom/poshmark/ui/fragments/MappPageFragment;
    .locals 2

    .prologue
    .line 187
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v1}, Lcom/poshmark/ui/PMActivity;->getVisibleFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    .line 188
    .local v0, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v0, :cond_0

    instance-of v1, v0, Lcom/poshmark/ui/fragments/MappPageFragment;

    if-eqz v1, :cond_0

    .line 189
    check-cast v0, Lcom/poshmark/ui/fragments/MappPageFragment;

    .line 191
    .end local v0    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    :goto_0
    return-object v0

    .restart local v0    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private gotoNews(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 370
    return-void
.end method

.method private gotoPartiesList(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 3
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    const/4 v2, 0x0

    .line 348
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v1, Lcom/poshmark/ui/fragments/AllPartiesFragment;

    invoke-virtual {v0, v2, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 349
    return-void
.end method

.method private gotoShareSettings(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 5
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 876
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 877
    .local v0, "b":Landroid/os/Bundle;
    iget-object v2, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "ext_service_id"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 878
    .local v1, "external_service_id":Ljava/lang/String;
    const-string v2, "ext_service_id"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 879
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v3, Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    const/4 v4, 0x0

    invoke-virtual {v2, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 880
    return-void
.end method

.method private handleDeepLink(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 7
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 854
    iget-object v3, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v4, "url"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 856
    .local v0, "deepLink":Ljava/lang/String;
    :try_start_0
    const-string v3, "UTF-8"

    invoke-static {v0, v3}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 857
    if-eqz v0, :cond_0

    .line 858
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 859
    .local v2, "uri":Landroid/net/Uri;
    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->isValidDeepLink(Landroid/net/Uri;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 860
    invoke-static {v2}, Lcom/poshmark/utils/DeepLinkUtils;->getDeepLinkLaunchInfo(Landroid/net/Uri;)Lcom/poshmark/utils/DeepLinkLaunchInfo;

    move-result-object v1

    .line 861
    .local v1, "deepLinkInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    if-eqz v1, :cond_0

    .line 862
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 863
    iget-object v3, v1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->fragmentClass:Ljava/lang/Class;

    if-eqz v3, :cond_0

    .line 864
    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MappPageFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v3

    iget-object v4, v1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->bundle:Landroid/os/Bundle;

    iget-object v5, v1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->fragmentClass:Ljava/lang/Class;

    iget-object v6, v1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->data:Ljava/lang/Object;

    invoke-virtual {v3, v4, v5, v6}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 873
    .end local v1    # "deepLinkInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    .end local v2    # "uri":Landroid/net/Uri;
    :cond_0
    :goto_0
    return-void

    .line 871
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method private hideHUDForWebView(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 2
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 478
    new-instance v0, Lcom/poshmark/utils/UIThreadTask;

    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v0, v1}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 479
    .local v0, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v1, Lcom/poshmark/webcommands/WebCommandsManager$7;

    invoke-direct {v1, p0}, Lcom/poshmark/webcommands/WebCommandsManager$7;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 485
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 486
    return-void
.end method

.method private loadEventDetails(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 6
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 352
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 353
    .local v0, "b":Landroid/os/Bundle;
    iget-object v3, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v4, "event"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 354
    .local v2, "eventId":Ljava/lang/String;
    const-string v3, "ID"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 356
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/controllers/GlobalPartiesController;->isModelPopulated()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 357
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/poshmark/controllers/GlobalPartiesController;->getParty(Ljava/lang/String;)Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v1

    .line 358
    .local v1, "event":Lcom/poshmark/data_model/models/PartyEvent;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->isFutureEvent()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 359
    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v4, Lcom/poshmark/ui/fragments/PartyInviteFragment;

    invoke-virtual {v3, v0, v4, v1}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 366
    .end local v1    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    :cond_0
    :goto_0
    return-void

    .line 361
    .restart local v1    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    :cond_1
    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v4, Lcom/poshmark/ui/fragments/PartyFragment;

    const/4 v5, 0x0

    invoke-virtual {v3, v0, v4, v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private loadPostDetails(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 246
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 247
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "ID"

    iget-object v1, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "post"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 248
    iget-object v1, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v2, "banner"

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 249
    const-string v2, "banner_json"

    iget-object v1, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "banner"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    :cond_0
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 252
    return-void
.end method

.method private loadPurchaseOrderDetails(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 255
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "https://www.poshmark.com/mapp/purchases/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v1, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "order"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "?pageName=ORDER_DETAILS&pageType=new"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 256
    .local v0, "url":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    const-string v2, "order_details_screen"

    invoke-virtual {v1, v0, v2}, Lcom/poshmark/ui/fragments/MappPageFragment;->launchWebView(Ljava/lang/String;Ljava/lang/String;)V

    .line 257
    return-void
.end method

.method private loadSoldOrderDetails(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 260
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "https://www.poshmark.com/mapp/sales/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v1, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "order"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "?pageName=ORDER_DETAILS&pageType=new"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 261
    .local v0, "url":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    const-string v2, "order_details_screen"

    invoke-virtual {v1, v0, v2}, Lcom/poshmark/ui/fragments/MappPageFragment;->launchWebView(Ljava/lang/String;Ljava/lang/String;)V

    .line 262
    return-void
.end method

.method private loadUserProfile(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 232
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 233
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "NAME"

    iget-object v1, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "users"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 234
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v2, Lcom/poshmark/ui/fragments/ClosetFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 235
    return-void
.end method

.method private loadUserSharedListings(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 5
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 823
    iget-object v2, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "user"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 824
    .local v1, "user":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 825
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 826
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "NAME"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 827
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v3, Lcom/poshmark/ui/fragments/UserSharesFragment;

    const/4 v4, 0x0

    invoke-virtual {v2, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 829
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_0
    return-void
.end method

.method private openURL(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 5
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 508
    iget-object v3, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v4, "url"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 510
    .local v2, "url":Ljava/lang/String;
    :try_start_0
    const-string v3, "UTF-8"

    invoke-static {v2, v3}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 516
    :goto_0
    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    const-string v4, "http://"

    invoke-virtual {v3, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    const-string v4, "https://"

    invoke-virtual {v3, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 517
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "http://"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 519
    :cond_0
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 520
    .local v1, "u":Landroid/net/Uri;
    if-eqz v1, :cond_1

    .line 521
    new-instance v0, Landroid/content/Intent;

    const-string v3, "android.intent.action.VIEW"

    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 522
    .local v0, "i":Landroid/content/Intent;
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 523
    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v3, v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->startActivity(Landroid/content/Intent;)V

    .line 525
    .end local v0    # "i":Landroid/content/Intent;
    :cond_1
    return-void

    .line 512
    .end local v1    # "u":Landroid/net/Uri;
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method private parseCommand(Ljava/lang/String;)Lcom/poshmark/webcommands/WebCommand;
    .locals 13
    .param p1, "commandString"    # Ljava/lang/String;

    .prologue
    .line 131
    const-string v11, "WebCommand"

    invoke-static {v11, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 132
    new-instance v1, Lcom/poshmark/webcommands/WebCommand;

    invoke-direct {v1}, Lcom/poshmark/webcommands/WebCommand;-><init>()V

    .line 134
    .local v1, "command":Lcom/poshmark/webcommands/WebCommand;
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v9

    .line 135
    .local v9, "url":Landroid/net/Uri;
    invoke-virtual {v9}, Landroid/net/Uri;->getEncodedAuthority()Ljava/lang/String;

    move-result-object v0

    .line 136
    .local v0, "authority":Ljava/lang/String;
    invoke-virtual {v9}, Landroid/net/Uri;->getEncodedPath()Ljava/lang/String;

    move-result-object v6

    .line 137
    .local v6, "parametersString":Ljava/lang/String;
    invoke-virtual {v9}, Landroid/net/Uri;->getQueryParameterNames()Ljava/util/Set;

    move-result-object v8

    .line 140
    .local v8, "queryParams":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v11, Ljava/util/HashMap;

    invoke-direct {v11}, Ljava/util/HashMap;-><init>()V

    iput-object v11, v1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    .line 141
    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 142
    .local v3, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_0

    .line 143
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 144
    .local v4, "key":Ljava/lang/String;
    invoke-virtual {v9, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 145
    .local v10, "val":Ljava/lang/String;
    iget-object v11, v1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    invoke-interface {v11, v4, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 148
    .end local v4    # "key":Ljava/lang/String;
    .end local v10    # "val":Ljava/lang/String;
    :cond_0
    const-string v11, "."

    invoke-virtual {v0, v11}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v11

    add-int/lit8 v11, v11, 0x1

    invoke-virtual {v0, v11}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v11

    iput-object v11, v1, Lcom/poshmark/webcommands/WebCommand;->commandName:Ljava/lang/String;

    .line 149
    const-string v11, "/"

    invoke-virtual {v6, v11}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    .line 150
    .local v7, "pieces":[Ljava/lang/String;
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 151
    .local v5, "parameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v2, 0x1

    .local v2, "i":I
    :goto_1
    array-length v11, v7

    if-ge v2, v11, :cond_2

    .line 152
    add-int/lit8 v11, v2, 0x1

    array-length v12, v7

    if-lt v11, v12, :cond_1

    .line 153
    aget-object v11, v7, v2

    const-string v12, ""

    invoke-interface {v5, v11, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 151
    :goto_2
    add-int/lit8 v2, v2, 0x2

    goto :goto_1

    .line 155
    :cond_1
    aget-object v11, v7, v2

    add-int/lit8 v12, v2, 0x1

    aget-object v12, v7, v12

    invoke-interface {v5, v11, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 158
    :cond_2
    iget-object v11, v1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    invoke-interface {v11, v5}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 160
    return-object v1
.end method

.method private postNotification(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 5
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 756
    iget-object v3, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v4, "name"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 757
    .local v1, "notificationType":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 758
    const-string v3, "OfferStatusUpdated"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 759
    iget-object v3, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v4, "post_id"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 760
    .local v0, "listingId":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 761
    new-instance v2, Lcom/poshmark/utils/UIThreadTask;

    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v2, v3}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 762
    .local v2, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v3, Lcom/poshmark/webcommands/WebCommandsManager$13;

    invoke-direct {v3, p0, v0}, Lcom/poshmark/webcommands/WebCommandsManager$13;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 768
    invoke-virtual {v2, p1}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 772
    .end local v0    # "listingId":Ljava/lang/String;
    .end local v2    # "task":Lcom/poshmark/utils/UIThreadTask;
    :cond_0
    return-void
.end method

.method private presentModalWebView(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 553
    invoke-direct {p0, p1}, Lcom/poshmark/webcommands/WebCommandsManager;->pushWebView(Lcom/poshmark/webcommands/WebCommand;)V

    .line 554
    return-void
.end method

.method private pushWebBrowser(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 286
    invoke-direct {p0, p1}, Lcom/poshmark/webcommands/WebCommandsManager;->pushWebView(Lcom/poshmark/webcommands/WebCommand;)V

    .line 287
    return-void
.end method

.method private pushWebView(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 8
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 265
    invoke-direct {p0}, Lcom/poshmark/webcommands/WebCommandsManager;->getCurrentVisibleMappPageFragment()Lcom/poshmark/ui/fragments/MappPageFragment;

    move-result-object v1

    .line 266
    .local v1, "currfragment":Lcom/poshmark/ui/fragments/MappPageFragment;
    if-eqz v1, :cond_2

    .line 267
    iget-object v6, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v7, "url"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-static {v6}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 268
    .local v4, "url":Ljava/lang/String;
    if-eqz v4, :cond_2

    .line 269
    const-string v6, "http"

    invoke-virtual {v4, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 270
    const-string v6, "/"

    invoke-virtual {v4, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 271
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "https://www.poshmark.com"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 279
    :cond_0
    :goto_0
    iget-object v6, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v7, "viewForAnalytics"

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-static {v6}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 280
    .local v5, "viewNameForAnalytics":Ljava/lang/String;
    if-nez v5, :cond_1

    const-string v5, "mapp_screen"

    .end local v5    # "viewNameForAnalytics":Ljava/lang/String;
    :cond_1
    invoke-virtual {v1, v4, v5}, Lcom/poshmark/ui/fragments/MappPageFragment;->launchWebView(Ljava/lang/String;Ljava/lang/String;)V

    .line 283
    .end local v4    # "url":Ljava/lang/String;
    :cond_2
    return-void

    .line 273
    .restart local v4    # "url":Ljava/lang/String;
    :cond_3
    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->getUrlAuthority()Ljava/lang/String;

    move-result-object v0

    .line 274
    .local v0, "authority":Ljava/lang/String;
    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->getUrlPath()Ljava/lang/String;

    move-result-object v3

    .line 275
    .local v3, "path":Ljava/lang/String;
    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->getLastPathSegment()Ljava/lang/String;

    move-result-object v2

    .line 276
    .local v2, "lastSegment":Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "https://www.poshmark.com"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v3, v2, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method

.method private removeLeftNavButton(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 549
    return-void
.end method

.method private removePendingCommand(I)V
    .locals 2
    .param p1, "commandHashCode"    # I

    .prologue
    .line 181
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 182
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 184
    :cond_0
    return-void
.end method

.method private removeRightNavButton(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 399
    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MappPageFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v1

    .line 400
    .local v1, "nextButton":Landroid/widget/Button;
    invoke-virtual {v1}, Landroid/widget/Button;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 401
    .local v0, "commandHashCode":I
    invoke-direct {p0, v0}, Lcom/poshmark/webcommands/WebCommandsManager;->removePendingCommand(I)V

    .line 404
    new-instance v2, Lcom/poshmark/utils/UIThreadTask;

    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v2, v3}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 405
    .local v2, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v3, Lcom/poshmark/webcommands/WebCommandsManager$3;

    invoke-direct {v3, p0}, Lcom/poshmark/webcommands/WebCommandsManager$3;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 411
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 412
    return-void
.end method

.method private setNavLeftButton(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 496
    return-void
.end method

.method private setNavRightButton(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 2
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 416
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    instance-of v1, v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    if-eqz v1, :cond_0

    .line 417
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v1, p1}, Lcom/poshmark/ui/fragments/MappPageFragment;->addActionBarButtonCommand(Lcom/poshmark/webcommands/WebCommand;)V

    .line 420
    :cond_0
    new-instance v0, Lcom/poshmark/utils/UIThreadTask;

    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v0, v1}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 421
    .local v0, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v1, Lcom/poshmark/webcommands/WebCommandsManager$4;

    invoke-direct {v1, p0}, Lcom/poshmark/webcommands/WebCommandsManager$4;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 445
    invoke-virtual {v0, p1}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 447
    new-instance v1, Lcom/poshmark/webcommands/WebCommandsManager$5;

    invoke-direct {v1, p0}, Lcom/poshmark/webcommands/WebCommandsManager$5;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;)V

    invoke-virtual {p1, v1}, Lcom/poshmark/webcommands/WebCommand;->setCommandCompletionHandler(Lcom/poshmark/webcommands/CommandCompletionHandler;)V

    .line 454
    return-void
.end method

.method private setTitle(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 3
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 340
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v0, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v2, "title"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->setTitle(Ljava/lang/String;)V

    .line 341
    return-void
.end method

.method private showBrandPicker(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 685
    new-instance v1, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;

    invoke-direct {v1}, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;-><init>()V

    .line 686
    .local v1, "initInfo":Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;
    iget-object v2, v1, Lcom/poshmark/utils/meta_data/BrandsMetaItemPickerInfo;->allItems:Ljava/util/List;

    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/controllers/GlobalDbController;->getAllBrands()Ljava/util/List;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 687
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 688
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "SHOW_ALL"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 689
    const-string v2, "META_ITEM_MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->BRAND_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->ordinal()I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 690
    const-string v2, "SEARCH_ENABLED"

    const/4 v3, 0x1

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 691
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v3, Lcom/poshmark/ui/fragments/BrandsMetaItemListViewFragment;

    invoke-virtual {v2, v0, v3, v1}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 692
    return-void
.end method

.method private showBundle(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 836
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 837
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "ID"

    iget-object v1, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "USERS"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 838
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v2, Lcom/poshmark/ui/fragments/ViewBundleFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 839
    return-void
.end method

.method private showDiscoveredClosets(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 5
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 795
    iget-object v2, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "user_id"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 796
    .local v1, "userId":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 797
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 798
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->CLOSETS_SHARED_FIRST:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 799
    const-string v2, "ID"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 800
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v3, Lcom/poshmark/ui/fragments/UserListFragment;

    const/4 v4, 0x0

    invoke-virtual {v2, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 802
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_0
    return-void
.end method

.method private showFBDialog(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 500
    return-void
.end method

.method private showHUDForWebView(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 6
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 458
    iget-object v4, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v5, "message"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 459
    .local v2, "message":Ljava/lang/String;
    iget-object v4, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v5, "should_disable_navbar"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 460
    .local v0, "HUDFlag":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 461
    invoke-static {v0}, Ljava/lang/Boolean;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    .line 466
    .local v1, "disableNavigation":Z
    :goto_0
    new-instance v3, Lcom/poshmark/utils/UIThreadTask;

    iget-object v4, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v3, v4}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 467
    .local v3, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v4, Lcom/poshmark/webcommands/WebCommandsManager$6;

    invoke-direct {v4, p0, v2, v1}, Lcom/poshmark/webcommands/WebCommandsManager$6;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;Z)V

    invoke-virtual {v3, v4}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 473
    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 474
    return-void

    .line 463
    .end local v1    # "disableNavigation":Z
    .end local v3    # "task":Lcom/poshmark/utils/UIThreadTask;
    :cond_0
    const/4 v1, 0x0

    .restart local v1    # "disableNavigation":Z
    goto :goto_0
.end method

.method private showJustInListingsOfBrand(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 6
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 676
    iget-object v3, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v4, "Brand"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 677
    .local v1, "brandName":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v3

    invoke-static {v1}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/controllers/GlobalDbController;->getBrandCanonicalName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 678
    .local v2, "canonical_name":Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 679
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "ID"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 680
    const-string v3, "MODE"

    sget-object v4, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 681
    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v4, Lcom/poshmark/ui/fragments/BrandFragment;

    const/4 v5, 0x0

    invoke-virtual {v3, v0, v4, v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 682
    return-void
.end method

.method private showListingsOfBrand(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 6
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 668
    iget-object v3, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v4, "Brand"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 669
    .local v1, "brandName":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v3

    invoke-static {v1}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/controllers/GlobalDbController;->getBrandCanonicalName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 670
    .local v2, "canonical_name":Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 671
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "ID"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 672
    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v4, Lcom/poshmark/ui/fragments/BrandFragment;

    const/4 v5, 0x0

    invoke-virtual {v3, v0, v4, v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 673
    return-void
.end method

.method private showMyBundles(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 842
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 843
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "MODE"

    sget-object v2, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->BUNDLES:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 844
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v2, Lcom/poshmark/ui/fragments/MyLikesFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 845
    return-void
.end method

.method private showMyLikes(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 3
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    const/4 v2, 0x0

    .line 393
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v1, Lcom/poshmark/ui/fragments/MyLikesFragment;

    invoke-virtual {v0, v2, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 394
    return-void
.end method

.method private showNewClosets(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 5
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 805
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 806
    .local v0, "b":Landroid/os/Bundle;
    iget-object v2, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "type"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 807
    .local v1, "mode":Ljava/lang/String;
    if-eqz v1, :cond_2

    .line 808
    const-string v2, "newly_opened"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 809
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_OPENED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 818
    :goto_0
    const-string v2, "ID"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 819
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v3, Lcom/poshmark/ui/fragments/UserListFragment;

    const/4 v4, 0x0

    invoke-virtual {v2, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 820
    return-void

    .line 810
    :cond_0
    const-string v2, "newly_joined"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 811
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_JOINED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 813
    :cond_1
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_OPENED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 816
    :cond_2
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->NEWLY_OPENED_CLOSETS:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private showOnRampFollowingController(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 3
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    const/4 v2, 0x0

    .line 503
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v1, Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-virtual {v0, v2, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 504
    return-void
.end method

.method private showShowroom(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 5
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 659
    iget-object v2, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "showroomid"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 660
    .local v1, "showroomId":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 661
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 662
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "ID"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 663
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v3, Lcom/poshmark/ui/fragments/ShowroomFragment;

    const/4 v4, 0x0

    invoke-virtual {v2, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 665
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_0
    return-void
.end method

.method private showSuccessHUDForWebView(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 3
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 489
    iget-object v1, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v2, "message"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 490
    .local v0, "message":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->showAutoHideSuccessMessage(Ljava/lang/String;)V

    .line 491
    return-void
.end method

.method private signOut(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 3
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 697
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v2}, Lcom/poshmark/ui/PMActivity;->getFragmentStackCount()I

    move-result v1

    .line 698
    .local v1, "viewCount":I
    new-instance v0, Lcom/poshmark/utils/UIThreadTask;

    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v0, v2}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 699
    .local v0, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v2, Lcom/poshmark/webcommands/WebCommandsManager$11;

    invoke-direct {v2, p0, v1}, Lcom/poshmark/webcommands/WebCommandsManager$11;-><init>(Lcom/poshmark/webcommands/WebCommandsManager;I)V

    invoke-virtual {v0, v2}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 710
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 711
    return-void
.end method

.method private startInviteFriendsFlow(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 848
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 849
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "MODE"

    sget-object v2, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 850
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v2, Lcom/poshmark/ui/fragments/ShareFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 851
    return-void
.end method

.method private startListingFlow(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 374
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/poshmark/webcommands/WebCommand;->commandHashCode()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 375
    new-instance v1, Lcom/poshmark/webcommands/StartListingFlowCompletionHandler;

    invoke-direct {v1}, Lcom/poshmark/webcommands/StartListingFlowCompletionHandler;-><init>()V

    invoke-virtual {p0, p1, v1}, Lcom/poshmark/webcommands/WebCommandsManager;->addCompletionHandlerToCommand(Lcom/poshmark/webcommands/WebCommand;Lcom/poshmark/webcommands/CommandCompletionHandler;)V

    .line 378
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 379
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "NEW_LISTING"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 380
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v2, Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 382
    return-void
.end method

.method private takePicture(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 6
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 385
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/poshmark/webcommands/WebCommand;->commandHashCode()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 386
    new-instance v0, Lcom/poshmark/webcommands/TakePictureCompletionHandler;

    invoke-direct {v0}, Lcom/poshmark/webcommands/TakePictureCompletionHandler;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/poshmark/webcommands/WebCommandsManager;->addCompletionHandlerToCommand(Lcom/poshmark/webcommands/WebCommand;Lcom/poshmark/webcommands/CommandCompletionHandler;)V

    .line 387
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 388
    .local v1, "b":Landroid/os/Bundle;
    const-string v0, "CREATION_MODE"

    sget v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_COVERSHOT:I

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 389
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {p1}, Lcom/poshmark/webcommands/WebCommand;->commandHashCode()I

    move-result v5

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 390
    return-void
.end method

.method private trackAnalyticsEvent(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 6
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 775
    iget-object v4, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v5, "Event"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 776
    .local v1, "event":Ljava/lang/String;
    iget-object v4, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v5, "Category"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 777
    .local v0, "category":Ljava/lang/String;
    iget-object v4, p1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v5, "Labels"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 778
    .local v2, "label":Ljava/lang/String;
    iget-object v4, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MappPageFragment;->getViewNameForAnalytics()Ljava/lang/String;

    move-result-object v3

    .line 780
    .local v3, "viewName":Ljava/lang/String;
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    .line 781
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    invoke-virtual {v4, v3, v0, v1, v2}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 783
    :cond_0
    return-void
.end method

.method private updatePoshPartyReminderSettings(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 1
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 344
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalPartiesController;->forceRefreshOfEventData()V

    .line 345
    return-void
.end method


# virtual methods
.method public addCommandToPendingList()V
    .locals 0

    .prologue
    .line 562
    return-void
.end method

.method public addCompletionHandlerToCommand(Lcom/poshmark/webcommands/WebCommand;Lcom/poshmark/webcommands/CommandCompletionHandler;)V
    .locals 0
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;
    .param p2, "handler"    # Lcom/poshmark/webcommands/CommandCompletionHandler;

    .prologue
    .line 565
    invoke-virtual {p1, p2}, Lcom/poshmark/webcommands/WebCommand;->setCommandCompletionHandler(Lcom/poshmark/webcommands/CommandCompletionHandler;)V

    .line 566
    return-void
.end method

.method public fireCommand(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 7
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 113
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    iget-object v3, p1, Lcom/poshmark/webcommands/WebCommand;->commandName:Ljava/lang/String;

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 114
    .local v1, "method":Ljava/lang/reflect/Method;
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-virtual {v1, p0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2

    .line 126
    .end local v1    # "method":Ljava/lang/reflect/Method;
    :goto_0
    return-void

    .line 115
    :catch_0
    move-exception v0

    .line 116
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    sget-object v2, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v3, Lcom/poshmark/config/Env;->STAGE:Lcom/poshmark/config/Env;

    if-ne v2, v3, :cond_0

    .line 117
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    const-string v3, "Command Error"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "command not implemented:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/NoSuchMethodException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/poshmark/ui/fragments/MappPageFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    :cond_0
    invoke-virtual {v0}, Ljava/lang/NoSuchMethodException;->printStackTrace()V

    goto :goto_0

    .line 121
    .end local v0    # "e":Ljava/lang/NoSuchMethodException;
    :catch_1
    move-exception v0

    .line 122
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->printStackTrace()V

    goto :goto_0

    .line 123
    .end local v0    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_2
    move-exception v0

    .line 124
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0
.end method

.method public getPendingCommands()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/poshmark/webcommands/WebCommand;",
            ">;"
        }
    .end annotation

    .prologue
    .line 102
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    return-object v0
.end method

.method public handleCommandResult(IILandroid/content/Intent;)V
    .locals 4
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 164
    const/4 v0, 0x0

    .line 167
    .local v0, "b":Landroid/os/Bundle;
    const/4 v2, -0x1

    if-ne p2, v2, :cond_1

    .line 168
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 169
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/webcommands/WebCommand;

    .line 170
    .local v1, "command":Lcom/poshmark/webcommands/WebCommand;
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 171
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v1, v2, p3}, Lcom/poshmark/webcommands/WebCommand;->handleCommandResults(Lcom/poshmark/ui/fragments/MappPageFragment;Landroid/content/Intent;)V

    .line 178
    .end local v1    # "command":Lcom/poshmark/webcommands/WebCommand;
    :cond_0
    :goto_0
    return-void

    .line 173
    :cond_1
    if-nez p2, :cond_0

    .line 174
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 175
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public launchWebCommand(Ljava/lang/String;)V
    .locals 1
    .param p1, "commandString"    # Ljava/lang/String;

    .prologue
    .line 107
    invoke-direct {p0, p1}, Lcom/poshmark/webcommands/WebCommandsManager;->parseCommand(Ljava/lang/String;)Lcom/poshmark/webcommands/WebCommand;

    move-result-object v0

    .line 108
    .local v0, "command":Lcom/poshmark/webcommands/WebCommand;
    invoke-virtual {p0, v0}, Lcom/poshmark/webcommands/WebCommandsManager;->fireCommand(Lcom/poshmark/webcommands/WebCommand;)V

    .line 109
    return-void
.end method

.method public reAttachHandlersToPendingCommands()V
    .locals 5

    .prologue
    .line 569
    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    .line 570
    .local v0, "collection":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/poshmark/webcommands/WebCommand;>;"
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 571
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/webcommands/WebCommand;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 572
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/webcommands/WebCommand;

    .line 573
    .local v2, "wc":Lcom/poshmark/webcommands/WebCommand;
    iget-object v3, v2, Lcom/poshmark/webcommands/WebCommand;->handlerType:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    sget-object v4, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->SIMPLE_CALLBACK:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    if-ne v3, v4, :cond_1

    .line 574
    const-string v3, "PM Callback"

    const-string v4, "simple"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 575
    :cond_1
    iget-object v3, v2, Lcom/poshmark/webcommands/WebCommand;->handlerType:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    sget-object v4, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->PICTURE:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    if-ne v3, v4, :cond_0

    .line 576
    new-instance v3, Lcom/poshmark/webcommands/TakePictureCompletionHandler;

    invoke-direct {v3}, Lcom/poshmark/webcommands/TakePictureCompletionHandler;-><init>()V

    invoke-virtual {p0, v2, v3}, Lcom/poshmark/webcommands/WebCommandsManager;->addCompletionHandlerToCommand(Lcom/poshmark/webcommands/WebCommand;Lcom/poshmark/webcommands/CommandCompletionHandler;)V

    .line 577
    const-string v3, "PM Callback"

    const-string v4, "picture"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 580
    .end local v2    # "wc":Lcom/poshmark/webcommands/WebCommand;
    :cond_2
    return-void
.end method

.method public setParentWebView(Lcom/poshmark/ui/fragments/MappPageFragment;)V
    .locals 1
    .param p1, "mappPageFragment"    # Lcom/poshmark/ui/fragments/MappPageFragment;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    .line 94
    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/MappPageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    iput-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    .line 95
    return-void
.end method

.method public setPendingCommandsMap(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/poshmark/webcommands/WebCommand;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 98
    .local p1, "list":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Lcom/poshmark/webcommands/WebCommand;>;"
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager;->pendingCommands:Ljava/util/Map;

    .line 99
    return-void
.end method
