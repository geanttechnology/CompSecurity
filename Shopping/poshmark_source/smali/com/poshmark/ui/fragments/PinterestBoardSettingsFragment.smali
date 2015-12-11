.class public Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "PinterestBoardSettingsFragment.java"


# static fields
.field public static final COMMUNITY_SHARES:I = 0x1

.field public static final MY_LISTINGS_SHARES:I = 0x2


# instance fields
.field community_shares_layout:Landroid/widget/RelativeLayout;

.field listener:Landroid/view/View$OnClickListener;

.field my_listing_shares_layout:Landroid/widget/RelativeLayout;

.field pins:Lcom/poshmark/utils/meta_data/PinterestSettings;

.field unlink_button:Lcom/poshmark/ui/customviews/PMButton;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 160
    new-instance v0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;-><init>(Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->setupView()V

    return-void
.end method

.method private setupView()V
    .locals 13

    .prologue
    const v12, 0x7f0c01bd

    const v11, 0x7f0c01ba

    const v10, 0x7f090039

    const v9, 0x7f0600be

    .line 93
    iget-object v6, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->pins:Lcom/poshmark/utils/meta_data/PinterestSettings;

    iget-object v4, v6, Lcom/poshmark/utils/meta_data/PinterestSettings;->self_board:Lcom/poshmark/utils/meta_data/PinterestBoard;

    .line 94
    .local v4, "selfBoard":Lcom/poshmark/utils/meta_data/PinterestBoard;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->pins:Lcom/poshmark/utils/meta_data/PinterestSettings;

    iget-object v2, v6, Lcom/poshmark/utils/meta_data/PinterestSettings;->others_board:Lcom/poshmark/utils/meta_data/PinterestBoard;

    .line 96
    .local v2, "othersBoard":Lcom/poshmark/utils/meta_data/PinterestBoard;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->community_shares_layout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6, v11}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMTextView;

    .line 97
    .local v0, "community_selected_board_text":Lcom/poshmark/ui/customviews/PMTextView;
    const v6, 0x7f06008f

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 98
    iget-object v6, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->community_shares_layout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6, v12}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    .line 99
    .local v5, "textview":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->community_shares_layout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6}, Landroid/widget/RelativeLayout;->getPaddingTop()I

    move-result v3

    .line 100
    .local v3, "padding":I
    iget-object v6, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->community_shares_layout:Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f020021

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 101
    iget-object v6, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->community_shares_layout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6, v3, v3, v3, v3}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    .line 102
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 103
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/poshmark/utils/meta_data/PinterestBoard;->getDisplay()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_0

    .line 104
    invoke-virtual {v2}, Lcom/poshmark/utils/meta_data/PinterestBoard;->getDisplay()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 108
    :goto_0
    iget-object v6, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->my_listing_shares_layout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6, v11}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 109
    .local v1, "my_listings_board_text":Lcom/poshmark/ui/customviews/PMTextView;
    const v6, 0x7f0601b4

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 110
    iget-object v6, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->my_listing_shares_layout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6, v12}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .end local v5    # "textview":Lcom/poshmark/ui/customviews/PMTextView;
    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    .line 111
    .restart local v5    # "textview":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 112
    if-eqz v4, :cond_1

    invoke-virtual {v4}, Lcom/poshmark/utils/meta_data/PinterestBoard;->getDisplay()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_1

    .line 113
    invoke-virtual {v4}, Lcom/poshmark/utils/meta_data/PinterestBoard;->getDisplay()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 119
    :goto_1
    iget-object v6, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->unlink_button:Lcom/poshmark/ui/customviews/PMButton;

    const v7, 0x7f0602a7

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/PMButton;->setText(Ljava/lang/CharSequence;)V

    .line 122
    return-void

    .line 106
    .end local v1    # "my_listings_board_text":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_0
    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 115
    .restart local v1    # "my_listings_board_text":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_1
    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 71
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 72
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 73
    new-instance v0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$1;-><init>(Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getPinterestSettings(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 89
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 4
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 137
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 138
    const-string v3, "RETURNED_RESULTS"

    invoke-virtual {p3, v3}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 139
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "DATA_SELECTED"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 142
    .local v1, "jsonString":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 143
    const-class v3, Lcom/poshmark/utils/meta_data/PinterestBoard;

    invoke-static {v1, v3}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/utils/meta_data/PinterestBoard;

    .line 144
    .local v2, "selectedBoard":Lcom/poshmark/utils/meta_data/PinterestBoard;
    packed-switch p1, :pswitch_data_0

    .line 158
    .end local v2    # "selectedBoard":Lcom/poshmark/utils/meta_data/PinterestBoard;
    :cond_0
    :goto_0
    return-void

    .line 148
    .restart local v2    # "selectedBoard":Lcom/poshmark/utils/meta_data/PinterestBoard;
    :pswitch_0
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->pins:Lcom/poshmark/utils/meta_data/PinterestSettings;

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/PinterestSettings;->others_board:Lcom/poshmark/utils/meta_data/PinterestBoard;

    goto :goto_0

    .line 154
    :pswitch_1
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->pins:Lcom/poshmark/utils/meta_data/PinterestSettings;

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/PinterestSettings;->self_board:Lcom/poshmark/utils/meta_data/PinterestBoard;

    goto :goto_0

    .line 144
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 46
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 48
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 57
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 59
    const v1, 0x7f0300a2

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 60
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c0265

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->community_shares_layout:Landroid/widget/RelativeLayout;

    .line 61
    const v1, 0x7f0c0264

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->my_listing_shares_layout:Landroid/widget/RelativeLayout;

    .line 62
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->community_shares_layout:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 63
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->my_listing_shares_layout:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 64
    const v1, 0x7f0c0266

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMButton;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->unlink_button:Lcom/poshmark/ui/customviews/PMButton;

    .line 65
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->unlink_button:Lcom/poshmark/ui/customviews/PMButton;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 66
    return-object v0
.end method

.method public onPMResume()V
    .locals 0

    .prologue
    .line 41
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 42
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 52
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPause()V

    .line 53
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 126
    const-string v0, "pinterest_share_settings_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 127
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 131
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 132
    const v0, 0x7f060203

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->setTitle(I)V

    .line 133
    return-void
.end method
