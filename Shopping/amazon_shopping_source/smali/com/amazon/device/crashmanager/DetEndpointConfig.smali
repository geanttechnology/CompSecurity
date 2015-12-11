.class Lcom/amazon/device/crashmanager/DetEndpointConfig;
.super Ljava/lang/Object;
.source "DetEndpointConfig.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/crashmanager/DetEndpointConfig$1;
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    return-void
.end method

.method static getServiceEndpoint(Lcom/amazon/device/crashmanager/Domain;)Lamazon/communication/identity/EndpointIdentity;
    .locals 2
    .param p0, "domain"    # Lcom/amazon/device/crashmanager/Domain;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 14
    sget-object v0, Lcom/amazon/device/crashmanager/DetEndpointConfig$1;->$SwitchMap$com$amazon$device$crashmanager$Domain:[I

    invoke-virtual {p0}, Lcom/amazon/device/crashmanager/Domain;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 19
    const-string/jumbo v0, "https://det-ta-g7g.vipinteg.amazon.com:443"

    invoke-static {v0}, Lamazon/communication/identity/EndpointIdentityFactory;->createFromUrn(Ljava/lang/String;)Lamazon/communication/identity/EndpointIdentity;

    move-result-object v0

    :goto_0
    return-object v0

    .line 16
    :pswitch_0
    const-string/jumbo v0, "https://det-ta-g7g.amazon.com:443"

    invoke-static {v0}, Lamazon/communication/identity/EndpointIdentityFactory;->createFromUrn(Ljava/lang/String;)Lamazon/communication/identity/EndpointIdentity;

    move-result-object v0

    goto :goto_0

    .line 14
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
