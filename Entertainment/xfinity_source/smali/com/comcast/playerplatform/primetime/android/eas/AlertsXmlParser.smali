.class public Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;
.super Ljava/lang/Object;
.source "AlertsXmlParser.java"


# static fields
.field private static final namespace:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x0

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->namespace:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static parseAlertXML(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 6
    .param p0, "response"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/eas/Alert;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 54
    const/4 v1, 0x0

    .line 56
    .local v1, "parsedResult":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/comcast/playerplatform/primetime/android/eas/Alert;>;"
    :try_start_0
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 58
    .local v2, "parser":Lorg/xmlpull/v1/XmlPullParser;
    new-instance v3, Ljava/io/StringReader;

    invoke-direct {v3, p0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    .line 59
    .local v3, "responseReader":Ljava/io/StringReader;
    const-string v4, "http://xmlpull.org/v1/doc/features.html#process-namespaces"

    const/4 v5, 0x0

    invoke-interface {v2, v4, v5}, Lorg/xmlpull/v1/XmlPullParser;->setFeature(Ljava/lang/String;Z)V

    .line 60
    invoke-interface {v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 61
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    .line 62
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readAlertXML(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 66
    .end local v2    # "parser":Lorg/xmlpull/v1/XmlPullParser;
    .end local v3    # "responseReader":Ljava/io/StringReader;
    :goto_0
    return-object v1

    .line 63
    :catch_0
    move-exception v0

    .line 64
    .local v0, "ex":Ljava/lang/Exception;
    const-string v4, "error"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static parseFipsCodeResponse(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "response"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 70
    const-string v1, ""

    .line 72
    .local v1, "fipsCode":Ljava/lang/String;
    :try_start_0
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 74
    .local v2, "parser":Lorg/xmlpull/v1/XmlPullParser;
    new-instance v3, Ljava/io/StringReader;

    invoke-direct {v3, p0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    .line 75
    .local v3, "responseReader":Ljava/io/StringReader;
    const-string v4, "http://xmlpull.org/v1/doc/features.html#process-namespaces"

    const/4 v5, 0x0

    invoke-interface {v2, v4, v5}, Lorg/xmlpull/v1/XmlPullParser;->setFeature(Ljava/lang/String;Z)V

    .line 76
    invoke-interface {v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 77
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    .line 78
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readLocationXML(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 82
    .end local v2    # "parser":Lorg/xmlpull/v1/XmlPullParser;
    .end local v3    # "responseReader":Ljava/io/StringReader;
    :goto_0
    return-object v1

    .line 79
    :catch_0
    move-exception v0

    .line 80
    .local v0, "ex":Ljava/lang/Exception;
    const-string v4, "error"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private static readAlert(Lorg/xmlpull/v1/XmlPullParser;)Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    .locals 5
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x2

    .line 181
    sget-object v2, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->namespace:Ljava/lang/String;

    const-string v3, "alert"

    invoke-interface {p0, v4, v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 182
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 183
    .local v0, "alertValues":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    :goto_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    const/4 v3, 0x3

    if-eq v2, v3, :cond_3

    .line 184
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v2

    if-ne v2, v4, :cond_0

    .line 187
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 188
    .local v1, "name":Ljava/lang/String;
    const-string v2, "identifier"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 189
    invoke-static {p0, v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readXmlValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 190
    :cond_1
    const-string v2, "info"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 191
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readInfo(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    goto :goto_0

    .line 193
    :cond_2
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_0

    .line 197
    .end local v1    # "name":Ljava/lang/String;
    :cond_3
    new-instance v2, Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    invoke-direct {v2, v0}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;-><init>(Ljava/util/HashMap;)V

    return-object v2
.end method

.method private static readAlertXML(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/ArrayList;
    .locals 6
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/xmlpull/v1/XmlPullParser;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/eas/Alert;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x2

    .line 159
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 161
    .local v1, "alerts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/comcast/playerplatform/primetime/android/eas/Alert;>;"
    sget-object v3, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->namespace:Ljava/lang/String;

    const-string v4, "alerts"

    invoke-interface {p0, v5, v3, v4}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 162
    :cond_0
    :goto_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v3

    const/4 v4, 0x3

    if-eq v3, v4, :cond_2

    .line 163
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v3

    if-ne v3, v5, :cond_0

    .line 166
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 168
    .local v2, "name":Ljava/lang/String;
    const-string v3, "alert"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 169
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readAlert(Lorg/xmlpull/v1/XmlPullParser;)Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    move-result-object v0

    .line 170
    .local v0, "alert":Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    if-eqz v0, :cond_0

    .line 171
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 174
    .end local v0    # "alert":Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    :cond_1
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_0

    .line 177
    .end local v2    # "name":Ljava/lang/String;
    :cond_2
    return-object v1
.end method

.method private static readArea(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)V
    .locals 3
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p1, "alertValues"    # Ljava/util/Map;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x2

    .line 245
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->namespace:Ljava/lang/String;

    const-string v1, "area"

    invoke-interface {p0, v2, v0, v1}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 246
    :cond_0
    :goto_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    const/4 v1, 0x3

    if-eq v0, v1, :cond_2

    .line 247
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 251
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "areaDesc"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 252
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readXmlValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 254
    :cond_1
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_0

    .line 257
    :cond_2
    return-void
.end method

.method private static readEvent(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)V
    .locals 3
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p1, "alertValues"    # Ljava/util/Map;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x2

    .line 260
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->namespace:Ljava/lang/String;

    const-string v1, "eventCode"

    invoke-interface {p0, v2, v0, v1}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 261
    :cond_0
    :goto_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    const/4 v1, 0x3

    if-eq v0, v1, :cond_2

    .line 262
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 266
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "value"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 267
    const-string v0, "eventCode"

    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readXmlValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 269
    :cond_1
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_0

    .line 272
    :cond_2
    return-void
.end method

.method private static readInfo(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/Map;
    .locals 5
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x2

    .line 201
    sget-object v2, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->namespace:Ljava/lang/String;

    const-string v3, "info"

    invoke-interface {p0, v4, v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 202
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 204
    .local v0, "alertValues":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    :goto_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    const/4 v3, 0x3

    if-eq v2, v3, :cond_6

    .line 205
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v2

    if-ne v2, v4, :cond_0

    .line 208
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 209
    .local v1, "name":Ljava/lang/String;
    const-string v2, "description"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    const-string v2, "instruction"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    const-string v2, "event"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    const-string v2, "expires"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    const-string v2, "effective"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 211
    :cond_1
    invoke-static {p0, v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readXmlValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 212
    :cond_2
    const-string v2, "area"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 213
    invoke-static {p0, v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readArea(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)V

    goto :goto_0

    .line 214
    :cond_3
    const-string v2, "eventCode"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 215
    invoke-static {p0, v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readEvent(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)V

    goto :goto_0

    .line 216
    :cond_4
    const-string v2, "resource"

    invoke-virtual {v1, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 217
    invoke-static {p0, v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readResource(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)V

    goto :goto_0

    .line 219
    :cond_5
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_0

    .line 222
    .end local v1    # "name":Ljava/lang/String;
    :cond_6
    return-object v0
.end method

.method private static readLocationXML(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    .locals 5
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x2

    .line 120
    const/4 v0, 0x0

    .line 122
    .local v0, "fipsCode":Ljava/lang/String;
    sget-object v2, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->namespace:Ljava/lang/String;

    const-string v3, "zips"

    invoke-interface {p0, v4, v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 123
    :cond_0
    :goto_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    const/4 v3, 0x3

    if-eq v2, v3, :cond_2

    .line 124
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v2

    if-ne v2, v4, :cond_0

    .line 127
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 129
    .local v1, "name":Ljava/lang/String;
    const-string v2, "zip"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 130
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readZipsXML(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 132
    :cond_1
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_0

    .line 135
    .end local v1    # "name":Ljava/lang/String;
    :cond_2
    return-object v0
.end method

.method private static readResource(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)V
    .locals 5
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p1, "alertValues"    # Ljava/util/Map;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x2

    .line 226
    sget-object v2, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->namespace:Ljava/lang/String;

    const-string v3, "resource"

    invoke-interface {p0, v4, v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 227
    const/4 v0, 0x0

    .line 228
    .local v0, "isHls":Z
    :cond_0
    :goto_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    const/4 v3, 0x3

    if-eq v2, v3, :cond_5

    .line 229
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v2

    if-ne v2, v4, :cond_0

    .line 233
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "mimeType"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 234
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readXmlValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 235
    .local v1, "mimeTypeName":Ljava/lang/String;
    const-string v2, "application/x-mpegURL"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    const-string v2, "application/vnd.apple.mpegurl"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    :cond_1
    const/4 v0, 0x1

    .line 236
    :goto_1
    goto :goto_0

    .line 235
    :cond_2
    const/4 v0, 0x0

    goto :goto_1

    .line 236
    .end local v1    # "mimeTypeName":Ljava/lang/String;
    :cond_3
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "uri"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    if-eqz v0, :cond_4

    .line 237
    const-string v2, "resource"

    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {p0, v3}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readXmlValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 239
    :cond_4
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_0

    .line 242
    :cond_5
    return-void
.end method

.method private static readText(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    .locals 3
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .prologue
    .line 282
    const-string v0, ""

    .line 283
    .local v0, "result":Ljava/lang/String;
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_0

    .line 284
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v0

    .line 285
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    .line 287
    :cond_0
    return-object v0
.end method

.method private static readXmlValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p1, "xmlName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .prologue
    .line 275
    const/4 v1, 0x2

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->namespace:Ljava/lang/String;

    invoke-interface {p0, v1, v2, p1}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 276
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readText(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;

    move-result-object v0

    .line 277
    .local v0, "identifier":Ljava/lang/String;
    const/4 v1, 0x3

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->namespace:Ljava/lang/String;

    invoke-interface {p0, v1, v2, p1}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 278
    return-object v0
.end method

.method private static readZipsXML(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    .locals 5
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x2

    .line 139
    const/4 v0, 0x0

    .line 141
    .local v0, "fipsCode":Ljava/lang/String;
    sget-object v2, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->namespace:Ljava/lang/String;

    const-string v3, "zip"

    invoke-interface {p0, v4, v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 143
    :cond_0
    :goto_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    const/4 v3, 0x3

    if-eq v2, v3, :cond_1

    .line 144
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v2

    if-ne v2, v4, :cond_0

    .line 147
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 148
    .local v1, "name":Ljava/lang/String;
    const-string v2, "countyFips"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 149
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->readText(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;

    move-result-object v0

    .line 155
    .end local v1    # "name":Ljava/lang/String;
    :cond_1
    return-object v0

    .line 152
    .restart local v1    # "name":Ljava/lang/String;
    :cond_2
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_0
.end method

.method private static skip(Lorg/xmlpull/v1/XmlPullParser;)V
    .locals 3
    .param p0, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 291
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v1

    const/4 v2, 0x2

    if-eq v1, v2, :cond_0

    .line 292
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1}, Ljava/lang/IllegalStateException;-><init>()V

    throw v1

    .line 294
    :cond_0
    const/4 v0, 0x1

    .line 295
    .local v0, "depth":I
    :goto_0
    if-eqz v0, :cond_1

    .line 296
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 301
    :pswitch_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 298
    :pswitch_1
    add-int/lit8 v0, v0, -0x1

    .line 299
    goto :goto_0

    .line 305
    :cond_1
    return-void

    .line 296
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
