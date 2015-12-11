.class public Lcom/comcast/cim/httpcomponentsandroid/impl/conn/IdleConnectionHandler;
.super Ljava/lang/Object;
.source "IdleConnectionHandler.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field private final connectionToTimes:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpConnection;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private final log:Lorg/apache/commons/logging/Log;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/IdleConnectionHandler;->log:Lorg/apache/commons/logging/Log;

    .line 61
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/IdleConnectionHandler;->connectionToTimes:Ljava/util/Map;

    .line 62
    return-void
.end method


# virtual methods
.method public removeAll()V
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/IdleConnectionHandler;->connectionToTimes:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 106
    return-void
.end method
