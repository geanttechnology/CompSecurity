.class public final Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;
.super Ljava/lang/Object;
.source "PandaTokenExchangeResponse.java"


# static fields
.field public static final TAG:Ljava/lang/String;


# instance fields
.field private mAccessToken:Ljava/lang/String;

.field private mDomain:Ljava/lang/String;

.field private mDomainToCookies:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lorg/json/JSONArray;",
            ">;"
        }
    .end annotation
.end field

.field private mExpiry:I

.field private mRefreshToken:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 58
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 74
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mDomainToCookies:Ljava/util/Map;

    .line 75
    return-void
.end method

.method public static parse(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;
    .locals 20
    .param p0, "json"    # Ljava/lang/String;

    .prologue
    .line 113
    :try_start_0
    new-instance v15, Lorg/json/JSONObject;

    move-object/from16 v0, p0

    invoke-direct {v15, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 121
    .local v15, "response":Lorg/json/JSONObject;
    new-instance v13, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;

    invoke-direct {v13}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;-><init>()V

    .line 122
    .local v13, "parsedResponse":Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;
    new-instance v12, Ljava/util/LinkedList;

    invoke-direct {v12}, Ljava/util/LinkedList;-><init>()V

    .line 124
    .local v12, "missingValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string/jumbo v17, "bearer"

    move-object/from16 v0, v17

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 125
    .local v3, "bearer":Lorg/json/JSONObject;
    if-nez v3, :cond_3

    .line 127
    const-string/jumbo v17, "bearer"

    move-object/from16 v0, v17

    invoke-interface {v12, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 162
    :goto_0
    const-string/jumbo v17, "website_cookies"

    move-object/from16 v0, v17

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v16

    .line 163
    .local v16, "websiteCookies":Lorg/json/JSONArray;
    if-eqz v16, :cond_0

    invoke-virtual/range {v16 .. v16}, Lorg/json/JSONArray;->length()I

    move-result v17

    if-gtz v17, :cond_7

    .line 165
    :cond_0
    const-string/jumbo v17, "website_cookies"

    move-object/from16 v0, v17

    invoke-interface {v12, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 206
    :cond_1
    invoke-interface {v12}, Ljava/util/List;->isEmpty()Z

    move-result v17

    if-nez v17, :cond_2

    .line 208
    sget-object v17, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->TAG:Ljava/lang/String;

    new-instance v18, Ljava/lang/StringBuilder;

    const-string/jumbo v19, "Missing values from Panda: "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string/jumbo v19, ","

    move-object/from16 v0, v19

    invoke-static {v0, v12}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 209
    invoke-interface {v12}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_2

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 211
    .local v11, "missingValue":Ljava/lang/String;
    new-instance v17, Ljava/lang/StringBuilder;

    const-string/jumbo v18, "ExchangeTokenResponseMissing:"

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    const/16 v18, 0x0

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_1

    .line 115
    .end local v3    # "bearer":Lorg/json/JSONObject;
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v11    # "missingValue":Ljava/lang/String;
    .end local v12    # "missingValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v13    # "parsedResponse":Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;
    .end local v15    # "response":Lorg/json/JSONObject;
    .end local v16    # "websiteCookies":Lorg/json/JSONArray;
    :catch_0
    move-exception v7

    .line 117
    .local v7, "e":Lorg/json/JSONException;
    sget-object v17, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->TAG:Ljava/lang/String;

    new-instance v18, Ljava/lang/StringBuilder;

    const-string/jumbo v19, "Invalid JSON from Panda: "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    const/4 v13, 0x0

    .line 214
    .end local v7    # "e":Lorg/json/JSONException;
    :cond_2
    return-object v13

    .line 131
    .restart local v3    # "bearer":Lorg/json/JSONObject;
    .restart local v12    # "missingValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v13    # "parsedResponse":Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;
    .restart local v15    # "response":Lorg/json/JSONObject;
    :cond_3
    const-string/jumbo v17, "expires_in"

    const/16 v18, -0x1

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v8

    .line 132
    .local v8, "expiry":I
    if-gez v8, :cond_4

    .line 134
    const-string/jumbo v17, "bearer.expires_in"

    move-object/from16 v0, v17

    invoke-interface {v12, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 141
    :goto_2
    const-string/jumbo v17, "access_token"

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 142
    .local v2, "accessToken":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-eqz v17, :cond_5

    .line 144
    const-string/jumbo v17, "bearer.access_token"

    move-object/from16 v0, v17

    invoke-interface {v12, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 151
    :goto_3
    const-string/jumbo v17, "refresh_token"

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 152
    .local v14, "refreshToken":Ljava/lang/String;
    invoke-static {v14}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-eqz v17, :cond_6

    .line 154
    const-string/jumbo v17, "bearer.refresh_token"

    move-object/from16 v0, v17

    invoke-interface {v12, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 138
    .end local v2    # "accessToken":Ljava/lang/String;
    .end local v14    # "refreshToken":Ljava/lang/String;
    :cond_4
    iput v8, v13, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mExpiry:I

    goto :goto_2

    .line 148
    .restart local v2    # "accessToken":Ljava/lang/String;
    :cond_5
    iput-object v2, v13, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mAccessToken:Ljava/lang/String;

    goto :goto_3

    .line 158
    .restart local v14    # "refreshToken":Ljava/lang/String;
    :cond_6
    iput-object v14, v13, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mRefreshToken:Ljava/lang/String;

    goto/16 :goto_0

    .line 169
    .end local v2    # "accessToken":Ljava/lang/String;
    .end local v8    # "expiry":I
    .end local v14    # "refreshToken":Ljava/lang/String;
    .restart local v16    # "websiteCookies":Lorg/json/JSONArray;
    :cond_7
    invoke-virtual/range {v16 .. v16}, Lorg/json/JSONArray;->length()I

    move-result v17

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-le v0, v1, :cond_8

    .line 171
    sget-object v17, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->TAG:Ljava/lang/String;

    const-string/jumbo v18, "Panda returned more than one domain\'s cookies. Using first in list."

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    :cond_8
    const/4 v10, 0x0

    .local v10, "index":I
    :goto_4
    if-gtz v10, :cond_1

    .line 176
    move-object/from16 v0, v16

    invoke-virtual {v0, v10}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 177
    .local v5, "cookiesObject":Lorg/json/JSONObject;
    if-nez v5, :cond_9

    .line 179
    new-instance v17, Ljava/lang/StringBuilder;

    const-string/jumbo v18, "website_cookies.cookiesObject"

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-interface {v12, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 174
    :goto_5
    add-int/lit8 v10, v10, 0x1

    goto :goto_4

    .line 183
    :cond_9
    const-string/jumbo v17, "domain"

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 184
    .local v6, "domain":Ljava/lang/String;
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-eqz v17, :cond_a

    .line 186
    new-instance v17, Ljava/lang/StringBuilder;

    const-string/jumbo v18, "website_cookies.cookiesObject"

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string/jumbo v18, ".domain"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-interface {v12, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_5

    .line 190
    :cond_a
    iput-object v6, v13, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mDomain:Ljava/lang/String;

    .line 191
    const-string/jumbo v17, "cookies"

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 193
    .local v4, "cookiesArray":Lorg/json/JSONArray;
    if-eqz v4, :cond_b

    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v17

    if-gtz v17, :cond_c

    .line 195
    :cond_b
    new-instance v17, Ljava/lang/StringBuilder;

    const-string/jumbo v18, "website_cookies.cookiesObject"

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string/jumbo v18, ".cookiesArray"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-interface {v12, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_5

    .line 199
    :cond_c
    iget-object v0, v13, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mDomainToCookies:Ljava/util/Map;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v0, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_5
.end method


# virtual methods
.method public getAccessToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mAccessToken:Ljava/lang/String;

    return-object v0
.end method

.method public getCookies()Lorg/json/JSONArray;
    .locals 3

    .prologue
    .line 94
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mDomain:Ljava/lang/String;

    if-nez v1, :cond_1

    .line 96
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    .line 105
    :cond_0
    :goto_0
    return-object v0

    .line 99
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mDomainToCookies:Ljava/util/Map;

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mDomain:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONArray;

    .line 100
    .local v0, "cookies":Lorg/json/JSONArray;
    if-nez v0, :cond_0

    .line 102
    new-instance v0, Lorg/json/JSONArray;

    .end local v0    # "cookies":Lorg/json/JSONArray;
    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    goto :goto_0
.end method

.method public getExpirySeconds()I
    .locals 1

    .prologue
    .line 89
    iget v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mExpiry:I

    return v0
.end method

.method public getRefreshToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->mRefreshToken:Ljava/lang/String;

    return-object v0
.end method
