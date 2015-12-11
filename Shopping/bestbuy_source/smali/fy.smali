.class public Lfy;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-class v0, Lfy;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lfy;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    return-void
.end method

.method public static a(Lft;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 100
    invoke-static {p0}, Lfy;->a(Lft;)Lfz;

    move-result-object v1

    .line 101
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Lfz;->a()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/commerce/giftcard?apiKey="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Lfz;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 102
    const-string v2, ""

    .line 104
    const-string v2, ""

    .line 105
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v2

    .line 106
    invoke-virtual {v2}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;

    move-result-object v2

    .line 107
    invoke-virtual {v2}, Ljavax/xml/parsers/DocumentBuilder;->newDocument()Lorg/w3c/dom/Document;

    move-result-object v2

    .line 108
    const-string v3, "balance-query"

    invoke-interface {v2, v3}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v3

    .line 109
    invoke-interface {v2, v3}, Lorg/w3c/dom/Document;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 111
    const-string v4, "gift-card"

    invoke-interface {v2, v4}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v4

    .line 112
    const-string v5, "card-num"

    invoke-interface {v4, v5, p1}, Lorg/w3c/dom/Element;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    const-string v5, "pin"

    invoke-interface {v4, v5, p2}, Lorg/w3c/dom/Element;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    invoke-interface {v3, v4}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 116
    invoke-static {v2}, Lhb;->a(Lorg/w3c/dom/Document;)Ljava/lang/String;

    move-result-object v2

    .line 117
    const-string v3, "application/xml"

    invoke-static {v1, v0, v0, v2, v3}, Lgw;->b(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 118
    if-eqz v1, :cond_0

    .line 119
    invoke-static {v1}, Lfy;->a(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;

    move-result-object v0

    .line 121
    :cond_0
    return-object v0
.end method

.method private static a(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;
    .locals 10

    .prologue
    const/4 v1, 0x0

    const/4 v3, 0x1

    .line 156
    const-string v0, ""

    .line 157
    new-instance v4, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;-><init>()V

    .line 158
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v5

    .line 160
    :try_start_0
    const-string v0, "http://xmlpull.org/v1/doc/features.html#process-namespaces"

    const/4 v2, 0x0

    invoke-interface {v5, v0, v2}, Lorg/xmlpull/v1/XmlPullParser;->setFeature(Ljava/lang/String;Z)V

    .line 161
    new-instance v0, Ljava/io/StringReader;

    invoke-direct {v0, p0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-interface {v5, v0}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 162
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    move v2, v0

    move v0, v1

    .line 164
    :goto_0
    if-eq v2, v3, :cond_3

    if-nez v0, :cond_3

    .line 165
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v6

    .line 166
    packed-switch v2, :pswitch_data_0

    .line 195
    :cond_0
    :goto_1
    :pswitch_0
    if-eqz v0, :cond_5

    move v2, v3

    .line 196
    goto :goto_0

    .line 170
    :pswitch_1
    const-string v2, "gift-card"

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 171
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v6

    move v2, v1

    .line 172
    :goto_2
    if-ge v2, v6, :cond_4

    .line 173
    invoke-interface {v5, v2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v7

    .line 174
    invoke-interface {v5, v2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v8

    .line 175
    const-string v9, "card-num"

    invoke-virtual {v7, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 176
    invoke-virtual {v4, v8}, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->setCardNumber(Ljava/lang/String;)V

    .line 172
    :cond_1
    :goto_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 177
    :cond_2
    const-string v9, "currency"

    invoke-virtual {v7, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 178
    invoke-virtual {v4, v8}, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->setCurrency(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    goto :goto_3

    .line 200
    :catch_0
    move-exception v0

    .line 201
    sget-object v1, Lfy;->a:Ljava/lang/String;

    invoke-static {v1, v0}, Lgs;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 207
    :cond_3
    :goto_4
    return-object v4

    .line 180
    :cond_4
    :try_start_1
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v2

    .line 181
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_0

    .line 182
    invoke-static {v2}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->setValue(D)V
    :try_end_1
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    goto :goto_1

    .line 202
    :catch_1
    move-exception v0

    .line 203
    sget-object v1, Lfy;->a:Ljava/lang/String;

    invoke-static {v1, v0}, Lgs;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_4

    .line 187
    :pswitch_2
    :try_start_2
    const-string v2, "gift-card"

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    move v0, v3

    .line 188
    goto :goto_1

    :pswitch_3
    move v0, v3

    .line 192
    goto :goto_1

    .line 198
    :cond_5
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I
    :try_end_2
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    move-result v2

    goto :goto_0

    .line 204
    :catch_2
    move-exception v0

    .line 205
    sget-object v1, Lfy;->a:Ljava/lang/String;

    invoke-static {v1, v0}, Lgs;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_4

    .line 166
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_3
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private static a(Lft;)Lfz;
    .locals 1

    .prologue
    .line 64
    sget-object v0, Lft;->a:Lft;

    if-ne p0, v0, :cond_0

    .line 65
    sget-object v0, Lfz;->a:Lfz;

    .line 75
    :goto_0
    return-object v0

    .line 66
    :cond_0
    sget-object v0, Lft;->b:Lft;

    if-ne p0, v0, :cond_1

    .line 67
    sget-object v0, Lfz;->e:Lfz;

    goto :goto_0

    .line 68
    :cond_1
    sget-object v0, Lft;->e:Lft;

    if-ne p0, v0, :cond_2

    .line 69
    sget-object v0, Lfz;->b:Lfz;

    goto :goto_0

    .line 70
    :cond_2
    sget-object v0, Lft;->g:Lft;

    if-ne p0, v0, :cond_3

    .line 71
    sget-object v0, Lfz;->c:Lfz;

    goto :goto_0

    .line 72
    :cond_3
    sget-object v0, Lft;->h:Lft;

    if-ne p0, v0, :cond_4

    .line 73
    sget-object v0, Lfz;->d:Lfz;

    goto :goto_0

    .line 75
    :cond_4
    sget-object v0, Lfz;->a:Lfz;

    goto :goto_0
.end method
