.class public Lhb;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lhb;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lhb;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    return-void
.end method

.method public static a(Lorg/w3c/dom/Document;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 168
    :try_start_0
    new-instance v0, Ljava/io/StringWriter;

    invoke-direct {v0}, Ljava/io/StringWriter;-><init>()V

    .line 169
    invoke-static {}, Ljavax/xml/transform/TransformerFactory;->newInstance()Ljavax/xml/transform/TransformerFactory;

    move-result-object v1

    .line 170
    invoke-virtual {v1}, Ljavax/xml/transform/TransformerFactory;->newTransformer()Ljavax/xml/transform/Transformer;

    move-result-object v1

    .line 171
    const-string v2, "omit-xml-declaration"

    const-string v3, "no"

    invoke-virtual {v1, v2, v3}, Ljavax/xml/transform/Transformer;->setOutputProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 172
    const-string v2, "method"

    const-string v3, "xml"

    invoke-virtual {v1, v2, v3}, Ljavax/xml/transform/Transformer;->setOutputProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 173
    const-string v2, "indent"

    const-string v3, "yes"

    invoke-virtual {v1, v2, v3}, Ljavax/xml/transform/Transformer;->setOutputProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    const-string v2, "encoding"

    const-string v3, "UTF-8"

    invoke-virtual {v1, v2, v3}, Ljavax/xml/transform/Transformer;->setOutputProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    new-instance v2, Ljavax/xml/transform/dom/DOMSource;

    invoke-direct {v2, p0}, Ljavax/xml/transform/dom/DOMSource;-><init>(Lorg/w3c/dom/Node;)V

    new-instance v3, Ljavax/xml/transform/stream/StreamResult;

    invoke-direct {v3, v0}, Ljavax/xml/transform/stream/StreamResult;-><init>(Ljava/io/Writer;)V

    invoke-virtual {v1, v2, v3}, Ljavax/xml/transform/Transformer;->transform(Ljavax/xml/transform/Source;Ljavax/xml/transform/Result;)V

    .line 177
    invoke-virtual {v0}, Ljava/io/StringWriter;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 178
    :catch_0
    move-exception v0

    .line 179
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Error converting to String"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public static a(Lorg/w3c/dom/Node;)V
    .locals 4

    .prologue
    .line 41
    sget-object v0, Lhb;->a:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, " nodeName=\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getNamespaceURI()Ljava/lang/String;

    move-result-object v0

    .line 44
    if-eqz v0, :cond_0

    .line 45
    sget-object v1, Lhb;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, " uri=\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    :cond_0
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getPrefix()Ljava/lang/String;

    move-result-object v0

    .line 50
    if-eqz v0, :cond_1

    .line 51
    sget-object v1, Lhb;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, " pre=\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    :cond_1
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getLocalName()Ljava/lang/String;

    move-result-object v0

    .line 55
    if-eqz v0, :cond_2

    .line 56
    sget-object v1, Lhb;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, " local=\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    :cond_2
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v0

    .line 60
    if-eqz v0, :cond_3

    .line 61
    sget-object v1, Lhb;->a:Ljava/lang/String;

    const-string v2, " nodeValue="

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 64
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, "[WS]"

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    :cond_3
    :goto_0
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, ""

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    return-void

    .line 67
    :cond_4
    sget-object v0, Lhb;->a:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p0}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static b(Lorg/w3c/dom/Node;)V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 74
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v0

    .line 76
    packed-switch v0, :pswitch_data_0

    .line 149
    sget-object v1, Lhb;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "UNSUPPORTED NODE: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    .line 153
    :cond_0
    :goto_0
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v0

    :goto_1
    if-eqz v0, :cond_1

    .line 155
    invoke-static {v0}, Lhb;->b(Lorg/w3c/dom/Node;)V

    .line 154
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNextSibling()Lorg/w3c/dom/Node;

    move-result-object v0

    goto :goto_1

    .line 78
    :pswitch_0
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, "ATTR:"

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    goto :goto_0

    .line 83
    :pswitch_1
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, "CDATA:"

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    goto :goto_0

    .line 88
    :pswitch_2
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, "COMM:"

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    goto :goto_0

    .line 93
    :pswitch_3
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, "DOC_FRAG:"

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    goto :goto_0

    .line 98
    :pswitch_4
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, "DOC:"

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    goto :goto_0

    .line 103
    :pswitch_5
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v2, "DOC_TYPE:"

    invoke-static {v0, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    move-object v0, p0

    .line 105
    check-cast v0, Lorg/w3c/dom/DocumentType;

    invoke-interface {v0}, Lorg/w3c/dom/DocumentType;->getEntities()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v2

    .line 106
    :goto_2
    invoke-interface {v2}, Lorg/w3c/dom/NamedNodeMap;->getLength()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 107
    invoke-interface {v2, v1}, Lorg/w3c/dom/NamedNodeMap;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    check-cast v0, Lorg/w3c/dom/Entity;

    .line 108
    invoke-static {v0}, Lhb;->b(Lorg/w3c/dom/Node;)V

    .line 106
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_2

    .line 113
    :pswitch_6
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v2, "ELEM:"

    invoke-static {v0, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    .line 116
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v0

    .line 117
    :goto_3
    invoke-interface {v0}, Lorg/w3c/dom/NamedNodeMap;->getLength()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 118
    invoke-interface {v0, v1}, Lorg/w3c/dom/NamedNodeMap;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 119
    invoke-static {v2}, Lhb;->b(Lorg/w3c/dom/Node;)V

    .line 117
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 124
    :pswitch_7
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, "ENT:"

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    goto/16 :goto_0

    .line 129
    :pswitch_8
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, "ENT_REF:"

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    goto/16 :goto_0

    .line 134
    :pswitch_9
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, "NOTATION:"

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    goto/16 :goto_0

    .line 139
    :pswitch_a
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, "PROC_INST:"

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    goto/16 :goto_0

    .line 144
    :pswitch_b
    sget-object v0, Lhb;->a:Ljava/lang/String;

    const-string v1, "TEXT:"

    invoke-static {v0, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    invoke-static {p0}, Lhb;->a(Lorg/w3c/dom/Node;)V

    goto/16 :goto_0

    .line 157
    :cond_1
    return-void

    .line 76
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_6
        :pswitch_0
        :pswitch_b
        :pswitch_1
        :pswitch_8
        :pswitch_7
        :pswitch_a
        :pswitch_2
        :pswitch_4
        :pswitch_5
        :pswitch_3
        :pswitch_9
    .end packed-switch
.end method
