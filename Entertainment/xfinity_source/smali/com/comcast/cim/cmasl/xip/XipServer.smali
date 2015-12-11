.class public Lcom/comcast/cim/cmasl/xip/XipServer;
.super Ljava/lang/Object;
.source "XipServer.java"


# instance fields
.field private final serverUri:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "serverUri"    # Ljava/lang/String;

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    iput-object p1, p0, Lcom/comcast/cim/cmasl/xip/XipServer;->serverUri:Ljava/lang/String;

    .line 9
    return-void
.end method


# virtual methods
.method public getURI()Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    iget-object v0, p0, Lcom/comcast/cim/cmasl/xip/XipServer;->serverUri:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/xip/XipServer;->getURI()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
