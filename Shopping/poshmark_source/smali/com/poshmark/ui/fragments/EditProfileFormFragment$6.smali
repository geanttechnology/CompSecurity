.class Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;
.super Ljava/lang/Object;
.source "EditProfileFormFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/EditProfileFormFragment;->setupNextActionForUpdate()V
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
    .line 427
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 431
    iget-object v4, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isFormValid()Z
    invoke-static {v4}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$300(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 432
    iget-object v4, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    const-string v5, "Updating..."

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 433
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 435
    .local v2, "profileInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v4}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->cityEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 436
    .local v1, "city":Ljava/lang/String;
    if-eqz v1, :cond_3

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_3

    .line 438
    const-string v4, ","

    invoke-virtual {v1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 439
    .local v3, "tokens":[Ljava/lang/String;
    if-eqz v3, :cond_2

    array-length v4, v3

    const/4 v5, 0x1

    if-le v4, v5, :cond_2

    .line 440
    const-string v4, "state"

    array-length v5, v3

    add-int/lit8 v5, v5, -0x1

    aget-object v5, v3, v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 441
    const-string v4, "city"

    const/4 v5, 0x0

    aget-object v5, v3, v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 453
    .end local v3    # "tokens":[Ljava/lang/String;
    :goto_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v4}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->websiteEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/PMEditText;->length()I

    move-result v4

    if-lez v4, :cond_4

    .line 454
    const-string v4, "website"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v5}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->websiteEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 460
    :goto_1
    const-string v4, "first_name"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v5}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 461
    const-string v4, "last_name"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v5}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->lastNameEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 462
    const-string v4, "email"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v5}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->emailEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 464
    const/4 v0, 0x0

    .line 465
    .local v0, "avataarImage":Landroid/graphics/Bitmap;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAvtaarImageSet:Z
    invoke-static {v4}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$400(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 466
    iget-object v4, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;
    invoke-static {v4}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$200(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/EditProfileFormViewHolder;->avataarImageView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    check-cast v4, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v4}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 469
    :cond_0
    new-instance v4, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$6$1;-><init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment$6;)V

    invoke-static {v2, v0, v4}, Lcom/poshmark/http/api/PMApi;->setUserProfile(Ljava/util/Map;Landroid/graphics/Bitmap;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 503
    .end local v0    # "avataarImage":Landroid/graphics/Bitmap;
    .end local v1    # "city":Ljava/lang/String;
    .end local v2    # "profileInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    return-void

    .line 443
    .restart local v1    # "city":Ljava/lang/String;
    .restart local v2    # "profileInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v3    # "tokens":[Ljava/lang/String;
    :cond_2
    const-string v4, "city"

    invoke-interface {v2, v4, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 444
    const-string v4, "state"

    const-string v5, ""

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 447
    .end local v3    # "tokens":[Ljava/lang/String;
    :cond_3
    const-string v4, "city"

    const-string v5, ""

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 448
    const-string v4, "state"

    const-string v5, ""

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 457
    :cond_4
    const-string v4, "website"

    const-string v5, ""

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_1
.end method
