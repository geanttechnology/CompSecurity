.class final Lcom/adobe/mediacore/logging/DefaultLogFactory;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/logging/LogFactory;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/logging/DefaultLogger;

    invoke-direct {v0}, Lcom/adobe/mediacore/logging/DefaultLogger;-><init>()V

    return-object v0
.end method
