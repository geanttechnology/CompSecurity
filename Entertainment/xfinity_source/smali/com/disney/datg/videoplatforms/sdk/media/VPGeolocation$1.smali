.class Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;
.super Lorg/springframework/util/LinkedMultiValueMap;
.source "VPGeolocation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getCurrentGeolocation(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
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
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

.field final synthetic val$latitude:Ljava/lang/String;

.field final synthetic val$longitude:Ljava/lang/String;

.field final synthetic val$zipcode:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 74
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->val$latitude:Ljava/lang/String;

    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->val$longitude:Ljava/lang/String;

    iput-object p4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->val$zipcode:Ljava/lang/String;

    invoke-direct {p0}, Lorg/springframework/util/LinkedMultiValueMap;-><init>()V

    .line 76
    const-string v0, "brand"

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    invoke-static {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentNetwork()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 77
    const-string v0, "device"

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    invoke-static {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentPartnerCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 78
    const-string v0, "type"

    const-string v1, "gt"

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 79
    const-string v0, "latitude"

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->val$latitude:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 80
    const-string v0, "longitude"

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->val$longitude:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 81
    const-string v0, "zipcode"

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->val$zipcode:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 82
    return-void
.end method
