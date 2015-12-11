.class public Lcom/poshmark/utils/ListingManager;
.super Ljava/lang/Object;
.source "ListingManager.java"


# static fields
.field public static final CREATE_LISTING:I = 0x65

.field public static final LISTING_CREATED:I = 0x66


# instance fields
.field bIsNewListing:Z

.field bShareOnFacebook:Z

.field bShareOnPinterest:Z

.field bShareOnTumblr:Z

.field bShareOnTwitter:Z

.field callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field currentSentImageIndex:I

.field eventIds:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field imageList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;",
            ">;"
        }
    .end annotation
.end field

.field listingId:Ljava/lang/String;

.field newListing:Lcom/poshmark/data_model/models/NewListing;

.field newListingId:Lcom/poshmark/data_model/ID;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-boolean v0, p0, Lcom/poshmark/utils/ListingManager;->bIsNewListing:Z

    .line 56
    iput-boolean v0, p0, Lcom/poshmark/utils/ListingManager;->bShareOnTwitter:Z

    .line 57
    iput-boolean v0, p0, Lcom/poshmark/utils/ListingManager;->bShareOnTumblr:Z

    .line 58
    iput-boolean v0, p0, Lcom/poshmark/utils/ListingManager;->bShareOnFacebook:Z

    .line 59
    iput-boolean v0, p0, Lcom/poshmark/utils/ListingManager;->bShareOnPinterest:Z

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/ListingManager;->eventIds:Ljava/util/List;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/utils/ListingManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/ListingManager;

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->resumeUpload()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/utils/ListingManager;Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/utils/ListingManager;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Lcom/poshmark/utils/ListingManager;->getRetryMessageForError(Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/poshmark/utils/ListingManager;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/ListingManager;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Lcom/poshmark/utils/ListingManager;->presentRetryAlert(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/utils/ListingManager;Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/ListingManager;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Lcom/poshmark/utils/ListingManager;->loadInvalidListingMappPage(Lcom/poshmark/http/api/PMApiResponse;)V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/utils/ListingManager;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/utils/ListingManager;

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->shouldShareListing()Z

    move-result v0

    return v0
.end method

.method static synthetic access$500(Lcom/poshmark/utils/ListingManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/ListingManager;

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->shareListing()V

    return-void
.end method

.method private getCommaSeparatedEventIdsForShare()Ljava/lang/String;
    .locals 4

    .prologue
    .line 357
    const-string v0, ""

    .line 358
    .local v0, "eIds":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->eventIds:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 359
    if-nez v1, :cond_0

    .line 360
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->eventIds:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 358
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 363
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->eventIds:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 366
    :cond_1
    return-object v0
.end method

.method private getCommaSeparatedExternalServiceIdsForShare()Ljava/lang/String;
    .locals 2

    .prologue
    .line 339
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 341
    .local v0, "ids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-boolean v1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnTumblr:Z

    if-eqz v1, :cond_0

    .line 342
    const-string v1, "tm"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 344
    :cond_0
    iget-boolean v1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnFacebook:Z

    if-eqz v1, :cond_1

    .line 345
    const-string v1, "fb"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 347
    :cond_1
    iget-boolean v1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnTwitter:Z

    if-eqz v1, :cond_2

    .line 348
    const-string v1, "tw"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 350
    :cond_2
    iget-boolean v1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnPinterest:Z

    if-eqz v1, :cond_3

    .line 351
    const-string v1, "pn"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 353
    :cond_3
    const-string v1, ","

    invoke-static {v0, v1}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private getRetryMessageForError(Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;
    .locals 5
    .param p1, "apiError"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 235
    const-string v1, ""

    .line 236
    .local v1, "messagePrefix":Ljava/lang/String;
    iget-boolean v2, p0, Lcom/poshmark/utils/ListingManager;->bIsNewListing:Z

    if-eqz v2, :cond_0

    .line 237
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->POST_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v3, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v4, 0x7f0600e4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, p1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    .line 239
    .local v0, "actionErrorContext":Lcom/poshmark/ui/model/ActionErrorContext;
    iget-object v1, v0, Lcom/poshmark/ui/model/ActionErrorContext;->message:Ljava/lang/String;

    .line 246
    :goto_0
    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v3, 0x7f06022f

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 242
    .end local v0    # "actionErrorContext":Lcom/poshmark/ui/model/ActionErrorContext;
    :cond_0
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->UPDATE_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v3, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v4, 0x7f0600e5

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, p1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    .line 244
    .restart local v0    # "actionErrorContext":Lcom/poshmark/ui/model/ActionErrorContext;
    iget-object v1, v0, Lcom/poshmark/ui/model/ActionErrorContext;->message:Ljava/lang/String;

    goto :goto_0
.end method

.method private loadInvalidListingMappPage(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 16
    .param p1, "apiResponse"    # Lcom/poshmark/http/api/PMApiResponse;

    .prologue
    .line 370
    move-object/from16 v0, p1

    iget-object v7, v0, Lcom/poshmark/http/api/PMApiResponse;->responseString:Ljava/lang/String;

    .line 372
    .local v7, "errorFromServer":Ljava/lang/String;
    new-instance v10, Lcom/google/gson/Gson;

    invoke-direct {v10}, Lcom/google/gson/Gson;-><init>()V

    .line 373
    .local v10, "gson":Lcom/google/gson/Gson;
    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/poshmark/http/api/PMApiResponse;->responseString:Ljava/lang/String;

    const-class v4, Ljava/util/HashMap;

    instance-of v5, v10, Lcom/google/gson/Gson;

    if-nez v5, :cond_1

    invoke-virtual {v10, v3, v4}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v11

    .end local v10    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v11, Ljava/util/HashMap;

    .line 374
    .local v11, "hashMap":Ljava/util/HashMap;
    const-string v3, "error"

    invoke-virtual {v11, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/google/gson/internal/StringMap;

    .line 375
    .local v8, "errorMap":Lcom/google/gson/internal/StringMap;
    if-eqz v8, :cond_0

    .line 377
    invoke-static {v8}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    .line 378
    .local v13, "jsonString":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lcom/poshmark/utils/ListingManager;->bIsNewListing:Z

    if-eqz v3, :cond_2

    const-string v9, "create"

    .line 379
    .local v9, "flowType":Ljava/lang/String;
    :goto_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcom/poshmark/webcommands/WebCommandsManager;->JAVASCRIPT_NULL:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 380
    .local v12, "jsNull":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/utils/ListingManager;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/NewListing;->getWebCommandInfo()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/utils/ListingManager;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/NewListing;->getWebCommandInfo()Ljava/lang/String;

    move-result-object v15

    .line 381
    .local v15, "webCommandInfo":Ljava/lang/String;
    :goto_2
    const-string v3, "/mapp/post_validation/error?post_id=%s&flow_type=%s&params=%s&web_command_info=%s"

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/poshmark/utils/ListingManager;->newListingId:Lcom/poshmark/data_model/ID;

    iget-object v6, v6, Lcom/poshmark/data_model/ID;->id:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object v9, v4, v5

    const/4 v5, 0x2

    aput-object v13, v4, v5

    const/4 v5, 0x3

    aput-object v15, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v14

    .line 385
    .local v14, "urlString":Ljava/lang/String;
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 386
    .local v2, "b":Landroid/os/Bundle;
    const-string v3, "URL"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "https://www.poshmark.com"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 387
    const-string v3, "SHOW_REFRESH"

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 388
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 389
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v3, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/poshmark/utils/ListingManager;->newListing:Lcom/poshmark/data_model/models/NewListing;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const/4 v6, 0x2

    invoke-virtual/range {v1 .. v6}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 391
    .end local v1    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    .end local v2    # "b":Landroid/os/Bundle;
    .end local v9    # "flowType":Ljava/lang/String;
    .end local v12    # "jsNull":Ljava/lang/String;
    .end local v13    # "jsonString":Ljava/lang/String;
    .end local v14    # "urlString":Ljava/lang/String;
    .end local v15    # "webCommandInfo":Ljava/lang/String;
    :cond_0
    return-void

    .line 373
    .end local v8    # "errorMap":Lcom/google/gson/internal/StringMap;
    .end local v11    # "hashMap":Ljava/util/HashMap;
    .restart local v10    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast v10, Lcom/google/gson/Gson;

    .end local v10    # "gson":Lcom/google/gson/Gson;
    invoke-static {v10, v3, v4}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v11

    goto/16 :goto_0

    .line 378
    .restart local v8    # "errorMap":Lcom/google/gson/internal/StringMap;
    .restart local v11    # "hashMap":Ljava/util/HashMap;
    .restart local v13    # "jsonString":Ljava/lang/String;
    :cond_2
    const-string v9, "edit"

    goto/16 :goto_1

    .restart local v9    # "flowType":Ljava/lang/String;
    .restart local v12    # "jsNull":Ljava/lang/String;
    :cond_3
    move-object v15, v12

    .line 380
    goto :goto_2
.end method

.method private postNewListing()V
    .locals 4

    .prologue
    .line 146
    sget-object v1, Lcom/poshmark/utils/NewRelicCustomInteractions;->CREATE_LISTING:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 147
    iget-object v1, p0, Lcom/poshmark/utils/ListingManager;->imageList:Ljava/util/List;

    iget v2, p0, Lcom/poshmark/utils/ListingManager;->currentSentImageIndex:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 148
    .local v0, "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    iget-object v1, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f060176

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 150
    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getFileUri()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->newListing:Lcom/poshmark/data_model/models/NewListing;

    new-instance v3, Lcom/poshmark/utils/ListingManager$1;

    invoke-direct {v3, p0}, Lcom/poshmark/utils/ListingManager$1;-><init>(Lcom/poshmark/utils/ListingManager;)V

    invoke-static {v1, v2, v3}, Lcom/poshmark/http/api/PMApi;->postNewListing(Ljava/lang/String;Lcom/poshmark/data_model/models/NewListing;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 167
    return-void
.end method

.method private postNewListingNextImage()V
    .locals 6

    .prologue
    .line 171
    iget v1, p0, Lcom/poshmark/utils/ListingManager;->currentSentImageIndex:I

    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->imageList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    iget-object v1, p0, Lcom/poshmark/utils/ListingManager;->imageList:Ljava/util/List;

    iget v2, p0, Lcom/poshmark/utils/ListingManager;->currentSentImageIndex:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object v0, v1

    .line 172
    .local v0, "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :goto_0
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isImageSet()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 174
    iget-object v1, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f060177

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget v5, p0, Lcom/poshmark/utils/ListingManager;->currentSentImageIndex:I

    add-int/lit8 v5, v5, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 176
    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getFileUri()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->newListingId:Lcom/poshmark/data_model/ID;

    iget-object v2, v2, Lcom/poshmark/data_model/ID;->id:Ljava/lang/String;

    new-instance v3, Lcom/poshmark/utils/ListingManager$2;

    invoke-direct {v3, p0}, Lcom/poshmark/utils/ListingManager$2;-><init>(Lcom/poshmark/utils/ListingManager;)V

    invoke-static {v1, v2, v3}, Lcom/poshmark/http/api/PMApi;->postImageToListing(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 193
    :cond_0
    return-void

    .line 171
    .end local v0    # "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private presentRetryAlert(Ljava/lang/String;)V
    .locals 6
    .param p1, "retryMsg"    # Ljava/lang/String;

    .prologue
    .line 250
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v1, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v2, 0x7f0600d0

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v3, 0x7f06022e

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v4, 0x7f06006d

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/poshmark/utils/ListingManager$4;

    invoke-direct {v5, p0}, Lcom/poshmark/utils/ListingManager$4;-><init>(Lcom/poshmark/utils/ListingManager;)V

    move-object v2, p1

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/fragments/PMFragment;->showConfirmationMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    .line 260
    return-void
.end method

.method private publishNewListing()V
    .locals 5

    .prologue
    .line 196
    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v3, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/PMFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f060220

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 198
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->getCommaSeparatedExternalServiceIdsForShare()Ljava/lang/String;

    move-result-object v1

    .line 199
    .local v1, "extServiceIds":Ljava/lang/String;
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->getCommaSeparatedEventIdsForShare()Ljava/lang/String;

    move-result-object v0

    .line 200
    .local v0, "eIds":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->newListingId:Lcom/poshmark/data_model/ID;

    iget-object v2, v2, Lcom/poshmark/data_model/ID;->id:Ljava/lang/String;

    new-instance v3, Lcom/poshmark/utils/ListingManager$3;

    invoke-direct {v3, p0}, Lcom/poshmark/utils/ListingManager$3;-><init>(Lcom/poshmark/utils/ListingManager;)V

    invoke-static {v2, v1, v0, v3}, Lcom/poshmark/http/api/PMApi;->publishListing(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 232
    return-void
.end method

.method private resumeUpload()V
    .locals 3

    .prologue
    .line 126
    iget-boolean v1, p0, Lcom/poshmark/utils/ListingManager;->bIsNewListing:Z

    if-eqz v1, :cond_3

    .line 127
    iget v1, p0, Lcom/poshmark/utils/ListingManager;->currentSentImageIndex:I

    if-nez v1, :cond_0

    .line 128
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->postNewListing()V

    .line 143
    :goto_0
    return-void

    .line 131
    :cond_0
    iget v1, p0, Lcom/poshmark/utils/ListingManager;->currentSentImageIndex:I

    iget-object v2, p0, Lcom/poshmark/utils/ListingManager;->imageList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    iget-object v1, p0, Lcom/poshmark/utils/ListingManager;->imageList:Ljava/util/List;

    iget v2, p0, Lcom/poshmark/utils/ListingManager;->currentSentImageIndex:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object v0, v1

    .line 132
    .local v0, "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :goto_1
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isImageSet()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 133
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->postNewListingNextImage()V

    goto :goto_0

    .line 131
    .end local v0    # "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_1
    const/4 v0, 0x0

    goto :goto_1

    .line 136
    .restart local v0    # "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_2
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->publishNewListing()V

    goto :goto_0

    .line 141
    .end local v0    # "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_3
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->updateListing()V

    goto :goto_0
.end method

.method private shareListing()V
    .locals 7

    .prologue
    const/4 v4, 0x0

    .line 311
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->getCommaSeparatedExternalServiceIdsForShare()Ljava/lang/String;

    move-result-object v2

    .line 312
    .local v2, "shareTo":Ljava/lang/String;
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->getCommaSeparatedEventIdsForShare()Ljava/lang/String;

    move-result-object v0

    .line 314
    .local v0, "eIds":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/ListingManager;->listingId:Ljava/lang/String;

    invoke-static {v3, v2, v0, v4, v4}, Lcom/poshmark/http/api/PMApi;->shareListing(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 317
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/poshmark/utils/ListingManager;->newListingId:Lcom/poshmark/data_model/ID;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/ListingManager;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/NewListing;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 318
    .local v1, "label":Ljava/lang/String;
    iget-boolean v3, p0, Lcom/poshmark/utils/ListingManager;->bShareOnFacebook:Z

    if-eqz v3, :cond_0

    .line 319
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "listing_confirmation_screen"

    const-string v5, "listing"

    const-string v6, "share_listing_facebook"

    invoke-virtual {v3, v4, v5, v6, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    :cond_0
    iget-boolean v3, p0, Lcom/poshmark/utils/ListingManager;->bShareOnTwitter:Z

    if-eqz v3, :cond_1

    .line 321
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "listing_confirmation_screen"

    const-string v5, "listing"

    const-string v6, "share_listing_twitter"

    invoke-virtual {v3, v4, v5, v6, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 322
    :cond_1
    iget-boolean v3, p0, Lcom/poshmark/utils/ListingManager;->bShareOnTumblr:Z

    if-eqz v3, :cond_2

    .line 323
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "listing_confirmation_screen"

    const-string v5, "listing"

    const-string v6, "share_listing_tumblr"

    invoke-virtual {v3, v4, v5, v6, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 324
    :cond_2
    iget-boolean v3, p0, Lcom/poshmark/utils/ListingManager;->bShareOnPinterest:Z

    if-eqz v3, :cond_3

    .line 325
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "listing_confirmation_screen"

    const-string v5, "listing"

    const-string v6, "share_listing_pinterest"

    invoke-virtual {v3, v4, v5, v6, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 326
    :cond_3
    return-void
.end method

.method private shouldShareListing()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 329
    iget-object v1, p0, Lcom/poshmark/utils/ListingManager;->eventIds:Ljava/util/List;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/poshmark/utils/ListingManager;->eventIds:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 335
    :cond_0
    :goto_0
    return v0

    .line 332
    :cond_1
    iget-boolean v1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnTwitter:Z

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnFacebook:Z

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnTumblr:Z

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnPinterest:Z

    if-nez v1, :cond_0

    .line 335
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private updateListing()V
    .locals 9

    .prologue
    .line 264
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 265
    .local v0, "fileMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v6, p0, Lcom/poshmark/utils/ListingManager;->imageList:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v4

    .line 266
    .local v4, "size":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v4, :cond_3

    .line 267
    iget-object v6, p0, Lcom/poshmark/utils/ListingManager;->imageList:Ljava/util/List;

    invoke-interface {v6, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 269
    .local v2, "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    new-instance v3, Ljava/lang/String;

    invoke-direct {v3}, Ljava/lang/String;-><init>()V

    .line 270
    .local v3, "label":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 271
    const-string v3, "cover_shot"

    .line 276
    :goto_1
    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isImageSet()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 277
    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getImageUrl()Ljava/lang/String;

    move-result-object v5

    .line 278
    .local v5, "url":Ljava/lang/String;
    if-eqz v5, :cond_2

    .line 279
    iget-object v6, p0, Lcom/poshmark/utils/ListingManager;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getImageId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v3, v7}, Lcom/poshmark/data_model/models/NewListing;->setKeyValuePair(Ljava/lang/String;Ljava/lang/String;)V

    .line 266
    .end local v5    # "url":Ljava/lang/String;
    :cond_0
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 273
    :cond_1
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "picture"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 283
    .restart local v5    # "url":Ljava/lang/String;
    :cond_2
    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getFileUri()Landroid/net/Uri;

    move-result-object v6

    invoke-virtual {v6}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v0, v3, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 287
    .end local v2    # "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    .end local v3    # "label":Ljava/lang/String;
    .end local v5    # "url":Ljava/lang/String;
    :cond_3
    iget-object v6, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v7, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/PMFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f0602b5

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 288
    iget-object v6, p0, Lcom/poshmark/utils/ListingManager;->listingId:Ljava/lang/String;

    iget-object v7, p0, Lcom/poshmark/utils/ListingManager;->newListing:Lcom/poshmark/data_model/models/NewListing;

    new-instance v8, Lcom/poshmark/utils/ListingManager$5;

    invoke-direct {v8, p0}, Lcom/poshmark/utils/ListingManager$5;-><init>(Lcom/poshmark/utils/ListingManager;)V

    invoke-static {v6, v7, v0, v8}, Lcom/poshmark/http/api/PMApi;->postUpdateListing(Ljava/lang/String;Lcom/poshmark/data_model/models/NewListing;Ljava/util/Map;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 308
    return-void
.end method


# virtual methods
.method public addEventId(Ljava/lang/String;)V
    .locals 1
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager;->eventIds:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 98
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager;->eventIds:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 99
    :cond_0
    return-void
.end method

.method public getNewListing()Lcom/poshmark/data_model/models/NewListing;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager;->newListing:Lcom/poshmark/data_model/models/NewListing;

    return-object v0
.end method

.method public handleValidationResult(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 117
    const-string v0, "FINISH_LISTING"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 118
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->shouldShareListing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 119
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->shareListing()V

    .line 121
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const/4 v1, -0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 123
    :cond_1
    return-void
.end method

.method public postListing(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 1
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 107
    iput-object p1, p0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 108
    iget-boolean v0, p0, Lcom/poshmark/utils/ListingManager;->bIsNewListing:Z

    if-eqz v0, :cond_0

    .line 109
    const/4 v0, 0x0

    iput v0, p0, Lcom/poshmark/utils/ListingManager;->currentSentImageIndex:I

    .line 110
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->resumeUpload()V

    .line 114
    :goto_0
    return-void

    .line 112
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/utils/ListingManager;->updateListing()V

    goto :goto_0
.end method

.method public removeEventId(Ljava/lang/String;)V
    .locals 1
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 102
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager;->eventIds:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager;->eventIds:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 104
    :cond_0
    return-void
.end method

.method public setFacebookShareFlag(Z)V
    .locals 0
    .param p1, "shareFlag"    # Z

    .prologue
    .line 89
    iput-boolean p1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnFacebook:Z

    .line 90
    return-void
.end method

.method public setImageList(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 68
    .local p1, "imageList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;>;"
    iput-object p1, p0, Lcom/poshmark/utils/ListingManager;->imageList:Ljava/util/List;

    .line 69
    return-void
.end method

.method public setListingDetails(Lcom/poshmark/data_model/models/NewListing;Ljava/lang/String;)V
    .locals 0
    .param p1, "listingInfo"    # Lcom/poshmark/data_model/models/NewListing;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/poshmark/utils/ListingManager;->newListing:Lcom/poshmark/data_model/models/NewListing;

    .line 77
    iput-object p2, p0, Lcom/poshmark/utils/ListingManager;->listingId:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setListingFlag(Z)V
    .locals 0
    .param p1, "bIsNewListing"    # Z

    .prologue
    .line 72
    iput-boolean p1, p0, Lcom/poshmark/utils/ListingManager;->bIsNewListing:Z

    .line 73
    return-void
.end method

.method public setPinterestShareFlag(Z)V
    .locals 0
    .param p1, "shareFlag"    # Z

    .prologue
    .line 93
    iput-boolean p1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnPinterest:Z

    .line 94
    return-void
.end method

.method public setTumblrShareFlag(Z)V
    .locals 0
    .param p1, "shareFlag"    # Z

    .prologue
    .line 85
    iput-boolean p1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnTumblr:Z

    .line 86
    return-void
.end method

.method public setTwitterShareFlag(Z)V
    .locals 0
    .param p1, "shareFlag"    # Z

    .prologue
    .line 81
    iput-boolean p1, p0, Lcom/poshmark/utils/ListingManager;->bShareOnTwitter:Z

    .line 82
    return-void
.end method
