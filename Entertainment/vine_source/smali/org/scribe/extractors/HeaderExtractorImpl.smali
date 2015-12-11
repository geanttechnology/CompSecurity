.class public Lorg/scribe/extractors/HeaderExtractorImpl;
.super Ljava/lang/Object;
.source "HeaderExtractorImpl.java"

# interfaces
.implements Lorg/scribe/extractors/HeaderExtractor;


# static fields
.field public static final ESTIMATED_PARAM_LENGTH:I = 0x14

.field private static final PARAM_SEPARATOR:Ljava/lang/String; = ", "

.field private static final PREAMBLE:Ljava/lang/String; = "OAuth "


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private checkPreconditions(Lorg/scribe/model/OAuthRequest;)V
    .locals 1
    .param p1, "request"    # Lorg/scribe/model/OAuthRequest;

    .prologue
    .line 43
    const-string v0, "Cannot extract a header from a null object"

    invoke-static {p1, v0}, Lorg/scribe/utils/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 45
    invoke-virtual {p1}, Lorg/scribe/model/OAuthRequest;->getOauthParameters()Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lorg/scribe/model/OAuthRequest;->getOauthParameters()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    if-gtz v0, :cond_1

    .line 47
    :cond_0
    new-instance v0, Lorg/scribe/exceptions/OAuthParametersMissingException;

    invoke-direct {v0, p1}, Lorg/scribe/exceptions/OAuthParametersMissingException;-><init>(Lorg/scribe/model/OAuthRequest;)V

    throw v0

    .line 49
    :cond_1
    return-void
.end method


# virtual methods
.method public extract(Lorg/scribe/model/OAuthRequest;)Ljava/lang/String;
    .locals 8
    .param p1, "request"    # Lorg/scribe/model/OAuthRequest;

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lorg/scribe/extractors/HeaderExtractorImpl;->checkPreconditions(Lorg/scribe/model/OAuthRequest;)V

    .line 27
    invoke-virtual {p1}, Lorg/scribe/model/OAuthRequest;->getOauthParameters()Ljava/util/Map;

    move-result-object v3

    .line 28
    .local v3, "parameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-interface {v3}, Ljava/util/Map;->size()I

    move-result v4

    mul-int/lit8 v4, v4, 0x14

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 29
    .local v1, "header":Ljava/lang/StringBuilder;
    const-string v4, "OAuth "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 30
    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 32
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    const-string v5, "OAuth "

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-le v4, v5, :cond_0

    .line 34
    const-string v4, ", "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 36
    :cond_0
    const-string v5, "%s=\"%s\""

    const/4 v4, 0x2

    new-array v6, v4, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    aput-object v7, v6, v4

    const/4 v7, 0x1

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Lorg/scribe/utils/OAuthEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 38
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method
