.class public Lcom/amazon/mShop/util/FeatureUtil;
.super Ljava/lang/Object;
.source "FeatureUtil.java"


# static fields
.field private static featureMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/util/FeatureUtil;->featureMap:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getFeatureName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "rawFeatureName"    # Ljava/lang/String;

    .prologue
    .line 54
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "feature_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static isFeatureEnabled(Ljava/lang/String;)Z
    .locals 3
    .param p0, "featureName"    # Ljava/lang/String;

    .prologue
    .line 45
    const/4 v0, 0x0

    .line 46
    .local v0, "enabled":Z
    invoke-static {p0}, Lcom/amazon/mShop/util/FeatureUtil;->getFeatureName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 47
    .local v1, "key":Ljava/lang/String;
    sget-object v2, Lcom/amazon/mShop/util/FeatureUtil;->featureMap:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 48
    sget-object v2, Lcom/amazon/mShop/util/FeatureUtil;->featureMap:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 50
    :cond_0
    return v0
.end method

.method public static loadFromRawFile(Landroid/content/Context;)V
    .locals 13
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v10, 0x1

    .line 58
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    .line 59
    .local v4, "packName":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const-string/jumbo v11, "feature_settings"

    const-string/jumbo v12, "raw"

    invoke-virtual {v9, v11, v12, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v5

    .line 60
    .local v5, "resId":I
    if-eqz v5, :cond_2

    .line 63
    :try_start_0
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v2

    .line 65
    .local v2, "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    const/4 v9, 0x1

    invoke-virtual {v2, v9}, Lorg/xmlpull/v1/XmlPullParserFactory;->setNamespaceAware(Z)V

    .line 66
    invoke-virtual {v2}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v8

    .line 67
    .local v8, "xpp":Lorg/xmlpull/v1/XmlPullParser;
    new-instance v9, Ljava/io/InputStreamReader;

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    invoke-virtual {v11, v5}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v11

    invoke-direct {v9, v11}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-interface {v8, v9}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 69
    invoke-interface {v8}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v1

    .line 70
    .local v1, "eventType":I
    :goto_0
    if-eq v1, v10, :cond_2

    .line 71
    if-nez v1, :cond_1

    .line 85
    :cond_0
    :goto_1
    invoke-interface {v8}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    goto :goto_0

    .line 72
    :cond_1
    const/4 v9, 0x2

    if-ne v1, v9, :cond_0

    .line 75
    invoke-interface {v8}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v6

    .line 76
    .local v6, "tagName":Ljava/lang/String;
    const-string/jumbo v9, "feature"

    invoke-virtual {v9, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 77
    const/4 v9, 0x0

    const-string/jumbo v11, "name"

    invoke-interface {v8, v9, v11}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 79
    .local v3, "nameProp":Ljava/lang/String;
    const/4 v9, 0x0

    const-string/jumbo v11, "value"

    invoke-interface {v8, v9, v11}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 81
    .local v7, "valueProp":Ljava/lang/String;
    const-string/jumbo v9, "true"

    invoke-virtual {v7, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3

    move v9, v10

    :goto_2
    invoke-static {v3, v9}, Lcom/amazon/mShop/util/FeatureUtil;->setFeatureEnabled(Ljava/lang/String;Z)V
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_1

    .line 87
    .end local v1    # "eventType":I
    .end local v2    # "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    .end local v3    # "nameProp":Ljava/lang/String;
    .end local v6    # "tagName":Ljava/lang/String;
    .end local v7    # "valueProp":Ljava/lang/String;
    .end local v8    # "xpp":Lorg/xmlpull/v1/XmlPullParser;
    :catch_0
    move-exception v0

    .line 89
    .local v0, "e":Lorg/xmlpull/v1/XmlPullParserException;
    const-string/jumbo v9, "FeatureUtil"

    const-string/jumbo v10, "Exception when initializing XML parser."

    invoke-static {v9, v10}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 95
    .end local v0    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    :cond_2
    :goto_3
    return-void

    .line 81
    .restart local v1    # "eventType":I
    .restart local v2    # "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    .restart local v3    # "nameProp":Ljava/lang/String;
    .restart local v6    # "tagName":Ljava/lang/String;
    .restart local v7    # "valueProp":Ljava/lang/String;
    .restart local v8    # "xpp":Lorg/xmlpull/v1/XmlPullParser;
    :cond_3
    const/4 v9, 0x0

    goto :goto_2

    .line 90
    .end local v1    # "eventType":I
    .end local v2    # "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    .end local v3    # "nameProp":Ljava/lang/String;
    .end local v6    # "tagName":Ljava/lang/String;
    .end local v7    # "valueProp":Ljava/lang/String;
    .end local v8    # "xpp":Lorg/xmlpull/v1/XmlPullParser;
    :catch_1
    move-exception v0

    .line 92
    .local v0, "e":Ljava/io/IOException;
    const-string/jumbo v9, "FeatureUtil"

    const-string/jumbo v10, "Exception when parsing XML."

    invoke-static {v9, v10}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3
.end method

.method public static setFeatureEnabled(Ljava/lang/String;Z)V
    .locals 3
    .param p0, "featureName"    # Ljava/lang/String;
    .param p1, "enabled"    # Z

    .prologue
    .line 37
    invoke-static {p0}, Lcom/amazon/mShop/util/FeatureUtil;->getFeatureName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 38
    .local v0, "key":Ljava/lang/String;
    sget-object v1, Lcom/amazon/mShop/util/FeatureUtil;->featureMap:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 39
    sget-object v1, Lcom/amazon/mShop/util/FeatureUtil;->featureMap:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    :cond_0
    sget-object v1, Lcom/amazon/mShop/util/FeatureUtil;->featureMap:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    return-void
.end method
