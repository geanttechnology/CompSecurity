.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;
.super Ljava/lang/Object;
.source "ResourceFactory.java"


# virtual methods
.method public abstract copy(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract generate(Ljava/lang/String;Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
