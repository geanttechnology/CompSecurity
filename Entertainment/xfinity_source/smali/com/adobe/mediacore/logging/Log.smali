.class public final Lcom/adobe/mediacore/logging/Log;
.super Ljava/lang/Object;


# static fields
.field private static _logFactory:Lcom/adobe/mediacore/logging/LogFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/logging/DefaultLogFactory;

    invoke-direct {v0}, Lcom/adobe/mediacore/logging/DefaultLogFactory;-><init>()V

    sput-object v0, Lcom/adobe/mediacore/logging/Log;->_logFactory:Lcom/adobe/mediacore/logging/LogFactory;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getLogFactory()Lcom/adobe/mediacore/logging/LogFactory;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/logging/Log;->_logFactory:Lcom/adobe/mediacore/logging/LogFactory;

    return-object v0
.end method

.method public static getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/logging/Log;->_logFactory:Lcom/adobe/mediacore/logging/LogFactory;

    invoke-interface {v0, p0}, Lcom/adobe/mediacore/logging/LogFactory;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    return-object v0
.end method

.method public static setLogFactory(Lcom/adobe/mediacore/logging/LogFactory;)V
    .locals 0

    sput-object p0, Lcom/adobe/mediacore/logging/Log;->_logFactory:Lcom/adobe/mediacore/logging/LogFactory;

    return-void
.end method
