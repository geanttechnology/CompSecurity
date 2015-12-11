.class public Lcom/amazon/device/ads/Controller$PlayerProperties;
.super Lcom/amazon/device/ads/Controller$ReflectedParcelable;
.source "Controller.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/Controller;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PlayerProperties"
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/device/ads/Controller$PlayerProperties;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public audioMuted:Z

.field public autoPlay:Z

.field public doLoop:Z

.field public inline:Z

.field public showControl:Z

.field public startStyle:Ljava/lang/String;

.field public stopStyle:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 134
    new-instance v0, Lcom/amazon/device/ads/Controller$PlayerProperties$1;

    invoke-direct {v0}, Lcom/amazon/device/ads/Controller$PlayerProperties$1;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/Controller$PlayerProperties;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 150
    invoke-direct {p0}, Lcom/amazon/device/ads/Controller$ReflectedParcelable;-><init>()V

    .line 151
    iput-boolean v1, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->autoPlay:Z

    .line 152
    iput-boolean v1, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->showControl:Z

    .line 153
    iput-boolean v0, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->doLoop:Z

    .line 154
    iput-boolean v0, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->audioMuted:Z

    .line 155
    const-string/jumbo v0, "normal"

    iput-object v0, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->startStyle:Ljava/lang/String;

    .line 156
    const-string/jumbo v0, "normal"

    iput-object v0, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->stopStyle:Ljava/lang/String;

    .line 157
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 0
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 161
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/Controller$ReflectedParcelable;-><init>(Landroid/os/Parcel;)V

    .line 162
    return-void
.end method


# virtual methods
.method public doLoop()Z
    .locals 1

    .prologue
    .line 193
    iget-boolean v0, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->doLoop:Z

    return v0
.end method

.method public doMute()Z
    .locals 1

    .prologue
    .line 198
    iget-boolean v0, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->audioMuted:Z

    return v0
.end method

.method public exitOnComplete()Z
    .locals 2

    .prologue
    .line 203
    iget-object v0, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->stopStyle:Ljava/lang/String;

    const-string/jumbo v1, "exit"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public isAutoPlay()Z
    .locals 1

    .prologue
    .line 183
    iget-boolean v0, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->autoPlay:Z

    return v0
.end method

.method public isFullScreen()Z
    .locals 2

    .prologue
    .line 208
    iget-object v0, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->startStyle:Ljava/lang/String;

    const-string/jumbo v1, "fullscreen"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public muteAudio()V
    .locals 1

    .prologue
    .line 178
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->audioMuted:Z

    .line 179
    return-void
.end method

.method public setProperties(ZZZZZLjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "audioMuted"    # Z
    .param p2, "autoPlay"    # Z
    .param p3, "controls"    # Z
    .param p4, "inline"    # Z
    .param p5, "loop"    # Z
    .param p6, "startStyle"    # Ljava/lang/String;
    .param p7, "stopStyle"    # Ljava/lang/String;

    .prologue
    .line 167
    iput-boolean p1, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->audioMuted:Z

    .line 168
    iput-boolean p2, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->autoPlay:Z

    .line 169
    iput-boolean p3, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->showControl:Z

    .line 170
    iput-boolean p4, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->inline:Z

    .line 171
    iput-boolean p5, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->doLoop:Z

    .line 172
    iput-object p6, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->startStyle:Ljava/lang/String;

    .line 173
    iput-object p7, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->stopStyle:Ljava/lang/String;

    .line 174
    return-void
.end method

.method public showControl()Z
    .locals 1

    .prologue
    .line 188
    iget-boolean v0, p0, Lcom/amazon/device/ads/Controller$PlayerProperties;->showControl:Z

    return v0
.end method
