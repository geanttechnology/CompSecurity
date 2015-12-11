.class public Lcom/auditude/ads/response/VmapXmlParser;
.super Ljava/lang/Object;
.source "VmapXmlParser.java"


# instance fields
.field private parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

.field private parser:Lorg/xmlpull/v1/XmlPullParser;

.field private rootNode:Lcom/auditude/ads/response/VmapXmlNode;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/ads/response/VmapXmlParser;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 20
    return-void
.end method

.method private parseNode()Lcom/auditude/ads/response/VmapXmlNode;
    .locals 14
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 58
    new-instance v3, Lcom/auditude/ads/response/VmapXmlNode;

    invoke-direct {v3}, Lcom/auditude/ads/response/VmapXmlNode;-><init>()V

    .line 59
    .local v3, "node":Lcom/auditude/ads/response/VmapXmlNode;
    iget-object v6, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Lcom/auditude/ads/response/VmapXmlNode;->setName(Ljava/lang/String;)V

    .line 60
    invoke-direct {p0, v3}, Lcom/auditude/ads/response/VmapXmlParser;->setAttributes(Lcom/auditude/ads/response/VmapXmlNode;)V

    .line 62
    iget-object v6, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    .line 63
    .local v1, "eventType":I
    :goto_0
    const/4 v6, 0x3

    if-ne v1, v6, :cond_0

    .line 101
    return-object v3

    .line 65
    :cond_0
    const/4 v6, 0x2

    if-ne v1, v6, :cond_5

    .line 67
    const-string v6, "VAST"

    iget-object v7, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v7}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 69
    iget-object v6, p0, Lcom/auditude/ads/response/VmapXmlParser;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-direct {p0, v6}, Lcom/auditude/ads/response/VmapXmlParser;->parseVAST(Lcom/auditude/ads/network/vast/model/VASTAd;)Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v4

    .line 70
    .local v4, "vastDoc":Lcom/auditude/ads/network/vast/model/VASTDocument;
    if-eqz v4, :cond_1

    .line 72
    invoke-virtual {v3, v4}, Lcom/auditude/ads/response/VmapXmlNode;->addVastDocument(Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    .line 99
    .end local v4    # "vastDoc":Lcom/auditude/ads/network/vast/model/VASTDocument;
    :cond_1
    :goto_1
    iget-object v6, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    goto :goto_0

    .line 77
    :cond_2
    const-string v6, "AdSource"

    iget-object v7, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v7}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 79
    new-instance v5, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    invoke-direct {v5}, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;-><init>()V

    .line 81
    .local v5, "wrapperAd":Lcom/auditude/ads/network/vast/model/VASTWrapperAd;
    iget-object v6, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v7, "followRedirects"

    const/4 v8, 0x1

    invoke-static {v6, v7, v8}, Lcom/auditude/ads/util/XMLUtil;->attributeAsBoolOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Z)Z

    move-result v6

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    iput-object v6, v5, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->followAdditionalWrappers:Ljava/lang/Boolean;

    .line 83
    const/4 v2, 0x0

    .line 84
    .local v2, "fallbackOnInvalidCreative":Z
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v6

    invoke-virtual {v6}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v0

    .line 85
    .local v0, "adSettings":Lcom/auditude/ads/core/AdSettings;
    const-string v6, "fallbackOnInvalidCreative"

    invoke-virtual {v0, v6}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    if-eqz v6, :cond_3

    .line 87
    const-string v6, "fallbackOnInvalidCreative"

    invoke-virtual {v0, v6}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    .line 89
    :cond_3
    new-instance v6, Lcom/auditude/ads/network/vast/model/VASTAd;

    iget-object v7, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v8, "id"

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v10

    const-wide v12, 0x408f400000000000L    # 1000.0

    mul-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->round(D)J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    invoke-static {v7, v8, v9}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    invoke-direct {v6, v7, v8}, Lcom/auditude/ads/network/vast/model/VASTAd;-><init>(Ljava/lang/String;Ljava/lang/Boolean;)V

    iput-object v6, p0, Lcom/auditude/ads/response/VmapXmlParser;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 90
    iget-object v6, p0, Lcom/auditude/ads/response/VmapXmlParser;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v6, v5}, Lcom/auditude/ads/network/vast/model/VASTAd;->setWrapperAd(Lcom/auditude/ads/network/vast/model/VASTWrapperAd;)V

    .line 92
    .end local v0    # "adSettings":Lcom/auditude/ads/core/AdSettings;
    .end local v2    # "fallbackOnInvalidCreative":Z
    .end local v5    # "wrapperAd":Lcom/auditude/ads/network/vast/model/VASTWrapperAd;
    :cond_4
    invoke-direct {p0}, Lcom/auditude/ads/response/VmapXmlParser;->parseNode()Lcom/auditude/ads/response/VmapXmlNode;

    move-result-object v6

    invoke-virtual {v3, v6}, Lcom/auditude/ads/response/VmapXmlNode;->addChild(Lcom/auditude/ads/response/VmapXmlNode;)V

    goto :goto_1

    .line 95
    :cond_5
    const/4 v6, 0x4

    if-ne v1, v6, :cond_1

    .line 97
    iget-object v6, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Lcom/auditude/ads/response/VmapXmlNode;->setValue(Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method private parseVAST(Lcom/auditude/ads/network/vast/model/VASTAd;)Lcom/auditude/ads/network/vast/model/VASTDocument;
    .locals 5
    .param p1, "parentAd"    # Lcom/auditude/ads/network/vast/model/VASTAd;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 106
    const/4 v2, 0x0

    .line 107
    .local v2, "vastDoc":Lcom/auditude/ads/network/vast/model/VASTDocument;
    iget-object v4, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 108
    .local v0, "eventType":I
    iget-object v4, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 111
    .local v1, "tag":Ljava/lang/String;
    :goto_0
    iget-object v4, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 113
    const/4 v4, 0x2

    if-ne v0, v4, :cond_0

    const-string v4, "VAST"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 115
    new-instance v3, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;

    invoke-direct {v3}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;-><init>()V

    .line 116
    .local v3, "vastParser":Lcom/auditude/ads/network/vast/loader/VASTXMLParser;
    iput-object p1, v3, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 117
    iget-object v4, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-virtual {v3, v4}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parse(Lorg/xmlpull/v1/XmlPullParser;)Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v2

    .line 119
    iget-object v4, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 120
    iget-object v4, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 124
    .end local v3    # "vastParser":Lcom/auditude/ads/network/vast/loader/VASTXMLParser;
    :cond_0
    const/4 v4, 0x3

    if-ne v0, v4, :cond_1

    const-string v4, "VAST"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 132
    return-object v2

    .line 129
    :cond_1
    iget-object v4, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 109
    goto :goto_0
.end method

.method private setAttributes(Lcom/auditude/ads/response/VmapXmlNode;)V
    .locals 4
    .param p1, "node"    # Lcom/auditude/ads/response/VmapXmlNode;

    .prologue
    .line 137
    if-eqz p1, :cond_0

    .line 139
    iget-object v2, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v0

    .line 140
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-lt v1, v0, :cond_1

    .line 145
    .end local v0    # "count":I
    .end local v1    # "i":I
    :cond_0
    return-void

    .line 142
    .restart local v0    # "count":I
    .restart local v1    # "i":I
    :cond_1
    iget-object v2, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Lcom/auditude/ads/response/VmapXmlNode;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getChildeNodesByName(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/response/VmapXmlNode;",
            ">;"
        }
    .end annotation

    .prologue
    .line 153
    iget-object v0, p0, Lcom/auditude/ads/response/VmapXmlParser;->rootNode:Lcom/auditude/ads/response/VmapXmlNode;

    invoke-virtual {v0, p1}, Lcom/auditude/ads/response/VmapXmlNode;->getChildeNodesByName(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public parseXML(Ljava/lang/String;)V
    .locals 5
    .param p1, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 28
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 30
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v1

    .line 31
    .local v1, "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    invoke-virtual {v1, v4}, Lorg/xmlpull/v1/XmlPullParserFactory;->setNamespaceAware(Z)V

    .line 32
    invoke-virtual {v1}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    iput-object v2, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    .line 33
    iget-object v2, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    new-instance v3, Ljava/io/StringReader;

    invoke-direct {v3, p1}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-interface {v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 35
    iget-object v2, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 36
    .local v0, "eventType":I
    :goto_0
    if-ne v0, v4, :cond_1

    .line 54
    .end local v0    # "eventType":I
    .end local v1    # "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    :cond_0
    return-void

    .line 39
    .restart local v0    # "eventType":I
    .restart local v1    # "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    :cond_1
    if-eqz v0, :cond_2

    .line 43
    if-eq v0, v4, :cond_2

    .line 47
    const/4 v2, 0x2

    if-ne v0, v2, :cond_2

    .line 49
    invoke-direct {p0}, Lcom/auditude/ads/response/VmapXmlParser;->parseNode()Lcom/auditude/ads/response/VmapXmlNode;

    move-result-object v2

    iput-object v2, p0, Lcom/auditude/ads/response/VmapXmlParser;->rootNode:Lcom/auditude/ads/response/VmapXmlNode;

    .line 51
    :cond_2
    iget-object v2, p0, Lcom/auditude/ads/response/VmapXmlParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0
.end method
