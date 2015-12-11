.class public Lcom/poshmark/ui/fragments/AddressMatchFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "AddressMatchFragment.java"


# instance fields
.field private addressCheckerResults:Lcom/poshmark/data_model/models/AddressCheckerResults;

.field private addressEnteredButton:Landroid/widget/Button;

.field private addressEnteredListener:Landroid/view/View$OnClickListener;

.field private addressFoundButton:Landroid/widget/Button;

.field private addressFoundListener:Landroid/view/View$OnClickListener;

.field private nextButtonListener:Landroid/view/View$OnClickListener;

.field private selectedAddress:Lcom/poshmark/data_model/models/inner_models/Address;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 56
    new-instance v0, Lcom/poshmark/ui/fragments/AddressMatchFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/AddressMatchFragment$1;-><init>(Lcom/poshmark/ui/fragments/AddressMatchFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressFoundListener:Landroid/view/View$OnClickListener;

    .line 65
    new-instance v0, Lcom/poshmark/ui/fragments/AddressMatchFragment$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/AddressMatchFragment$2;-><init>(Lcom/poshmark/ui/fragments/AddressMatchFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressEnteredListener:Landroid/view/View$OnClickListener;

    .line 74
    new-instance v0, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;-><init>(Lcom/poshmark/ui/fragments/AddressMatchFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->nextButtonListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Lcom/poshmark/data_model/models/inner_models/Address;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/AddressMatchFragment;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->selectedAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    return-object v0
.end method

.method static synthetic access$002(Lcom/poshmark/ui/fragments/AddressMatchFragment;Lcom/poshmark/data_model/models/inner_models/Address;)Lcom/poshmark/data_model/models/inner_models/Address;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/AddressMatchFragment;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/inner_models/Address;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->selectedAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    return-object p1
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Lcom/poshmark/data_model/models/AddressCheckerResults;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/AddressMatchFragment;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressCheckerResults:Lcom/poshmark/data_model/models/AddressCheckerResults;

    return-object v0
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/AddressMatchFragment;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressFoundButton:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/AddressMatchFragment;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressEnteredButton:Landroid/widget/Button;

    return-object v0
.end method

.method private setupView(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 94
    const v2, 0x7f0c0051

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressFoundButton:Landroid/widget/Button;

    .line 95
    const v2, 0x7f0c0053

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressEnteredButton:Landroid/widget/Button;

    .line 97
    iget-object v2, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressCheckerResults:Lcom/poshmark/data_model/models/AddressCheckerResults;

    iget-object v2, v2, Lcom/poshmark/data_model/models/AddressCheckerResults;->address_entered:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/Address;->getName()Ljava/lang/String;

    move-result-object v1

    .line 98
    .local v1, "name":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressCheckerResults:Lcom/poshmark/data_model/models/AddressCheckerResults;

    iget-object v2, v2, Lcom/poshmark/data_model/models/AddressCheckerResults;->address_found:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-static {v2}, Lcom/poshmark/utils/AddressUtils;->addressStringWithoutPhone(Lcom/poshmark/data_model/models/inner_models/Address;)Ljava/lang/String;

    move-result-object v0

    .line 99
    .local v0, "addressFoundString":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 100
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 102
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressFoundButton:Landroid/widget/Button;

    invoke-virtual {v2, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 103
    iget-object v2, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressEnteredButton:Landroid/widget/Button;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressCheckerResults:Lcom/poshmark/data_model/models/AddressCheckerResults;

    iget-object v3, v3, Lcom/poshmark/data_model/models/AddressCheckerResults;->address_entered:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-static {v3}, Lcom/poshmark/utils/AddressUtils;->addressStringWithoutPhone(Lcom/poshmark/data_model/models/inner_models/Address;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 105
    iget-object v2, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressFoundButton:Landroid/widget/Button;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressFoundListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 106
    iget-object v2, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressEnteredButton:Landroid/widget/Button;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressEnteredListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 43
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 27
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 28
    const-class v0, Lcom/poshmark/data_model/models/AddressCheckerResults;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/AddressCheckerResults;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressCheckerResults:Lcom/poshmark/data_model/models/AddressCheckerResults;

    .line 29
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressCheckerResults:Lcom/poshmark/data_model/models/AddressCheckerResults;

    iget-object v0, v0, Lcom/poshmark/data_model/models/AddressCheckerResults;->address_found:Lcom/poshmark/data_model/models/inner_models/Address;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->selectedAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    .line 30
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 34
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 35
    const v1, 0x7f03000a

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 36
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->setupView(Landroid/view/View;)V

    .line 37
    return-object v0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 53
    const-string v0, "address_confirmation_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 47
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 48
    const-string v0, "Confirm Address"

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->setTitle(Ljava/lang/String;)V

    .line 49
    const v0, 0x7f0600bf

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment;->nextButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 50
    return-void
.end method
