.class Lcom/poshmark/ui/fragments/SignupFormFragment$4;
.super Ljava/lang/Object;
.source "SignupFormFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SignupFormFragment;->displayForm()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SignupFormFragment;)V
    .locals 0

    .prologue
    .line 322
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 12
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 326
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    iget-object v8, v8, Lcom/poshmark/ui/fragments/SignupFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v9, "user"

    const-string v10, "join_in_signup_clicked"

    const/4 v11, 0x0

    invoke-virtual {v7, v8, v9, v10, v11}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 327
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/SignupFormFragment;->isFormValid()Z
    invoke-static {v7}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$500(Lcom/poshmark/ui/fragments/SignupFormFragment;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 328
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-virtual {v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f060190

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 329
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 330
    .local v5, "signupHash":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v7, "username"

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->userNameEditText:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$600(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 331
    const-string v7, "password"

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->passwordEditText:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$700(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 332
    const-string v7, "first_name"

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->firstNameEditText:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$800(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 333
    const-string v7, "last_name"

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->lastNameEditText:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$900(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 334
    const-string v7, "email"

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->emailEditText:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1000(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 335
    const-string v7, "referral_code"

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->inviteCodeEditText:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1100(Lcom/poshmark/ui/fragments/SignupFormFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 337
    invoke-static {}, Lcom/poshmark/utils/DeepLinkUtils;->getDeepLinkHash()Ljava/util/Map;

    move-result-object v1

    .line 338
    .local v1, "deepLinkMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v7

    if-lez v7, :cond_0

    .line 339
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/SignupFormFragment;->getView()Landroid/view/View;

    move-result-object v7

    invoke-virtual {v7}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v7

    check-cast v7, Landroid/app/Activity;

    invoke-static {v7}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingStackAsJson(Landroid/app/Activity;)Ljava/lang/String;

    move-result-object v6

    .line 340
    .local v6, "trackingJSON":Ljava/lang/String;
    const-string v7, "stack"

    invoke-interface {v5, v7, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 341
    new-instance v7, Lcom/google/gson/GsonBuilder;

    invoke-direct {v7}, Lcom/google/gson/GsonBuilder;-><init>()V

    invoke-virtual {v7}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v2

    .line 342
    .local v2, "gson":Lcom/google/gson/Gson;
    new-instance v7, Lcom/poshmark/ui/fragments/SignupFormFragment$4$1;

    invoke-direct {v7, p0}, Lcom/poshmark/ui/fragments/SignupFormFragment$4$1;-><init>(Lcom/poshmark/ui/fragments/SignupFormFragment$4;)V

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/SignupFormFragment$4$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v3

    .line 343
    .local v3, "hashMap":Ljava/lang/reflect/Type;
    instance-of v7, v2, Lcom/google/gson/Gson;

    if-nez v7, :cond_4

    invoke-virtual {v2, v1, v3}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    .line 344
    .end local v2    # "gson":Lcom/google/gson/Gson;
    .local v4, "json":Ljava/lang/String;
    :goto_0
    const-string v7, "deeplinks"

    invoke-interface {v5, v7, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 346
    .end local v3    # "hashMap":Ljava/lang/reflect/Type;
    .end local v4    # "json":Ljava/lang/String;
    .end local v6    # "trackingJSON":Ljava/lang/String;
    :cond_0
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->isFbSignup:Z
    invoke-static {v7}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1200(Lcom/poshmark/ui/fragments/SignupFormFragment;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 347
    const-string v7, "ext_access_token"

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->externalToken:Ljava/lang/String;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1300(Lcom/poshmark/ui/fragments/SignupFormFragment;)Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 348
    const-string v7, "ext_service_id"

    const-string v8, "fb"

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 349
    const-string v7, "ext_token_expr"

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->exprDate:Ljava/lang/String;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1400(Lcom/poshmark/ui/fragments/SignupFormFragment;)Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 354
    :cond_1
    :goto_1
    const/4 v0, 0x0

    .line 355
    .local v0, "avataarImage":Landroid/graphics/Bitmap;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->isAvtaarImageSet:Z
    invoke-static {v7}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1600(Lcom/poshmark/ui/fragments/SignupFormFragment;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 356
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->avataar:Landroid/widget/ImageView;
    invoke-static {v7}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$200(Lcom/poshmark/ui/fragments/SignupFormFragment;)Landroid/widget/ImageView;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v7

    check-cast v7, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v7}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 358
    :cond_2
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    const/4 v8, 0x1

    # setter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->creationInProgress:Z
    invoke-static {v7, v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1702(Lcom/poshmark/ui/fragments/SignupFormFragment;Z)Z

    .line 359
    new-instance v7, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;

    invoke-direct {v7, p0}, Lcom/poshmark/ui/fragments/SignupFormFragment$4$2;-><init>(Lcom/poshmark/ui/fragments/SignupFormFragment$4;)V

    invoke-static {v5, v0, v7}, Lcom/poshmark/http/api/PMApi;->createNewUser(Ljava/util/Map;Landroid/graphics/Bitmap;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 408
    .end local v0    # "avataarImage":Landroid/graphics/Bitmap;
    .end local v1    # "deepLinkMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v5    # "signupHash":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_3
    return-void

    .line 343
    .restart local v1    # "deepLinkMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    .restart local v3    # "hashMap":Ljava/lang/reflect/Type;
    .restart local v5    # "signupHash":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v6    # "trackingJSON":Ljava/lang/String;
    :cond_4
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, v1, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 350
    .end local v3    # "hashMap":Ljava/lang/reflect/Type;
    .end local v6    # "trackingJSON":Ljava/lang/String;
    :cond_5
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->isGoogleSignup:Z
    invoke-static {v7}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1500(Lcom/poshmark/ui/fragments/SignupFormFragment;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 351
    const-string v7, "ext_access_token"

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$4;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/SignupFormFragment;->externalToken:Ljava/lang/String;
    invoke-static {v8}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$1300(Lcom/poshmark/ui/fragments/SignupFormFragment;)Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 352
    const-string v7, "ext_service_id"

    const-string v8, "gp"

    invoke-interface {v5, v7, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1
.end method
