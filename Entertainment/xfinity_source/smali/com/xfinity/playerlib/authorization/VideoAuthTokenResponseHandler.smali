.class public Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;
.super Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.source "VideoAuthTokenResponseHandler.java"


# instance fields
.field private videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;-><init>()V

    .line 21
    new-instance v0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-direct {v0}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    .line 24
    invoke-virtual {p0}, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->addDefaultHeaderHandlers()V

    .line 25
    return-void
.end method


# virtual methods
.method public getVideoAuthToken()Lcom/xfinity/playerlib/authorization/VideoAuthToken;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    return-object v0
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 13
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    const/4 v11, 0x0

    .line 34
    new-instance v9, Ljava/io/StringWriter;

    invoke-direct {v9}, Ljava/io/StringWriter;-><init>()V

    .line 36
    .local v9, "writer":Ljava/io/StringWriter;
    :try_start_0
    const-string v10, "UTF-8"

    invoke-static {p1, v9, v10}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/Writer;Ljava/lang/String;)V

    .line 37
    invoke-virtual {v9}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v8

    .line 38
    .local v8, "videoAuthTokenString":Ljava/lang/String;
    const-string v10, "\n"

    invoke-static {v8, v10}, Lorg/apache/commons/lang3/StringUtils;->remove(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 39
    iget-object v10, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-virtual {v10, v8}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->setRawData(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 44
    if-eqz v8, :cond_10

    .line 46
    :try_start_1
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v5

    .line 47
    .local v5, "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    invoke-virtual {v5}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;

    move-result-object v0

    .line 48
    .local v0, "builder":Ljavax/xml/parsers/DocumentBuilder;
    new-instance v7, Lorg/xml/sax/InputSource;

    new-instance v10, Ljava/io/StringReader;

    invoke-direct {v10, v8}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-direct {v7, v10}, Lorg/xml/sax/InputSource;-><init>(Ljava/io/Reader;)V

    .line 49
    .local v7, "inputSource":Lorg/xml/sax/InputSource;
    invoke-virtual {v0, v7}, Ljavax/xml/parsers/DocumentBuilder;->parse(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;

    move-result-object v3

    .line 51
    .local v3, "doc":Lorg/w3c/dom/Document;
    if-eqz v3, :cond_10

    invoke-interface {v3}, Lorg/w3c/dom/Document;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    if-eqz v10, :cond_10

    .line 52
    invoke-interface {v3}, Lorg/w3c/dom/Document;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    invoke-interface {v10}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v2

    .line 53
    .local v2, "childNodes":Lorg/w3c/dom/NodeList;
    if-eqz v2, :cond_10

    .line 54
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    invoke-interface {v2}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v10

    if-ge v6, v10, :cond_10

    .line 55
    invoke-interface {v2, v6}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 56
    .local v1, "child":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v12, "resourceID"

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_2

    .line 57
    iget-object v12, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    if-eqz v10, :cond_1

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    invoke-interface {v10}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v10

    :goto_1
    invoke-virtual {v12, v10}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->setResourceID(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 54
    :cond_0
    :goto_2
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 40
    .end local v0    # "builder":Ljavax/xml/parsers/DocumentBuilder;
    .end local v1    # "child":Lorg/w3c/dom/Node;
    .end local v2    # "childNodes":Lorg/w3c/dom/NodeList;
    .end local v3    # "doc":Lorg/w3c/dom/Document;
    .end local v5    # "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    .end local v6    # "i":I
    .end local v7    # "inputSource":Lorg/xml/sax/InputSource;
    .end local v8    # "videoAuthTokenString":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 41
    .local v4, "e":Ljava/io/IOException;
    new-instance v10, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v10, v4}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v10

    .end local v4    # "e":Ljava/io/IOException;
    .restart local v0    # "builder":Ljavax/xml/parsers/DocumentBuilder;
    .restart local v1    # "child":Lorg/w3c/dom/Node;
    .restart local v2    # "childNodes":Lorg/w3c/dom/NodeList;
    .restart local v3    # "doc":Lorg/w3c/dom/Document;
    .restart local v5    # "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    .restart local v6    # "i":I
    .restart local v7    # "inputSource":Lorg/xml/sax/InputSource;
    .restart local v8    # "videoAuthTokenString":Ljava/lang/String;
    :cond_1
    move-object v10, v11

    .line 57
    goto :goto_1

    .line 58
    :cond_2
    :try_start_2
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v12, "titleID"

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_4

    .line 59
    iget-object v12, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    if-eqz v10, :cond_3

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    invoke-interface {v10}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v10

    :goto_3
    invoke-virtual {v12, v10}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->setTitleID(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_2

    .line 76
    .end local v0    # "builder":Ljavax/xml/parsers/DocumentBuilder;
    .end local v1    # "child":Lorg/w3c/dom/Node;
    .end local v2    # "childNodes":Lorg/w3c/dom/NodeList;
    .end local v3    # "doc":Lorg/w3c/dom/Document;
    .end local v5    # "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    .end local v6    # "i":I
    .end local v7    # "inputSource":Lorg/xml/sax/InputSource;
    :catch_1
    move-exception v4

    .line 77
    .local v4, "e":Ljava/lang/Exception;
    new-instance v10, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v10, v4}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v10

    .end local v4    # "e":Ljava/lang/Exception;
    .restart local v0    # "builder":Ljavax/xml/parsers/DocumentBuilder;
    .restart local v1    # "child":Lorg/w3c/dom/Node;
    .restart local v2    # "childNodes":Lorg/w3c/dom/NodeList;
    .restart local v3    # "doc":Lorg/w3c/dom/Document;
    .restart local v5    # "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    .restart local v6    # "i":I
    .restart local v7    # "inputSource":Lorg/xml/sax/InputSource;
    :cond_3
    move-object v10, v11

    .line 59
    goto :goto_3

    .line 60
    :cond_4
    :try_start_3
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v12, "requestorID"

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_6

    .line 61
    iget-object v12, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    if-eqz v10, :cond_5

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    invoke-interface {v10}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v10

    :goto_4
    invoke-virtual {v12, v10}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->setRequestorID(Ljava/lang/String;)V

    goto :goto_2

    :cond_5
    move-object v10, v11

    goto :goto_4

    .line 62
    :cond_6
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v12, "issueTime"

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_8

    .line 63
    iget-object v12, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    if-eqz v10, :cond_7

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    invoke-interface {v10}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v10

    :goto_5
    invoke-virtual {v12, v10}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->setIssueTime(Ljava/lang/String;)V

    goto :goto_2

    :cond_7
    move-object v10, v11

    goto :goto_5

    .line 64
    :cond_8
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v12, "ttl"

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_a

    .line 65
    iget-object v12, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    if-eqz v10, :cond_9

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    invoke-interface {v10}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v10

    :goto_6
    invoke-virtual {v12, v10}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->setTtl(Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_9
    move-object v10, v11

    goto :goto_6

    .line 66
    :cond_a
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v12, "opaqueUserID"

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_c

    .line 67
    iget-object v12, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    if-eqz v10, :cond_b

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    invoke-interface {v10}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v10

    :goto_7
    invoke-virtual {v12, v10}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->setOpaqueUserID(Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_b
    move-object v10, v11

    goto :goto_7

    .line 68
    :cond_c
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v12, "keyName"

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_e

    .line 69
    iget-object v12, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    if-eqz v10, :cond_d

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    invoke-interface {v10}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v10

    :goto_8
    invoke-virtual {v12, v10}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->setKeyName(Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_d
    move-object v10, v11

    goto :goto_8

    .line 70
    :cond_e
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v10

    const-string v12, "value"

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_0

    .line 71
    iget-object v12, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->videoAuthToken:Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    if-eqz v10, :cond_f

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v10

    invoke-interface {v10}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v10

    :goto_9
    invoke-virtual {v12, v10}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->setValue(Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_2

    :cond_f
    move-object v10, v11

    goto :goto_9

    .line 80
    .end local v0    # "builder":Ljavax/xml/parsers/DocumentBuilder;
    .end local v1    # "child":Lorg/w3c/dom/Node;
    .end local v2    # "childNodes":Lorg/w3c/dom/NodeList;
    .end local v3    # "doc":Lorg/w3c/dom/Document;
    .end local v5    # "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    .end local v6    # "i":I
    .end local v7    # "inputSource":Lorg/xml/sax/InputSource;
    :cond_10
    return-void
.end method
