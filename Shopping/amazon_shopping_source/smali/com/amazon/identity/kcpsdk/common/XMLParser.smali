.class public Lcom/amazon/identity/kcpsdk/common/XMLParser;
.super Ljava/lang/Object;
.source "XMLParser.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mBytesToParse:Ljava/io/ByteArrayOutputStream;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/XMLParser;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/XMLParser;->mBytesToParse:Ljava/io/ByteArrayOutputStream;

    .line 27
    return-void
.end method


# virtual methods
.method public parseChunk([BJ)Z
    .locals 3
    .param p1, "xml"    # [B
    .param p2, "length"    # J

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/XMLParser;->mBytesToParse:Ljava/io/ByteArrayOutputStream;

    const/4 v1, 0x0

    long-to-int v2, p2

    invoke-virtual {v0, p1, v1, v2}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    .line 32
    const/4 v0, 0x1

    return v0
.end method

.method public parseEndOfDocument()Lorg/w3c/dom/Document;
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 37
    const/4 v1, 0x0

    .line 40
    .local v1, "doc":Lorg/w3c/dom/Document;
    :try_start_0
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v4

    .line 42
    const/4 v0, 0x0

    .local v0, "dbFactory":Ljavax/xml/parsers/DocumentBuilderFactory;
    invoke-virtual {v4}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;

    move-result-object v4

    .line 43
    new-instance v5, Ljava/io/ByteArrayInputStream;

    iget-object v6, p0, Lcom/amazon/identity/kcpsdk/common/XMLParser;->mBytesToParse:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v6}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-virtual {v4, v5}, Ljavax/xml/parsers/DocumentBuilder;->parse(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    :try_end_0
    .catch Ljavax/xml/parsers/ParserConfigurationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/xml/sax/SAXException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v1

    .line 66
    .end local v0    # "dbFactory":Ljavax/xml/parsers/DocumentBuilderFactory;
    :cond_0
    :goto_0
    return-object v1

    .line 45
    :catch_0
    move-exception v2

    .line 47
    .local v2, "e":Ljavax/xml/parsers/ParserConfigurationException;
    sget-object v4, Lcom/amazon/identity/kcpsdk/common/XMLParser;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Could not parse xml because of parser configuration issue: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljavax/xml/parsers/ParserConfigurationException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 49
    .end local v2    # "e":Ljavax/xml/parsers/ParserConfigurationException;
    :catch_1
    move-exception v4

    const/4 v2, 0x0

    .local v2, "e":Lorg/xml/sax/SAXException;
    invoke-virtual {v4}, Lorg/xml/sax/SAXException;->getMessage()Ljava/lang/String;

    move-result-object v3

    .line 52
    .local v3, "message":Ljava/lang/String;
    sget-object v4, Lcom/amazon/identity/kcpsdk/common/XMLParser;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Could not parse xml because it was invalid: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    const-string/jumbo v4, "RegistrationError:SAXException"

    new-array v5, v7, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 56
    const-string/jumbo v4, "Unexpected end of document"

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 58
    const-string/jumbo v4, "RegistrationError:SAXException:UnexpectedEndOfDocument"

    new-array v5, v7, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0

    .line 61
    .end local v2    # "e":Lorg/xml/sax/SAXException;
    .end local v3    # "message":Ljava/lang/String;
    :catch_2
    move-exception v2

    .line 63
    .local v2, "e":Ljava/io/IOException;
    sget-object v4, Lcom/amazon/identity/kcpsdk/common/XMLParser;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Could not parse xml because of an IOException: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
