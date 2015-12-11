.class public Lcom/xfinity/playerlib/model/dibic/DibicParser;
.super Ljava/lang/Object;
.source "DibicParser.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected createProgramStreamFromBuffer([B)Lorg/apache/commons/io/input/SwappedDataInputStream;
    .locals 2
    .param p1, "buffer"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 90
    new-instance v0, Lorg/apache/commons/io/input/SwappedDataInputStream;

    new-instance v1, Ljava/io/ByteArrayInputStream;

    invoke-direct {v1, p1}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-direct {v0, v1}, Lorg/apache/commons/io/input/SwappedDataInputStream;-><init>(Ljava/io/InputStream;)V

    return-object v0
.end method

.method public getPrograms(Lorg/apache/commons/io/input/SwappedDataInputStream;Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Ljava/util/List;
    .locals 24
    .param p1, "inputStream"    # Lorg/apache/commons/io/input/SwappedDataInputStream;
    .param p2, "programFactory"    # Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;
    .param p3, "tagsRoot"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/apache/commons/io/input/SwappedDataInputStream;",
            "Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 20
    :try_start_0
    invoke-virtual/range {p1 .. p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v11

    .line 21
    .local v11, "programCount":I
    new-instance v12, Ljava/util/LinkedHashMap;

    invoke-direct {v12}, Ljava/util/LinkedHashMap;-><init>()V

    .line 23
    .local v12, "programMap":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Lcom/xfinity/playerlib/model/MerlinId;Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-virtual/range {p1 .. p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v15

    .line 24
    .local v15, "recordSize":I
    new-array v3, v15, [B

    .line 26
    .local v3, "buffer":[B
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    if-ge v7, v11, :cond_1

    .line 27
    invoke-interface/range {p2 .. p2}, Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;->create()Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v10

    .line 28
    .local v10, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Lorg/apache/commons/io/input/SwappedDataInputStream;->read([B)I

    .line 29
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/xfinity/playerlib/model/dibic/DibicParser;->createProgramStreamFromBuffer([B)Lorg/apache/commons/io/input/SwappedDataInputStream;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v10, v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->parse(Lorg/apache/commons/io/input/SwappedDataInputStream;)V

    .line 31
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Set;

    .line 32
    .local v6, "existingPrograms":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    if-nez v6, :cond_0

    .line 33
    new-instance v6, Ljava/util/HashSet;

    .end local v6    # "existingPrograms":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-direct {v6}, Ljava/util/HashSet;-><init>()V

    .line 36
    .restart local v6    # "existingPrograms":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_0
    invoke-interface {v6, v10}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 37
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0, v6}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 40
    .end local v6    # "existingPrograms":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .end local v10    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_1
    invoke-virtual/range {p1 .. p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v17

    .line 41
    .local v17, "tokenCount":I
    move/from16 v0, v17

    new-array v0, v0, [I

    move-object/from16 v18, v0

    .line 43
    .local v18, "tokens":[I
    const/4 v8, 0x0

    .local v8, "j":I
    :goto_1
    move/from16 v0, v17

    if-ge v8, v0, :cond_2

    .line 44
    invoke-virtual/range {p1 .. p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v21

    aput v21, v18, v8

    .line 43
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 47
    :cond_2
    invoke-virtual/range {p1 .. p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v19

    .line 48
    .local v19, "wordCount":I
    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v20, v0

    .line 50
    .local v20, "words":[Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    .line 52
    new-instance v21, Ljava/util/Scanner;

    const-string v22, "UTF-8"

    move-object/from16 v0, v21

    move-object/from16 v1, p1

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Ljava/util/Scanner;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    const-string v22, "\u0000"

    invoke-virtual/range {v21 .. v22}, Ljava/util/Scanner;->useDelimiter(Ljava/lang/String;)Ljava/util/Scanner;

    move-result-object v16

    .line 53
    .local v16, "scanner":Ljava/util/Scanner;
    const/4 v7, 0x0

    :goto_2
    move/from16 v0, v19

    if-ge v7, v0, :cond_3

    invoke-virtual/range {v16 .. v16}, Ljava/util/Scanner;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_3

    .line 54
    invoke-virtual/range {v16 .. v16}, Ljava/util/Scanner;->next()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v20, v7

    .line 53
    add-int/lit8 v7, v7, 0x1

    goto :goto_2

    .line 57
    :cond_3
    new-instance v14, Ljava/util/ArrayList;

    invoke-direct {v14}, Ljava/util/ArrayList;-><init>()V

    .line 58
    .local v14, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    new-instance v4, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-direct {v4, v0, v1}, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;-><init>([I[Ljava/lang/String;)V

    .line 60
    .local v4, "dictionary":Lcom/xfinity/playerlib/model/dibic/DibicDictionary;
    invoke-virtual {v12}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v21

    invoke-interface/range {v21 .. v21}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v21

    :cond_4
    :goto_3
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->hasNext()Z

    move-result v22

    if-eqz v22, :cond_8

    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/Set;

    .line 61
    .local v13, "programSet":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    const/4 v9, 0x0

    .line 62
    .local v9, "mergedProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-interface {v13}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v22

    :cond_5
    :goto_4
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_7

    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 64
    .restart local v10    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-virtual {v10, v4}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->setDictionary(Lcom/xfinity/playerlib/model/dibic/DibicDictionary;)V

    .line 65
    move-object/from16 v0, p3

    invoke-virtual {v10, v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->setTagsRoot(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)V

    .line 67
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lcom/xfinity/playerlib/model/dibic/DibicParser;->isProgramValid(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z

    move-result v23

    if-eqz v23, :cond_5

    .line 68
    if-nez v9, :cond_6

    .line 69
    move-object v9, v10

    goto :goto_4

    .line 72
    :cond_6
    invoke-virtual {v9, v10}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->merge(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_4

    .line 84
    .end local v3    # "buffer":[B
    .end local v4    # "dictionary":Lcom/xfinity/playerlib/model/dibic/DibicDictionary;
    .end local v7    # "i":I
    .end local v8    # "j":I
    .end local v9    # "mergedProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .end local v10    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .end local v11    # "programCount":I
    .end local v12    # "programMap":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Lcom/xfinity/playerlib/model/MerlinId;Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    .end local v13    # "programSet":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .end local v14    # "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .end local v15    # "recordSize":I
    .end local v16    # "scanner":Ljava/util/Scanner;
    .end local v17    # "tokenCount":I
    .end local v18    # "tokens":[I
    .end local v19    # "wordCount":I
    .end local v20    # "words":[Ljava/lang/String;
    :catch_0
    move-exception v5

    .line 85
    .local v5, "e":Ljava/io/IOException;
    new-instance v21, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    move-object/from16 v0, v21

    invoke-direct {v0, v5}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v21

    .line 77
    .end local v5    # "e":Ljava/io/IOException;
    .restart local v3    # "buffer":[B
    .restart local v4    # "dictionary":Lcom/xfinity/playerlib/model/dibic/DibicDictionary;
    .restart local v7    # "i":I
    .restart local v8    # "j":I
    .restart local v9    # "mergedProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .restart local v11    # "programCount":I
    .restart local v12    # "programMap":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Lcom/xfinity/playerlib/model/MerlinId;Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    .restart local v13    # "programSet":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .restart local v14    # "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .restart local v15    # "recordSize":I
    .restart local v16    # "scanner":Ljava/util/Scanner;
    .restart local v17    # "tokenCount":I
    .restart local v18    # "tokens":[I
    .restart local v19    # "wordCount":I
    .restart local v20    # "words":[Ljava/lang/String;
    :cond_7
    if-eqz v9, :cond_4

    .line 78
    :try_start_1
    invoke-virtual {v9}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->populateStrings()V

    .line 79
    invoke-interface {v14, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_3

    .line 83
    .end local v9    # "mergedProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .end local v13    # "programSet":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_8
    return-object v14
.end method

.method protected isProgramValid(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z
    .locals 1
    .param p1, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 94
    const/4 v0, 0x1

    return v0
.end method
