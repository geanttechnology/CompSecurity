.class public Lcom/xfinity/playerlib/authorization/SMILParser;
.super Ljava/lang/Object;
.source "SMILParser.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/xfinity/playerlib/authorization/SMILParser;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/authorization/SMILParser;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private adStartsTooCloseToTotalDuration(IJ)Z
    .locals 6
    .param p1, "c3Start"    # I
    .param p2, "duration"    # J

    .prologue
    .line 113
    const/4 v0, 0x0

    .line 116
    .local v0, "returnValue":Z
    const-wide/16 v2, 0x0

    cmp-long v1, p2, v2

    if-lez v1, :cond_0

    int-to-long v2, p1

    cmp-long v1, p2, v2

    if-ltz v1, :cond_0

    .line 118
    int-to-long v2, p1

    const-wide/16 v4, 0x7530

    sub-long v4, p2, v4

    cmp-long v1, v2, v4

    if-lez v1, :cond_0

    .line 119
    const/4 v0, 0x1

    .line 122
    :cond_0
    return v0
.end method

.method private convertAdsTime(Ljava/lang/String;)I
    .locals 9
    .param p1, "time"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 127
    const/4 v3, 0x0

    .line 129
    .local v3, "ret":I
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p1

    .line 130
    const-string v6, ":"

    invoke-virtual {p1, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 131
    const-string v6, ":"

    invoke-virtual {p1, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 133
    .local v5, "tokens":[Ljava/lang/String;
    const/4 v6, 0x0

    aget-object v6, v5, v6

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 134
    .local v1, "h":I
    const/4 v6, 0x1

    aget-object v6, v5, v6

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .line 135
    .local v2, "m":I
    const/4 v6, 0x2

    aget-object v6, v5, v6

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    .line 137
    .local v4, "s":I
    mul-int/lit8 v6, v2, 0x3c

    add-int/2addr v6, v4

    mul-int/lit8 v7, v1, 0x3c

    mul-int/lit8 v7, v7, 0x3c

    add-int/2addr v6, v7

    mul-int/lit16 v3, v6, 0x3e8

    .line 148
    .end local v1    # "h":I
    .end local v2    # "m":I
    .end local v4    # "s":I
    .end local v5    # "tokens":[Ljava/lang/String;
    :cond_0
    return v3

    .line 139
    :cond_1
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    .line 140
    if-gtz v3, :cond_0

    .line 141
    new-instance v6, Ljava/lang/RuntimeException;

    const-string v7, "ad time <= 0"

    invoke-direct {v6, v7}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v6
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 144
    :catch_0
    move-exception v0

    .line 145
    .local v0, "e":Ljava/lang/Exception;
    sget-object v6, Lcom/xfinity/playerlib/authorization/SMILParser;->LOG:Lorg/slf4j/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Smil Ad time parsing error for "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 146
    throw v0
.end method


# virtual methods
.method public parse(Ljava/lang/String;)Lcom/xfinity/playerlib/authorization/SMILResource;
    .locals 42
    .param p1, "smilXML"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 28
    :try_start_0
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v28

    .line 29
    .local v28, "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    invoke-virtual/range {v28 .. v28}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;

    move-result-object v19

    .line 31
    .local v19, "builder":Ljavax/xml/parsers/DocumentBuilder;
    new-instance v37, Ljava/io/ByteArrayInputStream;

    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v38

    invoke-direct/range {v37 .. v38}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 33
    .local v37, "stream":Ljava/io/ByteArrayInputStream;
    move-object/from16 v0, v19

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Ljavax/xml/parsers/DocumentBuilder;->parse(Ljava/io/InputStream;)Lorg/w3c/dom/Document;

    move-result-object v23

    .line 34
    .local v23, "document":Lorg/w3c/dom/Document;
    const-string v38, "meta"

    move-object/from16 v0, v23

    move-object/from16 v1, v38

    invoke-interface {v0, v1}, Lorg/w3c/dom/Document;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v31

    .line 35
    .local v31, "metaList":Lorg/w3c/dom/NodeList;
    const/16 v38, 0x0

    move-object/from16 v0, v31

    move/from16 v1, v38

    invoke-interface {v0, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v30

    .line 36
    .local v30, "meta":Lorg/w3c/dom/Node;
    invoke-interface/range {v30 .. v30}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v38

    const-string v39, "base"

    invoke-interface/range {v38 .. v39}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v38

    invoke-interface/range {v38 .. v38}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v12

    .line 38
    .local v12, "baseUrl":Ljava/lang/String;
    const-string v38, "ref"

    move-object/from16 v0, v23

    move-object/from16 v1, v38

    invoke-interface {v0, v1}, Lorg/w3c/dom/Document;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v34

    .line 39
    .local v34, "refList":Lorg/w3c/dom/NodeList;
    const/16 v38, 0x0

    move-object/from16 v0, v34

    move/from16 v1, v38

    invoke-interface {v0, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v33

    .line 40
    .local v33, "ref":Lorg/w3c/dom/Node;
    invoke-interface/range {v33 .. v33}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v32

    .line 41
    .local v32, "nodeMap":Lorg/w3c/dom/NamedNodeMap;
    const-string v38, "src"

    move-object/from16 v0, v32

    move-object/from16 v1, v38

    invoke-interface {v0, v1}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v38

    invoke-interface/range {v38 .. v38}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v35

    .line 42
    .local v35, "refPath":Ljava/lang/String;
    new-instance v36, Lcom/xfinity/playerlib/authorization/SMILResource;

    new-instance v38, Ljava/lang/StringBuilder;

    invoke-direct/range {v38 .. v38}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v38

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    move-object/from16 v0, v38

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual/range {v38 .. v38}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v36

    move-object/from16 v1, v38

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/authorization/SMILResource;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 44
    .local v36, "smil":Lcom/xfinity/playerlib/authorization/SMILResource;
    const-wide/16 v24, 0x0

    .line 47
    .local v24, "duration":J
    :try_start_1
    const-string v38, "dur"

    move-object/from16 v0, v32

    move-object/from16 v1, v38

    invoke-interface {v0, v1}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v38

    if-eqz v38, :cond_0

    .line 48
    const-string v38, "dur"

    move-object/from16 v0, v32

    move-object/from16 v1, v38

    invoke-interface {v0, v1}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v38

    invoke-interface/range {v38 .. v38}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v38

    const-string v39, "ms"

    const-string v40, ""

    invoke-virtual/range {v38 .. v40}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v38

    invoke-static/range {v38 .. v38}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3

    move-result-wide v24

    .line 54
    :cond_0
    :goto_0
    :try_start_2
    sget-object v11, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->NO_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    .line 55
    .local v11, "adsType":Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    const-string v38, "tp:ChapterStartTimes"

    move-object/from16 v0, v32

    move-object/from16 v1, v38

    invoke-interface {v0, v1}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v9

    .line 56
    .local v9, "adsTimesNode":Lorg/w3c/dom/Node;
    if-eqz v9, :cond_1

    .line 57
    sget-object v11, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->AUDITUDE_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    .line 58
    invoke-interface {v9}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v10

    .line 59
    .local v10, "adsTimesValue":Ljava/lang/String;
    const-string v38, ","

    move-object/from16 v0, v38

    invoke-virtual {v10, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    .line 60
    .local v8, "adsTimes":[Ljava/lang/String;
    array-length v0, v8

    move/from16 v39, v0

    const/16 v38, 0x0

    :goto_1
    move/from16 v0, v38

    move/from16 v1, v39

    if-ge v0, v1, :cond_1

    aget-object v6, v8, v38
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .line 62
    .local v6, "adTime":Ljava/lang/String;
    :try_start_3
    move-object/from16 v0, p0

    invoke-direct {v0, v6}, Lcom/xfinity/playerlib/authorization/SMILParser;->convertAdsTime(Ljava/lang/String;)I

    move-result v40

    move-object/from16 v0, v36

    move/from16 v1, v40

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/authorization/SMILResource;->addAdsBreakStartTime(I)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    .line 60
    :goto_2
    add-int/lit8 v38, v38, 0x1

    goto :goto_1

    .line 63
    :catch_0
    move-exception v26

    .line 64
    .local v26, "e":Ljava/lang/Exception;
    :try_start_4
    sget-object v40, Lcom/xfinity/playerlib/authorization/SMILParser;->LOG:Lorg/slf4j/Logger;

    const-string v41, "Ad time parsing error...ignore"

    invoke-interface/range {v40 .. v41}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_2

    .line 105
    .end local v6    # "adTime":Ljava/lang/String;
    .end local v8    # "adsTimes":[Ljava/lang/String;
    .end local v9    # "adsTimesNode":Lorg/w3c/dom/Node;
    .end local v10    # "adsTimesValue":Ljava/lang/String;
    .end local v11    # "adsType":Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    .end local v12    # "baseUrl":Ljava/lang/String;
    .end local v19    # "builder":Ljavax/xml/parsers/DocumentBuilder;
    .end local v23    # "document":Lorg/w3c/dom/Document;
    .end local v24    # "duration":J
    .end local v26    # "e":Ljava/lang/Exception;
    .end local v28    # "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    .end local v30    # "meta":Lorg/w3c/dom/Node;
    .end local v31    # "metaList":Lorg/w3c/dom/NodeList;
    .end local v32    # "nodeMap":Lorg/w3c/dom/NamedNodeMap;
    .end local v33    # "ref":Lorg/w3c/dom/Node;
    .end local v34    # "refList":Lorg/w3c/dom/NodeList;
    .end local v35    # "refPath":Ljava/lang/String;
    .end local v36    # "smil":Lcom/xfinity/playerlib/authorization/SMILResource;
    .end local v37    # "stream":Ljava/io/ByteArrayInputStream;
    :catch_1
    move-exception v27

    .line 106
    .local v27, "ex":Ljava/lang/Exception;
    sget-object v38, Lcom/xfinity/playerlib/authorization/SMILParser;->LOG:Lorg/slf4j/Logger;

    const-string v39, "Unable to parse SMIL from thePlatform."

    move-object/from16 v0, v38

    move-object/from16 v1, v39

    move-object/from16 v2, v27

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 107
    throw v27

    .line 70
    .end local v27    # "ex":Ljava/lang/Exception;
    .restart local v9    # "adsTimesNode":Lorg/w3c/dom/Node;
    .restart local v11    # "adsType":Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    .restart local v12    # "baseUrl":Ljava/lang/String;
    .restart local v19    # "builder":Ljavax/xml/parsers/DocumentBuilder;
    .restart local v23    # "document":Lorg/w3c/dom/Document;
    .restart local v24    # "duration":J
    .restart local v28    # "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    .restart local v30    # "meta":Lorg/w3c/dom/Node;
    .restart local v31    # "metaList":Lorg/w3c/dom/NodeList;
    .restart local v32    # "nodeMap":Lorg/w3c/dom/NamedNodeMap;
    .restart local v33    # "ref":Lorg/w3c/dom/Node;
    .restart local v34    # "refList":Lorg/w3c/dom/NodeList;
    .restart local v35    # "refPath":Ljava/lang/String;
    .restart local v36    # "smil":Lcom/xfinity/playerlib/authorization/SMILResource;
    .restart local v37    # "stream":Ljava/io/ByteArrayInputStream;
    :cond_1
    :try_start_5
    const-string v38, "tp:BlackoutStartTimes"

    move-object/from16 v0, v32

    move-object/from16 v1, v38

    invoke-interface {v0, v1}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v14

    .line 71
    .local v14, "blackoutStartTimesNode":Lorg/w3c/dom/Node;
    const-string v38, "tp:BlackoutEndTimes"

    move-object/from16 v0, v32

    move-object/from16 v1, v38

    invoke-interface {v0, v1}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v13

    .line 72
    .local v13, "blackoutEndTimesNode":Lorg/w3c/dom/Node;
    if-eqz v13, :cond_4

    if-eqz v14, :cond_4

    .line 73
    sget-object v11, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->C3_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    .line 74
    invoke-interface {v14}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v16

    .line 75
    .local v16, "blockoutStartTimesValue":Ljava/lang/String;
    invoke-interface {v13}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v15

    .line 76
    .local v15, "blockoutEndTimesValue":Ljava/lang/String;
    const-string v38, ","

    move-object/from16 v0, v16

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v18

    .line 77
    .local v18, "boStartTimes":[Ljava/lang/String;
    const-string v38, ","

    move-object/from16 v0, v38

    invoke-virtual {v15, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v17

    .line 78
    .local v17, "boEndTimes":[Ljava/lang/String;
    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v38, v0

    move-object/from16 v0, v17

    array-length v0, v0

    move/from16 v39, v0

    move/from16 v0, v38

    move/from16 v1, v39

    if-lt v0, v1, :cond_3

    move-object/from16 v0, v17

    array-length v0, v0

    move/from16 v22, v0
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    .line 79
    .local v22, "count":I
    :goto_3
    const/16 v29, 0x0

    .local v29, "i":I
    :goto_4
    move/from16 v0, v29

    move/from16 v1, v22

    if-ge v0, v1, :cond_4

    .line 81
    :try_start_6
    aget-object v38, v18, v29

    move-object/from16 v0, p0

    move-object/from16 v1, v38

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/authorization/SMILParser;->convertAdsTime(Ljava/lang/String;)I

    move-result v21

    .line 82
    .local v21, "c3Start":I
    aget-object v38, v17, v29

    move-object/from16 v0, p0

    move-object/from16 v1, v38

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/authorization/SMILParser;->convertAdsTime(Ljava/lang/String;)I

    move-result v20

    .line 83
    .local v20, "c3End":I
    sub-int v38, v20, v21

    if-lez v38, :cond_2

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-wide/from16 v2, v24

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/authorization/SMILParser;->adStartsTooCloseToTotalDuration(IJ)Z

    move-result v38

    if-nez v38, :cond_2

    .line 85
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 86
    .local v7, "ads":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;>;"
    new-instance v4, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-direct {v4}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;-><init>()V

    .line 87
    .local v4, "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    move/from16 v0, v21

    int-to-long v0, v0

    move-wide/from16 v38, v0

    move-wide/from16 v0, v38

    invoke-virtual {v4, v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setStartTime(J)V

    .line 88
    sub-int v38, v20, v21

    move/from16 v0, v38

    int-to-long v0, v0

    move-wide/from16 v38, v0

    move-wide/from16 v0, v38

    invoke-virtual {v4, v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setDuration(J)V

    .line 89
    invoke-interface {v7, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 90
    new-instance v5, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    invoke-direct {v5}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;-><init>()V

    .line 91
    .local v5, "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    invoke-virtual {v5, v7}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->setVideoAdsList(Ljava/util/List;)V

    .line 92
    move/from16 v0, v21

    int-to-long v0, v0

    move-wide/from16 v38, v0

    move-wide/from16 v0, v38

    invoke-virtual {v5, v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->setStartTime(J)V

    .line 93
    sub-int v38, v21, v20

    move/from16 v0, v38

    int-to-long v0, v0

    move-wide/from16 v38, v0

    move-wide/from16 v0, v38

    invoke-virtual {v5, v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->setDuration(J)V

    .line 94
    move-object/from16 v0, v36

    invoke-virtual {v0, v5}, Lcom/xfinity/playerlib/authorization/SMILResource;->addC3Block(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2

    .line 79
    .end local v4    # "ad":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .end local v5    # "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .end local v7    # "ads":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;>;"
    .end local v20    # "c3End":I
    .end local v21    # "c3Start":I
    :cond_2
    :goto_5
    add-int/lit8 v29, v29, 0x1

    goto :goto_4

    .line 78
    .end local v22    # "count":I
    .end local v29    # "i":I
    :cond_3
    :try_start_7
    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v22, v0

    goto :goto_3

    .line 96
    .restart local v22    # "count":I
    .restart local v29    # "i":I
    :catch_2
    move-exception v26

    .line 97
    .restart local v26    # "e":Ljava/lang/Exception;
    sget-object v38, Lcom/xfinity/playerlib/authorization/SMILParser;->LOG:Lorg/slf4j/Logger;

    const-string v39, "C3 Ad time parsing error...ignore"

    invoke-interface/range {v38 .. v39}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    goto :goto_5

    .line 101
    .end local v15    # "blockoutEndTimesValue":Ljava/lang/String;
    .end local v16    # "blockoutStartTimesValue":Ljava/lang/String;
    .end local v17    # "boEndTimes":[Ljava/lang/String;
    .end local v18    # "boStartTimes":[Ljava/lang/String;
    .end local v22    # "count":I
    .end local v26    # "e":Ljava/lang/Exception;
    .end local v29    # "i":I
    :cond_4
    move-object/from16 v0, v36

    invoke-virtual {v0, v11}, Lcom/xfinity/playerlib/authorization/SMILResource;->setAdsType(Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1

    .line 103
    return-object v36

    .line 50
    .end local v9    # "adsTimesNode":Lorg/w3c/dom/Node;
    .end local v11    # "adsType":Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    .end local v13    # "blackoutEndTimesNode":Lorg/w3c/dom/Node;
    .end local v14    # "blackoutStartTimesNode":Lorg/w3c/dom/Node;
    :catch_3
    move-exception v38

    goto/16 :goto_0
.end method
