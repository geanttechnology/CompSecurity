.class public Lcom/comcast/cim/httpcomponentsandroid/client/utils/URLEncodedUtils;
.super Ljava/lang/Object;
.source "URLEncodedUtils.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "content"    # Ljava/lang/String;
    .param p1, "encoding"    # Ljava/lang/String;

    .prologue
    .line 204
    if-eqz p1, :cond_0

    .end local p1    # "encoding":Ljava/lang/String;
    :goto_0
    :try_start_0
    invoke-static {p0, p1}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .restart local p1    # "encoding":Ljava/lang/String;
    :cond_0
    const-string p1, "ISO-8859-1"
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 206
    .end local p1    # "encoding":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 207
    .local v0, "problem":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private static encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "content"    # Ljava/lang/String;
    .param p1, "encoding"    # Ljava/lang/String;

    .prologue
    .line 213
    if-eqz p1, :cond_0

    .end local p1    # "encoding":Ljava/lang/String;
    :goto_0
    :try_start_0
    invoke-static {p0, p1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .restart local p1    # "encoding":Ljava/lang/String;
    :cond_0
    const-string p1, "ISO-8859-1"
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 215
    .end local p1    # "encoding":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 216
    .local v0, "problem":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public static format(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "encoding"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<+",
            "Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 188
    .local p0, "parameters":Ljava/util/List;, "Ljava/util/List<+Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 189
    .local v4, "result":Ljava/lang/StringBuilder;
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    .line 190
    .local v3, "parameter":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URLEncodedUtils;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 191
    .local v0, "encodedName":Ljava/lang/String;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v5

    .line 192
    .local v5, "value":Ljava/lang/String;
    if-eqz v5, :cond_1

    invoke-static {v5, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URLEncodedUtils;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 193
    .local v1, "encodedValue":Ljava/lang/String;
    :goto_1
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->length()I

    move-result v6

    if-lez v6, :cond_0

    .line 194
    const-string v6, "&"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 195
    :cond_0
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 196
    const-string v6, "="

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 197
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 192
    .end local v1    # "encodedValue":Ljava/lang/String;
    :cond_1
    const-string v1, ""

    goto :goto_1

    .line 199
    .end local v0    # "encodedName":Ljava/lang/String;
    .end local v3    # "parameter":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .end local v5    # "value":Ljava/lang/String;
    :cond_2
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6
.end method

.method public static parse(Ljava/net/URI;Ljava/lang/String;)Ljava/util/List;
    .locals 3
    .param p0, "uri"    # Ljava/net/URI;
    .param p1, "encoding"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 76
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v1

    .line 77
    .local v1, "result":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    invoke-virtual {p0}, Ljava/net/URI;->getRawQuery()Ljava/lang/String;

    move-result-object v0

    .line 78
    .local v0, "query":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 79
    new-instance v1, Ljava/util/ArrayList;

    .end local v1    # "result":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 80
    .restart local v1    # "result":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    new-instance v2, Ljava/util/Scanner;

    invoke-direct {v2, v0}, Ljava/util/Scanner;-><init>(Ljava/lang/String;)V

    invoke-static {v1, v2, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URLEncodedUtils;->parse(Ljava/util/List;Ljava/util/Scanner;Ljava/lang/String;)V

    .line 82
    :cond_0
    return-object v1
.end method

.method public static parse(Ljava/util/List;Ljava/util/Scanner;Ljava/lang/String;)V
    .locals 6
    .param p1, "scanner"    # Ljava/util/Scanner;
    .param p2, "encoding"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;",
            ">;",
            "Ljava/util/Scanner;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .local p0, "parameters":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    const/4 v5, 0x2

    .line 164
    const-string v3, "&"

    invoke-virtual {p1, v3}, Ljava/util/Scanner;->useDelimiter(Ljava/lang/String;)Ljava/util/Scanner;

    .line 165
    :goto_0
    invoke-virtual {p1}, Ljava/util/Scanner;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 166
    invoke-virtual {p1}, Ljava/util/Scanner;->next()Ljava/lang/String;

    move-result-object v3

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 167
    .local v1, "nameValue":[Ljava/lang/String;
    array-length v3, v1

    if-eqz v3, :cond_0

    array-length v3, v1

    if-le v3, v5, :cond_1

    .line 168
    :cond_0
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "bad parameter"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 170
    :cond_1
    const/4 v3, 0x0

    aget-object v3, v1, v3

    invoke-static {v3, p2}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URLEncodedUtils;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 171
    .local v0, "name":Ljava/lang/String;
    const/4 v2, 0x0

    .line 172
    .local v2, "value":Ljava/lang/String;
    array-length v3, v1

    if-ne v3, v5, :cond_2

    .line 173
    const/4 v3, 0x1

    aget-object v3, v1, v3

    invoke-static {v3, p2}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URLEncodedUtils;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 174
    :cond_2
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/message/BasicNameValuePair;

    invoke-direct {v3, v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 176
    .end local v0    # "name":Ljava/lang/String;
    .end local v1    # "nameValue":[Ljava/lang/String;
    .end local v2    # "value":Ljava/lang/String;
    :cond_3
    return-void
.end method
