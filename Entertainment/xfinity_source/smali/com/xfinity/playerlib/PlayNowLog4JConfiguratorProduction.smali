.class public Lcom/xfinity/playerlib/PlayNowLog4JConfiguratorProduction;
.super Ljava/lang/Object;
.source "PlayNowLog4JConfiguratorProduction.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/logging/Log4JConfigurator;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public configureLogging()V
    .locals 1

    .prologue
    .line 13
    invoke-static {}, Lorg/apache/log4j/Logger;->getRootLogger()Lorg/apache/log4j/Logger;

    move-result-object v0

    .line 14
    .local v0, "logger":Lorg/apache/log4j/Logger;
    invoke-virtual {v0}, Lorg/apache/log4j/Logger;->removeAllAppenders()V

    .line 15
    return-void
.end method
