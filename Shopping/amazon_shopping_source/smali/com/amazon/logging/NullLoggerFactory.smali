.class public Lcom/amazon/logging/NullLoggerFactory;
.super Ljava/lang/Object;
.source "NullLoggerFactory.java"

# interfaces
.implements Lcom/amazon/logging/LoggerFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/logging/Logger;"
        }
    .end annotation

    .prologue
    .line 15
    .local p1, "tag":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Lcom/amazon/logging/NullLogger;

    invoke-direct {v0}, Lcom/amazon/logging/NullLogger;-><init>()V

    return-object v0
.end method

.method public createLogger(Ljava/lang/String;Ljava/lang/Class;)Lcom/amazon/logging/Logger;
    .locals 1
    .param p1, "category"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/logging/Logger;"
        }
    .end annotation

    .prologue
    .line 26
    .local p2, "tag":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Lcom/amazon/logging/NullLogger;

    invoke-direct {v0}, Lcom/amazon/logging/NullLogger;-><init>()V

    return-object v0
.end method
