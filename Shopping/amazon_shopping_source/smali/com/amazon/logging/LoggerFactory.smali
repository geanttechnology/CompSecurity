.class public interface abstract Lcom/amazon/logging/LoggerFactory;
.super Ljava/lang/Object;
.source "LoggerFactory.java"


# virtual methods
.method public abstract createLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/logging/Logger;"
        }
    .end annotation
.end method

.method public abstract createLogger(Ljava/lang/String;Ljava/lang/Class;)Lcom/amazon/logging/Logger;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/logging/Logger;"
        }
    .end annotation
.end method
