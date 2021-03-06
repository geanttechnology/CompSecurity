.class final Ltwitter4j/internal/json/URLEntityJSONImpl;
.super Ltwitter4j/internal/json/EntityIndex;
.source "SourceFile"

# interfaces
.implements Ltwitter4j/URLEntity;


# static fields
.field private static final serialVersionUID:J = -0x7c2f5c909f047130L


# instance fields
.field private displayURL:Ljava/lang/String;

.field private expandedURL:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Ltwitter4j/internal/json/EntityIndex;-><init>()V

    .line 55
    return-void
.end method

.method constructor <init>(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Ltwitter4j/internal/json/EntityIndex;-><init>()V

    .line 45
    invoke-virtual {p0, p1}, Ltwitter4j/internal/json/URLEntityJSONImpl;->setStart(I)V

    .line 46
    invoke-virtual {p0, p2}, Ltwitter4j/internal/json/URLEntityJSONImpl;->setEnd(I)V

    .line 47
    iput-object p3, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    .line 48
    iput-object p4, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->expandedURL:Ljava/lang/String;

    .line 49
    iput-object p5, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->displayURL:Ljava/lang/String;

    .line 50
    return-void
.end method

.method constructor <init>(Ltwitter4j/internal/org/json/JSONObject;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ltwitter4j/internal/json/EntityIndex;-><init>()V

    .line 40
    invoke-direct {p0, p1}, Ltwitter4j/internal/json/URLEntityJSONImpl;->init(Ltwitter4j/internal/org/json/JSONObject;)V

    .line 41
    return-void
.end method

.method private init(Ltwitter4j/internal/org/json/JSONObject;)V
    .locals 2

    .prologue
    .line 59
    :try_start_0
    const-string v0, "indices"

    invoke-virtual {p1, v0}, Ltwitter4j/internal/org/json/JSONObject;->getJSONArray(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;

    move-result-object v0

    .line 60
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ltwitter4j/internal/org/json/JSONArray;->getInt(I)I

    move-result v1

    invoke-virtual {p0, v1}, Ltwitter4j/internal/json/URLEntityJSONImpl;->setStart(I)V

    .line 61
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ltwitter4j/internal/org/json/JSONArray;->getInt(I)I

    move-result v0

    invoke-virtual {p0, v0}, Ltwitter4j/internal/json/URLEntityJSONImpl;->setEnd(I)V

    .line 63
    const-string v0, "url"

    invoke-virtual {p1, v0}, Ltwitter4j/internal/org/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    .line 64
    const-string v0, "expanded_url"

    invoke-virtual {p1, v0}, Ltwitter4j/internal/org/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 67
    const-string v0, "expanded_url"

    invoke-virtual {p1, v0}, Ltwitter4j/internal/org/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->expandedURL:Ljava/lang/String;

    .line 72
    :goto_0
    const-string v0, "display_url"

    invoke-virtual {p1, v0}, Ltwitter4j/internal/org/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 75
    const-string v0, "display_url"

    invoke-virtual {p1, v0}, Ltwitter4j/internal/org/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->displayURL:Ljava/lang/String;

    .line 81
    :goto_1
    return-void

    .line 69
    :cond_0
    iget-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    iput-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->expandedURL:Ljava/lang/String;
    :try_end_0
    .catch Ltwitter4j/internal/org/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 79
    :catch_0
    move-exception v0

    .line 80
    new-instance v1, Ltwitter4j/TwitterException;

    invoke-direct {v1, v0}, Ltwitter4j/TwitterException;-><init>(Ljava/lang/Exception;)V

    throw v1

    .line 77
    :cond_1
    :try_start_1
    iget-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    iput-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->displayURL:Ljava/lang/String;
    :try_end_1
    .catch Ltwitter4j/internal/org/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method


# virtual methods
.method public final equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 134
    if-ne p0, p1, :cond_1

    .line 143
    :cond_0
    :goto_0
    return v0

    .line 135
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_3

    :cond_2
    move v0, v1

    goto :goto_0

    .line 137
    :cond_3
    check-cast p1, Ltwitter4j/internal/json/URLEntityJSONImpl;

    .line 139
    iget-object v2, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->displayURL:Ljava/lang/String;

    if-eqz v2, :cond_5

    iget-object v2, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->displayURL:Ljava/lang/String;

    iget-object v3, p1, Ltwitter4j/internal/json/URLEntityJSONImpl;->displayURL:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_6

    :cond_4
    move v0, v1

    goto :goto_0

    :cond_5
    iget-object v2, p1, Ltwitter4j/internal/json/URLEntityJSONImpl;->displayURL:Ljava/lang/String;

    if-nez v2, :cond_4

    .line 140
    :cond_6
    iget-object v2, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->expandedURL:Ljava/lang/String;

    if-eqz v2, :cond_8

    iget-object v2, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->expandedURL:Ljava/lang/String;

    iget-object v3, p1, Ltwitter4j/internal/json/URLEntityJSONImpl;->expandedURL:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_9

    :cond_7
    move v0, v1

    goto :goto_0

    :cond_8
    iget-object v2, p1, Ltwitter4j/internal/json/URLEntityJSONImpl;->expandedURL:Ljava/lang/String;

    if-nez v2, :cond_7

    .line 141
    :cond_9
    iget-object v2, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    if-eqz v2, :cond_a

    iget-object v2, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    iget-object v3, p1, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :goto_1
    move v0, v1

    goto :goto_0

    :cond_a
    iget-object v2, p1, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    if-eqz v2, :cond_0

    goto :goto_1
.end method

.method public final getDisplayURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->displayURL:Ljava/lang/String;

    return-object v0
.end method

.method public final getEnd()I
    .locals 1

    .prologue
    .line 129
    invoke-super {p0}, Ltwitter4j/internal/json/EntityIndex;->getEnd()I

    move-result v0

    return v0
.end method

.method public final getExpandedURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->expandedURL:Ljava/lang/String;

    return-object v0
.end method

.method public final getStart()I
    .locals 1

    .prologue
    .line 121
    invoke-super {p0}, Ltwitter4j/internal/json/EntityIndex;->getStart()I

    move-result v0

    return v0
.end method

.method public final getText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    return-object v0
.end method

.method public final getURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    return-object v0
.end method

.method public final hashCode()I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 148
    iget-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 149
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->expandedURL:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->expandedURL:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_1
    add-int/2addr v0, v2

    .line 150
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->displayURL:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v1, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->displayURL:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :cond_0
    add-int/2addr v0, v1

    .line 151
    return v0

    :cond_1
    move v0, v1

    .line 148
    goto :goto_0

    :cond_2
    move v0, v1

    .line 149
    goto :goto_1
.end method

.method public final toString()Ljava/lang/String;
    .locals 3

    .prologue
    const/16 v2, 0x27

    .line 156
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "URLEntityJSONImpl{url=\'"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->url:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", expandedURL=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->expandedURL:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", displayURL=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltwitter4j/internal/json/URLEntityJSONImpl;->displayURL:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
