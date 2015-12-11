.class public Lcom/uplynk/media/MediaPlayer$UplynkID3;
.super Ljava/lang/Object;
.source "MediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "UplynkID3"
.end annotation


# instance fields
.field protected _desc:Ljava/lang/String;

.field protected _key:Ljava/lang/String;

.field protected _value:Ljava/lang/String;

.field final synthetic this$0:Lcom/uplynk/media/MediaPlayer;


# direct methods
.method protected constructor <init>(Lcom/uplynk/media/MediaPlayer;)V
    .locals 0

    .prologue
    .line 1299
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer$UplynkID3;->this$0:Lcom/uplynk/media/MediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;
    .param p4, "desc"    # Ljava/lang/String;

    .prologue
    .line 1301
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer$UplynkID3;->this$0:Lcom/uplynk/media/MediaPlayer;

    .line 1300
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1302
    iput-object p2, p0, Lcom/uplynk/media/MediaPlayer$UplynkID3;->_key:Ljava/lang/String;

    .line 1303
    iput-object p3, p0, Lcom/uplynk/media/MediaPlayer$UplynkID3;->_value:Ljava/lang/String;

    .line 1304
    iput-object p4, p0, Lcom/uplynk/media/MediaPlayer$UplynkID3;->_desc:Ljava/lang/String;

    .line 1305
    return-void
.end method


# virtual methods
.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1309
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkID3;->_desc:Ljava/lang/String;

    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1307
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkID3;->_key:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1308
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkID3;->_value:Ljava/lang/String;

    return-object v0
.end method
