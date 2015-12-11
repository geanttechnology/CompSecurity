.class public Lcom/amazon/mShop/payment/alipay/AlipayAdapter;
.super Ljava/lang/Object;
.source "AlipayAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/payment/alipay/AlipayAdapter$Factory;
    }
.end annotation


# static fields
.field private static final RESULT_FIELD_PATTERN:Ljava/util/regex/Pattern;

.field private static final SINGLETON_INSTANCE:Lcom/amazon/mShop/payment/alipay/AlipayAdapter;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 53
    const-string/jumbo v0, "\\s*([^;]+?)\\s*=\\s*\\{(.*?)\\}\\s*"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->RESULT_FIELD_PATTERN:Ljava/util/regex/Pattern;

    .line 55
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;

    invoke-direct {v0}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;-><init>()V

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->SINGLETON_INSTANCE:Lcom/amazon/mShop/payment/alipay/AlipayAdapter;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    return-void
.end method

.method static synthetic access$000()Lcom/amazon/mShop/payment/alipay/AlipayAdapter;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->SINGLETON_INSTANCE:Lcom/amazon/mShop/payment/alipay/AlipayAdapter;

    return-object v0
.end method

.method private convertPaymentResultStrToJson(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 8
    .param p1, "alipayResult"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x2

    .line 205
    invoke-direct {p0, p1}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 206
    const/4 v1, 0x0

    .line 228
    :goto_0
    return-object v1

    .line 208
    :cond_0
    const/4 v1, 0x0

    .line 210
    .local v1, "json":Lorg/json/JSONObject;
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 213
    .end local v1    # "json":Lorg/json/JSONObject;
    .local v2, "json":Lorg/json/JSONObject;
    :try_start_1
    sget-object v6, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->RESULT_FIELD_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v6, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v4

    .line 214
    .local v4, "matcher":Ljava/util/regex/Matcher;
    :cond_1
    :goto_1
    invoke-virtual {v4}, Ljava/util/regex/Matcher;->find()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 215
    invoke-virtual {v4}, Ljava/util/regex/Matcher;->groupCount()I

    move-result v0

    .line 216
    .local v0, "groupCount":I
    if-ne v0, v7, :cond_1

    .line 217
    const/4 v6, 0x1

    invoke-virtual {v4, v6}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    .line 218
    .local v3, "key":Ljava/lang/String;
    const/4 v6, 0x2

    invoke-virtual {v4, v6}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v5

    .line 219
    .local v5, "value":Ljava/lang/String;
    invoke-virtual {v2, v3, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 223
    .end local v0    # "groupCount":I
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "matcher":Ljava/util/regex/Matcher;
    .end local v5    # "value":Ljava/lang/String;
    :catch_0
    move-exception v6

    move-object v1, v2

    .end local v2    # "json":Lorg/json/JSONObject;
    .restart local v1    # "json":Lorg/json/JSONObject;
    goto :goto_0

    .end local v1    # "json":Lorg/json/JSONObject;
    .restart local v2    # "json":Lorg/json/JSONObject;
    .restart local v4    # "matcher":Ljava/util/regex/Matcher;
    :cond_2
    move-object v1, v2

    .line 227
    .end local v2    # "json":Lorg/json/JSONObject;
    .restart local v1    # "json":Lorg/json/JSONObject;
    goto :goto_0

    .line 223
    .end local v4    # "matcher":Ljava/util/regex/Matcher;
    :catch_1
    move-exception v6

    goto :goto_0
.end method

.method private isCompatiblePackInstalled(Landroid/content/Context;Ljava/lang/String;I)Z
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "minVersion"    # I

    .prologue
    .line 90
    const/4 v0, 0x0

    .line 92
    .local v0, "available":Z
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 93
    .local v1, "manager":Landroid/content/pm/PackageManager;
    const/4 v3, 0x0

    invoke-virtual {v1, p2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    .line 94
    .local v2, "packageInfo":Landroid/content/pm/PackageInfo;
    if-eqz v2, :cond_0

    .line 95
    iget v3, v2, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    if-le v3, p3, :cond_0

    .line 96
    const/4 v0, 0x1

    .line 104
    .end local v1    # "manager":Landroid/content/pm/PackageManager;
    .end local v2    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    :goto_0
    return v0

    .line 99
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method private isEmpty(Ljava/lang/String;)Z
    .locals 1
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 237
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getResultAsUriQueryParam(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "resultString"    # Ljava/lang/String;

    .prologue
    .line 177
    invoke-direct {p0, p1}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 178
    const/4 v1, 0x0

    .line 191
    :cond_0
    :goto_0
    return-object v1

    .line 180
    :cond_1
    invoke-direct {p0, p1}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->convertPaymentResultStrToJson(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 181
    .local v0, "json":Lorg/json/JSONObject;
    const/4 v1, 0x0

    .line 182
    .local v1, "resultParam":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 184
    :try_start_0
    sget-object v2, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->result:Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    invoke-virtual {v2}, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 185
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public isAlipayInstalled(Landroid/content/Context;)Z
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x1

    .line 77
    const-string/jumbo v1, "com.eg.android.AlipayGphone"

    const/16 v2, 0x26

    invoke-direct {p0, p1, v1, v2}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->isCompatiblePackInstalled(Landroid/content/Context;Ljava/lang/String;I)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "com.alipay.android.app"

    invoke-direct {p0, p1, v1, v0}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->isCompatiblePackInstalled(Landroid/content/Context;Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPaymentSuccess(Ljava/lang/String;)Z
    .locals 4
    .param p1, "resultString"    # Ljava/lang/String;

    .prologue
    .line 143
    invoke-direct {p0, p1}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 144
    const/4 v0, 0x0

    .line 160
    :cond_0
    :goto_0
    return v0

    .line 146
    :cond_1
    invoke-direct {p0, p1}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->convertPaymentResultStrToJson(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 147
    .local v1, "resultJson":Lorg/json/JSONObject;
    const/4 v0, 0x0

    .line 148
    .local v0, "isSuccess":Z
    if-eqz v1, :cond_0

    .line 150
    :try_start_0
    sget-object v3, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->resultStatus:Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;

    invoke-virtual {v3}, Lcom/amazon/mShop/payment/alipay/AlipayCallback$ResultField;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 151
    .local v2, "resultStatus":Ljava/lang/String;
    const-string/jumbo v3, "9000"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    if-eqz v3, :cond_0

    .line 152
    const/4 v0, 0x1

    goto :goto_0

    .line 154
    .end local v2    # "resultStatus":Ljava/lang/String;
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method public pay(Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/mShop/payment/alipay/AlipayCallback;)Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;
    .locals 4
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "orderInfo"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/amazon/mShop/payment/alipay/AlipayCallback;

    .prologue
    .line 118
    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->ADAPTER_INVOKE_SUCCESS:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    .line 119
    .local v1, "invokationResult":Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;
    const-string/jumbo v2, "com.eg.android.AlipayGphone"

    const/16 v3, 0x26

    invoke-direct {p0, p1, v2, v3}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->isCompatiblePackInstalled(Landroid/content/Context;Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 120
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;-><init>(Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/mShop/payment/alipay/AlipayCallback;)V

    .line 121
    .local v0, "alipayConnection":Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;
    const-string/jumbo v2, "com.eg.android.AlipayGphone.IAlixPay"

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->startPayment(Ljava/lang/String;)V

    .line 130
    .end local v0    # "alipayConnection":Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;
    :goto_0
    return-object v1

    .line 123
    :cond_0
    const-string/jumbo v2, "com.alipay.android.app"

    const/4 v3, 0x1

    invoke-direct {p0, p1, v2, v3}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->isCompatiblePackInstalled(Landroid/content/Context;Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 124
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;-><init>(Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/mShop/payment/alipay/AlipayCallback;)V

    .line 125
    .restart local v0    # "alipayConnection":Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;
    const-string/jumbo v2, "com.alipay.android.app.IAlixPay"

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->startPayment(Ljava/lang/String;)V

    goto :goto_0

    .line 128
    .end local v0    # "alipayConnection":Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;
    :cond_1
    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->ALIPAY_UAVAILABLE:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    goto :goto_0
.end method
