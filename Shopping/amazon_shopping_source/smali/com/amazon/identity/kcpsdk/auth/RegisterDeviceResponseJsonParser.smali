.class public Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseJsonParser;
.super Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;
.source "RegisterDeviceResponseJsonParser.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 10
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseJsonParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;

    invoke-direct {v1}, Lcom/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser;-><init>()V

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/kcpsdk/auth/JsonWebResponseParser;-><init>(Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/PandaResponseJsonParser;)V

    .line 11
    return-void
.end method
