.class public interface abstract Lorg/springframework/core/io/Resource;
.super Ljava/lang/Object;
.source "Resource.java"

# interfaces
.implements Lorg/springframework/core/io/InputStreamSource;


# virtual methods
.method public abstract contentLength()J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract getDescription()Ljava/lang/String;
.end method

.method public abstract getFilename()Ljava/lang/String;
.end method
