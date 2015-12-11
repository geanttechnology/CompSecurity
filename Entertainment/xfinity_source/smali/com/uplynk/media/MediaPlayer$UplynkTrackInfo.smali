.class public Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;
.super Ljava/lang/Object;
.source "MediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "UplynkTrackInfo"
.end annotation


# instance fields
.field protected _autoSelect:Z

.field protected _group:Ljava/lang/String;

.field protected _isDefault:Z

.field protected _isEmbedded:Z

.field protected _isForced:Z

.field protected _lang:Ljava/lang/String;

.field protected _name:Ljava/lang/String;

.field protected _type:C

.field final synthetic this$0:Lcom/uplynk/media/MediaPlayer;


# direct methods
.method protected constructor <init>(Lcom/uplynk/media/MediaPlayer;)V
    .locals 0

    .prologue
    .line 1397
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->this$0:Lcom/uplynk/media/MediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Lcom/uplynk/media/MediaPlayer;CLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)V
    .locals 0
    .param p2, "type"    # C
    .param p3, "name"    # Ljava/lang/String;
    .param p4, "group"    # Ljava/lang/String;
    .param p5, "lang"    # Ljava/lang/String;
    .param p6, "isEmbedded"    # Z
    .param p7, "isDefault"    # Z
    .param p8, "isForced"    # Z

    .prologue
    .line 1399
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->this$0:Lcom/uplynk/media/MediaPlayer;

    .line 1398
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1400
    iput-char p2, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_type:C

    .line 1401
    iput-object p3, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_name:Ljava/lang/String;

    .line 1402
    iput-object p4, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_group:Ljava/lang/String;

    .line 1403
    iput-object p5, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_lang:Ljava/lang/String;

    .line 1404
    iput-boolean p6, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_isEmbedded:Z

    .line 1405
    iput-boolean p7, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_isDefault:Z

    .line 1406
    iput-boolean p8, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_isForced:Z

    .line 1407
    return-void
.end method


# virtual methods
.method public getGroup()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1412
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_group:Ljava/lang/String;

    return-object v0
.end method

.method public getLang()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1413
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_lang:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1411
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_name:Ljava/lang/String;

    return-object v0
.end method

.method public getType()C
    .locals 1

    .prologue
    .line 1410
    iget-char v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_type:C

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 1415
    const-string v0, "[%s] %s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_lang:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->_name:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
