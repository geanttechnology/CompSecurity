.class Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;
.super Ljava/lang/Object;
.source "ListingConditionPickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->setupHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 102
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_retail_container:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 103
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->retailSwitch:Landroid/widget/Switch;

    invoke-virtual {v0, v3}, Landroid/widget/Switch;->setChecked(Z)V

    .line 105
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_yes_checkmark:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 107
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->ntw_no_checkmark:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 109
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_no_text:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f09003c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 110
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_no_text:Landroid/widget/TextView;

    const/4 v1, 0x1

    invoke-virtual {v0, v5, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 112
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_yes_text:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090035

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 113
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->nwt_yes_text:Landroid/widget/TextView;

    invoke-virtual {v0, v5, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 116
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->retailMessage:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 119
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    const-string v1, "not_nwt"

    invoke-static {v1}, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->getConditionMetaItemForListingFlow(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/data_model/models/MetaItem;->clone(Lcom/poshmark/data_model/models/MetaItem;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->currentCondition:Lcom/poshmark/data_model/models/MetaItem;

    .line 120
    return-void
.end method
