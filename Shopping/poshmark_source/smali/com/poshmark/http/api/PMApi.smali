.class public Lcom/poshmark/http/api/PMApi;
.super Ljava/lang/Object;
.source "PMApi.java"


# static fields
.field public static PMTrackingActionKey:Ljava/lang/String;

.field public static PMTrackingActionShareBrand:Ljava/lang/String;

.field public static PMTrackingActionShareCloset:Ljava/lang/String;

.field public static PMTrackingActionShareListing:Ljava/lang/String;

.field public static PMTrackingActionShareParty:Ljava/lang/String;

.field public static PMTrackingActionShareReferralCode:Ljava/lang/String;

.field public static PMTrackingActionShareShowroom:Ljava/lang/String;

.field public static PMTrackingMediumKey:Ljava/lang/String;

.field public static PMTrackingObjectIdKey:Ljava/lang/String;

.field public static PMTrackingScreenBrandShare:Ljava/lang/String;

.field public static PMTrackingScreenClosetShare:Ljava/lang/String;

.field public static PMTrackingScreenJustInBrandShare:Ljava/lang/String;

.field public static PMTrackingScreenKey:Ljava/lang/String;

.field public static PMTrackingScreenListingShare:Ljava/lang/String;

.field public static PMTrackingScreenPartyShare:Ljava/lang/String;

.field public static PMTrackingScreenReferralCodeShare:Ljava/lang/String;

.field public static PMTrackingScreenShowroomShare:Ljava/lang/String;

.field public static PMTrackingShareMediumEmail:Ljava/lang/String;

.field public static PMTrackingShareMediumFbDialog:Ljava/lang/String;

.field public static PMTrackingShareMediumFbMessenger:Ljava/lang/String;

.field public static PMTrackingShareMediumInstagram:Ljava/lang/String;

.field public static PMTrackingShareMediumPinterest:Ljava/lang/String;

