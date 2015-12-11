.class public interface abstract Lcom/comcast/cim/microdata/deserialization/MicrodataDeserializer;
.super Ljava/lang/Object;
.source "MicrodataDeserializer.java"


# virtual methods
.method public abstract convert(Ljava/io/InputStream;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
        }
    .end annotation
.end method
