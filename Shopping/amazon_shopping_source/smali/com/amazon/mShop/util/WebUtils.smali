.class public Lcom/amazon/mShop/util/WebUtils;
.super Ljava/lang/Object;
.source "WebUtils.java"


# static fields
.field static final EMAIL_NEEDS_CRASH_REPORT:I

.field static final PROVIDE_BETA_FEEDBACK_ADDRESS_ID:I

.field static final PROVIDE_BETA_FEEDBACK_SUBJECT_ID:I

.field static final PROVIDE_FEEDBACK_ADDRESS_ID:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->provide_feedback_to_address_android:I

    sput v0, Lcom/amazon/mShop/util/WebUtils;->PROVIDE_FEEDBACK_ADDRESS_ID:I

    .line 49
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->provide_beta_feedback_to_address_android:I

    sput v0, Lcom/amazon/mShop/util/WebUtils;->PROVIDE_BETA_FEEDBACK_ADDRESS_ID:I

    .line 51
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->provide_beta_feedback_subject_android:I

    sput v0, Lcom/amazon/mShop/util/WebUtils;->PROVIDE_BETA_FEEDBACK_SUBJECT_ID:I

    .line 53
    sget v0, Lcom/amazon/mShop/android/lib/R$array;->needsCrashEmailList:I

    sput v0, Lcom/amazon/mShop/util/WebUtils;->EMAIL_NEEDS_CRASH_REPORT:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static buildFullUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "refTag"    # Ljava/lang/String;

    .prologue
    .line 305
    move-object v1, p0

    .line 306
    .local v1, "result":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 307
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 308
    .local v0, "build":Landroid/net/Uri$Builder;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "ref="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 309
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    .line 311
    .end local v0    # "build":Landroid/net/Uri$Builder;
    :cond_0
    return-object v1
.end method

