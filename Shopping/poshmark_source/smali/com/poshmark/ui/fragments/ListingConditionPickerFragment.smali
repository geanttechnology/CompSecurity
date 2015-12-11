.class public Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ListingConditionPickerFragment.java"


# instance fields
.field backoutFlag:Z

.field currentCondition:Lcom/poshmark/data_model/models/MetaItem;

.field ntw_no_checkmark:Landroid/widget/ImageView;

.field ntw_no_container:Landroid/widget/RelativeLayout;

.field ntw_retail_container:Landroid/widget/RelativeLayout;

.field ntw_yes_checkmark:Landroid/widget/ImageView;

.field ntw_yes_container:Landroid/widget/RelativeLayout;

.field nwt_message:Landroid/widget/TextView;

.field nwt_no_text:Landroid/widget/TextView;

.field nwt_yes_text:Landroid/widget/TextView;

.field retailMessage:Landroid/widget/TextView;

.field retailSwitch:Landroid/widget/Switch;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 36
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->backoutFlag:Z

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->returnData()V

    return-void
.end method

.method private initViewState(Landroid/view/View;)V
    .locals 12
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v11, 0x0

    const v10, 0x7f09003c

    const v9, 0x7f02007e

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 139
    const v5, 0x7f0c0176

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_yes_container:Landroid/widget/RelativeLayout;

    .line 140
    const v5, 0x7f0c0177

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_yes_text:Landroid/widget/TextView;

    .line 141
    const v5, 0x7f0c017d

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_no_text:Landroid/widget/TextView;

    .line 142
    const v5, 0x7f0c0179

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_retail_container:Landroid/widget/RelativeLayout;

    .line 143
    const v5, 0x7f0c017c

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_no_container:Landroid/widget/RelativeLayout;

    .line 144
    const v5, 0x7f0c0178

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_yes_checkmark:Landroid/widget/ImageView;

    .line 145
    const v5, 0x7f0c017e

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_no_checkmark:Landroid/widget/ImageView;

    .line 146
    const v5, 0x7f0c0180

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->retailMessage:Landroid/widget/TextView;

    .line 147
    const v5, 0x7f0c017b

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Switch;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->retailSwitch:Landroid/widget/Switch;

    .line 148
    const v5, 0x7f0c017f

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_message:Landroid/widget/TextView;

    .line 150
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->currentCondition:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v5, :cond_0

    .line 151
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->currentCondition:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v5

    const-string v6, "nwt"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 152
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_yes_checkmark:Landroid/widget/ImageView;

    invoke-virtual {v5, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 153
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_retail_container:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 154
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->retailMessage:Landroid/widget/TextView;

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 155
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_yes_text:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTextColor(I)V

    .line 156
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_yes_text:Landroid/widget/TextView;

    invoke-virtual {v5, v11, v8}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 157
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_yes_checkmark:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 175
    :cond_0
    :goto_0
    const v5, 0x7f060213

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 176
    .local v3, "poshmarkNWTPolicyText":Ljava/lang/String;
    new-instance v4, Landroid/text/SpannableStringBuilder;

    invoke-direct {v4, v3}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 177
    .local v4, "ssb":Landroid/text/SpannableStringBuilder;
    const v5, 0x7f0601d8

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 179
    .local v2, "nwtPolicyText":Ljava/lang/String;
    invoke-virtual {v3, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 180
    .local v0, "idx1":I
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    add-int v1, v0, v5

    .line 181
    .local v1, "idx2":I
    new-instance v5, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$4;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$4;-><init>(Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;)V

    invoke-virtual {v4, v5, v0, v1, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 188
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_message:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 189
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_message:Landroid/widget/TextView;

    sget-object v6, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {v5, v4, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 191
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_message:Landroid/widget/TextView;

    new-instance v6, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$5;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$5;-><init>(Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;)V

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 202
    return-void

    .line 158
    .end local v0    # "idx1":I
    .end local v1    # "idx2":I
    .end local v2    # "nwtPolicyText":Ljava/lang/String;
    .end local v3    # "poshmarkNWTPolicyText":Ljava/lang/String;
    .end local v4    # "ssb":Landroid/text/SpannableStringBuilder;
    :cond_1
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->currentCondition:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v5

    const-string v6, "ret"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 159
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_retail_container:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 160
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_yes_checkmark:Landroid/widget/ImageView;

    invoke-virtual {v5, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 161
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->retailSwitch:Landroid/widget/Switch;

    invoke-virtual {v5, v7}, Landroid/widget/Switch;->setVisibility(I)V

    .line 162
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->retailMessage:Landroid/widget/TextView;

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 163
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_yes_text:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTextColor(I)V

    .line 164
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_yes_text:Landroid/widget/TextView;

    invoke-virtual {v5, v11, v8}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 165
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_yes_checkmark:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 166
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_retail_container:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 167
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->retailSwitch:Landroid/widget/Switch;

    invoke-virtual {v5, v8}, Landroid/widget/Switch;->setChecked(Z)V

    goto/16 :goto_0

    .line 169
    :cond_2
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_no_checkmark:Landroid/widget/ImageView;

    invoke-virtual {v5, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 170
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_no_checkmark:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_0
.end method

.method private returnData()V
    .locals 9

    .prologue
    const/4 v8, -0x1

    .line 218
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/fragments/PMFragment;

    .line 219
    .local v5, "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->currentCondition:Lcom/poshmark/data_model/models/MetaItem;

    const-class v7, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v6, v7}, Lcom/poshmark/utils/StringUtils;->toJson(Lcom/poshmark/data_model/models/MetaItem;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 220
    .local v2, "json":Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 221
    .local v0, "b":Landroid/os/Bundle;
    const-string v6, "DATA_SELECTED"

    invoke-virtual {v0, v6, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 222
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 223
    .local v1, "i":Landroid/content/Intent;
    const-string v6, "RETURNED_RESULTS"

    invoke-virtual {v1, v6, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 225
    if-eqz v5, :cond_1

    .line 226
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getTargetRequestCode()I

    move-result v4

    .line 227
    .local v4, "requestCode":I
    invoke-virtual {v5, v4, v8, v1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 228
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    .line 229
    .local v3, "parent":Landroid/app/Activity;
    if-eqz v3, :cond_0

    .line 230
    invoke-virtual {v3}, Landroid/app/Activity;->onBackPressed()V

    .line 237
    .end local v3    # "parent":Landroid/app/Activity;
    .end local v4    # "requestCode":I
    :cond_0
    :goto_0
    return-void

    .line 234
    :cond_1
    invoke-virtual {p0, v8, v1}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_0
.end method

.method private setupHandlers()V
    .locals 2

    .prologue
    .line 73
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_yes_container:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$1;-><init>(Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 98
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_no_container:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;-><init>(Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 123
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->retailSwitch:Landroid/widget/Switch;

    new-instance v1, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$3;-><init>(Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 136
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 250
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 251
    if-nez p1, :cond_0

    .line 254
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 51
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 52
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 56
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 57
    const v2, 0x7f030060

    const/4 v3, 0x0

    invoke-virtual {p1, v2, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 58
    .local v1, "v":Landroid/view/View;
    if-nez p3, :cond_1

    .line 59
    const-class v2, Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/MetaItem;

    .line 60
    .local v0, "condition":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v0, :cond_0

    .line 61
    invoke-static {v0}, Lcom/poshmark/data_model/models/MetaItem;->clone(Lcom/poshmark/data_model/models/MetaItem;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->currentCondition:Lcom/poshmark/data_model/models/MetaItem;

    .line 63
    :cond_0
    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->initViewState(Landroid/view/View;)V

    .line 64
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->setupHandlers()V

    .line 69
    .end local v0    # "condition":Lcom/poshmark/data_model/models/MetaItem;
    :goto_0
    return-object v1

    .line 66
    :cond_1
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->backoutFlag:Z

    goto :goto_0
.end method

.method public onPMResume()V
    .locals 1

    .prologue
    .line 242
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 243
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->backoutFlag:Z

    if-eqz v0, :cond_0

    .line 244
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 246
    :cond_0
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 0

    .prologue
    .line 258
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 206
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 207
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->showRefreshButton(Z)V

    .line 208
    const v0, 0x7f06026b

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->setTitle(I)V

    .line 209
    const-string v0, "DONE"

    new-instance v1, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$6;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$6;-><init>(Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 215
    return-void
.end method
