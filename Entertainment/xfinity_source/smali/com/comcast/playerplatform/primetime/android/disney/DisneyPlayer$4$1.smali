.class Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4$1;
.super Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;
.source "DisneyPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;)V
    .locals 4

    .prologue
    .line 634
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4$1;->this$1:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;

    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;-><init>()V

    .line 635
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4$1;->this$1:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;

    iget-object v2, v2, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmKey()Ljava/lang/String;

    move-result-object v0

    .line 637
    .local v0, "token":Ljava/lang/String;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 638
    .local v1, "tokenParams":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "token_type"

    const-string v3, "offsite.comcast"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 639
    const-string v2, "token"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 640
    invoke-virtual {p0, v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4$1;->setTokenParameters(Ljava/util/Map;)V

    .line 641
    return-void
.end method
