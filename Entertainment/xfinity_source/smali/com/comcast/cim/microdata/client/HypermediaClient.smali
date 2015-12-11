.class public interface abstract Lcom/comcast/cim/microdata/client/HypermediaClient;
.super Ljava/lang/Object;
.source "HypermediaClient.java"


# virtual methods
.method public abstract isAutomaticNetworkLoadingEnabled()Z
.end method

.method public abstract parseResource(Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
        }
    .end annotation
.end method
