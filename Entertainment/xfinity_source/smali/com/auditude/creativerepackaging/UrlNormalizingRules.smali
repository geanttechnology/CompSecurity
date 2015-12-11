.class public Lcom/auditude/creativerepackaging/UrlNormalizingRules;
.super Ljava/lang/Object;
.source "UrlNormalizingRules.java"

# interfaces
.implements Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;
    }
.end annotation


# static fields
.field private static instance:Lcom/auditude/creativerepackaging/UrlNormalizingRules;


# instance fields
.field private _loaded:Ljava/lang/Boolean;

.field private _loading:Ljava/lang/Boolean;

.field private dataLoader:Lcom/auditude/ads/loader/DataLoader;

.field private listeners:Ljava/util/concurrent/CopyOnWriteArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArrayList",
            "<",
            "Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;",
            ">;"
        }
    .end annotation
.end field

.field private parser:Lorg/xmlpull/v1/XmlPullParser;

.field private rules:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/creativerepackaging/Rule;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->_loaded:Ljava/lang/Boolean;

    .line 36
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->_loading:Ljava/lang/Boolean;

    .line 37
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->listeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    .line 45
    return-void
.end method

.method private dispatchLoaded(Ljava/lang/Boolean;)V
    .locals 3
    .param p1, "success"    # Ljava/lang/Boolean;

    .prologue
    .line 223
    iget-object v1, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->listeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 227
    return-void

    .line 223
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;

    .line 225
    .local v0, "listener":Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;
    invoke-interface {v0, p1}, Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;->onRulesLoaded(Ljava/lang/Boolean;)V

    goto :goto_0
.end method

.method public static getInstance()Lcom/auditude/creativerepackaging/UrlNormalizingRules;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->instance:Lcom/auditude/creativerepackaging/UrlNormalizingRules;

    if-nez v0, :cond_0

    .line 30
    new-instance v0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;

    invoke-direct {v0}, Lcom/auditude/creativerepackaging/UrlNormalizingRules;-><init>()V

    sput-object v0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->instance:Lcom/auditude/creativerepackaging/UrlNormalizingRules;

    .line 32
    :cond_0
    sget-object v0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->instance:Lcom/auditude/creativerepackaging/UrlNormalizingRules;

    return-object v0
.end method

.method private parseCraterias()Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
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
    .line 140
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 141
    .local v0, "domains":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v1, 0x2

    .line 144
    .local v1, "eventType":I
    :goto_0
    iget-object v3, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 145
    .local v2, "tagName":Ljava/lang/String;
    const/4 v3, 0x2

    if-ne v1, v3, :cond_1

    .line 147
    const-string v3, "Domain"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 149
    iget-object v3, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 156
    :cond_0
    iget-object v3, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    .line 142
    goto :goto_0

    .line 152
    :cond_1
    const/4 v3, 0x3

    if-ne v1, v3, :cond_0

    const-string v3, "Criteria"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 158
    return-object v0
.end method

.method private parseRule()Lcom/auditude/creativerepackaging/Rule;
    .locals 8
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
    .local v2, "find":Ljava/lang/String;
    const/4 v3, 0x0

    .line 108
    .local v3, "replace":Ljava/lang/String;
    const/4 v0, 0x0

    .line 110
    .local v0, "domains":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v1, 0x2

    .line 113
    .local v1, "eventType":I
    :goto_0
    iget-object v5, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 114
    .local v4, "tagName":Ljava/lang/String;
    const/4 v5, 0x2

    if-ne v1, v5, :cond_3

    .line 116
    const-string v5, "Find"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 118
    iget-object v5, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v5

    const-string v6, "\t"

    const-string v7, ""

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 133
    :cond_0
    :goto_1
    iget-object v5, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    .line 111
    goto :goto_0

    .line 120
    :cond_1
    const-string v5, "Replace"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 122
    iget-object v5, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v5

    const-string v6, "\t"

    const-string v7, ""

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 123
    goto :goto_1

    .line 124
    :cond_2
    const-string v5, "Criteria"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 126
    invoke-direct {p0}, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parseCraterias()Ljava/util/ArrayList;

    move-result-object v0

    .line 128
    goto :goto_1

    .line 129
    :cond_3
    const/4 v5, 0x3

    if-ne v1, v5, :cond_0

    const-string v5, "Rule"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 135
    new-instance v5, Lcom/auditude/creativerepackaging/Rule;

    invoke-direct {v5, v2, v3, v0}, Lcom/auditude/creativerepackaging/Rule;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    return-object v5
