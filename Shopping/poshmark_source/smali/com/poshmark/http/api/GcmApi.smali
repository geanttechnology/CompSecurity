.class public Lcom/poshmark/http/api/GcmApi;
.super Ljava/lang/Object;
.source "GcmApi.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static PostGcmMessage(Lcom/poshmark/http/BrainTreeHttpResponseHandler;)V
    .locals 4
    .param p0, "handler"    # Lcom/poshmark/http/BrainTreeHttpResponseHandler;

    .prologue
    .line 13
    new-instance v0, Lcom/poshmark/http/PMHttpRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    const-string v2, "https://android.googleapis.com/gcm/send"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/http/PMHttpRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;)V

    .line 15
    .local v0, "apiRequest":Lcom/poshmark/http/PMHttpRequest;
    iget-object v1, v0, Lcom/poshmark/http/PMHttpRequest;->headers:Ljava/util/Map;

    const-string v2, "Authorization"

    const-string v3, "key=AIzaSyA7erstLkZ2EHcUvF40MW_fiUxQkb0bMvE"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 16
    iget-object v1, v0, Lcom/poshmark/http/PMHttpRequest;->headers:Ljava/util/Map;

    const-string v2, "Content-Type"

    const-string v3, "application/json"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 17
    iget-object v1, v0, Lcom/poshmark/http/PMHttpRequest;->formData:Ljava/util/Map;

    const-string v2, "registration_id"

    const-string v3, "APA91bGmEpnZ4gmOKQHra3mjAtHqDHaZkfFR-V37CLicOBA9O0cIwYdq8d5jlVef2hetMyZRyXekSm9NXmUGblnZ3li187-hqMzbiNKRvwSNS2ep-86_WLeGn6_oEAZSun66wCCc0CoPO0uc3Os7ZOMe0K7OV-P-9w"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 18
    invoke-virtual {v0, p0}, Lcom/poshmark/http/PMHttpRequest;->execute(Lcom/poshmark/http/PMHttpResponseHandler;)V

    .line 19
    return-void
.end method
