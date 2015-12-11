.class public final Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser;
.super Ljava/lang/Object;
.source "BatchCredentialsParser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    return-void
.end method

.method public static parseBatchCredentialsResponse(Lorg/w3c/dom/Element;)Ljava/util/Map;
    .locals 23
    .param p0, "deviceCredentialsNode"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/w3c/dom/Element;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 88
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 94
    .local v6, "credentials":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    new-instance v15, Ljava/util/LinkedList;

    invoke-direct {v15}, Ljava/util/LinkedList;-><init>()V

    .line 96
    .local v15, "refList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;>;"
    if-nez p0, :cond_1

    .line 169
    :cond_0
    return-object v6

    .line 101
    :cond_1
    invoke-interface/range {p0 .. p0}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v3

    .line 103
    .local v3, "children":Lorg/w3c/dom/NodeList;
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_0
    invoke-interface {v3}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v19

    move/from16 v0, v19

    if-ge v10, v0, :cond_6

    .line 105
    invoke-interface {v3, v10}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v8

    .line 106
    .local v8, "credentialsNode":Lorg/w3c/dom/Node;
    invoke-interface {v8}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v19

    const/16 v20, 0x1

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_5

    move-object v7, v8

    .line 108
    check-cast v7, Lorg/w3c/dom/Element;

    .line 112
    .local v7, "credentialsEle":Lorg/w3c/dom/Element;
    const-string/jumbo v19, "deviceType"

    move-object/from16 v0, v19

    invoke-interface {v7, v0}, Lorg/w3c/dom/Element;->hasAttribute(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_5

    .line 116
    const-string/jumbo v19, "deviceType"

    move-object/from16 v0, v19

    invoke-interface {v7, v0}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 120
    .local v9, "deviceType":Ljava/lang/String;
    invoke-interface {v6, v9}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v19

    if-nez v19, :cond_3

    .line 123
    new-instance v13, Ljava/util/HashMap;

    invoke-direct {v13}, Ljava/util/HashMap;-><init>()V

    .line 124
    .local v13, "perDeviceTypeMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v6, v9, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    :goto_1
    invoke-interface {v8}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v5

    .line 132
    .local v5, "credentialListForDeviceType":Lorg/w3c/dom/NodeList;
    const/4 v12, 0x0

    .local v12, "j":I
    :goto_2
    invoke-interface {v5}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v19

    move/from16 v0, v19

    if-ge v12, v0, :cond_5

    .line 134
    invoke-interface {v5, v12}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v18

    .line 135
    .local v18, "specificCredentialNode":Lorg/w3c/dom/Node;
    invoke-interface/range {v18 .. v18}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v19

    const/16 v20, 0x1

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_2

    move-object/from16 v17, v18

    .line 137
    check-cast v17, Lorg/w3c/dom/Element;

    .line 147
    .local v17, "specificCredentialEle":Lorg/w3c/dom/Element;
    const-string/jumbo v19, "refDeviceType"

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Lorg/w3c/dom/Element;->hasAttribute(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_4

    .line 149
    const-string/jumbo v19, "refDeviceType"

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 151
    .local v16, "referenceDeviceType":Ljava/lang/String;
    new-instance v19, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;

    invoke-interface/range {v18 .. v18}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    move-object/from16 v2, v16

    invoke-direct {v0, v9, v1, v2}, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v19

    invoke-interface {v15, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 132
    .end local v16    # "referenceDeviceType":Ljava/lang/String;
    .end local v17    # "specificCredentialEle":Lorg/w3c/dom/Element;
    :cond_2
    :goto_3
    add-int/lit8 v12, v12, 0x1

    goto :goto_2

    .line 128
    .end local v5    # "credentialListForDeviceType":Lorg/w3c/dom/NodeList;
    .end local v12    # "j":I
    .end local v13    # "perDeviceTypeMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v18    # "specificCredentialNode":Lorg/w3c/dom/Node;
    :cond_3
    invoke-interface {v6, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/Map;

    .restart local v13    # "perDeviceTypeMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    goto :goto_1

    .restart local v5    # "credentialListForDeviceType":Lorg/w3c/dom/NodeList;
    .restart local v12    # "j":I
    .restart local v17    # "specificCredentialEle":Lorg/w3c/dom/Element;
    .restart local v18    # "specificCredentialNode":Lorg/w3c/dom/Node;
    :cond_4
    move-object/from16 v19, v18

    .line 157
    check-cast v19, Lorg/w3c/dom/Element;

    invoke-static/range {v19 .. v19}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v4

    .line 158
    .local v4, "credentialBlob":Ljava/lang/String;
    invoke-interface/range {v18 .. v18}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-interface {v13, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    .line 103
    .end local v4    # "credentialBlob":Ljava/lang/String;
    .end local v5    # "credentialListForDeviceType":Lorg/w3c/dom/NodeList;
    .end local v7    # "credentialsEle":Lorg/w3c/dom/Element;
    .end local v9    # "deviceType":Ljava/lang/String;
    .end local v12    # "j":I
    .end local v13    # "perDeviceTypeMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v17    # "specificCredentialEle":Lorg/w3c/dom/Element;
    .end local v18    # "specificCredentialNode":Lorg/w3c/dom/Node;
    :cond_5
    add-int/lit8 v10, v10, 0x1

    goto/16 :goto_0

    .line 163
    .end local v8    # "credentialsNode":Lorg/w3c/dom/Node;
    :cond_6
    invoke-interface {v15}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .local v11, "i$":Ljava/util/Iterator;
    :goto_4
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v19

    if-eqz v19, :cond_0

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;

    .line 165
    .local v14, "refInfo":Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;
    invoke-virtual {v14}, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-interface {v6, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/util/Map;

    .line 166
    invoke-virtual {v14}, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;->getCredentialType()Ljava/lang/String;

    move-result-object v21

    invoke-virtual {v14}, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;->getReferenceDeviceType()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-interface {v6, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/util/Map;

    invoke-virtual {v14}, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;->getCredentialType()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v20

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v21

    move-object/from16 v2, v20

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_4
.end method