.end method


# virtual methods
.method public addEventListener(Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;

    .prologue
    .line 231
    iget-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->listeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z

    .line 232
    return-void
.end method

.method public loadRules()V
    .locals 4

    .prologue
    const/4 v1, 0x1

    .line 49
    iget-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->rules:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->_loaded:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->_loading:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    .line 51
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->_loading:Ljava/lang/Boolean;

    .line 53
    new-instance v0, Lcom/auditude/ads/loader/DataLoader;

    invoke-direct {v0}, Lcom/auditude/ads/loader/DataLoader;-><init>()V

    iput-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    .line 54
    iget-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    invoke-virtual {v0, p0}, Lcom/auditude/ads/loader/DataLoader;->setDataLoaderListener(Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;)V

    .line 55
    iget-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    const-string v1, "http://cdn2.auditude.com/crs/rules.xml"

    const/4 v2, 0x0

    const/4 v3, 0x5

    invoke-virtual {v0, v1, v2, v3}, Lcom/auditude/ads/loader/DataLoader;->load(Ljava/lang/String;Ljava/lang/String;I)V

    .line 61
    :cond_0
    :goto_0
    return-void

    .line 57
    :cond_1
    iget-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->_loading:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    .line 59
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->dispatchLoaded(Ljava/lang/Boolean;)V

    goto :goto_0
.end method

.method public normalize(Ljava/lang/String;)Ljava/lang/String;
    .locals 13
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v12, 0x1

    .line 163
    const/4 v6, 0x0

    .line 166
    .local v6, "uri":Ljava/net/URI;
    :try_start_0
    new-instance v7, Ljava/net/URI;

    invoke-direct {v7, p1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 172
    .end local v6    # "uri":Ljava/net/URI;
    .local v7, "uri":Ljava/net/URI;
    move-object v4, p1

    .line 174
    .local v4, "result":Ljava/lang/String;
    iget-object v9, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->rules:Ljava/util/ArrayList;

    if-eqz v9, :cond_1

    iget-object v9, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->rules:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-lez v9, :cond_1

    .line 176
    iget-object v9, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->rules:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-nez v10, :cond_2

    :cond_1
    move-object v6, v7

    .line 206
    .end local v4    # "result":Ljava/lang/String;
    .end local v7    # "uri":Ljava/net/URI;
    .restart local v6    # "uri":Ljava/net/URI;
    :goto_1
    return-object v4

    .line 168
    :catch_0
    move-exception v1

    .local v1, "e":Ljava/lang/Exception;
    move-object v4, p1

    .line 169
    goto :goto_1

    .line 176
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v6    # "uri":Ljava/net/URI;
    .restart local v4    # "result":Ljava/lang/String;
    .restart local v7    # "uri":Ljava/net/URI;
    :cond_2
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/auditude/creativerepackaging/Rule;

    .line 178
    .local v5, "rule":Lcom/auditude/creativerepackaging/Rule;
    iget-object v10, v5, Lcom/auditude/creativerepackaging/Rule;->replace:Ljava/lang/String;

    if-eqz v10, :cond_0

    iget-object v10, v5, Lcom/auditude/creativerepackaging/Rule;->find:Ljava/lang/String;

    if-eqz v10, :cond_0

    .line 181
    const/4 v10, 0x0

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    .line 182
    .local v8, "valideDomain":Ljava/lang/Boolean;
    iget-object v10, v5, Lcom/auditude/creativerepackaging/Rule;->domains:Ljava/util/ArrayList;

    if-eqz v10, :cond_5

    iget-object v10, v5, Lcom/auditude/creativerepackaging/Rule;->domains:Ljava/util/ArrayList;

    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v10

    if-lez v10, :cond_5

    .line 184
    iget-object v10, v5, Lcom/auditude/creativerepackaging/Rule;->domains:Ljava/util/ArrayList;

    invoke-virtual {v10}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :cond_3
    :goto_2
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_4

    .line 197
    :goto_3
    invoke-virtual {v8}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    if-eqz v10, :cond_0

    .line 199
    iget-object v2, v5, Lcom/auditude/creativerepackaging/Rule;->find:Ljava/lang/String;

    .line 200
    .local v2, "find":Ljava/lang/String;
    iget-object v3, v5, Lcom/auditude/creativerepackaging/Rule;->replace:Ljava/lang/String;

    .line 201
    .local v3, "replace":Ljava/lang/String;
    invoke-virtual {v4, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 184
    .end local v2    # "find":Ljava/lang/String;
    .end local v3    # "replace":Ljava/lang/String;
    :cond_4
    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 186
    .local v0, "domain":Ljava/lang/String;
    invoke-virtual {v7}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_3

    .line 188
    invoke-static {v12}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    goto :goto_2

    .line 194
    .end local v0    # "domain":Ljava/lang/String;
    :cond_5
    invoke-static {v12}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    goto :goto_3
.end method

.method public onRequestComplete(Ljava/lang/String;)V
    .locals 8
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x1

    .line 65
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    .line 66
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->rules:Ljava/util/ArrayList;

    .line 70
    :try_start_0
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v2

    .line 71
    .local v2, "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    invoke-virtual {v2}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v4

    iput-object v4, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    .line 72
    iget-object v4, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    new-instance v5, Ljava/io/StringReader;

    invoke-direct {v5, p1}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-interface {v4, v5}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 74
    iget-object v4, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 75
    .local v1, "eventType":I
    :goto_0
    if-ne v1, v7, :cond_0

    .line 99
    .end local v1    # "eventType":I
    .end local v2    # "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    :goto_1
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    iput-object v4, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->_loaded:Ljava/lang/Boolean;

    .line 100
    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    iput-object v4, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->_loading:Ljava/lang/Boolean;

    .line 101
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->dispatchLoaded(Ljava/lang/Boolean;)V

    .line 102
    return-void

    .line 77
    .restart local v1    # "eventType":I
    .restart local v2    # "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    :cond_0
    packed-switch v1, :pswitch_data_0

    .line 92
    :cond_1
    :goto_2
    :try_start_1
    iget-object v4, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    goto :goto_0

    .line 80
    :pswitch_0
    iget-object v4, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 81
    .local v3, "tagName":Ljava/lang/String;
    const-string v4, "Rule"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 83
    iget-object v4, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->rules:Ljava/util/ArrayList;

    invoke-direct {p0}, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->parseRule()Lcom/auditude/creativerepackaging/Rule;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2

    .line 95
    .end local v1    # "eventType":I
    .end local v2    # "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    .end local v3    # "tagName":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 96
    .local v0, "e":Ljava/lang/Exception;
    const-string v4, "UrlNormalizingRules"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Error Parsing : "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 77
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method public onRequestFailed(Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    const/4 v1, 0x0

    .line 211
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->_loaded:Ljava/lang/Boolean;

    .line 212
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->_loading:Ljava/lang/Boolean;

    .line 213
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->dispatchLoaded(Ljava/lang/Boolean;)V

    .line 214
    return-void
.end method

.method public removeEventListener(Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;

    .prologue
    .line 235
    iget-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->listeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 237
    iget-object v0, p0, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->listeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    .line 239
    :cond_0
    return-void
.end method
