.class Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;
.super Ljava/lang/Object;
.source "EditProfileFormFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/EditProfileFormFragment;->setupNextActionForCreate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)V
    .locals 0

    .prologue
    .line 342
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 13
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v12, 0x0

    .line 348
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v8

    iget-object v9, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    iget-object v9, v9, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v10, "user"

    const-string v11, "create_profile_button_tapped"

    invoke-virtual {v8, v9, v10, v11, v12}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 349
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 350
    .local v3, "profileInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v8, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v8

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->shoeSizeSpinner:Landroid/widget/Spinner;

    invoke-virtual {v8}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/MetaItem;

    .line 351
    .local v5, "shoeSizeItem":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v5, :cond_0

    .line 352
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v8

    iget-object v9, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    iget-object v9, v9, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v10, "user"

    const-string v11, "onramp_shoe_size_entered"

    invoke-virtual {v8, v9, v10, v11, v12}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 353
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v4

    .line 354
    .local v4, "shoeSize":Ljava/lang/String;
    if-eqz v4, :cond_0

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_0

    .line 355
    const-string v8, "shoe_size"

    invoke-interface {v3, v8, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 360
    .end local v4    # "shoeSize":Ljava/lang/String;
    :cond_0
    iget-object v8, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v8

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->dressSizeSpinner:Landroid/widget/Spinner;

    invoke-virtual {v8}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 361
    .local v2, "dressSizeItem":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v2, :cond_1

    .line 362
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v8

    iget-object v9, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    iget-object v9, v9, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v10, "user"

    const-string v11, "onramp_dress_size_entered"

    invoke-virtual {v8, v9, v10, v11, v12}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 363
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v1

    .line 364
    .local v1, "dressSize":Ljava/lang/String;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_1

    .line 365
    const-string v8, "dress_size"

    invoke-interface {v3, v8, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 369
    .end local v1    # "dressSize":Ljava/lang/String;
    :cond_1
    iget-object v8, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v8

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->cityEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v8}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 370
    .local v0, "city":Ljava/lang/String;
    iget-object v8, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v8

    iget-object v8, v8, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->websiteEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v8}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 372
    .local v7, "website":Ljava/lang/String;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_2

    .line 373
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v8

    iget-object v9, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    iget-object v9, v9, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v10, "user"

    const-string v11, "onramp_mycity_entered"

    invoke-virtual {v8, v9, v10, v11, v12}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 375
    const-string v8, ","

    invoke-virtual {v0, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 376
    .local v6, "tokens":[Ljava/lang/String;
    if-eqz v6, :cond_4

    array-length v8, v6

    const/4 v9, 0x1

    if-le v8, v9, :cond_4

    .line 377
    const-string v8, "state"

    array-length v9, v6

    add-int/lit8 v9, v9, -0x1

    aget-object v9, v6, v9

    invoke-interface {v3, v8, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 378
    const-string v8, "city"

    const/4 v9, 0x0

    aget-object v9, v6, v9

    invoke-interface {v3, v8, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 384
    .end local v6    # "tokens":[Ljava/lang/String;
    :cond_2
    :goto_0
    if-eqz v7, :cond_3

    invoke-virtual {v7}, Ljava/lang/String;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_3

    .line 385
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v8

    iget-object v9, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    iget-object v9, v9, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v10, "user"

    const-string v11, "onramp_website_entered"

    invoke-virtual {v8, v9, v10, v11, v12}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 386
    const-string v8, "website"

    invoke-interface {v3, v8, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 389
    :cond_3
    new-instance v8, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5$1;

    invoke-direct {v8, p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$5$1;-><init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment$5;)V

    invoke-static {v3, v12, v8}, Lcom/poshmark/http/api/PMApi;->setUserProfile(Ljava/util/Map;Landroid/graphics/Bitmap;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 417
    return-void

    .line 380
    .restart local v6    # "tokens":[Ljava/lang/String;
    :cond_4
    const-string v8, "city"

    invoke-interface {v3, v8, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method