.method private static getCrashBody(Landroid/content/Context;)Ljava/lang/String;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 133
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDeviceId()Ljava/lang/String;

    move-result-object v1

    .line 134
    .local v1, "deviceId":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->do_not_remove_device_id:I

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 135
    .local v0, "body":Ljava/lang/String;
    const-string/jumbo v2, "\n\n\n\n\n\n--------------------------------------------------\n%s"

    new-array v3, v6, [Ljava/lang/Object;

    aput-object v0, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static handleMailtoLink(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 32
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 56
    const-string/jumbo v3, "mailto:"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 62
    new-instance v13, Ljava/util/HashMap;

    invoke-direct {v13}, Ljava/util/HashMap;-><init>()V

    .line 63
    .local v13, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v3, "mailto:"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v22

    .line 64
    .local v22, "noScheme":Ljava/lang/String;
    invoke-static/range {v22 .. v22}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v10

    .line 67
    .local v10, "email":Landroid/net/Uri;
    invoke-virtual {v10}, Landroid/net/Uri;->getEncodedQuery()Ljava/lang/String;

    move-result-object v25

    .line 68
    .local v25, "query":Ljava/lang/String;
    if-eqz v25, :cond_2

    .line 69
    const-string/jumbo v3, "&"

    move-object/from16 v0, v25

    invoke-virtual {v0, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v24

    .line 70
    .local v24, "queries":[Ljava/lang/String;
    move-object/from16 v8, v24

    .local v8, "arr$":[Ljava/lang/String;
    array-length v0, v8

    move/from16 v16, v0

    .local v16, "len$":I
    const/4 v14, 0x0

    .local v14, "i$":I
    :goto_0
    move/from16 v0, v16

    if-ge v14, v0, :cond_2

    aget-object v23, v8, v14

    .line 71
    .local v23, "q":Ljava/lang/String;
    const-string/jumbo v3, "="

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v20

    .line 72
    .local v20, "nameval":[Ljava/lang/String;
    move-object/from16 v0, v20

    array-length v0, v0

    move/from16 v17, v0

    .line 73
    .local v17, "length":I
    if-nez v17, :cond_0

    .line 70
    :goto_1
    add-int/lit8 v14, v14, 0x1

    goto :goto_0

    .line 76
    :cond_0
    const/4 v3, 0x0

    aget-object v3, v20, v3

    invoke-static {v3}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v11

    .line 77
    .local v11, "headerKey":Ljava/lang/String;
    move-object/from16 v0, v20

    array-length v3, v0

    const/16 v29, 0x1

    move/from16 v0, v29

    if-le v3, v0, :cond_1

    const/4 v3, 0x1

    aget-object v3, v20, v3

    invoke-static {v3}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 78
    .local v12, "headerValue":Ljava/lang/String;
    :goto_2
    invoke-interface {v13, v11, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 77
    .end local v12    # "headerValue":Ljava/lang/String;
    :cond_1
    const/4 v12, 0x0

    goto :goto_2

    .line 84
    .end local v8    # "arr$":[Ljava/lang/String;
    .end local v11    # "headerKey":Ljava/lang/String;
    .end local v14    # "i$":I
    .end local v16    # "len$":I
    .end local v17    # "length":I
    .end local v20    # "nameval":[Ljava/lang/String;
    .end local v23    # "q":Ljava/lang/String;
    .end local v24    # "queries":[Ljava/lang/String;
    :cond_2
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v26

    .line 85
    .local v26, "resources":Landroid/content/res/Resources;
    new-instance v21, Ljava/util/HashSet;

    sget v3, Lcom/amazon/mShop/util/WebUtils;->EMAIL_NEEDS_CRASH_REPORT:I

    move-object/from16 v0, v26

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    move-object/from16 v0, v21

    invoke-direct {v0, v3}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 87
    .local v21, "needsCrashReport":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual {v10}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v19

    .line 88
    .local v19, "mainReceiver":Ljava/lang/String;
    move-object/from16 v0, v21

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v15

    .line 89
    .local v15, "isFeedback":Z
    const-string/jumbo v3, "subject"

    invoke-interface {v13, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 93
    .local v6, "subject":Ljava/lang/String;
    sget v3, Lcom/amazon/mShop/util/WebUtils;->PROVIDE_FEEDBACK_ADDRESS_ID:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    move-object/from16 v0, v19

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    .line 94
    .local v18, "mShopfeedbackAddress":Z
    if-eqz v18, :cond_3

    invoke-static/range {p0 .. p0}, Lcom/amazon/mShop/util/BuildUtils;->getBetaName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 95
    sget v3, Lcom/amazon/mShop/util/WebUtils;->PROVIDE_BETA_FEEDBACK_ADDRESS_ID:I

    move-object/from16 v0, v26

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v19

    .line 96
    sget v3, Lcom/amazon/mShop/util/WebUtils;->PROVIDE_BETA_FEEDBACK_SUBJECT_ID:I

    const/16 v29, 0x1

    move/from16 v0, v29

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v29, v0

    const/16 v30, 0x0

    invoke-static/range {p0 .. p0}, Lcom/amazon/mShop/util/BuildUtils;->getRevisionNumber(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v31

    aput-object v31, v29, v30

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-virtual {v0, v3, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 99
    :cond_3
    const/16 v28, 0x0

    .line 100
    .local v28, "toReceivers":[Ljava/lang/String;
    const-string/jumbo v3, "to"

    invoke-interface {v13, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Ljava/lang/String;

    .line 101
    .local v27, "to":Ljava/lang/String;
    invoke-static/range {v27 .. v27}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 102
    const-string/jumbo v3, ","

    move-object/from16 v0, v27

    invoke-virtual {v0, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v28

    .line 105
    :cond_4
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 106
    .local v4, "toAddress":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object/from16 v0, v19

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 107
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 108
    .local v5, "ccAddress":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static/range {v28 .. v28}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 109
    move-object/from16 v0, v28

    invoke-static {v4, v0}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 112
    :cond_5
    const-string/jumbo v3, "cc"

    invoke-interface {v13, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 113
    .local v9, "cc":Ljava/lang/String;
    invoke-static {v9}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_6

    .line 114
    const-string/jumbo v3, ","

    invoke-virtual {v9, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    invoke-static {v5, v3}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 119
    :cond_6
    if-eqz v15, :cond_8

    invoke-static/range {p0 .. p0}, Lcom/amazon/mShop/util/WebUtils;->getCrashBody(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    .line 120
    .local v7, "body":Ljava/lang/String;
    :goto_3
    if-eqz v15, :cond_7

    invoke-static {}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->getInstance()Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    move-result-object v3

    if-eqz v3, :cond_7

    .line 121
    invoke-static {}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->getInstance()Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    move-result-object v3

    new-instance v29, Ljava/lang/RuntimeException;

    const-string/jumbo v30, "Contact Us Exception"

    invoke-direct/range {v29 .. v30}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v29

    invoke-virtual {v3, v0}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->reportCrash(Ljava/lang/Throwable;)V

    .line 124
    :cond_7
    new-instance v2, Lcom/amazon/mShop/util/EmailComposer;

    move-object/from16 v3, p0

    invoke-direct/range {v2 .. v7}, Lcom/amazon/mShop/util/EmailComposer;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    .local v2, "ec":Lcom/amazon/mShop/util/EmailComposer;
    invoke-virtual {v2}, Lcom/amazon/mShop/util/EmailComposer;->composeEmail()V

    .line 126
    const/4 v3, 0x1

    .line 129
    .end local v2    # "ec":Lcom/amazon/mShop/util/EmailComposer;
    .end local v4    # "toAddress":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v5    # "ccAddress":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v6    # "subject":Ljava/lang/String;
    .end local v7    # "body":Ljava/lang/String;
    .end local v9    # "cc":Ljava/lang/String;
    .end local v10    # "email":Landroid/net/Uri;
    .end local v13    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v15    # "isFeedback":Z
    .end local v18    # "mShopfeedbackAddress":Z
    .end local v19    # "mainReceiver":Ljava/lang/String;
    .end local v21    # "needsCrashReport":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v22    # "noScheme":Ljava/lang/String;
    .end local v25    # "query":Ljava/lang/String;
    .end local v26    # "resources":Landroid/content/res/Resources;
    .end local v27    # "to":Ljava/lang/String;
    .end local v28    # "toReceivers":[Ljava/lang/String;
    :goto_4
    return v3

    .line 119
    .restart local v4    # "toAddress":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v5    # "ccAddress":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v6    # "subject":Ljava/lang/String;
    .restart local v9    # "cc":Ljava/lang/String;
    .restart local v10    # "email":Landroid/net/Uri;
    .restart local v13    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v15    # "isFeedback":Z
    .restart local v18    # "mShopfeedbackAddress":Z
    .restart local v19    # "mainReceiver":Ljava/lang/String;
    .restart local v21    # "needsCrashReport":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v22    # "noScheme":Ljava/lang/String;
    .restart local v25    # "query":Ljava/lang/String;
    .restart local v26    # "resources":Landroid/content/res/Resources;
    .restart local v27    # "to":Ljava/lang/String;
    .restart local v28    # "toReceivers":[Ljava/lang/String;
    :cond_8
    const-string/jumbo v3, "body"

    invoke-interface {v13, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    move-object v7, v3

    goto :goto_3

    .line 129
    .end local v4    # "toAddress":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v5    # "ccAddress":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v6    # "subject":Ljava/lang/String;
    .end local v9    # "cc":Ljava/lang/String;
    .end local v10    # "email":Landroid/net/Uri;
    .end local v13    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v15    # "isFeedback":Z
    .end local v18    # "mShopfeedbackAddress":Z
    .end local v19    # "mainReceiver":Ljava/lang/String;
    .end local v21    # "needsCrashReport":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v22    # "noScheme":Ljava/lang/String;
    .end local v25    # "query":Ljava/lang/String;
    .end local v26    # "resources":Landroid/content/res/Resources;
    .end local v27    # "to":Ljava/lang/String;
    .end local v28    # "toReceivers":[Ljava/lang/String;
    :cond_9
    const/4 v3, 0x0

    goto :goto_4
.end method

.method public static initializeCookiesForDevoHost(Ljava/lang/String;Ljava/lang/String;)V
    .locals 11
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "domain"    # Ljava/lang/String;

    .prologue
    .line 229
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    .line 230
    .local v7, "uri":Landroid/net/Uri;
    invoke-virtual {v7}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v4

    .line 231
    .local v4, "host":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/WebUtils;->isDevoHost(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 235
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "https://www"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 237
    .local v3, "cookies":Ljava/lang/String;
    const-string/jumbo v8, ";"

    invoke-virtual {v3, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 238
    .local v2, "cookieItems":[Ljava/lang/String;
    move-object v0, v2

    .local v0, "arr$":[Ljava/lang/String;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_0

    aget-object v1, v0, v5

    .line 240
    .local v1, "cookie":Ljava/lang/String;
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v8

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v4, v9}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 243
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "cookie":Ljava/lang/String;
    .end local v2    # "cookieItems":[Ljava/lang/String;
    .end local v3    # "cookies":Ljava/lang/String;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    :cond_0
    return-void
.end method

.method public static isBaseUrlEqual(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 5
    .param p0, "urlA"    # Ljava/lang/String;
    .param p1, "urlB"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 322
    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    .line 335
    :cond_0
    :goto_0
    return v2

    .line 325
    :cond_1
    const-string/jumbo v3, "#"

    invoke-virtual {p0, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 326
    .local v0, "posA":I
    const-string/jumbo v3, "#"

    invoke-virtual {p1, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 328
    .local v1, "posB":I
    if-ltz v0, :cond_2

    .line 329
    :goto_1
    if-ltz v1, :cond_3

    .line 330
    :goto_2
    if-ne v0, v1, :cond_0

    .line 331
    invoke-virtual {p0, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 332
    const/4 v2, 0x1

    goto :goto_0

    .line 328
    :cond_2
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    goto :goto_1

    .line 329
    :cond_3
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    goto :goto_2
.end method

.method public static isDefined(Ljava/lang/String;)Z
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 273
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "undefined"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 274
    :cond_0
    const/4 v0, 0x0

    .line 276
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isDevoHost(Ljava/lang/String;)Z
    .locals 2
    .param p0, "host"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 208
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 209
    const-string/jumbo v1, "www.amazon.com"

    invoke-virtual {p0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 220
    :cond_0
    :goto_0
    return v0

    .line 215
    :cond_1
    const-string/jumbo v1, ".amazonpmi.com"

    invoke-virtual {p0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string/jumbo v1, ".amazon.com"

    invoke-virtual {p0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 217
    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isFragmentUrl(Ljava/lang/String;)Z
    .locals 2
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 252
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 253
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 254
    .local v0, "uri":Landroid/net/Uri;
    invoke-virtual {v0}, Landroid/net/Uri;->getFragment()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 255
    const/4 v1, 0x1

    .line 258
    .end local v0    # "uri":Landroid/net/Uri;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static logRefMarkerForWebPage(Landroid/net/Uri;)V
    .locals 6
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 346
    :try_start_0
    invoke-virtual {p0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    .line 347
    .local v2, "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 348
    .local v3, "segment":Ljava/lang/String;
    const-string/jumbo v4, "ref="

    invoke-virtual {v3, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 349
    .local v1, "index":I
    if-nez v1, :cond_0

    .line 350
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/net/UrlLogger;->logURL(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 353
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "index":I
    .end local v2    # "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v3    # "segment":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 356
    :cond_1
    return-void
.end method

.method public static openWebview(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 286
    const-class v0, Lcom/amazon/mShop/web/MShopWebActivity;

    const/4 v1, -0x1

    invoke-static {p0, v0, p1, v1}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 287
    return-void
.end method

.method public static openWebview(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "refTag"    # Ljava/lang/String;

    .prologue
    .line 297
    invoke-static {p1, p2}, Lcom/amazon/mShop/util/WebUtils;->buildFullUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 298
    .local v0, "fullUrl":Ljava/lang/String;
    const-class v1, Lcom/amazon/mShop/web/MShopWebActivity;

    const/4 v2, -0x1

    invoke-static {p0, v1, v0, v2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 301
    return-void
.end method

.method public static parseQueryToJsObject(Landroid/net/Uri;)Ljava/lang/String;
    .locals 14
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 171
    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v12, "{"

    invoke-direct {v4, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 172
    .local v4, "jsObject":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Landroid/net/Uri;->getEncodedQuery()Ljava/lang/String;

    move-result-object v10

    .line 173
    .local v10, "query":Ljava/lang/String;
    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_2

    .line 174
    const-string/jumbo v12, "&"

    invoke-virtual {v10, v12}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v9

    .line 175
    .local v9, "queries":[Ljava/lang/String;
    const/4 v1, 0x0

    .line 176
    .local v1, "i":I
    move-object v0, v9

    .local v0, "arr$":[Ljava/lang/String;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    move v2, v1

    .end local v1    # "i":I
    .local v2, "i":I
    :goto_0
    if-ge v3, v6, :cond_2

    aget-object v8, v0, v3

    .line 177
    .local v8, "q":Ljava/lang/String;
    const-string/jumbo v12, "="

    invoke-virtual {v8, v12}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    .line 178
    .local v7, "nameval":[Ljava/lang/String;
    array-length v12, v7

    const/4 v13, 0x2

    if-ne v12, v13, :cond_3

    .line 179
    const/4 v12, 0x0

    aget-object v12, v7, v12

    invoke-static {v12}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    .line 180
    .local v5, "key":Ljava/lang/String;
    const/4 v12, 0x1

    aget-object v12, v7, v12

    invoke-static {v12}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v11

    .line 181
    .local v11, "value":Ljava/lang/String;
    const-string/jumbo v12, "app-action"

    invoke-virtual {v12, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_0

    move v1, v2

    .line 176
    .end local v2    # "i":I
    .end local v5    # "key":Ljava/lang/String;
    .end local v11    # "value":Ljava/lang/String;
    .restart local v1    # "i":I
    :goto_1
    add-int/lit8 v3, v3, 0x1

    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto :goto_0

    .line 185
    .restart local v5    # "key":Ljava/lang/String;
    .restart local v11    # "value":Ljava/lang/String;
    :cond_0
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    if-eqz v2, :cond_1

    .line 186
    const-string/jumbo v12, ","

    invoke-virtual {v4, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 188
    :cond_1
    const-string/jumbo v12, "\'"

    invoke-virtual {v4, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 189
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 190
    const-string/jumbo v12, "\':\'"

    invoke-virtual {v4, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 191
    invoke-virtual {v4, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 192
    const-string/jumbo v12, "\'"

    invoke-virtual {v4, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 196
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "i":I
    .end local v3    # "i$":I
    .end local v5    # "key":Ljava/lang/String;
    .end local v6    # "len$":I
    .end local v7    # "nameval":[Ljava/lang/String;
    .end local v8    # "q":Ljava/lang/String;
    .end local v9    # "queries":[Ljava/lang/String;
    .end local v11    # "value":Ljava/lang/String;
    :cond_2
    const-string/jumbo v12, "}"

    invoke-virtual {v4, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 198
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    return-object v12

    .restart local v0    # "arr$":[Ljava/lang/String;
    .restart local v2    # "i":I
    .restart local v3    # "i$":I
    .restart local v6    # "len$":I
    .restart local v7    # "nameval":[Ljava/lang/String;
    .restart local v8    # "q":Ljava/lang/String;
    .restart local v9    # "queries":[Ljava/lang/String;
    :cond_3
    move v1, v2

    .end local v2    # "i":I
    .restart local v1    # "i":I
    goto :goto_1
.end method
