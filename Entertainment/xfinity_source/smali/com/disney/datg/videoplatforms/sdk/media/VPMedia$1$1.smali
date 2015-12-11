.class Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;
.super Lorg/springframework/util/LinkedMultiValueMap;
.source "VPMedia.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->call()Ljava/lang/String;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/springframework/util/LinkedMultiValueMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 350
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;

    invoke-direct {p0}, Lorg/springframework/util/LinkedMultiValueMap;-><init>()V

    .line 352
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;

    iget-object v1, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    iget-object v1, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->accessWindow:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->SUBSCRIPTION:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;

    iget-object v1, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    iget-object v1, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->tokenToAuthorize:Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;

    if-eqz v1, :cond_0

    .line 355
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;

    iget-object v1, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    iget-object v1, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->tokenToAuthorize:Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;->getTokenParameters()Ljava/util/Map;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->setAll(Ljava/util/Map;)V

    .line 358
    :cond_0
    const-string v1, "brand"

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;

    iget-object v2, v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    invoke-static {v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentNetwork()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 359
    const-string v1, "device"

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;

    iget-object v2, v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    invoke-static {v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentPartnerCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 360
    const-string v1, "video_id"

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;

    iget-object v2, v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 361
    const-string v1, "video_type"

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;

    iget-object v2, v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->getTypes()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 362
    const-string v1, "affiliate"

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;

    iget-object v2, v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    iget-object v2, v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->affiliateId:Ljava/lang/String;

    invoke-virtual {p0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 363
    const-string v1, "mvpd"

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;

    iget-object v2, v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    invoke-static {v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentPartnerName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 365
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getGeolocationManager()Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    move-result-object v1

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getCurrentGeolocation()Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    move-result-object v0

    .line 366
    .local v0, "location":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getUser()Lcom/disney/datg/videoplatforms/sdk/models/api/User;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getUser()Lcom/disney/datg/videoplatforms/sdk/models/api/User;

    move-result-object v1

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getZipCode()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 367
    const-string v1, "latitude"

    const-string v2, "1"

    invoke-virtual {p0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 368
    const-string v1, "longitude"

    const-string v2, "1"

    invoke-virtual {p0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 369
    const-string v1, "zipcode"

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getUser()Lcom/disney/datg/videoplatforms/sdk/models/api/User;

    move-result-object v2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getZipCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 371
    :cond_1
    return-void
.end method