.field public static PMTrackingShareMediumSMS:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 1498
    const-string v0, "act"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionKey:Ljava/lang/String;

    .line 1499
    const-string v0, "mdm"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingMediumKey:Ljava/lang/String;

    .line 1500
    const-string v0, "oid"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingObjectIdKey:Ljava/lang/String;

    .line 1501
    const-string v0, "scr"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenKey:Ljava/lang/String;

    .line 1503
    const-string v0, "sh_l"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareListing:Ljava/lang/String;

    .line 1504
    const-string v0, "sh_p"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareParty:Ljava/lang/String;

    .line 1505
    const-string v0, "sh_c"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareCloset:Ljava/lang/String;

    .line 1506
    const-string v0, "sh_s"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareShowroom:Ljava/lang/String;

    .line 1507
    const-string v0, "sh_b"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareBrand:Ljava/lang/String;

    .line 1508
    const-string v0, "sh_r"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareReferralCode:Ljava/lang/String;

    .line 1510
    const-string v0, "em"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    .line 1511
    const-string v0, "sms"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    .line 1512
    const-string v0, "pin"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    .line 1513
    const-string v0, "ins"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    .line 1514
    const-string v0, "fbm"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    .line 1515
    const-string v0, "fbd"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    .line 1517
    const-string v0, "li_s"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenListingShare:Ljava/lang/String;

    .line 1518
    const-string v0, "pa_s"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenPartyShare:Ljava/lang/String;

    .line 1519
    const-string v0, "cl_s"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenClosetShare:Ljava/lang/String;

    .line 1520
    const-string v0, "sh_s"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenShowroomShare:Ljava/lang/String;

    .line 1521
    const-string v0, "br_s"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenBrandShare:Ljava/lang/String;

    .line 1522
    const-string v0, "brj_s"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenJustInBrandShare:Ljava/lang/String;

    .line 1523
    const-string v0, "rc_s"

    sput-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenReferralCodeShare:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addListingToBundle(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "seller"    # Ljava/lang/String;
    .param p1, "listingId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1262
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/bundles/users/%s/posts/%s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    const/4 v4, 0x2

    aput-object p1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1265
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1266
    return-void
.end method

.method public static addProductToOffer(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "listingId"    # Ljava/lang/String;
    .param p2, "trackingJSON"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/PMOfferInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 960
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/PMOfferInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/posts/%s/offers/new"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/PMOfferInfo;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 963
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/PMOfferInfo;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 965
    if-eqz p2, :cond_0

    .line 966
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "tr_goal"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 969
    :cond_0
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 970
    return-void
.end method

.method public static addProductToOrder(Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p1, "trackingJSON"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/PMOrder;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 947
    .local p0, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/PMOrder;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/orders/%s/line_items"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string v5, "self"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/PMOrder;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 950
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/PMOrder;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 952
    if-eqz p1, :cond_0

    .line 953
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "tr_goal"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 956
    :cond_0
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 957
    return-void
.end method

.method public static becameActive(Lcom/poshmark/http/api/PMApiResponseHandler;Lcom/poshmark/data_model/models/ActiveUserInfo;)V
    .locals 9
    .param p1, "info"    # Lcom/poshmark/data_model/models/ActiveUserInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;",
            "Lcom/poshmark/data_model/models/ActiveUserInfo;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1072
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v5

    iget-object v2, v5, Lcom/poshmark/application/AppInfo;->deviceID:Ljava/lang/String;

    .line 1073
    .local v2, "deviceId":Ljava/lang/String;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_1

    .line 1088
    :cond_0
    :goto_0
    return-void

    .line 1076
    :cond_1
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v5, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v6, "/api/devices/%s/apps/events/became_active"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v2, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    const-class v7, Ljava/lang/Void;

    invoke-direct {v0, v5, v6, v7}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1080
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p1, :cond_2

    .line 1081
    new-instance v1, Lcom/google/gson/GsonBuilder;

    invoke-direct {v1}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 1082
    .local v1, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v1}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v3

    .line 1083
    .local v3, "gson":Lcom/google/gson/Gson;
    const-class v5, Lcom/poshmark/data_model/models/ActiveUserInfo;

    instance-of v6, v3, Lcom/google/gson/Gson;

    if-nez v6, :cond_3

    invoke-virtual {v3, p1, v5}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    .line 1084
    .end local v3    # "gson":Lcom/google/gson/Gson;
    .local v4, "json":Ljava/lang/String;
    :goto_1
    iget-object v5, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v6, "source"

    invoke-interface {v5, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1087
    .end local v1    # "b":Lcom/google/gson/GsonBuilder;
    .end local v4    # "json":Ljava/lang/String;
    :cond_2
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 1083
    .restart local v1    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v3    # "gson":Lcom/google/gson/Gson;
    :cond_3
    check-cast v3, Lcom/google/gson/Gson;

    .end local v3    # "gson":Lcom/google/gson/Gson;
    invoke-static {v3, p1, v5}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    goto :goto_1
.end method

.method public static blockUser(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "userId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 293
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/blocked/users/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 296
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 297
    return-void
.end method

.method public static checkIfPasswordSet(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/user/UserInfoDetails$PasswordStatus;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 615
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/user/UserInfoDetails$PasswordStatus;>;"
    const-string v2, "/api/users/%s/password_set"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 616
    .local v1, "urlPath":Ljava/lang/String;
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-class v3, Lcom/poshmark/user/UserInfoDetails$PasswordStatus;

    invoke-direct {v0, v2, v1, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 617
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/user/UserInfoDetails$PasswordStatus;>;"
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 618
    return-void
.end method

.method public static createNewUser(Ljava/util/Map;Landroid/graphics/Bitmap;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 9
    .param p1, "avataarImage"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Landroid/graphics/Bitmap;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/user/UserInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 76
    .local p0, "signupHash":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/user/UserInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v4, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v5, "/api/auth/users"

    const-class v6, Lcom/poshmark/user/UserInfo;

    invoke-direct {v0, v4, v5, v6}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 79
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/user/UserInfo;>;"
    iget-object v4, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v4, v5}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 82
    iget-object v4, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    invoke-interface {v4, p0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 84
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getGCMRegId()Ljava/lang/String;

    move-result-object v3

    .line 85
    .local v3, "pushToken":Ljava/lang/String;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_0

    .line 86
    iget-object v4, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v5, "push_token"

    invoke-interface {v4, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    :cond_0
    if-eqz p1, :cond_1

    .line 91
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 92
    .local v1, "bos":Ljava/io/ByteArrayOutputStream;
    sget-object v4, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v5, 0x5f

    invoke-virtual {p1, v4, v5, v1}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 93
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v2

    .line 94
    .local v2, "data":[B
    iget-object v4, v0, Lcom/poshmark/http/api/PMApiRequest;->multipartData:Ljava/util/Map;

    const-string v5, "file"

    new-instance v6, Lcom/poshmark/http/PMMultipartItem;

    const-string v7, "image/jpeg"

    const-string v8, "file.jpg"

    invoke-direct {v6, v2, v7, v8}, Lcom/poshmark/http/PMMultipartItem;-><init>([BLjava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    .end local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .end local v2    # "data":[B
    :cond_1
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 98
    return-void
.end method

.method public static deleteComment(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "listingId"    # Ljava/lang/String;
    .param p1, "commentId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1490
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s/comments/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    const/4 v4, 0x1

    aput-object p1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1494
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1495
    return-void
.end method

.method public static deleteListing(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "listingId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 692
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 695
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 696
    return-void
.end method

.method public static fbLink(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "token"    # Ljava/lang/String;
    .param p1, "date"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ExternalServiceInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 424
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ExternalServiceInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_services"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ExternalServiceInfo;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 429
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ExternalServiceInfo;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_access_token"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 430
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_token_expr"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 431
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_service_id"

    const-string v3, "fb"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 433
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 434
    return-void
.end method

.method public static followBrand(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "brandName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1123
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    const-string v1, "/"

    const-string v2, "%2F"

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 1124
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/brands/%s/followers/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p0}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1127
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1128
    return-void
.end method

.method public static followUser(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "followeeId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 269
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/followers/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    const/4 v4, 0x1

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 273
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 274
    return-void
.end method

.method public static getAddressConfirmation(Lcom/poshmark/data_model/models/inner_models/Address;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 7
    .param p0, "address"    # Lcom/poshmark/data_model/models/inner_models/Address;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/data_model/models/inner_models/Address;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/AddressCheckerResults;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1030
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/AddressCheckerResults;>;"
    new-instance v2, Lcom/google/gson/GsonBuilder;

    invoke-direct {v2}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 1031
    .local v2, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v2}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v3

    .line 1032
    .local v3, "gson":Lcom/google/gson/Gson;
    const-class v4, Lcom/poshmark/data_model/models/inner_models/Address;

    instance-of v5, v3, Lcom/google/gson/Gson;

    if-nez v5, :cond_0

    invoke-virtual {v3, p0, v4}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v0

    .line 1034
    .end local v3    # "gson":Lcom/google/gson/Gson;
    .local v0, "addressString":Ljava/lang/String;
    :goto_0
    new-instance v1, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v4, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v5, "/api/addresses"

    const-class v6, Lcom/poshmark/data_model/models/AddressCheckerResults;

    invoke-direct {v1, v4, v5, v6}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1035
    .local v1, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/AddressCheckerResults;>;"
    iget-object v4, v1, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v5, "address"

    invoke-interface {v4, v5, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1037
    invoke-virtual {v1, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1038
    return-void

    .line 1032
    .end local v0    # "addressString":Ljava/lang/String;
    .end local v1    # "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/AddressCheckerResults;>;"
    .restart local v3    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v3, Lcom/google/gson/Gson;

    .end local v3    # "gson":Lcom/google/gson/Gson;
    invoke-static {v3, p0, v4}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getAllBrands(Ljava/util/List;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/db/AllBrandsModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1139
    .local p0, "fields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/db/AllBrandsModel;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v4, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v5, "/api/meta/brands"

    const-class v6, Lcom/poshmark/db/AllBrandsModel;

    invoke-direct {v0, v4, v5, v6}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1141
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/db/AllBrandsModel;>;"
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1}, Ljava/lang/String;-><init>()V

    .line 1142
    .local v1, "fieldsParam":Ljava/lang/String;
    if-eqz p0, :cond_2

    .line 1143
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v3

    .line 1144
    .local v3, "size":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v3, :cond_1

    .line 1145
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1146
    add-int/lit8 v4, v3, -0x1

    if-ge v2, v4, :cond_0

    .line 1147
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1144
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1150
    :cond_1
    iget-object v4, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v5, "fields"

    invoke-interface {v4, v5, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1151
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1153
    .end local v2    # "i":I
    .end local v3    # "size":I
    :cond_2
    return-void
.end method

.method public static getAllFollowingBrands(Ljava/util/List;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/db/AllBrandsModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1161
    .local p0, "fields":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/db/AllBrandsModel;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v4, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v5, "/api/users/%s/brands/following"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const-class v6, Lcom/poshmark/db/AllBrandsModel;

    invoke-direct {v0, v4, v5, v6}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1164
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/db/AllBrandsModel;>;"
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1}, Ljava/lang/String;-><init>()V

    .line 1165
    .local v1, "fieldsParam":Ljava/lang/String;
    if-eqz p0, :cond_2

    .line 1166
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v3

    .line 1167
    .local v3, "size":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v3, :cond_1

    .line 1168
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1169
    add-int/lit8 v4, v3, -0x1

    if-ge v2, v4, :cond_0

    .line 1170
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1167
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1173
    :cond_1
    iget-object v4, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v5, "fields"

    invoke-interface {v4, v5, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1174
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1176
    .end local v2    # "i":I
    .end local v3    # "size":I
    :cond_2
    return-void
.end method

.method public static getBrandMetaData(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "brandName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/Brand;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1092
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/Brand;>;"
    const-string v1, "/"

    const-string v2, "%2F"

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 1093
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/brands/%s/meta"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p0}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/Brand;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1096
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/Brand;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1097
    return-void
.end method

.method public static getBrandShareMessages(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "brandName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/BrandShareMessageContainer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1187
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/BrandShareMessageContainer;>;"
    if-eqz p0, :cond_0

    .line 1188
    const-string v1, "/"

    const-string v2, "%2F"

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 1189
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_shares/brands/%s/share_messages"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {p0}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/BrandShareMessageContainer;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1192
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/BrandShareMessageContainer;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1195
    .end local v0    # "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/BrandShareMessageContainer;>;"
    :cond_0
    return-void
.end method

.method public static getBundleFromCloset(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "seller"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/PMBundle;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1254
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/PMBundle;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/bundles/users/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/PMBundle;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1257
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/PMBundle;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "nm"

    const-string v3, "bnd"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1258
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1259
    return-void
.end method

.method public static getCatalog(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/Catalog;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1156
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/Catalog;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/meta/catalog"

    const-class v3, Lcom/poshmark/data_model/models/Catalog;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1157
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/Catalog;>;"
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1158
    return-void
.end method

.method public static getCreditCardGatewayData(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "orderId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1042
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/orders/%s/gateway-data"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1046
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1047
    return-void
.end method

.method public static getDiscoveredClosets(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .param p1, "nextPageValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 335
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/users/discovered"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 338
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 339
    return-void
.end method

.method public static getEventSocialListings(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "eventId"    # Ljava/lang/String;
    .param p1, "collectionId"    # Ljava/lang/String;
    .param p2, "nextPageValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/Feed_v1;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 919
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/Feed_v1;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/events/%s/posts"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/Feed_v1;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 921
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/Feed_v1;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 922
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "40"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 923
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summary_slice"

    const-string v3, "oldest"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 924
    if-eqz p2, :cond_0

    .line 925
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 926
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 927
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "collection"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 929
    :cond_1
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 930
    return-void
.end method

.method public static getEventSummaryListings(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "eventId"    # Ljava/lang/String;
    .param p1, "collectionId"    # Ljava/lang/String;
    .param p2, "nextPageValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/PartyEventListings;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 905
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/PartyEventListings;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/events/%s/posts"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/PartyEventListings;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 907
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/PartyEventListings;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 908
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "40"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 909
    if-eqz p2, :cond_0

    .line 910
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 911
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 912
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "collection"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 914
    :cond_1
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 915
    return-void
.end method

.method public static getEvents(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/EventList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 895
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/EventList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/events/invited"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/EventList;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 900
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/EventList;>;"
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 901
    return-void
.end method

.method public static getFacebookFriends(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 490
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/connections"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 494
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "ext_service_id"

    const-string v3, "fb"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 495
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "username"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 497
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 498
    return-void
.end method

.method public static getFeatures(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/Features;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1347
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/Features;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/feature_settings"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/Features;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1351
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/Features;>;"
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1353
    return-void
.end method

.method public static getFeed(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "nextPageMaxValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/Feed_v1;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 186
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/Feed_v1;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/feed"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/Feed_v1;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 189
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/Feed_v1;>;"
    if-eqz p0, :cond_0

    .line 191
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 197
    :goto_0
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 198
    return-void

    .line 194
    :cond_0
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "nm"

    const-string v3, "fd"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static getFollowersList(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 359
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/followers"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 362
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "500"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 364
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 365
    return-void
.end method

.method public static getFollowingList(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 325
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/following"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 328
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "500"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 330
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 331
    return-void
.end method

.method public static getHetroFeed(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "nextPageMaxValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 202
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/feed/personalized"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 205
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p0, :cond_0

    .line 207
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 213
    :goto_0
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 214
    return-void

    .line 210
    :cond_0
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "nm"

    const-string v3, "fd"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static getLikersforListing(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "listingId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 848
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s/likes/users"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 850
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "40"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 852
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 853
    return-void
.end method

.method public static getListingDetails(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "listingID"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ListingDetails;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 711
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ListingDetails;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ListingDetails;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 713
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ListingDetails;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 714
    return-void
.end method

.method public static getListingsForBrand(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "brandName"    # Ljava/lang/String;
    .param p1, "searchString"    # Ljava/lang/String;
    .param p2, "nextPageValue"    # Ljava/lang/String;
    .param p3, "searchTrigger"    # Ljava/lang/String;
    .param p4, "keywordSource"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/SearchResults;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1100
    .local p5, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/SearchResults;>;"
    const-string v1, "/"

    const-string v2, "%2F"

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 1101
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/brands/%s/posts"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p0}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/SearchResults;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1106
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/SearchResults;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1107
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "40"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1108
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "request"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1109
    if-eqz p3, :cond_0

    .line 1110
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "nm"

    invoke-interface {v1, v2, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1112
    :cond_0
    if-eqz p4, :cond_1

    .line 1113
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "src"

    invoke-interface {v1, v2, p4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1115
    :cond_1
    if-eqz p2, :cond_2

    .line 1116
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1119
    :cond_2
    invoke-virtual {v0, p5}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1120
    return-void
.end method

.method public static getMyBundles(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "nextPageValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/MyBundles;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1276
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/MyBundles;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/bundles"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/MyBundles;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1279
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/MyBundles;>;"
    if-eqz p0, :cond_0

    .line 1280
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1281
    :cond_0
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "posts_per_bundle"

    const-string v3, "3"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1283
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1284
    return-void
.end method

.method public static getMyLikedListings(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "nextPageMaxValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/MyLikes;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 218
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/MyLikes;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/posts/liked"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/MyLikes;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 221
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/MyLikes;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "40"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 223
    if-eqz p0, :cond_0

    .line 224
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 229
    :goto_0
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 230
    return-void

    .line 226
    :cond_0
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "nm"

    const-string v3, "mlk"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static getMyLikedListingsFiltered(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "nextPageValue"    # Ljava/lang/String;
    .param p1, "filterString"    # Ljava/lang/String;
    .param p2, "searchTrigger"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/MyLikes;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 234
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/MyLikes;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/posts/liked/filtered"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/MyLikes;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 237
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/MyLikes;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 238
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "40"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 239
    if-eqz p1, :cond_0

    .line 240
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "request"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 242
    :cond_0
    if-eqz p0, :cond_1

    .line 243
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 245
    :cond_1
    if-eqz p2, :cond_2

    .line 246
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "nm"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 249
    :cond_2
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 250
    return-void
.end method

.method public static getMyLikesFacets(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "filterString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/MyLikes;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 254
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/MyLikes;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/posts/liked/filtered"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/MyLikes;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 257
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/MyLikes;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 258
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "1"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 259
    if-eqz p0, :cond_0

    .line 260
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "request"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 262
    :cond_0
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 263
    return-void
.end method

.method public static getMySize(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/MySize;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 632
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/MySize;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/sizes"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/MySize;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 635
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/MySize;>;"
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 636
    return-void
.end method

.method public static getNewlyJoinedClosets(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .param p1, "nextPageValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 351
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/users/suggested/newly_joined"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 354
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 355
    return-void
.end method

.method public static getNewlyOpenedClosets(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .param p1, "nextPageValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 343
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/users/suggested/newly_opened"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 346
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 347
    return-void
.end method

.method public static getOffer(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "orderId"    # Ljava/lang/String;
    .param p1, "trackingJSON"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/PMOfferInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1018
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/PMOfferInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/offers/%s/checkout"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/PMOfferInfo;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1022
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/PMOfferInfo;>;"
    if-eqz p1, :cond_0

    .line 1023
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "tr_goal"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1025
    :cond_0
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1026
    return-void
.end method

.method public static getPinterestBoards(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/utils/meta_data/PinterestBoardList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 408
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/utils/meta_data/PinterestBoardList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_services/pinterest/boards"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/utils/meta_data/PinterestBoardList;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 412
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/utils/meta_data/PinterestBoardList;>;"
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 413
    return-void
.end method

.method public static getPinterestSettings(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/utils/meta_data/PinterestSettings;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 416
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/utils/meta_data/PinterestSettings;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/settings/pinterest"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/utils/meta_data/PinterestSettings;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 420
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/utils/meta_data/PinterestSettings;>;"
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 421
    return-void
.end method

.method public static getReferralCode(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/Referral;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 560
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/Referral;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/referral_codes/join"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/Referral;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 563
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/Referral;>;"
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 564
    return-void
.end method

.method public static getSearchResults(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 4
    .param p0, "searchString"    # Ljava/lang/String;
    .param p1, "nextPageValue"    # Ljava/lang/String;
    .param p2, "searchTrigger"    # Ljava/lang/String;
    .param p3, "keywordSource"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/SearchResults;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 872
    .local p4, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/SearchResults;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/SearchResults;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 874
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/SearchResults;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 875
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "40"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 876
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "request"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 877
    if-eqz p2, :cond_0

    .line 878
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "nm"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 880
    :cond_0
    if-eqz p3, :cond_1

    .line 881
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "src"

    invoke-interface {v1, v2, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 883
    :cond_1
    if-eqz p1, :cond_2

    .line 884
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 887
    :cond_2
    invoke-virtual {v0, p4}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 888
    return-void
.end method

.method public static getShareBannerImage(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "paramString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1198
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    if-eqz p0, :cond_0

    .line 1199
    const-string v1, "/"

    const-string v2, "%2F"

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 1200
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_services/banner_content"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1202
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "data"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1203
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1206
    .end local v0    # "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    :cond_0
    return-void
.end method

.method public static getShareMessagesFromServer(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 3
    .param p0, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/utils/sharing/ServerShareMessages;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1209
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/utils/sharing/ServerShareMessages;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-class v2, Lcom/poshmark/utils/sharing/ServerShareMessages;

    invoke-direct {v0, v1, p0, v2}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1210
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/utils/sharing/ServerShareMessages;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1211
    return-void
.end method

.method public static getShowroom(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "showroomId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/Showroom;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1295
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/Showroom;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/collections/%s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/Showroom;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1298
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/Showroom;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1299
    return-void
.end method

.method public static getShowroomListings(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "showroomId"    # Ljava/lang/String;
    .param p1, "nextPageValue"    # Ljava/lang/String;
    .param p2, "filterString"    # Ljava/lang/String;
    .param p3, "searchTrigger"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ShowroomListings;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1302
    .local p4, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ShowroomListings;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/collections/%s/items"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ShowroomListings;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1306
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ShowroomListings;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1307
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "40"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1308
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summary_slice"

    const-string v3, "oldest"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1309
    if-eqz p2, :cond_0

    .line 1310
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "request"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1311
    :cond_0
    if-eqz p1, :cond_1

    .line 1312
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1313
    :cond_1
    if-eqz p3, :cond_2

    .line 1314
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "nm"

    invoke-interface {v1, v2, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1317
    :cond_2
    invoke-virtual {v0, p4}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1318
    return-void
.end method

.method public static getShowrooms(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ShowroomGroupList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1288
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ShowroomGroupList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/collections/posts/feed/summary"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ShowroomGroupList;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1291
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ShowroomGroupList;>;"
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1292
    return-void
.end method

.method public static getSimilarListing(Ljava/lang/String;ILcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "listingID"    # Ljava/lang/String;
    .param p1, "count"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ListingSummaryCollection;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 718
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s/related/posts"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 720
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 721
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 723
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 724
    return-void
.end method

.method public static getSuggestedBrandsForUser(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/db/AllBrandsModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1179
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/db/AllBrandsModel;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/brands/suggested"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/db/AllBrandsModel;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1182
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/db/AllBrandsModel;>;"
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1184
    return-void
.end method

.method public static getSuggestedSearch(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 4
    .param p0, "keyword"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/SuggestedSearchResults;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1335
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/SuggestedSearchResults;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/searches/suggested"

    const-class v3, Lcom/poshmark/data_model/models/SuggestedSearchResults;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1339
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/SuggestedSearchResults;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "for_user_id"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1340
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "query"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1342
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1343
    return-void
.end method

.method public static getSuggestedUsers(Ljava/lang/String;ZILcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .param p1, "isOnRamp"    # Z
    .param p2, "viewCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "ZI",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 377
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    const-string v1, "/api/users/suggested"

    .line 378
    .local v1, "url":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 379
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/new_user"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 381
    :cond_0
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-class v3, Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-direct {v0, v2, v1, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 382
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "for_user_id"

    invoke-interface {v2, v3, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 383
    if-lez p2, :cond_1

    .line 384
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "view_count"

    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 386
    :cond_1
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 387
    return-void
.end method

.method public static getTinyURLForUser(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userID"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/ShortUrl;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 842
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/inner_models/ShortUrl;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/short_url"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/inner_models/ShortUrl;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 844
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/inner_models/ShortUrl;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 845
    return-void
.end method

.method public static getTinyUrlForListing(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "listingID"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/ShortUrl;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 835
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/inner_models/ShortUrl;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s/short_url"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/inner_models/ShortUrl;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 838
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/inner_models/ShortUrl;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 839
    return-void
.end method

.method public static getTwitterConnections(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 478
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/connections"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 482
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "ext_service_id"

    const-string v3, "tw"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 483
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "username"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 485
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 486
    return-void
.end method

.method public static getUserCloset(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .param p1, "nextPageValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ListingSummaryCollection;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 502
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/posts"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 505
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 506
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "40"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 508
    if-eqz p1, :cond_0

    .line 509
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 514
    :goto_0
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 515
    return-void

    .line 511
    :cond_0
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "nm"

    const-string v3, "cl"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static getUserClosetFacets(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .param p1, "filterString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ListingSummaryCollection;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 536
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/posts/filtered"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 539
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 540
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "1"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 541
    if-eqz p1, :cond_0

    .line 542
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "request"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 544
    :cond_0
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 545
    return-void
.end method

.method public static getUserClosetFiltered(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .param p1, "nextPageValue"    # Ljava/lang/String;
    .param p2, "filterString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ListingSummaryCollection;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 519
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/posts/filtered"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 522
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 523
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "40"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 524
    if-eqz p2, :cond_0

    .line 525
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "request"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 527
    :cond_0
    if-eqz p1, :cond_1

    .line 528
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 531
    :cond_1
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 532
    return-void
.end method

.method public static getUserInteractionsList(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserInteractions;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 369
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserInteractions;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/interactions/users"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/UserInteractions;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 373
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserInteractions;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 374
    return-void
.end method

.method public static getUserProfile(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/user/UserInfoDetails;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 609
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/user/UserInfoDetails;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/user/UserInfoDetails;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 611
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/user/UserInfoDetails;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 612
    return-void
.end method

.method public static getUserSettings(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/user/UserInfoDetails$Settings;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 575
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/user/UserInfoDetails$Settings;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/settings"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/user/UserInfoDetails$Settings;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 578
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/user/UserInfoDetails$Settings;>;"
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 579
    return-void
.end method

.method public static getUserSharesList(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userId"    # Ljava/lang/String;
    .param p1, "nextPageValue"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ListingSummaryCollection;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 391
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/shared_posts"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ListingSummaryCollection;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 395
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ListingSummaryCollection;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "summarize"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 396
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "count"

    const-string v3, "40"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 398
    if-eqz p1, :cond_0

    .line 399
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "max_id"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 404
    :goto_0
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 405
    return-void

    .line 401
    :cond_0
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "nm"

    const-string v3, "ush"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static getUserSummary(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserStateSummary;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1236
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserStateSummary;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/state/summary"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/UserStateSummary;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1239
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserStateSummary;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "notifications"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1240
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "event_invites"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1241
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "info"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1242
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "user_info"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1243
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "collections"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1244
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "active_user_tracking"

    const-string v3, "false"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1245
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "feature_settings"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1246
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "brands"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1247
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "catalog"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1249
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1250
    return-void
.end method

.method public static getViewTrackingInfo(Ljava/lang/String;)V
    .locals 6
    .param p0, "screenTag"    # Ljava/lang/String;

    .prologue
    .line 1373
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v3, "/trk/view"

    const-class v4, Ljava/lang/Void;

    const-string v5, "https://tr.poshmark.com"

    invoke-direct {v0, v2, v3, v4, v5}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    .line 1376
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p0, :cond_0

    .line 1377
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "nm"

    invoke-interface {v2, v3, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1380
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v1

    .line 1381
    .local v1, "userId":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 1382
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "user_id"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1385
    :cond_1
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1386
    return-void
.end method

.method public static getViewTrackingInfo(Ljava/util/Map;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1389
    .local p0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v3, "/trk/view"

    const-class v4, Ljava/lang/Void;

    const-string v5, "https://tr.poshmark.com"

    invoke-direct {v0, v2, v3, v4, v5}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    .line 1392
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-interface {v2, p0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1393
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v1

    .line 1394
    .local v1, "userId":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 1395
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "user_id"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1398
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1399
    return-void
.end method

.method public static gpLogin(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "token"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/user/UserInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 142
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/user/UserInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v3, "/api/auth/users/access_token"

    const-class v4, Lcom/poshmark/user/UserInfo;

    invoke-direct {v0, v2, v3, v4}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 144
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/user/UserInfo;>;"
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "ext_access_token"

    invoke-interface {v2, v3, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "ext_service_id"

    const-string v4, "gp"

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v3

    iget-object v3, v3, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v2, v3}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 147
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getGCMRegId()Ljava/lang/String;

    move-result-object v1

    .line 148
    .local v1, "pushToken":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 149
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "push_token"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 153
    :cond_0
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 154
    return-void
.end method

.method public static inviteFriends(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "referralCode"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "externalService"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 648
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    const-string v2, "/api/users/%s/external_shares/invites/join"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 649
    .local v1, "urlPathString":Ljava/lang/String;
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v2, v1, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 651
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 652
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "ext_service_id"

    invoke-interface {v2, v3, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 653
    :cond_0
    if-eqz p0, :cond_1

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 654
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "referral_code"

    invoke-interface {v2, v3, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 655
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_2

    .line 656
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "message"

    invoke-interface {v2, v3, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 658
    :cond_2
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 659
    return-void
.end method

.method public static like(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "listingID"    # Ljava/lang/String;
    .param p1, "trackingJSON"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 738
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s/likes"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 740
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p1, :cond_0

    .line 741
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "tr_goal"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 744
    :cond_0
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 745
    return-void
.end method

.method public static logout(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 177
    .local p0, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/auth/access_token/%s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getAccessToken()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 180
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v1, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 181
    invoke-virtual {v0, p0}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 182
    return-void
.end method

.method public static pinterestLink(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "token"    # Ljava/lang/String;
    .param p1, "permissions"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ExternalServiceInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 465
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ExternalServiceInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_services"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ExternalServiceInfo;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 469
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ExternalServiceInfo;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_access_token"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 470
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_permissions"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 471
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_service_id"

    const-string v3, "pn"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 473
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 474
    return-void
.end method

.method public static pmLogin(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "userHandle"    # Ljava/lang/String;
    .param p1, "password"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/user/UserInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 158
    .local p2, "hash":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/user/UserInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v3, "/api/auth/users/access_token"

    const-class v4, Lcom/poshmark/user/UserInfo;

    invoke-direct {v0, v2, v3, v4}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 160
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/user/UserInfo;>;"
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "user_handle"

    invoke-interface {v2, v3, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 161
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "password"

    invoke-interface {v2, v3, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 164
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 167
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getGCMRegId()Ljava/lang/String;

    move-result-object v1

    .line 168
    .local v1, "pushToken":Ljava/lang/String;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 169
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "push_token"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 171
    :cond_1
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v3

    iget-object v3, v3, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v2, v3}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 173
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 174
    return-void
.end method

.method public static postComment(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "listingId"    # Ljava/lang/String;
    .param p1, "comment"    # Ljava/lang/String;
    .param p2, "trackingJSON"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Comment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 857
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/inner_models/Comment;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s/comments"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/inner_models/Comment;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 860
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/inner_models/Comment;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "comment"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 862
    if-eqz p2, :cond_0

    .line 863
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "tr_goal"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 866
    :cond_0
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 867
    return-void
.end method

.method public static postFacebookTimelineFlag(ZLcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 7
    .param p0, "flag"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 599
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v3, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v4, "/api/users/%s/settings"

    new-array v5, v1, [Ljava/lang/Object;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v2

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    const-class v5, Ljava/lang/Void;

    invoke-direct {v0, v3, v4, v5}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 602
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p0, :cond_0

    .line 603
    .local v1, "flagVal":I
    :goto_0
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "timeline"

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 605
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 606
    return-void

    .end local v1    # "flagVal":I
    :cond_0
    move v1, v2

    .line 602
    goto :goto_0
.end method

.method public static postGoalTrackingInfo(Ljava/lang/String;)V
    .locals 6
    .param p0, "trackingJson"    # Ljava/lang/String;

    .prologue
    .line 1357
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v3, "/trk/goal"

    const-class v4, Ljava/lang/Void;

    const-string v5, "https://tr.poshmark.com"

    invoke-direct {v0, v2, v3, v4, v5}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    .line 1360
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p0, :cond_0

    .line 1361
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "tr_goal"

    invoke-interface {v2, v3, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1364
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v1

    .line 1365
    .local v1, "userId":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 1366
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "user_id"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1369
    :cond_1
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1370
    return-void
.end method

.method public static postImageToListing(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "fileName"    # Ljava/lang/String;
    .param p1, "listingId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 767
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s/media"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    const-string v4, "https://up.poshmark.com"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    .line 768
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v1, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 770
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->multipartData:Ljava/util/Map;

    const-string v2, "file"

    invoke-static {p0}, Lcom/poshmark/http/PMMultipartItem;->getMultipartJPGItem(Ljava/lang/String;)Lcom/poshmark/http/PMMultipartItem;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 772
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 773
    return-void
.end method

.method public static postNewListing(Ljava/lang/String;Lcom/poshmark/data_model/models/NewListing;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "fileName"    # Ljava/lang/String;
    .param p1, "info"    # Lcom/poshmark/data_model/models/NewListing;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/data_model/models/NewListing;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/ID;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 756
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/ID;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/self/posts"

    const-class v3, Lcom/poshmark/data_model/ID;

    const-string v4, "https://up.poshmark.com"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    .line 757
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/ID;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v1, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 759
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->multipartData:Ljava/util/Map;

    const-string v2, "file"

    invoke-static {p0}, Lcom/poshmark/http/PMMultipartItem;->getMultipartJPGItem(Ljava/lang/String;)Lcom/poshmark/http/PMMultipartItem;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 760
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/NewListing;->getListingInfoHash()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 762
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 763
    return-void
.end method

.method public static postNewPassword(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "newPassword"    # Ljava/lang/String;
    .param p1, "oldPassword"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/user/UserInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 621
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/user/UserInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/password"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/user/UserInfo;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 624
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/user/UserInfo;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "new_password"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 625
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "old_password"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 627
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 629
    return-void
.end method

.method public static postOffer(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "orderId"    # Ljava/lang/String;
    .param p2, "trackingJSON"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/PMOffer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1005
    .local p1, "orderInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/PMOffer;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/offers/%s/checkout"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/PMOffer;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1009
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/PMOffer;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1010
    if-eqz p2, :cond_0

    .line 1011
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "tr_goal"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1013
    :cond_0
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1014
    return-void
.end method

.method public static postOfferAddresses(Ljava/lang/String;Ljava/util/Map;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "orderId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/PMOfferInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1061
    .local p1, "addressInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/PMOfferInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/offers/%s/addresses"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/PMOfferInfo;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1065
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/PMOfferInfo;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1066
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1067
    return-void
.end method

.method public static postOrder(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "orderId"    # Ljava/lang/String;
    .param p2, "trackingJSON"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/PMOrder;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 992
    .local p1, "orderInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/PMOrder;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/orders/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/PMOrder;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 996
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/PMOrder;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 997
    if-eqz p2, :cond_0

    .line 998
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "tr_goal"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1000
    :cond_0
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1001
    return-void
.end method

.method public static postOrderAddresses(Ljava/lang/String;Ljava/util/Map;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "orderId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/PMOrder;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1051
    .local p1, "addressInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/PMOrder;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/orders/%s/addresses"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/PMOrder;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1055
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/PMOrder;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1056
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1057
    return-void
.end method

.method public static postPinterestBoardsUpdate(Ljava/util/Map;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 592
    .local p0, "board":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/settings"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 594
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->nestedFormData:Lcom/poshmark/utils/view_holders/MultiMap;

    const-string v2, "pins"

    invoke-virtual {v1, v2, p0}, Lcom/poshmark/utils/view_holders/MultiMap;->putNestedFormParams(Ljava/lang/String;Ljava/lang/Object;)V

    .line 595
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 596
    return-void
.end method

.method public static postSearchVisibilityFlag(ZLcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 7
    .param p0, "flag"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 582
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v3, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v4, "/api/users/%s/settings"

    new-array v5, v1, [Ljava/lang/Object;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v2

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    const-class v5, Ljava/lang/Void;

    invoke-direct {v0, v3, v4, v5}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 585
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p0, :cond_0

    .line 586
    .local v1, "flagVal":I
    :goto_0
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "search_visibility"

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 588
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 589
    return-void

    .end local v1    # "flagVal":I
    :cond_0
    move v1, v2

    .line 585
    goto :goto_0
.end method

.method public static postUpdateListing(Ljava/lang/String;Lcom/poshmark/data_model/models/NewListing;Ljava/util/Map;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 7
    .param p0, "listingId"    # Ljava/lang/String;
    .param p1, "listingInfo"    # Lcom/poshmark/data_model/models/NewListing;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/data_model/models/NewListing;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 789
    .local p2, "imageFiles":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v3, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v4, "/api/posts/%s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p0, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    const-class v5, Ljava/lang/Void;

    const-string v6, "https://up.poshmark.com"

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    .line 790
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v3, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v3, v4}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 792
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 793
    .local v2, "stringStringEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v4, v0, Lcom/poshmark/http/api/PMApiRequest;->multipartData:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/http/PMMultipartItem;->getMultipartJPGItem(Ljava/lang/String;)Lcom/poshmark/http/PMMultipartItem;

    move-result-object v3

    invoke-interface {v4, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 796
    .end local v2    # "stringStringEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    iget-object v3, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/NewListing;->getListingInfoHash()Ljava/util/Map;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 798
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 799
    return-void
.end method

.method public static publishListing(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "listingID"    # Ljava/lang/String;
    .param p1, "externalServices"    # Ljava/lang/String;
    .param p2, "eventsIds"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 777
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s/status/published"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 778
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v1, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 779
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 780
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "ext_service_ids"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 781
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 782
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "event_ids"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 784
    :cond_1
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 785
    return-void
.end method

.method public static putGCMPushToken(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "googlePushToken"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 548
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v2

    iget-object v1, v2, Lcom/poshmark/application/AppInfo;->deviceID:Ljava/lang/String;

    .line 549
    .local v1, "deviceId":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_1

    .line 556
    :cond_0
    :goto_0
    return-void

    .line 551
    :cond_1
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v3, "/api/devices/%s/push_token/%s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    const/4 v5, 0x1

    aput-object p0, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const-class v4, Ljava/lang/Void;

    invoke-direct {v0, v2, v3, v4}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 554
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v3

    iget-object v3, v3, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v2, v3}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 555
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method public static releaseBundle(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "orderId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/Referral;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 983
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/Referral;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/orders/%s/line_items/all"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/Referral;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 987
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/Referral;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 988
    return-void
.end method

.method public static releaseOrder(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "listingId"    # Ljava/lang/String;
    .param p1, "orderId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/Referral;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 974
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/Referral;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/orders/%s/line_items/%s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p1, v3, v4

    const/4 v4, 0x2

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/Referral;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 978
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/Referral;>;"
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 979
    return-void
.end method

.method public static removeListingFromBundle(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "seller"    # Ljava/lang/String;
    .param p1, "listingId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1269
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/bundles/users/%s/posts/%s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    const/4 v4, 0x2

    aput-object p1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1272
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1273
    return-void
.end method

.method public static reportListing(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "listingId"    # Ljava/lang/String;
    .param p1, "reason"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 700
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/reported/posts/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 704
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "reason"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 706
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 707
    return-void
.end method

.method public static reportUser(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "userId"    # Ljava/lang/String;
    .param p1, "reason"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 285
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/reported/users/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 288
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "reason"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 289
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 290
    return-void
.end method

.method public static saveExternalServiceInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "extServiceCode"    # Ljava/lang/String;
    .param p1, "token"    # Ljava/lang/String;
    .param p2, "date"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/user/UserInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 122
    .local p3, "hash":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p4, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/user/UserInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v3, "/api/auth/users/access_token"

    const-class v4, Lcom/poshmark/user/UserInfo;

    invoke-direct {v0, v2, v3, v4}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 124
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/user/UserInfo;>;"
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "ext_access_token"

    invoke-interface {v2, v3, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 125
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "ext_token_expr"

    invoke-interface {v2, v3, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 126
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "ext_service_id"

    invoke-interface {v2, v3, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v3

    iget-object v3, v3, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v2, v3}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 129
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 130
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-interface {v2, p3}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 133
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getGCMRegId()Ljava/lang/String;

    move-result-object v1

    .line 134
    .local v1, "pushToken":Ljava/lang/String;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 135
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "push_token"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 137
    :cond_1
    invoke-virtual {v0, p4}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 138
    return-void
.end method

.method public static searchUsers(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 8
    .param p0, "searchString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 662
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v5, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v6, "/api/users"

    const-class v7, Lcom/poshmark/data_model/models/UserReferenceList;

    invoke-direct {v0, v5, v6, v7}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 664
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 665
    .local v4, "searchMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v5, "name"

    invoke-interface {v4, v5, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 667
    new-instance v1, Lcom/google/gson/GsonBuilder;

    invoke-direct {v1}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 668
    .local v1, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v1}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v2

    .line 669
    .local v2, "gson":Lcom/google/gson/Gson;
    const-class v5, Ljava/util/HashMap;

    instance-of v6, v2, Lcom/google/gson/Gson;

    if-nez v6, :cond_0

    invoke-virtual {v2, v4, v5}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    .line 671
    .end local v2    # "gson":Lcom/google/gson/Gson;
    .local v3, "jsonString":Ljava/lang/String;
    :goto_0
    iget-object v5, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v6, "request"

    invoke-interface {v5, v6, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 672
    iget-object v5, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v6, "nm"

    const-string v7, "sp"

    invoke-interface {v5, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 674
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 675
    return-void

    .line 669
    .end local v3    # "jsonString":Ljava/lang/String;
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, v4, v5}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public static setMySize(Ljava/util/Map;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 639
    .local p0, "changes":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/sizes"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 642
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 644
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 645
    return-void
.end method

.method public static setUserProfile(Ljava/util/Map;Landroid/graphics/Bitmap;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 8
    .param p1, "avataarImage"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Landroid/graphics/Bitmap;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 308
    .local p0, "profileHash":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v3, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v4, "/api/users/%s/profile"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    const-class v5, Ljava/lang/Void;

    invoke-direct {v0, v3, v4, v5}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 311
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v3, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    invoke-interface {v3, p0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 313
    if-eqz p1, :cond_0

    .line 314
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 315
    .local v1, "bos":Ljava/io/ByteArrayOutputStream;
    sget-object v3, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v4, 0x5f

    invoke-virtual {p1, v3, v4, v1}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 316
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v2

    .line 317
    .local v2, "data":[B
    iget-object v3, v0, Lcom/poshmark/http/api/PMApiRequest;->multipartData:Ljava/util/Map;

    const-string v4, "cover_shot"

    new-instance v5, Lcom/poshmark/http/PMMultipartItem;

    const-string v6, "image/jpeg"

    const-string v7, "file.jpg"

    invoke-direct {v5, v2, v6, v7}, Lcom/poshmark/http/PMMultipartItem;-><init>([BLjava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 320
    .end local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .end local v2    # "data":[B
    :cond_0
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 321
    return-void
.end method

.method public static shareBrandToExternalService(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "brandName"    # Ljava/lang/String;
    .param p1, "externalService"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1214
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    if-eqz p0, :cond_2

    .line 1215
    const-string v1, "/"

    const-string v2, "%2F"

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 1216
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_shares/brands/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {p0}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1220
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 1221
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "ext_service_id"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1223
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 1224
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "message"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1226
    :cond_1
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1228
    .end local v0    # "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    :cond_2
    return-void
.end method

.method public static shareCloset(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "userId"    # Ljava/lang/String;
    .param p1, "externalService"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 678
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_shares/users/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 681
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 682
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "ext_service_id"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 683
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 684
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "message"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 686
    :cond_1
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 687
    return-void
.end method

.method public static shareEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "eventId"    # Ljava/lang/String;
    .param p1, "externalService"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 933
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_shares/events/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 936
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 937
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "ext_service_id"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 938
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 939
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "message"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 941
    :cond_1
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 942
    return-void
.end method

.method public static shareListing(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "listingId"    # Ljava/lang/String;
    .param p1, "externalServices"    # Ljava/lang/String;
    .param p2, "eventsIds"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 802
    .local p4, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/shared_posts/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 806
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 807
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "ext_service_ids"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 809
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 810
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "event_ids"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 812
    :cond_1
    if-eqz p3, :cond_2

    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_2

    .line 813
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "message"

    invoke-interface {v1, v2, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 815
    :cond_2
    invoke-virtual {v0, p4}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 816
    return-void
.end method

.method public static shareListingToExternalService(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "listingId"    # Ljava/lang/String;
    .param p1, "externalService"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 820
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_shares/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 824
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 825
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "ext_service_id"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 827
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 828
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "message"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 830
    :cond_1
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 831
    return-void
.end method

.method public static shareShowroom(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "showroomId"    # Ljava/lang/String;
    .param p1, "externalService"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1321
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_shares/collections/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1324
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 1325
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "ext_service_id"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1326
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 1327
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "message"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1329
    :cond_1
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1330
    return-void
.end method

.method public static tmblrLink(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "token"    # Ljava/lang/String;
    .param p1, "secret"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ExternalServiceInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 452
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ExternalServiceInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_services"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ExternalServiceInfo;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 456
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ExternalServiceInfo;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_access_token"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 457
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_token_secret"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 458
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_service_id"

    const-string v3, "tm"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 460
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 461
    return-void
.end method

.method public static trackDeepLink(Ljava/util/HashMap;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1422
    .local p0, "trackingInfo":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v4, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v5, "/tr"

    const-class v6, Ljava/lang/Void;

    const-string v7, "https://tr.poshmark.com"

    invoke-direct {v0, v4, v5, v6, v7}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    .line 1425
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p0, :cond_0

    .line 1426
    const/4 v3, 0x0

    .line 1427
    .local v3, "json":Ljava/lang/String;
    new-instance v1, Lcom/google/gson/GsonBuilder;

    invoke-direct {v1}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 1428
    .local v1, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v1}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v2

    .line 1429
    .local v2, "gson":Lcom/google/gson/Gson;
    const-class v4, Ljava/util/HashMap;

    instance-of v5, v2, Lcom/google/gson/Gson;

    if-nez v5, :cond_1

    invoke-virtual {v2, p0, v4}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    .line 1430
    .end local v2    # "gson":Lcom/google/gson/Gson;
    :goto_0
    if-eqz v3, :cond_0

    .line 1431
    iget-object v4, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v5, "d"

    invoke-interface {v4, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1434
    .end local v1    # "b":Lcom/google/gson/GsonBuilder;
    .end local v3    # "json":Ljava/lang/String;
    :cond_0
    iget-object v4, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v4, v5}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1435
    iget-object v4, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v5, "os"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Android: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    sget-object v7, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1437
    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1438
    return-void

    .line 1429
    .restart local v1    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    .restart local v3    # "json":Ljava/lang/String;
    :cond_1
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, p0, v4}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public static trackExternalShare(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p0, "shareJson"    # Ljava/lang/String;
    .param p1, "shareState"    # Ljava/lang/String;

    .prologue
    .line 1468
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v3, "/trk/evt/ext_share_init"

    const-class v4, Ljava/lang/Void;

    const-string v5, "https://tr.poshmark.com"

    invoke-direct {v0, v2, v3, v4, v5}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    .line 1471
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v3

    iget-object v3, v3, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v2, v3}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1472
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "os"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Android: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1473
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "d"

    invoke-interface {v2, v3, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1474
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "d"

    invoke-interface {v2, v3, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1477
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "s"

    invoke-interface {v2, v3, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1479
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v1

    .line 1480
    .local v1, "userId":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 1481
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "user_id"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1484
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1485
    return-void
.end method

.method public static trackPushNotificationClick(Lcom/poshmark/data_model/models/ActiveUserInfo;)V
    .locals 9
    .param p0, "info"    # Lcom/poshmark/data_model/models/ActiveUserInfo;

    .prologue
    .line 1441
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v5, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v6, "/trk/ntf/clk"

    const-class v7, Ljava/lang/Void;

    const-string v8, "https://tr.poshmark.com"

    invoke-direct {v0, v5, v6, v7, v8}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    .line 1444
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    .line 1445
    .local v4, "userId":Ljava/lang/String;
    if-eqz v4, :cond_0

    .line 1446
    iget-object v5, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v6, "user_id"

    invoke-interface {v5, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1449
    :cond_0
    if-eqz p0, :cond_2

    .line 1450
    const/4 v3, 0x0

    .line 1451
    .local v3, "json":Ljava/lang/String;
    new-instance v1, Lcom/google/gson/GsonBuilder;

    invoke-direct {v1}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 1452
    .local v1, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v1}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v2

    .line 1453
    .local v2, "gson":Lcom/google/gson/Gson;
    iget-object v5, p0, Lcom/poshmark/data_model/models/ActiveUserInfo;->type:Ljava/lang/String;

    const-string v6, "push_ntf"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 1454
    iget-object v5, p0, Lcom/poshmark/data_model/models/ActiveUserInfo;->push_ntf:Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;

    const-class v6, Lcom/poshmark/data_model/models/ActiveUserInfo$PushNotificationInfo;

    instance-of v7, v2, Lcom/google/gson/Gson;

    if-nez v7, :cond_3

    invoke-virtual {v2, v5, v6}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    .line 1459
    .end local v2    # "gson":Lcom/google/gson/Gson;
    :cond_1
    :goto_0
    if-eqz v3, :cond_2

    .line 1460
    iget-object v5, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v6, "d"

    invoke-interface {v5, v6, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1464
    .end local v1    # "b":Lcom/google/gson/GsonBuilder;
    .end local v3    # "json":Ljava/lang/String;
    :cond_2
    const/4 v5, 0x0

    invoke-virtual {v0, v5}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1465
    return-void

    .line 1454
    .restart local v1    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    .restart local v3    # "json":Ljava/lang/String;
    :cond_3
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, v5, v6}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 1455
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    :cond_4
    iget-object v5, p0, Lcom/poshmark/data_model/models/ActiveUserInfo;->type:Ljava/lang/String;

    const-string v6, "local_ntf"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 1456
    iget-object v5, p0, Lcom/poshmark/data_model/models/ActiveUserInfo;->local_ntf:Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;

    const-class v6, Lcom/poshmark/data_model/models/ActiveUserInfo$LocalNotificationInfo;

    instance-of v7, v2, Lcom/google/gson/Gson;

    if-nez v7, :cond_5

    invoke-virtual {v2, v5, v6}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    .end local v2    # "gson":Lcom/google/gson/Gson;
    :goto_1
    goto :goto_0

    .restart local v2    # "gson":Lcom/google/gson/Gson;
    :cond_5
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, v5, v6}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    goto :goto_1
.end method

.method public static trackPushNotificationDelivery(Landroid/os/Bundle;)V
    .locals 7
    .param p0, "msgBundle"    # Landroid/os/Bundle;

    .prologue
    .line 1402
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v3, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v4, "/tr"

    const-class v5, Ljava/lang/Void;

    const-string v6, "https://tr.poshmark.com"

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V

    .line 1405
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v3, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v3, v4}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1406
    iget-object v3, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v4, "os"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Android: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1408
    const-string v3, "message"

    invoke-virtual {p0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1409
    .local v1, "message":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 1410
    iget-object v3, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v4, "message"

    invoke-interface {v3, v4, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1413
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v2

    .line 1414
    .local v2, "userId":Ljava/lang/String;
    if-eqz v2, :cond_1

    .line 1415
    iget-object v3, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v4, "user_id"

    invoke-interface {v3, v4, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1418
    :cond_1
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1419
    return-void
.end method

.method public static twitterLink(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "token"    # Ljava/lang/String;
    .param p1, "secret"    # Ljava/lang/String;
    .param p2, "userId"    # Ljava/lang/String;
    .param p3, "userName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/data_model/models/ExternalServiceInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 438
    .local p4, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/data_model/models/ExternalServiceInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_services"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/poshmark/data_model/models/ExternalServiceInfo;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 442
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/data_model/models/ExternalServiceInfo;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_access_token"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 443
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_token_secret"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 444
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_service_id"

    const-string v3, "tw"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 445
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v2, "ext_user_id"

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 447
    invoke-virtual {v0, p4}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 448
    return-void
.end method

.method public static unFollowBrand(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "brandName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1131
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    const-string v1, "/"

    const-string v2, "%2F"

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 1132
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/brands/%s/followers/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p0}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 1135
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1136
    return-void
.end method

.method public static unFollowUser(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "followeeId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 277
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/followers/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    const/4 v4, 0x1

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 281
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 282
    return-void
.end method

.method public static unLike(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "listingID"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 749
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s/likes"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 751
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 752
    return-void
.end method

.method public static unblockUser(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "userId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 300
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/blocked/users/%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 303
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 304
    return-void
.end method

.method public static unlinkExternalService(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 6
    .param p0, "service"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 567
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_DELETE:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/users/%s/external_services"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 570
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "ext_service_id"

    invoke-interface {v1, v2, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 571
    invoke-virtual {v0, p1}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 572
    return-void
.end method

.method public static updateFbToken(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "token"    # Ljava/lang/String;
    .param p1, "date"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Lcom/poshmark/user/UserInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 102
    .local p2, "hash":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Lcom/poshmark/user/UserInfo;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v2, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v3, "/api/auth/users/access_token"

    const-class v4, Lcom/poshmark/user/UserInfo;

    invoke-direct {v0, v2, v3, v4}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 104
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Lcom/poshmark/user/UserInfo;>;"
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "ext_access_token"

    invoke-interface {v2, v3, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "ext_token_expr"

    invoke-interface {v2, v3, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 106
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->formData:Ljava/util/Map;

    const-string v3, "ext_service_id"

    const-string v4, "fb"

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 107
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v3

    iget-object v3, v3, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    invoke-interface {v2, v3}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 109
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 110
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 113
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getGCMRegId()Ljava/lang/String;

    move-result-object v1

    .line 114
    .local v1, "pushToken":Ljava/lang/String;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 115
    iget-object v2, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v3, "push_token"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 117
    :cond_1
    invoke-virtual {v0, p3}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 118
    return-void
.end method

.method public static updateListingStatus(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 5
    .param p0, "listingID"    # Ljava/lang/String;
    .param p1, "listingStatus"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 728
    .local p2, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<Ljava/lang/Void;>;"
    new-instance v0, Lcom/poshmark/http/api/PMApiRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_PUT:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "/api/posts/%s/inventory/status"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    const/4 v4, 0x1

    aput-object p1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Ljava/lang/Void;

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/http/api/PMApiRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V

    .line 729
    .local v0, "apiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<Ljava/lang/Void;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 730
    iget-object v1, v0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v2, "status"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 732
    :cond_0
    invoke-virtual {v0, p2}, Lcom/poshmark/http/api/PMApiRequest;->callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 733
    return-void
.end method
