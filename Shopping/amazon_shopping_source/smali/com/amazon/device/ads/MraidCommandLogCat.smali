.class Lcom/amazon/device/ads/MraidCommandLogCat;
.super Lcom/amazon/device/ads/MraidCommand;
.source "MraidCommand.java"


# static fields
.field private static final MRAID_LOG_TAG:Ljava/lang/String; = "MRAIDLog"


# direct methods
.method constructor <init>(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)V
    .locals 0
    .param p2, "view"    # Lcom/amazon/device/ads/MraidView;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/device/ads/MraidView;",
            ")V"
        }
    .end annotation

    .prologue
    .line 168
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/MraidCommand;-><init>(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)V

    .line 169
    return-void
.end method


# virtual methods
.method execute()V
    .locals 3

    .prologue
    .line 172
    const-string/jumbo v2, "level"

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/MraidCommandLogCat;->getIntFromParamsForKey(Ljava/lang/String;)I

    move-result v0

    .line 173
    .local v0, "level":I
    const-string/jumbo v2, "log"

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/MraidCommandLogCat;->getStringFromParamsForKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 175
    .local v1, "log":Ljava/lang/String;
    const/4 v2, -0x1

    if-ne v0, v2, :cond_1

    .line 200
    :cond_0
    :goto_0
    return-void

    .line 176
    :cond_1
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-eqz v2, :cond_0

    .line 178
    packed-switch v0, :pswitch_data_0

    .line 197
    :pswitch_0
    const-string/jumbo v2, "MRAIDLog"

    invoke-static {v2, v1}, Lcom/amazon/device/ads/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 180
    :pswitch_1
    const-string/jumbo v2, "MRAIDLog"

    invoke-static {v2, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 184
    :pswitch_2
    const-string/jumbo v2, "MRAIDLog"

    invoke-static {v2, v1}, Lcom/amazon/device/ads/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 188
    :pswitch_3
    const-string/jumbo v2, "MRAIDLog"

    invoke-static {v2, v1}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 192
    :pswitch_4
    const-string/jumbo v2, "MRAIDLog"

    invoke-static {v2, v1}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 178
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method
