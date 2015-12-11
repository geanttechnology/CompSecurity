.class public Lcom/uplynk/media/MediaPlayer$UplynkMetadata;
.super Ljava/lang/Object;
.source "MediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "UplynkMetadata"
.end annotation


# instance fields
.field protected _assetID:Ljava/lang/String;

.field protected _assetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

.field protected _ray:Ljava/lang/String;

.field protected _sliceIndex:Ljava/lang/String;

.field final synthetic this$0:Lcom/uplynk/media/MediaPlayer;


# direct methods
.method protected constructor <init>(Lcom/uplynk/media/MediaPlayer;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 1261
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->this$0:Lcom/uplynk/media/MediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1256
    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_assetID:Ljava/lang/String;

    .line 1257
    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_ray:Ljava/lang/String;

    .line 1258
    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_sliceIndex:Ljava/lang/String;

    .line 1259
    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_assetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    .line 1261
    return-void
.end method

.method protected constructor <init>(Lcom/uplynk/media/MediaPlayer;[Ljava/lang/String;)V
    .locals 2
    .param p2, "properties"    # [Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 1263
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->this$0:Lcom/uplynk/media/MediaPlayer;

    .line 1262
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1256
    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_assetID:Ljava/lang/String;

    .line 1257
    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_ray:Ljava/lang/String;

    .line 1258
    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_sliceIndex:Ljava/lang/String;

    .line 1259
    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_assetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    .line 1264
    array-length v0, p2

    const/4 v1, 0x3

    if-ge v0, v1, :cond_0

    .line 1268
    :goto_0
    return-void

    .line 1265
    :cond_0
    const/4 v0, 0x0

    aget-object v0, p2, v0

    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_assetID:Ljava/lang/String;

    .line 1266
    const/4 v0, 0x1

    aget-object v0, p2, v0

    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_ray:Ljava/lang/String;

    .line 1267
    const/4 v0, 0x2

    aget-object v0, p2, v0

    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_sliceIndex:Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method public getAssetID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1270
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_assetID:Ljava/lang/String;

    return-object v0
.end method

.method public getAssetInfo()Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    .locals 1

    .prologue
    .line 1273
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_assetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    return-object v0
.end method

.method public getRay()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1271
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_ray:Ljava/lang/String;

    return-object v0
.end method

.method public getSliceIndex()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1272
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_sliceIndex:Ljava/lang/String;

    return-object v0
.end method

.method public getSliceNumber()I
    .locals 3

    .prologue
    .line 1276
    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_sliceIndex:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 1278
    const/4 v0, 0x0

    .line 1280
    .local v0, "idx":I
    :try_start_0
    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_sliceIndex:Ljava/lang/String;

    const/16 v2, 0x10

    invoke-static {v1, v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 1287
    .end local v0    # "idx":I
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 1282
    .restart local v0    # "idx":I
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1290
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_assetID:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_ray:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_sliceIndex:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->getSliceNumber()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
