.class public Lcom/amazon/device/analytics/log/LoggerBuilder;
.super Ljava/lang/Object;
.source "LoggerBuilder.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final cls:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private level:Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field private final tag:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Class;)V
    .locals 0
    .param p1, "tag"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 15
    .local p2, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/amazon/device/analytics/log/LoggerBuilder;->tag:Ljava/lang/String;

    .line 17
    iput-object p2, p0, Lcom/amazon/device/analytics/log/LoggerBuilder;->cls:Ljava/lang/Class;

    .line 18
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/device/analytics/log/Logger;
    .locals 1

    .prologue
    .line 39
    new-instance v0, Lcom/amazon/device/analytics/log/Logger;

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/log/Logger;-><init>(Lcom/amazon/device/analytics/log/LoggerBuilder;)V

    return-object v0
.end method

.method public getGlobalLogLevel()Lcom/amazon/device/analytics/log/Logging$LogLevel;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/device/analytics/log/LoggerBuilder;->level:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    return-object v0
.end method

.method public getLogClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/device/analytics/log/LoggerBuilder;->cls:Ljava/lang/Class;

    return-object v0
.end method

.method public getTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/device/analytics/log/LoggerBuilder;->tag:Ljava/lang/String;

    return-object v0
.end method

.method public setGlobalLogLevel(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Lcom/amazon/device/analytics/log/LoggerBuilder;
    .locals 0
    .param p1, "level"    # Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .prologue
    .line 21
    iput-object p1, p0, Lcom/amazon/device/analytics/log/LoggerBuilder;->level:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 22
    return-object p0
.end method
