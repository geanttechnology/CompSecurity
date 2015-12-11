.class interface abstract Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$ResponseProvider;
.super Ljava/lang/Object;
.source "RetryingHttpClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x60a
    name = "ResponseProvider"
.end annotation


# virtual methods
.method public abstract executeRequest()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
