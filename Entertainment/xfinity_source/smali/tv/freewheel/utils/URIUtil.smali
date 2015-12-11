.class public Ltv/freewheel/utils/URIUtil;
.super Ljava/lang/Object;
.source "URIUtil.java"


# direct methods
.method public static getFixedString(Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x0

    .line 20
    if-nez p0, :cond_0

    move-object v0, v8

    .line 34
    :goto_0
    return-object v0

    .line 25
    :cond_0
    :try_start_0
    new-instance v7, Ljava/net/URL;

    invoke-direct {v7, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 26
    .local v7, "url":Ljava/net/URL;
    new-instance v0, Ljava/net/URI;

    invoke-virtual {v7}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7}, Ljava/net/URL;->getAuthority()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7}, Ljava/net/URL;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7}, Ljava/net/URL;->getQuery()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v7}, Ljava/net/URL;->getRef()Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Ljava/net/URI;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    goto :goto_0

    .line 31
    .end local v7    # "url":Ljava/net/URL;
    :catch_0
    move-exception v6

    .local v6, "e":Ljava/net/MalformedURLException;
    move-object v0, v8

    .line 32
    goto :goto_0

    .line 33
    .end local v6    # "e":Ljava/net/MalformedURLException;
    :catch_1
    move-exception v6

    .local v6, "e":Ljava/net/URISyntaxException;
    move-object v0, v8

    .line 34
    goto :goto_0
.end method
