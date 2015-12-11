.class public Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;
.super Landroid/app/DialogFragment;
.source "KidsFilterDialogFragment.java"


# instance fields
.field private allButton:Landroid/widget/RadioButton;

.field private downloadableCheckBox:Landroid/widget/CheckBox;

.field private onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

.field private pairList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private programTypes:Landroid/widget/RadioGroup;

.field private subscriptionOnlyCheckBox:Landroid/widget/CheckBox;

.field protected userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    .line 32
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 34
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->pairList:Ljava/util/ArrayList;

    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;)Landroid/widget/CheckBox;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->downloadableCheckBox:Landroid/widget/CheckBox;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;)Landroid/widget/CheckBox;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->subscriptionOnlyCheckBox:Landroid/widget/CheckBox;

    return-object v0
.end method

.method private buildCheckBoxsViews(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 162
    sget v2, Lcom/xfinity/playerlib/R$id;->downloadable_checkbox:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/CheckBox;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->downloadableCheckBox:Landroid/widget/CheckBox;

    .line 163
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->downloadableCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->isDownloadableOn()Z

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 165
    sget v2, Lcom/xfinity/playerlib/R$id;->subscription_only_checkbox:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/CheckBox;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->subscriptionOnlyCheckBox:Landroid/widget/CheckBox;

    .line 166
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->subscriptionOnlyCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->isHideLockOn()Z

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 168
    sget v2, Lcom/xfinity/playerlib/R$id;->downloadable_checkbox_container:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 169
    .local v0, "downloadbleCheckBoxContainer":Landroid/widget/LinearLayout;
    new-instance v2, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$3;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$3;-><init>(Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 176
    sget v2, Lcom/xfinity/playerlib/R$id;->subscription_only_checkbox_container:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 177
    .local v1, "subscriptionOnlyCheckBoxContainer":Landroid/widget/LinearLayout;
    new-instance v2, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$4;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$4;-><init>(Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 183
    return-void
.end method

.method private buildProgramTypesView()V
    .locals 8

    .prologue
    .line 110
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->pairList:Ljava/util/ArrayList;

    new-instance v5, Landroid/util/Pair;

    const-string v6, "movies"

    const-string v7, "Movies"

    invoke-direct {v5, v6, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 111
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->pairList:Ljava/util/ArrayList;

    new-instance v5, Landroid/util/Pair;

    const-string v6, "tvseries"

    const-string v7, "TV Series"

    invoke-direct {v5, v6, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 112
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->pairList:Ljava/util/ArrayList;

    new-instance v5, Landroid/util/Pair;

    const-string v6, "all"

    sget v7, Lcom/xfinity/playerlib/R$string;->movies_and_tv:I

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 114
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v4

    sget-object v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->PROGRAM_TYPE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {v4, v5}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getFiltersForCategory(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)Ljava/util/Map;

    move-result-object v0

    .line 116
    .local v0, "filterMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->pairList:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v1, v4, :cond_4

    .line 117
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->pairList:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/util/Pair;

    .line 119
    .local v2, "pair":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$layout;->kids_filter_radio_button:I

    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->programTypes:Landroid/widget/RadioGroup;

    const/4 v7, 0x0

    invoke-virtual {v4, v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    .line 120
    .local v3, "radioButton":Landroid/widget/RadioButton;
    invoke-virtual {v3, v1}, Landroid/widget/RadioButton;->setId(I)V

    .line 121
    iget-object v4, v2, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v4, Ljava/lang/CharSequence;

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;)V

    .line 123
    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    iget-object v4, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    invoke-interface {v0, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 124
    :cond_0
    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_2

    iget-object v4, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v4, Ljava/lang/String;

    const-string v5, "all"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 125
    :cond_1
    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setChecked(Z)V

    .line 128
    :cond_2
    iget-object v4, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v4, Ljava/lang/String;

    const-string v5, "all"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 129
    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->allButton:Landroid/widget/RadioButton;

    .line 132
    :cond_3
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->programTypes:Landroid/widget/RadioGroup;

    invoke-virtual {v4, v3}, Landroid/widget/RadioGroup;->addView(Landroid/view/View;)V

    .line 116
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 134
    .end local v2    # "pair":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "radioButton":Landroid/widget/RadioButton;
    :cond_4
    return-void
.end method


# virtual methods
.method clearAll()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 154
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->downloadableCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 155
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->subscriptionOnlyCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 157
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->programTypes:Landroid/widget/RadioGroup;

    invoke-virtual {v0}, Landroid/widget/RadioGroup;->clearCheck()V

    .line 158
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->allButton:Landroid/widget/RadioButton;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setChecked(Z)V

    .line 159
    return-void
.end method

.method protected getFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getKidsFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    return-object v0
.end method

.method handleDone()V
    .locals 6

    .prologue
    .line 186
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->programTypes:Landroid/widget/RadioGroup;

    invoke-virtual {v3}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v0

    .line 187
    .local v0, "checked":I
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->pairList:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/util/Pair;

    .line 189
    .local v2, "pair":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v1

    .line 190
    .local v1, "filter":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->PROGRAM_TYPE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {v1, v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->clearFiltersForCategory(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 192
    iget-object v3, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v3, Ljava/lang/String;

    const-string v4, "all"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 193
    iget-object v3, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v3, Ljava/lang/String;

    iget-object v4, v2, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v4, Ljava/lang/String;

    sget-object v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->PROGRAM_TYPE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {v1, v3, v4, v5}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->addToSelectedList(Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 196
    :cond_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->downloadableCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {v3}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v3

    invoke-virtual {v1, v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->setDownloadableOn(Z)V

    .line 197
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->subscriptionOnlyCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {v3}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v3

    invoke-virtual {v1, v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->setHideLockOn(Z)V

    .line 199
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->dismiss()V

    .line 200
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 45
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onCreate(Landroid/os/Bundle;)V

    .line 46
    const/4 v0, 0x0

    sget v1, Lcom/xfinity/playerlib/R$style;->xfinity_remote_filter_dialog:I

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->setStyle(II)V

    .line 47
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 9
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x1

    .line 67
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6, v8}, Landroid/view/Window;->requestFeature(I)Z

    .line 68
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v6

    invoke-virtual {v6, v8}, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V

    .line 70
    sget v6, Lcom/xfinity/playerlib/R$layout;->kids_filter_dialog:I

    const/4 v7, 0x0

    invoke-virtual {p1, v6, p2, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v5

    .line 73
    .local v5, "v":Landroid/view/View;
    sget v6, Lcom/xfinity/playerlib/R$id;->label:I

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 74
    .local v1, "categoryLabel":Landroid/widget/TextView;
    if-eqz v1, :cond_0

    .line 75
    sget v6, Lcom/xfinity/playerlib/R$string;->filter_program_type:I

    invoke-virtual {v1, v6}, Landroid/widget/TextView;->setText(I)V

    .line 77
    sget v6, Lcom/xfinity/playerlib/R$id;->filterCountContainer:I

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 78
    .local v3, "filterCount":Landroid/view/View;
    const/16 v6, 0x8

    invoke-virtual {v3, v6}, Landroid/view/View;->setVisibility(I)V

    .line 80
    sget v6, Lcom/xfinity/playerlib/R$id;->filter_dialog_category_item_layout:I

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 81
    .local v4, "layout":Landroid/view/View;
    invoke-virtual {v4, v8}, Landroid/view/View;->setSelected(Z)V

    .line 84
    .end local v3    # "filterCount":Landroid/view/View;
    .end local v4    # "layout":Landroid/view/View;
    :cond_0
    sget v6, Lcom/xfinity/playerlib/R$id;->program_types:I

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/RadioGroup;

    iput-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->programTypes:Landroid/widget/RadioGroup;

    .line 86
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->buildProgramTypesView()V

    .line 88
    invoke-direct {p0, v5}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->buildCheckBoxsViews(Landroid/view/View;)V

    .line 90
    sget v6, Lcom/xfinity/playerlib/R$id;->apply:I

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 91
    .local v0, "applyButton":Landroid/widget/Button;
    new-instance v6, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$1;

    invoke-direct {v6, p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;)V

    invoke-virtual {v0, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 98
    sget v6, Lcom/xfinity/playerlib/R$id;->clear:I

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 99
    .local v2, "clearButton":Landroid/widget/Button;
    new-instance v6, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$2;

    invoke-direct {v6, p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$2;-><init>(Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;)V

    invoke-virtual {v2, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 106
    return-object v5
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 146
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    if-eqz v0, :cond_0

    .line 147
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    invoke-interface {v0, p1}, Landroid/content/DialogInterface$OnDismissListener;->onDismiss(Landroid/content/DialogInterface;)V

    .line 150
    :cond_0
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onDismiss(Landroid/content/DialogInterface;)V

    .line 151
    return-void
.end method

.method public onStart()V
    .locals 4

    .prologue
    .line 52
    invoke-super {p0}, Landroid/app/DialogFragment;->onStart()V

    .line 55
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v2

    if-nez v2, :cond_0

    .line 61
    :goto_0
    return-void

    .line 58
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$dimen;->filter_layout_dialog_width:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 59
    .local v1, "width":I
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$dimen;->kids_filter_layout_dialog_height:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 60
    .local v0, "height":I
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/view/Window;->setLayout(II)V

    goto :goto_0
.end method

.method public setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    .locals 0
    .param p1, "onDismissListener"    # Landroid/content/DialogInterface$OnDismissListener;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    .line 142
    return-void
.end method
