.class public Lcom/adobe/mobile/Acquisition;
.super Ljava/lang/Object;
.source "Acquisition.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static campaignStartForApp(Ljava/lang/String;Ljava/util/Map;)V
    .locals 0
    .param p0, "appId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 25
    .local p1, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-static {p0, p1}, Lcom/adobe/mobile/AcquisitionHandler;->campaignStartForApp(Ljava/lang/String;Ljava/util/Map;)V

    .line 26
    return-void
.end method
