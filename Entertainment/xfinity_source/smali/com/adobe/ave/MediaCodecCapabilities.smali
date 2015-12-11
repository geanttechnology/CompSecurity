.class public Lcom/adobe/ave/MediaCodecCapabilities;
.super Ljava/lang/Object;
.source "MediaCodecCapabilities.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "MediaCodecCapabilities(j)"

.field private static capabilitiesMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/media/MediaCodecInfo$CodecCapabilities;",
            ">;"
        }
    .end annotation
.end field

.field private static codecInfoList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/media/MediaCodecInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 276
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    .line 277
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/adobe/ave/MediaCodecCapabilities;->capabilitiesMap:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    return-void
.end method

.method public static IsABRSupportedByMediaCodec(Ljava/lang/String;)Z
    .locals 12
    .param p0, "mime"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 137
    sget v9, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v10, 0x13

    if-ge v9, v10, :cond_1

    .line 179
    :cond_0
    :goto_0
    return v7

    .line 140
    :cond_1
    sget-object v9, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v9

    if-nez v9, :cond_4

    sget-object v9, Lcom/adobe/ave/MediaCodecCapabilities;->capabilitiesMap:Ljava/util/Map;

    invoke-interface {v9}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->isEmpty()Z

    move-result v9

    if-nez v9, :cond_4

    const-string v9, "video/avc"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 143
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    sget-object v9, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-ge v2, v9, :cond_0

    .line 144
    sget-object v9, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v9, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/media/MediaCodecInfo;

    .line 145
    .local v3, "info":Landroid/media/MediaCodecInfo;
    sget-object v9, Lcom/adobe/ave/MediaCodecCapabilities;->capabilitiesMap:Ljava/util/Map;

    invoke-virtual {v3}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v9, v10}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/media/MediaCodecInfo$CodecCapabilities;

    .line 147
    .local v1, "caps":Landroid/media/MediaCodecInfo$CodecCapabilities;
    if-nez v1, :cond_3

    .line 143
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 150
    :cond_3
    const-string v9, "adaptive-playback"

    invoke-virtual {v1, v9}, Landroid/media/MediaCodecInfo$CodecCapabilities;->isFeatureSupported(Ljava/lang/String;)Z

    move-result v0

    .line 151
    .local v0, "ap":Z
    const-string v9, "MediaCodecCapabilities(j)"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "IsCodecSupported (video/avc) : info = "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v3}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "AdaptivePlayback supported = "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 153
    if-eqz v0, :cond_2

    move v7, v8

    .line 154
    goto :goto_0

    .line 158
    .end local v0    # "ap":Z
    .end local v1    # "caps":Landroid/media/MediaCodecInfo$CodecCapabilities;
    .end local v2    # "i":I
    .end local v3    # "info":Landroid/media/MediaCodecInfo;
    :cond_4
    invoke-static {}, Landroid/media/MediaCodecList;->getCodecCount()I

    move-result v5

    .line 159
    .local v5, "numCodecs":I
    const/4 v2, 0x0

    .restart local v2    # "i":I
    :goto_2
    if-ge v2, v5, :cond_0

    .line 160
    invoke-static {v2}, Landroid/media/MediaCodecList;->getCodecInfoAt(I)Landroid/media/MediaCodecInfo;

    move-result-object v3

    .line 162
    .restart local v3    # "info":Landroid/media/MediaCodecInfo;
    invoke-virtual {v3}, Landroid/media/MediaCodecInfo;->isEncoder()Z

    move-result v9

    if-eqz v9, :cond_6

    .line 159
    :cond_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 166
    :cond_6
    invoke-virtual {v3}, Landroid/media/MediaCodecInfo;->getSupportedTypes()[Ljava/lang/String;

    move-result-object v6

    .line 167
    .local v6, "types":[Ljava/lang/String;
    const/4 v4, 0x0

    .local v4, "j":I
    :goto_3
    array-length v9, v6

    if-ge v4, v9, :cond_5

    .line 169
    aget-object v9, v6, v4

    invoke-virtual {v9, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_7

    .line 170
    aget-object v9, v6, v4

    invoke-virtual {v3, v9}, Landroid/media/MediaCodecInfo;->getCapabilitiesForType(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;

    move-result-object v9

    const-string v10, "adaptive-playback"

    invoke-virtual {v9, v10}, Landroid/media/MediaCodecInfo$CodecCapabilities;->isFeatureSupported(Ljava/lang/String;)Z

    move-result v0

    .line 171
    .restart local v0    # "ap":Z
    const-string v9, "MediaCodecCapabilities(j)"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "IsCodecSupported (video/avc) : info = "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v3}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "AdaptivePlayback supported = "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 173
    if-eqz v0, :cond_7

    move v7, v8

    .line 174
    goto/16 :goto_0

    .line 167
    .end local v0    # "ap":Z
    :cond_7
    add-int/lit8 v4, v4, 0x1

    goto :goto_3
.end method

.method public static IsCodecSupported(Ljava/lang/String;)Z
    .locals 8
    .param p0, "mime"    # Ljava/lang/String;

    .prologue
    .line 203
    invoke-static {}, Landroid/media/MediaCodecList;->getCodecCount()I

    move-result v3

    .line 204
    .local v3, "numCodecs":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_3

    .line 205
    invoke-static {v0}, Landroid/media/MediaCodecList;->getCodecInfoAt(I)Landroid/media/MediaCodecInfo;

    move-result-object v1

    .line 207
    .local v1, "info":Landroid/media/MediaCodecInfo;
    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->isEncoder()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 204
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 211
    :cond_1
    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getSupportedTypes()[Ljava/lang/String;

    move-result-object v4

    .line 212
    .local v4, "types":[Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_1
    array-length v5, v4

    if-ge v2, v5, :cond_0

    .line 213
    aget-object v5, v4, v2

    invoke-virtual {v5, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 214
    const-string v5, "MediaCodecCapabilities(j)"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "IsCodecSupported ("

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ") : info = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " : yes, it\'s supported"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 215
    const/4 v5, 0x1

    .line 220
    .end local v1    # "info":Landroid/media/MediaCodecInfo;
    .end local v2    # "j":I
    .end local v4    # "types":[Ljava/lang/String;
    :goto_2
    return v5

    .line 212
    .restart local v1    # "info":Landroid/media/MediaCodecInfo;
    .restart local v2    # "j":I
    .restart local v4    # "types":[Ljava/lang/String;
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 219
    .end local v1    # "info":Landroid/media/MediaCodecInfo;
    .end local v2    # "j":I
    .end local v4    # "types":[Ljava/lang/String;
    :cond_3
    const-string v5, "MediaCodecCapabilities(j)"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "IsCodecSupported ("

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ") : no, it\'s not supported"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 220
    const/4 v5, 0x0

    goto :goto_2
.end method

.method public static IsProfileLevelSupported(Ljava/lang/String;II)Z
    .locals 10
    .param p0, "mime"    # Ljava/lang/String;
    .param p1, "profile"    # I
    .param p2, "level"    # I

    .prologue
    .line 86
    const/4 v4, 0x0

    .line 87
    .local v4, "isSupported":Z
    sget-object v7, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 89
    invoke-static {p0}, Lcom/adobe/ave/MediaCodecCapabilities;->getCodecInfos(Ljava/lang/String;)V

    .line 91
    :cond_0
    sget-object v7, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 93
    const-string v7, "MediaCodecCapabilities(j)"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "no codeInfo for mime "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move v5, v4

    .line 132
    .end local v4    # "isSupported":Z
    .local v5, "isSupported":I
    :goto_0
    return v5

    .line 97
    .end local v5    # "isSupported":I
    .restart local v4    # "isSupported":Z
    :cond_1
    sget-object v7, Lcom/adobe/ave/MediaCodecCapabilities;->capabilitiesMap:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->isEmpty()Z

    move-result v7

    if-eqz v7, :cond_4

    .line 99
    const/4 v6, 0x0

    .local v6, "l":I
    :goto_1
    sget-object v7, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-ge v6, v7, :cond_6

    .line 101
    sget-object v7, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/media/MediaCodecInfo;

    .line 102
    .local v1, "codecInfo":Landroid/media/MediaCodecInfo;
    const/4 v0, 0x0

    .line 106
    .local v0, "caps":Landroid/media/MediaCodecInfo$CodecCapabilities;
    :try_start_0
    new-instance v7, Ljava/lang/String;

    const-string v8, "video/avc"

    invoke-direct {v7, v8}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v7}, Landroid/media/MediaCodecInfo;->getCapabilitiesForType(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 111
    :goto_2
    if-nez v0, :cond_3

    .line 99
    :cond_2
    :goto_3
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 107
    :catch_0
    move-exception v3

    .line 109
    .local v3, "e":Ljava/lang/Exception;
    const-string v7, "MediaCodecCapabilities(j)"

    const-string v8, "caught exception"

    invoke-static {v7, v8}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2

    .line 114
    .end local v3    # "e":Ljava/lang/Exception;
    :cond_3
    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-static {v0, p1, p2, v7}, Lcom/adobe/ave/MediaCodecCapabilities;->isProfileLevelSupportedByCapacities(Landroid/media/MediaCodecInfo$CodecCapabilities;IILjava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 115
    const/4 v4, 0x1

    goto :goto_3

    .line 118
    .end local v0    # "caps":Landroid/media/MediaCodecInfo$CodecCapabilities;
    .end local v1    # "codecInfo":Landroid/media/MediaCodecInfo;
    .end local v6    # "l":I
    :cond_4
    sget-object v7, Lcom/adobe/ave/MediaCodecCapabilities;->capabilitiesMap:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_5
    :goto_4
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_6

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 120
    .local v2, "codecName":Ljava/lang/String;
    sget-object v8, Lcom/adobe/ave/MediaCodecCapabilities;->capabilitiesMap:Ljava/util/Map;

    invoke-interface {v8, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/MediaCodecInfo$CodecCapabilities;

    .line 121
    .restart local v0    # "caps":Landroid/media/MediaCodecInfo$CodecCapabilities;
    if-eqz v0, :cond_5

    .line 124
    invoke-static {v0, p1, p2, v2}, Lcom/adobe/ave/MediaCodecCapabilities;->isProfileLevelSupportedByCapacities(Landroid/media/MediaCodecInfo$CodecCapabilities;IILjava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 125
    const/4 v4, 0x1

    goto :goto_4

    .line 129
    .end local v0    # "caps":Landroid/media/MediaCodecInfo$CodecCapabilities;
    .end local v2    # "codecName":Ljava/lang/String;
    :cond_6
    if-nez v4, :cond_7

    .line 130
    const-string v7, "MediaCodecCapabilities(j)"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "profile "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " and level "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "not supported"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_7
    move v5, v4

    .line 132
    .restart local v5    # "isSupported":I
    goto/16 :goto_0
.end method

.method public static PreloadCodecInfoList(Ljava/lang/String;)V
    .locals 7
    .param p0, "mime"    # Ljava/lang/String;

    .prologue
    .line 50
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0x16

    if-gt v4, v5, :cond_1

    .line 82
    :cond_0
    :goto_0
    return-void

    .line 56
    :cond_1
    sget-object v4, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 58
    invoke-static {p0}, Lcom/adobe/ave/MediaCodecCapabilities;->getCodecInfos(Ljava/lang/String;)V

    .line 61
    :cond_2
    sget-object v4, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 63
    const-string v4, "MediaCodecCapabilities(j)"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "no codeInfo for mime "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 67
    :cond_3
    const/4 v3, 0x0

    .local v3, "l":I
    :goto_1
    sget-object v4, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v3, v4, :cond_0

    .line 69
    sget-object v4, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/media/MediaCodecInfo;

    .line 70
    .local v1, "codecInfo":Landroid/media/MediaCodecInfo;
    const/4 v0, 0x0

    .line 74
    .local v0, "caps":Landroid/media/MediaCodecInfo$CodecCapabilities;
    :try_start_0
    invoke-virtual {v1, p0}, Landroid/media/MediaCodecInfo;->getCapabilitiesForType(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;

    move-result-object v0

    .line 75
    sget-object v4, Lcom/adobe/ave/MediaCodecCapabilities;->capabilitiesMap:Ljava/util/Map;

    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 67
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 76
    :catch_0
    move-exception v2

    .line 78
    .local v2, "e":Ljava/lang/Exception;
    const-string v4, "MediaCodecCapabilities(j)"

    const-string v5, "caught exception"

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2
.end method

.method public static PrintCodecList()V
    .locals 8

    .prologue
    .line 183
    invoke-static {}, Landroid/media/MediaCodecList;->getCodecCount()I

    move-result v3

    .line 184
    .local v3, "numCodecs":I
    const-string v5, "MediaCodecCapabilities(j)"

    const-string v6, "PrintCodecList ---------"

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 185
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_2

    .line 186
    invoke-static {v0}, Landroid/media/MediaCodecList;->getCodecInfoAt(I)Landroid/media/MediaCodecInfo;

    move-result-object v1

    .line 188
    .local v1, "info":Landroid/media/MediaCodecInfo;
    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->isEncoder()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 185
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 192
    :cond_1
    const-string v5, "MediaCodecCapabilities(j)"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "    Name = ["

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 193
    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getSupportedTypes()[Ljava/lang/String;

    move-result-object v4

    .line 194
    .local v4, "types":[Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_1
    array-length v5, v4

    if-ge v2, v5, :cond_0

    .line 195
    const-string v5, "MediaCodecCapabilities(j)"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "        SupportedType["

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "] = ["

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    aget-object v7, v4, v2

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 194
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 198
    .end local v1    # "info":Landroid/media/MediaCodecInfo;
    .end local v2    # "j":I
    .end local v4    # "types":[Ljava/lang/String;
    :cond_2
    const-string v5, "MediaCodecCapabilities(j)"

    const-string v6, "-------------------------------"

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 199
    return-void
.end method

.method private static getCodecInfos(Ljava/lang/String;)V
    .locals 8
    .param p0, "mime"    # Ljava/lang/String;

    .prologue
    .line 228
    invoke-static {}, Landroid/media/MediaCodecList;->getCodecCount()I

    move-result v3

    .line 229
    .local v3, "numCodecs":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_3

    .line 231
    invoke-static {v0}, Landroid/media/MediaCodecList;->getCodecInfoAt(I)Landroid/media/MediaCodecInfo;

    move-result-object v1

    .line 233
    .local v1, "info":Landroid/media/MediaCodecInfo;
    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->isEncoder()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 229
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 237
    :cond_1
    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getSupportedTypes()[Ljava/lang/String;

    move-result-object v4

    .line 238
    .local v4, "types":[Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_1
    array-length v5, v4

    if-ge v2, v5, :cond_0

    .line 239
    aget-object v5, v4, v2

    invoke-virtual {v5, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 241
    sget-object v5, Lcom/adobe/ave/MediaCodecCapabilities;->codecInfoList:Ljava/util/ArrayList;

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 242
    const-string v5, "MediaCodecCapabilities(j)"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "info = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 238
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 246
    .end local v1    # "info":Landroid/media/MediaCodecInfo;
    .end local v2    # "j":I
    .end local v4    # "types":[Ljava/lang/String;
    :cond_3
    return-void
.end method

.method private static isProfileLevelSupportedByCapacities(Landroid/media/MediaCodecInfo$CodecCapabilities;IILjava/lang/String;)Z
    .locals 6
    .param p0, "caps"    # Landroid/media/MediaCodecInfo$CodecCapabilities;
    .param p1, "profile"    # I
    .param p2, "level"    # I
    .param p3, "codecName"    # Ljava/lang/String;

    .prologue
    .line 253
    const/4 v0, 0x0

    .line 254
    .local v0, "isSupported":Z
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 255
    .local v2, "out":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "k":I
    :goto_0
    iget-object v3, p0, Landroid/media/MediaCodecInfo$CodecCapabilities;->profileLevels:[Landroid/media/MediaCodecInfo$CodecProfileLevel;

    array-length v3, v3

    if-ge v1, v3, :cond_2

    .line 257
    if-lez v1, :cond_0

    .line 258
    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 261
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Landroid/media/MediaCodecInfo$CodecCapabilities;->profileLevels:[Landroid/media/MediaCodecInfo$CodecProfileLevel;

    aget-object v4, v4, v1

    iget v4, v4, Landroid/media/MediaCodecInfo$CodecProfileLevel;->profile:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " / "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/media/MediaCodecInfo$CodecCapabilities;->profileLevels:[Landroid/media/MediaCodecInfo$CodecProfileLevel;

    aget-object v4, v4, v1

    iget v4, v4, Landroid/media/MediaCodecInfo$CodecProfileLevel;->level:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 266
    iget-object v3, p0, Landroid/media/MediaCodecInfo$CodecCapabilities;->profileLevels:[Landroid/media/MediaCodecInfo$CodecProfileLevel;

    aget-object v3, v3, v1

    iget v3, v3, Landroid/media/MediaCodecInfo$CodecProfileLevel;->profile:I

    if-lt v3, p1, :cond_1

    iget-object v3, p0, Landroid/media/MediaCodecInfo$CodecCapabilities;->profileLevels:[Landroid/media/MediaCodecInfo$CodecProfileLevel;

    aget-object v3, v3, v1

    iget v3, v3, Landroid/media/MediaCodecInfo$CodecProfileLevel;->level:I

    if-lt v3, p2, :cond_1

    .line 268
    const-string v3, "MediaCodecCapabilities(j)"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "IsProfileLevelSupported suppported: caps.profileLevels[k].profile: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Landroid/media/MediaCodecInfo$CodecCapabilities;->profileLevels:[Landroid/media/MediaCodecInfo$CodecProfileLevel;

    aget-object v5, v5, v1

    iget v5, v5, Landroid/media/MediaCodecInfo$CodecProfileLevel;->profile:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " >= profile: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " and caps.profileLevels[k].level: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Landroid/media/MediaCodecInfo$CodecCapabilities;->profileLevels:[Landroid/media/MediaCodecInfo$CodecProfileLevel;

    aget-object v5, v5, v1

    iget v5, v5, Landroid/media/MediaCodecInfo$CodecProfileLevel;->level:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " >= level: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 269
    const/4 v0, 0x1

    .line 255
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_0

    .line 272
    :cond_2
    const-string v3, "MediaCodecCapabilities(j)"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "codecName "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "    profiles/levels: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 273
    return v0
.end method
