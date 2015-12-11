.class Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$3;
.super Ljava/lang/Object;
.source "ListingConditionPickerFragment.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


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
    .line 123
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 2
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 126
    if-eqz p2, :cond_0

    .line 128
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    const-string v1, "ret"

    invoke-static {v1}, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->getConditionMetaItemForListingFlow(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/data_model/models/MetaItem;->clone(Lcom/poshmark/data_model/models/MetaItem;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->currentCondition:Lcom/poshmark/data_model/models/MetaItem;

    .line 134
    :goto_0
    return-void

    .line 131
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    const-string v1, "nwt"

    invoke-static {v1}, Lcom/poshmark/utils/meta_data/NWTOptionsMetaData;->getConditionMetaItemForListingFlow(Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/data_model/models/MetaItem;->clone(Lcom/poshmark/data_model/models/MetaItem;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->currentCondition:Lcom/poshmark/data_model/models/MetaItem;

    goto :goto_0
.end method
