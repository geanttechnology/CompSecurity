.class public Lcom/auditude/ads/model/tracking/Submission;
.super Lcom/auditude/ads/model/tracking/TrackingUrl;
.source "Submission.java"


# instance fields
.field public externalUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static newSubmission(Ljava/lang/String;Ljava/lang/String;)Lcom/auditude/ads/model/tracking/Submission;
    .locals 1
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 55
    new-instance v0, Lcom/auditude/ads/model/tracking/Submission;

    invoke-direct {v0, p0, p1}, Lcom/auditude/ads/model/tracking/Submission;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public duplicate()Lcom/auditude/ads/model/tracking/TrackingUrl;
    .locals 3

    .prologue
    .line 47
    new-instance v0, Lcom/auditude/ads/model/tracking/Submission;

    invoke-virtual {p0}, Lcom/auditude/ads/model/tracking/Submission;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/auditude/ads/model/tracking/Submission;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/model/tracking/Submission;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    .local v0, "submission":Lcom/auditude/ads/model/tracking/Submission;
    iget-object v1, p0, Lcom/auditude/ads/model/tracking/Submission;->externalUrl:Ljava/lang/String;

    iput-object v1, v0, Lcom/auditude/ads/model/tracking/Submission;->externalUrl:Ljava/lang/String;

    .line 50
    return-object v0
.end method

.method public log(ZLjava/util/HashMap;)V
    .locals 3
    .param p1, "force"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p2, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/auditude/ads/model/tracking/Submission;->isLogged()Z

    move-result v1

    if-eqz v1, :cond_1

    if-nez p1, :cond_1

    .line 42
    :cond_0
    :goto_0
    return-void

    .line 26
    :cond_1
    invoke-virtual {p0}, Lcom/auditude/ads/model/tracking/Submission;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p2}, Lcom/auditude/ads/util/URLUtil;->appendURLParams(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    .line 27
    .local v0, "pingUrl":Ljava/lang/String;
    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 30
    iget-object v1, p0, Lcom/auditude/ads/model/tracking/Submission;->externalUrl:Ljava/lang/String;

    invoke-static {v1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 32
    new-instance p2, Ljava/util/HashMap;

    .end local p2    # "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p2}, Ljava/util/HashMap;-><init>()V

    .line 33
    .restart local p2    # "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "v"

    const-string v2, "0"

    invoke-virtual {p2, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 36
    invoke-static {v0, p2}, Lcom/auditude/ads/util/URLUtil;->appendURLParams(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    .line 39
    :cond_2
    invoke-static {v0}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;)V

    .line 41
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/auditude/ads/model/tracking/Submission;->setLogged(Z)V

    goto :goto_0
.end method
