.class public interface abstract Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;
.super Ljava/lang/Object;
.source "JsonFileIo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "JsonInterpreter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract fromJson(Ljava/lang/String;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract toJson(Ljava/lang/Object;)Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
