.class public Lcom/amazon/mShop/util/ConfigUtils;
.super Ljava/lang/Object;
.source "ConfigUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getString(Landroid/content/Context;I)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "featureConfigStringId"    # I

    .prologue
    const/4 v1, 0x0

    .line 99
    if-nez p0, :cond_1

    .line 106
    :cond_0
    :goto_0
    return-object v1

    .line 102
    :cond_1
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 103
    .local v0, "featureConfigKey":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 106
    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ResourcesUtils;->getStringForCurrentLocale(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static getStringForApp(Landroid/content/Context;I)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "featureConfigStringId"    # I

    .prologue
    .line 150
    if-nez p0, :cond_0

    .line 151
    const/4 v0, 0x0

    .line 153
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "featureConfigStringId"    # I
    .param p2, "localeName"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 125
    if-nez p0, :cond_1

    .line 132
    :cond_0
    :goto_0
    return-object v1

    .line 128
    :cond_1
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 129
    .local v0, "featureConfigKey":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 132
    invoke-static {p0, v0, p2}, Lcom/amazon/mShop/util/ResourcesUtils;->getStringOfSpecificLocale(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static injectDefaultDebugSettings(Landroid/content/Context;)V
    .locals 31
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 201
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v27

    if-nez v27, :cond_1

    .line 330
    :cond_0
    :goto_0
    return-void

    .line 204
    :cond_1
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v27

    const-string/jumbo v28, "debugsettings"

    const-string/jumbo v29, "raw"

    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v27 .. v30}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v21

    .line 207
    .local v21, "resId":I
    if-eqz v21, :cond_0

    .line 208
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v27

    move-object/from16 v0, v27

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v14

    .line 209
    .local v14, "fis":Ljava/io/InputStream;
    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v27

    invoke-virtual/range {v27 .. v27}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v25

    .line 210
    .local v25, "xmlString":Ljava/lang/String;
    const/16 v19, 0x0

    .line 211
    .local v19, "nameProp":Ljava/lang/String;
    const/16 v16, 0x0

    .line 212
    .local v16, "isAttrString":Z
    new-instance v10, Ljava/util/HashMap;

    invoke-direct {v10}, Ljava/util/HashMap;-><init>()V

    .line 213
    .local v10, "dataStoreMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 214
    .local v5, "cookieMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 215
    .local v4, "adsDataStoreMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v7, 0x0

    .line 220
    .local v7, "currMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_0
    invoke-static {v14}, Lcom/amazon/mShop/util/ConfigUtils;->readTextFile(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v25

    .line 221
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v13

    .line 223
    .local v13, "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    const/16 v27, 0x1

    move/from16 v0, v27

    invoke-virtual {v13, v0}, Lorg/xmlpull/v1/XmlPullParserFactory;->setNamespaceAware(Z)V

    .line 224
    invoke-virtual {v13}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v26

    .line 226
    .local v26, "xpp":Lorg/xmlpull/v1/XmlPullParser;
    new-instance v27, Ljava/io/StringReader;

    move-object/from16 v0, v27

    move-object/from16 v1, v25

    invoke-direct {v0, v1}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-interface/range {v26 .. v27}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 227
    invoke-interface/range {v26 .. v26}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v12

    .line 228
    .local v12, "eventType":I
    :goto_1
    const/16 v27, 0x1

    move/from16 v0, v27

    if-eq v12, v0, :cond_a

    .line 229
    if-nez v12, :cond_3

    .line 261
    :cond_2
    :goto_2
    invoke-interface/range {v26 .. v26}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v12

    goto :goto_1

    .line 230
    :cond_3
    const/16 v27, 0x2

    move/from16 v0, v27

    if-ne v12, v0, :cond_7

    .line 233
    invoke-interface/range {v26 .. v26}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v22

    .line 234
    .local v22, "tagName":Ljava/lang/String;
    const-string/jumbo v27, "DataStore"

    move-object/from16 v0, v27

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v27

    if-eqz v27, :cond_5

    .line 235
    move-object v7, v10

    .line 243
    :cond_4
    :goto_3
    const/16 v27, 0x0

    const-string/jumbo v28, "name"

    invoke-interface/range {v26 .. v28}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 245
    const-string/jumbo v27, "string"

    const/16 v28, 0x0

    const-string/jumbo v29, "type"

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-interface {v0, v1, v2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v28

    invoke-virtual/range {v27 .. v28}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v16

    .line 247
    goto :goto_2

    .line 236
    :cond_5
    const-string/jumbo v27, "Cookie"

    move-object/from16 v0, v27

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v27

    if-eqz v27, :cond_6

    .line 237
    move-object v7, v5

    goto :goto_3

    .line 238
    :cond_6
    const-string/jumbo v27, "MobileAdsDataStore"

    move-object/from16 v0, v27

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v27

    if-eqz v27, :cond_4

    .line 239
    move-object v7, v4

    goto :goto_3

    .line 247
    .end local v22    # "tagName":Ljava/lang/String;
    :cond_7
    const/16 v27, 0x3

    move/from16 v0, v27

    if-ne v12, v0, :cond_8

    .line 249
    const/16 v19, 0x0

    .line 250
    const/16 v16, 0x0

    goto :goto_2

    .line 251
    :cond_8
    const/16 v27, 0x4

    move/from16 v0, v27

    if-ne v12, v0, :cond_2

    .line 252
    if-eqz v19, :cond_2

    const-string/jumbo v27, ""

    invoke-virtual/range {v19 .. v19}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v28

    invoke-virtual/range {v27 .. v28}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v27

    if-nez v27, :cond_2

    .line 253
    invoke-interface/range {v26 .. v26}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v17

    .line 254
    .local v17, "itemValue":Ljava/lang/String;
    if-eqz v16, :cond_9

    .line 255
    new-instance v27, Ljava/lang/StringBuilder;

    invoke-direct/range {v27 .. v27}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v28, "\""

    invoke-virtual/range {v27 .. v28}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v27

    move-object/from16 v0, v27

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v27

    const-string/jumbo v28, "\""

    invoke-virtual/range {v27 .. v28}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v27

    invoke-virtual/range {v27 .. v27}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 258
    :cond_9
    move-object/from16 v0, v19

    move-object/from16 v1, v17

    invoke-virtual {v7, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    goto/16 :goto_2

    .line 263
    .end local v12    # "eventType":I
    .end local v13    # "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    .end local v17    # "itemValue":Ljava/lang/String;
    .end local v26    # "xpp":Lorg/xmlpull/v1/XmlPullParser;
    :catch_0
    move-exception v27

    .line 274
    :cond_a
    :goto_4
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v27

    invoke-interface/range {v27 .. v27}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v9

    .line 275
    .local v9, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    invoke-virtual {v10}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v27

    invoke-interface/range {v27 .. v27}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v15

    .local v15, "i$":Ljava/util/Iterator;
    :cond_b
    :goto_5
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v27

    if-eqz v27, :cond_c

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/Map$Entry;

    .line 276
    .local v11, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v11}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/lang/String;

    .line 277
    .local v18, "key":Ljava/lang/String;
    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Ljava/lang/String;

    .line 278
    .local v23, "value":Ljava/lang/String;
    move-object/from16 v0, v18

    invoke-interface {v9, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 282
    .local v8, "currValue":Ljava/lang/String;
    invoke-static {v8}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v27

    if-eqz v27, :cond_b

    .line 290
    const/16 v27, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v23

    move/from16 v2, v27

    invoke-interface {v9, v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_5

    .line 297
    .end local v8    # "currValue":Ljava/lang/String;
    .end local v11    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v18    # "key":Ljava/lang/String;
    .end local v23    # "value":Ljava/lang/String;
    :cond_c
    invoke-virtual {v5}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v27

    invoke-interface/range {v27 .. v27}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :cond_d
    :goto_6
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v27

    if-eqz v27, :cond_10

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/Map$Entry;

    .line 298
    .restart local v11    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v11}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/lang/String;

    .line 299
    .restart local v18    # "key":Ljava/lang/String;
    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Ljava/lang/String;

    .line 300
    .restart local v23    # "value":Ljava/lang/String;
    const/16 v20, 0x0

    .line 301
    .local v20, "previousSetting":Ljava/lang/String;
    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/CookieBridge;->getCookie(Ljava/lang/String;Landroid/content/Context;)Ljava/util/Map;

    move-result-object v6

    .line 304
    .local v6, "cookies":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v6, :cond_e

    invoke-interface {v6}, Ljava/util/Map;->size()I

    move-result v27

    if-lez v27, :cond_e

    .line 305
    move-object/from16 v0, v18

    invoke-interface {v6, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    .end local v20    # "previousSetting":Ljava/lang/String;
    check-cast v20, Ljava/lang/String;

    .line 308
    .restart local v20    # "previousSetting":Ljava/lang/String;
    :cond_e
    if-nez v23, :cond_f

    .line 309
    const-string/jumbo v23, ""

    .line 314
    :cond_f
    invoke-static/range {v20 .. v20}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v27

    if-eqz v27, :cond_d

    .line 315
    const/16 v27, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v27

    move-object/from16 v2, v18

    move-object/from16 v3, v23

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/net/CookieBridge;->setCookie(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)V

    goto :goto_6

    .line 319
    .end local v6    # "cookies":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v11    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v18    # "key":Ljava/lang/String;
    .end local v20    # "previousSetting":Ljava/lang/String;
    .end local v23    # "value":Ljava/lang/String;
    :cond_10
    move-object/from16 v0, p0

    invoke-static {v0, v4}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->writeSettingsMap(Landroid/content/Context;Ljava/util/Map;)V

    .line 326
    new-instance v24, Landroid/webkit/WebView;

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 327
    .local v24, "webview":Landroid/webkit/WebView;
    new-instance v27, Landroid/webkit/WebViewClient;

    invoke-direct/range {v27 .. v27}, Landroid/webkit/WebViewClient;-><init>()V

    move-object/from16 v0, v24

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 328
    sget v27, Lcom/amazon/mShop/android/lib/R$string;->wishlist_web_page_url:I

    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v24

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 269
    .end local v9    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .end local v15    # "i$":Ljava/util/Iterator;
    .end local v24    # "webview":Landroid/webkit/WebView;
    :catch_1
    move-exception v27

    goto/16 :goto_4

    .line 267
    :catch_2
    move-exception v27

    goto/16 :goto_4

    .line 265
    :catch_3
    move-exception v27

    goto/16 :goto_4
.end method

.method public static isDigitalContentEnabled()Z
    .locals 1

    .prologue
    .line 365
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasAppstore:I

    invoke-static {v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v0

    if-nez v0, :cond_0

    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasAIV:I

    invoke-static {v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isEnabled(I)Z
    .locals 1
    .param p0, "featureConfigStringId"    # I

    .prologue
    .line 83
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    return v0
.end method

.method public static isEnabled(Landroid/content/Context;I)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "featureConfigStringId"    # I

    .prologue
    const/4 v1, 0x0

    .line 63
    if-nez p0, :cond_1

    .line 70
    :cond_0
    :goto_0
    return v1

    .line 66
    :cond_1
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 67
    .local v0, "featureConfigKey":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 70
    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ResourcesUtils;->getBoolForCurrentLocale(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    goto :goto_0
.end method

.method public static isEnabledForApp(Landroid/content/Context;I)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "featureConfigStringId"    # I

    .prologue
    .line 46
    if-nez p0, :cond_0

    .line 47
    const/4 v0, 0x0

    .line 49
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v0

    goto :goto_0
.end method

.method private static readTextFile(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 5
    .param p0, "is"    # Ljava/io/InputStream;

    .prologue
    .line 340
    new-instance v3, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v3}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 341
    .local v3, "os":Ljava/io/ByteArrayOutputStream;
    const/16 v4, 0x400

    new-array v0, v4, [B

    .line 342
    .local v0, "buff":[B
    const/4 v2, 0x0

    .line 344
    .local v2, "len":I
    :goto_0
    :try_start_0
    invoke-virtual {p0, v0}, Ljava/io/InputStream;->read([B)I

    move-result v2

    const/4 v4, -0x1

    if-eq v2, v4, :cond_0

    .line 345
    const/4 v4, 0x0

    invoke-virtual {v3, v0, v4, v2}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 347
    :catch_0
    move-exception v1

    .line 348
    .local v1, "ioe":Ljava/io/IOException;
    :try_start_1
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 351
    :try_start_2
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 352
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2

    .line 357
    .end local v1    # "ioe":Ljava/io/IOException;
    :goto_1
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 351
    :cond_0
    :try_start_3
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 352
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_1

    .line 353
    :catch_1
    move-exception v1

    .line 354
    .restart local v1    # "ioe":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 353
    :catch_2
    move-exception v1

    .line 354
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 350
    .end local v1    # "ioe":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    .line 351
    :try_start_4
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 352
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3

    .line 355
    :goto_2
    throw v4

    .line 353
    :catch_3
    move-exception v1

    .line 354
    .restart local v1    # "ioe":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_2
.end method
